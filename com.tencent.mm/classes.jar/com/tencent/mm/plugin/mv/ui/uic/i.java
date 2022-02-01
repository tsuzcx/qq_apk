package com.tencent.mm.plugin.mv.ui.uic;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.CloseDrawerCallback;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.plugin.mv.ui.view.e;
import com.tencent.mm.plugin.mv.ui.view.e.b;
import com.tencent.mm.plugin.secdata.ui.a.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.dbs;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.g.a;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvInfoUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "drawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "isShowTipsPopupWindow", "Landroidx/lifecycle/MutableLiveData;", "", "()Landroidx/lifecycle/MutableLiveData;", "isShowTipsPopupWindow$delegate", "Lkotlin/Lazy;", "mediaChangeListener", "Lcom/tencent/mm/plugin/thumbplayer/view/OnPlayerChangeMediaListener;", "getMediaChangeListener", "()Lcom/tencent/mm/plugin/thumbplayer/view/OnPlayerChangeMediaListener;", "mvListDialog", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvListDialog;", "refVideoNickNameTvMap", "Ljava/util/HashMap;", "", "Ljava/lang/ref/WeakReference;", "Landroid/widget/TextView;", "Lkotlin/collections/HashMap;", "getRefVideoNickNameTvMap", "()Ljava/util/HashMap;", "tipsPopupWindow", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTipsPopupWindow;", "getTipsPopupWindow", "()Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTipsPopupWindow;", "addRefVideoNickNameTv", "", "refVideoNickNameTv", "enterFinderProfile", "username", "", "isMvMaker", "isMvListDialogShow", "makeSureDrawerInit", "onBackPressed", "onCommentClicked", "musicMv", "Lcom/tencent/mm/plugin/mv/model/MusicMv;", "refCommentId", "", "closeCallback", "Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$CloseDrawerCallback;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "showMvListDialog", "Companion", "plugin-mv_release"})
public final class i
  extends UIComponent
{
  public static final i.a Gjn;
  public final com.tencent.mm.plugin.mv.ui.view.c Gji;
  public final e Gjj;
  private final kotlin.f Gjk;
  final com.tencent.mm.plugin.thumbplayer.view.d Gjl;
  public final HashMap<Integer, WeakReference<TextView>> Gjm;
  private com.tencent.mm.plugin.finder.view.f xvK;
  
  static
  {
    AppMethodBeat.i(238401);
    Gjn = new i.a((byte)0);
    AppMethodBeat.o(238401);
  }
  
  public i(final AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(238398);
    this.Gji = new com.tencent.mm.plugin.mv.ui.view.c((Context)getContext());
    this.Gjj = new e((Context)paramAppCompatActivity, (e.b)new d(paramAppCompatActivity));
    this.Gjk = kotlin.g.ar((kotlin.g.a.a)i.b.Gjo);
    this.Gjl = ((com.tencent.mm.plugin.thumbplayer.view.d)new c(this, paramAppCompatActivity));
    this.Gjm = new HashMap();
    AppMethodBeat.o(238398);
  }
  
  private final void fgX()
  {
    AppMethodBeat.i(238378);
    if (this.xvK == null)
    {
      Object localObject1 = com.tencent.mm.plugin.finder.view.f.AVu;
      localObject1 = getActivity();
      if (localObject1 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(238378);
        throw ((Throwable)localObject1);
      }
      localObject1 = (MMFragmentActivity)localObject1;
      Object localObject2 = getActivity().getWindow();
      p.j(localObject2, "activity.window");
      localObject2 = ((Window)localObject2).getDecorView();
      p.j(localObject2, "activity.window.decorView");
      this.xvK = com.tencent.mm.plugin.finder.view.f.a.a((MMFragmentActivity)localObject1, (View)localObject2, 2, false, 70);
    }
    AppMethodBeat.o(238378);
  }
  
  public final void a(com.tencent.mm.plugin.mv.model.f paramf, long paramLong, CommentDrawerContract.CloseDrawerCallback paramCloseDrawerCallback)
  {
    AppMethodBeat.i(238383);
    p.k(paramf, "musicMv");
    p.k(paramCloseDrawerCallback, "closeCallback");
    Object localObject1 = com.tencent.mm.plugin.secdata.ui.a.JbV;
    localObject1 = (dbs)a.a.a((Context)getContext(), 7, dbs.class);
    if (localObject1 != null) {}
    for (localObject1 = Integer.valueOf(((dbs)localObject1).TJh + 1);; localObject1 = null)
    {
      Object localObject2 = com.tencent.mm.plugin.secdata.ui.a.JbV;
      localObject2 = (dbs)a.a.a((Context)getContext(), 7, dbs.class);
      if (localObject2 != null) {
        ((dbs)localObject2).TJh = ((Integer)localObject1).intValue();
      }
      localObject1 = com.tencent.mm.plugin.secdata.ui.a.JbV;
      localObject1 = (dbs)a.a.a((Context)getContext(), 7, dbs.class);
      if (localObject1 != null) {
        ((dbs)localObject1).TJc = 1;
      }
      localObject1 = com.tencent.mm.plugin.mv.model.f.GbD;
      paramf = com.tencent.mm.plugin.mv.model.f.a.b(paramf);
      if (paramf == null) {
        break label247;
      }
      Log.i("MicroMsg.Mv.MusicMvInfoUIC", "onCommentClicked id:" + paramf.id + " nonceId:" + paramf.objectNonceId);
      localObject1 = FinderItem.Companion;
      paramf = FinderItem.a.b(paramf, 65536);
      fgX();
      localObject1 = this.xvK;
      if (localObject1 == null) {
        break;
      }
      com.tencent.mm.plugin.finder.view.f.a((com.tencent.mm.plugin.finder.view.f)localObject1, paramf, paramLong, false, true, false, paramCloseDrawerCallback, 128);
      AppMethodBeat.o(238383);
      return;
    }
    AppMethodBeat.o(238383);
    return;
    label247:
    AppMethodBeat.o(238383);
  }
  
  public final void cf(String paramString, boolean paramBoolean)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    AppMethodBeat.i(238395);
    p.k(paramString, "username");
    if (paramBoolean)
    {
      localObject2 = com.tencent.mm.plugin.secdata.ui.a.JbV;
      localObject2 = (dbs)a.a.a((Context)getContext(), 7, dbs.class);
      if (localObject2 != null) {
        localObject1 = Integer.valueOf(((dbs)localObject2).TJm + 1);
      }
      localObject2 = com.tencent.mm.plugin.secdata.ui.a.JbV;
      localObject2 = (dbs)a.a.a((Context)getContext(), 7, dbs.class);
      if (localObject2 != null) {
        ((dbs)localObject2).TJm = ((Integer)localObject1).intValue();
      }
    }
    for (;;)
    {
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("finder_username", paramString);
      ((Intent)localObject1).putExtra("key_from_profile_share_scene", 19);
      ((Intent)localObject1).putExtra("key_enter_profile_type", 1);
      ((Intent)localObject1).putExtra("key_not_request_focus", true);
      ((Intent)localObject1).putExtra("key_hide_float_ball", true);
      ((Intent)localObject1).putExtra("key_comment_scene", 91);
      ((ak)h.ag(ak.class)).fillContextIdToIntent(7, 2, 32, (Intent)localObject1);
      paramString = com.tencent.mm.plugin.music.model.c.FRf;
      com.tencent.mm.plugin.music.model.c.vs(true);
      ((ak)h.ag(ak.class)).enterFinderProfileUI((Context)getActivity(), (Intent)localObject1);
      AppMethodBeat.o(238395);
      return;
      localObject1 = com.tencent.mm.plugin.secdata.ui.a.JbV;
      dbs localdbs = (dbs)a.a.a((Context)getContext(), 7, dbs.class);
      localObject1 = localObject2;
      if (localdbs != null) {
        localObject1 = Integer.valueOf(localdbs.TJn + 1);
      }
      localObject2 = com.tencent.mm.plugin.secdata.ui.a.JbV;
      localObject2 = (dbs)a.a.a((Context)getContext(), 7, dbs.class);
      if (localObject2 != null) {
        ((dbs)localObject2).TJn = ((Integer)localObject1).intValue();
      }
    }
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(238391);
    com.tencent.mm.plugin.finder.view.f localf = this.xvK;
    if ((localf != null) && (localf.eis() == true))
    {
      localf = this.xvK;
      if (localf != null) {
        localf.eir();
      }
      AppMethodBeat.o(238391);
      return true;
    }
    AppMethodBeat.o(238391);
    return false;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(238373);
    super.onCreate(paramBundle);
    fgX();
    AppMethodBeat.o(238373);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(238375);
    com.tencent.mm.plugin.finder.view.f localf = this.xvK;
    if (localf != null) {
      localf.eir();
    }
    super.onDestroy();
    AppMethodBeat.o(238375);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/mv/ui/uic/MusicMvInfoUIC$mediaChangeListener$1", "Lcom/tencent/mm/plugin/thumbplayer/view/OnPlayerChangeMediaListener;", "onChange", "", "index", "", "targetMedia", "Lcom/tencent/mm/plugin/thumbplayer/model/TPMediaInfo;", "plugin-mv_release"})
  public static final class c
    implements com.tencent.mm.plugin.thumbplayer.view.d
  {
    c(AppCompatActivity paramAppCompatActivity) {}
    
    public final void a(int paramInt, final com.tencent.mm.plugin.thumbplayer.e.d paramd)
    {
      AppMethodBeat.i(234960);
      p.k(paramd, "targetMedia");
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(this, paramd));
      AppMethodBeat.o(234960);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.a<x>
    {
      a(i.c paramc, com.tencent.mm.plugin.thumbplayer.e.d paramd)
      {
        super();
      }
      
      @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/mv/ui/uic/MusicMvInfoUIC$mediaChangeListener$1$onChange$1$1$1$2$1", "com/tencent/mm/plugin/mv/ui/uic/MusicMvInfoUIC$mediaChangeListener$1$onChange$1$$special$$inlined$let$lambda$1", "com/tencent/mm/plugin/mv/ui/uic/MusicMvInfoUIC$mediaChangeListener$1$onChange$1$$special$$inlined$let$lambda$2"})
      static final class a
        implements View.OnClickListener
      {
        a(TextView paramTextView, Object paramObject, i.c.a parama) {}
        
        public final void onClick(View paramView)
        {
          AppMethodBeat.i(226417);
          Object localObject = new b();
          ((b)localObject).bn(paramView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/uic/MusicMvInfoUIC$mediaChangeListener$1$onChange$1$$special$$inlined$forEach$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
          paramView = ((FinderObject)this.Gjt).contact;
          if (paramView != null)
          {
            paramView = paramView.username;
            if (paramView != null)
            {
              localObject = this.Gju.Gjq.Gjp;
              p.j(paramView, "it");
              ((i)localObject).cf(paramView, false);
            }
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/uic/MusicMvInfoUIC$mediaChangeListener$1$onChange$1$$special$$inlined$forEach$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(226417);
        }
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/mv/ui/uic/MusicMvInfoUIC$tipsPopupWindow$1", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTipsPopupWindow$OnClickListener;", "onClick", "", "musicMv", "Lcom/tencent/mm/plugin/mv/model/MusicMv;", "plugin-mv_release"})
  public static final class d
    implements e.b
  {
    d(AppCompatActivity paramAppCompatActivity) {}
    
    public final void i(com.tencent.mm.plugin.mv.model.f paramf)
    {
      AppMethodBeat.i(230860);
      com.tencent.mm.ui.component.g localg = com.tencent.mm.ui.component.g.Xox;
      ((u)com.tencent.mm.ui.component.g.b(this.wYZ).i(u.class)).a(paramf, true);
      AppMethodBeat.o(230860);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.uic.i
 * JD-Core Version:    0.7.0.1
 */