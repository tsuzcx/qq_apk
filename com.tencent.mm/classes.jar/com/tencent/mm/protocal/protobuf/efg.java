package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class efg
  extends com.tencent.mm.bw.a
{
  public String FZl;
  public String HGP;
  public int Scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32558);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HGP == null)
      {
        paramVarArgs = new b("Not all required fields were included: Talker");
        AppMethodBeat.o(32558);
        throw paramVarArgs;
      }
      if (this.FZl == null)
      {
        paramVarArgs = new b("Not all required fields were included: Text");
        AppMethodBeat.o(32558);
        throw paramVarArgs;
      }
      if (this.HGP != null) {
        paramVarArgs.d(1, this.HGP);
      }
      if (this.FZl != null) {
        paramVarArgs.d(2, this.FZl);
      }
      paramVarArgs.aS(3, this.Scene);
      AppMethodBeat.o(32558);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HGP == null) {
        break label427;
      }
    }
    label427:
    for (paramInt = f.a.a.b.b.a.e(1, this.HGP) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FZl != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.FZl);
      }
      paramInt = f.a.a.b.b.a.bz(3, this.Scene);
      AppMethodBeat.o(32558);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.HGP == null)
        {
          paramVarArgs = new b("Not all required fields were included: Talker");
          AppMethodBeat.o(32558);
          throw paramVarArgs;
        }
        if (this.FZl == null)
        {
          paramVarArgs = new b("Not all required fields were included: Text");
          AppMethodBeat.o(32558);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32558);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        efg localefg = (efg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32558);
          return -1;
        case 1: 
          localefg.HGP = locala.OmT.readString();
          AppMethodBeat.o(32558);
          return 0;
        case 2: 
          localefg.FZl = locala.OmT.readString();
          AppMethodBeat.o(32558);
          return 0;
        }
        localefg.Scene = locala.OmT.zc();
        AppMethodBeat.o(32558);
        return 0;
      }
      AppMethodBeat.o(32558);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.efg
 * JD-Core Version:    0.7.0.1
 */