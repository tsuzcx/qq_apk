package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class fg
  extends cwj
{
  public LinkedList<fu> FPM;
  public int FPN;
  public String FPO;
  public int FPP;
  public int FPQ;
  public int FPR;
  public er FPS;
  public dwq FPT;
  public String FPU;
  public byj FPV;
  public fc FPW;
  public LinkedList<String> FPX;
  public dr FPY;
  public LinkedList<bwv> FPZ;
  public String FQa;
  public String hCa;
  public String url;
  
  public fg()
  {
    AppMethodBeat.i(103195);
    this.FPM = new LinkedList();
    this.FPX = new LinkedList();
    this.FPZ = new LinkedList();
    AppMethodBeat.o(103195);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(103196);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(103196);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.FPM);
      paramVarArgs.aS(3, this.FPN);
      if (this.FPO != null) {
        paramVarArgs.d(4, this.FPO);
      }
      paramVarArgs.aS(5, this.FPP);
      paramVarArgs.aS(6, this.FPQ);
      paramVarArgs.aS(7, this.FPR);
      if (this.FPS != null)
      {
        paramVarArgs.lJ(8, this.FPS.computeSize());
        this.FPS.writeFields(paramVarArgs);
      }
      if (this.url != null) {
        paramVarArgs.d(9, this.url);
      }
      if (this.hCa != null) {
        paramVarArgs.d(10, this.hCa);
      }
      if (this.FPT != null)
      {
        paramVarArgs.lJ(11, this.FPT.computeSize());
        this.FPT.writeFields(paramVarArgs);
      }
      if (this.FPU != null) {
        paramVarArgs.d(12, this.FPU);
      }
      if (this.FPV != null)
      {
        paramVarArgs.lJ(13, this.FPV.computeSize());
        this.FPV.writeFields(paramVarArgs);
      }
      if (this.FPW != null)
      {
        paramVarArgs.lJ(14, this.FPW.computeSize());
        this.FPW.writeFields(paramVarArgs);
      }
      paramVarArgs.e(15, 1, this.FPX);
      if (this.FPY != null)
      {
        paramVarArgs.lJ(16, this.FPY.computeSize());
        this.FPY.writeFields(paramVarArgs);
      }
      paramVarArgs.e(17, 8, this.FPZ);
      if (this.FQa != null) {
        paramVarArgs.d(18, this.FQa);
      }
      AppMethodBeat.o(103196);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1962;
      }
    }
    label1962:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.FPM) + f.a.a.b.b.a.bz(3, this.FPN);
      paramInt = i;
      if (this.FPO != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FPO);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.FPP) + f.a.a.b.b.a.bz(6, this.FPQ) + f.a.a.b.b.a.bz(7, this.FPR);
      paramInt = i;
      if (this.FPS != null) {
        paramInt = i + f.a.a.a.lI(8, this.FPS.computeSize());
      }
      i = paramInt;
      if (this.url != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.url);
      }
      paramInt = i;
      if (this.hCa != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.hCa);
      }
      i = paramInt;
      if (this.FPT != null) {
        i = paramInt + f.a.a.a.lI(11, this.FPT.computeSize());
      }
      paramInt = i;
      if (this.FPU != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.FPU);
      }
      i = paramInt;
      if (this.FPV != null) {
        i = paramInt + f.a.a.a.lI(13, this.FPV.computeSize());
      }
      paramInt = i;
      if (this.FPW != null) {
        paramInt = i + f.a.a.a.lI(14, this.FPW.computeSize());
      }
      i = paramInt + f.a.a.a.c(15, 1, this.FPX);
      paramInt = i;
      if (this.FPY != null) {
        paramInt = i + f.a.a.a.lI(16, this.FPY.computeSize());
      }
      i = paramInt + f.a.a.a.c(17, 8, this.FPZ);
      paramInt = i;
      if (this.FQa != null) {
        paramInt = i + f.a.a.b.b.a.e(18, this.FQa);
      }
      AppMethodBeat.o(103196);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FPM.clear();
        this.FPX.clear();
        this.FPZ.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(103196);
          throw paramVarArgs;
        }
        AppMethodBeat.o(103196);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        fg localfg = (fg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(103196);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localfg.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(103196);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new fu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((fu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localfg.FPM.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(103196);
          return 0;
        case 3: 
          localfg.FPN = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(103196);
          return 0;
        case 4: 
          localfg.FPO = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(103196);
          return 0;
        case 5: 
          localfg.FPP = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(103196);
          return 0;
        case 6: 
          localfg.FPQ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(103196);
          return 0;
        case 7: 
          localfg.FPR = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(103196);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new er();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((er)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localfg.FPS = ((er)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(103196);
          return 0;
        case 9: 
          localfg.url = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(103196);
          return 0;
        case 10: 
          localfg.hCa = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(103196);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dwq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dwq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localfg.FPT = ((dwq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(103196);
          return 0;
        case 12: 
          localfg.FPU = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(103196);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new byj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((byj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localfg.FPV = ((byj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(103196);
          return 0;
        case 14: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new fc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((fc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localfg.FPW = ((fc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(103196);
          return 0;
        case 15: 
          localfg.FPX.add(((f.a.a.a.a)localObject1).OmT.readString());
          AppMethodBeat.o(103196);
          return 0;
        case 16: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dr();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localfg.FPY = ((dr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(103196);
          return 0;
        case 17: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bwv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localfg.FPZ.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(103196);
          return 0;
        }
        localfg.FQa = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(103196);
        return 0;
      }
      AppMethodBeat.o(103196);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fg
 * JD-Core Version:    0.7.0.1
 */