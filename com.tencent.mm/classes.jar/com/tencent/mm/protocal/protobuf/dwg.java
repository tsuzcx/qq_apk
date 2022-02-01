package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class dwg
  extends com.tencent.mm.bw.a
{
  public long Gdw;
  public String Username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32515);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Username == null)
      {
        paramVarArgs = new b("Not all required fields were included: Username");
        AppMethodBeat.o(32515);
        throw paramVarArgs;
      }
      paramVarArgs.aO(1, this.Gdw);
      if (this.Username != null) {
        paramVarArgs.d(2, this.Username);
      }
      AppMethodBeat.o(32515);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.p(1, this.Gdw) + 0;
      paramInt = i;
      if (this.Username != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Username);
      }
      AppMethodBeat.o(32515);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      if (this.Username == null)
      {
        paramVarArgs = new b("Not all required fields were included: Username");
        AppMethodBeat.o(32515);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32515);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dwg localdwg = (dwg)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32515);
        return -1;
      case 1: 
        localdwg.Gdw = locala.LVo.xG();
        AppMethodBeat.o(32515);
        return 0;
      }
      localdwg.Username = locala.LVo.readString();
      AppMethodBeat.o(32515);
      return 0;
    }
    AppMethodBeat.o(32515);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dwg
 * JD-Core Version:    0.7.0.1
 */