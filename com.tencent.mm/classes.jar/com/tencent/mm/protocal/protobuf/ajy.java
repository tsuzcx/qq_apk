package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ajy
  extends com.tencent.mm.bw.a
{
  public akf Ekw;
  public akh FId;
  public ajz GBb;
  public boolean GBc = false;
  public ake GBd;
  public boolean GBe = false;
  public alc GBf;
  public boolean GBg = false;
  public akm GBh;
  public boolean GBi = false;
  public akw GBj;
  public boolean GBk = false;
  public boolean GBl = false;
  public long GBm;
  public boolean GBn = false;
  public int GBo = -1;
  public boolean GBp = false;
  public boolean GBq = false;
  public boolean GBr = false;
  public ajv GBs;
  public boolean GBt = false;
  public boolean GBu = false;
  public akf GBv;
  public boolean GBw = false;
  public ary GBx;
  public boolean GBy = false;
  public boolean Gzt = false;
  public boolean Gzu = false;
  public String desc;
  public String iWF;
  public long pWN;
  public String title;
  
  public final ajy a(akm paramakm)
  {
    this.GBh = paramakm;
    this.GBi = true;
    return this;
  }
  
  public final ajy a(akw paramakw)
  {
    this.GBj = paramakw;
    this.GBk = true;
    return this;
  }
  
  public final ajy a(alc paramalc)
  {
    this.GBf = paramalc;
    this.GBg = true;
    return this;
  }
  
  public final ajy b(ajv paramajv)
  {
    this.GBs = paramajv;
    this.GBt = true;
    return this;
  }
  
  public final ajy c(ajz paramajz)
  {
    this.GBb = paramajz;
    this.GBc = true;
    return this;
  }
  
  public final ajy c(ake paramake)
  {
    this.GBd = paramake;
    this.GBe = true;
    return this;
  }
  
  public final ajy c(ary paramary)
  {
    this.GBx = paramary;
    this.GBy = true;
    return this;
  }
  
  public final ajy d(akf paramakf)
  {
    this.Ekw = paramakf;
    this.GBu = true;
    return this;
  }
  
  public final ajy e(akf paramakf)
  {
    this.GBv = paramakf;
    this.GBw = true;
    return this;
  }
  
  public final ajz fkC()
  {
    return this.GBb;
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127458);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GBb != null)
      {
        paramVarArgs.lJ(1, this.GBb.computeSize());
        this.GBb.writeFields(paramVarArgs);
      }
      if (this.GBd != null)
      {
        paramVarArgs.lJ(2, this.GBd.computeSize());
        this.GBd.writeFields(paramVarArgs);
      }
      if (this.GBf != null)
      {
        paramVarArgs.lJ(3, this.GBf.computeSize());
        this.GBf.writeFields(paramVarArgs);
      }
      if (this.GBh != null)
      {
        paramVarArgs.lJ(4, this.GBh.computeSize());
        this.GBh.writeFields(paramVarArgs);
      }
      if (this.GBj != null)
      {
        paramVarArgs.lJ(5, this.GBj.computeSize());
        this.GBj.writeFields(paramVarArgs);
      }
      if (this.iWF != null) {
        paramVarArgs.d(6, this.iWF);
      }
      if (this.title != null) {
        paramVarArgs.d(7, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.d(8, this.desc);
      }
      if (this.GBn == true) {
        paramVarArgs.aZ(9, this.GBm);
      }
      if (this.GBp == true) {
        paramVarArgs.aS(101, this.GBo);
      }
      if (this.GBq == true) {
        paramVarArgs.aZ(11, this.pWN);
      }
      if (this.FId != null)
      {
        paramVarArgs.lJ(12, this.FId.computeSize());
        this.FId.writeFields(paramVarArgs);
      }
      if (this.GBs != null)
      {
        paramVarArgs.lJ(13, this.GBs.computeSize());
        this.GBs.writeFields(paramVarArgs);
      }
      if (this.Ekw != null)
      {
        paramVarArgs.lJ(14, this.Ekw.computeSize());
        this.Ekw.writeFields(paramVarArgs);
      }
      if (this.GBv != null)
      {
        paramVarArgs.lJ(15, this.GBv.computeSize());
        this.GBv.writeFields(paramVarArgs);
      }
      if (this.GBx != null)
      {
        paramVarArgs.lJ(16, this.GBx.computeSize());
        this.GBx.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(127458);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GBb == null) {
        break label2242;
      }
    }
    label2242:
    for (int i = f.a.a.a.lI(1, this.GBb.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GBd != null) {
        paramInt = i + f.a.a.a.lI(2, this.GBd.computeSize());
      }
      i = paramInt;
      if (this.GBf != null) {
        i = paramInt + f.a.a.a.lI(3, this.GBf.computeSize());
      }
      paramInt = i;
      if (this.GBh != null) {
        paramInt = i + f.a.a.a.lI(4, this.GBh.computeSize());
      }
      i = paramInt;
      if (this.GBj != null) {
        i = paramInt + f.a.a.a.lI(5, this.GBj.computeSize());
      }
      paramInt = i;
      if (this.iWF != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.iWF);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.title);
      }
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.desc);
      }
      i = paramInt;
      if (this.GBn == true) {
        i = paramInt + f.a.a.b.b.a.p(9, this.GBm);
      }
      paramInt = i;
      if (this.GBp == true) {
        paramInt = i + f.a.a.b.b.a.bz(101, this.GBo);
      }
      i = paramInt;
      if (this.GBq == true) {
        i = paramInt + f.a.a.b.b.a.p(11, this.pWN);
      }
      paramInt = i;
      if (this.FId != null) {
        paramInt = i + f.a.a.a.lI(12, this.FId.computeSize());
      }
      i = paramInt;
      if (this.GBs != null) {
        i = paramInt + f.a.a.a.lI(13, this.GBs.computeSize());
      }
      paramInt = i;
      if (this.Ekw != null) {
        paramInt = i + f.a.a.a.lI(14, this.Ekw.computeSize());
      }
      i = paramInt;
      if (this.GBv != null) {
        i = paramInt + f.a.a.a.lI(15, this.GBv.computeSize());
      }
      paramInt = i;
      if (this.GBx != null) {
        paramInt = i + f.a.a.a.lI(16, this.GBx.computeSize());
      }
      AppMethodBeat.o(127458);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(127458);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ajy localajy = (ajy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(127458);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ajz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ajz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localajy.GBb = ((ajz)localObject1);
            paramInt += 1;
          }
          localajy.GBc = true;
          AppMethodBeat.o(127458);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ake();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ake)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localajy.GBd = ((ake)localObject1);
            paramInt += 1;
          }
          localajy.GBe = true;
          AppMethodBeat.o(127458);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new alc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((alc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localajy.GBf = ((alc)localObject1);
            paramInt += 1;
          }
          localajy.GBg = true;
          AppMethodBeat.o(127458);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new akm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((akm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localajy.GBh = ((akm)localObject1);
            paramInt += 1;
          }
          localajy.GBi = true;
          AppMethodBeat.o(127458);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new akw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((akw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localajy.GBj = ((akw)localObject1);
            paramInt += 1;
          }
          localajy.GBk = true;
          AppMethodBeat.o(127458);
          return 0;
        case 6: 
          localajy.iWF = ((f.a.a.a.a)localObject1).OmT.readString();
          localajy.GBl = true;
          AppMethodBeat.o(127458);
          return 0;
        case 7: 
          localajy.title = ((f.a.a.a.a)localObject1).OmT.readString();
          localajy.Gzt = true;
          AppMethodBeat.o(127458);
          return 0;
        case 8: 
          localajy.desc = ((f.a.a.a.a)localObject1).OmT.readString();
          localajy.Gzu = true;
          AppMethodBeat.o(127458);
          return 0;
        case 9: 
          localajy.GBm = ((f.a.a.a.a)localObject1).OmT.zd();
          localajy.GBn = true;
          AppMethodBeat.o(127458);
          return 0;
        case 101: 
          localajy.GBo = ((f.a.a.a.a)localObject1).OmT.zc();
          localajy.GBp = true;
          AppMethodBeat.o(127458);
          return 0;
        case 11: 
          localajy.pWN = ((f.a.a.a.a)localObject1).OmT.zd();
          localajy.GBq = true;
          AppMethodBeat.o(127458);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new akh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((akh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localajy.FId = ((akh)localObject1);
            paramInt += 1;
          }
          localajy.GBr = true;
          AppMethodBeat.o(127458);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ajv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ajv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localajy.GBs = ((ajv)localObject1);
            paramInt += 1;
          }
          localajy.GBt = true;
          AppMethodBeat.o(127458);
          return 0;
        case 14: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new akf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((akf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localajy.Ekw = ((akf)localObject1);
            paramInt += 1;
          }
          localajy.GBu = true;
          AppMethodBeat.o(127458);
          return 0;
        case 15: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new akf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((akf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localajy.GBv = ((akf)localObject1);
            paramInt += 1;
          }
          localajy.GBw = true;
          AppMethodBeat.o(127458);
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
          localajy.GBx = ((ary)localObject1);
          paramInt += 1;
        }
        localajy.GBy = true;
        AppMethodBeat.o(127458);
        return 0;
      }
      AppMethodBeat.o(127458);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ajy
 * JD-Core Version:    0.7.0.1
 */