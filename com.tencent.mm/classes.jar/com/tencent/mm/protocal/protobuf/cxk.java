package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cxk
  extends com.tencent.mm.bw.a
{
  public int DPW;
  public String ELg;
  public String EUa;
  public String Eof;
  public String Eog;
  public int FGW;
  public SKBuiltinBuffer_t FGX;
  public int FGY;
  public String Fep;
  public int Feq;
  public String Fer;
  public String Fes;
  public String Fet;
  public int Feu;
  public int Fev;
  public dbt Few;
  public aaf Fex;
  public int iJT;
  public String iJU;
  public String iJV;
  public String iJW;
  public String iKc;
  public String iKd;
  public String ncR;
  public String ndW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32440);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FGX == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgBuffer");
        AppMethodBeat.o(32440);
        throw paramVarArgs;
      }
      if (this.ncR != null) {
        paramVarArgs.d(1, this.ncR);
      }
      if (this.ndW != null) {
        paramVarArgs.d(2, this.ndW);
      }
      if (this.iJU != null) {
        paramVarArgs.d(3, this.iJU);
      }
      if (this.iJV != null) {
        paramVarArgs.d(4, this.iJV);
      }
      if (this.iJW != null) {
        paramVarArgs.d(5, this.iJW);
      }
      if (this.Fep != null) {
        paramVarArgs.d(6, this.Fep);
      }
      paramVarArgs.aR(7, this.iJT);
      paramVarArgs.aR(8, this.DPW);
      paramVarArgs.aR(9, this.FGW);
      if (this.FGX != null)
      {
        paramVarArgs.ln(10, this.FGX.computeSize());
        this.FGX.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(11, this.FGY);
      if (this.Fes != null) {
        paramVarArgs.d(12, this.Fes);
      }
      if (this.Fet != null) {
        paramVarArgs.d(13, this.Fet);
      }
      paramVarArgs.aR(14, this.Feu);
      paramVarArgs.aR(15, this.Feq);
      if (this.Fer != null) {
        paramVarArgs.d(16, this.Fer);
      }
      if (this.EUa != null) {
        paramVarArgs.d(17, this.EUa);
      }
      paramVarArgs.aR(21, this.Fev);
      if (this.Few != null)
      {
        paramVarArgs.ln(22, this.Few.computeSize());
        this.Few.writeFields(paramVarArgs);
      }
      if (this.iKc != null) {
        paramVarArgs.d(23, this.iKc);
      }
      if (this.Eof != null) {
        paramVarArgs.d(24, this.Eof);
      }
      if (this.Eog != null) {
        paramVarArgs.d(25, this.Eog);
      }
      if (this.iKd != null) {
        paramVarArgs.d(26, this.iKd);
      }
      if (this.Fex != null)
      {
        paramVarArgs.ln(27, this.Fex.computeSize());
        this.Fex.writeFields(paramVarArgs);
      }
      if (this.ELg != null) {
        paramVarArgs.d(28, this.ELg);
      }
      AppMethodBeat.o(32440);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ncR == null) {
        break label1953;
      }
    }
    label1953:
    for (int i = f.a.a.b.b.a.e(1, this.ncR) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ndW != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ndW);
      }
      i = paramInt;
      if (this.iJU != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.iJU);
      }
      paramInt = i;
      if (this.iJV != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.iJV);
      }
      i = paramInt;
      if (this.iJW != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.iJW);
      }
      paramInt = i;
      if (this.Fep != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Fep);
      }
      i = paramInt + f.a.a.b.b.a.bx(7, this.iJT) + f.a.a.b.b.a.bx(8, this.DPW) + f.a.a.b.b.a.bx(9, this.FGW);
      paramInt = i;
      if (this.FGX != null) {
        paramInt = i + f.a.a.a.lm(10, this.FGX.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bx(11, this.FGY);
      paramInt = i;
      if (this.Fes != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.Fes);
      }
      i = paramInt;
      if (this.Fet != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.Fet);
      }
      i = i + f.a.a.b.b.a.bx(14, this.Feu) + f.a.a.b.b.a.bx(15, this.Feq);
      paramInt = i;
      if (this.Fer != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.Fer);
      }
      i = paramInt;
      if (this.EUa != null) {
        i = paramInt + f.a.a.b.b.a.e(17, this.EUa);
      }
      i += f.a.a.b.b.a.bx(21, this.Fev);
      paramInt = i;
      if (this.Few != null) {
        paramInt = i + f.a.a.a.lm(22, this.Few.computeSize());
      }
      i = paramInt;
      if (this.iKc != null) {
        i = paramInt + f.a.a.b.b.a.e(23, this.iKc);
      }
      paramInt = i;
      if (this.Eof != null) {
        paramInt = i + f.a.a.b.b.a.e(24, this.Eof);
      }
      i = paramInt;
      if (this.Eog != null) {
        i = paramInt + f.a.a.b.b.a.e(25, this.Eog);
      }
      paramInt = i;
      if (this.iKd != null) {
        paramInt = i + f.a.a.b.b.a.e(26, this.iKd);
      }
      i = paramInt;
      if (this.Fex != null) {
        i = paramInt + f.a.a.a.lm(27, this.Fex.computeSize());
      }
      paramInt = i;
      if (this.ELg != null) {
        paramInt = i + f.a.a.b.b.a.e(28, this.ELg);
      }
      AppMethodBeat.o(32440);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.FGX == null)
        {
          paramVarArgs = new b("Not all required fields were included: ImgBuffer");
          AppMethodBeat.o(32440);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32440);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cxk localcxk = (cxk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 18: 
        case 19: 
        case 20: 
        default: 
          AppMethodBeat.o(32440);
          return -1;
        case 1: 
          localcxk.ncR = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 2: 
          localcxk.ndW = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 3: 
          localcxk.iJU = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 4: 
          localcxk.iJV = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 5: 
          localcxk.iJW = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 6: 
          localcxk.Fep = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 7: 
          localcxk.iJT = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32440);
          return 0;
        case 8: 
          localcxk.DPW = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32440);
          return 0;
        case 9: 
          localcxk.FGW = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32440);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcxk.FGX = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32440);
          return 0;
        case 11: 
          localcxk.FGY = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32440);
          return 0;
        case 12: 
          localcxk.Fes = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 13: 
          localcxk.Fet = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 14: 
          localcxk.Feu = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32440);
          return 0;
        case 15: 
          localcxk.Feq = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32440);
          return 0;
        case 16: 
          localcxk.Fer = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 17: 
          localcxk.EUa = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 21: 
          localcxk.Fev = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32440);
          return 0;
        case 22: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dbt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dbt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcxk.Few = ((dbt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32440);
          return 0;
        case 23: 
          localcxk.iKc = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 24: 
          localcxk.Eof = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 25: 
          localcxk.Eog = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 26: 
          localcxk.iKd = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 27: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aaf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aaf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcxk.Fex = ((aaf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32440);
          return 0;
        }
        localcxk.ELg = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(32440);
        return 0;
      }
      AppMethodBeat.o(32440);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cxk
 * JD-Core Version:    0.7.0.1
 */