package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class adi
  extends com.tencent.mm.bw.a
{
  public String LjZ;
  public LinkedList<Integer> Low;
  
  public adi()
  {
    AppMethodBeat.i(32170);
    this.Low = new LinkedList();
    AppMethodBeat.o(32170);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32171);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.LjZ != null) {
        paramVarArgs.e(1, this.LjZ);
      }
      paramVarArgs.e(2, 2, this.Low);
      AppMethodBeat.o(32171);
      return 0;
    }
    if (paramInt == 1) {
      if (this.LjZ == null) {
        break label285;
      }
    }
    label285:
    for (paramInt = g.a.a.b.b.a.f(1, this.LjZ) + 0;; paramInt = 0)
    {
      int i = g.a.a.a.c(2, 2, this.Low);
      AppMethodBeat.o(32171);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Low.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(32171);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        adi localadi = (adi)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32171);
          return -1;
        case 1: 
          localadi.LjZ = locala.UbS.readString();
          AppMethodBeat.o(32171);
          return 0;
        }
        localadi.Low.add(Integer.valueOf(locala.UbS.zi()));
        AppMethodBeat.o(32171);
        return 0;
      }
      AppMethodBeat.o(32171);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.adi
 * JD-Core Version:    0.7.0.1
 */