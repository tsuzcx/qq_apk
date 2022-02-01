package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eid
  extends com.tencent.mm.bw.a
{
  public String LQx;
  public boolean Nht;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(6440);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.LQx != null) {
        paramVarArgs.e(1, this.LQx);
      }
      paramVarArgs.cc(2, this.Nht);
      AppMethodBeat.o(6440);
      return 0;
    }
    if (paramInt == 1) {
      if (this.LQx == null) {
        break label266;
      }
    }
    label266:
    for (paramInt = g.a.a.b.b.a.f(1, this.LQx) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.fS(2);
      AppMethodBeat.o(6440);
      return paramInt + (i + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(6440);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        eid localeid = (eid)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(6440);
          return -1;
        case 1: 
          localeid.LQx = locala.UbS.readString();
          AppMethodBeat.o(6440);
          return 0;
        }
        localeid.Nht = locala.UbS.yZ();
        AppMethodBeat.o(6440);
        return 0;
      }
      AppMethodBeat.o(6440);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eid
 * JD-Core Version:    0.7.0.1
 */