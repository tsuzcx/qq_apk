package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aot
  extends com.tencent.mm.cd.a
{
  public int SBA;
  public String SBB;
  public int SBC;
  public long SBp;
  public long SBq;
  public long SBr;
  public String SBs;
  public long SBt;
  public String SBu;
  public String SBv;
  public String SBw;
  public String SBx;
  public String SBy;
  public String SBz;
  public String SiM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91460);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.SBp);
      paramVarArgs.bm(2, this.SBq);
      paramVarArgs.bm(3, this.SBr);
      if (this.SBs != null) {
        paramVarArgs.f(4, this.SBs);
      }
      paramVarArgs.bm(5, this.SBt);
      if (this.SBu != null) {
        paramVarArgs.f(6, this.SBu);
      }
      if (this.SBv != null) {
        paramVarArgs.f(7, this.SBv);
      }
      if (this.SBw != null) {
        paramVarArgs.f(8, this.SBw);
      }
      if (this.SBx != null) {
        paramVarArgs.f(9, this.SBx);
      }
      if (this.SBy != null) {
        paramVarArgs.f(10, this.SBy);
      }
      if (this.SBz != null) {
        paramVarArgs.f(11, this.SBz);
      }
      paramVarArgs.aY(12, this.SBA);
      if (this.SBB != null) {
        paramVarArgs.f(13, this.SBB);
      }
      paramVarArgs.aY(14, this.SBC);
      if (this.SiM != null) {
        paramVarArgs.f(15, this.SiM);
      }
      AppMethodBeat.o(91460);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.p(1, this.SBp) + 0 + g.a.a.b.b.a.p(2, this.SBq) + g.a.a.b.b.a.p(3, this.SBr);
      paramInt = i;
      if (this.SBs != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.SBs);
      }
      i = paramInt + g.a.a.b.b.a.p(5, this.SBt);
      paramInt = i;
      if (this.SBu != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.SBu);
      }
      i = paramInt;
      if (this.SBv != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.SBv);
      }
      paramInt = i;
      if (this.SBw != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.SBw);
      }
      i = paramInt;
      if (this.SBx != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.SBx);
      }
      paramInt = i;
      if (this.SBy != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.SBy);
      }
      i = paramInt;
      if (this.SBz != null) {
        i = paramInt + g.a.a.b.b.a.g(11, this.SBz);
      }
      i += g.a.a.b.b.a.bM(12, this.SBA);
      paramInt = i;
      if (this.SBB != null) {
        paramInt = i + g.a.a.b.b.a.g(13, this.SBB);
      }
      i = paramInt + g.a.a.b.b.a.bM(14, this.SBC);
      paramInt = i;
      if (this.SiM != null) {
        paramInt = i + g.a.a.b.b.a.g(15, this.SiM);
      }
      AppMethodBeat.o(91460);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(91460);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      aot localaot = (aot)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91460);
        return -1;
      case 1: 
        localaot.SBp = locala.abFh.AN();
        AppMethodBeat.o(91460);
        return 0;
      case 2: 
        localaot.SBq = locala.abFh.AN();
        AppMethodBeat.o(91460);
        return 0;
      case 3: 
        localaot.SBr = locala.abFh.AN();
        AppMethodBeat.o(91460);
        return 0;
      case 4: 
        localaot.SBs = locala.abFh.readString();
        AppMethodBeat.o(91460);
        return 0;
      case 5: 
        localaot.SBt = locala.abFh.AN();
        AppMethodBeat.o(91460);
        return 0;
      case 6: 
        localaot.SBu = locala.abFh.readString();
        AppMethodBeat.o(91460);
        return 0;
      case 7: 
        localaot.SBv = locala.abFh.readString();
        AppMethodBeat.o(91460);
        return 0;
      case 8: 
        localaot.SBw = locala.abFh.readString();
        AppMethodBeat.o(91460);
        return 0;
      case 9: 
        localaot.SBx = locala.abFh.readString();
        AppMethodBeat.o(91460);
        return 0;
      case 10: 
        localaot.SBy = locala.abFh.readString();
        AppMethodBeat.o(91460);
        return 0;
      case 11: 
        localaot.SBz = locala.abFh.readString();
        AppMethodBeat.o(91460);
        return 0;
      case 12: 
        localaot.SBA = locala.abFh.AK();
        AppMethodBeat.o(91460);
        return 0;
      case 13: 
        localaot.SBB = locala.abFh.readString();
        AppMethodBeat.o(91460);
        return 0;
      case 14: 
        localaot.SBC = locala.abFh.AK();
        AppMethodBeat.o(91460);
        return 0;
      }
      localaot.SiM = locala.abFh.readString();
      AppMethodBeat.o(91460);
      return 0;
    }
    AppMethodBeat.o(91460);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aot
 * JD-Core Version:    0.7.0.1
 */