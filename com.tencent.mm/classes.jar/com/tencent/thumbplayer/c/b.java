package com.tencent.thumbplayer.c;

import android.util.Xml;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.api.composition.ITPMediaComposition;
import com.tencent.thumbplayer.api.composition.ITPMediaTrack;
import com.tencent.thumbplayer.utils.g;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlSerializer;

public final class b
  implements ITPMediaComposition
{
  private List<ITPMediaTrack> ahGA;
  private List<ITPMediaTrack> ahGB;
  private int ahGw;
  private int ahGx;
  private int ahGy;
  private List<ITPMediaTrack> ahGz;
  
  public b()
  {
    AppMethodBeat.i(226950);
    this.ahGw = 0;
    this.ahGx = 0;
    this.ahGy = 0;
    this.ahGz = new ArrayList(1);
    this.ahGA = new ArrayList(1);
    this.ahGB = new ArrayList(1);
    AppMethodBeat.o(226950);
  }
  
  private long getAudioDuration()
  {
    AppMethodBeat.i(226977);
    long l2;
    if (this.ahGA != null)
    {
      Iterator localIterator = this.ahGA.iterator();
      long l1 = 0L;
      l2 = l1;
      if (!localIterator.hasNext()) {
        break label74;
      }
      ITPMediaTrack localITPMediaTrack = (ITPMediaTrack)localIterator.next();
      if (l1 >= localITPMediaTrack.getTimelineDurationMs()) {
        break label81;
      }
      l1 = localITPMediaTrack.getTimelineDurationMs();
    }
    label74:
    label81:
    for (;;)
    {
      break;
      l2 = 0L;
      AppMethodBeat.o(226977);
      return l2;
    }
  }
  
  private int kac()
  {
    try
    {
      int i = this.ahGw + 1;
      this.ahGw = i;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private int kad()
  {
    try
    {
      int i = this.ahGx + 1;
      this.ahGx = i;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private int kae()
  {
    try
    {
      int i = this.ahGy + 1;
      this.ahGy = i;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private long kaf()
  {
    AppMethodBeat.i(226970);
    long l2;
    if (this.ahGz != null)
    {
      Iterator localIterator = this.ahGz.iterator();
      long l1 = 0L;
      l2 = l1;
      if (!localIterator.hasNext()) {
        break label74;
      }
      ITPMediaTrack localITPMediaTrack = (ITPMediaTrack)localIterator.next();
      if (l1 >= localITPMediaTrack.getTimelineDurationMs()) {
        break label81;
      }
      l1 = localITPMediaTrack.getTimelineDurationMs();
    }
    label74:
    label81:
    for (;;)
    {
      break;
      l2 = 0L;
      AppMethodBeat.o(226970);
      return l2;
    }
  }
  
  public final ITPMediaTrack addAVTrack()
  {
    try
    {
      AppMethodBeat.i(226988);
      d locald = new d(kae(), 1);
      this.ahGB.add(locald);
      AppMethodBeat.o(226988);
      return locald;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final ITPMediaTrack addAudioTrack()
  {
    try
    {
      AppMethodBeat.i(226986);
      d locald = new d(kad(), 3);
      this.ahGA.add(locald);
      AppMethodBeat.o(226986);
      return locald;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final ITPMediaTrack addVideoTrack()
  {
    try
    {
      AppMethodBeat.i(226985);
      d locald = new d(kac(), 2);
      this.ahGz.add(locald);
      AppMethodBeat.o(226985);
      return locald;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final List<ITPMediaTrack> getAllAVTracks()
  {
    return this.ahGB;
  }
  
  public final List<ITPMediaTrack> getAllAudioTracks()
  {
    try
    {
      List localList = this.ahGA;
      return localList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final List<ITPMediaTrack> getAllVideoTracks()
  {
    try
    {
      List localList = this.ahGz;
      return localList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final long getDurationMs()
  {
    AppMethodBeat.i(227018);
    Object localObject;
    long l1;
    long l2;
    if (!com.tencent.thumbplayer.utils.b.isEmpty(this.ahGB)) {
      if (this.ahGB != null)
      {
        localObject = this.ahGB.iterator();
        l1 = 0L;
        l2 = l1;
        if (!((Iterator)localObject).hasNext()) {
          break label86;
        }
        ITPMediaTrack localITPMediaTrack = (ITPMediaTrack)((Iterator)localObject).next();
        if (l1 >= localITPMediaTrack.getTimelineDurationMs()) {
          break label281;
        }
        l1 = localITPMediaTrack.getTimelineDurationMs();
      }
    }
    label281:
    for (;;)
    {
      break;
      l2 = 0L;
      label86:
      AppMethodBeat.o(227018);
      return l2;
      l2 = getAudioDuration();
      long l4 = kaf();
      long l3;
      int i;
      if (l4 > l2)
      {
        l3 = l4;
        localObject = c.ahGC;
        i = -1;
        switch (((String)localObject).hashCode())
        {
        default: 
          label164:
          l1 = l4;
          switch (i)
          {
          default: 
            l1 = l3;
          }
          break;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(227018);
        return l1;
        l3 = l2;
        break;
        if (!((String)localObject).equals("base_video")) {
          break label164;
        }
        i = 0;
        break label164;
        if (!((String)localObject).equals("base_audio")) {
          break label164;
        }
        i = 1;
        break label164;
        if (!((String)localObject).equals("base_longer")) {
          break label164;
        }
        i = 2;
        break label164;
        l1 = l2;
        continue;
        l1 = l4;
        if (l4 <= l2) {
          l1 = l2;
        }
      }
    }
  }
  
  public final int getMediaType()
  {
    return 4;
  }
  
  public final String getUrl()
  {
    AppMethodBeat.i(227034);
    for (;;)
    {
      List localList1;
      List localList2;
      try
      {
        Object localObject = Xml.newSerializer();
        StringWriter localStringWriter = new StringWriter();
        ((XmlSerializer)localObject).setOutput(localStringWriter);
        ((XmlSerializer)localObject).startDocument("UTF-8", Boolean.TRUE);
        ((XmlSerializer)localObject).startTag("", "assets");
        localList1 = getAllAVTracks();
        if (!com.tencent.thumbplayer.utils.b.isEmpty(localList1))
        {
          f.a((XmlSerializer)localObject, localList1, 1, 0L);
          ((XmlSerializer)localObject).endTag("", "assets");
          ((XmlSerializer)localObject).endDocument();
          localObject = localStringWriter.toString();
          AppMethodBeat.o(227034);
          return localObject;
        }
        localList1 = getAllVideoTracks();
        localList2 = getAllAudioTracks();
        if ((com.tencent.thumbplayer.utils.b.isEmpty(localList1)) && (com.tencent.thumbplayer.utils.b.isEmpty(localList2)))
        {
          AppMethodBeat.o(227034);
          return "";
        }
      }
      catch (Exception localException)
      {
        g.e("TPMediaComposition", localException);
        AppMethodBeat.o(227034);
        return null;
      }
      long l = ((b)this).kaf();
      f.a(localException, localList1, 2, ((b)this).getAudioDuration());
      f.a(localException, localList2, 3, l);
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(227025);
    if (this.ahGz != null)
    {
      this.ahGz.clear();
      this.ahGz = null;
    }
    if (this.ahGA != null)
    {
      this.ahGA.clear();
      this.ahGA = null;
    }
    if (this.ahGB != null)
    {
      this.ahGB.clear();
      this.ahGB = null;
    }
    AppMethodBeat.o(227025);
  }
  
  public final boolean removeAVTrack(ITPMediaTrack paramITPMediaTrack)
  {
    AppMethodBeat.i(227000);
    if (paramITPMediaTrack == null)
    {
      paramITPMediaTrack = new IllegalArgumentException("remove audio track , track is null .");
      AppMethodBeat.o(227000);
      throw paramITPMediaTrack;
    }
    boolean bool = this.ahGB.remove(paramITPMediaTrack);
    AppMethodBeat.o(227000);
    return bool;
  }
  
  public final boolean removeAudioTrack(ITPMediaTrack paramITPMediaTrack)
  {
    try
    {
      AppMethodBeat.i(226997);
      if (paramITPMediaTrack == null)
      {
        paramITPMediaTrack = new IllegalArgumentException("remove audio track , track is null .");
        AppMethodBeat.o(226997);
        throw paramITPMediaTrack;
      }
    }
    finally {}
    boolean bool = this.ahGA.remove(paramITPMediaTrack);
    AppMethodBeat.o(226997);
    return bool;
  }
  
  public final boolean removeVideoTrack(ITPMediaTrack paramITPMediaTrack)
  {
    try
    {
      AppMethodBeat.i(226995);
      if (paramITPMediaTrack == null)
      {
        paramITPMediaTrack = new IllegalArgumentException("remove video track , track is null .");
        AppMethodBeat.o(226995);
        throw paramITPMediaTrack;
      }
    }
    finally {}
    boolean bool = this.ahGz.remove(paramITPMediaTrack);
    AppMethodBeat.o(226995);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.thumbplayer.c.b
 * JD-Core Version:    0.7.0.1
 */