package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cjq
  extends cqk
{
  public String AYl;
  public int Fxq;
  public String Fxr;
  public String Fxs;
  public bio Fxt;
  public int nWx;
  public String nWy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91642);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91642);
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
      paramVarArgs.aR(4, this.Fxq);
      if (this.Fxr != null) {
        paramVarArgs.d(5, this.Fxr);
      }
      if (this.Fxs != null) {
        paramVarArgs.d(6, this.Fxs);
      }
      if (this.Fxt != null)
      {
        paramVarArgs.ln(7, this.Fxt.computeSize());
        this.Fxt.writeFields(paramVarArgs);
      }
      if (this.AYl != null) {
        paramVarArgs.d(100, this.AYl);
      }
      AppMethodBeat.o(91642);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label874;
      }
    }
    label874:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.nWx);
      paramInt = i;
      if (this.nWy != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nWy);
      }
      i = paramInt + f.a.a.b.b.a.bx(4, this.Fxq);
      paramInt = i;
      if (this.Fxr != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Fxr);
      }
      i = paramInt;
      if (this.Fxs != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.Fxs);
      }
      paramInt = i;
      if (this.Fxt != null) {
        paramInt = i + f.a.a.a.lm(7, this.Fxt.computeSize());
      }
      i = paramInt;
      if (this.AYl != null) {
        i = paramInt + f.a.a.b.b.a.e(100, this.AYl);
      }
      AppMethodBeat.o(91642);
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
          AppMethodBeat.o(91642);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91642);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cjq localcjq = (cjq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91642);
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
            localcjq.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91642);
          return 0;
        case 2: 
          localcjq.nWx = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91642);
          return 0;
        case 3: 
          localcjq.nWy = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91642);
          return 0;
        case 4: 
          localcjq.Fxq = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91642);
          return 0;
        case 5: 
          localcjq.Fxr = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91642);
          return 0;
        case 6: 
          localcjq.Fxs = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91642);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bio();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bio)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcjq.Fxt = ((bio)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91642);
          return 0;
        }
        localcjq.AYl = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91642);
        return 0;
      }
      AppMethodBeat.o(91642);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cjq
 * JD-Core Version:    0.7.0.1
 */