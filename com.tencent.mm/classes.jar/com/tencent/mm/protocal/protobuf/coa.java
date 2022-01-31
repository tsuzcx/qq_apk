package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class coa
  extends com.tencent.mm.bv.a
{
  public int Ret;
  public int pIx;
  public int pIy;
  public String wQr;
  public boolean xWR;
  public boolean xWS = false;
  public String xbi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(62586);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.Ret);
      paramVarArgs.aO(2, this.pIy);
      paramVarArgs.aO(3, this.pIx);
      if (this.wQr != null) {
        paramVarArgs.e(4, this.wQr);
      }
      paramVarArgs.aS(5, this.xWR);
      if (this.xbi != null) {
        paramVarArgs.e(6, this.xbi);
      }
      paramVarArgs.aS(7, this.xWS);
      AppMethodBeat.o(62586);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.Ret) + 0 + e.a.a.b.b.a.bl(2, this.pIy) + e.a.a.b.b.a.bl(3, this.pIx);
      paramInt = i;
      if (this.wQr != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wQr);
      }
      i = paramInt + (e.a.a.b.b.a.eW(5) + 1);
      paramInt = i;
      if (this.xbi != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.xbi);
      }
      i = e.a.a.b.b.a.eW(7);
      AppMethodBeat.o(62586);
      return paramInt + (i + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(62586);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      coa localcoa = (coa)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(62586);
        return -1;
      case 1: 
        localcoa.Ret = locala.CLY.sl();
        AppMethodBeat.o(62586);
        return 0;
      case 2: 
        localcoa.pIy = locala.CLY.sl();
        AppMethodBeat.o(62586);
        return 0;
      case 3: 
        localcoa.pIx = locala.CLY.sl();
        AppMethodBeat.o(62586);
        return 0;
      case 4: 
        localcoa.wQr = locala.CLY.readString();
        AppMethodBeat.o(62586);
        return 0;
      case 5: 
        localcoa.xWR = locala.CLY.emu();
        AppMethodBeat.o(62586);
        return 0;
      case 6: 
        localcoa.xbi = locala.CLY.readString();
        AppMethodBeat.o(62586);
        return 0;
      }
      localcoa.xWS = locala.CLY.emu();
      AppMethodBeat.o(62586);
      return 0;
    }
    AppMethodBeat.o(62586);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.coa
 * JD-Core Version:    0.7.0.1
 */