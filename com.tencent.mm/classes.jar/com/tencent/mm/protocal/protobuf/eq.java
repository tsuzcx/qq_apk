package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eq
  extends com.tencent.mm.bw.a
{
  public boolean CxY;
  public boolean Cyr;
  public boolean Cys;
  public int KAy;
  public String value;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50078);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.KAy);
      if (this.value != null) {
        paramVarArgs.e(2, this.value);
      }
      paramVarArgs.cc(3, this.Cyr);
      paramVarArgs.cc(4, this.CxY);
      paramVarArgs.cc(5, this.Cys);
      AppMethodBeat.o(50078);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.KAy) + 0;
      paramInt = i;
      if (this.value != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.value);
      }
      i = g.a.a.b.b.a.fS(3);
      int j = g.a.a.b.b.a.fS(4);
      int k = g.a.a.b.b.a.fS(5);
      AppMethodBeat.o(50078);
      return paramInt + (i + 1) + (j + 1) + (k + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(50078);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      eq localeq = (eq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(50078);
        return -1;
      case 1: 
        localeq.KAy = locala.UbS.zi();
        AppMethodBeat.o(50078);
        return 0;
      case 2: 
        localeq.value = locala.UbS.readString();
        AppMethodBeat.o(50078);
        return 0;
      case 3: 
        localeq.Cyr = locala.UbS.yZ();
        AppMethodBeat.o(50078);
        return 0;
      case 4: 
        localeq.CxY = locala.UbS.yZ();
        AppMethodBeat.o(50078);
        return 0;
      }
      localeq.Cys = locala.UbS.yZ();
      AppMethodBeat.o(50078);
      return 0;
    }
    AppMethodBeat.o(50078);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eq
 * JD-Core Version:    0.7.0.1
 */