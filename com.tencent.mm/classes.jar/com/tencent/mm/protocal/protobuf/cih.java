package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cih
  extends cqk
{
  public int Exf;
  public long Exg;
  public int Fwo;
  public int Fwq;
  public int Fwr;
  public int pAG;
  public String pAH;
  public int tIL;
  public String tIM;
  public int tJa;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32391);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32391);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(3, this.Exf);
      paramVarArgs.aO(4, this.Exg);
      paramVarArgs.aR(5, this.Fwq);
      paramVarArgs.aR(6, this.Fwo);
      paramVarArgs.aR(7, this.tJa);
      paramVarArgs.aR(8, this.Fwr);
      paramVarArgs.aR(9, this.pAG);
      if (this.pAH != null) {
        paramVarArgs.d(10, this.pAH);
      }
      paramVarArgs.aR(11, this.tIL);
      if (this.tIM != null) {
        paramVarArgs.d(12, this.tIM);
      }
      AppMethodBeat.o(32391);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label855;
      }
    }
    label855:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(3, this.Exf) + f.a.a.b.b.a.p(4, this.Exg) + f.a.a.b.b.a.bx(5, this.Fwq) + f.a.a.b.b.a.bx(6, this.Fwo) + f.a.a.b.b.a.bx(7, this.tJa) + f.a.a.b.b.a.bx(8, this.Fwr) + f.a.a.b.b.a.bx(9, this.pAG);
      paramInt = i;
      if (this.pAH != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.pAH);
      }
      i = paramInt + f.a.a.b.b.a.bx(11, this.tIL);
      paramInt = i;
      if (this.tIM != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.tIM);
      }
      AppMethodBeat.o(32391);
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
          AppMethodBeat.o(32391);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32391);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cih localcih = (cih)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 2: 
        default: 
          AppMethodBeat.o(32391);
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
            localcih.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32391);
          return 0;
        case 3: 
          localcih.Exf = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32391);
          return 0;
        case 4: 
          localcih.Exg = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(32391);
          return 0;
        case 5: 
          localcih.Fwq = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32391);
          return 0;
        case 6: 
          localcih.Fwo = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32391);
          return 0;
        case 7: 
          localcih.tJa = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32391);
          return 0;
        case 8: 
          localcih.Fwr = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32391);
          return 0;
        case 9: 
          localcih.pAG = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32391);
          return 0;
        case 10: 
          localcih.pAH = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32391);
          return 0;
        case 11: 
          localcih.tIL = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32391);
          return 0;
        }
        localcih.tIM = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(32391);
        return 0;
      }
      AppMethodBeat.o(32391);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cih
 * JD-Core Version:    0.7.0.1
 */