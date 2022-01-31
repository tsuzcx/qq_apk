package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class zf
  extends blm
{
  public String mQq;
  public String sBm;
  public String sRr;
  public String sYA;
  public String sYB;
  public String sYz;
  
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
      if (this.sYz != null) {
        paramVarArgs.d(2, this.sYz);
      }
      if (this.sBm != null) {
        paramVarArgs.d(3, this.sBm);
      }
      if (this.mQq != null) {
        paramVarArgs.d(4, this.mQq);
      }
      if (this.sYA != null) {
        paramVarArgs.d(5, this.sYA);
      }
      if (this.sYB != null) {
        paramVarArgs.d(6, this.sYB);
      }
      if (this.sRr != null) {
        paramVarArgs.d(7, this.sRr);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label607;
      }
    }
    label607:
    for (int i = d.a.a.a.gA(1, this.tEX.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.sYz != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.sYz);
      }
      i = paramInt;
      if (this.sBm != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.sBm);
      }
      paramInt = i;
      if (this.mQq != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.mQq);
      }
      i = paramInt;
      if (this.sYA != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.sYA);
      }
      paramInt = i;
      if (this.sYB != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.sYB);
      }
      i = paramInt;
      if (this.sRr != null) {
        i = paramInt + d.a.a.b.b.a.e(7, this.sRr);
      }
      return i;
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
        zf localzf = (zf)paramVarArgs[1];
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
            localzf.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localzf.sYz = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localzf.sBm = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localzf.mQq = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localzf.sYA = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localzf.sYB = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localzf.sRr = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.zf
 * JD-Core Version:    0.7.0.1
 */