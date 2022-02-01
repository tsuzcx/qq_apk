package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class wx
  extends dpc
{
  public int CpN;
  public String Cxg;
  public String Cxh;
  public String LhU;
  public boolean LhV;
  public int dDN;
  public String qwn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72449);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72449);
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
      if (this.LhU != null) {
        paramVarArgs.e(4, this.LhU);
      }
      if (this.Cxg != null) {
        paramVarArgs.e(5, this.Cxg);
      }
      paramVarArgs.cc(6, this.LhV);
      if (this.Cxh != null) {
        paramVarArgs.e(7, this.Cxh);
      }
      paramVarArgs.aM(8, this.CpN);
      AppMethodBeat.o(72449);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label734;
      }
    }
    label734:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.dDN);
      paramInt = i;
      if (this.qwn != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.qwn);
      }
      i = paramInt;
      if (this.LhU != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.LhU);
      }
      paramInt = i;
      if (this.Cxg != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.Cxg);
      }
      i = paramInt + (g.a.a.b.b.a.fS(6) + 1);
      paramInt = i;
      if (this.Cxh != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.Cxh);
      }
      i = g.a.a.b.b.a.bu(8, this.CpN);
      AppMethodBeat.o(72449);
      return paramInt + i;
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
          AppMethodBeat.o(72449);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72449);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        wx localwx = (wx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72449);
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
            localwx.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72449);
          return 0;
        case 2: 
          localwx.dDN = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(72449);
          return 0;
        case 3: 
          localwx.qwn = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72449);
          return 0;
        case 4: 
          localwx.LhU = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72449);
          return 0;
        case 5: 
          localwx.Cxg = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72449);
          return 0;
        case 6: 
          localwx.LhV = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(72449);
          return 0;
        case 7: 
          localwx.Cxh = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72449);
          return 0;
        }
        localwx.CpN = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(72449);
        return 0;
      }
      AppMethodBeat.o(72449);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.wx
 * JD-Core Version:    0.7.0.1
 */