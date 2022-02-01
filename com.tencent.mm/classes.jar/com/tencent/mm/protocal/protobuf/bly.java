package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bly
  extends com.tencent.mm.bx.a
{
  public String CVv;
  public String CVw;
  public String Dqd;
  public String mAQ;
  public String mBV;
  public int mBi;
  public String vJI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155433);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.vJI != null) {
        paramVarArgs.d(1, this.vJI);
      }
      if (this.mAQ != null) {
        paramVarArgs.d(2, this.mAQ);
      }
      paramVarArgs.aR(3, this.mBi);
      if (this.CVv != null) {
        paramVarArgs.d(4, this.CVv);
      }
      if (this.CVw != null) {
        paramVarArgs.d(5, this.CVw);
      }
      if (this.mBV != null) {
        paramVarArgs.d(6, this.mBV);
      }
      if (this.Dqd != null) {
        paramVarArgs.d(7, this.Dqd);
      }
      AppMethodBeat.o(155433);
      return 0;
    }
    if (paramInt == 1) {
      if (this.vJI == null) {
        break label562;
      }
    }
    label562:
    for (paramInt = f.a.a.b.b.a.e(1, this.vJI) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.mAQ != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.mAQ);
      }
      i += f.a.a.b.b.a.bA(3, this.mBi);
      paramInt = i;
      if (this.CVv != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.CVv);
      }
      i = paramInt;
      if (this.CVw != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.CVw);
      }
      paramInt = i;
      if (this.mBV != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.mBV);
      }
      i = paramInt;
      if (this.Dqd != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.Dqd);
      }
      AppMethodBeat.o(155433);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(155433);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bly localbly = (bly)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(155433);
          return -1;
        case 1: 
          localbly.vJI = locala.KhF.readString();
          AppMethodBeat.o(155433);
          return 0;
        case 2: 
          localbly.mAQ = locala.KhF.readString();
          AppMethodBeat.o(155433);
          return 0;
        case 3: 
          localbly.mBi = locala.KhF.xS();
          AppMethodBeat.o(155433);
          return 0;
        case 4: 
          localbly.CVv = locala.KhF.readString();
          AppMethodBeat.o(155433);
          return 0;
        case 5: 
          localbly.CVw = locala.KhF.readString();
          AppMethodBeat.o(155433);
          return 0;
        case 6: 
          localbly.mBV = locala.KhF.readString();
          AppMethodBeat.o(155433);
          return 0;
        }
        localbly.Dqd = locala.KhF.readString();
        AppMethodBeat.o(155433);
        return 0;
      }
      AppMethodBeat.o(155433);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bly
 * JD-Core Version:    0.7.0.1
 */