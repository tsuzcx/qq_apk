package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class drr
  extends cqk
{
  public long Exg;
  public long FOh;
  public int FZa;
  public int FZb;
  public int FZc;
  public int FZd;
  public com.tencent.mm.bw.b FZe;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125510);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(125510);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.FOh);
      paramVarArgs.aO(3, this.Exg);
      paramVarArgs.aR(4, this.FZa);
      paramVarArgs.aR(5, this.FZb);
      paramVarArgs.aR(6, this.FZc);
      paramVarArgs.aR(7, this.FZd);
      if (this.FZe != null) {
        paramVarArgs.c(8, this.FZe);
      }
      AppMethodBeat.o(125510);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label678;
      }
    }
    label678:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.FOh) + f.a.a.b.b.a.p(3, this.Exg) + f.a.a.b.b.a.bx(4, this.FZa) + f.a.a.b.b.a.bx(5, this.FZb) + f.a.a.b.b.a.bx(6, this.FZc) + f.a.a.b.b.a.bx(7, this.FZd);
      paramInt = i;
      if (this.FZe != null) {
        paramInt = i + f.a.a.b.b.a.b(8, this.FZe);
      }
      AppMethodBeat.o(125510);
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
          AppMethodBeat.o(125510);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125510);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        drr localdrr = (drr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125510);
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
            localdrr.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125510);
          return 0;
        case 2: 
          localdrr.FOh = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(125510);
          return 0;
        case 3: 
          localdrr.Exg = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(125510);
          return 0;
        case 4: 
          localdrr.FZa = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125510);
          return 0;
        case 5: 
          localdrr.FZb = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125510);
          return 0;
        case 6: 
          localdrr.FZc = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125510);
          return 0;
        case 7: 
          localdrr.FZd = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125510);
          return 0;
        }
        localdrr.FZe = ((f.a.a.a.a)localObject1).LVo.gfk();
        AppMethodBeat.o(125510);
        return 0;
      }
      AppMethodBeat.o(125510);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.drr
 * JD-Core Version:    0.7.0.1
 */