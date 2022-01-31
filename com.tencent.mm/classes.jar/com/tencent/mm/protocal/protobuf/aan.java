package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aan
  extends com.tencent.mm.bv.a
{
  public String Name;
  public String PriceType;
  public int nuk;
  public int wCm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56778);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.Name != null) {
        paramVarArgs.e(1, this.Name);
      }
      paramVarArgs.aO(2, this.wCm);
      if (this.PriceType != null) {
        paramVarArgs.e(3, this.PriceType);
      }
      paramVarArgs.aO(4, this.nuk);
      AppMethodBeat.o(56778);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Name == null) {
        break label362;
      }
    }
    label362:
    for (paramInt = e.a.a.b.b.a.f(1, this.Name) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.wCm);
      paramInt = i;
      if (this.PriceType != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.PriceType);
      }
      i = e.a.a.b.b.a.bl(4, this.nuk);
      AppMethodBeat.o(56778);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(56778);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        aan localaan = (aan)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(56778);
          return -1;
        case 1: 
          localaan.Name = locala.CLY.readString();
          AppMethodBeat.o(56778);
          return 0;
        case 2: 
          localaan.wCm = locala.CLY.sl();
          AppMethodBeat.o(56778);
          return 0;
        case 3: 
          localaan.PriceType = locala.CLY.readString();
          AppMethodBeat.o(56778);
          return 0;
        }
        localaan.nuk = locala.CLY.sl();
        AppMethodBeat.o(56778);
        return 0;
      }
      AppMethodBeat.o(56778);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aan
 * JD-Core Version:    0.7.0.1
 */