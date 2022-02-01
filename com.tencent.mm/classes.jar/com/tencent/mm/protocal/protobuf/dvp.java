package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dvp
  extends com.tencent.mm.bx.a
{
  public String FIk;
  public String GXd;
  public int GXe;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(176156);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.GXe);
      if (this.FIk != null) {
        paramVarArgs.d(2, this.FIk);
      }
      if (this.GXd != null) {
        paramVarArgs.d(3, this.GXd);
      }
      AppMethodBeat.o(176156);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.GXe) + 0;
      paramInt = i;
      if (this.FIk != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FIk);
      }
      i = paramInt;
      if (this.GXd != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GXd);
      }
      AppMethodBeat.o(176156);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(176156);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dvp localdvp = (dvp)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(176156);
        return -1;
      case 1: 
        localdvp.GXe = locala.NPN.zc();
        AppMethodBeat.o(176156);
        return 0;
      case 2: 
        localdvp.FIk = locala.NPN.readString();
        AppMethodBeat.o(176156);
        return 0;
      }
      localdvp.GXd = locala.NPN.readString();
      AppMethodBeat.o(176156);
      return 0;
    }
    AppMethodBeat.o(176156);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dvp
 * JD-Core Version:    0.7.0.1
 */