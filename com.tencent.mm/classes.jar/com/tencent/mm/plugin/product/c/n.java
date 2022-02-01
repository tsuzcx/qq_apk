package com.tencent.mm.plugin.product.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class n
  extends com.tencent.mm.bx.a
{
  public String dlB;
  public int dtM;
  public String name;
  public String username;
  public String uwS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91282);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dlB != null) {
        paramVarArgs.d(1, this.dlB);
      }
      if (this.name != null) {
        paramVarArgs.d(2, this.name);
      }
      if (this.uwS != null) {
        paramVarArgs.d(3, this.uwS);
      }
      if (this.username != null) {
        paramVarArgs.d(4, this.username);
      }
      paramVarArgs.aR(5, this.dtM);
      AppMethodBeat.o(91282);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dlB == null) {
        break label438;
      }
    }
    label438:
    for (int i = f.a.a.b.b.a.e(1, this.dlB) + 0;; i = 0)
    {
      paramInt = i;
      if (this.name != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.name);
      }
      i = paramInt;
      if (this.uwS != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.uwS);
      }
      paramInt = i;
      if (this.username != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.username);
      }
      i = f.a.a.b.b.a.bA(5, this.dtM);
      AppMethodBeat.o(91282);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(91282);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        n localn = (n)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91282);
          return -1;
        case 1: 
          localn.dlB = locala.KhF.readString();
          AppMethodBeat.o(91282);
          return 0;
        case 2: 
          localn.name = locala.KhF.readString();
          AppMethodBeat.o(91282);
          return 0;
        case 3: 
          localn.uwS = locala.KhF.readString();
          AppMethodBeat.o(91282);
          return 0;
        case 4: 
          localn.username = locala.KhF.readString();
          AppMethodBeat.o(91282);
          return 0;
        }
        localn.dtM = locala.KhF.xS();
        AppMethodBeat.o(91282);
        return 0;
      }
      AppMethodBeat.o(91282);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.product.c.n
 * JD-Core Version:    0.7.0.1
 */