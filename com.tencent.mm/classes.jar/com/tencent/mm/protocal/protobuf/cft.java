package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class cft
  extends com.tencent.mm.bw.a
{
  public String iFF;
  public String key;
  public int type = -1;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(220712);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.key == null)
      {
        paramVarArgs = new b("Not all required fields were included: key");
        AppMethodBeat.o(220712);
        throw paramVarArgs;
      }
      if (this.iFF == null)
      {
        paramVarArgs = new b("Not all required fields were included: val");
        AppMethodBeat.o(220712);
        throw paramVarArgs;
      }
      paramVarArgs.aM(1, this.type);
      if (this.key != null) {
        paramVarArgs.e(2, this.key);
      }
      if (this.iFF != null) {
        paramVarArgs.e(3, this.iFF);
      }
      AppMethodBeat.o(220712);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.type) + 0;
      paramInt = i;
      if (this.key != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.key);
      }
      i = paramInt;
      if (this.iFF != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.iFF);
      }
      AppMethodBeat.o(220712);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      if (this.key == null)
      {
        paramVarArgs = new b("Not all required fields were included: key");
        AppMethodBeat.o(220712);
        throw paramVarArgs;
      }
      if (this.iFF == null)
      {
        paramVarArgs = new b("Not all required fields were included: val");
        AppMethodBeat.o(220712);
        throw paramVarArgs;
      }
      AppMethodBeat.o(220712);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      cft localcft = (cft)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(220712);
        return -1;
      case 1: 
        localcft.type = locala.UbS.zi();
        AppMethodBeat.o(220712);
        return 0;
      case 2: 
        localcft.key = locala.UbS.readString();
        AppMethodBeat.o(220712);
        return 0;
      }
      localcft.iFF = locala.UbS.readString();
      AppMethodBeat.o(220712);
      return 0;
    }
    AppMethodBeat.o(220712);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cft
 * JD-Core Version:    0.7.0.1
 */