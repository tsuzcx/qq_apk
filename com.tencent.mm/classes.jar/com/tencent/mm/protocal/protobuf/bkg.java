package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bkg
  extends dpc
{
  public boolean LTt;
  public int LTu;
  public int LTv;
  public un LTw;
  public boolean LTx;
  public int pTZ;
  public String pUa;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114007);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(114007);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.pTZ);
      if (this.pUa != null) {
        paramVarArgs.e(3, this.pUa);
      }
      paramVarArgs.cc(4, this.LTt);
      paramVarArgs.aM(5, this.LTu);
      paramVarArgs.aM(6, this.LTv);
      if (this.LTw != null)
      {
        paramVarArgs.ni(7, this.LTw.computeSize());
        this.LTw.writeFields(paramVarArgs);
      }
      paramVarArgs.cc(8, this.LTx);
      AppMethodBeat.o(114007);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label790;
      }
    }
    label790:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.pTZ);
      paramInt = i;
      if (this.pUa != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.pUa);
      }
      i = paramInt + (g.a.a.b.b.a.fS(4) + 1) + g.a.a.b.b.a.bu(5, this.LTu) + g.a.a.b.b.a.bu(6, this.LTv);
      paramInt = i;
      if (this.LTw != null) {
        paramInt = i + g.a.a.a.nh(7, this.LTw.computeSize());
      }
      i = g.a.a.b.b.a.fS(8);
      AppMethodBeat.o(114007);
      return paramInt + (i + 1);
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
          AppMethodBeat.o(114007);
          throw paramVarArgs;
        }
        AppMethodBeat.o(114007);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bkg localbkg = (bkg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114007);
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
            localbkg.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114007);
          return 0;
        case 2: 
          localbkg.pTZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(114007);
          return 0;
        case 3: 
          localbkg.pUa = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(114007);
          return 0;
        case 4: 
          localbkg.LTt = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(114007);
          return 0;
        case 5: 
          localbkg.LTu = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(114007);
          return 0;
        case 6: 
          localbkg.LTv = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(114007);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new un();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((un)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbkg.LTw = ((un)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114007);
          return 0;
        }
        localbkg.LTx = ((g.a.a.a.a)localObject1).UbS.yZ();
        AppMethodBeat.o(114007);
        return 0;
      }
      AppMethodBeat.o(114007);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bkg
 * JD-Core Version:    0.7.0.1
 */