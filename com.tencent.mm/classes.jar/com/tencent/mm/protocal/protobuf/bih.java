package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class bih
  extends esc
{
  public int BeA;
  public b YJa;
  public b ZEQ;
  public String ZRn;
  public bzd ZRp;
  public bzd ZRq;
  public boh ZRr;
  public bzd ZRs;
  public int ZRt;
  public bms ZRu;
  public buh ZRv;
  public long ZRw;
  public b ZRx;
  public int ZRy;
  public LinkedList<bmu> ZgM;
  public int ZnA;
  public long mMJ;
  
  public bih()
  {
    AppMethodBeat.i(257418);
    this.ZgM = new LinkedList();
    AppMethodBeat.o(257418);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257427);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.ZgM);
      if (this.ZRp != null)
      {
        paramVarArgs.qD(3, this.ZRp.computeSize());
        this.ZRp.writeFields(paramVarArgs);
      }
      if (this.YJa != null) {
        paramVarArgs.d(4, this.YJa);
      }
      if (this.ZRq != null)
      {
        paramVarArgs.qD(5, this.ZRq.computeSize());
        this.ZRq.writeFields(paramVarArgs);
      }
      if (this.ZRr != null)
      {
        paramVarArgs.qD(6, this.ZRr.computeSize());
        this.ZRr.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(7, this.mMJ);
      if (this.ZRs != null)
      {
        paramVarArgs.qD(8, this.ZRs.computeSize());
        this.ZRs.writeFields(paramVarArgs);
      }
      if (this.ZRn != null) {
        paramVarArgs.g(9, this.ZRn);
      }
      paramVarArgs.bS(10, this.ZnA);
      paramVarArgs.bS(11, this.ZRt);
      if (this.ZRu != null)
      {
        paramVarArgs.qD(12, this.ZRu.computeSize());
        this.ZRu.writeFields(paramVarArgs);
      }
      if (this.ZRv != null)
      {
        paramVarArgs.qD(13, this.ZRv.computeSize());
        this.ZRv.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(14, this.ZRw);
      if (this.ZEQ != null) {
        paramVarArgs.d(100, this.ZEQ);
      }
      paramVarArgs.bS(101, this.BeA);
      if (this.ZRx != null) {
        paramVarArgs.d(102, this.ZRx);
      }
      paramVarArgs.bS(103, this.ZRy);
      AppMethodBeat.o(257427);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1794;
      }
    }
    label1794:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.ZgM);
      paramInt = i;
      if (this.ZRp != null) {
        paramInt = i + i.a.a.a.qC(3, this.ZRp.computeSize());
      }
      i = paramInt;
      if (this.YJa != null) {
        i = paramInt + i.a.a.b.b.a.c(4, this.YJa);
      }
      paramInt = i;
      if (this.ZRq != null) {
        paramInt = i + i.a.a.a.qC(5, this.ZRq.computeSize());
      }
      i = paramInt;
      if (this.ZRr != null) {
        i = paramInt + i.a.a.a.qC(6, this.ZRr.computeSize());
      }
      i += i.a.a.b.b.a.q(7, this.mMJ);
      paramInt = i;
      if (this.ZRs != null) {
        paramInt = i + i.a.a.a.qC(8, this.ZRs.computeSize());
      }
      i = paramInt;
      if (this.ZRn != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.ZRn);
      }
      i = i + i.a.a.b.b.a.cJ(10, this.ZnA) + i.a.a.b.b.a.cJ(11, this.ZRt);
      paramInt = i;
      if (this.ZRu != null) {
        paramInt = i + i.a.a.a.qC(12, this.ZRu.computeSize());
      }
      i = paramInt;
      if (this.ZRv != null) {
        i = paramInt + i.a.a.a.qC(13, this.ZRv.computeSize());
      }
      i += i.a.a.b.b.a.q(14, this.ZRw);
      paramInt = i;
      if (this.ZEQ != null) {
        paramInt = i + i.a.a.b.b.a.c(100, this.ZEQ);
      }
      i = paramInt + i.a.a.b.b.a.cJ(101, this.BeA);
      paramInt = i;
      if (this.ZRx != null) {
        paramInt = i + i.a.a.b.b.a.c(102, this.ZRx);
      }
      i = i.a.a.b.b.a.cJ(103, this.ZRy);
      AppMethodBeat.o(257427);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ZgM.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257427);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bih localbih = (bih)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257427);
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
            localbih.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257427);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bmu();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bmu)localObject2).parseFrom((byte[])localObject1);
            }
            localbih.ZgM.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257427);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bzd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bzd)localObject2).parseFrom((byte[])localObject1);
            }
            localbih.ZRp = ((bzd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257427);
          return 0;
        case 4: 
          localbih.YJa = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(257427);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bzd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bzd)localObject2).parseFrom((byte[])localObject1);
            }
            localbih.ZRq = ((bzd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257427);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new boh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((boh)localObject2).parseFrom((byte[])localObject1);
            }
            localbih.ZRr = ((boh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257427);
          return 0;
        case 7: 
          localbih.mMJ = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(257427);
          return 0;
        case 8: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bzd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bzd)localObject2).parseFrom((byte[])localObject1);
            }
            localbih.ZRs = ((bzd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257427);
          return 0;
        case 9: 
          localbih.ZRn = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257427);
          return 0;
        case 10: 
          localbih.ZnA = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257427);
          return 0;
        case 11: 
          localbih.ZRt = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257427);
          return 0;
        case 12: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bms();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bms)localObject2).parseFrom((byte[])localObject1);
            }
            localbih.ZRu = ((bms)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257427);
          return 0;
        case 13: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new buh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((buh)localObject2).parseFrom((byte[])localObject1);
            }
            localbih.ZRv = ((buh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257427);
          return 0;
        case 14: 
          localbih.ZRw = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(257427);
          return 0;
        case 100: 
          localbih.ZEQ = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(257427);
          return 0;
        case 101: 
          localbih.BeA = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257427);
          return 0;
        case 102: 
          localbih.ZRx = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(257427);
          return 0;
        }
        localbih.ZRy = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(257427);
        return 0;
      }
      AppMethodBeat.o(257427);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bih
 * JD-Core Version:    0.7.0.1
 */