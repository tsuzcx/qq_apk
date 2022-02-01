package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class mx
  extends com.tencent.mm.bx.a
{
  public int CKA;
  public String CKv;
  public int CKw;
  public int CKx;
  public int CKy;
  public int CKz;
  public int dtM;
  public int tGD;
  public String url;
  public int weight;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124437);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CKv != null) {
        paramVarArgs.d(1, this.CKv);
      }
      paramVarArgs.aR(2, this.weight);
      paramVarArgs.aR(3, this.CKw);
      paramVarArgs.aR(4, this.dtM);
      if (this.url != null) {
        paramVarArgs.d(5, this.url);
      }
      paramVarArgs.aR(6, this.tGD);
      paramVarArgs.aR(7, this.CKx);
      paramVarArgs.aR(8, this.CKy);
      paramVarArgs.aR(9, this.CKz);
      paramVarArgs.aR(10, this.CKA);
      AppMethodBeat.o(124437);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CKv == null) {
        break label642;
      }
    }
    label642:
    for (paramInt = f.a.a.b.b.a.e(1, this.CKv) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.weight) + f.a.a.b.b.a.bA(3, this.CKw) + f.a.a.b.b.a.bA(4, this.dtM);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.url);
      }
      i = f.a.a.b.b.a.bA(6, this.tGD);
      int j = f.a.a.b.b.a.bA(7, this.CKx);
      int k = f.a.a.b.b.a.bA(8, this.CKy);
      int m = f.a.a.b.b.a.bA(9, this.CKz);
      int n = f.a.a.b.b.a.bA(10, this.CKA);
      AppMethodBeat.o(124437);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(124437);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        mx localmx = (mx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124437);
          return -1;
        case 1: 
          localmx.CKv = locala.KhF.readString();
          AppMethodBeat.o(124437);
          return 0;
        case 2: 
          localmx.weight = locala.KhF.xS();
          AppMethodBeat.o(124437);
          return 0;
        case 3: 
          localmx.CKw = locala.KhF.xS();
          AppMethodBeat.o(124437);
          return 0;
        case 4: 
          localmx.dtM = locala.KhF.xS();
          AppMethodBeat.o(124437);
          return 0;
        case 5: 
          localmx.url = locala.KhF.readString();
          AppMethodBeat.o(124437);
          return 0;
        case 6: 
          localmx.tGD = locala.KhF.xS();
          AppMethodBeat.o(124437);
          return 0;
        case 7: 
          localmx.CKx = locala.KhF.xS();
          AppMethodBeat.o(124437);
          return 0;
        case 8: 
          localmx.CKy = locala.KhF.xS();
          AppMethodBeat.o(124437);
          return 0;
        case 9: 
          localmx.CKz = locala.KhF.xS();
          AppMethodBeat.o(124437);
          return 0;
        }
        localmx.CKA = locala.KhF.xS();
        AppMethodBeat.o(124437);
        return 0;
      }
      AppMethodBeat.o(124437);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.mx
 * JD-Core Version:    0.7.0.1
 */