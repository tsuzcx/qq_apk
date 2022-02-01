package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cls
  extends cpx
{
  public String Fzm;
  public String djj;
  public int oxC;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32403);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.oxC);
      if (this.Fzm != null) {
        paramVarArgs.d(3, this.Fzm);
      }
      if (this.djj != null) {
        paramVarArgs.d(4, this.djj);
      }
      paramVarArgs.aR(5, this.scene);
      AppMethodBeat.o(32403);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label529;
      }
    }
    label529:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.oxC);
      paramInt = i;
      if (this.Fzm != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Fzm);
      }
      i = paramInt;
      if (this.djj != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.djj);
      }
      paramInt = f.a.a.b.b.a.bx(5, this.scene);
      AppMethodBeat.o(32403);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(32403);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cls localcls = (cls)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32403);
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
            localcls.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32403);
          return 0;
        case 2: 
          localcls.oxC = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32403);
          return 0;
        case 3: 
          localcls.Fzm = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32403);
          return 0;
        case 4: 
          localcls.djj = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32403);
          return 0;
        }
        localcls.scene = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(32403);
        return 0;
      }
      AppMethodBeat.o(32403);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cls
 * JD-Core Version:    0.7.0.1
 */