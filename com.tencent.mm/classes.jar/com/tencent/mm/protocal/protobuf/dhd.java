package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dhd
  extends dpc
{
  public String KBN;
  public eig LUW;
  public long LpD;
  public dpp MhF;
  public long MhJ;
  public String icon;
  public int nHh;
  public int pTZ;
  public String pTn;
  public String pUa;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72558);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72558);
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
      if (this.KBN != null) {
        paramVarArgs.e(4, this.KBN);
      }
      paramVarArgs.bb(5, this.MhJ);
      paramVarArgs.bb(6, this.LpD);
      if (this.MhF != null)
      {
        paramVarArgs.ni(7, this.MhF.computeSize());
        this.MhF.writeFields(paramVarArgs);
      }
      if (this.LUW != null)
      {
        paramVarArgs.ni(8, this.LUW.computeSize());
        this.LUW.writeFields(paramVarArgs);
      }
      if (this.pTn != null) {
        paramVarArgs.e(9, this.pTn);
      }
      paramVarArgs.aM(10, this.nHh);
      if (this.icon != null) {
        paramVarArgs.e(11, this.icon);
      }
      AppMethodBeat.o(72558);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1094;
      }
    }
    label1094:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.pTZ);
      paramInt = i;
      if (this.pUa != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.pUa);
      }
      i = paramInt;
      if (this.KBN != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.KBN);
      }
      i = i + g.a.a.b.b.a.r(5, this.MhJ) + g.a.a.b.b.a.r(6, this.LpD);
      paramInt = i;
      if (this.MhF != null) {
        paramInt = i + g.a.a.a.nh(7, this.MhF.computeSize());
      }
      i = paramInt;
      if (this.LUW != null) {
        i = paramInt + g.a.a.a.nh(8, this.LUW.computeSize());
      }
      paramInt = i;
      if (this.pTn != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.pTn);
      }
      i = paramInt + g.a.a.b.b.a.bu(10, this.nHh);
      paramInt = i;
      if (this.icon != null) {
        paramInt = i + g.a.a.b.b.a.f(11, this.icon);
      }
      AppMethodBeat.o(72558);
      return paramInt;
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
          AppMethodBeat.o(72558);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72558);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dhd localdhd = (dhd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72558);
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
            localdhd.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72558);
          return 0;
        case 2: 
          localdhd.pTZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(72558);
          return 0;
        case 3: 
          localdhd.pUa = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72558);
          return 0;
        case 4: 
          localdhd.KBN = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72558);
          return 0;
        case 5: 
          localdhd.MhJ = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(72558);
          return 0;
        case 6: 
          localdhd.LpD = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(72558);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dpp();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dpp)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdhd.MhF = ((dpp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72558);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eig();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eig)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdhd.LUW = ((eig)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72558);
          return 0;
        case 9: 
          localdhd.pTn = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72558);
          return 0;
        case 10: 
          localdhd.nHh = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(72558);
          return 0;
        }
        localdhd.icon = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(72558);
        return 0;
      }
      AppMethodBeat.o(72558);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dhd
 * JD-Core Version:    0.7.0.1
 */