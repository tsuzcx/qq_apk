package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bre
  extends com.tencent.mm.bw.a
{
  public double Ecf;
  public double Ecg;
  public String Fgr;
  public String Fgs;
  public String Fgt;
  public String pAt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32338);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, this.Ecg);
      paramVarArgs.e(2, this.Ecf);
      if (this.pAt != null) {
        paramVarArgs.d(3, this.pAt);
      }
      if (this.Fgr != null) {
        paramVarArgs.d(4, this.Fgr);
      }
      if (this.Fgs != null) {
        paramVarArgs.d(5, this.Fgs);
      }
      if (this.Fgt != null) {
        paramVarArgs.d(6, this.Fgt);
      }
      AppMethodBeat.o(32338);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.fK(1) + 8 + 0 + (f.a.a.b.b.a.fK(2) + 8);
      paramInt = i;
      if (this.pAt != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.pAt);
      }
      i = paramInt;
      if (this.Fgr != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.Fgr);
      }
      paramInt = i;
      if (this.Fgs != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Fgs);
      }
      i = paramInt;
      if (this.Fgt != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.Fgt);
      }
      AppMethodBeat.o(32338);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(32338);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bre localbre = (bre)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32338);
        return -1;
      case 1: 
        localbre.Ecg = Double.longBitsToDouble(locala.LVo.gab());
        AppMethodBeat.o(32338);
        return 0;
      case 2: 
        localbre.Ecf = Double.longBitsToDouble(locala.LVo.gab());
        AppMethodBeat.o(32338);
        return 0;
      case 3: 
        localbre.pAt = locala.LVo.readString();
        AppMethodBeat.o(32338);
        return 0;
      case 4: 
        localbre.Fgr = locala.LVo.readString();
        AppMethodBeat.o(32338);
        return 0;
      case 5: 
        localbre.Fgs = locala.LVo.readString();
        AppMethodBeat.o(32338);
        return 0;
      }
      localbre.Fgt = locala.LVo.readString();
      AppMethodBeat.o(32338);
      return 0;
    }
    AppMethodBeat.o(32338);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bre
 * JD-Core Version:    0.7.0.1
 */