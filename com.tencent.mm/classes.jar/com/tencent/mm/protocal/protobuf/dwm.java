package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dwm
  extends com.tencent.mm.bw.a
{
  public String GaH;
  public String HqD;
  public int HqE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(176156);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.HqE);
      if (this.GaH != null) {
        paramVarArgs.d(2, this.GaH);
      }
      if (this.HqD != null) {
        paramVarArgs.d(3, this.HqD);
      }
      AppMethodBeat.o(176156);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.HqE) + 0;
      paramInt = i;
      if (this.GaH != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.GaH);
      }
      i = paramInt;
      if (this.HqD != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.HqD);
      }
      AppMethodBeat.o(176156);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(176156);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dwm localdwm = (dwm)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(176156);
        return -1;
      case 1: 
        localdwm.HqE = locala.OmT.zc();
        AppMethodBeat.o(176156);
        return 0;
      case 2: 
        localdwm.GaH = locala.OmT.readString();
        AppMethodBeat.o(176156);
        return 0;
      }
      localdwm.HqD = locala.OmT.readString();
      AppMethodBeat.o(176156);
      return 0;
    }
    AppMethodBeat.o(176156);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dwm
 * JD-Core Version:    0.7.0.1
 */