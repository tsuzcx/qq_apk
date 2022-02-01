package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class gq
  extends com.tencent.mm.bw.a
{
  public String DNk;
  public SKBuiltinBuffer_t DTA;
  public int DTB;
  public SKBuiltinBuffer_t DTC;
  public duz DTD;
  public dzo DTE;
  public SKBuiltinBuffer_t DTF;
  public SKBuiltinBuffer_t DTG;
  public String DTH;
  public SKBuiltinBuffer_t DTI;
  public String DTJ;
  public cyu DTK;
  public String DTL;
  public int DTM;
  public int DTN;
  public int DTO;
  public int DTP;
  public int DTQ;
  public SKBuiltinBuffer_t DTR;
  public SKBuiltinBuffer_t DTS;
  public int DTT;
  public ado DTy;
  public SKBuiltinBuffer_t DTz;
  public int pAs;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133145);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DTy == null)
      {
        paramVarArgs = new b("Not all required fields were included: SvrPubECDHKey");
        AppMethodBeat.o(133145);
        throw paramVarArgs;
      }
      if (this.DTz == null)
      {
        paramVarArgs = new b("Not all required fields were included: SessionKey");
        AppMethodBeat.o(133145);
        throw paramVarArgs;
      }
      if (this.DTA == null)
      {
        paramVarArgs = new b("Not all required fields were included: AutoAuthKey");
        AppMethodBeat.o(133145);
        throw paramVarArgs;
      }
      if (this.DTR == null)
      {
        paramVarArgs = new b("Not all required fields were included: ClientSessionKey");
        AppMethodBeat.o(133145);
        throw paramVarArgs;
      }
      if (this.DTS == null)
      {
        paramVarArgs = new b("Not all required fields were included: ServerSessionKey");
        AppMethodBeat.o(133145);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.pAs);
      if (this.DTy != null)
      {
        paramVarArgs.ln(2, this.DTy.computeSize());
        this.DTy.writeFields(paramVarArgs);
      }
      if (this.DTz != null)
      {
        paramVarArgs.ln(3, this.DTz.computeSize());
        this.DTz.writeFields(paramVarArgs);
      }
      if (this.DTA != null)
      {
        paramVarArgs.ln(4, this.DTA.computeSize());
        this.DTA.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(5, this.DTB);
      if (this.DTC != null)
      {
        paramVarArgs.ln(6, this.DTC.computeSize());
        this.DTC.writeFields(paramVarArgs);
      }
      if (this.DTD != null)
      {
        paramVarArgs.ln(7, this.DTD.computeSize());
        this.DTD.writeFields(paramVarArgs);
      }
      if (this.DTE != null)
      {
        paramVarArgs.ln(8, this.DTE.computeSize());
        this.DTE.writeFields(paramVarArgs);
      }
      if (this.DTF != null)
      {
        paramVarArgs.ln(9, this.DTF.computeSize());
        this.DTF.writeFields(paramVarArgs);
      }
      if (this.DTG != null)
      {
        paramVarArgs.ln(10, this.DTG.computeSize());
        this.DTG.writeFields(paramVarArgs);
      }
      if (this.DTH != null) {
        paramVarArgs.d(11, this.DTH);
      }
      if (this.DTI != null)
      {
        paramVarArgs.ln(12, this.DTI.computeSize());
        this.DTI.writeFields(paramVarArgs);
      }
      if (this.DTJ != null) {
        paramVarArgs.d(14, this.DTJ);
      }
      if (this.DTK != null)
      {
        paramVarArgs.ln(15, this.DTK.computeSize());
        this.DTK.writeFields(paramVarArgs);
      }
      if (this.DTL != null) {
        paramVarArgs.d(16, this.DTL);
      }
      paramVarArgs.aR(17, this.DTM);
      paramVarArgs.aR(18, this.DTN);
      paramVarArgs.aR(19, this.DTO);
      if (this.DNk != null) {
        paramVarArgs.d(20, this.DNk);
      }
      paramVarArgs.aR(21, this.DTP);
      paramVarArgs.aR(22, this.DTQ);
      if (this.DTR != null)
      {
        paramVarArgs.ln(23, this.DTR.computeSize());
        this.DTR.writeFields(paramVarArgs);
      }
      if (this.DTS != null)
      {
        paramVarArgs.ln(24, this.DTS.computeSize());
        this.DTS.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(25, this.DTT);
      AppMethodBeat.o(133145);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.pAs) + 0;
      paramInt = i;
      if (this.DTy != null) {
        paramInt = i + f.a.a.a.lm(2, this.DTy.computeSize());
      }
      i = paramInt;
      if (this.DTz != null) {
        i = paramInt + f.a.a.a.lm(3, this.DTz.computeSize());
      }
      paramInt = i;
      if (this.DTA != null) {
        paramInt = i + f.a.a.a.lm(4, this.DTA.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bx(5, this.DTB);
      paramInt = i;
      if (this.DTC != null) {
        paramInt = i + f.a.a.a.lm(6, this.DTC.computeSize());
      }
      i = paramInt;
      if (this.DTD != null) {
        i = paramInt + f.a.a.a.lm(7, this.DTD.computeSize());
      }
      paramInt = i;
      if (this.DTE != null) {
        paramInt = i + f.a.a.a.lm(8, this.DTE.computeSize());
      }
      i = paramInt;
      if (this.DTF != null) {
        i = paramInt + f.a.a.a.lm(9, this.DTF.computeSize());
      }
      paramInt = i;
      if (this.DTG != null) {
        paramInt = i + f.a.a.a.lm(10, this.DTG.computeSize());
      }
      i = paramInt;
      if (this.DTH != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.DTH);
      }
      paramInt = i;
      if (this.DTI != null) {
        paramInt = i + f.a.a.a.lm(12, this.DTI.computeSize());
      }
      i = paramInt;
      if (this.DTJ != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.DTJ);
      }
      paramInt = i;
      if (this.DTK != null) {
        paramInt = i + f.a.a.a.lm(15, this.DTK.computeSize());
      }
      i = paramInt;
      if (this.DTL != null) {
        i = paramInt + f.a.a.b.b.a.e(16, this.DTL);
      }
      i = i + f.a.a.b.b.a.bx(17, this.DTM) + f.a.a.b.b.a.bx(18, this.DTN) + f.a.a.b.b.a.bx(19, this.DTO);
      paramInt = i;
      if (this.DNk != null) {
        paramInt = i + f.a.a.b.b.a.e(20, this.DNk);
      }
      i = paramInt + f.a.a.b.b.a.bx(21, this.DTP) + f.a.a.b.b.a.bx(22, this.DTQ);
      paramInt = i;
      if (this.DTR != null) {
        paramInt = i + f.a.a.a.lm(23, this.DTR.computeSize());
      }
      i = paramInt;
      if (this.DTS != null) {
        i = paramInt + f.a.a.a.lm(24, this.DTS.computeSize());
      }
      paramInt = f.a.a.b.b.a.bx(25, this.DTT);
      AppMethodBeat.o(133145);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      if (this.DTy == null)
      {
        paramVarArgs = new b("Not all required fields were included: SvrPubECDHKey");
        AppMethodBeat.o(133145);
        throw paramVarArgs;
      }
      if (this.DTz == null)
      {
        paramVarArgs = new b("Not all required fields were included: SessionKey");
        AppMethodBeat.o(133145);
        throw paramVarArgs;
      }
      if (this.DTA == null)
      {
        paramVarArgs = new b("Not all required fields were included: AutoAuthKey");
        AppMethodBeat.o(133145);
        throw paramVarArgs;
      }
      if (this.DTR == null)
      {
        paramVarArgs = new b("Not all required fields were included: ClientSessionKey");
        AppMethodBeat.o(133145);
        throw paramVarArgs;
      }
      if (this.DTS == null)
      {
        paramVarArgs = new b("Not all required fields were included: ServerSessionKey");
        AppMethodBeat.o(133145);
        throw paramVarArgs;
      }
      AppMethodBeat.o(133145);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      gq localgq = (gq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      case 13: 
      default: 
        AppMethodBeat.o(133145);
        return -1;
      case 1: 
        localgq.pAs = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(133145);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ado();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ado)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localgq.DTy = ((ado)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133145);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localgq.DTz = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133145);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localgq.DTA = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133145);
        return 0;
      case 5: 
        localgq.DTB = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(133145);
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
          localgq.DTC = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133145);
        return 0;
      case 7: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new duz();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((duz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localgq.DTD = ((duz)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133145);
        return 0;
      case 8: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dzo();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dzo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localgq.DTE = ((dzo)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133145);
        return 0;
      case 9: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localgq.DTF = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133145);
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
          localgq.DTG = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133145);
        return 0;
      case 11: 
        localgq.DTH = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(133145);
        return 0;
      case 12: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localgq.DTI = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133145);
        return 0;
      case 14: 
        localgq.DTJ = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(133145);
        return 0;
      case 15: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cyu();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cyu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localgq.DTK = ((cyu)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133145);
        return 0;
      case 16: 
        localgq.DTL = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(133145);
        return 0;
      case 17: 
        localgq.DTM = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(133145);
        return 0;
      case 18: 
        localgq.DTN = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(133145);
        return 0;
      case 19: 
        localgq.DTO = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(133145);
        return 0;
      case 20: 
        localgq.DNk = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(133145);
        return 0;
      case 21: 
        localgq.DTP = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(133145);
        return 0;
      case 22: 
        localgq.DTQ = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(133145);
        return 0;
      case 23: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localgq.DTR = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133145);
        return 0;
      case 24: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localgq.DTS = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133145);
        return 0;
      }
      localgq.DTT = ((f.a.a.a.a)localObject1).LVo.xF();
      AppMethodBeat.o(133145);
      return 0;
    }
    AppMethodBeat.o(133145);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gq
 * JD-Core Version:    0.7.0.1
 */