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
    AppMethodBeat.i(194563);
    if ((parame instanceof a))
    {
      b(paramXmlSerializer, parame, paramLong);
      AppMethodBeat.o(194563);
      return;
    }
    if ((parame instanceof e))
    {
      c(paramXmlSerializer, parame, paramLong);
      AppMethodBeat.o(194563);
      return;
    }
    AppMethodBeat.o(194563);
  }
  
  static void a(XmlSerializer paramXmlSerializer, List<com.tencent.thumbplayer.b.a.d> paramList, int paramInt, long paramLong)
  {
    AppMethodBeat.i(194562);
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
          str1 = bw(paramInt, true);
          String str2 = bw(paramInt, false);
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
          if ((paramInt == 1) || (!c.Mxf.equals("base_audio")) || (((com.tencent.thumbplayer.b.a.d)localObject).gbe() <= paramLong)) {
            break label264;
          }
          long l = 0L;
          localObject = ((com.tencent.thumbplayer.b.a.d)localObject).gbd().iterator();
          com.tencent.thumbplayer.b.a.e locale;
          if (((Iterator)localObject).hasNext())
          {
            locale = (com.tencent.thumbplayer.b.a.e)((Iterator)localObject).next();
            l += locale.gbg();
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
          AppMethodBeat.o(194562);
          return;
        }
        continue;
        label264:
        Object localObject = ((com.tencent.thumbplayer.b.a.d)localObject).gbd().iterator();
        while (((Iterator)localObject).hasNext()) {
          a(paramXmlSerializer, (com.tencent.thumbplayer.b.a.e)((Iterator)localObject).next(), 0L);
        }
      }
      paramXmlSerializer.endTag("", str1);
    }
    label317:
    AppMethodBeat.o(194562);
  }
  
  static void a(XmlSerializer paramXmlSerializer, List<com.tencent.thumbplayer.b.a.e> paramList, String paramString1, String paramString2)
  {
    AppMethodBeat.i(194561);
    paramXmlSerializer.startTag("", paramString1);
    paramXmlSerializer.startTag("", paramString2);
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      a(paramXmlSerializer, (com.tencent.thumbplayer.b.a.e)paramList.next(), 0L);
    }
    paramXmlSerializer.endTag("", paramString2);
    paramXmlSerializer.endTag("", paramString1);
    AppMethodBeat.o(194561);
  }
  
  private static void b(XmlSerializer paramXmlSerializer, com.tencent.thumbplayer.b.a.e parame, long paramLong)
  {
    AppMethodBeat.i(194564);
    paramXmlSerializer.startTag("", "track_clip");
    paramXmlSerializer.startTag("", "clip_id");
    paramXmlSerializer.text(Integer.toString(parame.gbf()));
    paramXmlSerializer.endTag("", "clip_id");
    paramXmlSerializer.startTag("", "clip_placeHolder");
    paramXmlSerializer.text("1");
    paramXmlSerializer.endTag("", "clip_placeHolder");
    paramXmlSerializer.startTag("", "clip_playTimeMs");
    if (paramLong > 0L) {
      paramXmlSerializer.text(Long.toString(parame.gbg() - paramLong));
    }
    for (;;)
    {
      paramXmlSerializer.endTag("", "clip_playTimeMs");
      paramXmlSerializer.endTag("", "track_clip");
      AppMethodBeat.o(194564);
      return;
      paramXmlSerializer.text(Long.toString(parame.gbg()));
    }
  }
  
  private static String bw(int paramInt, boolean paramBoolean)
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
    AppMethodBeat.i(194565);
    paramXmlSerializer.startTag("", "track_clip");
    paramXmlSerializer.startTag("", "clip_id");
    paramXmlSerializer.text(Integer.toString(parame.gbf()));
    paramXmlSerializer.endTag("", "clip_id");
    paramXmlSerializer.startTag("", "clip_placeHolder");
    paramXmlSerializer.text("0");
    paramXmlSerializer.endTag("", "clip_placeHolder");
    paramXmlSerializer.startTag("", "clip_path");
    paramXmlSerializer.text(parame.getFilePath());
    paramXmlSerializer.endTag("", "clip_path");
    paramXmlSerializer.startTag("", "clip_startTimeMs");
    paramXmlSerializer.text(Long.toString(parame.evQ()));
    paramXmlSerializer.endTag("", "clip_startTimeMs");
    paramXmlSerializer.startTag("", "clip_durationMs");
    paramXmlSerializer.text(Long.toString(parame.gbg()));
    paramXmlSerializer.endTag("", "clip_durationMs");
    if (paramLong > 0L)
    {
      long l1 = parame.evR();
      long l2 = parame.gbg();
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
      AppMethodBeat.o(194565);
      return;
      paramXmlSerializer.startTag("", "clip_endTimeMs");
      paramXmlSerializer.text(Long.toString(parame.evR()));
      paramXmlSerializer.endTag("", "clip_endTimeMs");
      paramXmlSerializer.startTag("", "clip_playTimeMs");
      paramXmlSerializer.text(Long.toString(parame.gbg()));
      paramXmlSerializer.endTag("", "clip_playTimeMs");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.d.f
 * JD-Core Version:    0.7.0.1
 */