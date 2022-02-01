package com.tencent.mm.protocal.protobuf.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class z
  extends com.tencent.mm.bx.a
{
  public int abaj;
  public int abak;
  public u acjh;
  public b acji;
  public int vhJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259683);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.vhJ);
      paramVarArgs.bS(2, this.abaj);
      paramVarArgs.bS(3, this.abak);
      if (this.acjh != null)
      {
        paramVarArgs.qD(4, this.acjh.computeSize());
        this.acjh.writeFields(paramVarArgs);
      }
      if (this.acji != null)
      {
        paramVarArgs.qD(5, this.acji.computeSize());
        this.acji.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(259683);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.vhJ) + 0 + i.a.a.b.b.a.cJ(2, this.abaj) + i.a.a.b.b.a.cJ(3, this.abak);
      paramInt = i;
      if (this.acjh != null) {
        paramInt = i + i.a.a.a.qC(4, this.acjh.computeSize());
      }
      i = paramInt;
      if (this.acji != null) {
        i = paramInt + i.a.a.a.qC(5, this.acji.computeSize());
      }
      AppMethodBeat.o(259683);
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
      AppMethodBeat.o(259683);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      z localz = (z)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(259683);
        return -1;
      case 1: 
        localz.vhJ = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(259683);
        return 0;
      case 2: 
        localz.abaj = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(259683);
        return 0;
      case 3: 
        localz.abak = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(259683);
        return 0;
      case 4: 
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
          localz.acjh = ((u)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(259683);
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
        localz.acji = ((b)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(259683);
      return 0;
    }
    AppMethodBeat.o(259683);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.a.z
 * JD-Core Version:    0.7.0.1
 */