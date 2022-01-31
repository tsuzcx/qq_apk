package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.protocal.c.rp;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class at
  extends d<n>
{
  private boolean bMo = false;
  private String jKL = "";
  List<n> list = new ArrayList();
  private int oMu = 0;
  private int oMv = 0;
  private Comparator<n> ooA = new at.1(this);
  private boolean pcF = false;
  private at.b pcG;
  private a pcH;
  private String userName = "";
  
  public at(at.b paramb, String paramString, boolean paramBoolean)
  {
    this.pcG = paramb;
    this.userName = paramString;
    this.bMo = paramBoolean;
  }
  
  private void b(boolean paramBoolean, List<n> paramList)
  {
    this.pcH = new a();
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    HashMap localHashMap3 = new HashMap();
    long l = System.currentTimeMillis();
    int j = 0;
    int i1 = 0;
    Object localObject;
    if ((paramBoolean) && (this.bMo))
    {
      localObject = new n((byte)0);
      ((n)localObject).field_snsId = 0L;
      ((n)localObject).oLk = -1;
      ((n)localObject).iB((int)(System.currentTimeMillis() / 1000L));
      paramList.add(0, localObject);
    }
    int i3 = paramList.size();
    y.d("MicroMsg.SnsSelfHelper", "initFixType " + i3);
    int n = 0;
    int m = 0;
    if (n < i3)
    {
      localObject = this.pcH;
      ((a)localObject).pcK = -1;
      ((a)localObject).pcU = -1;
      ((a)localObject).pcJ = -1;
      ((a)localObject).pcO = "";
      ((a)localObject).pcP = "";
      ((a)localObject).pcQ = "";
      ((a)localObject).pcT = false;
      ((a)localObject).pcL = false;
      ((a)localObject).pcV = false;
      ((a)localObject).pcW = -1;
      ((a)localObject).pcM = -1;
      ((a)localObject).pcR = -1;
      ((a)localObject).pcS = 0;
      ((a)localObject).pcN = 0;
      ((a)localObject).pcX = 0;
      int i;
      label261:
      int i2;
      if ((this.bMo) && (n == 0))
      {
        i = 1;
        localHashMap1.put(Integer.valueOf(m), Integer.valueOf(j));
        localHashMap2.put(Integer.valueOf(m), Integer.valueOf(i));
        i2 = j + i;
        localHashMap3.put(Integer.valueOf(m), Integer.valueOf(i1));
        if ((!this.bMo) || (n != 0)) {
          break label1035;
        }
        j = 0;
      }
      for (;;)
      {
        i1 += j;
        n += i;
        m += 1;
        j = i2;
        break;
        bxk localbxk;
        if (n + 1 < i3)
        {
          localObject = (n)paramList.get(n + 1);
          this.pcH.pcK = ((n)localObject).field_head;
          localbxk = ((n)localObject).bGe();
          this.pcH.pcO = localbxk.tNo;
          this.pcH.pcL = aj.U(((n)localObject).field_localPrivate, this.bMo);
          this.pcH.pcM = ((n)localObject).field_type;
          if (localbxk.tNr != null) {
            this.pcH.pcN = localbxk.tNr.sPJ.size();
          }
        }
        else
        {
          label473:
          if (n + 2 < i3)
          {
            localObject = (n)paramList.get(n + 2);
            this.pcH.pcU = ((n)localObject).field_head;
            localbxk = ((n)localObject).bGe();
            this.pcH.pcP = localbxk.tNo;
            this.pcH.pcV = aj.U(((n)localObject).field_localPrivate, this.bMo);
            this.pcH.pcW = ((n)localObject).field_type;
            if (localbxk.tNr == null) {
              break label723;
            }
            this.pcH.pcX = localbxk.tNr.sPJ.size();
          }
          label585:
          localObject = (n)paramList.get(n);
          this.pcH.pcJ = ((n)localObject).field_head;
          localbxk = ((n)localObject).bGe();
          this.pcH.pcQ = localbxk.tNo;
          this.pcH.pcR = ((n)localObject).field_type;
          this.pcH.pcT = aj.U(((n)localObject).field_localPrivate, this.bMo);
          if (localbxk.tNr == null) {
            break label734;
          }
          this.pcH.pcS = localbxk.tNr.sPJ.size();
          label686:
          localObject = this.pcH;
          if (((a)localObject).pcR != 2) {
            break label745;
          }
          i = 1;
        }
        for (;;)
        {
          if (i == 0) {
            break label907;
          }
          i = 1;
          break;
          this.pcH.pcN = 0;
          break label473;
          label723:
          this.pcH.pcX = 0;
          break label585;
          label734:
          this.pcH.pcS = 0;
          break label686;
          label745:
          if (((a)localObject).pcK == -1) {
            i = 1;
          } else if (((a)localObject).pcR != ((a)localObject).pcM) {
            i = 1;
          } else if (a.yN(((a)localObject).pcR)) {
            i = 1;
          } else if (a.yN(((a)localObject).pcM)) {
            i = 1;
          } else if ((((a)localObject).pcS > 1) || (((a)localObject).pcN > 1)) {
            i = 1;
          } else if ((((a)localObject).pcQ != null) && (!((a)localObject).pcQ.equals(""))) {
            i = 1;
          } else if ((((a)localObject).pcO != null) && (!((a)localObject).pcO.equals(""))) {
            i = 1;
          } else if (((a)localObject).pcJ != ((a)localObject).pcK) {
            i = 1;
          } else {
            i = 0;
          }
        }
        label907:
        localObject = this.pcH;
        if (((a)localObject).pcU == -1) {
          i = 1;
        }
        for (;;)
        {
          if (i == 0) {
            break label1030;
          }
          i = 2;
          break;
          if (((a)localObject).pcM != ((a)localObject).pcW) {
            i = 1;
          } else if (a.yN(((a)localObject).pcW)) {
            i = 1;
          } else if (((a)localObject).pcX > 1) {
            i = 1;
          } else if ((((a)localObject).pcP != null) && (!((a)localObject).pcP.equals(""))) {
            i = 1;
          } else if (((a)localObject).pcK != ((a)localObject).pcU) {
            i = 1;
          } else {
            i = 0;
          }
        }
        label1030:
        i = 3;
        break label261;
        label1035:
        int k = 0;
        j = k;
        if (i > 0)
        {
          j = k;
          if (this.pcH.pcR == 1) {
            j = 1;
          }
        }
        k = j;
        if (i >= 2)
        {
          k = j;
          if (this.pcH.pcM == 1) {
            k = j + 1;
          }
        }
        j = k;
        if (i >= 3)
        {
          j = k;
          if (this.pcH.pcW == 1) {
            j = k + 1;
          }
        }
      }
    }
    this.oMu = m;
    this.oMv = paramList.size();
    y.d("MicroMsg.SnsSelfHelper", "icount " + this.oMu);
    this.list = paramList;
    i.ai("SnsphotoAdapter initFixType ", l);
    this.pcG.a(this.list, localHashMap1, localHashMap2, localHashMap3, this.oMv, this.oMu);
  }
  
  public final void bJl()
  {
    Collections.sort(this.list, this.ooA);
  }
  
  final void bJm()
  {
    b(false, this.list);
  }
  
  public final void cF(List<n> paramList)
  {
    if (this.pcG != null)
    {
      if (paramList != null) {
        b(true, paramList);
      }
      this.pcG.bJk();
    }
  }
  
  public final void e(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    y.d("MicroMsg.SnsSelfHelper", "limitSeq " + paramString);
    this.jKL = paramString;
    this.pcF = paramBoolean1;
    gw(paramBoolean2);
  }
  
  public final List<n> xY()
  {
    List localList = aj.a(this.userName, this.bMo, this.jKL, this.pcF);
    y.i("MicroMsg.SnsSelfHelper", "loadData thread: %d count: %d", new Object[] { Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(localList.size()) });
    return localList;
  }
  
  final class a
  {
    public int pcJ = -1;
    public int pcK = -1;
    public boolean pcL = false;
    public int pcM = -1;
    int pcN = 0;
    public String pcO = "";
    public String pcP = "";
    public String pcQ = "";
    public int pcR = -1;
    int pcS = 0;
    public boolean pcT = false;
    public int pcU = -1;
    public boolean pcV = false;
    public int pcW = -1;
    int pcX = 0;
    
    a() {}
    
    public static boolean yN(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return false;
      }
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.at
 * JD-Core Version:    0.7.0.1
 */