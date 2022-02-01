package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bfu
  extends cpx
{
  public boolean EVf;
  public String EVg;
  public String hip;
  public String pIw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32281);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.pIw == null)
      {
        paramVarArgs = new b("Not all required fields were included: appusername");
        AppMethodBeat.o(32281);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bl(2, this.EVf);
      if (this.hip != null) {
        paramVarArgs.d(3, this.hip);
      }
      if (this.pIw != null) {
        paramVarArgs.d(4, this.pIw);
      }
      if (this.EVg != null) {
        paramVarArgs.d(5, this.EVg);
      }
      AppMethodBeat.o(32281);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label593;
      }
    }
    label593:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + (f.a.a.b.b.a.fK(2) + 1);
      paramInt = i;
      if (this.hip != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.hip);
      }
      i = paramInt;
      if (this.pIw != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.pIw);
      }
      paramInt = i;
      if (this.EVg != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.EVg);
      }
      AppMethodBeat.o(32281);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.pIw == null)
        {
          paramVarArgs = new b("Not all required fields were included: appusername");
          AppMethodBeat.o(32281);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32281);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bfu localbfu = (bfu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32281);
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
            localbfu.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32281);
          return 0;
        case 2: 
          localbfu.EVf = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(32281);
          return 0;
        case 3: 
          localbfu.hip = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32281);
          return 0;
        case 4: 
          localbfu.pIw = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32281);
          return 0;
        }
        localbfu.EVg = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(32281);
        return 0;
      }
      AppMethodBeat.o(32281);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bfu
 * JD-Core Version:    0.7.0.1
 */