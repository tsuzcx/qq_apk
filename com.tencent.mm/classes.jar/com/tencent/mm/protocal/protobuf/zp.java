package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zp
  extends com.tencent.mm.bw.a
{
  public String BsL;
  public String BsP;
  public String BzP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91429);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BsL != null) {
        paramVarArgs.d(1, this.BsL);
      }
      if (this.BzP != null) {
        paramVarArgs.d(2, this.BzP);
      }
      if (this.BsP != null) {
        paramVarArgs.d(3, this.BsP);
      }
      AppMethodBeat.o(91429);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BsL == null) {
        break label334;
      }
    }
    label334:
    for (int i = f.a.a.b.b.a.e(1, this.BsL) + 0;; i = 0)
    {
      paramInt = i;
      if (this.BzP != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.BzP);
      }
      i = paramInt;
      if (this.BsP != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.BsP);
      }
      AppMethodBeat.o(91429);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(91429);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        zp localzp = (zp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91429);
          return -1;
        case 1: 
          localzp.BsL = locala.LVo.readString();
          AppMethodBeat.o(91429);
          return 0;
        case 2: 
          localzp.BzP = locala.LVo.readString();
          AppMethodBeat.o(91429);
          return 0;
        }
        localzp.BsP = locala.LVo.readString();
        AppMethodBeat.o(91429);
        return 0;
      }
      AppMethodBeat.o(91429);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.zp
 * JD-Core Version:    0.7.0.1
 */