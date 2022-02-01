package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class die
  extends ckq
{
  public String CLB;
  public dky CXZ;
  public did CYb;
  public int Scene;
  public String sdP;
  public String sdQ;
  public SKBuiltinBuffer_t uKT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32487);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CXZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: VoiceAttr");
        AppMethodBeat.o(32487);
        throw paramVarArgs;
      }
      if (this.CYb == null)
      {
        paramVarArgs = new b("Not all required fields were included: UploadCtx");
        AppMethodBeat.o(32487);
        throw paramVarArgs;
      }
      if (this.uKT == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(32487);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.CLB != null) {
        paramVarArgs.d(2, this.CLB);
      }
      if (this.CXZ != null)
      {
        paramVarArgs.kX(3, this.CXZ.computeSize());
        this.CXZ.writeFields(paramVarArgs);
      }
      if (this.CYb != null)
      {
        paramVarArgs.kX(4, this.CYb.computeSize());
        this.CYb.writeFields(paramVarArgs);
      }
      if (this.uKT != null)
      {
        paramVarArgs.kX(5, this.uKT.computeSize());
        this.uKT.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(6, this.Scene);
      if (this.sdQ != null) {
        paramVarArgs.d(7, this.sdQ);
      }
      if (this.sdP != null) {
        paramVarArgs.d(8, this.sdP);
      }
      AppMethodBeat.o(32487);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1168;
      }
    }
    label1168:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CLB != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.CLB);
      }
      i = paramInt;
      if (this.CXZ != null) {
        i = paramInt + f.a.a.a.kW(3, this.CXZ.computeSize());
      }
      paramInt = i;
      if (this.CYb != null) {
        paramInt = i + f.a.a.a.kW(4, this.CYb.computeSize());
      }
      i = paramInt;
      if (this.uKT != null) {
        i = paramInt + f.a.a.a.kW(5, this.uKT.computeSize());
      }
      i += f.a.a.b.b.a.bA(6, this.Scene);
      paramInt = i;
      if (this.sdQ != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.sdQ);
      }
      i = paramInt;
      if (this.sdP != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.sdP);
      }
      AppMethodBeat.o(32487);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.CXZ == null)
        {
          paramVarArgs = new b("Not all required fields were included: VoiceAttr");
          AppMethodBeat.o(32487);
          throw paramVarArgs;
        }
        if (this.CYb == null)
        {
          paramVarArgs = new b("Not all required fields were included: UploadCtx");
          AppMethodBeat.o(32487);
          throw paramVarArgs;
        }
        if (this.uKT == null)
        {
          paramVarArgs = new b("Not all required fields were included: Data");
          AppMethodBeat.o(32487);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32487);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        die localdie = (die)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32487);
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
            localdie.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32487);
          return 0;
        case 2: 
          localdie.CLB = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32487);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dky();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dky)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdie.CXZ = ((dky)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32487);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new did();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((did)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdie.CYb = ((did)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32487);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdie.uKT = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32487);
          return 0;
        case 6: 
          localdie.Scene = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32487);
          return 0;
        case 7: 
          localdie.sdQ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32487);
          return 0;
        }
        localdie.sdP = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(32487);
        return 0;
      }
      AppMethodBeat.o(32487);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.die
 * JD-Core Version:    0.7.0.1
 */