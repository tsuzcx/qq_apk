package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class aa
  extends blm
{
  public String SSID;
  public String URL;
  public String ssn;
  public String sso;
  public String ssp;
  public int ssq;
  public LinkedList<cy> ssr = new LinkedList();
  public int sss;
  public String sst;
  public int ssu;
  public String ssv;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tEX != null)
      {
        paramVarArgs.gD(1, this.tEX.btq());
        this.tEX.a(paramVarArgs);
      }
      if (this.URL != null) {
        paramVarArgs.d(2, this.URL);
      }
      if (this.SSID != null) {
        paramVarArgs.d(3, this.SSID);
      }
      if (this.ssn != null) {
        paramVarArgs.d(4, this.ssn);
      }
      if (this.sso != null) {
        paramVarArgs.d(5, this.sso);
      }
      if (this.ssp != null) {
        paramVarArgs.d(6, this.ssp);
      }
      paramVarArgs.gB(7, this.ssq);
      paramVarArgs.d(8, 8, this.ssr);
      paramVarArgs.gB(9, this.sss);
      if (this.sst != null) {
        paramVarArgs.d(10, this.sst);
      }
      paramVarArgs.gB(11, this.ssu);
      if (this.ssv != null) {
        paramVarArgs.d(12, this.ssv);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label916;
      }
    }
    label916:
    for (int i = d.a.a.a.gA(1, this.tEX.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.URL != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.URL);
      }
      i = paramInt;
      if (this.SSID != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.SSID);
      }
      paramInt = i;
      if (this.ssn != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.ssn);
      }
      i = paramInt;
      if (this.sso != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.sso);
      }
      paramInt = i;
      if (this.ssp != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.ssp);
      }
      i = paramInt + d.a.a.a.gy(7, this.ssq) + d.a.a.a.c(8, 8, this.ssr) + d.a.a.a.gy(9, this.sss);
      paramInt = i;
      if (this.sst != null) {
        paramInt = i + d.a.a.b.b.a.e(10, this.sst);
      }
      i = paramInt + d.a.a.a.gy(11, this.ssu);
      paramInt = i;
      if (this.ssv != null) {
        paramInt = i + d.a.a.b.b.a.e(12, this.ssv);
      }
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ssr.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = blm.a(paramVarArgs); paramInt > 0; paramInt = blm.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        break;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        aa localaa = (aa)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new gc();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((gc)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localaa.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localaa.URL = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localaa.SSID = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localaa.ssn = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localaa.sso = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localaa.ssp = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 7: 
          localaa.ssq = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 8: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cy();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cy)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localaa.ssr.add(localObject1);
            paramInt += 1;
          }
        case 9: 
          localaa.sss = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 10: 
          localaa.sst = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 11: 
          localaa.ssu = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localaa.ssv = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.aa
 * JD-Core Version:    0.7.0.1
 */