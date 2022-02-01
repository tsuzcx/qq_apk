package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class yb
  extends com.tencent.mm.bx.a
{
  public int Dac;
  public int Dad;
  public String Dae;
  public String ddS;
  public String ddT;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32169);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.version);
      paramVarArgs.aR(2, this.Dac);
      paramVarArgs.aR(3, this.Dad);
      if (this.ddT != null) {
        paramVarArgs.d(4, this.ddT);
      }
      if (this.Dae != null) {
        paramVarArgs.d(5, this.Dae);
      }
      if (this.ddS != null) {
        paramVarArgs.d(6, this.ddS);
      }
      AppMethodBeat.o(32169);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.version) + 0 + f.a.a.b.b.a.bA(2, this.Dac) + f.a.a.b.b.a.bA(3, this.Dad);
      paramInt = i;
      if (this.ddT != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.ddT);
      }
      i = paramInt;
      if (this.Dae != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Dae);
      }
      paramInt = i;
      if (this.ddS != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.ddS);
      }
      AppMethodBeat.o(32169);
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
      AppMethodBeat.o(32169);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      yb localyb = (yb)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32169);
        return -1;
      case 1: 
        localyb.version = locala.KhF.xS();
        AppMethodBeat.o(32169);
        return 0;
      case 2: 
        localyb.Dac = locala.KhF.xS();
        AppMethodBeat.o(32169);
        return 0;
      case 3: 
        localyb.Dad = locala.KhF.xS();
        AppMethodBeat.o(32169);
        return 0;
      case 4: 
        localyb.ddT = locala.KhF.readString();
        AppMethodBeat.o(32169);
        return 0;
      case 5: 
        localyb.Dae = locala.KhF.readString();
        AppMethodBeat.o(32169);
        return 0;
      }
      localyb.ddS = locala.KhF.readString();
      AppMethodBeat.o(32169);
      return 0;
    }
    AppMethodBeat.o(32169);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.yb
 * JD-Core Version:    0.7.0.1
 */