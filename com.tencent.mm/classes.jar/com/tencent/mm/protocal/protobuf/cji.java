package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cji
  extends com.tencent.mm.bx.a
{
  public int EeB;
  public int EeC;
  public String fVv;
  public String fVw;
  public String fVx;
  public String fVy;
  public String mBv;
  public String nlF;
  public int wvu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123640);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.mBv != null) {
        paramVarArgs.d(1, this.mBv);
      }
      paramVarArgs.aR(2, this.EeB);
      if (this.fVv != null) {
        paramVarArgs.d(3, this.fVv);
      }
      if (this.fVw != null) {
        paramVarArgs.d(4, this.fVw);
      }
      paramVarArgs.aR(5, this.wvu);
      paramVarArgs.aR(6, this.EeC);
      if (this.fVx != null) {
        paramVarArgs.d(7, this.fVx);
      }
      if (this.fVy != null) {
        paramVarArgs.d(8, this.fVy);
      }
      if (this.nlF != null) {
        paramVarArgs.d(9, this.nlF);
      }
      AppMethodBeat.o(123640);
      return 0;
    }
    if (paramInt == 1) {
      if (this.mBv == null) {
        break label654;
      }
    }
    label654:
    for (paramInt = f.a.a.b.b.a.e(1, this.mBv) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.EeB);
      paramInt = i;
      if (this.fVv != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.fVv);
      }
      i = paramInt;
      if (this.fVw != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.fVw);
      }
      i = i + f.a.a.b.b.a.bA(5, this.wvu) + f.a.a.b.b.a.bA(6, this.EeC);
      paramInt = i;
      if (this.fVx != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.fVx);
      }
      i = paramInt;
      if (this.fVy != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.fVy);
      }
      paramInt = i;
      if (this.nlF != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.nlF);
      }
      AppMethodBeat.o(123640);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(123640);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cji localcji = (cji)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123640);
          return -1;
        case 1: 
          localcji.mBv = locala.KhF.readString();
          AppMethodBeat.o(123640);
          return 0;
        case 2: 
          localcji.EeB = locala.KhF.xS();
          AppMethodBeat.o(123640);
          return 0;
        case 3: 
          localcji.fVv = locala.KhF.readString();
          AppMethodBeat.o(123640);
          return 0;
        case 4: 
          localcji.fVw = locala.KhF.readString();
          AppMethodBeat.o(123640);
          return 0;
        case 5: 
          localcji.wvu = locala.KhF.xS();
          AppMethodBeat.o(123640);
          return 0;
        case 6: 
          localcji.EeC = locala.KhF.xS();
          AppMethodBeat.o(123640);
          return 0;
        case 7: 
          localcji.fVx = locala.KhF.readString();
          AppMethodBeat.o(123640);
          return 0;
        case 8: 
          localcji.fVy = locala.KhF.readString();
          AppMethodBeat.o(123640);
          return 0;
        }
        localcji.nlF = locala.KhF.readString();
        AppMethodBeat.o(123640);
        return 0;
      }
      AppMethodBeat.o(123640);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cji
 * JD-Core Version:    0.7.0.1
 */