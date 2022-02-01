package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cnr
  extends cpx
{
  public SKBuiltinBuffer_t DYu;
  public String EMr;
  public long EMt;
  public String FAO;
  public String FAP;
  public int Scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104375);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.EMt);
      if (this.FAO != null) {
        paramVarArgs.d(3, this.FAO);
      }
      if (this.FAP != null) {
        paramVarArgs.d(4, this.FAP);
      }
      if (this.EMr != null) {
        paramVarArgs.d(5, this.EMr);
      }
      if (this.DYu != null)
      {
        paramVarArgs.ln(6, this.DYu.computeSize());
        this.DYu.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(7, this.Scene);
      AppMethodBeat.o(104375);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label738;
      }
    }
    label738:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.EMt);
      paramInt = i;
      if (this.FAO != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.FAO);
      }
      i = paramInt;
      if (this.FAP != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.FAP);
      }
      paramInt = i;
      if (this.EMr != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.EMr);
      }
      i = paramInt;
      if (this.DYu != null) {
        i = paramInt + f.a.a.a.lm(6, this.DYu.computeSize());
      }
      paramInt = f.a.a.b.b.a.bx(7, this.Scene);
      AppMethodBeat.o(104375);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(104375);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cnr localcnr = (cnr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104375);
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
            localcnr.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104375);
          return 0;
        case 2: 
          localcnr.EMt = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(104375);
          return 0;
        case 3: 
          localcnr.FAO = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(104375);
          return 0;
        case 4: 
          localcnr.FAP = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(104375);
          return 0;
        case 5: 
          localcnr.EMr = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(104375);
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
            localcnr.DYu = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104375);
          return 0;
        }
        localcnr.Scene = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(104375);
        return 0;
      }
      AppMethodBeat.o(104375);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cnr
 * JD-Core Version:    0.7.0.1
 */