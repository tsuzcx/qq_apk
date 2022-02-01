package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dtv
  extends com.tencent.mm.bw.a
{
  public LinkedList<String> GbA;
  public String Gbz;
  
  public dtv()
  {
    AppMethodBeat.i(147798);
    this.GbA = new LinkedList();
    AppMethodBeat.o(147798);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147799);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Gbz != null) {
        paramVarArgs.d(1, this.Gbz);
      }
      paramVarArgs.e(2, 1, this.GbA);
      AppMethodBeat.o(147799);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Gbz == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.e(1, this.Gbz) + 0;; paramInt = 0)
    {
      int i = f.a.a.a.c(2, 1, this.GbA);
      AppMethodBeat.o(147799);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GbA.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(147799);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dtv localdtv = (dtv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(147799);
          return -1;
        case 1: 
          localdtv.Gbz = locala.LVo.readString();
          AppMethodBeat.o(147799);
          return 0;
        }
        localdtv.GbA.add(locala.LVo.readString());
        AppMethodBeat.o(147799);
        return 0;
      }
      AppMethodBeat.o(147799);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dtv
 * JD-Core Version:    0.7.0.1
 */