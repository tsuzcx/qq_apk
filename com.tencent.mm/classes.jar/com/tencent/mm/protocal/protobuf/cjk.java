package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cjk
  extends cqk
{
  public String DKT;
  public dhy EOc;
  public cqw EZC;
  public long EZG;
  public long Eub;
  public String drM;
  public int lRv;
  public String nVJ;
  public int nWx;
  public String nWy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72558);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72558);
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
      if (this.DKT != null) {
        paramVarArgs.d(4, this.DKT);
      }
      paramVarArgs.aO(5, this.EZG);
      paramVarArgs.aO(6, this.Eub);
      if (this.EZC != null)
      {
        paramVarArgs.ln(7, this.EZC.computeSize());
        this.EZC.writeFields(paramVarArgs);
      }
      if (this.EOc != null)
      {
        paramVarArgs.ln(8, this.EOc.computeSize());
        this.EOc.writeFields(paramVarArgs);
      }
      if (this.nVJ != null) {
        paramVarArgs.d(9, this.nVJ);
      }
      paramVarArgs.aR(10, this.lRv);
      if (this.drM != null) {
        paramVarArgs.d(11, this.drM);
      }
      AppMethodBeat.o(72558);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1094;
      }
    }
    label1094:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.nWx);
      paramInt = i;
      if (this.nWy != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nWy);
      }
      i = paramInt;
      if (this.DKT != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.DKT);
      }
      i = i + f.a.a.b.b.a.p(5, this.EZG) + f.a.a.b.b.a.p(6, this.Eub);
      paramInt = i;
      if (this.EZC != null) {
        paramInt = i + f.a.a.a.lm(7, this.EZC.computeSize());
      }
      i = paramInt;
      if (this.EOc != null) {
        i = paramInt + f.a.a.a.lm(8, this.EOc.computeSize());
      }
      paramInt = i;
      if (this.nVJ != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.nVJ);
      }
      i = paramInt + f.a.a.b.b.a.bx(10, this.lRv);
      paramInt = i;
      if (this.drM != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.drM);
      }
      AppMethodBeat.o(72558);
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
          AppMethodBeat.o(72558);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72558);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cjk localcjk = (cjk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72558);
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
            localcjk.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72558);
          return 0;
        case 2: 
          localcjk.nWx = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(72558);
          return 0;
        case 3: 
          localcjk.nWy = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72558);
          return 0;
        case 4: 
          localcjk.DKT = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72558);
          return 0;
        case 5: 
          localcjk.EZG = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(72558);
          return 0;
        case 6: 
          localcjk.Eub = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(72558);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cqw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cqw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcjk.EZC = ((cqw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72558);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dhy();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dhy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcjk.EOc = ((dhy)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72558);
          return 0;
        case 9: 
          localcjk.nVJ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72558);
          return 0;
        case 10: 
          localcjk.lRv = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(72558);
          return 0;
        }
        localcjk.drM = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(72558);
        return 0;
      }
      AppMethodBeat.o(72558);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cjk
 * JD-Core Version:    0.7.0.1
 */