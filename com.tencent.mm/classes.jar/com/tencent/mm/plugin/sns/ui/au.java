package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ak;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.vi;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class au
  extends d<n>
{
  private boolean ctJ;
  List<n> list;
  private String meP;
  private int rEf;
  private int rEg;
  private boolean rVp;
  private au.b rVq;
  private au.a rVr;
  private Comparator<n> rcR;
  private String userName;
  
  public au(au.b paramb, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(39233);
    this.userName = "";
    this.list = new ArrayList();
    this.ctJ = false;
    this.rEf = 0;
    this.rEg = 0;
    this.meP = "";
    this.rVp = false;
    this.rcR = new au.1(this);
    this.rVq = paramb;
    this.userName = paramString;
    this.ctJ = paramBoolean;
    AppMethodBeat.o(39233);
  }
  
  private int a(int paramInt1, int paramInt2, List<n> paramList)
  {
    int i = 1;
    AppMethodBeat.i(39239);
    Object localObject = this.rVr;
    ((au.a)localObject).rVu = -1;
    ((au.a)localObject).rVE = -1;
    ((au.a)localObject).rVt = -1;
    ((au.a)localObject).rVy = "";
    ((au.a)localObject).rVz = "";
    ((au.a)localObject).rVA = "";
    ((au.a)localObject).rVD = false;
    ((au.a)localObject).rVv = false;
    ((au.a)localObject).rVF = false;
    ((au.a)localObject).rVG = -1;
    ((au.a)localObject).rVw = -1;
    ((au.a)localObject).rVB = -1;
    ((au.a)localObject).rVC = 0;
    ((au.a)localObject).rVx = 0;
    ((au.a)localObject).rVH = 0;
    if ((this.ctJ) && (paramInt1 == 0))
    {
      AppMethodBeat.o(39239);
      return 1;
    }
    TimeLineObject localTimeLineObject;
    if (paramInt1 + 1 < paramInt2)
    {
      localObject = (n)paramList.get(paramInt1 + 1);
      this.rVr.rVu = ((n)localObject).field_head;
      localTimeLineObject = ((n)localObject).csh();
      this.rVr.rVy = localTimeLineObject.xTP;
      this.rVr.rVv = ak.ad(((n)localObject).field_localPrivate, this.ctJ);
      this.rVr.rVw = ((n)localObject).field_type;
      if (localTimeLineObject.xTS != null) {
        this.rVr.rVx = localTimeLineObject.xTS.wOa.size();
      }
    }
    else
    {
      if (paramInt1 + 2 < paramInt2)
      {
        localObject = (n)paramList.get(paramInt1 + 2);
        this.rVr.rVE = ((n)localObject).field_head;
        localTimeLineObject = ((n)localObject).csh();
        this.rVr.rVz = localTimeLineObject.xTP;
        this.rVr.rVF = ak.ad(((n)localObject).field_localPrivate, this.ctJ);
        this.rVr.rVG = ((n)localObject).field_type;
        if (localTimeLineObject.xTS == null) {
          break label475;
        }
        this.rVr.rVH = localTimeLineObject.xTS.wOa.size();
      }
      label343:
      paramList = (n)paramList.get(paramInt1);
      this.rVr.rVt = paramList.field_head;
      localObject = paramList.csh();
      this.rVr.rVA = ((TimeLineObject)localObject).xTP;
      this.rVr.rVB = paramList.field_type;
      this.rVr.rVD = ak.ad(paramList.field_localPrivate, this.ctJ);
      if (((TimeLineObject)localObject).xTS == null) {
        break label486;
      }
      this.rVr.rVC = ((TimeLineObject)localObject).xTS.wOa.size();
      label438:
      paramList = this.rVr;
      if (paramList.rVB != 2) {
        break label497;
      }
      paramInt1 = 1;
    }
    for (;;)
    {
      if (paramInt1 == 0) {
        break label646;
      }
      AppMethodBeat.o(39239);
      return 1;
      this.rVr.rVx = 0;
      break;
      label475:
      this.rVr.rVH = 0;
      break label343;
      label486:
      this.rVr.rVC = 0;
      break label438;
      label497:
      if (paramList.rVu == -1) {
        paramInt1 = 1;
      } else if (paramList.rVB != paramList.rVw) {
        paramInt1 = 1;
      } else if (au.a.EV(paramList.rVB)) {
        paramInt1 = 1;
      } else if (au.a.EV(paramList.rVw)) {
        paramInt1 = 1;
      } else if ((paramList.rVC > 1) || (paramList.rVx > 1)) {
        paramInt1 = 1;
      } else if ((paramList.rVA != null) && (!paramList.rVA.equals(""))) {
        paramInt1 = 1;
      } else if ((paramList.rVy != null) && (!paramList.rVy.equals(""))) {
        paramInt1 = 1;
      } else if (paramList.rVt != paramList.rVu) {
        paramInt1 = 1;
      } else {
        paramInt1 = 0;
      }
    }
    label646:
    paramList = this.rVr;
    if (paramList.rVE == -1) {
      paramInt1 = i;
    }
    while (paramInt1 != 0)
    {
      AppMethodBeat.o(39239);
      return 2;
      paramInt1 = i;
      if (paramList.rVw == paramList.rVG)
      {
        paramInt1 = i;
        if (!au.a.EV(paramList.rVG))
        {
          paramInt1 = i;
          if (paramList.rVH <= 1) {
            if (paramList.rVz != null)
            {
              paramInt1 = i;
              if (!paramList.rVz.equals("")) {}
            }
            else
            {
              paramInt1 = i;
              if (paramList.rVu == paramList.rVE) {
                paramInt1 = 0;
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(39239);
    return 3;
  }
  
  private void c(boolean paramBoolean, List<n> paramList)
  {
    AppMethodBeat.i(39240);
    if (!paramBoolean)
    {
      AppMethodBeat.o(39240);
      return;
    }
    if (this.ctJ)
    {
      n localn = new n((byte)0);
      localn.field_snsId = 0L;
      localn.rCV = -1;
      localn.lp((int)(System.currentTimeMillis() / 1000L));
      paramList.add(0, localn);
    }
    AppMethodBeat.o(39240);
  }
  
  private void d(boolean paramBoolean, List<n> paramList)
  {
    AppMethodBeat.i(39241);
    this.rVr = new au.a(this);
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    HashMap localHashMap3 = new HashMap();
    long l = System.currentTimeMillis();
    int m = 0;
    int k = 0;
    int i = 0;
    c(paramBoolean, paramList);
    int n = paramList.size();
    ab.d("MicroMsg.SnsSelfHelper", "initFixType ".concat(String.valueOf(n)));
    int j = 0;
    while (j < n)
    {
      int i1 = a(j, n, paramList);
      localHashMap1.put(Integer.valueOf(i), Integer.valueOf(m));
      localHashMap2.put(Integer.valueOf(i), Integer.valueOf(i1));
      m += i1;
      localHashMap3.put(Integer.valueOf(i), Integer.valueOf(k));
      k += fM(j, i1);
      j += i1;
      i += 1;
    }
    this.rEf = i;
    this.rEg = paramList.size();
    ab.d("MicroMsg.SnsSelfHelper", "icount " + this.rEf);
    this.list = paramList;
    i.aC("SnsphotoAdapter initFixType ", l);
    this.rVq.a(this.list, localHashMap1, localHashMap2, localHashMap3, this.rEg, this.rEf);
    AppMethodBeat.o(39241);
  }
  
  private int fM(int paramInt1, int paramInt2)
  {
    int i = 0;
    int j = 0;
    if ((this.ctJ) && (paramInt1 == 0)) {
      paramInt1 = j;
    }
    do
    {
      do
      {
        return paramInt1;
        paramInt1 = i;
        if (paramInt2 > 0)
        {
          paramInt1 = i;
          if (this.rVr.rVB == 1) {
            paramInt1 = 1;
          }
        }
        i = paramInt1;
        if (paramInt2 >= 2)
        {
          i = paramInt1;
          if (this.rVr.rVw == 1) {
            i = paramInt1 + 1;
          }
        }
        paramInt1 = i;
      } while (paramInt2 < 3);
      paramInt1 = i;
    } while (this.rVr.rVG != 1);
    return i + 1;
  }
  
  public final List<n> Kq()
  {
    AppMethodBeat.i(39235);
    List localList = ak.a(this.userName, this.ctJ, this.meP, this.rVp);
    ab.i("MicroMsg.SnsSelfHelper", "loadData thread: %d count: %d", new Object[] { Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(localList.size()) });
    AppMethodBeat.o(39235);
    return localList;
  }
  
  public final void cvN()
  {
    AppMethodBeat.i(39236);
    Collections.sort(this.list, this.rcR);
    AppMethodBeat.o(39236);
  }
  
  final void cvO()
  {
    AppMethodBeat.i(39237);
    d(false, this.list);
    AppMethodBeat.o(39237);
  }
  
  public final void dl(List<n> paramList)
  {
    AppMethodBeat.i(39234);
    if (this.rVq != null)
    {
      if (paramList != null) {
        d(true, paramList);
      }
      this.rVq.cvM();
    }
    AppMethodBeat.o(39234);
  }
  
  public final void h(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(39238);
    ab.d("MicroMsg.SnsSelfHelper", "limitSeq ".concat(String.valueOf(paramString)));
    this.meP = paramString;
    this.rVp = paramBoolean1;
    ie(paramBoolean2);
    AppMethodBeat.o(39238);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.au
 * JD-Core Version:    0.7.0.1
 */