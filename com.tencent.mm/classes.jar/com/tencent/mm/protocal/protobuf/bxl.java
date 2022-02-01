package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bxl
  extends com.tencent.mm.bw.a
{
  public String Fmi;
  public String Fmj;
  public int Fmk;
  public int Fml;
  public int Fmm;
  public int Fmn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133179);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Fmi != null) {
        paramVarArgs.d(1, this.Fmi);
      }
      if (this.Fmj != null) {
        paramVarArgs.d(2, this.Fmj);
      }
      paramVarArgs.aR(3, this.Fmk);
      paramVarArgs.aR(4, this.Fml);
      paramVarArgs.aR(5, this.Fmm);
      paramVarArgs.aR(7, this.Fmn);
      AppMethodBeat.o(133179);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Fmi == null) {
        break label462;
      }
    }
    label462:
    for (paramInt = f.a.a.b.b.a.e(1, this.Fmi) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Fmj != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Fmj);
      }
      paramInt = f.a.a.b.b.a.bx(3, this.Fmk);
      int j = f.a.a.b.b.a.bx(4, this.Fml);
      int k = f.a.a.b.b.a.bx(5, this.Fmm);
      int m = f.a.a.b.b.a.bx(7, this.Fmn);
      AppMethodBeat.o(133179);
      return i + paramInt + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(133179);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bxl localbxl = (bxl)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 6: 
        default: 
          AppMethodBeat.o(133179);
          return -1;
        case 1: 
          localbxl.Fmi = locala.LVo.readString();
          AppMethodBeat.o(133179);
          return 0;
        case 2: 
          localbxl.Fmj = locala.LVo.readString();
          AppMethodBeat.o(133179);
          return 0;
        case 3: 
          localbxl.Fmk = locala.LVo.xF();
          AppMethodBeat.o(133179);
          return 0;
        case 4: 
          localbxl.Fml = locala.LVo.xF();
          AppMethodBeat.o(133179);
          return 0;
        case 5: 
          localbxl.Fmm = locala.LVo.xF();
          AppMethodBeat.o(133179);
          return 0;
        }
        localbxl.Fmn = locala.LVo.xF();
        AppMethodBeat.o(133179);
        return 0;
      }
      AppMethodBeat.o(133179);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bxl
 * JD-Core Version:    0.7.0.1
 */