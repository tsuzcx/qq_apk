package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dzj
  extends com.tencent.mm.bx.a
{
  public FinderObject Dky;
  public dzm KWK;
  public dzk LxQ;
  public int dataType;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(203869);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.dataType);
      if (this.LxQ != null)
      {
        paramVarArgs.kX(2, this.LxQ.computeSize());
        this.LxQ.writeFields(paramVarArgs);
      }
      if (this.KWK != null)
      {
        paramVarArgs.kX(3, this.KWK.computeSize());
        this.KWK.writeFields(paramVarArgs);
      }
      if (this.Dky != null)
      {
        paramVarArgs.kX(4, this.Dky.computeSize());
        this.Dky.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(203869);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.dataType) + 0;
      paramInt = i;
      if (this.LxQ != null) {
        paramInt = i + f.a.a.a.kW(2, this.LxQ.computeSize());
      }
      i = paramInt;
      if (this.KWK != null) {
        i = paramInt + f.a.a.a.kW(3, this.KWK.computeSize());
      }
      paramInt = i;
      if (this.Dky != null) {
        paramInt = i + f.a.a.a.kW(4, this.Dky.computeSize());
      }
      AppMethodBeat.o(203869);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(203869);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dzj localdzj = (dzj)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(203869);
        return -1;
      case 1: 
        localdzj.dataType = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(203869);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dzk();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dzk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdzj.LxQ = ((dzk)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(203869);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dzm();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dzm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdzj.KWK = ((dzm)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(203869);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new FinderObject();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((FinderObject)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localdzj.Dky = ((FinderObject)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(203869);
      return 0;
    }
    AppMethodBeat.o(203869);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzj
 * JD-Core Version:    0.7.0.1
 */