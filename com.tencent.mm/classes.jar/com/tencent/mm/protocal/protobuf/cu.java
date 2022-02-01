package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cu
  extends com.tencent.mm.bw.a
{
  public int CreateTime;
  public crm DPT;
  public crm DPU;
  public crm DPV;
  public int DPW;
  public SKBuiltinBuffer_t DPX;
  public String DPY;
  public String DPZ;
  public int DQa;
  public int ndj;
  public int tit;
  public int vTO;
  public long vTQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133143);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DPT == null)
      {
        paramVarArgs = new b("Not all required fields were included: FromUserName");
        AppMethodBeat.o(133143);
        throw paramVarArgs;
      }
      if (this.DPU == null)
      {
        paramVarArgs = new b("Not all required fields were included: ToUserName");
        AppMethodBeat.o(133143);
        throw paramVarArgs;
      }
      if (this.DPV == null)
      {
        paramVarArgs = new b("Not all required fields were included: Content");
        AppMethodBeat.o(133143);
        throw paramVarArgs;
      }
      if (this.DPX == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgBuf");
        AppMethodBeat.o(133143);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.vTO);
      if (this.DPT != null)
      {
        paramVarArgs.ln(2, this.DPT.computeSize());
        this.DPT.writeFields(paramVarArgs);
      }
      if (this.DPU != null)
      {
        paramVarArgs.ln(3, this.DPU.computeSize());
        this.DPU.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(4, this.tit);
      if (this.DPV != null)
      {
        paramVarArgs.ln(5, this.DPV.computeSize());
        this.DPV.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(6, this.ndj);
      paramVarArgs.aR(7, this.DPW);
      if (this.DPX != null)
      {
        paramVarArgs.ln(8, this.DPX.computeSize());
        this.DPX.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(9, this.CreateTime);
      if (this.DPY != null) {
        paramVarArgs.d(10, this.DPY);
      }
      if (this.DPZ != null) {
        paramVarArgs.d(11, this.DPZ);
      }
      paramVarArgs.aO(12, this.vTQ);
      paramVarArgs.aR(13, this.DQa);
      AppMethodBeat.o(133143);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.vTO) + 0;
      paramInt = i;
      if (this.DPT != null) {
        paramInt = i + f.a.a.a.lm(2, this.DPT.computeSize());
      }
      i = paramInt;
      if (this.DPU != null) {
        i = paramInt + f.a.a.a.lm(3, this.DPU.computeSize());
      }
      i += f.a.a.b.b.a.bx(4, this.tit);
      paramInt = i;
      if (this.DPV != null) {
        paramInt = i + f.a.a.a.lm(5, this.DPV.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bx(6, this.ndj) + f.a.a.b.b.a.bx(7, this.DPW);
      paramInt = i;
      if (this.DPX != null) {
        paramInt = i + f.a.a.a.lm(8, this.DPX.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bx(9, this.CreateTime);
      paramInt = i;
      if (this.DPY != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.DPY);
      }
      i = paramInt;
      if (this.DPZ != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.DPZ);
      }
      paramInt = f.a.a.b.b.a.p(12, this.vTQ);
      int j = f.a.a.b.b.a.bx(13, this.DQa);
      AppMethodBeat.o(133143);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      if (this.DPT == null)
      {
        paramVarArgs = new b("Not all required fields were included: FromUserName");
        AppMethodBeat.o(133143);
        throw paramVarArgs;
      }
      if (this.DPU == null)
      {
        paramVarArgs = new b("Not all required fields were included: ToUserName");
        AppMethodBeat.o(133143);
        throw paramVarArgs;
      }
      if (this.DPV == null)
      {
        paramVarArgs = new b("Not all required fields were included: Content");
        AppMethodBeat.o(133143);
        throw paramVarArgs;
      }
      if (this.DPX == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgBuf");
        AppMethodBeat.o(133143);
        throw paramVarArgs;
      }
      AppMethodBeat.o(133143);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      cu localcu = (cu)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(133143);
        return -1;
      case 1: 
        localcu.vTO = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(133143);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new crm();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcu.DPT = ((crm)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133143);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new crm();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcu.DPU = ((crm)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133143);
        return 0;
      case 4: 
        localcu.tit = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(133143);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new crm();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcu.DPV = ((crm)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133143);
        return 0;
      case 6: 
        localcu.ndj = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(133143);
        return 0;
      case 7: 
        localcu.DPW = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(133143);
        return 0;
      case 8: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcu.DPX = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133143);
        return 0;
      case 9: 
        localcu.CreateTime = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(133143);
        return 0;
      case 10: 
        localcu.DPY = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(133143);
        return 0;
      case 11: 
        localcu.DPZ = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(133143);
        return 0;
      case 12: 
        localcu.vTQ = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(133143);
        return 0;
      }
      localcu.DQa = ((f.a.a.a.a)localObject1).LVo.xF();
      AppMethodBeat.o(133143);
      return 0;
    }
    AppMethodBeat.o(133143);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cu
 * JD-Core Version:    0.7.0.1
 */