package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class byd
  extends com.tencent.mm.bw.a
{
  public String Fno;
  public String Fnp;
  public String Fnq;
  public int action;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(198620);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Fno != null) {
        paramVarArgs.d(1, this.Fno);
      }
      if (this.Fnp != null) {
        paramVarArgs.d(2, this.Fnp);
      }
      if (this.Fnq != null) {
        paramVarArgs.d(3, this.Fnq);
      }
      paramVarArgs.aR(4, this.action);
      AppMethodBeat.o(198620);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Fno == null) {
        break label378;
      }
    }
    label378:
    for (int i = f.a.a.b.b.a.e(1, this.Fno) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Fnp != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Fnp);
      }
      i = paramInt;
      if (this.Fnq != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Fnq);
      }
      paramInt = f.a.a.b.b.a.bx(4, this.action);
      AppMethodBeat.o(198620);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(198620);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        byd localbyd = (byd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(198620);
          return -1;
        case 1: 
          localbyd.Fno = locala.LVo.readString();
          AppMethodBeat.o(198620);
          return 0;
        case 2: 
          localbyd.Fnp = locala.LVo.readString();
          AppMethodBeat.o(198620);
          return 0;
        case 3: 
          localbyd.Fnq = locala.LVo.readString();
          AppMethodBeat.o(198620);
          return 0;
        }
        localbyd.action = locala.LVo.xF();
        AppMethodBeat.o(198620);
        return 0;
      }
      AppMethodBeat.o(198620);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.byd
 * JD-Core Version:    0.7.0.1
 */