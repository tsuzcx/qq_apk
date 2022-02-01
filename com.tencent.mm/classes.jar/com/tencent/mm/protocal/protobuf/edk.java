package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class edk
  extends com.tencent.mm.bx.a
{
  public long FAf;
  public com.tencent.mm.bx.b Fyu;
  public int HPb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32552);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Fyu == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: VoiceData");
        AppMethodBeat.o(32552);
        throw paramVarArgs;
      }
      paramVarArgs.aY(1, this.FAf);
      if (this.Fyu != null) {
        paramVarArgs.c(2, this.Fyu);
      }
      paramVarArgs.aS(3, this.HPb);
      AppMethodBeat.o(32552);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.p(1, this.FAf) + 0;
      paramInt = i;
      if (this.Fyu != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.Fyu);
      }
      i = f.a.a.b.b.a.bz(3, this.HPb);
      AppMethodBeat.o(32552);
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
      if (this.Fyu == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: VoiceData");
        AppMethodBeat.o(32552);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32552);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      edk localedk = (edk)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32552);
        return -1;
      case 1: 
        localedk.FAf = locala.NPN.zd();
        AppMethodBeat.o(32552);
        return 0;
      case 2: 
        localedk.Fyu = locala.NPN.gxI();
        AppMethodBeat.o(32552);
        return 0;
      }
      localedk.HPb = locala.NPN.zc();
      AppMethodBeat.o(32552);
      return 0;
    }
    AppMethodBeat.o(32552);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.edk
 * JD-Core Version:    0.7.0.1
 */