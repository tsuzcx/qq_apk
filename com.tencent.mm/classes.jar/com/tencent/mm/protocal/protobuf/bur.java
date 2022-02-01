package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bur
  extends com.tencent.mm.bx.a
{
  public com.tencent.mm.bx.b CEi;
  public int DRP;
  public String DRQ;
  public SKBuiltinBuffer_t DRR;
  public int DRS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32359);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DRR == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: ClientKey");
        AppMethodBeat.o(32359);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.DRP);
      if (this.CEi != null) {
        paramVarArgs.c(2, this.CEi);
      }
      if (this.DRQ != null) {
        paramVarArgs.d(3, this.DRQ);
      }
      if (this.DRR != null)
      {
        paramVarArgs.kX(4, this.DRR.computeSize());
        this.DRR.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(5, this.DRS);
      AppMethodBeat.o(32359);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.DRP) + 0;
      paramInt = i;
      if (this.CEi != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.CEi);
      }
      i = paramInt;
      if (this.DRQ != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DRQ);
      }
      paramInt = i;
      if (this.DRR != null) {
        paramInt = i + f.a.a.a.kW(4, this.DRR.computeSize());
      }
      i = f.a.a.b.b.a.bA(5, this.DRS);
      AppMethodBeat.o(32359);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      if (this.DRR == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: ClientKey");
        AppMethodBeat.o(32359);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32359);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      bur localbur = (bur)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32359);
        return -1;
      case 1: 
        localbur.DRP = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(32359);
        return 0;
      case 2: 
        localbur.CEi = ((f.a.a.a.a)localObject1).KhF.fMu();
        AppMethodBeat.o(32359);
        return 0;
      case 3: 
        localbur.DRQ = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(32359);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbur.DRR = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32359);
        return 0;
      }
      localbur.DRS = ((f.a.a.a.a)localObject1).KhF.xS();
      AppMethodBeat.o(32359);
      return 0;
    }
    AppMethodBeat.o(32359);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bur
 * JD-Core Version:    0.7.0.1
 */