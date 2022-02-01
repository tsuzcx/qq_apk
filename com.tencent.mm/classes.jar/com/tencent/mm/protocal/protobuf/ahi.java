package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ahi
  extends com.tencent.mm.bw.a
{
  public int DPH;
  public int DPI;
  public int DPJ;
  public int DPK;
  public String DPN;
  public int ndj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127470);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.DPH);
      paramVarArgs.aR(2, this.ndj);
      if (this.DPN != null) {
        paramVarArgs.d(3, this.DPN);
      }
      paramVarArgs.aR(4, this.DPI);
      paramVarArgs.aR(5, this.DPJ);
      paramVarArgs.aR(6, this.DPK);
      AppMethodBeat.o(127470);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.DPH) + 0 + f.a.a.b.b.a.bx(2, this.ndj);
      paramInt = i;
      if (this.DPN != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.DPN);
      }
      i = f.a.a.b.b.a.bx(4, this.DPI);
      int j = f.a.a.b.b.a.bx(5, this.DPJ);
      int k = f.a.a.b.b.a.bx(6, this.DPK);
      AppMethodBeat.o(127470);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(127470);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ahi localahi = (ahi)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(127470);
        return -1;
      case 1: 
        localahi.DPH = locala.LVo.xF();
        AppMethodBeat.o(127470);
        return 0;
      case 2: 
        localahi.ndj = locala.LVo.xF();
        AppMethodBeat.o(127470);
        return 0;
      case 3: 
        localahi.DPN = locala.LVo.readString();
        AppMethodBeat.o(127470);
        return 0;
      case 4: 
        localahi.DPI = locala.LVo.xF();
        AppMethodBeat.o(127470);
        return 0;
      case 5: 
        localahi.DPJ = locala.LVo.xF();
        AppMethodBeat.o(127470);
        return 0;
      }
      localahi.DPK = locala.LVo.xF();
      AppMethodBeat.o(127470);
      return 0;
    }
    AppMethodBeat.o(127470);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ahi
 * JD-Core Version:    0.7.0.1
 */