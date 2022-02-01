package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dka
  extends com.tencent.mm.bw.a
{
  public int HRK;
  public String HRL;
  public String HRM;
  public String HRN;
  public String HRO;
  public int height;
  public int width;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168761);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.HRK);
      if (this.HRL != null) {
        paramVarArgs.d(2, this.HRL);
      }
      if (this.HRM != null) {
        paramVarArgs.d(3, this.HRM);
      }
      paramVarArgs.aS(4, this.height);
      paramVarArgs.aS(5, this.width);
      if (this.HRN != null) {
        paramVarArgs.d(6, this.HRN);
      }
      if (this.HRO != null) {
        paramVarArgs.d(7, this.HRO);
      }
      AppMethodBeat.o(168761);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.HRK) + 0;
      paramInt = i;
      if (this.HRL != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.HRL);
      }
      i = paramInt;
      if (this.HRM != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.HRM);
      }
      i = i + f.a.a.b.b.a.bz(4, this.height) + f.a.a.b.b.a.bz(5, this.width);
      paramInt = i;
      if (this.HRN != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.HRN);
      }
      i = paramInt;
      if (this.HRO != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.HRO);
      }
      AppMethodBeat.o(168761);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(168761);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dka localdka = (dka)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(168761);
        return -1;
      case 1: 
        localdka.HRK = locala.OmT.zc();
        AppMethodBeat.o(168761);
        return 0;
      case 2: 
        localdka.HRL = locala.OmT.readString();
        AppMethodBeat.o(168761);
        return 0;
      case 3: 
        localdka.HRM = locala.OmT.readString();
        AppMethodBeat.o(168761);
        return 0;
      case 4: 
        localdka.height = locala.OmT.zc();
        AppMethodBeat.o(168761);
        return 0;
      case 5: 
        localdka.width = locala.OmT.zc();
        AppMethodBeat.o(168761);
        return 0;
      case 6: 
        localdka.HRN = locala.OmT.readString();
        AppMethodBeat.o(168761);
        return 0;
      }
      localdka.HRO = locala.OmT.readString();
      AppMethodBeat.o(168761);
      return 0;
    }
    AppMethodBeat.o(168761);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dka
 * JD-Core Version:    0.7.0.1
 */