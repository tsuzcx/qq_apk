package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class dtw
  extends com.tencent.mm.bw.a
{
  public long KHA;
  public String KHz;
  public String MVG;
  public String jGZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152690);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.jGZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: tp_username");
        AppMethodBeat.o(152690);
        throw paramVarArgs;
      }
      if (this.MVG == null)
      {
        paramVarArgs = new b("Not all required fields were included: verify_content");
        AppMethodBeat.o(152690);
        throw paramVarArgs;
      }
      if (this.KHz == null)
      {
        paramVarArgs = new b("Not all required fields were included: antispam_ticket");
        AppMethodBeat.o(152690);
        throw paramVarArgs;
      }
      if (this.jGZ != null) {
        paramVarArgs.e(1, this.jGZ);
      }
      if (this.MVG != null) {
        paramVarArgs.e(2, this.MVG);
      }
      if (this.KHz != null) {
        paramVarArgs.e(3, this.KHz);
      }
      paramVarArgs.bb(4, this.KHA);
      AppMethodBeat.o(152690);
      return 0;
    }
    if (paramInt == 1) {
      if (this.jGZ == null) {
        break label522;
      }
    }
    label522:
    for (int i = g.a.a.b.b.a.f(1, this.jGZ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.MVG != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.MVG);
      }
      i = paramInt;
      if (this.KHz != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.KHz);
      }
      paramInt = g.a.a.b.b.a.r(4, this.KHA);
      AppMethodBeat.o(152690);
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
          AppMethodBeat.o(152690);
          throw paramVarArgs;
        }
        if (this.MVG == null)
        {
          paramVarArgs = new b("Not all required fields were included: verify_content");
          AppMethodBeat.o(152690);
          throw paramVarArgs;
        }
        if (this.KHz == null)
        {
          paramVarArgs = new b("Not all required fields were included: antispam_ticket");
          AppMethodBeat.o(152690);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152690);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dtw localdtw = (dtw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152690);
          return -1;
        case 1: 
          localdtw.jGZ = locala.UbS.readString();
          AppMethodBeat.o(152690);
          return 0;
        case 2: 
          localdtw.MVG = locala.UbS.readString();
          AppMethodBeat.o(152690);
          return 0;
        case 3: 
          localdtw.KHz = locala.UbS.readString();
          AppMethodBeat.o(152690);
          return 0;
        }
        localdtw.KHA = locala.UbS.zl();
        AppMethodBeat.o(152690);
        return 0;
      }
      AppMethodBeat.o(152690);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dtw
 * JD-Core Version:    0.7.0.1
 */