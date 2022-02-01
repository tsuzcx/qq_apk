package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class x
  extends com.tencent.mm.bx.a
{
  public String YAf;
  public long YAh;
  public int YAi;
  public long YzZ;
  public String nQV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91332);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.nQV != null) {
        paramVarArgs.g(1, this.nQV);
      }
      paramVarArgs.bv(2, this.YzZ);
      paramVarArgs.bv(3, this.YAh);
      paramVarArgs.bS(4, this.YAi);
      if (this.YAf != null) {
        paramVarArgs.g(5, this.YAf);
      }
      AppMethodBeat.o(91332);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nQV == null) {
        break label398;
      }
    }
    label398:
    for (paramInt = i.a.a.b.b.a.h(1, this.nQV) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.q(2, this.YzZ) + i.a.a.b.b.a.q(3, this.YAh) + i.a.a.b.b.a.cJ(4, this.YAi);
      paramInt = i;
      if (this.YAf != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.YAf);
      }
      AppMethodBeat.o(91332);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91332);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        x localx = (x)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91332);
          return -1;
        case 1: 
          localx.nQV = locala.ajGk.readString();
          AppMethodBeat.o(91332);
          return 0;
        case 2: 
          localx.YzZ = locala.ajGk.aaw();
          AppMethodBeat.o(91332);
          return 0;
        case 3: 
          localx.YAh = locala.ajGk.aaw();
          AppMethodBeat.o(91332);
          return 0;
        case 4: 
          localx.YAi = locala.ajGk.aar();
          AppMethodBeat.o(91332);
          return 0;
        }
        localx.YAf = locala.ajGk.readString();
        AppMethodBeat.o(91332);
        return 0;
      }
      AppMethodBeat.o(91332);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.x
 * JD-Core Version:    0.7.0.1
 */