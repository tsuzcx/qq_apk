package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eys
  extends com.tencent.mm.cd.a
{
  public String Sba;
  public int TJG;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258773);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.url != null) {
        paramVarArgs.f(1, this.url);
      }
      paramVarArgs.aY(2, this.TJG);
      if (this.Sba != null) {
        paramVarArgs.f(3, this.Sba);
      }
      AppMethodBeat.o(258773);
      return 0;
    }
    if (paramInt == 1) {
      if (this.url == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = g.a.a.b.b.a.g(1, this.url) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.TJG);
      paramInt = i;
      if (this.Sba != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.Sba);
      }
      AppMethodBeat.o(258773);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(258773);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        eys localeys = (eys)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258773);
          return -1;
        case 1: 
          localeys.url = locala.abFh.readString();
          AppMethodBeat.o(258773);
          return 0;
        case 2: 
          localeys.TJG = locala.abFh.AK();
          AppMethodBeat.o(258773);
          return 0;
        }
        localeys.Sba = locala.abFh.readString();
        AppMethodBeat.o(258773);
        return 0;
      }
      AppMethodBeat.o(258773);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eys
 * JD-Core Version:    0.7.0.1
 */