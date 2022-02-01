package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fuo
  extends com.tencent.mm.bx.a
{
  public String Poo;
  public int Pop;
  public String scope;
  public int state;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(74674);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.scope != null) {
        paramVarArgs.g(1, this.scope);
      }
      if (this.Poo != null) {
        paramVarArgs.g(2, this.Poo);
      }
      paramVarArgs.bS(3, this.state);
      paramVarArgs.bS(4, this.Pop);
      AppMethodBeat.o(74674);
      return 0;
    }
    if (paramInt == 1) {
      if (this.scope == null) {
        break label362;
      }
    }
    label362:
    for (paramInt = i.a.a.b.b.a.h(1, this.scope) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Poo != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.Poo);
      }
      paramInt = i.a.a.b.b.a.cJ(3, this.state);
      int j = i.a.a.b.b.a.cJ(4, this.Pop);
      AppMethodBeat.o(74674);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(74674);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        fuo localfuo = (fuo)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(74674);
          return -1;
        case 1: 
          localfuo.scope = locala.ajGk.readString();
          AppMethodBeat.o(74674);
          return 0;
        case 2: 
          localfuo.Poo = locala.ajGk.readString();
          AppMethodBeat.o(74674);
          return 0;
        case 3: 
          localfuo.state = locala.ajGk.aar();
          AppMethodBeat.o(74674);
          return 0;
        }
        localfuo.Pop = locala.ajGk.aar();
        AppMethodBeat.o(74674);
        return 0;
      }
      AppMethodBeat.o(74674);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fuo
 * JD-Core Version:    0.7.0.1
 */