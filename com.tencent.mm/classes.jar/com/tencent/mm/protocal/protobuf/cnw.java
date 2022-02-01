package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cnw
  extends cqk
{
  public int FAV;
  public int FAY;
  public int FAZ;
  public dqq FBa;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32413);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32413);
        throw paramVarArgs;
      }
      if (this.FBa == null)
      {
        paramVarArgs = new b("Not all required fields were included: NextPiece");
        AppMethodBeat.o(32413);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.FAY);
      paramVarArgs.aR(3, this.FAZ);
      if (this.FBa != null)
      {
        paramVarArgs.ln(4, this.FBa.computeSize());
        this.FBa.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(5, this.FAV);
      AppMethodBeat.o(32413);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label705;
      }
    }
    label705:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.FAY) + f.a.a.b.b.a.bx(3, this.FAZ);
      paramInt = i;
      if (this.FBa != null) {
        paramInt = i + f.a.a.a.lm(4, this.FBa.computeSize());
      }
      i = f.a.a.b.b.a.bx(5, this.FAV);
      AppMethodBeat.o(32413);
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
          AppMethodBeat.o(32413);
          throw paramVarArgs;
        }
        if (this.FBa == null)
        {
          paramVarArgs = new b("Not all required fields were included: NextPiece");
          AppMethodBeat.o(32413);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32413);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cnw localcnw = (cnw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32413);
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
            localcnw.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32413);
          return 0;
        case 2: 
          localcnw.FAY = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32413);
          return 0;
        case 3: 
          localcnw.FAZ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32413);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dqq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcnw.FBa = ((dqq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32413);
          return 0;
        }
        localcnw.FAV = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(32413);
        return 0;
      }
      AppMethodBeat.o(32413);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cnw
 * JD-Core Version:    0.7.0.1
 */