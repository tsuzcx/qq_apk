package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ri
  extends com.tencent.mm.bw.a
{
  public int AJS;
  public int AJT;
  public int GfH;
  public int GfI;
  public int GfJ;
  public int GfK;
  public int GfL;
  public int GfM;
  public int GfN;
  public int GfO;
  public int GfP;
  public int GfQ;
  public int GfR;
  public String aeskey;
  public String md5;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(220221);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.aeskey != null) {
        paramVarArgs.d(1, this.aeskey);
      }
      paramVarArgs.aS(2, this.GfH);
      if (this.url != null) {
        paramVarArgs.d(3, this.url);
      }
      paramVarArgs.aS(4, this.GfI);
      paramVarArgs.aS(5, this.GfJ);
      paramVarArgs.aS(6, this.GfK);
      paramVarArgs.aS(7, this.AJT);
      paramVarArgs.aS(8, this.AJS);
      if (this.md5 != null) {
        paramVarArgs.d(9, this.md5);
      }
      paramVarArgs.aS(10, this.GfL);
      paramVarArgs.aS(11, this.GfM);
      paramVarArgs.aS(12, this.GfN);
      paramVarArgs.aS(13, this.GfO);
      paramVarArgs.aS(14, this.GfP);
      paramVarArgs.aS(15, this.GfQ);
      paramVarArgs.aS(16, this.GfR);
      AppMethodBeat.o(220221);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aeskey == null) {
        break label934;
      }
    }
    label934:
    for (paramInt = f.a.a.b.b.a.e(1, this.aeskey) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.GfH);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.url);
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.GfI) + f.a.a.b.b.a.bz(5, this.GfJ) + f.a.a.b.b.a.bz(6, this.GfK) + f.a.a.b.b.a.bz(7, this.AJT) + f.a.a.b.b.a.bz(8, this.AJS);
      paramInt = i;
      if (this.md5 != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.md5);
      }
      i = f.a.a.b.b.a.bz(10, this.GfL);
      int j = f.a.a.b.b.a.bz(11, this.GfM);
      int k = f.a.a.b.b.a.bz(12, this.GfN);
      int m = f.a.a.b.b.a.bz(13, this.GfO);
      int n = f.a.a.b.b.a.bz(14, this.GfP);
      int i1 = f.a.a.b.b.a.bz(15, this.GfQ);
      int i2 = f.a.a.b.b.a.bz(16, this.GfR);
      AppMethodBeat.o(220221);
      return paramInt + i + j + k + m + n + i1 + i2;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(220221);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ri localri = (ri)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(220221);
          return -1;
        case 1: 
          localri.aeskey = locala.OmT.readString();
          AppMethodBeat.o(220221);
          return 0;
        case 2: 
          localri.GfH = locala.OmT.zc();
          AppMethodBeat.o(220221);
          return 0;
        case 3: 
          localri.url = locala.OmT.readString();
          AppMethodBeat.o(220221);
          return 0;
        case 4: 
          localri.GfI = locala.OmT.zc();
          AppMethodBeat.o(220221);
          return 0;
        case 5: 
          localri.GfJ = locala.OmT.zc();
          AppMethodBeat.o(220221);
          return 0;
        case 6: 
          localri.GfK = locala.OmT.zc();
          AppMethodBeat.o(220221);
          return 0;
        case 7: 
          localri.AJT = locala.OmT.zc();
          AppMethodBeat.o(220221);
          return 0;
        case 8: 
          localri.AJS = locala.OmT.zc();
          AppMethodBeat.o(220221);
          return 0;
        case 9: 
          localri.md5 = locala.OmT.readString();
          AppMethodBeat.o(220221);
          return 0;
        case 10: 
          localri.GfL = locala.OmT.zc();
          AppMethodBeat.o(220221);
          return 0;
        case 11: 
          localri.GfM = locala.OmT.zc();
          AppMethodBeat.o(220221);
          return 0;
        case 12: 
          localri.GfN = locala.OmT.zc();
          AppMethodBeat.o(220221);
          return 0;
        case 13: 
          localri.GfO = locala.OmT.zc();
          AppMethodBeat.o(220221);
          return 0;
        case 14: 
          localri.GfP = locala.OmT.zc();
          AppMethodBeat.o(220221);
          return 0;
        case 15: 
          localri.GfQ = locala.OmT.zc();
          AppMethodBeat.o(220221);
          return 0;
        }
        localri.GfR = locala.OmT.zc();
        AppMethodBeat.o(220221);
        return 0;
      }
      AppMethodBeat.o(220221);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ri
 * JD-Core Version:    0.7.0.1
 */