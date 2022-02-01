package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class gdb
  extends com.tencent.mm.bx.a
{
  public gbv acaF;
  public int acaS;
  public int acaT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147817);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.acaF == null)
      {
        paramVarArgs = new b("Not all required fields were included: base_request");
        AppMethodBeat.o(147817);
        throw paramVarArgs;
      }
      if (this.acaF != null)
      {
        paramVarArgs.qD(1, this.acaF.computeSize());
        this.acaF.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.acaS);
      paramVarArgs.bS(3, this.acaT);
      AppMethodBeat.o(147817);
      return 0;
    }
    if (paramInt == 1) {
      if (this.acaF == null) {
        break label424;
      }
    }
    label424:
    for (paramInt = i.a.a.a.qC(1, this.acaF.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.acaS);
      int j = i.a.a.b.b.a.cJ(3, this.acaT);
      AppMethodBeat.o(147817);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.acaF == null)
        {
          paramVarArgs = new b("Not all required fields were included: base_request");
          AppMethodBeat.o(147817);
          throw paramVarArgs;
        }
        AppMethodBeat.o(147817);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        gdb localgdb = (gdb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(147817);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            gbv localgbv = new gbv();
            if ((localObject != null) && (localObject.length > 0)) {
              localgbv.parseFrom((byte[])localObject);
            }
            localgdb.acaF = localgbv;
            paramInt += 1;
          }
          AppMethodBeat.o(147817);
          return 0;
        case 2: 
          localgdb.acaS = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(147817);
          return 0;
        }
        localgdb.acaT = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(147817);
        return 0;
      }
      AppMethodBeat.o(147817);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gdb
 * JD-Core Version:    0.7.0.1
 */