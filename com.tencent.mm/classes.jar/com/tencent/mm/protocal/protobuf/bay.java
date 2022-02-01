package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bay
  extends cvc
{
  public int GxW;
  public aeq GxX;
  public LinkedList<ahl> GxY;
  public int GxZ;
  public String Gya;
  public int Scene;
  
  public bay()
  {
    AppMethodBeat.i(210594);
    this.GxY = new LinkedList();
    AppMethodBeat.o(210594);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(210595);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GxX == null)
      {
        paramVarArgs = new b("Not all required fields were included: DeviceType");
        AppMethodBeat.o(210595);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.GxW);
      paramVarArgs.aS(3, this.Scene);
      if (this.GxX != null)
      {
        paramVarArgs.lC(4, this.GxX.computeSize());
        this.GxX.writeFields(paramVarArgs);
      }
      paramVarArgs.e(5, 8, this.GxY);
      paramVarArgs.aS(6, this.GxZ);
      if (this.Gya != null) {
        paramVarArgs.d(7, this.Gya);
      }
      AppMethodBeat.o(210595);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label846;
      }
    }
    label846:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.GxW) + f.a.a.b.b.a.bz(3, this.Scene);
      paramInt = i;
      if (this.GxX != null) {
        paramInt = i + f.a.a.a.lB(4, this.GxX.computeSize());
      }
      i = paramInt + f.a.a.a.c(5, 8, this.GxY) + f.a.a.b.b.a.bz(6, this.GxZ);
      paramInt = i;
      if (this.Gya != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.Gya);
      }
      AppMethodBeat.o(210595);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GxY.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.GxX == null)
        {
          paramVarArgs = new b("Not all required fields were included: DeviceType");
          AppMethodBeat.o(210595);
          throw paramVarArgs;
        }
        AppMethodBeat.o(210595);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bay localbay = (bay)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(210595);
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
            localbay.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(210595);
          return 0;
        case 2: 
          localbay.GxW = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(210595);
          return 0;
        case 3: 
          localbay.Scene = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(210595);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aeq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aeq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbay.GxX = ((aeq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(210595);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ahl();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ahl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbay.GxY.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(210595);
          return 0;
        case 6: 
          localbay.GxZ = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(210595);
          return 0;
        }
        localbay.Gya = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(210595);
        return 0;
      }
      AppMethodBeat.o(210595);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bay
 * JD-Core Version:    0.7.0.1
 */