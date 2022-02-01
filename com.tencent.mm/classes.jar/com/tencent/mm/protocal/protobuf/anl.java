package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class anl
  extends com.tencent.mm.bw.a
{
  public String FeZ;
  public String Lyk;
  public int ckU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127485);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.FeZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: tagName");
        AppMethodBeat.o(127485);
        throw paramVarArgs;
      }
      if (this.Lyk == null)
      {
        paramVarArgs = new b("Not all required fields were included: tagPinYin");
        AppMethodBeat.o(127485);
        throw paramVarArgs;
      }
      if (this.FeZ != null) {
        paramVarArgs.e(1, this.FeZ);
      }
      if (this.Lyk != null) {
        paramVarArgs.e(2, this.Lyk);
      }
      paramVarArgs.aM(3, this.ckU);
      AppMethodBeat.o(127485);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FeZ == null) {
        break label414;
      }
    }
    label414:
    for (paramInt = g.a.a.b.b.a.f(1, this.FeZ) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Lyk != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.Lyk);
      }
      paramInt = g.a.a.b.b.a.bu(3, this.ckU);
      AppMethodBeat.o(127485);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.FeZ == null)
        {
          paramVarArgs = new b("Not all required fields were included: tagName");
          AppMethodBeat.o(127485);
          throw paramVarArgs;
        }
        if (this.Lyk == null)
        {
          paramVarArgs = new b("Not all required fields were included: tagPinYin");
          AppMethodBeat.o(127485);
          throw paramVarArgs;
        }
        AppMethodBeat.o(127485);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        anl localanl = (anl)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127485);
          return -1;
        case 1: 
          localanl.FeZ = locala.UbS.readString();
          AppMethodBeat.o(127485);
          return 0;
        case 2: 
          localanl.Lyk = locala.UbS.readString();
          AppMethodBeat.o(127485);
          return 0;
        }
        localanl.ckU = locala.UbS.zi();
        AppMethodBeat.o(127485);
        return 0;
      }
      AppMethodBeat.o(127485);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.anl
 * JD-Core Version:    0.7.0.1
 */