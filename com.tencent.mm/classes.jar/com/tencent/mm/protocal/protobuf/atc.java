package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class atc
  extends com.tencent.mm.bx.a
{
  public int index;
  public int kuN;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32211);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.index);
      if (this.username != null) {
        paramVarArgs.d(2, this.username);
      }
      paramVarArgs.aS(3, this.kuN);
      AppMethodBeat.o(32211);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.index) + 0;
      paramInt = i;
      if (this.username != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.username);
      }
      i = f.a.a.b.b.a.bz(3, this.kuN);
      AppMethodBeat.o(32211);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(32211);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      atc localatc = (atc)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32211);
        return -1;
      case 1: 
        localatc.index = locala.NPN.zc();
        AppMethodBeat.o(32211);
        return 0;
      case 2: 
        localatc.username = locala.NPN.readString();
        AppMethodBeat.o(32211);
        return 0;
      }
      localatc.kuN = locala.NPN.zc();
      AppMethodBeat.o(32211);
      return 0;
    }
    AppMethodBeat.o(32211);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.atc
 * JD-Core Version:    0.7.0.1
 */