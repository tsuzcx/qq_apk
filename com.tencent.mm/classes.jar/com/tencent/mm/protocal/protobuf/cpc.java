package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class cpc
  extends esc
{
  public String Url;
  public String YIU;
  public int YIq;
  public String YRE;
  public int YVg;
  public String YYr;
  public gol aatT;
  public String aauc;
  public int aaud;
  public int aavT;
  public LinkedList<dzn> aavU;
  
  public cpc()
  {
    AppMethodBeat.i(56250);
    this.aavU = new LinkedList();
    AppMethodBeat.o(56250);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56251);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(56251);
        throw paramVarArgs;
      }
      if (this.aatT == null)
      {
        paramVarArgs = new b("Not all required fields were included: Buff");
        AppMethodBeat.o(56251);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.aavT);
      paramVarArgs.e(3, 8, this.aavU);
      paramVarArgs.bS(4, this.YIq);
      paramVarArgs.bS(5, this.YVg);
      if (this.aatT != null)
      {
        paramVarArgs.qD(6, this.aatT.computeSize());
        this.aatT.writeFields(paramVarArgs);
      }
      if (this.Url != null) {
        paramVarArgs.g(7, this.Url);
      }
      if (this.aauc != null) {
        paramVarArgs.g(8, this.aauc);
      }
      if (this.YRE != null) {
        paramVarArgs.g(9, this.YRE);
      }
      if (this.YIU != null) {
        paramVarArgs.g(10, this.YIU);
      }
      paramVarArgs.bS(11, this.aaud);
      if (this.YYr != null) {
        paramVarArgs.g(12, this.YYr);
      }
      AppMethodBeat.o(56251);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1116;
      }
    }
    label1116:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.aavT) + i.a.a.a.c(3, 8, this.aavU) + i.a.a.b.b.a.cJ(4, this.YIq) + i.a.a.b.b.a.cJ(5, this.YVg);
      paramInt = i;
      if (this.aatT != null) {
        paramInt = i + i.a.a.a.qC(6, this.aatT.computeSize());
      }
      i = paramInt;
      if (this.Url != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.Url);
      }
      paramInt = i;
      if (this.aauc != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.aauc);
      }
      i = paramInt;
      if (this.YRE != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.YRE);
      }
      paramInt = i;
      if (this.YIU != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.YIU);
      }
      i = paramInt + i.a.a.b.b.a.cJ(11, this.aaud);
      paramInt = i;
      if (this.YYr != null) {
        paramInt = i + i.a.a.b.b.a.h(12, this.YYr);
      }
      AppMethodBeat.o(56251);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aavU.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(56251);
          throw paramVarArgs;
        }
        if (this.aatT == null)
        {
          paramVarArgs = new b("Not all required fields were included: Buff");
          AppMethodBeat.o(56251);
          throw paramVarArgs;
        }
        AppMethodBeat.o(56251);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cpc localcpc = (cpc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56251);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kd)localObject2).parseFrom((byte[])localObject1);
            }
            localcpc.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(56251);
          return 0;
        case 2: 
          localcpc.aavT = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(56251);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dzn();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dzn)localObject2).parseFrom((byte[])localObject1);
            }
            localcpc.aavU.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(56251);
          return 0;
        case 4: 
          localcpc.YIq = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(56251);
          return 0;
        case 5: 
          localcpc.YVg = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(56251);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gol();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gol)localObject2).dg((byte[])localObject1);
            }
            localcpc.aatT = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(56251);
          return 0;
        case 7: 
          localcpc.Url = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(56251);
          return 0;
        case 8: 
          localcpc.aauc = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(56251);
          return 0;
        case 9: 
          localcpc.YRE = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(56251);
          return 0;
        case 10: 
          localcpc.YIU = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(56251);
          return 0;
        case 11: 
          localcpc.aaud = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(56251);
          return 0;
        }
        localcpc.YYr = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(56251);
        return 0;
      }
      AppMethodBeat.o(56251);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cpc
 * JD-Core Version:    0.7.0.1
 */