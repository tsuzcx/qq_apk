package com.tencent.mm.plugin.story.ui.view;

import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.ae;
import com.tencent.mm.compatible.util.j;
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
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.KeyBoardUtil;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.widget.InputPanelFrameLayout;
import com.tencent.mm.ui.widget.MMEditText;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/view/StoryMsgInputView;", "Lcom/tencent/mm/ui/widget/InputPanelFrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "canSend", "", "commentInputCallback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "content", "success", "", "getCommentInputCallback", "()Lkotlin/jvm/functions/Function2;", "setCommentInputCallback", "(Lkotlin/jvm/functions/Function2;)V", "emojiBtn", "Landroid/widget/ImageView;", "emojiRoot", "Landroid/widget/FrameLayout;", "hintTv", "Landroid/widget/TextView;", "inputContentGroup", "Landroid/view/View;", "inputLimit", "inputRootView", "inputType", "getInputType", "()I", "setInputType", "(I)V", "inputView", "Lcom/tencent/mm/ui/widget/MMEditText;", "isKeyboardShown", "keyboardHeight", "limitHighLightColor", "limitNormalColor", "loading", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "showImeRunnable", "Ljava/lang/Runnable;", "smileyPanel", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel;", "destroy", "getContent", "", "hideInputPanel", "hideSoftInput", "initSmileyPanel", "onBack", "onInputPanelChange", "isKeyboardShow", "refreshBottomPanelHeight", "setInputHint", "toUser", "isReply", "setKeyboardVisibility", "visible", "setVisibility", "visibility", "needRequest", "Companion", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class StoryMsgInputView
  extends InputPanelFrameLayout
{
  public static final StoryMsgInputView.a Sza;
  private final FrameLayout SxL;
  private final MMEditText SxM;
  private final ImageView SxN;
  private final TextView SxO;
  private final View SxQ;
  private final View SxR;
  private boolean SxS;
  private final int SxT;
  private final int SxU;
  private m<? super String, ? super Boolean, ah> SxV;
  private final String TAG;
  private int inputType;
  private boolean miH;
  private final ChatFooterPanel moD;
  private final TextView qjr;
  private int sNb;
  private final Runnable ymo;
  
  static
  {
    AppMethodBeat.i(120226);
    Sza = new StoryMsgInputView.a((byte)0);
    AppMethodBeat.o(120226);
  }
  
  public StoryMsgInputView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(120225);
    AppMethodBeat.o(120225);
  }
  
  public StoryMsgInputView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(120224);
    this.TAG = "MicroMsg.StoryCommentInputView";
    this.inputType = -1;
    View.inflate(paramContext, a.e.SfQ, (ViewGroup)this);
    setClickable(true);
    paramAttributeSet = findViewById(a.d.Ses);
    s.s(paramAttributeSet, "findViewById(R.id.story_comment_emoji_root)");
    this.SxL = ((FrameLayout)paramAttributeSet);
    paramAttributeSet = findViewById(a.d.Seu);
    s.s(paramAttributeSet, "findViewById(R.id.story_comment_input)");
    this.SxM = ((MMEditText)paramAttributeSet);
    this.SxM.setEnableSendBtn(true);
    paramAttributeSet = findViewById(a.d.Ser);
    s.s(paramAttributeSet, "findViewById(R.id.story_comment_emoji_btn)");
    this.SxN = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(a.d.Sey);
    s.s(paramAttributeSet, "findViewById(R.id.story_comment_input_limit)");
    this.SxO = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(a.d.Sex);
    s.s(paramAttributeSet, "findViewById(R.id.story_comment_input_hint)");
    this.qjr = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(a.d.SeA);
    s.s(paramAttributeSet, "findViewById(R.id.story_comment_input_root)");
    this.SxQ = paramAttributeSet;
    paramAttributeSet = findViewById(a.d.Sew);
    s.s(paramAttributeSet, "findViewById(R.id.story_…ent_input_footer_content)");
    this.SxR = paramAttributeSet;
    this.SxT = getResources().getColor(a.a.ScV);
    this.SxU = getResources().getColor(a.a.Red);
    paramAttributeSet = ae.m(paramContext, true);
    s.s(paramAttributeSet, "getSmileyPanel(context, true)");
    this.moD = ((ChatFooterPanel)paramAttributeSet);
    this.sNb = KeyBoardUtil.getValidPanelHeight(getContext());
    paramAttributeSet = new FrameLayout.LayoutParams(-1, this.sNb);
    this.SxL.addView((View)this.moD, (ViewGroup.LayoutParams)paramAttributeSet);
    this.moD.setPortHeightPx(this.sNb);
    this.moD.setEntranceScene(ChatFooterPanel.NEv);
    this.moD.iKh();
    this.moD.setVisibility(0);
    this.moD.setShowSend(true);
    this.moD.onResume();
    this.moD.setOnTextOperationListener((ChatFooterPanel.a)new b(this));
    this.SxM.addTextChangedListener((TextWatcher)new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(120208);
        if (paramAnonymousEditable != null)
        {
          int j = ((CharSequence)paramAnonymousEditable).length();
          int k = 60 - j;
          StoryMsgInputView localStoryMsgInputView = this.Szb;
          int i;
          if (((CharSequence)paramAnonymousEditable).length() > 0)
          {
            i = 1;
            if ((i == 0) || (k < 0) || (StoryMsgInputView.b(this.Szb).getLineCount() > 10)) {
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
            StoryMsgInputView.f(this.Szb).setVisibility(0);
            StoryMsgInputView.f(this.Szb).setText((CharSequence)String.valueOf(k));
            if (k < 0) {
              break label153;
            }
            StoryMsgInputView.f(this.Szb).setTextColor(StoryMsgInputView.g(this.Szb));
            AppMethodBeat.o(120208);
            return;
            i = 0;
            break;
          }
          label153:
          StoryMsgInputView.f(this.Szb).setTextColor(StoryMsgInputView.h(this.Szb));
          AppMethodBeat.o(120208);
          return;
          label176:
          StoryMsgInputView.f(this.Szb).setVisibility(8);
          AppMethodBeat.o(120208);
          return;
        }
        StoryMsgInputView.a(this.Szb, false);
        StoryMsgInputView.f(this.Szb).setVisibility(8);
        AppMethodBeat.o(120208);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.SxQ.setOnClickListener(new StoryMsgInputView..ExternalSyntheticLambda1(this, paramContext));
    this.SxN.setOnClickListener(new StoryMsgInputView..ExternalSyntheticLambda0(this, paramContext));
    this.SxM.setOnEditorActionListener(new StoryMsgInputView..ExternalSyntheticLambda2(this));
    this.SxN.setImageDrawable(bb.m(paramContext, a.f.icons_filled_sticker, -1));
    this.miH = false;
    setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    this.ymo = new StoryMsgInputView..ExternalSyntheticLambda3(this);
    AppMethodBeat.o(120224);
  }
  
  private static final void a(StoryMsgInputView paramStoryMsgInputView)
  {
    AppMethodBeat.i(367490);
    s.u(paramStoryMsgInputView, "this$0");
    InputMethodManager localInputMethodManager = (InputMethodManager)paramStoryMsgInputView.getContext().getSystemService("input_method");
    if (localInputMethodManager != null) {
      localInputMethodManager.showSoftInput((View)paramStoryMsgInputView.SxM, 0);
    }
    AppMethodBeat.o(367490);
  }
  
  private static final void a(StoryMsgInputView paramStoryMsgInputView, Context paramContext, View paramView)
  {
    AppMethodBeat.i(367474);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramStoryMsgInputView);
    localb.cH(paramContext);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/story/ui/view/StoryMsgInputView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramStoryMsgInputView, "this$0");
    s.u(paramContext, "$context");
    if (!paramStoryMsgInputView.SxS)
    {
      paramStoryMsgInputView.setInputType(2);
      paramStoryMsgInputView.setKeyboardVisibility(true);
      paramStoryMsgInputView.SxN.setImageDrawable(bb.m(paramContext, a.f.icons_filled_sticker, -1));
    }
    a.a(new Object(), "com/tencent/mm/plugin/story/ui/view/StoryMsgInputView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(367474);
  }
  
  private static final boolean a(StoryMsgInputView paramStoryMsgInputView, TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(367484);
    s.u(paramStoryMsgInputView, "this$0");
    if (((4 == paramInt) || (paramKeyEvent.getAction() == 66)) && (paramStoryMsgInputView.miH))
    {
      paramTextView = com.tencent.mm.plugin.story.g.h.SqZ;
      com.tencent.mm.plugin.story.g.h.ano(9);
      paramTextView = paramStoryMsgInputView.SxM.getText();
      if (paramTextView != null)
      {
        paramStoryMsgInputView.hzQ();
        paramStoryMsgInputView.SxM.setText(null);
        paramStoryMsgInputView = paramStoryMsgInputView.getCommentInputCallback();
        if (paramStoryMsgInputView != null) {
          paramStoryMsgInputView.invoke(paramTextView.toString(), Boolean.TRUE);
        }
      }
    }
    AppMethodBeat.o(367484);
    return true;
  }
  
  private static final void b(StoryMsgInputView paramStoryMsgInputView, Context paramContext, View paramView)
  {
    AppMethodBeat.i(367478);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramStoryMsgInputView);
    localb.cH(paramContext);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/story/ui/view/StoryMsgInputView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramStoryMsgInputView, "this$0");
    s.u(paramContext, "$context");
    if (paramStoryMsgInputView.getInputType() == 0)
    {
      paramStoryMsgInputView.setInputType(2);
      paramStoryMsgInputView.setKeyboardVisibility(true);
      paramStoryMsgInputView.SxN.setImageDrawable(bb.m(paramContext, a.f.icons_filled_sticker, -1));
      a.a(new Object(), "com/tencent/mm/plugin/story/ui/view/StoryMsgInputView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(367478);
      return;
    }
    if (paramStoryMsgInputView.SxS)
    {
      paramStoryMsgInputView.setInputType(0);
      paramStoryMsgInputView.setKeyboardVisibility(false);
    }
    for (;;)
    {
      paramStoryMsgInputView.SxN.setImageDrawable(bb.m(paramContext, a.f.icons_filled_keyboard, -1));
      break;
      paramStoryMsgInputView.setInputType(0);
      paramStoryMsgInputView.SxL.setVisibility(0);
    }
  }
  
  private final void hzQ()
  {
    AppMethodBeat.i(120222);
    InputMethodManager localInputMethodManager = (InputMethodManager)getContext().getSystemService("input_method");
    if (localInputMethodManager != null) {
      localInputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
    }
    AppMethodBeat.o(120222);
  }
  
  private final void setKeyboardVisibility(boolean paramBoolean)
  {
    AppMethodBeat.i(120221);
    if (paramBoolean)
    {
      post(this.ymo);
      AppMethodBeat.o(120221);
      return;
    }
    removeCallbacks(this.ymo);
    InputMethodManager localInputMethodManager = (InputMethodManager)getContext().getSystemService("input_method");
    if (localInputMethodManager != null) {
      localInputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
    }
    AppMethodBeat.o(120221);
  }
  
  public final void EV(boolean paramBoolean)
  {
    AppMethodBeat.i(120220);
    if (paramBoolean)
    {
      this.SxM.requestFocus();
      this.inputType = 2;
      this.SxN.setImageDrawable(bb.m(getContext(), a.f.icons_filled_sticker, -1));
      this.SxL.setVisibility(4);
      setKeyboardVisibility(true);
    }
    setVisibility(0);
    if (!paramBoolean) {
      clearFocus();
    }
    AppMethodBeat.o(120220);
  }
  
  public final void a(CharSequence paramCharSequence, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(120216);
    s.u(paramString, "toUser");
    this.SxM.setText((CharSequence)p.b(getContext(), paramCharSequence, this.SxM.getTextSize()));
    if (paramCharSequence != null) {
      this.SxM.setSelection(paramCharSequence.length());
    }
    if (paramBoolean)
    {
      s.s(getResources().getString(a.g.Sia), "resources.getString(R.st…story_reply_visible_hint)");
      paramCharSequence = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(paramString);
      StringBuilder localStringBuilder = new StringBuilder().append(getResources().getString(a.g.ShZ)).append(' ');
      Context localContext = this.SxM.getContext();
      if (paramCharSequence == null)
      {
        paramCharSequence = "";
        paramCharSequence = p.b(localContext, (CharSequence)paramCharSequence, this.SxM.getTextSize());
      }
    }
    for (;;)
    {
      this.SxM.setHint((CharSequence)paramCharSequence);
      AppMethodBeat.o(120216);
      return;
      paramString = paramCharSequence.aSV();
      paramCharSequence = paramString;
      if (paramString != null) {
        break;
      }
      paramCharSequence = "";
      break;
      s.s(getResources().getString(a.g.Shu), "resources.getString(R.st…ory_comment_visible_hint)");
      paramCharSequence = getResources().getString(a.g.Shu);
      s.s(paramCharSequence, "resources.getString(R.st…ory_comment_visible_hint)");
    }
  }
  
  public final m<String, Boolean, ah> getCommentInputCallback()
  {
    return this.SxV;
  }
  
  public final CharSequence getContent()
  {
    AppMethodBeat.i(120218);
    Object localObject = this.SxM.getText();
    if (localObject == null) {}
    for (localObject = null;; localObject = localObject.toString())
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
  
  public final void hzW()
  {
    AppMethodBeat.i(120219);
    if (this.inputType == 0) {
      this.SxL.setVisibility(8);
    }
    for (;;)
    {
      this.inputType = -1;
      AppMethodBeat.o(120219);
      return;
      if (this.inputType == 2) {
        hzQ();
      }
    }
  }
  
  public final void onInputPanelChange(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(120223);
    super.onInputPanelChange(paramBoolean, paramInt);
    this.SxS = paramBoolean;
    if (paramBoolean)
    {
      this.inputType = 2;
      this.SxL.setVisibility(4);
    }
    for (;;)
    {
      if ((this.sNb != paramInt) && (paramInt != 0))
      {
        this.sNb = paramInt;
        j.H(getContext(), paramInt);
        paramInt = KeyBoardUtil.getValidPanelHeight(getContext());
        this.moD.setPortHeightPx(paramInt);
        ViewGroup.LayoutParams localLayoutParams = this.moD.getLayoutParams();
        if (localLayoutParams != null) {
          localLayoutParams.height = paramInt;
        }
      }
      AppMethodBeat.o(120223);
      return;
      if (this.inputType == 0)
      {
        this.SxL.setVisibility(0);
      }
      else
      {
        this.SxL.setVisibility(8);
        this.inputType = -1;
      }
    }
  }
  
  public final void setCommentInputCallback(m<? super String, ? super Boolean, ah> paramm)
  {
    this.SxV = paramm;
  }
  
  public final void setInputType(int paramInt)
  {
    this.inputType = paramInt;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/story/ui/view/StoryMsgInputView$initSmileyPanel$1", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "append", "", "text", "", "del", "onToSendTextEnable", "enable", "", "performSend", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements ChatFooterPanel.a
  {
    b(StoryMsgInputView paramStoryMsgInputView) {}
    
    public final void aWL()
    {
      AppMethodBeat.i(120214);
      if (StoryMsgInputView.c(this.Szb))
      {
        Object localObject1 = com.tencent.mm.plugin.story.g.h.SqZ;
        com.tencent.mm.plugin.story.g.h.ano(9);
        localObject1 = StoryMsgInputView.b(this.Szb).getText();
        if (localObject1 != null)
        {
          Object localObject2 = this.Szb;
          StoryMsgInputView.d((StoryMsgInputView)localObject2);
          StoryMsgInputView.b((StoryMsgInputView)localObject2).setText(null);
          StoryMsgInputView.e((StoryMsgInputView)localObject2).setVisibility(8);
          localObject2 = ((StoryMsgInputView)localObject2).getCommentInputCallback();
          if (localObject2 != null) {
            ((m)localObject2).invoke(localObject1.toString(), Boolean.TRUE);
          }
        }
      }
      AppMethodBeat.o(120214);
    }
    
    public final void aWM()
    {
      AppMethodBeat.i(120213);
      InputConnection localInputConnection = StoryMsgInputView.b(this.Szb).getInputConnection();
      if (localInputConnection != null) {
        localInputConnection.sendKeyEvent(new KeyEvent(0, 67));
      }
      localInputConnection = StoryMsgInputView.b(this.Szb).getInputConnection();
      if (localInputConnection != null) {
        localInputConnection.sendKeyEvent(new KeyEvent(1, 67));
      }
      AppMethodBeat.o(120213);
    }
    
    public final void append(String paramString)
    {
      AppMethodBeat.i(120212);
      StoryMsgInputView.b(this.Szb).bDt(paramString);
      AppMethodBeat.o(120212);
    }
    
    public final void fp(boolean paramBoolean) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.StoryMsgInputView
 * JD-Core Version:    0.7.0.1
 */