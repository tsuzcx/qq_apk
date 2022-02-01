package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dco
  extends cvc
{
  public SKBuiltinBuffer_t FyU;
  public int HrA;
  public String qdZ;
  public String xbo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(134257);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.qdZ != null) {
        paramVarArgs.d(2, this.qdZ);
      }
      if (this.xbo != null) {
        paramVarArgs.d(3, this.xbo);
      }
      if (this.FyU != null)
      {
        paramVarArgs.lC(4, this.FyU.computeSize());
        this.FyU.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(5, this.HrA);
      AppMethodBeat.o(134257);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label630;
      }
    }
    label630:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.qdZ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.qdZ);
      }
      i = paramInt;
      if (this.xbo != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.xbo);
      }
      paramInt = i;
      if (this.FyU != null) {
        paramInt = i + f.a.a.a.lB(4, this.FyU.computeSize());
      }
      i = f.a.a.b.b.a.bz(5, this.HrA);
      AppMethodBeat.o(134257);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(134257);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dco localdco = (dco)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(134257);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdco.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134257);
          return 0;
        case 2: 
          localdco.qdZ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(134257);
          return 0;
        case 3: 
          localdco.xbo = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(134257);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdco.FyU = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134257);
          return 0;
        }
        localdco.HrA = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(134257);
        return 0;
      }
      AppMethodBeat.o(134257);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dco
 * JD-Core Version:    0.7.0.1
 */