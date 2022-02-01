package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fxz
  extends com.tencent.mm.bx.a
{
  public int LYA;
  public LinkedList<qi> YVe;
  public int ZHp;
  public String abVR;
  public String abVS;
  public long abVT;
  public LinkedList<dft> abVU;
  public boolean abVV;
  public int cHb;
  public int eventId;
  public String hJW;
  public String id;
  public long timestamp;
  public int type;
  public String typeName;
  
  public fxz()
  {
    AppMethodBeat.i(257929);
    this.id = "";
    this.abVR = "";
    this.typeName = "";
    this.hJW = "";
    this.abVS = "";
    this.eventId = 0;
    this.timestamp = 0L;
    this.abVT = 0L;
    this.ZHp = 0;
    this.YVe = new LinkedList();
    this.abVU = new LinkedList();
    this.abVV = true;
    this.type = -1;
    AppMethodBeat.o(257929);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257938);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.id != null) {
        paramVarArgs.g(1, this.id);
      }
      if (this.abVR != null) {
        paramVarArgs.g(2, this.abVR);
      }
      if (this.typeName != null) {
        paramVarArgs.g(3, this.typeName);
      }
      if (this.hJW != null) {
        paramVarArgs.g(4, this.hJW);
      }
      if (this.abVS != null) {
        paramVarArgs.g(5, this.abVS);
      }
      paramVarArgs.bS(6, this.eventId);
      paramVarArgs.bS(7, this.cHb);
      paramVarArgs.bS(8, this.LYA);
      paramVarArgs.bv(9, this.timestamp);
      paramVarArgs.bv(10, this.abVT);
      paramVarArgs.bS(11, this.ZHp);
      paramVarArgs.e(12, 8, this.YVe);
      paramVarArgs.e(13, 8, this.abVU);
      paramVarArgs.di(14, this.abVV);
      paramVarArgs.bS(15, this.type);
      AppMethodBeat.o(257938);
      return 0;
    }
    if (paramInt == 1) {
      if (this.id == null) {
        break label1078;
      }
    }
    label1078:
    for (int i = i.a.a.b.b.a.h(1, this.id) + 0;; i = 0)
    {
      paramInt = i;
      if (this.abVR != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.abVR);
      }
      i = paramInt;
      if (this.typeName != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.typeName);
      }
      paramInt = i;
      if (this.hJW != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.hJW);
      }
      i = paramInt;
      if (this.abVS != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.abVS);
      }
      paramInt = i.a.a.b.b.a.cJ(6, this.eventId);
      int j = i.a.a.b.b.a.cJ(7, this.cHb);
      int k = i.a.a.b.b.a.cJ(8, this.LYA);
      int m = i.a.a.b.b.a.q(9, this.timestamp);
      int n = i.a.a.b.b.a.q(10, this.abVT);
      int i1 = i.a.a.b.b.a.cJ(11, this.ZHp);
      int i2 = i.a.a.a.c(12, 8, this.YVe);
      int i3 = i.a.a.a.c(13, 8, this.abVU);
      int i4 = i.a.a.b.b.a.ko(14);
      int i5 = i.a.a.b.b.a.cJ(15, this.type);
      AppMethodBeat.o(257938);
      return i + paramInt + j + k + m + n + i1 + i2 + i3 + (i4 + 1) + i5;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.YVe.clear();
        this.abVU.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257938);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        fxz localfxz = (fxz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257938);
          return -1;
        case 1: 
          localfxz.id = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257938);
          return 0;
        case 2: 
          localfxz.abVR = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257938);
          return 0;
        case 3: 
          localfxz.typeName = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257938);
          return 0;
        case 4: 
          localfxz.hJW = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257938);
          return 0;
        case 5: 
          localfxz.abVS = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257938);
          return 0;
        case 6: 
          localfxz.eventId = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257938);
          return 0;
        case 7: 
          localfxz.cHb = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257938);
          return 0;
        case 8: 
          localfxz.LYA = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257938);
          return 0;
        case 9: 
          localfxz.timestamp = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(257938);
          return 0;
        case 10: 
          localfxz.abVT = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(257938);
          return 0;
        case 11: 
          localfxz.ZHp = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257938);
          return 0;
        case 12: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new qi();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((qi)localObject2).parseFrom((byte[])localObject1);
            }
            localfxz.YVe.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257938);
          return 0;
        case 13: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dft();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dft)localObject2).parseFrom((byte[])localObject1);
            }
            localfxz.abVU.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257938);
          return 0;
        case 14: 
          localfxz.abVV = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(257938);
          return 0;
        }
        localfxz.type = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(257938);
        return 0;
      }
      AppMethodBeat.o(257938);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fxz
 * JD-Core Version:    0.7.0.1
 */