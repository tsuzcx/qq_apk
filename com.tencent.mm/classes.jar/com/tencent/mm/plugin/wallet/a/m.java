package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class m
  extends com.tencent.mm.bw.a
{
  public String CZb;
  public int selected;
  public String wRt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91298);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CZb != null) {
        paramVarArgs.d(1, this.CZb);
      }
      paramVarArgs.aS(2, this.selected);
      if (this.wRt != null) {
        paramVarArgs.d(3, this.wRt);
      }
      AppMethodBeat.o(91298);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CZb == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = f.a.a.b.b.a.e(1, this.CZb) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.selected);
      paramInt = i;
      if (this.wRt != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.wRt);
      }
      AppMethodBeat.o(91298);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(91298);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        m localm = (m)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91298);
          return -1;
        case 1: 
          localm.CZb = locala.OmT.readString();
          AppMethodBeat.o(91298);
          return 0;
        case 2: 
          localm.selected = locala.OmT.zc();
          AppMethodBeat.o(91298);
          return 0;
        }
        localm.wRt = locala.OmT.readString();
        AppMethodBeat.o(91298);
        return 0;
      }
      AppMethodBeat.o(91298);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.a.m
 * JD-Core Version:    0.7.0.1
 */