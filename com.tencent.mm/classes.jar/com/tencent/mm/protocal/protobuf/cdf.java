package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cdf
  extends com.tencent.mm.bx.a
{
  public int DZv;
  public int DZw;
  public int DZx;
  public int oXv;
  public String oXw;
  public int sBd;
  public String sBe;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32392);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.DZw);
      paramVarArgs.aR(2, this.DZx);
      paramVarArgs.aR(3, this.DZv);
      paramVarArgs.aR(4, this.oXv);
      if (this.oXw != null) {
        paramVarArgs.d(5, this.oXw);
      }
      paramVarArgs.aR(6, this.sBd);
      if (this.sBe != null) {
        paramVarArgs.d(7, this.sBe);
      }
      AppMethodBeat.o(32392);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.DZw) + 0 + f.a.a.b.b.a.bA(2, this.DZx) + f.a.a.b.b.a.bA(3, this.DZv) + f.a.a.b.b.a.bA(4, this.oXv);
      paramInt = i;
      if (this.oXw != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.oXw);
      }
      i = paramInt + f.a.a.b.b.a.bA(6, this.sBd);
      paramInt = i;
      if (this.sBe != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.sBe);
      }
      AppMethodBeat.o(32392);
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
      AppMethodBeat.o(32392);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cdf localcdf = (cdf)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32392);
        return -1;
      case 1: 
        localcdf.DZw = locala.KhF.xS();
        AppMethodBeat.o(32392);
        return 0;
      case 2: 
        localcdf.DZx = locala.KhF.xS();
        AppMethodBeat.o(32392);
        return 0;
      case 3: 
        localcdf.DZv = locala.KhF.xS();
        AppMethodBeat.o(32392);
        return 0;
      case 4: 
        localcdf.oXv = locala.KhF.xS();
        AppMethodBeat.o(32392);
        return 0;
      case 5: 
        localcdf.oXw = locala.KhF.readString();
        AppMethodBeat.o(32392);
        return 0;
      case 6: 
        localcdf.sBd = locala.KhF.xS();
        AppMethodBeat.o(32392);
        return 0;
      }
      localcdf.sBe = locala.KhF.readString();
      AppMethodBeat.o(32392);
      return 0;
    }
    AppMethodBeat.o(32392);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cdf
 * JD-Core Version:    0.7.0.1
 */