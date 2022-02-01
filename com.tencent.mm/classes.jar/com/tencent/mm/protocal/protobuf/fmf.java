package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fmf
  extends com.tencent.mm.cd.a
{
  public String Hnd;
  public int RYM;
  public String ULa;
  public String appid;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82491);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.appid != null) {
        paramVarArgs.f(1, this.appid);
      }
      paramVarArgs.aY(2, this.RYM);
      if (this.ULa != null) {
        paramVarArgs.f(3, this.ULa);
      }
      if (this.Hnd != null) {
        paramVarArgs.f(4, this.Hnd);
      }
      AppMethodBeat.o(82491);
      return 0;
    }
    if (paramInt == 1) {
      if (this.appid == null) {
        break label378;
      }
    }
    label378:
    for (paramInt = g.a.a.b.b.a.g(1, this.appid) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.RYM);
      paramInt = i;
      if (this.ULa != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.ULa);
      }
      i = paramInt;
      if (this.Hnd != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.Hnd);
      }
      AppMethodBeat.o(82491);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(82491);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        fmf localfmf = (fmf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(82491);
          return -1;
        case 1: 
          localfmf.appid = locala.abFh.readString();
          AppMethodBeat.o(82491);
          return 0;
        case 2: 
          localfmf.RYM = locala.abFh.AK();
          AppMethodBeat.o(82491);
          return 0;
        case 3: 
          localfmf.ULa = locala.abFh.readString();
          AppMethodBeat.o(82491);
          return 0;
        }
        localfmf.Hnd = locala.abFh.readString();
        AppMethodBeat.o(82491);
        return 0;
      }
      AppMethodBeat.o(82491);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fmf
 * JD-Core Version:    0.7.0.1
 */