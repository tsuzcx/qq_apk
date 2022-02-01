package com.tencent.mm.plugin.textstatus.proto;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ar
  extends com.tencent.mm.bx.a
{
  public String TpT;
  public LinkedList<as> TpU;
  public long key;
  public LinkedList<ap> wwD;
  
  public ar()
  {
    AppMethodBeat.i(289934);
    this.TpU = new LinkedList();
    this.wwD = new LinkedList();
    AppMethodBeat.o(289934);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(289946);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.key);
      if (this.TpT != null) {
        paramVarArgs.g(2, this.TpT);
      }
      paramVarArgs.e(3, 8, this.TpU);
      paramVarArgs.e(4, 8, this.wwD);
      AppMethodBeat.o(289946);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.q(1, this.key) + 0;
      paramInt = i;
      if (this.TpT != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.TpT);
      }
      i = i.a.a.a.c(3, 8, this.TpU);
      int j = i.a.a.a.c(4, 8, this.wwD);
      AppMethodBeat.o(289946);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.TpU.clear();
      this.wwD.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(289946);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      ar localar = (ar)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(289946);
        return -1;
      case 1: 
        localar.key = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(289946);
        return 0;
      case 2: 
        localar.TpT = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(289946);
        return 0;
      case 3: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new as();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((as)localObject2).parseFrom((byte[])localObject1);
          }
          localar.TpU.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(289946);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new ap();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((ap)localObject2).parseFrom((byte[])localObject1);
        }
        localar.wwD.add(localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(289946);
      return 0;
    }
    AppMethodBeat.o(289946);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.proto.ar
 * JD-Core Version:    0.7.0.1
 */