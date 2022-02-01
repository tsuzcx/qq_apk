package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class cxk
  extends dpc
{
  public int MBS;
  public int MBT;
  public String MBU;
  public String MBV;
  public int MBW;
  public int MBX;
  public int dDN;
  public String jTx;
  public String jTy;
  public String qwn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72539);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72539);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.dDN);
      if (this.qwn != null) {
        paramVarArgs.e(3, this.qwn);
      }
      paramVarArgs.aM(4, this.MBS);
      paramVarArgs.aM(5, this.MBT);
      if (this.jTx != null) {
        paramVarArgs.e(6, this.jTx);
      }
      if (this.jTy != null) {
        paramVarArgs.e(7, this.jTy);
      }
      if (this.MBU != null) {
        paramVarArgs.e(8, this.MBU);
      }
      if (this.MBV != null) {
        paramVarArgs.e(9, this.MBV);
      }
      paramVarArgs.aM(10, this.MBW);
      paramVarArgs.aM(11, this.MBX);
      AppMethodBeat.o(72539);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label890;
      }
    }
    label890:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.dDN);
      paramInt = i;
      if (this.qwn != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.qwn);
      }
      i = paramInt + g.a.a.b.b.a.bu(4, this.MBS) + g.a.a.b.b.a.bu(5, this.MBT);
      paramInt = i;
      if (this.jTx != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.jTx);
      }
      i = paramInt;
      if (this.jTy != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.jTy);
      }
      paramInt = i;
      if (this.MBU != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.MBU);
      }
      i = paramInt;
      if (this.MBV != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.MBV);
      }
      paramInt = g.a.a.b.b.a.bu(10, this.MBW);
      int j = g.a.a.b.b.a.bu(11, this.MBX);
      AppMethodBeat.o(72539);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
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
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cxk localcxk = (cxk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72539);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcxk.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72539);
          return 0;
        case 2: 
          localcxk.dDN = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(72539);
          return 0;
        case 3: 
          localcxk.qwn = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72539);
          return 0;
        case 4: 
          localcxk.MBS = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(72539);
          return 0;
        case 5: 
          localcxk.MBT = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(72539);
          return 0;
        case 6: 
          localcxk.jTx = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72539);
          return 0;
        case 7: 
          localcxk.jTy = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72539);
          return 0;
        case 8: 
          localcxk.MBU = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72539);
          return 0;
        case 9: 
          localcxk.MBV = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72539);
          return 0;
        case 10: 
          localcxk.MBW = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(72539);
          return 0;
        }
        localcxk.MBX = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(72539);
        return 0;
      }
      AppMethodBeat.o(72539);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cxk
 * JD-Core Version:    0.7.0.1
 */