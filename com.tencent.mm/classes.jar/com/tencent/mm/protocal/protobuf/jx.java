package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class jx
  extends com.tencent.mm.bx.a
{
  public String YMj;
  public String YMk;
  public String imei;
  public String modelName;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116465);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.imei != null) {
        paramVarArgs.g(1, this.imei);
      }
      if (this.YMj != null) {
        paramVarArgs.g(2, this.YMj);
      }
      if (this.modelName != null) {
        paramVarArgs.g(3, this.modelName);
      }
      if (this.YMk != null) {
        paramVarArgs.g(4, this.YMk);
      }
      AppMethodBeat.o(116465);
      return 0;
    }
    if (paramInt == 1) {
      if (this.imei == null) {
        break label390;
      }
    }
    label390:
    for (int i = i.a.a.b.b.a.h(1, this.imei) + 0;; i = 0)
    {
      paramInt = i;
      if (this.YMj != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.YMj);
      }
      i = paramInt;
      if (this.modelName != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.modelName);
      }
      paramInt = i;
      if (this.YMk != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.YMk);
      }
      AppMethodBeat.o(116465);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(116465);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        jx localjx = (jx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(116465);
          return -1;
        case 1: 
          localjx.imei = locala.ajGk.readString();
          AppMethodBeat.o(116465);
          return 0;
        case 2: 
          localjx.YMj = locala.ajGk.readString();
          AppMethodBeat.o(116465);
          return 0;
        case 3: 
          localjx.modelName = locala.ajGk.readString();
          AppMethodBeat.o(116465);
          return 0;
        }
        localjx.YMk = locala.ajGk.readString();
        AppMethodBeat.o(116465);
        return 0;
      }
      AppMethodBeat.o(116465);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.jx
 * JD-Core Version:    0.7.0.1
 */