package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ddc
  extends com.tencent.mm.bw.a
{
  public int FMK;
  public int FML;
  public int FMM;
  public int FMN;
  public int FMO;
  public int FMP;
  public int Timestamp;
  public int ndH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32457);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.ndH);
      paramVarArgs.aR(2, this.Timestamp);
      paramVarArgs.aR(3, this.FMK);
      paramVarArgs.aR(4, this.FML);
      paramVarArgs.aR(5, this.FMM);
      paramVarArgs.aR(6, this.FMN);
      paramVarArgs.aR(7, this.FMO);
      paramVarArgs.aR(8, this.FMP);
      AppMethodBeat.o(32457);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bx(1, this.ndH);
      int i = f.a.a.b.b.a.bx(2, this.Timestamp);
      int j = f.a.a.b.b.a.bx(3, this.FMK);
      int k = f.a.a.b.b.a.bx(4, this.FML);
      int m = f.a.a.b.b.a.bx(5, this.FMM);
      int n = f.a.a.b.b.a.bx(6, this.FMN);
      int i1 = f.a.a.b.b.a.bx(7, this.FMO);
      int i2 = f.a.a.b.b.a.bx(8, this.FMP);
      AppMethodBeat.o(32457);
      return paramInt + 0 + i + j + k + m + n + i1 + i2;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(32457);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ddc localddc = (ddc)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32457);
        return -1;
      case 1: 
        localddc.ndH = locala.LVo.xF();
        AppMethodBeat.o(32457);
        return 0;
      case 2: 
        localddc.Timestamp = locala.LVo.xF();
        AppMethodBeat.o(32457);
        return 0;
      case 3: 
        localddc.FMK = locala.LVo.xF();
        AppMethodBeat.o(32457);
        return 0;
      case 4: 
        localddc.FML = locala.LVo.xF();
        AppMethodBeat.o(32457);
        return 0;
      case 5: 
        localddc.FMM = locala.LVo.xF();
        AppMethodBeat.o(32457);
        return 0;
      case 6: 
        localddc.FMN = locala.LVo.xF();
        AppMethodBeat.o(32457);
        return 0;
      case 7: 
        localddc.FMO = locala.LVo.xF();
        AppMethodBeat.o(32457);
        return 0;
      }
      localddc.FMP = locala.LVo.xF();
      AppMethodBeat.o(32457);
      return 0;
    }
    AppMethodBeat.o(32457);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ddc
 * JD-Core Version:    0.7.0.1
 */