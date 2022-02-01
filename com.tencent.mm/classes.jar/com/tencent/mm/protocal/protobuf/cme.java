package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cme
  extends dop
{
  public int KCx;
  public String KFu;
  public jk KLK;
  public String KLL;
  public int KLM;
  public String KLN;
  public String KLO;
  public SKBuiltinBuffer_t KLP;
  public SKBuiltinBuffer_t KLQ;
  public String KLR;
  public dfx KLS;
  public String Lsj;
  public String Mrw;
  public String Mrx;
  public String Mry;
  public int Mrz;
  public String hid;
  public String hie;
  public int hil;
  public String keb;
  public String oTI;
  public String rBH;
  public String rBI;
  public String yiZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133176);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.KLK != null)
      {
        paramVarArgs.ni(2, this.KLK.computeSize());
        this.KLK.writeFields(paramVarArgs);
      }
      if (this.yiZ != null) {
        paramVarArgs.e(3, this.yiZ);
      }
      if (this.KLL != null) {
        paramVarArgs.e(4, this.KLL);
      }
      paramVarArgs.aM(5, this.KLM);
      if (this.KLN != null) {
        paramVarArgs.e(6, this.KLN);
      }
      if (this.keb != null) {
        paramVarArgs.e(7, this.keb);
      }
      if (this.oTI != null) {
        paramVarArgs.e(8, this.oTI);
      }
      if (this.KLO != null) {
        paramVarArgs.e(9, this.KLO);
      }
      if (this.rBI != null) {
        paramVarArgs.e(10, this.rBI);
      }
      if (this.rBH != null) {
        paramVarArgs.e(11, this.rBH);
      }
      paramVarArgs.aM(13, this.KCx);
      paramVarArgs.aM(14, this.hil);
      if (this.hie != null) {
        paramVarArgs.e(15, this.hie);
      }
      if (this.hid != null) {
        paramVarArgs.e(16, this.hid);
      }
      if (this.Mrw != null) {
        paramVarArgs.e(17, this.Mrw);
      }
      if (this.Lsj != null) {
        paramVarArgs.e(18, this.Lsj);
      }
      if (this.KLR != null) {
        paramVarArgs.e(19, this.KLR);
      }
      if (this.Mrx != null) {
        paramVarArgs.e(20, this.Mrx);
      }
      if (this.Mry != null) {
        paramVarArgs.e(21, this.Mry);
      }
      paramVarArgs.aM(22, this.Mrz);
      if (this.KLP != null)
      {
        paramVarArgs.ni(23, this.KLP.computeSize());
        this.KLP.writeFields(paramVarArgs);
      }
      if (this.KLQ != null)
      {
        paramVarArgs.ni(24, this.KLQ.computeSize());
        this.KLQ.writeFields(paramVarArgs);
      }
      if (this.KFu != null) {
        paramVarArgs.e(25, this.KFu);
      }
      if (this.KLS != null)
      {
        paramVarArgs.ni(26, this.KLS.computeSize());
        this.KLS.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133176);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label2106;
      }
    }
    label2106:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.KLK != null) {
        paramInt = i + g.a.a.a.nh(2, this.KLK.computeSize());
      }
      i = paramInt;
      if (this.yiZ != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.yiZ);
      }
      paramInt = i;
      if (this.KLL != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.KLL);
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.KLM);
      paramInt = i;
      if (this.KLN != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.KLN);
      }
      i = paramInt;
      if (this.keb != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.keb);
      }
      paramInt = i;
      if (this.oTI != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.oTI);
      }
      i = paramInt;
      if (this.KLO != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.KLO);
      }
      paramInt = i;
      if (this.rBI != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.rBI);
      }
      i = paramInt;
      if (this.rBH != null) {
        i = paramInt + g.a.a.b.b.a.f(11, this.rBH);
      }
      i = i + g.a.a.b.b.a.bu(13, this.KCx) + g.a.a.b.b.a.bu(14, this.hil);
      paramInt = i;
      if (this.hie != null) {
        paramInt = i + g.a.a.b.b.a.f(15, this.hie);
      }
      i = paramInt;
      if (this.hid != null) {
        i = paramInt + g.a.a.b.b.a.f(16, this.hid);
      }
      paramInt = i;
      if (this.Mrw != null) {
        paramInt = i + g.a.a.b.b.a.f(17, this.Mrw);
      }
      i = paramInt;
      if (this.Lsj != null) {
        i = paramInt + g.a.a.b.b.a.f(18, this.Lsj);
      }
      paramInt = i;
      if (this.KLR != null) {
        paramInt = i + g.a.a.b.b.a.f(19, this.KLR);
      }
      i = paramInt;
      if (this.Mrx != null) {
        i = paramInt + g.a.a.b.b.a.f(20, this.Mrx);
      }
      paramInt = i;
      if (this.Mry != null) {
        paramInt = i + g.a.a.b.b.a.f(21, this.Mry);
      }
      i = paramInt + g.a.a.b.b.a.bu(22, this.Mrz);
      paramInt = i;
      if (this.KLP != null) {
        paramInt = i + g.a.a.a.nh(23, this.KLP.computeSize());
      }
      i = paramInt;
      if (this.KLQ != null) {
        i = paramInt + g.a.a.a.nh(24, this.KLQ.computeSize());
      }
      paramInt = i;
      if (this.KFu != null) {
        paramInt = i + g.a.a.b.b.a.f(25, this.KFu);
      }
      i = paramInt;
      if (this.KLS != null) {
        i = paramInt + g.a.a.a.nh(26, this.KLS.computeSize());
      }
      AppMethodBeat.o(133176);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(133176);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cme localcme = (cme)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 12: 
        default: 
          AppMethodBeat.o(133176);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcme.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133176);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jk();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jk)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcme.KLK = ((jk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133176);
          return 0;
        case 3: 
          localcme.yiZ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 4: 
          localcme.KLL = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 5: 
          localcme.KLM = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(133176);
          return 0;
        case 6: 
          localcme.KLN = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 7: 
          localcme.keb = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 8: 
          localcme.oTI = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 9: 
          localcme.KLO = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 10: 
          localcme.rBI = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 11: 
          localcme.rBH = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 13: 
          localcme.KCx = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(133176);
          return 0;
        case 14: 
          localcme.hil = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(133176);
          return 0;
        case 15: 
          localcme.hie = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 16: 
          localcme.hid = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 17: 
          localcme.Mrw = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 18: 
          localcme.Lsj = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 19: 
          localcme.KLR = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 20: 
          localcme.Mrx = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 21: 
          localcme.Mry = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 22: 
          localcme.Mrz = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(133176);
          return 0;
        case 23: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcme.KLP = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133176);
          return 0;
        case 24: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcme.KLQ = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133176);
          return 0;
        case 25: 
          localcme.KFu = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(133176);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dfx();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dfx)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localcme.KLS = ((dfx)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133176);
        return 0;
      }
      AppMethodBeat.o(133176);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cme
 * JD-Core Version:    0.7.0.1
 */