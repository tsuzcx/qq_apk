package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ig
  extends com.tencent.mm.bw.a
{
  public String DVW;
  public String cZz;
  public String tGS;
  public String vxk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91356);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DVW != null) {
        paramVarArgs.d(1, this.DVW);
      }
      if (this.cZz != null) {
        paramVarArgs.d(2, this.cZz);
      }
      if (this.tGS != null) {
        paramVarArgs.d(3, this.tGS);
      }
      if (this.vxk != null) {
        paramVarArgs.d(4, this.vxk);
      }
      AppMethodBeat.o(91356);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DVW == null) {
        break label394;
      }
    }
    label394:
    for (int i = f.a.a.b.b.a.e(1, this.DVW) + 0;; i = 0)
    {
      paramInt = i;
      if (this.cZz != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.cZz);
      }
      i = paramInt;
      if (this.tGS != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.tGS);
      }
      paramInt = i;
      if (this.vxk != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.vxk);
      }
      AppMethodBeat.o(91356);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(91356);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ig localig = (ig)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91356);
          return -1;
        case 1: 
          localig.DVW = locala.LVo.readString();
          AppMethodBeat.o(91356);
          return 0;
        case 2: 
          localig.cZz = locala.LVo.readString();
          AppMethodBeat.o(91356);
          return 0;
        case 3: 
          localig.tGS = locala.LVo.readString();
          AppMethodBeat.o(91356);
          return 0;
        }
        localig.vxk = locala.LVo.readString();
        AppMethodBeat.o(91356);
        return 0;
      }
      AppMethodBeat.o(91356);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ig
 * JD-Core Version:    0.7.0.1
 */