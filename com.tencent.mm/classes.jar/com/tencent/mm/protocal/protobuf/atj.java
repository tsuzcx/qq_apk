package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class atj
  extends cpx
{
  public SKBuiltinBuffer_t DYu;
  public String EMr;
  public int EMs;
  public int Scene;
  public int ndI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104367);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.ndI);
      paramVarArgs.aR(3, this.Scene);
      if (this.EMr != null) {
        paramVarArgs.d(4, this.EMr);
      }
      if (this.DYu != null)
      {
        paramVarArgs.ln(5, this.DYu.computeSize());
        this.DYu.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(6, this.EMs);
      AppMethodBeat.o(104367);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label658;
      }
    }
    label658:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.ndI) + f.a.a.b.b.a.bx(3, this.Scene);
      paramInt = i;
      if (this.EMr != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.EMr);
      }
      i = paramInt;
      if (this.DYu != null) {
        i = paramInt + f.a.a.a.lm(5, this.DYu.computeSize());
      }
      paramInt = f.a.a.b.b.a.bx(6, this.EMs);
      AppMethodBeat.o(104367);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(104367);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        atj localatj = (atj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104367);
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
            localatj.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104367);
          return 0;
        case 2: 
          localatj.ndI = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(104367);
          return 0;
        case 3: 
          localatj.Scene = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(104367);
          return 0;
        case 4: 
          localatj.EMr = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(104367);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localatj.DYu = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104367);
          return 0;
        }
        localatj.EMs = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(104367);
        return 0;
      }
      AppMethodBeat.o(104367);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.atj
 * JD-Core Version:    0.7.0.1
 */