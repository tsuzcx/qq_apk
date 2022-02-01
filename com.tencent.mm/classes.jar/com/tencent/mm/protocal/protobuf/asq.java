package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class asq
  extends cqk
{
  public int ELY;
  public String ELZ;
  public String EMa;
  public int nWx;
  public String nWy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91476);
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
      paramVarArgs.aR(4, this.ELY);
      if (this.ELZ != null) {
        paramVarArgs.d(5, this.ELZ);
      }
      if (this.EMa != null) {
        paramVarArgs.d(6, this.EMa);
      }
      AppMethodBeat.o(91476);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label582;
      }
    }
    label582:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.nWx);
      paramInt = i;
      if (this.nWy != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nWy);
      }
      i = paramInt + f.a.a.b.b.a.bx(4, this.ELY);
      paramInt = i;
      if (this.ELZ != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.ELZ);
      }
      i = paramInt;
      if (this.EMa != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.EMa);
      }
      AppMethodBeat.o(91476);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(91476);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        asq localasq = (asq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91476);
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
            localasq.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91476);
          return 0;
        case 2: 
          localasq.nWx = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91476);
          return 0;
        case 3: 
          localasq.nWy = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91476);
          return 0;
        case 4: 
          localasq.ELY = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91476);
          return 0;
        case 5: 
          localasq.ELZ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91476);
          return 0;
        }
        localasq.EMa = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91476);
        return 0;
      }
      AppMethodBeat.o(91476);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.asq
 * JD-Core Version:    0.7.0.1
 */