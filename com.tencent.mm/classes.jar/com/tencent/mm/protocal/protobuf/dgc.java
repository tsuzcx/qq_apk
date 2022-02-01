package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dgc
  extends com.tencent.mm.bx.a
{
  public String IHW;
  public String UserName;
  public int aaLw;
  public String vgW;
  public String vhX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258126);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.UserName != null) {
        paramVarArgs.g(1, this.UserName);
      }
      if (this.vhX != null) {
        paramVarArgs.g(2, this.vhX);
      }
      if (this.IHW != null) {
        paramVarArgs.g(3, this.IHW);
      }
      if (this.vgW != null) {
        paramVarArgs.g(4, this.vgW);
      }
      paramVarArgs.bS(5, this.aaLw);
      AppMethodBeat.o(258126);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UserName == null) {
        break label434;
      }
    }
    label434:
    for (int i = i.a.a.b.b.a.h(1, this.UserName) + 0;; i = 0)
    {
      paramInt = i;
      if (this.vhX != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.vhX);
      }
      i = paramInt;
      if (this.IHW != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.IHW);
      }
      paramInt = i;
      if (this.vgW != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.vgW);
      }
      i = i.a.a.b.b.a.cJ(5, this.aaLw);
      AppMethodBeat.o(258126);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258126);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        dgc localdgc = (dgc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258126);
          return -1;
        case 1: 
          localdgc.UserName = locala.ajGk.readString();
          AppMethodBeat.o(258126);
          return 0;
        case 2: 
          localdgc.vhX = locala.ajGk.readString();
          AppMethodBeat.o(258126);
          return 0;
        case 3: 
          localdgc.IHW = locala.ajGk.readString();
          AppMethodBeat.o(258126);
          return 0;
        case 4: 
          localdgc.vgW = locala.ajGk.readString();
          AppMethodBeat.o(258126);
          return 0;
        }
        localdgc.aaLw = locala.ajGk.aar();
        AppMethodBeat.o(258126);
        return 0;
      }
      AppMethodBeat.o(258126);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dgc
 * JD-Core Version:    0.7.0.1
 */