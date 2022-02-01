package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class lu
  extends cvc
{
  public long FEA;
  public String FEy;
  public String FEz;
  public String mac;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82394);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.FEy != null) {
        paramVarArgs.d(2, this.FEy);
      }
      if (this.FEz != null) {
        paramVarArgs.d(3, this.FEz);
      }
      if (this.mac != null) {
        paramVarArgs.d(4, this.mac);
      }
      paramVarArgs.aY(5, this.FEA);
      AppMethodBeat.o(82394);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label534;
      }
    }
    label534:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FEy != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FEy);
      }
      i = paramInt;
      if (this.FEz != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FEz);
      }
      paramInt = i;
      if (this.mac != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.mac);
      }
      i = f.a.a.b.b.a.p(5, this.FEA);
      AppMethodBeat.o(82394);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(82394);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        lu locallu = (lu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(82394);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locallu.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82394);
          return 0;
        case 2: 
          locallu.FEy = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(82394);
          return 0;
        case 3: 
          locallu.FEz = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(82394);
          return 0;
        case 4: 
          locallu.mac = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(82394);
          return 0;
        }
        locallu.FEA = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(82394);
        return 0;
      }
      AppMethodBeat.o(82394);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.lu
 * JD-Core Version:    0.7.0.1
 */