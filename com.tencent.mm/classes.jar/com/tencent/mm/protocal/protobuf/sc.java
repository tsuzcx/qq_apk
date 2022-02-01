package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class sc
  extends com.tencent.mm.bw.a
{
  public String Elh;
  public String Eli;
  public int Elj;
  public int Elk;
  public int Ell;
  public int Elm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123560);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Elh != null) {
        paramVarArgs.d(1, this.Elh);
      }
      if (this.Eli != null) {
        paramVarArgs.d(2, this.Eli);
      }
      paramVarArgs.aR(3, this.Elj);
      paramVarArgs.aR(4, this.Elk);
      paramVarArgs.aR(5, this.Ell);
      paramVarArgs.aR(6, this.Elm);
      AppMethodBeat.o(123560);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Elh == null) {
        break label458;
      }
    }
    label458:
    for (paramInt = f.a.a.b.b.a.e(1, this.Elh) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Eli != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Eli);
      }
      paramInt = f.a.a.b.b.a.bx(3, this.Elj);
      int j = f.a.a.b.b.a.bx(4, this.Elk);
      int k = f.a.a.b.b.a.bx(5, this.Ell);
      int m = f.a.a.b.b.a.bx(6, this.Elm);
      AppMethodBeat.o(123560);
      return i + paramInt + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(123560);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        sc localsc = (sc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123560);
          return -1;
        case 1: 
          localsc.Elh = locala.LVo.readString();
          AppMethodBeat.o(123560);
          return 0;
        case 2: 
          localsc.Eli = locala.LVo.readString();
          AppMethodBeat.o(123560);
          return 0;
        case 3: 
          localsc.Elj = locala.LVo.xF();
          AppMethodBeat.o(123560);
          return 0;
        case 4: 
          localsc.Elk = locala.LVo.xF();
          AppMethodBeat.o(123560);
          return 0;
        case 5: 
          localsc.Ell = locala.LVo.xF();
          AppMethodBeat.o(123560);
          return 0;
        }
        localsc.Elm = locala.LVo.xF();
        AppMethodBeat.o(123560);
        return 0;
      }
      AppMethodBeat.o(123560);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.sc
 * JD-Core Version:    0.7.0.1
 */