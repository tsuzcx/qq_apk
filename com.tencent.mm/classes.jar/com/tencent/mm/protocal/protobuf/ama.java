package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class ama
  extends com.tencent.mm.bx.a
{
  public LinkedList<String> Krs;
  public int ZsX;
  public String zzS;
  
  public ama()
  {
    AppMethodBeat.i(257688);
    this.Krs = new LinkedList();
    AppMethodBeat.o(257688);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257691);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.zzS == null)
      {
        paramVarArgs = new b("Not all required fields were included: configID");
        AppMethodBeat.o(257691);
        throw paramVarArgs;
      }
      if (this.zzS != null) {
        paramVarArgs.g(1, this.zzS);
      }
      paramVarArgs.bS(2, this.ZsX);
      paramVarArgs.e(3, 1, this.Krs);
      AppMethodBeat.o(257691);
      return 0;
    }
    if (paramInt == 1) {
      if (this.zzS == null) {
        break label366;
      }
    }
    label366:
    for (paramInt = i.a.a.b.b.a.h(1, this.zzS) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.ZsX);
      int j = i.a.a.a.c(3, 1, this.Krs);
      AppMethodBeat.o(257691);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Krs.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.zzS == null)
        {
          paramVarArgs = new b("Not all required fields were included: configID");
          AppMethodBeat.o(257691);
          throw paramVarArgs;
        }
        AppMethodBeat.o(257691);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        ama localama = (ama)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(257691);
          return -1;
        case 1: 
          localama.zzS = locala.ajGk.readString();
          AppMethodBeat.o(257691);
          return 0;
        case 2: 
          localama.ZsX = locala.ajGk.aar();
          AppMethodBeat.o(257691);
          return 0;
        }
        localama.Krs.add(locala.ajGk.readString());
        AppMethodBeat.o(257691);
        return 0;
      }
      AppMethodBeat.o(257691);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ama
 * JD-Core Version:    0.7.0.1
 */