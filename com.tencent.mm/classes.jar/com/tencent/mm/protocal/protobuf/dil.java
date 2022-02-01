package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dil
  extends com.tencent.mm.bx.a
{
  public String scope;
  public int state;
  public int wdA;
  public String wdz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(74674);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.scope != null) {
        paramVarArgs.d(1, this.scope);
      }
      if (this.wdz != null) {
        paramVarArgs.d(2, this.wdz);
      }
      paramVarArgs.aR(3, this.state);
      paramVarArgs.aR(4, this.wdA);
      AppMethodBeat.o(74674);
      return 0;
    }
    if (paramInt == 1) {
      if (this.scope == null) {
        break label366;
      }
    }
    label366:
    for (paramInt = f.a.a.b.b.a.e(1, this.scope) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.wdz != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.wdz);
      }
      paramInt = f.a.a.b.b.a.bA(3, this.state);
      int j = f.a.a.b.b.a.bA(4, this.wdA);
      AppMethodBeat.o(74674);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(74674);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dil localdil = (dil)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(74674);
          return -1;
        case 1: 
          localdil.scope = locala.KhF.readString();
          AppMethodBeat.o(74674);
          return 0;
        case 2: 
          localdil.wdz = locala.KhF.readString();
          AppMethodBeat.o(74674);
          return 0;
        case 3: 
          localdil.state = locala.KhF.xS();
          AppMethodBeat.o(74674);
          return 0;
        }
        localdil.wdA = locala.KhF.xS();
        AppMethodBeat.o(74674);
        return 0;
      }
      AppMethodBeat.o(74674);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dil
 * JD-Core Version:    0.7.0.1
 */