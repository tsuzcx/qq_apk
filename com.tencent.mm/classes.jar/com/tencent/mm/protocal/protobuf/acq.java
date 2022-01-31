package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class acq
  extends com.tencent.mm.bv.a
{
  public String desc;
  public String hKa;
  public long lsP;
  public String title;
  public aci uVl;
  public int version;
  public boolean wSv;
  public boolean wSw;
  public ach wUd;
  public boolean wUe;
  public adf wUf;
  public boolean wUg;
  public acp wUh;
  public boolean wUi;
  public acz wUj;
  public boolean wUk;
  public boolean wUl;
  public long wUm;
  public boolean wUn;
  public int wUo;
  public boolean wUp;
  public boolean wUq;
  public boolean wUr;
  public aby wUs;
  public boolean wUt;
  public boolean wUu;
  public acw wVa;
  public boolean wVb;
  public LinkedList<aca> wVc;
  public boolean wVd;
  public boolean wVe;
  public ack wjV;
  
  public acq()
  {
    AppMethodBeat.i(51404);
    this.wVb = false;
    this.wVc = new LinkedList();
    this.wVd = false;
    this.wUe = false;
    this.wUg = false;
    this.wUl = false;
    this.wSv = false;
    this.wSw = false;
    this.wUn = false;
    this.wUo = -1;
    this.wUp = false;
    this.wUi = false;
    this.wUq = false;
    this.wUk = false;
    this.wVe = false;
    this.wUr = false;
    this.wUt = false;
    this.wUu = false;
    AppMethodBeat.o(51404);
  }
  
  public final acq MP(int paramInt)
  {
    this.wUo = paramInt;
    this.wUp = true;
    return this;
  }
  
  public final acq MQ(int paramInt)
  {
    this.version = paramInt;
    this.wVe = true;
    return this;
  }
  
  public final acq a(ack paramack)
  {
    this.wjV = paramack;
    this.wUr = true;
    return this;
  }
  
  public final acq a(acw paramacw)
  {
    this.wVa = paramacw;
    this.wVb = true;
    return this;
  }
  
  public final acq aJ(LinkedList<aca> paramLinkedList)
  {
    this.wVc = paramLinkedList;
    this.wVd = true;
    return this;
  }
  
  public final acq aok(String paramString)
  {
    this.hKa = paramString;
    this.wUl = true;
    return this;
  }
  
  public final acq aol(String paramString)
  {
    this.title = paramString;
    this.wSv = true;
    return this;
  }
  
  public final acq aom(String paramString)
  {
    this.desc = paramString;
    this.wSw = true;
    return this;
  }
  
  public final acq b(aby paramaby)
  {
    this.wUs = paramaby;
    this.wUt = true;
    return this;
  }
  
  public final acq b(ach paramach)
  {
    this.wUd = paramach;
    this.wUe = true;
    return this;
  }
  
  public final acq b(acp paramacp)
  {
    this.wUh = paramacp;
    this.wUi = true;
    return this;
  }
  
  public final acq b(acz paramacz)
  {
    this.wUj = paramacz;
    this.wUk = true;
    return this;
  }
  
  public final acq b(adf paramadf)
  {
    this.wUf = paramadf;
    this.wUg = true;
    return this;
  }
  
  public final acq c(aci paramaci)
  {
    this.uVl = paramaci;
    this.wUu = true;
    return this;
  }
  
  public final acq nG(long paramLong)
  {
    this.wUm = paramLong;
    this.wUn = true;
    return this;
  }
  
  public final acq nH(long paramLong)
  {
    this.lsP = paramLong;
    this.wUq = true;
    return this;
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(51405);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wVa != null)
      {
        paramVarArgs.iQ(1, this.wVa.computeSize());
        this.wVa.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.wVc);
      if (this.wUd != null)
      {
        paramVarArgs.iQ(3, this.wUd.computeSize());
        this.wUd.writeFields(paramVarArgs);
      }
      if (this.wUf != null)
      {
        paramVarArgs.iQ(4, this.wUf.computeSize());
        this.wUf.writeFields(paramVarArgs);
      }
      if (this.hKa != null) {
        paramVarArgs.e(5, this.hKa);
      }
      if (this.title != null) {
        paramVarArgs.e(6, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.e(7, this.desc);
      }
      if (this.wUn == true) {
        paramVarArgs.am(8, this.wUm);
      }
      if (this.wUp == true) {
        paramVarArgs.aO(91, this.wUo);
      }
      if (this.wUh != null)
      {
        paramVarArgs.iQ(10, this.wUh.computeSize());
        this.wUh.writeFields(paramVarArgs);
      }
      if (this.wUq == true) {
        paramVarArgs.am(11, this.lsP);
      }
      if (this.wUj != null)
      {
        paramVarArgs.iQ(12, this.wUj.computeSize());
        this.wUj.writeFields(paramVarArgs);
      }
      if (this.wVe == true) {
        paramVarArgs.aO(13, this.version);
      }
      if (this.wjV != null)
      {
        paramVarArgs.iQ(14, this.wjV.computeSize());
        this.wjV.writeFields(paramVarArgs);
      }
      if (this.wUs != null)
      {
        paramVarArgs.iQ(15, this.wUs.computeSize());
        this.wUs.writeFields(paramVarArgs);
      }
      if (this.uVl != null)
      {
        paramVarArgs.iQ(16, this.uVl.computeSize());
        this.uVl.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(51405);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wVa == null) {
        break label2134;
      }
    }
    label2134:
    for (paramInt = e.a.a.a.iP(1, this.wVa.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.a.c(2, 8, this.wVc);
      paramInt = i;
      if (this.wUd != null) {
        paramInt = i + e.a.a.a.iP(3, this.wUd.computeSize());
      }
      i = paramInt;
      if (this.wUf != null) {
        i = paramInt + e.a.a.a.iP(4, this.wUf.computeSize());
      }
      paramInt = i;
      if (this.hKa != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.hKa);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + e.a.a.b.b.a.f(6, this.title);
      }
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.desc);
      }
      i = paramInt;
      if (this.wUn == true) {
        i = paramInt + e.a.a.b.b.a.p(8, this.wUm);
      }
      paramInt = i;
      if (this.wUp == true) {
        paramInt = i + e.a.a.b.b.a.bl(91, this.wUo);
      }
      i = paramInt;
      if (this.wUh != null) {
        i = paramInt + e.a.a.a.iP(10, this.wUh.computeSize());
      }
      paramInt = i;
      if (this.wUq == true) {
        paramInt = i + e.a.a.b.b.a.p(11, this.lsP);
      }
      i = paramInt;
      if (this.wUj != null) {
        i = paramInt + e.a.a.a.iP(12, this.wUj.computeSize());
      }
      paramInt = i;
      if (this.wVe == true) {
        paramInt = i + e.a.a.b.b.a.bl(13, this.version);
      }
      i = paramInt;
      if (this.wjV != null) {
        i = paramInt + e.a.a.a.iP(14, this.wjV.computeSize());
      }
      paramInt = i;
      if (this.wUs != null) {
        paramInt = i + e.a.a.a.iP(15, this.wUs.computeSize());
      }
      i = paramInt;
      if (this.uVl != null) {
        i = paramInt + e.a.a.a.iP(16, this.uVl.computeSize());
      }
      AppMethodBeat.o(51405);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wVc.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(51405);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        acq localacq = (acq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(51405);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new acw();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((acw)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localacq.wVa = ((acw)localObject1);
            paramInt += 1;
          }
          localacq.wVb = true;
          AppMethodBeat.o(51405);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aca();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aca)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localacq.wVc.add(localObject1);
            paramInt += 1;
          }
          localacq.wVd = true;
          AppMethodBeat.o(51405);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ach();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ach)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localacq.wUd = ((ach)localObject1);
            paramInt += 1;
          }
          localacq.wUe = true;
          AppMethodBeat.o(51405);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new adf();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((adf)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localacq.wUf = ((adf)localObject1);
            paramInt += 1;
          }
          localacq.wUg = true;
          AppMethodBeat.o(51405);
          return 0;
        case 5: 
          localacq.hKa = ((e.a.a.a.a)localObject1).CLY.readString();
          localacq.wUl = true;
          AppMethodBeat.o(51405);
          return 0;
        case 6: 
          localacq.title = ((e.a.a.a.a)localObject1).CLY.readString();
          localacq.wSv = true;
          AppMethodBeat.o(51405);
          return 0;
        case 7: 
          localacq.desc = ((e.a.a.a.a)localObject1).CLY.readString();
          localacq.wSw = true;
          AppMethodBeat.o(51405);
          return 0;
        case 8: 
          localacq.wUm = ((e.a.a.a.a)localObject1).CLY.sm();
          localacq.wUn = true;
          AppMethodBeat.o(51405);
          return 0;
        case 91: 
          localacq.wUo = ((e.a.a.a.a)localObject1).CLY.sl();
          localacq.wUp = true;
          AppMethodBeat.o(51405);
          return 0;
        case 10: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new acp();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((acp)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localacq.wUh = ((acp)localObject1);
            paramInt += 1;
          }
          localacq.wUi = true;
          AppMethodBeat.o(51405);
          return 0;
        case 11: 
          localacq.lsP = ((e.a.a.a.a)localObject1).CLY.sm();
          localacq.wUq = true;
          AppMethodBeat.o(51405);
          return 0;
        case 12: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new acz();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((acz)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localacq.wUj = ((acz)localObject1);
            paramInt += 1;
          }
          localacq.wUk = true;
          AppMethodBeat.o(51405);
          return 0;
        case 13: 
          localacq.version = ((e.a.a.a.a)localObject1).CLY.sl();
          localacq.wVe = true;
          AppMethodBeat.o(51405);
          return 0;
        case 14: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ack();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ack)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localacq.wjV = ((ack)localObject1);
            paramInt += 1;
          }
          localacq.wUr = true;
          AppMethodBeat.o(51405);
          return 0;
        case 15: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aby();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aby)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localacq.wUs = ((aby)localObject1);
            paramInt += 1;
          }
          localacq.wUt = true;
          AppMethodBeat.o(51405);
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
          localacq.uVl = ((aci)localObject1);
          paramInt += 1;
        }
        localacq.wUu = true;
        AppMethodBeat.o(51405);
        return 0;
      }
      AppMethodBeat.o(51405);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.acq
 * JD-Core Version:    0.7.0.1
 */