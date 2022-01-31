package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class qd
  extends com.tencent.mm.bv.a
{
  public String cHn;
  public int kmq;
  public String kqd;
  public int wAo;
  public String wIC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(89048);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.cHn != null) {
        paramVarArgs.e(1, this.cHn);
      }
      if (this.kqd != null) {
        paramVarArgs.e(2, this.kqd);
      }
      paramVarArgs.aO(3, this.kmq);
      paramVarArgs.aO(4, this.wAo);
      if (this.wIC != null) {
        paramVarArgs.e(5, this.wIC);
      }
      AppMethodBeat.o(89048);
      return 0;
    }
    if (paramInt == 1) {
      if (this.cHn == null) {
        break label422;
      }
    }
    label422:
    for (paramInt = e.a.a.b.b.a.f(1, this.cHn) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.kqd != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.kqd);
      }
      i = i + e.a.a.b.b.a.bl(3, this.kmq) + e.a.a.b.b.a.bl(4, this.wAo);
      paramInt = i;
      if (this.wIC != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.wIC);
      }
      AppMethodBeat.o(89048);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(89048);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        qd localqd = (qd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(89048);
          return -1;
        case 1: 
          localqd.cHn = locala.CLY.readString();
          AppMethodBeat.o(89048);
          return 0;
        case 2: 
          localqd.kqd = locala.CLY.readString();
          AppMethodBeat.o(89048);
          return 0;
        case 3: 
          localqd.kmq = locala.CLY.sl();
          AppMethodBeat.o(89048);
          return 0;
        case 4: 
          localqd.wAo = locala.CLY.sl();
          AppMethodBeat.o(89048);
          return 0;
        }
        localqd.wIC = locala.CLY.readString();
        AppMethodBeat.o(89048);
        return 0;
      }
      AppMethodBeat.o(89048);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qd
 * JD-Core Version:    0.7.0.1
 */