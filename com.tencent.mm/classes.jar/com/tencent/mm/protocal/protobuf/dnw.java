package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dnw
  extends cqk
{
  public int CreateTime;
  public String DRb;
  public int Eck;
  public int Eed;
  public int EfV;
  public int EhF;
  public int EvW;
  public int hNR;
  public String tlJ;
  public String tlK;
  public int vTO;
  public long vTQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(148662);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(148662);
        throw paramVarArgs;
      }
      if (this.tlK != null) {
        paramVarArgs.d(1, this.tlK);
      }
      if (this.tlJ != null) {
        paramVarArgs.d(2, this.tlJ);
      }
      paramVarArgs.aR(3, this.EfV);
      paramVarArgs.aR(4, this.Eck);
      paramVarArgs.aR(5, this.CreateTime);
      if (this.DRb != null) {
        paramVarArgs.d(6, this.DRb);
      }
      paramVarArgs.aR(7, this.vTO);
      paramVarArgs.aR(8, this.Eed);
      paramVarArgs.aR(9, this.hNR);
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(10, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(11, this.EvW);
      paramVarArgs.aO(12, this.vTQ);
      paramVarArgs.aR(13, this.EhF);
      AppMethodBeat.o(148662);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tlK == null) {
        break label946;
      }
    }
    label946:
    for (paramInt = f.a.a.b.b.a.e(1, this.tlK) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.tlJ != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.tlJ);
      }
      i = i + f.a.a.b.b.a.bx(3, this.EfV) + f.a.a.b.b.a.bx(4, this.Eck) + f.a.a.b.b.a.bx(5, this.CreateTime);
      paramInt = i;
      if (this.DRb != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.DRb);
      }
      i = paramInt + f.a.a.b.b.a.bx(7, this.vTO) + f.a.a.b.b.a.bx(8, this.Eed) + f.a.a.b.b.a.bx(9, this.hNR);
      paramInt = i;
      if (this.BaseResponse != null) {
        paramInt = i + f.a.a.a.lm(10, this.BaseResponse.computeSize());
      }
      i = f.a.a.b.b.a.bx(11, this.EvW);
      int j = f.a.a.b.b.a.p(12, this.vTQ);
      int k = f.a.a.b.b.a.bx(13, this.EhF);
      AppMethodBeat.o(148662);
      return paramInt + i + j + k;
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
          AppMethodBeat.o(148662);
          throw paramVarArgs;
        }
        AppMethodBeat.o(148662);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dnw localdnw = (dnw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(148662);
          return -1;
        case 1: 
          localdnw.tlK = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(148662);
          return 0;
        case 2: 
          localdnw.tlJ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(148662);
          return 0;
        case 3: 
          localdnw.EfV = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(148662);
          return 0;
        case 4: 
          localdnw.Eck = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(148662);
          return 0;
        case 5: 
          localdnw.CreateTime = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(148662);
          return 0;
        case 6: 
          localdnw.DRb = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(148662);
          return 0;
        case 7: 
          localdnw.vTO = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(148662);
          return 0;
        case 8: 
          localdnw.Eed = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(148662);
          return 0;
        case 9: 
          localdnw.hNR = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(148662);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdnw.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(148662);
          return 0;
        case 11: 
          localdnw.EvW = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(148662);
          return 0;
        case 12: 
          localdnw.vTQ = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(148662);
          return 0;
        }
        localdnw.EhF = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(148662);
        return 0;
      }
      AppMethodBeat.o(148662);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dnw
 * JD-Core Version:    0.7.0.1
 */