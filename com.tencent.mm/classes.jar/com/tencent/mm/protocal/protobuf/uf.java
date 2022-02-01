package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class uf
  extends cpx
{
  public String Eor;
  public String Eos;
  public String cZz;
  public String tGS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72452);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Eor != null) {
        paramVarArgs.d(2, this.Eor);
      }
      if (this.Eos != null) {
        paramVarArgs.d(3, this.Eos);
      }
      if (this.tGS != null) {
        paramVarArgs.d(4, this.tGS);
      }
      if (this.cZz != null) {
        paramVarArgs.d(5, this.cZz);
      }
      AppMethodBeat.o(72452);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label550;
      }
    }
    label550:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Eor != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Eor);
      }
      i = paramInt;
      if (this.Eos != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Eos);
      }
      paramInt = i;
      if (this.tGS != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.tGS);
      }
      i = paramInt;
      if (this.cZz != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.cZz);
      }
      AppMethodBeat.o(72452);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(72452);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        uf localuf = (uf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72452);
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
            localuf.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72452);
          return 0;
        case 2: 
          localuf.Eor = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72452);
          return 0;
        case 3: 
          localuf.Eos = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72452);
          return 0;
        case 4: 
          localuf.tGS = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72452);
          return 0;
        }
        localuf.cZz = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(72452);
        return 0;
      }
      AppMethodBeat.o(72452);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.uf
 * JD-Core Version:    0.7.0.1
 */