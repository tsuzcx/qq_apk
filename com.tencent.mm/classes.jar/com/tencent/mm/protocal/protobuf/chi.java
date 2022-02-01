package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class chi
  extends com.tencent.mm.cd.a
{
  public String Suq;
  public String ToJ;
  public String ToK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152609);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Suq != null) {
        paramVarArgs.f(1, this.Suq);
      }
      if (this.ToJ != null) {
        paramVarArgs.f(2, this.ToJ);
      }
      if (this.ToK != null) {
        paramVarArgs.f(3, this.ToK);
      }
      AppMethodBeat.o(152609);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Suq == null) {
        break label334;
      }
    }
    label334:
    for (int i = g.a.a.b.b.a.g(1, this.Suq) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ToJ != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.ToJ);
      }
      i = paramInt;
      if (this.ToK != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.ToK);
      }
      AppMethodBeat.o(152609);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(152609);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        chi localchi = (chi)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152609);
          return -1;
        case 1: 
          localchi.Suq = locala.abFh.readString();
          AppMethodBeat.o(152609);
          return 0;
        case 2: 
          localchi.ToJ = locala.abFh.readString();
          AppMethodBeat.o(152609);
          return 0;
        }
        localchi.ToK = locala.abFh.readString();
        AppMethodBeat.o(152609);
        return 0;
      }
      AppMethodBeat.o(152609);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.chi
 * JD-Core Version:    0.7.0.1
 */