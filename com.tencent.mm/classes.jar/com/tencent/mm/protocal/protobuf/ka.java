package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ka
  extends com.tencent.mm.bw.a
{
  public LinkedList<String> KOo;
  public int ReqType;
  public int xIY;
  public int xuA;
  
  public ka()
  {
    AppMethodBeat.i(104755);
    this.KOo = new LinkedList();
    AppMethodBeat.o(104755);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104756);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.xuA);
      paramVarArgs.aM(2, this.ReqType);
      paramVarArgs.e(3, 1, this.KOo);
      paramVarArgs.aM(4, this.xIY);
      AppMethodBeat.o(104756);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.xuA);
      int i = g.a.a.b.b.a.bu(2, this.ReqType);
      int j = g.a.a.a.c(3, 1, this.KOo);
      int k = g.a.a.b.b.a.bu(4, this.xIY);
      AppMethodBeat.o(104756);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.KOo.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(104756);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ka localka = (ka)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(104756);
        return -1;
      case 1: 
        localka.xuA = locala.UbS.zi();
        AppMethodBeat.o(104756);
        return 0;
      case 2: 
        localka.ReqType = locala.UbS.zi();
        AppMethodBeat.o(104756);
        return 0;
      case 3: 
        localka.KOo.add(locala.UbS.readString());
        AppMethodBeat.o(104756);
        return 0;
      }
      localka.xIY = locala.UbS.zi();
      AppMethodBeat.o(104756);
      return 0;
    }
    AppMethodBeat.o(104756);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ka
 * JD-Core Version:    0.7.0.1
 */