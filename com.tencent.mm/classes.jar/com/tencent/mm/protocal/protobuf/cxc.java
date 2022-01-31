package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class cxc
  extends com.tencent.mm.bv.a
{
  public String jKG;
  public String xlH;
  public long yeJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28737);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xlH == null)
      {
        paramVarArgs = new b("Not all required fields were included: Talker");
        AppMethodBeat.o(28737);
        throw paramVarArgs;
      }
      if (this.jKG == null)
      {
        paramVarArgs = new b("Not all required fields were included: NickName");
        AppMethodBeat.o(28737);
        throw paramVarArgs;
      }
      if (this.xlH != null) {
        paramVarArgs.e(1, this.xlH);
      }
      if (this.jKG != null) {
        paramVarArgs.e(2, this.jKG);
      }
      paramVarArgs.am(3, this.yeJ);
      AppMethodBeat.o(28737);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xlH == null) {
        break label427;
      }
    }
    label427:
    for (paramInt = e.a.a.b.b.a.f(1, this.xlH) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.jKG != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.jKG);
      }
      paramInt = e.a.a.b.b.a.p(3, this.yeJ);
      AppMethodBeat.o(28737);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.xlH == null)
        {
          paramVarArgs = new b("Not all required fields were included: Talker");
          AppMethodBeat.o(28737);
          throw paramVarArgs;
        }
        if (this.jKG == null)
        {
          paramVarArgs = new b("Not all required fields were included: NickName");
          AppMethodBeat.o(28737);
          throw paramVarArgs;
        }
        AppMethodBeat.o(28737);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        cxc localcxc = (cxc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(28737);
          return -1;
        case 1: 
          localcxc.xlH = locala.CLY.readString();
          AppMethodBeat.o(28737);
          return 0;
        case 2: 
          localcxc.jKG = locala.CLY.readString();
          AppMethodBeat.o(28737);
          return 0;
        }
        localcxc.yeJ = locala.CLY.sm();
        AppMethodBeat.o(28737);
        return 0;
      }
      AppMethodBeat.o(28737);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cxc
 * JD-Core Version:    0.7.0.1
 */