package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class csq
  extends com.tencent.mm.bw.a
{
  public SKBuiltinBuffer_t DPX;
  public String ELg;
  public String Eof;
  public String Eog;
  public crm EtY;
  public crm EtZ;
  public crm EuE;
  public int FEO;
  public crm Fbd;
  public int Feq;
  public String Fer;
  public String Fes;
  public String Fet;
  public int Feu;
  public dbt Few;
  public aaf Fex;
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
    AppMethodBeat.i(152681);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EuE == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(152681);
        throw paramVarArgs;
      }
      if (this.Fbd == null)
      {
        paramVarArgs = new b("Not all required fields were included: NickName");
        AppMethodBeat.o(152681);
        throw paramVarArgs;
      }
      if (this.EtY == null)
      {
        paramVarArgs = new b("Not all required fields were included: PYInitial");
        AppMethodBeat.o(152681);
        throw paramVarArgs;
      }
      if (this.EtZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: QuanPin");
        AppMethodBeat.o(152681);
        throw paramVarArgs;
      }
      if (this.DPX == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgBuf");
        AppMethodBeat.o(152681);
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
      if (this.iJU != null) {
        paramVarArgs.d(7, this.iJU);
      }
      if (this.iJV != null) {
        paramVarArgs.d(8, this.iJV);
      }
      if (this.iJW != null) {
        paramVarArgs.d(9, this.iJW);
      }
      paramVarArgs.aR(10, this.iJX);
      paramVarArgs.aR(11, this.Feq);
      if (this.Fer != null) {
        paramVarArgs.d(12, this.Fer);
      }
      if (this.Fes != null) {
        paramVarArgs.d(13, this.Fes);
      }
      if (this.iJY != null) {
        paramVarArgs.d(14, this.iJY);
      }
      if (this.Fet != null) {
        paramVarArgs.d(15, this.Fet);
      }
      paramVarArgs.aR(16, this.Feu);
      paramVarArgs.aR(17, this.iKa);
      paramVarArgs.aR(18, this.iJZ);
      if (this.iKb != null) {
        paramVarArgs.d(19, this.iKb);
      }
      if (this.Few != null)
      {
        paramVarArgs.ln(20, this.Few.computeSize());
        this.Few.writeFields(paramVarArgs);
      }
      if (this.iKc != null) {
        paramVarArgs.d(21, this.iKc);
      }
      if (this.iKd != null) {
        paramVarArgs.d(22, this.iKd);
      }
      if (this.Fex != null)
      {
        paramVarArgs.ln(23, this.Fex.computeSize());
        this.Fex.writeFields(paramVarArgs);
      }
      if (this.Eof != null) {
        paramVarArgs.d(24, this.Eof);
      }
      if (this.Eog != null) {
        paramVarArgs.d(25, this.Eog);
      }
      if (this.ELg != null) {
        paramVarArgs.d(26, this.ELg);
      }
      paramVarArgs.aR(27, this.FEO);
      AppMethodBeat.o(152681);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EuE == null) {
        break label2602;
      }
    }
    label2602:
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
      i = paramInt;
      if (this.iJU != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.iJU);
      }
      paramInt = i;
      if (this.iJV != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.iJV);
      }
      i = paramInt;
      if (this.iJW != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.iJW);
      }
      i = i + f.a.a.b.b.a.bx(10, this.iJX) + f.a.a.b.b.a.bx(11, this.Feq);
      paramInt = i;
      if (this.Fer != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.Fer);
      }
      i = paramInt;
      if (this.Fes != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.Fes);
      }
      paramInt = i;
      if (this.iJY != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.iJY);
      }
      i = paramInt;
      if (this.Fet != null) {
        i = paramInt + f.a.a.b.b.a.e(15, this.Fet);
      }
      i = i + f.a.a.b.b.a.bx(16, this.Feu) + f.a.a.b.b.a.bx(17, this.iKa) + f.a.a.b.b.a.bx(18, this.iJZ);
      paramInt = i;
      if (this.iKb != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.iKb);
      }
      i = paramInt;
      if (this.Few != null) {
        i = paramInt + f.a.a.a.lm(20, this.Few.computeSize());
      }
      paramInt = i;
      if (this.iKc != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.iKc);
      }
      i = paramInt;
      if (this.iKd != null) {
        i = paramInt + f.a.a.b.b.a.e(22, this.iKd);
      }
      paramInt = i;
      if (this.Fex != null) {
        paramInt = i + f.a.a.a.lm(23, this.Fex.computeSize());
      }
      i = paramInt;
      if (this.Eof != null) {
        i = paramInt + f.a.a.b.b.a.e(24, this.Eof);
      }
      paramInt = i;
      if (this.Eog != null) {
        paramInt = i + f.a.a.b.b.a.e(25, this.Eog);
      }
      i = paramInt;
      if (this.ELg != null) {
        i = paramInt + f.a.a.b.b.a.e(26, this.ELg);
      }
      paramInt = f.a.a.b.b.a.bx(27, this.FEO);
      AppMethodBeat.o(152681);
      return i + paramInt;
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
          AppMethodBeat.o(152681);
          throw paramVarArgs;
        }
        if (this.Fbd == null)
        {
          paramVarArgs = new b("Not all required fields were included: NickName");
          AppMethodBeat.o(152681);
          throw paramVarArgs;
        }
        if (this.EtY == null)
        {
          paramVarArgs = new b("Not all required fields were included: PYInitial");
          AppMethodBeat.o(152681);
          throw paramVarArgs;
        }
        if (this.EtZ == null)
        {
          paramVarArgs = new b("Not all required fields were included: QuanPin");
          AppMethodBeat.o(152681);
          throw paramVarArgs;
        }
        if (this.DPX == null)
        {
          paramVarArgs = new b("Not all required fields were included: ImgBuf");
          AppMethodBeat.o(152681);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152681);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        csq localcsq = (csq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152681);
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
            localcsq.EuE = ((crm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152681);
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
            localcsq.Fbd = ((crm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152681);
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
            localcsq.EtY = ((crm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152681);
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
            localcsq.EtZ = ((crm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152681);
          return 0;
        case 5: 
          localcsq.iJT = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152681);
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
            localcsq.DPX = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152681);
          return 0;
        case 7: 
          localcsq.iJU = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152681);
          return 0;
        case 8: 
          localcsq.iJV = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152681);
          return 0;
        case 9: 
          localcsq.iJW = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152681);
          return 0;
        case 10: 
          localcsq.iJX = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152681);
          return 0;
        case 11: 
          localcsq.Feq = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152681);
          return 0;
        case 12: 
          localcsq.Fer = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152681);
          return 0;
        case 13: 
          localcsq.Fes = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152681);
          return 0;
        case 14: 
          localcsq.iJY = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152681);
          return 0;
        case 15: 
          localcsq.Fet = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152681);
          return 0;
        case 16: 
          localcsq.Feu = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152681);
          return 0;
        case 17: 
          localcsq.iKa = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152681);
          return 0;
        case 18: 
          localcsq.iJZ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152681);
          return 0;
        case 19: 
          localcsq.iKb = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152681);
          return 0;
        case 20: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dbt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dbt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcsq.Few = ((dbt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152681);
          return 0;
        case 21: 
          localcsq.iKc = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152681);
          return 0;
        case 22: 
          localcsq.iKd = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152681);
          return 0;
        case 23: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aaf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aaf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcsq.Fex = ((aaf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152681);
          return 0;
        case 24: 
          localcsq.Eof = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152681);
          return 0;
        case 25: 
          localcsq.Eog = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152681);
          return 0;
        case 26: 
          localcsq.ELg = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152681);
          return 0;
        }
        localcsq.FEO = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(152681);
        return 0;
      }
      AppMethodBeat.o(152681);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.csq
 * JD-Core Version:    0.7.0.1
 */