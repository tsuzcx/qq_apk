package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class akd
  extends com.tencent.mm.bx.a
{
  public ajv DSw;
  public ajx FpF;
  public boolean GgK;
  public boolean GgL;
  public akm GiA;
  public boolean GiB;
  public boolean GiC;
  public long GiD;
  public boolean GiE;
  public int GiF;
  public boolean GiG;
  public boolean GiH;
  public boolean GiI;
  public ajl GiJ;
  public boolean GiK;
  public boolean GiL;
  public arj GiO;
  public boolean GiP;
  public aju Giu;
  public boolean Giv;
  public aks Giw;
  public boolean Gix;
  public akc Giy;
  public boolean Giz;
  public akj Gjv;
  public boolean Gjw;
  public boolean Gjx;
  public boolean Gjy;
  public String desc;
  public String iTM;
  public LinkedList<ajn> nZa;
  public long pQi;
  public String title;
  public int version;
  
  public akd()
  {
    AppMethodBeat.i(127473);
    this.Gjw = false;
    this.nZa = new LinkedList();
    this.Gjx = false;
    this.Giv = false;
    this.Gix = false;
    this.GiC = false;
    this.GgK = false;
    this.GgL = false;
    this.GiE = false;
    this.GiF = -1;
    this.GiG = false;
    this.Giz = false;
    this.GiH = false;
    this.GiB = false;
    this.Gjy = false;
    this.GiI = false;
    this.GiK = false;
    this.GiL = false;
    this.GiP = false;
    AppMethodBeat.o(127473);
  }
  
  public final akd CK(long paramLong)
  {
    this.GiD = paramLong;
    this.GiE = true;
    return this;
  }
  
  public final akd CL(long paramLong)
  {
    this.pQi = paramLong;
    this.GiH = true;
    return this;
  }
  
  public final akd ZP(int paramInt)
  {
    this.GiF = paramInt;
    this.GiG = true;
    return this;
  }
  
  public final akd ZQ(int paramInt)
  {
    this.version = paramInt;
    this.Gjy = true;
    return this;
  }
  
  public final akd a(ajx paramajx)
  {
    this.FpF = paramajx;
    this.GiI = true;
    return this;
  }
  
  public final akd a(akj paramakj)
  {
    this.Gjv = paramakj;
    this.Gjw = true;
    return this;
  }
  
  public final akd aPc(String paramString)
  {
    this.iTM = paramString;
    this.GiC = true;
    return this;
  }
  
  public final akd aPd(String paramString)
  {
    this.title = paramString;
    this.GgK = true;
    return this;
  }
  
  public final akd aPe(String paramString)
  {
    this.desc = paramString;
    this.GgL = true;
    return this;
  }
  
  public final akd b(akc paramakc)
  {
    this.Giy = paramakc;
    this.Giz = true;
    return this;
  }
  
  public final akd b(akm paramakm)
  {
    this.GiA = paramakm;
    this.GiB = true;
    return this;
  }
  
  public final akd b(aks paramaks)
  {
    this.Giw = paramaks;
    this.Gix = true;
    return this;
  }
  
  public final akd bl(LinkedList<ajn> paramLinkedList)
  {
    this.nZa = paramLinkedList;
    this.Gjx = true;
    return this;
  }
  
  public final akd c(ajl paramajl)
  {
    this.GiJ = paramajl;
    this.GiK = true;
    return this;
  }
  
  public final akd d(aju paramaju)
  {
    this.Giu = paramaju;
    this.Giv = true;
    return this;
  }
  
  public final akd d(arj paramarj)
  {
    this.GiO = paramarj;
    this.GiP = true;
    return this;
  }
  
  public final akd f(ajv paramajv)
  {
    this.DSw = paramajv;
    this.GiL = true;
    return this;
  }
  
  public final arj fgN()
  {
    return this.GiO;
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127474);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Gjv != null)
      {
        paramVarArgs.lC(1, this.Gjv.computeSize());
        this.Gjv.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.nZa);
      if (this.Giu != null)
      {
        paramVarArgs.lC(3, this.Giu.computeSize());
        this.Giu.writeFields(paramVarArgs);
      }
      if (this.Giw != null)
      {
        paramVarArgs.lC(4, this.Giw.computeSize());
        this.Giw.writeFields(paramVarArgs);
      }
      if (this.iTM != null) {
        paramVarArgs.d(5, this.iTM);
      }
      if (this.title != null) {
        paramVarArgs.d(6, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.d(7, this.desc);
      }
      if (this.GiE == true) {
        paramVarArgs.aY(8, this.GiD);
      }
      if (this.GiG == true) {
        paramVarArgs.aS(91, this.GiF);
      }
      if (this.Giy != null)
      {
        paramVarArgs.lC(10, this.Giy.computeSize());
        this.Giy.writeFields(paramVarArgs);
      }
      if (this.GiH == true) {
        paramVarArgs.aY(11, this.pQi);
      }
      if (this.GiA != null)
      {
        paramVarArgs.lC(12, this.GiA.computeSize());
        this.GiA.writeFields(paramVarArgs);
      }
      if (this.Gjy == true) {
        paramVarArgs.aS(13, this.version);
      }
      if (this.FpF != null)
      {
        paramVarArgs.lC(14, this.FpF.computeSize());
        this.FpF.writeFields(paramVarArgs);
      }
      if (this.GiJ != null)
      {
        paramVarArgs.lC(15, this.GiJ.computeSize());
        this.GiJ.writeFields(paramVarArgs);
      }
      if (this.DSw != null)
      {
        paramVarArgs.lC(16, this.DSw.computeSize());
        this.DSw.writeFields(paramVarArgs);
      }
      if (this.GiO != null)
      {
        paramVarArgs.lC(17, this.GiO.computeSize());
        this.GiO.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(127474);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Gjv == null) {
        break label2300;
      }
    }
    label2300:
    for (paramInt = f.a.a.a.lB(1, this.Gjv.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.nZa);
      paramInt = i;
      if (this.Giu != null) {
        paramInt = i + f.a.a.a.lB(3, this.Giu.computeSize());
      }
      i = paramInt;
      if (this.Giw != null) {
        i = paramInt + f.a.a.a.lB(4, this.Giw.computeSize());
      }
      paramInt = i;
      if (this.iTM != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.iTM);
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
      if (this.GiE == true) {
        i = paramInt + f.a.a.b.b.a.p(8, this.GiD);
      }
      paramInt = i;
      if (this.GiG == true) {
        paramInt = i + f.a.a.b.b.a.bz(91, this.GiF);
      }
      i = paramInt;
      if (this.Giy != null) {
        i = paramInt + f.a.a.a.lB(10, this.Giy.computeSize());
      }
      paramInt = i;
      if (this.GiH == true) {
        paramInt = i + f.a.a.b.b.a.p(11, this.pQi);
      }
      i = paramInt;
      if (this.GiA != null) {
        i = paramInt + f.a.a.a.lB(12, this.GiA.computeSize());
      }
      paramInt = i;
      if (this.Gjy == true) {
        paramInt = i + f.a.a.b.b.a.bz(13, this.version);
      }
      i = paramInt;
      if (this.FpF != null) {
        i = paramInt + f.a.a.a.lB(14, this.FpF.computeSize());
      }
      paramInt = i;
      if (this.GiJ != null) {
        paramInt = i + f.a.a.a.lB(15, this.GiJ.computeSize());
      }
      i = paramInt;
      if (this.DSw != null) {
        i = paramInt + f.a.a.a.lB(16, this.DSw.computeSize());
      }
      paramInt = i;
      if (this.GiO != null) {
        paramInt = i + f.a.a.a.lB(17, this.GiO.computeSize());
      }
      AppMethodBeat.o(127474);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.nZa.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(127474);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        akd localakd = (akd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(127474);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new akj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((akj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localakd.Gjv = ((akj)localObject1);
            paramInt += 1;
          }
          localakd.Gjw = true;
          AppMethodBeat.o(127474);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ajn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ajn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localakd.nZa.add(localObject1);
            paramInt += 1;
          }
          localakd.Gjx = true;
          AppMethodBeat.o(127474);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aju();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aju)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localakd.Giu = ((aju)localObject1);
            paramInt += 1;
          }
          localakd.Giv = true;
          AppMethodBeat.o(127474);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aks();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aks)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localakd.Giw = ((aks)localObject1);
            paramInt += 1;
          }
          localakd.Gix = true;
          AppMethodBeat.o(127474);
          return 0;
        case 5: 
          localakd.iTM = ((f.a.a.a.a)localObject1).NPN.readString();
          localakd.GiC = true;
          AppMethodBeat.o(127474);
          return 0;
        case 6: 
          localakd.title = ((f.a.a.a.a)localObject1).NPN.readString();
          localakd.GgK = true;
          AppMethodBeat.o(127474);
          return 0;
        case 7: 
          localakd.desc = ((f.a.a.a.a)localObject1).NPN.readString();
          localakd.GgL = true;
          AppMethodBeat.o(127474);
          return 0;
        case 8: 
          localakd.GiD = ((f.a.a.a.a)localObject1).NPN.zd();
          localakd.GiE = true;
          AppMethodBeat.o(127474);
          return 0;
        case 91: 
          localakd.GiF = ((f.a.a.a.a)localObject1).NPN.zc();
          localakd.GiG = true;
          AppMethodBeat.o(127474);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new akc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((akc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localakd.Giy = ((akc)localObject1);
            paramInt += 1;
          }
          localakd.Giz = true;
          AppMethodBeat.o(127474);
          return 0;
        case 11: 
          localakd.pQi = ((f.a.a.a.a)localObject1).NPN.zd();
          localakd.GiH = true;
          AppMethodBeat.o(127474);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new akm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((akm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localakd.GiA = ((akm)localObject1);
            paramInt += 1;
          }
          localakd.GiB = true;
          AppMethodBeat.o(127474);
          return 0;
        case 13: 
          localakd.version = ((f.a.a.a.a)localObject1).NPN.zc();
          localakd.Gjy = true;
          AppMethodBeat.o(127474);
          return 0;
        case 14: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ajx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ajx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localakd.FpF = ((ajx)localObject1);
            paramInt += 1;
          }
          localakd.GiI = true;
          AppMethodBeat.o(127474);
          return 0;
        case 15: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ajl();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ajl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localakd.GiJ = ((ajl)localObject1);
            paramInt += 1;
          }
          localakd.GiK = true;
          AppMethodBeat.o(127474);
          return 0;
        case 16: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ajv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ajv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localakd.DSw = ((ajv)localObject1);
            paramInt += 1;
          }
          localakd.GiL = true;
          AppMethodBeat.o(127474);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new arj();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((arj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localakd.GiO = ((arj)localObject1);
          paramInt += 1;
        }
        localakd.GiP = true;
        AppMethodBeat.o(127474);
        return 0;
      }
      AppMethodBeat.o(127474);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.akd
 * JD-Core Version:    0.7.0.1
 */