package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class box
  extends com.tencent.mm.bx.a
{
  public String FXa;
  public String GJI;
  public String GJJ;
  public String GJK;
  public String GJL;
  public int GJM;
  public String GJN;
  public String Title;
  public String Url;
  public int nEf;
  public String uiR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32327);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Title != null) {
        paramVarArgs.d(1, this.Title);
      }
      if (this.GJI != null) {
        paramVarArgs.d(2, this.GJI);
      }
      paramVarArgs.aS(3, this.nEf);
      if (this.Url != null) {
        paramVarArgs.d(4, this.Url);
      }
      if (this.GJJ != null) {
        paramVarArgs.d(5, this.GJJ);
      }
      if (this.FXa != null) {
        paramVarArgs.d(6, this.FXa);
      }
      if (this.GJK != null) {
        paramVarArgs.d(7, this.GJK);
      }
      if (this.uiR != null) {
        paramVarArgs.d(8, this.uiR);
      }
      if (this.GJL != null) {
        paramVarArgs.d(9, this.GJL);
      }
      paramVarArgs.aS(10, this.GJM);
      if (this.GJN != null) {
        paramVarArgs.d(11, this.GJN);
      }
      AppMethodBeat.o(32327);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label811;
      }
    }
    label811:
    for (paramInt = f.a.a.b.b.a.e(1, this.Title) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.GJI != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.GJI);
      }
      i += f.a.a.b.b.a.bz(3, this.nEf);
      paramInt = i;
      if (this.Url != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Url);
      }
      i = paramInt;
      if (this.GJJ != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.GJJ);
      }
      paramInt = i;
      if (this.FXa != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FXa);
      }
      i = paramInt;
      if (this.GJK != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.GJK);
      }
      paramInt = i;
      if (this.uiR != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.uiR);
      }
      i = paramInt;
      if (this.GJL != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.GJL);
      }
      i += f.a.a.b.b.a.bz(10, this.GJM);
      paramInt = i;
      if (this.GJN != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.GJN);
      }
      AppMethodBeat.o(32327);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(32327);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        box localbox = (box)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32327);
          return -1;
        case 1: 
          localbox.Title = locala.NPN.readString();
          AppMethodBeat.o(32327);
          return 0;
        case 2: 
          localbox.GJI = locala.NPN.readString();
          AppMethodBeat.o(32327);
          return 0;
        case 3: 
          localbox.nEf = locala.NPN.zc();
          AppMethodBeat.o(32327);
          return 0;
        case 4: 
          localbox.Url = locala.NPN.readString();
          AppMethodBeat.o(32327);
          return 0;
        case 5: 
          localbox.GJJ = locala.NPN.readString();
          AppMethodBeat.o(32327);
          return 0;
        case 6: 
          localbox.FXa = locala.NPN.readString();
          AppMethodBeat.o(32327);
          return 0;
        case 7: 
          localbox.GJK = locala.NPN.readString();
          AppMethodBeat.o(32327);
          return 0;
        case 8: 
          localbox.uiR = locala.NPN.readString();
          AppMethodBeat.o(32327);
          return 0;
        case 9: 
          localbox.GJL = locala.NPN.readString();
          AppMethodBeat.o(32327);
          return 0;
        case 10: 
          localbox.GJM = locala.NPN.zc();
          AppMethodBeat.o(32327);
          return 0;
        }
        localbox.GJN = locala.NPN.readString();
        AppMethodBeat.o(32327);
        return 0;
      }
      AppMethodBeat.o(32327);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.box
 * JD-Core Version:    0.7.0.1
 */