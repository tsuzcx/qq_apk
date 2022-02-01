package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ati
  extends cqk
{
  public bkx EMo;
  public String EMp;
  public bks EMq;
  public int result;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82408);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(82408);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.EMo != null)
      {
        paramVarArgs.ln(2, this.EMo.computeSize());
        this.EMo.writeFields(paramVarArgs);
      }
      if (this.EMp != null) {
        paramVarArgs.d(3, this.EMp);
      }
      if (this.EMq != null)
      {
        paramVarArgs.ln(4, this.EMq.computeSize());
        this.EMq.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(5, this.result);
      AppMethodBeat.o(82408);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label770;
      }
    }
    label770:
    for (int i = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.EMo != null) {
        paramInt = i + f.a.a.a.lm(2, this.EMo.computeSize());
      }
      i = paramInt;
      if (this.EMp != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.EMp);
      }
      paramInt = i;
      if (this.EMq != null) {
        paramInt = i + f.a.a.a.lm(4, this.EMq.computeSize());
      }
      i = f.a.a.b.b.a.bx(5, this.result);
      AppMethodBeat.o(82408);
      return paramInt + i;
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
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(82408);
          throw paramVarArgs;
        }
        AppMethodBeat.o(82408);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ati localati = (ati)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(82408);
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
            localati.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82408);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bkx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bkx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localati.EMo = ((bkx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82408);
          return 0;
        case 3: 
          localati.EMp = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(82408);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bks();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bks)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localati.EMq = ((bks)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82408);
          return 0;
        }
        localati.result = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(82408);
        return 0;
      }
      AppMethodBeat.o(82408);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ati
 * JD-Core Version:    0.7.0.1
 */