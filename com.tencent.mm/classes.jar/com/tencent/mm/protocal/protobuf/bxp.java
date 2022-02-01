package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bxp
  extends com.tencent.mm.bw.a
{
  public int FYj;
  public int HeR;
  public int Hko;
  public int Hkp;
  public String Hkq;
  public int Hkr;
  public int Scene;
  public String dwb;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147770);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dwb != null) {
        paramVarArgs.d(1, this.dwb);
      }
      if (this.username != null) {
        paramVarArgs.d(2, this.username);
      }
      paramVarArgs.aS(3, this.HeR);
      paramVarArgs.aS(4, this.FYj);
      paramVarArgs.aS(5, this.Scene);
      paramVarArgs.aS(6, this.Hko);
      paramVarArgs.aS(7, this.Hkp);
      if (this.Hkq != null) {
        paramVarArgs.d(8, this.Hkq);
      }
      paramVarArgs.aS(9, this.Hkr);
      AppMethodBeat.o(147770);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dwb == null) {
        break label598;
      }
    }
    label598:
    for (paramInt = f.a.a.b.b.a.e(1, this.dwb) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.username != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.username);
      }
      i = i + f.a.a.b.b.a.bz(3, this.HeR) + f.a.a.b.b.a.bz(4, this.FYj) + f.a.a.b.b.a.bz(5, this.Scene) + f.a.a.b.b.a.bz(6, this.Hko) + f.a.a.b.b.a.bz(7, this.Hkp);
      paramInt = i;
      if (this.Hkq != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.Hkq);
      }
      i = f.a.a.b.b.a.bz(9, this.Hkr);
      AppMethodBeat.o(147770);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(147770);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bxp localbxp = (bxp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(147770);
          return -1;
        case 1: 
          localbxp.dwb = locala.OmT.readString();
          AppMethodBeat.o(147770);
          return 0;
        case 2: 
          localbxp.username = locala.OmT.readString();
          AppMethodBeat.o(147770);
          return 0;
        case 3: 
          localbxp.HeR = locala.OmT.zc();
          AppMethodBeat.o(147770);
          return 0;
        case 4: 
          localbxp.FYj = locala.OmT.zc();
          AppMethodBeat.o(147770);
          return 0;
        case 5: 
          localbxp.Scene = locala.OmT.zc();
          AppMethodBeat.o(147770);
          return 0;
        case 6: 
          localbxp.Hko = locala.OmT.zc();
          AppMethodBeat.o(147770);
          return 0;
        case 7: 
          localbxp.Hkp = locala.OmT.zc();
          AppMethodBeat.o(147770);
          return 0;
        case 8: 
          localbxp.Hkq = locala.OmT.readString();
          AppMethodBeat.o(147770);
          return 0;
        }
        localbxp.Hkr = locala.OmT.zc();
        AppMethodBeat.o(147770);
        return 0;
      }
      AppMethodBeat.o(147770);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bxp
 * JD-Core Version:    0.7.0.1
 */