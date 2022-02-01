package com.tencent.mm.plugin.mv.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mv.b.b;
import com.tencent.mm.plugin.mv.b.e;
import com.tencent.mm.plugin.mv.b.f;
import com.tencent.mm.plugin.mv.ui.uic.n;
import com.tencent.mm.plugin.mv.ui.uic.o;
import com.tencent.mm.plugin.mv.ui.uic.p.b;
import com.tencent.mm.plugin.mv.ui.uic.p.e;
import com.tencent.mm.plugin.mv.ui.uic.v;
import com.tencent.mm.plugin.thumbplayer.view.MultiMediaEffectVideoLayout;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.bol;
import com.tencent.mm.protocal.protobuf.boq;
import com.tencent.mm.protocal.protobuf.dtf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedDeque;
import kotlin.Metadata;
import kotlin.a.ar;
import kotlin.ah;
import kotlin.d.f;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.bu;

@com.tencent.mm.ui.base.a(32)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/MusicMvMakerPreviewUI;", "Lcom/tencent/mm/plugin/mv/ui/BaseMusicMvUI;", "()V", "startPostUI", "", "trackData", "Lcom/tencent/mm/protocal/protobuf/MusicMvData;", "getTrackData", "()Lcom/tencent/mm/protocal/protobuf/MusicMvData;", "setTrackData", "(Lcom/tencent/mm/protocal/protobuf/MusicMvData;)V", "getLayoutId", "", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onResume", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MusicMvMakerPreviewUI
  extends BaseMusicMvUI
{
  private dtf LZM;
  private boolean LZN;
  
  private static final void a(MusicMvMakerPreviewUI paramMusicMvMakerPreviewUI, View paramView)
  {
    AppMethodBeat.i(286330);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramMusicMvMakerPreviewUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/MusicMvMakerPreviewUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramMusicMvMakerPreviewUI, "this$0");
    paramMusicMvMakerPreviewUI.finish();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/mv/ui/MusicMvMakerPreviewUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(286330);
  }
  
  private static final void b(MusicMvMakerPreviewUI paramMusicMvMakerPreviewUI, View paramView)
  {
    AppMethodBeat.i(286342);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramMusicMvMakerPreviewUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/MusicMvMakerPreviewUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramMusicMvMakerPreviewUI, "this$0");
    paramView = new Intent((Context)paramMusicMvMakerPreviewUI, MusicMvPostUI.class);
    localObject = paramMusicMvMakerPreviewUI.LZM;
    if (localObject != null) {
      paramView.putExtra("key_track_data", ((dtf)localObject).toByteArray());
    }
    com.tencent.mm.ae.d.a(paramView, paramMusicMvMakerPreviewUI.getIntent(), "key_mv_from_scene");
    paramMusicMvMakerPreviewUI.LZN = true;
    localObject = com.tencent.mm.plugin.music.model.c.LLZ;
    com.tencent.mm.plugin.music.model.c.zK(true);
    paramView = new com.tencent.mm.hellhoundlib.b.a().cG(paramView);
    com.tencent.mm.hellhoundlib.a.a.b(paramMusicMvMakerPreviewUI, paramView.aYi(), "com/tencent/mm/plugin/mv/ui/MusicMvMakerPreviewUI", "onCreate$lambda-5", "(Lcom/tencent/mm/plugin/mv/ui/MusicMvMakerPreviewUI;Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramMusicMvMakerPreviewUI.startActivity((Intent)paramView.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramMusicMvMakerPreviewUI, "com/tencent/mm/plugin/mv/ui/MusicMvMakerPreviewUI", "onCreate$lambda-5", "(Lcom/tencent/mm/plugin/mv/ui/MusicMvMakerPreviewUI;Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramMusicMvMakerPreviewUI.finish();
    paramMusicMvMakerPreviewUI = com.tencent.mm.plugin.mv.model.m.LYc;
    com.tencent.mm.plugin.mv.model.m.gpK();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/mv/ui/MusicMvMakerPreviewUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(286342);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getLayoutId()
  {
    return b.f.LVE;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(286360);
    Set localSet = super.importUIComponents();
    if (localSet == null)
    {
      AppMethodBeat.o(286360);
      return null;
    }
    localSet = ar.b(localSet, (Iterable)ar.setOf(new Class[] { n.class, com.tencent.mm.plugin.mv.ui.uic.p.class, o.class }));
    AppMethodBeat.o(286360);
    return localSet;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(286391);
    super.onCreate(paramBundle);
    hideTitleView();
    paramBundle = findViewById(b.e.back_btn);
    Util.expandViewTouchArea(paramBundle, 200, 200, 200, 200);
    paramBundle.setOnClickListener(new MusicMvMakerPreviewUI..ExternalSyntheticLambda0(this));
    paramBundle = getWindow().getDecorView();
    s.s(paramBundle, "window.decorView");
    paramBundle.setSystemUiVisibility(1280);
    setActionbarColor(getContext().getResources().getColor(b.b.transparent));
    hideActionbarLine();
    this.LZM = new dtf();
    paramBundle = getIntent().getByteArrayExtra("key_track_data");
    if (paramBundle != null)
    {
      localObject1 = this.LZM;
      if (localObject1 != null) {
        ((dtf)localObject1).parseFrom(paramBundle);
      }
    }
    com.tencent.mm.plugin.music.logic.j.gnw().gnj().wH(0);
    paramBundle = k.aeZF;
    paramBundle = k.d((AppCompatActivity)this).q(n.class);
    s.s(paramBundle, "UICProvider.of(this).get…PreviewBgUIC::class.java)");
    Object localObject1 = (n)paramBundle;
    paramBundle = this.LZM;
    label207:
    int j;
    label395:
    Object localObject2;
    int m;
    Object localObject3;
    int i;
    int k;
    label491:
    Object localObject4;
    if (paramBundle == null)
    {
      paramBundle = null;
      ((n)localObject1).thumbPath = paramBundle;
      paramBundle = this.LZM;
      if (paramBundle != null) {
        break label595;
      }
      paramBundle = null;
      ((n)localObject1).thumbUrl = paramBundle;
      ((n)localObject1).a((com.tencent.mm.plugin.mv.ui.uic.u)new MusicMvMakerPreviewUI.a());
      ((n)localObject1).LZM = this.LZM;
      ((n)localObject1).a((com.tencent.mm.plugin.thumbplayer.view.d)new b(this));
      paramBundle = k.aeZF;
      paramBundle = k.d((AppCompatActivity)this).q(com.tencent.mm.plugin.mv.ui.uic.p.class);
      s.s(paramBundle, "UICProvider.of(this).get…viewTrackUIC::class.java)");
      paramBundle = (com.tencent.mm.plugin.mv.ui.uic.p)paramBundle;
      ((n)localObject1).Mgs = ((kotlin.g.a.m)new MusicMvMakerPreviewUI.c(paramBundle));
      paramBundle.MgG = ((v)new d((n)localObject1));
      paramBundle.LZM = this.LZM;
      localObject1 = paramBundle.LZM;
      if (localObject1 == null) {
        break label815;
      }
      localObject1 = ((dtf)localObject1).aaYK;
      if (localObject1 == null) {
        break label815;
      }
      localObject1 = ((FinderObject)localObject1).objectDesc;
      if (localObject1 == null) {
        break label815;
      }
      localObject1 = ((FinderObjectDesc)localObject1).mvInfo;
      if (localObject1 == null) {
        break label815;
      }
      localObject1 = ((bol)localObject1).ZWI;
      if (localObject1 == null) {
        break label815;
      }
      localObject1 = ((Iterable)localObject1).iterator();
      j = 0;
      if (!((Iterator)localObject1).hasNext()) {
        break label815;
      }
      localObject2 = ((Iterator)localObject1).next();
      if (j < 0) {
        kotlin.a.p.kkW();
      }
      localObject2 = (boq)localObject2;
      m = 0;
      if (((boq)localObject2).refObjectId == 0L) {
        break label733;
      }
      localObject3 = paramBundle.LZM;
      i = m;
      if (localObject3 == null) {
        break label672;
      }
      localObject3 = ((dtf)localObject3).ZJp;
      i = m;
      if (localObject3 == null) {
        break label672;
      }
      localObject3 = (Iterable)localObject3;
      k = 0;
      localObject3 = ((Iterable)localObject3).iterator();
      i = 0;
      if (!((Iterator)localObject3).hasNext()) {
        break label672;
      }
      localObject4 = ((Iterator)localObject3).next();
      if (k < 0) {
        kotlin.a.p.kkW();
      }
      localObject4 = (FinderObject)localObject4;
      if (((FinderObject)localObject4).id != ((boq)localObject2).refObjectId) {
        break label1229;
      }
      p.b localb = new p.b(paramBundle, k);
      localb.MgH = ((boq)localObject2);
      localb.MgI = ((FinderObject)localObject4);
      paramBundle.MgC.add(localb);
      i = 1;
    }
    label672:
    label815:
    label1229:
    for (;;)
    {
      k += 1;
      break label491;
      paramBundle = paramBundle.aaYL;
      break;
      label595:
      paramBundle = paramBundle.aaYK;
      if (paramBundle == null)
      {
        paramBundle = null;
        break label207;
      }
      paramBundle = paramBundle.objectDesc;
      if (paramBundle == null)
      {
        paramBundle = null;
        break label207;
      }
      paramBundle = paramBundle.media;
      if (paramBundle == null)
      {
        paramBundle = null;
        break label207;
      }
      paramBundle = (FinderMedia)kotlin.a.p.oL((List)paramBundle);
      if (paramBundle == null)
      {
        paramBundle = null;
        break label207;
      }
      paramBundle = s.X(paramBundle.thumbUrl, paramBundle.thumb_url_token);
      break label207;
      if (i == 0)
      {
        localObject3 = paramBundle.MgC;
        localObject4 = new p.b(paramBundle, j);
        ((p.b)localObject4).MgH = ((boq)localObject2);
        ((p.b)localObject4).hJv = true;
        ((p.b)localObject4).oBZ = true;
        localObject2 = ah.aiuX;
        ((ArrayList)localObject3).add(localObject4);
      }
      j += 1;
      break label395;
      label733:
      localObject3 = (CharSequence)((boq)localObject2).ZWZ;
      if ((localObject3 == null) || (((CharSequence)localObject3).length() == 0)) {}
      for (k = 1;; k = 0)
      {
        i = m;
        if (k != 0) {
          break;
        }
        localObject3 = new p.b(paramBundle, j);
        ((p.b)localObject3).MgH = ((boq)localObject2);
        ((p.b)localObject3).hJv = true;
        paramBundle.MgC.add(localObject3);
        i = 1;
        break;
      }
      localObject1 = (p.b)kotlin.a.p.oL((List)paramBundle.MgC);
      if (localObject1 != null) {
        ((p.b)localObject1).wwJ = true;
      }
      paramBundle.MgE = 0;
      kotlinx.coroutines.j.a((aq)bu.ajwo, (f)bg.kCi(), null, (kotlin.g.a.m)new p.e(paramBundle, null), 2);
      paramBundle.MgD = ((WxRecyclerView)paramBundle.getActivity().findViewById(b.e.LRX));
      localObject1 = new View((Context)paramBundle.getActivity());
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)new RecyclerView.LayoutParams(com.tencent.mm.cd.a.fromDPToPix((Context)paramBundle.getActivity(), 24), com.tencent.mm.cd.a.fromDPToPix((Context)paramBundle.getActivity(), 64)));
      i.a((i)paramBundle.getAdapter(), (View)localObject1, -1);
      localObject1 = new View((Context)paramBundle.getActivity());
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)new RecyclerView.LayoutParams(com.tencent.mm.cd.a.fromDPToPix((Context)paramBundle.getActivity(), 24), com.tencent.mm.cd.a.fromDPToPix((Context)paramBundle.getActivity(), 64)));
      i.b((i)paramBundle.getAdapter(), (View)localObject1, -2);
      localObject1 = paramBundle.MgD;
      if (localObject1 != null) {
        ((WxRecyclerView)localObject1).setLayoutManager((RecyclerView.LayoutManager)paramBundle.EKZ.getValue());
      }
      localObject1 = paramBundle.MgD;
      if (localObject1 != null) {
        ((WxRecyclerView)localObject1).setAdapter((RecyclerView.a)paramBundle.getAdapter());
      }
      paramBundle = (Button)findViewById(b.e.complete_btn);
      if (paramBundle != null) {
        paramBundle.setOnClickListener(new MusicMvMakerPreviewUI..ExternalSyntheticLambda1(this));
      }
      paramBundle = k.aeZF;
      localObject1 = (o)k.d((AppCompatActivity)this).q(o.class);
      paramBundle = this.LZM;
      if (paramBundle == null) {
        paramBundle = null;
      }
      for (;;)
      {
        ((o)localObject1).LWI = paramBundle;
        paramBundle = k.aeZF;
        ((o)k.d((AppCompatActivity)this).q(o.class)).gre();
        AppMethodBeat.o(286391);
        return;
        paramBundle = paramBundle.aaYK;
        if (paramBundle == null)
        {
          paramBundle = null;
        }
        else
        {
          paramBundle = paramBundle.objectDesc;
          if (paramBundle == null)
          {
            paramBundle = null;
          }
          else
          {
            paramBundle = paramBundle.mvInfo;
            if (paramBundle == null) {
              paramBundle = null;
            } else {
              paramBundle = paramBundle.LWI;
            }
          }
        }
      }
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(286408);
    super.onPause();
    com.tencent.mm.plugin.music.model.c localc = com.tencent.mm.plugin.music.model.c.LLZ;
    com.tencent.mm.plugin.music.model.c.gnQ();
    AppMethodBeat.o(286408);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(286403);
    super.onResume();
    if (!this.LZN)
    {
      this.LZN = false;
      com.tencent.mm.plugin.music.model.c localc = com.tencent.mm.plugin.music.model.c.LLZ;
      com.tencent.mm.plugin.music.model.c.onResume();
    }
    AppMethodBeat.o(286403);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/MusicMvMakerPreviewUI$onCreate$5", "Lcom/tencent/mm/plugin/thumbplayer/view/OnPlayerChangeMediaListener;", "onChange", "", "index", "", "targetMedia", "Lcom/tencent/mm/plugin/thumbplayer/api/TPMediaInfo;", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements com.tencent.mm.plugin.thumbplayer.view.d
  {
    b(MusicMvMakerPreviewUI paramMusicMvMakerPreviewUI) {}
    
    public final void a(final int paramInt, com.tencent.mm.plugin.thumbplayer.a.b paramb)
    {
      AppMethodBeat.i(286418);
      s.u(paramb, "targetMedia");
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(this.LZO, paramInt));
      AppMethodBeat.o(286418);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends kotlin.g.b.u
      implements kotlin.g.a.a<ah>
    {
      a(MusicMvMakerPreviewUI paramMusicMvMakerPreviewUI, int paramInt)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/MusicMvMakerPreviewUI$onCreate$7", "Lcom/tencent/mm/plugin/mv/ui/uic/OnMediaSelectListener;", "select", "", "index", "", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements v
  {
    d(n paramn) {}
    
    public final void select(int paramInt)
    {
      Object localObject2 = null;
      AppMethodBeat.i(286421);
      Object localObject1 = this.LZP.Mci;
      com.tencent.mm.plugin.thumbplayer.c.b localb;
      if (localObject1 != null)
      {
        localb = ((MultiMediaEffectVideoLayout)localObject1).TGY;
        String str = localb.TAG;
        StringBuilder localStringBuilder = new StringBuilder("seekToIndex:").append(paramInt).append(", renderPts:").append(localb.TCX).append(", playingPlayers.size:").append(localb.TCS.size()).append(", status:").append(localb.TCW).append(", trackList.size:");
        localObject1 = localb.TCV;
        if (localObject1 != null) {
          break label257;
        }
        localObject1 = null;
        Log.i(str, localObject1);
        localObject1 = localb.TCV;
        if (localObject1 != null) {
          break label288;
        }
      }
      label257:
      label288:
      for (localObject1 = localObject2;; localObject1 = ((com.tencent.mm.plugin.thumbplayer.c.d)localObject1).TDz)
      {
        if ((localObject1 != null) && (paramInt <= ((ArrayList)localObject1).size()))
        {
          localObject1 = ((ArrayList)localObject1).get(paramInt);
          s.s(localObject1, "trackList[index]");
          localObject1 = (com.tencent.mm.plugin.thumbplayer.c.c)localObject1;
          long l = ((com.tencent.mm.plugin.thumbplayer.c.c)localObject1).TDw;
          Log.i(localb.TAG, "found seek target track:" + localObject1 + ", trackSeekTime:" + l + ", trackStartTimeMs:" + ((com.tencent.mm.plugin.thumbplayer.c.c)localObject1).TDw);
          localb.TDc = ((com.tencent.mm.plugin.thumbplayer.c.c)localObject1).startTimeMs;
          localb.a((com.tencent.mm.plugin.thumbplayer.c.c)localObject1, l);
        }
        AppMethodBeat.o(286421);
        return;
        localObject1 = ((com.tencent.mm.plugin.thumbplayer.c.d)localObject1).TDz;
        if (localObject1 == null)
        {
          localObject1 = null;
          break;
        }
        localObject1 = Integer.valueOf(((ArrayList)localObject1).size());
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.MusicMvMakerPreviewUI
 * JD-Core Version:    0.7.0.1
 */