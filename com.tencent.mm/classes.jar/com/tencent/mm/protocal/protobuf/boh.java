package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class boh
  extends dpc
{
  public String HHX;
  public boolean HHY;
  public String HHZ;
  public String HIa;
  public String HIb;
  public String HIc;
  public String HId;
  public String HIe;
  public boolean HIg;
  public LinkedList<cbg> LWw;
  public int dDN;
  public String qwn;
  
  public boh()
  {
    AppMethodBeat.i(72486);
    this.dDN = 0;
    this.qwn = "ok";
    this.LWw = new LinkedList();
    AppMethodBeat.o(72486);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72487);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72487);
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
      if (this.HHX != null) {
        paramVarArgs.e(4, this.HHX);
      }
      paramVarArgs.cc(6, this.HHY);
      if (this.HHZ != null) {
        paramVarArgs.e(7, this.HHZ);
      }
      if (this.HIa != null) {
        paramVarArgs.e(8, this.HIa);
      }
      if (this.HIb != null) {
        paramVarArgs.e(9, this.HIb);
      }
      if (this.HIc != null) {
        paramVarArgs.e(10, this.HIc);
      }
      if (this.HId != null) {
        paramVarArgs.e(11, this.HId);
      }
      if (this.HIe != null) {
        paramVarArgs.e(12, this.HIe);
      }
      paramVarArgs.e(13, 8, this.LWw);
      paramVarArgs.cc(14, this.HIg);
      AppMethodBeat.o(72487);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1130;
      }
    }
    label1130:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.dDN);
      paramInt = i;
      if (this.qwn != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.qwn);
      }
      i = paramInt;
      if (this.HHX != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.HHX);
      }
      i += g.a.a.b.b.a.fS(6) + 1;
      paramInt = i;
      if (this.HHZ != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.HHZ);
      }
      i = paramInt;
      if (this.HIa != null) {
        i = paramInt + g.a.a.b.b.a.f(8, this.HIa);
      }
      paramInt = i;
      if (this.HIb != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.HIb);
      }
      i = paramInt;
      if (this.HIc != null) {
        i = paramInt + g.a.a.b.b.a.f(10, this.HIc);
      }
      paramInt = i;
      if (this.HId != null) {
        paramInt = i + g.a.a.b.b.a.f(11, this.HId);
      }
      i = paramInt;
      if (this.HIe != null) {
        i = paramInt + g.a.a.b.b.a.f(12, this.HIe);
      }
      paramInt = g.a.a.a.c(13, 8, this.LWw);
      int j = g.a.a.b.b.a.fS(14);
      AppMethodBeat.o(72487);
      return i + paramInt + (j + 1);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LWw.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(72487);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72487);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        boh localboh = (boh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 5: 
        default: 
          AppMethodBeat.o(72487);
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
            localboh.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72487);
          return 0;
        case 2: 
          localboh.dDN = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(72487);
          return 0;
        case 3: 
          localboh.qwn = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72487);
          return 0;
        case 4: 
          localboh.HHX = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72487);
          return 0;
        case 6: 
          localboh.HHY = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(72487);
          return 0;
        case 7: 
          localboh.HHZ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72487);
          return 0;
        case 8: 
          localboh.HIa = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72487);
          return 0;
        case 9: 
          localboh.HIb = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72487);
          return 0;
        case 10: 
          localboh.HIc = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72487);
          return 0;
        case 11: 
          localboh.HId = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72487);
          return 0;
        case 12: 
          localboh.HIe = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72487);
          return 0;
        case 13: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cbg();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cbg)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localboh.LWw.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72487);
          return 0;
        }
        localboh.HIg = ((g.a.a.a.a)localObject1).UbS.yZ();
        AppMethodBeat.o(72487);
        return 0;
      }
      AppMethodBeat.o(72487);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.boh
 * JD-Core Version:    0.7.0.1
 */