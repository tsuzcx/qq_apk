package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bem
  extends com.tencent.mm.bx.a
{
  public String CFy;
  public String DBZ;
  public String DCa;
  public String Dqd;
  public int Ret;
  public String mAQ;
  public String mBV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155421);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CFy != null) {
        paramVarArgs.d(1, this.CFy);
      }
      if (this.mAQ != null) {
        paramVarArgs.d(2, this.mAQ);
      }
      if (this.DBZ != null) {
        paramVarArgs.d(3, this.DBZ);
      }
      if (this.DCa != null) {
        paramVarArgs.d(4, this.DCa);
      }
      paramVarArgs.aR(5, this.Ret);
      if (this.mBV != null) {
        paramVarArgs.d(6, this.mBV);
      }
      if (this.Dqd != null) {
        paramVarArgs.d(7, this.Dqd);
      }
      AppMethodBeat.o(155421);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CFy == null) {
        break label562;
      }
    }
    label562:
    for (int i = f.a.a.b.b.a.e(1, this.CFy) + 0;; i = 0)
    {
      paramInt = i;
      if (this.mAQ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.mAQ);
      }
      i = paramInt;
      if (this.DBZ != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DBZ);
      }
      paramInt = i;
      if (this.DCa != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DCa);
      }
      i = paramInt + f.a.a.b.b.a.bA(5, this.Ret);
      paramInt = i;
      if (this.mBV != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.mBV);
      }
      i = paramInt;
      if (this.Dqd != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.Dqd);
      }
      AppMethodBeat.o(155421);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(155421);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bem localbem = (bem)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(155421);
          return -1;
        case 1: 
          localbem.CFy = locala.KhF.readString();
          AppMethodBeat.o(155421);
          return 0;
        case 2: 
          localbem.mAQ = locala.KhF.readString();
          AppMethodBeat.o(155421);
          return 0;
        case 3: 
          localbem.DBZ = locala.KhF.readString();
          AppMethodBeat.o(155421);
          return 0;
        case 4: 
          localbem.DCa = locala.KhF.readString();
          AppMethodBeat.o(155421);
          return 0;
        case 5: 
          localbem.Ret = locala.KhF.xS();
          AppMethodBeat.o(155421);
          return 0;
        case 6: 
          localbem.mBV = locala.KhF.readString();
          AppMethodBeat.o(155421);
          return 0;
        }
        localbem.Dqd = locala.KhF.readString();
        AppMethodBeat.o(155421);
        return 0;
      }
      AppMethodBeat.o(155421);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bem
 * JD-Core Version:    0.7.0.1
 */