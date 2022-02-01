package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bal
  extends com.tencent.mm.bw.a
{
  public String ERr;
  public String ERs;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125734);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ERr != null) {
        paramVarArgs.d(1, this.ERr);
      }
      if (this.ERs != null) {
        paramVarArgs.d(2, this.ERs);
      }
      AppMethodBeat.o(125734);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ERr == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.e(1, this.ERr) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ERs != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.ERs);
      }
      AppMethodBeat.o(125734);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(125734);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bal localbal = (bal)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(125734);
          return -1;
        case 1: 
          localbal.ERr = locala.LVo.readString();
          AppMethodBeat.o(125734);
          return 0;
        }
        localbal.ERs = locala.LVo.readString();
        AppMethodBeat.o(125734);
        return 0;
      }
      AppMethodBeat.o(125734);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bal
 * JD-Core Version:    0.7.0.1
 */