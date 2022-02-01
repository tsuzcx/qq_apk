package com.tencent.mm.plugin.story.ui.view;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.LayerDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.g.b.a.jn;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.widget.a.f.c;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/ui/view/StoryCommentView;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/plugin/story/contract/CommentContract$IView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "avatarConfetti", "Lcom/tencent/mm/particles/ConfettiManager;", "avatarConfettiIndex", "avatarGenerator", "Lcom/tencent/mm/particles/ConfettiGenerator;", "avatarMap", "Ljava/util/LinkedHashMap;", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "Landroid/graphics/drawable/LayerDrawable;", "Lkotlin/collections/LinkedHashMap;", "commentAdapter", "Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter;", "commentClickHelper", "Lcom/tencent/mm/plugin/story/ui/view/ViewClickHelper;", "commentData", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryComment;", "commentDialog", "Lcom/tencent/mm/plugin/story/ui/view/CommentInputDialog;", "commentHint", "Landroid/widget/TextView;", "commentInputCallback", "Lkotlin/Function2;", "", "", "", "commentInputSuccess", "commentOtherGroup", "Landroid/view/View;", "commentOthersBubbleIv", "Lcom/tencent/mm/plugin/story/ui/view/StoryCommentBubbleView;", "commentOthersInputIv", "commentRecycler", "Landroid/support/v7/widget/RecyclerView;", "commentSelfActionIv", "commentSelfGroup", "contentView", "currState", "generator", "hasConfetti", "hideHintRunnable", "Ljava/lang/Runnable;", "isActive", "isBubbled", "isContact", "isReply", "isSelf", "itemContainer", "Lcom/tencent/mm/plugin/story/ui/view/CommentsContainer;", "maskView", "outsideClickListener", "Lkotlin/Function0;", "getOutsideClickListener", "()Lkotlin/jvm/functions/Function0;", "setOutsideClickListener", "(Lkotlin/jvm/functions/Function0;)V", "penddingState", "replyCommentId", "replyIndex", "replyInputCallback", "saveContent", "", "saveReplyContentCache", "sessionId", "getSessionId", "()Ljava/lang/String;", "setSessionId", "(Ljava/lang/String;)V", "smallConfetti", "smallGenerator", "stateChangeCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "state", "getStateChangeCallback", "()Lkotlin/jvm/functions/Function1;", "setStateChangeCallback", "(Lkotlin/jvm/functions/Function1;)V", "storyId", "", "storyOwner", "toUser", "deleteComment", "comment", "destroy", "emitClickBubble", "hide", "hideItemContainer", "onBack", "pause", "postBubble", "isBtn", "resume", "saveReplyContent", "setup", "scene", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItemScene;", "story", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "show", "showBubbleHint", "showItemContainer", "switchImageMode", "switchState", "switchVideoMode", "toggleActiveState", "active", "Companion", "plugin-story_release"})
public final class StoryCommentView
  extends RelativeLayout
{
  private static final int[] Cdb;
  public static final StoryCommentView.a FCD;
  public static final String TAG = "MicroMsg.StoryCommentView";
  public final com.tencent.mm.plugin.story.ui.a.e FBS;
  private final m<String, Boolean, x> FBY;
  private kotlin.g.a.b<? super Integer, x> FCA;
  private kotlin.g.a.a<Boolean> FCB;
  private final m<com.tencent.mm.plugin.story.f.b.a, Boolean, x> FCC;
  public final CommentsContainer FCc;
  private final TextView FCd;
  private final StoryCommentBubbleView FCe;
  private final StoryCommentBubbleView FCf;
  private final StoryCommentBubbleView FCg;
  public final View FCh;
  public final View FCi;
  public boolean FCj;
  public com.tencent.mm.plugin.story.f.d.g FCk;
  public int FCl;
  public boolean FCm;
  public c FCn;
  private boolean FCo;
  private boolean FCp;
  public CharSequence FCq;
  public LinkedHashMap<String, CharSequence> FCr;
  private final com.tencent.mm.particles.b FCs;
  private final com.tencent.mm.particles.b FCt;
  private com.tencent.mm.particles.b FCu;
  private boolean FCv;
  private int FCw;
  private int FCx;
  public final LinkedHashMap<com.tencent.mm.plugin.story.f.b.a, LayerDrawable> FCy;
  public final g FCz;
  public String Foa;
  public int Fob;
  private final RecyclerView FwW;
  public final View contentView;
  public boolean dJM;
  public long edx;
  public int iFU;
  public boolean isActive;
  private final View maskView;
  private final Runnable rtb;
  private String sessionId;
  public String toUser;
  
  static
  {
    AppMethodBeat.i(120165);
    FCD = new StoryCommentView.a((byte)0);
    TAG = "MicroMsg.StoryCommentView";
    Cdb = new int[] { -372399, -352965, -15616, -7220480, -16268960, -15683841, -15432210, -10197008 };
    AppMethodBeat.o(120165);
  }
  
  public StoryCommentView(Context paramContext)
  {
    this(paramContext, null);
    AppMethodBeat.i(120164);
    AppMethodBeat.o(120164);
  }
  
  public StoryCommentView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(120163);
    AppMethodBeat.o(120163);
  }
  
  public StoryCommentView(final Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(120162);
    this.Foa = "";
    this.FCk = new com.tencent.mm.plugin.story.f.d.g();
    this.iFU = 2;
    this.FCl = 2;
    this.FCr = new LinkedHashMap();
    this.FCv = true;
    this.toUser = "";
    this.FCx = -1;
    this.FCy = new LinkedHashMap();
    View.inflate(paramContext, 2131496584, (ViewGroup)this);
    paramAttributeSet = findViewById(2131308516);
    p.g(paramAttributeSet, "findViewById(R.id.story_comment_item_container)");
    this.FCc = ((CommentsContainer)paramAttributeSet);
    paramAttributeSet = findViewById(2131308530);
    p.g(paramAttributeSet, "findViewById(R.id.story_comment_recycler)");
    this.FwW = ((RecyclerView)paramAttributeSet);
    paramAttributeSet = findViewById(2131308525);
    p.g(paramAttributeSet, "findViewById(R.id.story_comment_mask_view)");
    this.maskView = paramAttributeSet;
    paramAttributeSet = findViewById(2131308504);
    p.g(paramAttributeSet, "findViewById(R.id.story_comment_hint)");
    this.FCd = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(2131308531);
    p.g(paramAttributeSet, "findViewById(R.id.story_comment_root_view)");
    this.contentView = paramAttributeSet;
    paramAttributeSet = findViewById(2131308533);
    p.g(paramAttributeSet, "findViewById(R.id.story_comment_self_bubble_icon)");
    this.FCe = ((StoryCommentBubbleView)paramAttributeSet);
    paramAttributeSet = findViewById(2131308527);
    p.g(paramAttributeSet, "findViewById(R.id.story_…mment_others_bubble_icon)");
    this.FCf = ((StoryCommentBubbleView)paramAttributeSet);
    paramAttributeSet = findViewById(2131308528);
    p.g(paramAttributeSet, "findViewById(R.id.story_…ment_others_comment_icon)");
    this.FCg = ((StoryCommentBubbleView)paramAttributeSet);
    paramAttributeSet = findViewById(2131308532);
    p.g(paramAttributeSet, "findViewById(R.id.story_comment_self_action_group)");
    this.FCh = paramAttributeSet;
    paramAttributeSet = findViewById(2131308526);
    p.g(paramAttributeSet, "findViewById(R.id.story_…ment_others_action_group)");
    this.FCi = paramAttributeSet;
    d.f(this.FCd);
    this.maskView.setVisibility(8);
    this.FCc.setItemClickListener((kotlin.g.a.a)new StoryCommentView.1(this));
    this.FCe.setImageDrawable(ar.m(paramContext, 2131690510, -1));
    this.FCg.setImageDrawable(ar.m(paramContext, 2131690510, -1));
    this.FBS = new com.tencent.mm.plugin.story.ui.a.e();
    this.FwW.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    this.FwW.setAdapter((RecyclerView.a)this.FBS);
    this.FwW.setVisibility(8);
    this.FwW.setFocusable(false);
    this.FBS.FxO = ((kotlin.g.a.a)new StoryCommentView.6(this));
    this.FBS.FxN = ((m)new q(paramContext) {});
    paramAttributeSet = BitmapFactory.decodeResource(getResources(), 2131235116);
    paramInt = com.tencent.mm.cb.a.fromDPToPix(paramContext, 48);
    paramAttributeSet = Bitmap.createScaledBitmap(paramAttributeSet, paramInt, paramInt, true);
    this.FCs = ((com.tencent.mm.particles.b)new StoryCommentView.8(paramAttributeSet));
    this.FCt = ((com.tencent.mm.particles.b)new StoryCommentView.9(paramAttributeSet));
    this.FCu = ((com.tencent.mm.particles.b)new StoryCommentView.10(this, paramContext));
    this.rtb = ((Runnable)new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(120144);
        StoryCommentView.m(this.FCE).animate().cancel();
        StoryCommentView.m(this.FCE).animate().alpha(0.0F).withEndAction((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(120143);
            StoryCommentView.m(this.FCH.FCE).setVisibility(8);
            AppMethodBeat.o(120143);
          }
        }).start();
        AppMethodBeat.o(120144);
      }
    });
    this.FCe.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120145);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/StoryCommentView$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (!StoryCommentView.c(this.FCE).commentList.isEmpty())
        {
          if (StoryCommentView.a(this.FCE) != 3) {
            break label95;
          }
          this.FCE.xN(2);
          paramAnonymousView = h.FuH;
          h.aaT(1);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/StoryCommentView$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(120145);
          return;
          label95:
          this.FCE.xN(3);
          paramAnonymousView = h.FuH;
          h.aaT(2);
          paramAnonymousView = h.FuH;
          h.fqm().sj(4L);
          paramAnonymousView = h.FuH;
          h.fqm().wR(String.valueOf(StoryCommentView.n(this.FCE)));
          paramAnonymousView = h.FuH;
          h.fqn();
        }
      }
    });
    this.FCf.setOnClickListener((View.OnClickListener)new StoryCommentView.13(this));
    this.FCg.setOnClickListener((View.OnClickListener)new StoryCommentView.2(this));
    this.FCz = new g((View)this);
    this.FCz.FEm = ((kotlin.g.a.b)new StoryCommentView.3(this));
    setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120135);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/StoryCommentView$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = StoryCommentView.o(this.FCE);
        paramAnonymousView.ipv = true;
        paramAnonymousView.FEp += 1;
        int i;
        if ((paramAnonymousView.FEp == 1) && (paramAnonymousView.FEn == null) && (paramAnonymousView.FEo == null)) {
          i = 1;
        }
        for (;;)
        {
          if (i != 0) {
            paramAnonymousView.fsj();
          }
          MMHandlerThread.removeRunnable(paramAnonymousView.FEr);
          MMHandlerThread.postToMainThreadDelayed(paramAnonymousView.FEr, paramAnonymousView.FEq);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/StoryCommentView$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(120135);
          return;
          if ((paramAnonymousView.FEp == 2) && (paramAnonymousView.FEo == null)) {
            i = 1;
          } else if (paramAnonymousView.FEp == 3) {
            i = 1;
          } else {
            i = 0;
          }
        }
      }
    });
    setOnLongClickListener((View.OnLongClickListener)new StoryCommentView.5(this));
    paramInt = au.aD(paramContext);
    Log.i(TAG, "LogStory: navigationHeight ".concat(String.valueOf(paramInt)));
    findViewById(2131308499).setPadding(0, 0, 0, paramInt);
    this.FBY = ((m)new b(this));
    this.FCC = ((m)new c(this, paramContext));
    AppMethodBeat.o(120162);
  }
  
  public final kotlin.g.a.a<Boolean> getOutsideClickListener()
  {
    return this.FCB;
  }
  
  public final String getSessionId()
  {
    return this.sessionId;
  }
  
  public final kotlin.g.a.b<Integer, x> getStateChangeCallback()
  {
    return this.FCA;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(120160);
    this.FCc.pause();
    this.contentView.setVisibility(8);
    AppMethodBeat.o(120160);
  }
  
  public final void setOutsideClickListener(kotlin.g.a.a<Boolean> parama)
  {
    this.FCB = parama;
  }
  
  public final void setSessionId(String paramString)
  {
    this.sessionId = paramString;
  }
  
  public final void setStateChangeCallback(kotlin.g.a.b<? super Integer, x> paramb)
  {
    this.FCA = paramb;
  }
  
  public final void show()
  {
    AppMethodBeat.i(120159);
    this.contentView.setVisibility(0);
    Object localObject;
    if (this.FCl == 2)
    {
      if ((this.contentView.getVisibility() == 0) && (this.iFU == 2) && (this.FCc.dLD))
      {
        this.FCk.FnW = false;
        this.FCc.resume();
        if ((!this.dJM) && (this.FCj))
        {
          localObject = com.tencent.mm.kernel.g.aAh();
          p.g(localObject, "storage()");
          int i = ((com.tencent.mm.kernel.e)localObject).azQ().getInt(ar.a.Oiu, 0);
          if (i < 3)
          {
            localObject = com.tencent.mm.kernel.g.aAh();
            p.g(localObject, "storage()");
            ((com.tencent.mm.kernel.e)localObject).azQ().set(ar.a.Oiu, Integer.valueOf(i + 1));
            this.FCd.animate().cancel();
            this.FCd.setVisibility(0);
            this.FCd.animate().alpha(1.0F).start();
            MMHandlerThread.removeRunnable(this.rtb);
            MMHandlerThread.postToMainThreadDelayed(this.rtb, 3000L);
          }
        }
      }
      AppMethodBeat.o(120159);
      return;
    }
    if (this.FCl == 3)
    {
      xN(3);
      localObject = this.FwW.getLayoutManager();
      if (localObject != null)
      {
        com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(this.FCk.commentList.size() - 1, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.axQ(), "com/tencent/mm/plugin/story/ui/view/StoryCommentView", "show", "()V", "Undefined", "scrollToPosition", "(I)V");
        ((RecyclerView.LayoutManager)localObject).scrollToPosition(((Integer)locala.pG(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/story/ui/view/StoryCommentView", "show", "()V", "Undefined", "scrollToPosition", "(I)V");
        AppMethodBeat.o(120159);
        return;
      }
    }
    AppMethodBeat.o(120159);
  }
  
  public final void xN(int paramInt)
  {
    AppMethodBeat.i(120161);
    Log.i(TAG, "switchState " + paramInt + ' ' + Util.getStack());
    if (this.iFU == paramInt)
    {
      AppMethodBeat.o(120161);
      return;
    }
    this.iFU = paramInt;
    this.FCl = paramInt;
    switch (paramInt)
    {
    }
    for (;;)
    {
      Object localObject = this.FCA;
      if (localObject == null) {
        break;
      }
      ((kotlin.g.a.b)localObject).invoke(Integer.valueOf(this.iFU));
      AppMethodBeat.o(120161);
      return;
      this.toUser = this.Foa;
      this.Fob = 0;
      this.FCc.pause();
      this.FwW.setVisibility(8);
      this.FCc.setVisibility(8);
      this.FCp = false;
      localObject = getContext();
      p.g(localObject, "context");
      this.FCn = new c((Context)localObject);
      localObject = this.FCn;
      if (localObject != null)
      {
        localObject = ((c)localObject).FAE;
        if (localObject != null) {
          ((StoryCommentInputView)localObject).setHostStory(this.FBS.FxM);
        }
      }
      localObject = this.FCn;
      if (localObject != null)
      {
        localObject = ((c)localObject).FAE;
        if (localObject != null) {
          ((StoryCommentInputView)localObject).setCommentInputCallback(this.FBY);
        }
      }
      localObject = this.FCn;
      if (localObject != null)
      {
        localObject = ((c)localObject).FAE;
        if (localObject != null) {
          ((StoryCommentInputView)localObject).setCommentReplyCallback(this.FCC);
        }
      }
      localObject = this.FCn;
      if (localObject != null)
      {
        localObject = ((c)localObject).FAE;
        if (localObject != null) {
          StoryCommentInputView.a((StoryCommentInputView)localObject, this.FCq);
        }
      }
      localObject = this.FCn;
      if (localObject != null)
      {
        localObject = ((c)localObject).FAE;
        if (localObject != null) {
          ((StoryCommentInputView)localObject).frZ();
        }
      }
      localObject = this.FCn;
      if (localObject != null)
      {
        localObject = ((c)localObject).FAE;
        if (localObject != null) {
          ((StoryCommentInputView)localObject).aj((List)this.FCk.commentList);
        }
      }
      localObject = this.FCn;
      if (localObject != null)
      {
        localObject = ((c)localObject).FAE;
        if (localObject != null) {
          ((StoryCommentInputView)localObject).FBS.notifyDataSetChanged();
        }
      }
      localObject = this.FCn;
      com.tencent.mm.hellhoundlib.b.a locala;
      if (localObject != null)
      {
        localObject = ((c)localObject).FAE;
        if (localObject != null)
        {
          locala = com.tencent.mm.hellhoundlib.b.c.a(this.FCk.commentList.size() - 1, new com.tencent.mm.hellhoundlib.b.a());
          com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.axQ(), "com/tencent/mm/plugin/story/ui/view/StoryCommentView", "switchState", "(I)V", "Undefined", "scrollToPosition", "(I)V");
          ((StoryCommentInputView)localObject).scrollToPosition(((Integer)locala.pG(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/story/ui/view/StoryCommentView", "switchState", "(I)V", "Undefined", "scrollToPosition", "(I)V");
        }
      }
      localObject = this.FCn;
      if (localObject != null) {
        ((c)localObject).show();
      }
      this.FCo = false;
      localObject = this.FCn;
      if (localObject != null)
      {
        ((c)localObject).setOnDismissListener((DialogInterface.OnDismissListener)new f(this));
        continue;
        this.FCc.pause();
        this.FCc.setVisibility(8);
        this.FwW.animate().alpha(0.0F).withEndAction((Runnable)new StoryCommentView.g(this)).start();
        this.FCp = true;
        localObject = getContext();
        p.g(localObject, "context");
        this.FCn = new c((Context)localObject);
        localObject = this.FCn;
        if (localObject != null)
        {
          localObject = ((c)localObject).FAE;
          if (localObject != null) {
            ((StoryCommentInputView)localObject).setHostStory(this.FBS.FxM);
          }
        }
        localObject = this.FCn;
        if (localObject != null)
        {
          localObject = ((c)localObject).FAE;
          if (localObject != null) {
            ((StoryCommentInputView)localObject).setCommentInputCallback(this.FBY);
          }
        }
        localObject = this.FCn;
        if (localObject != null)
        {
          localObject = ((c)localObject).FAE;
          if (localObject != null) {
            ((StoryCommentInputView)localObject).setCommentReplyCallback(this.FCC);
          }
        }
        localObject = this.FCn;
        if (localObject != null)
        {
          localObject = ((c)localObject).FAE;
          if (localObject != null) {
            ((StoryCommentInputView)localObject).a((CharSequence)this.FCr.get(this.toUser), this.toUser, true);
          }
        }
        localObject = this.FCn;
        if (localObject != null)
        {
          localObject = ((c)localObject).FAE;
          if (localObject != null) {
            ((StoryCommentInputView)localObject).frZ();
          }
        }
        localObject = this.FCn;
        if (localObject != null)
        {
          localObject = ((c)localObject).FAE;
          if (localObject != null) {
            ((StoryCommentInputView)localObject).aj((List)this.FCk.commentList);
          }
        }
        localObject = this.FCn;
        if (localObject != null)
        {
          localObject = ((c)localObject).FAE;
          if (localObject != null) {
            ((StoryCommentInputView)localObject).FBS.notifyDataSetChanged();
          }
        }
        localObject = this.FCn;
        if (localObject != null)
        {
          localObject = ((c)localObject).FAE;
          if (localObject != null)
          {
            locala = com.tencent.mm.hellhoundlib.b.c.a(this.FCx, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.axQ(), "com/tencent/mm/plugin/story/ui/view/StoryCommentView", "switchState", "(I)V", "Undefined", "scrollToPosition", "(I)V");
            ((StoryCommentInputView)localObject).scrollToPosition(((Integer)locala.pG(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/story/ui/view/StoryCommentView", "switchState", "(I)V", "Undefined", "scrollToPosition", "(I)V");
          }
        }
        localObject = this.FCn;
        if (localObject != null) {
          ((c)localObject).show();
        }
        this.FCo = false;
        localObject = this.FCn;
        if (localObject != null)
        {
          ((c)localObject).setOnDismissListener((DialogInterface.OnDismissListener)new h(this));
          continue;
          this.toUser = this.Foa;
          this.Fob = 0;
          if (this.dJM)
          {
            this.FCh.setVisibility(0);
            this.FCi.setVisibility(8);
          }
          for (;;)
          {
            this.maskView.animate().cancel();
            this.maskView.animate().alpha(0.0F).start();
            this.FwW.animate().alpha(0.0F).withEndAction((Runnable)new StoryCommentView.i(this)).start();
            this.FCc.animate().cancel();
            this.FCc.setVisibility(0);
            this.FCc.setAlpha(1.0F);
            if (this.isActive) {
              this.FCc.resume();
            }
            localObject = this.FCn;
            if (localObject == null) {
              break;
            }
            ((c)localObject).dismiss();
            break;
            this.FCh.setVisibility(8);
            this.FCi.setVisibility(0);
          }
          this.toUser = this.Foa;
          this.Fob = 0;
          this.maskView.animate().cancel();
          this.maskView.setVisibility(0);
          this.maskView.animate().alpha(1.0F).start();
          this.FCc.animate().alpha(0.0F).withEndAction((Runnable)new StoryCommentView.j(this)).start();
          this.FwW.animate().cancel();
          this.FwW.setVisibility(0);
          this.FwW.setAlpha(1.0F);
          this.FBS.hw((List)this.FCk.commentList);
          this.FBS.notifyDataSetChanged();
          this.FBS.FxL = true;
          this.FwW.setAdapter((RecyclerView.a)this.FBS);
          localObject = this.FwW;
          locala = com.tencent.mm.hellhoundlib.b.c.a(this.FCk.commentList.size() - 1, new com.tencent.mm.hellhoundlib.b.a());
          com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.axQ(), "com/tencent/mm/plugin/story/ui/view/StoryCommentView", "switchState", "(I)V", "Undefined", "scrollToPosition", "(I)V");
          ((RecyclerView)localObject).scrollToPosition(((Integer)locala.pG(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/story/ui/view/StoryCommentView", "switchState", "(I)V", "Undefined", "scrollToPosition", "(I)V");
          this.FwW.post((Runnable)new StoryCommentView.k(this));
        }
      }
    }
    AppMethodBeat.o(120161);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "content", "", "success", "", "invoke"})
  static final class b
    extends q
    implements m<String, Boolean, x>
  {
    b(StoryCommentView paramStoryCommentView)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "comment", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "isReply", "", "invoke"})
  static final class c
    extends q
    implements m<com.tencent.mm.plugin.story.f.b.a, Boolean, x>
  {
    c(StoryCommentView paramStoryCommentView, Context paramContext)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
  static final class f
    implements DialogInterface.OnDismissListener
  {
    f(StoryCommentView paramStoryCommentView) {}
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(120153);
      this.FCE.xN(2);
      StoryCommentView localStoryCommentView;
      if (!StoryCommentView.d(this.FCE))
      {
        localStoryCommentView = this.FCE;
        paramDialogInterface = StoryCommentView.e(this.FCE);
        if (paramDialogInterface == null) {
          break label90;
        }
        paramDialogInterface = paramDialogInterface.FAE;
        if (paramDialogInterface == null) {
          break label90;
        }
      }
      label90:
      for (paramDialogInterface = paramDialogInterface.getContent();; paramDialogInterface = null)
      {
        StoryCommentView.a(localStoryCommentView, paramDialogInterface);
        paramDialogInterface = StoryCommentView.e(this.FCE);
        if (paramDialogInterface == null) {
          break;
        }
        paramDialogInterface = paramDialogInterface.FAE;
        if (paramDialogInterface == null) {
          break;
        }
        paramDialogInterface.destroy();
        AppMethodBeat.o(120153);
        return;
      }
      AppMethodBeat.o(120153);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
  static final class h
    implements DialogInterface.OnDismissListener
  {
    h(StoryCommentView paramStoryCommentView) {}
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(120155);
      if (!StoryCommentView.d(this.FCE)) {
        StoryCommentView.g(this.FCE);
      }
      this.FCE.xN(2);
      paramDialogInterface = StoryCommentView.e(this.FCE);
      if (paramDialogInterface != null)
      {
        paramDialogInterface = paramDialogInterface.FAE;
        if (paramDialogInterface != null)
        {
          paramDialogInterface.destroy();
          AppMethodBeat.o(120155);
          return;
        }
      }
      AppMethodBeat.o(120155);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.StoryCommentView
 * JD-Core Version:    0.7.0.1
 */