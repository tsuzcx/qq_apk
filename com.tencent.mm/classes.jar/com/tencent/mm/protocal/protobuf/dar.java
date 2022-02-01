package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dar
  extends com.tencent.mm.bx.a
{
  public int Cxm;
  public String Esu;
  public String Esv;
  public String ijP;
  public String mAQ;
  public String mBV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124559);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.mAQ != null) {
        paramVarArgs.d(1, this.mAQ);
      }
      if (this.mBV != null) {
        paramVarArgs.d(2, this.mBV);
      }
      paramVarArgs.aR(3, this.Cxm);
      if (this.Esu != null) {
        paramVarArgs.d(4, this.Esu);
      }
      if (this.ijP != null) {
        paramVarArgs.d(5, this.ijP);
      }
      if (this.Esv != null) {
        paramVarArgs.d(6, this.Esv);
      }
      AppMethodBeat.o(124559);
      return 0;
    }
    if (paramInt == 1) {
      if (this.mAQ == null) {
        break label502;
      }
    }
    label502:
    for (paramInt = f.a.a.b.b.a.e(1, this.mAQ) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.mBV != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.mBV);
      }
      i += f.a.a.b.b.a.bA(3, this.Cxm);
      paramInt = i;
      if (this.Esu != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Esu);
      }
      i = paramInt;
      if (this.ijP != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.ijP);
      }
      paramInt = i;
      if (this.Esv != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Esv);
      }
      AppMethodBeat.o(124559);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(124559);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dar localdar = (dar)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124559);
          return -1;
        case 1: 
          localdar.mAQ = locala.KhF.readString();
          AppMethodBeat.o(124559);
          return 0;
        case 2: 
          localdar.mBV = locala.KhF.readString();
          AppMethodBeat.o(124559);
          return 0;
        case 3: 
          localdar.Cxm = locala.KhF.xS();
          AppMethodBeat.o(124559);
          return 0;
        case 4: 
          localdar.Esu = locala.KhF.readString();
          AppMethodBeat.o(124559);
          return 0;
        case 5: 
          localdar.ijP = locala.KhF.readString();
          AppMethodBeat.o(124559);
          return 0;
        }
        localdar.Esv = locala.KhF.readString();
        AppMethodBeat.o(124559);
        return 0;
      }
      AppMethodBeat.o(124559);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dar
 * JD-Core Version:    0.7.0.1
 */