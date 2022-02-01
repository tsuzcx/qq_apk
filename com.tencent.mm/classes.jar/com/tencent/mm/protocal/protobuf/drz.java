package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class drz
  extends cqk
{
  public int Exf;
  public long Exg;
  public int FZp;
  public int Fnf;
  public int Fwc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115877);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(115877);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.Exf);
      paramVarArgs.aO(3, this.Exg);
      paramVarArgs.aR(4, this.Fwc);
      paramVarArgs.aR(5, this.Fnf);
      paramVarArgs.aR(6, this.FZp);
      AppMethodBeat.o(115877);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label590;
      }
    }
    label590:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bx(2, this.Exf);
      int j = f.a.a.b.b.a.p(3, this.Exg);
      int k = f.a.a.b.b.a.bx(4, this.Fwc);
      int m = f.a.a.b.b.a.bx(5, this.Fnf);
      int n = f.a.a.b.b.a.bx(6, this.FZp);
      AppMethodBeat.o(115877);
      return paramInt + i + j + k + m + n;
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
          AppMethodBeat.o(115877);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115877);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        drz localdrz = (drz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115877);
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
            localdrz.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115877);
          return 0;
        case 2: 
          localdrz.Exf = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115877);
          return 0;
        case 3: 
          localdrz.Exg = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(115877);
          return 0;
        case 4: 
          localdrz.Fwc = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115877);
          return 0;
        case 5: 
          localdrz.Fnf = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115877);
          return 0;
        }
        localdrz.FZp = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(115877);
        return 0;
      }
      AppMethodBeat.o(115877);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.drz
 * JD-Core Version:    0.7.0.1
 */