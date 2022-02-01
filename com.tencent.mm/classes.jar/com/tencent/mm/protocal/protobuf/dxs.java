package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dxs
  extends cvc
{
  public SKBuiltinBuffer_t FAN;
  public int GeI;
  public long GeJ;
  public int HKg;
  public int HKh;
  public int HKi;
  public int HKj;
  public int HKk;
  public int Hgi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115876);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FAN == null)
      {
        paramVarArgs = new b("Not all required fields were included: Buffer");
        AppMethodBeat.o(115876);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.GeI);
      paramVarArgs.aY(3, this.GeJ);
      paramVarArgs.aS(4, this.Hgi);
      paramVarArgs.aS(5, this.HKg);
      paramVarArgs.aS(6, this.HKh);
      paramVarArgs.aS(7, this.HKi);
      paramVarArgs.aS(8, this.HKj);
      paramVarArgs.aS(9, this.HKk);
      if (this.FAN != null)
      {
        paramVarArgs.lC(10, this.FAN.computeSize());
        this.FAN.writeFields(paramVarArgs);
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
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.GeI) + f.a.a.b.b.a.p(3, this.GeJ) + f.a.a.b.b.a.bz(4, this.Hgi) + f.a.a.b.b.a.bz(5, this.HKg) + f.a.a.b.b.a.bz(6, this.HKh) + f.a.a.b.b.a.bz(7, this.HKi) + f.a.a.b.b.a.bz(8, this.HKj) + f.a.a.b.b.a.bz(9, this.HKk);
      paramInt = i;
      if (this.FAN != null) {
        paramInt = i + f.a.a.a.lB(10, this.FAN.computeSize());
      }
      AppMethodBeat.o(115876);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.FAN == null)
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
        dxs localdxs = (dxs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115876);
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
            localdxs.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115876);
          return 0;
        case 2: 
          localdxs.GeI = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115876);
          return 0;
        case 3: 
          localdxs.GeJ = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(115876);
          return 0;
        case 4: 
          localdxs.Hgi = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115876);
          return 0;
        case 5: 
          localdxs.HKg = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115876);
          return 0;
        case 6: 
          localdxs.HKh = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115876);
          return 0;
        case 7: 
          localdxs.HKi = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115876);
          return 0;
        case 8: 
          localdxs.HKj = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115876);
          return 0;
        case 9: 
          localdxs.HKk = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115876);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdxs.FAN = ((SKBuiltinBuffer_t)localObject1);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dxs
 * JD-Core Version:    0.7.0.1
 */