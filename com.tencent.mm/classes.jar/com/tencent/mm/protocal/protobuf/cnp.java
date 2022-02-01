package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cnp
  extends com.tencent.mm.bw.a
{
  public String DXq;
  public int Fye;
  public String pAt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32411);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.pAt != null) {
        paramVarArgs.d(1, this.pAt);
      }
      if (this.DXq != null) {
        paramVarArgs.d(2, this.DXq);
      }
      paramVarArgs.aR(3, this.Fye);
      AppMethodBeat.o(32411);
      return 0;
    }
    if (paramInt == 1) {
      if (this.pAt == null) {
        break label327;
      }
    }
    label327:
    for (paramInt = f.a.a.b.b.a.e(1, this.pAt) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.DXq != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.DXq);
      }
      paramInt = f.a.a.b.b.a.bx(3, this.Fye);
      AppMethodBeat.o(32411);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(32411);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cnp localcnp = (cnp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32411);
          return -1;
        case 1: 
          localcnp.pAt = locala.LVo.readString();
          AppMethodBeat.o(32411);
          return 0;
        case 2: 
          localcnp.DXq = locala.LVo.readString();
          AppMethodBeat.o(32411);
          return 0;
        }
        localcnp.Fye = locala.LVo.xF();
        AppMethodBeat.o(32411);
        return 0;
      }
      AppMethodBeat.o(32411);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cnp
 * JD-Core Version:    0.7.0.1
 */