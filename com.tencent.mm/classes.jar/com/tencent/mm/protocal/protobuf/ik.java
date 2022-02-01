package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ik
  extends com.tencent.mm.bw.a
{
  public LinkedList<String> KMy;
  public int KMz;
  public int xIY;
  
  public ik()
  {
    AppMethodBeat.i(104747);
    this.KMy = new LinkedList();
    AppMethodBeat.o(104747);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104748);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 1, this.KMy);
      paramVarArgs.aM(2, this.KMz);
      paramVarArgs.aM(3, this.xIY);
      AppMethodBeat.o(104748);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.a.c(1, 1, this.KMy);
      int i = g.a.a.b.b.a.bu(2, this.KMz);
      int j = g.a.a.b.b.a.bu(3, this.xIY);
      AppMethodBeat.o(104748);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.KMy.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(104748);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ik localik = (ik)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(104748);
        return -1;
      case 1: 
        localik.KMy.add(locala.UbS.readString());
        AppMethodBeat.o(104748);
        return 0;
      case 2: 
        localik.KMz = locala.UbS.zi();
        AppMethodBeat.o(104748);
        return 0;
      }
      localik.xIY = locala.UbS.zi();
      AppMethodBeat.o(104748);
      return 0;
    }
    AppMethodBeat.o(104748);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ik
 * JD-Core Version:    0.7.0.1
 */