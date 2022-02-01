package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cba
  extends com.tencent.mm.bx.a
{
  public String VHT;
  public String Vyi;
  public String pic_url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258435);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.pic_url != null) {
        paramVarArgs.g(1, this.pic_url);
      }
      if (this.VHT != null) {
        paramVarArgs.g(2, this.VHT);
      }
      if (this.Vyi != null) {
        paramVarArgs.g(3, this.Vyi);
      }
      AppMethodBeat.o(258435);
      return 0;
    }
    if (paramInt == 1) {
      if (this.pic_url == null) {
        break label330;
      }
    }
    label330:
    for (int i = i.a.a.b.b.a.h(1, this.pic_url) + 0;; i = 0)
    {
      paramInt = i;
      if (this.VHT != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.VHT);
      }
      i = paramInt;
      if (this.Vyi != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.Vyi);
      }
      AppMethodBeat.o(258435);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258435);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        cba localcba = (cba)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258435);
          return -1;
        case 1: 
          localcba.pic_url = locala.ajGk.readString();
          AppMethodBeat.o(258435);
          return 0;
        case 2: 
          localcba.VHT = locala.ajGk.readString();
          AppMethodBeat.o(258435);
          return 0;
        }
        localcba.Vyi = locala.ajGk.readString();
        AppMethodBeat.o(258435);
        return 0;
      }
      AppMethodBeat.o(258435);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cba
 * JD-Core Version:    0.7.0.1
 */