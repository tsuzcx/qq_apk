package com.tencent.mm.plugin.recordvideo.b;

import a.f.b.j;
import a.l;
import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.editor.a.a;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.story.e.c;
import com.tencent.mm.plugin.story.e.c.a;
import com.tencent.mm.plugin.story.e.c.a.a;
import com.tencent.mm.plugin.story.model.audio.AudioCacheInfo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.af;
import java.util.ArrayList;
import java.util.Arrays;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/recordvideo/config/RemuxMediaEditConfig;", "", "muteOrigin", "", "audioCacheInfo", "Lcom/tencent/mm/plugin/story/model/audio/AudioCacheInfo;", "editItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/media/editor/item/BaseEditorItem;", "editDatas", "Lcom/tencent/mm/media/editor/item/BaseEditorData;", "drawingRect", "", "reMuxStartTimeMs", "", "reMuxEndTimeMs", "(ZLcom/tencent/mm/plugin/story/model/audio/AudioCacheInfo;Ljava/util/ArrayList;Ljava/util/ArrayList;[FII)V", "getAudioCacheInfo", "()Lcom/tencent/mm/plugin/story/model/audio/AudioCacheInfo;", "setAudioCacheInfo", "(Lcom/tencent/mm/plugin/story/model/audio/AudioCacheInfo;)V", "getDrawingRect", "()[F", "setDrawingRect", "([F)V", "getEditDatas", "()Ljava/util/ArrayList;", "setEditDatas", "(Ljava/util/ArrayList;)V", "getEditItems", "setEditItems", "getMuteOrigin", "()Z", "setMuteOrigin", "(Z)V", "getReMuxEndTimeMs", "()I", "setReMuxEndTimeMs", "(I)V", "getReMuxStartTimeMs", "setReMuxStartTimeMs", "generateTargetConfig", "Lcom/tencent/mm/plugin/recordvideo/config/RemuxMediaEditConfig$EncodeConfig;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "mediaCaptureInfo", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "isLandVideo", "videoInfo", "Lcom/tencent/mm/plugin/story/data/StoryUtil$Companion$VideoInfo;", "setSize", "", "config", "toString", "", "videoConfigForFile", "videoPath", "Companion", "EncodeConfig", "plugin-recordvideo_release"})
public final class b
{
  public static final b.a qbb;
  public boolean qaU;
  public AudioCacheInfo qaV;
  public ArrayList<com.tencent.mm.media.editor.a.b> qaW;
  private ArrayList<a> qaX;
  public float[] qaY;
  public int qaZ;
  public int qba;
  
  static
  {
    AppMethodBeat.i(150577);
    qbb = new b.a((byte)0);
    AppMethodBeat.o(150577);
  }
  
  public b(boolean paramBoolean, AudioCacheInfo paramAudioCacheInfo, ArrayList<com.tencent.mm.media.editor.a.b> paramArrayList, ArrayList<a> paramArrayList1, float[] paramArrayOfFloat, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(150575);
    this.qaU = paramBoolean;
    this.qaV = paramAudioCacheInfo;
    this.qaW = paramArrayList;
    this.qaX = paramArrayList1;
    this.qaY = paramArrayOfFloat;
    this.qaZ = paramInt1;
    this.qba = paramInt2;
    AppMethodBeat.o(150575);
  }
  
  public static b.b a(String paramString, RecordConfigProvider paramRecordConfigProvider, b.b paramb)
  {
    AppMethodBeat.i(150573);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(150573);
      return paramb;
    }
    Object localObject = c.ssB;
    if (paramString == null) {
      j.ebi();
    }
    paramString = c.a.acN(paramString);
    int i;
    int j;
    int k;
    if (paramString != null)
    {
      paramb.fzT = paramRecordConfigProvider.qbq.fzT;
      paramb.audioSampleRate = paramRecordConfigProvider.qbq.audioSampleRate;
      paramb.videoBitrate = paramString.videoBitrate;
      paramb.eWL = paramString.rotate;
      paramb.eRF = paramRecordConfigProvider.qbq.eRF;
      ab.d("MicroMsg.RemuxMediaEditConfig", "video info : ".concat(String.valueOf(paramString)));
      if (paramString.videoBitrate - 200000 > paramRecordConfigProvider.qbq.videoBitrate)
      {
        paramb.videoBitrate = paramRecordConfigProvider.qbq.videoBitrate;
        paramb.qbc = true;
        ab.i("MicroMsg.RemuxMediaEditConfig", "remux by high videoBitrate " + paramString.videoBitrate + "  " + paramRecordConfigProvider.qbq.videoBitrate);
      }
      i = paramRecordConfigProvider.qbq.width;
      j = paramRecordConfigProvider.qbq.height;
      if (paramString.width <= paramString.height) {
        break label450;
      }
      k = 1;
      if (k == 0) {
        break label688;
      }
    }
    for (;;)
    {
      if (paramRecordConfigProvider.qbs == 1)
      {
        localObject = af.hQ(ah.getContext());
        k = ((Point)localObject).y;
        m = ((Point)localObject).x;
        paramRecordConfigProvider.qbq.height = (k * paramRecordConfigProvider.qbq.width / m);
        k = paramString.width;
        m = paramString.height;
        if ((k - 32 > j) || (m - 32 > i))
        {
          paramb.eRu = j;
          paramb.eRv = i;
          paramb.qbc = true;
          ab.i("MicroMsg.RemuxMediaEditConfig", "remux by:FIT_SCREEN by high size " + paramString.width + "  " + paramb.eRu);
        }
      }
      for (;;)
      {
        j = paramString.fps;
        i = j;
        if (paramString.fps > paramRecordConfigProvider.qbq.fps * 1.5F)
        {
          i = j;
          if (paramRecordConfigProvider.qbq.fps >= 0) {
            i = paramRecordConfigProvider.qbq.fps;
          }
        }
        paramb.eRw = i;
        if (paramb.eRu % 16 != 0) {
          paramb.eRu = d.zn(paramb.eRu);
        }
        if (paramb.eRv % 16 != 0) {
          paramb.eRv = d.zn(paramb.eRv);
        }
        AppMethodBeat.o(150573);
        return paramb;
        label450:
        k = 0;
        break;
        paramb.eRv = paramString.height;
        paramb.eRu = paramString.width;
        continue;
        if (paramRecordConfigProvider.qbs == 2)
        {
          k = paramString.width;
          m = paramString.height;
          if ((k != j) || (m != i))
          {
            paramb.qbc = true;
            ab.i("MicroMsg.RemuxMediaEditConfig", "remux by:FORCE_WIDTH_AND_HEIGHT by high size ");
          }
          paramb.eRu = j;
          paramb.eRv = i;
        }
        else if (paramRecordConfigProvider.qbs == 4)
        {
          m = paramString.width - 32;
          int n = paramString.height - 32;
          paramb.eRv = paramString.height;
          paramb.eRu = paramString.width;
          if (k != 0)
          {
            if (n > i)
            {
              paramb.eRv = i;
              paramb.eRu = (i * m / n);
              paramb.qbc = true;
              ab.i("MicroMsg.RemuxMediaEditConfig", "remux by:SCALE_SIZE by high size ");
            }
          }
          else if (m > j)
          {
            paramb.eRu = j;
            paramb.eRv = (j * n / m);
            paramb.qbc = true;
            ab.i("MicroMsg.RemuxMediaEditConfig", "remux by:SCALE_SIZE by high size ");
          }
        }
        else if (paramRecordConfigProvider.qbs == 3)
        {
          paramb.eRu = paramString.width;
          paramb.eRv = paramString.height;
        }
      }
      label688:
      int m = i;
      i = j;
      j = m;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(150574);
    String str = "RemuxMediaEditConfig(muteOrigin=" + this.qaU + ", audioCacheInfo=" + this.qaV + ", editItems=" + this.qaW + ", drawingRect=" + Arrays.toString(this.qaY) + ", reMuxStartTimeMs=" + this.qaZ + ", reMuxEndTimeMs=" + this.qba + ')';
    AppMethodBeat.o(150574);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.b.b
 * JD-Core Version:    0.7.0.1
 */