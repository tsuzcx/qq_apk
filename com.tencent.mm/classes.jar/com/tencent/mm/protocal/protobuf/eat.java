package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eat
  extends com.tencent.mm.bw.a
{
  public String Ggu;
  public int Ggv;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123704);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Ggu != null) {
        paramVarArgs.d(1, this.Ggu);
      }
      paramVarArgs.aR(2, this.scene);
      paramVarArgs.aR(3, this.Ggv);
      AppMethodBeat.o(123704);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Ggu == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = f.a.a.b.b.a.e(1, this.Ggu) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bx(2, this.scene);
      int j = f.a.a.b.b.a.bx(3, this.Ggv);
      AppMethodBeat.o(123704);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(123704);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        eat localeat = (eat)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123704);
          return -1;
        case 1: 
          localeat.Ggu = locala.LVo.readString();
          AppMethodBeat.o(123704);
          return 0;
        case 2: 
          localeat.scene = locala.LVo.xF();
          AppMethodBeat.o(123704);
          return 0;
        }
        localeat.Ggv = locala.LVo.xF();
        AppMethodBeat.o(123704);
        return 0;
      }
      AppMethodBeat.o(123704);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eat
 * JD-Core Version:    0.7.0.1
 */