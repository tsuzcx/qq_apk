package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cil
  extends cqk
{
  public String AYl;
  public String DKS;
  public String Fwy;
  public int dqL;
  public int nWx;
  public String nWy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91637);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91637);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.nWx);
      if (this.nWy != null) {
        paramVarArgs.d(3, this.nWy);
      }
      if (this.Fwy != null) {
        paramVarArgs.d(4, this.Fwy);
      }
      if (this.DKS != null) {
        paramVarArgs.d(5, this.DKS);
      }
      paramVarArgs.aR(6, this.dqL);
      if (this.AYl != null) {
        paramVarArgs.d(100, this.AYl);
      }
      AppMethodBeat.o(91637);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label714;
      }
    }
    label714:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.nWx);
      paramInt = i;
      if (this.nWy != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nWy);
      }
      i = paramInt;
      if (this.Fwy != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.Fwy);
      }
      paramInt = i;
      if (this.DKS != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.DKS);
      }
      i = paramInt + f.a.a.b.b.a.bx(6, this.dqL);
      paramInt = i;
      if (this.AYl != null) {
        paramInt = i + f.a.a.b.b.a.e(100, this.AYl);
      }
      AppMethodBeat.o(91637);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91637);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91637);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cil localcil = (cil)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91637);
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
            localcil.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91637);
          return 0;
        case 2: 
          localcil.nWx = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91637);
          return 0;
        case 3: 
          localcil.nWy = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91637);
          return 0;
        case 4: 
          localcil.Fwy = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91637);
          return 0;
        case 5: 
          localcil.DKS = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91637);
          return 0;
        case 6: 
          localcil.dqL = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91637);
          return 0;
        }
        localcil.AYl = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91637);
        return 0;
      }
      AppMethodBeat.o(91637);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cil
 * JD-Core Version:    0.7.0.1
 */