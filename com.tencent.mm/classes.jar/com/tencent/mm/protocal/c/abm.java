package com.tencent.mm.protocal.c;

import com.tencent.mm.bv.b;
import java.util.LinkedList;

public final class abm
  extends blm
{
  public String app_id;
  public String iln;
  public b inP;
  public int ivC;
  public String ivD;
  public String ivE;
  public String ivF;
  public String ivG;
  public int taO;
  public int time_stamp;
  
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
      if (this.app_id != null) {
        paramVarArgs.d(2, this.app_id);
      }
      paramVarArgs.gB(3, this.ivC);
      if (this.ivD != null) {
        paramVarArgs.d(4, this.ivD);
      }
      if (this.ivE != null) {
        paramVarArgs.d(5, this.ivE);
      }
      paramVarArgs.gB(6, this.time_stamp);
      if (this.ivF != null) {
        paramVarArgs.d(7, this.ivF);
      }
      if (this.iln != null) {
        paramVarArgs.d(8, this.iln);
      }
      if (this.ivG != null) {
        paramVarArgs.d(9, this.ivG);
      }
      if (this.inP != null) {
        paramVarArgs.b(10, this.inP);
      }
      paramVarArgs.gB(11, this.taO);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label780;
      }
    }
    label780:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.app_id != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.app_id);
      }
      i += d.a.a.a.gy(3, this.ivC);
      paramInt = i;
      if (this.ivD != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.ivD);
      }
      i = paramInt;
      if (this.ivE != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.ivE);
      }
      i += d.a.a.a.gy(6, this.time_stamp);
      paramInt = i;
      if (this.ivF != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.ivF);
      }
      i = paramInt;
      if (this.iln != null) {
        i = paramInt + d.a.a.b.b.a.e(8, this.iln);
      }
      paramInt = i;
      if (this.ivG != null) {
        paramInt = i + d.a.a.b.b.a.e(9, this.ivG);
      }
      i = paramInt;
      if (this.inP != null) {
        i = paramInt + d.a.a.a.a(10, this.inP);
      }
      return i + d.a.a.a.gy(11, this.taO);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
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
        abm localabm = (abm)paramVarArgs[1];
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
            localObject1 = new gc();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((gc)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localabm.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localabm.app_id = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localabm.ivC = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          localabm.ivD = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localabm.ivE = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localabm.time_stamp = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 7: 
          localabm.ivF = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 8: 
          localabm.iln = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 9: 
          localabm.ivG = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 10: 
          localabm.inP = ((d.a.a.a.a)localObject1).cUs();
          return 0;
        }
        localabm.taO = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.abm
 * JD-Core Version:    0.7.0.1
 */