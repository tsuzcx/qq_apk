package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cai
  extends com.tencent.mm.bx.a
{
  public String DWS;
  public String DWT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72548);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DWS != null) {
        paramVarArgs.d(1, this.DWS);
      }
      if (this.DWT != null) {
        paramVarArgs.d(2, this.DWT);
      }
      AppMethodBeat.o(72548);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DWS == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.e(1, this.DWS) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.DWT != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.DWT);
      }
      AppMethodBeat.o(72548);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(72548);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cai localcai = (cai)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72548);
          return -1;
        case 1: 
          localcai.DWS = locala.KhF.readString();
          AppMethodBeat.o(72548);
          return 0;
        }
        localcai.DWT = locala.KhF.readString();
        AppMethodBeat.o(72548);
        return 0;
      }
      AppMethodBeat.o(72548);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cai
 * JD-Core Version:    0.7.0.1
 */