package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class vd
  extends com.tencent.mm.bw.a
{
  public String Lfq;
  public String Lfr;
  public int Lfs;
  public int Lft;
  public int Lfu;
  public int Lfv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123560);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Lfq != null) {
        paramVarArgs.e(1, this.Lfq);
      }
      if (this.Lfr != null) {
        paramVarArgs.e(2, this.Lfr);
      }
      paramVarArgs.aM(3, this.Lfs);
      paramVarArgs.aM(4, this.Lft);
      paramVarArgs.aM(5, this.Lfu);
      paramVarArgs.aM(6, this.Lfv);
      AppMethodBeat.o(123560);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Lfq == null) {
        break label458;
      }
    }
    label458:
    for (paramInt = g.a.a.b.b.a.f(1, this.Lfq) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Lfr != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.Lfr);
      }
      paramInt = g.a.a.b.b.a.bu(3, this.Lfs);
      int j = g.a.a.b.b.a.bu(4, this.Lft);
      int k = g.a.a.b.b.a.bu(5, this.Lfu);
      int m = g.a.a.b.b.a.bu(6, this.Lfv);
      AppMethodBeat.o(123560);
      return i + paramInt + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(123560);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        vd localvd = (vd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123560);
          return -1;
        case 1: 
          localvd.Lfq = locala.UbS.readString();
          AppMethodBeat.o(123560);
          return 0;
        case 2: 
          localvd.Lfr = locala.UbS.readString();
          AppMethodBeat.o(123560);
          return 0;
        case 3: 
          localvd.Lfs = locala.UbS.zi();
          AppMethodBeat.o(123560);
          return 0;
        case 4: 
          localvd.Lft = locala.UbS.zi();
          AppMethodBeat.o(123560);
          return 0;
        case 5: 
          localvd.Lfu = locala.UbS.zi();
          AppMethodBeat.o(123560);
          return 0;
        }
        localvd.Lfv = locala.UbS.zi();
        AppMethodBeat.o(123560);
        return 0;
      }
      AppMethodBeat.o(123560);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vd
 * JD-Core Version:    0.7.0.1
 */