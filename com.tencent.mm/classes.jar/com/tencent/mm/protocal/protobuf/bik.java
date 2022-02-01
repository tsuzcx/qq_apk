package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bik
  extends com.tencent.mm.bw.a
{
  public String EuS;
  public int EuT;
  public String tGX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147769);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EuS != null) {
        paramVarArgs.d(1, this.EuS);
      }
      paramVarArgs.aR(2, this.EuT);
      if (this.tGX != null) {
        paramVarArgs.d(3, this.tGX);
      }
      AppMethodBeat.o(147769);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EuS == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = f.a.a.b.b.a.e(1, this.EuS) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.EuT);
      paramInt = i;
      if (this.tGX != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.tGX);
      }
      AppMethodBeat.o(147769);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(147769);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bik localbik = (bik)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(147769);
          return -1;
        case 1: 
          localbik.EuS = locala.LVo.readString();
          AppMethodBeat.o(147769);
          return 0;
        case 2: 
          localbik.EuT = locala.LVo.xF();
          AppMethodBeat.o(147769);
          return 0;
        }
        localbik.tGX = locala.LVo.readString();
        AppMethodBeat.o(147769);
        return 0;
      }
      AppMethodBeat.o(147769);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bik
 * JD-Core Version:    0.7.0.1
 */