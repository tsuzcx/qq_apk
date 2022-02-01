package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class agj
  extends com.tencent.mm.bx.a
{
  public int Cxl;
  public int Cxm;
  public int Cxn;
  public int Cxo;
  public String Cxr;
  public int mBi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127470);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Cxl);
      paramVarArgs.aR(2, this.mBi);
      if (this.Cxr != null) {
        paramVarArgs.d(3, this.Cxr);
      }
      paramVarArgs.aR(4, this.Cxm);
      paramVarArgs.aR(5, this.Cxn);
      paramVarArgs.aR(6, this.Cxo);
      AppMethodBeat.o(127470);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.Cxl) + 0 + f.a.a.b.b.a.bA(2, this.mBi);
      paramInt = i;
      if (this.Cxr != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Cxr);
      }
      i = f.a.a.b.b.a.bA(4, this.Cxm);
      int j = f.a.a.b.b.a.bA(5, this.Cxn);
      int k = f.a.a.b.b.a.bA(6, this.Cxo);
      AppMethodBeat.o(127470);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(127470);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      agj localagj = (agj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(127470);
        return -1;
      case 1: 
        localagj.Cxl = locala.KhF.xS();
        AppMethodBeat.o(127470);
        return 0;
      case 2: 
        localagj.mBi = locala.KhF.xS();
        AppMethodBeat.o(127470);
        return 0;
      case 3: 
        localagj.Cxr = locala.KhF.readString();
        AppMethodBeat.o(127470);
        return 0;
      case 4: 
        localagj.Cxm = locala.KhF.xS();
        AppMethodBeat.o(127470);
        return 0;
      case 5: 
        localagj.Cxn = locala.KhF.xS();
        AppMethodBeat.o(127470);
        return 0;
      }
      localagj.Cxo = locala.KhF.xS();
      AppMethodBeat.o(127470);
      return 0;
    }
    AppMethodBeat.o(127470);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.agj
 * JD-Core Version:    0.7.0.1
 */