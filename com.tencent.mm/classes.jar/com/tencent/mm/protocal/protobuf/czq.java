package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class czq
  extends cpx
{
  public cob DQr;
  public SKBuiltinBuffer_t FIP;
  public SKBuiltinBuffer_t FIQ;
  public int FIR;
  public long Id;
  public int Scene;
  public int sVo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125766);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.Id);
      paramVarArgs.aR(3, this.Scene);
      if (this.FIP != null)
      {
        paramVarArgs.ln(4, this.FIP.computeSize());
        this.FIP.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(5, this.sVo);
      if (this.FIQ != null)
      {
        paramVarArgs.ln(6, this.FIQ.computeSize());
        this.FIQ.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(7, this.FIR);
      if (this.DQr != null)
      {
        paramVarArgs.ln(8, this.DQr.computeSize());
        this.DQr.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125766);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label954;
      }
    }
    label954:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.Id) + f.a.a.b.b.a.bx(3, this.Scene);
      paramInt = i;
      if (this.FIP != null) {
        paramInt = i + f.a.a.a.lm(4, this.FIP.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bx(5, this.sVo);
      paramInt = i;
      if (this.FIQ != null) {
        paramInt = i + f.a.a.a.lm(6, this.FIQ.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bx(7, this.FIR);
      paramInt = i;
      if (this.DQr != null) {
        paramInt = i + f.a.a.a.lm(8, this.DQr.computeSize());
      }
      AppMethodBeat.o(125766);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(125766);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        czq localczq = (czq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125766);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localczq.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125766);
          return 0;
        case 2: 
          localczq.Id = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(125766);
          return 0;
        case 3: 
          localczq.Scene = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125766);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localczq.FIP = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125766);
          return 0;
        case 5: 
          localczq.sVo = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125766);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localczq.FIQ = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125766);
          return 0;
        case 7: 
          localczq.FIR = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125766);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cob();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cob)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localczq.DQr = ((cob)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125766);
        return 0;
      }
      AppMethodBeat.o(125766);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.czq
 * JD-Core Version:    0.7.0.1
 */