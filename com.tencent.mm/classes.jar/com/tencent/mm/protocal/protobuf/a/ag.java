package com.tencent.mm.protocal.protobuf.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ag
  extends com.tencent.mm.bx.a
{
  public u acjh;
  public b acji;
  public int vhJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259711);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.vhJ);
      if (this.acjh != null)
      {
        paramVarArgs.qD(2, this.acjh.computeSize());
        this.acjh.writeFields(paramVarArgs);
      }
      if (this.acji != null)
      {
        paramVarArgs.qD(3, this.acji.computeSize());
        this.acji.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(259711);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.vhJ) + 0;
      paramInt = i;
      if (this.acjh != null) {
        paramInt = i + i.a.a.a.qC(2, this.acjh.computeSize());
      }
      i = paramInt;
      if (this.acji != null) {
        i = paramInt + i.a.a.a.qC(3, this.acji.computeSize());
      }
      AppMethodBeat.o(259711);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(259711);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      ag localag = (ag)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(259711);
        return -1;
      case 1: 
        localag.vhJ = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(259711);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new u();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((u)localObject2).parseFrom((byte[])localObject1);
          }
          localag.acjh = ((u)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(259711);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new b();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((b)localObject2).parseFrom((byte[])localObject1);
        }
        localag.acji = ((b)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(259711);
      return 0;
    }
    AppMethodBeat.o(259711);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.a.ag
 * JD-Core Version:    0.7.0.1
 */