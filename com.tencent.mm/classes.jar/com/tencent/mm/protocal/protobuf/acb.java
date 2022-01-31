package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class acb
  extends com.tencent.mm.bv.a
{
  public String desc;
  public String hKa;
  public long lsP;
  public String title;
  public aci uVl;
  public boolean wSv = false;
  public boolean wSw = false;
  public acc wUb;
  public boolean wUc = false;
  public ach wUd;
  public boolean wUe = false;
  public adf wUf;
  public boolean wUg = false;
  public acp wUh;
  public boolean wUi = false;
  public acz wUj;
  public boolean wUk = false;
  public boolean wUl = false;
  public long wUm;
  public boolean wUn = false;
  public int wUo = -1;
  public boolean wUp = false;
  public boolean wUq = false;
  public boolean wUr = false;
  public aby wUs;
  public boolean wUt = false;
  public boolean wUu = false;
  public ack wjV;
  
  public final acb a(aby paramaby)
  {
    this.wUs = paramaby;
    this.wUt = true;
    return this;
  }
  
  public final acb a(ach paramach)
  {
    this.wUd = paramach;
    this.wUe = true;
    return this;
  }
  
  public final acb a(acp paramacp)
  {
    this.wUh = paramacp;
    this.wUi = true;
    return this;
  }
  
  public final acb a(acz paramacz)
  {
    this.wUj = paramacz;
    this.wUk = true;
    return this;
  }
  
  public final acb a(adf paramadf)
  {
    this.wUf = paramadf;
    this.wUg = true;
    return this;
  }
  
  public final acb b(aci paramaci)
  {
    this.uVl = paramaci;
    this.wUu = true;
    return this;
  }
  
  public final acb c(acc paramacc)
  {
    this.wUb = paramacc;
    this.wUc = true;
    return this;
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(51391);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wUb != null)
      {
        paramVarArgs.iQ(1, this.wUb.computeSize());
        this.wUb.writeFields(paramVarArgs);
      }
      if (this.wUd != null)
      {
        paramVarArgs.iQ(2, this.wUd.computeSize());
        this.wUd.writeFields(paramVarArgs);
      }
      if (this.wUf != null)
      {
        paramVarArgs.iQ(3, this.wUf.computeSize());
        this.wUf.writeFields(paramVarArgs);
      }
      if (this.wUh != null)
      {
        paramVarArgs.iQ(4, this.wUh.computeSize());
        this.wUh.writeFields(paramVarArgs);
      }
      if (this.wUj != null)
      {
        paramVarArgs.iQ(5, this.wUj.computeSize());
        this.wUj.writeFields(paramVarArgs);
      }
      if (this.hKa != null) {
        paramVarArgs.e(6, this.hKa);
      }
      if (this.title != null) {
        paramVarArgs.e(7, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.e(8, this.desc);
      }
      if (this.wUn == true) {
        paramVarArgs.am(9, this.wUm);
      }
      if (this.wUp == true) {
        paramVarArgs.aO(101, this.wUo);
      }
      if (this.wUq == true) {
        paramVarArgs.am(11, this.lsP);
      }
      if (this.wjV != null)
      {
        paramVarArgs.iQ(12, this.wjV.computeSize());
        this.wjV.writeFields(paramVarArgs);
      }
      if (this.wUs != null)
      {
        paramVarArgs.iQ(13, this.wUs.computeSize());
        this.wUs.writeFields(paramVarArgs);
      }
      if (this.uVl != null)
      {
        paramVarArgs.iQ(14, this.uVl.computeSize());
        this.uVl.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(51391);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wUb == null) {
        break label1910;
      }
    }
    label1910:
    for (int i = e.a.a.a.iP(1, this.wUb.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wUd != null) {
        paramInt = i + e.a.a.a.iP(2, this.wUd.computeSize());
      }
      i = paramInt;
      if (this.wUf != null) {
        i = paramInt + e.a.a.a.iP(3, this.wUf.computeSize());
      }
      paramInt = i;
      if (this.wUh != null) {
        paramInt = i + e.a.a.a.iP(4, this.wUh.computeSize());
      }
      i = paramInt;
      if (this.wUj != null) {
        i = paramInt + e.a.a.a.iP(5, this.wUj.computeSize());
      }
      paramInt = i;
      if (this.hKa != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.hKa);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.title);
      }
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.desc);
      }
      i = paramInt;
      if (this.wUn == true) {
        i = paramInt + e.a.a.b.b.a.p(9, this.wUm);
      }
      paramInt = i;
      if (this.wUp == true) {
        paramInt = i + e.a.a.b.b.a.bl(101, this.wUo);
      }
      i = paramInt;
      if (this.wUq == true) {
        i = paramInt + e.a.a.b.b.a.p(11, this.lsP);
      }
      paramInt = i;
      if (this.wjV != null) {
        paramInt = i + e.a.a.a.iP(12, this.wjV.computeSize());
      }
      i = paramInt;
      if (this.wUs != null) {
        i = paramInt + e.a.a.a.iP(13, this.wUs.computeSize());
      }
      paramInt = i;
      if (this.uVl != null) {
        paramInt = i + e.a.a.a.iP(14, this.uVl.computeSize());
      }
      AppMethodBeat.o(51391);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(51391);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        acb localacb = (acb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(51391);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new acc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((acc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localacb.wUb = ((acc)localObject1);
            paramInt += 1;
          }
          localacb.wUc = true;
          AppMethodBeat.o(51391);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ach();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ach)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localacb.wUd = ((ach)localObject1);
            paramInt += 1;
          }
          localacb.wUe = true;
          AppMethodBeat.o(51391);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new adf();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((adf)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localacb.wUf = ((adf)localObject1);
            paramInt += 1;
          }
          localacb.wUg = true;
          AppMethodBeat.o(51391);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new acp();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((acp)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localacb.wUh = ((acp)localObject1);
            paramInt += 1;
          }
          localacb.wUi = true;
          AppMethodBeat.o(51391);
          return 0;
        case 5: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new acz();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((acz)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localacb.wUj = ((acz)localObject1);
            paramInt += 1;
          }
          localacb.wUk = true;
          AppMethodBeat.o(51391);
          return 0;
        case 6: 
          localacb.hKa = ((e.a.a.a.a)localObject1).CLY.readString();
          localacb.wUl = true;
          AppMethodBeat.o(51391);
          return 0;
        case 7: 
          localacb.title = ((e.a.a.a.a)localObject1).CLY.readString();
          localacb.wSv = true;
          AppMethodBeat.o(51391);
          return 0;
        case 8: 
          localacb.desc = ((e.a.a.a.a)localObject1).CLY.readString();
          localacb.wSw = true;
          AppMethodBeat.o(51391);
          return 0;
        case 9: 
          localacb.wUm = ((e.a.a.a.a)localObject1).CLY.sm();
          localacb.wUn = true;
          AppMethodBeat.o(51391);
          return 0;
        case 101: 
          localacb.wUo = ((e.a.a.a.a)localObject1).CLY.sl();
          localacb.wUp = true;
          AppMethodBeat.o(51391);
          return 0;
        case 11: 
          localacb.lsP = ((e.a.a.a.a)localObject1).CLY.sm();
          localacb.wUq = true;
          AppMethodBeat.o(51391);
          return 0;
        case 12: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ack();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ack)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localacb.wjV = ((ack)localObject1);
            paramInt += 1;
          }
          localacb.wUr = true;
          AppMethodBeat.o(51391);
          return 0;
        case 13: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aby();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aby)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localacb.wUs = ((aby)localObject1);
            paramInt += 1;
          }
          localacb.wUt = true;
          AppMethodBeat.o(51391);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aci();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aci)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localacb.uVl = ((aci)localObject1);
          paramInt += 1;
        }
        localacb.wUu = true;
        AppMethodBeat.o(51391);
        return 0;
      }
      AppMethodBeat.o(51391);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.acb
 * JD-Core Version:    0.7.0.1
 */