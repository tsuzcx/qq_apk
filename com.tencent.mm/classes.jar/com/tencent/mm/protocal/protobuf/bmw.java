package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class bmw
  extends cpx
{
  public int EuD;
  public int FbQ;
  public int FbR;
  public eat FbS;
  public String Fce;
  public String hOf;
  public b ncy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123618);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.hOf != null) {
        paramVarArgs.d(2, this.hOf);
      }
      if (this.ncy != null) {
        paramVarArgs.c(3, this.ncy);
      }
      if (this.Fce != null) {
        paramVarArgs.d(4, this.Fce);
      }
      paramVarArgs.aR(5, this.FbQ);
      paramVarArgs.aR(6, this.FbR);
      if (this.FbS != null)
      {
        paramVarArgs.ln(7, this.FbS.computeSize());
        this.FbS.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(8, this.EuD);
      AppMethodBeat.o(123618);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label782;
      }
    }
    label782:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.hOf != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.hOf);
      }
      i = paramInt;
      if (this.ncy != null) {
        i = paramInt + f.a.a.b.b.a.b(3, this.ncy);
      }
      paramInt = i;
      if (this.Fce != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Fce);
      }
      i = paramInt + f.a.a.b.b.a.bx(5, this.FbQ) + f.a.a.b.b.a.bx(6, this.FbR);
      paramInt = i;
      if (this.FbS != null) {
        paramInt = i + f.a.a.a.lm(7, this.FbS.computeSize());
      }
      i = f.a.a.b.b.a.bx(8, this.EuD);
      AppMethodBeat.o(123618);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(123618);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bmw localbmw = (bmw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123618);
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
            localbmw.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123618);
          return 0;
        case 2: 
          localbmw.hOf = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123618);
          return 0;
        case 3: 
          localbmw.ncy = ((f.a.a.a.a)localObject1).LVo.gfk();
          AppMethodBeat.o(123618);
          return 0;
        case 4: 
          localbmw.Fce = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123618);
          return 0;
        case 5: 
          localbmw.FbQ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(123618);
          return 0;
        case 6: 
          localbmw.FbR = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(123618);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eat();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eat)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbmw.FbS = ((eat)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123618);
          return 0;
        }
        localbmw.EuD = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(123618);
        return 0;
      }
      AppMethodBeat.o(123618);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bmw
 * JD-Core Version:    0.7.0.1
 */