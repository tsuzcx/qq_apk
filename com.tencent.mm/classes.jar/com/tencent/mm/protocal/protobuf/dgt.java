package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dgt
  extends com.tencent.mm.bx.a
{
  public String dgo;
  public String dlX;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(181514);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dlX != null) {
        paramVarArgs.d(1, this.dlX);
      }
      if (this.dgo != null) {
        paramVarArgs.d(2, this.dgo);
      }
      paramVarArgs.aR(3, this.scene);
      AppMethodBeat.o(181514);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dlX == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = f.a.a.b.b.a.e(1, this.dlX) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.dgo != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.dgo);
      }
      paramInt = f.a.a.b.b.a.bA(3, this.scene);
      AppMethodBeat.o(181514);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(181514);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dgt localdgt = (dgt)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(181514);
          return -1;
        case 1: 
          localdgt.dlX = locala.KhF.readString();
          AppMethodBeat.o(181514);
          return 0;
        case 2: 
          localdgt.dgo = locala.KhF.readString();
          AppMethodBeat.o(181514);
          return 0;
        }
        localdgt.scene = locala.KhF.xS();
        AppMethodBeat.o(181514);
        return 0;
      }
      AppMethodBeat.o(181514);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dgt
 * JD-Core Version:    0.7.0.1
 */