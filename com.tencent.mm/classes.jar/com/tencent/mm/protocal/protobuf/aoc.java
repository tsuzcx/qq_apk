package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class aoc
  extends com.tencent.mm.cd.a
{
  public anu PTL;
  public anw RDh;
  public aoi SAB;
  public boolean SAC;
  public boolean SAD;
  public boolean SAE;
  public boolean SxH;
  public boolean SxI;
  public int SzA;
  public boolean SzB;
  public boolean SzC;
  public boolean SzD;
  public ank SzE;
  public boolean SzF;
  public boolean SzG;
  public bje SzJ;
  public boolean SzK;
  public ant Szp;
  public boolean Szq;
  public aor Szr;
  public boolean Szs;
  public aob Szt;
  public boolean Szu;
  public aol Szv;
  public boolean Szw;
  public boolean Szx;
  public long Szy;
  public boolean Szz;
  public String desc;
  public String remark;
  public LinkedList<anm> syG;
  public String title;
  public long uTt;
  public int version;
  
  public aoc()
  {
    AppMethodBeat.i(127473);
    this.SAC = false;
    this.syG = new LinkedList();
    this.SAD = false;
    this.Szq = false;
    this.Szs = false;
    this.Szx = false;
    this.SxH = false;
    this.SxI = false;
    this.Szz = false;
    this.SzA = -1;
    this.SzB = false;
    this.Szu = false;
    this.SzC = false;
    this.Szw = false;
    this.SAE = false;
    this.SzD = false;
    this.SzF = false;
    this.SzG = false;
    this.SzK = false;
    AppMethodBeat.o(127473);
  }
  
  public final aoc Uc(long paramLong)
  {
    this.Szy = paramLong;
    this.Szz = true;
    return this;
  }
  
  public final aoc Ud(long paramLong)
  {
    this.uTt = paramLong;
    this.SzC = true;
    return this;
  }
  
  public final aoc a(anw paramanw)
  {
    this.RDh = paramanw;
    this.SzD = true;
    return this;
  }
  
  public final aoc a(aoi paramaoi)
  {
    this.SAB = paramaoi;
    this.SAC = true;
    return this;
  }
  
  public final aoc arx(int paramInt)
  {
    this.SzA = paramInt;
    this.SzB = true;
    return this;
  }
  
  public final aoc ary(int paramInt)
  {
    this.version = paramInt;
    this.SAE = true;
    return this;
  }
  
  public final aoc b(aob paramaob)
  {
    this.Szt = paramaob;
    this.Szu = true;
    return this;
  }
  
  public final aoc b(aol paramaol)
  {
    this.Szv = paramaol;
    this.Szw = true;
    return this;
  }
  
  public final LinkedList<anm> bJY()
  {
    return this.syG;
  }
  
  public final aoc btu(String paramString)
  {
    this.remark = paramString;
    this.Szx = true;
    return this;
  }
  
  public final aoc btv(String paramString)
  {
    this.title = paramString;
    this.SxH = true;
    return this;
  }
  
  public final aoc btw(String paramString)
  {
    this.desc = paramString;
    this.SxI = true;
    return this;
  }
  
  public final aoc c(ank paramank)
  {
    this.SzE = paramank;
    this.SzF = true;
    return this;
  }
  
  public final aoc c(aor paramaor)
  {
    this.Szr = paramaor;
    this.Szs = true;
    return this;
  }
  
  public final aoc cg(LinkedList<anm> paramLinkedList)
  {
    this.syG = paramLinkedList;
    this.SAD = true;
    return this;
  }
  
  public final aoc d(ant paramant)
  {
    this.Szp = paramant;
    this.Szq = true;
    return this;
  }
  
  public final aoc d(bje parambje)
  {
    this.SzJ = parambje;
    this.SzK = true;
    return this;
  }
  
  public final aoc f(anu paramanu)
  {
    this.PTL = paramanu;
    this.SzG = true;
    return this;
  }
  
  public final String getTitle()
  {
    return this.title;
  }
  
  public final aoi hpE()
  {
    return this.SAB;
  }
  
  public final anw hpF()
  {
    return this.RDh;
  }
  
  public final bje hpG()
  {
    return this.SzJ;
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127474);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SAB != null)
      {
        paramVarArgs.oE(1, this.SAB.computeSize());
        this.SAB.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.syG);
      if (this.Szp != null)
      {
        paramVarArgs.oE(3, this.Szp.computeSize());
        this.Szp.writeFields(paramVarArgs);
      }
      if (this.Szr != null)
      {
        paramVarArgs.oE(4, this.Szr.computeSize());
        this.Szr.writeFields(paramVarArgs);
      }
      if (this.remark != null) {
        paramVarArgs.f(5, this.remark);
      }
      if (this.title != null) {
        paramVarArgs.f(6, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.f(7, this.desc);
      }
      if (this.Szz == true) {
        paramVarArgs.bm(8, this.Szy);
      }
      if (this.SzB == true) {
        paramVarArgs.aY(91, this.SzA);
      }
      if (this.Szt != null)
      {
        paramVarArgs.oE(10, this.Szt.computeSize());
        this.Szt.writeFields(paramVarArgs);
      }
      if (this.SzC == true) {
        paramVarArgs.bm(11, this.uTt);
      }
      if (this.Szv != null)
      {
        paramVarArgs.oE(12, this.Szv.computeSize());
        this.Szv.writeFields(paramVarArgs);
      }
      if (this.SAE == true) {
        paramVarArgs.aY(13, this.version);
      }
      if (this.RDh != null)
      {
        paramVarArgs.oE(14, this.RDh.computeSize());
        this.RDh.writeFields(paramVarArgs);
      }
      if (this.SzE != null)
      {
        paramVarArgs.oE(15, this.SzE.computeSize());
        this.SzE.writeFields(paramVarArgs);
      }
      if (this.PTL != null)
      {
        paramVarArgs.oE(16, this.PTL.computeSize());
        this.PTL.writeFields(paramVarArgs);
      }
      if (this.SzJ != null)
      {
        paramVarArgs.oE(17, this.SzJ.computeSize());
        this.SzJ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(127474);
      return 0;
    }
    if (paramInt == 1) {
      if (this.SAB == null) {
        break label2080;
      }
    }
    label2080:
    for (paramInt = g.a.a.a.oD(1, this.SAB.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.syG);
      paramInt = i;
      if (this.Szp != null) {
        paramInt = i + g.a.a.a.oD(3, this.Szp.computeSize());
      }
      i = paramInt;
      if (this.Szr != null) {
        i = paramInt + g.a.a.a.oD(4, this.Szr.computeSize());
      }
      paramInt = i;
      if (this.remark != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.remark);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.title);
      }
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.desc);
      }
      i = paramInt;
      if (this.Szz == true) {
        i = paramInt + g.a.a.b.b.a.p(8, this.Szy);
      }
      paramInt = i;
      if (this.SzB == true) {
        paramInt = i + g.a.a.b.b.a.bM(91, this.SzA);
      }
      i = paramInt;
      if (this.Szt != null) {
        i = paramInt + g.a.a.a.oD(10, this.Szt.computeSize());
      }
      paramInt = i;
      if (this.SzC == true) {
        paramInt = i + g.a.a.b.b.a.p(11, this.uTt);
      }
      i = paramInt;
      if (this.Szv != null) {
        i = paramInt + g.a.a.a.oD(12, this.Szv.computeSize());
      }
      paramInt = i;
      if (this.SAE == true) {
        paramInt = i + g.a.a.b.b.a.bM(13, this.version);
      }
      i = paramInt;
      if (this.RDh != null) {
        i = paramInt + g.a.a.a.oD(14, this.RDh.computeSize());
      }
      paramInt = i;
      if (this.SzE != null) {
        paramInt = i + g.a.a.a.oD(15, this.SzE.computeSize());
      }
      i = paramInt;
      if (this.PTL != null) {
        i = paramInt + g.a.a.a.oD(16, this.PTL.computeSize());
      }
      paramInt = i;
      if (this.SzJ != null) {
        paramInt = i + g.a.a.a.oD(17, this.SzJ.computeSize());
      }
      AppMethodBeat.o(127474);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.syG.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(127474);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        aoc localaoc = (aoc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(127474);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aoi();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aoi)localObject2).parseFrom((byte[])localObject1);
            }
            localaoc.SAB = ((aoi)localObject2);
            paramInt += 1;
          }
          localaoc.SAC = true;
          AppMethodBeat.o(127474);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new anm();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((anm)localObject2).parseFrom((byte[])localObject1);
            }
            localaoc.syG.add(localObject2);
            paramInt += 1;
          }
          localaoc.SAD = true;
          AppMethodBeat.o(127474);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ant();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ant)localObject2).parseFrom((byte[])localObject1);
            }
            localaoc.Szp = ((ant)localObject2);
            paramInt += 1;
          }
          localaoc.Szq = true;
          AppMethodBeat.o(127474);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aor();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aor)localObject2).parseFrom((byte[])localObject1);
            }
            localaoc.Szr = ((aor)localObject2);
            paramInt += 1;
          }
          localaoc.Szs = true;
          AppMethodBeat.o(127474);
          return 0;
        case 5: 
          localaoc.remark = ((g.a.a.a.a)localObject1).abFh.readString();
          localaoc.Szx = true;
          AppMethodBeat.o(127474);
          return 0;
        case 6: 
          localaoc.title = ((g.a.a.a.a)localObject1).abFh.readString();
          localaoc.SxH = true;
          AppMethodBeat.o(127474);
          return 0;
        case 7: 
          localaoc.desc = ((g.a.a.a.a)localObject1).abFh.readString();
          localaoc.SxI = true;
          AppMethodBeat.o(127474);
          return 0;
        case 8: 
          localaoc.Szy = ((g.a.a.a.a)localObject1).abFh.AN();
          localaoc.Szz = true;
          AppMethodBeat.o(127474);
          return 0;
        case 91: 
          localaoc.SzA = ((g.a.a.a.a)localObject1).abFh.AK();
          localaoc.SzB = true;
          AppMethodBeat.o(127474);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aob();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aob)localObject2).parseFrom((byte[])localObject1);
            }
            localaoc.Szt = ((aob)localObject2);
            paramInt += 1;
          }
          localaoc.Szu = true;
          AppMethodBeat.o(127474);
          return 0;
        case 11: 
          localaoc.uTt = ((g.a.a.a.a)localObject1).abFh.AN();
          localaoc.SzC = true;
          AppMethodBeat.o(127474);
          return 0;
        case 12: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aol();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aol)localObject2).parseFrom((byte[])localObject1);
            }
            localaoc.Szv = ((aol)localObject2);
            paramInt += 1;
          }
          localaoc.Szw = true;
          AppMethodBeat.o(127474);
          return 0;
        case 13: 
          localaoc.version = ((g.a.a.a.a)localObject1).abFh.AK();
          localaoc.SAE = true;
          AppMethodBeat.o(127474);
          return 0;
        case 14: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new anw();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((anw)localObject2).parseFrom((byte[])localObject1);
            }
            localaoc.RDh = ((anw)localObject2);
            paramInt += 1;
          }
          localaoc.SzD = true;
          AppMethodBeat.o(127474);
          return 0;
        case 15: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ank();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ank)localObject2).parseFrom((byte[])localObject1);
            }
            localaoc.SzE = ((ank)localObject2);
            paramInt += 1;
          }
          localaoc.SzF = true;
          AppMethodBeat.o(127474);
          return 0;
        case 16: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new anu();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((anu)localObject2).parseFrom((byte[])localObject1);
            }
            localaoc.PTL = ((anu)localObject2);
            paramInt += 1;
          }
          localaoc.SzG = true;
          AppMethodBeat.o(127474);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bje();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bje)localObject2).parseFrom((byte[])localObject1);
          }
          localaoc.SzJ = ((bje)localObject2);
          paramInt += 1;
        }
        localaoc.SzK = true;
        AppMethodBeat.o(127474);
        return 0;
      }
      AppMethodBeat.o(127474);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aoc
 * JD-Core Version:    0.7.0.1
 */