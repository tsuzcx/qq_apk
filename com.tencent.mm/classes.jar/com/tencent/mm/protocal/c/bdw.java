package com.tencent.mm.protocal.c;

import com.tencent.mm.bv.b;
import java.util.LinkedList;

public final class bdw
  extends blm
{
  public int sHe;
  public aw sHl;
  public int sss;
  public String tzf;
  public String tzg;
  public b tzh;
  public int tzi;
  
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
      if (this.tzf != null) {
        paramVarArgs.d(2, this.tzf);
      }
      if (this.tzg != null) {
        paramVarArgs.d(3, this.tzg);
      }
      if (this.tzh != null) {
        paramVarArgs.b(4, this.tzh);
      }
      paramVarArgs.gB(5, this.sHe);
      paramVarArgs.gB(6, this.sss);
      paramVarArgs.gB(7, this.tzi);
      if (this.sHl != null)
      {
        paramVarArgs.gD(8, this.sHl.btq());
        this.sHl.a(paramVarArgs);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label701;
      }
    }
    label701:
    for (int i = d.a.a.a.gA(1, this.tEX.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.tzf != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.tzf);
      }
      i = paramInt;
      if (this.tzg != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.tzg);
      }
      paramInt = i;
      if (this.tzh != null) {
        paramInt = i + d.a.a.a.a(4, this.tzh);
      }
      i = paramInt + d.a.a.a.gy(5, this.sHe) + d.a.a.a.gy(6, this.sss) + d.a.a.a.gy(7, this.tzi);
      paramInt = i;
      if (this.sHl != null) {
        paramInt = i + d.a.a.a.gA(8, this.sHl.btq());
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
        break;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        bdw localbdw = (bdw)paramVarArgs[1];
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
            localbdw.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localbdw.tzf = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localbdw.tzg = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localbdw.tzh = ((d.a.a.a.a)localObject1).cUs();
          return 0;
        case 5: 
          localbdw.sHe = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 6: 
          localbdw.sss = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 7: 
          localbdw.tzi = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aw();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aw)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
          localbdw.sHl = ((aw)localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bdw
 * JD-Core Version:    0.7.0.1
 */