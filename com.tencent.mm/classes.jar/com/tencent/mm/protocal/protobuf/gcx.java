package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class gcx
  extends com.tencent.mm.bx.a
{
  public gbw acaH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147813);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.acaH == null)
      {
        paramVarArgs = new b("Not all required fields were included: base_response");
        AppMethodBeat.o(147813);
        throw paramVarArgs;
      }
      if (this.acaH != null)
      {
        paramVarArgs.qD(1, this.acaH.computeSize());
        this.acaH.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(147813);
      return 0;
    }
    if (paramInt == 1) {
      if (this.acaH == null) {
        break label332;
      }
    }
    label332:
    for (paramInt = i.a.a.a.qC(1, this.acaH.computeSize()) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(147813);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.acaH == null)
        {
          paramVarArgs = new b("Not all required fields were included: base_response");
          AppMethodBeat.o(147813);
          throw paramVarArgs;
        }
        AppMethodBeat.o(147813);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        gcx localgcx = (gcx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(147813);
          return -1;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        int i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          gbw localgbw = new gbw();
          if ((localObject != null) && (localObject.length > 0)) {
            localgbw.parseFrom((byte[])localObject);
          }
          localgcx.acaH = localgbw;
          paramInt += 1;
        }
        AppMethodBeat.o(147813);
        return 0;
      }
      AppMethodBeat.o(147813);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gcx
 * JD-Core Version:    0.7.0.1
 */