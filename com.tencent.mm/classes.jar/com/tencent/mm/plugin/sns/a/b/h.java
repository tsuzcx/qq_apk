package com.tencent.mm.plugin.sns.a.b;

import android.os.SystemClock;
import com.tencent.mm.plugin.sns.a.b.a.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;

public final class h
{
  public String TAG = "MicroMsg.SnsAdVideoStatistic";
  public long eAF = 0L;
  public long eAG = 0L;
  public int olp = 0;
  public int olq = 0;
  public long olr = 0L;
  public int ols = 0;
  public int olt = 0;
  public int olu = 0;
  public int olv = 0;
  public boolean olw = false;
  public a olx = new a();
  public LinkedList<a> oly = new LinkedList();
  public long olz = 0L;
  
  public h() {}
  
  public h(String paramString)
  {
    this.TAG = ("MicroMsg.SnsAdVideoStatistic:" + paramString);
  }
  
  public final String bCf()
  {
    if (this.olr == 0L) {}
    StringBuffer localStringBuffer;
    a locala;
    for (int i = 0;; i = (int)bk.cp(this.olr))
    {
      this.olq = i;
      y.d(this.TAG, "__staytotaltime " + this.olr + " " + this.olq + " clock: " + SystemClock.elapsedRealtime());
      localStringBuffer = new StringBuffer();
      localStringBuffer.append("<viewinfo>");
      localStringBuffer.append("<downloadstatus>");
      localStringBuffer.append(this.olp);
      localStringBuffer.append("</downloadstatus>");
      localStringBuffer.append("<staytotaltime>");
      localStringBuffer.append(this.olq);
      localStringBuffer.append("</staytotaltime>");
      if (this.ols > 0)
      {
        localStringBuffer.append("<masktotaltime>");
        localStringBuffer.append(this.ols);
        localStringBuffer.append("</masktotaltime>");
      }
      localObject = this.oly;
      if ((!this.olw) || (this.oly.size() <= 1)) {
        break label570;
      }
      locala = new a();
      i = 0;
      while (i < this.oly.size())
      {
        localObject = (a)this.oly.get(i);
        if (i == 0)
        {
          locala.omw = ((a)localObject).omw;
          locala.omx = ((a)localObject).omx;
          locala.omy = ((a)localObject).omy;
        }
        locala.omu += ((a)localObject).omu;
        int j = locala.omv;
        locala.omv = (((a)localObject).omv + j);
        i += 1;
      }
    }
    Object localObject = new LinkedList();
    ((LinkedList)localObject).add(locala);
    label570:
    for (;;)
    {
      localStringBuffer.append(String.format("<playitemlist count=\"%d\">", new Object[] { Integer.valueOf(((LinkedList)localObject).size()) }));
      i = 0;
      while (i < ((LinkedList)localObject).size())
      {
        locala = (a)((LinkedList)localObject).get(i);
        localStringBuffer.append("<playitem>");
        localStringBuffer.append(String.format("<playcount>%d</playcount>", new Object[] { Integer.valueOf(locala.omu) }));
        localStringBuffer.append(String.format("<playtotaltime>%d</playtotaltime>", new Object[] { Integer.valueOf(locala.omv) }));
        localStringBuffer.append(String.format("<videototaltime>%d</videototaltime>", new Object[] { Integer.valueOf(locala.omw * 1000) }));
        localStringBuffer.append(String.format("<playmode>%d</playmode>", new Object[] { Integer.valueOf(locala.omx) }));
        localStringBuffer.append(String.format("<playorientation>%d</playorientation>", new Object[] { Integer.valueOf(locala.omy) }));
        localStringBuffer.append("</playitem>");
        i += 1;
      }
      localStringBuffer.append("</playitemlist>");
      localStringBuffer.append("</viewinfo>");
      localObject = localStringBuffer.toString();
      y.i(this.TAG, "xml " + (String)localObject);
      return localObject;
    }
  }
  
  public final void bCg()
  {
    this.olt = 0;
    this.olu = 0;
    this.olv = 0;
    Iterator localIterator = this.oly.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      this.olt += locala.omt;
      this.olu += locala.omu;
      int i = this.olv;
      this.olv = (locala.omv + i);
    }
    if ((this.olx != null) && (!this.oly.contains(this.olx)))
    {
      this.olt += this.olx.omt;
      this.olu += this.olx.omu;
      this.olv += this.olx.omv;
    }
  }
  
  public final void onResume()
  {
    if (this.eAF == 0L) {}
    long l;
    do
    {
      return;
      l = bk.cp(this.eAF);
      this.eAG += l;
      this.eAF = 0L;
    } while (this.olx == null);
    a locala = this.olx;
    locala.omA = (l + locala.omA);
  }
  
  public final void xx(int paramInt)
  {
    a locala;
    if (this.olx.omv <= 0)
    {
      locala = this.olx;
      if (this.olx.omz != 0L) {
        break label120;
      }
    }
    label120:
    for (int i = 0;; i = (int)bk.cp(this.olx.omz))
    {
      locala.omv = i;
      if (paramInt != 0)
      {
        this.olx.omw = paramInt;
        this.olz = paramInt;
      }
      y.i(this.TAG, "pushplayitem duration " + this.olx.omv + " " + this.olx.omy);
      this.oly.add(this.olx);
      this.olx = new a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.a.b.h
 * JD-Core Version:    0.7.0.1
 */