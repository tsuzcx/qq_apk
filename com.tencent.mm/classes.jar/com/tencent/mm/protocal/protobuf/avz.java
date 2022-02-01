package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class avz
  extends cwj
{
  public String FJb;
  public int FJl;
  public SKBuiltinBuffer_t GNA;
  public String GNB;
  public String GNC;
  public brk GND;
  public avj GNE;
  public String GNF;
  public int GNG;
  public LinkedList<pa> GNH;
  public String GNI;
  public acv GNJ;
  public SKBuiltinBuffer_t GNK;
  public int GNL;
  public SKBuiltinBuffer_t GNM;
  public SKBuiltinBuffer_t GNN;
  public String GNf;
  public String GNg;
  public LinkedList<bpk> GNl;
  public String SSID;
  public String Title;
  public String hFS;
  public String nIJ;
  public String urq;
  
  public avz()
  {
    AppMethodBeat.i(152553);
    this.GNH = new LinkedList();
    this.GNl = new LinkedList();
    AppMethodBeat.o(152553);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152554);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(152554);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.GNB != null) {
        paramVarArgs.d(2, this.GNB);
      }
      if (this.GNC != null) {
        paramVarArgs.d(3, this.GNC);
      }
      paramVarArgs.aS(4, this.FJl);
      if (this.Title != null) {
        paramVarArgs.d(5, this.Title);
      }
      if (this.hFS != null) {
        paramVarArgs.d(6, this.hFS);
      }
      if (this.GND != null)
      {
        paramVarArgs.lJ(7, this.GND.computeSize());
        this.GND.writeFields(paramVarArgs);
      }
      if (this.GNE != null)
      {
        paramVarArgs.lJ(8, this.GNE.computeSize());
        this.GNE.writeFields(paramVarArgs);
      }
      if (this.nIJ != null) {
        paramVarArgs.d(9, this.nIJ);
      }
      if (this.GNF != null) {
        paramVarArgs.d(15, this.GNF);
      }
      paramVarArgs.aS(16, this.GNG);
      paramVarArgs.e(17, 8, this.GNH);
      if (this.GNI != null) {
        paramVarArgs.d(18, this.GNI);
      }
      if (this.SSID != null) {
        paramVarArgs.d(20, this.SSID);
      }
      if (this.FJb != null) {
        paramVarArgs.d(21, this.FJb);
      }
      if (this.GNJ != null)
      {
        paramVarArgs.lJ(22, this.GNJ.computeSize());
        this.GNJ.writeFields(paramVarArgs);
      }
      if (this.GNK != null)
      {
        paramVarArgs.lJ(23, this.GNK.computeSize());
        this.GNK.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(24, this.GNL);
      paramVarArgs.e(25, 8, this.GNl);
      if (this.urq != null) {
        paramVarArgs.d(26, this.urq);
      }
      if (this.GNf != null) {
        paramVarArgs.d(27, this.GNf);
      }
      if (this.GNA != null)
      {
        paramVarArgs.lJ(28, this.GNA.computeSize());
        this.GNA.writeFields(paramVarArgs);
      }
      if (this.GNg != null) {
        paramVarArgs.d(29, this.GNg);
      }
      if (this.GNM != null)
      {
        paramVarArgs.lJ(30, this.GNM.computeSize());
        this.GNM.writeFields(paramVarArgs);
      }
      if (this.GNN != null)
      {
        paramVarArgs.lJ(31, this.GNN.computeSize());
        this.GNN.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(152554);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2630;
      }
    }
    label2630:
    for (int i = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GNB != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.GNB);
      }
      i = paramInt;
      if (this.GNC != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GNC);
      }
      i += f.a.a.b.b.a.bz(4, this.FJl);
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Title);
      }
      i = paramInt;
      if (this.hFS != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.hFS);
      }
      paramInt = i;
      if (this.GND != null) {
        paramInt = i + f.a.a.a.lI(7, this.GND.computeSize());
      }
      i = paramInt;
      if (this.GNE != null) {
        i = paramInt + f.a.a.a.lI(8, this.GNE.computeSize());
      }
      paramInt = i;
      if (this.nIJ != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.nIJ);
      }
      i = paramInt;
      if (this.GNF != null) {
        i = paramInt + f.a.a.b.b.a.e(15, this.GNF);
      }
      i = i + f.a.a.b.b.a.bz(16, this.GNG) + f.a.a.a.c(17, 8, this.GNH);
      paramInt = i;
      if (this.GNI != null) {
        paramInt = i + f.a.a.b.b.a.e(18, this.GNI);
      }
      i = paramInt;
      if (this.SSID != null) {
        i = paramInt + f.a.a.b.b.a.e(20, this.SSID);
      }
      paramInt = i;
      if (this.FJb != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.FJb);
      }
      i = paramInt;
      if (this.GNJ != null) {
        i = paramInt + f.a.a.a.lI(22, this.GNJ.computeSize());
      }
      paramInt = i;
      if (this.GNK != null) {
        paramInt = i + f.a.a.a.lI(23, this.GNK.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(24, this.GNL) + f.a.a.a.c(25, 8, this.GNl);
      paramInt = i;
      if (this.urq != null) {
        paramInt = i + f.a.a.b.b.a.e(26, this.urq);
      }
      i = paramInt;
      if (this.GNf != null) {
        i = paramInt + f.a.a.b.b.a.e(27, this.GNf);
      }
      paramInt = i;
      if (this.GNA != null) {
        paramInt = i + f.a.a.a.lI(28, this.GNA.computeSize());
      }
      i = paramInt;
      if (this.GNg != null) {
        i = paramInt + f.a.a.b.b.a.e(29, this.GNg);
      }
      paramInt = i;
      if (this.GNM != null) {
        paramInt = i + f.a.a.a.lI(30, this.GNM.computeSize());
      }
      i = paramInt;
      if (this.GNN != null) {
        i = paramInt + f.a.a.a.lI(31, this.GNN.computeSize());
      }
      AppMethodBeat.o(152554);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GNH.clear();
        this.GNl.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(152554);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152554);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        avz localavz = (avz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 10: 
        case 11: 
        case 12: 
        case 13: 
        case 14: 
        case 19: 
        default: 
          AppMethodBeat.o(152554);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localavz.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152554);
          return 0;
        case 2: 
          localavz.GNB = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152554);
          return 0;
        case 3: 
          localavz.GNC = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152554);
          return 0;
        case 4: 
          localavz.FJl = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152554);
          return 0;
        case 5: 
          localavz.Title = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152554);
          return 0;
        case 6: 
          localavz.hFS = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152554);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new brk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((brk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localavz.GND = ((brk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152554);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new avj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((avj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localavz.GNE = ((avj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152554);
          return 0;
        case 9: 
          localavz.nIJ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152554);
          return 0;
        case 15: 
          localavz.GNF = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152554);
          return 0;
        case 16: 
          localavz.GNG = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152554);
          return 0;
        case 17: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new pa();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((pa)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localavz.GNH.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152554);
          return 0;
        case 18: 
          localavz.GNI = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152554);
          return 0;
        case 20: 
          localavz.SSID = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152554);
          return 0;
        case 21: 
          localavz.FJb = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152554);
          return 0;
        case 22: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new acv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((acv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localavz.GNJ = ((acv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152554);
          return 0;
        case 23: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localavz.GNK = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152554);
          return 0;
        case 24: 
          localavz.GNL = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152554);
          return 0;
        case 25: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bpk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bpk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localavz.GNl.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152554);
          return 0;
        case 26: 
          localavz.urq = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152554);
          return 0;
        case 27: 
          localavz.GNf = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152554);
          return 0;
        case 28: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localavz.GNA = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152554);
          return 0;
        case 29: 
          localavz.GNg = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152554);
          return 0;
        case 30: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localavz.GNM = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152554);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localavz.GNN = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(152554);
        return 0;
      }
      AppMethodBeat.o(152554);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.avz
 * JD-Core Version:    0.7.0.1
 */