package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class anm
  extends com.tencent.mm.bx.a
{
  public String AesKey;
  public int Nju;
  public String Url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104771);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.Url != null) {
        paramVarArgs.g(1, this.Url);
      }
      if (this.AesKey != null) {
        paramVarArgs.g(2, this.AesKey);
      }
      paramVarArgs.bS(3, this.Nju);
      AppMethodBeat.o(104771);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Url == null) {
        break label314;
      }
    }
    label314:
    for (paramInt = i.a.a.b.b.a.h(1, this.Url) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.AesKey != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.AesKey);
      }
      paramInt = i.a.a.b.b.a.cJ(3, this.Nju);
      AppMethodBeat.o(104771);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(104771);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        anm localanm = (anm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(104771);
          return -1;
        case 1: 
          localanm.Url = locala.ajGk.readString();
          AppMethodBeat.o(104771);
          return 0;
        case 2: 
          localanm.AesKey = locala.ajGk.readString();
          AppMethodBeat.o(104771);
          return 0;
        }
        localanm.Nju = locala.ajGk.aar();
        AppMethodBeat.o(104771);
        return 0;
      }
      AppMethodBeat.o(104771);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.anm
 * JD-Core Version:    0.7.0.1
 */