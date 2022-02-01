package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dvu
  extends cqk
{
  public String djc;
  public int gbd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(121114);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.djc != null) {
        paramVarArgs.d(2, this.djc);
      }
      paramVarArgs.aR(3, this.gbd);
      AppMethodBeat.o(121114);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label414;
      }
    }
    label414:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.djc != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.djc);
      }
      paramInt = f.a.a.b.b.a.bx(3, this.gbd);
      AppMethodBeat.o(121114);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(121114);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dvu localdvu = (dvu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(121114);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdvu.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(121114);
          return 0;
        case 2: 
          localdvu.djc = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(121114);
          return 0;
        }
        localdvu.gbd = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(121114);
        return 0;
      }
      AppMethodBeat.o(121114);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dvu
 * JD-Core Version:    0.7.0.1
 */