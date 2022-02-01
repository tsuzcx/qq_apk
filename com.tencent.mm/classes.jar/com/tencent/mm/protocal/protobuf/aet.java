package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aet
  extends com.tencent.mm.bw.a
{
  public String desc;
  public String hDr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72473);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.desc != null) {
        paramVarArgs.d(1, this.desc);
      }
      if (this.hDr != null) {
        paramVarArgs.d(2, this.hDr);
      }
      AppMethodBeat.o(72473);
      return 0;
    }
    if (paramInt == 1) {
      if (this.desc == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.e(1, this.desc) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.hDr != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.hDr);
      }
      AppMethodBeat.o(72473);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(72473);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        aet localaet = (aet)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72473);
          return -1;
        case 1: 
          localaet.desc = locala.OmT.readString();
          AppMethodBeat.o(72473);
          return 0;
        }
        localaet.hDr = locala.OmT.readString();
        AppMethodBeat.o(72473);
        return 0;
      }
      AppMethodBeat.o(72473);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aet
 * JD-Core Version:    0.7.0.1
 */