package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class rl
  extends com.tencent.mm.bw.a
{
  public String dvP;
  public String nUr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113964);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.nUr != null) {
        paramVarArgs.d(1, this.nUr);
      }
      if (this.dvP != null) {
        paramVarArgs.d(2, this.dvP);
      }
      AppMethodBeat.o(113964);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nUr == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.e(1, this.nUr) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.dvP != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.dvP);
      }
      AppMethodBeat.o(113964);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(113964);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        rl localrl = (rl)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(113964);
          return -1;
        case 1: 
          localrl.nUr = locala.LVo.readString();
          AppMethodBeat.o(113964);
          return 0;
        }
        localrl.dvP = locala.LVo.readString();
        AppMethodBeat.o(113964);
        return 0;
      }
      AppMethodBeat.o(113964);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.rl
 * JD-Core Version:    0.7.0.1
 */