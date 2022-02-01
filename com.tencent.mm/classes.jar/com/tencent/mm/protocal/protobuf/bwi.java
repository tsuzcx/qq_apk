package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class bwi
  extends esc
{
  public bve ACr;
  public int BeA;
  public bwe BeF;
  public int Bez;
  public com.tencent.mm.bx.b ZIF;
  public bku ZKN;
  public String ZlL;
  public String aafa;
  public String aafb;
  public int aafc;
  public int aafd;
  public int aafe;
  public avp aaff;
  public int aafg;
  public bxw aafh;
  public auk aafi;
  public String aafj;
  public bwf aafk;
  public String aafl;
  public bwk aafm;
  public com.tencent.mm.bx.b lastBuffer;
  public LinkedList<FinderObject> liveObjects;
  public LinkedList<FinderObject> object;
  public btc preloadInfo;
  
  public bwi()
  {
    AppMethodBeat.i(169057);
    this.object = new LinkedList();
    this.liveObjects = new LinkedList();
    AppMethodBeat.o(169057);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169058);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(169058);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.object);
      if (this.lastBuffer != null) {
        paramVarArgs.d(3, this.lastBuffer);
      }
      if (this.aafa != null) {
        paramVarArgs.g(4, this.aafa);
      }
      if (this.aafb != null) {
        paramVarArgs.g(5, this.aafb);
      }
      paramVarArgs.bS(6, this.Bez);
      paramVarArgs.bS(7, this.aafc);
      paramVarArgs.bS(8, this.aafd);
      paramVarArgs.bS(9, this.aafe);
      if (this.preloadInfo != null)
      {
        paramVarArgs.qD(10, this.preloadInfo.computeSize());
        this.preloadInfo.writeFields(paramVarArgs);
      }
      if (this.aaff != null)
      {
        paramVarArgs.qD(11, this.aaff.computeSize());
        this.aaff.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(12, this.aafg);
      paramVarArgs.e(13, 8, this.liveObjects);
      if (this.aafh != null)
      {
        paramVarArgs.qD(14, this.aafh.computeSize());
        this.aafh.writeFields(paramVarArgs);
      }
      if (this.aafi != null)
      {
        paramVarArgs.qD(15, this.aafi.computeSize());
        this.aafi.writeFields(paramVarArgs);
      }
      if (this.aafj != null) {
        paramVarArgs.g(16, this.aafj);
      }
      if (this.ACr != null)
      {
        paramVarArgs.qD(17, this.ACr.computeSize());
        this.ACr.writeFields(paramVarArgs);
      }
      if (this.aafk != null)
      {
        paramVarArgs.qD(18, this.aafk.computeSize());
        this.aafk.writeFields(paramVarArgs);
      }
      if (this.BeF != null)
      {
        paramVarArgs.qD(19, this.BeF.computeSize());
        this.BeF.writeFields(paramVarArgs);
      }
      if (this.ZlL != null) {
        paramVarArgs.g(20, this.ZlL);
      }
      if (this.ZKN != null)
      {
        paramVarArgs.qD(21, this.ZKN.computeSize());
        this.ZKN.writeFields(paramVarArgs);
      }
      if (this.ZIF != null) {
        paramVarArgs.d(22, this.ZIF);
      }
      if (this.aafl != null) {
        paramVarArgs.g(23, this.aafl);
      }
      paramVarArgs.bS(24, this.BeA);
      if (this.aafm != null)
      {
        paramVarArgs.qD(25, this.aafm.computeSize());
        this.aafm.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(169058);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2474;
      }
    }
    label2474:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.object);
      paramInt = i;
      if (this.lastBuffer != null) {
        paramInt = i + i.a.a.b.b.a.c(3, this.lastBuffer);
      }
      i = paramInt;
      if (this.aafa != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.aafa);
      }
      paramInt = i;
      if (this.aafb != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.aafb);
      }
      i = paramInt + i.a.a.b.b.a.cJ(6, this.Bez) + i.a.a.b.b.a.cJ(7, this.aafc) + i.a.a.b.b.a.cJ(8, this.aafd) + i.a.a.b.b.a.cJ(9, this.aafe);
      paramInt = i;
      if (this.preloadInfo != null) {
        paramInt = i + i.a.a.a.qC(10, this.preloadInfo.computeSize());
      }
      i = paramInt;
      if (this.aaff != null) {
        i = paramInt + i.a.a.a.qC(11, this.aaff.computeSize());
      }
      i = i + i.a.a.b.b.a.cJ(12, this.aafg) + i.a.a.a.c(13, 8, this.liveObjects);
      paramInt = i;
      if (this.aafh != null) {
        paramInt = i + i.a.a.a.qC(14, this.aafh.computeSize());
      }
      i = paramInt;
      if (this.aafi != null) {
        i = paramInt + i.a.a.a.qC(15, this.aafi.computeSize());
      }
      paramInt = i;
      if (this.aafj != null) {
        paramInt = i + i.a.a.b.b.a.h(16, this.aafj);
      }
      i = paramInt;
      if (this.ACr != null) {
        i = paramInt + i.a.a.a.qC(17, this.ACr.computeSize());
      }
      paramInt = i;
      if (this.aafk != null) {
        paramInt = i + i.a.a.a.qC(18, this.aafk.computeSize());
      }
      i = paramInt;
      if (this.BeF != null) {
        i = paramInt + i.a.a.a.qC(19, this.BeF.computeSize());
      }
      paramInt = i;
      if (this.ZlL != null) {
        paramInt = i + i.a.a.b.b.a.h(20, this.ZlL);
      }
      i = paramInt;
      if (this.ZKN != null) {
        i = paramInt + i.a.a.a.qC(21, this.ZKN.computeSize());
      }
      paramInt = i;
      if (this.ZIF != null) {
        paramInt = i + i.a.a.b.b.a.c(22, this.ZIF);
      }
      i = paramInt;
      if (this.aafl != null) {
        i = paramInt + i.a.a.b.b.a.h(23, this.aafl);
      }
      i += i.a.a.b.b.a.cJ(24, this.BeA);
      paramInt = i;
      if (this.aafm != null) {
        paramInt = i + i.a.a.a.qC(25, this.aafm.computeSize());
      }
      AppMethodBeat.o(169058);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.object.clear();
        this.liveObjects.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(169058);
          throw paramVarArgs;
        }
        AppMethodBeat.o(169058);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bwi localbwi = (bwi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169058);
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
            localbwi.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169058);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new FinderObject();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((FinderObject)localObject2).parseFrom((byte[])localObject1);
            }
            localbwi.object.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169058);
          return 0;
        case 3: 
          localbwi.lastBuffer = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(169058);
          return 0;
        case 4: 
          localbwi.aafa = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(169058);
          return 0;
        case 5: 
          localbwi.aafb = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(169058);
          return 0;
        case 6: 
          localbwi.Bez = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(169058);
          return 0;
        case 7: 
          localbwi.aafc = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(169058);
          return 0;
        case 8: 
          localbwi.aafd = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(169058);
          return 0;
        case 9: 
          localbwi.aafe = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(169058);
          return 0;
        case 10: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new btc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((btc)localObject2).parseFrom((byte[])localObject1);
            }
            localbwi.preloadInfo = ((btc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169058);
          return 0;
        case 11: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new avp();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((avp)localObject2).parseFrom((byte[])localObject1);
            }
            localbwi.aaff = ((avp)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169058);
          return 0;
        case 12: 
          localbwi.aafg = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(169058);
          return 0;
        case 13: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new FinderObject();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((FinderObject)localObject2).parseFrom((byte[])localObject1);
            }
            localbwi.liveObjects.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169058);
          return 0;
        case 14: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bxw();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bxw)localObject2).parseFrom((byte[])localObject1);
            }
            localbwi.aafh = ((bxw)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169058);
          return 0;
        case 15: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new auk();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((auk)localObject2).parseFrom((byte[])localObject1);
            }
            localbwi.aafi = ((auk)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169058);
          return 0;
        case 16: 
          localbwi.aafj = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(169058);
          return 0;
        case 17: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bve();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bve)localObject2).parseFrom((byte[])localObject1);
            }
            localbwi.ACr = ((bve)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169058);
          return 0;
        case 18: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bwf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bwf)localObject2).parseFrom((byte[])localObject1);
            }
            localbwi.aafk = ((bwf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169058);
          return 0;
        case 19: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bwe();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bwe)localObject2).parseFrom((byte[])localObject1);
            }
            localbwi.BeF = ((bwe)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169058);
          return 0;
        case 20: 
          localbwi.ZlL = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(169058);
          return 0;
        case 21: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bku();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bku)localObject2).parseFrom((byte[])localObject1);
            }
            localbwi.ZKN = ((bku)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169058);
          return 0;
        case 22: 
          localbwi.ZIF = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(169058);
          return 0;
        case 23: 
          localbwi.aafl = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(169058);
          return 0;
        case 24: 
          localbwi.BeA = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(169058);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bwk();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bwk)localObject2).parseFrom((byte[])localObject1);
          }
          localbwi.aafm = ((bwk)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(169058);
        return 0;
      }
      AppMethodBeat.o(169058);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bwi
 * JD-Core Version:    0.7.0.1
 */