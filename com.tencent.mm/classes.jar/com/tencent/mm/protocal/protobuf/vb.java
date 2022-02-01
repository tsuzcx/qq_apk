package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class vb
  extends com.tencent.mm.bw.a
{
  public int KHb;
  public String KUk;
  public long Lfn;
  public int Lfo;
  public int oTW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(93332);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KUk != null) {
        paramVarArgs.e(1, this.KUk);
      }
      paramVarArgs.bb(2, this.Lfn);
      paramVarArgs.aM(3, this.Lfo);
      paramVarArgs.aM(4, this.KHb);
      paramVarArgs.aM(5, this.oTW);
      AppMethodBeat.o(93332);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KUk == null) {
        break label398;
      }
    }
    label398:
    for (paramInt = g.a.a.b.b.a.f(1, this.KUk) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.r(2, this.Lfn);
      int j = g.a.a.b.b.a.bu(3, this.Lfo);
      int k = g.a.a.b.b.a.bu(4, this.KHb);
      int m = g.a.a.b.b.a.bu(5, this.oTW);
      AppMethodBeat.o(93332);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(93332);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        vb localvb = (vb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(93332);
          return -1;
        case 1: 
          localvb.KUk = locala.UbS.readString();
          AppMethodBeat.o(93332);
          return 0;
        case 2: 
          localvb.Lfn = locala.UbS.zl();
          AppMethodBeat.o(93332);
          return 0;
        case 3: 
          localvb.Lfo = locala.UbS.zi();
          AppMethodBeat.o(93332);
          return 0;
        case 4: 
          localvb.KHb = locala.UbS.zi();
          AppMethodBeat.o(93332);
          return 0;
        }
        localvb.oTW = locala.UbS.zi();
        AppMethodBeat.o(93332);
        return 0;
      }
      AppMethodBeat.o(93332);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vb
 * JD-Core Version:    0.7.0.1
 */