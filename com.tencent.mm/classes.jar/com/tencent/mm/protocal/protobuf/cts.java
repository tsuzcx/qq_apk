package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cts
  extends cvw
{
  public int HEI;
  public dyb HEJ;
  public int HEK;
  public int nJz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32412);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HEJ == null)
      {
        paramVarArgs = new b("Not all required fields were included: PieceData");
        AppMethodBeat.o(32412);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.nJz);
      paramVarArgs.aS(3, this.HEI);
      if (this.HEJ != null)
      {
        paramVarArgs.lJ(4, this.HEJ.computeSize());
        this.HEJ.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(5, this.HEK);
      AppMethodBeat.o(32412);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label657;
      }
    }
    label657:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.nJz) + f.a.a.b.b.a.bz(3, this.HEI);
      paramInt = i;
      if (this.HEJ != null) {
        paramInt = i + f.a.a.a.lI(4, this.HEJ.computeSize());
      }
      i = f.a.a.b.b.a.bz(5, this.HEK);
      AppMethodBeat.o(32412);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.HEJ == null)
        {
          paramVarArgs = new b("Not all required fields were included: PieceData");
          AppMethodBeat.o(32412);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32412);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cts localcts = (cts)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32412);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcts.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32412);
          return 0;
        case 2: 
          localcts.nJz = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32412);
          return 0;
        case 3: 
          localcts.HEI = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32412);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dyb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dyb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcts.HEJ = ((dyb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32412);
          return 0;
        }
        localcts.HEK = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(32412);
        return 0;
      }
      AppMethodBeat.o(32412);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cts
 * JD-Core Version:    0.7.0.1
 */