package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class bcz
  extends com.tencent.mm.bx.a
{
  public int ZNI;
  public String ZNJ;
  public int ZNK;
  public int ZNL;
  public String nickname;
  public String xkY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259211);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.nickname != null) {
        paramVarArgs.g(1, this.nickname);
      }
      if (this.xkY != null) {
        paramVarArgs.g(2, this.xkY);
      }
      paramVarArgs.bS(3, this.ZNI);
      if (this.ZNJ != null) {
        paramVarArgs.g(4, this.ZNJ);
      }
      paramVarArgs.bS(5, this.ZNK);
      paramVarArgs.bS(6, this.ZNL);
      AppMethodBeat.o(259211);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nickname == null) {
        break label466;
      }
    }
    label466:
    for (paramInt = i.a.a.b.b.a.h(1, this.nickname) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xkY != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.xkY);
      }
      i += i.a.a.b.b.a.cJ(3, this.ZNI);
      paramInt = i;
      if (this.ZNJ != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.ZNJ);
      }
      i = i.a.a.b.b.a.cJ(5, this.ZNK);
      int j = i.a.a.b.b.a.cJ(6, this.ZNL);
      AppMethodBeat.o(259211);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259211);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        bcz localbcz = (bcz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(259211);
          return -1;
        case 1: 
          localbcz.nickname = locala.ajGk.readString();
          AppMethodBeat.o(259211);
          return 0;
        case 2: 
          localbcz.xkY = locala.ajGk.readString();
          AppMethodBeat.o(259211);
          return 0;
        case 3: 
          localbcz.ZNI = locala.ajGk.aar();
          AppMethodBeat.o(259211);
          return 0;
        case 4: 
          localbcz.ZNJ = locala.ajGk.readString();
          AppMethodBeat.o(259211);
          return 0;
        case 5: 
          localbcz.ZNK = locala.ajGk.aar();
          AppMethodBeat.o(259211);
          return 0;
        }
        localbcz.ZNL = locala.ajGk.aar();
        AppMethodBeat.o(259211);
        return 0;
      }
      AppMethodBeat.o(259211);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bcz
 * JD-Core Version:    0.7.0.1
 */