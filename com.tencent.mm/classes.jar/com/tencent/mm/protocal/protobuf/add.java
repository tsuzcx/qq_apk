package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class add
  extends com.tencent.mm.bw.a
{
  public int Loq;
  public int Lor;
  public String Los;
  public String dFb;
  public String dFc;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32169);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.version);
      paramVarArgs.aM(2, this.Loq);
      paramVarArgs.aM(3, this.Lor);
      if (this.dFc != null) {
        paramVarArgs.e(4, this.dFc);
      }
      if (this.Los != null) {
        paramVarArgs.e(5, this.Los);
      }
      if (this.dFb != null) {
        paramVarArgs.e(6, this.dFb);
      }
      AppMethodBeat.o(32169);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.version) + 0 + g.a.a.b.b.a.bu(2, this.Loq) + g.a.a.b.b.a.bu(3, this.Lor);
      paramInt = i;
      if (this.dFc != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.dFc);
      }
      i = paramInt;
      if (this.Los != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.Los);
      }
      paramInt = i;
      if (this.dFb != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.dFb);
      }
      AppMethodBeat.o(32169);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(32169);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      add localadd = (add)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32169);
        return -1;
      case 1: 
        localadd.version = locala.UbS.zi();
        AppMethodBeat.o(32169);
        return 0;
      case 2: 
        localadd.Loq = locala.UbS.zi();
        AppMethodBeat.o(32169);
        return 0;
      case 3: 
        localadd.Lor = locala.UbS.zi();
        AppMethodBeat.o(32169);
        return 0;
      case 4: 
        localadd.dFc = locala.UbS.readString();
        AppMethodBeat.o(32169);
        return 0;
      case 5: 
        localadd.Los = locala.UbS.readString();
        AppMethodBeat.o(32169);
        return 0;
      }
      localadd.dFb = locala.UbS.readString();
      AppMethodBeat.o(32169);
      return 0;
    }
    AppMethodBeat.o(32169);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.add
 * JD-Core Version:    0.7.0.1
 */