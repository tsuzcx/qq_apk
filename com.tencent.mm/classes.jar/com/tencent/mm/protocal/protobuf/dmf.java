package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dmf
  extends com.tencent.mm.bx.a
{
  public SKBuiltinBuffer_t CCV;
  public int CYY;
  public int oXh;
  public int vJz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115873);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CCV == null)
      {
        paramVarArgs = new b("Not all required fields were included: Buffer");
        AppMethodBeat.o(115873);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.CYY);
      paramVarArgs.aR(2, this.oXh);
      paramVarArgs.aR(3, this.vJz);
      if (this.CCV != null)
      {
        paramVarArgs.kX(4, this.CCV.computeSize());
        this.CCV.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(115873);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.CYY) + 0 + f.a.a.b.b.a.bA(2, this.oXh) + f.a.a.b.b.a.bA(3, this.vJz);
      paramInt = i;
      if (this.CCV != null) {
        paramInt = i + f.a.a.a.kW(4, this.CCV.computeSize());
      }
      AppMethodBeat.o(115873);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      if (this.CCV == null)
      {
        paramVarArgs = new b("Not all required fields were included: Buffer");
        AppMethodBeat.o(115873);
        throw paramVarArgs;
      }
      AppMethodBeat.o(115873);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dmf localdmf = (dmf)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(115873);
        return -1;
      case 1: 
        localdmf.CYY = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(115873);
        return 0;
      case 2: 
        localdmf.oXh = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(115873);
        return 0;
      case 3: 
        localdmf.vJz = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(115873);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new SKBuiltinBuffer_t();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localdmf.CCV = ((SKBuiltinBuffer_t)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(115873);
      return 0;
    }
    AppMethodBeat.o(115873);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dmf
 * JD-Core Version:    0.7.0.1
 */