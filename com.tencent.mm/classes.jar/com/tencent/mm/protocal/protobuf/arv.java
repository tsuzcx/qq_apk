package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class arv
  extends com.tencent.mm.bx.a
{
  public arn WKx;
  public arp YzK;
  public bvl ZAB;
  public boolean ZAC;
  public arm ZAh;
  public boolean ZAi;
  public ask ZAj;
  public boolean ZAk;
  public aru ZAl;
  public boolean ZAm;
  public ase ZAn;
  public boolean ZAo;
  public boolean ZAp;
  public long ZAq;
  public boolean ZAr;
  public int ZAs;
  public boolean ZAt;
  public boolean ZAu;
  public boolean ZAv;
  public ard ZAw;
  public boolean ZAx;
  public boolean ZAy;
  public asb ZBt;
  public boolean ZBu;
  public boolean ZBv;
  public boolean ZBw;
  public boolean ZyA;
  public boolean Zyz;
  public String desc;
  public String remark;
  public String title;
  public LinkedList<arf> vEn;
  public int version;
  public long ygh;
  
  public arv()
  {
    AppMethodBeat.i(127473);
    this.ZBu = false;
    this.vEn = new LinkedList();
    this.ZBv = false;
    this.ZAi = false;
    this.ZAk = false;
    this.ZAp = false;
    this.Zyz = false;
    this.ZyA = false;
    this.ZAr = false;
    this.ZAs = -1;
    this.ZAt = false;
    this.ZAm = false;
    this.ZAu = false;
    this.ZAo = false;
    this.ZBw = false;
    this.ZAv = false;
    this.ZAx = false;
    this.ZAy = false;
    this.ZAC = false;
    AppMethodBeat.o(127473);
  }
  
  public final arv a(arp paramarp)
  {
    this.YzK = paramarp;
    this.ZAv = true;
    return this;
  }
  
  public final arv a(asb paramasb)
  {
    this.ZBt = paramasb;
    this.ZBu = true;
    return this;
  }
  
  public final arv axF(int paramInt)
  {
    this.ZAs = paramInt;
    this.ZAt = true;
    return this;
  }
  
  public final arv axG(int paramInt)
  {
    this.version = paramInt;
    this.ZBw = true;
    return this;
  }
  
  public final arv b(aru paramaru)
  {
    this.ZAl = paramaru;
    this.ZAm = true;
    return this;
  }
  
  public final arv b(ase paramase)
  {
    this.ZAn = paramase;
    this.ZAo = true;
    return this;
  }
  
  public final arv btl(String paramString)
  {
    this.remark = paramString;
    this.ZAp = true;
    return this;
  }
  
  public final arv btm(String paramString)
  {
    this.title = paramString;
    this.Zyz = true;
    return this;
  }
  
  public final arv btn(String paramString)
  {
    this.desc = paramString;
    this.ZyA = true;
    return this;
  }
  
  public final arv c(ard paramard)
  {
    this.ZAw = paramard;
    this.ZAx = true;
    return this;
  }
  
  public final arv c(ask paramask)
  {
    this.ZAj = paramask;
    this.ZAk = true;
    return this;
  }
  
  public final arv cs(LinkedList<arf> paramLinkedList)
  {
    this.vEn = paramLinkedList;
    this.ZBv = true;
    return this;
  }
  
  public final arv d(arm paramarm)
  {
    this.ZAh = paramarm;
    this.ZAi = true;
    return this;
  }
  
  public final arv f(arn paramarn)
  {
    this.WKx = paramarn;
    this.ZAy = true;
    return this;
  }
  
  public final arv h(bvl parambvl)
  {
    this.ZAB = parambvl;
    this.ZAC = true;
    return this;
  }
  
  public final asb iQs()
  {
    return this.ZBt;
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127474);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZBt != null)
      {
        paramVarArgs.qD(1, this.ZBt.computeSize());
        this.ZBt.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.vEn);
      if (this.ZAh != null)
      {
        paramVarArgs.qD(3, this.ZAh.computeSize());
        this.ZAh.writeFields(paramVarArgs);
      }
      if (this.ZAj != null)
      {
        paramVarArgs.qD(4, this.ZAj.computeSize());
        this.ZAj.writeFields(paramVarArgs);
      }
      if (this.remark != null) {
        paramVarArgs.g(5, this.remark);
      }
      if (this.title != null) {
        paramVarArgs.g(6, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.g(7, this.desc);
      }
      if (this.ZAr == true) {
        paramVarArgs.bv(8, this.ZAq);
      }
      if (this.ZAt == true) {
        paramVarArgs.bS(91, this.ZAs);
      }
      if (this.ZAl != null)
      {
        paramVarArgs.qD(10, this.ZAl.computeSize());
        this.ZAl.writeFields(paramVarArgs);
      }
      if (this.ZAu == true) {
        paramVarArgs.bv(11, this.ygh);
      }
      if (this.ZAn != null)
      {
        paramVarArgs.qD(12, this.ZAn.computeSize());
        this.ZAn.writeFields(paramVarArgs);
      }
      if (this.ZBw == true) {
        paramVarArgs.bS(13, this.version);
      }
      if (this.YzK != null)
      {
        paramVarArgs.qD(14, this.YzK.computeSize());
        this.YzK.writeFields(paramVarArgs);
      }
      if (this.ZAw != null)
      {
        paramVarArgs.qD(15, this.ZAw.computeSize());
        this.ZAw.writeFields(paramVarArgs);
      }
      if (this.WKx != null)
      {
        paramVarArgs.qD(16, this.WKx.computeSize());
        this.WKx.writeFields(paramVarArgs);
      }
      if (this.ZAB != null)
      {
        paramVarArgs.qD(17, this.ZAB.computeSize());
        this.ZAB.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(127474);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZBt == null) {
        break label2080;
      }
    }
    label2080:
    for (paramInt = i.a.a.a.qC(1, this.ZBt.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.vEn);
      paramInt = i;
      if (this.ZAh != null) {
        paramInt = i + i.a.a.a.qC(3, this.ZAh.computeSize());
      }
      i = paramInt;
      if (this.ZAj != null) {
        i = paramInt + i.a.a.a.qC(4, this.ZAj.computeSize());
      }
      paramInt = i;
      if (this.remark != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.remark);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.title);
      }
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.desc);
      }
      i = paramInt;
      if (this.ZAr == true) {
        i = paramInt + i.a.a.b.b.a.q(8, this.ZAq);
      }
      paramInt = i;
      if (this.ZAt == true) {
        paramInt = i + i.a.a.b.b.a.cJ(91, this.ZAs);
      }
      i = paramInt;
      if (this.ZAl != null) {
        i = paramInt + i.a.a.a.qC(10, this.ZAl.computeSize());
      }
      paramInt = i;
      if (this.ZAu == true) {
        paramInt = i + i.a.a.b.b.a.q(11, this.ygh);
      }
      i = paramInt;
      if (this.ZAn != null) {
        i = paramInt + i.a.a.a.qC(12, this.ZAn.computeSize());
      }
      paramInt = i;
      if (this.ZBw == true) {
        paramInt = i + i.a.a.b.b.a.cJ(13, this.version);
      }
      i = paramInt;
      if (this.YzK != null) {
        i = paramInt + i.a.a.a.qC(14, this.YzK.computeSize());
      }
      paramInt = i;
      if (this.ZAw != null) {
        paramInt = i + i.a.a.a.qC(15, this.ZAw.computeSize());
      }
      i = paramInt;
      if (this.WKx != null) {
        i = paramInt + i.a.a.a.qC(16, this.WKx.computeSize());
      }
      paramInt = i;
      if (this.ZAB != null) {
        paramInt = i + i.a.a.a.qC(17, this.ZAB.computeSize());
      }
      AppMethodBeat.o(127474);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.vEn.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(127474);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        arv localarv = (arv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(127474);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new asb();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((asb)localObject2).parseFrom((byte[])localObject1);
            }
            localarv.ZBt = ((asb)localObject2);
            paramInt += 1;
          }
          localarv.ZBu = true;
          AppMethodBeat.o(127474);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new arf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((arf)localObject2).parseFrom((byte[])localObject1);
            }
            localarv.vEn.add(localObject2);
            paramInt += 1;
          }
          localarv.ZBv = true;
          AppMethodBeat.o(127474);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new arm();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((arm)localObject2).parseFrom((byte[])localObject1);
            }
            localarv.ZAh = ((arm)localObject2);
            paramInt += 1;
          }
          localarv.ZAi = true;
          AppMethodBeat.o(127474);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ask();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ask)localObject2).parseFrom((byte[])localObject1);
            }
            localarv.ZAj = ((ask)localObject2);
            paramInt += 1;
          }
          localarv.ZAk = true;
          AppMethodBeat.o(127474);
          return 0;
        case 5: 
          localarv.remark = ((i.a.a.a.a)localObject1).ajGk.readString();
          localarv.ZAp = true;
          AppMethodBeat.o(127474);
          return 0;
        case 6: 
          localarv.title = ((i.a.a.a.a)localObject1).ajGk.readString();
          localarv.Zyz = true;
          AppMethodBeat.o(127474);
          return 0;
        case 7: 
          localarv.desc = ((i.a.a.a.a)localObject1).ajGk.readString();
          localarv.ZyA = true;
          AppMethodBeat.o(127474);
          return 0;
        case 8: 
          localarv.ZAq = ((i.a.a.a.a)localObject1).ajGk.aaw();
          localarv.ZAr = true;
          AppMethodBeat.o(127474);
          return 0;
        case 91: 
          localarv.ZAs = ((i.a.a.a.a)localObject1).ajGk.aar();
          localarv.ZAt = true;
          AppMethodBeat.o(127474);
          return 0;
        case 10: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aru();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aru)localObject2).parseFrom((byte[])localObject1);
            }
            localarv.ZAl = ((aru)localObject2);
            paramInt += 1;
          }
          localarv.ZAm = true;
          AppMethodBeat.o(127474);
          return 0;
        case 11: 
          localarv.ygh = ((i.a.a.a.a)localObject1).ajGk.aaw();
          localarv.ZAu = true;
          AppMethodBeat.o(127474);
          return 0;
        case 12: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ase();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ase)localObject2).parseFrom((byte[])localObject1);
            }
            localarv.ZAn = ((ase)localObject2);
            paramInt += 1;
          }
          localarv.ZAo = true;
          AppMethodBeat.o(127474);
          return 0;
        case 13: 
          localarv.version = ((i.a.a.a.a)localObject1).ajGk.aar();
          localarv.ZBw = true;
          AppMethodBeat.o(127474);
          return 0;
        case 14: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new arp();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((arp)localObject2).parseFrom((byte[])localObject1);
            }
            localarv.YzK = ((arp)localObject2);
            paramInt += 1;
          }
          localarv.ZAv = true;
          AppMethodBeat.o(127474);
          return 0;
        case 15: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ard();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ard)localObject2).parseFrom((byte[])localObject1);
            }
            localarv.ZAw = ((ard)localObject2);
            paramInt += 1;
          }
          localarv.ZAx = true;
          AppMethodBeat.o(127474);
          return 0;
        case 16: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new arn();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((arn)localObject2).parseFrom((byte[])localObject1);
            }
            localarv.WKx = ((arn)localObject2);
            paramInt += 1;
          }
          localarv.ZAy = true;
          AppMethodBeat.o(127474);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bvl();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bvl)localObject2).parseFrom((byte[])localObject1);
          }
          localarv.ZAB = ((bvl)localObject2);
          paramInt += 1;
        }
        localarv.ZAC = true;
        AppMethodBeat.o(127474);
        return 0;
      }
      AppMethodBeat.o(127474);
      return -1;
    }
  }
  
  public final arv ys(long paramLong)
  {
    this.ZAq = paramLong;
    this.ZAr = true;
    return this;
  }
  
  public final arv yt(long paramLong)
  {
    this.ygh = paramLong;
    this.ZAu = true;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.arv
 * JD-Core Version:    0.7.0.1
 */