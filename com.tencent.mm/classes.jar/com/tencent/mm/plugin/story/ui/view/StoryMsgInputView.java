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
import com.tencent.mm.api.aa;
import com.tencent.mm.compatible.util.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.sdk.platformtools.z;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.widget.InputPanelFrameLayout;
import com.tencent.mm.ui.widget.MMEditText;
import d.g.a.m;
import d.l;
import d.y;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/ui/view/StoryMsgInputView;", "Lcom/tencent/mm/ui/widget/InputPanelFrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "canSend", "", "commentInputCallback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "content", "success", "", "getCommentInputCallback", "()Lkotlin/jvm/functions/Function2;", "setCommentInputCallback", "(Lkotlin/jvm/functions/Function2;)V", "emojiBtn", "Landroid/widget/ImageView;", "emojiRoot", "Landroid/widget/FrameLayout;", "hintTv", "Landroid/widget/TextView;", "inputContentGroup", "Landroid/view/View;", "inputLimit", "inputRootView", "inputType", "getInputType", "()I", "setInputType", "(I)V", "inputView", "Lcom/tencent/mm/ui/widget/MMEditText;", "isKeyboardShown", "keyboardHeight", "limitHighLightColor", "limitNormalColor", "loading", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "showImeRunnable", "Ljava/lang/Runnable;", "smileyPanel", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel;", "destroy", "getContent", "", "hideInputPanel", "hideSoftInput", "initSmileyPanel", "onBack", "onInputPanelChange", "isKeyboardShow", "refreshBottomPanelHeight", "setInputHint", "toUser", "isReply", "setKeyboardVisibility", "visible", "setVisibility", "visibility", "needRequest", "Companion", "plugin-story_release"})
public final class StoryMsgInputView
  extends InputPanelFrameLayout
{
  public static final a ywm;
  private final String TAG;
  private boolean fNO;
  private final ChatFooterPanel fSY;
  private final TextView iAd;
  private int inputType;
  private int mEi;
  private final Runnable oQp;
  private final FrameLayout yuK;
  private final MMEditText yuL;
  private final ImageView yuM;
  private final TextView yuN;
  private final View yuP;
  private final View yuQ;
  private boolean yuR;
  private final int yuS;
  private final int yuT;
  private m<? super String, ? super Boolean, y> yuU;
  
  static
  {
    AppMethodBeat.i(120226);
    ywm = new a((byte)0);
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
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.story_comment_emoji_root)");
    this.yuK = ((FrameLayout)paramAttributeSet);
    paramAttributeSet = findViewById(2131305300);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.story_comment_input)");
    this.yuL = ((MMEditText)paramAttributeSet);
    this.yuL.setEnableSendBtn(true);
    paramAttributeSet = findViewById(2131305296);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.story_comment_emoji_btn)");
    this.yuM = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131305305);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.story_comment_input_limit)");
    this.yuN = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(2131305304);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.story_comment_input_hint)");
    this.iAd = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(2131305307);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.story_comment_input_root)");
    this.yuP = paramAttributeSet;
    paramAttributeSet = findViewById(2131305303);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.story_…ent_input_footer_content)");
    this.yuQ = paramAttributeSet;
    this.yuS = getResources().getColor(2131100996);
    this.yuT = getResources().getColor(2131099803);
    paramAttributeSet = aa.k(paramContext, true);
    d.g.b.k.g(paramAttributeSet, "SmileyPanelFactory.getSmileyPanel(context, true)");
    this.fSY = ((ChatFooterPanel)paramAttributeSet);
    this.mEi = z.in(getContext());
    paramAttributeSet = new FrameLayout.LayoutParams(-1, this.mEi);
    this.yuK.addView((View)this.fSY, (ViewGroup.LayoutParams)paramAttributeSet);
    this.fSY.setPortHeightPx(this.mEi);
    this.fSY.setEntranceScene(ChatFooterPanel.vej);
    this.fSY.exn();
    this.fSY.setVisibility(0);
    this.fSY.setShowSend(true);
    this.fSY.onResume();
    this.fSY.setOnTextOperationListener((ChatFooterPanel.a)new b(this));
    this.yuL.addTextChangedListener((TextWatcher)new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(120208);
        if (paramAnonymousEditable != null)
        {
          int j = ((CharSequence)paramAnonymousEditable).length();
          int k = 60 - j;
          StoryMsgInputView localStoryMsgInputView = this.ywn;
          int i;
          if (((CharSequence)paramAnonymousEditable).length() > 0)
          {
            i = 1;
            if ((i == 0) || (k < 0) || (StoryMsgInputView.a(this.ywn).getLineCount() > 10)) {
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
            StoryMsgInputView.e(this.ywn).setVisibility(0);
            StoryMsgInputView.e(this.ywn).setText((CharSequence)String.valueOf(k));
            if (k < 0) {
              break label153;
            }
            StoryMsgInputView.e(this.ywn).setTextColor(StoryMsgInputView.f(this.ywn));
            AppMethodBeat.o(120208);
            return;
            i = 0;
            break;
          }
          label153:
          StoryMsgInputView.e(this.ywn).setTextColor(StoryMsgInputView.g(this.ywn));
          AppMethodBeat.o(120208);
          return;
          label176:
          StoryMsgInputView.e(this.ywn).setVisibility(8);
          AppMethodBeat.o(120208);
          return;
        }
        StoryMsgInputView.a(this.ywn, false);
        StoryMsgInputView.e(this.ywn).setVisibility(8);
        AppMethodBeat.o(120208);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.yuP.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120209);
        if (!StoryMsgInputView.h(this.ywn))
        {
          this.ywn.setInputType(2);
          StoryMsgInputView.b(this.ywn, true);
          StoryMsgInputView.i(this.ywn).setImageDrawable(am.i(paramContext, 2131690482, -1));
        }
        AppMethodBeat.o(120209);
      }
    });
    this.yuM.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120210);
        if (this.ywn.getInputType() == 0)
        {
          this.ywn.setInputType(2);
          StoryMsgInputView.b(this.ywn, true);
          StoryMsgInputView.i(this.ywn).setImageDrawable(am.i(paramContext, 2131690482, -1));
          AppMethodBeat.o(120210);
          return;
        }
        if (StoryMsgInputView.h(this.ywn))
        {
          this.ywn.setInputType(0);
          StoryMsgInputView.b(this.ywn, false);
        }
        for (;;)
        {
          StoryMsgInputView.i(this.ywn).setImageDrawable(am.i(paramContext, 2131690417, -1));
          AppMethodBeat.o(120210);
          return;
          this.ywn.setInputType(0);
          StoryMsgInputView.d(this.ywn).setVisibility(0);
        }
      }
    });
    this.yuL.setOnEditorActionListener((TextView.OnEditorActionListener)new TextView.OnEditorActionListener()
    {
      public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(120211);
        if (4 != paramAnonymousInt)
        {
          d.g.b.k.g(paramAnonymousKeyEvent, "keyEvent");
          if (paramAnonymousKeyEvent.getAction() != 66) {}
        }
        else if (StoryMsgInputView.b(this.ywn))
        {
          paramAnonymousTextView = h.ynv;
          h.OB(9);
          paramAnonymousTextView = StoryMsgInputView.a(this.ywn).getText();
          if (paramAnonymousTextView != null)
          {
            StoryMsgInputView.c(this.ywn);
            StoryMsgInputView.a(this.ywn).setText(null);
            paramAnonymousKeyEvent = this.ywn.getCommentInputCallback();
            if (paramAnonymousKeyEvent != null) {
              paramAnonymousKeyEvent.n(paramAnonymousTextView.toString(), Boolean.TRUE);
            }
          }
        }
        AppMethodBeat.o(120211);
        return true;
      }
    });
    this.yuM.setImageDrawable(am.i(paramContext, 2131690482, -1));
    this.fNO = false;
    setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    this.oQp = ((Runnable)new c(this));
    AppMethodBeat.o(120224);
  }
  
  private final void dLi()
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
      post(this.oQp);
      AppMethodBeat.o(120221);
      return;
    }
    removeCallbacks(this.oQp);
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
    d.g.b.k.h(paramString, "toUser");
    this.yuL.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.b(getContext(), paramCharSequence, this.yuL.getTextSize()));
    if (paramCharSequence != null) {
      this.yuL.setSelection(paramCharSequence.length());
    }
    if (paramBoolean)
    {
      d.g.b.k.g(getResources().getString(2131764303), "resources.getString(R.st…story_reply_visible_hint)");
      paramCharSequence = g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class);
      d.g.b.k.g(paramCharSequence, "MMKernel.service(IMessengerStorage::class.java)");
      paramCharSequence = ((com.tencent.mm.plugin.messenger.foundation.a.k)paramCharSequence).apM().aHY(paramString);
      paramString = new StringBuilder().append(getResources().getString(2131764302)).append(' ');
      Context localContext = this.yuL.getContext();
      if (paramCharSequence != null)
      {
        paramCharSequence = paramCharSequence.ZX();
        if (paramCharSequence != null)
        {
          paramCharSequence = (CharSequence)paramCharSequence;
          paramCharSequence = com.tencent.mm.pluginsdk.ui.span.k.b(localContext, paramCharSequence, this.yuL.getTextSize());
        }
      }
    }
    for (;;)
    {
      this.yuL.setHint((CharSequence)paramCharSequence);
      AppMethodBeat.o(120216);
      return;
      paramCharSequence = (CharSequence)"";
      break;
      d.g.b.k.g(getResources().getString(2131764227), "resources.getString(R.st…ory_comment_visible_hint)");
      paramCharSequence = getResources().getString(2131764227);
      d.g.b.k.g(paramCharSequence, "resources.getString(R.st…ory_comment_visible_hint)");
    }
  }
  
  public final void dLh()
  {
    AppMethodBeat.i(120219);
    if (this.inputType == 0) {
      this.yuK.setVisibility(8);
    }
    for (;;)
    {
      this.inputType = -1;
      AppMethodBeat.o(120219);
      return;
      if (this.inputType == 2) {
        dLi();
      }
    }
  }
  
  public final void g(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(120223);
    super.g(paramBoolean, paramInt);
    this.yuR = paramBoolean;
    if (paramBoolean)
    {
      this.inputType = 2;
      this.yuK.setVisibility(4);
    }
    for (;;)
    {
      if ((this.mEi != paramInt) && (paramInt != 0))
      {
        this.mEi = paramInt;
        i.A(getContext(), paramInt);
        paramInt = z.in(getContext());
        this.fSY.setPortHeightPx(paramInt);
        ViewGroup.LayoutParams localLayoutParams = this.fSY.getLayoutParams();
        if (localLayoutParams != null) {
          localLayoutParams.height = paramInt;
        }
      }
      AppMethodBeat.o(120223);
      return;
      if (this.inputType == 0)
      {
        this.yuK.setVisibility(0);
      }
      else
      {
        this.yuK.setVisibility(8);
        this.inputType = -1;
      }
    }
  }
  
  public final m<String, Boolean, y> getCommentInputCallback()
  {
    return this.yuU;
  }
  
  public final CharSequence getContent()
  {
    AppMethodBeat.i(120218);
    Object localObject = this.yuL.getText();
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
  
  public final void setCommentInputCallback(m<? super String, ? super Boolean, y> paramm)
  {
    this.yuU = paramm;
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
      this.yuL.requestFocus();
      this.inputType = 2;
      this.yuM.setImageDrawable(am.i(getContext(), 2131690482, -1));
      this.yuK.setVisibility(4);
      setKeyboardVisibility(true);
    }
    setVisibility(0);
    if (!paramBoolean) {
      clearFocus();
    }
    AppMethodBeat.o(120220);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/ui/view/StoryMsgInputView$Companion;", "", "()V", "InputEmoji", "", "InputEmojiLater", "InputKeyboard", "InputKeyboardLater", "InputLimit", "InputNone", "MinShowLimit", "plugin-story_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/story/ui/view/StoryMsgInputView$initSmileyPanel$1", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "append", "", "text", "", "del", "onToSendTextEnable", "enable", "", "performSend", "plugin-story_release"})
  public static final class b
    implements ChatFooterPanel.a
  {
    public final void append(String paramString)
    {
      AppMethodBeat.i(120212);
      StoryMsgInputView.a(this.ywn).aMd(paramString);
      AppMethodBeat.o(120212);
    }
    
    public final void btF()
    {
      AppMethodBeat.i(120213);
      InputConnection localInputConnection = StoryMsgInputView.a(this.ywn).getInputConnection();
      if (localInputConnection != null) {
        localInputConnection.sendKeyEvent(new KeyEvent(0, 67));
      }
      localInputConnection = StoryMsgInputView.a(this.ywn).getInputConnection();
      if (localInputConnection != null)
      {
        localInputConnection.sendKeyEvent(new KeyEvent(1, 67));
        AppMethodBeat.o(120213);
        return;
      }
      AppMethodBeat.o(120213);
    }
    
    public final void cqY()
    {
      AppMethodBeat.i(120214);
      if (StoryMsgInputView.b(this.ywn))
      {
        Object localObject = h.ynv;
        h.OB(9);
        localObject = StoryMsgInputView.a(this.ywn).getText();
        if (localObject != null)
        {
          StoryMsgInputView.c(this.ywn);
          StoryMsgInputView.a(this.ywn).setText(null);
          StoryMsgInputView.d(this.ywn).setVisibility(8);
          m localm = this.ywn.getCommentInputCallback();
          if (localm != null)
          {
            localm.n(localObject.toString(), Boolean.TRUE);
            AppMethodBeat.o(120214);
            return;
          }
          AppMethodBeat.o(120214);
          return;
        }
      }
      AppMethodBeat.o(120214);
    }
    
    public final void lf(boolean paramBoolean) {}
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(StoryMsgInputView paramStoryMsgInputView) {}
    
    public final void run()
    {
      AppMethodBeat.i(120215);
      InputMethodManager localInputMethodManager = (InputMethodManager)this.ywn.getContext().getSystemService("input_method");
      if (localInputMethodManager != null)
      {
        localInputMethodManager.showSoftInput((View)StoryMsgInputView.a(this.ywn), 0);
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