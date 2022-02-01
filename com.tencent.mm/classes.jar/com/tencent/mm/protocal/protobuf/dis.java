package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dis
  extends com.tencent.mm.bx.a
{
  public String YBM;
  public String aaNn;
  public String aaNt;
  public String nickname;
  public String xkY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260070);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aaNt != null) {
        paramVarArgs.g(1, this.aaNt);
      }
      if (this.nickname != null) {
        paramVarArgs.g(2, this.nickname);
      }
      if (this.xkY != null) {
        paramVarArgs.g(3, this.xkY);
      }
      if (this.aaNn != null) {
        paramVarArgs.g(4, this.aaNn);
      }
      if (this.YBM != null) {
        paramVarArgs.g(5, this.YBM);
      }
      AppMethodBeat.o(260070);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aaNt == null) {
        break label450;
      }
    }
    label450:
    for (int i = i.a.a.b.b.a.h(1, this.aaNt) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.nickname);
      }
      i = paramInt;
      if (this.xkY != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.xkY);
      }
      paramInt = i;
      if (this.aaNn != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.aaNn);
      }
      i = paramInt;
      if (this.YBM != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.YBM);
      }
      AppMethodBeat.o(260070);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(260070);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        dis localdis = (dis)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(260070);
          return -1;
        case 1: 
          localdis.aaNt = locala.ajGk.readString();
          AppMethodBeat.o(260070);
          return 0;
        case 2: 
          localdis.nickname = locala.ajGk.readString();
          AppMethodBeat.o(260070);
          return 0;
        case 3: 
          localdis.xkY = locala.ajGk.readString();
          AppMethodBeat.o(260070);
          return 0;
        case 4: 
          localdis.aaNn = locala.ajGk.readString();
          AppMethodBeat.o(260070);
          return 0;
        }
        localdis.YBM = locala.ajGk.readString();
        AppMethodBeat.o(260070);
        return 0;
      }
      AppMethodBeat.o(260070);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dis
 * JD-Core Version:    0.7.0.1
 */