package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class dxq
  extends com.tencent.mm.bw.a
{
  public b GsQ;
  public dxw IcQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(190866);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.IcQ != null)
      {
        paramVarArgs.lJ(1, this.IcQ.computeSize());
        this.IcQ.writeFields(paramVarArgs);
      }
      if (this.GsQ != null) {
        paramVarArgs.c(2, this.GsQ);
      }
      AppMethodBeat.o(190866);
      return 0;
    }
    if (paramInt == 1) {
      if (this.IcQ == null) {
        break label370;
      }
    }
    label370:
    for (paramInt = f.a.a.a.lI(1, this.IcQ.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.GsQ != null) {
        i = paramInt + f.a.a.b.b.a.b(2, this.GsQ);
      }
      AppMethodBeat.o(190866);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(190866);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dxq localdxq = (dxq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(190866);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dxw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((dxw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdxq.IcQ = ((dxw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(190866);
          return 0;
        }
        localdxq.GsQ = ((f.a.a.a.a)localObject1).OmT.gCk();
        AppMethodBeat.o(190866);
        return 0;
      }
      AppMethodBeat.o(190866);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dxq
 * JD-Core Version:    0.7.0.1
 */