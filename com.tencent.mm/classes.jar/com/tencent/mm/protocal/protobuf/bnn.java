package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bnn
  extends com.tencent.mm.bx.a
{
  public int CreateTime;
  public SKBuiltinBuffer_t FAN;
  public long GHN;
  public int nEf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32320);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FAN == null)
      {
        paramVarArgs = new b("Not all required fields were included: Buffer");
        AppMethodBeat.o(32320);
        throw paramVarArgs;
      }
      paramVarArgs.aY(1, this.GHN);
      paramVarArgs.aS(2, this.CreateTime);
      if (this.FAN != null)
      {
        paramVarArgs.lC(3, this.FAN.computeSize());
        this.FAN.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(4, this.nEf);
      AppMethodBeat.o(32320);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.p(1, this.GHN) + 0 + f.a.a.b.b.a.bz(2, this.CreateTime);
      paramInt = i;
      if (this.FAN != null) {
        paramInt = i + f.a.a.a.lB(3, this.FAN.computeSize());
      }
      i = f.a.a.b.b.a.bz(4, this.nEf);
      AppMethodBeat.o(32320);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      if (this.FAN == null)
      {
        paramVarArgs = new b("Not all required fields were included: Buffer");
        AppMethodBeat.o(32320);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32320);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      bnn localbnn = (bnn)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32320);
        return -1;
      case 1: 
        localbnn.GHN = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(32320);
        return 0;
      case 2: 
        localbnn.CreateTime = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(32320);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbnn.FAN = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32320);
        return 0;
      }
      localbnn.nEf = ((f.a.a.a.a)localObject1).NPN.zc();
      AppMethodBeat.o(32320);
      return 0;
    }
    AppMethodBeat.o(32320);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bnn
 * JD-Core Version:    0.7.0.1
 */