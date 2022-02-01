package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dnk
  extends com.tencent.mm.bx.a
{
  public String EVK;
  public int GtH;
  public LinkedList<dod> Guf;
  public String Gux;
  public int Guy;
  public int ZHp;
  public int ZHq;
  public int ZHr;
  public int ZHu;
  public int ZHw;
  public int ZHx;
  public int aaUI;
  public int aaUJ;
  public int aaUK;
  public long aaUL;
  public int duration;
  public long feedId;
  public String hVy;
  public int networkId;
  public int sDa;
  public int scene;
  
  public dnk()
  {
    AppMethodBeat.i(258542);
    this.Guf = new LinkedList();
    AppMethodBeat.o(258542);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258548);
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
      paramVarArgs.bS(8, this.aaUI);
      paramVarArgs.bS(9, this.aaUJ);
      paramVarArgs.bS(10, this.ZHu);
      paramVarArgs.e(11, 8, this.Guf);
      paramVarArgs.bS(12, this.aaUK);
      paramVarArgs.bS(13, this.GtH);
      paramVarArgs.bS(14, this.ZHw);
      if (this.EVK != null) {
        paramVarArgs.g(15, this.EVK);
      }
      paramVarArgs.bv(16, this.aaUL);
      paramVarArgs.bS(17, this.ZHx);
      paramVarArgs.bS(18, this.networkId);
      if (this.Gux != null) {
        paramVarArgs.g(19, this.Gux);
      }
      paramVarArgs.bS(20, this.Guy);
      if (this.hVy != null) {
        paramVarArgs.g(21, this.hVy);
      }
      AppMethodBeat.o(258548);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.q(1, this.feedId) + 0 + i.a.a.b.b.a.cJ(2, this.ZHp) + i.a.a.b.b.a.cJ(3, this.scene) + i.a.a.b.b.a.cJ(4, this.ZHq) + i.a.a.b.b.a.cJ(5, this.sDa) + i.a.a.b.b.a.cJ(6, this.ZHr) + i.a.a.b.b.a.cJ(7, this.duration) + i.a.a.b.b.a.cJ(8, this.aaUI) + i.a.a.b.b.a.cJ(9, this.aaUJ) + i.a.a.b.b.a.cJ(10, this.ZHu) + i.a.a.a.c(11, 8, this.Guf) + i.a.a.b.b.a.cJ(12, this.aaUK) + i.a.a.b.b.a.cJ(13, this.GtH) + i.a.a.b.b.a.cJ(14, this.ZHw);
      paramInt = i;
      if (this.EVK != null) {
        paramInt = i + i.a.a.b.b.a.h(15, this.EVK);
      }
      i = paramInt + i.a.a.b.b.a.q(16, this.aaUL) + i.a.a.b.b.a.cJ(17, this.ZHx) + i.a.a.b.b.a.cJ(18, this.networkId);
      paramInt = i;
      if (this.Gux != null) {
        paramInt = i + i.a.a.b.b.a.h(19, this.Gux);
      }
      i = paramInt + i.a.a.b.b.a.cJ(20, this.Guy);
      paramInt = i;
      if (this.hVy != null) {
        paramInt = i + i.a.a.b.b.a.h(21, this.hVy);
      }
      AppMethodBeat.o(258548);
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
      AppMethodBeat.o(258548);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      dnk localdnk = (dnk)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(258548);
        return -1;
      case 1: 
        localdnk.feedId = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(258548);
        return 0;
      case 2: 
        localdnk.ZHp = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(258548);
        return 0;
      case 3: 
        localdnk.scene = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(258548);
        return 0;
      case 4: 
        localdnk.ZHq = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(258548);
        return 0;
      case 5: 
        localdnk.sDa = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(258548);
        return 0;
      case 6: 
        localdnk.ZHr = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(258548);
        return 0;
      case 7: 
        localdnk.duration = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(258548);
        return 0;
      case 8: 
        localdnk.aaUI = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(258548);
        return 0;
      case 9: 
        localdnk.aaUJ = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(258548);
        return 0;
      case 10: 
        localdnk.ZHu = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(258548);
        return 0;
      case 11: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          dod localdod = new dod();
          if ((localObject != null) && (localObject.length > 0)) {
            localdod.parseFrom((byte[])localObject);
          }
          localdnk.Guf.add(localdod);
          paramInt += 1;
        }
        AppMethodBeat.o(258548);
        return 0;
      case 12: 
        localdnk.aaUK = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(258548);
        return 0;
      case 13: 
        localdnk.GtH = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(258548);
        return 0;
      case 14: 
        localdnk.ZHw = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(258548);
        return 0;
      case 15: 
        localdnk.EVK = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(258548);
        return 0;
      case 16: 
        localdnk.aaUL = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(258548);
        return 0;
      case 17: 
        localdnk.ZHx = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(258548);
        return 0;
      case 18: 
        localdnk.networkId = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(258548);
        return 0;
      case 19: 
        localdnk.Gux = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(258548);
        return 0;
      case 20: 
        localdnk.Guy = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(258548);
        return 0;
      }
      localdnk.hVy = ((i.a.a.a.a)localObject).ajGk.readString();
      AppMethodBeat.o(258548);
      return 0;
    }
    AppMethodBeat.o(258548);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dnk
 * JD-Core Version:    0.7.0.1
 */