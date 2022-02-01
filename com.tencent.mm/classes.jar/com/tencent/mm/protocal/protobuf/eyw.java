package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class eyw
  extends com.tencent.mm.bw.a
{
  public String MRZ;
  public long Nvw;
  public String oUJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32536);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MRZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: Talker");
        AppMethodBeat.o(32536);
        throw paramVarArgs;
      }
      if (this.oUJ == null)
      {
        paramVarArgs = new b("Not all required fields were included: NickName");
        AppMethodBeat.o(32536);
        throw paramVarArgs;
      }
      if (this.MRZ != null) {
        paramVarArgs.e(1, this.MRZ);
      }
      if (this.oUJ != null) {
        paramVarArgs.e(2, this.oUJ);
      }
      paramVarArgs.bb(3, this.Nvw);
      AppMethodBeat.o(32536);
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
      if (this.oUJ != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.oUJ);
      }
      paramInt = g.a.a.b.b.a.r(3, this.Nvw);
      AppMethodBeat.o(32536);
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
          AppMethodBeat.o(32536);
          throw paramVarArgs;
        }
        if (this.oUJ == null)
        {
          paramVarArgs = new b("Not all required fields were included: NickName");
          AppMethodBeat.o(32536);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32536);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        eyw localeyw = (eyw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32536);
          return -1;
        case 1: 
          localeyw.MRZ = locala.UbS.readString();
          AppMethodBeat.o(32536);
          return 0;
        case 2: 
          localeyw.oUJ = locala.UbS.readString();
          AppMethodBeat.o(32536);
          return 0;
        }
        localeyw.Nvw = locala.UbS.zl();
        AppMethodBeat.o(32536);
        return 0;
      }
      AppMethodBeat.o(32536);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eyw
 * JD-Core Version:    0.7.0.1
 */