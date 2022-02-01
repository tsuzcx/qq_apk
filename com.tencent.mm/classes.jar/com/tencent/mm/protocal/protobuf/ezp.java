package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ezp
  extends com.tencent.mm.bw.a
{
  public com.tencent.mm.bw.b KKz;
  public String MRZ;
  public long NvN;
  public int Scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32559);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MRZ == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: Talker");
        AppMethodBeat.o(32559);
        throw paramVarArgs;
      }
      if (this.KKz == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: VoiceData");
        AppMethodBeat.o(32559);
        throw paramVarArgs;
      }
      if (this.MRZ != null) {
        paramVarArgs.e(1, this.MRZ);
      }
      paramVarArgs.bb(2, this.NvN);
      if (this.KKz != null) {
        paramVarArgs.c(3, this.KKz);
      }
      paramVarArgs.aM(4, this.Scene);
      AppMethodBeat.o(32559);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MRZ == null) {
        break label472;
      }
    }
    label472:
    for (paramInt = g.a.a.b.b.a.f(1, this.MRZ) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.r(2, this.NvN);
      paramInt = i;
      if (this.KKz != null) {
        paramInt = i + g.a.a.b.b.a.b(3, this.KKz);
      }
      i = g.a.a.b.b.a.bu(4, this.Scene);
      AppMethodBeat.o(32559);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.MRZ == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: Talker");
          AppMethodBeat.o(32559);
          throw paramVarArgs;
        }
        if (this.KKz == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: VoiceData");
          AppMethodBeat.o(32559);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32559);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ezp localezp = (ezp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32559);
          return -1;
        case 1: 
          localezp.MRZ = locala.UbS.readString();
          AppMethodBeat.o(32559);
          return 0;
        case 2: 
          localezp.NvN = locala.UbS.zl();
          AppMethodBeat.o(32559);
          return 0;
        case 3: 
          localezp.KKz = locala.UbS.hPo();
          AppMethodBeat.o(32559);
          return 0;
        }
        localezp.Scene = locala.UbS.zi();
        AppMethodBeat.o(32559);
        return 0;
      }
      AppMethodBeat.o(32559);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ezp
 * JD-Core Version:    0.7.0.1
 */