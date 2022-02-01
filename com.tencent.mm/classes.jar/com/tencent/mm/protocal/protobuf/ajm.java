package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ajm
  extends com.tencent.mm.bx.a
{
  public String FGh;
  public String FOH;
  public int FOI;
  public String FVK;
  public String FVL;
  public String FVM;
  public int FVN;
  public String GgI;
  public int GgJ;
  public int nDG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127456);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FVK != null) {
        paramVarArgs.d(1, this.FVK);
      }
      if (this.FVL != null) {
        paramVarArgs.d(2, this.FVL);
      }
      if (this.FVM != null) {
        paramVarArgs.d(3, this.FVM);
      }
      paramVarArgs.aS(4, this.FVN);
      if (this.GgI != null) {
        paramVarArgs.d(5, this.GgI);
      }
      if (this.FOH != null) {
        paramVarArgs.d(6, this.FOH);
      }
      paramVarArgs.aS(7, this.FOI);
      if (this.FGh != null) {
        paramVarArgs.d(8, this.FGh);
      }
      paramVarArgs.aS(9, this.nDG);
      paramVarArgs.aS(10, this.GgJ);
      AppMethodBeat.o(127456);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FVK == null) {
        break label702;
      }
    }
    label702:
    for (int i = f.a.a.b.b.a.e(1, this.FVK) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FVL != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FVL);
      }
      i = paramInt;
      if (this.FVM != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FVM);
      }
      i += f.a.a.b.b.a.bz(4, this.FVN);
      paramInt = i;
      if (this.GgI != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.GgI);
      }
      i = paramInt;
      if (this.FOH != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.FOH);
      }
      i += f.a.a.b.b.a.bz(7, this.FOI);
      paramInt = i;
      if (this.FGh != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.FGh);
      }
      i = f.a.a.b.b.a.bz(9, this.nDG);
      int j = f.a.a.b.b.a.bz(10, this.GgJ);
      AppMethodBeat.o(127456);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(127456);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ajm localajm = (ajm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127456);
          return -1;
        case 1: 
          localajm.FVK = locala.NPN.readString();
          AppMethodBeat.o(127456);
          return 0;
        case 2: 
          localajm.FVL = locala.NPN.readString();
          AppMethodBeat.o(127456);
          return 0;
        case 3: 
          localajm.FVM = locala.NPN.readString();
          AppMethodBeat.o(127456);
          return 0;
        case 4: 
          localajm.FVN = locala.NPN.zc();
          AppMethodBeat.o(127456);
          return 0;
        case 5: 
          localajm.GgI = locala.NPN.readString();
          AppMethodBeat.o(127456);
          return 0;
        case 6: 
          localajm.FOH = locala.NPN.readString();
          AppMethodBeat.o(127456);
          return 0;
        case 7: 
          localajm.FOI = locala.NPN.zc();
          AppMethodBeat.o(127456);
          return 0;
        case 8: 
          localajm.FGh = locala.NPN.readString();
          AppMethodBeat.o(127456);
          return 0;
        case 9: 
          localajm.nDG = locala.NPN.zc();
          AppMethodBeat.o(127456);
          return 0;
        }
        localajm.GgJ = locala.NPN.zc();
        AppMethodBeat.o(127456);
        return 0;
      }
      AppMethodBeat.o(127456);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ajm
 * JD-Core Version:    0.7.0.1
 */