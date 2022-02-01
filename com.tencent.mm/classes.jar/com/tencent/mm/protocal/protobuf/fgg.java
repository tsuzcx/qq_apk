package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class fgg
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
  public int abFi;
  public fge abGh;
  
  public fgg()
  {
    AppMethodBeat.i(257920);
    this.YMT = new LinkedList();
    this.abEb = new LinkedList();
    AppMethodBeat.o(257920);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257931);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(257931);
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
      if (this.abGh != null)
      {
        paramVarArgs.qD(16, this.abGh.computeSize());
        this.abGh.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(257931);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1446;
      }
    }
    label1446:
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
      if (this.abGh != null) {
        paramInt = i + i.a.a.a.qC(16, this.abGh.computeSize());
      }
      AppMethodBeat.o(257931);
      return paramInt;
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
          AppMethodBeat.o(257931);
          throw paramVarArgs;
        }
        AppMethodBeat.o(257931);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        fgg localfgg = (fgg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257931);
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
            localfgg.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257931);
          return 0;
        case 2: 
          localfgg.abDu = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257931);
          return 0;
        case 3: 
          localfgg.aaWr = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257931);
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
            localfgg.YMT.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257931);
          return 0;
        case 5: 
          localfgg.abFK = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257931);
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
            localfgg.aaMs = ((ffs)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257931);
          return 0;
        case 7: 
          localfgg.abFi = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257931);
          return 0;
        case 8: 
          localfgg.abDy = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257931);
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
            localfgg.abDz = ((ffb)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257931);
          return 0;
        case 10: 
          localfgg.abFL = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(257931);
          return 0;
        case 11: 
          localfgg.abFM = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(257931);
          return 0;
        case 12: 
          localfgg.abFN = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257931);
          return 0;
        case 13: 
          localfgg.abEa = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257931);
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
            localfgg.abEb.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257931);
          return 0;
        case 15: 
          localfgg.abFO = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(257931);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fge();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fge)localObject2).parseFrom((byte[])localObject1);
          }
          localfgg.abGh = ((fge)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(257931);
        return 0;
      }
      AppMethodBeat.o(257931);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fgg
 * JD-Core Version:    0.7.0.1
 */