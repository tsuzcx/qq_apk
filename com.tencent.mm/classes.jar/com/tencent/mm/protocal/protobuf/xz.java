package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class xz
  extends com.tencent.mm.bx.a
{
  public String CzP;
  public int Dab;
  public int status;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(90961);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Dab);
      if (this.CzP != null) {
        paramVarArgs.d(2, this.CzP);
      }
      paramVarArgs.aR(3, this.status);
      AppMethodBeat.o(90961);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.Dab) + 0;
      paramInt = i;
      if (this.CzP != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.CzP);
      }
      i = f.a.a.b.b.a.bA(3, this.status);
      AppMethodBeat.o(90961);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(90961);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      xz localxz = (xz)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(90961);
        return -1;
      case 1: 
        localxz.Dab = locala.KhF.xS();
        AppMethodBeat.o(90961);
        return 0;
      case 2: 
        localxz.CzP = locala.KhF.readString();
        AppMethodBeat.o(90961);
        return 0;
      }
      localxz.status = locala.KhF.xS();
      AppMethodBeat.o(90961);
      return 0;
    }
    AppMethodBeat.o(90961);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.xz
 * JD-Core Version:    0.7.0.1
 */