package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class xb
  extends com.tencent.mm.bw.a
{
  public String Erv;
  public String qom;
  public String qox;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(195044);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.qox != null) {
        paramVarArgs.d(1, this.qox);
      }
      if (this.qom != null) {
        paramVarArgs.d(2, this.qom);
      }
      if (this.Erv != null) {
        paramVarArgs.d(3, this.Erv);
      }
      AppMethodBeat.o(195044);
      return 0;
    }
    if (paramInt == 1) {
      if (this.qox == null) {
        break label334;
      }
    }
    label334:
    for (int i = f.a.a.b.b.a.e(1, this.qox) + 0;; i = 0)
    {
      paramInt = i;
      if (this.qom != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.qom);
      }
      i = paramInt;
      if (this.Erv != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Erv);
      }
      AppMethodBeat.o(195044);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(195044);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        xb localxb = (xb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(195044);
          return -1;
        case 1: 
          localxb.qox = locala.LVo.readString();
          AppMethodBeat.o(195044);
          return 0;
        case 2: 
          localxb.qom = locala.LVo.readString();
          AppMethodBeat.o(195044);
          return 0;
        }
        localxb.Erv = locala.LVo.readString();
        AppMethodBeat.o(195044);
        return 0;
      }
      AppMethodBeat.o(195044);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.xb
 * JD-Core Version:    0.7.0.1
 */