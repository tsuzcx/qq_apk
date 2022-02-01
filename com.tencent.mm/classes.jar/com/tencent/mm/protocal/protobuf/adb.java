package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class adb
  extends com.tencent.mm.bw.a
{
  public long Lnw;
  public int Lof;
  public String Loo;
  public LinkedList<String> Lop;
  
  public adb()
  {
    AppMethodBeat.i(186801);
    this.Lop = new LinkedList();
    AppMethodBeat.o(186801);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(186802);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.Lnw);
      if (this.Loo != null) {
        paramVarArgs.e(2, this.Loo);
      }
      paramVarArgs.e(3, 1, this.Lop);
      paramVarArgs.aM(4, this.Lof);
      AppMethodBeat.o(186802);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.r(1, this.Lnw) + 0;
      paramInt = i;
      if (this.Loo != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Loo);
      }
      i = g.a.a.a.c(3, 1, this.Lop);
      int j = g.a.a.b.b.a.bu(4, this.Lof);
      AppMethodBeat.o(186802);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Lop.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(186802);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      adb localadb = (adb)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(186802);
        return -1;
      case 1: 
        localadb.Lnw = locala.UbS.zl();
        AppMethodBeat.o(186802);
        return 0;
      case 2: 
        localadb.Loo = locala.UbS.readString();
        AppMethodBeat.o(186802);
        return 0;
      case 3: 
        localadb.Lop.add(locala.UbS.readString());
        AppMethodBeat.o(186802);
        return 0;
      }
      localadb.Lof = locala.UbS.zi();
      AppMethodBeat.o(186802);
      return 0;
    }
    AppMethodBeat.o(186802);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.adb
 * JD-Core Version:    0.7.0.1
 */