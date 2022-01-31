package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class bos
  extends blm
{
  public String ffk;
  public String jnU;
  public int sGS;
  public int sRM;
  public int sxP;
  public dn tGZ;
  public String tHa;
  public String tHb;
  public int tHc;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tGZ == null) {
        throw new b("Not all required fields were included: Msg");
      }
      if (this.tEX != null)
      {
        paramVarArgs.gD(1, this.tEX.btq());
        this.tEX.a(paramVarArgs);
      }
      if (this.tGZ != null)
      {
        paramVarArgs.gD(2, this.tGZ.btq());
        this.tGZ.a(paramVarArgs);
      }
      if (this.tHa != null) {
        paramVarArgs.d(3, this.tHa);
      }
      paramVarArgs.gB(4, this.sRM);
      if (this.jnU != null) {
        paramVarArgs.d(5, this.jnU);
      }
      paramVarArgs.gB(6, this.sxP);
      if (this.ffk != null) {
        paramVarArgs.d(7, this.ffk);
      }
      if (this.tHb != null) {
        paramVarArgs.d(8, this.tHb);
      }
      paramVarArgs.gB(9, this.tHc);
      paramVarArgs.gB(10, this.sGS);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label834;
      }
    }
    label834:
    for (int i = d.a.a.a.gA(1, this.tEX.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.tGZ != null) {
        paramInt = i + d.a.a.a.gA(2, this.tGZ.btq());
      }
      i = paramInt;
      if (this.tHa != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.tHa);
      }
      i += d.a.a.a.gy(4, this.sRM);
      paramInt = i;
      if (this.jnU != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.jnU);
      }
      i = paramInt + d.a.a.a.gy(6, this.sxP);
      paramInt = i;
      if (this.ffk != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.ffk);
      }
      i = paramInt;
      if (this.tHb != null) {
        i = paramInt + d.a.a.b.b.a.e(8, this.tHb);
      }
      return i + d.a.a.a.gy(9, this.tHc) + d.a.a.a.gy(10, this.sGS);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = blm.a(paramVarArgs); paramInt > 0; paramInt = blm.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.tGZ != null) {
          break;
        }
        throw new b("Not all required fields were included: Msg");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        bos localbos = (bos)paramVarArgs[1];
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
            localbos.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dn();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dn)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localbos.tGZ = ((dn)localObject1);
            paramInt += 1;
          }
        case 3: 
          localbos.tHa = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localbos.sRM = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          localbos.jnU = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localbos.sxP = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 7: 
          localbos.ffk = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 8: 
          localbos.tHb = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 9: 
          localbos.tHc = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localbos.sGS = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bos
 * JD-Core Version:    0.7.0.1
 */