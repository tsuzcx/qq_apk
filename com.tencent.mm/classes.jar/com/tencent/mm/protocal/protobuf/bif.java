package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bif
  extends com.tencent.mm.cd.a
{
  public int SSG;
  public LinkedList<String> SSH;
  public String path;
  
  public bif()
  {
    AppMethodBeat.i(197454);
    this.SSH = new LinkedList();
    AppMethodBeat.o(197454);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(197459);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.path != null) {
        paramVarArgs.f(1, this.path);
      }
      paramVarArgs.aY(2, this.SSG);
      paramVarArgs.e(3, 1, this.SSH);
      AppMethodBeat.o(197459);
      return 0;
    }
    if (paramInt == 1) {
      if (this.path == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = g.a.a.b.b.a.g(1, this.path) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bM(2, this.SSG);
      int j = g.a.a.a.c(3, 1, this.SSH);
      AppMethodBeat.o(197459);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.SSH.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(197459);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        bif localbif = (bif)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(197459);
          return -1;
        case 1: 
          localbif.path = locala.abFh.readString();
          AppMethodBeat.o(197459);
          return 0;
        case 2: 
          localbif.SSG = locala.abFh.AK();
          AppMethodBeat.o(197459);
          return 0;
        }
        localbif.SSH.add(locala.abFh.readString());
        AppMethodBeat.o(197459);
        return 0;
      }
      AppMethodBeat.o(197459);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bif
 * JD-Core Version:    0.7.0.1
 */