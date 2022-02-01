package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bft
  extends cqk
{
  public LinkedList<api> DPP;
  public LinkedList<ddd> DQy;
  public String EUW;
  public ect EUX;
  public LinkedList<ecv> EUY;
  public LinkedList<ecu> EUZ;
  public LinkedList<String> EVa;
  public String EVb;
  public String EVc;
  public LinkedList<px> EVd;
  public boolean EVe;
  public String pBj;
  public String pBk;
  public boolean pBt;
  public int pHU;
  public String source;
  
  public bft()
  {
    AppMethodBeat.i(32279);
    this.EUY = new LinkedList();
    this.EUZ = new LinkedList();
    this.EVa = new LinkedList();
    this.DQy = new LinkedList();
    this.DPP = new LinkedList();
    this.EVd = new LinkedList();
    AppMethodBeat.o(32279);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32280);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32280);
        throw paramVarArgs;
      }
      if (this.EUW == null)
      {
        paramVarArgs = new b("Not all required fields were included: coverurl");
        AppMethodBeat.o(32280);
        throw paramVarArgs;
      }
      if (this.pBk == null)
      {
        paramVarArgs = new b("Not all required fields were included: motto");
        AppMethodBeat.o(32280);
        throw paramVarArgs;
      }
      if (this.EUX == null)
      {
        paramVarArgs = new b("Not all required fields were included: rankdesc");
        AppMethodBeat.o(32280);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.EUW != null) {
        paramVarArgs.d(2, this.EUW);
      }
      if (this.pBk != null) {
        paramVarArgs.d(3, this.pBk);
      }
      if (this.EUX != null)
      {
        paramVarArgs.ln(4, this.EUX.computeSize());
        this.EUX.writeFields(paramVarArgs);
      }
      paramVarArgs.e(5, 8, this.EUY);
      paramVarArgs.e(6, 8, this.EUZ);
      if (this.source != null) {
        paramVarArgs.d(7, this.source);
      }
      paramVarArgs.e(8, 1, this.EVa);
      if (this.EVb != null) {
        paramVarArgs.d(9, this.EVb);
      }
      if (this.EVc != null) {
        paramVarArgs.d(10, this.EVc);
      }
      paramVarArgs.e(14, 8, this.DQy);
      paramVarArgs.e(15, 8, this.DPP);
      paramVarArgs.bl(16, this.pBt);
      paramVarArgs.e(17, 8, this.EVd);
      paramVarArgs.bl(18, this.EVe);
      paramVarArgs.aR(19, this.pHU);
      if (this.pBj != null) {
        paramVarArgs.d(20, this.pBj);
      }
      AppMethodBeat.o(32280);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1953;
      }
    }
    label1953:
    for (int i = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.EUW != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.EUW);
      }
      i = paramInt;
      if (this.pBk != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.pBk);
      }
      paramInt = i;
      if (this.EUX != null) {
        paramInt = i + f.a.a.a.lm(4, this.EUX.computeSize());
      }
      i = paramInt + f.a.a.a.c(5, 8, this.EUY) + f.a.a.a.c(6, 8, this.EUZ);
      paramInt = i;
      if (this.source != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.source);
      }
      i = paramInt + f.a.a.a.c(8, 1, this.EVa);
      paramInt = i;
      if (this.EVb != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.EVb);
      }
      i = paramInt;
      if (this.EVc != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.EVc);
      }
      i = i + f.a.a.a.c(14, 8, this.DQy) + f.a.a.a.c(15, 8, this.DPP) + (f.a.a.b.b.a.fK(16) + 1) + f.a.a.a.c(17, 8, this.EVd) + (f.a.a.b.b.a.fK(18) + 1) + f.a.a.b.b.a.bx(19, this.pHU);
      paramInt = i;
      if (this.pBj != null) {
        paramInt = i + f.a.a.b.b.a.e(20, this.pBj);
      }
      AppMethodBeat.o(32280);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EUY.clear();
        this.EUZ.clear();
        this.EVa.clear();
        this.DQy.clear();
        this.DPP.clear();
        this.EVd.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32280);
          throw paramVarArgs;
        }
        if (this.EUW == null)
        {
          paramVarArgs = new b("Not all required fields were included: coverurl");
          AppMethodBeat.o(32280);
          throw paramVarArgs;
        }
        if (this.pBk == null)
        {
          paramVarArgs = new b("Not all required fields were included: motto");
          AppMethodBeat.o(32280);
          throw paramVarArgs;
        }
        if (this.EUX == null)
        {
          paramVarArgs = new b("Not all required fields were included: rankdesc");
          AppMethodBeat.o(32280);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32280);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bft localbft = (bft)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 11: 
        case 12: 
        case 13: 
        default: 
          AppMethodBeat.o(32280);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbft.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32280);
          return 0;
        case 2: 
          localbft.EUW = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32280);
          return 0;
        case 3: 
          localbft.pBk = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32280);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ect();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ect)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbft.EUX = ((ect)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32280);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ecv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ecv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbft.EUY.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32280);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ecu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ecu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbft.EUZ.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32280);
          return 0;
        case 7: 
          localbft.source = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32280);
          return 0;
        case 8: 
          localbft.EVa.add(((f.a.a.a.a)localObject1).LVo.readString());
          AppMethodBeat.o(32280);
          return 0;
        case 9: 
          localbft.EVb = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32280);
          return 0;
        case 10: 
          localbft.EVc = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32280);
          return 0;
        case 14: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ddd();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ddd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbft.DQy.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32280);
          return 0;
        case 15: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new api();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((api)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbft.DPP.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32280);
          return 0;
        case 16: 
          localbft.pBt = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(32280);
          return 0;
        case 17: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new px();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((px)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbft.EVd.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32280);
          return 0;
        case 18: 
          localbft.EVe = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(32280);
          return 0;
        case 19: 
          localbft.pHU = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32280);
          return 0;
        }
        localbft.pBj = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(32280);
        return 0;
      }
      AppMethodBeat.o(32280);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bft
 * JD-Core Version:    0.7.0.1
 */