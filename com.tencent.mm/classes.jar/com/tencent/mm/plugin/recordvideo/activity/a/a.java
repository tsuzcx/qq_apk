package com.tencent.mm.plugin.recordvideo.activity.a;

import android.media.MediaFormat;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.h.c;
import com.tencent.mm.media.widget.camerarecordview.b.b;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;
import d.g.b.p;
import d.l;
import d.n.n;
import java.util.ArrayList;
import java.util.Collection;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/activity/controller/RecordUIController;", "", "()V", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "checkConfigProvider", "", "toWhere", "fileCheck", "path", "", "formatCheck", "getCaptureInfoFromProvider", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "setUpProvider", "", "Companion", "plugin-recordvideo_release"})
public final class a
{
  public static final a.a xJs;
  
  static
  {
    AppMethodBeat.i(75067);
    xJs = new a.a((byte)0);
    AppMethodBeat.o(75067);
  }
  
  public static int awK(String paramString)
  {
    AppMethodBeat.i(75064);
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      ae.e("MicroMsg.MMRecordUI", "fileCheck path is null");
      AppMethodBeat.o(75064);
      return 1000;
    }
    if (o.aZR(paramString) < 1L)
    {
      ae.e("MicroMsg.MMRecordUI", "fileCheck file size is 0. path: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(75064);
      return 1001;
    }
    AppMethodBeat.o(75064);
    return 999;
  }
  
  public static int awL(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(75065);
    long l = bu.HQ();
    c localc = new c();
    for (;;)
    {
      Object localObject2;
      Object localObject3;
      Object localObject4;
      Object localObject5;
      Object localObject6;
      try
      {
        localc.setDataSource(paramString);
        int j = localc.getTrackCount();
        String str1 = null;
        localObject2 = null;
        localObject3 = localObject2;
        localObject4 = str1;
        MediaFormat localMediaFormat;
        String str2;
        if (i < j)
        {
          localMediaFormat = localc.getTrackFormat(i);
          p.g(localMediaFormat, "extractor.getTrackFormat(i)");
          if (!localMediaFormat.containsKey("mime"))
          {
            ae.d("MicroMsg.RecordUIController", "find video mime : not found.");
            localObject5 = localObject2;
            localObject6 = str1;
            break label386;
          }
          str2 = localMediaFormat.getString("mime");
          ae.d("MicroMsg.RecordUIController", "find video mime : %s", new Object[] { str2 });
          localObject5 = localObject2;
          localObject6 = str1;
          if (str2 == null) {
            break label386;
          }
          if (n.nF(str2, "video/"))
          {
            localObject3 = localObject2;
            localObject4 = str1;
            if (str1 != null) {
              break label401;
            }
            localObject4 = localMediaFormat;
            localObject3 = localObject2;
            break label401;
          }
        }
        else
        {
          ae.i("MicroMsg.RecordUIController", "cost time: " + bu.aO(l));
          if (localObject3 == null) {
            continue;
          }
          if (localObject3.containsKey("mime")) {
            continue;
          }
          str1 = "";
          boolean bool = n.H("audio/mp4a-latm", str1, true);
          if (!bool) {
            continue;
          }
          return 999;
        }
        localObject3 = localObject2;
        localObject4 = str1;
        if (!n.nF(str2, "audio/")) {
          break label401;
        }
        localObject3 = localObject2;
        localObject4 = str1;
        if (localObject2 != null) {
          break label401;
        }
        localObject3 = localMediaFormat;
        localObject4 = str1;
        break label401;
        str1 = localObject3.getString("mime");
        continue;
        return 999;
        ae.d("MicroMsg.RecordUIController", "mediaItem format:%s, videoPath:%s", new Object[] { localObject4, paramString });
        localc.release();
      }
      catch (Exception localException)
      {
        ae.d("MicroMsg.RecordUIController", "Video extractor init failed. video path = [%s] e = [%s]", new Object[] { paramString, localException.getMessage() });
        localc.release();
        continue;
      }
      finally
      {
        localc.release();
        AppMethodBeat.o(75065);
      }
      AppMethodBeat.o(75065);
      return 1004;
      label386:
      label401:
      do
      {
        do
        {
          i += 1;
          localObject2 = localObject5;
          Object localObject1 = localObject6;
          break;
          localObject5 = localObject3;
          localObject6 = localObject4;
        } while (localObject3 == null);
        localObject5 = localObject3;
        localObject6 = localObject4;
      } while (localObject4 == null);
    }
  }
  
  public static b b(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(75066);
    p.h(paramRecordConfigProvider, "configProvider");
    b localb = new b(null, null, false, null, null, null, null, null, 16379);
    Object localObject = paramRecordConfigProvider.xOw;
    if (localObject != null) {
      localb.hwL = ((ArrayList)localObject);
    }
    localObject = paramRecordConfigProvider.sNQ;
    if (localObject != null) {
      localb.hwK = ((ArrayList)localObject);
    }
    localObject = (Collection)paramRecordConfigProvider.sNQ;
    if ((localObject == null) || (((Collection)localObject).isEmpty()))
    {
      i = 1;
      if (i != 0)
      {
        localObject = (Collection)paramRecordConfigProvider.xOw;
        if ((localObject != null) && (!((Collection)localObject).isEmpty())) {
          break label290;
        }
      }
    }
    label290:
    for (int i = 1;; i = 0)
    {
      if ((i == 0) && (paramRecordConfigProvider.xOw.size() == 1))
      {
        localObject = paramRecordConfigProvider.xOw.get(0);
        p.g(localObject, "configProvider.videos[0]");
        localb.yU((String)localObject);
        localb.hwE = e.ayN(localb.hwB).videoDuration;
        localObject = paramRecordConfigProvider.thumbPath;
        p.g(localObject, "configProvider.thumbPath");
        localb.yV((String)localObject);
      }
      if (!TextUtils.isEmpty((CharSequence)paramRecordConfigProvider.xOu))
      {
        localObject = paramRecordConfigProvider.xOu;
        p.g(localObject, "configProvider.inputPhotoPath");
        localb.yW((String)localObject);
      }
      if ((!TextUtils.isEmpty((CharSequence)paramRecordConfigProvider.xOs)) && (o.fB(paramRecordConfigProvider.xOs)))
      {
        localObject = paramRecordConfigProvider.xOs;
        p.g(localObject, "configProvider.inputVideoPath");
        localb.yU((String)localObject);
        localb.hwE = e.ayN(paramRecordConfigProvider.xOs).videoDuration;
        paramRecordConfigProvider = paramRecordConfigProvider.thumbPath;
        p.g(paramRecordConfigProvider, "configProvider.thumbPath");
        localb.yV(paramRecordConfigProvider);
      }
      AppMethodBeat.o(75066);
      return localb;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.activity.a.a
 * JD-Core Version:    0.7.0.1
 */