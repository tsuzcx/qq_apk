package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fcx
  extends com.tencent.mm.bw.a
{
  public com.tencent.mm.bw.b KSW;
  public LinkedList<fcu> KSX;
  public String Mmv;
  
  public fcx()
  {
    AppMethodBeat.i(123701);
    this.KSX = new LinkedList();
    AppMethodBeat.o(123701);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123702);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Mmv == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: WxaUserName");
        AppMethodBeat.o(123702);
        throw paramVarArgs;
      }
      if (this.Mmv != null) {
        paramVarArgs.e(1, this.Mmv);
      }
      if (this.KSW != null) {
        paramVarArgs.c(2, this.KSW);
      }
      paramVarArgs.e(3, 8, this.KSX);
      AppMethodBeat.o(123702);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Mmv == null) {
        break label466;
      }
    }
    label466:
    for (paramInt = g.a.a.b.b.a.f(1, this.Mmv) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.KSW != null) {
        i = paramInt + g.a.a.b.b.a.b(2, this.KSW);
      }
      paramInt = g.a.a.a.c(3, 8, this.KSX);
      AppMethodBeat.o(123702);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.KSX.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.Mmv == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: WxaUserName");
          AppMethodBeat.o(123702);
          throw paramVarArgs;
        }
        AppMethodBeat.o(123702);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        fcx localfcx = (fcx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123702);
          return -1;
        case 1: 
          localfcx.Mmv = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123702);
          return 0;
        case 2: 
          localfcx.KSW = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(123702);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new fcu();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((fcu)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localfcx.KSX.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(123702);
        return 0;
      }
      AppMethodBeat.o(123702);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fcx
 * JD-Core Version:    0.7.0.1
 */