package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class dxb
  extends com.tencent.mm.bw.a
{
  public long FvQ;
  public boolean GdL;
  public String Username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32540);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Username == null)
      {
        paramVarArgs = new b("Not all required fields were included: Username");
        AppMethodBeat.o(32540);
        throw paramVarArgs;
      }
      if (this.Username != null) {
        paramVarArgs.d(1, this.Username);
      }
      paramVarArgs.aO(2, this.FvQ);
      paramVarArgs.bl(3, this.GdL);
      AppMethodBeat.o(32540);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Username == null) {
        break label363;
      }
    }
    label363:
    for (paramInt = f.a.a.b.b.a.e(1, this.Username) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.p(2, this.FvQ);
      int j = f.a.a.b.b.a.fK(3);
      AppMethodBeat.o(32540);
      return paramInt + i + (j + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.Username == null)
        {
          paramVarArgs = new b("Not all required fields were included: Username");
          AppMethodBeat.o(32540);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32540);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dxb localdxb = (dxb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32540);
          return -1;
        case 1: 
          localdxb.Username = locala.LVo.readString();
          AppMethodBeat.o(32540);
          return 0;
        case 2: 
          localdxb.FvQ = locala.LVo.xG();
          AppMethodBeat.o(32540);
          return 0;
        }
        localdxb.GdL = locala.LVo.fZX();
        AppMethodBeat.o(32540);
        return 0;
      }
      AppMethodBeat.o(32540);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dxb
 * JD-Core Version:    0.7.0.1
 */