package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cey
  extends cqk
{
  public String DPG;
  public String EJP;
  public String EJQ;
  public String pAH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91607);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91607);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.EJP != null) {
        paramVarArgs.d(2, this.EJP);
      }
      if (this.EJQ != null) {
        paramVarArgs.d(3, this.EJQ);
      }
      if (this.DPG != null) {
        paramVarArgs.d(4, this.DPG);
      }
      if (this.pAH != null) {
        paramVarArgs.d(5, this.pAH);
      }
      AppMethodBeat.o(91607);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label598;
      }
    }
    label598:
    for (int i = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.EJP != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.EJP);
      }
      i = paramInt;
      if (this.EJQ != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.EJQ);
      }
      paramInt = i;
      if (this.DPG != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DPG);
      }
      i = paramInt;
      if (this.pAH != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.pAH);
      }
      AppMethodBeat.o(91607);
      return i;
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
          AppMethodBeat.o(91607);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91607);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cey localcey = (cey)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91607);
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
            localcey.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91607);
          return 0;
        case 2: 
          localcey.EJP = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91607);
          return 0;
        case 3: 
          localcey.EJQ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91607);
          return 0;
        case 4: 
          localcey.DPG = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91607);
          return 0;
        }
        localcey.pAH = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91607);
        return 0;
      }
      AppMethodBeat.o(91607);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cey
 * JD-Core Version:    0.7.0.1
 */