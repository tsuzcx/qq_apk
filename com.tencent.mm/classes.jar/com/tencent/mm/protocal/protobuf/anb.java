package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class anb
  extends com.tencent.mm.bw.a
{
  public amt IXu;
  public amv KBr;
  public boolean Lvh;
  public boolean Lvi;
  public ams LwQ;
  public boolean LwR;
  public anq LwS;
  public boolean LwT;
  public ana LwU;
  public boolean LwV;
  public ank LwW;
  public boolean LwX;
  public boolean LwY;
  public long LwZ;
  public boolean Lxa;
  public int Lxb;
  public boolean Lxc;
  public boolean Lxd;
  public boolean Lxe;
  public amj Lxf;
  public boolean Lxg;
  public boolean Lxh;
  public bcj Lxk;
  public boolean Lxl;
  public anh Lya;
  public boolean Lyb;
  public boolean Lyc;
  public boolean Lyd;
  public String desc;
  public LinkedList<aml> ppH;
  public String remark;
  public long rnM;
  public String title;
  public int version;
  
  public anb()
  {
    AppMethodBeat.i(127473);
    this.Lyb = false;
    this.ppH = new LinkedList();
    this.Lyc = false;
    this.LwR = false;
    this.LwT = false;
    this.LwY = false;
    this.Lvh = false;
    this.Lvi = false;
    this.Lxa = false;
    this.Lxb = -1;
    this.Lxc = false;
    this.LwV = false;
    this.Lxd = false;
    this.LwX = false;
    this.Lyd = false;
    this.Lxe = false;
    this.Lxg = false;
    this.Lxh = false;
    this.Lxl = false;
    AppMethodBeat.o(127473);
  }
  
  public final anb My(long paramLong)
  {
    this.LwZ = paramLong;
    this.Lxa = true;
    return this;
  }
  
  public final anb Mz(long paramLong)
  {
    this.rnM = paramLong;
    this.Lxd = true;
    return this;
  }
  
  public final anb a(amv paramamv)
  {
    this.KBr = paramamv;
    this.Lxe = true;
    return this;
  }
  
  public final anb a(anh paramanh)
  {
    this.Lya = paramanh;
    this.Lyb = true;
    return this;
  }
  
  public final anb ajk(int paramInt)
  {
    this.Lxb = paramInt;
    this.Lxc = true;
    return this;
  }
  
  public final anb ajl(int paramInt)
  {
    this.version = paramInt;
    this.Lyd = true;
    return this;
  }
  
  public final anb b(ana paramana)
  {
    this.LwU = paramana;
    this.LwV = true;
    return this;
  }
  
  public final anb b(ank paramank)
  {
    this.LwW = paramank;
    this.LwX = true;
    return this;
  }
  
  public final anb b(anq paramanq)
  {
    this.LwS = paramanq;
    this.LwT = true;
    return this;
  }
  
  public final anb bH(LinkedList<aml> paramLinkedList)
  {
    this.ppH = paramLinkedList;
    this.Lyc = true;
    return this;
  }
  
  public final anb bhc(String paramString)
  {
    this.remark = paramString;
    this.LwY = true;
    return this;
  }
  
  public final anb bhd(String paramString)
  {
    this.title = paramString;
    this.Lvh = true;
    return this;
  }
  
  public final anb bhe(String paramString)
  {
    this.desc = paramString;
    this.Lvi = true;
    return this;
  }
  
  public final LinkedList<aml> byK()
  {
    return this.ppH;
  }
  
  public final anb c(amj paramamj)
  {
    this.Lxf = paramamj;
    this.Lxg = true;
    return this;
  }
  
  public final anb d(ams paramams)
  {
    this.LwQ = paramams;
    this.LwR = true;
    return this;
  }
  
  public final anb d(bcj parambcj)
  {
    this.Lxk = parambcj;
    this.Lxl = true;
    return this;
  }
  
  public final anb f(amt paramamt)
  {
    this.IXu = paramamt;
    this.Lxh = true;
    return this;
  }
  
  public final String getTitle()
  {
    return this.title;
  }
  
  public final anh gui()
  {
    return this.Lya;
  }
  
  public final amv guj()
  {
    return this.KBr;
  }
  
  public final bcj guk()
  {
    return this.Lxk;
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127474);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Lya != null)
      {
        paramVarArgs.ni(1, this.Lya.computeSize());
        this.Lya.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.ppH);
      if (this.LwQ != null)
      {
        paramVarArgs.ni(3, this.LwQ.computeSize());
        this.LwQ.writeFields(paramVarArgs);
      }
      if (this.LwS != null)
      {
        paramVarArgs.ni(4, this.LwS.computeSize());
        this.LwS.writeFields(paramVarArgs);
      }
      if (this.remark != null) {
        paramVarArgs.e(5, this.remark);
      }
      if (this.title != null) {
        paramVarArgs.e(6, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.e(7, this.desc);
      }
      if (this.Lxa == true) {
        paramVarArgs.bb(8, this.LwZ);
      }
      if (this.Lxc == true) {
        paramVarArgs.aM(91, this.Lxb);
      }
      if (this.LwU != null)
      {
        paramVarArgs.ni(10, this.LwU.computeSize());
        this.LwU.writeFields(paramVarArgs);
      }
      if (this.Lxd == true) {
        paramVarArgs.bb(11, this.rnM);
      }
      if (this.LwW != null)
      {
        paramVarArgs.ni(12, this.LwW.computeSize());
        this.LwW.writeFields(paramVarArgs);
      }
      if (this.Lyd == true) {
        paramVarArgs.aM(13, this.version);
      }
      if (this.KBr != null)
      {
        paramVarArgs.ni(14, this.KBr.computeSize());
        this.KBr.writeFields(paramVarArgs);
      }
      if (this.Lxf != null)
      {
        paramVarArgs.ni(15, this.Lxf.computeSize());
        this.Lxf.writeFields(paramVarArgs);
      }
      if (this.IXu != null)
      {
        paramVarArgs.ni(16, this.IXu.computeSize());
        this.IXu.writeFields(paramVarArgs);
      }
      if (this.Lxk != null)
      {
        paramVarArgs.ni(17, this.Lxk.computeSize());
        this.Lxk.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(127474);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Lya == null) {
        break label2300;
      }
    }
    label2300:
    for (paramInt = g.a.a.a.nh(1, this.Lya.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.ppH);
      paramInt = i;
      if (this.LwQ != null) {
        paramInt = i + g.a.a.a.nh(3, this.LwQ.computeSize());
      }
      i = paramInt;
      if (this.LwS != null) {
        i = paramInt + g.a.a.a.nh(4, this.LwS.computeSize());
      }
      paramInt = i;
      if (this.remark != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.remark);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.title);
      }
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.desc);
      }
      i = paramInt;
      if (this.Lxa == true) {
        i = paramInt + g.a.a.b.b.a.r(8, this.LwZ);
      }
      paramInt = i;
      if (this.Lxc == true) {
        paramInt = i + g.a.a.b.b.a.bu(91, this.Lxb);
      }
      i = paramInt;
      if (this.LwU != null) {
        i = paramInt + g.a.a.a.nh(10, this.LwU.computeSize());
      }
      paramInt = i;
      if (this.Lxd == true) {
        paramInt = i + g.a.a.b.b.a.r(11, this.rnM);
      }
      i = paramInt;
      if (this.LwW != null) {
        i = paramInt + g.a.a.a.nh(12, this.LwW.computeSize());
      }
      paramInt = i;
      if (this.Lyd == true) {
        paramInt = i + g.a.a.b.b.a.bu(13, this.version);
      }
      i = paramInt;
      if (this.KBr != null) {
        i = paramInt + g.a.a.a.nh(14, this.KBr.computeSize());
      }
      paramInt = i;
      if (this.Lxf != null) {
        paramInt = i + g.a.a.a.nh(15, this.Lxf.computeSize());
      }
      i = paramInt;
      if (this.IXu != null) {
        i = paramInt + g.a.a.a.nh(16, this.IXu.computeSize());
      }
      paramInt = i;
      if (this.Lxk != null) {
        paramInt = i + g.a.a.a.nh(17, this.Lxk.computeSize());
      }
      AppMethodBeat.o(127474);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ppH.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(127474);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        anb localanb = (anb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(127474);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new anh();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((anh)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localanb.Lya = ((anh)localObject1);
            paramInt += 1;
          }
          localanb.Lyb = true;
          AppMethodBeat.o(127474);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aml();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aml)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localanb.ppH.add(localObject1);
            paramInt += 1;
          }
          localanb.Lyc = true;
          AppMethodBeat.o(127474);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ams();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ams)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localanb.LwQ = ((ams)localObject1);
            paramInt += 1;
          }
          localanb.LwR = true;
          AppMethodBeat.o(127474);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new anq();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((anq)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localanb.LwS = ((anq)localObject1);
            paramInt += 1;
          }
          localanb.LwT = true;
          AppMethodBeat.o(127474);
          return 0;
        case 5: 
          localanb.remark = ((g.a.a.a.a)localObject1).UbS.readString();
          localanb.LwY = true;
          AppMethodBeat.o(127474);
          return 0;
        case 6: 
          localanb.title = ((g.a.a.a.a)localObject1).UbS.readString();
          localanb.Lvh = true;
          AppMethodBeat.o(127474);
          return 0;
        case 7: 
          localanb.desc = ((g.a.a.a.a)localObject1).UbS.readString();
          localanb.Lvi = true;
          AppMethodBeat.o(127474);
          return 0;
        case 8: 
          localanb.LwZ = ((g.a.a.a.a)localObject1).UbS.zl();
          localanb.Lxa = true;
          AppMethodBeat.o(127474);
          return 0;
        case 91: 
          localanb.Lxb = ((g.a.a.a.a)localObject1).UbS.zi();
          localanb.Lxc = true;
          AppMethodBeat.o(127474);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ana();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ana)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localanb.LwU = ((ana)localObject1);
            paramInt += 1;
          }
          localanb.LwV = true;
          AppMethodBeat.o(127474);
          return 0;
        case 11: 
          localanb.rnM = ((g.a.a.a.a)localObject1).UbS.zl();
          localanb.Lxd = true;
          AppMethodBeat.o(127474);
          return 0;
        case 12: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ank();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ank)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localanb.LwW = ((ank)localObject1);
            paramInt += 1;
          }
          localanb.LwX = true;
          AppMethodBeat.o(127474);
          return 0;
        case 13: 
          localanb.version = ((g.a.a.a.a)localObject1).UbS.zi();
          localanb.Lyd = true;
          AppMethodBeat.o(127474);
          return 0;
        case 14: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new amv();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((amv)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localanb.KBr = ((amv)localObject1);
            paramInt += 1;
          }
          localanb.Lxe = true;
          AppMethodBeat.o(127474);
          return 0;
        case 15: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new amj();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((amj)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localanb.Lxf = ((amj)localObject1);
            paramInt += 1;
          }
          localanb.Lxg = true;
          AppMethodBeat.o(127474);
          return 0;
        case 16: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new amt();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((amt)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localanb.IXu = ((amt)localObject1);
            paramInt += 1;
          }
          localanb.Lxh = true;
          AppMethodBeat.o(127474);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bcj();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bcj)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localanb.Lxk = ((bcj)localObject1);
          paramInt += 1;
        }
        localanb.Lxl = true;
        AppMethodBeat.o(127474);
        return 0;
      }
      AppMethodBeat.o(127474);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.anb
 * JD-Core Version:    0.7.0.1
 */