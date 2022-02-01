package com.tencent.mm.plugin.recordvideo.util;

import android.graphics.Point;
import android.media.MediaMetadataRetriever;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelcontrol.e;
import com.tencent.mm.plugin.recordvideo.c.j;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.b;
import com.tencent.mm.plugin.sight.base.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/util/MediaRecordParamUtil;", "", "()V", "TAG", "", "checkConfigProviderParam", "", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "getVideoInfo", "Lcom/tencent/mm/plugin/recordvideo/util/MediaRecordParamUtil$VideoInfo;", "path", "VideoInfo", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
{
  public static final g Obu;
  
  static
  {
    AppMethodBeat.i(76222);
    Obu = new g();
    AppMethodBeat.o(76222);
  }
  
  public static g.a aTF(String paramString)
  {
    boolean bool = true;
    AppMethodBeat.i(76221);
    s.u(paramString, "path");
    b localb = f.aVX(paramString);
    if (localb == null)
    {
      AppMethodBeat.o(76221);
      return null;
    }
    if ((localb.height <= 0) || (localb.width <= 0)) {}
    try
    {
      MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
      localMediaMetadataRetriever.setDataSource(paramString);
      localb.width = Util.getInt(localMediaMetadataRetriever.extractMetadata(18), 0);
      localb.height = Util.getInt(localMediaMetadataRetriever.extractMetadata(19), 0);
      localb.videoBitrate = Util.getInt(localMediaMetadataRetriever.extractMetadata(20), 0);
      localMediaMetadataRetriever.release();
      label116:
      int k = SightVideoJNI.getMp4RotateVFS(paramString);
      paramString = aw.bf(MMApplicationContext.getContext());
      int j;
      int i;
      if ((k == 270) || (k == 90))
      {
        j = 1;
        if (j == 0) {
          break label254;
        }
        i = localb.height;
        label153:
        if (j == 0) {
          break label263;
        }
        j = localb.width;
        label163:
        if (Math.abs(i / j - paramString.x / paramString.y) > 0.01D) {
          break label272;
        }
      }
      for (;;)
      {
        paramString = new g.a(localb.width, localb.height, localb.videoDuration, k, localb.videoBitrate, localb.frameRate, bool, localb.Obw, localb.Obx, localb.Oby);
        AppMethodBeat.o(76221);
        return paramString;
        j = 0;
        break;
        label254:
        i = localb.width;
        break label153;
        label263:
        j = localb.height;
        break label163;
        label272:
        bool = false;
      }
    }
    catch (Exception localException)
    {
      break label116;
    }
  }
  
  public static void q(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(76220);
    s.u(paramRecordConfigProvider, "configProvider");
    if (paramRecordConfigProvider.oXZ == null)
    {
      if (paramRecordConfigProvider.scene == 2) {
        paramRecordConfigProvider.oXZ = e.bIg().bIk();
      }
      Log.i("MicroMsg.MediaRecordParamUtil", s.X("checkConfigProviderParam ", paramRecordConfigProvider.oXZ));
    }
    if (paramRecordConfigProvider.oXZ == null)
    {
      AppMethodBeat.o(76220);
      return;
    }
    Object localObject = j.NHe;
    localObject = j.agv(paramRecordConfigProvider.scene);
    if (localObject != null)
    {
      j localj = j.NHe;
      int i = j.bI((JSONObject)localObject);
      localj = j.NHe;
      int j = j.bJ((JSONObject)localObject);
      if ((i > 0) || (j > 0))
      {
        int k = paramRecordConfigProvider.oXZ.width;
        int m = paramRecordConfigProvider.oXZ.height;
        paramRecordConfigProvider.oXZ.width = i;
        paramRecordConfigProvider.oXZ.height = j;
        if (i <= 0) {
          paramRecordConfigProvider.oXZ.width = (k * j / m);
        }
        if (j <= 0) {
          paramRecordConfigProvider.oXZ.height = (m * i / k);
        }
        Log.i("MicroMsg.MediaRecordParamUtil", "force change video width:" + paramRecordConfigProvider.oXZ.width + "  height:" + paramRecordConfigProvider.oXZ.height + " ; config width:" + i + " height:" + j);
      }
    }
    AppMethodBeat.o(76220);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.util.g
 * JD-Core Version:    0.7.0.1
 */