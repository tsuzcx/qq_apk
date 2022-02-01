package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class gda
  extends com.tencent.mm.bx.a
{
  public gbv acaF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147816);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.acaF == null)
      {
        paramVarArgs = new b("Not all required fields were included: base_request");
        AppMethodBeat.o(147816);
        throw paramVarArgs;
      }
      if (this.acaF != null)
      {
        paramVarArgs.qD(1, this.acaF.computeSize());
        this.acaF.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(147816);
      return 0;
    }
    if (paramInt == 1) {
      if (this.acaF == null) {
        break label332;
      }
    }
    label332:
    for (paramInt = i.a.a.a.qC(1, this.acaF.computeSize()) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(147816);
      return paramInt;
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
          AppMethodBeat.o(147816);
          throw paramVarArgs;
        }
        AppMethodBeat.o(147816);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        gda localgda = (gda)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(147816);
          return -1;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        int i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          gbv localgbv = new gbv();
          if ((localObject != null) && (localObject.length > 0)) {
            localgbv.parseFrom((byte[])localObject);
          }
          localgda.acaF = localgbv;
          paramInt += 1;
        }
        AppMethodBeat.o(147816);
        return 0;
      }
      AppMethodBeat.o(147816);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gda
 * JD-Core Version:    0.7.0.1
 */