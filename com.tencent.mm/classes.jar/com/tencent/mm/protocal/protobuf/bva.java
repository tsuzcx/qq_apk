package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bva
  extends com.tencent.mm.bw.a
{
  public String DPS;
  public SKBuiltinBuffer_t DPX;
  public int DeleteFlag;
  public ua ENw;
  public String EUa;
  public String Eof;
  public String Eog;
  public crm EtY;
  public crm EtZ;
  public int Etk;
  public int Etl;
  public int Etq;
  public int Etr;
  public LinkedList<cqy> Ets;
  public int Etu;
  public int Etv;
  public crm EuE;
  public int EuF;
  public String EuG;
  public int ExtFlag;
  public crm Fbd;
  public int Feq;
  public String Fer;
  public String Fes;
  public String Fet;
  public int Feu;
  public dbt Few;
  public aaf Fex;
  public int FkA;
  public crm FkE;
  public int FkF;
  public int FkG;
  public String FkH;
  public String FkI;
  public String FkJ;
  public String FkK;
  public String FkL;
  public String FkM;
  public String FkN;
  public String FkO;
  public dg FkP;
  public int FkQ;
  public int FkR;
  public int FkS;
  public String FkT;
  public cfk FkU;
  public int FkV;
  public int FkW;
  public String FkX;
  public crm Fkk;
  public crm Fkl;
  public crm Fkm;
  public String eyk;
  public long eyr;
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
  public String iKd;
  public int sVo;
  public String tlX;
  
  public bva()
  {
    AppMethodBeat.i(43106);
    this.Ets = new LinkedList();
    AppMethodBeat.o(43106);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43107);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EuE == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(43107);
        throw paramVarArgs;
      }
      if (this.Fbd == null)
      {
        paramVarArgs = new b("Not all required fields were included: NickName");
        AppMethodBeat.o(43107);
        throw paramVarArgs;
      }
      if (this.EtY == null)
      {
        paramVarArgs = new b("Not all required fields were included: PYInitial");
        AppMethodBeat.o(43107);
        throw paramVarArgs;
      }
      if (this.EtZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: QuanPin");
        AppMethodBeat.o(43107);
        throw paramVarArgs;
      }
      if (this.DPX == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgBuf");
        AppMethodBeat.o(43107);
        throw paramVarArgs;
      }
      if (this.EuE != null)
      {
        paramVarArgs.ln(1, this.EuE.computeSize());
        this.EuE.writeFields(paramVarArgs);
      }
      if (this.Fbd != null)
      {
        paramVarArgs.ln(2, this.Fbd.computeSize());
        this.Fbd.writeFields(paramVarArgs);
      }
      if (this.EtY != null)
      {
        paramVarArgs.ln(3, this.EtY.computeSize());
        this.EtY.writeFields(paramVarArgs);
      }
      if (this.EtZ != null)
      {
        paramVarArgs.ln(4, this.EtZ.computeSize());
        this.EtZ.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(5, this.iJT);
      if (this.DPX != null)
      {
        paramVarArgs.ln(6, this.DPX.computeSize());
        this.DPX.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(7, this.Etk);
      paramVarArgs.aR(8, this.Etl);
      paramVarArgs.aR(9, this.FkA);
      if (this.Fkk != null)
      {
        paramVarArgs.ln(10, this.Fkk.computeSize());
        this.Fkk.writeFields(paramVarArgs);
      }
      if (this.Fkl != null)
      {
        paramVarArgs.ln(11, this.Fkl.computeSize());
        this.Fkl.writeFields(paramVarArgs);
      }
      if (this.Fkm != null)
      {
        paramVarArgs.ln(12, this.Fkm.computeSize());
        this.Fkm.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(13, this.Etq);
      paramVarArgs.aR(14, this.Etr);
      paramVarArgs.e(15, 8, this.Ets);
      if (this.FkE != null)
      {
        paramVarArgs.ln(16, this.FkE.computeSize());
        this.FkE.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(17, this.Etu);
      paramVarArgs.aR(18, this.Etv);
      if (this.iJU != null) {
        paramVarArgs.d(19, this.iJU);
      }
      if (this.iJV != null) {
        paramVarArgs.d(20, this.iJV);
      }
      if (this.iJW != null) {
        paramVarArgs.d(21, this.iJW);
      }
      paramVarArgs.aR(22, this.iJX);
      paramVarArgs.aR(23, this.FkF);
      paramVarArgs.aR(24, this.Feq);
      if (this.Fer != null) {
        paramVarArgs.d(25, this.Fer);
      }
      paramVarArgs.aR(26, this.FkG);
      paramVarArgs.aR(27, this.sVo);
      if (this.Fes != null) {
        paramVarArgs.d(28, this.Fes);
      }
      if (this.EUa != null) {
        paramVarArgs.d(29, this.EUa);
      }
      if (this.iJY != null) {
        paramVarArgs.d(30, this.iJY);
      }
      if (this.FkH != null) {
        paramVarArgs.d(31, this.FkH);
      }
      if (this.Fet != null) {
        paramVarArgs.d(32, this.Fet);
      }
      paramVarArgs.aR(33, this.Feu);
      paramVarArgs.aR(34, this.iKa);
      paramVarArgs.aR(35, this.iJZ);
      if (this.iKb != null) {
        paramVarArgs.d(36, this.iKb);
      }
      if (this.Few != null)
      {
        paramVarArgs.ln(37, this.Few.computeSize());
        this.Few.writeFields(paramVarArgs);
      }
      if (this.iKc != null) {
        paramVarArgs.d(38, this.iKc);
      }
      if (this.Eof != null) {
        paramVarArgs.d(39, this.Eof);
      }
      if (this.Eog != null) {
        paramVarArgs.d(40, this.Eog);
      }
      if (this.iKd != null) {
        paramVarArgs.d(41, this.iKd);
      }
      if (this.Fex != null)
      {
        paramVarArgs.ln(42, this.Fex.computeSize());
        this.Fex.writeFields(paramVarArgs);
      }
      if (this.FkI != null) {
        paramVarArgs.d(43, this.FkI);
      }
      if (this.FkJ != null) {
        paramVarArgs.d(44, this.FkJ);
      }
      if (this.FkK != null) {
        paramVarArgs.d(45, this.FkK);
      }
      if (this.FkL != null) {
        paramVarArgs.d(46, this.FkL);
      }
      if (this.FkM != null) {
        paramVarArgs.d(47, this.FkM);
      }
      if (this.FkN != null) {
        paramVarArgs.d(48, this.FkN);
      }
      if (this.FkO != null) {
        paramVarArgs.d(49, this.FkO);
      }
      if (this.FkP != null)
      {
        paramVarArgs.ln(50, this.FkP.computeSize());
        this.FkP.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(53, this.FkQ);
      if (this.tlX != null) {
        paramVarArgs.d(54, this.tlX);
      }
      paramVarArgs.aR(55, this.FkR);
      paramVarArgs.aR(56, this.FkS);
      if (this.ENw != null)
      {
        paramVarArgs.ln(57, this.ENw.computeSize());
        this.ENw.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(58, this.DeleteFlag);
      if (this.DPS != null) {
        paramVarArgs.d(59, this.DPS);
      }
      if (this.FkT != null) {
        paramVarArgs.d(60, this.FkT);
      }
      if (this.EuG != null) {
        paramVarArgs.d(61, this.EuG);
      }
      if (this.FkU != null)
      {
        paramVarArgs.ln(62, this.FkU.computeSize());
        this.FkU.writeFields(paramVarArgs);
      }
      if (this.eyk != null) {
        paramVarArgs.d(63, this.eyk);
      }
      paramVarArgs.aR(64, this.FkV);
      paramVarArgs.aR(65, this.EuF);
      paramVarArgs.aR(66, this.FkW);
      paramVarArgs.aR(67, this.ExtFlag);
      if (this.FkX != null) {
        paramVarArgs.d(68, this.FkX);
      }
      paramVarArgs.aO(70, this.eyr);
      AppMethodBeat.o(43107);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EuE == null) {
        break label5522;
      }
    }
    label5522:
    for (int i = f.a.a.a.lm(1, this.EuE.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Fbd != null) {
        paramInt = i + f.a.a.a.lm(2, this.Fbd.computeSize());
      }
      i = paramInt;
      if (this.EtY != null) {
        i = paramInt + f.a.a.a.lm(3, this.EtY.computeSize());
      }
      paramInt = i;
      if (this.EtZ != null) {
        paramInt = i + f.a.a.a.lm(4, this.EtZ.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bx(5, this.iJT);
      paramInt = i;
      if (this.DPX != null) {
        paramInt = i + f.a.a.a.lm(6, this.DPX.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bx(7, this.Etk) + f.a.a.b.b.a.bx(8, this.Etl) + f.a.a.b.b.a.bx(9, this.FkA);
      paramInt = i;
      if (this.Fkk != null) {
        paramInt = i + f.a.a.a.lm(10, this.Fkk.computeSize());
      }
      i = paramInt;
      if (this.Fkl != null) {
        i = paramInt + f.a.a.a.lm(11, this.Fkl.computeSize());
      }
      paramInt = i;
      if (this.Fkm != null) {
        paramInt = i + f.a.a.a.lm(12, this.Fkm.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bx(13, this.Etq) + f.a.a.b.b.a.bx(14, this.Etr) + f.a.a.a.c(15, 8, this.Ets);
      paramInt = i;
      if (this.FkE != null) {
        paramInt = i + f.a.a.a.lm(16, this.FkE.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bx(17, this.Etu) + f.a.a.b.b.a.bx(18, this.Etv);
      paramInt = i;
      if (this.iJU != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.iJU);
      }
      i = paramInt;
      if (this.iJV != null) {
        i = paramInt + f.a.a.b.b.a.e(20, this.iJV);
      }
      paramInt = i;
      if (this.iJW != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.iJW);
      }
      i = paramInt + f.a.a.b.b.a.bx(22, this.iJX) + f.a.a.b.b.a.bx(23, this.FkF) + f.a.a.b.b.a.bx(24, this.Feq);
      paramInt = i;
      if (this.Fer != null) {
        paramInt = i + f.a.a.b.b.a.e(25, this.Fer);
      }
      i = paramInt + f.a.a.b.b.a.bx(26, this.FkG) + f.a.a.b.b.a.bx(27, this.sVo);
      paramInt = i;
      if (this.Fes != null) {
        paramInt = i + f.a.a.b.b.a.e(28, this.Fes);
      }
      i = paramInt;
      if (this.EUa != null) {
        i = paramInt + f.a.a.b.b.a.e(29, this.EUa);
      }
      paramInt = i;
      if (this.iJY != null) {
        paramInt = i + f.a.a.b.b.a.e(30, this.iJY);
      }
      i = paramInt;
      if (this.FkH != null) {
        i = paramInt + f.a.a.b.b.a.e(31, this.FkH);
      }
      paramInt = i;
      if (this.Fet != null) {
        paramInt = i + f.a.a.b.b.a.e(32, this.Fet);
      }
      i = paramInt + f.a.a.b.b.a.bx(33, this.Feu) + f.a.a.b.b.a.bx(34, this.iKa) + f.a.a.b.b.a.bx(35, this.iJZ);
      paramInt = i;
      if (this.iKb != null) {
        paramInt = i + f.a.a.b.b.a.e(36, this.iKb);
      }
      i = paramInt;
      if (this.Few != null) {
        i = paramInt + f.a.a.a.lm(37, this.Few.computeSize());
      }
      paramInt = i;
      if (this.iKc != null) {
        paramInt = i + f.a.a.b.b.a.e(38, this.iKc);
      }
      i = paramInt;
      if (this.Eof != null) {
        i = paramInt + f.a.a.b.b.a.e(39, this.Eof);
      }
      paramInt = i;
      if (this.Eog != null) {
        paramInt = i + f.a.a.b.b.a.e(40, this.Eog);
      }
      i = paramInt;
      if (this.iKd != null) {
        i = paramInt + f.a.a.b.b.a.e(41, this.iKd);
      }
      paramInt = i;
      if (this.Fex != null) {
        paramInt = i + f.a.a.a.lm(42, this.Fex.computeSize());
      }
      i = paramInt;
      if (this.FkI != null) {
        i = paramInt + f.a.a.b.b.a.e(43, this.FkI);
      }
      paramInt = i;
      if (this.FkJ != null) {
        paramInt = i + f.a.a.b.b.a.e(44, this.FkJ);
      }
      i = paramInt;
      if (this.FkK != null) {
        i = paramInt + f.a.a.b.b.a.e(45, this.FkK);
      }
      paramInt = i;
      if (this.FkL != null) {
        paramInt = i + f.a.a.b.b.a.e(46, this.FkL);
      }
      i = paramInt;
      if (this.FkM != null) {
        i = paramInt + f.a.a.b.b.a.e(47, this.FkM);
      }
      paramInt = i;
      if (this.FkN != null) {
        paramInt = i + f.a.a.b.b.a.e(48, this.FkN);
      }
      i = paramInt;
      if (this.FkO != null) {
        i = paramInt + f.a.a.b.b.a.e(49, this.FkO);
      }
      paramInt = i;
      if (this.FkP != null) {
        paramInt = i + f.a.a.a.lm(50, this.FkP.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bx(53, this.FkQ);
      paramInt = i;
      if (this.tlX != null) {
        paramInt = i + f.a.a.b.b.a.e(54, this.tlX);
      }
      i = paramInt + f.a.a.b.b.a.bx(55, this.FkR) + f.a.a.b.b.a.bx(56, this.FkS);
      paramInt = i;
      if (this.ENw != null) {
        paramInt = i + f.a.a.a.lm(57, this.ENw.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bx(58, this.DeleteFlag);
      paramInt = i;
      if (this.DPS != null) {
        paramInt = i + f.a.a.b.b.a.e(59, this.DPS);
      }
      i = paramInt;
      if (this.FkT != null) {
        i = paramInt + f.a.a.b.b.a.e(60, this.FkT);
      }
      paramInt = i;
      if (this.EuG != null) {
        paramInt = i + f.a.a.b.b.a.e(61, this.EuG);
      }
      i = paramInt;
      if (this.FkU != null) {
        i = paramInt + f.a.a.a.lm(62, this.FkU.computeSize());
      }
      paramInt = i;
      if (this.eyk != null) {
        paramInt = i + f.a.a.b.b.a.e(63, this.eyk);
      }
      i = paramInt + f.a.a.b.b.a.bx(64, this.FkV) + f.a.a.b.b.a.bx(65, this.EuF) + f.a.a.b.b.a.bx(66, this.FkW) + f.a.a.b.b.a.bx(67, this.ExtFlag);
      paramInt = i;
      if (this.FkX != null) {
        paramInt = i + f.a.a.b.b.a.e(68, this.FkX);
      }
      i = f.a.a.b.b.a.p(70, this.eyr);
      AppMethodBeat.o(43107);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Ets.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.EuE == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserName");
          AppMethodBeat.o(43107);
          throw paramVarArgs;
        }
        if (this.Fbd == null)
        {
          paramVarArgs = new b("Not all required fields were included: NickName");
          AppMethodBeat.o(43107);
          throw paramVarArgs;
        }
        if (this.EtY == null)
        {
          paramVarArgs = new b("Not all required fields were included: PYInitial");
          AppMethodBeat.o(43107);
          throw paramVarArgs;
        }
        if (this.EtZ == null)
        {
          paramVarArgs = new b("Not all required fields were included: QuanPin");
          AppMethodBeat.o(43107);
          throw paramVarArgs;
        }
        if (this.DPX == null)
        {
          paramVarArgs = new b("Not all required fields were included: ImgBuf");
          AppMethodBeat.o(43107);
          throw paramVarArgs;
        }
        AppMethodBeat.o(43107);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bva localbva = (bva)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 51: 
        case 52: 
        case 69: 
        default: 
          AppMethodBeat.o(43107);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbva.EuE = ((crm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
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
            localbva.Fbd = ((crm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
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
            localbva.EtY = ((crm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbva.EtZ = ((crm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
          return 0;
        case 5: 
          localbva.iJT = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(43107);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbva.DPX = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
          return 0;
        case 7: 
          localbva.Etk = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(43107);
          return 0;
        case 8: 
          localbva.Etl = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(43107);
          return 0;
        case 9: 
          localbva.FkA = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(43107);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbva.Fkk = ((crm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbva.Fkl = ((crm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbva.Fkm = ((crm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
          return 0;
        case 13: 
          localbva.Etq = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(43107);
          return 0;
        case 14: 
          localbva.Etr = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(43107);
          return 0;
        case 15: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cqy();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cqy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbva.Ets.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
          return 0;
        case 16: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbva.FkE = ((crm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
          return 0;
        case 17: 
          localbva.Etu = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(43107);
          return 0;
        case 18: 
          localbva.Etv = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(43107);
          return 0;
        case 19: 
          localbva.iJU = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 20: 
          localbva.iJV = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 21: 
          localbva.iJW = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 22: 
          localbva.iJX = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(43107);
          return 0;
        case 23: 
          localbva.FkF = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(43107);
          return 0;
        case 24: 
          localbva.Feq = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(43107);
          return 0;
        case 25: 
          localbva.Fer = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 26: 
          localbva.FkG = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(43107);
          return 0;
        case 27: 
          localbva.sVo = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(43107);
          return 0;
        case 28: 
          localbva.Fes = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 29: 
          localbva.EUa = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 30: 
          localbva.iJY = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 31: 
          localbva.FkH = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 32: 
          localbva.Fet = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 33: 
          localbva.Feu = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(43107);
          return 0;
        case 34: 
          localbva.iKa = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(43107);
          return 0;
        case 35: 
          localbva.iJZ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(43107);
          return 0;
        case 36: 
          localbva.iKb = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 37: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dbt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dbt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbva.Few = ((dbt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
          return 0;
        case 38: 
          localbva.iKc = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 39: 
          localbva.Eof = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 40: 
          localbva.Eog = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 41: 
          localbva.iKd = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 42: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aaf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aaf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbva.Fex = ((aaf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
          return 0;
        case 43: 
          localbva.FkI = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 44: 
          localbva.FkJ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 45: 
          localbva.FkK = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 46: 
          localbva.FkL = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 47: 
          localbva.FkM = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 48: 
          localbva.FkN = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 49: 
          localbva.FkO = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 50: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbva.FkP = ((dg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
          return 0;
        case 53: 
          localbva.FkQ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(43107);
          return 0;
        case 54: 
          localbva.tlX = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 55: 
          localbva.FkR = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(43107);
          return 0;
        case 56: 
          localbva.FkS = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(43107);
          return 0;
        case 57: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ua();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ua)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbva.ENw = ((ua)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
          return 0;
        case 58: 
          localbva.DeleteFlag = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(43107);
          return 0;
        case 59: 
          localbva.DPS = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 60: 
          localbva.FkT = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 61: 
          localbva.EuG = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 62: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cfk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cfk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbva.FkU = ((cfk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
          return 0;
        case 63: 
          localbva.eyk = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 64: 
          localbva.FkV = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(43107);
          return 0;
        case 65: 
          localbva.EuF = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(43107);
          return 0;
        case 66: 
          localbva.FkW = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(43107);
          return 0;
        case 67: 
          localbva.ExtFlag = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(43107);
          return 0;
        case 68: 
          localbva.FkX = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(43107);
          return 0;
        }
        localbva.eyr = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(43107);
        return 0;
      }
      AppMethodBeat.o(43107);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bva
 * JD-Core Version:    0.7.0.1
 */