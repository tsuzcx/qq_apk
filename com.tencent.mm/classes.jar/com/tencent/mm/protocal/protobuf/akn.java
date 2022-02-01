package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class akn
  extends com.tencent.mm.bw.a
{
  public akf Ekw;
  public akh FId;
  public ake GBd;
  public boolean GBe;
  public alc GBf;
  public boolean GBg;
  public akm GBh;
  public boolean GBi;
  public akw GBj;
  public boolean GBk;
  public boolean GBl;
  public long GBm;
  public boolean GBn;
  public int GBo;
  public boolean GBp;
  public boolean GBq;
  public boolean GBr;
  public ajv GBs;
  public boolean GBt;
  public boolean GBu;
  public ary GBx;
  public boolean GBy;
  public akt GCe;
  public boolean GCf;
  public boolean GCg;
  public boolean GCh;
  public boolean Gzt;
  public boolean Gzu;
  public String desc;
  public String iWF;
  public LinkedList<ajx> oeJ;
  public long pWN;
  public String title;
  public int version;
  
  public akn()
  {
    AppMethodBeat.i(127473);
    this.GCf = false;
    this.oeJ = new LinkedList();
    this.GCg = false;
    this.GBe = false;
    this.GBg = false;
    this.GBl = false;
    this.Gzt = false;
    this.Gzu = false;
    this.GBn = false;
    this.GBo = -1;
    this.GBp = false;
    this.GBi = false;
    this.GBq = false;
    this.GBk = false;
    this.GCh = false;
    this.GBr = false;
    this.GBt = false;
    this.GBu = false;
    this.GBy = false;
    AppMethodBeat.o(127473);
  }
  
  public final akn Di(long paramLong)
  {
    this.GBm = paramLong;
    this.GBn = true;
    return this;
  }
  
  public final akn Dj(long paramLong)
  {
    this.pWN = paramLong;
    this.GBq = true;
    return this;
  }
  
  public final akn a(akh paramakh)
  {
    this.FId = paramakh;
    this.GBr = true;
    return this;
  }
  
  public final akn a(akt paramakt)
  {
    this.GCe = paramakt;
    this.GCf = true;
    return this;
  }
  
  public final akn aQA(String paramString)
  {
    this.title = paramString;
    this.Gzt = true;
    return this;
  }
  
  public final akn aQB(String paramString)
  {
    this.desc = paramString;
    this.Gzu = true;
    return this;
  }
  
  public final akn aQz(String paramString)
  {
    this.iWF = paramString;
    this.GBl = true;
    return this;
  }
  
  public final akn aav(int paramInt)
  {
    this.GBo = paramInt;
    this.GBp = true;
    return this;
  }
  
  public final akn aaw(int paramInt)
  {
    this.version = paramInt;
    this.GCh = true;
    return this;
  }
  
  public final akn b(akm paramakm)
  {
    this.GBh = paramakm;
    this.GBi = true;
    return this;
  }
  
  public final akn b(akw paramakw)
  {
    this.GBj = paramakw;
    this.GBk = true;
    return this;
  }
  
  public final akn b(alc paramalc)
  {
    this.GBf = paramalc;
    this.GBg = true;
    return this;
  }
  
  public final akn bm(LinkedList<ajx> paramLinkedList)
  {
    this.oeJ = paramLinkedList;
    this.GCg = true;
    return this;
  }
  
  public final akn c(ajv paramajv)
  {
    this.GBs = paramajv;
    this.GBt = true;
    return this;
  }
  
  public final akn d(ake paramake)
  {
    this.GBd = paramake;
    this.GBe = true;
    return this;
  }
  
  public final akn d(ary paramary)
  {
    this.GBx = paramary;
    this.GBy = true;
    return this;
  }
  
  public final akn f(akf paramakf)
  {
    this.Ekw = paramakf;
    this.GBu = true;
    return this;
  }
  
  public final ary fkE()
  {
    return this.GBx;
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127474);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GCe != null)
      {
        paramVarArgs.lJ(1, this.GCe.computeSize());
        this.GCe.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.oeJ);
      if (this.GBd != null)
      {
        paramVarArgs.lJ(3, this.GBd.computeSize());
        this.GBd.writeFields(paramVarArgs);
      }
      if (this.GBf != null)
      {
        paramVarArgs.lJ(4, this.GBf.computeSize());
        this.GBf.writeFields(paramVarArgs);
      }
      if (this.iWF != null) {
        paramVarArgs.d(5, this.iWF);
      }
      if (this.title != null) {
        paramVarArgs.d(6, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.d(7, this.desc);
      }
      if (this.GBn == true) {
        paramVarArgs.aZ(8, this.GBm);
      }
      if (this.GBp == true) {
        paramVarArgs.aS(91, this.GBo);
      }
      if (this.GBh != null)
      {
        paramVarArgs.lJ(10, this.GBh.computeSize());
        this.GBh.writeFields(paramVarArgs);
      }
      if (this.GBq == true) {
        paramVarArgs.aZ(11, this.pWN);
      }
      if (this.GBj != null)
      {
        paramVarArgs.lJ(12, this.GBj.computeSize());
        this.GBj.writeFields(paramVarArgs);
      }
      if (this.GCh == true) {
        paramVarArgs.aS(13, this.version);
      }
      if (this.FId != null)
      {
        paramVarArgs.lJ(14, this.FId.computeSize());
        this.FId.writeFields(paramVarArgs);
      }
      if (this.GBs != null)
      {
        paramVarArgs.lJ(15, this.GBs.computeSize());
        this.GBs.writeFields(paramVarArgs);
      }
      if (this.Ekw != null)
      {
        paramVarArgs.lJ(16, this.Ekw.computeSize());
        this.Ekw.writeFields(paramVarArgs);
      }
      if (this.GBx != null)
      {
        paramVarArgs.lJ(17, this.GBx.computeSize());
        this.GBx.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(127474);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GCe == null) {
        break label2300;
      }
    }
    label2300:
    for (paramInt = f.a.a.a.lI(1, this.GCe.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.oeJ);
      paramInt = i;
      if (this.GBd != null) {
        paramInt = i + f.a.a.a.lI(3, this.GBd.computeSize());
      }
      i = paramInt;
      if (this.GBf != null) {
        i = paramInt + f.a.a.a.lI(4, this.GBf.computeSize());
      }
      paramInt = i;
      if (this.iWF != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.iWF);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.title);
      }
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.desc);
      }
      i = paramInt;
      if (this.GBn == true) {
        i = paramInt + f.a.a.b.b.a.p(8, this.GBm);
      }
      paramInt = i;
      if (this.GBp == true) {
        paramInt = i + f.a.a.b.b.a.bz(91, this.GBo);
      }
      i = paramInt;
      if (this.GBh != null) {
        i = paramInt + f.a.a.a.lI(10, this.GBh.computeSize());
      }
      paramInt = i;
      if (this.GBq == true) {
        paramInt = i + f.a.a.b.b.a.p(11, this.pWN);
      }
      i = paramInt;
      if (this.GBj != null) {
        i = paramInt + f.a.a.a.lI(12, this.GBj.computeSize());
      }
      paramInt = i;
      if (this.GCh == true) {
        paramInt = i + f.a.a.b.b.a.bz(13, this.version);
      }
      i = paramInt;
      if (this.FId != null) {
        i = paramInt + f.a.a.a.lI(14, this.FId.computeSize());
      }
      paramInt = i;
      if (this.GBs != null) {
        paramInt = i + f.a.a.a.lI(15, this.GBs.computeSize());
      }
      i = paramInt;
      if (this.Ekw != null) {
        i = paramInt + f.a.a.a.lI(16, this.Ekw.computeSize());
      }
      paramInt = i;
      if (this.GBx != null) {
        paramInt = i + f.a.a.a.lI(17, this.GBx.computeSize());
      }
      AppMethodBeat.o(127474);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.oeJ.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(127474);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        akn localakn = (akn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(127474);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new akt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((akt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localakn.GCe = ((akt)localObject1);
            paramInt += 1;
          }
          localakn.GCf = true;
          AppMethodBeat.o(127474);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ajx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ajx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localakn.oeJ.add(localObject1);
            paramInt += 1;
          }
          localakn.GCg = true;
          AppMethodBeat.o(127474);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ake();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ake)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localakn.GBd = ((ake)localObject1);
            paramInt += 1;
          }
          localakn.GBe = true;
          AppMethodBeat.o(127474);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new alc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((alc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localakn.GBf = ((alc)localObject1);
            paramInt += 1;
          }
          localakn.GBg = true;
          AppMethodBeat.o(127474);
          return 0;
        case 5: 
          localakn.iWF = ((f.a.a.a.a)localObject1).OmT.readString();
          localakn.GBl = true;
          AppMethodBeat.o(127474);
          return 0;
        case 6: 
          localakn.title = ((f.a.a.a.a)localObject1).OmT.readString();
          localakn.Gzt = true;
          AppMethodBeat.o(127474);
          return 0;
        case 7: 
          localakn.desc = ((f.a.a.a.a)localObject1).OmT.readString();
          localakn.Gzu = true;
          AppMethodBeat.o(127474);
          return 0;
        case 8: 
          localakn.GBm = ((f.a.a.a.a)localObject1).OmT.zd();
          localakn.GBn = true;
          AppMethodBeat.o(127474);
          return 0;
        case 91: 
          localakn.GBo = ((f.a.a.a.a)localObject1).OmT.zc();
          localakn.GBp = true;
          AppMethodBeat.o(127474);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new akm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((akm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localakn.GBh = ((akm)localObject1);
            paramInt += 1;
          }
          localakn.GBi = true;
          AppMethodBeat.o(127474);
          return 0;
        case 11: 
          localakn.pWN = ((f.a.a.a.a)localObject1).OmT.zd();
          localakn.GBq = true;
          AppMethodBeat.o(127474);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new akw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((akw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localakn.GBj = ((akw)localObject1);
            paramInt += 1;
          }
          localakn.GBk = true;
          AppMethodBeat.o(127474);
          return 0;
        case 13: 
          localakn.version = ((f.a.a.a.a)localObject1).OmT.zc();
          localakn.GCh = true;
          AppMethodBeat.o(127474);
          return 0;
        case 14: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new akh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((akh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localakn.FId = ((akh)localObject1);
            paramInt += 1;
          }
          localakn.GBr = true;
          AppMethodBeat.o(127474);
          return 0;
        case 15: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ajv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ajv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localakn.GBs = ((ajv)localObject1);
            paramInt += 1;
          }
          localakn.GBt = true;
          AppMethodBeat.o(127474);
          return 0;
        case 16: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new akf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((akf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localakn.Ekw = ((akf)localObject1);
            paramInt += 1;
          }
          localakn.GBu = true;
          AppMethodBeat.o(127474);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ary();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ary)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localakn.GBx = ((ary)localObject1);
          paramInt += 1;
        }
        localakn.GBy = true;
        AppMethodBeat.o(127474);
        return 0;
      }
      AppMethodBeat.o(127474);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.akn
 * JD-Core Version:    0.7.0.1
 */