package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class dk
  extends com.tencent.mm.bw.a
{
  public long KHA;
  public String KHz;
  public String jGZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152487);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.jGZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: tp_username");
        AppMethodBeat.o(152487);
        throw paramVarArgs;
      }
      if (this.KHz == null)
      {
        paramVarArgs = new b("Not all required fields were included: antispam_ticket");
        AppMethodBeat.o(152487);
        throw paramVarArgs;
      }
      if (this.jGZ != null) {
        paramVarArgs.e(1, this.jGZ);
      }
      if (this.KHz != null) {
        paramVarArgs.e(2, this.KHz);
      }
      paramVarArgs.bb(3, this.KHA);
      AppMethodBeat.o(152487);
      return 0;
    }
    if (paramInt == 1) {
      if (this.jGZ == null) {
        break label414;
      }
    }
    label414:
    for (paramInt = g.a.a.b.b.a.f(1, this.jGZ) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.KHz != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.KHz);
      }
      paramInt = g.a.a.b.b.a.r(3, this.KHA);
      AppMethodBeat.o(152487);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.jGZ == null)
        {
          paramVarArgs = new b("Not all required fields were included: tp_username");
          AppMethodBeat.o(152487);
          throw paramVarArgs;
        }
        if (this.KHz == null)
        {
          paramVarArgs = new b("Not all required fields were included: antispam_ticket");
          AppMethodBeat.o(152487);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152487);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dk localdk = (dk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152487);
          return -1;
        case 1: 
          localdk.jGZ = locala.UbS.readString();
          AppMethodBeat.o(152487);
          return 0;
        case 2: 
          localdk.KHz = locala.UbS.readString();
          AppMethodBeat.o(152487);
          return 0;
        }
        localdk.KHA = locala.UbS.zl();
        AppMethodBeat.o(152487);
        return 0;
      }
      AppMethodBeat.o(152487);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dk
 * JD-Core Version:    0.7.0.1
 */