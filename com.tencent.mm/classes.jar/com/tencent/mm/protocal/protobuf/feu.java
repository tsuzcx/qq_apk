package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class feu
  extends com.tencent.mm.bx.a
{
  public int Rgo;
  public int Rgp;
  public String YHn;
  public String YHo;
  public String YHp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125804);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YHn != null) {
        paramVarArgs.g(1, this.YHn);
      }
      if (this.YHo != null) {
        paramVarArgs.g(2, this.YHo);
      }
      if (this.YHp != null) {
        paramVarArgs.g(3, this.YHp);
      }
      paramVarArgs.bS(4, this.Rgo);
      paramVarArgs.bS(5, this.Rgp);
      AppMethodBeat.o(125804);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YHn == null) {
        break label422;
      }
    }
    label422:
    for (int i = i.a.a.b.b.a.h(1, this.YHn) + 0;; i = 0)
    {
      paramInt = i;
      if (this.YHo != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.YHo);
      }
      i = paramInt;
      if (this.YHp != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.YHp);
      }
      paramInt = i.a.a.b.b.a.cJ(4, this.Rgo);
      int j = i.a.a.b.b.a.cJ(5, this.Rgp);
      AppMethodBeat.o(125804);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(125804);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        feu localfeu = (feu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(125804);
          return -1;
        case 1: 
          localfeu.YHn = locala.ajGk.readString();
          AppMethodBeat.o(125804);
          return 0;
        case 2: 
          localfeu.YHo = locala.ajGk.readString();
          AppMethodBeat.o(125804);
          return 0;
        case 3: 
          localfeu.YHp = locala.ajGk.readString();
          AppMethodBeat.o(125804);
          return 0;
        case 4: 
          localfeu.Rgo = locala.ajGk.aar();
          AppMethodBeat.o(125804);
          return 0;
        }
        localfeu.Rgp = locala.ajGk.aar();
        AppMethodBeat.o(125804);
        return 0;
      }
      AppMethodBeat.o(125804);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.feu
 * JD-Core Version:    0.7.0.1
 */