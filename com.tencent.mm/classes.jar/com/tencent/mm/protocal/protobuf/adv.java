package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class adv
  extends com.tencent.mm.bx.a
{
  public String Gcj;
  public int Gck;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32188);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Gcj != null) {
        paramVarArgs.d(1, this.Gcj);
      }
      paramVarArgs.aS(2, this.Gck);
      AppMethodBeat.o(32188);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Gcj == null) {
        break label266;
      }
    }
    label266:
    for (paramInt = f.a.a.b.b.a.e(1, this.Gcj) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.Gck);
      AppMethodBeat.o(32188);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(32188);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        adv localadv = (adv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32188);
          return -1;
        case 1: 
          localadv.Gcj = locala.NPN.readString();
          AppMethodBeat.o(32188);
          return 0;
        }
        localadv.Gck = locala.NPN.zc();
        AppMethodBeat.o(32188);
        return 0;
      }
      AppMethodBeat.o(32188);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.adv
 * JD-Core Version:    0.7.0.1
 */