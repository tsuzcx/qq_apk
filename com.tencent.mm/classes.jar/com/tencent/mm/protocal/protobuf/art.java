package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class art
  extends com.tencent.mm.bx.a
{
  public String AesKey;
  public String Md5;
  public String ZBp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127471);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.Md5 != null) {
        paramVarArgs.g(1, this.Md5);
      }
      if (this.AesKey != null) {
        paramVarArgs.g(2, this.AesKey);
      }
      if (this.ZBp != null) {
        paramVarArgs.g(3, this.ZBp);
      }
      AppMethodBeat.o(127471);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Md5 == null) {
        break label330;
      }
    }
    label330:
    for (int i = i.a.a.b.b.a.h(1, this.Md5) + 0;; i = 0)
    {
      paramInt = i;
      if (this.AesKey != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.AesKey);
      }
      i = paramInt;
      if (this.ZBp != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.ZBp);
      }
      AppMethodBeat.o(127471);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(127471);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        art localart = (art)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127471);
          return -1;
        case 1: 
          localart.Md5 = locala.ajGk.readString();
          AppMethodBeat.o(127471);
          return 0;
        case 2: 
          localart.AesKey = locala.ajGk.readString();
          AppMethodBeat.o(127471);
          return 0;
        }
        localart.ZBp = locala.ajGk.readString();
        AppMethodBeat.o(127471);
        return 0;
      }
      AppMethodBeat.o(127471);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.art
 * JD-Core Version:    0.7.0.1
 */