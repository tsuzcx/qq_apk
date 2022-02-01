package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ebe
  extends dpc
{
  public LinkedList<SnsObject> KOH;
  public SKBuiltinBuffer_t MYJ;
  public String MZg;
  public int MZk;
  public eat MZl;
  public int MvM;
  public int NaG;
  public int NaH;
  public LinkedList<ds> NaI;
  public int NaJ;
  public LinkedList<dkg> NaK;
  public int NaL;
  public LinkedList<aez> NaM;
  public int NaO;
  public LinkedList<Long> NaP;
  public LinkedList<Integer> NaQ;
  public SKBuiltinBuffer_t NaR;
  public int xuw;
  
  public ebe()
  {
    AppMethodBeat.i(125828);
    this.KOH = new LinkedList();
    this.NaI = new LinkedList();
    this.NaK = new LinkedList();
    this.NaM = new LinkedList();
    this.NaP = new LinkedList();
    this.NaQ = new LinkedList();
    AppMethodBeat.o(125828);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125829);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(125829);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.MZg != null) {
        paramVarArgs.e(2, this.MZg);
      }
      paramVarArgs.aM(3, this.MvM);
      paramVarArgs.e(4, 8, this.KOH);
      paramVarArgs.aM(5, this.NaG);
      paramVarArgs.aM(6, this.MZk);
      paramVarArgs.aM(7, this.xuw);
      if (this.MZl != null)
      {
        paramVarArgs.ni(8, this.MZl.computeSize());
        this.MZl.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(9, this.NaH);
      paramVarArgs.e(10, 8, this.NaI);
      if (this.MYJ != null)
      {
        paramVarArgs.ni(11, this.MYJ.computeSize());
        this.MYJ.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(12, this.NaJ);
      paramVarArgs.e(13, 8, this.NaK);
      paramVarArgs.aM(14, this.NaL);
      paramVarArgs.e(15, 8, this.NaM);
      paramVarArgs.aM(16, this.NaO);
      paramVarArgs.f(17, 3, this.NaP);
      paramVarArgs.f(18, 2, this.NaQ);
      if (this.NaR != null)
      {
        paramVarArgs.ni(19, this.NaR.computeSize());
        this.NaR.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125829);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1940;
      }
    }
    label1940:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.MZg != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.MZg);
      }
      i = i + g.a.a.b.b.a.bu(3, this.MvM) + g.a.a.a.c(4, 8, this.KOH) + g.a.a.b.b.a.bu(5, this.NaG) + g.a.a.b.b.a.bu(6, this.MZk) + g.a.a.b.b.a.bu(7, this.xuw);
      paramInt = i;
      if (this.MZl != null) {
        paramInt = i + g.a.a.a.nh(8, this.MZl.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(9, this.NaH) + g.a.a.a.c(10, 8, this.NaI);
      paramInt = i;
      if (this.MYJ != null) {
        paramInt = i + g.a.a.a.nh(11, this.MYJ.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(12, this.NaJ) + g.a.a.a.c(13, 8, this.NaK) + g.a.a.b.b.a.bu(14, this.NaL) + g.a.a.a.c(15, 8, this.NaM) + g.a.a.b.b.a.bu(16, this.NaO) + g.a.a.a.d(17, 3, this.NaP) + g.a.a.a.d(18, 2, this.NaQ);
      paramInt = i;
      if (this.NaR != null) {
        paramInt = i + g.a.a.a.nh(19, this.NaR.computeSize());
      }
      AppMethodBeat.o(125829);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.KOH.clear();
        this.NaI.clear();
        this.NaK.clear();
        this.NaM.clear();
        this.NaP.clear();
        this.NaQ.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(125829);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125829);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ebe localebe = (ebe)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125829);
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
            localebe.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125829);
          return 0;
        case 2: 
          localebe.MZg = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(125829);
          return 0;
        case 3: 
          localebe.MvM = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125829);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SnsObject();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SnsObject)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localebe.KOH.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125829);
          return 0;
        case 5: 
          localebe.NaG = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125829);
          return 0;
        case 6: 
          localebe.MZk = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125829);
          return 0;
        case 7: 
          localebe.xuw = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125829);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eat();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eat)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localebe.MZl = ((eat)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125829);
          return 0;
        case 9: 
          localebe.NaH = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125829);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ds();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ds)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localebe.NaI.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125829);
          return 0;
        case 11: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localebe.MYJ = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125829);
          return 0;
        case 12: 
          localebe.NaJ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125829);
          return 0;
        case 13: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dkg();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dkg)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localebe.NaK.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125829);
          return 0;
        case 14: 
          localebe.NaL = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125829);
          return 0;
        case 15: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aez();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aez)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localebe.NaM.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125829);
          return 0;
        case 16: 
          localebe.NaO = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125829);
          return 0;
        case 17: 
          localebe.NaP = new g.a.a.a.a(((g.a.a.a.a)localObject1).UbS.hPo().zy, unknownTagHandler).UbS.hPn();
          AppMethodBeat.o(125829);
          return 0;
        case 18: 
          localebe.NaQ = new g.a.a.a.a(((g.a.a.a.a)localObject1).UbS.hPo().zy, unknownTagHandler).UbS.hPm();
          AppMethodBeat.o(125829);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localebe.NaR = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125829);
        return 0;
      }
      AppMethodBeat.o(125829);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ebe
 * JD-Core Version:    0.7.0.1
 */