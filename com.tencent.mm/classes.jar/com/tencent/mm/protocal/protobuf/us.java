package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class us
  extends com.tencent.mm.bw.a
{
  public boolean EoI;
  public String desc;
  public String result;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(207489);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.d(2, this.desc);
      }
      if (this.result != null) {
        paramVarArgs.d(3, this.result);
      }
      paramVarArgs.bl(4, this.EoI);
      AppMethodBeat.o(207489);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label378;
      }
    }
    label378:
    for (int i = f.a.a.b.b.a.e(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.desc);
      }
      i = paramInt;
      if (this.result != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.result);
      }
      paramInt = f.a.a.b.b.a.fK(4);
      AppMethodBeat.o(207489);
      return i + (paramInt + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(207489);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        us localus = (us)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(207489);
          return -1;
        case 1: 
          localus.title = locala.LVo.readString();
          AppMethodBeat.o(207489);
          return 0;
        case 2: 
          localus.desc = locala.LVo.readString();
          AppMethodBeat.o(207489);
          return 0;
        case 3: 
          localus.result = locala.LVo.readString();
          AppMethodBeat.o(207489);
          return 0;
        }
        localus.EoI = locala.LVo.fZX();
        AppMethodBeat.o(207489);
        return 0;
      }
      AppMethodBeat.o(207489);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.us
 * JD-Core Version:    0.7.0.1
 */