package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class arp
  extends com.tencent.mm.bx.a
{
  public String ZBm;
  public String ZBn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127469);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZBm != null) {
        paramVarArgs.g(1, this.ZBm);
      }
      if (this.ZBn != null) {
        paramVarArgs.g(2, this.ZBn);
      }
      AppMethodBeat.o(127469);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZBm == null) {
        break label270;
      }
    }
    label270:
    for (paramInt = i.a.a.b.b.a.h(1, this.ZBm) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ZBn != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.ZBn);
      }
      AppMethodBeat.o(127469);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(127469);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        arp localarp = (arp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127469);
          return -1;
        case 1: 
          localarp.ZBm = locala.ajGk.readString();
          AppMethodBeat.o(127469);
          return 0;
        }
        localarp.ZBn = locala.ajGk.readString();
        AppMethodBeat.o(127469);
        return 0;
      }
      AppMethodBeat.o(127469);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.arp
 * JD-Core Version:    0.7.0.1
 */