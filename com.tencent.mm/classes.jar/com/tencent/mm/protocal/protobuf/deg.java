package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class deg
  extends com.tencent.mm.bw.a
{
  public long FMS;
  public SKBuiltinBuffer_t FNV;
  public int fZz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118463);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FNV == null)
      {
        paramVarArgs = new b("Not all required fields were included: OpContent");
        AppMethodBeat.o(118463);
        throw paramVarArgs;
      }
      paramVarArgs.aO(1, this.FMS);
      paramVarArgs.aR(2, this.fZz);
      if (this.FNV != null)
      {
        paramVarArgs.ln(3, this.FNV.computeSize());
        this.FNV.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(118463);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.p(1, this.FMS) + 0 + f.a.a.b.b.a.bx(2, this.fZz);
      paramInt = i;
      if (this.FNV != null) {
        paramInt = i + f.a.a.a.lm(3, this.FNV.computeSize());
      }
      AppMethodBeat.o(118463);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      if (this.FNV == null)
      {
        paramVarArgs = new b("Not all required fields were included: OpContent");
        AppMethodBeat.o(118463);
        throw paramVarArgs;
      }
      AppMethodBeat.o(118463);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      deg localdeg = (deg)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(118463);
        return -1;
      case 1: 
        localdeg.FMS = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(118463);
        return 0;
      case 2: 
        localdeg.fZz = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(118463);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new SKBuiltinBuffer_t();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localdeg.FNV = ((SKBuiltinBuffer_t)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(118463);
      return 0;
    }
    AppMethodBeat.o(118463);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.deg
 * JD-Core Version:    0.7.0.1
 */