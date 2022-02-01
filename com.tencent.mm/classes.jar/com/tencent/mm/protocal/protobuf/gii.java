package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class gii
  extends com.tencent.mm.bx.a
{
  public LinkedList<String> aceT;
  public String title;
  
  public gii()
  {
    AppMethodBeat.i(258513);
    this.aceT = new LinkedList();
    AppMethodBeat.o(258513);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258518);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.g(1, this.title);
      }
      paramVarArgs.e(2, 1, this.aceT);
      AppMethodBeat.o(258518);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label270;
      }
    }
    label270:
    for (paramInt = i.a.a.b.b.a.h(1, this.title) + 0;; paramInt = 0)
    {
      int i = i.a.a.a.c(2, 1, this.aceT);
      AppMethodBeat.o(258518);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aceT.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258518);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        gii localgii = (gii)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258518);
          return -1;
        case 1: 
          localgii.title = locala.ajGk.readString();
          AppMethodBeat.o(258518);
          return 0;
        }
        localgii.aceT.add(locala.ajGk.readString());
        AppMethodBeat.o(258518);
        return 0;
      }
      AppMethodBeat.o(258518);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gii
 * JD-Core Version:    0.7.0.1
 */