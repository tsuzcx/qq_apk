package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class amm
  extends com.tencent.mm.bw.a
{
  public amt IXu;
  public amv KBr;
  public boolean Lvh = false;
  public boolean Lvi = false;
  public amn LwO;
  public boolean LwP = false;
  public ams LwQ;
  public boolean LwR = false;
  public anq LwS;
  public boolean LwT = false;
  public ana LwU;
  public boolean LwV = false;
  public ank LwW;
  public boolean LwX = false;
  public boolean LwY = false;
  public long LwZ;
  public boolean Lxa = false;
  public int Lxb = -1;
  public boolean Lxc = false;
  public boolean Lxd = false;
  public boolean Lxe = false;
  public amj Lxf;
  public boolean Lxg = false;
  public boolean Lxh = false;
  public amt Lxi;
  public boolean Lxj = false;
  public bcj Lxk;
  public boolean Lxl = false;
  public axf Lxm;
  public boolean Lxn = false;
  public bci Lxo;
  public boolean Lxp = false;
  public bcf Lxq;
  public boolean Lxr = false;
  public css Lxs;
  public boolean Lxt = false;
  public bcl Lxu;
  public boolean Lxv = false;
  public String desc;
  public String remark;
  public long rnM;
  public String title;
  
  public final amm a(ana paramana)
  {
    this.LwU = paramana;
    this.LwV = true;
    return this;
  }
  
  public final amm a(ank paramank)
  {
    this.LwW = paramank;
    this.LwX = true;
    return this;
  }
  
  public final amm a(anq paramanq)
  {
    this.LwS = paramanq;
    this.LwT = true;
    return this;
  }
  
  public final amm a(bci parambci)
  {
    this.Lxo = parambci;
    this.Lxp = true;
    return this;
  }
  
  public final amm b(amj paramamj)
  {
    this.Lxf = paramamj;
    this.Lxg = true;
    return this;
  }
  
  public final amm c(amn paramamn)
  {
    this.LwO = paramamn;
    this.LwP = true;
    return this;
  }
  
  public final amm c(ams paramams)
  {
    this.LwQ = paramams;
    this.LwR = true;
    return this;
  }
  
  public final amm c(bcf parambcf)
  {
    this.Lxq = parambcf;
    this.Lxr = true;
    return this;
  }
  
  public final amm c(bcj parambcj)
  {
    this.Lxk = parambcj;
    this.Lxl = true;
    return this;
  }
  
  public final amm c(bcl parambcl)
  {
    this.Lxu = parambcl;
    this.Lxv = true;
    return this;
  }
  
  public final amm d(amt paramamt)
  {
    this.IXu = paramamt;
    this.Lxh = true;
    return this;
  }
  
  public final amm e(amt paramamt)
  {
    this.Lxi = paramamt;
    this.Lxj = true;
    return this;
  }
  
  public final amm e(axf paramaxf)
  {
    this.Lxm = paramaxf;
    this.Lxn = true;
    return this;
  }
  
  public final amm e(css paramcss)
  {
    this.Lxs = paramcss;
    this.Lxt = true;
    return this;
  }
  
  public final amn guh()
  {
    return this.LwO;
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127458);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.LwO != null)
      {
        paramVarArgs.ni(1, this.LwO.computeSize());
        this.LwO.writeFields(paramVarArgs);
      }
      if (this.LwQ != null)
      {
        paramVarArgs.ni(2, this.LwQ.computeSize());
        this.LwQ.writeFields(paramVarArgs);
      }
      if (this.LwS != null)
      {
        paramVarArgs.ni(3, this.LwS.computeSize());
        this.LwS.writeFields(paramVarArgs);
      }
      if (this.LwU != null)
      {
        paramVarArgs.ni(4, this.LwU.computeSize());
        this.LwU.writeFields(paramVarArgs);
      }
      if (this.LwW != null)
      {
        paramVarArgs.ni(5, this.LwW.computeSize());
        this.LwW.writeFields(paramVarArgs);
      }
      if (this.remark != null) {
        paramVarArgs.e(6, this.remark);
      }
      if (this.title != null) {
        paramVarArgs.e(7, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.e(8, this.desc);
      }
      if (this.Lxa == true) {
        paramVarArgs.bb(9, this.LwZ);
      }
      if (this.Lxc == true) {
        paramVarArgs.aM(101, this.Lxb);
      }
      if (this.Lxd == true) {
        paramVarArgs.bb(11, this.rnM);
      }
      if (this.KBr != null)
      {
        paramVarArgs.ni(12, this.KBr.computeSize());
        this.KBr.writeFields(paramVarArgs);
      }
      if (this.Lxf != null)
      {
        paramVarArgs.ni(13, this.Lxf.computeSize());
        this.Lxf.writeFields(paramVarArgs);
      }
      if (this.IXu != null)
      {
        paramVarArgs.ni(14, this.IXu.computeSize());
        this.IXu.writeFields(paramVarArgs);
      }
      if (this.Lxi != null)
      {
        paramVarArgs.ni(15, this.Lxi.computeSize());
        this.Lxi.writeFields(paramVarArgs);
      }
      if (this.Lxk != null)
      {
        paramVarArgs.ni(16, this.Lxk.computeSize());
        this.Lxk.writeFields(paramVarArgs);
      }
      if (this.Lxm != null)
      {
        paramVarArgs.ni(17, this.Lxm.computeSize());
        this.Lxm.writeFields(paramVarArgs);
      }
      if (this.Lxo != null)
      {
        paramVarArgs.ni(18, this.Lxo.computeSize());
        this.Lxo.writeFields(paramVarArgs);
      }
      if (this.Lxq != null)
      {
        paramVarArgs.ni(19, this.Lxq.computeSize());
        this.Lxq.writeFields(paramVarArgs);
      }
      if (this.Lxs != null)
      {
        paramVarArgs.ni(20, this.Lxs.computeSize());
        this.Lxs.writeFields(paramVarArgs);
      }
      if (this.Lxu != null)
      {
        paramVarArgs.ni(21, this.Lxu.computeSize());
        this.Lxu.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(127458);
      return 0;
    }
    if (paramInt == 1) {
      if (this.LwO == null) {
        break label3072;
      }
    }
    label3072:
    for (int i = g.a.a.a.nh(1, this.LwO.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.LwQ != null) {
        paramInt = i + g.a.a.a.nh(2, this.LwQ.computeSize());
      }
      i = paramInt;
      if (this.LwS != null) {
        i = paramInt + g.a.a.a.nh(3, this.LwS.computeSize());
      }
      paramInt = i;
      if (this.LwU != null) {
        paramInt = i + g.a.a.a.nh(4, this.LwU.computeSize());
      }
      i = paramInt;
      if (this.LwW != null) {
        i = paramInt + g.a.a.a.nh(5, this.LwW.computeSize());
      }
      paramInt = i;
      if (this.remark != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.remark);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.title);
      }
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.desc);
      }
      i = paramInt;
      if (this.Lxa == true) {
        i = paramInt + g.a.a.b.b.a.r(9, this.LwZ);
      }
      paramInt = i;
      if (this.Lxc == true) {
        paramInt = i + g.a.a.b.b.a.bu(101, this.Lxb);
      }
      i = paramInt;
      if (this.Lxd == true) {
        i = paramInt + g.a.a.b.b.a.r(11, this.rnM);
      }
      paramInt = i;
      if (this.KBr != null) {
        paramInt = i + g.a.a.a.nh(12, this.KBr.computeSize());
      }
      i = paramInt;
      if (this.Lxf != null) {
        i = paramInt + g.a.a.a.nh(13, this.Lxf.computeSize());
      }
      paramInt = i;
      if (this.IXu != null) {
        paramInt = i + g.a.a.a.nh(14, this.IXu.computeSize());
      }
      i = paramInt;
      if (this.Lxi != null) {
        i = paramInt + g.a.a.a.nh(15, this.Lxi.computeSize());
      }
      paramInt = i;
      if (this.Lxk != null) {
        paramInt = i + g.a.a.a.nh(16, this.Lxk.computeSize());
      }
      i = paramInt;
      if (this.Lxm != null) {
        i = paramInt + g.a.a.a.nh(17, this.Lxm.computeSize());
      }
      paramInt = i;
      if (this.Lxo != null) {
        paramInt = i + g.a.a.a.nh(18, this.Lxo.computeSize());
      }
      i = paramInt;
      if (this.Lxq != null) {
        i = paramInt + g.a.a.a.nh(19, this.Lxq.computeSize());
      }
      paramInt = i;
      if (this.Lxs != null) {
        paramInt = i + g.a.a.a.nh(20, this.Lxs.computeSize());
      }
      i = paramInt;
      if (this.Lxu != null) {
        i = paramInt + g.a.a.a.nh(21, this.Lxu.computeSize());
      }
      AppMethodBeat.o(127458);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(127458);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        amm localamm = (amm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(127458);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new amn();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((amn)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localamm.LwO = ((amn)localObject1);
            paramInt += 1;
          }
          localamm.LwP = true;
          AppMethodBeat.o(127458);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ams();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ams)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localamm.LwQ = ((ams)localObject1);
            paramInt += 1;
          }
          localamm.LwR = true;
          AppMethodBeat.o(127458);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new anq();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((anq)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localamm.LwS = ((anq)localObject1);
            paramInt += 1;
          }
          localamm.LwT = true;
          AppMethodBeat.o(127458);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ana();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ana)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localamm.LwU = ((ana)localObject1);
            paramInt += 1;
          }
          localamm.LwV = true;
          AppMethodBeat.o(127458);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ank();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ank)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localamm.LwW = ((ank)localObject1);
            paramInt += 1;
          }
          localamm.LwX = true;
          AppMethodBeat.o(127458);
          return 0;
        case 6: 
          localamm.remark = ((g.a.a.a.a)localObject1).UbS.readString();
          localamm.LwY = true;
          AppMethodBeat.o(127458);
          return 0;
        case 7: 
          localamm.title = ((g.a.a.a.a)localObject1).UbS.readString();
          localamm.Lvh = true;
          AppMethodBeat.o(127458);
          return 0;
        case 8: 
          localamm.desc = ((g.a.a.a.a)localObject1).UbS.readString();
          localamm.Lvi = true;
          AppMethodBeat.o(127458);
          return 0;
        case 9: 
          localamm.LwZ = ((g.a.a.a.a)localObject1).UbS.zl();
          localamm.Lxa = true;
          AppMethodBeat.o(127458);
          return 0;
        case 101: 
          localamm.Lxb = ((g.a.a.a.a)localObject1).UbS.zi();
          localamm.Lxc = true;
          AppMethodBeat.o(127458);
          return 0;
        case 11: 
          localamm.rnM = ((g.a.a.a.a)localObject1).UbS.zl();
          localamm.Lxd = true;
          AppMethodBeat.o(127458);
          return 0;
        case 12: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new amv();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((amv)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localamm.KBr = ((amv)localObject1);
            paramInt += 1;
          }
          localamm.Lxe = true;
          AppMethodBeat.o(127458);
          return 0;
        case 13: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new amj();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((amj)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localamm.Lxf = ((amj)localObject1);
            paramInt += 1;
          }
          localamm.Lxg = true;
          AppMethodBeat.o(127458);
          return 0;
        case 14: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new amt();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((amt)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localamm.IXu = ((amt)localObject1);
            paramInt += 1;
          }
          localamm.Lxh = true;
          AppMethodBeat.o(127458);
          return 0;
        case 15: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new amt();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((amt)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localamm.Lxi = ((amt)localObject1);
            paramInt += 1;
          }
          localamm.Lxj = true;
          AppMethodBeat.o(127458);
          return 0;
        case 16: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bcj();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bcj)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localamm.Lxk = ((bcj)localObject1);
            paramInt += 1;
          }
          localamm.Lxl = true;
          AppMethodBeat.o(127458);
          return 0;
        case 17: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new axf();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((axf)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localamm.Lxm = ((axf)localObject1);
            paramInt += 1;
          }
          localamm.Lxn = true;
          AppMethodBeat.o(127458);
          return 0;
        case 18: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bci();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bci)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localamm.Lxo = ((bci)localObject1);
            paramInt += 1;
          }
          localamm.Lxp = true;
          AppMethodBeat.o(127458);
          return 0;
        case 19: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bcf();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bcf)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localamm.Lxq = ((bcf)localObject1);
            paramInt += 1;
          }
          localamm.Lxr = true;
          AppMethodBeat.o(127458);
          return 0;
        case 20: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new css();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((css)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localamm.Lxs = ((css)localObject1);
            paramInt += 1;
          }
          localamm.Lxt = true;
          AppMethodBeat.o(127458);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bcl();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bcl)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localamm.Lxu = ((bcl)localObject1);
          paramInt += 1;
        }
        localamm.Lxv = true;
        AppMethodBeat.o(127458);
        return 0;
      }
      AppMethodBeat.o(127458);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.amm
 * JD-Core Version:    0.7.0.1
 */