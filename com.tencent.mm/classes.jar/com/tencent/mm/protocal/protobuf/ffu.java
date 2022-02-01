package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class ffu
  extends esc
{
  public LinkedList<SnsObject> YMT;
  public ffs aaMs;
  public int aaWr;
  public String abDu;
  public int abDy;
  public ffb abDz;
  public int abEa;
  public LinkedList<fgh> abEb;
  public int abFK;
  public long abFL;
  public long abFM;
  public String abFN;
  public boolean abFO;
  public String abFP;
  public int abFQ;
  public int abFi;
  
  public ffu()
  {
    AppMethodBeat.i(125836);
    this.YMT = new LinkedList();
    this.abEb = new LinkedList();
    AppMethodBeat.o(125836);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125837);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(125837);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.abDu != null) {
        paramVarArgs.g(2, this.abDu);
      }
      paramVarArgs.bS(3, this.aaWr);
      paramVarArgs.e(4, 8, this.YMT);
      paramVarArgs.bS(5, this.abFK);
      if (this.aaMs != null)
      {
        paramVarArgs.qD(6, this.aaMs.computeSize());
        this.aaMs.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(7, this.abFi);
      paramVarArgs.bS(8, this.abDy);
      if (this.abDz != null)
      {
        paramVarArgs.qD(9, this.abDz.computeSize());
        this.abDz.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(10, this.abFL);
      paramVarArgs.bv(11, this.abFM);
      if (this.abFN != null) {
        paramVarArgs.g(12, this.abFN);
      }
      paramVarArgs.bS(13, this.abEa);
      paramVarArgs.e(14, 8, this.abEb);
      paramVarArgs.di(15, this.abFO);
      if (this.abFP != null) {
        paramVarArgs.g(16, this.abFP);
      }
      paramVarArgs.bS(17, this.abFQ);
      AppMethodBeat.o(125837);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1420;
      }
    }
    label1420:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.abDu != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.abDu);
      }
      i = i + i.a.a.b.b.a.cJ(3, this.aaWr) + i.a.a.a.c(4, 8, this.YMT) + i.a.a.b.b.a.cJ(5, this.abFK);
      paramInt = i;
      if (this.aaMs != null) {
        paramInt = i + i.a.a.a.qC(6, this.aaMs.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(7, this.abFi) + i.a.a.b.b.a.cJ(8, this.abDy);
      paramInt = i;
      if (this.abDz != null) {
        paramInt = i + i.a.a.a.qC(9, this.abDz.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.q(10, this.abFL) + i.a.a.b.b.a.q(11, this.abFM);
      paramInt = i;
      if (this.abFN != null) {
        paramInt = i + i.a.a.b.b.a.h(12, this.abFN);
      }
      i = paramInt + i.a.a.b.b.a.cJ(13, this.abEa) + i.a.a.a.c(14, 8, this.abEb) + (i.a.a.b.b.a.ko(15) + 1);
      paramInt = i;
      if (this.abFP != null) {
        paramInt = i + i.a.a.b.b.a.h(16, this.abFP);
      }
      i = i.a.a.b.b.a.cJ(17, this.abFQ);
      AppMethodBeat.o(125837);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.YMT.clear();
        this.abEb.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(125837);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125837);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ffu localffu = (ffu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125837);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kd)localObject2).parseFrom((byte[])localObject1);
            }
            localffu.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125837);
          return 0;
        case 2: 
          localffu.abDu = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(125837);
          return 0;
        case 3: 
          localffu.aaWr = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125837);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new SnsObject();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((SnsObject)localObject2).parseFrom((byte[])localObject1);
            }
            localffu.YMT.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125837);
          return 0;
        case 5: 
          localffu.abFK = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125837);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ffs();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ffs)localObject2).parseFrom((byte[])localObject1);
            }
            localffu.aaMs = ((ffs)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125837);
          return 0;
        case 7: 
          localffu.abFi = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125837);
          return 0;
        case 8: 
          localffu.abDy = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125837);
          return 0;
        case 9: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ffb();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ffb)localObject2).parseFrom((byte[])localObject1);
            }
            localffu.abDz = ((ffb)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125837);
          return 0;
        case 10: 
          localffu.abFL = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(125837);
          return 0;
        case 11: 
          localffu.abFM = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(125837);
          return 0;
        case 12: 
          localffu.abFN = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(125837);
          return 0;
        case 13: 
          localffu.abEa = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125837);
          return 0;
        case 14: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fgh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fgh)localObject2).parseFrom((byte[])localObject1);
            }
            localffu.abEb.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125837);
          return 0;
        case 15: 
          localffu.abFO = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(125837);
          return 0;
        case 16: 
          localffu.abFP = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(125837);
          return 0;
        }
        localffu.abFQ = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(125837);
        return 0;
      }
      AppMethodBeat.o(125837);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ffu
 * JD-Core Version:    0.7.0.1
 */