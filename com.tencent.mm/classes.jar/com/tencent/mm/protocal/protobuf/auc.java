package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class auc
  extends cqk
{
  public qg DZh;
  public qg DZi;
  public qg DZj;
  public SKBuiltinBuffer_t DZk;
  public SKBuiltinBuffer_t DZl;
  public qg DZm;
  public int DZn;
  public qf DZo;
  public qf DZp;
  public int EMH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152567);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(152567);
        throw paramVarArgs;
      }
      if (this.DZh == null)
      {
        paramVarArgs = new b("Not all required fields were included: DnsInfo");
        AppMethodBeat.o(152567);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.DZh != null)
      {
        paramVarArgs.ln(2, this.DZh.computeSize());
        this.DZh.writeFields(paramVarArgs);
      }
      if (this.DZi != null)
      {
        paramVarArgs.ln(3, this.DZi.computeSize());
        this.DZi.writeFields(paramVarArgs);
      }
      if (this.DZj != null)
      {
        paramVarArgs.ln(4, this.DZj.computeSize());
        this.DZj.writeFields(paramVarArgs);
      }
      if (this.DZk != null)
      {
        paramVarArgs.ln(5, this.DZk.computeSize());
        this.DZk.writeFields(paramVarArgs);
      }
      if (this.DZl != null)
      {
        paramVarArgs.ln(6, this.DZl.computeSize());
        this.DZl.writeFields(paramVarArgs);
      }
      if (this.DZm != null)
      {
        paramVarArgs.ln(7, this.DZm.computeSize());
        this.DZm.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(8, this.DZn);
      if (this.DZo != null)
      {
        paramVarArgs.ln(9, this.DZo.computeSize());
        this.DZo.writeFields(paramVarArgs);
      }
      if (this.DZp != null)
      {
        paramVarArgs.ln(10, this.DZp.computeSize());
        this.DZp.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(11, this.EMH);
      AppMethodBeat.o(152567);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1738;
      }
    }
    label1738:
    for (int i = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DZh != null) {
        paramInt = i + f.a.a.a.lm(2, this.DZh.computeSize());
      }
      i = paramInt;
      if (this.DZi != null) {
        i = paramInt + f.a.a.a.lm(3, this.DZi.computeSize());
      }
      paramInt = i;
      if (this.DZj != null) {
        paramInt = i + f.a.a.a.lm(4, this.DZj.computeSize());
      }
      i = paramInt;
      if (this.DZk != null) {
        i = paramInt + f.a.a.a.lm(5, this.DZk.computeSize());
      }
      paramInt = i;
      if (this.DZl != null) {
        paramInt = i + f.a.a.a.lm(6, this.DZl.computeSize());
      }
      i = paramInt;
      if (this.DZm != null) {
        i = paramInt + f.a.a.a.lm(7, this.DZm.computeSize());
      }
      i += f.a.a.b.b.a.bx(8, this.DZn);
      paramInt = i;
      if (this.DZo != null) {
        paramInt = i + f.a.a.a.lm(9, this.DZo.computeSize());
      }
      i = paramInt;
      if (this.DZp != null) {
        i = paramInt + f.a.a.a.lm(10, this.DZp.computeSize());
      }
      paramInt = f.a.a.b.b.a.bx(11, this.EMH);
      AppMethodBeat.o(152567);
      return i + paramInt;
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
          AppMethodBeat.o(152567);
          throw paramVarArgs;
        }
        if (this.DZh == null)
        {
          paramVarArgs = new b("Not all required fields were included: DnsInfo");
          AppMethodBeat.o(152567);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152567);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        auc localauc = (auc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152567);
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
            localauc.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152567);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new qg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((qg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localauc.DZh = ((qg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152567);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new qg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((qg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localauc.DZi = ((qg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152567);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new qg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((qg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localauc.DZj = ((qg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152567);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localauc.DZk = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152567);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localauc.DZl = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152567);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new qg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((qg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localauc.DZm = ((qg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152567);
          return 0;
        case 8: 
          localauc.DZn = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152567);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new qf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((qf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localauc.DZo = ((qf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152567);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new qf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((qf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localauc.DZp = ((qf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152567);
          return 0;
        }
        localauc.EMH = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(152567);
        return 0;
      }
      AppMethodBeat.o(152567);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.auc
 * JD-Core Version:    0.7.0.1
 */