package com.tencent.mm.plugin.music.f.b;

import com.google.android.exoplayer2.d.b;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import com.google.android.exoplayer2.metadata.id3.ApicFrame;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;
import com.google.android.exoplayer2.metadata.id3.GeobFrame;
import com.google.android.exoplayer2.metadata.id3.Id3Frame;
import com.google.android.exoplayer2.metadata.id3.PrivFrame;
import com.google.android.exoplayer2.metadata.id3.TextInformationFrame;
import com.google.android.exoplayer2.metadata.id3.UrlLinkFrame;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import java.text.NumberFormat;
import java.util.Locale;

public final class a
{
  private static final NumberFormat vhb;
  
  static
  {
    AppMethodBeat.i(137413);
    NumberFormat localNumberFormat = NumberFormat.getInstance(Locale.US);
    vhb = localNumberFormat;
    localNumberFormat.setMinimumFractionDigits(2);
    vhb.setMaximumFractionDigits(2);
    vhb.setGroupingUsed(false);
    AppMethodBeat.o(137413);
  }
  
  public static String JZ(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "?";
    case 2: 
      return "B";
    case 4: 
      return "E";
    case 1: 
      return "I";
    }
    return "R";
  }
  
  public static void a(Metadata paramMetadata, String paramString)
  {
    AppMethodBeat.i(137412);
    int i = 0;
    if (i < paramMetadata.bjI.length)
    {
      Object localObject = paramMetadata.bjI[i];
      if ((localObject instanceof TextInformationFrame))
      {
        localObject = (TextInformationFrame)localObject;
        ac.d("MicroMsg.ExoPlayer", paramString + String.format("%s: value=%s", new Object[] { ((TextInformationFrame)localObject).id, ((TextInformationFrame)localObject).value }));
      }
      for (;;)
      {
        i += 1;
        break;
        if ((localObject instanceof UrlLinkFrame))
        {
          localObject = (UrlLinkFrame)localObject;
          ac.d("MicroMsg.ExoPlayer", paramString + String.format("%s: url=%s", new Object[] { ((UrlLinkFrame)localObject).id, ((UrlLinkFrame)localObject).url }));
        }
        else if ((localObject instanceof PrivFrame))
        {
          localObject = (PrivFrame)localObject;
          ac.d("MicroMsg.ExoPlayer", paramString + String.format("%s: owner=%s", new Object[] { ((PrivFrame)localObject).id, ((PrivFrame)localObject).bkl }));
        }
        else if ((localObject instanceof GeobFrame))
        {
          localObject = (GeobFrame)localObject;
          ac.d("MicroMsg.ExoPlayer", paramString + String.format("%s: mimeType=%s, filename=%s, description=%s", new Object[] { ((GeobFrame)localObject).id, ((GeobFrame)localObject).mimeType, ((GeobFrame)localObject).filename, ((GeobFrame)localObject).description }));
        }
        else if ((localObject instanceof ApicFrame))
        {
          localObject = (ApicFrame)localObject;
          ac.d("MicroMsg.ExoPlayer", paramString + String.format("%s: mimeType=%s, description=%s", new Object[] { ((ApicFrame)localObject).id, ((ApicFrame)localObject).mimeType, ((ApicFrame)localObject).description }));
        }
        else if ((localObject instanceof CommentFrame))
        {
          localObject = (CommentFrame)localObject;
          ac.d("MicroMsg.ExoPlayer", paramString + String.format("%s: language=%s, description=%s", new Object[] { ((CommentFrame)localObject).id, ((CommentFrame)localObject).aTm, ((CommentFrame)localObject).description }));
        }
        else if ((localObject instanceof Id3Frame))
        {
          localObject = (Id3Frame)localObject;
          ac.d("MicroMsg.ExoPlayer", paramString + String.format("%s", new Object[] { ((Id3Frame)localObject).id }));
        }
        else if ((localObject instanceof EventMessage))
        {
          localObject = (EventMessage)localObject;
          ac.d("MicroMsg.ExoPlayer", paramString + String.format("EMSG: scheme=%s, id=%d, value=%s", new Object[] { ((EventMessage)localObject).bjT, Long.valueOf(((EventMessage)localObject).id), ((EventMessage)localObject).value }));
        }
      }
    }
    AppMethodBeat.o(137412);
  }
  
  public static void djs()
  {
    AppMethodBeat.i(137410);
    b.DEBUG = false;
    b.a(new a.1());
    AppMethodBeat.o(137410);
  }
  
  public static String wc(long paramLong)
  {
    AppMethodBeat.i(137411);
    if (paramLong == -9223372036854775807L)
    {
      AppMethodBeat.o(137411);
      return "?";
    }
    String str = vhb.format((float)paramLong / 1000.0F);
    AppMethodBeat.o(137411);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.f.b.a
 * JD-Core Version:    0.7.0.1
 */