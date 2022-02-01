package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bsf
  extends com.tencent.mm.bx.a
{
  public boolean DDL;
  public dcm DnE;
  public long timestamp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122518);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DnE != null)
      {
        paramVarArgs.kX(1, this.DnE.computeSize());
        this.DnE.writeFields(paramVarArgs);
      }
      paramVarArgs.bg(2, this.DDL);
      paramVarArgs.aG(3, this.timestamp);
      AppMethodBeat.o(122518);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DnE == null) {
        break label398;
      }
    }
    label398:
    for (paramInt = f.a.a.a.kW(1, this.DnE.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.fY(2);
      int j = f.a.a.b.b.a.q(3, this.timestamp);
      AppMethodBeat.o(122518);
      return paramInt + (i + 1) + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(122518);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bsf localbsf = (bsf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122518);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dcm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((dcm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbsf.DnE = ((dcm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122518);
          return 0;
        case 2: 
          localbsf.DDL = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(122518);
          return 0;
        }
        localbsf.timestamp = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(122518);
        return 0;
      }
      AppMethodBeat.o(122518);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bsf
 * JD-Core Version:    0.7.0.1
 */