package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class k
  extends com.tencent.mm.bv.a
{
  public long cNd;
  public int state;
  public String title;
  public String wjW;
  public String wjX;
  public String wkg;
  public int wkh;
  public String wki;
  public String wkj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56679);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wjW != null) {
        paramVarArgs.e(1, this.wjW);
      }
      if (this.title != null) {
        paramVarArgs.e(2, this.title);
      }
      paramVarArgs.am(3, this.cNd);
      if (this.wkg != null) {
        paramVarArgs.e(5, this.wkg);
      }
      paramVarArgs.aO(10, this.state);
      paramVarArgs.aO(11, this.wkh);
      if (this.wki != null) {
        paramVarArgs.e(12, this.wki);
      }
      if (this.wjX != null) {
        paramVarArgs.e(13, this.wjX);
      }
      if (this.wkj != null) {
        paramVarArgs.e(14, this.wkj);
      }
      AppMethodBeat.o(56679);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wjW == null) {
        break label674;
      }
    }
    label674:
    for (paramInt = e.a.a.b.b.a.f(1, this.wjW) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.title != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.title);
      }
      i += e.a.a.b.b.a.p(3, this.cNd);
      paramInt = i;
      if (this.wkg != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.wkg);
      }
      i = paramInt + e.a.a.b.b.a.bl(10, this.state) + e.a.a.b.b.a.bl(11, this.wkh);
      paramInt = i;
      if (this.wki != null) {
        paramInt = i + e.a.a.b.b.a.f(12, this.wki);
      }
      i = paramInt;
      if (this.wjX != null) {
        i = paramInt + e.a.a.b.b.a.f(13, this.wjX);
      }
      paramInt = i;
      if (this.wkj != null) {
        paramInt = i + e.a.a.b.b.a.f(14, this.wkj);
      }
      AppMethodBeat.o(56679);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(56679);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        k localk = (k)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 4: 
        case 6: 
        case 7: 
        case 8: 
        case 9: 
        default: 
          AppMethodBeat.o(56679);
          return -1;
        case 1: 
          localk.wjW = locala.CLY.readString();
          AppMethodBeat.o(56679);
          return 0;
        case 2: 
          localk.title = locala.CLY.readString();
          AppMethodBeat.o(56679);
          return 0;
        case 3: 
          localk.cNd = locala.CLY.sm();
          AppMethodBeat.o(56679);
          return 0;
        case 5: 
          localk.wkg = locala.CLY.readString();
          AppMethodBeat.o(56679);
          return 0;
        case 10: 
          localk.state = locala.CLY.sl();
          AppMethodBeat.o(56679);
          return 0;
        case 11: 
          localk.wkh = locala.CLY.sl();
          AppMethodBeat.o(56679);
          return 0;
        case 12: 
          localk.wki = locala.CLY.readString();
          AppMethodBeat.o(56679);
          return 0;
        case 13: 
          localk.wjX = locala.CLY.readString();
          AppMethodBeat.o(56679);
          return 0;
        }
        localk.wkj = locala.CLY.readString();
        AppMethodBeat.o(56679);
        return 0;
      }
      AppMethodBeat.o(56679);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.k
 * JD-Core Version:    0.7.0.1
 */