package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class el
  extends com.tencent.mm.bv.a
{
  public String bGw;
  public String kRZ;
  public String sxY;
  public String sxZ;
  public em sya;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sya == null) {
        throw new b("Not all required fields were included: ArtisIcon");
      }
      if (this.kRZ != null) {
        paramVarArgs.d(1, this.kRZ);
      }
      if (this.bGw != null) {
        paramVarArgs.d(2, this.bGw);
      }
      if (this.sxY != null) {
        paramVarArgs.d(3, this.sxY);
      }
      if (this.sxZ != null) {
        paramVarArgs.d(4, this.sxZ);
      }
      if (this.sya != null)
      {
        paramVarArgs.gD(5, this.sya.btq());
        this.sya.a(paramVarArgs);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.kRZ == null) {
        break label525;
      }
    }
    label525:
    for (int i = d.a.a.b.b.a.e(1, this.kRZ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.bGw != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.bGw);
      }
      i = paramInt;
      if (this.sxY != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.sxY);
      }
      paramInt = i;
      if (this.sxZ != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.sxZ);
      }
      i = paramInt;
      if (this.sya != null) {
        i = paramInt + d.a.a.a.gA(5, this.sya.btq());
      }
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.sya != null) {
          break;
        }
        throw new b("Not all required fields were included: ArtisIcon");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        el localel = (el)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          localel.kRZ = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 2: 
          localel.bGw = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localel.sxY = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localel.sxZ = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new em();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((em)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localel.sya = ((em)localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.el
 * JD-Core Version:    0.7.0.1
 */