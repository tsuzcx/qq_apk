package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bzl
  extends com.tencent.mm.bw.a
{
  public int EeA;
  public String Eou;
  public int EqS;
  public int FileSize;
  public int For;
  public int Fos;
  public String Fot;
  public int Fou;
  public String Fov;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32360);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Eou != null) {
        paramVarArgs.d(1, this.Eou);
      }
      paramVarArgs.aR(2, this.For);
      paramVarArgs.aR(3, this.Fos);
      paramVarArgs.aR(4, this.EeA);
      if (this.Fot != null) {
        paramVarArgs.d(5, this.Fot);
      }
      paramVarArgs.aR(6, this.FileSize);
      paramVarArgs.aR(7, this.Fou);
      paramVarArgs.aR(8, this.EqS);
      if (this.Fov != null) {
        paramVarArgs.d(9, this.Fov);
      }
      AppMethodBeat.o(32360);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Eou == null) {
        break label613;
      }
    }
    label613:
    for (paramInt = f.a.a.b.b.a.e(1, this.Eou) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.For) + f.a.a.b.b.a.bx(3, this.Fos) + f.a.a.b.b.a.bx(4, this.EeA);
      paramInt = i;
      if (this.Fot != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Fot);
      }
      i = paramInt + f.a.a.b.b.a.bx(6, this.FileSize) + f.a.a.b.b.a.bx(7, this.Fou) + f.a.a.b.b.a.bx(8, this.EqS);
      paramInt = i;
      if (this.Fov != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.Fov);
      }
      AppMethodBeat.o(32360);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(32360);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bzl localbzl = (bzl)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32360);
          return -1;
        case 1: 
          localbzl.Eou = locala.LVo.readString();
          AppMethodBeat.o(32360);
          return 0;
        case 2: 
          localbzl.For = locala.LVo.xF();
          AppMethodBeat.o(32360);
          return 0;
        case 3: 
          localbzl.Fos = locala.LVo.xF();
          AppMethodBeat.o(32360);
          return 0;
        case 4: 
          localbzl.EeA = locala.LVo.xF();
          AppMethodBeat.o(32360);
          return 0;
        case 5: 
          localbzl.Fot = locala.LVo.readString();
          AppMethodBeat.o(32360);
          return 0;
        case 6: 
          localbzl.FileSize = locala.LVo.xF();
          AppMethodBeat.o(32360);
          return 0;
        case 7: 
          localbzl.Fou = locala.LVo.xF();
          AppMethodBeat.o(32360);
          return 0;
        case 8: 
          localbzl.EqS = locala.LVo.xF();
          AppMethodBeat.o(32360);
          return 0;
        }
        localbzl.Fov = locala.LVo.readString();
        AppMethodBeat.o(32360);
        return 0;
      }
      AppMethodBeat.o(32360);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bzl
 * JD-Core Version:    0.7.0.1
 */