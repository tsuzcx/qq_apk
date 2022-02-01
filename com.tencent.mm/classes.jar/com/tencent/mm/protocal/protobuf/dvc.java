package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dvc
  extends com.tencent.mm.bw.a
{
  public String MWc;
  public String className;
  public String dataPath;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122531);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.className != null) {
        paramVarArgs.e(1, this.className);
      }
      if (this.dataPath != null) {
        paramVarArgs.e(2, this.dataPath);
      }
      if (this.MWc != null) {
        paramVarArgs.e(3, this.MWc);
      }
      AppMethodBeat.o(122531);
      return 0;
    }
    if (paramInt == 1) {
      if (this.className == null) {
        break label334;
      }
    }
    label334:
    for (int i = g.a.a.b.b.a.f(1, this.className) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dataPath != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.dataPath);
      }
      i = paramInt;
      if (this.MWc != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.MWc);
      }
      AppMethodBeat.o(122531);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(122531);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dvc localdvc = (dvc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(122531);
          return -1;
        case 1: 
          localdvc.className = locala.UbS.readString();
          AppMethodBeat.o(122531);
          return 0;
        case 2: 
          localdvc.dataPath = locala.UbS.readString();
          AppMethodBeat.o(122531);
          return 0;
        }
        localdvc.MWc = locala.UbS.readString();
        AppMethodBeat.o(122531);
        return 0;
      }
      AppMethodBeat.o(122531);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dvc
 * JD-Core Version:    0.7.0.1
 */