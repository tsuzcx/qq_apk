package com.tencent.mm.plugin.recordvideo.activity.a;

import a.l;
import a.l.m;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/recordvideo/activity/controller/RecordUIController;", "", "()V", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "checkConfigProvider", "", "toWhere", "fileCheck", "path", "", "formatCheck", "setUpProvider", "", "Companion", "plugin-recordvideo_release"})
public final class a
{
  public static final a.a qaL;
  
  static
  {
    AppMethodBeat.i(150559);
    qaL = new a.a((byte)0);
    AppMethodBeat.o(150559);
  }
  
  public static int XW(String paramString)
  {
    AppMethodBeat.i(150557);
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      ab.e("MicroMsg.MMRecordUI", "fileCheck path is null");
      AppMethodBeat.o(150557);
      return 1000;
    }
    if (e.avI(paramString) < 1L)
    {
      ab.e("MicroMsg.MMRecordUI", "fileCheck file size is 0. path: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(150557);
      return 1001;
    }
    AppMethodBeat.o(150557);
    return 999;
  }
  
  public static int XX(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(150558);
    long l = bo.yB();
    MediaExtractor localMediaExtractor = new MediaExtractor();
    label394:
    for (;;)
    {
      Object localObject2;
      Object localObject3;
      Object localObject4;
      Object localObject5;
      Object localObject6;
      try
      {
        localMediaExtractor.setDataSource(paramString);
        int j = localMediaExtractor.getTrackCount();
        String str1 = null;
        localObject2 = null;
        localObject3 = localObject2;
        localObject4 = str1;
        MediaFormat localMediaFormat;
        String str2;
        if (i < j)
        {
          localMediaFormat = localMediaExtractor.getTrackFormat(i);
          if (!localMediaFormat.containsKey("mime"))
          {
            ab.d("MicroMsg.RecordUIController", "find video mime : not found.");
            localObject5 = localObject2;
            localObject6 = str1;
            break label379;
          }
          str2 = localMediaFormat.getString("mime");
          ab.d("MicroMsg.RecordUIController", "find video mime : %s", new Object[] { str2 });
          localObject5 = localObject2;
          localObject6 = str1;
          if (str2 == null) {
            break label379;
          }
          if (m.jw(str2, "video/"))
          {
            localObject3 = localObject2;
            localObject4 = str1;
            if (str1 != null) {
              break label394;
            }
            localObject4 = localMediaFormat;
            localObject3 = localObject2;
            break label394;
          }
        }
        else
        {
          ab.i("MicroMsg.RecordUIController", "cost time: " + bo.av(l));
          if (localObject3 == null) {
            continue;
          }
          if (localObject3.containsKey("mime")) {
            continue;
          }
          str1 = "";
          boolean bool = m.I("audio/mp4a-latm", str1, true);
          if (!bool) {
            continue;
          }
          return 999;
        }
        localObject3 = localObject2;
        localObject4 = str1;
        if (!m.jw(str2, "audio/")) {
          break label394;
        }
        localObject3 = localObject2;
        localObject4 = str1;
        if (localObject2 != null) {
          break label394;
        }
        localObject3 = localMediaFormat;
        localObject4 = str1;
        break label394;
        str1 = localObject3.getString("mime");
        continue;
        return 999;
        ab.d("MicroMsg.RecordUIController", "mediaItem format:%s, videoPath:%s", new Object[] { localObject4, paramString });
        localMediaExtractor.release();
      }
      catch (Exception localException)
      {
        ab.d("MicroMsg.RecordUIController", "Video extractor init failed. video path = [%s] e = [%s]", new Object[] { paramString, localException.getMessage() });
        localMediaExtractor.release();
        continue;
      }
      finally
      {
        localMediaExtractor.release();
        AppMethodBeat.o(150558);
      }
      AppMethodBeat.o(150558);
      return 1004;
      label379:
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.activity.a.a
 * JD-Core Version:    0.7.0.1
 */