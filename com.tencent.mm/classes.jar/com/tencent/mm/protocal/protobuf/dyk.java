package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dyk
  extends com.tencent.mm.bw.a
{
  public com.tencent.mm.bw.b MYa;
  public int Version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152695);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MYa == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: Signature");
        AppMethodBeat.o(152695);
        throw paramVarArgs;
      }
      paramVarArgs.aM(1, this.Version);
      if (this.MYa != null) {
        paramVarArgs.c(2, this.MYa);
      }
      AppMethodBeat.o(152695);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.Version) + 0;
      paramInt = i;
      if (this.MYa != null) {
        paramInt = i + g.a.a.b.b.a.b(2, this.MYa);
      }
      AppMethodBeat.o(152695);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      if (this.MYa == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: Signature");
        AppMethodBeat.o(152695);
        throw paramVarArgs;
      }
      AppMethodBeat.o(152695);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      dyk localdyk = (dyk)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(152695);
        return -1;
      case 1: 
        localdyk.Version = locala.UbS.zi();
        AppMethodBeat.o(152695);
        return 0;
      }
      localdyk.MYa = locala.UbS.hPo();
      AppMethodBeat.o(152695);
      return 0;
    }
    AppMethodBeat.o(152695);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dyk
 * JD-Core Version:    0.7.0.1
 */