package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cuj
  extends com.tencent.mm.bx.a
{
  public String Url;
  public int aazR;
  public int aazS;
  public String aazT;
  public String aazU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152607);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.Url != null) {
        paramVarArgs.g(1, this.Url);
      }
      paramVarArgs.bS(2, this.aazR);
      paramVarArgs.bS(3, this.aazS);
      if (this.aazT != null) {
        paramVarArgs.g(4, this.aazT);
      }
      if (this.aazU != null) {
        paramVarArgs.g(5, this.aazU);
      }
      AppMethodBeat.o(152607);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Url == null) {
        break label418;
      }
    }
    label418:
    for (paramInt = i.a.a.b.b.a.h(1, this.Url) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.aazR) + i.a.a.b.b.a.cJ(3, this.aazS);
      paramInt = i;
      if (this.aazT != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.aazT);
      }
      i = paramInt;
      if (this.aazU != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.aazU);
      }
      AppMethodBeat.o(152607);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(152607);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        cuj localcuj = (cuj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152607);
          return -1;
        case 1: 
          localcuj.Url = locala.ajGk.readString();
          AppMethodBeat.o(152607);
          return 0;
        case 2: 
          localcuj.aazR = locala.ajGk.aar();
          AppMethodBeat.o(152607);
          return 0;
        case 3: 
          localcuj.aazS = locala.ajGk.aar();
          AppMethodBeat.o(152607);
          return 0;
        case 4: 
          localcuj.aazT = locala.ajGk.readString();
          AppMethodBeat.o(152607);
          return 0;
        }
        localcuj.aazU = locala.ajGk.readString();
        AppMethodBeat.o(152607);
        return 0;
      }
      AppMethodBeat.o(152607);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cuj
 * JD-Core Version:    0.7.0.1
 */