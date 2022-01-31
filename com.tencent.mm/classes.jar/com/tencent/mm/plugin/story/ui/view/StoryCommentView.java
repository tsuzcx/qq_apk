package com.tencent.mm.plugin.story.ui.view;

import a.f.a.m;
import a.f.b.j;
import a.l;
import a.y;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.LayerDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.i;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.am;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/view/StoryCommentView;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/plugin/story/contract/CommentContract$IView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "avatarConfetti", "Lcom/tencent/mm/particles/ConfettiManager;", "avatarConfettiIndex", "avatarGenerator", "Lcom/tencent/mm/particles/ConfettiGenerator;", "avatarMap", "Ljava/util/LinkedHashMap;", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "Landroid/graphics/drawable/LayerDrawable;", "Lkotlin/collections/LinkedHashMap;", "commentAdapter", "Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter;", "commentClickHelper", "Lcom/tencent/mm/plugin/story/ui/view/ViewClickHelper;", "commentData", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryComment;", "commentDialog", "Lcom/tencent/mm/plugin/story/ui/view/CommentInputDialog;", "commentHint", "Landroid/widget/TextView;", "commentInputCallback", "Lkotlin/Function2;", "", "", "", "commentInputSuccess", "commentOtherGroup", "Landroid/view/View;", "commentOthersBubbleIv", "Lcom/tencent/mm/plugin/story/ui/view/StoryCommentBubbleView;", "commentOthersInputIv", "commentRecycler", "Landroid/support/v7/widget/RecyclerView;", "commentSelfActionIv", "commentSelfGroup", "contentView", "currState", "generator", "hasConfetti", "hideHintRunnable", "Ljava/lang/Runnable;", "isActive", "isBubbled", "isContact", "isReply", "isSelf", "itemContainer", "Lcom/tencent/mm/plugin/story/ui/view/CommentsContainer;", "maskView", "outsideClickListener", "Lkotlin/Function0;", "getOutsideClickListener", "()Lkotlin/jvm/functions/Function0;", "setOutsideClickListener", "(Lkotlin/jvm/functions/Function0;)V", "penddingState", "replyCommentId", "replyIndex", "replyInputCallback", "saveContent", "", "saveReplyContentCache", "sessionId", "getSessionId", "()Ljava/lang/String;", "setSessionId", "(Ljava/lang/String;)V", "smallConfetti", "smallGenerator", "stateChangeCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "state", "getStateChangeCallback", "()Lkotlin/jvm/functions/Function1;", "setStateChangeCallback", "(Lkotlin/jvm/functions/Function1;)V", "storyId", "", "storyOwner", "toUser", "deleteComment", "comment", "destroy", "emitClickBubble", "hide", "hideItemContainer", "onBack", "pause", "postBubble", "isBtn", "resume", "saveReplyContent", "setup", "scene", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItemScene;", "story", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "show", "showBubbleHint", "showItemContainer", "switchImageMode", "switchState", "switchVideoMode", "toggleActiveState", "active", "Companion", "plugin-story_release"})
public final class StoryCommentView
  extends RelativeLayout
{
  private static final String TAG = "MicroMsg.StoryCommentView";
  private static final int[] sMX;
  public static final StoryCommentView.a sMY;
  public long cJA;
  private final View contentView;
  private String cpW;
  public boolean ctJ;
  private int fnU;
  public boolean isActive;
  private final View jbK;
  private final Runnable lym;
  private final RecyclerView sHy;
  private final StoryCommentBubbleView sMA;
  public final View sMB;
  public final View sMC;
  public boolean sMD;
  public com.tencent.mm.plugin.story.model.d.f sME;
  public int sMF;
  public boolean sMG;
  private c sMH;
  private boolean sMI;
  private boolean sMJ;
  public CharSequence sMK;
  public LinkedHashMap<String, CharSequence> sML;
  private final com.tencent.mm.particles.b sMM;
  private final com.tencent.mm.particles.b sMN;
  private com.tencent.mm.particles.b sMO;
  private boolean sMP;
  private int sMQ;
  private int sMR;
  private final LinkedHashMap<com.tencent.mm.plugin.story.model.b.a, LayerDrawable> sMS;
  public final h sMT;
  private a.f.a.b<? super Integer, y> sMU;
  private a.f.a.a<Boolean> sMV;
  private final m<com.tencent.mm.plugin.story.model.b.a, Boolean, y> sMW;
  public final com.tencent.mm.plugin.story.ui.a.f sMk;
  private final m<String, Boolean, y> sMs;
  public final CommentsContainer sMw;
  private final TextView sMx;
  private final StoryCommentBubbleView sMy;
  private final StoryCommentBubbleView sMz;
  public String sxC;
  public int sxD;
  public String toUser;
  
  static
  {
    AppMethodBeat.i(110437);
    sMY = new StoryCommentView.a((byte)0);
    TAG = "MicroMsg.StoryCommentView";
    sMX = new int[] { -372399, -352965, -15616, -7220480, -16268960, -15683841, -15432210, -10197008 };
    AppMethodBeat.o(110437);
  }
  
  public StoryCommentView(Context paramContext)
  {
    this(paramContext, null);
    AppMethodBeat.i(110436);
    AppMethodBeat.o(110436);
  }
  
  public StoryCommentView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(110435);
    AppMethodBeat.o(110435);
  }
  
  public StoryCommentView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(110434);
    this.sxC = "";
    this.sME = new com.tencent.mm.plugin.story.model.d.f();
    this.fnU = 2;
    this.sMF = 2;
    this.sML = new LinkedHashMap();
    this.sMP = true;
    this.toUser = "";
    this.sMR = -1;
    this.sMS = new LinkedHashMap();
    View.inflate(paramContext, 2130970941, (ViewGroup)this);
    paramAttributeSet = findViewById(2131828332);
    j.p(paramAttributeSet, "findViewById(R.id.story_comment_item_container)");
    this.sMw = ((CommentsContainer)paramAttributeSet);
    paramAttributeSet = findViewById(2131828328);
    j.p(paramAttributeSet, "findViewById(R.id.story_comment_recycler)");
    this.sHy = ((RecyclerView)paramAttributeSet);
    paramAttributeSet = findViewById(2131828330);
    j.p(paramAttributeSet, "findViewById(R.id.story_comment_mask_view)");
    this.jbK = paramAttributeSet;
    paramAttributeSet = findViewById(2131828339);
    j.p(paramAttributeSet, "findViewById(R.id.story_comment_hint)");
    this.sMx = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(2131828329);
    j.p(paramAttributeSet, "findViewById(R.id.story_comment_root_view)");
    this.contentView = paramAttributeSet;
    paramAttributeSet = findViewById(2131828338);
    j.p(paramAttributeSet, "findViewById(R.id.story_comment_self_bubble_icon)");
    this.sMy = ((StoryCommentBubbleView)paramAttributeSet);
    paramAttributeSet = findViewById(2131828335);
    j.p(paramAttributeSet, "findViewById(R.id.story_…mment_others_bubble_icon)");
    this.sMz = ((StoryCommentBubbleView)paramAttributeSet);
    paramAttributeSet = findViewById(2131828336);
    j.p(paramAttributeSet, "findViewById(R.id.story_…ment_others_comment_icon)");
    this.sMA = ((StoryCommentBubbleView)paramAttributeSet);
    paramAttributeSet = findViewById(2131828337);
    j.p(paramAttributeSet, "findViewById(R.id.story_comment_self_action_group)");
    this.sMB = paramAttributeSet;
    paramAttributeSet = findViewById(2131828334);
    j.p(paramAttributeSet, "findViewById(R.id.story_…ment_others_action_group)");
    this.sMC = paramAttributeSet;
    com.tencent.mm.ab.b.e(this.sMx);
    this.jbK.setVisibility(8);
    this.sMw.setItemClickListener((a.f.a.a)new StoryCommentView.1(this));
    this.sMy.setImageDrawable(aj.g(paramContext, 2131231444, -1));
    this.sMA.setImageDrawable(aj.g(paramContext, 2131231444, -1));
    this.sMk = new com.tencent.mm.plugin.story.ui.a.f();
    this.sHy.setLayoutManager((RecyclerView.i)new LinearLayoutManager());
    this.sHy.setAdapter((RecyclerView.a)this.sMk);
    this.sHy.setVisibility(8);
    this.sHy.setFocusable(false);
    this.sMk.sIx = ((a.f.a.a)new StoryCommentView.6(this));
    this.sMk.sIw = ((m)new StoryCommentView.7(this, paramContext));
    paramAttributeSet = BitmapFactory.decodeResource(getResources(), 2130840467);
    paramInt = com.tencent.mm.cb.a.fromDPToPix(paramContext, 48);
    paramAttributeSet = Bitmap.createScaledBitmap(paramAttributeSet, paramInt, paramInt, true);
    this.sMM = ((com.tencent.mm.particles.b)new StoryCommentView.8(paramAttributeSet));
    this.sMN = ((com.tencent.mm.particles.b)new StoryCommentView.9(paramAttributeSet));
    this.sMO = ((com.tencent.mm.particles.b)new StoryCommentView.10(this, paramContext));
    this.lym = ((Runnable)new StoryCommentView.11(this));
    this.sMy.setOnClickListener((View.OnClickListener)new StoryCommentView.12(this));
    this.sMz.setOnClickListener((View.OnClickListener)new StoryCommentView.13(this));
    this.sMA.setOnClickListener((View.OnClickListener)new StoryCommentView.2(this));
    this.sMT = new h((View)this);
    this.sMT.sNB = ((a.f.a.b)new StoryCommentView.3(this));
    setOnClickListener((View.OnClickListener)new StoryCommentView.4(this));
    setOnLongClickListener((View.OnLongClickListener)new StoryCommentView.5(this));
    paramInt = am.fx(paramContext);
    ab.i(TAG, "LogStory: navigationHeight ".concat(String.valueOf(paramInt)));
    findViewById(2131828331).setPadding(0, 0, 0, paramInt);
    this.sMs = ((m)new StoryCommentView.b(this));
    this.sMW = ((m)new StoryCommentView.c(this, paramContext));
    AppMethodBeat.o(110434);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(138921);
    this.sMw.pause();
    this.sMS.clear();
    this.sML.clear();
    AppMethodBeat.o(138921);
  }
  
  public final a.f.a.a<Boolean> getOutsideClickListener()
  {
    return this.sMV;
  }
  
  public final String getSessionId()
  {
    return this.cpW;
  }
  
  public final a.f.a.b<Integer, y> getStateChangeCallback()
  {
    return this.sMU;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(110425);
    this.sMw.pause();
    this.contentView.setVisibility(8);
    AppMethodBeat.o(110425);
  }
  
  public final void mi(boolean paramBoolean)
  {
    AppMethodBeat.i(138922);
    ab.i(TAG, "toggleActiveState ".concat(String.valueOf(paramBoolean)));
    if (paramBoolean)
    {
      show();
      AppMethodBeat.o(138922);
      return;
    }
    hide();
    AppMethodBeat.o(138922);
  }
  
  public final void oq(int paramInt)
  {
    AppMethodBeat.i(110430);
    ab.i(TAG, "switchState " + paramInt + ' ' + bo.dtY());
    if (this.fnU == paramInt)
    {
      AppMethodBeat.o(110430);
      return;
    }
    this.fnU = paramInt;
    this.sMF = paramInt;
    switch (paramInt)
    {
    }
    for (;;)
    {
      Object localObject = this.sMU;
      if (localObject == null) {
        break;
      }
      ((a.f.a.b)localObject).S(Integer.valueOf(this.fnU));
      AppMethodBeat.o(110430);
      return;
      this.toUser = this.sxC;
      this.sxD = 0;
      this.sMw.pause();
      this.sHy.setVisibility(8);
      this.sMw.setVisibility(8);
      this.sMJ = false;
      localObject = getContext();
      j.p(localObject, "context");
      this.sMH = new c((Context)localObject);
      localObject = this.sMH;
      if (localObject != null)
      {
        localObject = ((c)localObject).sLt;
        if (localObject != null) {
          ((StoryCommentInputView)localObject).setHostStory(this.sMk.sIv);
        }
      }
      localObject = this.sMH;
      if (localObject != null)
      {
        localObject = ((c)localObject).sLt;
        if (localObject != null) {
          ((StoryCommentInputView)localObject).setCommentInputCallback(this.sMs);
        }
      }
      localObject = this.sMH;
      if (localObject != null)
      {
        localObject = ((c)localObject).sLt;
        if (localObject != null) {
          ((StoryCommentInputView)localObject).setCommentReplyCallback(this.sMW);
        }
      }
      localObject = this.sMH;
      if (localObject != null)
      {
        localObject = ((c)localObject).sLt;
        if (localObject != null) {
          StoryCommentInputView.a((StoryCommentInputView)localObject, this.sMK);
        }
      }
      localObject = this.sMH;
      if (localObject != null)
      {
        localObject = ((c)localObject).sLt;
        if (localObject != null) {
          ((StoryCommentInputView)localObject).cFw();
        }
      }
      localObject = this.sMH;
      if (localObject != null)
      {
        localObject = ((c)localObject).sLt;
        if (localObject != null) {
          ((StoryCommentInputView)localObject).dJ((List)this.sME.rPQ);
        }
      }
      localObject = this.sMH;
      if (localObject != null)
      {
        localObject = ((c)localObject).sLt;
        if (localObject != null) {
          ((StoryCommentInputView)localObject).sMk.notifyDataSetChanged();
        }
      }
      localObject = this.sMH;
      if (localObject != null)
      {
        localObject = ((c)localObject).sLt;
        if (localObject != null) {
          ((StoryCommentInputView)localObject).bJ(this.sME.rPQ.size() - 1);
        }
      }
      localObject = this.sMH;
      if (localObject != null) {
        ((c)localObject).show();
      }
      this.sMI = false;
      localObject = this.sMH;
      if (localObject != null)
      {
        ((c)localObject).setOnDismissListener((DialogInterface.OnDismissListener)new StoryCommentView.f(this));
        continue;
        this.sMw.pause();
        this.sMw.setVisibility(8);
        this.sHy.animate().alpha(0.0F).withEndAction((Runnable)new StoryCommentView.g(this)).start();
        this.sMJ = true;
        localObject = getContext();
        j.p(localObject, "context");
        this.sMH = new c((Context)localObject);
        localObject = this.sMH;
        if (localObject != null)
        {
          localObject = ((c)localObject).sLt;
          if (localObject != null) {
            ((StoryCommentInputView)localObject).setHostStory(this.sMk.sIv);
          }
        }
        localObject = this.sMH;
        if (localObject != null)
        {
          localObject = ((c)localObject).sLt;
          if (localObject != null) {
            ((StoryCommentInputView)localObject).setCommentInputCallback(this.sMs);
          }
        }
        localObject = this.sMH;
        if (localObject != null)
        {
          localObject = ((c)localObject).sLt;
          if (localObject != null) {
            ((StoryCommentInputView)localObject).setCommentReplyCallback(this.sMW);
          }
        }
        localObject = this.sMH;
        if (localObject != null)
        {
          localObject = ((c)localObject).sLt;
          if (localObject != null) {
            ((StoryCommentInputView)localObject).a((CharSequence)this.sML.get(this.toUser), this.toUser, true);
          }
        }
        localObject = this.sMH;
        if (localObject != null)
        {
          localObject = ((c)localObject).sLt;
          if (localObject != null) {
            ((StoryCommentInputView)localObject).cFw();
          }
        }
        localObject = this.sMH;
        if (localObject != null)
        {
          localObject = ((c)localObject).sLt;
          if (localObject != null) {
            ((StoryCommentInputView)localObject).dJ((List)this.sME.rPQ);
          }
        }
        localObject = this.sMH;
        if (localObject != null)
        {
          localObject = ((c)localObject).sLt;
          if (localObject != null) {
            ((StoryCommentInputView)localObject).sMk.notifyDataSetChanged();
          }
        }
        localObject = this.sMH;
        if (localObject != null)
        {
          localObject = ((c)localObject).sLt;
          if (localObject != null) {
            ((StoryCommentInputView)localObject).bJ(this.sMR);
          }
        }
        localObject = this.sMH;
        if (localObject != null) {
          ((c)localObject).show();
        }
        this.sMI = false;
        localObject = this.sMH;
        if (localObject != null)
        {
          ((c)localObject).setOnDismissListener((DialogInterface.OnDismissListener)new StoryCommentView.h(this));
          continue;
          this.toUser = this.sxC;
          this.sxD = 0;
          if (this.ctJ)
          {
            this.sMB.setVisibility(0);
            this.sMC.setVisibility(8);
          }
          for (;;)
          {
            this.jbK.animate().cancel();
            this.jbK.animate().alpha(0.0F).start();
            this.sHy.animate().alpha(0.0F).withEndAction((Runnable)new StoryCommentView.i(this)).start();
            this.sMw.animate().cancel();
            this.sMw.setVisibility(0);
            this.sMw.setAlpha(1.0F);
            if (this.isActive) {
              this.sMw.resume();
            }
            localObject = this.sMH;
            if (localObject == null) {
              break;
            }
            ((c)localObject).dismiss();
            break;
            this.sMB.setVisibility(8);
            this.sMC.setVisibility(0);
          }
          this.toUser = this.sxC;
          this.sxD = 0;
          this.jbK.animate().cancel();
          this.jbK.setVisibility(0);
          this.jbK.animate().alpha(1.0F).start();
          this.sMw.animate().alpha(0.0F).withEndAction((Runnable)new StoryCommentView.j(this)).start();
          this.sHy.animate().cancel();
          this.sHy.setVisibility(0);
          this.sHy.setAlpha(1.0F);
          this.sMk.dH((List)this.sME.rPQ);
          this.sMk.notifyDataSetChanged();
          this.sMk.sIu = true;
          this.sHy.setAdapter((RecyclerView.a)this.sMk);
          this.sHy.bJ(this.sME.rPQ.size() - 1);
          this.sHy.post((Runnable)new StoryCommentView.k(this));
        }
      }
    }
    AppMethodBeat.o(110430);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(110428);
    ab.i(TAG, "LogStory: pause");
    this.sMw.pause();
    AppMethodBeat.o(110428);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(110427);
    ab.i(TAG, "LogStory: resume");
    if ((this.contentView.getVisibility() == 0) && (this.fnU == 2) && (this.sMw.cvo)) {
      this.sMw.resume();
    }
    AppMethodBeat.o(110427);
  }
  
  public final void setOutsideClickListener(a.f.a.a<Boolean> parama)
  {
    this.sMV = parama;
  }
  
  public final void setSessionId(String paramString)
  {
    this.cpW = paramString;
  }
  
  public final void setStateChangeCallback(a.f.a.b<? super Integer, y> paramb)
  {
    this.sMU = paramb;
  }
  
  public final void show()
  {
    AppMethodBeat.i(110429);
    this.contentView.setVisibility(0);
    if (this.sMF == 2)
    {
      if ((this.contentView.getVisibility() == 0) && (this.fnU == 2) && (this.sMw.cvo))
      {
        this.sME.sxy = false;
        this.sMw.resume();
        if ((!this.ctJ) && (this.sMD))
        {
          e locale = g.RL();
          j.p(locale, "storage()");
          int i = locale.Ru().getInt(ac.a.yLu, 0);
          if (i < 3)
          {
            locale = g.RL();
            j.p(locale, "storage()");
            locale.Ru().set(ac.a.yLu, Integer.valueOf(i + 1));
            this.sMx.animate().cancel();
            this.sMx.setVisibility(0);
            this.sMx.animate().alpha(1.0F).start();
            al.ae(this.lym);
            al.p(this.lym, 3000L);
          }
        }
      }
      AppMethodBeat.o(110429);
      return;
    }
    if (this.sMF == 3)
    {
      oq(3);
      this.sHy.getLayoutManager().bJ(this.sME.rPQ.size() - 1);
    }
    AppMethodBeat.o(110429);
  }
  
  public final boolean zY()
  {
    AppMethodBeat.i(110426);
    if (this.fnU == 1)
    {
      oq(2);
      AppMethodBeat.o(110426);
      return true;
    }
    if (this.fnU == 3)
    {
      oq(2);
      AppMethodBeat.o(110426);
      return true;
    }
    if (this.fnU == 5)
    {
      oq(2);
      AppMethodBeat.o(110426);
      return true;
    }
    AppMethodBeat.o(110426);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.StoryCommentView
 * JD-Core Version:    0.7.0.1
 */