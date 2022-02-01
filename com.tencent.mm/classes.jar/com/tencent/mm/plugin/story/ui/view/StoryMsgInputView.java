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
import com.tencent.mm.compatible.util.i;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.widget.InputPanelFrameLayout;
import com.tencent.mm.ui.widget.MMEditText;
import d.g.a.m;
import d.g.b.p;
import d.z;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/ui/view/StoryMsgInputView;", "Lcom/tencent/mm/ui/widget/InputPanelFrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "canSend", "", "commentInputCallback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "content", "success", "", "getCommentInputCallback", "()Lkotlin/jvm/functions/Function2;", "setCommentInputCallback", "(Lkotlin/jvm/functions/Function2;)V", "emojiBtn", "Landroid/widget/ImageView;", "emojiRoot", "Landroid/widget/FrameLayout;", "hintTv", "Landroid/widget/TextView;", "inputContentGroup", "Landroid/view/View;", "inputLimit", "inputRootView", "inputType", "getInputType", "()I", "setInputType", "(I)V", "inputView", "Lcom/tencent/mm/ui/widget/MMEditText;", "isKeyboardShown", "keyboardHeight", "limitHighLightColor", "limitNormalColor", "loading", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "showImeRunnable", "Ljava/lang/Runnable;", "smileyPanel", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel;", "destroy", "getContent", "", "hideInputPanel", "hideSoftInput", "initSmileyPanel", "onBack", "onInputPanelChange", "isKeyboardShow", "refreshBottomPanelHeight", "setInputHint", "toUser", "isReply", "setKeyboardVisibility", "visible", "setVisibility", "visibility", "needRequest", "Companion", "plugin-story_release"})
public final class StoryMsgInputView
  extends InputPanelFrameLayout
{
  public static final StoryMsgInputView.a BsB;
  private final FrameLayout Brb;
  private final MMEditText Brc;
  private final ImageView Brd;
  private final TextView Bre;
  private final View Brg;
  private final View Brh;
  private boolean Bri;
  private final int Brj;
  private final int Brk;
  private m<? super String, ? super Boolean, z> Brl;
  private final String TAG;
  private boolean gnu;
  private int inputType;
  private final TextView jwg;
  private int nMm;
  private final Runnable qdL;
  private final ChatFooterPanel qdo;
  
  static
  {
    AppMethodBeat.i(120226);
    BsB = new StoryMsgInputView.a((byte)0);
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
    View.inflate(paramContext, 2131495710, (ViewGroup)this);
    setClickable(true);
    paramAttributeSet = findViewById(2131305297);
    p.g(paramAttributeSet, "findViewById(R.id.story_comment_emoji_root)");
    this.Brb = ((FrameLayout)paramAttributeSet);
    paramAttributeSet = findViewById(2131305300);
    p.g(paramAttributeSet, "findViewById(R.id.story_comment_input)");
    this.Brc = ((MMEditText)paramAttributeSet);
    this.Brc.setEnableSendBtn(true);
    paramAttributeSet = findViewById(2131305296);
    p.g(paramAttributeSet, "findViewById(R.id.story_comment_emoji_btn)");
    this.Brd = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131305305);
    p.g(paramAttributeSet, "findViewById(R.id.story_comment_input_limit)");
    this.Bre = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(2131305304);
    p.g(paramAttributeSet, "findViewById(R.id.story_comment_input_hint)");
    this.jwg = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(2131305307);
    p.g(paramAttributeSet, "findViewById(R.id.story_comment_input_root)");
    this.Brg = paramAttributeSet;
    paramAttributeSet = findViewById(2131305303);
    p.g(paramAttributeSet, "findViewById(R.id.story_…ent_input_footer_content)");
    this.Brh = paramAttributeSet;
    this.Brj = getResources().getColor(2131100996);
    this.Brk = getResources().getColor(2131099803);
    paramAttributeSet = com.tencent.mm.api.aa.k(paramContext, true);
    p.g(paramAttributeSet, "SmileyPanelFactory.getSmileyPanel(context, true)");
    this.qdo = ((ChatFooterPanel)paramAttributeSet);
    this.nMm = com.tencent.mm.sdk.platformtools.aa.iN(getContext());
    paramAttributeSet = new FrameLayout.LayoutParams(-1, this.nMm);
    this.Brb.addView((View)this.qdo, (ViewGroup.LayoutParams)paramAttributeSet);
    this.qdo.setPortHeightPx(this.nMm);
    this.qdo.setEntranceScene(ChatFooterPanel.xKJ);
    this.qdo.fft();
    this.qdo.setVisibility(0);
    this.qdo.setShowSend(true);
    this.qdo.onResume();
    this.qdo.setOnTextOperationListener((ChatFooterPanel.a)new b(this));
    this.Brc.addTextChangedListener((TextWatcher)new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(120208);
        if (paramAnonymousEditable != null)
        {
          int j = ((CharSequence)paramAnonymousEditable).length();
          int k = 60 - j;
          StoryMsgInputView localStoryMsgInputView = this.BsC;
          int i;
          if (((CharSequence)paramAnonymousEditable).length() > 0)
          {
            i = 1;
            if ((i == 0) || (k < 0) || (StoryMsgInputView.a(this.BsC).getLineCount() > 10)) {
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
            StoryMsgInputView.e(this.BsC).setVisibility(0);
            StoryMsgInputView.e(this.BsC).setText((CharSequence)String.valueOf(k));
            if (k < 0) {
              break label153;
            }
            StoryMsgInputView.e(this.BsC).setTextColor(StoryMsgInputView.f(this.BsC));
            AppMethodBeat.o(120208);
            return;
            i = 0;
            break;
          }
          label153:
          StoryMsgInputView.e(this.BsC).setTextColor(StoryMsgInputView.g(this.BsC));
          AppMethodBeat.o(120208);
          return;
          label176:
          StoryMsgInputView.e(this.BsC).setVisibility(8);
          AppMethodBeat.o(120208);
          return;
        }
        StoryMsgInputView.a(this.BsC, false);
        StoryMsgInputView.e(this.BsC).setVisibility(8);
        AppMethodBeat.o(120208);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.Brg.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120209);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/story/ui/view/StoryMsgInputView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (!StoryMsgInputView.h(this.BsC))
        {
          this.BsC.setInputType(2);
          StoryMsgInputView.b(this.BsC, true);
          StoryMsgInputView.i(this.BsC).setImageDrawable(ao.k(paramContext, 2131690482, -1));
        }
        a.a(this, "com/tencent/mm/plugin/story/ui/view/StoryMsgInputView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(120209);
      }
    });
    this.Brd.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120210);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/story/ui/view/StoryMsgInputView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (this.BsC.getInputType() == 0)
        {
          this.BsC.setInputType(2);
          StoryMsgInputView.b(this.BsC, true);
          StoryMsgInputView.i(this.BsC).setImageDrawable(ao.k(paramContext, 2131690482, -1));
          a.a(this, "com/tencent/mm/plugin/story/ui/view/StoryMsgInputView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(120210);
          return;
        }
        if (StoryMsgInputView.h(this.BsC))
        {
          this.BsC.setInputType(0);
          StoryMsgInputView.b(this.BsC, false);
        }
        for (;;)
        {
          StoryMsgInputView.i(this.BsC).setImageDrawable(ao.k(paramContext, 2131690417, -1));
          break;
          this.BsC.setInputType(0);
          StoryMsgInputView.d(this.BsC).setVisibility(0);
        }
      }
    });
    this.Brc.setOnEditorActionListener((TextView.OnEditorActionListener)new TextView.OnEditorActionListener()
    {
      public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(120211);
        if (4 != paramAnonymousInt)
        {
          p.g(paramAnonymousKeyEvent, "keyEvent");
          if (paramAnonymousKeyEvent.getAction() != 66) {}
        }
        else if (StoryMsgInputView.b(this.BsC))
        {
          paramAnonymousTextView = h.BjR;
          h.SX(9);
          paramAnonymousTextView = StoryMsgInputView.a(this.BsC).getText();
          if (paramAnonymousTextView != null)
          {
            StoryMsgInputView.c(this.BsC);
            StoryMsgInputView.a(this.BsC).setText(null);
            paramAnonymousKeyEvent = this.BsC.getCommentInputCallback();
            if (paramAnonymousKeyEvent != null) {
              paramAnonymousKeyEvent.p(paramAnonymousTextView.toString(), Boolean.TRUE);
            }
          }
        }
        AppMethodBeat.o(120211);
        return true;
      }
    });
    this.Brd.setImageDrawable(ao.k(paramContext, 2131690482, -1));
    this.gnu = false;
    setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    this.qdL = ((Runnable)new c(this));
    AppMethodBeat.o(120224);
  }
  
  private final void epG()
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
      post(this.qdL);
      AppMethodBeat.o(120221);
      return;
    }
    removeCallbacks(this.qdL);
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
    this.Brc.setText((CharSequence)k.b(getContext(), paramCharSequence, this.Brc.getTextSize()));
    if (paramCharSequence != null) {
      this.Brc.setSelection(paramCharSequence.length());
    }
    if (paramBoolean)
    {
      p.g(getResources().getString(2131764303), "resources.getString(R.st…story_reply_visible_hint)");
      paramCharSequence = g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
      p.g(paramCharSequence, "MMKernel.service(IMessengerStorage::class.java)");
      paramCharSequence = ((com.tencent.mm.plugin.messenger.foundation.a.l)paramCharSequence).azF().BH(paramString);
      paramString = new StringBuilder().append(getResources().getString(2131764302)).append(' ');
      Context localContext = this.Brc.getContext();
      if (paramCharSequence != null)
      {
        paramCharSequence = paramCharSequence.adG();
        if (paramCharSequence != null)
        {
          paramCharSequence = (CharSequence)paramCharSequence;
          paramCharSequence = k.b(localContext, paramCharSequence, this.Brc.getTextSize());
        }
      }
    }
    for (;;)
    {
      this.Brc.setHint((CharSequence)paramCharSequence);
      AppMethodBeat.o(120216);
      return;
      paramCharSequence = (CharSequence)"";
      break;
      p.g(getResources().getString(2131764227), "resources.getString(R.st…ory_comment_visible_hint)");
      paramCharSequence = getResources().getString(2131764227);
      p.g(paramCharSequence, "resources.getString(R.st…ory_comment_visible_hint)");
    }
  }
  
  public final void epF()
  {
    AppMethodBeat.i(120219);
    if (this.inputType == 0) {
      this.Brb.setVisibility(8);
    }
    for (;;)
    {
      this.inputType = -1;
      AppMethodBeat.o(120219);
      return;
      if (this.inputType == 2) {
        epG();
      }
    }
  }
  
  public final void g(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(120223);
    super.g(paramBoolean, paramInt);
    this.Bri = paramBoolean;
    if (paramBoolean)
    {
      this.inputType = 2;
      this.Brb.setVisibility(4);
    }
    for (;;)
    {
      if ((this.nMm != paramInt) && (paramInt != 0))
      {
        this.nMm = paramInt;
        i.A(getContext(), paramInt);
        paramInt = com.tencent.mm.sdk.platformtools.aa.iN(getContext());
        this.qdo.setPortHeightPx(paramInt);
        ViewGroup.LayoutParams localLayoutParams = this.qdo.getLayoutParams();
        if (localLayoutParams != null) {
          localLayoutParams.height = paramInt;
        }
      }
      AppMethodBeat.o(120223);
      return;
      if (this.inputType == 0)
      {
        this.Brb.setVisibility(0);
      }
      else
      {
        this.Brb.setVisibility(8);
        this.inputType = -1;
      }
    }
  }
  
  public final m<String, Boolean, z> getCommentInputCallback()
  {
    return this.Brl;
  }
  
  public final CharSequence getContent()
  {
    AppMethodBeat.i(120218);
    Object localObject = this.Brc.getText();
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
  
  public final void setCommentInputCallback(m<? super String, ? super Boolean, z> paramm)
  {
    this.Brl = paramm;
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
      this.Brc.requestFocus();
      this.inputType = 2;
      this.Brd.setImageDrawable(ao.k(getContext(), 2131690482, -1));
      this.Brb.setVisibility(4);
      setKeyboardVisibility(true);
    }
    setVisibility(0);
    if (!paramBoolean) {
      clearFocus();
    }
    AppMethodBeat.o(120220);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/story/ui/view/StoryMsgInputView$initSmileyPanel$1", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "append", "", "text", "", "del", "onToSendTextEnable", "enable", "", "performSend", "plugin-story_release"})
  public static final class b
    implements ChatFooterPanel.a
  {
    public final void apc()
    {
      AppMethodBeat.i(120213);
      InputConnection localInputConnection = StoryMsgInputView.a(this.BsC).getInputConnection();
      if (localInputConnection != null) {
        localInputConnection.sendKeyEvent(new KeyEvent(0, 67));
      }
      localInputConnection = StoryMsgInputView.a(this.BsC).getInputConnection();
      if (localInputConnection != null)
      {
        localInputConnection.sendKeyEvent(new KeyEvent(1, 67));
        AppMethodBeat.o(120213);
        return;
      }
      AppMethodBeat.o(120213);
    }
    
    public final void apd()
    {
      AppMethodBeat.i(120214);
      if (StoryMsgInputView.b(this.BsC))
      {
        Object localObject = h.BjR;
        h.SX(9);
        localObject = StoryMsgInputView.a(this.BsC).getText();
        if (localObject != null)
        {
          StoryMsgInputView.c(this.BsC);
          StoryMsgInputView.a(this.BsC).setText(null);
          StoryMsgInputView.d(this.BsC).setVisibility(8);
          m localm = this.BsC.getCommentInputCallback();
          if (localm != null)
          {
            localm.p(localObject.toString(), Boolean.TRUE);
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
      StoryMsgInputView.a(this.BsC).aZf(paramString);
      AppMethodBeat.o(120212);
    }
    
    public final void dW(boolean paramBoolean) {}
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(StoryMsgInputView paramStoryMsgInputView) {}
    
    public final void run()
    {
      AppMethodBeat.i(120215);
      InputMethodManager localInputMethodManager = (InputMethodManager)this.BsC.getContext().getSystemService("input_method");
      if (localInputMethodManager != null)
      {
        localInputMethodManager.showSoftInput((View)StoryMsgInputView.a(this.BsC), 0);
        AppMethodBeat.o(120215);
        return;
      }
      AppMethodBeat.o(120215);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.StoryMsgInputView
 * JD-Core Version:    0.7.0.1
 */