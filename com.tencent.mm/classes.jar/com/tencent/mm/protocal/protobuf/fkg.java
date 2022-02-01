package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fkg
  extends com.tencent.mm.cd.a
{
  public int CPw;
  public com.tencent.mm.cd.b RLr;
  public long UIY;
  public String Ueg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32559);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Ueg == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: Talker");
        AppMethodBeat.o(32559);
        throw paramVarArgs;
      }
      if (this.RLr == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: VoiceData");
        AppMethodBeat.o(32559);
        throw paramVarArgs;
      }
      if (this.Ueg != null) {
        paramVarArgs.f(1, this.Ueg);
      }
      paramVarArgs.bm(2, this.UIY);
      if (this.RLr != null) {
        paramVarArgs.c(3, this.RLr);
      }
      paramVarArgs.aY(4, this.CPw);
      AppMethodBeat.o(32559);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Ueg == null) {
        break label472;
      }
    }
    label472:
    for (paramInt = g.a.a.b.b.a.g(1, this.Ueg) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.p(2, this.UIY);
      paramInt = i;
      if (this.RLr != null) {
        paramInt = i + g.a.a.b.b.a.b(3, this.RLr);
      }
      i = g.a.a.b.b.a.bM(4, this.CPw);
      AppMethodBeat.o(32559);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.Ueg == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: Talker");
          AppMethodBeat.o(32559);
          throw paramVarArgs;
        }
        if (this.RLr == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: VoiceData");
          AppMethodBeat.o(32559);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32559);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        fkg localfkg = (fkg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32559);
          return -1;
        case 1: 
          localfkg.Ueg = locala.abFh.readString();
          AppMethodBeat.o(32559);
          return 0;
        case 2: 
          localfkg.UIY = locala.abFh.AN();
          AppMethodBeat.o(32559);
          return 0;
        case 3: 
          localfkg.RLr = locala.abFh.iUw();
          AppMethodBeat.o(32559);
          return 0;
        }
        localfkg.CPw = locala.abFh.AK();
        AppMethodBeat.o(32559);
        return 0;
      }
      AppMethodBeat.o(32559);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fkg
 * JD-Core Version:    0.7.0.1
 */