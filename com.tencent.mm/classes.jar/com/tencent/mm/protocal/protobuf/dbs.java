package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class dbs
  extends com.tencent.mm.cd.a
{
  public String AtM;
  public int TIZ;
  public String TJa;
  public int TJb;
  public int TJc;
  public int TJd;
  public long TJe;
  public long TJf;
  public long TJg;
  public int TJh;
  public int TJi;
  public int TJj;
  public int TJk;
  public long TJl;
  public int TJm;
  public int TJn;
  public int TJo;
  public int scene;
  public String wmL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(197901);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.scene);
      if (this.wmL != null) {
        paramVarArgs.f(2, this.wmL);
      }
      paramVarArgs.aY(3, this.TIZ);
      if (this.TJa != null) {
        paramVarArgs.f(4, this.TJa);
      }
      paramVarArgs.aY(5, this.TJb);
      if (this.AtM != null) {
        paramVarArgs.f(6, this.AtM);
      }
      paramVarArgs.aY(7, this.TJc);
      paramVarArgs.aY(8, this.TJd);
      paramVarArgs.bm(9, this.TJe);
      paramVarArgs.bm(10, this.TJf);
      paramVarArgs.bm(11, this.TJg);
      paramVarArgs.aY(12, this.TJh);
      paramVarArgs.aY(13, this.TJi);
      paramVarArgs.aY(14, this.TJj);
      paramVarArgs.aY(15, this.TJk);
      paramVarArgs.bm(16, this.TJl);
      paramVarArgs.aY(17, this.TJm);
      paramVarArgs.aY(18, this.TJn);
      paramVarArgs.aY(19, this.TJo);
      AppMethodBeat.o(197901);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.scene) + 0;
      paramInt = i;
      if (this.wmL != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.wmL);
      }
      i = paramInt + g.a.a.b.b.a.bM(3, this.TIZ);
      paramInt = i;
      if (this.TJa != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.TJa);
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.TJb);
      paramInt = i;
      if (this.AtM != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.AtM);
      }
      i = g.a.a.b.b.a.bM(7, this.TJc);
      int j = g.a.a.b.b.a.bM(8, this.TJd);
      int k = g.a.a.b.b.a.p(9, this.TJe);
      int m = g.a.a.b.b.a.p(10, this.TJf);
      int n = g.a.a.b.b.a.p(11, this.TJg);
      int i1 = g.a.a.b.b.a.bM(12, this.TJh);
      int i2 = g.a.a.b.b.a.bM(13, this.TJi);
      int i3 = g.a.a.b.b.a.bM(14, this.TJj);
      int i4 = g.a.a.b.b.a.bM(15, this.TJk);
      int i5 = g.a.a.b.b.a.p(16, this.TJl);
      int i6 = g.a.a.b.b.a.bM(17, this.TJm);
      int i7 = g.a.a.b.b.a.bM(18, this.TJn);
      int i8 = g.a.a.b.b.a.bM(19, this.TJo);
      AppMethodBeat.o(197901);
      return paramInt + i + j + k + m + n + i1 + i2 + i3 + i4 + i5 + i6 + i7 + i8;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(197901);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      dbs localdbs = (dbs)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(197901);
        return -1;
      case 1: 
        localdbs.scene = locala.abFh.AK();
        AppMethodBeat.o(197901);
        return 0;
      case 2: 
        localdbs.wmL = locala.abFh.readString();
        AppMethodBeat.o(197901);
        return 0;
      case 3: 
        localdbs.TIZ = locala.abFh.AK();
        AppMethodBeat.o(197901);
        return 0;
      case 4: 
        localdbs.TJa = locala.abFh.readString();
        AppMethodBeat.o(197901);
        return 0;
      case 5: 
        localdbs.TJb = locala.abFh.AK();
        AppMethodBeat.o(197901);
        return 0;
      case 6: 
        localdbs.AtM = locala.abFh.readString();
        AppMethodBeat.o(197901);
        return 0;
      case 7: 
        localdbs.TJc = locala.abFh.AK();
        AppMethodBeat.o(197901);
        return 0;
      case 8: 
        localdbs.TJd = locala.abFh.AK();
        AppMethodBeat.o(197901);
        return 0;
      case 9: 
        localdbs.TJe = locala.abFh.AN();
        AppMethodBeat.o(197901);
        return 0;
      case 10: 
        localdbs.TJf = locala.abFh.AN();
        AppMethodBeat.o(197901);
        return 0;
      case 11: 
        localdbs.TJg = locala.abFh.AN();
        AppMethodBeat.o(197901);
        return 0;
      case 12: 
        localdbs.TJh = locala.abFh.AK();
        AppMethodBeat.o(197901);
        return 0;
      case 13: 
        localdbs.TJi = locala.abFh.AK();
        AppMethodBeat.o(197901);
        return 0;
      case 14: 
        localdbs.TJj = locala.abFh.AK();
        AppMethodBeat.o(197901);
        return 0;
      case 15: 
        localdbs.TJk = locala.abFh.AK();
        AppMethodBeat.o(197901);
        return 0;
      case 16: 
        localdbs.TJl = locala.abFh.AN();
        AppMethodBeat.o(197901);
        return 0;
      case 17: 
        localdbs.TJm = locala.abFh.AK();
        AppMethodBeat.o(197901);
        return 0;
      case 18: 
        localdbs.TJn = locala.abFh.AK();
        AppMethodBeat.o(197901);
        return 0;
      }
      localdbs.TJo = locala.abFh.AK();
      AppMethodBeat.o(197901);
      return 0;
    }
    AppMethodBeat.o(197901);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbs
 * JD-Core Version:    0.7.0.1
 */