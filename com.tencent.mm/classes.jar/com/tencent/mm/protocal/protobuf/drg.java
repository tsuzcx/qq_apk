package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class drg
  extends com.tencent.mm.bx.a
{
  public boolean aaFe;
  public fns aajj;
  public long timestamp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122518);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aajj != null)
      {
        paramVarArgs.qD(1, this.aajj.computeSize());
        this.aajj.writeFields(paramVarArgs);
      }
      paramVarArgs.di(2, this.aaFe);
      paramVarArgs.bv(3, this.timestamp);
      AppMethodBeat.o(122518);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aajj == null) {
        break label372;
      }
    }
    label372:
    for (paramInt = i.a.a.a.qC(1, this.aajj.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.ko(2);
      int j = i.a.a.b.b.a.q(3, this.timestamp);
      AppMethodBeat.o(122518);
      return paramInt + (i + 1) + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(122518);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        drg localdrg = (drg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122518);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            fns localfns = new fns();
            if ((localObject != null) && (localObject.length > 0)) {
              localfns.parseFrom((byte[])localObject);
            }
            localdrg.aajj = localfns;
            paramInt += 1;
          }
          AppMethodBeat.o(122518);
          return 0;
        case 2: 
          localdrg.aaFe = ((i.a.a.a.a)localObject).ajGk.aai();
          AppMethodBeat.o(122518);
          return 0;
        }
        localdrg.timestamp = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(122518);
        return 0;
      }
      AppMethodBeat.o(122518);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.drg
 * JD-Core Version:    0.7.0.1
 */