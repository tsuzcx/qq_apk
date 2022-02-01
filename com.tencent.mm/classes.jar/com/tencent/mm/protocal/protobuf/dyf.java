package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dyf
  extends com.tencent.mm.bw.a
{
  public int Idc;
  public String Idg;
  public int ijY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32501);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.Idc);
      paramVarArgs.aS(2, this.ijY);
      if (this.Idg != null) {
        paramVarArgs.d(3, this.Idg);
      }
      AppMethodBeat.o(32501);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.Idc) + 0 + f.a.a.b.b.a.bz(2, this.ijY);
      paramInt = i;
      if (this.Idg != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Idg);
      }
      AppMethodBeat.o(32501);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(32501);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dyf localdyf = (dyf)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32501);
        return -1;
      case 1: 
        localdyf.Idc = locala.OmT.zc();
        AppMethodBeat.o(32501);
        return 0;
      case 2: 
        localdyf.ijY = locala.OmT.zc();
        AppMethodBeat.o(32501);
        return 0;
      }
      localdyf.Idg = locala.OmT.readString();
      AppMethodBeat.o(32501);
      return 0;
    }
    AppMethodBeat.o(32501);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dyf
 * JD-Core Version:    0.7.0.1
 */