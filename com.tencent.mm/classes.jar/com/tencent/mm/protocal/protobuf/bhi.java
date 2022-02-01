package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bhi
  extends cqk
{
  public int ENG;
  public ccl EWj;
  public LinkedList<bwp> EWp;
  public String EWq;
  public String EWr;
  public String EWs;
  public String EWt;
  public String EWu;
  public LinkedList<ebg> EWv;
  public int Eae;
  public String djj;
  public String dlt;
  public String oGD;
  public int ret;
  public String url;
  
  public bhi()
  {
    AppMethodBeat.i(123588);
    this.EWp = new LinkedList();
    this.EWv = new LinkedList();
    AppMethodBeat.o(123588);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123589);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(123589);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.ret);
      if (this.url != null) {
        paramVarArgs.d(3, this.url);
      }
      paramVarArgs.aR(4, this.ENG);
      if (this.dlt != null) {
        paramVarArgs.d(5, this.dlt);
      }
      if (this.EWj != null)
      {
        paramVarArgs.ln(6, this.EWj.computeSize());
        this.EWj.writeFields(paramVarArgs);
      }
      paramVarArgs.e(7, 8, this.EWp);
      if (this.EWq != null) {
        paramVarArgs.d(8, this.EWq);
      }
      if (this.oGD != null) {
        paramVarArgs.d(9, this.oGD);
      }
      paramVarArgs.aR(10, this.Eae);
      if (this.djj != null) {
        paramVarArgs.d(11, this.djj);
      }
      if (this.EWr != null) {
        paramVarArgs.d(12, this.EWr);
      }
      if (this.EWs != null) {
        paramVarArgs.d(13, this.EWs);
      }
      if (this.EWt != null) {
        paramVarArgs.d(14, this.EWt);
      }
      if (this.EWu != null) {
        paramVarArgs.d(15, this.EWu);
      }
      paramVarArgs.e(16, 8, this.EWv);
      AppMethodBeat.o(123589);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1486;
      }
    }
    label1486:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.ret);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.url);
      }
      i = paramInt + f.a.a.b.b.a.bx(4, this.ENG);
      paramInt = i;
      if (this.dlt != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.dlt);
      }
      i = paramInt;
      if (this.EWj != null) {
        i = paramInt + f.a.a.a.lm(6, this.EWj.computeSize());
      }
      i += f.a.a.a.c(7, 8, this.EWp);
      paramInt = i;
      if (this.EWq != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.EWq);
      }
      i = paramInt;
      if (this.oGD != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.oGD);
      }
      i += f.a.a.b.b.a.bx(10, this.Eae);
      paramInt = i;
      if (this.djj != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.djj);
      }
      i = paramInt;
      if (this.EWr != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.EWr);
      }
      paramInt = i;
      if (this.EWs != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.EWs);
      }
      i = paramInt;
      if (this.EWt != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.EWt);
      }
      paramInt = i;
      if (this.EWu != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.EWu);
      }
      i = f.a.a.a.c(16, 8, this.EWv);
      AppMethodBeat.o(123589);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EWp.clear();
        this.EWv.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(123589);
          throw paramVarArgs;
        }
        AppMethodBeat.o(123589);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bhi localbhi = (bhi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123589);
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
            localbhi.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123589);
          return 0;
        case 2: 
          localbhi.ret = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(123589);
          return 0;
        case 3: 
          localbhi.url = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123589);
          return 0;
        case 4: 
          localbhi.ENG = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(123589);
          return 0;
        case 5: 
          localbhi.dlt = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123589);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ccl();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ccl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbhi.EWj = ((ccl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123589);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bwp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbhi.EWp.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123589);
          return 0;
        case 8: 
          localbhi.EWq = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123589);
          return 0;
        case 9: 
          localbhi.oGD = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123589);
          return 0;
        case 10: 
          localbhi.Eae = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(123589);
          return 0;
        case 11: 
          localbhi.djj = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123589);
          return 0;
        case 12: 
          localbhi.EWr = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123589);
          return 0;
        case 13: 
          localbhi.EWs = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123589);
          return 0;
        case 14: 
          localbhi.EWt = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123589);
          return 0;
        case 15: 
          localbhi.EWu = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123589);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ebg();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ebg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbhi.EWv.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(123589);
        return 0;
      }
      AppMethodBeat.o(123589);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bhi
 * JD-Core Version:    0.7.0.1
 */