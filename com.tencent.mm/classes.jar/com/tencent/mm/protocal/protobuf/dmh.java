package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dmh
  extends ckq
{
  public SKBuiltinBuffer_t CCV;
  public int DZg;
  public int DdZ;
  public long Dea;
  public int EBX;
  public int EBY;
  public int EBZ;
  public int ECa;
  public int ECb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115876);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CCV == null)
      {
        paramVarArgs = new b("Not all required fields were included: Buffer");
        AppMethodBeat.o(115876);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.DdZ);
      paramVarArgs.aG(3, this.Dea);
      paramVarArgs.aR(4, this.DZg);
      paramVarArgs.aR(5, this.EBX);
      paramVarArgs.aR(6, this.EBY);
      paramVarArgs.aR(7, this.EBZ);
      paramVarArgs.aR(8, this.ECa);
      paramVarArgs.aR(9, this.ECb);
      if (this.CCV != null)
      {
        paramVarArgs.kX(10, this.CCV.computeSize());
        this.CCV.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(115876);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label862;
      }
    }
    label862:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.DdZ) + f.a.a.b.b.a.q(3, this.Dea) + f.a.a.b.b.a.bA(4, this.DZg) + f.a.a.b.b.a.bA(5, this.EBX) + f.a.a.b.b.a.bA(6, this.EBY) + f.a.a.b.b.a.bA(7, this.EBZ) + f.a.a.b.b.a.bA(8, this.ECa) + f.a.a.b.b.a.bA(9, this.ECb);
      paramInt = i;
      if (this.CCV != null) {
        paramInt = i + f.a.a.a.kW(10, this.CCV.computeSize());
      }
      AppMethodBeat.o(115876);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.CCV == null)
        {
          paramVarArgs = new b("Not all required fields were included: Buffer");
          AppMethodBeat.o(115876);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115876);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dmh localdmh = (dmh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115876);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdmh.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115876);
          return 0;
        case 2: 
          localdmh.DdZ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115876);
          return 0;
        case 3: 
          localdmh.Dea = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(115876);
          return 0;
        case 4: 
          localdmh.DZg = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115876);
          return 0;
        case 5: 
          localdmh.EBX = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115876);
          return 0;
        case 6: 
          localdmh.EBY = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115876);
          return 0;
        case 7: 
          localdmh.EBZ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115876);
          return 0;
        case 8: 
          localdmh.ECa = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115876);
          return 0;
        case 9: 
          localdmh.ECb = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115876);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdmh.CCV = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(115876);
        return 0;
      }
      AppMethodBeat.o(115876);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dmh
 * JD-Core Version:    0.7.0.1
 */