package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class gaw
  extends com.tencent.mm.bx.a
{
  public String abYA;
  public int abYk;
  public int abYl;
  public int abYm;
  public int abYn;
  public int abYo;
  public int abYp;
  public int abYq;
  public int abYr;
  public int abYs;
  public int abYt;
  public LinkedList<Integer> abYu;
  public int abYv;
  public LinkedList<Integer> abYw;
  public int abYx;
  public LinkedList<Integer> abYy;
  public String abYz;
  
  public gaw()
  {
    AppMethodBeat.i(115892);
    this.abYu = new LinkedList();
    this.abYw = new LinkedList();
    this.abYy = new LinkedList();
    AppMethodBeat.o(115892);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115893);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.abYk);
      paramVarArgs.bS(2, this.abYl);
      paramVarArgs.bS(3, this.abYm);
      paramVarArgs.bS(4, this.abYn);
      paramVarArgs.bS(5, this.abYo);
      paramVarArgs.bS(6, this.abYp);
      paramVarArgs.bS(7, this.abYq);
      paramVarArgs.bS(8, this.abYr);
      paramVarArgs.bS(9, this.abYs);
      paramVarArgs.bS(10, this.abYt);
      paramVarArgs.e(11, 2, this.abYu);
      paramVarArgs.bS(12, this.abYv);
      paramVarArgs.e(13, 2, this.abYw);
      paramVarArgs.bS(14, this.abYx);
      paramVarArgs.e(15, 2, this.abYy);
      if (this.abYz != null) {
        paramVarArgs.g(16, this.abYz);
      }
      if (this.abYA != null) {
        paramVarArgs.g(17, this.abYA);
      }
      AppMethodBeat.o(115893);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.abYk) + 0 + i.a.a.b.b.a.cJ(2, this.abYl) + i.a.a.b.b.a.cJ(3, this.abYm) + i.a.a.b.b.a.cJ(4, this.abYn) + i.a.a.b.b.a.cJ(5, this.abYo) + i.a.a.b.b.a.cJ(6, this.abYp) + i.a.a.b.b.a.cJ(7, this.abYq) + i.a.a.b.b.a.cJ(8, this.abYr) + i.a.a.b.b.a.cJ(9, this.abYs) + i.a.a.b.b.a.cJ(10, this.abYt) + i.a.a.a.c(11, 2, this.abYu) + i.a.a.b.b.a.cJ(12, this.abYv) + i.a.a.a.c(13, 2, this.abYw) + i.a.a.b.b.a.cJ(14, this.abYx) + i.a.a.a.c(15, 2, this.abYy);
      paramInt = i;
      if (this.abYz != null) {
        paramInt = i + i.a.a.b.b.a.h(16, this.abYz);
      }
      i = paramInt;
      if (this.abYA != null) {
        i = paramInt + i.a.a.b.b.a.h(17, this.abYA);
      }
      AppMethodBeat.o(115893);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.abYu.clear();
      this.abYw.clear();
      this.abYy.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(115893);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      gaw localgaw = (gaw)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(115893);
        return -1;
      case 1: 
        localgaw.abYk = locala.ajGk.aar();
        AppMethodBeat.o(115893);
        return 0;
      case 2: 
        localgaw.abYl = locala.ajGk.aar();
        AppMethodBeat.o(115893);
        return 0;
      case 3: 
        localgaw.abYm = locala.ajGk.aar();
        AppMethodBeat.o(115893);
        return 0;
      case 4: 
        localgaw.abYn = locala.ajGk.aar();
        AppMethodBeat.o(115893);
        return 0;
      case 5: 
        localgaw.abYo = locala.ajGk.aar();
        AppMethodBeat.o(115893);
        return 0;
      case 6: 
        localgaw.abYp = locala.ajGk.aar();
        AppMethodBeat.o(115893);
        return 0;
      case 7: 
        localgaw.abYq = locala.ajGk.aar();
        AppMethodBeat.o(115893);
        return 0;
      case 8: 
        localgaw.abYr = locala.ajGk.aar();
        AppMethodBeat.o(115893);
        return 0;
      case 9: 
        localgaw.abYs = locala.ajGk.aar();
        AppMethodBeat.o(115893);
        return 0;
      case 10: 
        localgaw.abYt = locala.ajGk.aar();
        AppMethodBeat.o(115893);
        return 0;
      case 11: 
        localgaw.abYu.add(Integer.valueOf(locala.ajGk.aar()));
        AppMethodBeat.o(115893);
        return 0;
      case 12: 
        localgaw.abYv = locala.ajGk.aar();
        AppMethodBeat.o(115893);
        return 0;
      case 13: 
        localgaw.abYw.add(Integer.valueOf(locala.ajGk.aar()));
        AppMethodBeat.o(115893);
        return 0;
      case 14: 
        localgaw.abYx = locala.ajGk.aar();
        AppMethodBeat.o(115893);
        return 0;
      case 15: 
        localgaw.abYy.add(Integer.valueOf(locala.ajGk.aar()));
        AppMethodBeat.o(115893);
        return 0;
      case 16: 
        localgaw.abYz = locala.ajGk.readString();
        AppMethodBeat.o(115893);
        return 0;
      }
      localgaw.abYA = locala.ajGk.readString();
      AppMethodBeat.o(115893);
      return 0;
    }
    AppMethodBeat.o(115893);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gaw
 * JD-Core Version:    0.7.0.1
 */