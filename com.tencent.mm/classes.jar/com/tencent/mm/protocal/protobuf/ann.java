package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ann
  extends com.tencent.mm.cd.a
{
  public anu PTL;
  public anw RDh;
  public boolean SxH = false;
  public boolean SxI = false;
  public int SzA = -1;
  public boolean SzB = false;
  public boolean SzC = false;
  public boolean SzD = false;
  public ank SzE;
  public boolean SzF = false;
  public boolean SzG = false;
  public anu SzH;
  public boolean SzI = false;
  public bje SzJ;
  public boolean SzK = false;
  public bcp SzL;
  public boolean SzM = false;
  public bjd SzN;
  public boolean SzO = false;
  public bja SzP;
  public boolean SzQ = false;
  public dbr SzR;
  public boolean SzS = false;
  public bjg SzT;
  public boolean SzU = false;
  public bjg SzV;
  public boolean SzW = false;
  public ano Szn;
  public boolean Szo = false;
  public ant Szp;
  public boolean Szq = false;
  public aor Szr;
  public boolean Szs = false;
  public aob Szt;
  public boolean Szu = false;
  public aol Szv;
  public boolean Szw = false;
  public boolean Szx = false;
  public long Szy;
  public boolean Szz = false;
  public String desc;
  public String remark;
  public String title;
  public long uTt;
  
  public final ann a(aob paramaob)
  {
    this.Szt = paramaob;
    this.Szu = true;
    return this;
  }
  
  public final ann a(aol paramaol)
  {
    this.Szv = paramaol;
    this.Szw = true;
    return this;
  }
  
  public final ann a(bjd parambjd)
  {
    this.SzN = parambjd;
    this.SzO = true;
    return this;
  }
  
  public final ann b(ank paramank)
  {
    this.SzE = paramank;
    this.SzF = true;
    return this;
  }
  
  public final ann b(aor paramaor)
  {
    this.Szr = paramaor;
    this.Szs = true;
    return this;
  }
  
  public final ann c(ano paramano)
  {
    this.Szn = paramano;
    this.Szo = true;
    return this;
  }
  
  public final ann c(ant paramant)
  {
    this.Szp = paramant;
    this.Szq = true;
    return this;
  }
  
  public final ann c(bja parambja)
  {
    this.SzP = parambja;
    this.SzQ = true;
    return this;
  }
  
  public final ann c(bje parambje)
  {
    this.SzJ = parambje;
    this.SzK = true;
    return this;
  }
  
  public final ann d(anu paramanu)
  {
    this.PTL = paramanu;
    this.SzG = true;
    return this;
  }
  
  public final ann d(bjg parambjg)
  {
    this.SzT = parambjg;
    this.SzU = true;
    return this;
  }
  
  public final ann e(anu paramanu)
  {
    this.SzH = paramanu;
    this.SzI = true;
    return this;
  }
  
  public final ann e(bjg parambjg)
  {
    this.SzV = parambjg;
    this.SzW = true;
    return this;
  }
  
  public final ann e(dbr paramdbr)
  {
    this.SzR = paramdbr;
    this.SzS = true;
    return this;
  }
  
  public final ann f(bcp parambcp)
  {
    this.SzL = parambcp;
    this.SzM = true;
    return this;
  }
  
  public final aol hpA()
  {
    return this.Szv;
  }
  
  public final anu hpB()
  {
    return this.SzH;
  }
  
  public final ano hpy()
  {
    return this.Szn;
  }
  
  public final aob hpz()
  {
    return this.Szt;
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127458);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Szn != null)
      {
        paramVarArgs.oE(1, this.Szn.computeSize());
        this.Szn.writeFields(paramVarArgs);
      }
      if (this.Szp != null)
      {
        paramVarArgs.oE(2, this.Szp.computeSize());
        this.Szp.writeFields(paramVarArgs);
      }
      if (this.Szr != null)
      {
        paramVarArgs.oE(3, this.Szr.computeSize());
        this.Szr.writeFields(paramVarArgs);
      }
      if (this.Szt != null)
      {
        paramVarArgs.oE(4, this.Szt.computeSize());
        this.Szt.writeFields(paramVarArgs);
      }
      if (this.Szv != null)
      {
        paramVarArgs.oE(5, this.Szv.computeSize());
        this.Szv.writeFields(paramVarArgs);
      }
      if (this.remark != null) {
        paramVarArgs.f(6, this.remark);
      }
      if (this.title != null) {
        paramVarArgs.f(7, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.f(8, this.desc);
      }
      if (this.Szz == true) {
        paramVarArgs.bm(9, this.Szy);
      }
      if (this.SzB == true) {
        paramVarArgs.aY(101, this.SzA);
      }
      if (this.SzC == true) {
        paramVarArgs.bm(11, this.uTt);
      }
      if (this.RDh != null)
      {
        paramVarArgs.oE(12, this.RDh.computeSize());
        this.RDh.writeFields(paramVarArgs);
      }
      if (this.SzE != null)
      {
        paramVarArgs.oE(13, this.SzE.computeSize());
        this.SzE.writeFields(paramVarArgs);
      }
      if (this.PTL != null)
      {
        paramVarArgs.oE(14, this.PTL.computeSize());
        this.PTL.writeFields(paramVarArgs);
      }
      if (this.SzH != null)
      {
        paramVarArgs.oE(15, this.SzH.computeSize());
        this.SzH.writeFields(paramVarArgs);
      }
      if (this.SzJ != null)
      {
        paramVarArgs.oE(16, this.SzJ.computeSize());
        this.SzJ.writeFields(paramVarArgs);
      }
      if (this.SzL != null)
      {
        paramVarArgs.oE(17, this.SzL.computeSize());
        this.SzL.writeFields(paramVarArgs);
      }
      if (this.SzN != null)
      {
        paramVarArgs.oE(18, this.SzN.computeSize());
        this.SzN.writeFields(paramVarArgs);
      }
      if (this.SzP != null)
      {
        paramVarArgs.oE(19, this.SzP.computeSize());
        this.SzP.writeFields(paramVarArgs);
      }
      if (this.SzR != null)
      {
        paramVarArgs.oE(20, this.SzR.computeSize());
        this.SzR.writeFields(paramVarArgs);
      }
      if (this.SzT != null)
      {
        paramVarArgs.oE(21, this.SzT.computeSize());
        this.SzT.writeFields(paramVarArgs);
      }
      if (this.SzV != null)
      {
        paramVarArgs.oE(22, this.SzV.computeSize());
        this.SzV.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(127458);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Szn == null) {
        break label2886;
      }
    }
    label2886:
    for (int i = g.a.a.a.oD(1, this.Szn.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Szp != null) {
        paramInt = i + g.a.a.a.oD(2, this.Szp.computeSize());
      }
      i = paramInt;
      if (this.Szr != null) {
        i = paramInt + g.a.a.a.oD(3, this.Szr.computeSize());
      }
      paramInt = i;
      if (this.Szt != null) {
        paramInt = i + g.a.a.a.oD(4, this.Szt.computeSize());
      }
      i = paramInt;
      if (this.Szv != null) {
        i = paramInt + g.a.a.a.oD(5, this.Szv.computeSize());
      }
      paramInt = i;
      if (this.remark != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.remark);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.title);
      }
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.desc);
      }
      i = paramInt;
      if (this.Szz == true) {
        i = paramInt + g.a.a.b.b.a.p(9, this.Szy);
      }
      paramInt = i;
      if (this.SzB == true) {
        paramInt = i + g.a.a.b.b.a.bM(101, this.SzA);
      }
      i = paramInt;
      if (this.SzC == true) {
        i = paramInt + g.a.a.b.b.a.p(11, this.uTt);
      }
      paramInt = i;
      if (this.RDh != null) {
        paramInt = i + g.a.a.a.oD(12, this.RDh.computeSize());
      }
      i = paramInt;
      if (this.SzE != null) {
        i = paramInt + g.a.a.a.oD(13, this.SzE.computeSize());
      }
      paramInt = i;
      if (this.PTL != null) {
        paramInt = i + g.a.a.a.oD(14, this.PTL.computeSize());
      }
      i = paramInt;
      if (this.SzH != null) {
        i = paramInt + g.a.a.a.oD(15, this.SzH.computeSize());
      }
      paramInt = i;
      if (this.SzJ != null) {
        paramInt = i + g.a.a.a.oD(16, this.SzJ.computeSize());
      }
      i = paramInt;
      if (this.SzL != null) {
        i = paramInt + g.a.a.a.oD(17, this.SzL.computeSize());
      }
      paramInt = i;
      if (this.SzN != null) {
        paramInt = i + g.a.a.a.oD(18, this.SzN.computeSize());
      }
      i = paramInt;
      if (this.SzP != null) {
        i = paramInt + g.a.a.a.oD(19, this.SzP.computeSize());
      }
      paramInt = i;
      if (this.SzR != null) {
        paramInt = i + g.a.a.a.oD(20, this.SzR.computeSize());
      }
      i = paramInt;
      if (this.SzT != null) {
        i = paramInt + g.a.a.a.oD(21, this.SzT.computeSize());
      }
      paramInt = i;
      if (this.SzV != null) {
        paramInt = i + g.a.a.a.oD(22, this.SzV.computeSize());
      }
      AppMethodBeat.o(127458);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(127458);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ann localann = (ann)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(127458);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ano();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ano)localObject2).parseFrom((byte[])localObject1);
            }
            localann.Szn = ((ano)localObject2);
            paramInt += 1;
          }
          localann.Szo = true;
          AppMethodBeat.o(127458);
          return 0;
        case 2: 
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
            localann.Szp = ((ant)localObject2);
            paramInt += 1;
          }
          localann.Szq = true;
          AppMethodBeat.o(127458);
          return 0;
        case 3: 
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
            localann.Szr = ((aor)localObject2);
            paramInt += 1;
          }
          localann.Szs = true;
          AppMethodBeat.o(127458);
          return 0;
        case 4: 
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
            localann.Szt = ((aob)localObject2);
            paramInt += 1;
          }
          localann.Szu = true;
          AppMethodBeat.o(127458);
          return 0;
        case 5: 
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
            localann.Szv = ((aol)localObject2);
            paramInt += 1;
          }
          localann.Szw = true;
          AppMethodBeat.o(127458);
          return 0;
        case 6: 
          localann.remark = ((g.a.a.a.a)localObject1).abFh.readString();
          localann.Szx = true;
          AppMethodBeat.o(127458);
          return 0;
        case 7: 
          localann.title = ((g.a.a.a.a)localObject1).abFh.readString();
          localann.SxH = true;
          AppMethodBeat.o(127458);
          return 0;
        case 8: 
          localann.desc = ((g.a.a.a.a)localObject1).abFh.readString();
          localann.SxI = true;
          AppMethodBeat.o(127458);
          return 0;
        case 9: 
          localann.Szy = ((g.a.a.a.a)localObject1).abFh.AN();
          localann.Szz = true;
          AppMethodBeat.o(127458);
          return 0;
        case 101: 
          localann.SzA = ((g.a.a.a.a)localObject1).abFh.AK();
          localann.SzB = true;
          AppMethodBeat.o(127458);
          return 0;
        case 11: 
          localann.uTt = ((g.a.a.a.a)localObject1).abFh.AN();
          localann.SzC = true;
          AppMethodBeat.o(127458);
          return 0;
        case 12: 
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
            localann.RDh = ((anw)localObject2);
            paramInt += 1;
          }
          localann.SzD = true;
          AppMethodBeat.o(127458);
          return 0;
        case 13: 
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
            localann.SzE = ((ank)localObject2);
            paramInt += 1;
          }
          localann.SzF = true;
          AppMethodBeat.o(127458);
          return 0;
        case 14: 
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
            localann.PTL = ((anu)localObject2);
            paramInt += 1;
          }
          localann.SzG = true;
          AppMethodBeat.o(127458);
          return 0;
        case 15: 
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
            localann.SzH = ((anu)localObject2);
            paramInt += 1;
          }
          localann.SzI = true;
          AppMethodBeat.o(127458);
          return 0;
        case 16: 
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
            localann.SzJ = ((bje)localObject2);
            paramInt += 1;
          }
          localann.SzK = true;
          AppMethodBeat.o(127458);
          return 0;
        case 17: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bcp();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bcp)localObject2).parseFrom((byte[])localObject1);
            }
            localann.SzL = ((bcp)localObject2);
            paramInt += 1;
          }
          localann.SzM = true;
          AppMethodBeat.o(127458);
          return 0;
        case 18: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bjd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bjd)localObject2).parseFrom((byte[])localObject1);
            }
            localann.SzN = ((bjd)localObject2);
            paramInt += 1;
          }
          localann.SzO = true;
          AppMethodBeat.o(127458);
          return 0;
        case 19: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bja();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bja)localObject2).parseFrom((byte[])localObject1);
            }
            localann.SzP = ((bja)localObject2);
            paramInt += 1;
          }
          localann.SzQ = true;
          AppMethodBeat.o(127458);
          return 0;
        case 20: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dbr();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dbr)localObject2).parseFrom((byte[])localObject1);
            }
            localann.SzR = ((dbr)localObject2);
            paramInt += 1;
          }
          localann.SzS = true;
          AppMethodBeat.o(127458);
          return 0;
        case 21: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bjg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bjg)localObject2).parseFrom((byte[])localObject1);
            }
            localann.SzT = ((bjg)localObject2);
            paramInt += 1;
          }
          localann.SzU = true;
          AppMethodBeat.o(127458);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bjg();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bjg)localObject2).parseFrom((byte[])localObject1);
          }
          localann.SzV = ((bjg)localObject2);
          paramInt += 1;
        }
        localann.SzW = true;
        AppMethodBeat.o(127458);
        return 0;
      }
      AppMethodBeat.o(127458);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ann
 * JD-Core Version:    0.7.0.1
 */