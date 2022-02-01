package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class ex
  extends com.tencent.mm.cd.a
{
  public String CQz;
  public String Id;
  public String RJH;
  public String RJI;
  public int RJJ;
  public String Version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125709);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Id != null) {
        paramVarArgs.f(1, this.Id);
      }
      if (this.Version != null) {
        paramVarArgs.f(2, this.Version);
      }
      if (this.CQz != null) {
        paramVarArgs.f(3, this.CQz);
      }
      if (this.RJH != null) {
        paramVarArgs.f(4, this.RJH);
      }
      if (this.RJI != null) {
        paramVarArgs.f(5, this.RJI);
      }
      paramVarArgs.aY(6, this.RJJ);
      AppMethodBeat.o(125709);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Id == null) {
        break label502;
      }
    }
    label502:
    for (int i = g.a.a.b.b.a.g(1, this.Id) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Version != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.Version);
      }
      i = paramInt;
      if (this.CQz != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.CQz);
      }
      paramInt = i;
      if (this.RJH != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.RJH);
      }
      i = paramInt;
      if (this.RJI != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.RJI);
      }
      paramInt = g.a.a.b.b.a.bM(6, this.RJJ);
      AppMethodBeat.o(125709);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(125709);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ex localex = (ex)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(125709);
          return -1;
        case 1: 
          localex.Id = locala.abFh.readString();
          AppMethodBeat.o(125709);
          return 0;
        case 2: 
          localex.Version = locala.abFh.readString();
          AppMethodBeat.o(125709);
          return 0;
        case 3: 
          localex.CQz = locala.abFh.readString();
          AppMethodBeat.o(125709);
          return 0;
        case 4: 
          localex.RJH = locala.abFh.readString();
          AppMethodBeat.o(125709);
          return 0;
        case 5: 
          localex.RJI = locala.abFh.readString();
          AppMethodBeat.o(125709);
          return 0;
        }
        localex.RJJ = locala.abFh.AK();
        AppMethodBeat.o(125709);
        return 0;
      }
      AppMethodBeat.o(125709);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ex
 * JD-Core Version:    0.7.0.1
 */