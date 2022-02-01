package com.tencent.thumbplayer.d;

import android.util.Xml;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.utils.a;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlSerializer;

public final class b
  implements com.tencent.thumbplayer.b.a.b
{
  private int MwZ;
  private int Mxa;
  private int Mxb;
  private List<com.tencent.thumbplayer.b.a.d> Mxc;
  private List<com.tencent.thumbplayer.b.a.d> Mxd;
  public List<com.tencent.thumbplayer.b.a.d> Mxe;
  
  public b()
  {
    AppMethodBeat.i(194555);
    this.MwZ = 0;
    this.Mxa = 0;
    this.Mxb = 0;
    this.Mxc = new ArrayList(1);
    this.Mxd = new ArrayList(1);
    this.Mxe = new ArrayList(1);
    AppMethodBeat.o(194555);
  }
  
  private long gbk()
  {
    AppMethodBeat.i(194557);
    long l2;
    if (this.Mxc != null)
    {
      Iterator localIterator = this.Mxc.iterator();
      long l1 = 0L;
      l2 = l1;
      if (!localIterator.hasNext()) {
        break label74;
      }
      com.tencent.thumbplayer.b.a.d locald = (com.tencent.thumbplayer.b.a.d)localIterator.next();
      if (l1 >= locald.gbe()) {
        break label81;
      }
      l1 = locald.gbe();
    }
    label74:
    label81:
    for (;;)
    {
      break;
      l2 = 0L;
      AppMethodBeat.o(194557);
      return l2;
    }
  }
  
  private long getAudioDuration()
  {
    AppMethodBeat.i(194558);
    long l2;
    if (this.Mxd != null)
    {
      Iterator localIterator = this.Mxd.iterator();
      long l1 = 0L;
      l2 = l1;
      if (!localIterator.hasNext()) {
        break label74;
      }
      com.tencent.thumbplayer.b.a.d locald = (com.tencent.thumbplayer.b.a.d)localIterator.next();
      if (l1 >= locald.gbe()) {
        break label81;
      }
      l1 = locald.gbe();
    }
    label74:
    label81:
    for (;;)
    {
      break;
      l2 = 0L;
      AppMethodBeat.o(194558);
      return l2;
    }
  }
  
  public final List<com.tencent.thumbplayer.b.a.d> gaY()
  {
    return this.Mxc;
  }
  
  public final List<com.tencent.thumbplayer.b.a.d> gaZ()
  {
    return this.Mxd;
  }
  
  public final List<com.tencent.thumbplayer.b.a.d> gba()
  {
    return this.Mxe;
  }
  
  public final int getMediaType()
  {
    return 4;
  }
  
  public final String getUrl()
  {
    AppMethodBeat.i(194556);
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
        localList1 = gba();
        if (!a.isEmpty(localList1))
        {
          f.a((XmlSerializer)localObject, localList1, 1, 0L);
          ((XmlSerializer)localObject).endTag("", "assets");
          ((XmlSerializer)localObject).endDocument();
          localObject = localStringWriter.toString();
          AppMethodBeat.o(194556);
          return localObject;
        }
        localList1 = gaY();
        localList2 = gaZ();
        if ((a.isEmpty(localList1)) && (a.isEmpty(localList2)))
        {
          AppMethodBeat.o(194556);
          return "";
        }
      }
      catch (Exception localException)
      {
        com.tencent.thumbplayer.utils.d.e("TPMediaComposition", localException);
        AppMethodBeat.o(194556);
        return null;
      }
      long l = ((b)this).gbk();
      f.a(localException, localList1, 2, ((b)this).getAudioDuration());
      f.a(localException, localList2, 3, l);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.d.b
 * JD-Core Version:    0.7.0.1
 */