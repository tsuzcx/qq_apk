package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bxy
  extends cqk
{
  public String DLD;
  public String DNb;
  public int DNe;
  public String DNh;
  public String DNi;
  public int DNj;
  public String DNk;
  public String DTH;
  public cyu DTK;
  public int DTP;
  public bkh DYG;
  public oq DYH;
  public bxl DYI;
  public qg DZh;
  public qg DZi;
  public qg DZj;
  public String ETZ;
  public SKBuiltinBuffer_t EUc;
  public String FmV;
  public int FmW;
  public String FmX;
  public int FmY;
  public cfv FmZ;
  public int Fna;
  public String Fnb;
  public String Fnc;
  public cts Fnd;
  public String ncR;
  public int ndj;
  public int pAs;
  public String pAu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133185);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(133185);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.pAs);
      if (this.DLD != null) {
        paramVarArgs.d(3, this.DLD);
      }
      if (this.DNh != null) {
        paramVarArgs.d(4, this.DNh);
      }
      if (this.DNi != null) {
        paramVarArgs.d(5, this.DNi);
      }
      if (this.FmV != null) {
        paramVarArgs.d(6, this.FmV);
      }
      if (this.DNb != null) {
        paramVarArgs.d(7, this.DNb);
      }
      paramVarArgs.aR(8, this.DNj);
      paramVarArgs.aR(9, this.FmW);
      if (this.FmX != null) {
        paramVarArgs.d(10, this.FmX);
      }
      if (this.DYH != null)
      {
        paramVarArgs.ln(14, this.DYH.computeSize());
        this.DYH.writeFields(paramVarArgs);
      }
      if (this.DNk != null) {
        paramVarArgs.d(15, this.DNk);
      }
      if (this.ncR != null) {
        paramVarArgs.d(16, this.ncR);
      }
      paramVarArgs.aR(17, this.ndj);
      if (this.DYI != null)
      {
        paramVarArgs.ln(18, this.DYI.computeSize());
        this.DYI.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(19, this.FmY);
      paramVarArgs.aR(20, this.DNe);
      if (this.DTH != null) {
        paramVarArgs.d(21, this.DTH);
      }
      if (this.FmZ != null)
      {
        paramVarArgs.ln(22, this.FmZ.computeSize());
        this.FmZ.writeFields(paramVarArgs);
      }
      if (this.pAu != null) {
        paramVarArgs.d(23, this.pAu);
      }
      paramVarArgs.aR(24, this.Fna);
      if (this.DYG != null)
      {
        paramVarArgs.ln(25, this.DYG.computeSize());
        this.DYG.writeFields(paramVarArgs);
      }
      if (this.Fnb != null) {
        paramVarArgs.d(26, this.Fnb);
      }
      if (this.DZh != null)
      {
        paramVarArgs.ln(27, this.DZh.computeSize());
        this.DZh.writeFields(paramVarArgs);
      }
      if (this.Fnc != null) {
        paramVarArgs.d(28, this.Fnc);
      }
      if (this.ETZ != null) {
        paramVarArgs.d(29, this.ETZ);
      }
      if (this.EUc != null)
      {
        paramVarArgs.ln(30, this.EUc.computeSize());
        this.EUc.writeFields(paramVarArgs);
      }
      if (this.DTK != null)
      {
        paramVarArgs.ln(31, this.DTK.computeSize());
        this.DTK.writeFields(paramVarArgs);
      }
      if (this.DZi != null)
      {
        paramVarArgs.ln(32, this.DZi.computeSize());
        this.DZi.writeFields(paramVarArgs);
      }
      if (this.DZj != null)
      {
        paramVarArgs.ln(33, this.DZj.computeSize());
        this.DZj.writeFields(paramVarArgs);
      }
      if (this.Fnd != null)
      {
        paramVarArgs.ln(34, this.Fnd.computeSize());
        this.Fnd.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(35, this.DTP);
      AppMethodBeat.o(133185);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label3094;
      }
    }
    label3094:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.pAs);
      paramInt = i;
      if (this.DLD != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.DLD);
      }
      i = paramInt;
      if (this.DNh != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.DNh);
      }
      paramInt = i;
      if (this.DNi != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.DNi);
      }
      i = paramInt;
      if (this.FmV != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.FmV);
      }
      paramInt = i;
      if (this.DNb != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.DNb);
      }
      i = paramInt + f.a.a.b.b.a.bx(8, this.DNj) + f.a.a.b.b.a.bx(9, this.FmW);
      paramInt = i;
      if (this.FmX != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.FmX);
      }
      i = paramInt;
      if (this.DYH != null) {
        i = paramInt + f.a.a.a.lm(14, this.DYH.computeSize());
      }
      paramInt = i;
      if (this.DNk != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.DNk);
      }
      i = paramInt;
      if (this.ncR != null) {
        i = paramInt + f.a.a.b.b.a.e(16, this.ncR);
      }
      i += f.a.a.b.b.a.bx(17, this.ndj);
      paramInt = i;
      if (this.DYI != null) {
        paramInt = i + f.a.a.a.lm(18, this.DYI.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bx(19, this.FmY) + f.a.a.b.b.a.bx(20, this.DNe);
      paramInt = i;
      if (this.DTH != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.DTH);
      }
      i = paramInt;
      if (this.FmZ != null) {
        i = paramInt + f.a.a.a.lm(22, this.FmZ.computeSize());
      }
      paramInt = i;
      if (this.pAu != null) {
        paramInt = i + f.a.a.b.b.a.e(23, this.pAu);
      }
      i = paramInt + f.a.a.b.b.a.bx(24, this.Fna);
      paramInt = i;
      if (this.DYG != null) {
        paramInt = i + f.a.a.a.lm(25, this.DYG.computeSize());
      }
      i = paramInt;
      if (this.Fnb != null) {
        i = paramInt + f.a.a.b.b.a.e(26, this.Fnb);
      }
      paramInt = i;
      if (this.DZh != null) {
        paramInt = i + f.a.a.a.lm(27, this.DZh.computeSize());
      }
      i = paramInt;
      if (this.Fnc != null) {
        i = paramInt + f.a.a.b.b.a.e(28, this.Fnc);
      }
      paramInt = i;
      if (this.ETZ != null) {
        paramInt = i + f.a.a.b.b.a.e(29, this.ETZ);
      }
      i = paramInt;
      if (this.EUc != null) {
        i = paramInt + f.a.a.a.lm(30, this.EUc.computeSize());
      }
      paramInt = i;
      if (this.DTK != null) {
        paramInt = i + f.a.a.a.lm(31, this.DTK.computeSize());
      }
      i = paramInt;
      if (this.DZi != null) {
        i = paramInt + f.a.a.a.lm(32, this.DZi.computeSize());
      }
      paramInt = i;
      if (this.DZj != null) {
        paramInt = i + f.a.a.a.lm(33, this.DZj.computeSize());
      }
      i = paramInt;
      if (this.Fnd != null) {
        i = paramInt + f.a.a.a.lm(34, this.Fnd.computeSize());
      }
      paramInt = f.a.a.b.b.a.bx(35, this.DTP);
      AppMethodBeat.o(133185);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(133185);
          throw paramVarArgs;
        }
        AppMethodBeat.o(133185);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bxy localbxy = (bxy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 11: 
        case 12: 
        case 13: 
        default: 
          AppMethodBeat.o(133185);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbxy.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133185);
          return 0;
        case 2: 
          localbxy.pAs = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(133185);
          return 0;
        case 3: 
          localbxy.DLD = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(133185);
          return 0;
        case 4: 
          localbxy.DNh = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(133185);
          return 0;
        case 5: 
          localbxy.DNi = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(133185);
          return 0;
        case 6: 
          localbxy.FmV = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(133185);
          return 0;
        case 7: 
          localbxy.DNb = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(133185);
          return 0;
        case 8: 
          localbxy.DNj = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(133185);
          return 0;
        case 9: 
          localbxy.FmW = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(133185);
          return 0;
        case 10: 
          localbxy.FmX = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(133185);
          return 0;
        case 14: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new oq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((oq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbxy.DYH = ((oq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133185);
          return 0;
        case 15: 
          localbxy.DNk = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(133185);
          return 0;
        case 16: 
          localbxy.ncR = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(133185);
          return 0;
        case 17: 
          localbxy.ndj = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(133185);
          return 0;
        case 18: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bxl();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bxl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbxy.DYI = ((bxl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133185);
          return 0;
        case 19: 
          localbxy.FmY = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(133185);
          return 0;
        case 20: 
          localbxy.DNe = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(133185);
          return 0;
        case 21: 
          localbxy.DTH = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(133185);
          return 0;
        case 22: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cfv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cfv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbxy.FmZ = ((cfv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133185);
          return 0;
        case 23: 
          localbxy.pAu = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(133185);
          return 0;
        case 24: 
          localbxy.Fna = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(133185);
          return 0;
        case 25: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bkh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bkh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbxy.DYG = ((bkh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133185);
          return 0;
        case 26: 
          localbxy.Fnb = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(133185);
          return 0;
        case 27: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new qg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((qg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbxy.DZh = ((qg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133185);
          return 0;
        case 28: 
          localbxy.Fnc = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(133185);
          return 0;
        case 29: 
          localbxy.ETZ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(133185);
          return 0;
        case 30: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbxy.EUc = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133185);
          return 0;
        case 31: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cyu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cyu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbxy.DTK = ((cyu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133185);
          return 0;
        case 32: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new qg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((qg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbxy.DZi = ((qg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133185);
          return 0;
        case 33: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new qg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((qg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbxy.DZj = ((qg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133185);
          return 0;
        case 34: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cts();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cts)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbxy.Fnd = ((cts)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133185);
          return 0;
        }
        localbxy.DTP = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(133185);
        return 0;
      }
      AppMethodBeat.o(133185);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bxy
 * JD-Core Version:    0.7.0.1
 */