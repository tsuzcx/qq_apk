package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class buk
  extends com.tencent.mm.bx.a
{
  public int CLY;
  public String Ddo;
  public String doQ;
  public String mAQ;
  public String mBV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(184131);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.mAQ != null) {
        paramVarArgs.d(1, this.mAQ);
      }
      if (this.Ddo != null) {
        paramVarArgs.d(2, this.Ddo);
      }
      paramVarArgs.aR(3, this.CLY);
      if (this.mBV != null) {
        paramVarArgs.d(4, this.mBV);
      }
      if (this.doQ != null) {
        paramVarArgs.d(5, this.doQ);
      }
      AppMethodBeat.o(184131);
      return 0;
    }
    if (paramInt == 1) {
      if (this.mAQ == null) {
        break label438;
      }
    }
    label438:
    for (paramInt = f.a.a.b.b.a.e(1, this.mAQ) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Ddo != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Ddo);
      }
      i += f.a.a.b.b.a.bA(3, this.CLY);
      paramInt = i;
      if (this.mBV != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.mBV);
      }
      i = paramInt;
      if (this.doQ != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.doQ);
      }
      AppMethodBeat.o(184131);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(184131);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        buk localbuk = (buk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(184131);
          return -1;
        case 1: 
          localbuk.mAQ = locala.KhF.readString();
          AppMethodBeat.o(184131);
          return 0;
        case 2: 
          localbuk.Ddo = locala.KhF.readString();
          AppMethodBeat.o(184131);
          return 0;
        case 3: 
          localbuk.CLY = locala.KhF.xS();
          AppMethodBeat.o(184131);
          return 0;
        case 4: 
          localbuk.mBV = locala.KhF.readString();
          AppMethodBeat.o(184131);
          return 0;
        }
        localbuk.doQ = locala.KhF.readString();
        AppMethodBeat.o(184131);
        return 0;
      }
      AppMethodBeat.o(184131);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.buk
 * JD-Core Version:    0.7.0.1
 */