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
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.widget.InputPanelFrameLayout;
import com.tencent.mm.ui.widget.MMEditText;
import d.g.a.m;
import d.g.b.p;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/ui/view/StoryMsgInputView;", "Lcom/tencent/mm/ui/widget/InputPanelFrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "canSend", "", "commentInputCallback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "content", "success", "", "getCommentInputCallback", "()Lkotlin/jvm/functions/Function2;", "setCommentInputCallback", "(Lkotlin/jvm/functions/Function2;)V", "emojiBtn", "Landroid/widget/ImageView;", "emojiRoot", "Landroid/widget/FrameLayout;", "hintTv", "Landroid/widget/TextView;", "inputContentGroup", "Landroid/view/View;", "inputLimit", "inputRootView", "inputType", "getInputType", "()I", "setInputType", "(I)V", "inputView", "Lcom/tencent/mm/ui/widget/MMEditText;", "isKeyboardShown", "keyboardHeight", "limitHighLightColor", "limitNormalColor", "loading", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "showImeRunnable", "Ljava/lang/Runnable;", "smileyPanel", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel;", "destroy", "getContent", "", "hideInputPanel", "hideSoftInput", "initSmileyPanel", "onBack", "onInputPanelChange", "isKeyboardShow", "refreshBottomPanelHeight", "setInputHint", "toUser", "isReply", "setKeyboardVisibility", "visible", "setVisibility", "visibility", "needRequest", "Companion", "plugin-story_release"})
public final class StoryMsgInputView
  extends InputPanelFrameLayout
{
  public static final StoryMsgInputView.a Bbd;
  private final FrameLayout AZD;
  private final MMEditText AZE;
  private final ImageView AZF;
  private final TextView AZG;
  private final View AZI;
  private final View AZJ;
  private boolean AZK;
  private final int AZL;
  private final int AZM;
  private m<? super String, ? super Boolean, d.z> AZN;
  private final String TAG;
  private boolean gkZ;
  private int inputType;
  private final TextView jtn;
  private int nGK;
  private final ChatFooterPanel pWJ;
  private final Runnable pXg;
  
  static
  {
    AppMethodBeat.i(120226);
    Bbd = new StoryMsgInputView.a((byte)0);
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
    this.AZD = ((FrameLayout)paramAttributeSet);
    paramAttributeSet = findViewById(2131305300);
    p.g(paramAttributeSet, "findViewById(R.id.story_comment_input)");
    this.AZE = ((MMEditText)paramAttributeSet);
    this.AZE.setEnableSendBtn(true);
    paramAttributeSet = findViewById(2131305296);
    p.g(paramAttributeSet, "findViewById(R.id.story_comment_emoji_btn)");
    this.AZF = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131305305);
    p.g(paramAttributeSet, "findViewById(R.id.story_comment_input_limit)");
    this.AZG = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(2131305304);
    p.g(paramAttributeSet, "findViewById(R.id.story_comment_input_hint)");
    this.jtn = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(2131305307);
    p.g(paramAttributeSet, "findViewById(R.id.story_comment_input_root)");
    this.AZI = paramAttributeSet;
    paramAttributeSet = findViewById(2131305303);
    p.g(paramAttributeSet, "findViewById(R.id.story_…ent_input_footer_content)");
    this.AZJ = paramAttributeSet;
    this.AZL = getResources().getColor(2131100996);
    this.AZM = getResources().getColor(2131099803);
    paramAttributeSet = aa.k(paramContext, true);
    p.g(paramAttributeSet, "SmileyPanelFactory.getSmileyPanel(context, true)");
    this.pWJ = ((ChatFooterPanel)paramAttributeSet);
    this.nGK = com.tencent.mm.sdk.platformtools.z.iI(getContext());
    paramAttributeSet = new FrameLayout.LayoutParams(-1, this.nGK);
    this.AZD.addView((View)this.pWJ, (ViewGroup.LayoutParams)paramAttributeSet);
    this.pWJ.setPortHeightPx(this.nGK);
    this.pWJ.setEntranceScene(ChatFooterPanel.xuM);
    this.pWJ.fbF();
    this.pWJ.setVisibility(0);
    this.pWJ.setShowSend(true);
    this.pWJ.onResume();
    this.pWJ.setOnTextOperationListener((ChatFooterPanel.a)new b(this));
    this.AZE.addTextChangedListener((TextWatcher)new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(120208);
        if (paramAnonymousEditable != null)
        {
          int j = ((CharSequence)paramAnonymousEditable).length();
          int k = 60 - j;
          StoryMsgInputView localStoryMsgInputView = this.Bbe;
          int i;
          if (((CharSequence)paramAnonymousEditable).length() > 0)
          {
            i = 1;
            if ((i == 0) || (k < 0) || (StoryMsgInputView.a(this.Bbe).getLineCount() > 10)) {
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
            StoryMsgInputView.e(this.Bbe).setVisibility(0);
            StoryMsgInputView.e(this.Bbe).setText((CharSequence)String.valueOf(k));
            if (k < 0) {
              break label153;
            }
            StoryMsgInputView.e(this.Bbe).setTextColor(StoryMsgInputView.f(this.Bbe));
            AppMethodBeat.o(120208);
            return;
            i = 0;
            break;
          }
          label153:
          StoryMsgInputView.e(this.Bbe).setTextColor(StoryMsgInputView.g(this.Bbe));
          AppMethodBeat.o(120208);
          return;
          label176:
          StoryMsgInputView.e(this.Bbe).setVisibility(8);
          AppMethodBeat.o(120208);
          return;
        }
        StoryMsgInputView.a(this.Bbe, false);
        StoryMsgInputView.e(this.Bbe).setVisibility(8);
        AppMethodBeat.o(120208);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.AZI.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120209);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/story/ui/view/StoryMsgInputView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (!StoryMsgInputView.h(this.Bbe))
        {
          this.Bbe.setInputType(2);
          StoryMsgInputView.b(this.Bbe, true);
          StoryMsgInputView.i(this.Bbe).setImageDrawable(ao.k(paramContext, 2131690482, -1));
        }
        a.a(this, "com/tencent/mm/plugin/story/ui/view/StoryMsgInputView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(120209);
      }
    });
    this.AZF.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120210);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/story/ui/view/StoryMsgInputView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (this.Bbe.getInputType() == 0)
        {
          this.Bbe.setInputType(2);
          StoryMsgInputView.b(this.Bbe, true);
          StoryMsgInputView.i(this.Bbe).setImageDrawable(ao.k(paramContext, 2131690482, -1));
          a.a(this, "com/tencent/mm/plugin/story/ui/view/StoryMsgInputView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(120210);
          return;
        }
        if (StoryMsgInputView.h(this.Bbe))
        {
          this.Bbe.setInputType(0);
          StoryMsgInputView.b(this.Bbe, false);
        }
        for (;;)
        {
          StoryMsgInputView.i(this.Bbe).setImageDrawable(ao.k(paramContext, 2131690417, -1));
          break;
          this.Bbe.setInputType(0);
          StoryMsgInputView.d(this.Bbe).setVisibility(0);
        }
      }
    });
    this.AZE.setOnEditorActionListener((TextView.OnEditorActionListener)new TextView.OnEditorActionListener()
    {
      public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(120211);
        if (4 != paramAnonymousInt)
        {
          p.g(paramAnonymousKeyEvent, "keyEvent");
          if (paramAnonymousKeyEvent.getAction() != 66) {}
        }
        else if (StoryMsgInputView.b(this.Bbe))
        {
          paramAnonymousTextView = h.ASt;
          h.Sq(9);
          paramAnonymousTextView = StoryMsgInputView.a(this.Bbe).getText();
          if (paramAnonymousTextView != null)
          {
            StoryMsgInputView.c(this.Bbe);
            StoryMsgInputView.a(this.Bbe).setText(null);
            paramAnonymousKeyEvent = this.Bbe.getCommentInputCallback();
            if (paramAnonymousKeyEvent != null) {
              paramAnonymousKeyEvent.p(paramAnonymousTextView.toString(), Boolean.TRUE);
            }
          }
        }
        AppMethodBeat.o(120211);
        return true;
      }
    });
    this.AZF.setImageDrawable(ao.k(paramContext, 2131690482, -1));
    this.gkZ = false;
    setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    this.pXg = ((Runnable)new c(this));
    AppMethodBeat.o(120224);
  }
  
  private final void elX()
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
      post(this.pXg);
      AppMethodBeat.o(120221);
      return;
    }
    removeCallbacks(this.pXg);
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
    this.AZE.setText((CharSequence)k.b(getContext(), paramCharSequence, this.AZE.getTextSize()));
    if (paramCharSequence != null) {
      this.AZE.setSelection(paramCharSequence.length());
    }
    if (paramBoolean)
    {
      p.g(getResources().getString(2131764303), "resources.getString(R.st…story_reply_visible_hint)");
      paramCharSequence = g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
      p.g(paramCharSequence, "MMKernel.service(IMessengerStorage::class.java)");
      paramCharSequence = ((com.tencent.mm.plugin.messenger.foundation.a.l)paramCharSequence).azp().Bf(paramString);
      paramString = new StringBuilder().append(getResources().getString(2131764302)).append(' ');
      Context localContext = this.AZE.getContext();
      if (paramCharSequence != null)
      {
        paramCharSequence = paramCharSequence.adv();
        if (paramCharSequence != null)
        {
          paramCharSequence = (CharSequence)paramCharSequence;
          paramCharSequence = k.b(localContext, paramCharSequence, this.AZE.getTextSize());
        }
      }
    }
    for (;;)
    {
      this.AZE.setHint((CharSequence)paramCharSequence);
      AppMethodBeat.o(120216);
      return;
      paramCharSequence = (CharSequence)"";
      break;
      p.g(getResources().getString(2131764227), "resources.getString(R.st…ory_comment_visible_hint)");
      paramCharSequence = getResources().getString(2131764227);
      p.g(paramCharSequence, "resources.getString(R.st…ory_comment_visible_hint)");
    }
  }
  
  public final void elW()
  {
    AppMethodBeat.i(120219);
    if (this.inputType == 0) {
      this.AZD.setVisibility(8);
    }
    for (;;)
    {
      this.inputType = -1;
      AppMethodBeat.o(120219);
      return;
      if (this.inputType == 2) {
        elX();
      }
    }
  }
  
  public final void g(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(120223);
    super.g(paramBoolean, paramInt);
    this.AZK = paramBoolean;
    if (paramBoolean)
    {
      this.inputType = 2;
      this.AZD.setVisibility(4);
    }
    for (;;)
    {
      if ((this.nGK != paramInt) && (paramInt != 0))
      {
        this.nGK = paramInt;
        i.A(getContext(), paramInt);
        paramInt = com.tencent.mm.sdk.platformtools.z.iI(getContext());
        this.pWJ.setPortHeightPx(paramInt);
        ViewGroup.LayoutParams localLayoutParams = this.pWJ.getLayoutParams();
        if (localLayoutParams != null) {
          localLayoutParams.height = paramInt;
        }
      }
      AppMethodBeat.o(120223);
      return;
      if (this.inputType == 0)
      {
        this.AZD.setVisibility(0);
      }
      else
      {
        this.AZD.setVisibility(8);
        this.inputType = -1;
      }
    }
  }
  
  public final m<String, Boolean, d.z> getCommentInputCallback()
  {
    return this.AZN;
  }
  
  public final CharSequence getContent()
  {
    AppMethodBeat.i(120218);
    Object localObject = this.AZE.getText();
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
  
  public final void setCommentInputCallback(m<? super String, ? super Boolean, d.z> paramm)
  {
    this.AZN = paramm;
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
      this.AZE.requestFocus();
      this.inputType = 2;
      this.AZF.setImageDrawable(ao.k(getContext(), 2131690482, -1));
      this.AZD.setVisibility(4);
      setKeyboardVisibility(true);
    }
    setVisibility(0);
    if (!paramBoolean) {
      clearFocus();
    }
    AppMethodBeat.o(120220);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/story/ui/view/StoryMsgInputView$initSmileyPanel$1", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "append", "", "text", "", "del", "onToSendTextEnable", "enable", "", "performSend", "plugin-story_release"})
  public static final class b
    implements ChatFooterPanel.a
  {
    public final void aoO()
    {
      AppMethodBeat.i(120213);
      InputConnection localInputConnection = StoryMsgInputView.a(this.Bbe).getInputConnection();
      if (localInputConnection != null) {
        localInputConnection.sendKeyEvent(new KeyEvent(0, 67));
      }
      localInputConnection = StoryMsgInputView.a(this.Bbe).getInputConnection();
      if (localInputConnection != null)
      {
        localInputConnection.sendKeyEvent(new KeyEvent(1, 67));
        AppMethodBeat.o(120213);
        return;
      }
      AppMethodBeat.o(120213);
    }
    
    public final void aoP()
    {
      AppMethodBeat.i(120214);
      if (StoryMsgInputView.b(this.Bbe))
      {
        Object localObject = h.ASt;
        h.Sq(9);
        localObject = StoryMsgInputView.a(this.Bbe).getText();
        if (localObject != null)
        {
          StoryMsgInputView.c(this.Bbe);
          StoryMsgInputView.a(this.Bbe).setText(null);
          StoryMsgInputView.d(this.Bbe).setVisibility(8);
          m localm = this.Bbe.getCommentInputCallback();
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
      StoryMsgInputView.a(this.Bbe).aXD(paramString);
      AppMethodBeat.o(120212);
    }
    
    public final void dU(boolean paramBoolean) {}
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(StoryMsgInputView paramStoryMsgInputView) {}
    
    public final void run()
    {
      AppMethodBeat.i(120215);
      InputMethodManager localInputMethodManager = (InputMethodManager)this.Bbe.getContext().getSystemService("input_method");
      if (localInputMethodManager != null)
      {
        localInputMethodManager.showSoftInput((View)StoryMsgInputView.a(this.Bbe), 0);
        AppMethodBeat.o(120215);
        return;
      }
      AppMethodBeat.o(120215);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.StoryMsgInputView
 * JD-Core Version:    0.7.0.1
 */