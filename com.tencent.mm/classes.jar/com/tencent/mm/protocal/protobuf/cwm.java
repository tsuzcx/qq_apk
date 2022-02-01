package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cwm
  extends com.tencent.mm.bw.a
{
  public String Hxp;
  public int gvx;
  public String uqf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117905);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Hxp != null) {
        paramVarArgs.d(1, this.Hxp);
      }
      paramVarArgs.aS(2, this.gvx);
      if (this.uqf != null) {
        paramVarArgs.d(3, this.uqf);
      }
      AppMethodBeat.o(117905);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Hxp == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = f.a.a.b.b.a.e(1, this.Hxp) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.gvx);
      paramInt = i;
      if (this.uqf != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.uqf);
      }
      AppMethodBeat.o(117905);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(117905);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cwm localcwm = (cwm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117905);
          return -1;
        case 1: 
          localcwm.Hxp = locala.OmT.readString();
          AppMethodBeat.o(117905);
          return 0;
        case 2: 
          localcwm.gvx = locala.OmT.zc();
          AppMethodBeat.o(117905);
          return 0;
        }
        localcwm.uqf = locala.OmT.readString();
        AppMethodBeat.o(117905);
        return 0;
      }
      AppMethodBeat.o(117905);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cwm
 * JD-Core Version:    0.7.0.1
 */