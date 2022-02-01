package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class emb
  extends com.tencent.mm.cd.a
{
  public int SmH;
  public int Svu;
  public int Uon;
  public int Uoo;
  public int Uop;
  public int Uoq;
  public int Uor;
  public LinkedList<Integer> Uos;
  public int Uot;
  public int Uou;
  public LinkedList<Integer> Uov;
  public int Uow;
  public int Uox;
  
  public emb()
  {
    AppMethodBeat.i(115853);
    this.Uos = new LinkedList();
    this.Uov = new LinkedList();
    AppMethodBeat.o(115853);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115854);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.Svu);
      paramVarArgs.aY(2, this.Uon);
      paramVarArgs.aY(3, this.SmH);
      paramVarArgs.aY(4, this.Uoo);
      paramVarArgs.aY(5, this.Uop);
      paramVarArgs.aY(6, this.Uoq);
      paramVarArgs.aY(7, this.Uor);
      paramVarArgs.e(8, 2, this.Uos);
      paramVarArgs.aY(9, this.Uot);
      paramVarArgs.aY(10, this.Uou);
      paramVarArgs.e(11, 2, this.Uov);
      paramVarArgs.aY(12, this.Uow);
      paramVarArgs.aY(13, this.Uox);
      AppMethodBeat.o(115854);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(1, this.Svu);
      int i = g.a.a.b.b.a.bM(2, this.Uon);
      int j = g.a.a.b.b.a.bM(3, this.SmH);
      int k = g.a.a.b.b.a.bM(4, this.Uoo);
      int m = g.a.a.b.b.a.bM(5, this.Uop);
      int n = g.a.a.b.b.a.bM(6, this.Uoq);
      int i1 = g.a.a.b.b.a.bM(7, this.Uor);
      int i2 = g.a.a.a.c(8, 2, this.Uos);
      int i3 = g.a.a.b.b.a.bM(9, this.Uot);
      int i4 = g.a.a.b.b.a.bM(10, this.Uou);
      int i5 = g.a.a.a.c(11, 2, this.Uov);
      int i6 = g.a.a.b.b.a.bM(12, this.Uow);
      int i7 = g.a.a.b.b.a.bM(13, this.Uox);
      AppMethodBeat.o(115854);
      return paramInt + 0 + i + j + k + m + n + i1 + i2 + i3 + i4 + i5 + i6 + i7;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Uos.clear();
      this.Uov.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(115854);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      emb localemb = (emb)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(115854);
        return -1;
      case 1: 
        localemb.Svu = locala.abFh.AK();
        AppMethodBeat.o(115854);
        return 0;
      case 2: 
        localemb.Uon = locala.abFh.AK();
        AppMethodBeat.o(115854);
        return 0;
      case 3: 
        localemb.SmH = locala.abFh.AK();
        AppMethodBeat.o(115854);
        return 0;
      case 4: 
        localemb.Uoo = locala.abFh.AK();
        AppMethodBeat.o(115854);
        return 0;
      case 5: 
        localemb.Uop = locala.abFh.AK();
        AppMethodBeat.o(115854);
        return 0;
      case 6: 
        localemb.Uoq = locala.abFh.AK();
        AppMethodBeat.o(115854);
        return 0;
      case 7: 
        localemb.Uor = locala.abFh.AK();
        AppMethodBeat.o(115854);
        return 0;
      case 8: 
        localemb.Uos.add(Integer.valueOf(locala.abFh.AK()));
        AppMethodBeat.o(115854);
        return 0;
      case 9: 
        localemb.Uot = locala.abFh.AK();
        AppMethodBeat.o(115854);
        return 0;
      case 10: 
        localemb.Uou = locala.abFh.AK();
        AppMethodBeat.o(115854);
        return 0;
      case 11: 
        localemb.Uov.add(Integer.valueOf(locala.abFh.AK()));
        AppMethodBeat.o(115854);
        return 0;
      case 12: 
        localemb.Uow = locala.abFh.AK();
        AppMethodBeat.o(115854);
        return 0;
      }
      localemb.Uox = locala.abFh.AK();
      AppMethodBeat.o(115854);
      return 0;
    }
    AppMethodBeat.o(115854);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.emb
 * JD-Core Version:    0.7.0.1
 */