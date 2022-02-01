package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class api
  extends com.tencent.mm.bw.a
{
  public int index;
  public int kar;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32211);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.index);
      if (this.username != null) {
        paramVarArgs.d(2, this.username);
      }
      paramVarArgs.aR(3, this.kar);
      AppMethodBeat.o(32211);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.index) + 0;
      paramInt = i;
      if (this.username != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.username);
      }
      i = f.a.a.b.b.a.bx(3, this.kar);
      AppMethodBeat.o(32211);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(32211);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      api localapi = (api)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32211);
        return -1;
      case 1: 
        localapi.index = locala.LVo.xF();
        AppMethodBeat.o(32211);
        return 0;
      case 2: 
        localapi.username = locala.LVo.readString();
        AppMethodBeat.o(32211);
        return 0;
      }
      localapi.kar = locala.LVo.xF();
      AppMethodBeat.o(32211);
      return 0;
    }
    AppMethodBeat.o(32211);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.api
 * JD-Core Version:    0.7.0.1
 */