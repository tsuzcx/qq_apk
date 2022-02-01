package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class cye
  extends cpx
{
  public LinkedList<Integer> DWN;
  public String FHw;
  public int Scene;
  public int ncL;
  
  public cye()
  {
    AppMethodBeat.i(127502);
    this.DWN = new LinkedList();
    AppMethodBeat.o(127502);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127503);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.FHw != null) {
        paramVarArgs.d(2, this.FHw);
      }
      paramVarArgs.aR(3, this.Scene);
      paramVarArgs.aR(4, this.ncL);
      paramVarArgs.f(5, 2, this.DWN);
      AppMethodBeat.o(127503);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label537;
      }
    }
    label537:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FHw != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.FHw);
      }
      paramInt = f.a.a.b.b.a.bx(3, this.Scene);
      int j = f.a.a.b.b.a.bx(4, this.ncL);
      int k = f.a.a.a.d(5, 2, this.DWN);
      AppMethodBeat.o(127503);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DWN.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(127503);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cye localcye = (cye)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(127503);
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
            localcye.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(127503);
          return 0;
        case 2: 
          localcye.FHw = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(127503);
          return 0;
        case 3: 
          localcye.Scene = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(127503);
          return 0;
        case 4: 
          localcye.ncL = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(127503);
          return 0;
        }
        localcye.DWN = new f.a.a.a.a(((f.a.a.a.a)localObject1).LVo.gfk().xy, unknownTagHandler).LVo.gfi();
        AppMethodBeat.o(127503);
        return 0;
      }
      AppMethodBeat.o(127503);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cye
 * JD-Core Version:    0.7.0.1
 */