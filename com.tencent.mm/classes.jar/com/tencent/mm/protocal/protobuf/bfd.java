package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bfd
  extends com.tencent.mm.bv.a
{
  public String cyc;
  public String url;
  public String xfV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(96277);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xfV != null) {
        paramVarArgs.e(1, this.xfV);
      }
      if (this.url != null) {
        paramVarArgs.e(2, this.url);
      }
      if (this.cyc != null) {
        paramVarArgs.e(3, this.cyc);
      }
      AppMethodBeat.o(96277);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xfV == null) {
        break label334;
      }
    }
    label334:
    for (int i = e.a.a.b.b.a.f(1, this.xfV) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.url);
      }
      i = paramInt;
      if (this.cyc != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.cyc);
      }
      AppMethodBeat.o(96277);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(96277);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        bfd localbfd = (bfd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(96277);
          return -1;
        case 1: 
          localbfd.xfV = locala.CLY.readString();
          AppMethodBeat.o(96277);
          return 0;
        case 2: 
          localbfd.url = locala.CLY.readString();
          AppMethodBeat.o(96277);
          return 0;
        }
        localbfd.cyc = locala.CLY.readString();
        AppMethodBeat.o(96277);
        return 0;
      }
      AppMethodBeat.o(96277);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bfd
 * JD-Core Version:    0.7.0.1
 */