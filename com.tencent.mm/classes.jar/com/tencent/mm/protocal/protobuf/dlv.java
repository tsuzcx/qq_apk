package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dlv
  extends dpc
{
  public String AOk;
  public String HuS;
  public int MJd;
  public boolean MPt;
  public boolean MPu;
  public String MPv;
  public String MPw;
  public String MPx;
  public String MPy;
  public ckj efB;
  public int pTZ;
  public String pUa;
  public int status;
  public String ynT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91666);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91666);
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
      paramVarArgs.cc(4, this.MPt);
      paramVarArgs.cc(5, this.MPu);
      paramVarArgs.aM(6, this.status);
      if (this.MPv != null) {
        paramVarArgs.e(7, this.MPv);
      }
      if (this.MPw != null) {
        paramVarArgs.e(8, this.MPw);
      }
      paramVarArgs.aM(9, this.MJd);
      if (this.ynT != null) {
        paramVarArgs.e(10, this.ynT);
      }
      if (this.AOk != null) {
        paramVarArgs.e(11, this.AOk);
      }
      if (this.MPx != null) {
        paramVarArgs.e(12, this.MPx);
      }
      if (this.MPy != null) {
        paramVarArgs.e(13, this.MPy);
      }
      if (this.efB != null)
      {
        paramVarArgs.ni(99, this.efB.computeSize());
        this.efB.writeFields(paramVarArgs);
      }
      if (this.HuS != null) {
        paramVarArgs.e(100, this.HuS);
      }
      AppMethodBeat.o(91666);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1282;
      }
    }
    label1282:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.pTZ);
      paramInt = i;
      if (this.pUa != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.pUa);
      }
      i = paramInt + (g.a.a.b.b.a.fS(4) + 1) + (g.a.a.b.b.a.fS(5) + 1) + g.a.a.b.b.a.bu(6, this.status);
      paramInt = i;
      if (this.MPv != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.MPv);
      }
      i = paramInt;
      if (this.MPw != null) {
        i = paramInt + g.a.a.b.b.a.f(8, this.MPw);
      }
      i += g.a.a.b.b.a.bu(9, this.MJd);
      paramInt = i;
      if (this.ynT != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.ynT);
      }
      i = paramInt;
      if (this.AOk != null) {
        i = paramInt + g.a.a.b.b.a.f(11, this.AOk);
      }
      paramInt = i;
      if (this.MPx != null) {
        paramInt = i + g.a.a.b.b.a.f(12, this.MPx);
      }
      i = paramInt;
      if (this.MPy != null) {
        i = paramInt + g.a.a.b.b.a.f(13, this.MPy);
      }
      paramInt = i;
      if (this.efB != null) {
        paramInt = i + g.a.a.a.nh(99, this.efB.computeSize());
      }
      i = paramInt;
      if (this.HuS != null) {
        i = paramInt + g.a.a.b.b.a.f(100, this.HuS);
      }
      AppMethodBeat.o(91666);
      return i;
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
          AppMethodBeat.o(91666);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91666);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dlv localdlv = (dlv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91666);
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
            localdlv.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91666);
          return 0;
        case 2: 
          localdlv.pTZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91666);
          return 0;
        case 3: 
          localdlv.pUa = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91666);
          return 0;
        case 4: 
          localdlv.MPt = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(91666);
          return 0;
        case 5: 
          localdlv.MPu = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(91666);
          return 0;
        case 6: 
          localdlv.status = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91666);
          return 0;
        case 7: 
          localdlv.MPv = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91666);
          return 0;
        case 8: 
          localdlv.MPw = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91666);
          return 0;
        case 9: 
          localdlv.MJd = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91666);
          return 0;
        case 10: 
          localdlv.ynT = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91666);
          return 0;
        case 11: 
          localdlv.AOk = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91666);
          return 0;
        case 12: 
          localdlv.MPx = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91666);
          return 0;
        case 13: 
          localdlv.MPy = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91666);
          return 0;
        case 99: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ckj();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ckj)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdlv.efB = ((ckj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91666);
          return 0;
        }
        localdlv.HuS = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91666);
        return 0;
      }
      AppMethodBeat.o(91666);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dlv
 * JD-Core Version:    0.7.0.1
 */