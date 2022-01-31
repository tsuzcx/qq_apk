package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cuw
  extends com.tencent.mm.bv.a
{
  public String ProductID;
  public String Title;
  public String xBK;
  public int ydA;
  public String ydB;
  public String ydC;
  public String ydD;
  public String ydE;
  public String ydF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28705);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.Title != null) {
        paramVarArgs.e(1, this.Title);
      }
      if (this.ProductID != null) {
        paramVarArgs.e(2, this.ProductID);
      }
      paramVarArgs.aO(3, this.ydA);
      if (this.ydB != null) {
        paramVarArgs.e(4, this.ydB);
      }
      if (this.xBK != null) {
        paramVarArgs.e(5, this.xBK);
      }
      if (this.ydC != null) {
        paramVarArgs.e(6, this.ydC);
      }
      if (this.ydD != null) {
        paramVarArgs.e(7, this.ydD);
      }
      if (this.ydE != null) {
        paramVarArgs.e(8, this.ydE);
      }
      if (this.ydF != null) {
        paramVarArgs.e(9, this.ydF);
      }
      AppMethodBeat.o(28705);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label701;
      }
    }
    label701:
    for (paramInt = e.a.a.b.b.a.f(1, this.Title) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ProductID != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.ProductID);
      }
      i += e.a.a.b.b.a.bl(3, this.ydA);
      paramInt = i;
      if (this.ydB != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.ydB);
      }
      i = paramInt;
      if (this.xBK != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.xBK);
      }
      paramInt = i;
      if (this.ydC != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.ydC);
      }
      i = paramInt;
      if (this.ydD != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.ydD);
      }
      paramInt = i;
      if (this.ydE != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.ydE);
      }
      i = paramInt;
      if (this.ydF != null) {
        i = paramInt + e.a.a.b.b.a.f(9, this.ydF);
      }
      AppMethodBeat.o(28705);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(28705);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        cuw localcuw = (cuw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(28705);
          return -1;
        case 1: 
          localcuw.Title = locala.CLY.readString();
          AppMethodBeat.o(28705);
          return 0;
        case 2: 
          localcuw.ProductID = locala.CLY.readString();
          AppMethodBeat.o(28705);
          return 0;
        case 3: 
          localcuw.ydA = locala.CLY.sl();
          AppMethodBeat.o(28705);
          return 0;
        case 4: 
          localcuw.ydB = locala.CLY.readString();
          AppMethodBeat.o(28705);
          return 0;
        case 5: 
          localcuw.xBK = locala.CLY.readString();
          AppMethodBeat.o(28705);
          return 0;
        case 6: 
          localcuw.ydC = locala.CLY.readString();
          AppMethodBeat.o(28705);
          return 0;
        case 7: 
          localcuw.ydD = locala.CLY.readString();
          AppMethodBeat.o(28705);
          return 0;
        case 8: 
          localcuw.ydE = locala.CLY.readString();
          AppMethodBeat.o(28705);
          return 0;
        }
        localcuw.ydF = locala.CLY.readString();
        AppMethodBeat.o(28705);
        return 0;
      }
      AppMethodBeat.o(28705);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cuw
 * JD-Core Version:    0.7.0.1
 */