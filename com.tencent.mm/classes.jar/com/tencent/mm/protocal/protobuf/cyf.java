package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cyf
  extends com.tencent.mm.bx.a
{
  public SKBuiltinBuffer_t Gxi;
  public String Gxj;
  public long Gxl;
  public int ReqType;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104834);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Gxj == null)
      {
        paramVarArgs = new b("Not all required fields were included: KeyWord");
        AppMethodBeat.o(104834);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.ReqType);
      if (this.Gxj != null) {
        paramVarArgs.d(2, this.Gxj);
      }
      if (this.Gxi != null)
      {
        paramVarArgs.lC(3, this.Gxi.computeSize());
        this.Gxi.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(4, this.Gxl);
      AppMethodBeat.o(104834);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.ReqType) + 0;
      paramInt = i;
      if (this.Gxj != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Gxj);
      }
      i = paramInt;
      if (this.Gxi != null) {
        i = paramInt + f.a.a.a.lB(3, this.Gxi.computeSize());
      }
      paramInt = f.a.a.b.b.a.p(4, this.Gxl);
      AppMethodBeat.o(104834);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      if (this.Gxj == null)
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
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      cyf localcyf = (cyf)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(104834);
        return -1;
      case 1: 
        localcyf.ReqType = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(104834);
        return 0;
      case 2: 
        localcyf.Gxj = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(104834);
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
          localcyf.Gxi = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(104834);
        return 0;
      }
      localcyf.Gxl = ((f.a.a.a.a)localObject1).NPN.zd();
      AppMethodBeat.o(104834);
      return 0;
    }
    AppMethodBeat.o(104834);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cyf
 * JD-Core Version:    0.7.0.1
 */