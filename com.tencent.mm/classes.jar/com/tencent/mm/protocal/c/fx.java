package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class fx
  extends com.tencent.mm.bv.a
{
  public String lnT;
  public String mOb;
  public String nve;
  public int nvf;
  public int nvg;
  public String nvh;
  public String nvi;
  public String nvj;
  public LinkedList<vv> szX = new LinkedList();
  public String szY;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.mOb != null) {
        paramVarArgs.d(1, this.mOb);
      }
      if (this.lnT != null) {
        paramVarArgs.d(2, this.lnT);
      }
      if (this.nve != null) {
        paramVarArgs.d(3, this.nve);
      }
      paramVarArgs.gB(4, this.nvf);
      paramVarArgs.gB(5, this.nvg);
      paramVarArgs.d(6, 8, this.szX);
      if (this.nvh != null) {
        paramVarArgs.d(7, this.nvh);
      }
      if (this.nvi != null) {
        paramVarArgs.d(8, this.nvi);
      }
      if (this.nvj != null) {
        paramVarArgs.d(9, this.nvj);
      }
      if (this.szY != null) {
        paramVarArgs.d(10, this.szY);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.mOb == null) {
        break label728;
      }
    }
    label728:
    for (int i = d.a.a.b.b.a.e(1, this.mOb) + 0;; i = 0)
    {
      paramInt = i;
      if (this.lnT != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.lnT);
      }
      i = paramInt;
      if (this.nve != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.nve);
      }
      i = i + d.a.a.a.gy(4, this.nvf) + d.a.a.a.gy(5, this.nvg) + d.a.a.a.c(6, 8, this.szX);
      paramInt = i;
      if (this.nvh != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.nvh);
      }
      i = paramInt;
      if (this.nvi != null) {
        i = paramInt + d.a.a.b.b.a.e(8, this.nvi);
      }
      paramInt = i;
      if (this.nvj != null) {
        paramInt = i + d.a.a.b.b.a.e(9, this.nvj);
      }
      i = paramInt;
      if (this.szY != null) {
        i = paramInt + d.a.a.b.b.a.e(10, this.szY);
      }
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.szX.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        break;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        fx localfx = (fx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          localfx.mOb = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 2: 
          localfx.lnT = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localfx.nve = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localfx.nvf = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          localfx.nvg = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 6: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new vv();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((vv)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localfx.szX.add(localObject1);
            paramInt += 1;
          }
        case 7: 
          localfx.nvh = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 8: 
          localfx.nvi = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 9: 
          localfx.nvj = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localfx.szY = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.fx
 * JD-Core Version:    0.7.0.1
 */