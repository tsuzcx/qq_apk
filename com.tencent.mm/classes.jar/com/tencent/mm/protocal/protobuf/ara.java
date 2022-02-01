package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ara
  extends com.tencent.mm.bx.a
{
  public String UserName;
  public String Zui;
  public String Zyp;
  public String vhX;
  public int vhk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32210);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.UserName != null) {
        paramVarArgs.g(1, this.UserName);
      }
      if (this.Zyp != null) {
        paramVarArgs.g(2, this.Zyp);
      }
      if (this.vhX != null) {
        paramVarArgs.g(3, this.vhX);
      }
      if (this.Zui != null) {
        paramVarArgs.g(4, this.Zui);
      }
      paramVarArgs.bS(5, this.vhk);
      AppMethodBeat.o(32210);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UserName == null) {
        break label445;
      }
    }
    label445:
    for (int i = i.a.a.b.b.a.h(1, this.UserName) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Zyp != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.Zyp);
      }
      i = paramInt;
      if (this.vhX != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.vhX);
      }
      paramInt = i;
      if (this.Zui != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.Zui);
      }
      i = i.a.a.b.b.a.cJ(5, this.vhk);
      AppMethodBeat.o(32210);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(32210);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        ara localara = (ara)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32210);
          return -1;
        case 1: 
          localara.UserName = locala.ajGk.readString();
          AppMethodBeat.o(32210);
          return 0;
        case 2: 
          localara.Zyp = locala.ajGk.readString();
          AppMethodBeat.o(32210);
          return 0;
        case 3: 
          localara.vhX = locala.ajGk.readString();
          AppMethodBeat.o(32210);
          return 0;
        case 4: 
          localara.Zui = locala.ajGk.readString();
          AppMethodBeat.o(32210);
          return 0;
        }
        localara.vhk = locala.ajGk.aar();
        AppMethodBeat.o(32210);
        return 0;
      }
      AppMethodBeat.o(32210);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ara
 * JD-Core Version:    0.7.0.1
 */