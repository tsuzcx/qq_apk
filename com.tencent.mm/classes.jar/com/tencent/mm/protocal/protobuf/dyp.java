package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dyp
  extends com.tencent.mm.bw.a
{
  public dgk BYp;
  public String EJp;
  public long EfR;
  public String EfU;
  public int EfV;
  public int FCc;
  public int FCg;
  public LinkedList<doh> FEW;
  public bpa FhT;
  public int FrR;
  public LinkedList<yh> Gdj;
  public int GeJ;
  public String GeK;
  public String GeL;
  public int GeM;
  public LinkedList<String> GeN;
  public LinkedList<byh> GeO;
  public com.tencent.mm.bw.b GeP;
  public com.tencent.mm.bw.b GeQ;
  public dad GeR;
  public aaj GeS;
  public cfw GeT;
  public int Geu;
  public String Gev;
  public int Scene;
  public String pAD;
  
  public dyp()
  {
    AppMethodBeat.i(117954);
    this.FEW = new LinkedList();
    this.GeN = new LinkedList();
    this.Geu = 2;
    this.Gdj = new LinkedList();
    this.GeO = new LinkedList();
    AppMethodBeat.o(117954);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117955);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EJp == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Keyword");
        AppMethodBeat.o(117955);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.FCc);
      if (this.EJp != null) {
        paramVarArgs.d(2, this.EJp);
      }
      paramVarArgs.aR(3, this.EfV);
      paramVarArgs.aO(4, this.EfR);
      paramVarArgs.aR(5, this.GeJ);
      if (this.FhT != null)
      {
        paramVarArgs.ln(6, this.FhT.computeSize());
        this.FhT.writeFields(paramVarArgs);
      }
      paramVarArgs.e(7, 8, this.FEW);
      paramVarArgs.aR(8, this.Scene);
      if (this.EfU != null) {
        paramVarArgs.d(9, this.EfU);
      }
      paramVarArgs.aR(10, this.FCg);
      if (this.GeK != null) {
        paramVarArgs.d(11, this.GeK);
      }
      if (this.GeL != null) {
        paramVarArgs.d(12, this.GeL);
      }
      paramVarArgs.aR(13, this.GeM);
      paramVarArgs.e(14, 1, this.GeN);
      paramVarArgs.aR(15, this.Geu);
      if (this.BYp != null)
      {
        paramVarArgs.ln(16, this.BYp.computeSize());
        this.BYp.writeFields(paramVarArgs);
      }
      paramVarArgs.e(17, 8, this.Gdj);
      paramVarArgs.e(18, 8, this.GeO);
      if (this.pAD != null) {
        paramVarArgs.d(19, this.pAD);
      }
      if (this.GeP != null) {
        paramVarArgs.c(20, this.GeP);
      }
      if (this.Gev != null) {
        paramVarArgs.d(21, this.Gev);
      }
      if (this.GeQ != null) {
        paramVarArgs.c(22, this.GeQ);
      }
      if (this.GeR != null)
      {
        paramVarArgs.ln(23, this.GeR.computeSize());
        this.GeR.writeFields(paramVarArgs);
      }
      if (this.GeS != null)
      {
        paramVarArgs.ln(24, this.GeS.computeSize());
        this.GeS.writeFields(paramVarArgs);
      }
      if (this.GeT != null)
      {
        paramVarArgs.ln(25, this.GeT.computeSize());
        this.GeT.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(26, this.FrR);
      AppMethodBeat.o(117955);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.FCc) + 0;
      paramInt = i;
      if (this.EJp != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.EJp);
      }
      i = paramInt + f.a.a.b.b.a.bx(3, this.EfV) + f.a.a.b.b.a.p(4, this.EfR) + f.a.a.b.b.a.bx(5, this.GeJ);
      paramInt = i;
      if (this.FhT != null) {
        paramInt = i + f.a.a.a.lm(6, this.FhT.computeSize());
      }
      i = paramInt + f.a.a.a.c(7, 8, this.FEW) + f.a.a.b.b.a.bx(8, this.Scene);
      paramInt = i;
      if (this.EfU != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.EfU);
      }
      i = paramInt + f.a.a.b.b.a.bx(10, this.FCg);
      paramInt = i;
      if (this.GeK != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.GeK);
      }
      i = paramInt;
      if (this.GeL != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.GeL);
      }
      i = i + f.a.a.b.b.a.bx(13, this.GeM) + f.a.a.a.c(14, 1, this.GeN) + f.a.a.b.b.a.bx(15, this.Geu);
      paramInt = i;
      if (this.BYp != null) {
        paramInt = i + f.a.a.a.lm(16, this.BYp.computeSize());
      }
      i = paramInt + f.a.a.a.c(17, 8, this.Gdj) + f.a.a.a.c(18, 8, this.GeO);
      paramInt = i;
      if (this.pAD != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.pAD);
      }
      i = paramInt;
      if (this.GeP != null) {
        i = paramInt + f.a.a.b.b.a.b(20, this.GeP);
      }
      paramInt = i;
      if (this.Gev != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.Gev);
      }
      i = paramInt;
      if (this.GeQ != null) {
        i = paramInt + f.a.a.b.b.a.b(22, this.GeQ);
      }
      paramInt = i;
      if (this.GeR != null) {
        paramInt = i + f.a.a.a.lm(23, this.GeR.computeSize());
      }
      i = paramInt;
      if (this.GeS != null) {
        i = paramInt + f.a.a.a.lm(24, this.GeS.computeSize());
      }
      paramInt = i;
      if (this.GeT != null) {
        paramInt = i + f.a.a.a.lm(25, this.GeT.computeSize());
      }
      i = f.a.a.b.b.a.bx(26, this.FrR);
      AppMethodBeat.o(117955);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.FEW.clear();
      this.GeN.clear();
      this.Gdj.clear();
      this.GeO.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      if (this.EJp == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Keyword");
        AppMethodBeat.o(117955);
        throw paramVarArgs;
      }
      AppMethodBeat.o(117955);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dyp localdyp = (dyp)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(117955);
        return -1;
      case 1: 
        localdyp.FCc = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(117955);
        return 0;
      case 2: 
        localdyp.EJp = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(117955);
        return 0;
      case 3: 
        localdyp.EfV = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(117955);
        return 0;
      case 4: 
        localdyp.EfR = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(117955);
        return 0;
      case 5: 
        localdyp.GeJ = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(117955);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bpa();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bpa)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdyp.FhT = ((bpa)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117955);
        return 0;
      case 7: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new doh();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((doh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdyp.FEW.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117955);
        return 0;
      case 8: 
        localdyp.Scene = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(117955);
        return 0;
      case 9: 
        localdyp.EfU = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(117955);
        return 0;
      case 10: 
        localdyp.FCg = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(117955);
        return 0;
      case 11: 
        localdyp.GeK = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(117955);
        return 0;
      case 12: 
        localdyp.GeL = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(117955);
        return 0;
      case 13: 
        localdyp.GeM = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(117955);
        return 0;
      case 14: 
        localdyp.GeN.add(((f.a.a.a.a)localObject1).LVo.readString());
        AppMethodBeat.o(117955);
        return 0;
      case 15: 
        localdyp.Geu = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(117955);
        return 0;
      case 16: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dgk();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dgk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdyp.BYp = ((dgk)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117955);
        return 0;
      case 17: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new yh();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((yh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdyp.Gdj.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117955);
        return 0;
      case 18: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new byh();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((byh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdyp.GeO.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117955);
        return 0;
      case 19: 
        localdyp.pAD = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(117955);
        return 0;
      case 20: 
        localdyp.GeP = ((f.a.a.a.a)localObject1).LVo.gfk();
        AppMethodBeat.o(117955);
        return 0;
      case 21: 
        localdyp.Gev = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(117955);
        return 0;
      case 22: 
        localdyp.GeQ = ((f.a.a.a.a)localObject1).LVo.gfk();
        AppMethodBeat.o(117955);
        return 0;
      case 23: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dad();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dad)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdyp.GeR = ((dad)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117955);
        return 0;
      case 24: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aaj();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aaj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdyp.GeS = ((aaj)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117955);
        return 0;
      case 25: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cfw();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cfw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdyp.GeT = ((cfw)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117955);
        return 0;
      }
      localdyp.FrR = ((f.a.a.a.a)localObject1).LVo.xF();
      AppMethodBeat.o(117955);
      return 0;
    }
    AppMethodBeat.o(117955);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dyp
 * JD-Core Version:    0.7.0.1
 */