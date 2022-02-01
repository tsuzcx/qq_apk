package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cxw
  extends dpc
{
  public String APx;
  public String MCI;
  public cxz MCM;
  public LinkedList<cxw> MCN;
  public int MCO;
  public String type;
  
  public cxw()
  {
    AppMethodBeat.i(117539);
    this.MCN = new LinkedList();
    AppMethodBeat.o(117539);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117540);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.MCM != null)
      {
        paramVarArgs.ni(2, this.MCM.computeSize());
        this.MCM.writeFields(paramVarArgs);
      }
      if (this.MCI != null) {
        paramVarArgs.e(3, this.MCI);
      }
      if (this.APx != null) {
        paramVarArgs.e(4, this.APx);
      }
      if (this.type != null) {
        paramVarArgs.e(5, this.type);
      }
      paramVarArgs.e(6, 8, this.MCN);
      paramVarArgs.aM(7, this.MCO);
      AppMethodBeat.o(117540);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label834;
      }
    }
    label834:
    for (int i = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.MCM != null) {
        paramInt = i + g.a.a.a.nh(2, this.MCM.computeSize());
      }
      i = paramInt;
      if (this.MCI != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.MCI);
      }
      paramInt = i;
      if (this.APx != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.APx);
      }
      i = paramInt;
      if (this.type != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.type);
      }
      paramInt = g.a.a.a.c(6, 8, this.MCN);
      int j = g.a.a.b.b.a.bu(7, this.MCO);
      AppMethodBeat.o(117540);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.MCN.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(117540);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cxw localcxw = (cxw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117540);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcxw.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117540);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxz();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxz)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcxw.MCM = ((cxz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117540);
          return 0;
        case 3: 
          localcxw.MCI = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(117540);
          return 0;
        case 4: 
          localcxw.APx = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(117540);
          return 0;
        case 5: 
          localcxw.type = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(117540);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxw();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxw)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcxw.MCN.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117540);
          return 0;
        }
        localcxw.MCO = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(117540);
        return 0;
      }
      AppMethodBeat.o(117540);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cxw
 * JD-Core Version:    0.7.0.1
 */