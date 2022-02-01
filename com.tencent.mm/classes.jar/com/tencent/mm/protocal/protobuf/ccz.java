package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ccz
  extends ckq
{
  public long DYX;
  public cmf DZn;
  public cmf DZo;
  public cmf DZp;
  public int DZq;
  public int DdZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32386);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DZn == null)
      {
        paramVarArgs = new b("Not all required fields were included: ClientReport");
        AppMethodBeat.o(32386);
        throw paramVarArgs;
      }
      if (this.DZo == null)
      {
        paramVarArgs = new b("Not all required fields were included: ChannelReport");
        AppMethodBeat.o(32386);
        throw paramVarArgs;
      }
      if (this.DZp == null)
      {
        paramVarArgs = new b("Not all required fields were included: EngineReport");
        AppMethodBeat.o(32386);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.DZn != null)
      {
        paramVarArgs.kX(2, this.DZn.computeSize());
        this.DZn.writeFields(paramVarArgs);
      }
      if (this.DZo != null)
      {
        paramVarArgs.kX(3, this.DZo.computeSize());
        this.DZo.writeFields(paramVarArgs);
      }
      if (this.DZp != null)
      {
        paramVarArgs.kX(4, this.DZp.computeSize());
        this.DZp.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(5, this.DdZ);
      paramVarArgs.aG(6, this.DYX);
      paramVarArgs.aR(7, this.DZq);
      AppMethodBeat.o(32386);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1075;
      }
    }
    label1075:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DZn != null) {
        paramInt = i + f.a.a.a.kW(2, this.DZn.computeSize());
      }
      i = paramInt;
      if (this.DZo != null) {
        i = paramInt + f.a.a.a.kW(3, this.DZo.computeSize());
      }
      paramInt = i;
      if (this.DZp != null) {
        paramInt = i + f.a.a.a.kW(4, this.DZp.computeSize());
      }
      i = f.a.a.b.b.a.bA(5, this.DdZ);
      int j = f.a.a.b.b.a.q(6, this.DYX);
      int k = f.a.a.b.b.a.bA(7, this.DZq);
      AppMethodBeat.o(32386);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.DZn == null)
        {
          paramVarArgs = new b("Not all required fields were included: ClientReport");
          AppMethodBeat.o(32386);
          throw paramVarArgs;
        }
        if (this.DZo == null)
        {
          paramVarArgs = new b("Not all required fields were included: ChannelReport");
          AppMethodBeat.o(32386);
          throw paramVarArgs;
        }
        if (this.DZp == null)
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
        ccz localccz = (ccz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32386);
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
            localccz.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32386);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localccz.DZn = ((cmf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32386);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localccz.DZo = ((cmf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32386);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localccz.DZp = ((cmf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32386);
          return 0;
        case 5: 
          localccz.DdZ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32386);
          return 0;
        case 6: 
          localccz.DYX = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(32386);
          return 0;
        }
        localccz.DZq = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(32386);
        return 0;
      }
      AppMethodBeat.o(32386);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ccz
 * JD-Core Version:    0.7.0.1
 */