package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dzg
  extends com.tencent.mm.bx.a
{
  public String IHo;
  public int abdZ;
  public String abea;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50095);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.abdZ);
      if (this.IHo != null) {
        paramVarArgs.g(2, this.IHo);
      }
      if (this.abea != null) {
        paramVarArgs.g(3, this.abea);
      }
      AppMethodBeat.o(50095);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.abdZ) + 0;
      paramInt = i;
      if (this.IHo != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.IHo);
      }
      i = paramInt;
      if (this.abea != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.abea);
      }
      AppMethodBeat.o(50095);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(50095);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      dzg localdzg = (dzg)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(50095);
        return -1;
      case 1: 
        localdzg.abdZ = locala.ajGk.aar();
        AppMethodBeat.o(50095);
        return 0;
      case 2: 
        localdzg.IHo = locala.ajGk.readString();
        AppMethodBeat.o(50095);
        return 0;
      }
      localdzg.abea = locala.ajGk.readString();
      AppMethodBeat.o(50095);
      return 0;
    }
    AppMethodBeat.o(50095);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzg
 * JD-Core Version:    0.7.0.1
 */