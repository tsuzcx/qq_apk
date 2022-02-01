package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class beh
  extends cqk
{
  public LinkedList<bjm> ETN;
  public String ETO;
  public int ETP;
  public LinkedList<String> ETQ;
  public int ETR;
  public long ETS;
  public int dae;
  public String oxf;
  public String ulf;
  
  public beh()
  {
    AppMethodBeat.i(91512);
    this.dae = 0;
    this.oxf = "ok";
    this.ETN = new LinkedList();
    this.ETQ = new LinkedList();
    AppMethodBeat.o(91512);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91513);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91513);
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
      paramVarArgs.e(4, 8, this.ETN);
      if (this.ETO != null) {
        paramVarArgs.d(5, this.ETO);
      }
      paramVarArgs.aR(6, this.ETP);
      if (this.ulf != null) {
        paramVarArgs.d(7, this.ulf);
      }
      paramVarArgs.e(8, 1, this.ETQ);
      paramVarArgs.aR(9, this.ETR);
      paramVarArgs.aO(10, this.ETS);
      AppMethodBeat.o(91513);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label926;
      }
    }
    label926:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.dae);
      paramInt = i;
      if (this.oxf != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.oxf);
      }
      i = paramInt + f.a.a.a.c(4, 8, this.ETN);
      paramInt = i;
      if (this.ETO != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.ETO);
      }
      i = paramInt + f.a.a.b.b.a.bx(6, this.ETP);
      paramInt = i;
      if (this.ulf != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.ulf);
      }
      i = f.a.a.a.c(8, 1, this.ETQ);
      int j = f.a.a.b.b.a.bx(9, this.ETR);
      int k = f.a.a.b.b.a.p(10, this.ETS);
      AppMethodBeat.o(91513);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ETN.clear();
        this.ETQ.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91513);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91513);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        beh localbeh = (beh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91513);
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
            localbeh.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91513);
          return 0;
        case 2: 
          localbeh.dae = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91513);
          return 0;
        case 3: 
          localbeh.oxf = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91513);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bjm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bjm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbeh.ETN.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91513);
          return 0;
        case 5: 
          localbeh.ETO = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91513);
          return 0;
        case 6: 
          localbeh.ETP = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91513);
          return 0;
        case 7: 
          localbeh.ulf = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91513);
          return 0;
        case 8: 
          localbeh.ETQ.add(((f.a.a.a.a)localObject1).LVo.readString());
          AppMethodBeat.o(91513);
          return 0;
        case 9: 
          localbeh.ETR = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91513);
          return 0;
        }
        localbeh.ETS = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(91513);
        return 0;
      }
      AppMethodBeat.o(91513);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.beh
 * JD-Core Version:    0.7.0.1
 */