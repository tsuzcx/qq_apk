package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cbd
  extends com.tencent.mm.bx.a
{
  public yo DXt;
  public yo DXu;
  public yo DXv;
  public yo DXw;
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
      paramVarArgs.aR(1, this.left);
      paramVarArgs.aR(2, this.top);
      paramVarArgs.aR(3, this.right);
      paramVarArgs.aR(4, this.bottom);
      if (this.DXt != null)
      {
        paramVarArgs.kX(5, this.DXt.computeSize());
        this.DXt.writeFields(paramVarArgs);
      }
      if (this.DXu != null)
      {
        paramVarArgs.kX(6, this.DXu.computeSize());
        this.DXu.writeFields(paramVarArgs);
      }
      if (this.DXv != null)
      {
        paramVarArgs.kX(7, this.DXv.computeSize());
        this.DXv.writeFields(paramVarArgs);
      }
      if (this.DXw != null)
      {
        paramVarArgs.kX(8, this.DXw.computeSize());
        this.DXw.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(100, this.type);
      AppMethodBeat.o(118412);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.left) + 0 + f.a.a.b.b.a.bA(2, this.top) + f.a.a.b.b.a.bA(3, this.right) + f.a.a.b.b.a.bA(4, this.bottom);
      paramInt = i;
      if (this.DXt != null) {
        paramInt = i + f.a.a.a.kW(5, this.DXt.computeSize());
      }
      i = paramInt;
      if (this.DXu != null) {
        i = paramInt + f.a.a.a.kW(6, this.DXu.computeSize());
      }
      paramInt = i;
      if (this.DXv != null) {
        paramInt = i + f.a.a.a.kW(7, this.DXv.computeSize());
      }
      i = paramInt;
      if (this.DXw != null) {
        i = paramInt + f.a.a.a.kW(8, this.DXw.computeSize());
      }
      paramInt = f.a.a.b.b.a.bA(100, this.type);
      AppMethodBeat.o(118412);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(118412);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      cbd localcbd = (cbd)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(118412);
        return -1;
      case 1: 
        localcbd.left = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(118412);
        return 0;
      case 2: 
        localcbd.top = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(118412);
        return 0;
      case 3: 
        localcbd.right = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(118412);
        return 0;
      case 4: 
        localcbd.bottom = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(118412);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new yo();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((yo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcbd.DXt = ((yo)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(118412);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new yo();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((yo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcbd.DXu = ((yo)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(118412);
        return 0;
      case 7: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new yo();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((yo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcbd.DXv = ((yo)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(118412);
        return 0;
      case 8: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new yo();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((yo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcbd.DXw = ((yo)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(118412);
        return 0;
      }
      localcbd.type = ((f.a.a.a.a)localObject1).KhF.xS();
      AppMethodBeat.o(118412);
      return 0;
    }
    AppMethodBeat.o(118412);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cbd
 * JD-Core Version:    0.7.0.1
 */