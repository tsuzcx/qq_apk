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
import com.tencent.mm.sdk.platformtools.y;
import java.text.NumberFormat;
import java.util.Locale;

public final class a
{
  private static final NumberFormat mAX;
  
  static
  {
    NumberFormat localNumberFormat = NumberFormat.getInstance(Locale.US);
    mAX = localNumberFormat;
    localNumberFormat.setMinimumFractionDigits(2);
    mAX.setMaximumFractionDigits(2);
    mAX.setGroupingUsed(false);
  }
  
  public static void a(Metadata paramMetadata, String paramString)
  {
    int i = 0;
    if (i < paramMetadata.aGI.length)
    {
      Object localObject = paramMetadata.aGI[i];
      if ((localObject instanceof TextInformationFrame))
      {
        localObject = (TextInformationFrame)localObject;
        y.d("MicroMsg.ExoPlayer", paramString + String.format("%s: value=%s", new Object[] { ((TextInformationFrame)localObject).id, ((TextInformationFrame)localObject).value }));
      }
      for (;;)
      {
        i += 1;
        break;
        if ((localObject instanceof UrlLinkFrame))
        {
          localObject = (UrlLinkFrame)localObject;
          y.d("MicroMsg.ExoPlayer", paramString + String.format("%s: url=%s", new Object[] { ((UrlLinkFrame)localObject).id, ((UrlLinkFrame)localObject).url }));
        }
        else if ((localObject instanceof PrivFrame))
        {
          localObject = (PrivFrame)localObject;
          y.d("MicroMsg.ExoPlayer", paramString + String.format("%s: owner=%s", new Object[] { ((PrivFrame)localObject).id, ((PrivFrame)localObject).aHm }));
        }
        else if ((localObject instanceof GeobFrame))
        {
          localObject = (GeobFrame)localObject;
          y.d("MicroMsg.ExoPlayer", paramString + String.format("%s: mimeType=%s, filename=%s, description=%s", new Object[] { ((GeobFrame)localObject).id, ((GeobFrame)localObject).mimeType, ((GeobFrame)localObject).filename, ((GeobFrame)localObject).description }));
        }
        else if ((localObject instanceof ApicFrame))
        {
          localObject = (ApicFrame)localObject;
          y.d("MicroMsg.ExoPlayer", paramString + String.format("%s: mimeType=%s, description=%s", new Object[] { ((ApicFrame)localObject).id, ((ApicFrame)localObject).mimeType, ((ApicFrame)localObject).description }));
        }
        else if ((localObject instanceof CommentFrame))
        {
          localObject = (CommentFrame)localObject;
          y.d("MicroMsg.ExoPlayer", paramString + String.format("%s: language=%s, description=%s", new Object[] { ((CommentFrame)localObject).id, ((CommentFrame)localObject).auI, ((CommentFrame)localObject).description }));
        }
        else if ((localObject instanceof Id3Frame))
        {
          localObject = (Id3Frame)localObject;
          y.d("MicroMsg.ExoPlayer", paramString + String.format("%s", new Object[] { ((Id3Frame)localObject).id }));
        }
        else if ((localObject instanceof EventMessage))
        {
          localObject = (EventMessage)localObject;
          y.d("MicroMsg.ExoPlayer", paramString + String.format("EMSG: scheme=%s, id=%d, value=%s", new Object[] { ((EventMessage)localObject).aGT, Long.valueOf(((EventMessage)localObject).id), ((EventMessage)localObject).value }));
        }
      }
    }
  }
  
  public static void bnN()
  {
    b.DEBUG = false;
    b.a(new a.1());
  }
  
  public static String fm(long paramLong)
  {
    if (paramLong == -9223372036854775807L) {
      return "?";
    }
    return mAX.format((float)paramLong / 1000.0F);
  }
  
  public static String uX(int paramInt)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.f.b.a
 * JD-Core Version:    0.7.0.1
 */