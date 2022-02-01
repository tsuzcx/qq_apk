package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class gho
  extends com.tencent.mm.bx.a
{
  public LinkedList<String> aaib;
  public String key;
  
  public gho()
  {
    AppMethodBeat.i(258758);
    this.aaib = new LinkedList();
    AppMethodBeat.o(258758);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258763);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.key == null)
      {
        paramVarArgs = new b("Not all required fields were included: key");
        AppMethodBeat.o(258763);
        throw paramVarArgs;
      }
      if (this.key != null) {
        paramVarArgs.g(1, this.key);
      }
      paramVarArgs.e(2, 1, this.aaib);
      AppMethodBeat.o(258763);
      return 0;
    }
    if (paramInt == 1) {
      if (this.key == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = i.a.a.b.b.a.h(1, this.key) + 0;; paramInt = 0)
    {
      int i = i.a.a.a.c(2, 1, this.aaib);
      AppMethodBeat.o(258763);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aaib.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.key == null)
        {
          paramVarArgs = new b("Not all required fields were included: key");
          AppMethodBeat.o(258763);
          throw paramVarArgs;
        }
        AppMethodBeat.o(258763);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        gho localgho = (gho)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258763);
          return -1;
        case 1: 
          localgho.key = locala.ajGk.readString();
          AppMethodBeat.o(258763);
          return 0;
        }
        localgho.aaib.add(locala.ajGk.readString());
        AppMethodBeat.o(258763);
        return 0;
      }
      AppMethodBeat.o(258763);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gho
 * JD-Core Version:    0.7.0.1
 */