package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public class dny
  extends com.tencent.mm.cd.a
{
  public int TVf;
  public boolean TVg;
  public boolean TVh;
  public boolean TVi;
  public boolean TVj;
  public boolean TVk;
  public boolean TVl;
  public int id;
  public String ktM = "";
  public int llp;
  public boolean sMn;
  public int sNh;
  public int svv;
  public String url;
  public int wGA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(205127);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.url == null)
      {
        paramVarArgs = new b("Not all required fields were included: url");
        AppMethodBeat.o(205127);
        throw paramVarArgs;
      }
      if (this.ktM == null)
      {
        paramVarArgs = new b("Not all required fields were included: uid");
        AppMethodBeat.o(205127);
        throw paramVarArgs;
      }
      paramVarArgs.aY(1, this.id);
      if (this.url != null) {
        paramVarArgs.f(2, this.url);
      }
      paramVarArgs.aY(3, this.llp);
      paramVarArgs.aY(4, this.sNh);
      paramVarArgs.aY(5, this.svv);
      paramVarArgs.aY(6, this.wGA);
      paramVarArgs.aY(7, this.TVf);
      if (this.ktM != null) {
        paramVarArgs.f(8, this.ktM);
      }
      paramVarArgs.co(9, this.TVg);
      paramVarArgs.co(10, this.TVh);
      paramVarArgs.co(11, this.TVi);
      paramVarArgs.co(12, this.TVj);
      paramVarArgs.co(13, this.TVk);
      paramVarArgs.co(14, this.sMn);
      paramVarArgs.co(15, this.TVl);
      AppMethodBeat.o(205127);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.id) + 0;
      paramInt = i;
      if (this.url != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.url);
      }
      i = paramInt + g.a.a.b.b.a.bM(3, this.llp) + g.a.a.b.b.a.bM(4, this.sNh) + g.a.a.b.b.a.bM(5, this.svv) + g.a.a.b.b.a.bM(6, this.wGA) + g.a.a.b.b.a.bM(7, this.TVf);
      paramInt = i;
      if (this.ktM != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.ktM);
      }
      i = g.a.a.b.b.a.gL(9);
      int j = g.a.a.b.b.a.gL(10);
      int k = g.a.a.b.b.a.gL(11);
      int m = g.a.a.b.b.a.gL(12);
      int n = g.a.a.b.b.a.gL(13);
      int i1 = g.a.a.b.b.a.gL(14);
      int i2 = g.a.a.b.b.a.gL(15);
      AppMethodBeat.o(205127);
      return paramInt + (i + 1) + (j + 1) + (k + 1) + (m + 1) + (n + 1) + (i1 + 1) + (i2 + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      if (this.url == null)
      {
        paramVarArgs = new b("Not all required fields were included: url");
        AppMethodBeat.o(205127);
        throw paramVarArgs;
      }
      if (this.ktM == null)
      {
        paramVarArgs = new b("Not all required fields were included: uid");
        AppMethodBeat.o(205127);
        throw paramVarArgs;
      }
      AppMethodBeat.o(205127);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      dny localdny = (dny)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(205127);
        return -1;
      case 1: 
        localdny.id = locala.abFh.AK();
        AppMethodBeat.o(205127);
        return 0;
      case 2: 
        localdny.url = locala.abFh.readString();
        AppMethodBeat.o(205127);
        return 0;
      case 3: 
        localdny.llp = locala.abFh.AK();
        AppMethodBeat.o(205127);
        return 0;
      case 4: 
        localdny.sNh = locala.abFh.AK();
        AppMethodBeat.o(205127);
        return 0;
      case 5: 
        localdny.svv = locala.abFh.AK();
        AppMethodBeat.o(205127);
        return 0;
      case 6: 
        localdny.wGA = locala.abFh.AK();
        AppMethodBeat.o(205127);
        return 0;
      case 7: 
        localdny.TVf = locala.abFh.AK();
        AppMethodBeat.o(205127);
        return 0;
      case 8: 
        localdny.ktM = locala.abFh.readString();
        AppMethodBeat.o(205127);
        return 0;
      case 9: 
        localdny.TVg = locala.abFh.AB();
        AppMethodBeat.o(205127);
        return 0;
      case 10: 
        localdny.TVh = locala.abFh.AB();
        AppMethodBeat.o(205127);
        return 0;
      case 11: 
        localdny.TVi = locala.abFh.AB();
        AppMethodBeat.o(205127);
        return 0;
      case 12: 
        localdny.TVj = locala.abFh.AB();
        AppMethodBeat.o(205127);
        return 0;
      case 13: 
        localdny.TVk = locala.abFh.AB();
        AppMethodBeat.o(205127);
        return 0;
      case 14: 
        localdny.sMn = locala.abFh.AB();
        AppMethodBeat.o(205127);
        return 0;
      }
      localdny.TVl = locala.abFh.AB();
      AppMethodBeat.o(205127);
      return 0;
    }
    AppMethodBeat.o(205127);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dny
 * JD-Core Version:    0.7.0.1
 */