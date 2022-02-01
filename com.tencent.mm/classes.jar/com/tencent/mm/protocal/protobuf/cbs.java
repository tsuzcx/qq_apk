package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cbs
  extends cqk
{
  public int FpL;
  public int FpM;
  public String FpN;
  public String FpO;
  public int FpP;
  public int FpQ;
  public int dae;
  public String iAx;
  public String iAy;
  public String oxf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72539);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72539);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.dae);
      if (this.oxf != null) {
        paramVarArgs.d(3, this.oxf);
      }
      paramVarArgs.aR(4, this.FpL);
      paramVarArgs.aR(5, this.FpM);
      if (this.iAx != null) {
        paramVarArgs.d(6, this.iAx);
      }
      if (this.iAy != null) {
        paramVarArgs.d(7, this.iAy);
      }
      if (this.FpN != null) {
        paramVarArgs.d(8, this.FpN);
      }
      if (this.FpO != null) {
        paramVarArgs.d(9, this.FpO);
      }
      paramVarArgs.aR(10, this.FpP);
      paramVarArgs.aR(11, this.FpQ);
      AppMethodBeat.o(72539);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label890;
      }
    }
    label890:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.dae);
      paramInt = i;
      if (this.oxf != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.oxf);
      }
      i = paramInt + f.a.a.b.b.a.bx(4, this.FpL) + f.a.a.b.b.a.bx(5, this.FpM);
      paramInt = i;
      if (this.iAx != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.iAx);
      }
      i = paramInt;
      if (this.iAy != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.iAy);
      }
      paramInt = i;
      if (this.FpN != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.FpN);
      }
      i = paramInt;
      if (this.FpO != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.FpO);
      }
      paramInt = f.a.a.b.b.a.bx(10, this.FpP);
      int j = f.a.a.b.b.a.bx(11, this.FpQ);
      AppMethodBeat.o(72539);
      return i + paramInt + j;
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
          AppMethodBeat.o(72539);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72539);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cbs localcbs = (cbs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72539);
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
            localcbs.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72539);
          return 0;
        case 2: 
          localcbs.dae = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(72539);
          return 0;
        case 3: 
          localcbs.oxf = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72539);
          return 0;
        case 4: 
          localcbs.FpL = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(72539);
          return 0;
        case 5: 
          localcbs.FpM = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(72539);
          return 0;
        case 6: 
          localcbs.iAx = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72539);
          return 0;
        case 7: 
          localcbs.iAy = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72539);
          return 0;
        case 8: 
          localcbs.FpN = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72539);
          return 0;
        case 9: 
          localcbs.FpO = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72539);
          return 0;
        case 10: 
          localcbs.FpP = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(72539);
          return 0;
        }
        localcbs.FpQ = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(72539);
        return 0;
      }
      AppMethodBeat.o(72539);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cbs
 * JD-Core Version:    0.7.0.1
 */