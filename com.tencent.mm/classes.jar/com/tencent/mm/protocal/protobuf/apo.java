package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class apo
  extends com.tencent.mm.bw.a
{
  public String BuL;
  public String BuM;
  public String BuN;
  public int EIA;
  public double EIB;
  public long EIz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91470);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.EIz);
      paramVarArgs.aR(2, this.EIA);
      paramVarArgs.e(3, this.EIB);
      if (this.BuL != null) {
        paramVarArgs.d(4, this.BuL);
      }
      if (this.BuM != null) {
        paramVarArgs.d(5, this.BuM);
      }
      if (this.BuN != null) {
        paramVarArgs.d(6, this.BuN);
      }
      AppMethodBeat.o(91470);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.p(1, this.EIz) + 0 + f.a.a.b.b.a.bx(2, this.EIA) + (f.a.a.b.b.a.fK(3) + 8);
      paramInt = i;
      if (this.BuL != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.BuL);
      }
      i = paramInt;
      if (this.BuM != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.BuM);
      }
      paramInt = i;
      if (this.BuN != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.BuN);
      }
      AppMethodBeat.o(91470);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(91470);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      apo localapo = (apo)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91470);
        return -1;
      case 1: 
        localapo.EIz = locala.LVo.xG();
        AppMethodBeat.o(91470);
        return 0;
      case 2: 
        localapo.EIA = locala.LVo.xF();
        AppMethodBeat.o(91470);
        return 0;
      case 3: 
        localapo.EIB = Double.longBitsToDouble(locala.LVo.gab());
        AppMethodBeat.o(91470);
        return 0;
      case 4: 
        localapo.BuL = locala.LVo.readString();
        AppMethodBeat.o(91470);
        return 0;
      case 5: 
        localapo.BuM = locala.LVo.readString();
        AppMethodBeat.o(91470);
        return 0;
      }
      localapo.BuN = locala.LVo.readString();
      AppMethodBeat.o(91470);
      return 0;
    }
    AppMethodBeat.o(91470);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.apo
 * JD-Core Version:    0.7.0.1
 */