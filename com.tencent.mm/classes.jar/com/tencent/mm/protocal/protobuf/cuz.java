package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class cuz
  extends esc
{
  public boolean LXq;
  public LinkedList<bzo> YFB;
  public LinkedList<fhw> YGC;
  public int ZqA;
  public LinkedList<fhb> ZqB;
  public gny Zqy;
  public boolean aaAA;
  public LinkedList<fhc> aaAB;
  public gnw aaAC;
  public String aaAt;
  public LinkedList<goa> aaAu;
  public LinkedList<gnz> aaAv;
  public LinkedList<String> aaAw;
  public String aaAx;
  public String aaAy;
  public LinkedList<tk> aaAz;
  public String source;
  public int yBl;
  public String ytX;
  public String ytY;
  public boolean yug;
  
  public cuz()
  {
    AppMethodBeat.i(32279);
    this.aaAu = new LinkedList();
    this.aaAv = new LinkedList();
    this.aaAw = new LinkedList();
    this.YGC = new LinkedList();
    this.YFB = new LinkedList();
    this.aaAz = new LinkedList();
    this.aaAB = new LinkedList();
    this.ZqB = new LinkedList();
    AppMethodBeat.o(32279);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32280);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32280);
        throw paramVarArgs;
      }
      if (this.aaAt == null)
      {
        paramVarArgs = new b("Not all required fields were included: coverurl");
        AppMethodBeat.o(32280);
        throw paramVarArgs;
      }
      if (this.ytY == null)
      {
        paramVarArgs = new b("Not all required fields were included: motto");
        AppMethodBeat.o(32280);
        throw paramVarArgs;
      }
      if (this.Zqy == null)
      {
        paramVarArgs = new b("Not all required fields were included: rankdesc");
        AppMethodBeat.o(32280);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.aaAt != null) {
        paramVarArgs.g(2, this.aaAt);
      }
      if (this.ytY != null) {
        paramVarArgs.g(3, this.ytY);
      }
      if (this.Zqy != null)
      {
        paramVarArgs.qD(4, this.Zqy.computeSize());
        this.Zqy.writeFields(paramVarArgs);
      }
      paramVarArgs.e(5, 8, this.aaAu);
      paramVarArgs.e(6, 8, this.aaAv);
      if (this.source != null) {
        paramVarArgs.g(7, this.source);
      }
      paramVarArgs.e(8, 1, this.aaAw);
      if (this.aaAx != null) {
        paramVarArgs.g(9, this.aaAx);
      }
      if (this.aaAy != null) {
        paramVarArgs.g(10, this.aaAy);
      }
      paramVarArgs.e(14, 8, this.YGC);
      paramVarArgs.e(15, 8, this.YFB);
      paramVarArgs.di(16, this.yug);
      paramVarArgs.e(17, 8, this.aaAz);
      paramVarArgs.di(18, this.aaAA);
      paramVarArgs.bS(19, this.yBl);
      if (this.ytX != null) {
        paramVarArgs.g(20, this.ytX);
      }
      paramVarArgs.e(21, 8, this.aaAB);
      paramVarArgs.bS(22, this.ZqA);
      if (this.aaAC != null)
      {
        paramVarArgs.qD(23, this.aaAC.computeSize());
        this.aaAC.writeFields(paramVarArgs);
      }
      paramVarArgs.di(24, this.LXq);
      paramVarArgs.e(25, 8, this.ZqB);
      AppMethodBeat.o(32280);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2262;
      }
    }
    label2262:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.aaAt != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.aaAt);
      }
      i = paramInt;
      if (this.ytY != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.ytY);
      }
      paramInt = i;
      if (this.Zqy != null) {
        paramInt = i + i.a.a.a.qC(4, this.Zqy.computeSize());
      }
      i = paramInt + i.a.a.a.c(5, 8, this.aaAu) + i.a.a.a.c(6, 8, this.aaAv);
      paramInt = i;
      if (this.source != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.source);
      }
      i = paramInt + i.a.a.a.c(8, 1, this.aaAw);
      paramInt = i;
      if (this.aaAx != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.aaAx);
      }
      i = paramInt;
      if (this.aaAy != null) {
        i = paramInt + i.a.a.b.b.a.h(10, this.aaAy);
      }
      i = i + i.a.a.a.c(14, 8, this.YGC) + i.a.a.a.c(15, 8, this.YFB) + (i.a.a.b.b.a.ko(16) + 1) + i.a.a.a.c(17, 8, this.aaAz) + (i.a.a.b.b.a.ko(18) + 1) + i.a.a.b.b.a.cJ(19, this.yBl);
      paramInt = i;
      if (this.ytX != null) {
        paramInt = i + i.a.a.b.b.a.h(20, this.ytX);
      }
      i = paramInt + i.a.a.a.c(21, 8, this.aaAB) + i.a.a.b.b.a.cJ(22, this.ZqA);
      paramInt = i;
      if (this.aaAC != null) {
        paramInt = i + i.a.a.a.qC(23, this.aaAC.computeSize());
      }
      i = i.a.a.b.b.a.ko(24);
      int j = i.a.a.a.c(25, 8, this.ZqB);
      AppMethodBeat.o(32280);
      return paramInt + (i + 1) + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aaAu.clear();
        this.aaAv.clear();
        this.aaAw.clear();
        this.YGC.clear();
        this.YFB.clear();
        this.aaAz.clear();
        this.aaAB.clear();
        this.ZqB.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32280);
          throw paramVarArgs;
        }
        if (this.aaAt == null)
        {
          paramVarArgs = new b("Not all required fields were included: coverurl");
          AppMethodBeat.o(32280);
          throw paramVarArgs;
        }
        if (this.ytY == null)
        {
          paramVarArgs = new b("Not all required fields were included: motto");
          AppMethodBeat.o(32280);
          throw paramVarArgs;
        }
        if (this.Zqy == null)
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
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cuz localcuz = (cuz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 11: 
        case 12: 
        case 13: 
        default: 
          AppMethodBeat.o(32280);
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
            localcuz.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32280);
          return 0;
        case 2: 
          localcuz.aaAt = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32280);
          return 0;
        case 3: 
          localcuz.ytY = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32280);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gny();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gny)localObject2).parseFrom((byte[])localObject1);
            }
            localcuz.Zqy = ((gny)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32280);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new goa();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((goa)localObject2).parseFrom((byte[])localObject1);
            }
            localcuz.aaAu.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32280);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gnz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gnz)localObject2).parseFrom((byte[])localObject1);
            }
            localcuz.aaAv.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32280);
          return 0;
        case 7: 
          localcuz.source = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32280);
          return 0;
        case 8: 
          localcuz.aaAw.add(((i.a.a.a.a)localObject1).ajGk.readString());
          AppMethodBeat.o(32280);
          return 0;
        case 9: 
          localcuz.aaAx = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32280);
          return 0;
        case 10: 
          localcuz.aaAy = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32280);
          return 0;
        case 14: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fhw();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fhw)localObject2).parseFrom((byte[])localObject1);
            }
            localcuz.YGC.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32280);
          return 0;
        case 15: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bzo();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bzo)localObject2).parseFrom((byte[])localObject1);
            }
            localcuz.YFB.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32280);
          return 0;
        case 16: 
          localcuz.yug = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(32280);
          return 0;
        case 17: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new tk();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((tk)localObject2).parseFrom((byte[])localObject1);
            }
            localcuz.aaAz.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32280);
          return 0;
        case 18: 
          localcuz.aaAA = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(32280);
          return 0;
        case 19: 
          localcuz.yBl = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32280);
          return 0;
        case 20: 
          localcuz.ytX = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32280);
          return 0;
        case 21: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fhc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fhc)localObject2).parseFrom((byte[])localObject1);
            }
            localcuz.aaAB.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32280);
          return 0;
        case 22: 
          localcuz.ZqA = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32280);
          return 0;
        case 23: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gnw();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gnw)localObject2).parseFrom((byte[])localObject1);
            }
            localcuz.aaAC = ((gnw)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32280);
          return 0;
        case 24: 
          localcuz.LXq = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(32280);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fhb();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fhb)localObject2).parseFrom((byte[])localObject1);
          }
          localcuz.ZqB.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(32280);
        return 0;
      }
      AppMethodBeat.o(32280);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cuz
 * JD-Core Version:    0.7.0.1
 */