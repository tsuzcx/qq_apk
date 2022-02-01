package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class aus
  extends cqk
{
  public LinkedList<String> nTc;
  public int nTe;
  public int nTf;
  public int nTg;
  
  public aus()
  {
    AppMethodBeat.i(114018);
    this.nTc = new LinkedList();
    AppMethodBeat.o(114018);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114019);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(114019);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 1, this.nTc);
      paramVarArgs.aR(3, this.nTe);
      paramVarArgs.aR(4, this.nTf);
      paramVarArgs.aR(5, this.nTg);
      AppMethodBeat.o(114019);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label554;
      }
    }
    label554:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.a.c(2, 1, this.nTc);
      int j = f.a.a.b.b.a.bx(3, this.nTe);
      int k = f.a.a.b.b.a.bx(4, this.nTf);
      int m = f.a.a.b.b.a.bx(5, this.nTg);
      AppMethodBeat.o(114019);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.nTc.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(114019);
          throw paramVarArgs;
        }
        AppMethodBeat.o(114019);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aus localaus = (aus)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114019);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaus.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114019);
          return 0;
        case 2: 
          localaus.nTc.add(((f.a.a.a.a)localObject1).LVo.readString());
          AppMethodBeat.o(114019);
          return 0;
        case 3: 
          localaus.nTe = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(114019);
          return 0;
        case 4: 
          localaus.nTf = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(114019);
          return 0;
        }
        localaus.nTg = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(114019);
        return 0;
      }
      AppMethodBeat.o(114019);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aus
 * JD-Core Version:    0.7.0.1
 */