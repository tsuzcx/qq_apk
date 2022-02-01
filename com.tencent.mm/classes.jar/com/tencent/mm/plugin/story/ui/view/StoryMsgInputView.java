package com.tencent.mm.plugin.story.ui.view;

import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.ad;
import com.tencent.mm.compatible.util.i;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.story.a.a;
import com.tencent.mm.plugin.story.a.d;
import com.tencent.mm.plugin.story.a.e;
import com.tencent.mm.plugin.story.a.f;
import com.tencent.mm.plugin.story.a.g;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.sdk.platformtools.KeyBoardUtil;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.widget.InputPanelFrameLayout;
import com.tencent.mm.ui.widget.MMEditText;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/view/StoryMsgInputView;", "Lcom/tencent/mm/ui/widget/InputPanelFrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "canSend", "", "commentInputCallback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "content", "success", "", "getCommentInputCallback", "()Lkotlin/jvm/functions/Function2;", "setCommentInputCallback", "(Lkotlin/jvm/functions/Function2;)V", "emojiBtn", "Landroid/widget/ImageView;", "emojiRoot", "Landroid/widget/FrameLayout;", "hintTv", "Landroid/widget/TextView;", "inputContentGroup", "Landroid/view/View;", "inputLimit", "inputRootView", "inputType", "getInputType", "()I", "setInputType", "(I)V", "inputView", "Lcom/tencent/mm/ui/widget/MMEditText;", "isKeyboardShown", "keyboardHeight", "limitHighLightColor", "limitNormalColor", "loading", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "showImeRunnable", "Ljava/lang/Runnable;", "smileyPanel", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel;", "destroy", "getContent", "", "hideInputPanel", "hideSoftInput", "initSmileyPanel", "onBack", "onInputPanelChange", "isKeyboardShow", "refreshBottomPanelHeight", "setInputHint", "toUser", "isReply", "setKeyboardVisibility", "visible", "setVisibility", "visibility", "needRequest", "Companion", "plugin-story_release"})
public final class StoryMsgInputView
  extends InputPanelFrameLayout
{
  public static final a LXr;
  private final FrameLayout LVS;
  private final MMEditText LVT;
  private final ImageView LVU;
  private final TextView LVV;
  private final View LVX;
  private final View LVY;
  private boolean LVZ;
  private final int LWa;
  private final int LWb;
  private m<? super String, ? super Boolean, x> LWc;
  private final String TAG;
  private int inputType;
  private boolean jJo;
  private final ChatFooterPanel jPN;
  private final TextView nmi;
  private int pIk;
  private final Runnable vao;
  
  static
  {
    AppMethodBeat.i(120226);
    LXr = new a((byte)0);
    AppMethodBeat.o(120226);
  }
  
  public StoryMsgInputView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(120225);
    AppMethodBeat.o(120225);
  }
  
  public StoryMsgInputView(final Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(120224);
    this.TAG = "MicroMsg.StoryCommentInputView";
    this.inputType = -1;
    View.inflate(paramContext, a.e.LCf, (ViewGroup)this);
    setClickable(true);
    paramAttributeSet = findViewById(a.d.LAF);
    p.j(paramAttributeSet, "findViewById(R.id.story_comment_emoji_root)");
    this.LVS = ((FrameLayout)paramAttributeSet);
    paramAttributeSet = findViewById(a.d.LAH);
    p.j(paramAttributeSet, "findViewById(R.id.story_comment_input)");
    this.LVT = ((MMEditText)paramAttributeSet);
    this.LVT.setEnableSendBtn(true);
    paramAttributeSet = findViewById(a.d.LAE);
    p.j(paramAttributeSet, "findViewById(R.id.story_comment_emoji_btn)");
    this.LVU = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(a.d.LAL);
    p.j(paramAttributeSet, "findViewById(R.id.story_comment_input_limit)");
    this.LVV = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(a.d.LAK);
    p.j(paramAttributeSet, "findViewById(R.id.story_comment_input_hint)");
    this.nmi = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(a.d.LAN);
    p.j(paramAttributeSet, "findViewById(R.id.story_comment_input_root)");
    this.LVX = paramAttributeSet;
    paramAttributeSet = findViewById(a.d.LAJ);
    p.j(paramAttributeSet, "findViewById(R.id.story_…ent_input_footer_content)");
    this.LVY = paramAttributeSet;
    this.LWa = getResources().getColor(a.a.Lzi);
    this.LWb = getResources().getColor(a.a.Red);
    paramAttributeSet = ad.m(paramContext, true);
    p.j(paramAttributeSet, "SmileyPanelFactory.getSmileyPanel(context, true)");
    this.jPN = ((ChatFooterPanel)paramAttributeSet);
    this.pIk = KeyBoardUtil.getValidPanelHeight(getContext());
    paramAttributeSet = new FrameLayout.LayoutParams(-1, this.pIk);
    this.LVS.addView((View)this.jPN, (ViewGroup.LayoutParams)paramAttributeSet);
    this.jPN.setPortHeightPx(this.pIk);
    this.jPN.setEntranceScene(ChatFooterPanel.HGY);
    this.jPN.hjp();
    this.jPN.setVisibility(0);
    this.jPN.setShowSend(true);
    this.jPN.onResume();
    this.jPN.setOnTextOperationListener((ChatFooterPanel.a)new b(this));
    this.LVT.addTextChangedListener((TextWatcher)new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(120208);
        if (paramAnonymousEditable != null)
        {
          int j = ((CharSequence)paramAnonymousEditable).length();
          int k = 60 - j;
          StoryMsgInputView localStoryMsgInputView = this.LXs;
          int i;
          if (((CharSequence)paramAnonymousEditable).length() > 0)
          {
            i = 1;
            if ((i == 0) || (k < 0) || (StoryMsgInputView.a(this.LXs).getLineCount() > 10)) {
              break label147;
            }
          }
          label147:
          for (boolean bool = true;; bool = false)
          {
            StoryMsgInputView.a(localStoryMsgInputView, bool);
            if (j < 55) {
              break label176;
            }
            StoryMsgInputView.e(this.LXs).setVisibility(0);
            StoryMsgInputView.e(this.LXs).setText((CharSequence)String.valueOf(k));
            if (k < 0) {
              break label153;
            }
            StoryMsgInputView.e(this.LXs).setTextColor(StoryMsgInputView.f(this.LXs));
            AppMethodBeat.o(120208);
            return;
            i = 0;
            break;
          }
          label153:
          StoryMsgInputView.e(this.LXs).setTextColor(StoryMsgInputView.g(this.LXs));
          AppMethodBeat.o(120208);
          return;
          label176:
          StoryMsgInputView.e(this.LXs).setVisibility(8);
          AppMethodBeat.o(120208);
          return;
        }
        StoryMsgInputView.a(this.LXs, false);
        StoryMsgInputView.e(this.LXs).setVisibility(8);
        AppMethodBeat.o(120208);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.LVX.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120209);
        b localb = new b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/story/ui/view/StoryMsgInputView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (!StoryMsgInputView.h(this.LXs))
        {
          this.LXs.setInputType(2);
          StoryMsgInputView.b(this.LXs, true);
          StoryMsgInputView.i(this.LXs).setImageDrawable(au.o(paramContext, a.f.icons_filled_sticker, -1));
        }
        a.a(this, "com/tencent/mm/plugin/story/ui/view/StoryMsgInputView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(120209);
      }
    });
    this.LVU.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120210);
        b localb = new b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/story/ui/view/StoryMsgInputView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (this.LXs.getInputType() == 0)
        {
          this.LXs.setInputType(2);
          StoryMsgInputView.b(this.LXs, true);
          StoryMsgInputView.i(this.LXs).setImageDrawable(au.o(paramContext, a.f.icons_filled_sticker, -1));
          a.a(this, "com/tencent/mm/plugin/story/ui/view/StoryMsgInputView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(120210);
          return;
        }
        if (StoryMsgInputView.h(this.LXs))
        {
          this.LXs.setInputType(0);
          StoryMsgInputView.b(this.LXs, false);
        }
        for (;;)
        {
          StoryMsgInputView.i(this.LXs).setImageDrawable(au.o(paramContext, a.f.icons_filled_keyboard, -1));
          break;
          this.LXs.setInputType(0);
          StoryMsgInputView.d(this.LXs).setVisibility(0);
        }
      }
    });
    this.LVT.setOnEditorActionListener((TextView.OnEditorActionListener)new TextView.OnEditorActionListener()
    {
      public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(120211);
        if (4 != paramAnonymousInt)
        {
          p.j(paramAnonymousKeyEvent, "keyEvent");
          if (paramAnonymousKeyEvent.getAction() != 66) {}
        }
        else if (StoryMsgInputView.b(this.LXs))
        {
          paramAnonymousTextView = com.tencent.mm.plugin.story.h.h.LOJ;
          com.tencent.mm.plugin.story.h.h.aio(9);
          paramAnonymousTextView = StoryMsgInputView.a(this.LXs).getText();
          if (paramAnonymousTextView != null)
          {
            StoryMsgInputView.c(this.LXs);
            StoryMsgInputView.a(this.LXs).setText(null);
            paramAnonymousKeyEvent = this.LXs.getCommentInputCallback();
            if (paramAnonymousKeyEvent != null) {
              paramAnonymousKeyEvent.invoke(paramAnonymousTextView.toString(), Boolean.TRUE);
            }
          }
        }
        AppMethodBeat.o(120211);
        return true;
      }
    });
    this.LVU.setImageDrawable(au.o(paramContext, a.f.icons_filled_sticker, -1));
    this.jJo = false;
    setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    this.vao = ((Runnable)new c(this));
    AppMethodBeat.o(120224);
  }
  
  private final void ggD()
  {
    AppMethodBeat.i(120222);
    InputMethodManager localInputMethodManager = (InputMethodManager)getContext().getSystemService("input_method");
    if (localInputMethodManager != null)
    {
      localInputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
      AppMethodBeat.o(120222);
      return;
    }
    AppMethodBeat.o(120222);
  }
  
  private final void setKeyboardVisibility(boolean paramBoolean)
  {
    AppMethodBeat.i(120221);
    if (paramBoolean)
    {
      post(this.vao);
      AppMethodBeat.o(120221);
      return;
    }
    removeCallbacks(this.vao);
    InputMethodManager localInputMethodManager = (InputMethodManager)getContext().getSystemService("input_method");
    if (localInputMethodManager != null)
    {
      localInputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
      AppMethodBeat.o(120221);
      return;
    }
    AppMethodBeat.o(120221);
  }
  
  public final void a(CharSequence paramCharSequence, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(120216);
    p.k(paramString, "toUser");
    this.LVT.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.b(getContext(), paramCharSequence, this.LVT.getTextSize()));
    if (paramCharSequence != null) {
      this.LVT.setSelection(paramCharSequence.length());
    }
    if (paramBoolean)
    {
      p.j(getResources().getString(a.g.LEp), "resources.getString(R.st…story_reply_visible_hint)");
      paramCharSequence = com.tencent.mm.kernel.h.ae(n.class);
      p.j(paramCharSequence, "MMKernel.service(IMessengerStorage::class.java)");
      paramCharSequence = ((n)paramCharSequence).bbL().RG(paramString);
      paramString = new StringBuilder().append(getResources().getString(a.g.LEo)).append(' ');
      Context localContext = this.LVT.getContext();
      if (paramCharSequence != null)
      {
        paramCharSequence = paramCharSequence.ays();
        if (paramCharSequence != null)
        {
          paramCharSequence = (CharSequence)paramCharSequence;
          paramCharSequence = com.tencent.mm.pluginsdk.ui.span.l.b(localContext, paramCharSequence, this.LVT.getTextSize());
        }
      }
    }
    for (;;)
    {
      this.LVT.setHint((CharSequence)paramCharSequence);
      AppMethodBeat.o(120216);
      return;
      paramCharSequence = (CharSequence)"";
      break;
      p.j(getResources().getString(a.g.LDJ), "resources.getString(R.st…ory_comment_visible_hint)");
      paramCharSequence = getResources().getString(a.g.LDJ);
      p.j(paramCharSequence, "resources.getString(R.st…ory_comment_visible_hint)");
    }
  }
  
  public final m<String, Boolean, x> getCommentInputCallback()
  {
    return this.LWc;
  }
  
  public final CharSequence getContent()
  {
    AppMethodBeat.i(120218);
    Object localObject = this.LVT.getText();
    if (localObject != null) {}
    for (localObject = localObject.toString();; localObject = null)
    {
      localObject = (CharSequence)localObject;
      AppMethodBeat.o(120218);
      return localObject;
    }
  }
  
  public final int getInputType()
  {
    return this.inputType;
  }
  
  public final void ggC()
  {
    AppMethodBeat.i(120219);
    if (this.inputType == 0) {
      this.LVS.setVisibility(8);
    }
    for (;;)
    {
      this.inputType = -1;
      AppMethodBeat.o(120219);
      return;
      if (this.inputType == 2) {
        ggD();
      }
    }
  }
  
  public final void h(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(120223);
    super.h(paramBoolean, paramInt);
    this.LVZ = paramBoolean;
    if (paramBoolean)
    {
      this.inputType = 2;
      this.LVS.setVisibility(4);
    }
    for (;;)
    {
      if ((this.pIk != paramInt) && (paramInt != 0))
      {
        this.pIk = paramInt;
        i.E(getContext(), paramInt);
        paramInt = KeyBoardUtil.getValidPanelHeight(getContext());
        this.jPN.setPortHeightPx(paramInt);
        ViewGroup.LayoutParams localLayoutParams = this.jPN.getLayoutParams();
        if (localLayoutParams != null) {
          localLayoutParams.height = paramInt;
        }
      }
      AppMethodBeat.o(120223);
      return;
      if (this.inputType == 0)
      {
        this.LVS.setVisibility(0);
      }
      else
      {
        this.LVS.setVisibility(8);
        this.inputType = -1;
      }
    }
  }
  
  public final void setCommentInputCallback(m<? super String, ? super Boolean, x> paramm)
  {
    this.LWc = paramm;
  }
  
  public final void setInputType(int paramInt)
  {
    this.inputType = paramInt;
  }
  
  public final void zD(boolean paramBoolean)
  {
    AppMethodBeat.i(120220);
    if (paramBoolean)
    {
      this.LVT.requestFocus();
      this.inputType = 2;
      this.LVU.setImageDrawable(au.o(getContext(), a.f.icons_filled_sticker, -1));
      this.LVS.setVisibility(4);
      setKeyboardVisibility(true);
    }
    setVisibility(0);
    if (!paramBoolean) {
      clearFocus();
    }
    AppMethodBeat.o(120220);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/view/StoryMsgInputView$Companion;", "", "()V", "InputEmoji", "", "InputEmojiLater", "InputKeyboard", "InputKeyboardLater", "InputLimit", "InputNone", "MinShowLimit", "plugin-story_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/story/ui/view/StoryMsgInputView$initSmileyPanel$1", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "append", "", "text", "", "del", "onToSendTextEnable", "enable", "", "performSend", "plugin-story_release"})
  public static final class b
    implements ChatFooterPanel.a
  {
    public final void aDN()
    {
      AppMethodBeat.i(120214);
      if (StoryMsgInputView.b(this.LXs))
      {
        Object localObject = com.tencent.mm.plugin.story.h.h.LOJ;
        com.tencent.mm.plugin.story.h.h.aio(9);
        localObject = StoryMsgInputView.a(this.LXs).getText();
        if (localObject != null)
        {
          StoryMsgInputView.c(this.LXs);
          StoryMsgInputView.a(this.LXs).setText(null);
          StoryMsgInputView.d(this.LXs).setVisibility(8);
          m localm = this.LXs.getCommentInputCallback();
          if (localm != null)
          {
            localm.invoke(localObject.toString(), Boolean.TRUE);
            AppMethodBeat.o(120214);
            return;
          }
          AppMethodBeat.o(120214);
          return;
        }
      }
      AppMethodBeat.o(120214);
    }
    
    public final void aDO()
    {
      AppMethodBeat.i(120213);
      InputConnection localInputConnection = StoryMsgInputView.a(this.LXs).getInputConnection();
      if (localInputConnection != null) {
        localInputConnection.sendKeyEvent(new KeyEvent(0, 67));
      }
      localInputConnection = StoryMsgInputView.a(this.LXs).getInputConnection();
      if (localInputConnection != null)
      {
        localInputConnection.sendKeyEvent(new KeyEvent(1, 67));
        AppMethodBeat.o(120213);
        return;
      }
      AppMethodBeat.o(120213);
    }
    
    public final void append(String paramString)
    {
      AppMethodBeat.i(120212);
      StoryMsgInputView.a(this.LXs).bBa(paramString);
      AppMethodBeat.o(120212);
    }
    
    public final void eE(boolean paramBoolean) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(StoryMsgInputView paramStoryMsgInputView) {}
    
    public final void run()
    {
      AppMethodBeat.i(120215);
      InputMethodManager localInputMethodManager = (InputMethodManager)this.LXs.getContext().getSystemService("input_method");
      if (localInputMethodManager != null)
      {
        localInputMethodManager.showSoftInput((View)StoryMsgInputView.a(this.LXs), 0);
        AppMethodBeat.o(120215);
        return;
      }
      AppMethodBeat.o(120215);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.StoryMsgInputView
 * JD-Core Version:    0.7.0.1
 */