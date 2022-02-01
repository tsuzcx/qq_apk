package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dhv
  extends com.tencent.mm.bw.a
{
  public String EJR;
  public boolean FQQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(6440);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EJR != null) {
        paramVarArgs.d(1, this.EJR);
      }
      paramVarArgs.bl(2, this.FQQ);
      AppMethodBeat.o(6440);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EJR == null) {
        break label266;
      }
    }
    label266:
    for (paramInt = f.a.a.b.b.a.e(1, this.EJR) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.fK(2);
      AppMethodBeat.o(6440);
      return paramInt + (i + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(6440);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dhv localdhv = (dhv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(6440);
          return -1;
        case 1: 
          localdhv.EJR = locala.LVo.readString();
          AppMethodBeat.o(6440);
          return 0;
        }
        localdhv.FQQ = locala.LVo.fZX();
        AppMethodBeat.o(6440);
        return 0;
      }
      AppMethodBeat.o(6440);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dhv
 * JD-Core Version:    0.7.0.1
 */