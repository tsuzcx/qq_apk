package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class acv
  extends com.tencent.mm.bw.a
{
  public LinkedList<String> Loe;
  public int Lof;
  public boolean Log;
  public int Loh;
  
  public acv()
  {
    AppMethodBeat.i(186795);
    this.Loe = new LinkedList();
    AppMethodBeat.o(186795);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(186796);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 1, this.Loe);
      paramVarArgs.aM(2, this.Lof);
      paramVarArgs.cc(3, this.Log);
      paramVarArgs.aM(4, this.Loh);
      AppMethodBeat.o(186796);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.a.c(1, 1, this.Loe);
      int i = g.a.a.b.b.a.bu(2, this.Lof);
      int j = g.a.a.b.b.a.fS(3);
      int k = g.a.a.b.b.a.bu(4, this.Loh);
      AppMethodBeat.o(186796);
      return paramInt + 0 + i + (j + 1) + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Loe.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(186796);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      acv localacv = (acv)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(186796);
        return -1;
      case 1: 
        localacv.Loe.add(locala.UbS.readString());
        AppMethodBeat.o(186796);
        return 0;
      case 2: 
        localacv.Lof = locala.UbS.zi();
        AppMethodBeat.o(186796);
        return 0;
      case 3: 
        localacv.Log = locala.UbS.yZ();
        AppMethodBeat.o(186796);
        return 0;
      }
      localacv.Loh = locala.UbS.zi();
      AppMethodBeat.o(186796);
      return 0;
    }
    AppMethodBeat.o(186796);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.acv
 * JD-Core Version:    0.7.0.1
 */