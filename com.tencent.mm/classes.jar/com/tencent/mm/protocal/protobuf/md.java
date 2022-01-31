package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class md
  extends com.tencent.mm.bv.a
{
  public LinkedList<String> wAF;
  public String wyh;
  
  public md()
  {
    AppMethodBeat.i(11729);
    this.wAF = new LinkedList();
    AppMethodBeat.o(11729);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(11730);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wyh == null)
      {
        paramVarArgs = new b("Not all required fields were included: brand_user_name");
        AppMethodBeat.o(11730);
        throw paramVarArgs;
      }
      if (this.wyh != null) {
        paramVarArgs.e(2, this.wyh);
      }
      paramVarArgs.e(3, 1, this.wAF);
      AppMethodBeat.o(11730);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wyh == null) {
        break label330;
      }
    }
    label330:
    for (paramInt = e.a.a.b.b.a.f(2, this.wyh) + 0;; paramInt = 0)
    {
      int i = e.a.a.a.c(3, 1, this.wAF);
      AppMethodBeat.o(11730);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wAF.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.wyh == null)
        {
          paramVarArgs = new b("Not all required fields were included: brand_user_name");
          AppMethodBeat.o(11730);
          throw paramVarArgs;
        }
        AppMethodBeat.o(11730);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        md localmd = (md)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(11730);
          return -1;
        case 2: 
          localmd.wyh = locala.CLY.readString();
          AppMethodBeat.o(11730);
          return 0;
        }
        localmd.wAF.add(locala.CLY.readString());
        AppMethodBeat.o(11730);
        return 0;
      }
      AppMethodBeat.o(11730);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.md
 * JD-Core Version:    0.7.0.1
 */