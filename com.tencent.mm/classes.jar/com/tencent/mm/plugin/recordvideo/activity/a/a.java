package com.tencent.mm.plugin.recordvideo.activity.a;

import android.media.MediaFormat;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.i.c;
import com.tencent.mm.media.widget.camerarecordview.b.b;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/activity/controller/RecordUIController;", "", "()V", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "checkConfigProvider", "", "toWhere", "fileCheck", "path", "", "formatCheck", "getCaptureInfoFromProvider", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "setUpProvider", "", "Companion", "plugin-recordvideo_release"})
public final class a
{
  public static final a.a BJv;
  
  static
  {
    AppMethodBeat.i(75067);
    BJv = new a.a((byte)0);
    AppMethodBeat.o(75067);
  }
  
  public static int aLc(String paramString)
  {
    AppMethodBeat.i(75064);
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      Log.e("MicroMsg.MMRecordUI", "fileCheck path is null");
      AppMethodBeat.o(75064);
      return 1000;
    }
    if (s.boW(paramString) < 1L)
    {
      Log.e("MicroMsg.MMRecordUI", "fileCheck file size is 0. path: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(75064);
      return 1001;
    }
    AppMethodBeat.o(75064);
    return 999;
  }
  
  public static int aLd(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(75065);
    long l = Util.currentTicks();
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
            Log.d("MicroMsg.RecordUIController", "find video mime : not found.");
            localObject5 = localObject2;
            localObject6 = str1;
            break label388;
          }
          str2 = localMediaFormat.getString("mime");
          Log.d("MicroMsg.RecordUIController", "find video mime : %s", new Object[] { str2 });
          localObject5 = localObject2;
          localObject6 = str1;
          if (str2 == null) {
            break label388;
          }
          if (n.J(str2, "video/", false))
          {
            localObject3 = localObject2;
            localObject4 = str1;
            if (str1 != null) {
              break label403;
            }
            localObject4 = localMediaFormat;
            localObject3 = localObject2;
            break label403;
          }
        }
        else
        {
          Log.i("MicroMsg.RecordUIController", "cost time: " + Util.ticksToNow(l));
          if (localObject3 == null) {
            continue;
          }
          if (localObject3.containsKey("mime")) {
            continue;
          }
          str1 = "";
          boolean bool = n.I("audio/mp4a-latm", str1, true);
          if (!bool) {
            continue;
          }
          return 999;
        }
        localObject3 = localObject2;
        localObject4 = str1;
        if (!n.J(str2, "audio/", false)) {
          break label403;
        }
        localObject3 = localObject2;
        localObject4 = str1;
        if (localObject2 != null) {
          break label403;
        }
        localObject3 = localMediaFormat;
        localObject4 = str1;
        break label403;
        str1 = localObject3.getString("mime");
        continue;
        return 999;
        Log.d("MicroMsg.RecordUIController", "mediaItem format:%s, videoPath:%s", new Object[] { localObject4, paramString });
        localc.release();
      }
      catch (Exception localException)
      {
        Log.d("MicroMsg.RecordUIController", "Video extractor init failed. video path = [%s] e = [%s]", new Object[] { paramString, localException.getMessage() });
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
      label388:
      label403:
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
    b localb = new b(null, null, false, null, null, null, null, null, null, 65535);
    Object localObject = paramRecordConfigProvider.BOD;
    if (localObject != null) {
      localb.iqn = ((ArrayList)localObject);
    }
    localObject = paramRecordConfigProvider.images;
    if (localObject != null) {
      localb.iqm = ((ArrayList)localObject);
    }
    localObject = (Collection)paramRecordConfigProvider.images;
    if ((localObject == null) || (((Collection)localObject).isEmpty()))
    {
      i = 1;
      if (i != 0)
      {
        localObject = (Collection)paramRecordConfigProvider.BOD;
        if ((localObject != null) && (!((Collection)localObject).isEmpty())) {
          break label290;
        }
      }
    }
    label290:
    for (int i = 1;; i = 0)
    {
      if ((i == 0) && (paramRecordConfigProvider.BOD.size() == 1))
      {
        localObject = paramRecordConfigProvider.BOD.get(0);
        p.g(localObject, "configProvider.videos[0]");
        localb.Hw((String)localObject);
        localb.iqg = e.aNx(localb.iqd).videoDuration;
        localObject = paramRecordConfigProvider.thumbPath;
        p.g(localObject, "configProvider.thumbPath");
        localb.Hx((String)localObject);
      }
      if (!TextUtils.isEmpty((CharSequence)paramRecordConfigProvider.BOB))
      {
        localObject = paramRecordConfigProvider.BOB;
        p.g(localObject, "configProvider.inputPhotoPath");
        localb.Hy((String)localObject);
      }
      if ((!TextUtils.isEmpty((CharSequence)paramRecordConfigProvider.BOz)) && (s.YS(paramRecordConfigProvider.BOz)))
      {
        localObject = paramRecordConfigProvider.BOz;
        p.g(localObject, "configProvider.inputVideoPath");
        localb.Hw((String)localObject);
        localb.iqg = e.aNx(paramRecordConfigProvider.BOz).videoDuration;
        paramRecordConfigProvider = paramRecordConfigProvider.thumbPath;
        p.g(paramRecordConfigProvider, "configProvider.thumbPath");
        localb.Hx(paramRecordConfigProvider);
      }
      AppMethodBeat.o(75066);
      return localb;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.activity.a.a
 * JD-Core Version:    0.7.0.1
 */