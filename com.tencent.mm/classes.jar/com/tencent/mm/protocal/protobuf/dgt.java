package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dgt
  extends dpc
{
  public boolean MLk;
  public LinkedList<cuh> Mzs;
  public String Mzt;
  public LinkedList<cue> Mzx;
  public String dNI;
  public String ixZ;
  public boolean lHF;
  public int lHG;
  public int lHH;
  public String lHI;
  public String lHJ;
  
  public dgt()
  {
    AppMethodBeat.i(82468);
    this.Mzs = new LinkedList();
    this.Mzx = new LinkedList();
    AppMethodBeat.o(82468);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82469);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(82469);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.cc(2, this.MLk);
      paramVarArgs.e(3, 8, this.Mzs);
      if (this.dNI != null) {
        paramVarArgs.e(4, this.dNI);
      }
      if (this.ixZ != null) {
        paramVarArgs.e(5, this.ixZ);
      }
      if (this.Mzt != null) {
        paramVarArgs.e(6, this.Mzt);
      }
      paramVarArgs.e(7, 8, this.Mzx);
      paramVarArgs.cc(8, this.lHF);
      paramVarArgs.aM(9, this.lHG);
      paramVarArgs.aM(10, this.lHH);
      if (this.lHI != null) {
        paramVarArgs.e(11, this.lHI);
      }
      if (this.lHJ != null) {
        paramVarArgs.e(12, this.lHJ);
      }
      AppMethodBeat.o(82469);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1118;
      }
    }
    label1118:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + (g.a.a.b.b.a.fS(2) + 1) + g.a.a.a.c(3, 8, this.Mzs);
      paramInt = i;
      if (this.dNI != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.dNI);
      }
      i = paramInt;
      if (this.ixZ != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.ixZ);
      }
      paramInt = i;
      if (this.Mzt != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.Mzt);
      }
      i = paramInt + g.a.a.a.c(7, 8, this.Mzx) + (g.a.a.b.b.a.fS(8) + 1) + g.a.a.b.b.a.bu(9, this.lHG) + g.a.a.b.b.a.bu(10, this.lHH);
      paramInt = i;
      if (this.lHI != null) {
        paramInt = i + g.a.a.b.b.a.f(11, this.lHI);
      }
      i = paramInt;
      if (this.lHJ != null) {
        i = paramInt + g.a.a.b.b.a.f(12, this.lHJ);
      }
      AppMethodBeat.o(82469);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Mzs.clear();
        this.Mzx.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(82469);
          throw paramVarArgs;
        }
        AppMethodBeat.o(82469);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dgt localdgt = (dgt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(82469);
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
            localdgt.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82469);
          return 0;
        case 2: 
          localdgt.MLk = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(82469);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cuh();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cuh)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdgt.Mzs.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82469);
          return 0;
        case 4: 
          localdgt.dNI = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(82469);
          return 0;
        case 5: 
          localdgt.ixZ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(82469);
          return 0;
        case 6: 
          localdgt.Mzt = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(82469);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cue();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cue)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdgt.Mzx.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82469);
          return 0;
        case 8: 
          localdgt.lHF = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(82469);
          return 0;
        case 9: 
          localdgt.lHG = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(82469);
          return 0;
        case 10: 
          localdgt.lHH = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(82469);
          return 0;
        case 11: 
          localdgt.lHI = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(82469);
          return 0;
        }
        localdgt.lHJ = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(82469);
        return 0;
      }
      AppMethodBeat.o(82469);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dgt
 * JD-Core Version:    0.7.0.1
 */