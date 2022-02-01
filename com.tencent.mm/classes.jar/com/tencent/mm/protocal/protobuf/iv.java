package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class iv
  extends com.tencent.mm.bw.a
{
  public String FUi;
  public String FUj;
  public String FUk;
  public String FUl;
  public String FUm;
  public String oGf;
  public String pqW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124392);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FUi != null) {
        paramVarArgs.d(1, this.FUi);
      }
      if (this.FUj != null) {
        paramVarArgs.d(2, this.FUj);
      }
      if (this.FUk != null) {
        paramVarArgs.d(3, this.FUk);
      }
      if (this.pqW != null) {
        paramVarArgs.d(4, this.pqW);
      }
      if (this.oGf != null) {
        paramVarArgs.d(5, this.oGf);
      }
      if (this.FUl != null) {
        paramVarArgs.d(6, this.FUl);
      }
      if (this.FUm != null) {
        paramVarArgs.d(7, this.FUm);
      }
      AppMethodBeat.o(124392);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FUi == null) {
        break label578;
      }
    }
    label578:
    for (int i = f.a.a.b.b.a.e(1, this.FUi) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FUj != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FUj);
      }
      i = paramInt;
      if (this.FUk != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FUk);
      }
      paramInt = i;
      if (this.pqW != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.pqW);
      }
      i = paramInt;
      if (this.oGf != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.oGf);
      }
      paramInt = i;
      if (this.FUl != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FUl);
      }
      i = paramInt;
      if (this.FUm != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.FUm);
      }
      AppMethodBeat.o(124392);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(124392);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        iv localiv = (iv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124392);
          return -1;
        case 1: 
          localiv.FUi = locala.OmT.readString();
          AppMethodBeat.o(124392);
          return 0;
        case 2: 
          localiv.FUj = locala.OmT.readString();
          AppMethodBeat.o(124392);
          return 0;
        case 3: 
          localiv.FUk = locala.OmT.readString();
          AppMethodBeat.o(124392);
          return 0;
        case 4: 
          localiv.pqW = locala.OmT.readString();
          AppMethodBeat.o(124392);
          return 0;
        case 5: 
          localiv.oGf = locala.OmT.readString();
          AppMethodBeat.o(124392);
          return 0;
        case 6: 
          localiv.FUl = locala.OmT.readString();
          AppMethodBeat.o(124392);
          return 0;
        }
        localiv.FUm = locala.OmT.readString();
        AppMethodBeat.o(124392);
        return 0;
      }
      AppMethodBeat.o(124392);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.iv
 * JD-Core Version:    0.7.0.1
 */