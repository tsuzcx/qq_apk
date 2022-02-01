package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class xs
  extends com.tencent.mm.bx.a
{
  public int CJd;
  public int CZn;
  public String CZo;
  public int CZp;
  public int CZq;
  public int CZr;
  public int CZs;
  public String CzP;
  public int CzR;
  public String content;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(103206);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.content != null) {
        paramVarArgs.d(1, this.content);
      }
      if (this.CzP != null) {
        paramVarArgs.d(3, this.CzP);
      }
      paramVarArgs.aR(4, this.CJd);
      paramVarArgs.aR(5, this.CzR);
      paramVarArgs.aR(6, this.CZn);
      if (this.CZo != null) {
        paramVarArgs.d(7, this.CZo);
      }
      paramVarArgs.aR(8, this.CZp);
      paramVarArgs.aR(9, this.CZq);
      paramVarArgs.aR(10, this.CZr);
      paramVarArgs.aR(11, this.CZs);
      AppMethodBeat.o(103206);
      return 0;
    }
    if (paramInt == 1) {
      if (this.content == null) {
        break label662;
      }
    }
    label662:
    for (paramInt = f.a.a.b.b.a.e(1, this.content) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.CzP != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.CzP);
      }
      i = i + f.a.a.b.b.a.bA(4, this.CJd) + f.a.a.b.b.a.bA(5, this.CzR) + f.a.a.b.b.a.bA(6, this.CZn);
      paramInt = i;
      if (this.CZo != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.CZo);
      }
      i = f.a.a.b.b.a.bA(8, this.CZp);
      int j = f.a.a.b.b.a.bA(9, this.CZq);
      int k = f.a.a.b.b.a.bA(10, this.CZr);
      int m = f.a.a.b.b.a.bA(11, this.CZs);
      AppMethodBeat.o(103206);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(103206);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        xs localxs = (xs)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 2: 
        default: 
          AppMethodBeat.o(103206);
          return -1;
        case 1: 
          localxs.content = locala.KhF.readString();
          AppMethodBeat.o(103206);
          return 0;
        case 3: 
          localxs.CzP = locala.KhF.readString();
          AppMethodBeat.o(103206);
          return 0;
        case 4: 
          localxs.CJd = locala.KhF.xS();
          AppMethodBeat.o(103206);
          return 0;
        case 5: 
          localxs.CzR = locala.KhF.xS();
          AppMethodBeat.o(103206);
          return 0;
        case 6: 
          localxs.CZn = locala.KhF.xS();
          AppMethodBeat.o(103206);
          return 0;
        case 7: 
          localxs.CZo = locala.KhF.readString();
          AppMethodBeat.o(103206);
          return 0;
        case 8: 
          localxs.CZp = locala.KhF.xS();
          AppMethodBeat.o(103206);
          return 0;
        case 9: 
          localxs.CZq = locala.KhF.xS();
          AppMethodBeat.o(103206);
          return 0;
        case 10: 
          localxs.CZr = locala.KhF.xS();
          AppMethodBeat.o(103206);
          return 0;
        }
        localxs.CZs = locala.KhF.xS();
        AppMethodBeat.o(103206);
        return 0;
      }
      AppMethodBeat.o(103206);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.xs
 * JD-Core Version:    0.7.0.1
 */