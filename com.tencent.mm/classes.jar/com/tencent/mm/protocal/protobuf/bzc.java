package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bzc
  extends com.tencent.mm.bx.a
{
  public String DUT;
  public long DVk;
  public LinkedList<String> DVl;
  public int DVm;
  public int DVn;
  public int DVo;
  public aka DVp;
  public aka DVq;
  public int DVr;
  public int DVs;
  public int DVt;
  public String DVu;
  public long ZRl;
  public String ZVe;
  public bms aaie;
  public int aaif;
  public LinkedList<agn> aaig;
  public aoj aaih;
  public String aaii;
  public ehg aaij;
  public String aaik;
  public String mdE;
  public int replay_status;
  public String request_id;
  public int status;
  public String title;
  public String wul;
  
  public bzc()
  {
    AppMethodBeat.i(257709);
    this.DVl = new LinkedList();
    this.aaig = new LinkedList();
    AppMethodBeat.o(257709);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257718);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.DVk);
      if (this.title != null) {
        paramVarArgs.g(2, this.title);
      }
      paramVarArgs.e(3, 1, this.DVl);
      paramVarArgs.bS(4, this.DVm);
      paramVarArgs.bS(5, this.DVn);
      paramVarArgs.bS(6, this.DVo);
      paramVarArgs.bS(7, this.status);
      if (this.DUT != null) {
        paramVarArgs.g(8, this.DUT);
      }
      if (this.DVp != null)
      {
        paramVarArgs.qD(9, this.DVp.computeSize());
        this.DVp.writeFields(paramVarArgs);
      }
      if (this.DVq != null)
      {
        paramVarArgs.qD(10, this.DVq.computeSize());
        this.DVq.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(11, this.DVr);
      paramVarArgs.bS(12, this.DVs);
      paramVarArgs.bS(13, this.DVt);
      if (this.DVu != null) {
        paramVarArgs.g(14, this.DVu);
      }
      if (this.mdE != null) {
        paramVarArgs.g(15, this.mdE);
      }
      if (this.wul != null) {
        paramVarArgs.g(16, this.wul);
      }
      if (this.aaie != null)
      {
        paramVarArgs.qD(17, this.aaie.computeSize());
        this.aaie.writeFields(paramVarArgs);
      }
      if (this.request_id != null) {
        paramVarArgs.g(18, this.request_id);
      }
      paramVarArgs.bS(19, this.aaif);
      paramVarArgs.e(20, 8, this.aaig);
      if (this.aaih != null)
      {
        paramVarArgs.qD(24, this.aaih.computeSize());
        this.aaih.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(25, this.ZRl);
      paramVarArgs.bS(26, this.replay_status);
      if (this.aaii != null) {
        paramVarArgs.g(27, this.aaii);
      }
      if (this.aaij != null)
      {
        paramVarArgs.qD(28, this.aaij.computeSize());
        this.aaij.writeFields(paramVarArgs);
      }
      if (this.aaik != null) {
        paramVarArgs.g(29, this.aaik);
      }
      if (this.ZVe != null) {
        paramVarArgs.g(30, this.ZVe);
      }
      AppMethodBeat.o(257718);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.q(1, this.DVk) + 0;
      paramInt = i;
      if (this.title != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.title);
      }
      i = paramInt + i.a.a.a.c(3, 1, this.DVl) + i.a.a.b.b.a.cJ(4, this.DVm) + i.a.a.b.b.a.cJ(5, this.DVn) + i.a.a.b.b.a.cJ(6, this.DVo) + i.a.a.b.b.a.cJ(7, this.status);
      paramInt = i;
      if (this.DUT != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.DUT);
      }
      i = paramInt;
      if (this.DVp != null) {
        i = paramInt + i.a.a.a.qC(9, this.DVp.computeSize());
      }
      paramInt = i;
      if (this.DVq != null) {
        paramInt = i + i.a.a.a.qC(10, this.DVq.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(11, this.DVr) + i.a.a.b.b.a.cJ(12, this.DVs) + i.a.a.b.b.a.cJ(13, this.DVt);
      paramInt = i;
      if (this.DVu != null) {
        paramInt = i + i.a.a.b.b.a.h(14, this.DVu);
      }
      i = paramInt;
      if (this.mdE != null) {
        i = paramInt + i.a.a.b.b.a.h(15, this.mdE);
      }
      paramInt = i;
      if (this.wul != null) {
        paramInt = i + i.a.a.b.b.a.h(16, this.wul);
      }
      i = paramInt;
      if (this.aaie != null) {
        i = paramInt + i.a.a.a.qC(17, this.aaie.computeSize());
      }
      paramInt = i;
      if (this.request_id != null) {
        paramInt = i + i.a.a.b.b.a.h(18, this.request_id);
      }
      i = paramInt + i.a.a.b.b.a.cJ(19, this.aaif) + i.a.a.a.c(20, 8, this.aaig);
      paramInt = i;
      if (this.aaih != null) {
        paramInt = i + i.a.a.a.qC(24, this.aaih.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.q(25, this.ZRl) + i.a.a.b.b.a.cJ(26, this.replay_status);
      paramInt = i;
      if (this.aaii != null) {
        paramInt = i + i.a.a.b.b.a.h(27, this.aaii);
      }
      i = paramInt;
      if (this.aaij != null) {
        i = paramInt + i.a.a.a.qC(28, this.aaij.computeSize());
      }
      paramInt = i;
      if (this.aaik != null) {
        paramInt = i + i.a.a.b.b.a.h(29, this.aaik);
      }
      i = paramInt;
      if (this.ZVe != null) {
        i = paramInt + i.a.a.b.b.a.h(30, this.ZVe);
      }
      AppMethodBeat.o(257718);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.DVl.clear();
      this.aaig.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(257718);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      bzc localbzc = (bzc)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      case 21: 
      case 22: 
      case 23: 
      default: 
        AppMethodBeat.o(257718);
        return -1;
      case 1: 
        localbzc.DVk = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(257718);
        return 0;
      case 2: 
        localbzc.title = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(257718);
        return 0;
      case 3: 
        localbzc.DVl.add(((i.a.a.a.a)localObject1).ajGk.readString());
        AppMethodBeat.o(257718);
        return 0;
      case 4: 
        localbzc.DVm = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(257718);
        return 0;
      case 5: 
        localbzc.DVn = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(257718);
        return 0;
      case 6: 
        localbzc.DVo = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(257718);
        return 0;
      case 7: 
        localbzc.status = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(257718);
        return 0;
      case 8: 
        localbzc.DUT = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(257718);
        return 0;
      case 9: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new aka();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((aka)localObject2).parseFrom((byte[])localObject1);
          }
          localbzc.DVp = ((aka)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(257718);
        return 0;
      case 10: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new aka();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((aka)localObject2).parseFrom((byte[])localObject1);
          }
          localbzc.DVq = ((aka)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(257718);
        return 0;
      case 11: 
        localbzc.DVr = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(257718);
        return 0;
      case 12: 
        localbzc.DVs = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(257718);
        return 0;
      case 13: 
        localbzc.DVt = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(257718);
        return 0;
      case 14: 
        localbzc.DVu = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(257718);
        return 0;
      case 15: 
        localbzc.mdE = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(257718);
        return 0;
      case 16: 
        localbzc.wul = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(257718);
        return 0;
      case 17: 
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
          localbzc.aaie = ((bms)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(257718);
        return 0;
      case 18: 
        localbzc.request_id = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(257718);
        return 0;
      case 19: 
        localbzc.aaif = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(257718);
        return 0;
      case 20: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new agn();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((agn)localObject2).parseFrom((byte[])localObject1);
          }
          localbzc.aaig.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(257718);
        return 0;
      case 24: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new aoj();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((aoj)localObject2).parseFrom((byte[])localObject1);
          }
          localbzc.aaih = ((aoj)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(257718);
        return 0;
      case 25: 
        localbzc.ZRl = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(257718);
        return 0;
      case 26: 
        localbzc.replay_status = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(257718);
        return 0;
      case 27: 
        localbzc.aaii = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(257718);
        return 0;
      case 28: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ehg();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ehg)localObject2).parseFrom((byte[])localObject1);
          }
          localbzc.aaij = ((ehg)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(257718);
        return 0;
      case 29: 
        localbzc.aaik = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(257718);
        return 0;
      }
      localbzc.ZVe = ((i.a.a.a.a)localObject1).ajGk.readString();
      AppMethodBeat.o(257718);
      return 0;
    }
    AppMethodBeat.o(257718);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bzc
 * JD-Core Version:    0.7.0.1
 */