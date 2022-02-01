package com.tencent.thumbplayer.d;

import android.util.Xml;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.b.a.e;
import com.tencent.thumbplayer.utils.a;
import java.io.IOException;
import java.io.Serializable;
import java.io.StringWriter;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlSerializer;

public final class d
  implements com.tencent.thumbplayer.b.a.d, Serializable
{
  private int Mao;
  private int Map;
  public List<e> Maq;
  
  public final List<e> fWE()
  {
    return this.Maq;
  }
  
  public final long fWF()
  {
    AppMethodBeat.i(191882);
    Iterator localIterator = this.Maq.iterator();
    for (long l = 0L; localIterator.hasNext(); l = ((e)localIterator.next()).fWH() + l) {}
    AppMethodBeat.o(191882);
    return l;
  }
  
  public final int getMediaType()
  {
    return this.Map;
  }
  
  public final int getTrackId()
  {
    return this.Mao;
  }
  
  public final String getUrl()
  {
    AppMethodBeat.i(191881);
    for (;;)
    {
      int i;
      try
      {
        localList = this.Maq;
        i = this.Map;
        if (!a.isEmpty(localList)) {
          break label156;
        }
        AppMethodBeat.o(191881);
        return "";
      }
      catch (IOException localIOException)
      {
        List localList;
        XmlSerializer localXmlSerializer;
        StringWriter localStringWriter;
        String str1;
        com.tencent.thumbplayer.utils.d.e("TPMediaCompositionTrack", localIOException);
        AppMethodBeat.o(191881);
        return null;
      }
      localXmlSerializer = Xml.newSerializer();
      localStringWriter = new StringWriter();
      localXmlSerializer.setOutput(localStringWriter);
      localXmlSerializer.startDocument("UTF-8", Boolean.TRUE);
      localXmlSerializer.startTag("", "assets");
      String str3;
      f.a(localXmlSerializer, localList, str3, str1);
      localXmlSerializer.endTag("", "assets");
      localXmlSerializer.endDocument();
      str1 = localStringWriter.toString();
      AppMethodBeat.o(191881);
      return str1;
      label156:
      String str2;
      if (i == 2)
      {
        str3 = "video_tracks";
        str1 = "video_track";
        continue;
        AppMethodBeat.o(191881);
        return "";
        if (i == 1)
        {
          str3 = "av_tracks";
          str2 = "av_track";
        }
      }
      else if (i == 3)
      {
        str3 = "audio_tracks";
        str2 = "audio_track";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.d.d
 * JD-Core Version:    0.7.0.1
 */