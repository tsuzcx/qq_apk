package com.tencent.mm.plugin.sns.a.b;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.a.b.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;

public final class h
{
  public String TAG;
  public long fQx;
  public long fQy;
  public int qZB;
  public int qZC;
  public long qZD;
  public int qZE;
  public int qZF;
  public int qZG;
  public int qZH;
  public boolean qZI;
  public a qZJ;
  public LinkedList<a> qZK;
  public long qZL;
  
  public h()
  {
    AppMethodBeat.i(35744);
    this.TAG = "MicroMsg.SnsAdVideoStatistic";
    this.qZB = 0;
    this.qZC = 0;
    this.qZD = 0L;
    this.qZE = 0;
    this.fQy = 0L;
    this.qZF = 0;
    this.qZG = 0;
    this.qZH = 0;
    this.qZI = false;
    this.qZJ = new a();
    this.qZK = new LinkedList();
    this.qZL = 0L;
    this.fQx = 0L;
    AppMethodBeat.o(35744);
  }
  
  public h(String paramString)
  {
    AppMethodBeat.i(35745);
    this.TAG = "MicroMsg.SnsAdVideoStatistic";
    this.qZB = 0;
    this.qZC = 0;
    this.qZD = 0L;
    this.qZE = 0;
    this.fQy = 0L;
    this.qZF = 0;
    this.qZG = 0;
    this.qZH = 0;
    this.qZI = false;
    this.qZJ = new a();
    this.qZK = new LinkedList();
    this.qZL = 0L;
    this.fQx = 0L;
    this.TAG = "MicroMsg.SnsAdVideoStatistic:".concat(String.valueOf(paramString));
    AppMethodBeat.o(35745);
  }
  
  public final void Dx(int paramInt)
  {
    AppMethodBeat.i(35746);
    a locala;
    if (this.qZJ.raJ <= 0)
    {
      locala = this.qZJ;
      if (this.qZJ.raN != 0L) {
        break label130;
      }
    }
    label130:
    for (int i = 0;; i = (int)bo.av(this.qZJ.raN))
    {
      locala.raJ = i;
      if (paramInt != 0)
      {
        this.qZJ.raK = paramInt;
        this.qZL = paramInt;
      }
      ab.i(this.TAG, "pushplayitem duration " + this.qZJ.raJ + " " + this.qZJ.raM);
      this.qZK.add(this.qZJ);
      this.qZJ = new a();
      AppMethodBeat.o(35746);
      return;
    }
  }
  
  public final String cnF()
  {
    AppMethodBeat.i(35747);
    if (this.qZD == 0L) {}
    StringBuffer localStringBuffer;
    a locala;
    for (int i = 0;; i = (int)bo.av(this.qZD))
    {
      this.qZC = i;
      ab.d(this.TAG, "__staytotaltime " + this.qZD + " " + this.qZC + " clock: " + SystemClock.elapsedRealtime());
      localStringBuffer = new StringBuffer();
      localStringBuffer.append("<viewinfo>");
      localStringBuffer.append("<downloadstatus>");
      localStringBuffer.append(this.qZB);
      localStringBuffer.append("</downloadstatus>");
      localStringBuffer.append("<staytotaltime>");
      localStringBuffer.append(this.qZC);
      localStringBuffer.append("</staytotaltime>");
      if (this.qZE > 0)
      {
        localStringBuffer.append("<masktotaltime>");
        localStringBuffer.append(this.qZE);
        localStringBuffer.append("</masktotaltime>");
      }
      localObject = this.qZK;
      if ((!this.qZI) || (this.qZK.size() <= 1)) {
        break label573;
      }
      locala = new a();
      i = 0;
      while (i < this.qZK.size())
      {
        localObject = (a)this.qZK.get(i);
        if (i == 0)
        {
          locala.raK = ((a)localObject).raK;
          locala.raL = ((a)localObject).raL;
          locala.raM = ((a)localObject).raM;
        }
        locala.raI += ((a)localObject).raI;
        int j = locala.raJ;
        locala.raJ = (((a)localObject).raJ + j);
        i += 1;
      }
    }
    Object localObject = new LinkedList();
    ((LinkedList)localObject).add(locala);
    label573:
    for (;;)
    {
      localStringBuffer.append(String.format("<playitemlist count=\"%d\">", new Object[] { Integer.valueOf(((LinkedList)localObject).size()) }));
      i = 0;
      while (i < ((LinkedList)localObject).size())
      {
        locala = (a)((LinkedList)localObject).get(i);
        localStringBuffer.append("<playitem>");
        localStringBuffer.append(String.format("<playcount>%d</playcount>", new Object[] { Integer.valueOf(locala.raI) }));
        localStringBuffer.append(String.format("<playtotaltime>%d</playtotaltime>", new Object[] { Integer.valueOf(locala.raJ) }));
        localStringBuffer.append(String.format("<videototaltime>%d</videototaltime>", new Object[] { Integer.valueOf(locala.raK * 1000) }));
        localStringBuffer.append(String.format("<playmode>%d</playmode>", new Object[] { Integer.valueOf(locala.raL) }));
        localStringBuffer.append(String.format("<playorientation>%d</playorientation>", new Object[] { Integer.valueOf(locala.raM) }));
        localStringBuffer.append("</playitem>");
        i += 1;
      }
      localStringBuffer.append("</playitemlist>");
      localStringBuffer.append("</viewinfo>");
      localObject = localStringBuffer.toString();
      ab.i(this.TAG, "xml ".concat(String.valueOf(localObject)));
      AppMethodBeat.o(35747);
      return localObject;
    }
  }
  
  public final void cnG()
  {
    AppMethodBeat.i(35748);
    this.qZF = 0;
    this.qZG = 0;
    this.qZH = 0;
    Iterator localIterator = this.qZK.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      this.qZF += locala.raH;
      this.qZG += locala.raI;
      int i = this.qZH;
      this.qZH = (locala.raJ + i);
    }
    if ((this.qZJ != null) && (!this.qZK.contains(this.qZJ)))
    {
      this.qZF += this.qZJ.raH;
      this.qZG += this.qZJ.raI;
      this.qZH += this.qZJ.raJ;
    }
    AppMethodBeat.o(35748);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(35749);
    if (this.fQx == 0L)
    {
      AppMethodBeat.o(35749);
      return;
    }
    long l = bo.av(this.fQx);
    this.fQy += l;
    this.fQx = 0L;
    if (this.qZJ != null)
    {
      a locala = this.qZJ;
      locala.raO = (l + locala.raO);
    }
    AppMethodBeat.o(35749);
  }
  
  public final void setDuration(int paramInt)
  {
    this.qZL = paramInt;
    this.qZJ.raK = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.a.b.h
 * JD-Core Version:    0.7.0.1
 */