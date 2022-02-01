package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dxw
  extends com.tencent.mm.bw.a
{
  public String IcF;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(190873);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.d(1, this.username);
      }
      if (this.IcF != null) {
        paramVarArgs.d(2, this.IcF);
      }
      AppMethodBeat.o(190873);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.e(1, this.username) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.IcF != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.IcF);
      }
      AppMethodBeat.o(190873);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(190873);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dxw localdxw = (dxw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(190873);
          return -1;
        case 1: 
          localdxw.username = locala.OmT.readString();
          AppMethodBeat.o(190873);
          return 0;
        }
        localdxw.IcF = locala.OmT.readString();
        AppMethodBeat.o(190873);
        return 0;
      }
      AppMethodBeat.o(190873);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dxw
 * JD-Core Version:    0.7.0.1
 */