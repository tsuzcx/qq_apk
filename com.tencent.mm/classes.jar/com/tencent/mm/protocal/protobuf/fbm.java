package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fbm
  extends com.tencent.mm.bx.a
{
  public String ILh;
  public String MD5;
  public String URL;
  public String crB;
  public String hAP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32451);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.URL != null) {
        paramVarArgs.g(1, this.URL);
      }
      if (this.hAP != null) {
        paramVarArgs.g(2, this.hAP);
      }
      if (this.crB != null) {
        paramVarArgs.g(3, this.crB);
      }
      if (this.ILh != null) {
        paramVarArgs.g(4, this.ILh);
      }
      if (this.MD5 != null) {
        paramVarArgs.g(5, this.MD5);
      }
      AppMethodBeat.o(32451);
      return 0;
    }
    if (paramInt == 1) {
      if (this.URL == null) {
        break label461;
      }
    }
    label461:
    for (int i = i.a.a.b.b.a.h(1, this.URL) + 0;; i = 0)
    {
      paramInt = i;
      if (this.hAP != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.hAP);
      }
      i = paramInt;
      if (this.crB != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.crB);
      }
      paramInt = i;
      if (this.ILh != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.ILh);
      }
      i = paramInt;
      if (this.MD5 != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.MD5);
      }
      AppMethodBeat.o(32451);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(32451);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        fbm localfbm = (fbm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32451);
          return -1;
        case 1: 
          localfbm.URL = locala.ajGk.readString();
          AppMethodBeat.o(32451);
          return 0;
        case 2: 
          localfbm.hAP = locala.ajGk.readString();
          AppMethodBeat.o(32451);
          return 0;
        case 3: 
          localfbm.crB = locala.ajGk.readString();
          AppMethodBeat.o(32451);
          return 0;
        case 4: 
          localfbm.ILh = locala.ajGk.readString();
          AppMethodBeat.o(32451);
          return 0;
        }
        localfbm.MD5 = locala.ajGk.readString();
        AppMethodBeat.o(32451);
        return 0;
      }
      AppMethodBeat.o(32451);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fbm
 * JD-Core Version:    0.7.0.1
 */