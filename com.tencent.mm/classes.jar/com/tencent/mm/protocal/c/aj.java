package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class aj
  extends blm
{
  public String bZc;
  public String bZd;
  public int bZe;
  public String imy;
  public String stb;
  public String stc;
  public int std;
  public int ste;
  public bvk stf;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.bZc == null) {
        throw new b("Not all required fields were included: card_id");
      }
      if (this.tEX != null)
      {
        paramVarArgs.gD(1, this.tEX.btq());
        this.tEX.a(paramVarArgs);
      }
      if (this.imy != null) {
        paramVarArgs.d(2, this.imy);
      }
      paramVarArgs.gB(3, this.bZe);
      if (this.bZc != null) {
        paramVarArgs.d(4, this.bZc);
      }
      if (this.bZd != null) {
        paramVarArgs.d(5, this.bZd);
      }
      if (this.stb != null) {
        paramVarArgs.d(6, this.stb);
      }
      if (this.stc != null) {
        paramVarArgs.d(7, this.stc);
      }
      paramVarArgs.gB(8, this.std);
      paramVarArgs.gB(9, this.ste);
      if (this.stf != null)
      {
        paramVarArgs.gD(10, this.stf.btq());
        this.stf.a(paramVarArgs);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label854;
      }
    }
    label854:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.imy != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.imy);
      }
      i += d.a.a.a.gy(3, this.bZe);
      paramInt = i;
      if (this.bZc != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.bZc);
      }
      i = paramInt;
      if (this.bZd != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.bZd);
      }
      paramInt = i;
      if (this.stb != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.stb);
      }
      i = paramInt;
      if (this.stc != null) {
        i = paramInt + d.a.a.b.b.a.e(7, this.stc);
      }
      i = i + d.a.a.a.gy(8, this.std) + d.a.a.a.gy(9, this.ste);
      paramInt = i;
      if (this.stf != null) {
        paramInt = i + d.a.a.a.gA(10, this.stf.btq());
      }
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = blm.a(paramVarArgs); paramInt > 0; paramInt = blm.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.bZc != null) {
          break;
        }
        throw new b("Not all required fields were included: card_id");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        aj localaj = (aj)paramVarArgs[1];
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
            localaj.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localaj.imy = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localaj.bZe = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          localaj.bZc = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localaj.bZd = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localaj.stb = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 7: 
          localaj.stc = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 8: 
          localaj.std = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 9: 
          localaj.ste = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bvk();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bvk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
          localaj.stf = ((bvk)localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.aj
 * JD-Core Version:    0.7.0.1
 */