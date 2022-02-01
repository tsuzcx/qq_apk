package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ls
  extends cqk
{
  public int DZA;
  public int DZB;
  public long DZC;
  public int DZK;
  public String DZL;
  public String DZM;
  public String DZN;
  public GoodsObject DZO;
  public boolean DZP = false;
  public int DZQ;
  public String djr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124395);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(124395);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.DZK);
      if (this.DZL != null) {
        paramVarArgs.d(3, this.DZL);
      }
      if (this.DZM != null) {
        paramVarArgs.d(4, this.DZM);
      }
      if (this.djr != null) {
        paramVarArgs.d(7, this.djr);
      }
      if (this.DZN != null) {
        paramVarArgs.d(8, this.DZN);
      }
      if (this.DZO != null)
      {
        paramVarArgs.ln(9, this.DZO.computeSize());
        this.DZO.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(10, this.DZA);
      paramVarArgs.aO(11, this.DZC);
      paramVarArgs.aR(12, this.DZB);
      paramVarArgs.bl(13, this.DZP);
      paramVarArgs.aR(50, this.DZQ);
      AppMethodBeat.o(124395);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1082;
      }
    }
    label1082:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.DZK);
      paramInt = i;
      if (this.DZL != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.DZL);
      }
      i = paramInt;
      if (this.DZM != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.DZM);
      }
      paramInt = i;
      if (this.djr != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.djr);
      }
      i = paramInt;
      if (this.DZN != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.DZN);
      }
      paramInt = i;
      if (this.DZO != null) {
        paramInt = i + f.a.a.a.lm(9, this.DZO.computeSize());
      }
      i = f.a.a.b.b.a.bx(10, this.DZA);
      int j = f.a.a.b.b.a.p(11, this.DZC);
      int k = f.a.a.b.b.a.bx(12, this.DZB);
      int m = f.a.a.b.b.a.fK(13);
      int n = f.a.a.b.b.a.bx(50, this.DZQ);
      AppMethodBeat.o(124395);
      return paramInt + i + j + k + (m + 1) + n;
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
          AppMethodBeat.o(124395);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124395);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ls localls = (ls)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124395);
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
            localls.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124395);
          return 0;
        case 2: 
          localls.DZK = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(124395);
          return 0;
        case 3: 
          localls.DZL = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(124395);
          return 0;
        case 4: 
          localls.DZM = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(124395);
          return 0;
        case 7: 
          localls.djr = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(124395);
          return 0;
        case 8: 
          localls.DZN = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(124395);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new GoodsObject();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((GoodsObject)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localls.DZO = ((GoodsObject)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124395);
          return 0;
        case 10: 
          localls.DZA = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(124395);
          return 0;
        case 11: 
          localls.DZC = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(124395);
          return 0;
        case 12: 
          localls.DZB = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(124395);
          return 0;
        case 13: 
          localls.DZP = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(124395);
          return 0;
        }
        localls.DZQ = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(124395);
        return 0;
      }
      AppMethodBeat.o(124395);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ls
 * JD-Core Version:    0.7.0.1
 */