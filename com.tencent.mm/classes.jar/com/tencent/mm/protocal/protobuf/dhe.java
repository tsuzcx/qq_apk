package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dhe
  extends com.tencent.mm.bx.a
{
  public String UserName;
  public String ZhO;
  public String ZhP;
  public String aant;
  public String vhX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(138178);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.UserName != null) {
        paramVarArgs.g(1, this.UserName);
      }
      if (this.vhX != null) {
        paramVarArgs.g(2, this.vhX);
      }
      if (this.ZhO != null) {
        paramVarArgs.g(3, this.ZhO);
      }
      if (this.ZhP != null) {
        paramVarArgs.g(4, this.ZhP);
      }
      if (this.aant != null) {
        paramVarArgs.g(5, this.aant);
      }
      AppMethodBeat.o(138178);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UserName == null) {
        break label450;
      }
    }
    label450:
    for (int i = i.a.a.b.b.a.h(1, this.UserName) + 0;; i = 0)
    {
      paramInt = i;
      if (this.vhX != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.vhX);
      }
      i = paramInt;
      if (this.ZhO != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.ZhO);
      }
      paramInt = i;
      if (this.ZhP != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.ZhP);
      }
      i = paramInt;
      if (this.aant != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.aant);
      }
      AppMethodBeat.o(138178);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(138178);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        dhe localdhe = (dhe)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(138178);
          return -1;
        case 1: 
          localdhe.UserName = locala.ajGk.readString();
          AppMethodBeat.o(138178);
          return 0;
        case 2: 
          localdhe.vhX = locala.ajGk.readString();
          AppMethodBeat.o(138178);
          return 0;
        case 3: 
          localdhe.ZhO = locala.ajGk.readString();
          AppMethodBeat.o(138178);
          return 0;
        case 4: 
          localdhe.ZhP = locala.ajGk.readString();
          AppMethodBeat.o(138178);
          return 0;
        }
        localdhe.aant = locala.ajGk.readString();
        AppMethodBeat.o(138178);
        return 0;
      }
      AppMethodBeat.o(138178);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dhe
 * JD-Core Version:    0.7.0.1
 */