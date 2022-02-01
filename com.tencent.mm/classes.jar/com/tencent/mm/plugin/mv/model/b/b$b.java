package com.tencent.mm.plugin.mv.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.l;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
final class b$b
  extends k
  implements m<aq, d<? super ah>, Object>
{
  int label;
  
  b$b(GalleryItem.VideoMediaItem paramVideoMediaItem, kotlin.g.a.a<ah> parama, d<? super b> paramd)
  {
    super(2, paramd);
  }
  
  public final d<ah> create(Object paramObject, d<?> paramd)
  {
    AppMethodBeat.i(286221);
    paramObject = (d)new b(this.LZA, this.nBK, paramd);
    AppMethodBeat.o(286221);
    return paramObject;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(286214);
    kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(286214);
      throw paramObject;
    case 0: 
      ResultKt.throwOnFailure(paramObject);
      Log.i("MicroMsg.Mv.MvPreviewDataSource", "load width and height");
      Object localObject = this.LZA.bud();
      paramObject = localObject;
      if (localObject == null) {
        paramObject = "";
      }
      localObject = SightVideoJNI.getSimpleMp4InfoVFS(paramObject);
      s.s(localObject, "getSimpleMp4InfoVFS(path)");
      Log.i("MicroMsg.Mv.MvPreviewDataSource", "get simple mp4 info %s", new Object[] { localObject });
      localObject = new JSONObject((String)localObject);
      this.LZA.oTN = ((JSONObject)localObject).getInt("videoDuration");
      this.LZA.videoHeight = ((JSONObject)localObject).getInt("videoHeight");
      this.LZA.videoWidth = ((JSONObject)localObject).getInt("videoWidth");
      this.LZA.videoBitRate = ((JSONObject)localObject).getInt("videoBitrate");
      this.LZA.videoFrameRate = ((JSONObject)localObject).getInt("videoFPS");
      this.LZA.nCg = SightVideoJNI.getMp4RotateVFS(paramObject);
      this.LZA.videoIFrameInterval = 0;
      this.LZA.oTL = com.tencent.mm.plugin.gallery.b.f.aFg(((JSONObject)localObject).getString("videoType"));
      this.LZA.oTM = com.tencent.mm.plugin.gallery.b.f.aFg(((JSONObject)localObject).getString("audioType"));
      paramObject = (kotlin.d.f)bg.kCh();
      localObject = (m)new b.b.1(this.nBK, null);
      d locald = (d)this;
      this.label = 1;
      if (l.a(paramObject, (m)localObject, locald) == locala)
      {
        AppMethodBeat.o(286214);
        return locala;
      }
      break;
    case 1: 
      ResultKt.throwOnFailure(paramObject);
    }
    paramObject = ah.aiuX;
    AppMethodBeat.o(286214);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.model.b.b.b
 * JD-Core Version:    0.7.0.1
 */