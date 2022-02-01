package com.tencent.mm.plugin.mv.ui.uic;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.CloseDrawerCallback;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.uniComments.d.a;
import com.tencent.mm.plugin.finder.uniComments.e.a;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.music.model.c;
import com.tencent.mm.plugin.mv.ui.view.d.b;
import com.tencent.mm.plugin.secdata.ui.a.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.dtk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k.b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvInfoUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "drawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "isShowTipsPopupWindow", "Landroidx/lifecycle/MutableLiveData;", "", "()Landroidx/lifecycle/MutableLiveData;", "isShowTipsPopupWindow$delegate", "Lkotlin/Lazy;", "mediaChangeListener", "Lcom/tencent/mm/plugin/thumbplayer/view/OnPlayerChangeMediaListener;", "getMediaChangeListener", "()Lcom/tencent/mm/plugin/thumbplayer/view/OnPlayerChangeMediaListener;", "mvListDialog", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvListDialog;", "refVideoNickNameTvMap", "Ljava/util/HashMap;", "", "Ljava/lang/ref/WeakReference;", "Landroid/widget/TextView;", "Lkotlin/collections/HashMap;", "getRefVideoNickNameTvMap", "()Ljava/util/HashMap;", "tipsPopupWindow", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTipsPopupWindow;", "getTipsPopupWindow", "()Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTipsPopupWindow;", "uinDrawer", "Lcom/tencent/mm/plugin/finder/uniComments/UniCommentComponent;", "addRefVideoNickNameTv", "", "refVideoNickNameTv", "checkDrawerStatus", "enterFinderProfile", "username", "", "isMvMaker", "isMvListDialogShow", "makeSureDrawerInit", "makeSureUniDrawerInit", "onBackPressed", "onCommentClicked", "musicMv", "Lcom/tencent/mm/plugin/mv/model/MusicMv;", "refCommentId", "", "closeCallback", "Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$CloseDrawerCallback;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onUniCommentClick", "Lcom/tencent/mm/plugin/finder/uniComments/UniCommentDrawerContract$CloseDrawerCallback;", "showMvListDialog", "Companion", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends UIComponent
{
  public static final g.a Mel;
  public com.tencent.mm.plugin.finder.view.f ATy;
  public com.tencent.mm.plugin.finder.uniComments.d Mem;
  final com.tencent.mm.plugin.mv.ui.view.b Men;
  public final com.tencent.mm.plugin.mv.ui.view.d Meo;
  private final j Mep;
  final com.tencent.mm.plugin.thumbplayer.view.d Meq;
  public final HashMap<Integer, WeakReference<TextView>> Mer;
  
  static
  {
    AppMethodBeat.i(287696);
    Mel = new g.a((byte)0);
    AppMethodBeat.o(287696);
  }
  
  public g(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(287672);
    this.Men = new com.tencent.mm.plugin.mv.ui.view.b((Context)getContext());
    this.Meo = new com.tencent.mm.plugin.mv.ui.view.d((Context)paramAppCompatActivity, (d.b)new d(paramAppCompatActivity));
    this.Mep = kotlin.k.cm((kotlin.g.a.a)g.b.Mes);
    this.Meq = ((com.tencent.mm.plugin.thumbplayer.view.d)new g.c(this, paramAppCompatActivity));
    this.Mer = new HashMap();
    AppMethodBeat.o(287672);
  }
  
  private final void gqG()
  {
    AppMethodBeat.i(287677);
    if (this.ATy == null)
    {
      Object localObject = com.tencent.mm.plugin.finder.view.f.GxF;
      localObject = (MMFragmentActivity)getActivity();
      View localView = getActivity().getWindow().getDecorView();
      s.s(localView, "activity.window.decorView");
      this.ATy = com.tencent.mm.plugin.finder.view.f.a.a((MMFragmentActivity)localObject, localView, 2, false, 70);
    }
    AppMethodBeat.o(287677);
  }
  
  private final void gqH()
  {
    AppMethodBeat.i(287685);
    if (this.Mem == null)
    {
      Object localObject = com.tencent.mm.plugin.finder.uniComments.d.FYz;
      localObject = (MMFragmentActivity)getActivity();
      View localView = getActivity().getWindow().getDecorView();
      s.s(localView, "activity.window.decorView");
      this.Mem = d.a.a((MMFragmentActivity)localObject, localView);
    }
    AppMethodBeat.o(287685);
  }
  
  public final void a(long paramLong, e.a parama)
  {
    AppMethodBeat.i(287740);
    s.u(parama, "closeCallback");
    Object localObject = com.tencent.mm.ui.component.k.aeZF;
    localObject = com.tencent.mm.ui.component.k.d(getActivity()).q(e.class);
    s.s(localObject, "UICProvider.of(activity)…sicMvDataUIC::class.java)");
    gqH();
    this.Meo.gsf();
    com.tencent.mm.plugin.finder.uniComments.d locald = this.Mem;
    if (locald != null)
    {
      com.tencent.mm.plugin.finder.uniComments.model.b localb = new com.tencent.mm.plugin.finder.uniComments.model.b(((e)localObject).Meg, ((e)localObject).Meh);
      localb.Gbe = ((e)localObject).LWI;
      localb.commentCount = ((e)localObject).commentCount;
      com.tencent.mm.plugin.finder.uniComments.d.a(locald, localb, paramLong, parama);
    }
    AppMethodBeat.o(287740);
  }
  
  public final void a(com.tencent.mm.plugin.mv.model.f paramf, long paramLong, CommentDrawerContract.CloseDrawerCallback paramCloseDrawerCallback)
  {
    AppMethodBeat.i(287726);
    s.u(paramf, "musicMv");
    s.u(paramCloseDrawerCallback, "closeCallback");
    Object localObject1 = com.tencent.mm.plugin.secdata.ui.a.PlI;
    localObject1 = (dtk)a.a.a((Context)getContext(), 7, dtk.class);
    if (localObject1 == null) {}
    for (localObject1 = null;; localObject1 = Integer.valueOf(((dtk)localObject1).aaYX + 1))
    {
      Object localObject2 = com.tencent.mm.plugin.secdata.ui.a.PlI;
      localObject2 = (dtk)a.a.a((Context)getContext(), 7, dtk.class);
      if (localObject2 != null) {
        ((dtk)localObject2).aaYX = ((Integer)localObject1).intValue();
      }
      localObject1 = com.tencent.mm.plugin.secdata.ui.a.PlI;
      localObject1 = (dtk)a.a.a((Context)getContext(), 7, dtk.class);
      if (localObject1 != null) {
        ((dtk)localObject1).aaYS = 1;
      }
      localObject1 = com.tencent.mm.plugin.mv.model.f.LXf;
      paramf = com.tencent.mm.plugin.mv.model.f.a.b(paramf);
      if (paramf != null)
      {
        Log.i("MicroMsg.Mv.MusicMvInfoUIC", "onCommentClicked id:" + paramf.id + " nonceId:" + paramf.objectNonceId);
        localObject1 = FinderItem.Companion;
        paramf = FinderItem.a.e(paramf, 65536);
        gqG();
        this.Meo.gsf();
        localObject1 = this.ATy;
        if (localObject1 != null) {
          com.tencent.mm.plugin.finder.view.f.a((com.tencent.mm.plugin.finder.view.f)localObject1, paramf, paramLong, false, true, false, paramCloseDrawerCallback, 0L, 1664);
        }
      }
      AppMethodBeat.o(287726);
      return;
    }
  }
  
  public final void cB(String paramString, boolean paramBoolean)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    AppMethodBeat.i(287760);
    s.u(paramString, "username");
    if (paramBoolean)
    {
      localObject2 = com.tencent.mm.plugin.secdata.ui.a.PlI;
      localObject2 = (dtk)a.a.a((Context)getContext(), 7, dtk.class);
      if (localObject2 == null) {}
      for (;;)
      {
        localObject2 = com.tencent.mm.plugin.secdata.ui.a.PlI;
        localObject2 = (dtk)a.a.a((Context)getContext(), 7, dtk.class);
        if (localObject2 != null) {
          ((dtk)localObject2).aaZc = ((Integer)localObject1).intValue();
        }
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("finder_username", paramString);
        ((Intent)localObject1).putExtra("key_from_profile_share_scene", 19);
        ((Intent)localObject1).putExtra("key_enter_profile_type", 1);
        ((Intent)localObject1).putExtra("key_not_request_focus", true);
        ((Intent)localObject1).putExtra("key_hide_float_ball", true);
        ((Intent)localObject1).putExtra("key_from_comment_scene", 91);
        ((cn)h.az(cn.class)).fillContextIdToIntent(7, 2, 32, (Intent)localObject1);
        paramString = c.LLZ;
        c.zK(true);
        ((cn)h.az(cn.class)).enterFinderProfileUI((Context)getActivity(), (Intent)localObject1);
        AppMethodBeat.o(287760);
        return;
        localObject1 = Integer.valueOf(((dtk)localObject2).aaZc + 1);
      }
    }
    localObject1 = com.tencent.mm.plugin.secdata.ui.a.PlI;
    localObject1 = (dtk)a.a.a((Context)getContext(), 7, dtk.class);
    if (localObject1 == null) {}
    for (localObject1 = localObject2;; localObject1 = Integer.valueOf(((dtk)localObject1).aaZd + 1))
    {
      localObject2 = com.tencent.mm.plugin.secdata.ui.a.PlI;
      localObject2 = (dtk)a.a.a((Context)getContext(), 7, dtk.class);
      if (localObject2 == null) {
        break;
      }
      ((dtk)localObject2).aaZd = ((Integer)localObject1).intValue();
      break;
    }
  }
  
  public final void i(com.tencent.mm.plugin.mv.model.f paramf)
  {
    AppMethodBeat.i(287777);
    s.u(paramf, "musicMv");
    Object localObject1 = com.tencent.mm.ui.component.k.aeZF;
    ((i)com.tencent.mm.ui.component.k.d(getActivity()).q(i.class)).MeN.agMz = true;
    localObject1 = com.tencent.mm.ui.component.k.aeZF;
    localObject1 = com.tencent.mm.ui.component.k.d(getActivity()).q(i.class);
    s.s(localObject1, "UICProvider.of(activity)…sicMvMainUIC::class.java)");
    Object localObject2 = (i)localObject1;
    localObject1 = this.Men;
    Object localObject3 = (Iterable)((i)localObject2).pUj;
    localObject2 = (Collection)new ArrayList(p.a((Iterable)localObject3, 10));
    localObject3 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject3).hasNext()) {
      ((Collection)localObject2).add(((com.tencent.mm.plugin.mv.ui.a.b)((Iterator)localObject3).next()).MaX);
    }
    ((com.tencent.mm.plugin.mv.ui.view.b)localObject1).a(paramf, (List)localObject2);
    paramf = this.Men;
    if (!paramf.Mix.isShowing())
    {
      paramf = paramf.Mix;
      paramf.sRw = paramf.isLandscape();
      paramf.sRx = paramf.getRotation();
      if (paramf.sRs != null)
      {
        localObject1 = paramf.rootView;
        s.checkNotNull(localObject1);
        localObject1 = ((View)localObject1).getParent();
        if (localObject1 == null)
        {
          paramf = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
          AppMethodBeat.o(287777);
          throw paramf;
        }
        ((ViewGroup)localObject1).setVisibility(0);
        localObject1 = paramf.rootView;
        s.checkNotNull(localObject1);
        localObject1 = ((View)localObject1).getLayoutParams();
        if (localObject1 == null)
        {
          paramf = new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
          AppMethodBeat.o(287777);
          throw paramf;
        }
        localObject1 = (FrameLayout.LayoutParams)localObject1;
        if ((paramf.sRw) && (paramf.mF != null))
        {
          localObject2 = new Rect();
          localObject3 = paramf.mF;
          s.checkNotNull(localObject3);
          ((View)localObject3).getWindowVisibleDisplayFrame((Rect)localObject2);
          ((FrameLayout.LayoutParams)localObject1).width = ((Rect)localObject2).right;
        }
        localObject2 = paramf.rootView;
        s.checkNotNull(localObject2);
        ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
        if (Build.VERSION.SDK_INT >= 21)
        {
          localObject1 = paramf.sRs;
          s.checkNotNull(localObject1);
          localObject1 = ((Dialog)localObject1).getWindow();
          s.checkNotNull(localObject1);
          ((Window)localObject1).addFlags(-2147483648);
        }
        if ((paramf.GwR) && (Build.VERSION.SDK_INT >= 23) && (paramf.sRs != null))
        {
          localObject1 = paramf.sRs;
          s.checkNotNull(localObject1);
          localObject1 = ((Dialog)localObject1).getWindow();
          s.checkNotNull(localObject1);
          ((Window)localObject1).getDecorView().setSystemUiVisibility(9216);
          localObject1 = paramf.sRs;
          s.checkNotNull(localObject1);
          localObject1 = ((Dialog)localObject1).getWindow();
          s.checkNotNull(localObject1);
          ((Window)localObject1).setStatusBarColor(0);
        }
        if (!paramf.sRz) {
          break label667;
        }
        localObject1 = paramf.sRs;
        s.checkNotNull(localObject1);
        localObject1 = ((Dialog)localObject1).getWindow();
        s.checkNotNull(localObject1);
        ((Window)localObject1).setFlags(8, 8);
        localObject1 = paramf.sRs;
        s.checkNotNull(localObject1);
        localObject1 = ((Dialog)localObject1).getWindow();
        s.checkNotNull(localObject1);
        ((Window)localObject1).addFlags(131200);
        localObject1 = paramf.sRs;
        s.checkNotNull(localObject1);
        localObject1 = ((Dialog)localObject1).getWindow();
        s.checkNotNull(localObject1);
        ((Window)localObject1).getDecorView().setSystemUiVisibility(6);
        if (paramf.mF != null) {
          if (paramf.mP != null) {
            break label770;
          }
        }
      }
    }
    label770:
    for (int i = 1;; i = 0)
    {
      localObject1 = paramf.mF;
      s.checkNotNull(localObject1);
      paramf.mP = ((View)localObject1).getViewTreeObserver();
      if (i != 0)
      {
        localObject1 = paramf.mP;
        s.checkNotNull(localObject1);
        ((ViewTreeObserver)localObject1).addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)paramf);
      }
      if (((paramf.mContext instanceof Activity)) && (!((Activity)paramf.mContext).isFinishing()))
      {
        localObject1 = paramf.sRs;
        s.checkNotNull(localObject1);
        ((Dialog)localObject1).show();
      }
      if (paramf.sRv != null)
      {
        paramf = paramf.sRv;
        s.checkNotNull(paramf);
        paramf.dqC = false;
      }
      AppMethodBeat.o(287777);
      return;
      label667:
      localObject1 = paramf.sRs;
      s.checkNotNull(localObject1);
      localObject1 = ((Dialog)localObject1).getWindow();
      s.checkNotNull(localObject1);
      ((Window)localObject1).clearFlags(8);
      localObject1 = paramf.sRs;
      s.checkNotNull(localObject1);
      localObject1 = ((Dialog)localObject1).getWindow();
      s.checkNotNull(localObject1);
      ((Window)localObject1).clearFlags(131072);
      localObject1 = paramf.sRs;
      s.checkNotNull(localObject1);
      localObject1 = ((Dialog)localObject1).getWindow();
      s.checkNotNull(localObject1);
      ((Window)localObject1).clearFlags(128);
      localObject1 = paramf.sRs;
      s.checkNotNull(localObject1);
      localObject1 = ((Dialog)localObject1).getWindow();
      s.checkNotNull(localObject1);
      ((Window)localObject1).getDecorView().setSystemUiVisibility(0);
      break;
    }
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(287748);
    com.tencent.mm.plugin.finder.view.f localf = this.ATy;
    if ((localf != null) && (localf.fkp() == true)) {}
    for (int i = 1; i != 0; i = 0)
    {
      localf = this.ATy;
      if (localf != null) {
        localf.fdh();
      }
      AppMethodBeat.o(287748);
      return true;
    }
    AppMethodBeat.o(287748);
    return false;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(287703);
    super.onCreate(paramBundle);
    gqG();
    gqH();
    AppMethodBeat.o(287703);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(287709);
    com.tencent.mm.plugin.finder.view.f localf = this.ATy;
    if (localf != null) {
      localf.fdh();
    }
    super.onDestroy();
    AppMethodBeat.o(287709);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/uic/MusicMvInfoUIC$tipsPopupWindow$1", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTipsPopupWindow$OnClickListener;", "onClick", "", "musicMv", "Lcom/tencent/mm/plugin/mv/model/MusicMv;", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements d.b
  {
    d(AppCompatActivity paramAppCompatActivity) {}
    
    public final void j(com.tencent.mm.plugin.mv.model.f paramf)
    {
      AppMethodBeat.i(287654);
      Object localObject = com.tencent.mm.ui.component.k.aeZF;
      localObject = com.tencent.mm.ui.component.k.d(this.Awh).q(r.class);
      s.s(localObject, "UICProvider.of(activity)…icMvShareUIC::class.java)");
      r.a((r)localObject, paramf);
      AppMethodBeat.o(287654);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.uic.g
 * JD-Core Version:    0.7.0.1
 */