package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fxc
  extends com.tencent.mm.bx.a
{
  public String aaGN;
  public String aaIL;
  public String abUP;
  public String appid;
  public String hhx;
  public String wDe;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123678);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.appid != null) {
        paramVarArgs.g(1, this.appid);
      }
      if (this.hhx != null) {
        paramVarArgs.g(2, this.hhx);
      }
      if (this.aaIL != null) {
        paramVarArgs.g(3, this.aaIL);
      }
      if (this.abUP != null) {
        paramVarArgs.g(4, this.abUP);
      }
      if (this.wDe != null) {
        paramVarArgs.g(5, this.wDe);
      }
      if (this.aaGN != null) {
        paramVarArgs.g(6, this.aaGN);
      }
      AppMethodBeat.o(123678);
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
      if (this.hhx != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.hhx);
      }
      i = paramInt;
      if (this.aaIL != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.aaIL);
      }
      paramInt = i;
      if (this.abUP != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.abUP);
      }
      i = paramInt;
      if (this.wDe != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.wDe);
      }
      paramInt = i;
      if (this.aaGN != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.aaGN);
      }
      AppMethodBeat.o(123678);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(123678);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        fxc localfxc = (fxc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123678);
          return -1;
        case 1: 
          localfxc.appid = locala.ajGk.readString();
          AppMethodBeat.o(123678);
          return 0;
        case 2: 
          localfxc.hhx = locala.ajGk.readString();
          AppMethodBeat.o(123678);
          return 0;
        case 3: 
          localfxc.aaIL = locala.ajGk.readString();
          AppMethodBeat.o(123678);
          return 0;
        case 4: 
          localfxc.abUP = locala.ajGk.readString();
          AppMethodBeat.o(123678);
          return 0;
        case 5: 
          localfxc.wDe = locala.ajGk.readString();
          AppMethodBeat.o(123678);
          return 0;
        }
        localfxc.aaGN = locala.ajGk.readString();
        AppMethodBeat.o(123678);
        return 0;
      }
      AppMethodBeat.o(123678);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fxc
 * JD-Core Version:    0.7.0.1
 */