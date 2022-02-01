package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class axu
  extends cpx
{
  public int EPw;
  public int EPx;
  public String EPy;
  public int EPz;
  public String ncR;
  public int vTH;
  public int vTI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152570);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ncR != null) {
        paramVarArgs.d(2, this.ncR);
      }
      paramVarArgs.aR(3, this.EPw);
      paramVarArgs.aR(4, this.EPx);
      if (this.EPy != null) {
        paramVarArgs.d(5, this.EPy);
      }
      paramVarArgs.aR(6, this.vTH);
      paramVarArgs.aR(7, this.vTI);
      paramVarArgs.aR(8, this.EPz);
      AppMethodBeat.o(152570);
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
      int i = paramInt;
      if (this.ncR != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.ncR);
      }
      i = i + f.a.a.b.b.a.bx(3, this.EPw) + f.a.a.b.b.a.bx(4, this.EPx);
      paramInt = i;
      if (this.EPy != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.EPy);
      }
      i = f.a.a.b.b.a.bx(6, this.vTH);
      int j = f.a.a.b.b.a.bx(7, this.vTI);
      int k = f.a.a.b.b.a.bx(8, this.EPz);
      AppMethodBeat.o(152570);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(152570);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        axu localaxu = (axu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152570);
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
            localaxu.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152570);
          return 0;
        case 2: 
          localaxu.ncR = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152570);
          return 0;
        case 3: 
          localaxu.EPw = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152570);
          return 0;
        case 4: 
          localaxu.EPx = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152570);
          return 0;
        case 5: 
          localaxu.EPy = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152570);
          return 0;
        case 6: 
          localaxu.vTH = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152570);
          return 0;
        case 7: 
          localaxu.vTI = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152570);
          return 0;
        }
        localaxu.EPz = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(152570);
        return 0;
      }
      AppMethodBeat.o(152570);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.axu
 * JD-Core Version:    0.7.0.1
 */