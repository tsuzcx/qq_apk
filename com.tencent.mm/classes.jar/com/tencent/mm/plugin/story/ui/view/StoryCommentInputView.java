package com.tencent.mm.plugin.story.ui.view;

import a.f.a.m;
import a.l;
import a.v;
import a.y;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.i;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.u;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.story.model.j.b;
import com.tencent.mm.plugin.story.ui.a.f;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.widget.InputPanelFrameLayout;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/view/StoryCommentInputView;", "Lcom/tencent/mm/ui/widget/InputPanelFrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "avatar", "Landroid/widget/ImageView;", "canSend", "", "commentAdapter", "Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter;", "commentInputCallback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "content", "success", "", "getCommentInputCallback", "()Lkotlin/jvm/functions/Function2;", "setCommentInputCallback", "(Lkotlin/jvm/functions/Function2;)V", "commentReplyCallback", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "comment", "isReply", "getCommentReplyCallback", "setCommentReplyCallback", "emojiBtn", "emojiRoot", "Landroid/widget/FrameLayout;", "fromUser", "Landroid/widget/TextView;", "hintTv", "inputContentGroup", "Landroid/view/View;", "inputLimit", "inputRootView", "inputType", "inputView", "Lcom/tencent/mm/ui/widget/MMEditText;", "isKeyboardShown", "keyboardHeight", "limitHighLightColor", "limitNormalColor", "loading", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "showImeRunnable", "Ljava/lang/Runnable;", "smileyPanel", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel;", "destroy", "getContent", "", "hideSoftInput", "initSmileyPanel", "notifyDataChanged", "notifyItemRemoved", "index", "onBack", "onInputPanelChange", "isKeyboardShow", "refreshBottomPanelHeight", "scrollToPosition", "position", "setHostStory", "storyInfo", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "setInputHint", "toUser", "setKeyboardVisibility", "visible", "setVisibility", "visibility", "showCommentsList", "show", "updateComments", "storyComments", "", "Companion", "plugin-story_release"})
public final class StoryCommentInputView
  extends InputPanelFrameLayout
{
  public static final StoryCommentInputView.a sMu;
  private final String TAG;
  private final ChatFooterPanel eys;
  private final TextView gMv;
  private final ImageView gxs;
  private final RecyclerView iQe;
  private int inputType;
  private final Runnable lzz;
  private final TextView sHE;
  private final FrameLayout sMg;
  private final MMEditText sMh;
  private final ImageView sMi;
  private final TextView sMj;
  final f sMk;
  private final View sMl;
  private final View sMm;
  private boolean sMn;
  private int sMo;
  private boolean sMp;
  private final int sMq;
  private final int sMr;
  private m<? super String, ? super Boolean, y> sMs;
  private m<? super com.tencent.mm.plugin.story.model.b.a, ? super Boolean, y> sMt;
  
  static
  {
    AppMethodBeat.i(110403);
    sMu = new StoryCommentInputView.a((byte)0);
    AppMethodBeat.o(110403);
  }
  
  public StoryCommentInputView(Context paramContext)
  {
    this(paramContext, null);
    AppMethodBeat.i(110402);
    AppMethodBeat.o(110402);
  }
  
  public StoryCommentInputView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(110401);
    AppMethodBeat.o(110401);
  }
  
  public StoryCommentInputView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(110400);
    this.TAG = "MicroMsg.StoryCommentInputView";
    View.inflate(paramContext, 2130970935, (ViewGroup)this);
    setClickable(true);
    paramAttributeSet = findViewById(2131828314);
    a.f.b.j.p(paramAttributeSet, "findViewById(R.id.story_comment_emoji_root)");
    this.sMg = ((FrameLayout)paramAttributeSet);
    paramAttributeSet = findViewById(2131828310);
    a.f.b.j.p(paramAttributeSet, "findViewById(R.id.story_comment_input)");
    this.sMh = ((MMEditText)paramAttributeSet);
    paramAttributeSet = findViewById(2131828312);
    a.f.b.j.p(paramAttributeSet, "findViewById(R.id.story_comment_emoji_btn)");
    this.sMi = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131828308);
    a.f.b.j.p(paramAttributeSet, "findViewById(R.id.story_comment_input_avatar)");
    this.gxs = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131828309);
    a.f.b.j.p(paramAttributeSet, "findViewById(R.id.story_comment_input_username)");
    this.sHE = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(2131828311);
    a.f.b.j.p(paramAttributeSet, "findViewById(R.id.story_comment_input_limit)");
    this.sMj = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(2131828306);
    a.f.b.j.p(paramAttributeSet, "findViewById(R.id.story_comment_input_hint)");
    this.gMv = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(2131828315);
    a.f.b.j.p(paramAttributeSet, "findViewById(R.id.story_comment_input_recycler)");
    this.iQe = ((RecyclerView)paramAttributeSet);
    paramAttributeSet = findViewById(2131828307);
    a.f.b.j.p(paramAttributeSet, "findViewById(R.id.story_comment_input_root)");
    this.sMl = paramAttributeSet;
    paramAttributeSet = findViewById(2131828305);
    a.f.b.j.p(paramAttributeSet, "findViewById(R.id.story_…ent_input_footer_content)");
    this.sMm = paramAttributeSet;
    this.sMk = new f();
    this.iQe.setLayoutManager((RecyclerView.i)new LinearLayoutManager());
    this.iQe.setAdapter((RecyclerView.a)this.sMk);
    this.iQe.setVisibility(8);
    this.iQe.setFocusable(false);
    this.sMk.sIx = ((a.f.a.a)new StoryCommentInputView.1(this));
    this.sMk.sIw = ((m)new StoryCommentInputView.2(this, paramContext));
    this.sMq = getResources().getColor(2131690553);
    this.sMr = getResources().getColor(2131689604);
    paramAttributeSet = this.gxs;
    Object localObject = com.tencent.mm.plugin.story.model.j.svi;
    a.b.s(paramAttributeSet, j.b.coK());
    paramAttributeSet = u.j(paramContext, true);
    a.f.b.j.p(paramAttributeSet, "SmileyPanelFactory.getSmileyPanel(context, true)");
    this.eys = ((ChatFooterPanel)paramAttributeSet);
    this.sMo = x.gL(getContext());
    paramAttributeSet = new FrameLayout.LayoutParams(-1, this.sMo);
    this.sMg.addView((View)this.eys, (ViewGroup.LayoutParams)paramAttributeSet);
    this.eys.setPortHeightPx(this.sMo);
    this.eys.setEntranceScene(ChatFooterPanel.vQq);
    this.eys.Az();
    this.eys.bo(false);
    this.eys.setVisibility(0);
    this.eys.AB();
    this.eys.onResume();
    this.eys.setOnTextOperationListener((ChatFooterPanel.a)new StoryCommentInputView.b(this));
    this.sMh.addTextChangedListener((TextWatcher)new StoryCommentInputView.3(this));
    this.sMl.setOnClickListener((View.OnClickListener)new StoryCommentInputView.4(this, paramContext));
    this.sMi.setOnClickListener((View.OnClickListener)new StoryCommentInputView.5(this, paramContext));
    this.sMh.setOnEditorActionListener((TextView.OnEditorActionListener)new StoryCommentInputView.6(this));
    setOnClickListener((View.OnClickListener)new StoryCommentInputView.7(this));
    this.sMi.setImageDrawable(aj.g(paramContext, 2131231476, -1));
    this.sMg.setVisibility(0);
    this.sMp = false;
    paramAttributeSet = this.sHE;
    localObject = g.RL();
    a.f.b.j.p(localObject, "storage()");
    localObject = ((e)localObject).Ru().get(4);
    if (localObject == null)
    {
      paramContext = new v("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(110400);
      throw paramContext;
    }
    paramAttributeSet.setText((CharSequence)com.tencent.mm.pluginsdk.ui.d.j.b(paramContext, (CharSequence)localObject, this.sHE.getTextSize()));
    this.inputType = 2;
    this.lzz = ((Runnable)new StoryCommentInputView.d(this));
    AppMethodBeat.o(110400);
  }
  
  private final void setKeyboardVisibility(boolean paramBoolean)
  {
    AppMethodBeat.i(110397);
    if (paramBoolean)
    {
      post(this.lzz);
      AppMethodBeat.o(110397);
      return;
    }
    removeCallbacks(this.lzz);
    InputMethodManager localInputMethodManager = (InputMethodManager)getContext().getSystemService("input_method");
    if (localInputMethodManager != null)
    {
      localInputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
      AppMethodBeat.o(110397);
      return;
    }
    AppMethodBeat.o(110397);
  }
  
  public final void a(CharSequence paramCharSequence, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(151174);
    a.f.b.j.q(paramString, "toUser");
    this.sMh.setText((CharSequence)com.tencent.mm.pluginsdk.ui.d.j.b(getContext(), paramCharSequence, this.sMh.getTextSize()));
    if (paramCharSequence != null) {
      this.sMh.setSelection(paramCharSequence.length());
    }
    Object localObject2;
    Object localObject1;
    if (paramBoolean)
    {
      localObject2 = getResources().getString(2131304192);
      a.f.b.j.p(localObject2, "resources.getString(R.st…story_reply_visible_hint)");
      localObject1 = getResources().getString(2131304191);
      a.f.b.j.p(localObject1, "resources.getString(R.st…_reply_visible_edit_hint)");
      paramCharSequence = g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class);
      a.f.b.j.p(paramCharSequence, "MMKernel.service(IMessengerStorage::class.java)");
      paramCharSequence = ((com.tencent.mm.plugin.messenger.foundation.a.j)paramCharSequence).YA().arw(paramString);
      paramString = new StringBuilder().append(getResources().getString(2131304191)).append(' ');
      Context localContext = this.sHE.getContext();
      if (paramCharSequence != null)
      {
        paramCharSequence = paramCharSequence.Of();
        if (paramCharSequence != null)
        {
          paramCharSequence = (CharSequence)paramCharSequence;
          paramString = com.tencent.mm.pluginsdk.ui.d.j.b(localContext, paramCharSequence, this.sHE.getTextSize());
          paramCharSequence = (CharSequence)localObject1;
          localObject1 = paramString;
          paramString = (String)localObject2;
        }
      }
    }
    for (;;)
    {
      this.sMh.setHint((CharSequence)paramCharSequence);
      this.gMv.setText((CharSequence)paramString);
      this.sHE.setText((CharSequence)localObject1);
      AppMethodBeat.o(151174);
      return;
      paramCharSequence = (CharSequence)"";
      break;
      paramString = getResources().getString(2131304126);
      a.f.b.j.p(paramString, "resources.getString(R.st…ory_comment_visible_hint)");
      paramCharSequence = getResources().getString(2131304125);
      a.f.b.j.p(paramCharSequence, "resources.getString(R.st…omment_visible_edit_hint)");
      localObject1 = getContext();
      localObject2 = g.RL();
      a.f.b.j.p(localObject2, "storage()");
      localObject2 = ((e)localObject2).Ru().get(4);
      if (localObject2 == null)
      {
        paramCharSequence = new v("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(151174);
        throw paramCharSequence;
      }
      localObject1 = String.valueOf(com.tencent.mm.pluginsdk.ui.d.j.b((Context)localObject1, (CharSequence)localObject2, this.sHE.getTextSize()));
    }
  }
  
  public final void bJ(int paramInt)
  {
    AppMethodBeat.i(151177);
    this.iQe.post((Runnable)new StoryCommentInputView.c(this, paramInt));
    AppMethodBeat.o(151177);
  }
  
  public final void cFw()
  {
    AppMethodBeat.i(151178);
    this.iQe.setVisibility(0);
    AppMethodBeat.o(151178);
  }
  
  public final void dJ(List<com.tencent.mm.plugin.story.model.b.a> paramList)
  {
    AppMethodBeat.i(151176);
    a.f.b.j.q(paramList, "storyComments");
    this.sMk.dH(paramList);
    AppMethodBeat.o(151176);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(151179);
    this.sMk.dH((List)new ArrayList());
    this.sMk.notifyDataSetChanged();
    this.eys.destroy();
    AppMethodBeat.o(151179);
  }
  
  public final m<String, Boolean, y> getCommentInputCallback()
  {
    return this.sMs;
  }
  
  public final m<com.tencent.mm.plugin.story.model.b.a, Boolean, y> getCommentReplyCallback()
  {
    return this.sMt;
  }
  
  public final CharSequence getContent()
  {
    AppMethodBeat.i(110396);
    Object localObject = this.sMh.getText();
    if (localObject != null) {}
    for (localObject = localObject.toString();; localObject = null)
    {
      localObject = (CharSequence)localObject;
      AppMethodBeat.o(110396);
      return localObject;
    }
  }
  
  public final void p(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(110398);
    super.p(paramBoolean, paramInt);
    this.sMn = paramBoolean;
    if (paramBoolean)
    {
      this.inputType = 2;
      this.sMg.setVisibility(4);
    }
    for (;;)
    {
      if ((this.sMo != paramInt) && (paramInt != 0))
      {
        this.sMo = paramInt;
        com.tencent.mm.compatible.util.j.z(getContext(), paramInt);
        paramInt = x.gL(getContext());
        this.eys.setPortHeightPx(paramInt);
        this.eys.AD();
        ViewGroup.LayoutParams localLayoutParams = this.eys.getLayoutParams();
        if (localLayoutParams != null) {
          localLayoutParams.height = paramInt;
        }
      }
      AppMethodBeat.o(110398);
      return;
      if (this.inputType == 0)
      {
        this.sMg.setVisibility(0);
      }
      else
      {
        this.sMg.setVisibility(8);
        this.inputType = -1;
      }
    }
  }
  
  public final void setCommentInputCallback(m<? super String, ? super Boolean, y> paramm)
  {
    this.sMs = paramm;
  }
  
  public final void setCommentReplyCallback(m<? super com.tencent.mm.plugin.story.model.b.a, ? super Boolean, y> paramm)
  {
    this.sMt = paramm;
  }
  
  public final void setHostStory(com.tencent.mm.plugin.story.h.j paramj)
  {
    this.sMk.sIv = paramj;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(110399);
    super.setVisibility(paramInt);
    if (paramInt == 0) {
      this.sMh.requestFocus();
    }
    AppMethodBeat.o(110399);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.StoryCommentInputView
 * JD-Core Version:    0.7.0.1
 */