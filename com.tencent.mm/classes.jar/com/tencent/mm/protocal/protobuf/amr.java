package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class amr
  extends dyy
{
  public String ByI;
  public String EBP;
  public cmb SwQ;
  public int fwx;
  public String tVo;
  public String ybP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91457);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91457);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.fwx);
      if (this.tVo != null) {
        paramVarArgs.f(3, this.tVo);
      }
      if (this.ybP != null) {
        paramVarArgs.f(4, this.ybP);
      }
      if (this.ByI != null) {
        paramVarArgs.f(5, this.ByI);
      }
      if (this.EBP != null) {
        paramVarArgs.f(6, this.EBP);
      }
      if (this.SwQ != null)
      {
        paramVarArgs.oE(7, this.SwQ.computeSize());
        this.SwQ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91457);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label758;
      }
    }
    label758:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.fwx);
      paramInt = i;
      if (this.tVo != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.tVo);
      }
      i = paramInt;
      if (this.ybP != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.ybP);
      }
      paramInt = i;
      if (this.ByI != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.ByI);
      }
      i = paramInt;
      if (this.EBP != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.EBP);
      }
      paramInt = i;
      if (this.SwQ != null) {
        paramInt = i + g.a.a.a.oD(7, this.SwQ.computeSize());
      }
      AppMethodBeat.o(91457);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91457);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91457);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        amr localamr = (amr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91457);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jh)localObject2).parseFrom((byte[])localObject1);
            }
            localamr.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91457);
          return 0;
        case 2: 
          localamr.fwx = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91457);
          return 0;
        case 3: 
          localamr.tVo = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91457);
          return 0;
        case 4: 
          localamr.ybP = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91457);
          return 0;
        case 5: 
          localamr.ByI = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91457);
          return 0;
        case 6: 
          localamr.EBP = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91457);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new cmb();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((cmb)localObject2).parseFrom((byte[])localObject1);
          }
          localamr.SwQ = ((cmb)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91457);
        return 0;
      }
      AppMethodBeat.o(91457);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.amr
 * JD-Core Version:    0.7.0.1
 */