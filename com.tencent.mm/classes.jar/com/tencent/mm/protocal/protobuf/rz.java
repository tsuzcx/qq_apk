package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class rz
  extends com.tencent.mm.bw.a
{
  public String Elc;
  public String code;
  public String djj;
  public String nUr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113977);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.nUr != null) {
        paramVarArgs.d(1, this.nUr);
      }
      if (this.code != null) {
        paramVarArgs.d(2, this.code);
      }
      if (this.Elc != null) {
        paramVarArgs.d(3, this.Elc);
      }
      if (this.djj != null) {
        paramVarArgs.d(4, this.djj);
      }
      AppMethodBeat.o(113977);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nUr == null) {
        break label394;
      }
    }
    label394:
    for (int i = f.a.a.b.b.a.e(1, this.nUr) + 0;; i = 0)
    {
      paramInt = i;
      if (this.code != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.code);
      }
      i = paramInt;
      if (this.Elc != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Elc);
      }
      paramInt = i;
      if (this.djj != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.djj);
      }
      AppMethodBeat.o(113977);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(113977);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        rz localrz = (rz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(113977);
          return -1;
        case 1: 
          localrz.nUr = locala.LVo.readString();
          AppMethodBeat.o(113977);
          return 0;
        case 2: 
          localrz.code = locala.LVo.readString();
          AppMethodBeat.o(113977);
          return 0;
        case 3: 
          localrz.Elc = locala.LVo.readString();
          AppMethodBeat.o(113977);
          return 0;
        }
        localrz.djj = locala.LVo.readString();
        AppMethodBeat.o(113977);
        return 0;
      }
      AppMethodBeat.o(113977);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.rz
 * JD-Core Version:    0.7.0.1
 */