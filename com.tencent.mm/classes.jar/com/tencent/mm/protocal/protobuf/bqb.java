package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bqb
  extends com.tencent.mm.bx.a
{
  public String CVv;
  public String CVw;
  public int DOj;
  public int DOk;
  public int ijM;
  public String ijN;
  public String ijO;
  public String ijP;
  public String ijV;
  public String mAQ;
  public int mBH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32348);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.mAQ != null) {
        paramVarArgs.d(1, this.mAQ);
      }
      paramVarArgs.aR(2, this.mBH);
      paramVarArgs.aR(3, this.ijM);
      if (this.ijO != null) {
        paramVarArgs.d(4, this.ijO);
      }
      if (this.ijN != null) {
        paramVarArgs.d(5, this.ijN);
      }
      if (this.ijP != null) {
        paramVarArgs.d(6, this.ijP);
      }
      paramVarArgs.aR(7, this.DOj);
      paramVarArgs.aR(8, this.DOk);
      if (this.ijV != null) {
        paramVarArgs.d(9, this.ijV);
      }
      if (this.CVv != null) {
        paramVarArgs.d(10, this.CVv);
      }
      if (this.CVw != null) {
        paramVarArgs.d(11, this.CVw);
      }
      AppMethodBeat.o(32348);
      return 0;
    }
    if (paramInt == 1) {
      if (this.mAQ == null) {
        break label775;
      }
    }
    label775:
    for (paramInt = f.a.a.b.b.a.e(1, this.mAQ) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.mBH) + f.a.a.b.b.a.bA(3, this.ijM);
      paramInt = i;
      if (this.ijO != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.ijO);
      }
      i = paramInt;
      if (this.ijN != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.ijN);
      }
      paramInt = i;
      if (this.ijP != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.ijP);
      }
      i = paramInt + f.a.a.b.b.a.bA(7, this.DOj) + f.a.a.b.b.a.bA(8, this.DOk);
      paramInt = i;
      if (this.ijV != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.ijV);
      }
      i = paramInt;
      if (this.CVv != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.CVv);
      }
      paramInt = i;
      if (this.CVw != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.CVw);
      }
      AppMethodBeat.o(32348);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(32348);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bqb localbqb = (bqb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32348);
          return -1;
        case 1: 
          localbqb.mAQ = locala.KhF.readString();
          AppMethodBeat.o(32348);
          return 0;
        case 2: 
          localbqb.mBH = locala.KhF.xS();
          AppMethodBeat.o(32348);
          return 0;
        case 3: 
          localbqb.ijM = locala.KhF.xS();
          AppMethodBeat.o(32348);
          return 0;
        case 4: 
          localbqb.ijO = locala.KhF.readString();
          AppMethodBeat.o(32348);
          return 0;
        case 5: 
          localbqb.ijN = locala.KhF.readString();
          AppMethodBeat.o(32348);
          return 0;
        case 6: 
          localbqb.ijP = locala.KhF.readString();
          AppMethodBeat.o(32348);
          return 0;
        case 7: 
          localbqb.DOj = locala.KhF.xS();
          AppMethodBeat.o(32348);
          return 0;
        case 8: 
          localbqb.DOk = locala.KhF.xS();
          AppMethodBeat.o(32348);
          return 0;
        case 9: 
          localbqb.ijV = locala.KhF.readString();
          AppMethodBeat.o(32348);
          return 0;
        case 10: 
          localbqb.CVv = locala.KhF.readString();
          AppMethodBeat.o(32348);
          return 0;
        }
        localbqb.CVw = locala.KhF.readString();
        AppMethodBeat.o(32348);
        return 0;
      }
      AppMethodBeat.o(32348);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bqb
 * JD-Core Version:    0.7.0.1
 */