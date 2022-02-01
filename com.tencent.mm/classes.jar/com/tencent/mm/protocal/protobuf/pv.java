package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class pv
  extends com.tencent.mm.bw.a
{
  public String EgA;
  public long Id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117853);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EgA == null)
      {
        paramVarArgs = new b("Not all required fields were included: ObjectDesc");
        AppMethodBeat.o(117853);
        throw paramVarArgs;
      }
      paramVarArgs.aO(1, this.Id);
      if (this.EgA != null) {
        paramVarArgs.d(2, this.EgA);
      }
      AppMethodBeat.o(117853);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.p(1, this.Id) + 0;
      paramInt = i;
      if (this.EgA != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.EgA);
      }
      AppMethodBeat.o(117853);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      if (this.EgA == null)
      {
        paramVarArgs = new b("Not all required fields were included: ObjectDesc");
        AppMethodBeat.o(117853);
        throw paramVarArgs;
      }
      AppMethodBeat.o(117853);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      pv localpv = (pv)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(117853);
        return -1;
      case 1: 
        localpv.Id = locala.LVo.xG();
        AppMethodBeat.o(117853);
        return 0;
      }
      localpv.EgA = locala.LVo.readString();
      AppMethodBeat.o(117853);
      return 0;
    }
    AppMethodBeat.o(117853);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pv
 * JD-Core Version:    0.7.0.1
 */