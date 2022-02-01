package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aft
  extends com.tencent.mm.bx.a
{
  public String DfI;
  public String SmallImgUrl;
  public String mAQ;
  public String mBV;
  public int mBi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32210);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.mAQ != null) {
        paramVarArgs.d(1, this.mAQ);
      }
      if (this.DfI != null) {
        paramVarArgs.d(2, this.DfI);
      }
      if (this.mBV != null) {
        paramVarArgs.d(3, this.mBV);
      }
      if (this.SmallImgUrl != null) {
        paramVarArgs.d(4, this.SmallImgUrl);
      }
      paramVarArgs.aR(5, this.mBi);
      AppMethodBeat.o(32210);
      return 0;
    }
    if (paramInt == 1) {
      if (this.mAQ == null) {
        break label449;
      }
    }
    label449:
    for (int i = f.a.a.b.b.a.e(1, this.mAQ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DfI != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DfI);
      }
      i = paramInt;
      if (this.mBV != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.mBV);
      }
      paramInt = i;
      if (this.SmallImgUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.SmallImgUrl);
      }
      i = f.a.a.b.b.a.bA(5, this.mBi);
      AppMethodBeat.o(32210);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(32210);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        aft localaft = (aft)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32210);
          return -1;
        case 1: 
          localaft.mAQ = locala.KhF.readString();
          AppMethodBeat.o(32210);
          return 0;
        case 2: 
          localaft.DfI = locala.KhF.readString();
          AppMethodBeat.o(32210);
          return 0;
        case 3: 
          localaft.mBV = locala.KhF.readString();
          AppMethodBeat.o(32210);
          return 0;
        case 4: 
          localaft.SmallImgUrl = locala.KhF.readString();
          AppMethodBeat.o(32210);
          return 0;
        }
        localaft.mBi = locala.KhF.xS();
        AppMethodBeat.o(32210);
        return 0;
      }
      AppMethodBeat.o(32210);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aft
 * JD-Core Version:    0.7.0.1
 */