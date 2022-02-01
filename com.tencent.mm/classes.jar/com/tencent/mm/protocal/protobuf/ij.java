package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ij
  extends com.tencent.mm.bw.a
{
  public int dIZ;
  public String data;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153261);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.e(1, this.username);
      }
      if (this.data != null) {
        paramVarArgs.e(2, this.data);
      }
      paramVarArgs.aM(3, this.dIZ);
      AppMethodBeat.o(153261);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = g.a.a.b.b.a.f(1, this.username) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.data != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.data);
      }
      paramInt = g.a.a.b.b.a.bu(3, this.dIZ);
      AppMethodBeat.o(153261);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(153261);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ij localij = (ij)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(153261);
          return -1;
        case 1: 
          localij.username = locala.UbS.readString();
          AppMethodBeat.o(153261);
          return 0;
        case 2: 
          localij.data = locala.UbS.readString();
          AppMethodBeat.o(153261);
          return 0;
        }
        localij.dIZ = locala.UbS.zi();
        AppMethodBeat.o(153261);
        return 0;
      }
      AppMethodBeat.o(153261);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ij
 * JD-Core Version:    0.7.0.1
 */