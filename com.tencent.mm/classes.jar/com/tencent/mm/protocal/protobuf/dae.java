package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dae
  extends cpx
{
  public String FJv;
  public int FJw;
  public int ndI;
  public int vTH;
  public int vTI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125782);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.vTI);
      paramVarArgs.aR(3, this.vTH);
      if (this.FJv != null) {
        paramVarArgs.d(4, this.FJv);
      }
      paramVarArgs.aR(5, this.ndI);
      paramVarArgs.aR(6, this.FJw);
      AppMethodBeat.o(125782);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label550;
      }
    }
    label550:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.vTI) + f.a.a.b.b.a.bx(3, this.vTH);
      paramInt = i;
      if (this.FJv != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FJv);
      }
      i = f.a.a.b.b.a.bx(5, this.ndI);
      int j = f.a.a.b.b.a.bx(6, this.FJw);
      AppMethodBeat.o(125782);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(125782);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dae localdae = (dae)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125782);
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
            localdae.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125782);
          return 0;
        case 2: 
          localdae.vTI = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125782);
          return 0;
        case 3: 
          localdae.vTH = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125782);
          return 0;
        case 4: 
          localdae.FJv = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(125782);
          return 0;
        case 5: 
          localdae.ndI = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125782);
          return 0;
        }
        localdae.FJw = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(125782);
        return 0;
      }
      AppMethodBeat.o(125782);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dae
 * JD-Core Version:    0.7.0.1
 */