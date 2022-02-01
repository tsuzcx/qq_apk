package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aih
  extends com.tencent.mm.bx.a
{
  public FinderObject DkX;
  public int DkY;
  public dzm Lxr;
  public long id;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168953);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.type);
      paramVarArgs.aG(2, this.id);
      if (this.DkX != null)
      {
        paramVarArgs.kX(3, this.DkX.computeSize());
        this.DkX.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(4, this.DkY);
      if (this.Lxr != null)
      {
        paramVarArgs.kX(5, this.Lxr.computeSize());
        this.Lxr.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(168953);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.type) + 0 + f.a.a.b.b.a.q(2, this.id);
      paramInt = i;
      if (this.DkX != null) {
        paramInt = i + f.a.a.a.kW(3, this.DkX.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bA(4, this.DkY);
      paramInt = i;
      if (this.Lxr != null) {
        paramInt = i + f.a.a.a.kW(5, this.Lxr.computeSize());
      }
      AppMethodBeat.o(168953);
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
      AppMethodBeat.o(168953);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      aih localaih = (aih)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(168953);
        return -1;
      case 1: 
        localaih.type = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(168953);
        return 0;
      case 2: 
        localaih.id = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(168953);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new FinderObject();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((FinderObject)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localaih.DkX = ((FinderObject)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(168953);
        return 0;
      case 4: 
        localaih.DkY = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(168953);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new dzm();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((dzm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localaih.Lxr = ((dzm)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(168953);
      return 0;
    }
    AppMethodBeat.o(168953);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aih
 * JD-Core Version:    0.7.0.1
 */