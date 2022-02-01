package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dhy
  extends com.tencent.mm.cd.a
{
  public LinkedList<Long> TPe;
  public int aNf;
  public String extraInfo;
  public String fFe;
  public int fSe;
  public String sessionId;
  public String wmA;
  public String wmC;
  public long wmw;
  public long wmx;
  public long wmy;
  public String wmz;
  
  public dhy()
  {
    AppMethodBeat.i(252753);
    this.aNf = 0;
    this.wmw = 0L;
    this.wmx = 0L;
    this.wmy = 0L;
    this.fSe = 0;
    this.TPe = new LinkedList();
    AppMethodBeat.o(252753);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(252755);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.sessionId != null) {
        paramVarArgs.f(1, this.sessionId);
      }
      if (this.fFe != null) {
        paramVarArgs.f(2, this.fFe);
      }
      paramVarArgs.aY(3, this.aNf);
      paramVarArgs.bm(4, this.wmw);
      paramVarArgs.bm(5, this.wmx);
      paramVarArgs.bm(6, this.wmy);
      if (this.wmz != null) {
        paramVarArgs.f(7, this.wmz);
      }
      if (this.wmA != null) {
        paramVarArgs.f(8, this.wmA);
      }
      paramVarArgs.aY(9, this.fSe);
      paramVarArgs.e(10, 3, this.TPe);
      if (this.extraInfo != null) {
        paramVarArgs.f(11, this.extraInfo);
      }
      if (this.wmC != null) {
        paramVarArgs.f(12, this.wmC);
      }
      AppMethodBeat.o(252755);
      return 0;
    }
    if (paramInt == 1) {
      if (this.sessionId == null) {
        break label801;
      }
    }
    label801:
    for (paramInt = g.a.a.b.b.a.g(1, this.sessionId) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.fFe != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.fFe);
      }
      i = i + g.a.a.b.b.a.bM(3, this.aNf) + g.a.a.b.b.a.p(4, this.wmw) + g.a.a.b.b.a.p(5, this.wmx) + g.a.a.b.b.a.p(6, this.wmy);
      paramInt = i;
      if (this.wmz != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.wmz);
      }
      i = paramInt;
      if (this.wmA != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.wmA);
      }
      i = i + g.a.a.b.b.a.bM(9, this.fSe) + g.a.a.a.c(10, 3, this.TPe);
      paramInt = i;
      if (this.extraInfo != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.extraInfo);
      }
      i = paramInt;
      if (this.wmC != null) {
        i = paramInt + g.a.a.b.b.a.g(12, this.wmC);
      }
      AppMethodBeat.o(252755);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.TPe.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(252755);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dhy localdhy = (dhy)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(252755);
          return -1;
        case 1: 
          localdhy.sessionId = locala.abFh.readString();
          AppMethodBeat.o(252755);
          return 0;
        case 2: 
          localdhy.fFe = locala.abFh.readString();
          AppMethodBeat.o(252755);
          return 0;
        case 3: 
          localdhy.aNf = locala.abFh.AK();
          AppMethodBeat.o(252755);
          return 0;
        case 4: 
          localdhy.wmw = locala.abFh.AN();
          AppMethodBeat.o(252755);
          return 0;
        case 5: 
          localdhy.wmx = locala.abFh.AN();
          AppMethodBeat.o(252755);
          return 0;
        case 6: 
          localdhy.wmy = locala.abFh.AN();
          AppMethodBeat.o(252755);
          return 0;
        case 7: 
          localdhy.wmz = locala.abFh.readString();
          AppMethodBeat.o(252755);
          return 0;
        case 8: 
          localdhy.wmA = locala.abFh.readString();
          AppMethodBeat.o(252755);
          return 0;
        case 9: 
          localdhy.fSe = locala.abFh.AK();
          AppMethodBeat.o(252755);
          return 0;
        case 10: 
          localdhy.TPe.add(Long.valueOf(locala.abFh.AN()));
          AppMethodBeat.o(252755);
          return 0;
        case 11: 
          localdhy.extraInfo = locala.abFh.readString();
          AppMethodBeat.o(252755);
          return 0;
        }
        localdhy.wmC = locala.abFh.readString();
        AppMethodBeat.o(252755);
        return 0;
      }
      AppMethodBeat.o(252755);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dhy
 * JD-Core Version:    0.7.0.1
 */