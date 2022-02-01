package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class baa
  extends cqk
{
  public int ENU;
  public rd EQY;
  public ri ERb;
  public rf ERc;
  public String ERd;
  public int nWx;
  public String nWy;
  public int oGs;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(206457);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(206457);
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
      if (this.ERb != null)
      {
        paramVarArgs.ln(4, this.ERb.computeSize());
        this.ERb.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(5, this.oGs);
      paramVarArgs.aR(6, this.ENU);
      if (this.ERc != null)
      {
        paramVarArgs.ln(7, this.ERc.computeSize());
        this.ERc.writeFields(paramVarArgs);
      }
      if (this.EQY != null)
      {
        paramVarArgs.ln(8, this.EQY.computeSize());
        this.EQY.writeFields(paramVarArgs);
      }
      if (this.ERd != null) {
        paramVarArgs.d(9, this.ERd);
      }
      AppMethodBeat.o(206457);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1078;
      }
    }
    label1078:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.nWx);
      paramInt = i;
      if (this.nWy != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nWy);
      }
      i = paramInt;
      if (this.ERb != null) {
        i = paramInt + f.a.a.a.lm(4, this.ERb.computeSize());
      }
      i = i + f.a.a.b.b.a.bx(5, this.oGs) + f.a.a.b.b.a.bx(6, this.ENU);
      paramInt = i;
      if (this.ERc != null) {
        paramInt = i + f.a.a.a.lm(7, this.ERc.computeSize());
      }
      i = paramInt;
      if (this.EQY != null) {
        i = paramInt + f.a.a.a.lm(8, this.EQY.computeSize());
      }
      paramInt = i;
      if (this.ERd != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.ERd);
      }
      AppMethodBeat.o(206457);
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
          AppMethodBeat.o(206457);
          throw paramVarArgs;
        }
        AppMethodBeat.o(206457);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        baa localbaa = (baa)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(206457);
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
            localbaa.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(206457);
          return 0;
        case 2: 
          localbaa.nWx = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(206457);
          return 0;
        case 3: 
          localbaa.nWy = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(206457);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ri();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ri)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbaa.ERb = ((ri)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(206457);
          return 0;
        case 5: 
          localbaa.oGs = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(206457);
          return 0;
        case 6: 
          localbaa.ENU = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(206457);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new rf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((rf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbaa.ERc = ((rf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(206457);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new rd();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((rd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbaa.EQY = ((rd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(206457);
          return 0;
        }
        localbaa.ERd = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(206457);
        return 0;
      }
      AppMethodBeat.o(206457);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.baa
 * JD-Core Version:    0.7.0.1
 */