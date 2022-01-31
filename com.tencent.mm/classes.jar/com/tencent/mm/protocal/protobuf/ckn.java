package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ckn
  extends com.tencent.mm.bv.a
{
  public String activityName = "";
  public String wXg = "";
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(73661);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.activityName != null) {
        paramVarArgs.e(1, this.activityName);
      }
      if (this.wXg != null) {
        paramVarArgs.e(2, this.wXg);
      }
      AppMethodBeat.o(73661);
      return 0;
    }
    if (paramInt == 1) {
      if (this.activityName == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = e.a.a.b.b.a.f(1, this.activityName) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.wXg != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.wXg);
      }
      AppMethodBeat.o(73661);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(73661);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        ckn localckn = (ckn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(73661);
          return -1;
        case 1: 
          localckn.activityName = locala.CLY.readString();
          AppMethodBeat.o(73661);
          return 0;
        }
        localckn.wXg = locala.CLY.readString();
        AppMethodBeat.o(73661);
        return 0;
      }
      AppMethodBeat.o(73661);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ckn
 * JD-Core Version:    0.7.0.1
 */