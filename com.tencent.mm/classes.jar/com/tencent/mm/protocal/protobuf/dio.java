package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dio
  extends com.tencent.mm.cd.a
{
  public String CMD;
  public int RXp;
  public String SsP;
  public int SsQ;
  public String SsR;
  public String TPW;
  public String TPX;
  public String TPY;
  public String UserName;
  public String query;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117887);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.RXp);
      if (this.CMD != null) {
        paramVarArgs.f(2, this.CMD);
      }
      if (this.UserName != null) {
        paramVarArgs.f(3, this.UserName);
      }
      if (this.SsP != null) {
        paramVarArgs.f(4, this.SsP);
      }
      paramVarArgs.aY(5, this.SsQ);
      if (this.SsR != null) {
        paramVarArgs.f(6, this.SsR);
      }
      if (this.TPW != null) {
        paramVarArgs.f(7, this.TPW);
      }
      if (this.TPX != null) {
        paramVarArgs.f(8, this.TPX);
      }
      if (this.query != null) {
        paramVarArgs.f(100, this.query);
      }
      if (this.TPY != null) {
        paramVarArgs.f(101, this.TPY);
      }
      AppMethodBeat.o(117887);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.RXp) + 0;
      paramInt = i;
      if (this.CMD != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.CMD);
      }
      i = paramInt;
      if (this.UserName != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.UserName);
      }
      paramInt = i;
      if (this.SsP != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.SsP);
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.SsQ);
      paramInt = i;
      if (this.SsR != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.SsR);
      }
      i = paramInt;
      if (this.TPW != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.TPW);
      }
      paramInt = i;
      if (this.TPX != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.TPX);
      }
      i = paramInt;
      if (this.query != null) {
        i = paramInt + g.a.a.b.b.a.g(100, this.query);
      }
      paramInt = i;
      if (this.TPY != null) {
        paramInt = i + g.a.a.b.b.a.g(101, this.TPY);
      }
      AppMethodBeat.o(117887);
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
      AppMethodBeat.o(117887);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      dio localdio = (dio)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(117887);
        return -1;
      case 1: 
        localdio.RXp = locala.abFh.AK();
        AppMethodBeat.o(117887);
        return 0;
      case 2: 
        localdio.CMD = locala.abFh.readString();
        AppMethodBeat.o(117887);
        return 0;
      case 3: 
        localdio.UserName = locala.abFh.readString();
        AppMethodBeat.o(117887);
        return 0;
      case 4: 
        localdio.SsP = locala.abFh.readString();
        AppMethodBeat.o(117887);
        return 0;
      case 5: 
        localdio.SsQ = locala.abFh.AK();
        AppMethodBeat.o(117887);
        return 0;
      case 6: 
        localdio.SsR = locala.abFh.readString();
        AppMethodBeat.o(117887);
        return 0;
      case 7: 
        localdio.TPW = locala.abFh.readString();
        AppMethodBeat.o(117887);
        return 0;
      case 8: 
        localdio.TPX = locala.abFh.readString();
        AppMethodBeat.o(117887);
        return 0;
      case 100: 
        localdio.query = locala.abFh.readString();
        AppMethodBeat.o(117887);
        return 0;
      }
      localdio.TPY = locala.abFh.readString();
      AppMethodBeat.o(117887);
      return 0;
    }
    AppMethodBeat.o(117887);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dio
 * JD-Core Version:    0.7.0.1
 */