package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class rc
  extends com.tencent.mm.bw.a
{
  public LinkedList<ans> KXX;
  public LinkedList<anr> KXY;
  public String KXZ;
  public String KYa;
  public String KYb;
  
  public rc()
  {
    AppMethodBeat.i(91368);
    this.KXX = new LinkedList();
    this.KXY = new LinkedList();
    AppMethodBeat.o(91368);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91369);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.KXX);
      paramVarArgs.e(2, 8, this.KXY);
      if (this.KXZ != null) {
        paramVarArgs.e(3, this.KXZ);
      }
      if (this.KYa != null) {
        paramVarArgs.e(4, this.KYa);
      }
      if (this.KYb != null) {
        paramVarArgs.e(5, this.KYb);
      }
      AppMethodBeat.o(91369);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.a.c(1, 8, this.KXX) + 0 + g.a.a.a.c(2, 8, this.KXY);
      paramInt = i;
      if (this.KXZ != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.KXZ);
      }
      i = paramInt;
      if (this.KYa != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.KYa);
      }
      paramInt = i;
      if (this.KYb != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.KYb);
      }
      AppMethodBeat.o(91369);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.KXX.clear();
      this.KXY.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(91369);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      rc localrc = (rc)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91369);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ans();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ans)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localrc.KXX.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91369);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new anr();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((anr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localrc.KXY.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91369);
        return 0;
      case 3: 
        localrc.KXZ = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91369);
        return 0;
      case 4: 
        localrc.KYa = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91369);
        return 0;
      }
      localrc.KYb = ((g.a.a.a.a)localObject1).UbS.readString();
      AppMethodBeat.o(91369);
      return 0;
    }
    AppMethodBeat.o(91369);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.rc
 * JD-Core Version:    0.7.0.1
 */