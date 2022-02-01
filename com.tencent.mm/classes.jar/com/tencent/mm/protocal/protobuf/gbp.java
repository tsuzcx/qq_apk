package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class gbp
  extends com.tencent.mm.bx.a
{
  public etl abMp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115920);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abMp == null)
      {
        paramVarArgs = new b("Not all required fields were included: StatReport");
        AppMethodBeat.o(115920);
        throw paramVarArgs;
      }
      if (this.abMp != null)
      {
        paramVarArgs.qD(1, this.abMp.computeSize());
        this.abMp.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(115920);
      return 0;
    }
    if (paramInt == 1) {
      if (this.abMp == null) {
        break label332;
      }
    }
    label332:
    for (paramInt = i.a.a.a.qC(1, this.abMp.computeSize()) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(115920);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.abMp == null)
        {
          paramVarArgs = new b("Not all required fields were included: StatReport");
          AppMethodBeat.o(115920);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115920);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        gbp localgbp = (gbp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115920);
          return -1;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        int i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          etl localetl = new etl();
          if ((localObject != null) && (localObject.length > 0)) {
            localetl.dh((byte[])localObject);
          }
          localgbp.abMp = localetl;
          paramInt += 1;
        }
        AppMethodBeat.o(115920);
        return 0;
      }
      AppMethodBeat.o(115920);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gbp
 * JD-Core Version:    0.7.0.1
 */