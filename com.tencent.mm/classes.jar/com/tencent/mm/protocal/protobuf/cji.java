package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cji
  extends cqk
{
  public String Fxi;
  public String Fxj;
  public qm Fxk;
  public String Fxl;
  public String Fxm;
  public diz Fxn;
  public String cZz;
  public String hhs;
  public int nWx;
  public String nWy;
  public String vwo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72556);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72556);
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
      if (this.Fxi != null) {
        paramVarArgs.d(4, this.Fxi);
      }
      if (this.hhs != null) {
        paramVarArgs.d(5, this.hhs);
      }
      if (this.Fxj != null) {
        paramVarArgs.d(6, this.Fxj);
      }
      if (this.Fxk != null)
      {
        paramVarArgs.ln(7, this.Fxk.computeSize());
        this.Fxk.writeFields(paramVarArgs);
      }
      if (this.Fxl != null) {
        paramVarArgs.d(8, this.Fxl);
      }
      if (this.vwo != null) {
        paramVarArgs.d(9, this.vwo);
      }
      if (this.cZz != null) {
        paramVarArgs.d(10, this.cZz);
      }
      if (this.Fxm != null) {
        paramVarArgs.d(11, this.Fxm);
      }
      if (this.Fxn != null)
      {
        paramVarArgs.ln(12, this.Fxn.computeSize());
        this.Fxn.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72556);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1206;
      }
    }
    label1206:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.nWx);
      paramInt = i;
      if (this.nWy != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nWy);
      }
      i = paramInt;
      if (this.Fxi != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.Fxi);
      }
      paramInt = i;
      if (this.hhs != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.hhs);
      }
      i = paramInt;
      if (this.Fxj != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.Fxj);
      }
      paramInt = i;
      if (this.Fxk != null) {
        paramInt = i + f.a.a.a.lm(7, this.Fxk.computeSize());
      }
      i = paramInt;
      if (this.Fxl != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.Fxl);
      }
      paramInt = i;
      if (this.vwo != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.vwo);
      }
      i = paramInt;
      if (this.cZz != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.cZz);
      }
      paramInt = i;
      if (this.Fxm != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.Fxm);
      }
      i = paramInt;
      if (this.Fxn != null) {
        i = paramInt + f.a.a.a.lm(12, this.Fxn.computeSize());
      }
      AppMethodBeat.o(72556);
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
          AppMethodBeat.o(72556);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72556);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cji localcji = (cji)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72556);
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
            localcji.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72556);
          return 0;
        case 2: 
          localcji.nWx = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(72556);
          return 0;
        case 3: 
          localcji.nWy = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72556);
          return 0;
        case 4: 
          localcji.Fxi = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72556);
          return 0;
        case 5: 
          localcji.hhs = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72556);
          return 0;
        case 6: 
          localcji.Fxj = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72556);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new qm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((qm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcji.Fxk = ((qm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72556);
          return 0;
        case 8: 
          localcji.Fxl = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72556);
          return 0;
        case 9: 
          localcji.vwo = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72556);
          return 0;
        case 10: 
          localcji.cZz = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72556);
          return 0;
        case 11: 
          localcji.Fxm = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72556);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new diz();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((diz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcji.Fxn = ((diz)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72556);
        return 0;
      }
      AppMethodBeat.o(72556);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cji
 * JD-Core Version:    0.7.0.1
 */