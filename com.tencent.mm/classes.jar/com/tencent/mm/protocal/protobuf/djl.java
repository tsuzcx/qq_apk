package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class djl
  extends cpx
{
  public String FSA;
  public String FSB;
  public String FSC;
  public String FSz;
  public int reason;
  public String wNe;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72590);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.reason);
      if (this.FSz != null) {
        paramVarArgs.d(3, this.FSz);
      }
      if (this.FSA != null) {
        paramVarArgs.d(4, this.FSA);
      }
      if (this.wNe != null) {
        paramVarArgs.d(5, this.wNe);
      }
      if (this.FSB != null) {
        paramVarArgs.d(6, this.FSB);
      }
      if (this.FSC != null) {
        paramVarArgs.d(7, this.FSC);
      }
      AppMethodBeat.o(72590);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label658;
      }
    }
    label658:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.reason);
      paramInt = i;
      if (this.FSz != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.FSz);
      }
      i = paramInt;
      if (this.FSA != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.FSA);
      }
      paramInt = i;
      if (this.wNe != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.wNe);
      }
      i = paramInt;
      if (this.FSB != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.FSB);
      }
      paramInt = i;
      if (this.FSC != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.FSC);
      }
      AppMethodBeat.o(72590);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(72590);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        djl localdjl = (djl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72590);
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
            localdjl.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72590);
          return 0;
        case 2: 
          localdjl.reason = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(72590);
          return 0;
        case 3: 
          localdjl.FSz = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72590);
          return 0;
        case 4: 
          localdjl.FSA = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72590);
          return 0;
        case 5: 
          localdjl.wNe = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72590);
          return 0;
        case 6: 
          localdjl.FSB = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72590);
          return 0;
        }
        localdjl.FSC = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(72590);
        return 0;
      }
      AppMethodBeat.o(72590);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.djl
 * JD-Core Version:    0.7.0.1
 */