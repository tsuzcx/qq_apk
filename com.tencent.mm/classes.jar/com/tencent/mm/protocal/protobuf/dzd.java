package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class dzd
  extends com.tencent.mm.bx.a
{
  public adx abat;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43118);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abat == null)
      {
        paramVarArgs = new b("Not all required fields were included: Oplog");
        AppMethodBeat.o(43118);
        throw paramVarArgs;
      }
      if (this.abat != null)
      {
        paramVarArgs.qD(1, this.abat.computeSize());
        this.abat.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(43118);
      return 0;
    }
    if (paramInt == 1) {
      if (this.abat == null) {
        break label332;
      }
    }
    label332:
    for (paramInt = i.a.a.a.qC(1, this.abat.computeSize()) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(43118);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.abat == null)
        {
          paramVarArgs = new b("Not all required fields were included: Oplog");
          AppMethodBeat.o(43118);
          throw paramVarArgs;
        }
        AppMethodBeat.o(43118);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        dzd localdzd = (dzd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(43118);
          return -1;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        int i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          adx localadx = new adx();
          if ((localObject != null) && (localObject.length > 0)) {
            localadx.parseFrom((byte[])localObject);
          }
          localdzd.abat = localadx;
          paramInt += 1;
        }
        AppMethodBeat.o(43118);
        return 0;
      }
      AppMethodBeat.o(43118);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzd
 * JD-Core Version:    0.7.0.1
 */