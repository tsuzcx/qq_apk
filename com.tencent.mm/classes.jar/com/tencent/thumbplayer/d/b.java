package com.tencent.thumbplayer.d;

import android.util.Xml;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.b.a.d;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlSerializer;

public final class b
  implements com.tencent.thumbplayer.b.a.b
{
  private int KgO;
  private int KgP;
  private int KgQ;
  private List<d> KgR;
  private List<d> KgS;
  public List<d> KgT;
  
  public b()
  {
    AppMethodBeat.i(187856);
    this.KgO = 0;
    this.KgP = 0;
    this.KgQ = 0;
    this.KgR = new ArrayList(1);
    this.KgS = new ArrayList(1);
    this.KgT = new ArrayList(1);
    AppMethodBeat.o(187856);
  }
  
  private long fFw()
  {
    AppMethodBeat.i(187858);
    long l2;
    if (this.KgR != null)
    {
      Iterator localIterator = this.KgR.iterator();
      long l1 = 0L;
      l2 = l1;
      if (!localIterator.hasNext()) {
        break label74;
      }
      d locald = (d)localIterator.next();
      if (l1 >= locald.fFo()) {
        break label81;
      }
      l1 = locald.fFo();
    }
    label74:
    label81:
    for (;;)
    {
      break;
      l2 = 0L;
      AppMethodBeat.o(187858);
      return l2;
    }
  }
  
  private long getAudioDuration()
  {
    AppMethodBeat.i(187859);
    long l2;
    if (this.KgS != null)
    {
      Iterator localIterator = this.KgS.iterator();
      long l1 = 0L;
      l2 = l1;
      if (!localIterator.hasNext()) {
        break label74;
      }
      d locald = (d)localIterator.next();
      if (l1 >= locald.fFo()) {
        break label81;
      }
      l1 = locald.fFo();
    }
    label74:
    label81:
    for (;;)
    {
      break;
      l2 = 0L;
      AppMethodBeat.o(187859);
      return l2;
    }
  }
  
  public final List<d> fFi()
  {
    return this.KgR;
  }
  
  public final List<d> fFj()
  {
    return this.KgS;
  }
  
  public final List<d> fFk()
  {
    return this.KgT;
  }
  
  public final int getMediaType()
  {
    return 4;
  }
  
  public final String getUrl()
  {
    AppMethodBeat.i(187857);
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
        localList1 = fFk();
        if (!com.tencent.thumbplayer.utils.b.isEmpty(localList1))
        {
          f.a((XmlSerializer)localObject, localList1, 1, 0L);
          ((XmlSerializer)localObject).endTag("", "assets");
          ((XmlSerializer)localObject).endDocument();
          localObject = localStringWriter.toString();
          AppMethodBeat.o(187857);
          return localObject;
        }
        localList1 = fFi();
        localList2 = fFj();
        if ((com.tencent.thumbplayer.utils.b.isEmpty(localList1)) && (com.tencent.thumbplayer.utils.b.isEmpty(localList2)))
        {
          AppMethodBeat.o(187857);
          return "";
        }
      }
      catch (Exception localException)
      {
        com.tencent.thumbplayer.utils.f.e("TPMediaComposition", localException);
        AppMethodBeat.o(187857);
        return null;
      }
      long l = ((b)this).fFw();
      f.a(localException, localList1, 2, ((b)this).getAudioDuration());
      f.a(localException, localList2, 3, l);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.d.b
 * JD-Core Version:    0.7.0.1
 */