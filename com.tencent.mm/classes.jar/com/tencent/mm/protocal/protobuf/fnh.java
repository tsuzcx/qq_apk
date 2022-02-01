package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fnh
  extends com.tencent.mm.bx.a
{
  public String ZmZ;
  public String Zna;
  public String jump_url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258454);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZmZ != null) {
        paramVarArgs.g(1, this.ZmZ);
      }
      if (this.Zna != null) {
        paramVarArgs.g(2, this.Zna);
      }
      if (this.jump_url != null) {
        paramVarArgs.g(3, this.jump_url);
      }
      AppMethodBeat.o(258454);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZmZ == null) {
        break label330;
      }
    }
    label330:
    for (int i = i.a.a.b.b.a.h(1, this.ZmZ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Zna != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.Zna);
      }
      i = paramInt;
      if (this.jump_url != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.jump_url);
      }
      AppMethodBeat.o(258454);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258454);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        fnh localfnh = (fnh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258454);
          return -1;
        case 1: 
          localfnh.ZmZ = locala.ajGk.readString();
          AppMethodBeat.o(258454);
          return 0;
        case 2: 
          localfnh.Zna = locala.ajGk.readString();
          AppMethodBeat.o(258454);
          return 0;
        }
        localfnh.jump_url = locala.ajGk.readString();
        AppMethodBeat.o(258454);
        return 0;
      }
      AppMethodBeat.o(258454);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fnh
 * JD-Core Version:    0.7.0.1
 */