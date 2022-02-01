package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cgf
  extends com.tencent.mm.bx.a
{
  public String DfI;
  public String Dqd;
  public int EbR;
  public String SmallImgUrl;
  public String mAQ;
  public String mBV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127295);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.mAQ != null) {
        paramVarArgs.d(1, this.mAQ);
      }
      paramVarArgs.aR(2, this.EbR);
      if (this.mBV != null) {
        paramVarArgs.d(3, this.mBV);
      }
      if (this.SmallImgUrl != null) {
        paramVarArgs.d(4, this.SmallImgUrl);
      }
      if (this.DfI != null) {
        paramVarArgs.d(5, this.DfI);
      }
      if (this.Dqd != null) {
        paramVarArgs.d(6, this.Dqd);
      }
      AppMethodBeat.o(127295);
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
      int i = paramInt + f.a.a.b.b.a.bA(2, this.EbR);
      paramInt = i;
      if (this.mBV != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.mBV);
      }
      i = paramInt;
      if (this.SmallImgUrl != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.SmallImgUrl);
      }
      paramInt = i;
      if (this.DfI != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.DfI);
      }
      i = paramInt;
      if (this.Dqd != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.Dqd);
      }
      AppMethodBeat.o(127295);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(127295);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cgf localcgf = (cgf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127295);
          return -1;
        case 1: 
          localcgf.mAQ = locala.KhF.readString();
          AppMethodBeat.o(127295);
          return 0;
        case 2: 
          localcgf.EbR = locala.KhF.xS();
          AppMethodBeat.o(127295);
          return 0;
        case 3: 
          localcgf.mBV = locala.KhF.readString();
          AppMethodBeat.o(127295);
          return 0;
        case 4: 
          localcgf.SmallImgUrl = locala.KhF.readString();
          AppMethodBeat.o(127295);
          return 0;
        case 5: 
          localcgf.DfI = locala.KhF.readString();
          AppMethodBeat.o(127295);
          return 0;
        }
        localcgf.Dqd = locala.KhF.readString();
        AppMethodBeat.o(127295);
        return 0;
      }
      AppMethodBeat.o(127295);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cgf
 * JD-Core Version:    0.7.0.1
 */