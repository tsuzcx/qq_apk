package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ber
  extends com.tencent.mm.bx.a
{
  public String ZOX;
  public String ZOY;
  public String ZOZ;
  public String ZPa;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258740);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZOX != null) {
        paramVarArgs.g(1, this.ZOX);
      }
      if (this.ZOY != null) {
        paramVarArgs.g(2, this.ZOY);
      }
      if (this.ZOZ != null) {
        paramVarArgs.g(101, this.ZOZ);
      }
      if (this.ZPa != null) {
        paramVarArgs.g(102, this.ZPa);
      }
      AppMethodBeat.o(258740);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZOX == null) {
        break label406;
      }
    }
    label406:
    for (int i = i.a.a.b.b.a.h(1, this.ZOX) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ZOY != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.ZOY);
      }
      i = paramInt;
      if (this.ZOZ != null) {
        i = paramInt + i.a.a.b.b.a.h(101, this.ZOZ);
      }
      paramInt = i;
      if (this.ZPa != null) {
        paramInt = i + i.a.a.b.b.a.h(102, this.ZPa);
      }
      AppMethodBeat.o(258740);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258740);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        ber localber = (ber)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258740);
          return -1;
        case 1: 
          localber.ZOX = locala.ajGk.readString();
          AppMethodBeat.o(258740);
          return 0;
        case 2: 
          localber.ZOY = locala.ajGk.readString();
          AppMethodBeat.o(258740);
          return 0;
        case 101: 
          localber.ZOZ = locala.ajGk.readString();
          AppMethodBeat.o(258740);
          return 0;
        }
        localber.ZPa = locala.ajGk.readString();
        AppMethodBeat.o(258740);
        return 0;
      }
      AppMethodBeat.o(258740);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ber
 * JD-Core Version:    0.7.0.1
 */