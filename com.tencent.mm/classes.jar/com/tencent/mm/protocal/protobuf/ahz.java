package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ahz
  extends com.tencent.mm.bx.a
{
  public int DkA;
  public int DkB;
  public int DkC;
  public String country;
  public String evA;
  public int evp;
  public String evz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168946);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.country != null) {
        paramVarArgs.d(1, this.country);
      }
      if (this.evz != null) {
        paramVarArgs.d(2, this.evz);
      }
      if (this.evA != null) {
        paramVarArgs.d(3, this.evA);
      }
      paramVarArgs.aR(4, this.evp);
      paramVarArgs.aR(5, this.DkA);
      paramVarArgs.aR(6, this.DkB);
      paramVarArgs.aR(7, this.DkC);
      AppMethodBeat.o(168946);
      return 0;
    }
    if (paramInt == 1) {
      if (this.country == null) {
        break label522;
      }
    }
    label522:
    for (int i = f.a.a.b.b.a.e(1, this.country) + 0;; i = 0)
    {
      paramInt = i;
      if (this.evz != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.evz);
      }
      i = paramInt;
      if (this.evA != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.evA);
      }
      paramInt = f.a.a.b.b.a.bA(4, this.evp);
      int j = f.a.a.b.b.a.bA(5, this.DkA);
      int k = f.a.a.b.b.a.bA(6, this.DkB);
      int m = f.a.a.b.b.a.bA(7, this.DkC);
      AppMethodBeat.o(168946);
      return i + paramInt + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(168946);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ahz localahz = (ahz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(168946);
          return -1;
        case 1: 
          localahz.country = locala.KhF.readString();
          AppMethodBeat.o(168946);
          return 0;
        case 2: 
          localahz.evz = locala.KhF.readString();
          AppMethodBeat.o(168946);
          return 0;
        case 3: 
          localahz.evA = locala.KhF.readString();
          AppMethodBeat.o(168946);
          return 0;
        case 4: 
          localahz.evp = locala.KhF.xS();
          AppMethodBeat.o(168946);
          return 0;
        case 5: 
          localahz.DkA = locala.KhF.xS();
          AppMethodBeat.o(168946);
          return 0;
        case 6: 
          localahz.DkB = locala.KhF.xS();
          AppMethodBeat.o(168946);
          return 0;
        }
        localahz.DkC = locala.KhF.xS();
        AppMethodBeat.o(168946);
        return 0;
      }
      AppMethodBeat.o(168946);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ahz
 * JD-Core Version:    0.7.0.1
 */