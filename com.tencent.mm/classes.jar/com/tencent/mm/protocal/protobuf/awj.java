package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class awj
  extends dyy
{
  public ayk SEV;
  public int SEX;
  public LinkedList<String> SFd;
  public LinkedList<bdb> SHa;
  public aza SHm;
  public LinkedList<axc> SID;
  public int SIE;
  public long SIF;
  public bau SIQ;
  public bdf SIR;
  public bcs SIS;
  public awl SIT;
  public int SIU;
  public bln SIV;
  public String SIW;
  public axb SIX;
  public dou SIY;
  public azh SIZ;
  public aqi SJa;
  public aze SJb;
  public crw kvP;
  public bac liveInfo;
  public bdm location;
  public String verify_info_buf;
  public b xak;
  
  public awj()
  {
    AppMethodBeat.i(230565);
    this.SHa = new LinkedList();
    this.SID = new LinkedList();
    this.SFd = new LinkedList();
    AppMethodBeat.o(230565);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(230575);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.xak != null) {
        paramVarArgs.c(2, this.xak);
      }
      if (this.kvP != null)
      {
        paramVarArgs.oE(3, this.kvP.computeSize());
        this.kvP.writeFields(paramVarArgs);
      }
      if (this.liveInfo != null)
      {
        paramVarArgs.oE(4, this.liveInfo.computeSize());
        this.liveInfo.writeFields(paramVarArgs);
      }
      if (this.SIQ != null)
      {
        paramVarArgs.oE(5, this.SIQ.computeSize());
        this.SIQ.writeFields(paramVarArgs);
      }
      if (this.SIR != null)
      {
        paramVarArgs.oE(6, this.SIR.computeSize());
        this.SIR.writeFields(paramVarArgs);
      }
      if (this.SIS != null)
      {
        paramVarArgs.oE(7, this.SIS.computeSize());
        this.SIS.writeFields(paramVarArgs);
      }
      if (this.SHm != null)
      {
        paramVarArgs.oE(8, this.SHm.computeSize());
        this.SHm.writeFields(paramVarArgs);
      }
      if (this.SIT != null)
      {
        paramVarArgs.oE(9, this.SIT.computeSize());
        this.SIT.writeFields(paramVarArgs);
      }
      paramVarArgs.e(10, 8, this.SHa);
      paramVarArgs.e(11, 8, this.SID);
      paramVarArgs.aY(12, this.SIE);
      paramVarArgs.aY(13, this.SIU);
      paramVarArgs.bm(14, this.SIF);
      if (this.verify_info_buf != null) {
        paramVarArgs.f(15, this.verify_info_buf);
      }
      if (this.location != null)
      {
        paramVarArgs.oE(16, this.location.computeSize());
        this.location.writeFields(paramVarArgs);
      }
      if (this.SIV != null)
      {
        paramVarArgs.oE(17, this.SIV.computeSize());
        this.SIV.writeFields(paramVarArgs);
      }
      if (this.SIW != null) {
        paramVarArgs.f(18, this.SIW);
      }
      paramVarArgs.e(19, 1, this.SFd);
      if (this.SIX != null)
      {
        paramVarArgs.oE(20, this.SIX.computeSize());
        this.SIX.writeFields(paramVarArgs);
      }
      if (this.SIY != null)
      {
        paramVarArgs.oE(21, this.SIY.computeSize());
        this.SIY.writeFields(paramVarArgs);
      }
      if (this.SEV != null)
      {
        paramVarArgs.oE(22, this.SEV.computeSize());
        this.SEV.writeFields(paramVarArgs);
      }
      if (this.SIZ != null)
      {
        paramVarArgs.oE(23, this.SIZ.computeSize());
        this.SIZ.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(24, this.SEX);
      if (this.SJa != null)
      {
        paramVarArgs.oE(25, this.SJa.computeSize());
        this.SJa.writeFields(paramVarArgs);
      }
      if (this.SJb != null)
      {
        paramVarArgs.oE(26, this.SJb.computeSize());
        this.SJb.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(230575);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2950;
      }
    }
    label2950:
    for (int i = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xak != null) {
        paramInt = i + g.a.a.b.b.a.b(2, this.xak);
      }
      i = paramInt;
      if (this.kvP != null) {
        i = paramInt + g.a.a.a.oD(3, this.kvP.computeSize());
      }
      paramInt = i;
      if (this.liveInfo != null) {
        paramInt = i + g.a.a.a.oD(4, this.liveInfo.computeSize());
      }
      i = paramInt;
      if (this.SIQ != null) {
        i = paramInt + g.a.a.a.oD(5, this.SIQ.computeSize());
      }
      paramInt = i;
      if (this.SIR != null) {
        paramInt = i + g.a.a.a.oD(6, this.SIR.computeSize());
      }
      i = paramInt;
      if (this.SIS != null) {
        i = paramInt + g.a.a.a.oD(7, this.SIS.computeSize());
      }
      paramInt = i;
      if (this.SHm != null) {
        paramInt = i + g.a.a.a.oD(8, this.SHm.computeSize());
      }
      i = paramInt;
      if (this.SIT != null) {
        i = paramInt + g.a.a.a.oD(9, this.SIT.computeSize());
      }
      i = i + g.a.a.a.c(10, 8, this.SHa) + g.a.a.a.c(11, 8, this.SID) + g.a.a.b.b.a.bM(12, this.SIE) + g.a.a.b.b.a.bM(13, this.SIU) + g.a.a.b.b.a.p(14, this.SIF);
      paramInt = i;
      if (this.verify_info_buf != null) {
        paramInt = i + g.a.a.b.b.a.g(15, this.verify_info_buf);
      }
      i = paramInt;
      if (this.location != null) {
        i = paramInt + g.a.a.a.oD(16, this.location.computeSize());
      }
      paramInt = i;
      if (this.SIV != null) {
        paramInt = i + g.a.a.a.oD(17, this.SIV.computeSize());
      }
      i = paramInt;
      if (this.SIW != null) {
        i = paramInt + g.a.a.b.b.a.g(18, this.SIW);
      }
      i += g.a.a.a.c(19, 1, this.SFd);
      paramInt = i;
      if (this.SIX != null) {
        paramInt = i + g.a.a.a.oD(20, this.SIX.computeSize());
      }
      i = paramInt;
      if (this.SIY != null) {
        i = paramInt + g.a.a.a.oD(21, this.SIY.computeSize());
      }
      paramInt = i;
      if (this.SEV != null) {
        paramInt = i + g.a.a.a.oD(22, this.SEV.computeSize());
      }
      i = paramInt;
      if (this.SIZ != null) {
        i = paramInt + g.a.a.a.oD(23, this.SIZ.computeSize());
      }
      i += g.a.a.b.b.a.bM(24, this.SEX);
      paramInt = i;
      if (this.SJa != null) {
        paramInt = i + g.a.a.a.oD(25, this.SJa.computeSize());
      }
      i = paramInt;
      if (this.SJb != null) {
        i = paramInt + g.a.a.a.oD(26, this.SJb.computeSize());
      }
      AppMethodBeat.o(230575);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.SHa.clear();
        this.SID.clear();
        this.SFd.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(230575);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        awj localawj = (awj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(230575);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jh)localObject2).parseFrom((byte[])localObject1);
            }
            localawj.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(230575);
          return 0;
        case 2: 
          localawj.xak = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(230575);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new crw();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((crw)localObject2).parseFrom((byte[])localObject1);
            }
            localawj.kvP = ((crw)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(230575);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bac();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bac)localObject2).parseFrom((byte[])localObject1);
            }
            localawj.liveInfo = ((bac)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(230575);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bau();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bau)localObject2).parseFrom((byte[])localObject1);
            }
            localawj.SIQ = ((bau)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(230575);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bdf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bdf)localObject2).parseFrom((byte[])localObject1);
            }
            localawj.SIR = ((bdf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(230575);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bcs();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bcs)localObject2).parseFrom((byte[])localObject1);
            }
            localawj.SIS = ((bcs)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(230575);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aza();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aza)localObject2).parseFrom((byte[])localObject1);
            }
            localawj.SHm = ((aza)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(230575);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new awl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((awl)localObject2).parseFrom((byte[])localObject1);
            }
            localawj.SIT = ((awl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(230575);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bdb();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bdb)localObject2).parseFrom((byte[])localObject1);
            }
            localawj.SHa.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(230575);
          return 0;
        case 11: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new axc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((axc)localObject2).parseFrom((byte[])localObject1);
            }
            localawj.SID.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(230575);
          return 0;
        case 12: 
          localawj.SIE = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(230575);
          return 0;
        case 13: 
          localawj.SIU = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(230575);
          return 0;
        case 14: 
          localawj.SIF = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(230575);
          return 0;
        case 15: 
          localawj.verify_info_buf = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(230575);
          return 0;
        case 16: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bdm();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bdm)localObject2).parseFrom((byte[])localObject1);
            }
            localawj.location = ((bdm)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(230575);
          return 0;
        case 17: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bln();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bln)localObject2).parseFrom((byte[])localObject1);
            }
            localawj.SIV = ((bln)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(230575);
          return 0;
        case 18: 
          localawj.SIW = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(230575);
          return 0;
        case 19: 
          localawj.SFd.add(((g.a.a.a.a)localObject1).abFh.readString());
          AppMethodBeat.o(230575);
          return 0;
        case 20: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new axb();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((axb)localObject2).parseFrom((byte[])localObject1);
            }
            localawj.SIX = ((axb)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(230575);
          return 0;
        case 21: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dou();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dou)localObject2).parseFrom((byte[])localObject1);
            }
            localawj.SIY = ((dou)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(230575);
          return 0;
        case 22: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ayk();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ayk)localObject2).parseFrom((byte[])localObject1);
            }
            localawj.SEV = ((ayk)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(230575);
          return 0;
        case 23: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new azh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((azh)localObject2).parseFrom((byte[])localObject1);
            }
            localawj.SIZ = ((azh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(230575);
          return 0;
        case 24: 
          localawj.SEX = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(230575);
          return 0;
        case 25: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aqi();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aqi)localObject2).parseFrom((byte[])localObject1);
            }
            localawj.SJa = ((aqi)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(230575);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new aze();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((aze)localObject2).parseFrom((byte[])localObject1);
          }
          localawj.SJb = ((aze)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(230575);
        return 0;
      }
      AppMethodBeat.o(230575);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.awj
 * JD-Core Version:    0.7.0.1
 */