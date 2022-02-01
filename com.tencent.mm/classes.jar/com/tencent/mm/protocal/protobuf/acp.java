package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public class acp
  extends com.tencent.mm.bx.a
{
  public int ZkU;
  public int ZkV;
  public int ZkW;
  public LinkedList<aco> ZkX;
  public b ZkY;
  public czp ZkZ;
  
  public acp()
  {
    AppMethodBeat.i(143967);
    this.ZkX = new LinkedList();
    AppMethodBeat.o(143967);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143968);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.ZkU);
      paramVarArgs.bS(2, this.ZkV);
      paramVarArgs.bS(3, this.ZkW);
      paramVarArgs.e(4, 8, this.ZkX);
      if (this.ZkY != null) {
        paramVarArgs.d(5, this.ZkY);
      }
      if (this.ZkZ != null)
      {
        paramVarArgs.qD(6, this.ZkZ.computeSize());
        this.ZkZ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(143968);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.ZkU) + 0 + i.a.a.b.b.a.cJ(2, this.ZkV) + i.a.a.b.b.a.cJ(3, this.ZkW) + i.a.a.a.c(4, 8, this.ZkX);
      paramInt = i;
      if (this.ZkY != null) {
        paramInt = i + i.a.a.b.b.a.c(5, this.ZkY);
      }
      i = paramInt;
      if (this.ZkZ != null) {
        i = paramInt + i.a.a.a.qC(6, this.ZkZ.computeSize());
      }
      AppMethodBeat.o(143968);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.ZkX.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(143968);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      acp localacp = (acp)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(143968);
        return -1;
      case 1: 
        localacp.ZkU = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(143968);
        return 0;
      case 2: 
        localacp.ZkV = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(143968);
        return 0;
      case 3: 
        localacp.ZkW = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(143968);
        return 0;
      case 4: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new aco();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((aco)localObject2).parseFrom((byte[])localObject1);
          }
          localacp.ZkX.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(143968);
        return 0;
      case 5: 
        localacp.ZkY = ((i.a.a.a.a)localObject1).ajGk.kFX();
        AppMethodBeat.o(143968);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new czp();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((czp)localObject2).parseFrom((byte[])localObject1);
        }
        localacp.ZkZ = ((czp)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(143968);
      return 0;
    }
    AppMethodBeat.o(143968);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.acp
 * JD-Core Version:    0.7.0.1
 */