package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dkf
  extends com.tencent.mm.bw.a
{
  public int Category;
  public int MOb;
  public int MOc;
  public LinkedList<String> MOd;
  public int MOe;
  
  public dkf()
  {
    AppMethodBeat.i(117893);
    this.MOd = new LinkedList();
    AppMethodBeat.o(117893);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117894);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.MOb);
      paramVarArgs.aM(2, this.MOc);
      paramVarArgs.aM(3, this.Category);
      paramVarArgs.e(4, 1, this.MOd);
      paramVarArgs.aM(5, this.MOe);
      AppMethodBeat.o(117894);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.MOb);
      int i = g.a.a.b.b.a.bu(2, this.MOc);
      int j = g.a.a.b.b.a.bu(3, this.Category);
      int k = g.a.a.a.c(4, 1, this.MOd);
      int m = g.a.a.b.b.a.bu(5, this.MOe);
      AppMethodBeat.o(117894);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.MOd.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(117894);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      dkf localdkf = (dkf)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(117894);
        return -1;
      case 1: 
        localdkf.MOb = locala.UbS.zi();
        AppMethodBeat.o(117894);
        return 0;
      case 2: 
        localdkf.MOc = locala.UbS.zi();
        AppMethodBeat.o(117894);
        return 0;
      case 3: 
        localdkf.Category = locala.UbS.zi();
        AppMethodBeat.o(117894);
        return 0;
      case 4: 
        localdkf.MOd.add(locala.UbS.readString());
        AppMethodBeat.o(117894);
        return 0;
      }
      localdkf.MOe = locala.UbS.zi();
      AppMethodBeat.o(117894);
      return 0;
    }
    AppMethodBeat.o(117894);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dkf
 * JD-Core Version:    0.7.0.1
 */