package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dho
  extends com.tencent.mm.bx.a
{
  public String AesKey;
  public String Md5;
  public String Url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104817);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.Url != null) {
        paramVarArgs.g(1, this.Url);
      }
      if (this.AesKey != null) {
        paramVarArgs.g(2, this.AesKey);
      }
      if (this.Md5 != null) {
        paramVarArgs.g(3, this.Md5);
      }
      AppMethodBeat.o(104817);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Url == null) {
        break label330;
      }
    }
    label330:
    for (int i = i.a.a.b.b.a.h(1, this.Url) + 0;; i = 0)
    {
      paramInt = i;
      if (this.AesKey != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.AesKey);
      }
      i = paramInt;
      if (this.Md5 != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.Md5);
      }
      AppMethodBeat.o(104817);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(104817);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        dho localdho = (dho)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(104817);
          return -1;
        case 1: 
          localdho.Url = locala.ajGk.readString();
          AppMethodBeat.o(104817);
          return 0;
        case 2: 
          localdho.AesKey = locala.ajGk.readString();
          AppMethodBeat.o(104817);
          return 0;
        }
        localdho.Md5 = locala.ajGk.readString();
        AppMethodBeat.o(104817);
        return 0;
      }
      AppMethodBeat.o(104817);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dho
 * JD-Core Version:    0.7.0.1
 */