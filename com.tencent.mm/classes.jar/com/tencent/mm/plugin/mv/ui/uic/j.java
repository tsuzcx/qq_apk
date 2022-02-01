package com.tencent.mm.plugin.mv.ui.uic;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.a.b;
import com.tencent.mm.am.a.b.a;
import com.tencent.mm.plugin.finder.report.v;
import com.tencent.mm.plugin.music.model.l;
import com.tencent.mm.plugin.mv.model.a.h;
import com.tencent.mm.plugin.mv.model.a.h.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.bol;
import com.tencent.mm.protocal.protobuf.boo;
import com.tencent.mm.protocal.protobuf.dsf;
import com.tencent.mm.protocal.protobuf.dtf;
import com.tencent.mm.sdk.coroutines.LifecycleScope;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k.b;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerDataUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "_trackDataLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mm/protocal/protobuf/MusicMvData;", "fromScene", "", "music", "Lcom/tencent/mm/plugin/music/model/storage/Music;", "getMusic", "()Lcom/tencent/mm/plugin/music/model/storage/Music;", "setMusic", "(Lcom/tencent/mm/plugin/music/model/storage/Music;)V", "mvTypeLiveData", "getMvTypeLiveData", "()Landroidx/lifecycle/MutableLiveData;", "mvTypeLiveData$delegate", "Lkotlin/Lazy;", "songInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "getSongInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "setSongInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;)V", "trackData", "trackDataLiveData", "Landroidx/lifecycle/LiveData;", "getTrackDataLiveData", "()Landroidx/lifecycle/LiveData;", "setTrackDataLiveData", "(Landroidx/lifecycle/LiveData;)V", "initData", "", "isFlexMode", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "reportEnterCreateMv", "syncBeatTrack", "Companion", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
  extends UIComponent
{
  public static final j.a Mfd;
  public com.tencent.mm.plugin.music.model.e.a LMB;
  public boo LWI;
  private dtf LZM;
  private final x<dtf> Mfe;
  public LiveData<dtf> Mff;
  private final kotlin.j Mfg;
  private int fromScene;
  
  static
  {
    AppMethodBeat.i(287692);
    Mfd = new j.a((byte)0);
    AppMethodBeat.o(287692);
  }
  
  public j(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(287681);
    this.LWI = new boo();
    this.Mfe = new x();
    this.Mff = ((LiveData)this.Mfe);
    this.LZM = new dtf();
    this.fromScene = 3;
    this.Mfg = kotlin.k.cm((kotlin.g.a.a)j.b.Mfh);
    AppMethodBeat.o(287681);
  }
  
  public final x<Integer> gqP()
  {
    AppMethodBeat.i(287733);
    x localx = (x)this.Mfg.getValue();
    AppMethodBeat.o(287733);
    return localx;
  }
  
  public final boolean gqh()
  {
    AppMethodBeat.i(287744);
    Integer localInteger = (Integer)gqP().getValue();
    if (localInteger == null) {}
    while (localInteger.intValue() != 1)
    {
      AppMethodBeat.o(287744);
      return false;
    }
    AppMethodBeat.o(287744);
    return true;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(287717);
    super.onCreate(paramBundle);
    paramBundle = l.LMH;
    this.LMB = l.bb((Activity)getActivity());
    paramBundle = this.LMB;
    if (paramBundle != null)
    {
      localObject = com.tencent.mm.plugin.mv.ui.a.Maz;
      com.tencent.mm.plugin.mv.ui.a.a(paramBundle, this.LWI);
    }
    paramBundle = getIntent().getByteArrayExtra("key_track_data");
    if (paramBundle != null) {
      this.LZM.parseFrom(paramBundle);
    }
    paramBundle = this.LZM.aaYK;
    if (paramBundle != null)
    {
      paramBundle = paramBundle.objectDesc;
      if (paramBundle != null)
      {
        paramBundle = paramBundle.mvInfo;
        if (paramBundle != null)
        {
          paramBundle = paramBundle.LWI;
          if (paramBundle != null)
          {
            s.u(paramBundle, "<set-?>");
            this.LWI = paramBundle;
          }
        }
      }
    }
    Object localObject = this.LMB;
    dtf localdtf = this.LZM;
    int i;
    if ((localObject != null) && (localdtf != null))
    {
      paramBundle = (CharSequence)((com.tencent.mm.plugin.music.model.e.a)localObject).field_songHAlbumUrl;
      if ((paramBundle != null) && (paramBundle.length() != 0)) {
        break label582;
      }
      i = 1;
      if (i != 0)
      {
        paramBundle = localdtf.aaYK;
        if (paramBundle != null) {
          break label587;
        }
        paramBundle = null;
        label185:
        ((com.tencent.mm.plugin.music.model.e.a)localObject).field_songHAlbumUrl = paramBundle;
      }
      paramBundle = (CharSequence)((com.tencent.mm.plugin.music.model.e.a)localObject).field_songLyric;
      if ((paramBundle != null) && (paramBundle.length() != 0)) {
        break label637;
      }
      i = 1;
      label215:
      if (i != 0)
      {
        paramBundle = localdtf.aaYK;
        if (paramBundle != null) {
          break label642;
        }
        paramBundle = null;
        label231:
        ((com.tencent.mm.plugin.music.model.e.a)localObject).field_songLyric = paramBundle;
      }
    }
    this.fromScene = getIntent().getIntExtra("key_mv_enter_maker_ui_from_scene", 3);
    if ((this.LZM.Mea <= 0) && (com.tencent.mm.plugin.music.model.m.dsS()))
    {
      this.LZM.Mea = 8192;
      paramBundle = this.LZM.aaYK;
      if (paramBundle != null)
      {
        paramBundle = paramBundle.objectDesc;
        if (paramBundle != null)
        {
          paramBundle = paramBundle.mvInfo;
          if (paramBundle != null)
          {
            localObject = paramBundle.LWI;
            if (localObject != null)
            {
              s.u(localObject, "songInfo");
              Log.i("MicroMsg.Mv.MusicMvMakerDataUIC", s.X("syncBeatTrack duration:", Integer.valueOf(((boo)localObject).duration)));
              paramBundle = new dsf();
              paramBundle.aaXV = ((boo)localObject).mLQ;
              paramBundle.ZTw = ((boo)localObject).songName;
              paramBundle.rDl = ((boo)localObject).rDl;
              paramBundle.aaYa = ((boo)localObject).musicDataUrl;
              paramBundle.xmo = ((boo)localObject).ZWR;
              paramBundle.aaYb = ((boo)localObject).duration;
              paramBundle.LWI = ((boo)localObject);
              localObject = h.LYU;
              paramBundle = h.a.a(paramBundle);
              localObject = b.ovw;
              paramBundle = b.a.e(paramBundle);
              localObject = com.tencent.mm.ui.component.k.aeZF;
              localObject = com.tencent.mm.ui.component.k.d(getActivity()).q(com.tencent.mm.plugin.mvvmbase.a.a.class);
              s.s(localObject, "UICProvider.of(activity)…ycleScopeUIC::class.java)");
              LifecycleScope.launchDefault$default(((com.tencent.mm.plugin.mvvmbase.a.a)localObject).gsu(), null, (kotlin.g.a.m)new j.c(paramBundle, this, null), 1, null);
            }
          }
        }
      }
    }
    this.Mfe.t(this.LZM);
    paramBundle = v.FrN;
    boolean bool;
    if (this.LZM.localId != 0L)
    {
      bool = true;
      label519:
      v.aP(10, bool);
      paramBundle = v.FrN;
      v.Sx(5);
      paramBundle = v.FrN;
      paramBundle = this.LMB;
      if (paramBundle != null) {
        break label697;
      }
      paramBundle = "";
    }
    for (;;)
    {
      v.azL(paramBundle);
      paramBundle = v.FrN;
      v.Sy(2);
      paramBundle = v.FrN;
      v.pE(this.LZM.localId);
      AppMethodBeat.o(287717);
      return;
      label582:
      i = 0;
      break;
      label587:
      paramBundle = paramBundle.objectDesc;
      if (paramBundle == null)
      {
        paramBundle = null;
        break label185;
      }
      paramBundle = paramBundle.mvInfo;
      if (paramBundle == null)
      {
        paramBundle = null;
        break label185;
      }
      paramBundle = paramBundle.LWI;
      if (paramBundle == null)
      {
        paramBundle = null;
        break label185;
      }
      paramBundle = paramBundle.ZWS;
      break label185;
      label637:
      i = 0;
      break label215;
      label642:
      paramBundle = paramBundle.objectDesc;
      if (paramBundle == null)
      {
        paramBundle = null;
        break label231;
      }
      paramBundle = paramBundle.mvInfo;
      if (paramBundle == null)
      {
        paramBundle = null;
        break label231;
      }
      paramBundle = paramBundle.LWI;
      if (paramBundle == null)
      {
        paramBundle = null;
        break label231;
      }
      paramBundle = paramBundle.Mcq;
      break label231;
      bool = false;
      break label519;
      label697:
      localObject = paramBundle.field_musicId;
      paramBundle = (Bundle)localObject;
      if (localObject == null) {
        paramBundle = "";
      }
    }
  }
  
  public final void zZ(boolean paramBoolean)
  {
    AppMethodBeat.i(287724);
    com.tencent.mm.plugin.mv.model.m localm = com.tencent.mm.plugin.mv.model.m.LYc;
    com.tencent.mm.plugin.mv.model.m.a((Context)getContext(), this.LWI, this.LZM, this.fromScene, paramBoolean);
    AppMethodBeat.o(287724);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.uic.j
 * JD-Core Version:    0.7.0.1
 */