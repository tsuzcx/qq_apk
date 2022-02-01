package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dfy
  extends com.tencent.mm.bw.a
{
  public int FPk;
  public int FPl;
  public String Fed;
  public String hOf;
  public String tlT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153306);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Fed != null) {
        paramVarArgs.d(1, this.Fed);
      }
      paramVarArgs.aR(2, this.FPk);
      paramVarArgs.aR(3, this.FPl);
      if (this.tlT != null) {
        paramVarArgs.d(4, this.tlT);
      }
      if (this.hOf != null) {
        paramVarArgs.d(5, this.hOf);
      }
      AppMethodBeat.o(153306);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Fed == null) {
        break label422;
      }
    }
    label422:
    for (paramInt = f.a.a.b.b.a.e(1, this.Fed) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.FPk) + f.a.a.b.b.a.bx(3, this.FPl);
      paramInt = i;
      if (this.tlT != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.tlT);
      }
      i = paramInt;
      if (this.hOf != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.hOf);
      }
      AppMethodBeat.o(153306);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(153306);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dfy localdfy = (dfy)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(153306);
          return -1;
        case 1: 
          localdfy.Fed = locala.LVo.readString();
          AppMethodBeat.o(153306);
          return 0;
        case 2: 
          localdfy.FPk = locala.LVo.xF();
          AppMethodBeat.o(153306);
          return 0;
        case 3: 
          localdfy.FPl = locala.LVo.xF();
          AppMethodBeat.o(153306);
          return 0;
        case 4: 
          localdfy.tlT = locala.LVo.readString();
          AppMethodBeat.o(153306);
          return 0;
        }
        localdfy.hOf = locala.LVo.readString();
        AppMethodBeat.o(153306);
        return 0;
      }
      AppMethodBeat.o(153306);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dfy
 * JD-Core Version:    0.7.0.1
 */