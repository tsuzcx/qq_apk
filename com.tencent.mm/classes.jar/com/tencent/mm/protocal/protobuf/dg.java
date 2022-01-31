package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class dg
  extends com.tencent.mm.bv.a
{
  public String cyA;
  public int type;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56703);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.cyA == null)
      {
        paramVarArgs = new b("Not all required fields were included: wording");
        AppMethodBeat.o(56703);
        throw paramVarArgs;
      }
      if (this.url == null)
      {
        paramVarArgs = new b("Not all required fields were included: url");
        AppMethodBeat.o(56703);
        throw paramVarArgs;
      }
      paramVarArgs.aO(1, this.type);
      if (this.cyA != null) {
        paramVarArgs.e(2, this.cyA);
      }
      if (this.url != null) {
        paramVarArgs.e(3, this.url);
      }
      AppMethodBeat.o(56703);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.type) + 0;
      paramInt = i;
      if (this.cyA != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.cyA);
      }
      i = paramInt;
      if (this.url != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.url);
      }
      AppMethodBeat.o(56703);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      if (this.cyA == null)
      {
        paramVarArgs = new b("Not all required fields were included: wording");
        AppMethodBeat.o(56703);
        throw paramVarArgs;
      }
      if (this.url == null)
      {
        paramVarArgs = new b("Not all required fields were included: url");
        AppMethodBeat.o(56703);
        throw paramVarArgs;
      }
      AppMethodBeat.o(56703);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      dg localdg = (dg)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(56703);
        return -1;
      case 1: 
        localdg.type = locala.CLY.sl();
        AppMethodBeat.o(56703);
        return 0;
      case 2: 
        localdg.cyA = locala.CLY.readString();
        AppMethodBeat.o(56703);
        return 0;
      }
      localdg.url = locala.CLY.readString();
      AppMethodBeat.o(56703);
      return 0;
    }
    AppMethodBeat.o(56703);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dg
 * JD-Core Version:    0.7.0.1
 */