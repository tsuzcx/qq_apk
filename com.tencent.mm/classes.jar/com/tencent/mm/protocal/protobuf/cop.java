package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class cop
  extends com.tencent.mm.cd.a
{
  public String key;
  public String lvH;
  public int type = -1;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(256260);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.key == null)
      {
        paramVarArgs = new b("Not all required fields were included: key");
        AppMethodBeat.o(256260);
        throw paramVarArgs;
      }
      if (this.lvH == null)
      {
        paramVarArgs = new b("Not all required fields were included: val");
        AppMethodBeat.o(256260);
        throw paramVarArgs;
      }
      paramVarArgs.aY(1, this.type);
      if (this.key != null) {
        paramVarArgs.f(2, this.key);
      }
      if (this.lvH != null) {
        paramVarArgs.f(3, this.lvH);
      }
      AppMethodBeat.o(256260);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.type) + 0;
      paramInt = i;
      if (this.key != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.key);
      }
      i = paramInt;
      if (this.lvH != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.lvH);
      }
      AppMethodBeat.o(256260);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      if (this.key == null)
      {
        paramVarArgs = new b("Not all required fields were included: key");
        AppMethodBeat.o(256260);
        throw paramVarArgs;
      }
      if (this.lvH == null)
      {
        paramVarArgs = new b("Not all required fields were included: val");
        AppMethodBeat.o(256260);
        throw paramVarArgs;
      }
      AppMethodBeat.o(256260);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      cop localcop = (cop)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(256260);
        return -1;
      case 1: 
        localcop.type = locala.abFh.AK();
        AppMethodBeat.o(256260);
        return 0;
      case 2: 
        localcop.key = locala.abFh.readString();
        AppMethodBeat.o(256260);
        return 0;
      }
      localcop.lvH = locala.abFh.readString();
      AppMethodBeat.o(256260);
      return 0;
    }
    AppMethodBeat.o(256260);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cop
 * JD-Core Version:    0.7.0.1
 */