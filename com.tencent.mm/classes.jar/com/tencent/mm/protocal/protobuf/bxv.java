package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bxv
  extends com.tencent.mm.bx.a
{
  public long ADo;
  public String ADp;
  public int Auy;
  public bqj ZHW;
  public int aagE;
  public int aagF;
  public int aagG;
  public bxt aagH;
  public int aagI;
  public int aagJ;
  public awt aagK;
  public int aagL;
  public String coverUrl;
  public int feedCount;
  public int followFlag;
  public int friendFollowCount;
  public String mdQ;
  public bxm tmpl_info;
  public String topic;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258210);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.topic != null) {
        paramVarArgs.g(1, this.topic);
      }
      paramVarArgs.bv(2, this.ADo);
      paramVarArgs.bS(3, this.feedCount);
      if (this.ADp != null) {
        paramVarArgs.g(4, this.ADp);
      }
      paramVarArgs.bS(5, this.Auy);
      paramVarArgs.bS(6, this.followFlag);
      if (this.coverUrl != null) {
        paramVarArgs.g(7, this.coverUrl);
      }
      paramVarArgs.bS(8, this.friendFollowCount);
      paramVarArgs.bS(9, this.aagE);
      paramVarArgs.bS(10, this.aagF);
      if (this.ZHW != null)
      {
        paramVarArgs.qD(11, this.ZHW.computeSize());
        this.ZHW.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(12, this.aagG);
      if (this.aagH != null)
      {
        paramVarArgs.qD(13, this.aagH.computeSize());
        this.aagH.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(14, this.aagI);
      if (this.tmpl_info != null)
      {
        paramVarArgs.qD(15, this.tmpl_info.computeSize());
        this.tmpl_info.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(16, this.aagJ);
      if (this.aagK != null)
      {
        paramVarArgs.qD(17, this.aagK.computeSize());
        this.aagK.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(18, this.aagL);
      if (this.mdQ != null) {
        paramVarArgs.g(19, this.mdQ);
      }
      AppMethodBeat.o(258210);
      return 0;
    }
    if (paramInt == 1) {
      if (this.topic == null) {
        break label1426;
      }
    }
    label1426:
    for (paramInt = i.a.a.b.b.a.h(1, this.topic) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.q(2, this.ADo) + i.a.a.b.b.a.cJ(3, this.feedCount);
      paramInt = i;
      if (this.ADp != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.ADp);
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.Auy) + i.a.a.b.b.a.cJ(6, this.followFlag);
      paramInt = i;
      if (this.coverUrl != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.coverUrl);
      }
      i = paramInt + i.a.a.b.b.a.cJ(8, this.friendFollowCount) + i.a.a.b.b.a.cJ(9, this.aagE) + i.a.a.b.b.a.cJ(10, this.aagF);
      paramInt = i;
      if (this.ZHW != null) {
        paramInt = i + i.a.a.a.qC(11, this.ZHW.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(12, this.aagG);
      paramInt = i;
      if (this.aagH != null) {
        paramInt = i + i.a.a.a.qC(13, this.aagH.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(14, this.aagI);
      paramInt = i;
      if (this.tmpl_info != null) {
        paramInt = i + i.a.a.a.qC(15, this.tmpl_info.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(16, this.aagJ);
      paramInt = i;
      if (this.aagK != null) {
        paramInt = i + i.a.a.a.qC(17, this.aagK.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(18, this.aagL);
      paramInt = i;
      if (this.mdQ != null) {
        paramInt = i + i.a.a.b.b.a.h(19, this.mdQ);
      }
      AppMethodBeat.o(258210);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258210);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bxv localbxv = (bxv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258210);
          return -1;
        case 1: 
          localbxv.topic = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258210);
          return 0;
        case 2: 
          localbxv.ADo = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(258210);
          return 0;
        case 3: 
          localbxv.feedCount = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258210);
          return 0;
        case 4: 
          localbxv.ADp = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258210);
          return 0;
        case 5: 
          localbxv.Auy = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258210);
          return 0;
        case 6: 
          localbxv.followFlag = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258210);
          return 0;
        case 7: 
          localbxv.coverUrl = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258210);
          return 0;
        case 8: 
          localbxv.friendFollowCount = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258210);
          return 0;
        case 9: 
          localbxv.aagE = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258210);
          return 0;
        case 10: 
          localbxv.aagF = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258210);
          return 0;
        case 11: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bqj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bqj)localObject2).parseFrom((byte[])localObject1);
            }
            localbxv.ZHW = ((bqj)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258210);
          return 0;
        case 12: 
          localbxv.aagG = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258210);
          return 0;
        case 13: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bxt();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bxt)localObject2).parseFrom((byte[])localObject1);
            }
            localbxv.aagH = ((bxt)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258210);
          return 0;
        case 14: 
          localbxv.aagI = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258210);
          return 0;
        case 15: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bxm();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bxm)localObject2).parseFrom((byte[])localObject1);
            }
            localbxv.tmpl_info = ((bxm)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258210);
          return 0;
        case 16: 
          localbxv.aagJ = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258210);
          return 0;
        case 17: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new awt();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((awt)localObject2).parseFrom((byte[])localObject1);
            }
            localbxv.aagK = ((awt)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258210);
          return 0;
        case 18: 
          localbxv.aagL = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258210);
          return 0;
        }
        localbxv.mdQ = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(258210);
        return 0;
      }
      AppMethodBeat.o(258210);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bxv
 * JD-Core Version:    0.7.0.1
 */