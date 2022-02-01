package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class bro
  extends com.tencent.mm.bw.a
{
  public String dHx;
  public String dOe;
  public String jGZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152580);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.jGZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: tp_username");
        AppMethodBeat.o(152580);
        throw paramVarArgs;
      }
      if (this.jGZ != null) {
        paramVarArgs.e(1, this.jGZ);
      }
      if (this.dOe != null) {
        paramVarArgs.e(2, this.dOe);
      }
      if (this.dHx != null) {
        paramVarArgs.e(3, this.dHx);
      }
      AppMethodBeat.o(152580);
      return 0;
    }
    if (paramInt == 1) {
      if (this.jGZ == null) {
        break label382;
      }
    }
    label382:
    for (int i = g.a.a.b.b.a.f(1, this.jGZ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dOe != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.dOe);
      }
      i = paramInt;
      if (this.dHx != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.dHx);
      }
      AppMethodBeat.o(152580);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.jGZ == null)
        {
          paramVarArgs = new b("Not all required fields were included: tp_username");
          AppMethodBeat.o(152580);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152580);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        bro localbro = (bro)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152580);
          return -1;
        case 1: 
          localbro.jGZ = locala.UbS.readString();
          AppMethodBeat.o(152580);
          return 0;
        case 2: 
          localbro.dOe = locala.UbS.readString();
          AppMethodBeat.o(152580);
          return 0;
        }
        localbro.dHx = locala.UbS.readString();
        AppMethodBeat.o(152580);
        return 0;
      }
      AppMethodBeat.o(152580);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bro
 * JD-Core Version:    0.7.0.1
 */