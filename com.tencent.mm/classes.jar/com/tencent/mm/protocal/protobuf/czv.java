package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class czv
  extends com.tencent.mm.bx.a
{
  public String businessId = "";
  public String dataPath;
  public String value;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122514);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.value != null) {
        paramVarArgs.g(1, this.value);
      }
      if (this.dataPath != null) {
        paramVarArgs.g(2, this.dataPath);
      }
      if (this.businessId != null) {
        paramVarArgs.g(3, this.businessId);
      }
      AppMethodBeat.o(122514);
      return 0;
    }
    if (paramInt == 1) {
      if (this.value == null) {
        break label330;
      }
    }
    label330:
    for (int i = i.a.a.b.b.a.h(1, this.value) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dataPath != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.dataPath);
      }
      i = paramInt;
      if (this.businessId != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.businessId);
      }
      AppMethodBeat.o(122514);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(122514);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        czv localczv = (czv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(122514);
          return -1;
        case 1: 
          localczv.value = locala.ajGk.readString();
          AppMethodBeat.o(122514);
          return 0;
        case 2: 
          localczv.dataPath = locala.ajGk.readString();
          AppMethodBeat.o(122514);
          return 0;
        }
        localczv.businessId = locala.ajGk.readString();
        AppMethodBeat.o(122514);
        return 0;
      }
      AppMethodBeat.o(122514);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.czv
 * JD-Core Version:    0.7.0.1
 */