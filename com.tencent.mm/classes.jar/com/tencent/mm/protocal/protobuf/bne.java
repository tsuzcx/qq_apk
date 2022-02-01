package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bne
  extends com.tencent.mm.bw.a
{
  public String FVP;
  public String GNI;
  public String Hat;
  public String Hau;
  public int Ret;
  public String nIJ;
  public String nJO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155421);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FVP != null) {
        paramVarArgs.d(1, this.FVP);
      }
      if (this.nIJ != null) {
        paramVarArgs.d(2, this.nIJ);
      }
      if (this.Hat != null) {
        paramVarArgs.d(3, this.Hat);
      }
      if (this.Hau != null) {
        paramVarArgs.d(4, this.Hau);
      }
      paramVarArgs.aS(5, this.Ret);
      if (this.nJO != null) {
        paramVarArgs.d(6, this.nJO);
      }
      if (this.GNI != null) {
        paramVarArgs.d(7, this.GNI);
      }
      AppMethodBeat.o(155421);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FVP == null) {
        break label562;
      }
    }
    label562:
    for (int i = f.a.a.b.b.a.e(1, this.FVP) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nIJ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.nIJ);
      }
      i = paramInt;
      if (this.Hat != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Hat);
      }
      paramInt = i;
      if (this.Hau != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Hau);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.Ret);
      paramInt = i;
      if (this.nJO != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.nJO);
      }
      i = paramInt;
      if (this.GNI != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.GNI);
      }
      AppMethodBeat.o(155421);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(155421);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bne localbne = (bne)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(155421);
          return -1;
        case 1: 
          localbne.FVP = locala.OmT.readString();
          AppMethodBeat.o(155421);
          return 0;
        case 2: 
          localbne.nIJ = locala.OmT.readString();
          AppMethodBeat.o(155421);
          return 0;
        case 3: 
          localbne.Hat = locala.OmT.readString();
          AppMethodBeat.o(155421);
          return 0;
        case 4: 
          localbne.Hau = locala.OmT.readString();
          AppMethodBeat.o(155421);
          return 0;
        case 5: 
          localbne.Ret = locala.OmT.zc();
          AppMethodBeat.o(155421);
          return 0;
        case 6: 
          localbne.nJO = locala.OmT.readString();
          AppMethodBeat.o(155421);
          return 0;
        }
        localbne.GNI = locala.OmT.readString();
        AppMethodBeat.o(155421);
        return 0;
      }
      AppMethodBeat.o(155421);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bne
 * JD-Core Version:    0.7.0.1
 */