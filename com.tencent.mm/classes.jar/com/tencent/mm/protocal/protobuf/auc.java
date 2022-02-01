package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class auc
  extends com.tencent.mm.bw.a
{
  public String GKZ;
  public long GLa;
  public int drN;
  public String id;
  public int tyw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32213);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.id != null) {
        paramVarArgs.d(1, this.id);
      }
      paramVarArgs.aS(2, this.tyw);
      if (this.GKZ != null) {
        paramVarArgs.d(3, this.GKZ);
      }
      paramVarArgs.aZ(4, this.GLa);
      paramVarArgs.aS(5, this.drN);
      AppMethodBeat.o(32213);
      return 0;
    }
    if (paramInt == 1) {
      if (this.id == null) {
        break label421;
      }
    }
    label421:
    for (paramInt = f.a.a.b.b.a.e(1, this.id) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.tyw);
      paramInt = i;
      if (this.GKZ != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.GKZ);
      }
      i = f.a.a.b.b.a.p(4, this.GLa);
      int j = f.a.a.b.b.a.bz(5, this.drN);
      AppMethodBeat.o(32213);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(32213);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        auc localauc = (auc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32213);
          return -1;
        case 1: 
          localauc.id = locala.OmT.readString();
          AppMethodBeat.o(32213);
          return 0;
        case 2: 
          localauc.tyw = locala.OmT.zc();
          AppMethodBeat.o(32213);
          return 0;
        case 3: 
          localauc.GKZ = locala.OmT.readString();
          AppMethodBeat.o(32213);
          return 0;
        case 4: 
          localauc.GLa = locala.OmT.zd();
          AppMethodBeat.o(32213);
          return 0;
        }
        localauc.drN = locala.OmT.zc();
        AppMethodBeat.o(32213);
        return 0;
      }
      AppMethodBeat.o(32213);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.auc
 * JD-Core Version:    0.7.0.1
 */