package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class djm
  extends cqk
{
  public String FSD;
  public String FSE;
  public coc FSy;
  public int nWx;
  public String nWy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72591);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.nWx);
      if (this.nWy != null) {
        paramVarArgs.d(3, this.nWy);
      }
      if (this.FSD != null) {
        paramVarArgs.d(4, this.FSD);
      }
      if (this.FSE != null) {
        paramVarArgs.d(5, this.FSE);
      }
      if (this.FSy != null)
      {
        paramVarArgs.ln(6, this.FSy.computeSize());
        this.FSy.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72591);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label690;
      }
    }
    label690:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.nWx);
      paramInt = i;
      if (this.nWy != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nWy);
      }
      i = paramInt;
      if (this.FSD != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.FSD);
      }
      paramInt = i;
      if (this.FSE != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.FSE);
      }
      i = paramInt;
      if (this.FSy != null) {
        i = paramInt + f.a.a.a.lm(6, this.FSy.computeSize());
      }
      AppMethodBeat.o(72591);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(72591);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        djm localdjm = (djm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72591);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdjm.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72591);
          return 0;
        case 2: 
          localdjm.nWx = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(72591);
          return 0;
        case 3: 
          localdjm.nWy = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72591);
          return 0;
        case 4: 
          localdjm.FSD = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72591);
          return 0;
        case 5: 
          localdjm.FSE = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72591);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new coc();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((coc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdjm.FSy = ((coc)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72591);
        return 0;
      }
      AppMethodBeat.o(72591);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.djm
 * JD-Core Version:    0.7.0.1
 */