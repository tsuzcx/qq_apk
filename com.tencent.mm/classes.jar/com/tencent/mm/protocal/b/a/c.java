package com.tencent.mm.protocal.b.a;

import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.protocal.c.yd;
import java.util.LinkedList;

public final class c
  extends com.tencent.mm.bv.a
{
  public LinkedList<xv> dTx = new LinkedList();
  public String desc;
  public String srn;
  public yd sro;
  public long srp;
  public String title;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.d(2, this.desc);
      }
      paramVarArgs.d(3, 8, this.dTx);
      if (this.srn != null) {
        paramVarArgs.d(4, this.srn);
      }
      if (this.sro != null)
      {
        paramVarArgs.gD(5, this.sro.btq());
        this.sro.a(paramVarArgs);
      }
      paramVarArgs.Y(6, this.srp);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label610;
      }
    }
    label610:
    for (paramInt = d.a.a.b.b.a.e(1, this.title) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.desc != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.desc);
      }
      i += d.a.a.a.c(3, 8, this.dTx);
      paramInt = i;
      if (this.srn != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.srn);
      }
      i = paramInt;
      if (this.sro != null) {
        i = paramInt + d.a.a.a.gA(5, this.sro.btq());
      }
      return i + d.a.a.a.X(6, this.srp);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.dTx.clear();
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
        c localc = (c)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          localc.title = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 2: 
          localc.desc = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new xv();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((xv)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localc.dTx.add(localObject1);
            paramInt += 1;
          }
        case 4: 
          localc.srn = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new yd();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((yd)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localc.sro = ((yd)localObject1);
            paramInt += 1;
          }
        }
        localc.srp = ((d.a.a.a.a)localObject1).xpH.oE();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.b.a.c
 * JD-Core Version:    0.7.0.1
 */