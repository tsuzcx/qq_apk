package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fp
  extends com.tencent.mm.cd.a
{
  public int CPw;
  public long RKG;
  public int RKH;
  public int RKI;
  public String SessionId;
  public String Url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(6390);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Url != null) {
        paramVarArgs.f(1, this.Url);
      }
      paramVarArgs.bm(2, this.RKG);
      paramVarArgs.aY(3, this.RKH);
      if (this.SessionId != null) {
        paramVarArgs.f(4, this.SessionId);
      }
      paramVarArgs.aY(5, this.CPw);
      paramVarArgs.aY(6, this.RKI);
      AppMethodBeat.o(6390);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Url == null) {
        break label466;
      }
    }
    label466:
    for (paramInt = g.a.a.b.b.a.g(1, this.Url) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.p(2, this.RKG) + g.a.a.b.b.a.bM(3, this.RKH);
      paramInt = i;
      if (this.SessionId != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.SessionId);
      }
      i = g.a.a.b.b.a.bM(5, this.CPw);
      int j = g.a.a.b.b.a.bM(6, this.RKI);
      AppMethodBeat.o(6390);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(6390);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        fp localfp = (fp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(6390);
          return -1;
        case 1: 
          localfp.Url = locala.abFh.readString();
          AppMethodBeat.o(6390);
          return 0;
        case 2: 
          localfp.RKG = locala.abFh.AN();
          AppMethodBeat.o(6390);
          return 0;
        case 3: 
          localfp.RKH = locala.abFh.AK();
          AppMethodBeat.o(6390);
          return 0;
        case 4: 
          localfp.SessionId = locala.abFh.readString();
          AppMethodBeat.o(6390);
          return 0;
        case 5: 
          localfp.CPw = locala.abFh.AK();
          AppMethodBeat.o(6390);
          return 0;
        }
        localfp.RKI = locala.abFh.AK();
        AppMethodBeat.o(6390);
        return 0;
      }
      AppMethodBeat.o(6390);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fp
 * JD-Core Version:    0.7.0.1
 */