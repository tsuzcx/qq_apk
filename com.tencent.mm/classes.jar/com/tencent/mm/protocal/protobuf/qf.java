package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class qf
  extends com.tencent.mm.bw.a
{
  public String KXd;
  public String KXe;
  public String KXf;
  public long KXg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(212261);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KXd != null) {
        paramVarArgs.e(1, this.KXd);
      }
      if (this.KXe != null) {
        paramVarArgs.e(2, this.KXe);
      }
      if (this.KXf != null) {
        paramVarArgs.e(3, this.KXf);
      }
      paramVarArgs.bb(4, this.KXg);
      AppMethodBeat.o(212261);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KXd == null) {
        break label378;
      }
    }
    label378:
    for (int i = g.a.a.b.b.a.f(1, this.KXd) + 0;; i = 0)
    {
      paramInt = i;
      if (this.KXe != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.KXe);
      }
      i = paramInt;
      if (this.KXf != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.KXf);
      }
      paramInt = g.a.a.b.b.a.r(4, this.KXg);
      AppMethodBeat.o(212261);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(212261);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        qf localqf = (qf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(212261);
          return -1;
        case 1: 
          localqf.KXd = locala.UbS.readString();
          AppMethodBeat.o(212261);
          return 0;
        case 2: 
          localqf.KXe = locala.UbS.readString();
          AppMethodBeat.o(212261);
          return 0;
        case 3: 
          localqf.KXf = locala.UbS.readString();
          AppMethodBeat.o(212261);
          return 0;
        }
        localqf.KXg = locala.UbS.zl();
        AppMethodBeat.o(212261);
        return 0;
      }
      AppMethodBeat.o(212261);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qf
 * JD-Core Version:    0.7.0.1
 */