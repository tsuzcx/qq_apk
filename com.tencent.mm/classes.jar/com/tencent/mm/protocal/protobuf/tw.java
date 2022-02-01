package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class tw
  extends com.tencent.mm.bw.a
{
  public int FNw;
  public String Gaq;
  public long GkL;
  public int GkM;
  public int nJb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(93332);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Gaq != null) {
        paramVarArgs.d(1, this.Gaq);
      }
      paramVarArgs.aZ(2, this.GkL);
      paramVarArgs.aS(3, this.GkM);
      paramVarArgs.aS(4, this.FNw);
      paramVarArgs.aS(5, this.nJb);
      AppMethodBeat.o(93332);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Gaq == null) {
        break label398;
      }
    }
    label398:
    for (paramInt = f.a.a.b.b.a.e(1, this.Gaq) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.p(2, this.GkL);
      int j = f.a.a.b.b.a.bz(3, this.GkM);
      int k = f.a.a.b.b.a.bz(4, this.FNw);
      int m = f.a.a.b.b.a.bz(5, this.nJb);
      AppMethodBeat.o(93332);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(93332);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        tw localtw = (tw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(93332);
          return -1;
        case 1: 
          localtw.Gaq = locala.OmT.readString();
          AppMethodBeat.o(93332);
          return 0;
        case 2: 
          localtw.GkL = locala.OmT.zd();
          AppMethodBeat.o(93332);
          return 0;
        case 3: 
          localtw.GkM = locala.OmT.zc();
          AppMethodBeat.o(93332);
          return 0;
        case 4: 
          localtw.FNw = locala.OmT.zc();
          AppMethodBeat.o(93332);
          return 0;
        }
        localtw.nJb = locala.OmT.zc();
        AppMethodBeat.o(93332);
        return 0;
      }
      AppMethodBeat.o(93332);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.tw
 * JD-Core Version:    0.7.0.1
 */