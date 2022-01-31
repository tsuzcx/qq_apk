package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.protocal.c.blm;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.gc;
import d.a.a.b;
import java.util.LinkedList;

public final class ag
  extends blm
{
  public String nde;
  public int ndf;
  public int ndg;
  public int ndh;
  public bmk ndi;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.ndi == null) {
        throw new b("Not all required fields were included: Data");
      }
      if (this.tEX != null)
      {
        paramVarArgs.gD(1, this.tEX.btq());
        this.tEX.a(paramVarArgs);
      }
      if (this.nde != null) {
        paramVarArgs.d(2, this.nde);
      }
      paramVarArgs.gB(3, this.ndf);
      paramVarArgs.gB(4, this.ndg);
      paramVarArgs.gB(5, this.ndh);
      if (this.ndi != null)
      {
        paramVarArgs.gD(6, this.ndi.btq());
        this.ndi.a(paramVarArgs);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label622;
      }
    }
    label622:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.nde != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.nde);
      }
      i = i + d.a.a.a.gy(3, this.ndf) + d.a.a.a.gy(4, this.ndg) + d.a.a.a.gy(5, this.ndh);
      paramInt = i;
      if (this.ndi != null) {
        paramInt = i + d.a.a.a.gA(6, this.ndi.btq());
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
        if (this.ndi != null) {
          break;
        }
        throw new b("Not all required fields were included: Data");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        ag localag = (ag)paramVarArgs[1];
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
            localag.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localag.nde = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localag.ndf = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          localag.ndg = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          localag.ndh = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bmk();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
          localag.ndi = ((bmk)localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.ag
 * JD-Core Version:    0.7.0.1
 */