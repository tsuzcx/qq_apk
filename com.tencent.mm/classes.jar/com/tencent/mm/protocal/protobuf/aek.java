package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class aek
  extends cpx
{
  public String EaV;
  public b EuL;
  public b Exk;
  public int sVo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124485);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.EaV != null) {
        paramVarArgs.d(2, this.EaV);
      }
      paramVarArgs.aR(3, this.sVo);
      if (this.Exk != null) {
        paramVarArgs.c(4, this.Exk);
      }
      if (this.EuL != null) {
        paramVarArgs.c(5, this.EuL);
      }
      AppMethodBeat.o(124485);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label534;
      }
    }
    label534:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.EaV != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.EaV);
      }
      i += f.a.a.b.b.a.bx(3, this.sVo);
      paramInt = i;
      if (this.Exk != null) {
        paramInt = i + f.a.a.b.b.a.b(4, this.Exk);
      }
      i = paramInt;
      if (this.EuL != null) {
        i = paramInt + f.a.a.b.b.a.b(5, this.EuL);
      }
      AppMethodBeat.o(124485);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(124485);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aek localaek = (aek)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124485);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaek.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124485);
          return 0;
        case 2: 
          localaek.EaV = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(124485);
          return 0;
        case 3: 
          localaek.sVo = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(124485);
          return 0;
        case 4: 
          localaek.Exk = ((f.a.a.a.a)localObject1).LVo.gfk();
          AppMethodBeat.o(124485);
          return 0;
        }
        localaek.EuL = ((f.a.a.a.a)localObject1).LVo.gfk();
        AppMethodBeat.o(124485);
        return 0;
      }
      AppMethodBeat.o(124485);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aek
 * JD-Core Version:    0.7.0.1
 */