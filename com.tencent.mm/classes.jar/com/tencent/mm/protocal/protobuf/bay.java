package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class bay
  extends com.tencent.mm.bw.a
{
  public String ddJ;
  public String djF;
  public String iod;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152580);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.iod == null)
      {
        paramVarArgs = new b("Not all required fields were included: tp_username");
        AppMethodBeat.o(152580);
        throw paramVarArgs;
      }
      if (this.iod != null) {
        paramVarArgs.d(1, this.iod);
      }
      if (this.djF != null) {
        paramVarArgs.d(2, this.djF);
      }
      if (this.ddJ != null) {
        paramVarArgs.d(3, this.ddJ);
      }
      AppMethodBeat.o(152580);
      return 0;
    }
    if (paramInt == 1) {
      if (this.iod == null) {
        break label382;
      }
    }
    label382:
    for (int i = f.a.a.b.b.a.e(1, this.iod) + 0;; i = 0)
    {
      paramInt = i;
      if (this.djF != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.djF);
      }
      i = paramInt;
      if (this.ddJ != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.ddJ);
      }
      AppMethodBeat.o(152580);
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
          AppMethodBeat.o(152580);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152580);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bay localbay = (bay)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152580);
          return -1;
        case 1: 
          localbay.iod = locala.LVo.readString();
          AppMethodBeat.o(152580);
          return 0;
        case 2: 
          localbay.djF = locala.LVo.readString();
          AppMethodBeat.o(152580);
          return 0;
        }
        localbay.ddJ = locala.LVo.readString();
        AppMethodBeat.o(152580);
        return 0;
      }
      AppMethodBeat.o(152580);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bay
 * JD-Core Version:    0.7.0.1
 */