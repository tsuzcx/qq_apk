package com.tencent.thumbplayer.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlSerializer;

public final class f
{
  private static void a(XmlSerializer paramXmlSerializer, com.tencent.thumbplayer.b.a.e parame, long paramLong)
  {
    AppMethodBeat.i(191885);
    if ((parame instanceof a))
    {
      b(paramXmlSerializer, parame, paramLong);
      AppMethodBeat.o(191885);
      return;
    }
    if ((parame instanceof e))
    {
      c(paramXmlSerializer, parame, paramLong);
      AppMethodBeat.o(191885);
      return;
    }
    AppMethodBeat.o(191885);
  }
  
  static void a(XmlSerializer paramXmlSerializer, List<com.tencent.thumbplayer.b.a.d> paramList, int paramInt, long paramLong)
  {
    AppMethodBeat.i(191884);
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
          str1 = bn(paramInt, true);
          String str2 = bn(paramInt, false);
          paramXmlSerializer.startTag("", str1);
          paramList = paramList.iterator();
          if (!paramList.hasNext()) {
            break;
          }
          localObject = (com.tencent.thumbplayer.b.a.d)paramList.next();
          if (((com.tencent.thumbplayer.b.a.d)localObject).getMediaType() != paramInt) {
            continue;
          }
          paramXmlSerializer.startTag("", str2);
          paramXmlSerializer.startTag("", "track_id");
          paramXmlSerializer.text(Integer.toString(((com.tencent.thumbplayer.b.a.d)localObject).getTrackId()));
          paramXmlSerializer.endTag("", "track_id");
          if ((paramInt == 1) || (!c.Mak.equals("base_audio")) || (((com.tencent.thumbplayer.b.a.d)localObject).fWF() <= paramLong)) {
            break label264;
          }
          long l = 0L;
          localObject = ((com.tencent.thumbplayer.b.a.d)localObject).fWE().iterator();
          com.tencent.thumbplayer.b.a.e locale;
          if (((Iterator)localObject).hasNext())
          {
            locale = (com.tencent.thumbplayer.b.a.e)((Iterator)localObject).next();
            l += locale.fWH();
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
          com.tencent.thumbplayer.utils.d.e("TPMediaCompositionXmlGenerator", paramXmlSerializer);
          AppMethodBeat.o(191884);
          return;
        }
        continue;
        label264:
        Object localObject = ((com.tencent.thumbplayer.b.a.d)localObject).fWE().iterator();
        while (((Iterator)localObject).hasNext()) {
          a(paramXmlSerializer, (com.tencent.thumbplayer.b.a.e)((Iterator)localObject).next(), 0L);
        }
      }
      paramXmlSerializer.endTag("", str1);
    }
    label317:
    AppMethodBeat.o(191884);
  }
  
  static void a(XmlSerializer paramXmlSerializer, List<com.tencent.thumbplayer.b.a.e> paramList, String paramString1, String paramString2)
  {
    AppMethodBeat.i(191883);
    paramXmlSerializer.startTag("", paramString1);
    paramXmlSerializer.startTag("", paramString2);
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      a(paramXmlSerializer, (com.tencent.thumbplayer.b.a.e)paramList.next(), 0L);
    }
    paramXmlSerializer.endTag("", paramString2);
    paramXmlSerializer.endTag("", paramString1);
    AppMethodBeat.o(191883);
  }
  
  private static void b(XmlSerializer paramXmlSerializer, com.tencent.thumbplayer.b.a.e parame, long paramLong)
  {
    AppMethodBeat.i(191886);
    paramXmlSerializer.startTag("", "track_clip");
    paramXmlSerializer.startTag("", "clip_id");
    paramXmlSerializer.text(Integer.toString(parame.fWG()));
    paramXmlSerializer.endTag("", "clip_id");
    paramXmlSerializer.startTag("", "clip_placeHolder");
    paramXmlSerializer.text("1");
    paramXmlSerializer.endTag("", "clip_placeHolder");
    paramXmlSerializer.startTag("", "clip_playTimeMs");
    if (paramLong > 0L) {
      paramXmlSerializer.text(Long.toString(parame.fWH() - paramLong));
    }
    for (;;)
    {
      paramXmlSerializer.endTag("", "clip_playTimeMs");
      paramXmlSerializer.endTag("", "track_clip");
      AppMethodBeat.o(191886);
      return;
      paramXmlSerializer.text(Long.toString(parame.fWH()));
    }
  }
  
  private static String bn(int paramInt, boolean paramBoolean)
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
    AppMethodBeat.i(191887);
    paramXmlSerializer.startTag("", "track_clip");
    paramXmlSerializer.startTag("", "clip_id");
    paramXmlSerializer.text(Integer.toString(parame.fWG()));
    paramXmlSerializer.endTag("", "clip_id");
    paramXmlSerializer.startTag("", "clip_placeHolder");
    paramXmlSerializer.text("0");
    paramXmlSerializer.endTag("", "clip_placeHolder");
    paramXmlSerializer.startTag("", "clip_path");
    paramXmlSerializer.text(parame.getFilePath());
    paramXmlSerializer.endTag("", "clip_path");
    paramXmlSerializer.startTag("", "clip_startTimeMs");
    paramXmlSerializer.text(Long.toString(parame.esj()));
    paramXmlSerializer.endTag("", "clip_startTimeMs");
    paramXmlSerializer.startTag("", "clip_durationMs");
    paramXmlSerializer.text(Long.toString(parame.fWH()));
    paramXmlSerializer.endTag("", "clip_durationMs");
    if (paramLong > 0L)
    {
      long l1 = parame.esk();
      long l2 = parame.fWH();
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
      AppMethodBeat.o(191887);
      return;
      paramXmlSerializer.startTag("", "clip_endTimeMs");
      paramXmlSerializer.text(Long.toString(parame.esk()));
      paramXmlSerializer.endTag("", "clip_endTimeMs");
      paramXmlSerializer.startTag("", "clip_playTimeMs");
      paramXmlSerializer.text(Long.toString(parame.fWH()));
      paramXmlSerializer.endTag("", "clip_playTimeMs");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.d.f
 * JD-Core Version:    0.7.0.1
 */