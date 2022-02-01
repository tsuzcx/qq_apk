package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class gie
  extends com.tencent.mm.bx.a
{
  public String aceF;
  public LinkedList<String> aceG;
  
  public gie()
  {
    AppMethodBeat.i(258641);
    this.aceG = new LinkedList();
    AppMethodBeat.o(258641);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258645);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aceF != null) {
        paramVarArgs.g(1, this.aceF);
      }
      paramVarArgs.e(2, 1, this.aceG);
      AppMethodBeat.o(258645);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aceF == null) {
        break label270;
      }
    }
    label270:
    for (paramInt = i.a.a.b.b.a.h(1, this.aceF) + 0;; paramInt = 0)
    {
      int i = i.a.a.a.c(2, 1, this.aceG);
      AppMethodBeat.o(258645);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aceG.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258645);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        gie localgie = (gie)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258645);
          return -1;
        case 1: 
          localgie.aceF = locala.ajGk.readString();
          AppMethodBeat.o(258645);
          return 0;
        }
        localgie.aceG.add(locala.ajGk.readString());
        AppMethodBeat.o(258645);
        return 0;
      }
      AppMethodBeat.o(258645);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gie
 * JD-Core Version:    0.7.0.1
 */