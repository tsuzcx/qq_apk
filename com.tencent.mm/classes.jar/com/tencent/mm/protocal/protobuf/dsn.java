package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dsn
  extends com.tencent.mm.bx.a
{
  public String appid;
  public String oOZ;
  public String xmo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259791);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.appid != null) {
        paramVarArgs.g(1, this.appid);
      }
      if (this.oOZ != null) {
        paramVarArgs.g(2, this.oOZ);
      }
      if (this.xmo != null) {
        paramVarArgs.g(3, this.xmo);
      }
      AppMethodBeat.o(259791);
      return 0;
    }
    if (paramInt == 1) {
      if (this.appid == null) {
        break label330;
      }
    }
    label330:
    for (int i = i.a.a.b.b.a.h(1, this.appid) + 0;; i = 0)
    {
      paramInt = i;
      if (this.oOZ != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.oOZ);
      }
      i = paramInt;
      if (this.xmo != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.xmo);
      }
      AppMethodBeat.o(259791);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259791);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        dsn localdsn = (dsn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(259791);
          return -1;
        case 1: 
          localdsn.appid = locala.ajGk.readString();
          AppMethodBeat.o(259791);
          return 0;
        case 2: 
          localdsn.oOZ = locala.ajGk.readString();
          AppMethodBeat.o(259791);
          return 0;
        }
        localdsn.xmo = locala.ajGk.readString();
        AppMethodBeat.o(259791);
        return 0;
      }
      AppMethodBeat.o(259791);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dsn
 * JD-Core Version:    0.7.0.1
 */