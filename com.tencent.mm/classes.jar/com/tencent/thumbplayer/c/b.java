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
  private int ZBt;
  private int ZBu;
  private int ZBv;
  private List<ITPMediaTrack> ZBw;
  private List<ITPMediaTrack> ZBx;
  private List<ITPMediaTrack> ZBy;
  
  public b()
  {
    AppMethodBeat.i(220105);
    this.ZBt = 0;
    this.ZBu = 0;
    this.ZBv = 0;
    this.ZBw = new ArrayList(1);
    this.ZBx = new ArrayList(1);
    this.ZBy = new ArrayList(1);
    AppMethodBeat.o(220105);
  }
  
  private long getAudioDuration()
  {
    AppMethodBeat.i(220131);
    long l2;
    if (this.ZBx != null)
    {
      Iterator localIterator = this.ZBx.iterator();
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
      AppMethodBeat.o(220131);
      return l2;
    }
  }
  
  private int iqG()
  {
    try
    {
      int i = this.ZBt + 1;
      this.ZBt = i;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private int iqH()
  {
    try
    {
      int i = this.ZBu + 1;
      this.ZBu = i;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private int iqI()
  {
    try
    {
      int i = this.ZBv + 1;
      this.ZBv = i;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private long iqJ()
  {
    AppMethodBeat.i(220129);
    long l2;
    if (this.ZBw != null)
    {
      Iterator localIterator = this.ZBw.iterator();
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
      AppMethodBeat.o(220129);
      return l2;
    }
  }
  
  public final ITPMediaTrack addAVTrack()
  {
    try
    {
      AppMethodBeat.i(220110);
      d locald = new d(iqI(), 1);
      this.ZBy.add(locald);
      AppMethodBeat.o(220110);
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
      AppMethodBeat.i(220109);
      d locald = new d(iqH(), 3);
      this.ZBx.add(locald);
      AppMethodBeat.o(220109);
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
      AppMethodBeat.i(220107);
      d locald = new d(iqG(), 2);
      this.ZBw.add(locald);
      AppMethodBeat.o(220107);
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
    return this.ZBy;
  }
  
  public final List<ITPMediaTrack> getAllAudioTracks()
  {
    try
    {
      List localList = this.ZBx;
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
      List localList = this.ZBw;
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
    AppMethodBeat.i(220122);
    Object localObject;
    long l1;
    long l2;
    if (!com.tencent.thumbplayer.utils.b.isEmpty(this.ZBy)) {
      if (this.ZBy != null)
      {
        localObject = this.ZBy.iterator();
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
      AppMethodBeat.o(220122);
      return l2;
      l2 = getAudioDuration();
      long l4 = iqJ();
      long l3;
      int i;
      if (l4 > l2)
      {
        l3 = l4;
        localObject = c.ZBz;
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
        AppMethodBeat.o(220122);
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
    AppMethodBeat.i(220127);
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
          AppMethodBeat.o(220127);
          return localObject;
        }
        localList1 = getAllVideoTracks();
        localList2 = getAllAudioTracks();
        if ((com.tencent.thumbplayer.utils.b.isEmpty(localList1)) && (com.tencent.thumbplayer.utils.b.isEmpty(localList2)))
        {
          AppMethodBeat.o(220127);
          return "";
        }
      }
      catch (Exception localException)
      {
        g.e("TPMediaComposition", localException);
        AppMethodBeat.o(220127);
        return null;
      }
      long l = ((b)this).iqJ();
      f.a(localException, localList1, 2, ((b)this).getAudioDuration());
      f.a(localException, localList2, 3, l);
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(220125);
    if (this.ZBw != null)
    {
      this.ZBw.clear();
      this.ZBw = null;
    }
    if (this.ZBx != null)
    {
      this.ZBx.clear();
      this.ZBx = null;
    }
    if (this.ZBy != null)
    {
      this.ZBy.clear();
      this.ZBy = null;
    }
    AppMethodBeat.o(220125);
  }
  
  public final boolean removeAVTrack(ITPMediaTrack paramITPMediaTrack)
  {
    AppMethodBeat.i(220115);
    if (paramITPMediaTrack == null)
    {
      paramITPMediaTrack = new IllegalArgumentException("remove audio track , track is null .");
      AppMethodBeat.o(220115);
      throw paramITPMediaTrack;
    }
    boolean bool = this.ZBy.remove(paramITPMediaTrack);
    AppMethodBeat.o(220115);
    return bool;
  }
  
  public final boolean removeAudioTrack(ITPMediaTrack paramITPMediaTrack)
  {
    try
    {
      AppMethodBeat.i(220113);
      if (paramITPMediaTrack == null)
      {
        paramITPMediaTrack = new IllegalArgumentException("remove audio track , track is null .");
        AppMethodBeat.o(220113);
        throw paramITPMediaTrack;
      }
    }
    finally {}
    boolean bool = this.ZBx.remove(paramITPMediaTrack);
    AppMethodBeat.o(220113);
    return bool;
  }
  
  public final boolean removeVideoTrack(ITPMediaTrack paramITPMediaTrack)
  {
    try
    {
      AppMethodBeat.i(220111);
      if (paramITPMediaTrack == null)
      {
        paramITPMediaTrack = new IllegalArgumentException("remove video track , track is null .");
        AppMethodBeat.o(220111);
        throw paramITPMediaTrack;
      }
    }
    finally {}
    boolean bool = this.ZBw.remove(paramITPMediaTrack);
    AppMethodBeat.o(220111);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.c.b
 * JD-Core Version:    0.7.0.1
 */