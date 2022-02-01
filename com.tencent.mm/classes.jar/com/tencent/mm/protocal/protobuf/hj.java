package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class hj
  extends com.tencent.mm.bx.a
{
  public int CCv;
  public String CCw;
  public String CCx;
  public String Cxj;
  public String ijP;
  public String mAQ;
  public String mBV;
  public int rlB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32127);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Cxj != null) {
        paramVarArgs.d(1, this.Cxj);
      }
      if (this.mBV != null) {
        paramVarArgs.d(2, this.mBV);
      }
      if (this.mAQ != null) {
        paramVarArgs.d(3, this.mAQ);
      }
      paramVarArgs.aR(4, this.CCv);
      if (this.CCw != null) {
        paramVarArgs.d(5, this.CCw);
      }
      if (this.ijP != null) {
        paramVarArgs.d(6, this.ijP);
      }
      if (this.CCx != null) {
        paramVarArgs.d(7, this.CCx);
      }
      paramVarArgs.aR(8, this.rlB);
      AppMethodBeat.o(32127);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Cxj == null) {
        break label624;
      }
    }
    label624:
    for (int i = f.a.a.b.b.a.e(1, this.Cxj) + 0;; i = 0)
    {
      paramInt = i;
      if (this.mBV != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.mBV);
      }
      i = paramInt;
      if (this.mAQ != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.mAQ);
      }
      i += f.a.a.b.b.a.bA(4, this.CCv);
      paramInt = i;
      if (this.CCw != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.CCw);
      }
      i = paramInt;
      if (this.ijP != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.ijP);
      }
      paramInt = i;
      if (this.CCx != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.CCx);
      }
      i = f.a.a.b.b.a.bA(8, this.rlB);
      AppMethodBeat.o(32127);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(32127);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        hj localhj = (hj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32127);
          return -1;
        case 1: 
          localhj.Cxj = locala.KhF.readString();
          AppMethodBeat.o(32127);
          return 0;
        case 2: 
          localhj.mBV = locala.KhF.readString();
          AppMethodBeat.o(32127);
          return 0;
        case 3: 
          localhj.mAQ = locala.KhF.readString();
          AppMethodBeat.o(32127);
          return 0;
        case 4: 
          localhj.CCv = locala.KhF.xS();
          AppMethodBeat.o(32127);
          return 0;
        case 5: 
          localhj.CCw = locala.KhF.readString();
          AppMethodBeat.o(32127);
          return 0;
        case 6: 
          localhj.ijP = locala.KhF.readString();
          AppMethodBeat.o(32127);
          return 0;
        case 7: 
          localhj.CCx = locala.KhF.readString();
          AppMethodBeat.o(32127);
          return 0;
        }
        localhj.rlB = locala.KhF.xS();
        AppMethodBeat.o(32127);
        return 0;
      }
      AppMethodBeat.o(32127);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.hj
 * JD-Core Version:    0.7.0.1
 */