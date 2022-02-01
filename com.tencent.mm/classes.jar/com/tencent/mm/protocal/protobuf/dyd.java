package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dyd
  extends dpc
{
  public String MTK;
  public hr MVQ;
  public int MXG;
  public hq MXH;
  public LinkedList<hs> MXI;
  public String MXJ;
  public String MXK;
  public ht MXL;
  public LinkedList<ht> MXM;
  public eqk MXN;
  public boolean MXO;
  public String MXP;
  public hp MXQ;
  public String Mzt;
  public String dHx;
  public String ixZ;
  public String title;
  
  public dyd()
  {
    AppMethodBeat.i(123652);
    this.MXI = new LinkedList();
    this.MXM = new LinkedList();
    AppMethodBeat.o(123652);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123653);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(123653);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.MVQ != null)
      {
        paramVarArgs.ni(2, this.MVQ.computeSize());
        this.MVQ.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(3, this.MXG);
      if (this.MXH != null)
      {
        paramVarArgs.ni(4, this.MXH.computeSize());
        this.MXH.writeFields(paramVarArgs);
      }
      if (this.title != null) {
        paramVarArgs.e(5, this.title);
      }
      if (this.Mzt != null) {
        paramVarArgs.e(6, this.Mzt);
      }
      if (this.ixZ != null) {
        paramVarArgs.e(7, this.ixZ);
      }
      if (this.MTK != null) {
        paramVarArgs.e(8, this.MTK);
      }
      paramVarArgs.e(9, 8, this.MXI);
      if (this.MXJ != null) {
        paramVarArgs.e(10, this.MXJ);
      }
      if (this.MXK != null) {
        paramVarArgs.e(11, this.MXK);
      }
      if (this.MXL != null)
      {
        paramVarArgs.ni(12, this.MXL.computeSize());
        this.MXL.writeFields(paramVarArgs);
      }
      paramVarArgs.e(13, 8, this.MXM);
      if (this.dHx != null) {
        paramVarArgs.e(14, this.dHx);
      }
      if (this.MXN != null)
      {
        paramVarArgs.ni(15, this.MXN.computeSize());
        this.MXN.writeFields(paramVarArgs);
      }
      paramVarArgs.cc(16, this.MXO);
      if (this.MXP != null) {
        paramVarArgs.e(17, this.MXP);
      }
      if (this.MXQ != null)
      {
        paramVarArgs.ni(19, this.MXQ.computeSize());
        this.MXQ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(123653);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2006;
      }
    }
    label2006:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.MVQ != null) {
        i = paramInt + g.a.a.a.nh(2, this.MVQ.computeSize());
      }
      i += g.a.a.b.b.a.bu(3, this.MXG);
      paramInt = i;
      if (this.MXH != null) {
        paramInt = i + g.a.a.a.nh(4, this.MXH.computeSize());
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.title);
      }
      paramInt = i;
      if (this.Mzt != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.Mzt);
      }
      i = paramInt;
      if (this.ixZ != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.ixZ);
      }
      paramInt = i;
      if (this.MTK != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.MTK);
      }
      i = paramInt + g.a.a.a.c(9, 8, this.MXI);
      paramInt = i;
      if (this.MXJ != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.MXJ);
      }
      i = paramInt;
      if (this.MXK != null) {
        i = paramInt + g.a.a.b.b.a.f(11, this.MXK);
      }
      paramInt = i;
      if (this.MXL != null) {
        paramInt = i + g.a.a.a.nh(12, this.MXL.computeSize());
      }
      i = paramInt + g.a.a.a.c(13, 8, this.MXM);
      paramInt = i;
      if (this.dHx != null) {
        paramInt = i + g.a.a.b.b.a.f(14, this.dHx);
      }
      i = paramInt;
      if (this.MXN != null) {
        i = paramInt + g.a.a.a.nh(15, this.MXN.computeSize());
      }
      i += g.a.a.b.b.a.fS(16) + 1;
      paramInt = i;
      if (this.MXP != null) {
        paramInt = i + g.a.a.b.b.a.f(17, this.MXP);
      }
      i = paramInt;
      if (this.MXQ != null) {
        i = paramInt + g.a.a.a.nh(19, this.MXQ.computeSize());
      }
      AppMethodBeat.o(123653);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.MXI.clear();
        this.MXM.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(123653);
          throw paramVarArgs;
        }
        AppMethodBeat.o(123653);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dyd localdyd = (dyd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 18: 
        default: 
          AppMethodBeat.o(123653);
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
            localdyd.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123653);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((hr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdyd.MVQ = ((hr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123653);
          return 0;
        case 3: 
          localdyd.MXG = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(123653);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hq();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((hq)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdyd.MXH = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123653);
          return 0;
        case 5: 
          localdyd.title = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123653);
          return 0;
        case 6: 
          localdyd.Mzt = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123653);
          return 0;
        case 7: 
          localdyd.ixZ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123653);
          return 0;
        case 8: 
          localdyd.MTK = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123653);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hs();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((hs)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdyd.MXI.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123653);
          return 0;
        case 10: 
          localdyd.MXJ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123653);
          return 0;
        case 11: 
          localdyd.MXK = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123653);
          return 0;
        case 12: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ht();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ht)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdyd.MXL = ((ht)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123653);
          return 0;
        case 13: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ht();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ht)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdyd.MXM.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123653);
          return 0;
        case 14: 
          localdyd.dHx = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123653);
          return 0;
        case 15: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eqk();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eqk)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdyd.MXN = ((eqk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123653);
          return 0;
        case 16: 
          localdyd.MXO = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(123653);
          return 0;
        case 17: 
          localdyd.MXP = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123653);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new hp();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((hp)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdyd.MXQ = ((hp)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(123653);
        return 0;
      }
      AppMethodBeat.o(123653);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dyd
 * JD-Core Version:    0.7.0.1
 */