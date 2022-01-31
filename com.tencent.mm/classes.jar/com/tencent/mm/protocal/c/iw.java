package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class iw
  extends com.tencent.mm.bv.a
{
  public String sCO;
  public int sCY;
  public int sCZ;
  public int sDa;
  public int sDb;
  public long sDc;
  public long sDd;
  public int sDe;
  public boolean sDf;
  public int sDg;
  public boolean sDh;
  public fz sDi;
  public boolean sDj;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sCO == null) {
        throw new b("Not all required fields were included: brand_user_name");
      }
      if (this.sCO != null) {
        paramVarArgs.d(1, this.sCO);
      }
      paramVarArgs.gB(2, this.sCY);
      paramVarArgs.gB(3, this.sCZ);
      paramVarArgs.gB(4, this.sDa);
      paramVarArgs.gB(5, this.sDb);
      paramVarArgs.Y(6, this.sDc);
      paramVarArgs.Y(7, this.sDd);
      paramVarArgs.gB(8, this.sDe);
      paramVarArgs.aA(9, this.sDf);
      paramVarArgs.gB(10, this.sDg);
      paramVarArgs.aA(11, this.sDh);
      if (this.sDi != null)
      {
        paramVarArgs.gD(12, this.sDi.btq());
        this.sDi.a(paramVarArgs);
      }
      paramVarArgs.aA(13, this.sDj);
      return 0;
    }
    if (paramInt == 1) {
      if (this.sCO == null) {
        break label772;
      }
    }
    label772:
    for (paramInt = d.a.a.b.b.a.e(1, this.sCO) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.sCY) + d.a.a.a.gy(3, this.sCZ) + d.a.a.a.gy(4, this.sDa) + d.a.a.a.gy(5, this.sDb) + d.a.a.a.X(6, this.sDc) + d.a.a.a.X(7, this.sDd) + d.a.a.a.gy(8, this.sDe) + (d.a.a.b.b.a.dQ(9) + 1) + d.a.a.a.gy(10, this.sDg) + (d.a.a.b.b.a.dQ(11) + 1);
      paramInt = i;
      if (this.sDi != null) {
        paramInt = i + d.a.a.a.gA(12, this.sDi.btq());
      }
      return paramInt + (d.a.a.b.b.a.dQ(13) + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.sCO != null) {
          break;
        }
        throw new b("Not all required fields were included: brand_user_name");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        iw localiw = (iw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          localiw.sCO = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 2: 
          localiw.sCY = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localiw.sCZ = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          localiw.sDa = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          localiw.sDb = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 6: 
          localiw.sDc = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 7: 
          localiw.sDd = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 8: 
          localiw.sDe = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 9: 
          localiw.sDf = ((d.a.a.a.a)localObject1).cUr();
          return 0;
        case 10: 
          localiw.sDg = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 11: 
          localiw.sDh = ((d.a.a.a.a)localObject1).cUr();
          return 0;
        case 12: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new fz();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((fz)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localiw.sDi = ((fz)localObject1);
            paramInt += 1;
          }
        }
        localiw.sDj = ((d.a.a.a.a)localObject1).cUr();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.iw
 * JD-Core Version:    0.7.0.1
 */