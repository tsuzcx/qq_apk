package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ciu
  extends com.tencent.mm.bx.a
{
  public int Eeh;
  public SKBuiltinBuffer_t Eei;
  public SKBuiltinBuffer_t Eej;
  public SKBuiltinBuffer_t Eek;
  public SKBuiltinBuffer_t Eel;
  public long Eem;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125760);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Eeh);
      if (this.Eei != null)
      {
        paramVarArgs.kX(2, this.Eei.computeSize());
        this.Eei.writeFields(paramVarArgs);
      }
      if (this.Eej != null)
      {
        paramVarArgs.kX(3, this.Eej.computeSize());
        this.Eej.writeFields(paramVarArgs);
      }
      if (this.Eek != null)
      {
        paramVarArgs.kX(4, this.Eek.computeSize());
        this.Eek.writeFields(paramVarArgs);
      }
      if (this.Eel != null)
      {
        paramVarArgs.kX(5, this.Eel.computeSize());
        this.Eel.writeFields(paramVarArgs);
      }
      paramVarArgs.aG(6, this.Eem);
      AppMethodBeat.o(125760);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.Eeh) + 0;
      paramInt = i;
      if (this.Eei != null) {
        paramInt = i + f.a.a.a.kW(2, this.Eei.computeSize());
      }
      i = paramInt;
      if (this.Eej != null) {
        i = paramInt + f.a.a.a.kW(3, this.Eej.computeSize());
      }
      paramInt = i;
      if (this.Eek != null) {
        paramInt = i + f.a.a.a.kW(4, this.Eek.computeSize());
      }
      i = paramInt;
      if (this.Eel != null) {
        i = paramInt + f.a.a.a.kW(5, this.Eel.computeSize());
      }
      paramInt = f.a.a.b.b.a.q(6, this.Eem);
      AppMethodBeat.o(125760);
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
      AppMethodBeat.o(125760);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      ciu localciu = (ciu)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(125760);
        return -1;
      case 1: 
        localciu.Eeh = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(125760);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localciu.Eei = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125760);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localciu.Eej = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125760);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localciu.Eek = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125760);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localciu.Eel = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125760);
        return 0;
      }
      localciu.Eem = ((f.a.a.a.a)localObject1).KhF.xT();
      AppMethodBeat.o(125760);
      return 0;
    }
    AppMethodBeat.o(125760);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ciu
 * JD-Core Version:    0.7.0.1
 */