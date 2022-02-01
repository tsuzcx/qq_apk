package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class tp
  extends cpx
{
  public boolean EnF;
  public boolean EnG;
  public LinkedList<Integer> Enb;
  public String desc;
  
  public tp()
  {
    AppMethodBeat.i(72444);
    this.Enb = new LinkedList();
    AppMethodBeat.o(72444);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72445);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 2, this.Enb);
      if (this.desc != null) {
        paramVarArgs.d(3, this.desc);
      }
      paramVarArgs.bl(4, this.EnF);
      paramVarArgs.bl(5, this.EnG);
      AppMethodBeat.o(72445);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label517;
      }
    }
    label517:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 2, this.Enb);
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.desc);
      }
      i = f.a.a.b.b.a.fK(4);
      int j = f.a.a.b.b.a.fK(5);
      AppMethodBeat.o(72445);
      return paramInt + (i + 1) + (j + 1);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Enb.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(72445);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        tp localtp = (tp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72445);
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
            localtp.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72445);
          return 0;
        case 2: 
          localtp.Enb.add(Integer.valueOf(((f.a.a.a.a)localObject1).LVo.xF()));
          AppMethodBeat.o(72445);
          return 0;
        case 3: 
          localtp.desc = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72445);
          return 0;
        case 4: 
          localtp.EnF = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(72445);
          return 0;
        }
        localtp.EnG = ((f.a.a.a.a)localObject1).LVo.fZX();
        AppMethodBeat.o(72445);
        return 0;
      }
      AppMethodBeat.o(72445);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.tp
 * JD-Core Version:    0.7.0.1
 */