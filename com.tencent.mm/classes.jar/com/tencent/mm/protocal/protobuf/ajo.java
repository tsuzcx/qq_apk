package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ajo
  extends com.tencent.mm.bx.a
{
  public ajv DSw;
  public ajx FpF;
  public boolean GgK = false;
  public boolean GgL = false;
  public akm GiA;
  public boolean GiB = false;
  public boolean GiC = false;
  public long GiD;
  public boolean GiE = false;
  public int GiF = -1;
  public boolean GiG = false;
  public boolean GiH = false;
  public boolean GiI = false;
  public ajl GiJ;
  public boolean GiK = false;
  public boolean GiL = false;
  public ajv GiM;
  public boolean GiN = false;
  public arj GiO;
  public boolean GiP = false;
  public ajp Gis;
  public boolean Git = false;
  public aju Giu;
  public boolean Giv = false;
  public aks Giw;
  public boolean Gix = false;
  public akc Giy;
  public boolean Giz = false;
  public String desc;
  public String iTM;
  public long pQi;
  public String title;
  
  public final ajo a(akc paramakc)
  {
    this.Giy = paramakc;
    this.Giz = true;
    return this;
  }
  
  public final ajo a(akm paramakm)
  {
    this.GiA = paramakm;
    this.GiB = true;
    return this;
  }
  
  public final ajo a(aks paramaks)
  {
    this.Giw = paramaks;
    this.Gix = true;
    return this;
  }
  
  public final ajo b(ajl paramajl)
  {
    this.GiJ = paramajl;
    this.GiK = true;
    return this;
  }
  
  public final ajo c(ajp paramajp)
  {
    this.Gis = paramajp;
    this.Git = true;
    return this;
  }
  
  public final ajo c(aju paramaju)
  {
    this.Giu = paramaju;
    this.Giv = true;
    return this;
  }
  
  public final ajo c(arj paramarj)
  {
    this.GiO = paramarj;
    this.GiP = true;
    return this;
  }
  
  public final ajo d(ajv paramajv)
  {
    this.DSw = paramajv;
    this.GiL = true;
    return this;
  }
  
  public final ajo e(ajv paramajv)
  {
    this.GiM = paramajv;
    this.GiN = true;
    return this;
  }
  
  public final ajp fgL()
  {
    return this.Gis;
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127458);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Gis != null)
      {
        paramVarArgs.lC(1, this.Gis.computeSize());
        this.Gis.writeFields(paramVarArgs);
      }
      if (this.Giu != null)
      {
        paramVarArgs.lC(2, this.Giu.computeSize());
        this.Giu.writeFields(paramVarArgs);
      }
      if (this.Giw != null)
      {
        paramVarArgs.lC(3, this.Giw.computeSize());
        this.Giw.writeFields(paramVarArgs);
      }
      if (this.Giy != null)
      {
        paramVarArgs.lC(4, this.Giy.computeSize());
        this.Giy.writeFields(paramVarArgs);
      }
      if (this.GiA != null)
      {
        paramVarArgs.lC(5, this.GiA.computeSize());
        this.GiA.writeFields(paramVarArgs);
      }
      if (this.iTM != null) {
        paramVarArgs.d(6, this.iTM);
      }
      if (this.title != null) {
        paramVarArgs.d(7, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.d(8, this.desc);
      }
      if (this.GiE == true) {
        paramVarArgs.aY(9, this.GiD);
      }
      if (this.GiG == true) {
        paramVarArgs.aS(101, this.GiF);
      }
      if (this.GiH == true) {
        paramVarArgs.aY(11, this.pQi);
      }
      if (this.FpF != null)
      {
        paramVarArgs.lC(12, this.FpF.computeSize());
        this.FpF.writeFields(paramVarArgs);
      }
      if (this.GiJ != null)
      {
        paramVarArgs.lC(13, this.GiJ.computeSize());
        this.GiJ.writeFields(paramVarArgs);
      }
      if (this.DSw != null)
      {
        paramVarArgs.lC(14, this.DSw.computeSize());
        this.DSw.writeFields(paramVarArgs);
      }
      if (this.GiM != null)
      {
        paramVarArgs.lC(15, this.GiM.computeSize());
        this.GiM.writeFields(paramVarArgs);
      }
      if (this.GiO != null)
      {
        paramVarArgs.lC(16, this.GiO.computeSize());
        this.GiO.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(127458);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Gis == null) {
        break label2242;
      }
    }
    label2242:
    for (int i = f.a.a.a.lB(1, this.Gis.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Giu != null) {
        paramInt = i + f.a.a.a.lB(2, this.Giu.computeSize());
      }
      i = paramInt;
      if (this.Giw != null) {
        i = paramInt + f.a.a.a.lB(3, this.Giw.computeSize());
      }
      paramInt = i;
      if (this.Giy != null) {
        paramInt = i + f.a.a.a.lB(4, this.Giy.computeSize());
      }
      i = paramInt;
      if (this.GiA != null) {
        i = paramInt + f.a.a.a.lB(5, this.GiA.computeSize());
      }
      paramInt = i;
      if (this.iTM != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.iTM);
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
      if (this.GiE == true) {
        i = paramInt + f.a.a.b.b.a.p(9, this.GiD);
      }
      paramInt = i;
      if (this.GiG == true) {
        paramInt = i + f.a.a.b.b.a.bz(101, this.GiF);
      }
      i = paramInt;
      if (this.GiH == true) {
        i = paramInt + f.a.a.b.b.a.p(11, this.pQi);
      }
      paramInt = i;
      if (this.FpF != null) {
        paramInt = i + f.a.a.a.lB(12, this.FpF.computeSize());
      }
      i = paramInt;
      if (this.GiJ != null) {
        i = paramInt + f.a.a.a.lB(13, this.GiJ.computeSize());
      }
      paramInt = i;
      if (this.DSw != null) {
        paramInt = i + f.a.a.a.lB(14, this.DSw.computeSize());
      }
      i = paramInt;
      if (this.GiM != null) {
        i = paramInt + f.a.a.a.lB(15, this.GiM.computeSize());
      }
      paramInt = i;
      if (this.GiO != null) {
        paramInt = i + f.a.a.a.lB(16, this.GiO.computeSize());
      }
      AppMethodBeat.o(127458);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(127458);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ajo localajo = (ajo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(127458);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ajp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ajp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localajo.Gis = ((ajp)localObject1);
            paramInt += 1;
          }
          localajo.Git = true;
          AppMethodBeat.o(127458);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aju();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aju)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localajo.Giu = ((aju)localObject1);
            paramInt += 1;
          }
          localajo.Giv = true;
          AppMethodBeat.o(127458);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aks();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aks)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localajo.Giw = ((aks)localObject1);
            paramInt += 1;
          }
          localajo.Gix = true;
          AppMethodBeat.o(127458);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new akc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((akc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localajo.Giy = ((akc)localObject1);
            paramInt += 1;
          }
          localajo.Giz = true;
          AppMethodBeat.o(127458);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new akm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((akm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localajo.GiA = ((akm)localObject1);
            paramInt += 1;
          }
          localajo.GiB = true;
          AppMethodBeat.o(127458);
          return 0;
        case 6: 
          localajo.iTM = ((f.a.a.a.a)localObject1).NPN.readString();
          localajo.GiC = true;
          AppMethodBeat.o(127458);
          return 0;
        case 7: 
          localajo.title = ((f.a.a.a.a)localObject1).NPN.readString();
          localajo.GgK = true;
          AppMethodBeat.o(127458);
          return 0;
        case 8: 
          localajo.desc = ((f.a.a.a.a)localObject1).NPN.readString();
          localajo.GgL = true;
          AppMethodBeat.o(127458);
          return 0;
        case 9: 
          localajo.GiD = ((f.a.a.a.a)localObject1).NPN.zd();
          localajo.GiE = true;
          AppMethodBeat.o(127458);
          return 0;
        case 101: 
          localajo.GiF = ((f.a.a.a.a)localObject1).NPN.zc();
          localajo.GiG = true;
          AppMethodBeat.o(127458);
          return 0;
        case 11: 
          localajo.pQi = ((f.a.a.a.a)localObject1).NPN.zd();
          localajo.GiH = true;
          AppMethodBeat.o(127458);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ajx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ajx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localajo.FpF = ((ajx)localObject1);
            paramInt += 1;
          }
          localajo.GiI = true;
          AppMethodBeat.o(127458);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ajl();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ajl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localajo.GiJ = ((ajl)localObject1);
            paramInt += 1;
          }
          localajo.GiK = true;
          AppMethodBeat.o(127458);
          return 0;
        case 14: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ajv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ajv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localajo.DSw = ((ajv)localObject1);
            paramInt += 1;
          }
          localajo.GiL = true;
          AppMethodBeat.o(127458);
          return 0;
        case 15: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ajv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ajv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localajo.GiM = ((ajv)localObject1);
            paramInt += 1;
          }
          localajo.GiN = true;
          AppMethodBeat.o(127458);
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
          localajo.GiO = ((arj)localObject1);
          paramInt += 1;
        }
        localajo.GiP = true;
        AppMethodBeat.o(127458);
        return 0;
      }
      AppMethodBeat.o(127458);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ajo
 * JD-Core Version:    0.7.0.1
 */