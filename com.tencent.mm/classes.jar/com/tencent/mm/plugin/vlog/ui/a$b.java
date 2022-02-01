package com.tencent.mm.plugin.vlog.ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.bbg;
import com.tencent.mm.protocal.protobuf.bqj;
import com.tencent.mm.protocal.protobuf.bqz;
import com.tencent.mm.protocal.protobuf.bxt;
import com.tencent.mm.protocal.protobuf.bxv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.a.p;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.l;

@Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
final class a$b
  extends k
  implements m<aq, d<? super String>, Object>
{
  Object L$0;
  Object Uf;
  Object VC;
  Object VD;
  Object Ze;
  int label;
  
  a$b(String paramString, FinderObject paramFinderObject, a parama, d<? super b> paramd)
  {
    super(2, paramd);
  }
  
  public final d<ah> create(Object paramObject, d<?> paramd)
  {
    AppMethodBeat.i(281445);
    paramObject = (d)new b(this.svx, this.UeY, this.UeX, paramd);
    AppMethodBeat.o(281445);
    return paramObject;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(281438);
    kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
    Object localObject3;
    int i;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(281438);
      throw paramObject;
    case 0: 
      ResultKt.throwOnFailure(paramObject);
      localObject3 = this.svx;
      paramObject = this.UeY.objectDesc;
      if (paramObject == null)
      {
        paramObject = "";
        if (((CharSequence)paramObject).length() != 0) {
          break label214;
        }
        i = 1;
        label96:
        if (i == 0) {
          break label1084;
        }
        paramObject = Util.getUnsignedLongString(this.UeY.id);
        s.s(paramObject, "getUnsignedLongString(finderObj.id)");
      }
      break;
    }
    label567:
    label1084:
    for (;;)
    {
      Object localObject2;
      try
      {
        localObject1 = (com.tencent.mm.am.b)new com.tencent.mm.plugin.findersdk.b.a(paramObject, kotlin.d.b.a.b.BF(this.UeY.id));
        localObject2 = (d)this;
        this.L$0 = localObject3;
        this.Uf = paramObject;
        this.label = 1;
        localObject1 = com.tencent.mm.af.b.a((com.tencent.mm.am.b)localObject1, (d)localObject2);
        if (localObject1 != locala) {
          break label1076;
        }
        AppMethodBeat.o(281438);
        return locala;
      }
      catch (com.tencent.mm.af.a paramObject)
      {
        Log.e("MicroMsg.EditAddMusicPlugin", s.X("GetFinderTopic fail:", paramObject.getLocalizedMessage()));
        AppMethodBeat.o(281438);
        return null;
      }
      paramObject = paramObject.feedBgmInfo;
      if (paramObject == null)
      {
        paramObject = "";
        break;
      }
      Object localObject1 = paramObject.groupId;
      paramObject = localObject1;
      if (localObject1 != null) {
        break;
      }
      paramObject = "";
      break;
      label214:
      i = 0;
      break label96;
      Object localObject4 = (String)this.Uf;
      localObject3 = (String)this.L$0;
      ResultKt.throwOnFailure(paramObject);
      paramObject = (bbg)paramObject;
      paramObject = paramObject.ZLU;
      Object localObject7;
      Object localObject5;
      Object localObject6;
      if (paramObject == null)
      {
        localObject7 = null;
        if (localObject7 == null) {
          break label1033;
        }
        localObject2 = Util.getUnsignedLongString(this.UeY.id);
        paramObject = ((bxt)localObject7).groupId;
        if (paramObject == null)
        {
          paramObject = localObject2;
          localObject1 = ((bxt)localObject7).contact;
          if (localObject1 != null) {
            break label567;
          }
          localObject1 = null;
          s.p(localObject1, z.bAW());
          localObject5 = new ah.f();
          localObject6 = new ah.f();
          localObject1 = this.UeY.objectDesc;
          if (localObject1 != null) {
            break label575;
          }
          localObject1 = null;
          if (localObject1 != null) {
            break label620;
          }
          if (localObject1 != null) {
            break label766;
          }
          localObject1 = (CharSequence)((ah.f)localObject5).aqH;
          if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
            break label787;
          }
          i = 1;
          if (i == 0) {
            break label1062;
          }
          localObject4 = h.baE().mCJ + "finder/tmp/" + (String)localObject4;
          Log.i("MicroMsg.EditAddMusicPlugin", "originBgmUrl is null, ready to extract audio from " + this.svx + " to " + (String)localObject4);
          localObject1 = (kotlin.d.f)bg.kCi();
          localObject3 = (m)new a(this.svx, (String)localObject4, null);
          localObject7 = (d)this;
          this.L$0 = localObject2;
          this.Uf = paramObject;
          this.VC = localObject5;
          this.VD = localObject6;
          this.Ze = localObject4;
          this.label = 2;
          localObject7 = l.a((kotlin.d.f)localObject1, (m)localObject3, (d)localObject7);
          if (localObject7 != locala) {
            break label1048;
          }
          AppMethodBeat.o(281438);
          return locala;
        }
      }
      else
      {
        localObject7 = paramObject.aagH;
        continue;
      }
      continue;
      localObject1 = ((FinderContact)localObject1).username;
      continue;
      label575:
      localObject1 = ((FinderObjectDesc)localObject1).media;
      if (localObject1 == null)
      {
        localObject1 = null;
      }
      else
      {
        localObject1 = (FinderMedia)p.oL((List)localObject1);
        if (localObject1 == null)
        {
          localObject1 = null;
        }
        else
        {
          localObject1 = Integer.valueOf(((FinderMedia)localObject1).mediaType);
          continue;
          label620:
          if (((Integer)localObject1).intValue() == 2)
          {
            bqj localbqj1 = ((bxt)localObject7).musicInfo;
            if (localbqj1 != null)
            {
              ((ah.f)localObject5).aqH = localbqj1.ZYp;
              ((ah.f)localObject6).aqH = new bqj();
              localObject1 = (bqj)((ah.f)localObject6).aqH;
              if (localObject1 != null) {
                ((bqj)localObject1).HsD = paramObject;
              }
              bqj localbqj2 = (bqj)((ah.f)localObject6).aqH;
              if (localbqj2 != null)
              {
                localObject7 = localbqj1.ZYp;
                localObject1 = localObject7;
                if (localObject7 == null) {
                  localObject1 = "";
                }
                localbqj2.ZYp = ((String)localObject1);
              }
              localObject1 = (bqj)((ah.f)localObject6).aqH;
              if (localObject1 != null) {
                ((bqj)localObject1).artist = localbqj1.artist;
              }
              localObject1 = (bqj)((ah.f)localObject6).aqH;
              if (localObject1 != null)
              {
                ((bqj)localObject1).name = localbqj1.name;
                continue;
                label766:
                if (((Integer)localObject1).intValue() == 4)
                {
                  ((ah.f)localObject5).aqH = ((bxt)localObject7).audioTrackUrl;
                  continue;
                  i = 0;
                  continue;
                  localObject4 = (String)this.Ze;
                  localObject1 = (ah.f)this.VD;
                  localObject3 = (ah.f)this.VC;
                  localObject6 = (String)this.Uf;
                  localObject2 = (String)this.L$0;
                  ResultKt.throwOnFailure(paramObject);
                  localObject5 = paramObject;
                  paramObject = localObject6;
                  if (((Boolean)localObject5).booleanValue())
                  {
                    Log.i("MicroMsg.EditAddMusicPlugin", "extract audio success!");
                    localObject5 = localObject4;
                    localObject4 = localObject3;
                  }
                  for (;;)
                  {
                    CaptureDataManager.NHH.rnY.putString("ORIGIN_MUSIC_ID", paramObject);
                    CaptureDataManager.NHH.rnY.putString("ORIGIN_MUSIC_PATH", (String)localObject5);
                    localObject3 = CaptureDataManager.NHH.rnY;
                    paramObject = (bqj)((ah.f)localObject1).aqH;
                    if (paramObject == null)
                    {
                      paramObject = null;
                      ((Bundle)localObject3).putByteArray("ORIGIN_MUSIC_INFO", paramObject);
                      paramObject = CaptureDataManager.NHH.rnY;
                      localObject1 = this.UeX.Gss;
                      if (localObject1 != null) {
                        break label1025;
                      }
                    }
                    for (i = 0;; i = ((AudioCacheInfo)localObject1).source)
                    {
                      paramObject.putInt("SOUND_TRACK_TYPE", i);
                      CaptureDataManager.NHH.rnY.putString("ORIGIN_BGM_URL", (String)((ah.f)localObject4).aqH);
                      CaptureDataManager.NHH.rnY.putString("MUSIC_FEED_ID", (String)localObject2);
                      AppMethodBeat.o(281438);
                      return localObject5;
                      Log.e("MicroMsg.EditAddMusicPlugin", "extract audio fail!");
                      AppMethodBeat.o(281438);
                      return null;
                      paramObject = paramObject.toByteArray();
                      break;
                    }
                    Log.e("MicroMsg.EditAddMusicPlugin", "bgmInfo is null");
                    AppMethodBeat.o(281438);
                    return null;
                    localObject1 = localObject6;
                    localObject3 = localObject5;
                    localObject5 = localObject7;
                    break;
                    localObject1 = localObject6;
                    localObject4 = localObject5;
                    localObject5 = localObject3;
                  }
                  localObject4 = paramObject;
                  paramObject = localObject1;
                }
              }
            }
          }
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends k
    implements m<aq, d<? super Boolean>, Object>
  {
    int label;
    
    a(String paramString1, String paramString2, d<? super a> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(281849);
      paramObject = (d)new a(this.svx, this.UeZ, paramd);
      AppMethodBeat.o(281849);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(281841);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(281841);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      paramObject = com.tencent.mm.plugin.vlog.remux.a.UdR;
      boolean bool = com.tencent.mm.plugin.vlog.remux.a.nr(this.svx, this.UeZ);
      AppMethodBeat.o(281841);
      return Boolean.valueOf(bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.a.b
 * JD-Core Version:    0.7.0.1
 */