package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class mj
  extends com.tencent.mm.bw.a
{
  public String Ebg;
  public int Ebh;
  public String Ebi;
  public int Ebj;
  public int Ebk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124415);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Ebg != null) {
        paramVarArgs.d(1, this.Ebg);
      }
      paramVarArgs.aR(2, this.Ebh);
      if (this.Ebi != null) {
        paramVarArgs.d(3, this.Ebi);
      }
      paramVarArgs.aR(4, this.Ebj);
      paramVarArgs.aR(5, this.Ebk);
      AppMethodBeat.o(124415);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Ebg == null) {
        break label410;
      }
    }
    label410:
    for (paramInt = f.a.a.b.b.a.e(1, this.Ebg) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.Ebh);
      paramInt = i;
      if (this.Ebi != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Ebi);
      }
      i = f.a.a.b.b.a.bx(4, this.Ebj);
      int j = f.a.a.b.b.a.bx(5, this.Ebk);
      AppMethodBeat.o(124415);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(124415);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        mj localmj = (mj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124415);
          return -1;
        case 1: 
          localmj.Ebg = locala.LVo.readString();
          AppMethodBeat.o(124415);
          return 0;
        case 2: 
          localmj.Ebh = locala.LVo.xF();
          AppMethodBeat.o(124415);
          return 0;
        case 3: 
          localmj.Ebi = locala.LVo.readString();
          AppMethodBeat.o(124415);
          return 0;
        case 4: 
          localmj.Ebj = locala.LVo.xF();
          AppMethodBeat.o(124415);
          return 0;
        }
        localmj.Ebk = locala.LVo.xF();
        AppMethodBeat.o(124415);
        return 0;
      }
      AppMethodBeat.o(124415);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.mj
 * JD-Core Version:    0.7.0.1
 */