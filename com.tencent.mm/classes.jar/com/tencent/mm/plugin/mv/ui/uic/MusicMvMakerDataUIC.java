package com.tencent.mm.plugin.mv.ui.uic;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.of;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.axw;
import com.tencent.mm.protocal.protobuf.axy;
import com.tencent.mm.protocal.protobuf.csp;
import com.tencent.mm.protocal.protobuf.cst;
import com.tencent.mm.ui.component.UIComponent;
import java.util.LinkedList;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerDataUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "listener", "Lcom/tencent/mm/plugin/mv/ui/uic/callback/OnDataReadyListener;", "getListener", "()Lcom/tencent/mm/plugin/mv/ui/uic/callback/OnDataReadyListener;", "setListener", "(Lcom/tencent/mm/plugin/mv/ui/uic/callback/OnDataReadyListener;)V", "music", "Lcom/tencent/mm/plugin/music/model/storage/Music;", "getMusic", "()Lcom/tencent/mm/plugin/music/model/storage/Music;", "setMusic", "(Lcom/tencent/mm/plugin/music/model/storage/Music;)V", "songInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "getSongInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "setSongInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;)V", "trackData", "Lcom/tencent/mm/protocal/protobuf/MusicMvData;", "getTrackData", "()Lcom/tencent/mm/protocal/protobuf/MusicMvData;", "setTrackData", "(Lcom/tencent/mm/protocal/protobuf/MusicMvData;)V", "initData", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "plugin-mv_release"})
public final class MusicMvMakerDataUIC
  extends UIComponent
{
  public com.tencent.mm.plugin.music.model.e.a AkC;
  public csp AqY;
  public axy Aqo;
  public com.tencent.mm.plugin.mv.ui.uic.a.b Auy;
  
  public MusicMvMakerDataUIC(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(257201);
    this.Aqo = new axy();
    AppMethodBeat.o(257201);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    Object localObject1 = null;
    AppMethodBeat.i(257200);
    super.onCreate(paramBundle);
    paramBundle = com.tencent.mm.plugin.music.model.l.AkI;
    this.AkC = com.tencent.mm.plugin.music.model.l.au((Activity)getActivity());
    paramBundle = this.AkC;
    if (paramBundle != null)
    {
      localObject2 = com.tencent.mm.plugin.mv.ui.a.ArA;
      com.tencent.mm.plugin.mv.ui.a.a(paramBundle, this.Aqo);
    }
    this.AqY = new csp();
    paramBundle = getIntent().getByteArrayExtra("key_track_data");
    if (paramBundle != null)
    {
      localObject2 = this.AqY;
      if (localObject2 != null) {
        ((csp)localObject2).parseFrom(paramBundle);
      }
    }
    paramBundle = this.AqY;
    if (paramBundle != null)
    {
      paramBundle = paramBundle.MxE;
      if (paramBundle != null)
      {
        paramBundle = paramBundle.objectDesc;
        if (paramBundle != null)
        {
          paramBundle = paramBundle.mvInfo;
          if (paramBundle != null)
          {
            paramBundle = paramBundle.Aqo;
            if (paramBundle != null)
            {
              p.g(paramBundle, "it");
              this.Aqo = paramBundle;
            }
          }
        }
      }
    }
    Object localObject2 = this.AkC;
    Object localObject3 = this.AqY;
    int i;
    if ((localObject2 != null) && (localObject3 != null))
    {
      paramBundle = (CharSequence)((com.tencent.mm.plugin.music.model.e.a)localObject2).field_songHAlbumUrl;
      if ((paramBundle != null) && (paramBundle.length() != 0)) {
        break label679;
      }
      i = 1;
      if (i != 0)
      {
        paramBundle = ((csp)localObject3).MxE;
        if (paramBundle == null) {
          break label684;
        }
        paramBundle = paramBundle.objectDesc;
        if (paramBundle == null) {
          break label684;
        }
        paramBundle = paramBundle.mvInfo;
        if (paramBundle == null) {
          break label684;
        }
        paramBundle = paramBundle.Aqo;
        if (paramBundle == null) {
          break label684;
        }
        paramBundle = paramBundle.Djf;
        label244:
        ((com.tencent.mm.plugin.music.model.e.a)localObject2).field_songHAlbumUrl = paramBundle;
      }
      paramBundle = (CharSequence)((com.tencent.mm.plugin.music.model.e.a)localObject2).field_songLyric;
      if ((paramBundle != null) && (paramBundle.length() != 0)) {
        break label689;
      }
      i = 1;
      label274:
      if (i != 0)
      {
        localObject3 = ((csp)localObject3).MxE;
        paramBundle = (Bundle)localObject1;
        if (localObject3 != null)
        {
          localObject3 = ((FinderObject)localObject3).objectDesc;
          paramBundle = (Bundle)localObject1;
          if (localObject3 != null)
          {
            localObject3 = ((FinderObjectDesc)localObject3).mvInfo;
            paramBundle = (Bundle)localObject1;
            if (localObject3 != null)
            {
              localObject3 = ((axw)localObject3).Aqo;
              paramBundle = (Bundle)localObject1;
              if (localObject3 != null) {
                paramBundle = ((axy)localObject3).LIh;
              }
            }
          }
        }
        ((com.tencent.mm.plugin.music.model.e.a)localObject2).field_songLyric = paramBundle;
      }
    }
    paramBundle = com.tencent.mm.plugin.mv.a.l.Uqz;
    localObject1 = (Context)getContext();
    paramBundle = this.Aqo;
    localObject2 = this.AqY;
    p.h(localObject1, "context");
    p.h(paramBundle, "songInfo");
    localObject3 = SecDataUIC.CWq;
    localObject1 = (cst)SecDataUIC.a.a((Context)localObject1, 7, cst.class);
    com.tencent.mm.plugin.mv.a.l.Uqu = new of();
    if (localObject1 != null)
    {
      com.tencent.mm.plugin.mv.a.l.Uqu.bla(((cst)localObject1).sGQ);
      com.tencent.mm.plugin.mv.a.l.Uqu.PO(((cst)localObject1).scene);
      com.tencent.mm.plugin.mv.a.l.Uqu.bvE(((cst)localObject1).Uuc);
    }
    localObject1 = com.tencent.mm.plugin.mv.a.l.Uqu;
    localObject3 = com.tencent.mm.plugin.comm.a.qCo;
    ((of)localObject1).ble(com.tencent.mm.plugin.comm.a.cAK());
    com.tencent.mm.plugin.mv.a.l.Uqu.bnJ(paramBundle.BPc);
    com.tencent.mm.plugin.mv.a.l.Uqu.bvy(paramBundle.AqO);
    com.tencent.mm.plugin.mv.a.l.Uqu.bvz(paramBundle.LIg);
    com.tencent.mm.plugin.mv.a.l.Uqu.bvA(paramBundle.musicDataUrl);
    com.tencent.mm.plugin.mv.a.l.Uqu.bvB(paramBundle.lDR);
    localObject3 = com.tencent.mm.plugin.mv.a.l.Uqu;
    localObject1 = z.aUg();
    paramBundle = (Bundle)localObject1;
    if (localObject1 == null) {
      paramBundle = "";
    }
    ((of)localObject3).bvC(paramBundle);
    paramBundle = com.tencent.mm.plugin.mv.a.l.Uqu;
    if (localObject2 != null)
    {
      localObject1 = ((csp)localObject2).MxE;
      if (localObject1 != null)
      {
        localObject1 = ((FinderObject)localObject1).objectDesc;
        if (localObject1 != null)
        {
          localObject1 = ((FinderObjectDesc)localObject1).mvInfo;
          if (localObject1 != null)
          {
            localObject1 = ((axw)localObject1).LId;
            if (localObject1 == null) {}
          }
        }
      }
    }
    for (long l = ((LinkedList)localObject1).size();; l = 0L)
    {
      paramBundle.PJ(l);
      paramBundle = com.tencent.mm.plugin.mv.a.l.gFd();
      paramBundle.PF(1L);
      paramBundle.bfK();
      localObject1 = com.tencent.mm.util.b.QYu;
      com.tencent.mm.util.b.a((com.tencent.mm.plugin.report.a)paramBundle);
      paramBundle = this.Auy;
      if (paramBundle == null) {
        break label699;
      }
      paramBundle.evE();
      AppMethodBeat.o(257200);
      return;
      label679:
      i = 0;
      break;
      label684:
      paramBundle = null;
      break label244;
      label689:
      i = 0;
      break label274;
    }
    label699:
    AppMethodBeat.o(257200);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.uic.MusicMvMakerDataUIC
 * JD-Core Version:    0.7.0.1
 */