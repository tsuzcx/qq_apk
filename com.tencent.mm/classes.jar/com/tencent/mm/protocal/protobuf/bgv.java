package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bgv
  extends com.tencent.mm.bx.a
{
  public String CXg;
  public String DEO;
  public String DEP;
  public String DEQ;
  public String DER;
  public int DES;
  public String DET;
  public String Title;
  public String Url;
  public int mBH;
  public String scR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32327);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Title != null) {
        paramVarArgs.d(1, this.Title);
      }
      if (this.DEO != null) {
        paramVarArgs.d(2, this.DEO);
      }
      paramVarArgs.aR(3, this.mBH);
      if (this.Url != null) {
        paramVarArgs.d(4, this.Url);
      }
      if (this.DEP != null) {
        paramVarArgs.d(5, this.DEP);
      }
      if (this.CXg != null) {
        paramVarArgs.d(6, this.CXg);
      }
      if (this.DEQ != null) {
        paramVarArgs.d(7, this.DEQ);
      }
      if (this.scR != null) {
        paramVarArgs.d(8, this.scR);
      }
      if (this.DER != null) {
        paramVarArgs.d(9, this.DER);
      }
      paramVarArgs.aR(10, this.DES);
      if (this.DET != null) {
        paramVarArgs.d(11, this.DET);
      }
      AppMethodBeat.o(32327);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label811;
      }
    }
    label811:
    for (paramInt = f.a.a.b.b.a.e(1, this.Title) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.DEO != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.DEO);
      }
      i += f.a.a.b.b.a.bA(3, this.mBH);
      paramInt = i;
      if (this.Url != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Url);
      }
      i = paramInt;
      if (this.DEP != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.DEP);
      }
      paramInt = i;
      if (this.CXg != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.CXg);
      }
      i = paramInt;
      if (this.DEQ != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.DEQ);
      }
      paramInt = i;
      if (this.scR != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.scR);
      }
      i = paramInt;
      if (this.DER != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.DER);
      }
      i += f.a.a.b.b.a.bA(10, this.DES);
      paramInt = i;
      if (this.DET != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.DET);
      }
      AppMethodBeat.o(32327);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(32327);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bgv localbgv = (bgv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32327);
          return -1;
        case 1: 
          localbgv.Title = locala.KhF.readString();
          AppMethodBeat.o(32327);
          return 0;
        case 2: 
          localbgv.DEO = locala.KhF.readString();
          AppMethodBeat.o(32327);
          return 0;
        case 3: 
          localbgv.mBH = locala.KhF.xS();
          AppMethodBeat.o(32327);
          return 0;
        case 4: 
          localbgv.Url = locala.KhF.readString();
          AppMethodBeat.o(32327);
          return 0;
        case 5: 
          localbgv.DEP = locala.KhF.readString();
          AppMethodBeat.o(32327);
          return 0;
        case 6: 
          localbgv.CXg = locala.KhF.readString();
          AppMethodBeat.o(32327);
          return 0;
        case 7: 
          localbgv.DEQ = locala.KhF.readString();
          AppMethodBeat.o(32327);
          return 0;
        case 8: 
          localbgv.scR = locala.KhF.readString();
          AppMethodBeat.o(32327);
          return 0;
        case 9: 
          localbgv.DER = locala.KhF.readString();
          AppMethodBeat.o(32327);
          return 0;
        case 10: 
          localbgv.DES = locala.KhF.xS();
          AppMethodBeat.o(32327);
          return 0;
        }
        localbgv.DET = locala.KhF.readString();
        AppMethodBeat.o(32327);
        return 0;
      }
      AppMethodBeat.o(32327);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bgv
 * JD-Core Version:    0.7.0.1
 */