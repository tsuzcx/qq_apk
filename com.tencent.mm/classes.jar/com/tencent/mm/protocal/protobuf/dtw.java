package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dtw
  extends com.tencent.mm.cd.a
{
  public String Uaa;
  public String Uab;
  public int Uac;
  public int Uad = 0;
  public String Uae;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117895);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Uaa != null) {
        paramVarArgs.f(1, this.Uaa);
      }
      if (this.Uab != null) {
        paramVarArgs.f(2, this.Uab);
      }
      paramVarArgs.aY(3, this.Uac);
      paramVarArgs.aY(4, this.Uad);
      if (this.Uae != null) {
        paramVarArgs.f(5, this.Uae);
      }
      AppMethodBeat.o(117895);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Uaa == null) {
        break label422;
      }
    }
    label422:
    for (paramInt = g.a.a.b.b.a.g(1, this.Uaa) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Uab != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.Uab);
      }
      i = i + g.a.a.b.b.a.bM(3, this.Uac) + g.a.a.b.b.a.bM(4, this.Uad);
      paramInt = i;
      if (this.Uae != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.Uae);
      }
      AppMethodBeat.o(117895);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(117895);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dtw localdtw = (dtw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117895);
          return -1;
        case 1: 
          localdtw.Uaa = locala.abFh.readString();
          AppMethodBeat.o(117895);
          return 0;
        case 2: 
          localdtw.Uab = locala.abFh.readString();
          AppMethodBeat.o(117895);
          return 0;
        case 3: 
          localdtw.Uac = locala.abFh.AK();
          AppMethodBeat.o(117895);
          return 0;
        case 4: 
          localdtw.Uad = locala.abFh.AK();
          AppMethodBeat.o(117895);
          return 0;
        }
        localdtw.Uae = locala.abFh.readString();
        AppMethodBeat.o(117895);
        return 0;
      }
      AppMethodBeat.o(117895);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dtw
 * JD-Core Version:    0.7.0.1
 */