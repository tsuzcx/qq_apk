package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class ezv
  extends com.tencent.mm.bw.a
{
  public int KCD;
  public String KTg;
  public String MRZ;
  public boolean NvV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32565);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MRZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: Talker");
        AppMethodBeat.o(32565);
        throw paramVarArgs;
      }
      if (this.KTg == null)
      {
        paramVarArgs = new b("Not all required fields were included: Text");
        AppMethodBeat.o(32565);
        throw paramVarArgs;
      }
      if (this.MRZ != null) {
        paramVarArgs.e(1, this.MRZ);
      }
      if (this.KTg != null) {
        paramVarArgs.e(2, this.KTg);
      }
      paramVarArgs.cc(3, this.NvV);
      paramVarArgs.aM(4, this.KCD);
      AppMethodBeat.o(32565);
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
      int i = paramInt;
      if (this.KTg != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.KTg);
      }
      paramInt = g.a.a.b.b.a.fS(3);
      int j = g.a.a.b.b.a.bu(4, this.KCD);
      AppMethodBeat.o(32565);
      return i + (paramInt + 1) + j;
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
          paramVarArgs = new b("Not all required fields were included: Talker");
          AppMethodBeat.o(32565);
          throw paramVarArgs;
        }
        if (this.KTg == null)
        {
          paramVarArgs = new b("Not all required fields were included: Text");
          AppMethodBeat.o(32565);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32565);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ezv localezv = (ezv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32565);
          return -1;
        case 1: 
          localezv.MRZ = locala.UbS.readString();
          AppMethodBeat.o(32565);
          return 0;
        case 2: 
          localezv.KTg = locala.UbS.readString();
          AppMethodBeat.o(32565);
          return 0;
        case 3: 
          localezv.NvV = locala.UbS.yZ();
          AppMethodBeat.o(32565);
          return 0;
        }
        localezv.KCD = locala.UbS.zi();
        AppMethodBeat.o(32565);
        return 0;
      }
      AppMethodBeat.o(32565);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ezv
 * JD-Core Version:    0.7.0.1
 */