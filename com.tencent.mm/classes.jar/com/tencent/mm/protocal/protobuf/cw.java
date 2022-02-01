package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cw
  extends com.tencent.mm.bw.a
{
  public LinkedList<String> DQf;
  public String djF;
  
  public cw()
  {
    AppMethodBeat.i(205114);
    this.DQf = new LinkedList();
    AppMethodBeat.o(205114);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(205115);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.djF != null) {
        paramVarArgs.d(1, this.djF);
      }
      paramVarArgs.e(2, 1, this.DQf);
      AppMethodBeat.o(205115);
      return 0;
    }
    if (paramInt == 1) {
      if (this.djF == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.e(1, this.djF) + 0;; paramInt = 0)
    {
      int i = f.a.a.a.c(2, 1, this.DQf);
      AppMethodBeat.o(205115);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DQf.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(205115);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cw localcw = (cw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(205115);
          return -1;
        case 1: 
          localcw.djF = locala.LVo.readString();
          AppMethodBeat.o(205115);
          return 0;
        }
        localcw.DQf.add(locala.LVo.readString());
        AppMethodBeat.o(205115);
        return 0;
      }
      AppMethodBeat.o(205115);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cw
 * JD-Core Version:    0.7.0.1
 */