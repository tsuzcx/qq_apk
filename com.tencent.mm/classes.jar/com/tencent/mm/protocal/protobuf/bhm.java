package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bhm
  extends cvc
{
  public int GCN;
  public int GCO;
  public ty GCP;
  public zb GCQ;
  public int GCR;
  public long cbe;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50089);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.GCN);
      paramVarArgs.aS(3, this.GCO);
      if (this.GCP != null)
      {
        paramVarArgs.lC(4, this.GCP.computeSize());
        this.GCP.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(5, this.cbe);
      if (this.GCQ != null)
      {
        paramVarArgs.lC(6, this.GCQ.computeSize());
        this.GCQ.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(7, this.GCR);
      AppMethodBeat.o(50089);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label798;
      }
    }
    label798:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.GCN) + f.a.a.b.b.a.bz(3, this.GCO);
      paramInt = i;
      if (this.GCP != null) {
        paramInt = i + f.a.a.a.lB(4, this.GCP.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.p(5, this.cbe);
      paramInt = i;
      if (this.GCQ != null) {
        paramInt = i + f.a.a.a.lB(6, this.GCQ.computeSize());
      }
      i = f.a.a.b.b.a.bz(7, this.GCR);
      AppMethodBeat.o(50089);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(50089);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bhm localbhm = (bhm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(50089);
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
            localbhm.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(50089);
          return 0;
        case 2: 
          localbhm.GCN = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(50089);
          return 0;
        case 3: 
          localbhm.GCO = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(50089);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ty();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ty)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbhm.GCP = ((ty)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(50089);
          return 0;
        case 5: 
          localbhm.cbe = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(50089);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new zb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((zb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbhm.GCQ = ((zb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(50089);
          return 0;
        }
        localbhm.GCR = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(50089);
        return 0;
      }
      AppMethodBeat.o(50089);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bhm
 * JD-Core Version:    0.7.0.1
 */