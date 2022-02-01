package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dnn
  extends ckq
{
  public int CRw;
  public SKBuiltinBuffer_t CRx;
  public String DZr;
  public int DdZ;
  public long Dea;
  public long EAY;
  public dme EEi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115925);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CRx == null)
      {
        paramVarArgs = new b("Not all required fields were included: KeyBuf");
        AppMethodBeat.o(115925);
        throw paramVarArgs;
      }
      if (this.EEi == null)
      {
        paramVarArgs = new b("Not all required fields were included: OpLog");
        AppMethodBeat.o(115925);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.DZr != null) {
        paramVarArgs.d(2, this.DZr);
      }
      paramVarArgs.aR(3, this.DdZ);
      if (this.CRx != null)
      {
        paramVarArgs.kX(4, this.CRx.computeSize());
        this.CRx.writeFields(paramVarArgs);
      }
      if (this.EEi != null)
      {
        paramVarArgs.kX(5, this.EEi.computeSize());
        this.EEi.writeFields(paramVarArgs);
      }
      paramVarArgs.aG(6, this.Dea);
      paramVarArgs.aR(7, this.CRw);
      paramVarArgs.aG(8, this.EAY);
      AppMethodBeat.o(115925);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label962;
      }
    }
    label962:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.DZr != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.DZr);
      }
      i += f.a.a.b.b.a.bA(3, this.DdZ);
      paramInt = i;
      if (this.CRx != null) {
        paramInt = i + f.a.a.a.kW(4, this.CRx.computeSize());
      }
      i = paramInt;
      if (this.EEi != null) {
        i = paramInt + f.a.a.a.kW(5, this.EEi.computeSize());
      }
      paramInt = f.a.a.b.b.a.q(6, this.Dea);
      int j = f.a.a.b.b.a.bA(7, this.CRw);
      int k = f.a.a.b.b.a.q(8, this.EAY);
      AppMethodBeat.o(115925);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.CRx == null)
        {
          paramVarArgs = new b("Not all required fields were included: KeyBuf");
          AppMethodBeat.o(115925);
          throw paramVarArgs;
        }
        if (this.EEi == null)
        {
          paramVarArgs = new b("Not all required fields were included: OpLog");
          AppMethodBeat.o(115925);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115925);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dnn localdnn = (dnn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115925);
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
            localdnn.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115925);
          return 0;
        case 2: 
          localdnn.DZr = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(115925);
          return 0;
        case 3: 
          localdnn.DdZ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115925);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdnn.CRx = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115925);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dme();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dme)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdnn.EEi = ((dme)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115925);
          return 0;
        case 6: 
          localdnn.Dea = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(115925);
          return 0;
        case 7: 
          localdnn.CRw = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115925);
          return 0;
        }
        localdnn.EAY = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(115925);
        return 0;
      }
      AppMethodBeat.o(115925);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dnn
 * JD-Core Version:    0.7.0.1
 */