package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class gx
  extends com.tencent.mm.bw.a
{
  public String FKN;
  public SKBuiltinBuffer_t FRA;
  public String FRB;
  public dfb FRC;
  public String FRD;
  public int FRE;
  public int FRF;
  public int FRG;
  public int FRH;
  public int FRI;
  public SKBuiltinBuffer_t FRJ;
  public SKBuiltinBuffer_t FRK;
  public int FRL;
  public afy FRq;
  public SKBuiltinBuffer_t FRr;
  public SKBuiltinBuffer_t FRs;
  public int FRt;
  public SKBuiltinBuffer_t FRu;
  public eck FRv;
  public ehj FRw;
  public SKBuiltinBuffer_t FRx;
  public SKBuiltinBuffer_t FRy;
  public String FRz;
  public int qkC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133145);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FRq == null)
      {
        paramVarArgs = new b("Not all required fields were included: SvrPubECDHKey");
        AppMethodBeat.o(133145);
        throw paramVarArgs;
      }
      if (this.FRr == null)
      {
        paramVarArgs = new b("Not all required fields were included: SessionKey");
        AppMethodBeat.o(133145);
        throw paramVarArgs;
      }
      if (this.FRs == null)
      {
        paramVarArgs = new b("Not all required fields were included: AutoAuthKey");
        AppMethodBeat.o(133145);
        throw paramVarArgs;
      }
      if (this.FRJ == null)
      {
        paramVarArgs = new b("Not all required fields were included: ClientSessionKey");
        AppMethodBeat.o(133145);
        throw paramVarArgs;
      }
      if (this.FRK == null)
      {
        paramVarArgs = new b("Not all required fields were included: ServerSessionKey");
        AppMethodBeat.o(133145);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.qkC);
      if (this.FRq != null)
      {
        paramVarArgs.lJ(2, this.FRq.computeSize());
        this.FRq.writeFields(paramVarArgs);
      }
      if (this.FRr != null)
      {
        paramVarArgs.lJ(3, this.FRr.computeSize());
        this.FRr.writeFields(paramVarArgs);
      }
      if (this.FRs != null)
      {
        paramVarArgs.lJ(4, this.FRs.computeSize());
        this.FRs.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(5, this.FRt);
      if (this.FRu != null)
      {
        paramVarArgs.lJ(6, this.FRu.computeSize());
        this.FRu.writeFields(paramVarArgs);
      }
      if (this.FRv != null)
      {
        paramVarArgs.lJ(7, this.FRv.computeSize());
        this.FRv.writeFields(paramVarArgs);
      }
      if (this.FRw != null)
      {
        paramVarArgs.lJ(8, this.FRw.computeSize());
        this.FRw.writeFields(paramVarArgs);
      }
      if (this.FRx != null)
      {
        paramVarArgs.lJ(9, this.FRx.computeSize());
        this.FRx.writeFields(paramVarArgs);
      }
      if (this.FRy != null)
      {
        paramVarArgs.lJ(10, this.FRy.computeSize());
        this.FRy.writeFields(paramVarArgs);
      }
      if (this.FRz != null) {
        paramVarArgs.d(11, this.FRz);
      }
      if (this.FRA != null)
      {
        paramVarArgs.lJ(12, this.FRA.computeSize());
        this.FRA.writeFields(paramVarArgs);
      }
      if (this.FRB != null) {
        paramVarArgs.d(14, this.FRB);
      }
      if (this.FRC != null)
      {
        paramVarArgs.lJ(15, this.FRC.computeSize());
        this.FRC.writeFields(paramVarArgs);
      }
      if (this.FRD != null) {
        paramVarArgs.d(16, this.FRD);
      }
      paramVarArgs.aS(17, this.FRE);
      paramVarArgs.aS(18, this.FRF);
      paramVarArgs.aS(19, this.FRG);
      if (this.FKN != null) {
        paramVarArgs.d(20, this.FKN);
      }
      paramVarArgs.aS(21, this.FRH);
      paramVarArgs.aS(22, this.FRI);
      if (this.FRJ != null)
      {
        paramVarArgs.lJ(23, this.FRJ.computeSize());
        this.FRJ.writeFields(paramVarArgs);
      }
      if (this.FRK != null)
      {
        paramVarArgs.lJ(24, this.FRK.computeSize());
        this.FRK.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(25, this.FRL);
      AppMethodBeat.o(133145);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.qkC) + 0;
      paramInt = i;
      if (this.FRq != null) {
        paramInt = i + f.a.a.a.lI(2, this.FRq.computeSize());
      }
      i = paramInt;
      if (this.FRr != null) {
        i = paramInt + f.a.a.a.lI(3, this.FRr.computeSize());
      }
      paramInt = i;
      if (this.FRs != null) {
        paramInt = i + f.a.a.a.lI(4, this.FRs.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.FRt);
      paramInt = i;
      if (this.FRu != null) {
        paramInt = i + f.a.a.a.lI(6, this.FRu.computeSize());
      }
      i = paramInt;
      if (this.FRv != null) {
        i = paramInt + f.a.a.a.lI(7, this.FRv.computeSize());
      }
      paramInt = i;
      if (this.FRw != null) {
        paramInt = i + f.a.a.a.lI(8, this.FRw.computeSize());
      }
      i = paramInt;
      if (this.FRx != null) {
        i = paramInt + f.a.a.a.lI(9, this.FRx.computeSize());
      }
      paramInt = i;
      if (this.FRy != null) {
        paramInt = i + f.a.a.a.lI(10, this.FRy.computeSize());
      }
      i = paramInt;
      if (this.FRz != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.FRz);
      }
      paramInt = i;
      if (this.FRA != null) {
        paramInt = i + f.a.a.a.lI(12, this.FRA.computeSize());
      }
      i = paramInt;
      if (this.FRB != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.FRB);
      }
      paramInt = i;
      if (this.FRC != null) {
        paramInt = i + f.a.a.a.lI(15, this.FRC.computeSize());
      }
      i = paramInt;
      if (this.FRD != null) {
        i = paramInt + f.a.a.b.b.a.e(16, this.FRD);
      }
      i = i + f.a.a.b.b.a.bz(17, this.FRE) + f.a.a.b.b.a.bz(18, this.FRF) + f.a.a.b.b.a.bz(19, this.FRG);
      paramInt = i;
      if (this.FKN != null) {
        paramInt = i + f.a.a.b.b.a.e(20, this.FKN);
      }
      i = paramInt + f.a.a.b.b.a.bz(21, this.FRH) + f.a.a.b.b.a.bz(22, this.FRI);
      paramInt = i;
      if (this.FRJ != null) {
        paramInt = i + f.a.a.a.lI(23, this.FRJ.computeSize());
      }
      i = paramInt;
      if (this.FRK != null) {
        i = paramInt + f.a.a.a.lI(24, this.FRK.computeSize());
      }
      paramInt = f.a.a.b.b.a.bz(25, this.FRL);
      AppMethodBeat.o(133145);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      if (this.FRq == null)
      {
        paramVarArgs = new b("Not all required fields were included: SvrPubECDHKey");
        AppMethodBeat.o(133145);
        throw paramVarArgs;
      }
      if (this.FRr == null)
      {
        paramVarArgs = new b("Not all required fields were included: SessionKey");
        AppMethodBeat.o(133145);
        throw paramVarArgs;
      }
      if (this.FRs == null)
      {
        paramVarArgs = new b("Not all required fields were included: AutoAuthKey");
        AppMethodBeat.o(133145);
        throw paramVarArgs;
      }
      if (this.FRJ == null)
      {
        paramVarArgs = new b("Not all required fields were included: ClientSessionKey");
        AppMethodBeat.o(133145);
        throw paramVarArgs;
      }
      if (this.FRK == null)
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
      gx localgx = (gx)paramVarArgs[1];
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
        localgx.qkC = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(133145);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new afy();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((afy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localgx.FRq = ((afy)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133145);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localgx.FRr = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133145);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localgx.FRs = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133145);
        return 0;
      case 5: 
        localgx.FRt = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(133145);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localgx.FRu = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133145);
        return 0;
      case 7: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new eck();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((eck)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localgx.FRv = ((eck)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133145);
        return 0;
      case 8: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ehj();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ehj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localgx.FRw = ((ehj)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133145);
        return 0;
      case 9: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localgx.FRx = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133145);
        return 0;
      case 10: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localgx.FRy = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133145);
        return 0;
      case 11: 
        localgx.FRz = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(133145);
        return 0;
      case 12: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localgx.FRA = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133145);
        return 0;
      case 14: 
        localgx.FRB = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(133145);
        return 0;
      case 15: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dfb();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dfb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localgx.FRC = ((dfb)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133145);
        return 0;
      case 16: 
        localgx.FRD = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(133145);
        return 0;
      case 17: 
        localgx.FRE = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(133145);
        return 0;
      case 18: 
        localgx.FRF = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(133145);
        return 0;
      case 19: 
        localgx.FRG = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(133145);
        return 0;
      case 20: 
        localgx.FKN = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(133145);
        return 0;
      case 21: 
        localgx.FRH = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(133145);
        return 0;
      case 22: 
        localgx.FRI = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(133145);
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
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localgx.FRJ = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133145);
        return 0;
      case 24: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localgx.FRK = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133145);
        return 0;
      }
      localgx.FRL = ((f.a.a.a.a)localObject1).OmT.zc();
      AppMethodBeat.o(133145);
      return 0;
    }
    AppMethodBeat.o(133145);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gx
 * JD-Core Version:    0.7.0.1
 */