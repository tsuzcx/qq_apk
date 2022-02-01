package com.tencent.mm.plugin.product.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends com.tencent.mm.bx.a
{
  public String IGU;
  public String IHo;
  public String MRj;
  public String nUB;
  public int vhJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91264);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.IGU != null) {
        paramVarArgs.g(1, this.IGU);
      }
      if (this.MRj != null) {
        paramVarArgs.g(2, this.MRj);
      }
      paramVarArgs.bS(3, this.vhJ);
      if (this.nUB != null) {
        paramVarArgs.g(4, this.nUB);
      }
      if (this.IHo != null) {
        paramVarArgs.g(5, this.IHo);
      }
      AppMethodBeat.o(91264);
      return 0;
    }
    if (paramInt == 1) {
      if (this.IGU == null) {
        break label434;
      }
    }
    label434:
    for (paramInt = i.a.a.b.b.a.h(1, this.IGU) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.MRj != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.MRj);
      }
      i += i.a.a.b.b.a.cJ(3, this.vhJ);
      paramInt = i;
      if (this.nUB != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.nUB);
      }
      i = paramInt;
      if (this.IHo != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.IHo);
      }
      AppMethodBeat.o(91264);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91264);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        a locala1 = (a)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91264);
          return -1;
        case 1: 
          locala1.IGU = locala.ajGk.readString();
          AppMethodBeat.o(91264);
          return 0;
        case 2: 
          locala1.MRj = locala.ajGk.readString();
          AppMethodBeat.o(91264);
          return 0;
        case 3: 
          locala1.vhJ = locala.ajGk.aar();
          AppMethodBeat.o(91264);
          return 0;
        case 4: 
          locala1.nUB = locala.ajGk.readString();
          AppMethodBeat.o(91264);
          return 0;
        }
        locala1.IHo = locala.ajGk.readString();
        AppMethodBeat.o(91264);
        return 0;
      }
      AppMethodBeat.o(91264);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.product.b.a
 * JD-Core Version:    0.7.0.1
 */