package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bjx
  extends com.tencent.mm.bw.a
{
  public String id;
  public String nUG;
  public long timestamp;
  public String wHu;
  public String wHv;
  public int wHw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72499);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.id != null) {
        paramVarArgs.d(1, this.id);
      }
      if (this.wHu != null) {
        paramVarArgs.d(2, this.wHu);
      }
      if (this.wHv != null) {
        paramVarArgs.d(3, this.wHv);
      }
      if (this.nUG != null) {
        paramVarArgs.d(4, this.nUG);
      }
      paramVarArgs.aO(6, this.timestamp);
      paramVarArgs.aR(5, this.wHw);
      AppMethodBeat.o(72499);
      return 0;
    }
    if (paramInt == 1) {
      if (this.id == null) {
        break label486;
      }
    }
    label486:
    for (int i = f.a.a.b.b.a.e(1, this.id) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wHu != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.wHu);
      }
      i = paramInt;
      if (this.wHv != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.wHv);
      }
      paramInt = i;
      if (this.nUG != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.nUG);
      }
      i = f.a.a.b.b.a.p(6, this.timestamp);
      int j = f.a.a.b.b.a.bx(5, this.wHw);
      AppMethodBeat.o(72499);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(72499);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bjx localbjx = (bjx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72499);
          return -1;
        case 1: 
          localbjx.id = locala.LVo.readString();
          AppMethodBeat.o(72499);
          return 0;
        case 2: 
          localbjx.wHu = locala.LVo.readString();
          AppMethodBeat.o(72499);
          return 0;
        case 3: 
          localbjx.wHv = locala.LVo.readString();
          AppMethodBeat.o(72499);
          return 0;
        case 4: 
          localbjx.nUG = locala.LVo.readString();
          AppMethodBeat.o(72499);
          return 0;
        case 6: 
          localbjx.timestamp = locala.LVo.xG();
          AppMethodBeat.o(72499);
          return 0;
        }
        localbjx.wHw = locala.LVo.xF();
        AppMethodBeat.o(72499);
        return 0;
      }
      AppMethodBeat.o(72499);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bjx
 * JD-Core Version:    0.7.0.1
 */