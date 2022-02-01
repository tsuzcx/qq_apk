package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class io
  extends com.tencent.mm.bx.a
{
  public cdh FBt;
  public cdh FBu;
  public cdh FBv;
  public cdh FBw;
  public int FBx;
  public int FBy;
  public int FBz;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118406);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.type);
      if (this.FBt != null)
      {
        paramVarArgs.lC(2, this.FBt.computeSize());
        this.FBt.writeFields(paramVarArgs);
      }
      if (this.FBu != null)
      {
        paramVarArgs.lC(3, this.FBu.computeSize());
        this.FBu.writeFields(paramVarArgs);
      }
      if (this.FBv != null)
      {
        paramVarArgs.lC(4, this.FBv.computeSize());
        this.FBv.writeFields(paramVarArgs);
      }
      if (this.FBw != null)
      {
        paramVarArgs.lC(11, this.FBw.computeSize());
        this.FBw.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(100, this.FBx);
      paramVarArgs.aS(101, this.FBy);
      paramVarArgs.aS(102, this.FBz);
      AppMethodBeat.o(118406);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.type) + 0;
      paramInt = i;
      if (this.FBt != null) {
        paramInt = i + f.a.a.a.lB(2, this.FBt.computeSize());
      }
      i = paramInt;
      if (this.FBu != null) {
        i = paramInt + f.a.a.a.lB(3, this.FBu.computeSize());
      }
      paramInt = i;
      if (this.FBv != null) {
        paramInt = i + f.a.a.a.lB(4, this.FBv.computeSize());
      }
      i = paramInt;
      if (this.FBw != null) {
        i = paramInt + f.a.a.a.lB(11, this.FBw.computeSize());
      }
      paramInt = f.a.a.b.b.a.bz(100, this.FBx);
      int j = f.a.a.b.b.a.bz(101, this.FBy);
      int k = f.a.a.b.b.a.bz(102, this.FBz);
      AppMethodBeat.o(118406);
      return i + paramInt + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(118406);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      io localio = (io)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(118406);
        return -1;
      case 1: 
        localio.type = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(118406);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cdh();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cdh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localio.FBt = ((cdh)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(118406);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cdh();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cdh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localio.FBu = ((cdh)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(118406);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cdh();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cdh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localio.FBv = ((cdh)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(118406);
        return 0;
      case 11: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cdh();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cdh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localio.FBw = ((cdh)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(118406);
        return 0;
      case 100: 
        localio.FBx = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(118406);
        return 0;
      case 101: 
        localio.FBy = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(118406);
        return 0;
      }
      localio.FBz = ((f.a.a.a.a)localObject1).NPN.zc();
      AppMethodBeat.o(118406);
      return 0;
    }
    AppMethodBeat.o(118406);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.io
 * JD-Core Version:    0.7.0.1
 */