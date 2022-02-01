package com.tencent.thumbplayer.c;

import android.util.Xml;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.api.composition.ITPMediaTrack;
import com.tencent.thumbplayer.api.composition.ITPMediaTrackClip;
import com.tencent.thumbplayer.utils.b;
import com.tencent.thumbplayer.utils.g;
import java.io.IOException;
import java.io.Serializable;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlSerializer;

public final class d
  implements ITPMediaTrack, Serializable
{
  private int ahGG;
  private int ahGH;
  private List<ITPMediaTrackClip> ahGI;
  
  public d(int paramInt)
  {
    AppMethodBeat.i(226947);
    this.ahGG = -1;
    this.ahGH = paramInt;
    this.ahGI = new ArrayList();
    AppMethodBeat.o(226947);
  }
  
  public d(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(226952);
    this.ahGG = -1;
    this.ahGG = paramInt1;
    this.ahGH = paramInt2;
    this.ahGI = new ArrayList();
    AppMethodBeat.o(226952);
  }
  
  private void a(ITPMediaTrackClip paramITPMediaTrackClip)
  {
    try
    {
      AppMethodBeat.i(226956);
      if (paramITPMediaTrackClip == null)
      {
        paramITPMediaTrackClip = new IllegalArgumentException("add track clip , clip can not be null");
        AppMethodBeat.o(226956);
        throw paramITPMediaTrackClip;
      }
    }
    finally {}
    if (paramITPMediaTrackClip.getMediaType() != this.ahGH)
    {
      paramITPMediaTrackClip = new IllegalArgumentException("add track clip failed, media type is not same");
      AppMethodBeat.o(226956);
      throw paramITPMediaTrackClip;
    }
    AppMethodBeat.o(226956);
  }
  
  /* Error */
  public final int addTrackClip(ITPMediaTrackClip paramITPMediaTrackClip)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 61
    //   4: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: aload_1
    //   9: invokespecial 63	com/tencent/thumbplayer/c/d:a	(Lcom/tencent/thumbplayer/api/composition/ITPMediaTrackClip;)V
    //   12: aload_0
    //   13: getfield 34	com/tencent/thumbplayer/c/d:ahGI	Ljava/util/List;
    //   16: aload_1
    //   17: invokeinterface 69 2 0
    //   22: ifeq +45 -> 67
    //   25: ldc 71
    //   27: new 73	java/lang/StringBuilder
    //   30: dup
    //   31: ldc 75
    //   33: invokespecial 76	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   36: aload_1
    //   37: invokeinterface 79 1 0
    //   42: invokevirtual 83	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   45: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokestatic 92	com/tencent/thumbplayer/utils/g:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   51: aload_1
    //   52: invokeinterface 79 1 0
    //   57: istore_2
    //   58: ldc 61
    //   60: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   63: aload_0
    //   64: monitorexit
    //   65: iload_2
    //   66: ireturn
    //   67: aload_0
    //   68: getfield 34	com/tencent/thumbplayer/c/d:ahGI	Ljava/util/List;
    //   71: aload_1
    //   72: invokeinterface 95 2 0
    //   77: pop
    //   78: aload_1
    //   79: invokeinterface 79 1 0
    //   84: istore_2
    //   85: ldc 61
    //   87: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   90: goto -27 -> 63
    //   93: astore_1
    //   94: aload_0
    //   95: monitorexit
    //   96: aload_1
    //   97: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	98	0	this	d
    //   0	98	1	paramITPMediaTrackClip	ITPMediaTrackClip
    //   57	28	2	i	int
    // Exception table:
    //   from	to	target	type
    //   2	63	93	finally
    //   67	90	93	finally
  }
  
  public final List<ITPMediaTrackClip> getAllTrackClips()
  {
    try
    {
      List localList = this.ahGI;
      return localList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int getMediaType()
  {
    try
    {
      int i = this.ahGH;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final long getTimelineDurationMs()
  {
    try
    {
      AppMethodBeat.i(227004);
      Iterator localIterator = this.ahGI.iterator();
      for (long l = 0L; localIterator.hasNext(); l = ((ITPMediaTrackClip)localIterator.next()).getOriginalDurationMs() + l) {}
      AppMethodBeat.o(227004);
      return l;
    }
    finally {}
  }
  
  /* Error */
  public final ITPMediaTrackClip getTrackClip(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 122
    //   4: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 34	com/tencent/thumbplayer/c/d:ahGI	Ljava/util/List;
    //   11: invokeinterface 106 1 0
    //   16: astore_3
    //   17: aload_3
    //   18: invokeinterface 112 1 0
    //   23: ifeq +32 -> 55
    //   26: aload_3
    //   27: invokeinterface 116 1 0
    //   32: checkcast 52	com/tencent/thumbplayer/api/composition/ITPMediaTrackClip
    //   35: astore_2
    //   36: aload_2
    //   37: invokeinterface 79 1 0
    //   42: iload_1
    //   43: if_icmpne -26 -> 17
    //   46: ldc 122
    //   48: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   51: aload_0
    //   52: monitorexit
    //   53: aload_2
    //   54: areturn
    //   55: aconst_null
    //   56: astore_2
    //   57: ldc 122
    //   59: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   62: goto -11 -> 51
    //   65: astore_2
    //   66: aload_0
    //   67: monitorexit
    //   68: aload_2
    //   69: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	70	0	this	d
    //   0	70	1	paramInt	int
    //   35	22	2	localITPMediaTrackClip	ITPMediaTrackClip
    //   65	4	2	localObject	Object
    //   16	11	3	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   2	17	65	finally
    //   17	51	65	finally
    //   57	62	65	finally
  }
  
  public final int getTrackId()
  {
    try
    {
      int i = this.ahGG;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final String getUrl()
  {
    for (;;)
    {
      List localList;
      String str1;
      try
      {
        AppMethodBeat.i(227001);
      }
      finally {}
      try
      {
        localList = this.ahGI;
        i = this.ahGH;
        if (!b.isEmpty(localList)) {
          continue;
        }
        str1 = "";
        AppMethodBeat.o(227001);
      }
      catch (IOException localIOException)
      {
        do
        {
          String str2;
          g.e("TPMediaCompositionTrack", localIOException);
          str3 = null;
          AppMethodBeat.o(227001);
          break;
        } while (i != 3);
        str4 = "audio_tracks";
        String str3 = "audio_track";
        continue;
      }
      return str1;
      if (i == 1)
      {
        str4 = "av_tracks";
        str1 = "av_track";
        XmlSerializer localXmlSerializer = Xml.newSerializer();
        StringWriter localStringWriter = new StringWriter();
        localXmlSerializer.setOutput(localStringWriter);
        localXmlSerializer.startDocument("UTF-8", Boolean.TRUE);
        localXmlSerializer.startTag("", "assets");
        f.a(localXmlSerializer, localList, str4, str1);
        localXmlSerializer.endTag("", "assets");
        localXmlSerializer.endDocument();
        str1 = localStringWriter.toString();
        AppMethodBeat.o(227001);
      }
      else
      {
        if (i != 2) {
          break;
        }
        str4 = "video_tracks";
        str2 = "video_track";
        continue;
        str2 = "";
        AppMethodBeat.o(227001);
      }
    }
  }
  
  public final int insertTrackClip(ITPMediaTrackClip paramITPMediaTrackClip, int paramInt)
  {
    try
    {
      AppMethodBeat.i(226966);
      a(paramITPMediaTrackClip);
      if (this.ahGI.contains(paramITPMediaTrackClip))
      {
        g.i("TPMediaCompositionTrack", "add track clip failed, clip already exists : " + paramITPMediaTrackClip.getClipId());
        paramInt = paramITPMediaTrackClip.getClipId();
        AppMethodBeat.o(226966);
      }
      for (;;)
      {
        return paramInt;
        if (paramInt != -1) {
          break;
        }
        this.ahGI.add(0, paramITPMediaTrackClip);
        paramInt = paramITPMediaTrackClip.getClipId();
        AppMethodBeat.o(226966);
      }
      j = this.ahGI.size();
    }
    finally {}
    int j;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        if (((ITPMediaTrackClip)this.ahGI.get(i)).getClipId() != paramInt) {
          break label212;
        }
        this.ahGI.add(i + 1, paramITPMediaTrackClip);
        paramInt = paramITPMediaTrackClip.getClipId();
        AppMethodBeat.o(226966);
        break;
      }
      this.ahGI.add(paramITPMediaTrackClip);
      g.i("TPMediaCompositionTrack", "insert track clip into the end, coz after clip not found :".concat(String.valueOf(paramInt)));
      paramInt = paramITPMediaTrackClip.getClipId();
      AppMethodBeat.o(226966);
      break;
      label212:
      i += 1;
    }
  }
  
  public final void removeAllTrackClips()
  {
    try
    {
      AppMethodBeat.i(226984);
      this.ahGI.clear();
      AppMethodBeat.o(226984);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean removeTrackClip(ITPMediaTrackClip paramITPMediaTrackClip)
  {
    try
    {
      AppMethodBeat.i(226975);
      if (paramITPMediaTrackClip == null)
      {
        paramITPMediaTrackClip = new IllegalArgumentException("remove track clip , clip can not be null");
        AppMethodBeat.o(226975);
        throw paramITPMediaTrackClip;
      }
    }
    finally {}
    boolean bool = this.ahGI.remove(paramITPMediaTrackClip);
    AppMethodBeat.o(226975);
    return bool;
  }
  
  public final boolean swapTrackClip(int paramInt1, int paramInt2)
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(226972);
        if ((paramInt1 < 0) || (paramInt1 >= this.ahGI.size()))
        {
          g.w("TPMediaCompositionTrack", "swap clip failed, from pos invalid , from pos : ".concat(String.valueOf(paramInt1)));
          AppMethodBeat.o(226972);
          return bool;
        }
        if ((paramInt2 < 0) || (paramInt2 >= this.ahGI.size()))
        {
          g.w("TPMediaCompositionTrack", "swap clip failed, to pos invalid , to pos :".concat(String.valueOf(paramInt2)));
          AppMethodBeat.o(226972);
          continue;
        }
        Collections.swap(this.ahGI, paramInt1, paramInt2);
      }
      finally {}
      bool = true;
      AppMethodBeat.o(226972);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.thumbplayer.c.d
 * JD-Core Version:    0.7.0.1
 */