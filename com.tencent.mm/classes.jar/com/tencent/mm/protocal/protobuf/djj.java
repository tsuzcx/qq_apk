package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class djj
  extends com.tencent.mm.bx.a
{
  public String hNH;
  public String hNQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152721);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.hNH == null)
      {
        paramVarArgs = new b("Not all required fields were included: tp_username");
        AppMethodBeat.o(152721);
        throw paramVarArgs;
      }
      if (this.hNQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: verify_ticket");
        AppMethodBeat.o(152721);
        throw paramVarArgs;
      }
      if (this.hNH != null) {
        paramVarArgs.d(1, this.hNH);
      }
      if (this.hNQ != null) {
        paramVarArgs.d(2, this.hNQ);
      }
      AppMethodBeat.o(152721);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hNH == null) {
        break label370;
      }
    }
    label370:
    for (paramInt = f.a.a.b.b.a.e(1, this.hNH) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.hNQ != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.hNQ);
      }
      AppMethodBeat.o(152721);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.hNH == null)
        {
          paramVarArgs = new b("Not all required fields were included: tp_username");
          AppMethodBeat.o(152721);
          throw paramVarArgs;
        }
        if (this.hNQ == null)
        {
          paramVarArgs = new b("Not all required fields were included: verify_ticket");
          AppMethodBeat.o(152721);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152721);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        djj localdjj = (djj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152721);
          return -1;
        case 1: 
          localdjj.hNH = locala.KhF.readString();
          AppMethodBeat.o(152721);
          return 0;
        }
        localdjj.hNQ = locala.KhF.readString();
        AppMethodBeat.o(152721);
        return 0;
      }
      AppMethodBeat.o(152721);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.djj
 * JD-Core Version:    0.7.0.1
 */