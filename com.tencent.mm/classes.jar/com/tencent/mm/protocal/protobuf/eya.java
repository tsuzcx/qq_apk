package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class eya
  extends com.tencent.mm.bw.a
{
  public String Desc;
  public LinkedList<aod> Nvh;
  public String Nvi;
  
  public eya()
  {
    AppMethodBeat.i(110852);
    this.Nvh = new LinkedList();
    AppMethodBeat.o(110852);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110853);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Nvi == null)
      {
        paramVarArgs = new b("Not all required fields were included: Charset");
        AppMethodBeat.o(110853);
        throw paramVarArgs;
      }
      paramVarArgs.e(1, 8, this.Nvh);
      if (this.Nvi != null) {
        paramVarArgs.e(2, this.Nvi);
      }
      if (this.Desc != null) {
        paramVarArgs.e(3, this.Desc);
      }
      AppMethodBeat.o(110853);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.a.c(1, 8, this.Nvh) + 0;
      paramInt = i;
      if (this.Nvi != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Nvi);
      }
      i = paramInt;
      if (this.Desc != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.Desc);
      }
      AppMethodBeat.o(110853);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Nvh.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      if (this.Nvi == null)
      {
        paramVarArgs = new b("Not all required fields were included: Charset");
        AppMethodBeat.o(110853);
        throw paramVarArgs;
      }
      AppMethodBeat.o(110853);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      eya localeya = (eya)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(110853);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aod();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((aod)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localeya.Nvh.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(110853);
        return 0;
      case 2: 
        localeya.Nvi = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(110853);
        return 0;
      }
      localeya.Desc = ((g.a.a.a.a)localObject1).UbS.readString();
      AppMethodBeat.o(110853);
      return 0;
    }
    AppMethodBeat.o(110853);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eya
 * JD-Core Version:    0.7.0.1
 */