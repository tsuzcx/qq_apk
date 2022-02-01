package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ego
  extends com.tencent.mm.bx.a
{
  public com.tencent.mm.bx.b FGF;
  public LinkedList<egl> FGG;
  public String GNH;
  
  public ego()
  {
    AppMethodBeat.i(123701);
    this.FGG = new LinkedList();
    AppMethodBeat.o(123701);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123702);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GNH == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: WxaUserName");
        AppMethodBeat.o(123702);
        throw paramVarArgs;
      }
      if (this.GNH != null) {
        paramVarArgs.d(1, this.GNH);
      }
      if (this.FGF != null) {
        paramVarArgs.c(2, this.FGF);
      }
      paramVarArgs.e(3, 8, this.FGG);
      AppMethodBeat.o(123702);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GNH == null) {
        break label466;
      }
    }
    label466:
    for (paramInt = f.a.a.b.b.a.e(1, this.GNH) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FGF != null) {
        i = paramInt + f.a.a.b.b.a.b(2, this.FGF);
      }
      paramInt = f.a.a.a.c(3, 8, this.FGG);
      AppMethodBeat.o(123702);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FGG.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.GNH == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: WxaUserName");
          AppMethodBeat.o(123702);
          throw paramVarArgs;
        }
        AppMethodBeat.o(123702);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ego localego = (ego)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123702);
          return -1;
        case 1: 
          localego.GNH = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123702);
          return 0;
        case 2: 
          localego.FGF = ((f.a.a.a.a)localObject1).NPN.gxI();
          AppMethodBeat.o(123702);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new egl();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((egl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localego.FGG.add(localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ego
 * JD-Core Version:    0.7.0.1
 */