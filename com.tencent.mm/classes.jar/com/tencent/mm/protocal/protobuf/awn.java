package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class awn
  extends com.tencent.mm.bx.a
{
  public String EVK;
  public long GtG;
  public int GtH;
  public LinkedList<bza> Guf;
  public String Gux;
  public int Guy;
  public akz ZHA;
  public int ZHB;
  public String ZHC;
  public int ZHp;
  public int ZHq;
  public int ZHr;
  public int ZHs;
  public int ZHt;
  public int ZHu;
  public int ZHv;
  public int ZHw;
  public int ZHx;
  public long ZHy;
  public int ZHz;
  public int duration;
  public long feedId;
  public String hVy;
  public int networkId;
  public int sDa;
  public int scene;
  
  public awn()
  {
    AppMethodBeat.i(184197);
    this.Guf = new LinkedList();
    AppMethodBeat.o(184197);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(184198);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.feedId);
      paramVarArgs.bS(2, this.ZHp);
      paramVarArgs.bS(3, this.scene);
      paramVarArgs.bS(4, this.ZHq);
      paramVarArgs.bS(5, this.sDa);
      paramVarArgs.bS(6, this.ZHr);
      paramVarArgs.bS(7, this.duration);
      paramVarArgs.bS(8, this.ZHs);
      paramVarArgs.bS(9, this.ZHt);
      paramVarArgs.bS(10, this.ZHu);
      paramVarArgs.e(11, 8, this.Guf);
      paramVarArgs.bS(12, this.ZHv);
      paramVarArgs.bS(13, this.GtH);
      paramVarArgs.bS(14, this.ZHw);
      if (this.EVK != null) {
        paramVarArgs.g(15, this.EVK);
      }
      paramVarArgs.bv(16, this.GtG);
      paramVarArgs.bS(17, this.ZHx);
      paramVarArgs.bS(18, this.networkId);
      if (this.Gux != null) {
        paramVarArgs.g(19, this.Gux);
      }
      paramVarArgs.bS(20, this.Guy);
      if (this.hVy != null) {
        paramVarArgs.g(21, this.hVy);
      }
      paramVarArgs.bv(22, this.ZHy);
      paramVarArgs.bS(23, this.ZHz);
      if (this.ZHA != null)
      {
        paramVarArgs.qD(24, this.ZHA.computeSize());
        this.ZHA.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(25, this.ZHB);
      if (this.ZHC != null) {
        paramVarArgs.g(26, this.ZHC);
      }
      AppMethodBeat.o(184198);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.q(1, this.feedId) + 0 + i.a.a.b.b.a.cJ(2, this.ZHp) + i.a.a.b.b.a.cJ(3, this.scene) + i.a.a.b.b.a.cJ(4, this.ZHq) + i.a.a.b.b.a.cJ(5, this.sDa) + i.a.a.b.b.a.cJ(6, this.ZHr) + i.a.a.b.b.a.cJ(7, this.duration) + i.a.a.b.b.a.cJ(8, this.ZHs) + i.a.a.b.b.a.cJ(9, this.ZHt) + i.a.a.b.b.a.cJ(10, this.ZHu) + i.a.a.a.c(11, 8, this.Guf) + i.a.a.b.b.a.cJ(12, this.ZHv) + i.a.a.b.b.a.cJ(13, this.GtH) + i.a.a.b.b.a.cJ(14, this.ZHw);
      paramInt = i;
      if (this.EVK != null) {
        paramInt = i + i.a.a.b.b.a.h(15, this.EVK);
      }
      i = paramInt + i.a.a.b.b.a.q(16, this.GtG) + i.a.a.b.b.a.cJ(17, this.ZHx) + i.a.a.b.b.a.cJ(18, this.networkId);
      paramInt = i;
      if (this.Gux != null) {
        paramInt = i + i.a.a.b.b.a.h(19, this.Gux);
      }
      i = paramInt + i.a.a.b.b.a.cJ(20, this.Guy);
      paramInt = i;
      if (this.hVy != null) {
        paramInt = i + i.a.a.b.b.a.h(21, this.hVy);
      }
      i = paramInt + i.a.a.b.b.a.q(22, this.ZHy) + i.a.a.b.b.a.cJ(23, this.ZHz);
      paramInt = i;
      if (this.ZHA != null) {
        paramInt = i + i.a.a.a.qC(24, this.ZHA.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(25, this.ZHB);
      paramInt = i;
      if (this.ZHC != null) {
        paramInt = i + i.a.a.b.b.a.h(26, this.ZHC);
      }
      AppMethodBeat.o(184198);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Guf.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(184198);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      awn localawn = (awn)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(184198);
        return -1;
      case 1: 
        localawn.feedId = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(184198);
        return 0;
      case 2: 
        localawn.ZHp = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(184198);
        return 0;
      case 3: 
        localawn.scene = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(184198);
        return 0;
      case 4: 
        localawn.ZHq = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(184198);
        return 0;
      case 5: 
        localawn.sDa = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(184198);
        return 0;
      case 6: 
        localawn.ZHr = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(184198);
        return 0;
      case 7: 
        localawn.duration = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(184198);
        return 0;
      case 8: 
        localawn.ZHs = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(184198);
        return 0;
      case 9: 
        localawn.ZHt = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(184198);
        return 0;
      case 10: 
        localawn.ZHu = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(184198);
        return 0;
      case 11: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bza();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bza)localObject2).parseFrom((byte[])localObject1);
          }
          localawn.Guf.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(184198);
        return 0;
      case 12: 
        localawn.ZHv = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(184198);
        return 0;
      case 13: 
        localawn.GtH = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(184198);
        return 0;
      case 14: 
        localawn.ZHw = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(184198);
        return 0;
      case 15: 
        localawn.EVK = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(184198);
        return 0;
      case 16: 
        localawn.GtG = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(184198);
        return 0;
      case 17: 
        localawn.ZHx = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(184198);
        return 0;
      case 18: 
        localawn.networkId = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(184198);
        return 0;
      case 19: 
        localawn.Gux = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(184198);
        return 0;
      case 20: 
        localawn.Guy = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(184198);
        return 0;
      case 21: 
        localawn.hVy = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(184198);
        return 0;
      case 22: 
        localawn.ZHy = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(184198);
        return 0;
      case 23: 
        localawn.ZHz = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(184198);
        return 0;
      case 24: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new akz();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((akz)localObject2).parseFrom((byte[])localObject1);
          }
          localawn.ZHA = ((akz)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(184198);
        return 0;
      case 25: 
        localawn.ZHB = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(184198);
        return 0;
      }
      localawn.ZHC = ((i.a.a.a.a)localObject1).ajGk.readString();
      AppMethodBeat.o(184198);
      return 0;
    }
    AppMethodBeat.o(184198);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.awn
 * JD-Core Version:    0.7.0.1
 */