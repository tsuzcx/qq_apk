package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class drk
  extends dpc
{
  public String KJw;
  public com.tencent.mm.bw.b MTX;
  public String MUa;
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
  
  public drk()
  {
    AppMethodBeat.i(82474);
    this.Mzs = new LinkedList();
    this.Mzx = new LinkedList();
    AppMethodBeat.o(82474);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82475);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(82475);
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
      if (this.MUa != null) {
        paramVarArgs.e(21, this.MUa);
      }
      if (this.MTX != null) {
        paramVarArgs.c(22, this.MTX);
      }
      AppMethodBeat.o(82475);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1390;
      }
    }
    label1390:
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
      paramInt = i;
      if (this.MUa != null) {
        paramInt = i + g.a.a.b.b.a.f(21, this.MUa);
      }
      i = paramInt;
      if (this.MTX != null) {
        i = paramInt + g.a.a.b.b.a.b(22, this.MTX);
      }
      AppMethodBeat.o(82475);
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
          paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(82475);
          throw paramVarArgs;
        }
        AppMethodBeat.o(82475);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        drk localdrk = (drk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 2: 
        case 7: 
        case 18: 
        case 19: 
        case 20: 
        default: 
          AppMethodBeat.o(82475);
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
            localdrk.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82475);
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
            localdrk.Mzs.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82475);
          return 0;
        case 4: 
          localdrk.ixZ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(82475);
          return 0;
        case 5: 
          localdrk.Mzt = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(82475);
          return 0;
        case 6: 
          localdrk.KJw = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(82475);
          return 0;
        case 8: 
          localdrk.Mzu = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(82475);
          return 0;
        case 9: 
          localdrk.Mzv = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(82475);
          return 0;
        case 10: 
          localdrk.Mzw = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(82475);
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
            localdrk.Mzx.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82475);
          return 0;
        case 12: 
          localdrk.Mzy = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(82475);
          return 0;
        case 13: 
          localdrk.lHF = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(82475);
          return 0;
        case 14: 
          localdrk.lHG = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(82475);
          return 0;
        case 15: 
          localdrk.lHH = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(82475);
          return 0;
        case 16: 
          localdrk.lHI = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(82475);
          return 0;
        case 17: 
          localdrk.lHJ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(82475);
          return 0;
        case 21: 
          localdrk.MUa = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(82475);
          return 0;
        }
        localdrk.MTX = ((g.a.a.a.a)localObject1).UbS.hPo();
        AppMethodBeat.o(82475);
        return 0;
      }
      AppMethodBeat.o(82475);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.drk
 * JD-Core Version:    0.7.0.1
 */