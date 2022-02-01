package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dam
  extends com.tencent.mm.bx.a
{
  public String DII;
  public int Esi;
  public int Esj;
  public String hnC;
  public String sdZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153306);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DII != null) {
        paramVarArgs.d(1, this.DII);
      }
      paramVarArgs.aR(2, this.Esi);
      paramVarArgs.aR(3, this.Esj);
      if (this.sdZ != null) {
        paramVarArgs.d(4, this.sdZ);
      }
      if (this.hnC != null) {
        paramVarArgs.d(5, this.hnC);
      }
      AppMethodBeat.o(153306);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DII == null) {
        break label422;
      }
    }
    label422:
    for (paramInt = f.a.a.b.b.a.e(1, this.DII) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.Esi) + f.a.a.b.b.a.bA(3, this.Esj);
      paramInt = i;
      if (this.sdZ != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.sdZ);
      }
      i = paramInt;
      if (this.hnC != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.hnC);
      }
      AppMethodBeat.o(153306);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(153306);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dam localdam = (dam)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(153306);
          return -1;
        case 1: 
          localdam.DII = locala.KhF.readString();
          AppMethodBeat.o(153306);
          return 0;
        case 2: 
          localdam.Esi = locala.KhF.xS();
          AppMethodBeat.o(153306);
          return 0;
        case 3: 
          localdam.Esj = locala.KhF.xS();
          AppMethodBeat.o(153306);
          return 0;
        case 4: 
          localdam.sdZ = locala.KhF.readString();
          AppMethodBeat.o(153306);
          return 0;
        }
        localdam.hnC = locala.KhF.readString();
        AppMethodBeat.o(153306);
        return 0;
      }
      AppMethodBeat.o(153306);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dam
 * JD-Core Version:    0.7.0.1
 */