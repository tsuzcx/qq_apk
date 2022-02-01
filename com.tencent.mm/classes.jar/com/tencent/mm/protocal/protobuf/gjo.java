package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class gjo
  extends com.tencent.mm.bx.a
{
  public String aaGN;
  public String acfJ;
  public String appid;
  public String hhx;
  public String wDe;
  public String wDg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258155);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.appid != null) {
        paramVarArgs.g(1, this.appid);
      }
      if (this.acfJ != null) {
        paramVarArgs.g(2, this.acfJ);
      }
      if (this.wDe != null) {
        paramVarArgs.g(3, this.wDe);
      }
      if (this.hhx != null) {
        paramVarArgs.g(4, this.hhx);
      }
      if (this.aaGN != null) {
        paramVarArgs.g(5, this.aaGN);
      }
      if (this.wDg != null) {
        paramVarArgs.g(6, this.wDg);
      }
      AppMethodBeat.o(258155);
      return 0;
    }
    if (paramInt == 1) {
      if (this.appid == null) {
        break label514;
      }
    }
    label514:
    for (int i = i.a.a.b.b.a.h(1, this.appid) + 0;; i = 0)
    {
      paramInt = i;
      if (this.acfJ != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.acfJ);
      }
      i = paramInt;
      if (this.wDe != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.wDe);
      }
      paramInt = i;
      if (this.hhx != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.hhx);
      }
      i = paramInt;
      if (this.aaGN != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.aaGN);
      }
      paramInt = i;
      if (this.wDg != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.wDg);
      }
      AppMethodBeat.o(258155);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258155);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        gjo localgjo = (gjo)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258155);
          return -1;
        case 1: 
          localgjo.appid = locala.ajGk.readString();
          AppMethodBeat.o(258155);
          return 0;
        case 2: 
          localgjo.acfJ = locala.ajGk.readString();
          AppMethodBeat.o(258155);
          return 0;
        case 3: 
          localgjo.wDe = locala.ajGk.readString();
          AppMethodBeat.o(258155);
          return 0;
        case 4: 
          localgjo.hhx = locala.ajGk.readString();
          AppMethodBeat.o(258155);
          return 0;
        case 5: 
          localgjo.aaGN = locala.ajGk.readString();
          AppMethodBeat.o(258155);
          return 0;
        }
        localgjo.wDg = locala.ajGk.readString();
        AppMethodBeat.o(258155);
        return 0;
      }
      AppMethodBeat.o(258155);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gjo
 * JD-Core Version:    0.7.0.1
 */