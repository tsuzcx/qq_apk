package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class un
  extends com.tencent.mm.bw.a
{
  public String Hwr;
  public String Hws;
  public int IhZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113965);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Hwr != null) {
        paramVarArgs.e(1, this.Hwr);
      }
      if (this.Hws != null) {
        paramVarArgs.e(2, this.Hws);
      }
      paramVarArgs.aM(3, this.IhZ);
      AppMethodBeat.o(113965);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Hwr == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = g.a.a.b.b.a.f(1, this.Hwr) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Hws != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.Hws);
      }
      paramInt = g.a.a.b.b.a.bu(3, this.IhZ);
      AppMethodBeat.o(113965);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(113965);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        un localun = (un)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(113965);
          return -1;
        case 1: 
          localun.Hwr = locala.UbS.readString();
          AppMethodBeat.o(113965);
          return 0;
        case 2: 
          localun.Hws = locala.UbS.readString();
          AppMethodBeat.o(113965);
          return 0;
        }
        localun.IhZ = locala.UbS.zi();
        AppMethodBeat.o(113965);
        return 0;
      }
      AppMethodBeat.o(113965);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.un
 * JD-Core Version:    0.7.0.1
 */