package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aui
  extends com.tencent.mm.bw.a
{
  public int FJh;
  public String FNs;
  public String FVY;
  public String GLi;
  public String GLj;
  public String GLk;
  public String GpF;
  public String nIJ;
  public String nJO;
  public String urn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32218);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FNs != null) {
        paramVarArgs.d(1, this.FNs);
      }
      if (this.nJO != null) {
        paramVarArgs.d(2, this.nJO);
      }
      if (this.nIJ != null) {
        paramVarArgs.d(3, this.nIJ);
      }
      if (this.urn != null) {
        paramVarArgs.d(4, this.urn);
      }
      if (this.GLi != null) {
        paramVarArgs.d(5, this.GLi);
      }
      if (this.GLj != null) {
        paramVarArgs.d(6, this.GLj);
      }
      if (this.FVY != null) {
        paramVarArgs.d(7, this.FVY);
      }
      if (this.GpF != null) {
        paramVarArgs.d(8, this.GpF);
      }
      if (this.GLk != null) {
        paramVarArgs.d(9, this.GLk);
      }
      paramVarArgs.aS(10, this.FJh);
      AppMethodBeat.o(32218);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FNs == null) {
        break label766;
      }
    }
    label766:
    for (int i = f.a.a.b.b.a.e(1, this.FNs) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nJO != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.nJO);
      }
      i = paramInt;
      if (this.nIJ != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.nIJ);
      }
      paramInt = i;
      if (this.urn != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.urn);
      }
      i = paramInt;
      if (this.GLi != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.GLi);
      }
      paramInt = i;
      if (this.GLj != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.GLj);
      }
      i = paramInt;
      if (this.FVY != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.FVY);
      }
      paramInt = i;
      if (this.GpF != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.GpF);
      }
      i = paramInt;
      if (this.GLk != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.GLk);
      }
      paramInt = f.a.a.b.b.a.bz(10, this.FJh);
      AppMethodBeat.o(32218);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(32218);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        aui localaui = (aui)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32218);
          return -1;
        case 1: 
          localaui.FNs = locala.OmT.readString();
          AppMethodBeat.o(32218);
          return 0;
        case 2: 
          localaui.nJO = locala.OmT.readString();
          AppMethodBeat.o(32218);
          return 0;
        case 3: 
          localaui.nIJ = locala.OmT.readString();
          AppMethodBeat.o(32218);
          return 0;
        case 4: 
          localaui.urn = locala.OmT.readString();
          AppMethodBeat.o(32218);
          return 0;
        case 5: 
          localaui.GLi = locala.OmT.readString();
          AppMethodBeat.o(32218);
          return 0;
        case 6: 
          localaui.GLj = locala.OmT.readString();
          AppMethodBeat.o(32218);
          return 0;
        case 7: 
          localaui.FVY = locala.OmT.readString();
          AppMethodBeat.o(32218);
          return 0;
        case 8: 
          localaui.GpF = locala.OmT.readString();
          AppMethodBeat.o(32218);
          return 0;
        case 9: 
          localaui.GLk = locala.OmT.readString();
          AppMethodBeat.o(32218);
          return 0;
        }
        localaui.FJh = locala.OmT.zc();
        AppMethodBeat.o(32218);
        return 0;
      }
      AppMethodBeat.o(32218);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aui
 * JD-Core Version:    0.7.0.1
 */