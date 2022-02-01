package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bjt
  extends com.tencent.mm.bx.a
{
  public int action;
  public String doh;
  public String url;
  public String username;
  public String vBP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72510);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.doh != null) {
        paramVarArgs.d(1, this.doh);
      }
      paramVarArgs.aR(2, this.action);
      if (this.url != null) {
        paramVarArgs.d(3, this.url);
      }
      if (this.username != null) {
        paramVarArgs.d(4, this.username);
      }
      if (this.vBP != null) {
        paramVarArgs.d(5, this.vBP);
      }
      AppMethodBeat.o(72510);
      return 0;
    }
    if (paramInt == 1) {
      if (this.doh == null) {
        break label438;
      }
    }
    label438:
    for (paramInt = f.a.a.b.b.a.e(1, this.doh) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.action);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.url);
      }
      i = paramInt;
      if (this.username != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.username);
      }
      paramInt = i;
      if (this.vBP != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.vBP);
      }
      AppMethodBeat.o(72510);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(72510);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bjt localbjt = (bjt)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72510);
          return -1;
        case 1: 
          localbjt.doh = locala.KhF.readString();
          AppMethodBeat.o(72510);
          return 0;
        case 2: 
          localbjt.action = locala.KhF.xS();
          AppMethodBeat.o(72510);
          return 0;
        case 3: 
          localbjt.url = locala.KhF.readString();
          AppMethodBeat.o(72510);
          return 0;
        case 4: 
          localbjt.username = locala.KhF.readString();
          AppMethodBeat.o(72510);
          return 0;
        }
        localbjt.vBP = locala.KhF.readString();
        AppMethodBeat.o(72510);
        return 0;
      }
      AppMethodBeat.o(72510);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bjt
 * JD-Core Version:    0.7.0.1
 */