package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cnc
  extends cvc
{
  public int GeI;
  public long HfZ;
  public cwt Hgp;
  public cwt Hgq;
  public cwt Hgr;
  public int Hgs;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32386);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Hgp == null)
      {
        paramVarArgs = new b("Not all required fields were included: ClientReport");
        AppMethodBeat.o(32386);
        throw paramVarArgs;
      }
      if (this.Hgq == null)
      {
        paramVarArgs = new b("Not all required fields were included: ChannelReport");
        AppMethodBeat.o(32386);
        throw paramVarArgs;
      }
      if (this.Hgr == null)
      {
        paramVarArgs = new b("Not all required fields were included: EngineReport");
        AppMethodBeat.o(32386);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Hgp != null)
      {
        paramVarArgs.lC(2, this.Hgp.computeSize());
        this.Hgp.writeFields(paramVarArgs);
      }
      if (this.Hgq != null)
      {
        paramVarArgs.lC(3, this.Hgq.computeSize());
        this.Hgq.writeFields(paramVarArgs);
      }
      if (this.Hgr != null)
      {
        paramVarArgs.lC(4, this.Hgr.computeSize());
        this.Hgr.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(5, this.GeI);
      paramVarArgs.aY(6, this.HfZ);
      paramVarArgs.aS(7, this.Hgs);
      AppMethodBeat.o(32386);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1075;
      }
    }
    label1075:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Hgp != null) {
        paramInt = i + f.a.a.a.lB(2, this.Hgp.computeSize());
      }
      i = paramInt;
      if (this.Hgq != null) {
        i = paramInt + f.a.a.a.lB(3, this.Hgq.computeSize());
      }
      paramInt = i;
      if (this.Hgr != null) {
        paramInt = i + f.a.a.a.lB(4, this.Hgr.computeSize());
      }
      i = f.a.a.b.b.a.bz(5, this.GeI);
      int j = f.a.a.b.b.a.p(6, this.HfZ);
      int k = f.a.a.b.b.a.bz(7, this.Hgs);
      AppMethodBeat.o(32386);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.Hgp == null)
        {
          paramVarArgs = new b("Not all required fields were included: ClientReport");
          AppMethodBeat.o(32386);
          throw paramVarArgs;
        }
        if (this.Hgq == null)
        {
          paramVarArgs = new b("Not all required fields were included: ChannelReport");
          AppMethodBeat.o(32386);
          throw paramVarArgs;
        }
        if (this.Hgr == null)
        {
          paramVarArgs = new b("Not all required fields were included: EngineReport");
          AppMethodBeat.o(32386);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32386);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cnc localcnc = (cnc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32386);
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
            localcnc.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32386);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcnc.Hgp = ((cwt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32386);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcnc.Hgq = ((cwt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32386);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcnc.Hgr = ((cwt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32386);
          return 0;
        case 5: 
          localcnc.GeI = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32386);
          return 0;
        case 6: 
          localcnc.HfZ = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(32386);
          return 0;
        }
        localcnc.Hgs = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(32386);
        return 0;
      }
      AppMethodBeat.o(32386);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cnc
 * JD-Core Version:    0.7.0.1
 */