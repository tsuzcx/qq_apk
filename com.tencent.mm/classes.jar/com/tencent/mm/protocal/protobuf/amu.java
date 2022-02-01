package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class amu
  extends com.tencent.mm.bx.a
{
  public String CFH;
  public String CXm;
  public int Ctn;
  public String Cxj;
  public String DnT;
  public String DnU;
  public String DnV;
  public String mAQ;
  public String mBV;
  public String sah;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32218);
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
      if (this.sah != null) {
        paramVarArgs.d(4, this.sah);
      }
      if (this.DnT != null) {
        paramVarArgs.d(5, this.DnT);
      }
      if (this.DnU != null) {
        paramVarArgs.d(6, this.DnU);
      }
      if (this.CFH != null) {
        paramVarArgs.d(7, this.CFH);
      }
      if (this.CXm != null) {
        paramVarArgs.d(8, this.CXm);
      }
      if (this.DnV != null) {
        paramVarArgs.d(9, this.DnV);
      }
      paramVarArgs.aR(10, this.Ctn);
      AppMethodBeat.o(32218);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Cxj == null) {
        break label766;
      }
    }
    label766:
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
      paramInt = i;
      if (this.sah != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.sah);
      }
      i = paramInt;
      if (this.DnT != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.DnT);
      }
      paramInt = i;
      if (this.DnU != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.DnU);
      }
      i = paramInt;
      if (this.CFH != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.CFH);
      }
      paramInt = i;
      if (this.CXm != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.CXm);
      }
      i = paramInt;
      if (this.DnV != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.DnV);
      }
      paramInt = f.a.a.b.b.a.bA(10, this.Ctn);
      AppMethodBeat.o(32218);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(32218);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        amu localamu = (amu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32218);
          return -1;
        case 1: 
          localamu.Cxj = locala.KhF.readString();
          AppMethodBeat.o(32218);
          return 0;
        case 2: 
          localamu.mBV = locala.KhF.readString();
          AppMethodBeat.o(32218);
          return 0;
        case 3: 
          localamu.mAQ = locala.KhF.readString();
          AppMethodBeat.o(32218);
          return 0;
        case 4: 
          localamu.sah = locala.KhF.readString();
          AppMethodBeat.o(32218);
          return 0;
        case 5: 
          localamu.DnT = locala.KhF.readString();
          AppMethodBeat.o(32218);
          return 0;
        case 6: 
          localamu.DnU = locala.KhF.readString();
          AppMethodBeat.o(32218);
          return 0;
        case 7: 
          localamu.CFH = locala.KhF.readString();
          AppMethodBeat.o(32218);
          return 0;
        case 8: 
          localamu.CXm = locala.KhF.readString();
          AppMethodBeat.o(32218);
          return 0;
        case 9: 
          localamu.DnV = locala.KhF.readString();
          AppMethodBeat.o(32218);
          return 0;
        }
        localamu.Ctn = locala.KhF.xS();
        AppMethodBeat.o(32218);
        return 0;
      }
      AppMethodBeat.o(32218);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.amu
 * JD-Core Version:    0.7.0.1
 */