package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fv
  extends cqk
{
  public com.tencent.mm.bw.b DSO;
  public int DST;
  public int DSU;
  public ga DSV;
  public fw DSW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32119);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32119);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.DST);
      paramVarArgs.aR(3, this.DSU);
      if (this.DSO != null) {
        paramVarArgs.c(4, this.DSO);
      }
      if (this.DSV != null)
      {
        paramVarArgs.ln(5, this.DSV.computeSize());
        this.DSV.writeFields(paramVarArgs);
      }
      if (this.DSW != null)
      {
        paramVarArgs.ln(6, this.DSW.computeSize());
        this.DSW.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32119);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label830;
      }
    }
    label830:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.DST) + f.a.a.b.b.a.bx(3, this.DSU);
      paramInt = i;
      if (this.DSO != null) {
        paramInt = i + f.a.a.b.b.a.b(4, this.DSO);
      }
      i = paramInt;
      if (this.DSV != null) {
        i = paramInt + f.a.a.a.lm(5, this.DSV.computeSize());
      }
      paramInt = i;
      if (this.DSW != null) {
        paramInt = i + f.a.a.a.lm(6, this.DSW.computeSize());
      }
      AppMethodBeat.o(32119);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32119);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32119);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        fv localfv = (fv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32119);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localfv.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32119);
          return 0;
        case 2: 
          localfv.DST = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32119);
          return 0;
        case 3: 
          localfv.DSU = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32119);
          return 0;
        case 4: 
          localfv.DSO = ((f.a.a.a.a)localObject1).LVo.gfk();
          AppMethodBeat.o(32119);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ga();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ga)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localfv.DSV = ((ga)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32119);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new fw();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((fw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localfv.DSW = ((fw)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32119);
        return 0;
      }
      AppMethodBeat.o(32119);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fv
 * JD-Core Version:    0.7.0.1
 */