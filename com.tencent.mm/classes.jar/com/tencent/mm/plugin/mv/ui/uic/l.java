package com.tencent.mm.plugin.mv.ui.uic;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.a.b.a;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.mv.model.a.e;
import com.tencent.mm.plugin.mv.model.a.e.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.bdp;
import com.tencent.mm.protocal.protobuf.bds;
import com.tencent.mm.protocal.protobuf.dax;
import com.tencent.mm.protocal.protobuf.day;
import com.tencent.mm.protocal.protobuf.dbo;
import com.tencent.mm.sdk.coroutines.LifecycleScope;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.g.a;
import java.util.LinkedList;
import kotlin.ResultKt;
import kotlin.d.b.a.j;
import kotlin.f;
import kotlin.g.b.p;
import kotlin.t;
import kotlin.x;
import kotlinx.coroutines.ak;
import kotlinx.coroutines.b.c;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerDataUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "_trackDataLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mm/protocal/protobuf/MusicMvData;", "fromScene", "", "music", "Lcom/tencent/mm/plugin/music/model/storage/Music;", "getMusic", "()Lcom/tencent/mm/plugin/music/model/storage/Music;", "setMusic", "(Lcom/tencent/mm/plugin/music/model/storage/Music;)V", "mvTypeLiveData", "getMvTypeLiveData", "()Landroidx/lifecycle/MutableLiveData;", "mvTypeLiveData$delegate", "Lkotlin/Lazy;", "songInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "getSongInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "setSongInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;)V", "trackData", "trackDataLiveData", "Landroidx/lifecycle/LiveData;", "getTrackDataLiveData", "()Landroidx/lifecycle/LiveData;", "setTrackDataLiveData", "(Landroidx/lifecycle/LiveData;)V", "initData", "", "isFlexMode", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "reportEnterCreateMv", "syncBeatTrack", "Companion", "plugin-mv_release"})
public final class l
  extends UIComponent
{
  public static final l.a Gkq;
  public com.tencent.mm.plugin.music.model.e.a FRG;
  public bds GaB;
  private dbo Geg;
  private final r<dbo> Gkn;
  public LiveData<dbo> Gko;
  private final f Gkp;
  private int fromScene;
  
  static
  {
    AppMethodBeat.i(230262);
    Gkq = new l.a((byte)0);
    AppMethodBeat.o(230262);
  }
  
  public l(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(230259);
    this.GaB = new bds();
    this.Gkn = new r();
    paramAppCompatActivity = this.Gkn;
    if (paramAppCompatActivity == null)
    {
      paramAppCompatActivity = new t("null cannot be cast to non-null type androidx.lifecycle.LiveData<com.tencent.mm.protocal.protobuf.MusicMvData>");
      AppMethodBeat.o(230259);
      throw paramAppCompatActivity;
    }
    this.Gko = ((LiveData)paramAppCompatActivity);
    this.Geg = new dbo();
    this.fromScene = 3;
    this.Gkp = kotlin.g.ar((kotlin.g.a.a)l.b.Gkr);
    AppMethodBeat.o(230259);
  }
  
  public final boolean fgD()
  {
    AppMethodBeat.i(230257);
    Integer localInteger = (Integer)fhe().getValue();
    if (localInteger == null) {}
    while (localInteger.intValue() != 1)
    {
      AppMethodBeat.o(230257);
      return false;
    }
    AppMethodBeat.o(230257);
    return true;
  }
  
  public final r<Integer> fhe()
  {
    AppMethodBeat.i(230254);
    r localr = (r)this.Gkp.getValue();
    AppMethodBeat.o(230254);
    return localr;
  }
  
  public final void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(230248);
    super.onCreate(paramBundle);
    paramBundle = com.tencent.mm.plugin.music.model.l.FRM;
    this.FRG = com.tencent.mm.plugin.music.model.l.aA((Activity)getActivity());
    paramBundle = this.FRG;
    if (paramBundle != null)
    {
      localObject = com.tencent.mm.plugin.mv.ui.a.Gfi;
      com.tencent.mm.plugin.mv.ui.a.a(paramBundle, this.GaB);
    }
    paramBundle = getIntent().getByteArrayExtra("key_track_data");
    if (paramBundle != null) {
      this.Geg.parseFrom(paramBundle);
    }
    paramBundle = this.Geg.TIV;
    if (paramBundle != null)
    {
      paramBundle = paramBundle.objectDesc;
      if (paramBundle != null)
      {
        paramBundle = paramBundle.mvInfo;
        if (paramBundle != null)
        {
          paramBundle = paramBundle.GaB;
          if (paramBundle != null)
          {
            p.j(paramBundle, "it");
            this.GaB = paramBundle;
          }
        }
      }
    }
    Object localObject = this.FRG;
    dbo localdbo = this.Geg;
    int i;
    label291:
    if ((localObject != null) && (localdbo != null))
    {
      paramBundle = (CharSequence)((com.tencent.mm.plugin.music.model.e.a)localObject).field_songHAlbumUrl;
      if ((paramBundle != null) && (paramBundle.length() != 0)) {
        break label657;
      }
      i = 1;
      if (i != 0)
      {
        paramBundle = localdbo.TIV;
        if (paramBundle == null) {
          break label662;
        }
        paramBundle = paramBundle.objectDesc;
        if (paramBundle == null) {
          break label662;
        }
        paramBundle = paramBundle.mvInfo;
        if (paramBundle == null) {
          break label662;
        }
        paramBundle = paramBundle.GaB;
        if (paramBundle == null) {
          break label662;
        }
        paramBundle = paramBundle.SOM;
        label215:
        ((com.tencent.mm.plugin.music.model.e.a)localObject).field_songHAlbumUrl = paramBundle;
      }
      paramBundle = (CharSequence)((com.tencent.mm.plugin.music.model.e.a)localObject).field_songLyric;
      if ((paramBundle != null) && (paramBundle.length() != 0)) {
        break label667;
      }
      i = 1;
      label245:
      if (i != 0)
      {
        paramBundle = localdbo.TIV;
        if (paramBundle == null) {
          break label672;
        }
        paramBundle = paramBundle.objectDesc;
        if (paramBundle == null) {
          break label672;
        }
        paramBundle = paramBundle.mvInfo;
        if (paramBundle == null) {
          break label672;
        }
        paramBundle = paramBundle.GaB;
        if (paramBundle == null) {
          break label672;
        }
        paramBundle = paramBundle.SOL;
        ((com.tencent.mm.plugin.music.model.e.a)localObject).field_songLyric = paramBundle;
      }
    }
    this.fromScene = getIntent().getIntExtra("key_mv_enter_maker_ui_from_scene", 3);
    if ((this.Geg.GiZ <= 0) && (com.tencent.mm.plugin.music.model.m.cPm()))
    {
      this.Geg.GiZ = 8192;
      paramBundle = this.Geg.TIV;
      if (paramBundle != null)
      {
        paramBundle = paramBundle.objectDesc;
        if (paramBundle != null)
        {
          paramBundle = paramBundle.mvInfo;
          if (paramBundle != null)
          {
            localObject = paramBundle.GaB;
            if (localObject != null)
            {
              p.j(localObject, "it");
              p.k(localObject, "songInfo");
              Log.i("MicroMsg.Mv.MusicMvMakerDataUIC", "syncBeatTrack duration:" + ((bds)localObject).duration);
              paramBundle = new dax();
              paramBundle.TIm = ((bds)localObject).kkU;
              paramBundle.SMU = ((bds)localObject).HLH;
              paramBundle.ozs = ((bds)localObject).ozs;
              paramBundle.TIr = ((bds)localObject).musicDataUrl;
              paramBundle.ugh = ((bds)localObject).SOK;
              paramBundle.TIs = ((bds)localObject).duration;
              paramBundle.GaB = ((bds)localObject);
              localObject = e.Gdm;
              paramBundle = e.a.a(paramBundle);
              localObject = com.tencent.mm.an.a.b.lDL;
              paramBundle = b.a.f(paramBundle);
              localObject = com.tencent.mm.ui.component.g.Xox;
              localObject = com.tencent.mm.ui.component.g.b(getActivity()).i(com.tencent.mm.plugin.livebase.a.a.class);
              p.j(localObject, "UICProvider.of(activity)…ycleScopeUIC::class.java)");
              LifecycleScope.launch$default(((com.tencent.mm.plugin.livebase.a.a)localObject).eLM(), null, (kotlin.g.a.m)new c(this, paramBundle, null), 1, null);
            }
          }
        }
      }
    }
    this.Gkn.L(this.Geg);
    paramBundle = k.zWs;
    if (this.Geg.localId != 0L) {}
    for (boolean bool = true;; bool = false)
    {
      k.av(10, bool);
      paramBundle = k.zWs;
      k.Pt(5);
      paramBundle = k.zWs;
      paramBundle = this.FRG;
      if (paramBundle != null)
      {
        localObject = paramBundle.field_musicId;
        paramBundle = (Bundle)localObject;
        if (localObject != null) {}
      }
      else
      {
        paramBundle = "";
      }
      k.aDW(paramBundle);
      paramBundle = k.zWs;
      k.Pu(2);
      AppMethodBeat.o(230248);
      return;
      label657:
      i = 0;
      break;
      label662:
      paramBundle = null;
      break label215;
      label667:
      i = 0;
      break label245;
      label672:
      paramBundle = null;
      break label291;
    }
  }
  
  public final void vE(boolean paramBoolean)
  {
    AppMethodBeat.i(230251);
    com.tencent.mm.plugin.mv.model.m localm = com.tencent.mm.plugin.mv.model.m.GcA;
    com.tencent.mm.plugin.mv.model.m.a((Context)getContext(), this.GaB, this.Geg, this.fromScene, paramBoolean);
    AppMethodBeat.o(230251);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class c
    extends j
    implements kotlin.g.a.m<ak, kotlin.d.d<? super x>, Object>
  {
    Object L$0;
    int label;
    Object oDA;
    private ak p$;
    
    c(l paraml, kotlinx.coroutines.b.b paramb, kotlin.d.d paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<x> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(243530);
      p.k(paramd, "completion");
      paramd = new c(this.Gks, paramBundle, paramd);
      paramd.p$ = ((ak)paramObject);
      AppMethodBeat.o(243530);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(243531);
      paramObject1 = ((c)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(x.aazN);
      AppMethodBeat.o(243531);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(243529);
      kotlin.d.a.a locala = kotlin.d.a.a.aaAA;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(243529);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.p$;
        kotlinx.coroutines.b.b localb = paramBundle;
        c localc = (c)new a(this);
        this.L$0 = paramObject;
        this.oDA = localb;
        this.label = 1;
        if (localb.a(localc, this) == locala)
        {
          AppMethodBeat.o(243529);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = x.aazN;
      AppMethodBeat.o(243529);
      return paramObject;
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"})
    public static final class a
      implements c<com.tencent.mm.an.a.a<day>>
    {
      public a(l.c paramc) {}
      
      public final Object a(Object paramObject, kotlin.d.d paramd)
      {
        AppMethodBeat.i(233987);
        paramd = (com.tencent.mm.an.a.a)paramObject;
        if (paramd.lDS == com.tencent.mm.an.b.b.lDQ)
        {
          StringBuilder localStringBuilder = new StringBuilder("syncBeatTrack sceneEnd errType:").append(paramd.errType).append(" errCode:").append(paramd.errCode).append(" errMsg:").append(paramd.errMsg).append(" flexSize:");
          paramObject = (day)paramd.lBJ;
          if (paramObject == null) {
            break label180;
          }
          paramObject = paramObject.TIu;
          if (paramObject == null) {
            break label180;
          }
          paramObject = Integer.valueOf(paramObject.size());
          Log.i("MicroMsg.Mv.MusicMvMakerDataUIC", paramObject);
          if (paramd.errCode == 0)
          {
            paramObject = (dbo)l.a(this.Gku.Gks).getValue();
            if (paramObject != null)
            {
              paramd = (day)paramd.lBJ;
              if (paramd == null) {
                break label185;
              }
              paramd = paramd.TIu;
              if (paramd == null) {
                break label185;
              }
            }
          }
        }
        label180:
        label185:
        for (int i = paramd.size();; i = 20)
        {
          paramObject.GiZ = i;
          paramObject = x.aazN;
          AppMethodBeat.o(233987);
          return paramObject;
          paramObject = null;
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.uic.l
 * JD-Core Version:    0.7.0.1
 */