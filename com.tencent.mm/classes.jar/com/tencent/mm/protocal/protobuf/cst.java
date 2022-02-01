package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class cst
  extends com.tencent.mm.bw.a
{
  public int MxI;
  public String MxJ;
  public int MxN;
  public int MxP;
  public String Uuc;
  public int Uud;
  public long Uue;
  public long Uuf;
  public long Uug;
  public int Uuh;
  public String sGQ;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(219129);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.scene);
      if (this.sGQ != null) {
        paramVarArgs.e(2, this.sGQ);
      }
      paramVarArgs.aM(3, this.MxI);
      if (this.MxJ != null) {
        paramVarArgs.e(4, this.MxJ);
      }
      paramVarArgs.aM(5, this.MxN);
      if (this.Uuc != null) {
        paramVarArgs.e(6, this.Uuc);
      }
      paramVarArgs.aM(7, this.MxP);
      paramVarArgs.aM(8, this.Uud);
      paramVarArgs.bb(9, this.Uue);
      paramVarArgs.bb(10, this.Uuf);
      paramVarArgs.bb(11, this.Uug);
      paramVarArgs.aM(12, this.Uuh);
      AppMethodBeat.o(219129);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.scene) + 0;
      paramInt = i;
      if (this.sGQ != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.sGQ);
      }
      i = paramInt + g.a.a.b.b.a.bu(3, this.MxI);
      paramInt = i;
      if (this.MxJ != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.MxJ);
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.MxN);
      paramInt = i;
      if (this.Uuc != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.Uuc);
      }
      i = g.a.a.b.b.a.bu(7, this.MxP);
      int j = g.a.a.b.b.a.bu(8, this.Uud);
      int k = g.a.a.b.b.a.r(9, this.Uue);
      int m = g.a.a.b.b.a.r(10, this.Uuf);
      int n = g.a.a.b.b.a.r(11, this.Uug);
      int i1 = g.a.a.b.b.a.bu(12, this.Uuh);
      AppMethodBeat.o(219129);
      return paramInt + i + j + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(219129);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      cst localcst = (cst)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(219129);
        return -1;
      case 1: 
        localcst.scene = locala.UbS.zi();
        AppMethodBeat.o(219129);
        return 0;
      case 2: 
        localcst.sGQ = locala.UbS.readString();
        AppMethodBeat.o(219129);
        return 0;
      case 3: 
        localcst.MxI = locala.UbS.zi();
        AppMethodBeat.o(219129);
        return 0;
      case 4: 
        localcst.MxJ = locala.UbS.readString();
        AppMethodBeat.o(219129);
        return 0;
      case 5: 
        localcst.MxN = locala.UbS.zi();
        AppMethodBeat.o(219129);
        return 0;
      case 6: 
        localcst.Uuc = locala.UbS.readString();
        AppMethodBeat.o(219129);
        return 0;
      case 7: 
        localcst.MxP = locala.UbS.zi();
        AppMethodBeat.o(219129);
        return 0;
      case 8: 
        localcst.Uud = locala.UbS.zi();
        AppMethodBeat.o(219129);
        return 0;
      case 9: 
        localcst.Uue = locala.UbS.zl();
        AppMethodBeat.o(219129);
        return 0;
      case 10: 
        localcst.Uuf = locala.UbS.zl();
        AppMethodBeat.o(219129);
        return 0;
      case 11: 
        localcst.Uug = locala.UbS.zl();
        AppMethodBeat.o(219129);
        return 0;
      }
      localcst.Uuh = locala.UbS.zi();
      AppMethodBeat.o(219129);
      return 0;
    }
    AppMethodBeat.o(219129);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cst
 * JD-Core Version:    0.7.0.1
 */