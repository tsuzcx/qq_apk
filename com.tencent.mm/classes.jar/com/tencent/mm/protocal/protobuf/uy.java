package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class uy
  extends com.tencent.mm.bx.a
{
  public String ZaT;
  public int ZaU;
  public String ZaV;
  public String ZaW;
  public String modelName;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116466);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZaT != null) {
        paramVarArgs.g(1, this.ZaT);
      }
      paramVarArgs.bS(2, this.ZaU);
      if (this.ZaV != null) {
        paramVarArgs.g(3, this.ZaV);
      }
      if (this.modelName != null) {
        paramVarArgs.g(4, this.modelName);
      }
      if (this.ZaW != null) {
        paramVarArgs.g(5, this.ZaW);
      }
      AppMethodBeat.o(116466);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZaT == null) {
        break label434;
      }
    }
    label434:
    for (paramInt = i.a.a.b.b.a.h(1, this.ZaT) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.ZaU);
      paramInt = i;
      if (this.ZaV != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.ZaV);
      }
      i = paramInt;
      if (this.modelName != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.modelName);
      }
      paramInt = i;
      if (this.ZaW != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.ZaW);
      }
      AppMethodBeat.o(116466);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(116466);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        uy localuy = (uy)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(116466);
          return -1;
        case 1: 
          localuy.ZaT = locala.ajGk.readString();
          AppMethodBeat.o(116466);
          return 0;
        case 2: 
          localuy.ZaU = locala.ajGk.aar();
          AppMethodBeat.o(116466);
          return 0;
        case 3: 
          localuy.ZaV = locala.ajGk.readString();
          AppMethodBeat.o(116466);
          return 0;
        case 4: 
          localuy.modelName = locala.ajGk.readString();
          AppMethodBeat.o(116466);
          return 0;
        }
        localuy.ZaW = locala.ajGk.readString();
        AppMethodBeat.o(116466);
        return 0;
      }
      AppMethodBeat.o(116466);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.uy
 * JD-Core Version:    0.7.0.1
 */