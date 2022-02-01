package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class ezo
  extends com.tencent.mm.bw.a
{
  public String KTg;
  public String MRZ;
  public int Scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32558);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MRZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: Talker");
        AppMethodBeat.o(32558);
        throw paramVarArgs;
      }
      if (this.KTg == null)
      {
        paramVarArgs = new b("Not all required fields were included: Text");
        AppMethodBeat.o(32558);
        throw paramVarArgs;
      }
      if (this.MRZ != null) {
        paramVarArgs.e(1, this.MRZ);
      }
      if (this.KTg != null) {
        paramVarArgs.e(2, this.KTg);
      }
      paramVarArgs.aM(3, this.Scene);
      AppMethodBeat.o(32558);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MRZ == null) {
        break label427;
      }
    }
    label427:
    for (paramInt = g.a.a.b.b.a.f(1, this.MRZ) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.KTg != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.KTg);
      }
      paramInt = g.a.a.b.b.a.bu(3, this.Scene);
      AppMethodBeat.o(32558);
      return i + paramInt;
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
          AppMethodBeat.o(32558);
          throw paramVarArgs;
        }
        if (this.KTg == null)
        {
          paramVarArgs = new b("Not all required fields were included: Text");
          AppMethodBeat.o(32558);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32558);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ezo localezo = (ezo)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32558);
          return -1;
        case 1: 
          localezo.MRZ = locala.UbS.readString();
          AppMethodBeat.o(32558);
          return 0;
        case 2: 
          localezo.KTg = locala.UbS.readString();
          AppMethodBeat.o(32558);
          return 0;
        }
        localezo.Scene = locala.UbS.zi();
        AppMethodBeat.o(32558);
        return 0;
      }
      AppMethodBeat.o(32558);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ezo
 * JD-Core Version:    0.7.0.1
 */