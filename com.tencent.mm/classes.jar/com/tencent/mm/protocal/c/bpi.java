package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class bpi
  extends com.tencent.mm.bv.a
{
  public String bIW;
  public int dQP;
  public int dQQ;
  public String dQR;
  public int eGn;
  public int eHH;
  public String owY;
  public LinkedList<bxz> tHl = new LinkedList();
  public int tHm;
  public String url;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.owY == null) {
        throw new b("Not all required fields were included: clientID");
      }
      paramVarArgs.d(1, 8, this.tHl);
      if (this.owY != null) {
        paramVarArgs.d(2, this.owY);
      }
      if (this.bIW != null) {
        paramVarArgs.d(3, this.bIW);
      }
      if (this.dQR != null) {
        paramVarArgs.d(4, this.dQR);
      }
      if (this.url != null) {
        paramVarArgs.d(5, this.url);
      }
      paramVarArgs.gB(6, this.eHH);
      paramVarArgs.gB(7, this.eGn);
      paramVarArgs.gB(8, this.tHm);
      paramVarArgs.gB(9, this.dQP);
      paramVarArgs.gB(10, this.dQQ);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = d.a.a.a.c(1, 8, this.tHl) + 0;
      paramInt = i;
      if (this.owY != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.owY);
      }
      i = paramInt;
      if (this.bIW != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.bIW);
      }
      paramInt = i;
      if (this.dQR != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.dQR);
      }
      i = paramInt;
      if (this.url != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.url);
      }
      return i + d.a.a.a.gy(6, this.eHH) + d.a.a.a.gy(7, this.eGn) + d.a.a.a.gy(8, this.tHm) + d.a.a.a.gy(9, this.dQP) + d.a.a.a.gy(10, this.dQQ);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.tHl.clear();
      paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      if (this.owY == null) {
        throw new b("Not all required fields were included: clientID");
      }
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
      bpi localbpi = (bpi)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
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
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bxz();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bxz)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localbpi.tHl.add(localObject1);
          paramInt += 1;
        }
        return 0;
      case 2: 
        localbpi.owY = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 3: 
        localbpi.bIW = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 4: 
        localbpi.dQR = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 5: 
        localbpi.url = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 6: 
        localbpi.eHH = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 7: 
        localbpi.eGn = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 8: 
        localbpi.tHm = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 9: 
        localbpi.dQP = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      localbpi.dQQ = ((d.a.a.a.a)localObject1).xpH.oD();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bpi
 * JD-Core Version:    0.7.0.1
 */