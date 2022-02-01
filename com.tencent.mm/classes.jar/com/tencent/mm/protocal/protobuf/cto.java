package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cto
  extends dop
{
  public String Bri;
  public int KDZ;
  public String KEa;
  public String KEb;
  public String KFu;
  public int KLM;
  public String KLN;
  public SKBuiltinBuffer_t KLP;
  public SKBuiltinBuffer_t KLQ;
  public String KLR;
  public dfx KLS;
  public aif KLY;
  public int KPT;
  public SKBuiltinBuffer_t KPW;
  public int KPZ;
  public String KQa;
  public String KQf;
  public String KQi;
  public String Lsj;
  public int LtW;
  public int LtX;
  public String LtY;
  public String LuU;
  public String MbJ;
  public String MbK;
  public String Mrx;
  public int MyA;
  public String MyB;
  public String MyC;
  public String MyD;
  public String MyE;
  public String MyF;
  public String MyG;
  public int MyH;
  public String MyI;
  public String MyJ;
  public int Myz;
  public String UserName;
  public String ked;
  public String oUJ;
  public String rBH;
  public String rBI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133184);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.UserName != null) {
        paramVarArgs.e(2, this.UserName);
      }
      if (this.KQi != null) {
        paramVarArgs.e(3, this.KQi);
      }
      if (this.oUJ != null) {
        paramVarArgs.e(4, this.oUJ);
      }
      paramVarArgs.aM(5, this.KDZ);
      if (this.KEa != null) {
        paramVarArgs.e(6, this.KEa);
      }
      if (this.KEb != null) {
        paramVarArgs.e(7, this.KEb);
      }
      if (this.Bri != null) {
        paramVarArgs.e(8, this.Bri);
      }
      paramVarArgs.aM(12, this.KLM);
      paramVarArgs.aM(13, this.Myz);
      paramVarArgs.aM(14, this.LtW);
      if (this.rBH != null) {
        paramVarArgs.e(15, this.rBH);
      }
      if (this.rBI != null) {
        paramVarArgs.e(16, this.rBI);
      }
      paramVarArgs.aM(17, this.KPT);
      if (this.Lsj != null) {
        paramVarArgs.e(18, this.Lsj);
      }
      if (this.KPW != null)
      {
        paramVarArgs.ni(19, this.KPW.computeSize());
        this.KPW.writeFields(paramVarArgs);
      }
      if (this.ked != null) {
        paramVarArgs.e(20, this.ked);
      }
      if (this.MbJ != null) {
        paramVarArgs.e(21, this.MbJ);
      }
      if (this.MbK != null) {
        paramVarArgs.e(22, this.MbK);
      }
      paramVarArgs.aM(23, this.LtX);
      paramVarArgs.aM(24, this.MyA);
      if (this.KLN != null) {
        paramVarArgs.e(31, this.KLN);
      }
      if (this.Mrx != null) {
        paramVarArgs.e(32, this.Mrx);
      }
      if (this.MyB != null) {
        paramVarArgs.e(33, this.MyB);
      }
      if (this.LuU != null) {
        paramVarArgs.e(34, this.LuU);
      }
      if (this.MyC != null) {
        paramVarArgs.e(35, this.MyC);
      }
      if (this.MyD != null) {
        paramVarArgs.e(36, this.MyD);
      }
      if (this.KLY != null)
      {
        paramVarArgs.ni(37, this.KLY.computeSize());
        this.KLY.writeFields(paramVarArgs);
      }
      if (this.MyE != null) {
        paramVarArgs.e(38, this.MyE);
      }
      if (this.KLR != null) {
        paramVarArgs.e(39, this.KLR);
      }
      if (this.MyF != null) {
        paramVarArgs.e(40, this.MyF);
      }
      if (this.MyG != null) {
        paramVarArgs.e(41, this.MyG);
      }
      paramVarArgs.aM(42, this.MyH);
      if (this.KLP != null)
      {
        paramVarArgs.ni(43, this.KLP.computeSize());
        this.KLP.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(44, this.KPZ);
      if (this.KQa != null) {
        paramVarArgs.e(45, this.KQa);
      }
      if (this.LtY != null) {
        paramVarArgs.e(46, this.LtY);
      }
      if (this.MyI != null) {
        paramVarArgs.e(47, this.MyI);
      }
      if (this.KLQ != null)
      {
        paramVarArgs.ni(48, this.KLQ.computeSize());
        this.KLQ.writeFields(paramVarArgs);
      }
      if (this.MyJ != null) {
        paramVarArgs.e(49, this.MyJ);
      }
      if (this.KFu != null) {
        paramVarArgs.e(50, this.KFu);
      }
      if (this.KQf != null) {
        paramVarArgs.e(51, this.KQf);
      }
      if (this.KLS != null)
      {
        paramVarArgs.ni(52, this.KLS.computeSize());
        this.KLS.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133184);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label3262;
      }
    }
    label3262:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.UserName != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.UserName);
      }
      i = paramInt;
      if (this.KQi != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.KQi);
      }
      paramInt = i;
      if (this.oUJ != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.oUJ);
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.KDZ);
      paramInt = i;
      if (this.KEa != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.KEa);
      }
      i = paramInt;
      if (this.KEb != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.KEb);
      }
      paramInt = i;
      if (this.Bri != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.Bri);
      }
      i = paramInt + g.a.a.b.b.a.bu(12, this.KLM) + g.a.a.b.b.a.bu(13, this.Myz) + g.a.a.b.b.a.bu(14, this.LtW);
      paramInt = i;
      if (this.rBH != null) {
        paramInt = i + g.a.a.b.b.a.f(15, this.rBH);
      }
      i = paramInt;
      if (this.rBI != null) {
        i = paramInt + g.a.a.b.b.a.f(16, this.rBI);
      }
      i += g.a.a.b.b.a.bu(17, this.KPT);
      paramInt = i;
      if (this.Lsj != null) {
        paramInt = i + g.a.a.b.b.a.f(18, this.Lsj);
      }
      i = paramInt;
      if (this.KPW != null) {
        i = paramInt + g.a.a.a.nh(19, this.KPW.computeSize());
      }
      paramInt = i;
      if (this.ked != null) {
        paramInt = i + g.a.a.b.b.a.f(20, this.ked);
      }
      i = paramInt;
      if (this.MbJ != null) {
        i = paramInt + g.a.a.b.b.a.f(21, this.MbJ);
      }
      paramInt = i;
      if (this.MbK != null) {
        paramInt = i + g.a.a.b.b.a.f(22, this.MbK);
      }
      i = paramInt + g.a.a.b.b.a.bu(23, this.LtX) + g.a.a.b.b.a.bu(24, this.MyA);
      paramInt = i;
      if (this.KLN != null) {
        paramInt = i + g.a.a.b.b.a.f(31, this.KLN);
      }
      i = paramInt;
      if (this.Mrx != null) {
        i = paramInt + g.a.a.b.b.a.f(32, this.Mrx);
      }
      paramInt = i;
      if (this.MyB != null) {
        paramInt = i + g.a.a.b.b.a.f(33, this.MyB);
      }
      i = paramInt;
      if (this.LuU != null) {
        i = paramInt + g.a.a.b.b.a.f(34, this.LuU);
      }
      paramInt = i;
      if (this.MyC != null) {
        paramInt = i + g.a.a.b.b.a.f(35, this.MyC);
      }
      i = paramInt;
      if (this.MyD != null) {
        i = paramInt + g.a.a.b.b.a.f(36, this.MyD);
      }
      paramInt = i;
      if (this.KLY != null) {
        paramInt = i + g.a.a.a.nh(37, this.KLY.computeSize());
      }
      i = paramInt;
      if (this.MyE != null) {
        i = paramInt + g.a.a.b.b.a.f(38, this.MyE);
      }
      paramInt = i;
      if (this.KLR != null) {
        paramInt = i + g.a.a.b.b.a.f(39, this.KLR);
      }
      i = paramInt;
      if (this.MyF != null) {
        i = paramInt + g.a.a.b.b.a.f(40, this.MyF);
      }
      paramInt = i;
      if (this.MyG != null) {
        paramInt = i + g.a.a.b.b.a.f(41, this.MyG);
      }
      i = paramInt + g.a.a.b.b.a.bu(42, this.MyH);
      paramInt = i;
      if (this.KLP != null) {
        paramInt = i + g.a.a.a.nh(43, this.KLP.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(44, this.KPZ);
      paramInt = i;
      if (this.KQa != null) {
        paramInt = i + g.a.a.b.b.a.f(45, this.KQa);
      }
      i = paramInt;
      if (this.LtY != null) {
        i = paramInt + g.a.a.b.b.a.f(46, this.LtY);
      }
      paramInt = i;
      if (this.MyI != null) {
        paramInt = i + g.a.a.b.b.a.f(47, this.MyI);
      }
      i = paramInt;
      if (this.KLQ != null) {
        i = paramInt + g.a.a.a.nh(48, this.KLQ.computeSize());
      }
      paramInt = i;
      if (this.MyJ != null) {
        paramInt = i + g.a.a.b.b.a.f(49, this.MyJ);
      }
      i = paramInt;
      if (this.KFu != null) {
        i = paramInt + g.a.a.b.b.a.f(50, this.KFu);
      }
      paramInt = i;
      if (this.KQf != null) {
        paramInt = i + g.a.a.b.b.a.f(51, this.KQf);
      }
      i = paramInt;
      if (this.KLS != null) {
        i = paramInt + g.a.a.a.nh(52, this.KLS.computeSize());
      }
      AppMethodBeat.o(133184);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(133184);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cto localcto = (cto)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 9: 
        case 10: 
        case 11: 
        case 25: 
        case 26: 
        case 27: 
        case 28: 
        case 29: 
        case 30: 
        default: 
          AppMethodBeat.o(133184);
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
            localcto.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133184);
          return 0;
        case 2: 
          localcto.UserName = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 3: 
          localcto.KQi = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 4: 
          localcto.oUJ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 5: 
          localcto.KDZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(133184);
          return 0;
        case 6: 
          localcto.KEa = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 7: 
          localcto.KEb = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 8: 
          localcto.Bri = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 12: 
          localcto.KLM = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(133184);
          return 0;
        case 13: 
          localcto.Myz = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(133184);
          return 0;
        case 14: 
          localcto.LtW = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(133184);
          return 0;
        case 15: 
          localcto.rBH = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 16: 
          localcto.rBI = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 17: 
          localcto.KPT = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(133184);
          return 0;
        case 18: 
          localcto.Lsj = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 19: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcto.KPW = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133184);
          return 0;
        case 20: 
          localcto.ked = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 21: 
          localcto.MbJ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 22: 
          localcto.MbK = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 23: 
          localcto.LtX = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(133184);
          return 0;
        case 24: 
          localcto.MyA = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(133184);
          return 0;
        case 31: 
          localcto.KLN = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 32: 
          localcto.Mrx = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 33: 
          localcto.MyB = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 34: 
          localcto.LuU = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 35: 
          localcto.MyC = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 36: 
          localcto.MyD = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 37: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aif();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aif)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcto.KLY = ((aif)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133184);
          return 0;
        case 38: 
          localcto.MyE = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 39: 
          localcto.KLR = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 40: 
          localcto.MyF = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 41: 
          localcto.MyG = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 42: 
          localcto.MyH = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(133184);
          return 0;
        case 43: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcto.KLP = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133184);
          return 0;
        case 44: 
          localcto.KPZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(133184);
          return 0;
        case 45: 
          localcto.KQa = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 46: 
          localcto.LtY = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 47: 
          localcto.MyI = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 48: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcto.KLQ = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133184);
          return 0;
        case 49: 
          localcto.MyJ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 50: 
          localcto.KFu = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 51: 
          localcto.KQf = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(133184);
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
          localcto.KLS = ((dfx)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133184);
        return 0;
      }
      AppMethodBeat.o(133184);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cto
 * JD-Core Version:    0.7.0.1
 */