package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bwa
  extends com.tencent.mm.bx.a
{
  public com.tencent.mm.bx.b DST;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43115);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DST == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: buf");
        AppMethodBeat.o(43115);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.type);
      if (this.DST != null) {
        paramVarArgs.c(2, this.DST);
      }
      AppMethodBeat.o(43115);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.type) + 0;
      paramInt = i;
      if (this.DST != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.DST);
      }
      AppMethodBeat.o(43115);
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
      if (this.DST == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: buf");
        AppMethodBeat.o(43115);
        throw paramVarArgs;
      }
      AppMethodBeat.o(43115);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bwa localbwa = (bwa)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(43115);
        return -1;
      case 1: 
        localbwa.type = locala.KhF.xS();
        AppMethodBeat.o(43115);
        return 0;
      }
      localbwa.DST = locala.KhF.fMu();
      AppMethodBeat.o(43115);
      return 0;
    }
    AppMethodBeat.o(43115);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bwa
 * JD-Core Version:    0.7.0.1
 */