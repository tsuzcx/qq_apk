package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bwa
  extends com.tencent.mm.bw.a
{
  public int DNa;
  public int DNd;
  public crm EuE;
  public long Eyr;
  public String Eys;
  public crm Fbd;
  public int Feq;
  public String Fer;
  public String Fes;
  public String Fet;
  public int Feu;
  public int FkG;
  public int FlA;
  public crm FlB;
  public crm FlC;
  public int FlD;
  public int FlE;
  public int FlF;
  public int FlG;
  public int FlH;
  public bib FlI;
  public int FlJ;
  public String FlK;
  public acw Fld;
  public int Flr;
  public int Flx;
  public com.tencent.mm.bw.b Fly;
  public int iJT;
  public String iJU;
  public String iJV;
  public String iJW;
  public int iJX;
  public String iJY;
  public int iJZ;
  public int iKa;
  public String iKb;
  public String iKc;
  public int ndj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43112);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EuE == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: UserName");
        AppMethodBeat.o(43112);
        throw paramVarArgs;
      }
      if (this.Fbd == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: NickName");
        AppMethodBeat.o(43112);
        throw paramVarArgs;
      }
      if (this.FlB == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BindEmail");
        AppMethodBeat.o(43112);
        throw paramVarArgs;
      }
      if (this.FlC == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BindMobile");
        AppMethodBeat.o(43112);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.FlA);
      if (this.EuE != null)
      {
        paramVarArgs.ln(2, this.EuE.computeSize());
        this.EuE.writeFields(paramVarArgs);
      }
      if (this.Fbd != null)
      {
        paramVarArgs.ln(3, this.Fbd.computeSize());
        this.Fbd.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(4, this.DNa);
      if (this.FlB != null)
      {
        paramVarArgs.ln(5, this.FlB.computeSize());
        this.FlB.writeFields(paramVarArgs);
      }
      if (this.FlC != null)
      {
        paramVarArgs.ln(6, this.FlC.computeSize());
        this.FlC.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(7, this.ndj);
      paramVarArgs.aR(8, this.Flx);
      if (this.Fly != null) {
        paramVarArgs.c(9, this.Fly);
      }
      paramVarArgs.aR(10, this.iJT);
      if (this.iJU != null) {
        paramVarArgs.d(11, this.iJU);
      }
      if (this.iJV != null) {
        paramVarArgs.d(12, this.iJV);
      }
      if (this.iJW != null) {
        paramVarArgs.d(13, this.iJW);
      }
      paramVarArgs.aR(14, this.iJX);
      if (this.Fld != null)
      {
        paramVarArgs.ln(15, this.Fld.computeSize());
        this.Fld.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(16, this.DNd);
      paramVarArgs.aR(17, this.Feq);
      if (this.Fer != null) {
        paramVarArgs.d(18, this.Fer);
      }
      paramVarArgs.aR(19, this.FlD);
      paramVarArgs.aR(20, this.FlE);
      paramVarArgs.aR(21, this.FkG);
      paramVarArgs.aR(22, this.FlF);
      paramVarArgs.aR(23, this.FlG);
      if (this.Fes != null) {
        paramVarArgs.d(24, this.Fes);
      }
      paramVarArgs.aR(25, this.FlH);
      if (this.FlI != null)
      {
        paramVarArgs.ln(26, this.FlI.computeSize());
        this.FlI.writeFields(paramVarArgs);
      }
      if (this.iJY != null) {
        paramVarArgs.d(27, this.iJY);
      }
      if (this.Fet != null) {
        paramVarArgs.d(28, this.Fet);
      }
      paramVarArgs.aR(29, this.Feu);
      paramVarArgs.aR(30, this.FlJ);
      paramVarArgs.aO(31, this.Eyr);
      if (this.Eys != null) {
        paramVarArgs.d(32, this.Eys);
      }
      paramVarArgs.aR(33, this.iKa);
      paramVarArgs.aR(34, this.iJZ);
      if (this.iKb != null) {
        paramVarArgs.d(35, this.iKb);
      }
      paramVarArgs.aR(36, this.Flr);
      if (this.FlK != null) {
        paramVarArgs.d(37, this.FlK);
      }
      if (this.iKc != null) {
        paramVarArgs.d(38, this.iKc);
      }
      AppMethodBeat.o(43112);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.FlA) + 0;
      paramInt = i;
      if (this.EuE != null) {
        paramInt = i + f.a.a.a.lm(2, this.EuE.computeSize());
      }
      i = paramInt;
      if (this.Fbd != null) {
        i = paramInt + f.a.a.a.lm(3, this.Fbd.computeSize());
      }
      i += f.a.a.b.b.a.bx(4, this.DNa);
      paramInt = i;
      if (this.FlB != null) {
        paramInt = i + f.a.a.a.lm(5, this.FlB.computeSize());
      }
      i = paramInt;
      if (this.FlC != null) {
        i = paramInt + f.a.a.a.lm(6, this.FlC.computeSize());
      }
      i = i + f.a.a.b.b.a.bx(7, this.ndj) + f.a.a.b.b.a.bx(8, this.Flx);
      paramInt = i;
      if (this.Fly != null) {
        paramInt = i + f.a.a.b.b.a.b(9, this.Fly);
      }
      i = paramInt + f.a.a.b.b.a.bx(10, this.iJT);
      paramInt = i;
      if (this.iJU != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.iJU);
      }
      i = paramInt;
      if (this.iJV != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.iJV);
      }
      paramInt = i;
      if (this.iJW != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.iJW);
      }
      i = paramInt + f.a.a.b.b.a.bx(14, this.iJX);
      paramInt = i;
      if (this.Fld != null) {
        paramInt = i + f.a.a.a.lm(15, this.Fld.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bx(16, this.DNd) + f.a.a.b.b.a.bx(17, this.Feq);
      paramInt = i;
      if (this.Fer != null) {
        paramInt = i + f.a.a.b.b.a.e(18, this.Fer);
      }
      i = paramInt + f.a.a.b.b.a.bx(19, this.FlD) + f.a.a.b.b.a.bx(20, this.FlE) + f.a.a.b.b.a.bx(21, this.FkG) + f.a.a.b.b.a.bx(22, this.FlF) + f.a.a.b.b.a.bx(23, this.FlG);
      paramInt = i;
      if (this.Fes != null) {
        paramInt = i + f.a.a.b.b.a.e(24, this.Fes);
      }
      i = paramInt + f.a.a.b.b.a.bx(25, this.FlH);
      paramInt = i;
      if (this.FlI != null) {
        paramInt = i + f.a.a.a.lm(26, this.FlI.computeSize());
      }
      i = paramInt;
      if (this.iJY != null) {
        i = paramInt + f.a.a.b.b.a.e(27, this.iJY);
      }
      paramInt = i;
      if (this.Fet != null) {
        paramInt = i + f.a.a.b.b.a.e(28, this.Fet);
      }
      i = paramInt + f.a.a.b.b.a.bx(29, this.Feu) + f.a.a.b.b.a.bx(30, this.FlJ) + f.a.a.b.b.a.p(31, this.Eyr);
      paramInt = i;
      if (this.Eys != null) {
        paramInt = i + f.a.a.b.b.a.e(32, this.Eys);
      }
      i = paramInt + f.a.a.b.b.a.bx(33, this.iKa) + f.a.a.b.b.a.bx(34, this.iJZ);
      paramInt = i;
      if (this.iKb != null) {
        paramInt = i + f.a.a.b.b.a.e(35, this.iKb);
      }
      i = paramInt + f.a.a.b.b.a.bx(36, this.Flr);
      paramInt = i;
      if (this.FlK != null) {
        paramInt = i + f.a.a.b.b.a.e(37, this.FlK);
      }
      i = paramInt;
      if (this.iKc != null) {
        i = paramInt + f.a.a.b.b.a.e(38, this.iKc);
      }
      AppMethodBeat.o(43112);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      if (this.EuE == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: UserName");
        AppMethodBeat.o(43112);
        throw paramVarArgs;
      }
      if (this.Fbd == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: NickName");
        AppMethodBeat.o(43112);
        throw paramVarArgs;
      }
      if (this.FlB == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BindEmail");
        AppMethodBeat.o(43112);
        throw paramVarArgs;
      }
      if (this.FlC == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BindMobile");
        AppMethodBeat.o(43112);
        throw paramVarArgs;
      }
      AppMethodBeat.o(43112);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      bwa localbwa = (bwa)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(43112);
        return -1;
      case 1: 
        localbwa.FlA = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(43112);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new crm();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbwa.EuE = ((crm)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(43112);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new crm();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbwa.Fbd = ((crm)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(43112);
        return 0;
      case 4: 
        localbwa.DNa = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(43112);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new crm();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbwa.FlB = ((crm)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(43112);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new crm();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbwa.FlC = ((crm)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(43112);
        return 0;
      case 7: 
        localbwa.ndj = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(43112);
        return 0;
      case 8: 
        localbwa.Flx = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(43112);
        return 0;
      case 9: 
        localbwa.Fly = ((f.a.a.a.a)localObject1).LVo.gfk();
        AppMethodBeat.o(43112);
        return 0;
      case 10: 
        localbwa.iJT = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(43112);
        return 0;
      case 11: 
        localbwa.iJU = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(43112);
        return 0;
      case 12: 
        localbwa.iJV = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(43112);
        return 0;
      case 13: 
        localbwa.iJW = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(43112);
        return 0;
      case 14: 
        localbwa.iJX = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(43112);
        return 0;
      case 15: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new acw();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((acw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbwa.Fld = ((acw)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(43112);
        return 0;
      case 16: 
        localbwa.DNd = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(43112);
        return 0;
      case 17: 
        localbwa.Feq = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(43112);
        return 0;
      case 18: 
        localbwa.Fer = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(43112);
        return 0;
      case 19: 
        localbwa.FlD = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(43112);
        return 0;
      case 20: 
        localbwa.FlE = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(43112);
        return 0;
      case 21: 
        localbwa.FkG = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(43112);
        return 0;
      case 22: 
        localbwa.FlF = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(43112);
        return 0;
      case 23: 
        localbwa.FlG = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(43112);
        return 0;
      case 24: 
        localbwa.Fes = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(43112);
        return 0;
      case 25: 
        localbwa.FlH = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(43112);
        return 0;
      case 26: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bib();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bib)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbwa.FlI = ((bib)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(43112);
        return 0;
      case 27: 
        localbwa.iJY = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(43112);
        return 0;
      case 28: 
        localbwa.Fet = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(43112);
        return 0;
      case 29: 
        localbwa.Feu = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(43112);
        return 0;
      case 30: 
        localbwa.FlJ = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(43112);
        return 0;
      case 31: 
        localbwa.Eyr = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(43112);
        return 0;
      case 32: 
        localbwa.Eys = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(43112);
        return 0;
      case 33: 
        localbwa.iKa = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(43112);
        return 0;
      case 34: 
        localbwa.iJZ = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(43112);
        return 0;
      case 35: 
        localbwa.iKb = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(43112);
        return 0;
      case 36: 
        localbwa.Flr = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(43112);
        return 0;
      case 37: 
        localbwa.FlK = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(43112);
        return 0;
      }
      localbwa.iKc = ((f.a.a.a.a)localObject1).LVo.readString();
      AppMethodBeat.o(43112);
      return 0;
    }
    AppMethodBeat.o(43112);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bwa
 * JD-Core Version:    0.7.0.1
 */