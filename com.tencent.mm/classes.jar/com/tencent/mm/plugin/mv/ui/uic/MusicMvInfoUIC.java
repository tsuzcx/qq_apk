package com.tencent.mm.plugin.mv.ui.uic;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.CloseDrawerCallback;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.music.model.c;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.cst;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.component.UIComponent;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvInfoUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "drawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "mediaChangeListener", "Lcom/tencent/mm/plugin/thumbplayer/view/OnPlayerChangeMediaListener;", "getMediaChangeListener", "()Lcom/tencent/mm/plugin/thumbplayer/view/OnPlayerChangeMediaListener;", "mvListDialog", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvListDialog;", "refVideoNickNameTvMap", "Ljava/util/HashMap;", "", "Ljava/lang/ref/WeakReference;", "Landroid/widget/TextView;", "Lkotlin/collections/HashMap;", "getRefVideoNickNameTvMap", "()Ljava/util/HashMap;", "addRefVideoNickNameTv", "", "refVideoNickNameTv", "enterFinderProfile", "username", "", "isMvListDialogShow", "", "makeSureDrawerInit", "onBackPressed", "onCommentClicked", "musicMv", "Lcom/tencent/mm/plugin/mv/model/MusicMv;", "refCommentId", "", "closeCallback", "Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$CloseDrawerCallback;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "showMvListDialog", "Companion", "plugin-mv_release"})
public final class MusicMvInfoUIC
  extends UIComponent
{
  public static final a AtB;
  public final HashMap<Integer, WeakReference<TextView>> AtA;
  final com.tencent.mm.plugin.mv.ui.view.e Aty;
  final com.tencent.mm.plugin.thumbplayer.view.d Atz;
  private com.tencent.mm.plugin.finder.view.e tLT;
  
  static
  {
    AppMethodBeat.i(257132);
    AtB = new a((byte)0);
    AppMethodBeat.o(257132);
  }
  
  public MusicMvInfoUIC(final AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(257131);
    this.Aty = new com.tencent.mm.plugin.mv.ui.view.e((Context)getContext());
    this.Atz = ((com.tencent.mm.plugin.thumbplayer.view.d)new b(this, paramAppCompatActivity));
    this.AtA = new HashMap();
    AppMethodBeat.o(257131);
  }
  
  private final void evP()
  {
    AppMethodBeat.i(257125);
    if (this.tLT == null)
    {
      Object localObject1 = com.tencent.mm.plugin.finder.view.e.wky;
      localObject1 = getActivity();
      if (localObject1 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(257125);
        throw ((Throwable)localObject1);
      }
      localObject1 = (MMFragmentActivity)localObject1;
      Object localObject2 = getActivity().getWindow();
      p.g(localObject2, "activity.window");
      localObject2 = ((Window)localObject2).getDecorView();
      p.g(localObject2, "activity.window.decorView");
      this.tLT = com.tencent.mm.plugin.finder.view.e.a.a((MMFragmentActivity)localObject1, (View)localObject2, 2, false, 70);
    }
    AppMethodBeat.o(257125);
  }
  
  public final void a(com.tencent.mm.plugin.mv.a.e parame, long paramLong, CommentDrawerContract.CloseDrawerCallback paramCloseDrawerCallback)
  {
    AppMethodBeat.i(257126);
    p.h(parame, "musicMv");
    p.h(paramCloseDrawerCallback, "closeCallback");
    Object localObject = SecDataUIC.CWq;
    localObject = (cst)SecDataUIC.a.a((Context)getContext(), 7, cst.class);
    if (localObject != null) {
      ((cst)localObject).Uuh = 1;
    }
    localObject = SecDataUIC.CWq;
    localObject = (cst)SecDataUIC.a.a((Context)getContext(), 7, cst.class);
    if (localObject != null) {
      ((cst)localObject).MxP = 1;
    }
    localObject = com.tencent.mm.plugin.mv.a.e.ApR;
    parame = com.tencent.mm.plugin.mv.a.e.a.a(parame);
    if (parame != null)
    {
      Log.i("MicroMsg.Mv.MusicMvInfoUIC", "onCommentClicked id:" + parame.id + " nonceId:" + parame.objectNonceId);
      localObject = FinderItem.Companion;
      parame = FinderItem.a.a(parame, 65536);
      evP();
      localObject = this.tLT;
      if (localObject != null)
      {
        com.tencent.mm.plugin.finder.view.e.a((com.tencent.mm.plugin.finder.view.e)localObject, parame, paramLong, false, true, false, paramCloseDrawerCallback, 128);
        AppMethodBeat.o(257126);
        return;
      }
      AppMethodBeat.o(257126);
      return;
    }
    AppMethodBeat.o(257126);
  }
  
  public final void aIr(String paramString)
  {
    AppMethodBeat.i(257129);
    p.h(paramString, "username");
    Intent localIntent = new Intent();
    localIntent.putExtra("finder_username", paramString);
    localIntent.putExtra("key_from_profile_share_scene", 19);
    localIntent.putExtra("key_enter_profile_type", 1);
    localIntent.putExtra("key_not_request_focus", true);
    localIntent.putExtra("key_hide_float_ball", true);
    ((aj)g.ah(aj.class)).fillContextIdToIntent(7, 2, 32, localIntent);
    paramString = c.Akc;
    c.sm(true);
    ((aj)g.ah(aj.class)).enterFinderProfileUI((Context)getActivity(), localIntent);
    AppMethodBeat.o(257129);
  }
  
  public final void f(com.tencent.mm.plugin.mv.a.e parame)
  {
    AppMethodBeat.i(257130);
    p.h(parame, "musicMv");
    Object localObject1 = com.tencent.mm.ui.component.a.PRN;
    ((MusicMvMainUIC)com.tencent.mm.ui.component.a.b(getActivity()).get(MusicMvMainUIC.class)).evT();
    localObject1 = com.tencent.mm.ui.component.a.PRN;
    localObject1 = com.tencent.mm.ui.component.a.b(getActivity()).get(MusicMvMainUIC.class);
    p.g(localObject1, "UICProvider.of(activity)…sicMvMainUIC::class.java)");
    Object localObject2 = (MusicMvMainUIC)localObject1;
    localObject1 = this.Aty;
    Object localObject3 = (Iterable)((MusicMvMainUIC)localObject2).kgc;
    localObject2 = (Collection)new ArrayList(j.a((Iterable)localObject3, 10));
    localObject3 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject3).hasNext()) {
      ((Collection)localObject2).add(((com.tencent.mm.plugin.mv.ui.a.b)((Iterator)localObject3).next()).ArY);
    }
    ((com.tencent.mm.plugin.mv.ui.view.e)localObject1).a(parame, (List)localObject2);
    this.Aty.show();
    AppMethodBeat.o(257130);
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(257128);
    com.tencent.mm.plugin.finder.view.e locale = this.tLT;
    if ((locale != null) && (locale.dGs() == true))
    {
      locale = this.tLT;
      if (locale != null) {
        locale.dGr();
      }
      AppMethodBeat.o(257128);
      return true;
    }
    AppMethodBeat.o(257128);
    return false;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(257123);
    super.onCreate(paramBundle);
    evP();
    AppMethodBeat.o(257123);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(257124);
    com.tencent.mm.plugin.finder.view.e locale = this.tLT;
    if (locale != null) {
      locale.dGr();
    }
    super.onDestroy();
    AppMethodBeat.o(257124);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvInfoUIC$Companion;", "", "()V", "TAG", "", "plugin-mv_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/mv/ui/uic/MusicMvInfoUIC$mediaChangeListener$1", "Lcom/tencent/mm/plugin/thumbplayer/view/OnPlayerChangeMediaListener;", "onChange", "", "index", "", "targetMedia", "Lcom/tencent/mm/plugin/thumbplayer/model/TPMediaInfo;", "plugin-mv_release"})
  public static final class b
    implements com.tencent.mm.plugin.thumbplayer.view.d
  {
    b(AppCompatActivity paramAppCompatActivity) {}
    
    public final void a(int paramInt, final com.tencent.mm.plugin.thumbplayer.d.a parama)
    {
      AppMethodBeat.i(257122);
      p.h(parama, "targetMedia");
      com.tencent.mm.ac.d.h((kotlin.g.a.a)new a(this, parama));
      AppMethodBeat.o(257122);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.a<x>
    {
      a(MusicMvInfoUIC.b paramb, com.tencent.mm.plugin.thumbplayer.d.a parama)
      {
        super();
      }
      
      @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/mv/ui/uic/MusicMvInfoUIC$mediaChangeListener$1$onChange$1$1$1$2$1", "com/tencent/mm/plugin/mv/ui/uic/MusicMvInfoUIC$mediaChangeListener$1$onChange$1$$special$$inlined$let$lambda$1", "com/tencent/mm/plugin/mv/ui/uic/MusicMvInfoUIC$mediaChangeListener$1$onChange$1$$special$$inlined$let$lambda$2"})
      static final class a
        implements View.OnClickListener
      {
        a(TextView paramTextView, Object paramObject, MusicMvInfoUIC.b.a parama) {}
        
        public final void onClick(View paramView)
        {
          AppMethodBeat.i(257120);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/uic/MusicMvInfoUIC$mediaChangeListener$1$onChange$1$$special$$inlined$forEach$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          paramView = ((FinderObject)this.AtG).contact;
          if (paramView != null)
          {
            paramView = paramView.username;
            if (paramView != null)
            {
              localObject = this.AtH.AtD.AtC;
              p.g(paramView, "it");
              ((MusicMvInfoUIC)localObject).aIr(paramView);
            }
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/uic/MusicMvInfoUIC$mediaChangeListener$1$onChange$1$$special$$inlined$forEach$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(257120);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.uic.MusicMvInfoUIC
 * JD-Core Version:    0.7.0.1
 */