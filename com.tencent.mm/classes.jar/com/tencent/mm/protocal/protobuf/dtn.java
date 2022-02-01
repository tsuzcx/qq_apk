package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class dtn
  extends com.tencent.mm.bw.a
{
  public int CW;
  public b Ewb;
  public String uuid;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147789);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.CW);
      if (this.uuid != null) {
        paramVarArgs.d(2, this.uuid);
      }
      if (this.Ewb != null) {
        paramVarArgs.c(3, this.Ewb);
      }
      AppMethodBeat.o(147789);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.CW) + 0;
      paramInt = i;
      if (this.uuid != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.uuid);
      }
      i = paramInt;
      if (this.Ewb != null) {
        i = paramInt + f.a.a.b.b.a.b(3, this.Ewb);
      }
      AppMethodBeat.o(147789);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(147789);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dtn localdtn = (dtn)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(147789);
        return -1;
      case 1: 
        localdtn.CW = locala.LVo.xF();
        AppMethodBeat.o(147789);
        return 0;
      case 2: 
        localdtn.uuid = locala.LVo.readString();
        AppMethodBeat.o(147789);
        return 0;
      }
      localdtn.Ewb = locala.LVo.gfk();
      AppMethodBeat.o(147789);
      return 0;
    }
    AppMethodBeat.o(147789);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dtn
 * JD-Core Version:    0.7.0.1
 */