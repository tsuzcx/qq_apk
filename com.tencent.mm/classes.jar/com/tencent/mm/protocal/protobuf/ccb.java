package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ccb
  extends com.tencent.mm.bx.a
{
  public String joy;
  public String token;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(193070);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.joy != null) {
        paramVarArgs.d(1, this.joy);
      }
      if (this.url != null) {
        paramVarArgs.d(2, this.url);
      }
      if (this.token != null) {
        paramVarArgs.d(3, this.token);
      }
      AppMethodBeat.o(193070);
      return 0;
    }
    if (paramInt == 1) {
      if (this.joy == null) {
        break label334;
      }
    }
    label334:
    for (int i = f.a.a.b.b.a.e(1, this.joy) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.url);
      }
      i = paramInt;
      if (this.token != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.token);
      }
      AppMethodBeat.o(193070);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(193070);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ccb localccb = (ccb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(193070);
          return -1;
        case 1: 
          localccb.joy = locala.NPN.readString();
          AppMethodBeat.o(193070);
          return 0;
        case 2: 
          localccb.url = locala.NPN.readString();
          AppMethodBeat.o(193070);
          return 0;
        }
        localccb.token = locala.NPN.readString();
        AppMethodBeat.o(193070);
        return 0;
      }
      AppMethodBeat.o(193070);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ccb
 * JD-Core Version:    0.7.0.1
 */