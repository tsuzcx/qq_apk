package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class aig
  extends com.tencent.mm.bx.a
{
  public long Njv;
  public etl ZqL;
  public int ZqO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43091);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZqL == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(43091);
        throw paramVarArgs;
      }
      if (this.ZqL != null)
      {
        paramVarArgs.qD(1, this.ZqL.computeSize());
        this.ZqL.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.ZqO);
      paramVarArgs.bv(3, this.Njv);
      AppMethodBeat.o(43091);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZqL == null) {
        break label424;
      }
    }
    label424:
    for (paramInt = i.a.a.a.qC(1, this.ZqL.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.ZqO);
      int j = i.a.a.b.b.a.q(3, this.Njv);
      AppMethodBeat.o(43091);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.ZqL == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserName");
          AppMethodBeat.o(43091);
          throw paramVarArgs;
        }
        AppMethodBeat.o(43091);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        aig localaig = (aig)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(43091);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            etl localetl = new etl();
            if ((localObject != null) && (localObject.length > 0)) {
              localetl.dh((byte[])localObject);
            }
            localaig.ZqL = localetl;
            paramInt += 1;
          }
          AppMethodBeat.o(43091);
          return 0;
        case 2: 
          localaig.ZqO = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(43091);
          return 0;
        }
        localaig.Njv = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(43091);
        return 0;
      }
      AppMethodBeat.o(43091);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aig
 * JD-Core Version:    0.7.0.1
 */