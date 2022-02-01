package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class blq
  extends cvp
{
  public int FFN;
  public chc GFG;
  public LinkedList<cbf> GFM;
  public String GFN;
  public String GFO;
  public String GFP;
  public String GFQ;
  public String GFR;
  public LinkedList<ehk> GFS;
  public int GwK;
  public String duW;
  public String dxg;
  public String pkh;
  public int ret;
  public String url;
  
  public blq()
  {
    AppMethodBeat.i(123588);
    this.GFM = new LinkedList();
    this.GFS = new LinkedList();
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
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.ret);
      if (this.url != null) {
        paramVarArgs.d(3, this.url);
      }
      paramVarArgs.aS(4, this.GwK);
      if (this.dxg != null) {
        paramVarArgs.d(5, this.dxg);
      }
      if (this.GFG != null)
      {
        paramVarArgs.lC(6, this.GFG.computeSize());
        this.GFG.writeFields(paramVarArgs);
      }
      paramVarArgs.e(7, 8, this.GFM);
      if (this.GFN != null) {
        paramVarArgs.d(8, this.GFN);
      }
      if (this.pkh != null) {
        paramVarArgs.d(9, this.pkh);
      }
      paramVarArgs.aS(10, this.FFN);
      if (this.duW != null) {
        paramVarArgs.d(11, this.duW);
      }
      if (this.GFO != null) {
        paramVarArgs.d(12, this.GFO);
      }
      if (this.GFP != null) {
        paramVarArgs.d(13, this.GFP);
      }
      if (this.GFQ != null) {
        paramVarArgs.d(14, this.GFQ);
      }
      if (this.GFR != null) {
        paramVarArgs.d(15, this.GFR);
      }
      paramVarArgs.e(16, 8, this.GFS);
      AppMethodBeat.o(123589);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1486;
      }
    }
    label1486:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.ret);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.url);
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.GwK);
      paramInt = i;
      if (this.dxg != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.dxg);
      }
      i = paramInt;
      if (this.GFG != null) {
        i = paramInt + f.a.a.a.lB(6, this.GFG.computeSize());
      }
      i += f.a.a.a.c(7, 8, this.GFM);
      paramInt = i;
      if (this.GFN != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.GFN);
      }
      i = paramInt;
      if (this.pkh != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.pkh);
      }
      i += f.a.a.b.b.a.bz(10, this.FFN);
      paramInt = i;
      if (this.duW != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.duW);
      }
      i = paramInt;
      if (this.GFO != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.GFO);
      }
      paramInt = i;
      if (this.GFP != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.GFP);
      }
      i = paramInt;
      if (this.GFQ != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.GFQ);
      }
      paramInt = i;
      if (this.GFR != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.GFR);
      }
      i = f.a.a.a.c(16, 8, this.GFS);
      AppMethodBeat.o(123589);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GFM.clear();
        this.GFS.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
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
        blq localblq = (blq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123589);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localblq.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123589);
          return 0;
        case 2: 
          localblq.ret = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(123589);
          return 0;
        case 3: 
          localblq.url = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123589);
          return 0;
        case 4: 
          localblq.GwK = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(123589);
          return 0;
        case 5: 
          localblq.dxg = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123589);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new chc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((chc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localblq.GFG = ((chc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123589);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cbf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cbf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localblq.GFM.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123589);
          return 0;
        case 8: 
          localblq.GFN = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123589);
          return 0;
        case 9: 
          localblq.pkh = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123589);
          return 0;
        case 10: 
          localblq.FFN = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(123589);
          return 0;
        case 11: 
          localblq.duW = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123589);
          return 0;
        case 12: 
          localblq.GFO = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123589);
          return 0;
        case 13: 
          localblq.GFP = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123589);
          return 0;
        case 14: 
          localblq.GFQ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123589);
          return 0;
        case 15: 
          localblq.GFR = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123589);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ehk();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ehk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localblq.GFS.add(localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.blq
 * JD-Core Version:    0.7.0.1
 */