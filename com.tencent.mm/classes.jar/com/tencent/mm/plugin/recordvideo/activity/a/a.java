package com.tencent.mm.plugin.recordvideo.activity.a;

import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.i.c;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.sight.base.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/activity/controller/RecordUIController;", "", "()V", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "checkConfigProvider", "", "toWhere", "fileCheck", "path", "", "formatCheck", "getCaptureInfoFromProvider", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "setUpProvider", "", "Companion", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a.a NDl;
  
  static
  {
    AppMethodBeat.i(75067);
    NDl = new a.a((byte)0);
    AppMethodBeat.o(75067);
  }
  
  public static int aSM(String paramString)
  {
    AppMethodBeat.i(75064);
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      Log.e("MicroMsg.MMRecordUI", "fileCheck path is null");
      AppMethodBeat.o(75064);
      return 1000;
    }
    if (y.bEl(paramString) < 1L)
    {
      Log.e("MicroMsg.MMRecordUI", s.X("fileCheck file size is 0. path: ", paramString));
      AppMethodBeat.o(75064);
      return 1001;
    }
    AppMethodBeat.o(75064);
    return 999;
  }
  
  public static int aSN(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(75065);
    long l = Util.currentTicks();
    c localc = new c();
    int k;
    Object localObject3;
    Object localObject2;
    Object localObject4;
    int j;
    Object localObject6;
    Object localObject5;
    try
    {
      localc.setDataSource(paramString);
      k = localc.lZm.getTrackCount();
      localObject3 = null;
      localObject2 = null;
      localObject4 = null;
      Object localObject1 = null;
      MediaFormat localMediaFormat;
      if (k > 0)
      {
        localObject3 = localObject2;
        localObject4 = localObject1;
        j = i + 1;
        localMediaFormat = localc.getTrackFormat(i);
        s.s(localMediaFormat, "extractor.getTrackFormat(i)");
        if (!localMediaFormat.containsKey("mime"))
        {
          Log.d("MicroMsg.RecordUIController", "find video mime : not found.");
          localObject6 = localObject4;
          localObject5 = localObject3;
          break label423;
        }
      }
      else
      {
        Log.i("MicroMsg.RecordUIController", s.X("cost time: ", Long.valueOf(Util.ticksToNow(l))));
        if (localObject4 == null) {
          break label304;
        }
        if (localObject4.containsKey("mime")) {
          break label292;
        }
      }
      label292:
      for (localObject1 = "";; localObject1 = localObject4.getString("mime"))
      {
        boolean bool = n.T("audio/mp4a-latm", (String)localObject1, true);
        if (!bool) {
          break;
        }
        return 999;
        String str = localMediaFormat.getString("mime");
        Log.d("MicroMsg.RecordUIController", "find video mime : %s", new Object[] { str });
        localObject6 = localObject4;
        localObject5 = localObject3;
        if (str == null) {
          break label423;
        }
        if (n.U(str, "video/", false))
        {
          localObject1 = localObject4;
          localObject2 = localObject3;
          if (localObject3 != null) {
            break label439;
          }
          localObject2 = localMediaFormat;
          localObject1 = localObject4;
          break label439;
        }
        localObject1 = localObject4;
        localObject2 = localObject3;
        if (!n.U(str, "audio/", false)) {
          break label439;
        }
        localObject1 = localObject4;
        localObject2 = localObject3;
        if (localObject4 != null) {
          break label439;
        }
        localObject1 = localMediaFormat;
        localObject2 = localObject3;
        break label439;
      }
      label304:
      return 999;
      Log.d("MicroMsg.RecordUIController", "mediaItem format:%s, videoPath:%s", new Object[] { localObject3, paramString });
      localc.lZm.release();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.d("MicroMsg.RecordUIController", "Video extractor init failed. video path = [%s] e = [%s]", new Object[] { paramString, localException.getMessage() });
        localc.lZm.release();
      }
    }
    finally
    {
      localc.lZm.release();
      AppMethodBeat.o(75065);
    }
    AppMethodBeat.o(75065);
    return 1004;
    label423:
    label439:
    label474:
    for (;;)
    {
      i = j;
      localObject4 = localObject6;
      localObject3 = localObject5;
      break;
      for (;;)
      {
        if (j < k) {
          break label474;
        }
        localObject4 = localObject6;
        localObject3 = localObject5;
        break;
        localObject6 = localException;
        localObject5 = localObject2;
        if (localException != null)
        {
          localObject4 = localException;
          localObject3 = localObject2;
          if (localObject2 != null) {
            break;
          }
          localObject6 = localException;
          localObject5 = localObject2;
        }
      }
    }
  }
  
  public static com.tencent.mm.media.widget.camerarecordview.b.b g(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(75066);
    s.u(paramRecordConfigProvider, "configProvider");
    com.tencent.mm.media.widget.camerarecordview.b.b localb = new com.tencent.mm.media.widget.camerarecordview.b.b(null, null, false, null, null, null, null, null, null, 65535);
    Object localObject = paramRecordConfigProvider.NIh;
    if (localObject != null) {
      localb.w((ArrayList)localObject);
    }
    localObject = paramRecordConfigProvider.FQY;
    if (localObject != null) {
      localb.v((ArrayList)localObject);
    }
    localObject = (Collection)paramRecordConfigProvider.FQY;
    if ((localObject == null) || (((Collection)localObject).isEmpty()))
    {
      i = 1;
      if (i != 0)
      {
        localObject = (Collection)paramRecordConfigProvider.NIh;
        if ((localObject != null) && (!((Collection)localObject).isEmpty())) {
          break label298;
        }
      }
    }
    label298:
    for (int i = 1;; i = 0)
    {
      if ((i == 0) && (paramRecordConfigProvider.NIh.size() == 1))
      {
        localObject = paramRecordConfigProvider.NIh.get(0);
        s.s(localObject, "configProvider.videos[0]");
        localb.GZ((String)localObject);
        localb.endTime = f.aVX(localb.nJU).videoDuration;
        localObject = paramRecordConfigProvider.thumbPath;
        s.s(localObject, "configProvider.thumbPath");
        localb.Ha((String)localObject);
      }
      if (!TextUtils.isEmpty((CharSequence)paramRecordConfigProvider.NIf))
      {
        localObject = paramRecordConfigProvider.NIf;
        s.s(localObject, "configProvider.inputPhotoPath");
        localb.Hb((String)localObject);
      }
      localb.nKf = paramRecordConfigProvider.oSS;
      if ((!TextUtils.isEmpty((CharSequence)paramRecordConfigProvider.NId)) && (y.ZC(paramRecordConfigProvider.NId)))
      {
        localObject = paramRecordConfigProvider.NId;
        s.s(localObject, "configProvider.inputVideoPath");
        localb.GZ((String)localObject);
        localb.endTime = f.aVX(paramRecordConfigProvider.NId).videoDuration;
        paramRecordConfigProvider = paramRecordConfigProvider.thumbPath;
        s.s(paramRecordConfigProvider, "configProvider.thumbPath");
        localb.Ha(paramRecordConfigProvider);
      }
      AppMethodBeat.o(75066);
      return localb;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.activity.a.a
 * JD-Core Version:    0.7.0.1
 */