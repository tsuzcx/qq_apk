package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class akz
  extends com.tencent.mm.bw.a
{
  public int LtB;
  public String LtC;
  public String LtD;
  public String LtP;
  public String LtQ;
  public int LtR;
  public int LtS;
  public String LtT;
  public String LtU;
  public String LtV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32206);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.LtB);
      if (this.LtC != null) {
        paramVarArgs.e(2, this.LtC);
      }
      if (this.LtP != null) {
        paramVarArgs.e(3, this.LtP);
      }
      if (this.LtQ != null) {
        paramVarArgs.e(4, this.LtQ);
      }
      paramVarArgs.aM(5, this.LtR);
      paramVarArgs.aM(6, this.LtS);
      if (this.LtT != null) {
        paramVarArgs.e(7, this.LtT);
      }
      if (this.LtD != null) {
        paramVarArgs.e(8, this.LtD);
      }
      if (this.LtU != null) {
        paramVarArgs.e(9, this.LtU);
      }
      if (this.LtV != null) {
        paramVarArgs.e(10, this.LtV);
      }
      AppMethodBeat.o(32206);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.LtB) + 0;
      paramInt = i;
      if (this.LtC != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.LtC);
      }
      i = paramInt;
      if (this.LtP != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.LtP);
      }
      paramInt = i;
      if (this.LtQ != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.LtQ);
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.LtR) + g.a.a.b.b.a.bu(6, this.LtS);
      paramInt = i;
      if (this.LtT != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.LtT);
      }
      i = paramInt;
      if (this.LtD != null) {
        i = paramInt + g.a.a.b.b.a.f(8, this.LtD);
      }
      paramInt = i;
      if (this.LtU != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.LtU);
      }
      i = paramInt;
      if (this.LtV != null) {
        i = paramInt + g.a.a.b.b.a.f(10, this.LtV);
      }
      AppMethodBeat.o(32206);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(32206);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      akz localakz = (akz)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32206);
        return -1;
      case 1: 
        localakz.LtB = locala.UbS.zi();
        AppMethodBeat.o(32206);
        return 0;
      case 2: 
        localakz.LtC = locala.UbS.readString();
        AppMethodBeat.o(32206);
        return 0;
      case 3: 
        localakz.LtP = locala.UbS.readString();
        AppMethodBeat.o(32206);
        return 0;
      case 4: 
        localakz.LtQ = locala.UbS.readString();
        AppMethodBeat.o(32206);
        return 0;
      case 5: 
        localakz.LtR = locala.UbS.zi();
        AppMethodBeat.o(32206);
        return 0;
      case 6: 
        localakz.LtS = locala.UbS.zi();
        AppMethodBeat.o(32206);
        return 0;
      case 7: 
        localakz.LtT = locala.UbS.readString();
        AppMethodBeat.o(32206);
        return 0;
      case 8: 
        localakz.LtD = locala.UbS.readString();
        AppMethodBeat.o(32206);
        return 0;
      case 9: 
        localakz.LtU = locala.UbS.readString();
        AppMethodBeat.o(32206);
        return 0;
      }
      localakz.LtV = locala.UbS.readString();
      AppMethodBeat.o(32206);
      return 0;
    }
    AppMethodBeat.o(32206);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.akz
 * JD-Core Version:    0.7.0.1
 */