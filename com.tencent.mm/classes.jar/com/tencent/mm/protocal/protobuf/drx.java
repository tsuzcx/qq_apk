package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class drx
  extends com.tencent.mm.bw.a
{
  public SKBuiltinBuffer_t LUY;
  public String LUZ;
  public long LVb;
  public int ReqType;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104834);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.LUZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: KeyWord");
        AppMethodBeat.o(104834);
        throw paramVarArgs;
      }
      paramVarArgs.aM(1, this.ReqType);
      if (this.LUZ != null) {
        paramVarArgs.e(2, this.LUZ);
      }
      if (this.LUY != null)
      {
        paramVarArgs.ni(3, this.LUY.computeSize());
        this.LUY.writeFields(paramVarArgs);
      }
      paramVarArgs.bb(4, this.LVb);
      AppMethodBeat.o(104834);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.ReqType) + 0;
      paramInt = i;
      if (this.LUZ != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.LUZ);
      }
      i = paramInt;
      if (this.LUY != null) {
        i = paramInt + g.a.a.a.nh(3, this.LUY.computeSize());
      }
      paramInt = g.a.a.b.b.a.r(4, this.LVb);
      AppMethodBeat.o(104834);
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
      if (this.LUZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: KeyWord");
        AppMethodBeat.o(104834);
        throw paramVarArgs;
      }
      AppMethodBeat.o(104834);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      drx localdrx = (drx)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(104834);
        return -1;
      case 1: 
        localdrx.ReqType = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(104834);
        return 0;
      case 2: 
        localdrx.LUZ = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(104834);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdrx.LUY = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(104834);
        return 0;
      }
      localdrx.LVb = ((g.a.a.a.a)localObject1).UbS.zl();
      AppMethodBeat.o(104834);
      return 0;
    }
    AppMethodBeat.o(104834);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.drx
 * JD-Core Version:    0.7.0.1
 */