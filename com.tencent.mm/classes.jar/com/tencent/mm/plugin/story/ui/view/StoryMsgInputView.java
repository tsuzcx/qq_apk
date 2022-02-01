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
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.sdk.platformtools.KeyBoardUtil;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.widget.InputPanelFrameLayout;
import com.tencent.mm.ui.widget.MMEditText;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/ui/view/StoryMsgInputView;", "Lcom/tencent/mm/ui/widget/InputPanelFrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "canSend", "", "commentInputCallback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "content", "success", "", "getCommentInputCallback", "()Lkotlin/jvm/functions/Function2;", "setCommentInputCallback", "(Lkotlin/jvm/functions/Function2;)V", "emojiBtn", "Landroid/widget/ImageView;", "emojiRoot", "Landroid/widget/FrameLayout;", "hintTv", "Landroid/widget/TextView;", "inputContentGroup", "Landroid/view/View;", "inputLimit", "inputRootView", "inputType", "getInputType", "()I", "setInputType", "(I)V", "inputView", "Lcom/tencent/mm/ui/widget/MMEditText;", "isKeyboardShown", "keyboardHeight", "limitHighLightColor", "limitNormalColor", "loading", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "showImeRunnable", "Ljava/lang/Runnable;", "smileyPanel", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel;", "destroy", "getContent", "", "hideInputPanel", "hideSoftInput", "initSmileyPanel", "onBack", "onInputPanelChange", "isKeyboardShow", "refreshBottomPanelHeight", "setInputHint", "toUser", "isReply", "setKeyboardVisibility", "visible", "setVisibility", "visibility", "needRequest", "Companion", "plugin-story_release"})
public final class StoryMsgInputView
  extends InputPanelFrameLayout
{
  public static final StoryMsgInputView.a FDo;
  private final FrameLayout FBO;
  private final MMEditText FBP;
  private final ImageView FBQ;
  private final TextView FBR;
  private final View FBT;
  private final View FBU;
  private boolean FBV;
  private final int FBW;
  private final int FBX;
  private m<? super String, ? super Boolean, x> FBY;
  private final String TAG;
  private boolean gYo;
  private int inputType;
  private final TextView kuu;
  private int oXi;
  private final Runnable ruJ;
  private final ChatFooterPanel rum;
  
  static
  {
    AppMethodBeat.i(120226);
    FDo = new StoryMsgInputView.a((byte)0);
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
    View.inflate(paramContext, 2131496615, (ViewGroup)this);
    setClickable(true);
    paramAttributeSet = findViewById(2131308502);
    p.g(paramAttributeSet, "findViewById(R.id.story_comment_emoji_root)");
    this.FBO = ((FrameLayout)paramAttributeSet);
    paramAttributeSet = findViewById(2131308505);
    p.g(paramAttributeSet, "findViewById(R.id.story_comment_input)");
    this.FBP = ((MMEditText)paramAttributeSet);
    this.FBP.setEnableSendBtn(true);
    paramAttributeSet = findViewById(2131308501);
    p.g(paramAttributeSet, "findViewById(R.id.story_comment_emoji_btn)");
    this.FBQ = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131308510);
    p.g(paramAttributeSet, "findViewById(R.id.story_comment_input_limit)");
    this.FBR = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(2131308509);
    p.g(paramAttributeSet, "findViewById(R.id.story_comment_input_hint)");
    this.kuu = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(2131308512);
    p.g(paramAttributeSet, "findViewById(R.id.story_comment_input_root)");
    this.FBT = paramAttributeSet;
    paramAttributeSet = findViewById(2131308508);
    p.g(paramAttributeSet, "findViewById(R.id.story_…ent_input_footer_content)");
    this.FBU = paramAttributeSet;
    this.FBW = getResources().getColor(2131101226);
    this.FBX = getResources().getColor(2131099818);
    paramAttributeSet = ad.l(paramContext, true);
    p.g(paramAttributeSet, "SmileyPanelFactory.getSmileyPanel(context, true)");
    this.rum = ((ChatFooterPanel)paramAttributeSet);
    this.oXi = KeyBoardUtil.getValidPanelHeight(getContext());
    paramAttributeSet = new FrameLayout.LayoutParams(-1, this.oXi);
    this.FBO.addView((View)this.rum, (ViewGroup.LayoutParams)paramAttributeSet);
    this.rum.setPortHeightPx(this.oXi);
    this.rum.setEntranceScene(ChatFooterPanel.BKN);
    this.rum.goD();
    this.rum.setVisibility(0);
    this.rum.setShowSend(true);
    this.rum.onResume();
    this.rum.setOnTextOperationListener((ChatFooterPanel.a)new b(this));
    this.FBP.addTextChangedListener((TextWatcher)new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(120208);
        if (paramAnonymousEditable != null)
        {
          int j = ((CharSequence)paramAnonymousEditable).length();
          int k = 60 - j;
          StoryMsgInputView localStoryMsgInputView = this.FDp;
          int i;
          if (((CharSequence)paramAnonymousEditable).length() > 0)
          {
            i = 1;
            if ((i == 0) || (k < 0) || (StoryMsgInputView.a(this.FDp).getLineCount() > 10)) {
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
            StoryMsgInputView.e(this.FDp).setVisibility(0);
            StoryMsgInputView.e(this.FDp).setText((CharSequence)String.valueOf(k));
            if (k < 0) {
              break label153;
            }
            StoryMsgInputView.e(this.FDp).setTextColor(StoryMsgInputView.f(this.FDp));
            AppMethodBeat.o(120208);
            return;
            i = 0;
            break;
          }
          label153:
          StoryMsgInputView.e(this.FDp).setTextColor(StoryMsgInputView.g(this.FDp));
          AppMethodBeat.o(120208);
          return;
          label176:
          StoryMsgInputView.e(this.FDp).setVisibility(8);
          AppMethodBeat.o(120208);
          return;
        }
        StoryMsgInputView.a(this.FDp, false);
        StoryMsgInputView.e(this.FDp).setVisibility(8);
        AppMethodBeat.o(120208);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.FBT.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120209);
        b localb = new b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/story/ui/view/StoryMsgInputView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (!StoryMsgInputView.h(this.FDp))
        {
          this.FDp.setInputType(2);
          StoryMsgInputView.b(this.FDp, true);
          StoryMsgInputView.i(this.FDp).setImageDrawable(ar.m(paramContext, 2131690683, -1));
        }
        a.a(this, "com/tencent/mm/plugin/story/ui/view/StoryMsgInputView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(120209);
      }
    });
    this.FBQ.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120210);
        b localb = new b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/story/ui/view/StoryMsgInputView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (this.FDp.getInputType() == 0)
        {
          this.FDp.setInputType(2);
          StoryMsgInputView.b(this.FDp, true);
          StoryMsgInputView.i(this.FDp).setImageDrawable(ar.m(paramContext, 2131690683, -1));
          a.a(this, "com/tencent/mm/plugin/story/ui/view/StoryMsgInputView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(120210);
          return;
        }
        if (StoryMsgInputView.h(this.FDp))
        {
          this.FDp.setInputType(0);
          StoryMsgInputView.b(this.FDp, false);
        }
        for (;;)
        {
          StoryMsgInputView.i(this.FDp).setImageDrawable(ar.m(paramContext, 2131690575, -1));
          break;
          this.FDp.setInputType(0);
          StoryMsgInputView.d(this.FDp).setVisibility(0);
        }
      }
    });
    this.FBP.setOnEditorActionListener((TextView.OnEditorActionListener)new TextView.OnEditorActionListener()
    {
      public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(120211);
        if (4 != paramAnonymousInt)
        {
          p.g(paramAnonymousKeyEvent, "keyEvent");
          if (paramAnonymousKeyEvent.getAction() != 66) {}
        }
        else if (StoryMsgInputView.b(this.FDp))
        {
          paramAnonymousTextView = h.FuH;
          h.aaT(9);
          paramAnonymousTextView = StoryMsgInputView.a(this.FDp).getText();
          if (paramAnonymousTextView != null)
          {
            StoryMsgInputView.c(this.FDp);
            StoryMsgInputView.a(this.FDp).setText(null);
            paramAnonymousKeyEvent = this.FDp.getCommentInputCallback();
            if (paramAnonymousKeyEvent != null) {
              paramAnonymousKeyEvent.invoke(paramAnonymousTextView.toString(), Boolean.TRUE);
            }
          }
        }
        AppMethodBeat.o(120211);
        return true;
      }
    });
    this.FBQ.setImageDrawable(ar.m(paramContext, 2131690683, -1));
    this.gYo = false;
    setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    this.ruJ = ((Runnable)new c(this));
    AppMethodBeat.o(120224);
  }
  
  private final void fsf()
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
      post(this.ruJ);
      AppMethodBeat.o(120221);
      return;
    }
    removeCallbacks(this.ruJ);
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
    p.h(paramString, "toUser");
    this.FBP.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.b(getContext(), paramCharSequence, this.FBP.getTextSize()));
    if (paramCharSequence != null) {
      this.FBP.setSelection(paramCharSequence.length());
    }
    if (paramBoolean)
    {
      p.g(getResources().getString(2131766561), "resources.getString(R.st…story_reply_visible_hint)");
      paramCharSequence = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
      p.g(paramCharSequence, "MMKernel.service(IMessengerStorage::class.java)");
      paramCharSequence = ((com.tencent.mm.plugin.messenger.foundation.a.l)paramCharSequence).aSN().Kn(paramString);
      paramString = new StringBuilder().append(getResources().getString(2131766560)).append(' ');
      Context localContext = this.FBP.getContext();
      if (paramCharSequence != null)
      {
        paramCharSequence = paramCharSequence.arJ();
        if (paramCharSequence != null)
        {
          paramCharSequence = (CharSequence)paramCharSequence;
          paramCharSequence = com.tencent.mm.pluginsdk.ui.span.l.b(localContext, paramCharSequence, this.FBP.getTextSize());
        }
      }
    }
    for (;;)
    {
      this.FBP.setHint((CharSequence)paramCharSequence);
      AppMethodBeat.o(120216);
      return;
      paramCharSequence = (CharSequence)"";
      break;
      p.g(getResources().getString(2131766483), "resources.getString(R.st…ory_comment_visible_hint)");
      paramCharSequence = getResources().getString(2131766483);
      p.g(paramCharSequence, "resources.getString(R.st…ory_comment_visible_hint)");
    }
  }
  
  public final void f(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(120223);
    super.f(paramBoolean, paramInt);
    this.FBV = paramBoolean;
    if (paramBoolean)
    {
      this.inputType = 2;
      this.FBO.setVisibility(4);
    }
    for (;;)
    {
      if ((this.oXi != paramInt) && (paramInt != 0))
      {
        this.oXi = paramInt;
        i.C(getContext(), paramInt);
        paramInt = KeyBoardUtil.getValidPanelHeight(getContext());
        this.rum.setPortHeightPx(paramInt);
        ViewGroup.LayoutParams localLayoutParams = this.rum.getLayoutParams();
        if (localLayoutParams != null) {
          localLayoutParams.height = paramInt;
        }
      }
      AppMethodBeat.o(120223);
      return;
      if (this.inputType == 0)
      {
        this.FBO.setVisibility(0);
      }
      else
      {
        this.FBO.setVisibility(8);
        this.inputType = -1;
      }
    }
  }
  
  public final void fse()
  {
    AppMethodBeat.i(120219);
    if (this.inputType == 0) {
      this.FBO.setVisibility(8);
    }
    for (;;)
    {
      this.inputType = -1;
      AppMethodBeat.o(120219);
      return;
      if (this.inputType == 2) {
        fsf();
      }
    }
  }
  
  public final m<String, Boolean, x> getCommentInputCallback()
  {
    return this.FBY;
  }
  
  public final CharSequence getContent()
  {
    AppMethodBeat.i(120218);
    Object localObject = this.FBP.getText();
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
  
  public final void setCommentInputCallback(m<? super String, ? super Boolean, x> paramm)
  {
    this.FBY = paramm;
  }
  
  public final void setInputType(int paramInt)
  {
    this.inputType = paramInt;
  }
  
  public final void setVisibility$2563266(boolean paramBoolean)
  {
    AppMethodBeat.i(120220);
    if (paramBoolean)
    {
      this.FBP.requestFocus();
      this.inputType = 2;
      this.FBQ.setImageDrawable(ar.m(getContext(), 2131690683, -1));
      this.FBO.setVisibility(4);
      setKeyboardVisibility(true);
    }
    setVisibility(0);
    if (!paramBoolean) {
      clearFocus();
    }
    AppMethodBeat.o(120220);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/story/ui/view/StoryMsgInputView$initSmileyPanel$1", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "append", "", "text", "", "del", "onToSendTextEnable", "enable", "", "performSend", "plugin-story_release"})
  public static final class b
    implements ChatFooterPanel.a
  {
    public final void aHC()
    {
      AppMethodBeat.i(120213);
      InputConnection localInputConnection = StoryMsgInputView.a(this.FDp).getInputConnection();
      if (localInputConnection != null) {
        localInputConnection.sendKeyEvent(new KeyEvent(0, 67));
      }
      localInputConnection = StoryMsgInputView.a(this.FDp).getInputConnection();
      if (localInputConnection != null)
      {
        localInputConnection.sendKeyEvent(new KeyEvent(1, 67));
        AppMethodBeat.o(120213);
        return;
      }
      AppMethodBeat.o(120213);
    }
    
    public final void aHD()
    {
      AppMethodBeat.i(120214);
      if (StoryMsgInputView.b(this.FDp))
      {
        Object localObject = h.FuH;
        h.aaT(9);
        localObject = StoryMsgInputView.a(this.FDp).getText();
        if (localObject != null)
        {
          StoryMsgInputView.c(this.FDp);
          StoryMsgInputView.a(this.FDp).setText(null);
          StoryMsgInputView.d(this.FDp).setVisibility(8);
          m localm = this.FDp.getCommentInputCallback();
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
    
    public final void append(String paramString)
    {
      AppMethodBeat.i(120212);
      StoryMsgInputView.a(this.FDp).bol(paramString);
      AppMethodBeat.o(120212);
    }
    
    public final void eP(boolean paramBoolean) {}
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(StoryMsgInputView paramStoryMsgInputView) {}
    
    public final void run()
    {
      AppMethodBeat.i(120215);
      InputMethodManager localInputMethodManager = (InputMethodManager)this.FDp.getContext().getSystemService("input_method");
      if (localInputMethodManager != null)
      {
        localInputMethodManager.showSoftInput((View)StoryMsgInputView.a(this.FDp), 0);
        AppMethodBeat.o(120215);
        return;
      }
      AppMethodBeat.o(120215);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.StoryMsgInputView
 * JD-Core Version:    0.7.0.1
 */