package com.tencent.thumbplayer.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.api.composition.ITPMediaTrack;
import com.tencent.thumbplayer.api.composition.ITPMediaTrackClip;
import com.tencent.thumbplayer.utils.g;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlSerializer;

public final class f
{
  private static void a(XmlSerializer paramXmlSerializer, ITPMediaTrackClip paramITPMediaTrackClip, long paramLong)
  {
    AppMethodBeat.i(226965);
    if ((paramITPMediaTrackClip instanceof a))
    {
      b(paramXmlSerializer, paramITPMediaTrackClip, paramLong);
      AppMethodBeat.o(226965);
      return;
    }
    if ((paramITPMediaTrackClip instanceof e))
    {
      c(paramXmlSerializer, paramITPMediaTrackClip, paramLong);
      AppMethodBeat.o(226965);
      return;
    }
    AppMethodBeat.o(226965);
  }
  
  static void a(XmlSerializer paramXmlSerializer, List<ITPMediaTrack> paramList, int paramInt, long paramLong)
  {
    AppMethodBeat.i(226962);
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
          str1 = dc(paramInt, true);
          String str2 = dc(paramInt, false);
          paramXmlSerializer.startTag("", str1);
          paramList = paramList.iterator();
          if (!paramList.hasNext()) {
            break;
          }
          localObject = (ITPMediaTrack)paramList.next();
          if (((ITPMediaTrack)localObject).getMediaType() != paramInt) {
            continue;
          }
          paramXmlSerializer.startTag("", str2);
          paramXmlSerializer.startTag("", "track_id");
          paramXmlSerializer.text(Integer.toString(((ITPMediaTrack)localObject).getTrackId()));
          paramXmlSerializer.endTag("", "track_id");
          if ((paramInt == 1) || (!c.ahGC.equals("base_audio")) || (((ITPMediaTrack)localObject).getTimelineDurationMs() <= paramLong)) {
            break label264;
          }
          long l = 0L;
          localObject = ((ITPMediaTrack)localObject).getAllTrackClips().iterator();
          ITPMediaTrackClip localITPMediaTrackClip;
          if (((Iterator)localObject).hasNext())
          {
            localITPMediaTrackClip = (ITPMediaTrackClip)((Iterator)localObject).next();
            l += localITPMediaTrackClip.getOriginalDurationMs();
            if (l > paramLong) {
              a(paramXmlSerializer, localITPMediaTrackClip, l - paramLong);
            }
          }
          else
          {
            paramXmlSerializer.endTag("", str2);
            continue;
          }
          a(paramXmlSerializer, localITPMediaTrackClip, 0L);
        }
        catch (IOException paramXmlSerializer)
        {
          g.e("TPMediaCompositionXmlGenerator", paramXmlSerializer);
          AppMethodBeat.o(226962);
          return;
        }
        continue;
        label264:
        Object localObject = ((ITPMediaTrack)localObject).getAllTrackClips().iterator();
        while (((Iterator)localObject).hasNext()) {
          a(paramXmlSerializer, (ITPMediaTrackClip)((Iterator)localObject).next(), 0L);
        }
      }
      paramXmlSerializer.endTag("", str1);
    }
    label317:
    AppMethodBeat.o(226962);
  }
  
  static void a(XmlSerializer paramXmlSerializer, List<ITPMediaTrackClip> paramList, String paramString1, String paramString2)
  {
    AppMethodBeat.i(226953);
    paramXmlSerializer.startTag("", paramString1);
    paramXmlSerializer.startTag("", paramString2);
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      a(paramXmlSerializer, (ITPMediaTrackClip)paramList.next(), 0L);
    }
    paramXmlSerializer.endTag("", paramString2);
    paramXmlSerializer.endTag("", paramString1);
    AppMethodBeat.o(226953);
  }
  
  private static void b(XmlSerializer paramXmlSerializer, ITPMediaTrackClip paramITPMediaTrackClip, long paramLong)
  {
    AppMethodBeat.i(226971);
    paramXmlSerializer.startTag("", "track_clip");
    paramXmlSerializer.startTag("", "clip_id");
    paramXmlSerializer.text(Integer.toString(paramITPMediaTrackClip.getClipId()));
    paramXmlSerializer.endTag("", "clip_id");
    paramXmlSerializer.startTag("", "clip_placeHolder");
    paramXmlSerializer.text("1");
    paramXmlSerializer.endTag("", "clip_placeHolder");
    paramXmlSerializer.startTag("", "clip_playTimeMs");
    if (paramLong > 0L) {
      paramXmlSerializer.text(Long.toString(paramITPMediaTrackClip.getOriginalDurationMs() - paramLong));
    }
    for (;;)
    {
      paramXmlSerializer.endTag("", "clip_playTimeMs");
      paramXmlSerializer.endTag("", "track_clip");
      AppMethodBeat.o(226971);
      return;
      paramXmlSerializer.text(Long.toString(paramITPMediaTrackClip.getOriginalDurationMs()));
    }
  }
  
  private static void c(XmlSerializer paramXmlSerializer, ITPMediaTrackClip paramITPMediaTrackClip, long paramLong)
  {
    AppMethodBeat.i(226980);
    paramXmlSerializer.startTag("", "track_clip");
    paramXmlSerializer.startTag("", "clip_id");
    paramXmlSerializer.text(Integer.toString(paramITPMediaTrackClip.getClipId()));
    paramXmlSerializer.endTag("", "clip_id");
    paramXmlSerializer.startTag("", "clip_placeHolder");
    paramXmlSerializer.text("0");
    paramXmlSerializer.endTag("", "clip_placeHolder");
    paramXmlSerializer.startTag("", "clip_path");
    paramXmlSerializer.text(paramITPMediaTrackClip.getFilePath());
    paramXmlSerializer.endTag("", "clip_path");
    paramXmlSerializer.startTag("", "clip_startTimeMs");
    paramXmlSerializer.text(Long.toString(paramITPMediaTrackClip.getStartTimeMs()));
    paramXmlSerializer.endTag("", "clip_startTimeMs");
    paramXmlSerializer.startTag("", "clip_durationMs");
    paramXmlSerializer.text(Long.toString(paramITPMediaTrackClip.getOriginalDurationMs()));
    paramXmlSerializer.endTag("", "clip_durationMs");
    if (paramLong > 0L)
    {
      long l1 = paramITPMediaTrackClip.getEndTimeMs();
      long l2 = paramITPMediaTrackClip.getOriginalDurationMs();
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
      AppMethodBeat.o(226980);
      return;
      paramXmlSerializer.startTag("", "clip_endTimeMs");
      paramXmlSerializer.text(Long.toString(paramITPMediaTrackClip.getEndTimeMs()));
      paramXmlSerializer.endTag("", "clip_endTimeMs");
      paramXmlSerializer.startTag("", "clip_playTimeMs");
      paramXmlSerializer.text(Long.toString(paramITPMediaTrackClip.getOriginalDurationMs()));
      paramXmlSerializer.endTag("", "clip_playTimeMs");
    }
  }
  
  private static String dc(int paramInt, boolean paramBoolean)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.thumbplayer.c.f
 * JD-Core Version:    0.7.0.1
 */