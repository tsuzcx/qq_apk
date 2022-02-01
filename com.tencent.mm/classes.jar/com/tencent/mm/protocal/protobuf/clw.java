package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class clw
  extends com.tencent.mm.bw.a
{
  public abs HxS;
  public abs HxT;
  public abs HxU;
  public abs HxV;
  public int bottom;
  public int left;
  public int right;
  public int top;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118412);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.left);
      paramVarArgs.aS(2, this.top);
      paramVarArgs.aS(3, this.right);
      paramVarArgs.aS(4, this.bottom);
      if (this.HxS != null)
      {
        paramVarArgs.lJ(5, this.HxS.computeSize());
        this.HxS.writeFields(paramVarArgs);
      }
      if (this.HxT != null)
      {
        paramVarArgs.lJ(6, this.HxT.computeSize());
        this.HxT.writeFields(paramVarArgs);
      }
      if (this.HxU != null)
      {
        paramVarArgs.lJ(7, this.HxU.computeSize());
        this.HxU.writeFields(paramVarArgs);
      }
      if (this.HxV != null)
      {
        paramVarArgs.lJ(8, this.HxV.computeSize());
        this.HxV.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(100, this.type);
      AppMethodBeat.o(118412);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.left) + 0 + f.a.a.b.b.a.bz(2, this.top) + f.a.a.b.b.a.bz(3, this.right) + f.a.a.b.b.a.bz(4, this.bottom);
      paramInt = i;
      if (this.HxS != null) {
        paramInt = i + f.a.a.a.lI(5, this.HxS.computeSize());
      }
      i = paramInt;
      if (this.HxT != null) {
        i = paramInt + f.a.a.a.lI(6, this.HxT.computeSize());
      }
      paramInt = i;
      if (this.HxU != null) {
        paramInt = i + f.a.a.a.lI(7, this.HxU.computeSize());
      }
      i = paramInt;
      if (this.HxV != null) {
        i = paramInt + f.a.a.a.lI(8, this.HxV.computeSize());
      }
      paramInt = f.a.a.b.b.a.bz(100, this.type);
      AppMethodBeat.o(118412);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(118412);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      clw localclw = (clw)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(118412);
        return -1;
      case 1: 
        localclw.left = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(118412);
        return 0;
      case 2: 
        localclw.top = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(118412);
        return 0;
      case 3: 
        localclw.right = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(118412);
        return 0;
      case 4: 
        localclw.bottom = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(118412);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new abs();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((abs)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localclw.HxS = ((abs)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(118412);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new abs();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((abs)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localclw.HxT = ((abs)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(118412);
        return 0;
      case 7: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new abs();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((abs)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localclw.HxU = ((abs)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(118412);
        return 0;
      case 8: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new abs();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((abs)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localclw.HxV = ((abs)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(118412);
        return 0;
      }
      localclw.type = ((f.a.a.a.a)localObject1).OmT.zc();
      AppMethodBeat.o(118412);
      return 0;
    }
    AppMethodBeat.o(118412);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.clw
 * JD-Core Version:    0.7.0.1
 */