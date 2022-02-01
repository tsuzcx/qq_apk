package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bip
  extends dop
{
  public String KCy;
  public int KCz;
  public ei LSI;
  public String appId;
  public String dmc;
  public String extend;
  public String sign;
  public String wPN;
  public String wPO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32219);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.appId != null) {
        paramVarArgs.e(2, this.appId);
      }
      if (this.wPN != null) {
        paramVarArgs.e(3, this.wPN);
      }
      if (this.wPO != null) {
        paramVarArgs.e(4, this.wPO);
      }
      if (this.extend != null) {
        paramVarArgs.e(5, this.extend);
      }
      if (this.dmc != null) {
        paramVarArgs.e(6, this.dmc);
      }
      if (this.sign != null) {
        paramVarArgs.e(7, this.sign);
      }
      if (this.LSI != null)
      {
        paramVarArgs.ni(8, this.LSI.computeSize());
        this.LSI.writeFields(paramVarArgs);
      }
      if (this.KCy != null) {
        paramVarArgs.e(9, this.KCy);
      }
      paramVarArgs.aM(10, this.KCz);
      AppMethodBeat.o(32219);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label954;
      }
    }
    label954:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.appId != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.appId);
      }
      i = paramInt;
      if (this.wPN != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.wPN);
      }
      paramInt = i;
      if (this.wPO != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.wPO);
      }
      i = paramInt;
      if (this.extend != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.extend);
      }
      paramInt = i;
      if (this.dmc != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.dmc);
      }
      i = paramInt;
      if (this.sign != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.sign);
      }
      paramInt = i;
      if (this.LSI != null) {
        paramInt = i + g.a.a.a.nh(8, this.LSI.computeSize());
      }
      i = paramInt;
      if (this.KCy != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.KCy);
      }
      paramInt = g.a.a.b.b.a.bu(10, this.KCz);
      AppMethodBeat.o(32219);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(32219);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bip localbip = (bip)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32219);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbip.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32219);
          return 0;
        case 2: 
          localbip.appId = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32219);
          return 0;
        case 3: 
          localbip.wPN = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32219);
          return 0;
        case 4: 
          localbip.wPO = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32219);
          return 0;
        case 5: 
          localbip.extend = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32219);
          return 0;
        case 6: 
          localbip.dmc = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32219);
          return 0;
        case 7: 
          localbip.sign = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32219);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ei();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ei)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbip.LSI = ((ei)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32219);
          return 0;
        case 9: 
          localbip.KCy = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32219);
          return 0;
        }
        localbip.KCz = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(32219);
        return 0;
      }
      AppMethodBeat.o(32219);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bip
 * JD-Core Version:    0.7.0.1
 */