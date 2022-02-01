package com.tencent.thumbplayer.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.b.a.d;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlSerializer;

public final class f
{
  private static void a(XmlSerializer paramXmlSerializer, com.tencent.thumbplayer.b.a.e parame, long paramLong)
  {
    AppMethodBeat.i(187864);
    if ((parame instanceof a))
    {
      b(paramXmlSerializer, parame, paramLong);
      AppMethodBeat.o(187864);
      return;
    }
    if ((parame instanceof e))
    {
      c(paramXmlSerializer, parame, paramLong);
      AppMethodBeat.o(187864);
      return;
    }
    AppMethodBeat.o(187864);
  }
  
  static void a(XmlSerializer paramXmlSerializer, List<d> paramList, int paramInt, long paramLong)
  {
    AppMethodBeat.i(187863);
    if (paramList != null)
    {
      String str1;
      for (;;)
      {
        try
        {
          if (paramList.size() <= 0) {
            break label317;
          }
          str1 = bf(paramInt, true);
          String str2 = bf(paramInt, false);
          paramXmlSerializer.startTag("", str1);
          paramList = paramList.iterator();
          if (!paramList.hasNext()) {
            break;
          }
          localObject = (d)paramList.next();
          if (((d)localObject).getMediaType() != paramInt) {
            continue;
          }
          paramXmlSerializer.startTag("", str2);
          paramXmlSerializer.startTag("", "track_id");
          paramXmlSerializer.text(Integer.toString(((d)localObject).getTrackId()));
          paramXmlSerializer.endTag("", "track_id");
          if ((paramInt == 1) || (!c.KgU.equals("base_audio")) || (((d)localObject).fFo() <= paramLong)) {
            break label264;
          }
          long l = 0L;
          localObject = ((d)localObject).fFn().iterator();
          com.tencent.thumbplayer.b.a.e locale;
          if (((Iterator)localObject).hasNext())
          {
            locale = (com.tencent.thumbplayer.b.a.e)((Iterator)localObject).next();
            l += locale.fFs();
            if (l > paramLong) {
              a(paramXmlSerializer, locale, l - paramLong);
            }
          }
          else
          {
            paramXmlSerializer.endTag("", str2);
            continue;
          }
          a(paramXmlSerializer, locale, 0L);
        }
        catch (IOException paramXmlSerializer)
        {
          com.tencent.thumbplayer.utils.f.e("TPMediaCompositionXmlGenerator", paramXmlSerializer);
          AppMethodBeat.o(187863);
          return;
        }
        continue;
        label264:
        Object localObject = ((d)localObject).fFn().iterator();
        while (((Iterator)localObject).hasNext()) {
          a(paramXmlSerializer, (com.tencent.thumbplayer.b.a.e)((Iterator)localObject).next(), 0L);
        }
      }
      paramXmlSerializer.endTag("", str1);
    }
    label317:
    AppMethodBeat.o(187863);
  }
  
  static void a(XmlSerializer paramXmlSerializer, List<com.tencent.thumbplayer.b.a.e> paramList, String paramString1, String paramString2)
  {
    AppMethodBeat.i(187862);
    paramXmlSerializer.startTag("", paramString1);
    paramXmlSerializer.startTag("", paramString2);
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      a(paramXmlSerializer, (com.tencent.thumbplayer.b.a.e)paramList.next(), 0L);
    }
    paramXmlSerializer.endTag("", paramString2);
    paramXmlSerializer.endTag("", paramString1);
    AppMethodBeat.o(187862);
  }
  
  private static void b(XmlSerializer paramXmlSerializer, com.tencent.thumbplayer.b.a.e parame, long paramLong)
  {
    AppMethodBeat.i(187865);
    paramXmlSerializer.startTag("", "track_clip");
    paramXmlSerializer.startTag("", "clip_id");
    paramXmlSerializer.text(Integer.toString(parame.fFp()));
    paramXmlSerializer.endTag("", "clip_id");
    paramXmlSerializer.startTag("", "clip_placeHolder");
    paramXmlSerializer.text("1");
    paramXmlSerializer.endTag("", "clip_placeHolder");
    paramXmlSerializer.startTag("", "clip_playTimeMs");
    if (paramLong > 0L) {
      paramXmlSerializer.text(Long.toString(parame.fFs() - paramLong));
    }
    for (;;)
    {
      paramXmlSerializer.endTag("", "clip_playTimeMs");
      paramXmlSerializer.endTag("", "track_clip");
      AppMethodBeat.o(187865);
      return;
      paramXmlSerializer.text(Long.toString(parame.fFs()));
    }
  }
  
  private static String bf(int paramInt, boolean paramBoolean)
  {
    if (paramInt == 1)
    {
      if (paramBoolean) {
        return "av_tracks";
      }
      return "av_track";
    }
    if (paramInt == 2)
    {
      if (paramBoolean) {
        return "video_tracks";
      }
      return "video_track";
    }
    if (paramInt == 3)
    {
      if (paramBoolean) {
        return "audio_tracks";
      }
      return "audio_track";
    }
    return "";
  }
  
  private static void c(XmlSerializer paramXmlSerializer, com.tencent.thumbplayer.b.a.e parame, long paramLong)
  {
    AppMethodBeat.i(187866);
    paramXmlSerializer.startTag("", "track_clip");
    paramXmlSerializer.startTag("", "clip_id");
    paramXmlSerializer.text(Integer.toString(parame.fFp()));
    paramXmlSerializer.endTag("", "clip_id");
    paramXmlSerializer.startTag("", "clip_placeHolder");
    paramXmlSerializer.text("0");
    paramXmlSerializer.endTag("", "clip_placeHolder");
    paramXmlSerializer.startTag("", "clip_path");
    paramXmlSerializer.text(parame.getFilePath());
    paramXmlSerializer.endTag("", "clip_path");
    paramXmlSerializer.startTag("", "clip_startTimeMs");
    paramXmlSerializer.text(Long.toString(parame.fFq()));
    paramXmlSerializer.endTag("", "clip_startTimeMs");
    paramXmlSerializer.startTag("", "clip_durationMs");
    paramXmlSerializer.text(Long.toString(parame.fFs()));
    paramXmlSerializer.endTag("", "clip_durationMs");
    if (paramLong > 0L)
    {
      long l1 = parame.fFr();
      long l2 = parame.fFs();
      paramXmlSerializer.startTag("", "clip_endTimeMs");
      paramXmlSerializer.text(Long.toString(l1 - paramLong));
      paramXmlSerializer.endTag("", "clip_endTimeMs");
      paramXmlSerializer.startTag("", "clip_playTimeMs");
      paramXmlSerializer.text(Long.toString(l2 - paramLong));
      paramXmlSerializer.endTag("", "clip_playTimeMs");
    }
    for (;;)
    {
      paramXmlSerializer.endTag("", "track_clip");
      AppMethodBeat.o(187866);
      return;
      paramXmlSerializer.startTag("", "clip_endTimeMs");
      paramXmlSerializer.text(Long.toString(parame.fFr()));
      paramXmlSerializer.endTag("", "clip_endTimeMs");
      paramXmlSerializer.startTag("", "clip_playTimeMs");
      paramXmlSerializer.text(Long.toString(parame.fFs()));
      paramXmlSerializer.endTag("", "clip_playTimeMs");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.d.f
 * JD-Core Version:    0.7.0.1
 */