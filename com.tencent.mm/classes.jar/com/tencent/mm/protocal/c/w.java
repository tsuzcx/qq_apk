package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class w
  extends blm
{
  public int limit;
  public int offset;
  public String sse;
  public int ssf;
  public int ssg;
  public String ssh;
  public int type;
  
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
      paramVarArgs.gB(2, this.limit);
      paramVarArgs.gB(3, this.offset);
      paramVarArgs.gB(4, this.type);
      if (this.sse != null) {
        paramVarArgs.d(5, this.sse);
      }
      paramVarArgs.gB(6, this.ssf);
      paramVarArgs.gB(7, this.ssg);
      if (this.ssh != null) {
        paramVarArgs.d(8, this.ssh);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label578;
      }
    }
    label578:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.limit) + d.a.a.a.gy(3, this.offset) + d.a.a.a.gy(4, this.type);
      paramInt = i;
      if (this.sse != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.sse);
      }
      i = paramInt + d.a.a.a.gy(6, this.ssf) + d.a.a.a.gy(7, this.ssg);
      paramInt = i;
      if (this.ssh != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.ssh);
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
        w localw = (w)paramVarArgs[1];
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
            localw.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localw.limit = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localw.offset = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          localw.type = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          localw.sse = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localw.ssf = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 7: 
          localw.ssg = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localw.ssh = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.w
 * JD-Core Version:    0.7.0.1
 */