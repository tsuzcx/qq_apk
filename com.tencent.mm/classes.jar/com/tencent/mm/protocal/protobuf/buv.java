package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class buv
  extends com.tencent.mm.bw.a
{
  public SKBuiltinBuffer_t DPX;
  public String EUa;
  public String Eof;
  public String Eog;
  public crm EtY;
  public crm EtZ;
  public int Etq;
  public crm EuE;
  public crm Fbd;
  public int Feq;
  public String Fer;
  public String Fes;
  public String Fet;
  public int Feu;
  public dbt Few;
  public aaf Fex;
  public int FkA;
  public crm Fkk;
  public crm Fkl;
  public crm Fkm;
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
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101824);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EuE == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(101824);
        throw paramVarArgs;
      }
      if (this.Fbd == null)
      {
        paramVarArgs = new b("Not all required fields were included: NickName");
        AppMethodBeat.o(101824);
        throw paramVarArgs;
      }
      if (this.EtY == null)
      {
        paramVarArgs = new b("Not all required fields were included: PYInitial");
        AppMethodBeat.o(101824);
        throw paramVarArgs;
      }
      if (this.EtZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: QuanPin");
        AppMethodBeat.o(101824);
        throw paramVarArgs;
      }
      if (this.DPX == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgBuf");
        AppMethodBeat.o(101824);
        throw paramVarArgs;
      }
      if (this.Fkk == null)
      {
        paramVarArgs = new b("Not all required fields were included: Remark");
        AppMethodBeat.o(101824);
        throw paramVarArgs;
      }
      if (this.Fkl == null)
      {
        paramVarArgs = new b("Not all required fields were included: RemarkPYInitial");
        AppMethodBeat.o(101824);
        throw paramVarArgs;
      }
      if (this.Fkm == null)
      {
        paramVarArgs = new b("Not all required fields were included: RemarkQuanPin");
        AppMethodBeat.o(101824);
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
      paramVarArgs.aR(7, this.FkA);
      if (this.Fkk != null)
      {
        paramVarArgs.ln(8, this.Fkk.computeSize());
        this.Fkk.writeFields(paramVarArgs);
      }
      if (this.Fkl != null)
      {
        paramVarArgs.ln(9, this.Fkl.computeSize());
        this.Fkl.writeFields(paramVarArgs);
      }
      if (this.Fkm != null)
      {
        paramVarArgs.ln(10, this.Fkm.computeSize());
        this.Fkm.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(11, this.Etq);
      if (this.iJU != null) {
        paramVarArgs.d(12, this.iJU);
      }
      if (this.iJV != null) {
        paramVarArgs.d(13, this.iJV);
      }
      if (this.iJW != null) {
        paramVarArgs.d(14, this.iJW);
      }
      paramVarArgs.aR(15, this.iJX);
      paramVarArgs.aR(16, this.Feq);
      if (this.Fer != null) {
        paramVarArgs.d(17, this.Fer);
      }
      if (this.Fes != null) {
        paramVarArgs.d(18, this.Fes);
      }
      if (this.EUa != null) {
        paramVarArgs.d(19, this.EUa);
      }
      if (this.Fet != null) {
        paramVarArgs.d(20, this.Fet);
      }
      paramVarArgs.aR(21, this.Feu);
      paramVarArgs.aR(22, this.iKa);
      paramVarArgs.aR(23, this.iJZ);
      if (this.iKb != null) {
        paramVarArgs.d(24, this.iKb);
      }
      if (this.iJY != null) {
        paramVarArgs.d(25, this.iJY);
      }
      if (this.Few != null)
      {
        paramVarArgs.ln(26, this.Few.computeSize());
        this.Few.writeFields(paramVarArgs);
      }
      if (this.iKc != null) {
        paramVarArgs.d(27, this.iKc);
      }
      if (this.Eof != null) {
        paramVarArgs.d(28, this.Eof);
      }
      if (this.Eog != null) {
        paramVarArgs.d(29, this.Eog);
      }
      if (this.iKd != null) {
        paramVarArgs.d(30, this.iKd);
      }
      if (this.Fex != null)
      {
        paramVarArgs.ln(31, this.Fex.computeSize());
        this.Fex.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(101824);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EuE == null) {
        break label3258;
      }
    }
    label3258:
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
      i = paramInt + f.a.a.b.b.a.bx(7, this.FkA);
      paramInt = i;
      if (this.Fkk != null) {
        paramInt = i + f.a.a.a.lm(8, this.Fkk.computeSize());
      }
      i = paramInt;
      if (this.Fkl != null) {
        i = paramInt + f.a.a.a.lm(9, this.Fkl.computeSize());
      }
      paramInt = i;
      if (this.Fkm != null) {
        paramInt = i + f.a.a.a.lm(10, this.Fkm.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bx(11, this.Etq);
      paramInt = i;
      if (this.iJU != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.iJU);
      }
      i = paramInt;
      if (this.iJV != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.iJV);
      }
      paramInt = i;
      if (this.iJW != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.iJW);
      }
      i = paramInt + f.a.a.b.b.a.bx(15, this.iJX) + f.a.a.b.b.a.bx(16, this.Feq);
      paramInt = i;
      if (this.Fer != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.Fer);
      }
      i = paramInt;
      if (this.Fes != null) {
        i = paramInt + f.a.a.b.b.a.e(18, this.Fes);
      }
      paramInt = i;
      if (this.EUa != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.EUa);
      }
      i = paramInt;
      if (this.Fet != null) {
        i = paramInt + f.a.a.b.b.a.e(20, this.Fet);
      }
      i = i + f.a.a.b.b.a.bx(21, this.Feu) + f.a.a.b.b.a.bx(22, this.iKa) + f.a.a.b.b.a.bx(23, this.iJZ);
      paramInt = i;
      if (this.iKb != null) {
        paramInt = i + f.a.a.b.b.a.e(24, this.iKb);
      }
      i = paramInt;
      if (this.iJY != null) {
        i = paramInt + f.a.a.b.b.a.e(25, this.iJY);
      }
      paramInt = i;
      if (this.Few != null) {
        paramInt = i + f.a.a.a.lm(26, this.Few.computeSize());
      }
      i = paramInt;
      if (this.iKc != null) {
        i = paramInt + f.a.a.b.b.a.e(27, this.iKc);
      }
      paramInt = i;
      if (this.Eof != null) {
        paramInt = i + f.a.a.b.b.a.e(28, this.Eof);
      }
      i = paramInt;
      if (this.Eog != null) {
        i = paramInt + f.a.a.b.b.a.e(29, this.Eog);
      }
      paramInt = i;
      if (this.iKd != null) {
        paramInt = i + f.a.a.b.b.a.e(30, this.iKd);
      }
      i = paramInt;
      if (this.Fex != null) {
        i = paramInt + f.a.a.a.lm(31, this.Fex.computeSize());
      }
      AppMethodBeat.o(101824);
      return i;
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
          paramVarArgs = new b("Not all required fields were included: UserName");
          AppMethodBeat.o(101824);
          throw paramVarArgs;
        }
        if (this.Fbd == null)
        {
          paramVarArgs = new b("Not all required fields were included: NickName");
          AppMethodBeat.o(101824);
          throw paramVarArgs;
        }
        if (this.EtY == null)
        {
          paramVarArgs = new b("Not all required fields were included: PYInitial");
          AppMethodBeat.o(101824);
          throw paramVarArgs;
        }
        if (this.EtZ == null)
        {
          paramVarArgs = new b("Not all required fields were included: QuanPin");
          AppMethodBeat.o(101824);
          throw paramVarArgs;
        }
        if (this.DPX == null)
        {
          paramVarArgs = new b("Not all required fields were included: ImgBuf");
          AppMethodBeat.o(101824);
          throw paramVarArgs;
        }
        if (this.Fkk == null)
        {
          paramVarArgs = new b("Not all required fields were included: Remark");
          AppMethodBeat.o(101824);
          throw paramVarArgs;
        }
        if (this.Fkl == null)
        {
          paramVarArgs = new b("Not all required fields were included: RemarkPYInitial");
          AppMethodBeat.o(101824);
          throw paramVarArgs;
        }
        if (this.Fkm == null)
        {
          paramVarArgs = new b("Not all required fields were included: RemarkQuanPin");
          AppMethodBeat.o(101824);
          throw paramVarArgs;
        }
        AppMethodBeat.o(101824);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        buv localbuv = (buv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(101824);
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
            localbuv.EuE = ((crm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101824);
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
            localbuv.Fbd = ((crm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101824);
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
            localbuv.EtY = ((crm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101824);
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
            localbuv.EtZ = ((crm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101824);
          return 0;
        case 5: 
          localbuv.iJT = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(101824);
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
            localbuv.DPX = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101824);
          return 0;
        case 7: 
          localbuv.FkA = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(101824);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbuv.Fkk = ((crm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101824);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbuv.Fkl = ((crm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101824);
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
            localbuv.Fkm = ((crm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101824);
          return 0;
        case 11: 
          localbuv.Etq = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(101824);
          return 0;
        case 12: 
          localbuv.iJU = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(101824);
          return 0;
        case 13: 
          localbuv.iJV = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(101824);
          return 0;
        case 14: 
          localbuv.iJW = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(101824);
          return 0;
        case 15: 
          localbuv.iJX = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(101824);
          return 0;
        case 16: 
          localbuv.Feq = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(101824);
          return 0;
        case 17: 
          localbuv.Fer = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(101824);
          return 0;
        case 18: 
          localbuv.Fes = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(101824);
          return 0;
        case 19: 
          localbuv.EUa = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(101824);
          return 0;
        case 20: 
          localbuv.Fet = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(101824);
          return 0;
        case 21: 
          localbuv.Feu = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(101824);
          return 0;
        case 22: 
          localbuv.iKa = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(101824);
          return 0;
        case 23: 
          localbuv.iJZ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(101824);
          return 0;
        case 24: 
          localbuv.iKb = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(101824);
          return 0;
        case 25: 
          localbuv.iJY = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(101824);
          return 0;
        case 26: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dbt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dbt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbuv.Few = ((dbt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101824);
          return 0;
        case 27: 
          localbuv.iKc = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(101824);
          return 0;
        case 28: 
          localbuv.Eof = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(101824);
          return 0;
        case 29: 
          localbuv.Eog = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(101824);
          return 0;
        case 30: 
          localbuv.iKd = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(101824);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aaf();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aaf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbuv.Fex = ((aaf)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(101824);
        return 0;
      }
      AppMethodBeat.o(101824);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.buv
 * JD-Core Version:    0.7.0.1
 */