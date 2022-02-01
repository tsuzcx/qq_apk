package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eks
  extends com.tencent.mm.bw.a
{
  public SKBuiltinBuffer_t LRE;
  public String Myy;
  public int NjV;
  public String NjY;
  public int NjZ;
  public int Ret;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152716);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.NjV);
      if (this.NjY != null) {
        paramVarArgs.e(2, this.NjY);
      }
      paramVarArgs.aM(3, this.Ret);
      if (this.Myy != null) {
        paramVarArgs.e(4, this.Myy);
      }
      if (this.LRE != null)
      {
        paramVarArgs.ni(5, this.LRE.computeSize());
        this.LRE.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(6, this.NjZ);
      AppMethodBeat.o(152716);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.NjV) + 0;
      paramInt = i;
      if (this.NjY != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.NjY);
      }
      i = paramInt + g.a.a.b.b.a.bu(3, this.Ret);
      paramInt = i;
      if (this.Myy != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.Myy);
      }
      i = paramInt;
      if (this.LRE != null) {
        i = paramInt + g.a.a.a.nh(5, this.LRE.computeSize());
      }
      paramInt = g.a.a.b.b.a.bu(6, this.NjZ);
      AppMethodBeat.o(152716);
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
      AppMethodBeat.o(152716);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      eks localeks = (eks)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(152716);
        return -1;
      case 1: 
        localeks.NjV = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(152716);
        return 0;
      case 2: 
        localeks.NjY = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(152716);
        return 0;
      case 3: 
        localeks.Ret = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(152716);
        return 0;
      case 4: 
        localeks.Myy = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(152716);
        return 0;
      case 5: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localeks.LRE = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(152716);
        return 0;
      }
      localeks.NjZ = ((g.a.a.a.a)localObject1).UbS.zi();
      AppMethodBeat.o(152716);
      return 0;
    }
    AppMethodBeat.o(152716);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eks
 * JD-Core Version:    0.7.0.1
 */