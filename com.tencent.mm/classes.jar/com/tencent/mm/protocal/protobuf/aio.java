package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aio
  extends com.tencent.mm.bx.a
{
  public String hMM;
  public LinkedList<String> username_list;
  
  public aio()
  {
    AppMethodBeat.i(258858);
    this.username_list = new LinkedList();
    AppMethodBeat.o(258858);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258862);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.hMM != null) {
        paramVarArgs.g(1, this.hMM);
      }
      paramVarArgs.e(2, 1, this.username_list);
      AppMethodBeat.o(258862);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hMM == null) {
        break label270;
      }
    }
    label270:
    for (paramInt = i.a.a.b.b.a.h(1, this.hMM) + 0;; paramInt = 0)
    {
      int i = i.a.a.a.c(2, 1, this.username_list);
      AppMethodBeat.o(258862);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.username_list.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258862);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        aio localaio = (aio)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258862);
          return -1;
        case 1: 
          localaio.hMM = locala.ajGk.readString();
          AppMethodBeat.o(258862);
          return 0;
        }
        localaio.username_list.add(locala.ajGk.readString());
        AppMethodBeat.o(258862);
        return 0;
      }
      AppMethodBeat.o(258862);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aio
 * JD-Core Version:    0.7.0.1
 */