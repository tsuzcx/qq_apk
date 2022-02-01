package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class cuo
  extends com.tencent.mm.bw.a
{
  public String DQi;
  public String FFT;
  public String iod;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152690);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.iod == null)
      {
        paramVarArgs = new b("Not all required fields were included: tp_username");
        AppMethodBeat.o(152690);
        throw paramVarArgs;
      }
      if (this.FFT == null)
      {
        paramVarArgs = new b("Not all required fields were included: verify_content");
        AppMethodBeat.o(152690);
        throw paramVarArgs;
      }
      if (this.DQi == null)
      {
        paramVarArgs = new b("Not all required fields were included: antispam_ticket");
        AppMethodBeat.o(152690);
        throw paramVarArgs;
      }
      if (this.iod != null) {
        paramVarArgs.d(1, this.iod);
      }
      if (this.FFT != null) {
        paramVarArgs.d(2, this.FFT);
      }
      if (this.DQi != null) {
        paramVarArgs.d(3, this.DQi);
      }
      AppMethodBeat.o(152690);
      return 0;
    }
    if (paramInt == 1) {
      if (this.iod == null) {
        break label478;
      }
    }
    label478:
    for (int i = f.a.a.b.b.a.e(1, this.iod) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FFT != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FFT);
      }
      i = paramInt;
      if (this.DQi != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DQi);
      }
      AppMethodBeat.o(152690);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.iod == null)
        {
          paramVarArgs = new b("Not all required fields were included: tp_username");
          AppMethodBeat.o(152690);
          throw paramVarArgs;
        }
        if (this.FFT == null)
        {
          paramVarArgs = new b("Not all required fields were included: verify_content");
          AppMethodBeat.o(152690);
          throw paramVarArgs;
        }
        if (this.DQi == null)
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
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cuo localcuo = (cuo)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152690);
          return -1;
        case 1: 
          localcuo.iod = locala.LVo.readString();
          AppMethodBeat.o(152690);
          return 0;
        case 2: 
          localcuo.FFT = locala.LVo.readString();
          AppMethodBeat.o(152690);
          return 0;
        }
        localcuo.DQi = locala.LVo.readString();
        AppMethodBeat.o(152690);
        return 0;
      }
      AppMethodBeat.o(152690);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cuo
 * JD-Core Version:    0.7.0.1
 */