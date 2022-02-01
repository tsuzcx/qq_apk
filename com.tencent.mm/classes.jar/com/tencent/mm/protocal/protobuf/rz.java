package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class rz
  extends com.tencent.mm.bx.a
{
  public String YRQ;
  public LinkedList<String> YWT;
  
  public rz()
  {
    AppMethodBeat.i(124465);
    this.YWT = new LinkedList();
    AppMethodBeat.o(124465);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124466);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YRQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: brand_user_name");
        AppMethodBeat.o(124466);
        throw paramVarArgs;
      }
      if (this.YRQ != null) {
        paramVarArgs.g(2, this.YRQ);
      }
      paramVarArgs.e(3, 1, this.YWT);
      AppMethodBeat.o(124466);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YRQ == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = i.a.a.b.b.a.h(2, this.YRQ) + 0;; paramInt = 0)
    {
      int i = i.a.a.a.c(3, 1, this.YWT);
      AppMethodBeat.o(124466);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.YWT.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.YRQ == null)
        {
          paramVarArgs = new b("Not all required fields were included: brand_user_name");
          AppMethodBeat.o(124466);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124466);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        rz localrz = (rz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124466);
          return -1;
        case 2: 
          localrz.YRQ = locala.ajGk.readString();
          AppMethodBeat.o(124466);
          return 0;
        }
        localrz.YWT.add(locala.ajGk.readString());
        AppMethodBeat.o(124466);
        return 0;
      }
      AppMethodBeat.o(124466);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.rz
 * JD-Core Version:    0.7.0.1
 */