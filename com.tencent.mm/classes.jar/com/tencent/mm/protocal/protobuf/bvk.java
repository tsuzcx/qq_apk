package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bvk
  extends com.tencent.mm.bw.a
{
  public String Flk;
  public int ndI;
  public String tkJ;
  public String wTM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127501);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.tkJ != null) {
        paramVarArgs.d(1, this.tkJ);
      }
      if (this.Flk != null) {
        paramVarArgs.d(2, this.Flk);
      }
      if (this.wTM != null) {
        paramVarArgs.d(3, this.wTM);
      }
      paramVarArgs.aR(4, this.ndI);
      AppMethodBeat.o(127501);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tkJ == null) {
        break label378;
      }
    }
    label378:
    for (int i = f.a.a.b.b.a.e(1, this.tkJ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Flk != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Flk);
      }
      i = paramInt;
      if (this.wTM != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.wTM);
      }
      paramInt = f.a.a.b.b.a.bx(4, this.ndI);
      AppMethodBeat.o(127501);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(127501);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bvk localbvk = (bvk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127501);
          return -1;
        case 1: 
          localbvk.tkJ = locala.LVo.readString();
          AppMethodBeat.o(127501);
          return 0;
        case 2: 
          localbvk.Flk = locala.LVo.readString();
          AppMethodBeat.o(127501);
          return 0;
        case 3: 
          localbvk.wTM = locala.LVo.readString();
          AppMethodBeat.o(127501);
          return 0;
        }
        localbvk.ndI = locala.LVo.xF();
        AppMethodBeat.o(127501);
        return 0;
      }
      AppMethodBeat.o(127501);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bvk
 * JD-Core Version:    0.7.0.1
 */