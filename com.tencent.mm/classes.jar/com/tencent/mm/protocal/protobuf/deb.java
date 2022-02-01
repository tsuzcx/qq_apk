package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class deb
  extends com.tencent.mm.cd.a
{
  public String HlB;
  public int RYY;
  public String UserName;
  public String fKu;
  public String rWI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(184131);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UserName != null) {
        paramVarArgs.f(1, this.UserName);
      }
      if (this.HlB != null) {
        paramVarArgs.f(2, this.HlB);
      }
      paramVarArgs.aY(3, this.RYY);
      if (this.rWI != null) {
        paramVarArgs.f(4, this.rWI);
      }
      if (this.fKu != null) {
        paramVarArgs.f(5, this.fKu);
      }
      AppMethodBeat.o(184131);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UserName == null) {
        break label438;
      }
    }
    label438:
    for (paramInt = g.a.a.b.b.a.g(1, this.UserName) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.HlB != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.HlB);
      }
      i += g.a.a.b.b.a.bM(3, this.RYY);
      paramInt = i;
      if (this.rWI != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.rWI);
      }
      i = paramInt;
      if (this.fKu != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.fKu);
      }
      AppMethodBeat.o(184131);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(184131);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        deb localdeb = (deb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(184131);
          return -1;
        case 1: 
          localdeb.UserName = locala.abFh.readString();
          AppMethodBeat.o(184131);
          return 0;
        case 2: 
          localdeb.HlB = locala.abFh.readString();
          AppMethodBeat.o(184131);
          return 0;
        case 3: 
          localdeb.RYY = locala.abFh.AK();
          AppMethodBeat.o(184131);
          return 0;
        case 4: 
          localdeb.rWI = locala.abFh.readString();
          AppMethodBeat.o(184131);
          return 0;
        }
        localdeb.fKu = locala.abFh.readString();
        AppMethodBeat.o(184131);
        return 0;
      }
      AppMethodBeat.o(184131);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.deb
 * JD-Core Version:    0.7.0.1
 */