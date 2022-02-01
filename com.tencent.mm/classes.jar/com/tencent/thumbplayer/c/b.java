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
  private int RYJ;
  private int RYK;
  private int RYL;
  private List<ITPMediaTrack> RYM;
  private List<ITPMediaTrack> RYN;
  private List<ITPMediaTrack> RYO;
  
  public b()
  {
    AppMethodBeat.i(189107);
    this.RYJ = 0;
    this.RYK = 0;
    this.RYL = 0;
    this.RYM = new ArrayList(1);
    this.RYN = new ArrayList(1);
    this.RYO = new ArrayList(1);
    AppMethodBeat.o(189107);
  }
  
  private long getAudioDuration()
  {
    AppMethodBeat.i(189118);
    long l2;
    if (this.RYN != null)
    {
      Iterator localIterator = this.RYN.iterator();
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
      AppMethodBeat.o(189118);
      return l2;
    }
  }
  
  private int hnf()
  {
    try
    {
      int i = this.RYJ + 1;
      this.RYJ = i;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private int hng()
  {
    try
    {
      int i = this.RYK + 1;
      this.RYK = i;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private int hnh()
  {
    try
    {
      int i = this.RYL + 1;
      this.RYL = i;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private long hni()
  {
    AppMethodBeat.i(189117);
    long l2;
    if (this.RYM != null)
    {
      Iterator localIterator = this.RYM.iterator();
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
      AppMethodBeat.o(189117);
      return l2;
    }
  }
  
  public final ITPMediaTrack addAVTrack()
  {
    try
    {
      AppMethodBeat.i(189110);
      d locald = new d(hnh(), 1);
      this.RYO.add(locald);
      AppMethodBeat.o(189110);
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
      AppMethodBeat.i(189109);
      d locald = new d(hng(), 3);
      this.RYN.add(locald);
      AppMethodBeat.o(189109);
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
      AppMethodBeat.i(189108);
      d locald = new d(hnf(), 2);
      this.RYM.add(locald);
      AppMethodBeat.o(189108);
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
    return this.RYO;
  }
  
  public final List<ITPMediaTrack> getAllAudioTracks()
  {
    try
    {
      List localList = this.RYN;
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
      List localList = this.RYM;
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
    AppMethodBeat.i(189114);
    Object localObject;
    long l1;
    long l2;
    if (!com.tencent.thumbplayer.utils.b.isEmpty(this.RYO)) {
      if (this.RYO != null)
      {
        localObject = this.RYO.iterator();
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
      AppMethodBeat.o(189114);
      return l2;
      l2 = getAudioDuration();
      long l4 = hni();
      long l3;
      int i;
      if (l4 > l2)
      {
        l3 = l4;
        localObject = c.RYP;
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
        AppMethodBeat.o(189114);
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
    AppMethodBeat.i(189116);
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
          AppMethodBeat.o(189116);
          return localObject;
        }
        localList1 = getAllVideoTracks();
        localList2 = getAllAudioTracks();
        if ((com.tencent.thumbplayer.utils.b.isEmpty(localList1)) && (com.tencent.thumbplayer.utils.b.isEmpty(localList2)))
        {
          AppMethodBeat.o(189116);
          return "";
        }
      }
      catch (Exception localException)
      {
        g.e("TPMediaComposition", localException);
        AppMethodBeat.o(189116);
        return null;
      }
      long l = ((b)this).hni();
      f.a(localException, localList1, 2, ((b)this).getAudioDuration());
      f.a(localException, localList2, 3, l);
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(189115);
    if (this.RYM != null)
    {
      this.RYM.clear();
      this.RYM = null;
    }
    if (this.RYN != null)
    {
      this.RYN.clear();
      this.RYN = null;
    }
    if (this.RYO != null)
    {
      this.RYO.clear();
      this.RYO = null;
    }
    AppMethodBeat.o(189115);
  }
  
  public final boolean removeAVTrack(ITPMediaTrack paramITPMediaTrack)
  {
    AppMethodBeat.i(189113);
    if (paramITPMediaTrack == null)
    {
      paramITPMediaTrack = new IllegalArgumentException("remove audio track , track is null .");
      AppMethodBeat.o(189113);
      throw paramITPMediaTrack;
    }
    boolean bool = this.RYO.remove(paramITPMediaTrack);
    AppMethodBeat.o(189113);
    return bool;
  }
  
  public final boolean removeAudioTrack(ITPMediaTrack paramITPMediaTrack)
  {
    try
    {
      AppMethodBeat.i(189112);
      if (paramITPMediaTrack == null)
      {
        paramITPMediaTrack = new IllegalArgumentException("remove audio track , track is null .");
        AppMethodBeat.o(189112);
        throw paramITPMediaTrack;
      }
    }
    finally {}
    boolean bool = this.RYN.remove(paramITPMediaTrack);
    AppMethodBeat.o(189112);
    return bool;
  }
  
  public final boolean removeVideoTrack(ITPMediaTrack paramITPMediaTrack)
  {
    try
    {
      AppMethodBeat.i(189111);
      if (paramITPMediaTrack == null)
      {
        paramITPMediaTrack = new IllegalArgumentException("remove video track , track is null .");
        AppMethodBeat.o(189111);
        throw paramITPMediaTrack;
      }
    }
    finally {}
    boolean bool = this.RYM.remove(paramITPMediaTrack);
    AppMethodBeat.o(189111);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.thumbplayer.c.b
 * JD-Core Version:    0.7.0.1
 */