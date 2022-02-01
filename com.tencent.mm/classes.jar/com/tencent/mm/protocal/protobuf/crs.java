package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class crs
  extends cpx
{
  public int DOv;
  public String EUS;
  public int dbL;
  public String djj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147776);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.djj != null) {
        paramVarArgs.d(2, this.djj);
      }
      if (this.EUS != null) {
        paramVarArgs.d(3, this.EUS);
      }
      paramVarArgs.aR(4, this.dbL);
      paramVarArgs.aR(5, this.DOv);
      AppMethodBeat.o(147776);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label522;
      }
    }
    label522:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.djj != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.djj);
      }
      i = paramInt;
      if (this.EUS != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.EUS);
      }
      paramInt = f.a.a.b.b.a.bx(4, this.dbL);
      int j = f.a.a.b.b.a.bx(5, this.DOv);
      AppMethodBeat.o(147776);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(147776);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        crs localcrs = (crs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(147776);
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
            localcrs.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(147776);
          return 0;
        case 2: 
          localcrs.djj = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(147776);
          return 0;
        case 3: 
          localcrs.EUS = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(147776);
          return 0;
        case 4: 
          localcrs.dbL = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(147776);
          return 0;
        }
        localcrs.DOv = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(147776);
        return 0;
      }
      AppMethodBeat.o(147776);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.crs
 * JD-Core Version:    0.7.0.1
 */