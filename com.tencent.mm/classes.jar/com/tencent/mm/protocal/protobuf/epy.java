package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class epy
  extends com.tencent.mm.cd.a
{
  public String CqK;
  public String Txp;
  public int Usv;
  public int Usw;
  public String lVG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153306);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Txp != null) {
        paramVarArgs.f(1, this.Txp);
      }
      paramVarArgs.aY(2, this.Usv);
      paramVarArgs.aY(3, this.Usw);
      if (this.CqK != null) {
        paramVarArgs.f(4, this.CqK);
      }
      if (this.lVG != null) {
        paramVarArgs.f(5, this.lVG);
      }
      AppMethodBeat.o(153306);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Txp == null) {
        break label422;
      }
    }
    label422:
    for (paramInt = g.a.a.b.b.a.g(1, this.Txp) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.Usv) + g.a.a.b.b.a.bM(3, this.Usw);
      paramInt = i;
      if (this.CqK != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.CqK);
      }
      i = paramInt;
      if (this.lVG != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.lVG);
      }
      AppMethodBeat.o(153306);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(153306);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        epy localepy = (epy)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(153306);
          return -1;
        case 1: 
          localepy.Txp = locala.abFh.readString();
          AppMethodBeat.o(153306);
          return 0;
        case 2: 
          localepy.Usv = locala.abFh.AK();
          AppMethodBeat.o(153306);
          return 0;
        case 3: 
          localepy.Usw = locala.abFh.AK();
          AppMethodBeat.o(153306);
          return 0;
        case 4: 
          localepy.CqK = locala.abFh.readString();
          AppMethodBeat.o(153306);
          return 0;
        }
        localepy.lVG = locala.abFh.readString();
        AppMethodBeat.o(153306);
        return 0;
      }
      AppMethodBeat.o(153306);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.epy
 * JD-Core Version:    0.7.0.1
 */