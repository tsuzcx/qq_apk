package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dry
  extends cpx
{
  public SKBuiltinBuffer_t DVs;
  public int Exf;
  public long Exg;
  public int FZk;
  public int FZl;
  public int FZm;
  public int FZn;
  public int FZo;
  public int Fwc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115876);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DVs == null)
      {
        paramVarArgs = new b("Not all required fields were included: Buffer");
        AppMethodBeat.o(115876);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.Exf);
      paramVarArgs.aO(3, this.Exg);
      paramVarArgs.aR(4, this.Fwc);
      paramVarArgs.aR(5, this.FZk);
      paramVarArgs.aR(6, this.FZl);
      paramVarArgs.aR(7, this.FZm);
      paramVarArgs.aR(8, this.FZn);
      paramVarArgs.aR(9, this.FZo);
      if (this.DVs != null)
      {
        paramVarArgs.ln(10, this.DVs.computeSize());
        this.DVs.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(115876);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label862;
      }
    }
    label862:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.Exf) + f.a.a.b.b.a.p(3, this.Exg) + f.a.a.b.b.a.bx(4, this.Fwc) + f.a.a.b.b.a.bx(5, this.FZk) + f.a.a.b.b.a.bx(6, this.FZl) + f.a.a.b.b.a.bx(7, this.FZm) + f.a.a.b.b.a.bx(8, this.FZn) + f.a.a.b.b.a.bx(9, this.FZo);
      paramInt = i;
      if (this.DVs != null) {
        paramInt = i + f.a.a.a.lm(10, this.DVs.computeSize());
      }
      AppMethodBeat.o(115876);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.DVs == null)
        {
          paramVarArgs = new b("Not all required fields were included: Buffer");
          AppMethodBeat.o(115876);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115876);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dry localdry = (dry)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115876);
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
            localdry.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115876);
          return 0;
        case 2: 
          localdry.Exf = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115876);
          return 0;
        case 3: 
          localdry.Exg = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(115876);
          return 0;
        case 4: 
          localdry.Fwc = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115876);
          return 0;
        case 5: 
          localdry.FZk = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115876);
          return 0;
        case 6: 
          localdry.FZl = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115876);
          return 0;
        case 7: 
          localdry.FZm = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115876);
          return 0;
        case 8: 
          localdry.FZn = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115876);
          return 0;
        case 9: 
          localdry.FZo = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115876);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdry.DVs = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(115876);
        return 0;
      }
      AppMethodBeat.o(115876);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dry
 * JD-Core Version:    0.7.0.1
 */