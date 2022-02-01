package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class hq
  extends com.tencent.mm.bw.a
{
  public LinkedList<String> DUX;
  public int DUY;
  public int DUZ;
  
  public hq()
  {
    AppMethodBeat.i(104747);
    this.DUX = new LinkedList();
    AppMethodBeat.o(104747);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104748);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 1, this.DUX);
      paramVarArgs.aR(2, this.DUY);
      paramVarArgs.aR(3, this.DUZ);
      AppMethodBeat.o(104748);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.a.c(1, 1, this.DUX);
      int i = f.a.a.b.b.a.bx(2, this.DUY);
      int j = f.a.a.b.b.a.bx(3, this.DUZ);
      AppMethodBeat.o(104748);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.DUX.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(104748);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      hq localhq = (hq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(104748);
        return -1;
      case 1: 
        localhq.DUX.add(locala.LVo.readString());
        AppMethodBeat.o(104748);
        return 0;
      case 2: 
        localhq.DUY = locala.LVo.xF();
        AppMethodBeat.o(104748);
        return 0;
      }
      localhq.DUZ = locala.LVo.xF();
      AppMethodBeat.o(104748);
      return 0;
    }
    AppMethodBeat.o(104748);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.hq
 * JD-Core Version:    0.7.0.1
 */