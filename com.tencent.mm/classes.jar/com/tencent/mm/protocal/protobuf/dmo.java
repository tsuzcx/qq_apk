package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dmo
  extends com.tencent.mm.bw.a
{
  public int MQc;
  public SKBuiltinBuffer_t MQd;
  public SKBuiltinBuffer_t MQe;
  public SKBuiltinBuffer_t MQf;
  public SKBuiltinBuffer_t MQg;
  public long MQh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125760);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.MQc);
      if (this.MQd != null)
      {
        paramVarArgs.ni(2, this.MQd.computeSize());
        this.MQd.writeFields(paramVarArgs);
      }
      if (this.MQe != null)
      {
        paramVarArgs.ni(3, this.MQe.computeSize());
        this.MQe.writeFields(paramVarArgs);
      }
      if (this.MQf != null)
      {
        paramVarArgs.ni(4, this.MQf.computeSize());
        this.MQf.writeFields(paramVarArgs);
      }
      if (this.MQg != null)
      {
        paramVarArgs.ni(5, this.MQg.computeSize());
        this.MQg.writeFields(paramVarArgs);
      }
      paramVarArgs.bb(6, this.MQh);
      AppMethodBeat.o(125760);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.MQc) + 0;
      paramInt = i;
      if (this.MQd != null) {
        paramInt = i + g.a.a.a.nh(2, this.MQd.computeSize());
      }
      i = paramInt;
      if (this.MQe != null) {
        i = paramInt + g.a.a.a.nh(3, this.MQe.computeSize());
      }
      paramInt = i;
      if (this.MQf != null) {
        paramInt = i + g.a.a.a.nh(4, this.MQf.computeSize());
      }
      i = paramInt;
      if (this.MQg != null) {
        i = paramInt + g.a.a.a.nh(5, this.MQg.computeSize());
      }
      paramInt = g.a.a.b.b.a.r(6, this.MQh);
      AppMethodBeat.o(125760);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(125760);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      dmo localdmo = (dmo)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(125760);
        return -1;
      case 1: 
        localdmo.MQc = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(125760);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdmo.MQd = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125760);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdmo.MQe = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125760);
        return 0;
      case 4: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdmo.MQf = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125760);
        return 0;
      case 5: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdmo.MQg = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125760);
        return 0;
      }
      localdmo.MQh = ((g.a.a.a.a)localObject1).UbS.zl();
      AppMethodBeat.o(125760);
      return 0;
    }
    AppMethodBeat.o(125760);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dmo
 * JD-Core Version:    0.7.0.1
 */