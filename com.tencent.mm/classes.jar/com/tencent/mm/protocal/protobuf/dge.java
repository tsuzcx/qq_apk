package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dge
  extends ckq
{
  public SKBuiltinBuffer_t CFU;
  public String EwY;
  public String EwZ;
  public int Scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(130921);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.EwY != null) {
        paramVarArgs.d(2, this.EwY);
      }
      if (this.EwZ != null) {
        paramVarArgs.d(3, this.EwZ);
      }
      paramVarArgs.aR(4, this.Scene);
      if (this.CFU != null)
      {
        paramVarArgs.kX(5, this.CFU.computeSize());
        this.CFU.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(130921);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label630;
      }
    }
    label630:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.EwY != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.EwY);
      }
      i = paramInt;
      if (this.EwZ != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.EwZ);
      }
      i += f.a.a.b.b.a.bA(4, this.Scene);
      paramInt = i;
      if (this.CFU != null) {
        paramInt = i + f.a.a.a.kW(5, this.CFU.computeSize());
      }
      AppMethodBeat.o(130921);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(130921);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dge localdge = (dge)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(130921);
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
            localdge.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(130921);
          return 0;
        case 2: 
          localdge.EwY = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(130921);
          return 0;
        case 3: 
          localdge.EwZ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(130921);
          return 0;
        case 4: 
          localdge.Scene = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(130921);
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
          localdge.CFU = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(130921);
        return 0;
      }
      AppMethodBeat.o(130921);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dge
 * JD-Core Version:    0.7.0.1
 */