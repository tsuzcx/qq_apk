package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ddj
  extends com.tencent.mm.bx.a
{
  public double CJD;
  public double CJE;
  public String DTI;
  public String Name;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56262);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, this.CJE);
      paramVarArgs.e(2, this.CJD);
      if (this.Name != null) {
        paramVarArgs.d(3, this.Name);
      }
      if (this.DTI != null) {
        paramVarArgs.d(4, this.DTI);
      }
      AppMethodBeat.o(56262);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.fY(1) + 8 + 0 + (f.a.a.b.b.a.fY(2) + 8);
      paramInt = i;
      if (this.Name != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Name);
      }
      i = paramInt;
      if (this.DTI != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.DTI);
      }
      AppMethodBeat.o(56262);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(56262);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ddj localddj = (ddj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(56262);
        return -1;
      case 1: 
        localddj.CJE = Double.longBitsToDouble(locala.KhF.fHy());
        AppMethodBeat.o(56262);
        return 0;
      case 2: 
        localddj.CJD = Double.longBitsToDouble(locala.KhF.fHy());
        AppMethodBeat.o(56262);
        return 0;
      case 3: 
        localddj.Name = locala.KhF.readString();
        AppMethodBeat.o(56262);
        return 0;
      }
      localddj.DTI = locala.KhF.readString();
      AppMethodBeat.o(56262);
      return 0;
    }
    AppMethodBeat.o(56262);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ddj
 * JD-Core Version:    0.7.0.1
 */