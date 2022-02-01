package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cpw
  extends com.tencent.mm.bw.a
{
  public String EUn;
  public int EUq;
  public int Een;
  public String djj;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(175247);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.djj != null) {
        paramVarArgs.d(1, this.djj);
      }
      if (this.username != null) {
        paramVarArgs.d(2, this.username);
      }
      if (this.EUn != null) {
        paramVarArgs.d(3, this.EUn);
      }
      paramVarArgs.aR(4, this.EUq);
      paramVarArgs.aR(5, this.Een);
      AppMethodBeat.o(175247);
      return 0;
    }
    if (paramInt == 1) {
      if (this.djj == null) {
        break label426;
      }
    }
    label426:
    for (int i = f.a.a.b.b.a.e(1, this.djj) + 0;; i = 0)
    {
      paramInt = i;
      if (this.username != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.username);
      }
      i = paramInt;
      if (this.EUn != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.EUn);
      }
      paramInt = f.a.a.b.b.a.bx(4, this.EUq);
      int j = f.a.a.b.b.a.bx(5, this.Een);
      AppMethodBeat.o(175247);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(175247);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cpw localcpw = (cpw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(175247);
          return -1;
        case 1: 
          localcpw.djj = locala.LVo.readString();
          AppMethodBeat.o(175247);
          return 0;
        case 2: 
          localcpw.username = locala.LVo.readString();
          AppMethodBeat.o(175247);
          return 0;
        case 3: 
          localcpw.EUn = locala.LVo.readString();
          AppMethodBeat.o(175247);
          return 0;
        case 4: 
          localcpw.EUq = locala.LVo.xF();
          AppMethodBeat.o(175247);
          return 0;
        }
        localcpw.Een = locala.LVo.xF();
        AppMethodBeat.o(175247);
        return 0;
      }
      AppMethodBeat.o(175247);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cpw
 * JD-Core Version:    0.7.0.1
 */