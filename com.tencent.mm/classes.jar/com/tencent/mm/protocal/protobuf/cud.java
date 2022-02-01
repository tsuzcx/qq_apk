package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class cud
  extends dpc
{
  public String KJw;
  public LinkedList<cuh> Mzs;
  public String Mzt;
  public boolean Mzu;
  public boolean Mzv;
  public boolean Mzw;
  public LinkedList<cue> Mzx;
  public boolean Mzy;
  public String ixZ;
  public boolean lHF;
  public int lHG;
  public int lHH;
  public String lHI;
  public String lHJ;
  
  public cud()
  {
    AppMethodBeat.i(82461);
    this.Mzs = new LinkedList();
    this.Mzx = new LinkedList();
    AppMethodBeat.o(82461);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82462);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(82462);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 8, this.Mzs);
      if (this.ixZ != null) {
        paramVarArgs.e(4, this.ixZ);
      }
      if (this.Mzt != null) {
        paramVarArgs.e(5, this.Mzt);
      }
      if (this.KJw != null) {
        paramVarArgs.e(6, this.KJw);
      }
      paramVarArgs.cc(8, this.Mzu);
      paramVarArgs.cc(9, this.Mzv);
      paramVarArgs.cc(10, this.Mzw);
      paramVarArgs.e(11, 8, this.Mzx);
      paramVarArgs.cc(12, this.Mzy);
      paramVarArgs.cc(13, this.lHF);
      paramVarArgs.aM(14, this.lHG);
      paramVarArgs.aM(15, this.lHH);
      if (this.lHI != null) {
        paramVarArgs.e(16, this.lHI);
      }
      if (this.lHJ != null) {
        paramVarArgs.e(17, this.lHJ);
      }
      AppMethodBeat.o(82462);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1254;
      }
    }
    label1254:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(3, 8, this.Mzs);
      paramInt = i;
      if (this.ixZ != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.ixZ);
      }
      i = paramInt;
      if (this.Mzt != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.Mzt);
      }
      paramInt = i;
      if (this.KJw != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.KJw);
      }
      i = paramInt + (g.a.a.b.b.a.fS(8) + 1) + (g.a.a.b.b.a.fS(9) + 1) + (g.a.a.b.b.a.fS(10) + 1) + g.a.a.a.c(11, 8, this.Mzx) + (g.a.a.b.b.a.fS(12) + 1) + (g.a.a.b.b.a.fS(13) + 1) + g.a.a.b.b.a.bu(14, this.lHG) + g.a.a.b.b.a.bu(15, this.lHH);
      paramInt = i;
      if (this.lHI != null) {
        paramInt = i + g.a.a.b.b.a.f(16, this.lHI);
      }
      i = paramInt;
      if (this.lHJ != null) {
        i = paramInt + g.a.a.b.b.a.f(17, this.lHJ);
      }
      AppMethodBeat.o(82462);
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
          AppMethodBeat.o(82462);
          throw paramVarArgs;
        }
        AppMethodBeat.o(82462);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cud localcud = (cud)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 2: 
        case 7: 
        default: 
          AppMethodBeat.o(82462);
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
            localcud.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82462);
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
            localcud.Mzs.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82462);
          return 0;
        case 4: 
          localcud.ixZ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(82462);
          return 0;
        case 5: 
          localcud.Mzt = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(82462);
          return 0;
        case 6: 
          localcud.KJw = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(82462);
          return 0;
        case 8: 
          localcud.Mzu = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(82462);
          return 0;
        case 9: 
          localcud.Mzv = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(82462);
          return 0;
        case 10: 
          localcud.Mzw = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(82462);
          return 0;
        case 11: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cue();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cue)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcud.Mzx.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82462);
          return 0;
        case 12: 
          localcud.Mzy = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(82462);
          return 0;
        case 13: 
          localcud.lHF = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(82462);
          return 0;
        case 14: 
          localcud.lHG = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(82462);
          return 0;
        case 15: 
          localcud.lHH = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(82462);
          return 0;
        case 16: 
          localcud.lHI = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(82462);
          return 0;
        }
        localcud.lHJ = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(82462);
        return 0;
      }
      AppMethodBeat.o(82462);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cud
 * JD-Core Version:    0.7.0.1
 */