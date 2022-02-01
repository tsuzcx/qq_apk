package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ctb
  extends com.tencent.mm.bw.a
{
  public int HEd;
  public String hCf;
  public String hCg;
  public String hCh;
  public String hCi;
  public String hCj;
  public String hCk;
  public String hCl;
  public String hCm;
  public String hCn;
  public String hCo;
  public String hCp;
  public String hCq;
  public boolean hCr;
  public int hCs;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169219);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.hCf != null) {
        paramVarArgs.d(1, this.hCf);
      }
      if (this.hCg != null) {
        paramVarArgs.d(2, this.hCg);
      }
      if (this.hCh != null) {
        paramVarArgs.d(3, this.hCh);
      }
      if (this.hCi != null) {
        paramVarArgs.d(4, this.hCi);
      }
      if (this.hCj != null) {
        paramVarArgs.d(5, this.hCj);
      }
      if (this.hCk != null) {
        paramVarArgs.d(6, this.hCk);
      }
      if (this.hCl != null) {
        paramVarArgs.d(7, this.hCl);
      }
      if (this.hCm != null) {
        paramVarArgs.d(8, this.hCm);
      }
      if (this.hCn != null) {
        paramVarArgs.d(9, this.hCn);
      }
      if (this.hCo != null) {
        paramVarArgs.d(10, this.hCo);
      }
      paramVarArgs.aS(11, this.HEd);
      if (this.hCp != null) {
        paramVarArgs.d(12, this.hCp);
      }
      if (this.hCq != null) {
        paramVarArgs.d(13, this.hCq);
      }
      paramVarArgs.bC(14, this.hCr);
      paramVarArgs.aS(15, this.hCs);
      AppMethodBeat.o(169219);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hCf == null) {
        break label1026;
      }
    }
    label1026:
    for (int i = f.a.a.b.b.a.e(1, this.hCf) + 0;; i = 0)
    {
      paramInt = i;
      if (this.hCg != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.hCg);
      }
      i = paramInt;
      if (this.hCh != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.hCh);
      }
      paramInt = i;
      if (this.hCi != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.hCi);
      }
      i = paramInt;
      if (this.hCj != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.hCj);
      }
      paramInt = i;
      if (this.hCk != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.hCk);
      }
      i = paramInt;
      if (this.hCl != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.hCl);
      }
      paramInt = i;
      if (this.hCm != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.hCm);
      }
      i = paramInt;
      if (this.hCn != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.hCn);
      }
      paramInt = i;
      if (this.hCo != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.hCo);
      }
      i = paramInt + f.a.a.b.b.a.bz(11, this.HEd);
      paramInt = i;
      if (this.hCp != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.hCp);
      }
      i = paramInt;
      if (this.hCq != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.hCq);
      }
      paramInt = f.a.a.b.b.a.amF(14);
      int j = f.a.a.b.b.a.bz(15, this.hCs);
      AppMethodBeat.o(169219);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(169219);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ctb localctb = (ctb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(169219);
          return -1;
        case 1: 
          localctb.hCf = locala.OmT.readString();
          AppMethodBeat.o(169219);
          return 0;
        case 2: 
          localctb.hCg = locala.OmT.readString();
          AppMethodBeat.o(169219);
          return 0;
        case 3: 
          localctb.hCh = locala.OmT.readString();
          AppMethodBeat.o(169219);
          return 0;
        case 4: 
          localctb.hCi = locala.OmT.readString();
          AppMethodBeat.o(169219);
          return 0;
        case 5: 
          localctb.hCj = locala.OmT.readString();
          AppMethodBeat.o(169219);
          return 0;
        case 6: 
          localctb.hCk = locala.OmT.readString();
          AppMethodBeat.o(169219);
          return 0;
        case 7: 
          localctb.hCl = locala.OmT.readString();
          AppMethodBeat.o(169219);
          return 0;
        case 8: 
          localctb.hCm = locala.OmT.readString();
          AppMethodBeat.o(169219);
          return 0;
        case 9: 
          localctb.hCn = locala.OmT.readString();
          AppMethodBeat.o(169219);
          return 0;
        case 10: 
          localctb.hCo = locala.OmT.readString();
          AppMethodBeat.o(169219);
          return 0;
        case 11: 
          localctb.HEd = locala.OmT.zc();
          AppMethodBeat.o(169219);
          return 0;
        case 12: 
          localctb.hCp = locala.OmT.readString();
          AppMethodBeat.o(169219);
          return 0;
        case 13: 
          localctb.hCq = locala.OmT.readString();
          AppMethodBeat.o(169219);
          return 0;
        case 14: 
          localctb.hCr = locala.OmT.gvY();
          AppMethodBeat.o(169219);
          return 0;
        }
        localctb.hCs = locala.OmT.zc();
        AppMethodBeat.o(169219);
        return 0;
      }
      AppMethodBeat.o(169219);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ctb
 * JD-Core Version:    0.7.0.1
 */