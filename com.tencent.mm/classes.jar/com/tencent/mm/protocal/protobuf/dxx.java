package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dxx
  extends com.tencent.mm.bw.a
{
  public dxw IcQ;
  public int status;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(190874);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.IcQ != null)
      {
        paramVarArgs.lJ(1, this.IcQ.computeSize());
        this.IcQ.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.status);
      AppMethodBeat.o(190874);
      return 0;
    }
    if (paramInt == 1) {
      if (this.IcQ == null) {
        break label354;
      }
    }
    label354:
    for (paramInt = f.a.a.a.lI(1, this.IcQ.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.status);
      AppMethodBeat.o(190874);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(190874);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dxx localdxx = (dxx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(190874);
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
            localdxx.IcQ = ((dxw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(190874);
          return 0;
        }
        localdxx.status = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(190874);
        return 0;
      }
      AppMethodBeat.o(190874);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dxx
 * JD-Core Version:    0.7.0.1
 */