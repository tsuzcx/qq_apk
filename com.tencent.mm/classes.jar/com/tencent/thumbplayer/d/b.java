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
  private int Mae;
  private int Maf;
  private int Mag;
  private List<com.tencent.thumbplayer.b.a.d> Mah;
  private List<com.tencent.thumbplayer.b.a.d> Mai;
  public List<com.tencent.thumbplayer.b.a.d> Maj;
  
  public b()
  {
    AppMethodBeat.i(191877);
    this.Mae = 0;
    this.Maf = 0;
    this.Mag = 0;
    this.Mah = new ArrayList(1);
    this.Mai = new ArrayList(1);
    this.Maj = new ArrayList(1);
    AppMethodBeat.o(191877);
  }
  
  private long fWL()
  {
    AppMethodBeat.i(191879);
    long l2;
    if (this.Mah != null)
    {
      Iterator localIterator = this.Mah.iterator();
      long l1 = 0L;
      l2 = l1;
      if (!localIterator.hasNext()) {
        break label74;
      }
      com.tencent.thumbplayer.b.a.d locald = (com.tencent.thumbplayer.b.a.d)localIterator.next();
      if (l1 >= locald.fWF()) {
        break label81;
      }
      l1 = locald.fWF();
    }
    label74:
    label81:
    for (;;)
    {
      break;
      l2 = 0L;
      AppMethodBeat.o(191879);
      return l2;
    }
  }
  
  private long getAudioDuration()
  {
    AppMethodBeat.i(191880);
    long l2;
    if (this.Mai != null)
    {
      Iterator localIterator = this.Mai.iterator();
      long l1 = 0L;
      l2 = l1;
      if (!localIterator.hasNext()) {
        break label74;
      }
      com.tencent.thumbplayer.b.a.d locald = (com.tencent.thumbplayer.b.a.d)localIterator.next();
      if (l1 >= locald.fWF()) {
        break label81;
      }
      l1 = locald.fWF();
    }
    label74:
    label81:
    for (;;)
    {
      break;
      l2 = 0L;
      AppMethodBeat.o(191880);
      return l2;
    }
  }
  
  public final List<com.tencent.thumbplayer.b.a.d> fWA()
  {
    return this.Mai;
  }
  
  public final List<com.tencent.thumbplayer.b.a.d> fWB()
  {
    return this.Maj;
  }
  
  public final List<com.tencent.thumbplayer.b.a.d> fWz()
  {
    return this.Mah;
  }
  
  public final int getMediaType()
  {
    return 4;
  }
  
  public final String getUrl()
  {
    AppMethodBeat.i(191878);
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
        localList1 = fWB();
        if (!a.isEmpty(localList1))
        {
          f.a((XmlSerializer)localObject, localList1, 1, 0L);
          ((XmlSerializer)localObject).endTag("", "assets");
          ((XmlSerializer)localObject).endDocument();
          localObject = localStringWriter.toString();
          AppMethodBeat.o(191878);
          return localObject;
        }
        localList1 = fWz();
        localList2 = fWA();
        if ((a.isEmpty(localList1)) && (a.isEmpty(localList2)))
        {
          AppMethodBeat.o(191878);
          return "";
        }
      }
      catch (Exception localException)
      {
        com.tencent.thumbplayer.utils.d.e("TPMediaComposition", localException);
        AppMethodBeat.o(191878);
        return null;
      }
      long l = ((b)this).fWL();
      f.a(localException, localList1, 2, ((b)this).getAudioDuration());
      f.a(localException, localList2, 3, l);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.d.b
 * JD-Core Version:    0.7.0.1
 */