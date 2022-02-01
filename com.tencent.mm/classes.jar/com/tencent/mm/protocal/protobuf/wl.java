package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class wl
  extends cqk
{
  public dqu EqJ;
  public dns EqK;
  public ckk EqL;
  public int EqM;
  public int ndj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32167);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32167);
        throw paramVarArgs;
      }
      if (this.EqJ == null)
      {
        paramVarArgs = new b("Not all required fields were included: TransRes");
        AppMethodBeat.o(32167);
        throw paramVarArgs;
      }
      if (this.EqK == null)
      {
        paramVarArgs = new b("Not all required fields were included: UploadCtx");
        AppMethodBeat.o(32167);
        throw paramVarArgs;
      }
      if (this.EqL == null)
      {
        paramVarArgs = new b("Not all required fields were included: QueryCtx");
        AppMethodBeat.o(32167);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.ndj);
      if (this.EqJ != null)
      {
        paramVarArgs.ln(3, this.EqJ.computeSize());
        this.EqJ.writeFields(paramVarArgs);
      }
      if (this.EqK != null)
      {
        paramVarArgs.ln(4, this.EqK.computeSize());
        this.EqK.writeFields(paramVarArgs);
      }
      if (this.EqL != null)
      {
        paramVarArgs.ln(5, this.EqL.computeSize());
        this.EqL.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(6, this.EqM);
      AppMethodBeat.o(32167);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1074;
      }
    }
    label1074:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.ndj);
      paramInt = i;
      if (this.EqJ != null) {
        paramInt = i + f.a.a.a.lm(3, this.EqJ.computeSize());
      }
      i = paramInt;
      if (this.EqK != null) {
        i = paramInt + f.a.a.a.lm(4, this.EqK.computeSize());
      }
      paramInt = i;
      if (this.EqL != null) {
        paramInt = i + f.a.a.a.lm(5, this.EqL.computeSize());
      }
      i = f.a.a.b.b.a.bx(6, this.EqM);
      AppMethodBeat.o(32167);
      return paramInt + i;
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
          AppMethodBeat.o(32167);
          throw paramVarArgs;
        }
        if (this.EqJ == null)
        {
          paramVarArgs = new b("Not all required fields were included: TransRes");
          AppMethodBeat.o(32167);
          throw paramVarArgs;
        }
        if (this.EqK == null)
        {
          paramVarArgs = new b("Not all required fields were included: UploadCtx");
          AppMethodBeat.o(32167);
          throw paramVarArgs;
        }
        if (this.EqL == null)
        {
          paramVarArgs = new b("Not all required fields were included: QueryCtx");
          AppMethodBeat.o(32167);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32167);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        wl localwl = (wl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32167);
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
            localwl.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32167);
          return 0;
        case 2: 
          localwl.ndj = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32167);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dqu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localwl.EqJ = ((dqu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32167);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dns();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dns)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localwl.EqK = ((dns)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32167);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ckk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ckk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localwl.EqL = ((ckk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32167);
          return 0;
        }
        localwl.EqM = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(32167);
        return 0;
      }
      AppMethodBeat.o(32167);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.wl
 * JD-Core Version:    0.7.0.1
 */