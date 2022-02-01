package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cq
  extends cvc
{
  public int Fva;
  public String Fvb;
  public String Fvc;
  public String hCW;
  public int nEf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127430);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.hCW != null) {
        paramVarArgs.d(2, this.hCW);
      }
      paramVarArgs.aS(3, this.nEf);
      paramVarArgs.aS(4, this.Fva);
      if (this.Fvb != null) {
        paramVarArgs.d(5, this.Fvb);
      }
      if (this.Fvc != null) {
        paramVarArgs.d(6, this.Fvc);
      }
      AppMethodBeat.o(127430);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label578;
      }
    }
    label578:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.hCW != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.hCW);
      }
      i = i + f.a.a.b.b.a.bz(3, this.nEf) + f.a.a.b.b.a.bz(4, this.Fva);
      paramInt = i;
      if (this.Fvb != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Fvb);
      }
      i = paramInt;
      if (this.Fvc != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.Fvc);
      }
      AppMethodBeat.o(127430);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(127430);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cq localcq = (cq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(127430);
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
            localcq.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(127430);
          return 0;
        case 2: 
          localcq.hCW = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(127430);
          return 0;
        case 3: 
          localcq.nEf = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(127430);
          return 0;
        case 4: 
          localcq.Fva = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(127430);
          return 0;
        case 5: 
          localcq.Fvb = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(127430);
          return 0;
        }
        localcq.Fvc = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(127430);
        return 0;
      }
      AppMethodBeat.o(127430);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cq
 * JD-Core Version:    0.7.0.1
 */