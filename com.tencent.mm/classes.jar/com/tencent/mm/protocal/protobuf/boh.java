package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class boh
  extends com.tencent.mm.bx.a
{
  public String ZWE;
  public LinkedList<bog> ZWF;
  
  public boh()
  {
    AppMethodBeat.i(258355);
    this.ZWF = new LinkedList();
    AppMethodBeat.o(258355);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258360);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZWE != null) {
        paramVarArgs.g(1, this.ZWE);
      }
      paramVarArgs.e(2, 8, this.ZWF);
      AppMethodBeat.o(258360);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZWE == null) {
        break label332;
      }
    }
    label332:
    for (paramInt = i.a.a.b.b.a.h(1, this.ZWE) + 0;; paramInt = 0)
    {
      int i = i.a.a.a.c(2, 8, this.ZWF);
      AppMethodBeat.o(258360);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ZWF.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258360);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        boh localboh = (boh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258360);
          return -1;
        case 1: 
          localboh.ZWE = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258360);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          bog localbog = new bog();
          if ((localObject != null) && (localObject.length > 0)) {
            localbog.parseFrom((byte[])localObject);
          }
          localboh.ZWF.add(localbog);
          paramInt += 1;
        }
        AppMethodBeat.o(258360);
        return 0;
      }
      AppMethodBeat.o(258360);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.boh
 * JD-Core Version:    0.7.0.1
 */