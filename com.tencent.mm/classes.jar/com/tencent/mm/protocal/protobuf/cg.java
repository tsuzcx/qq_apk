package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class cg
  extends com.tencent.mm.bx.a
{
  public cv FuH;
  public String FuI;
  public b FuJ;
  public boolean FuK;
  public long seq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(194968);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FuH != null)
      {
        paramVarArgs.lC(1, this.FuH.computeSize());
        this.FuH.writeFields(paramVarArgs);
      }
      if (this.FuI != null) {
        paramVarArgs.d(2, this.FuI);
      }
      paramVarArgs.aY(3, this.seq);
      if (this.FuJ != null) {
        paramVarArgs.c(4, this.FuJ);
      }
      paramVarArgs.bt(5, this.FuK);
      AppMethodBeat.o(194968);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FuH == null) {
        break label514;
      }
    }
    label514:
    for (paramInt = f.a.a.a.lB(1, this.FuH.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FuI != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.FuI);
      }
      i += f.a.a.b.b.a.p(3, this.seq);
      paramInt = i;
      if (this.FuJ != null) {
        paramInt = i + f.a.a.b.b.a.b(4, this.FuJ);
      }
      i = f.a.a.b.b.a.alV(5);
      AppMethodBeat.o(194968);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(194968);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cg localcg = (cg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(194968);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((cv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcg.FuH = ((cv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(194968);
          return 0;
        case 2: 
          localcg.FuI = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(194968);
          return 0;
        case 3: 
          localcg.seq = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(194968);
          return 0;
        case 4: 
          localcg.FuJ = ((f.a.a.a.a)localObject1).NPN.gxI();
          AppMethodBeat.o(194968);
          return 0;
        }
        localcg.FuK = ((f.a.a.a.a)localObject1).NPN.grw();
        AppMethodBeat.o(194968);
        return 0;
      }
      AppMethodBeat.o(194968);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cg
 * JD-Core Version:    0.7.0.1
 */