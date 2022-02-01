package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ctm
  extends com.tencent.mm.bx.a
{
  public com.tencent.mm.bx.b Elh;
  public int Version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152695);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Elh == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Signature");
        AppMethodBeat.o(152695);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.Version);
      if (this.Elh != null) {
        paramVarArgs.c(2, this.Elh);
      }
      AppMethodBeat.o(152695);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.Version) + 0;
      paramInt = i;
      if (this.Elh != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.Elh);
      }
      AppMethodBeat.o(152695);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      if (this.Elh == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Signature");
        AppMethodBeat.o(152695);
        throw paramVarArgs;
      }
      AppMethodBeat.o(152695);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ctm localctm = (ctm)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(152695);
        return -1;
      case 1: 
        localctm.Version = locala.KhF.xS();
        AppMethodBeat.o(152695);
        return 0;
      }
      localctm.Elh = locala.KhF.fMu();
      AppMethodBeat.o(152695);
      return 0;
    }
    AppMethodBeat.o(152695);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ctm
 * JD-Core Version:    0.7.0.1
 */