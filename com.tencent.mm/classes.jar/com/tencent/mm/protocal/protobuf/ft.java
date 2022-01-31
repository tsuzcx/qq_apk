package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class ft
  extends com.tencent.mm.bv.a
{
  public int lGw;
  public String wmA;
  public zd wrJ;
  public SKBuiltinBuffer_t wrK;
  public SKBuiltinBuffer_t wrL;
  public int wrM;
  public SKBuiltinBuffer_t wrN;
  public cvh wrO;
  public czh wrP;
  public SKBuiltinBuffer_t wrQ;
  public SKBuiltinBuffer_t wrR;
  public String wrS;
  public SKBuiltinBuffer_t wrT;
  public String wrU;
  public cco wrV;
  public String wrW;
  public int wrX;
  public int wrY;
  public int wrZ;
  public int wsa;
  public int wsb;
  public SKBuiltinBuffer_t wsc;
  public SKBuiltinBuffer_t wsd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(58886);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wrJ == null)
      {
        paramVarArgs = new b("Not all required fields were included: SvrPubECDHKey");
        AppMethodBeat.o(58886);
        throw paramVarArgs;
      }
      if (this.wrK == null)
      {
        paramVarArgs = new b("Not all required fields were included: SessionKey");
        AppMethodBeat.o(58886);
        throw paramVarArgs;
      }
      if (this.wrL == null)
      {
        paramVarArgs = new b("Not all required fields were included: AutoAuthKey");
        AppMethodBeat.o(58886);
        throw paramVarArgs;
      }
      if (this.wsc == null)
      {
        paramVarArgs = new b("Not all required fields were included: ClientSessionKey");
        AppMethodBeat.o(58886);
        throw paramVarArgs;
      }
      if (this.wsd == null)
      {
        paramVarArgs = new b("Not all required fields were included: ServerSessionKey");
        AppMethodBeat.o(58886);
        throw paramVarArgs;
      }
      paramVarArgs.aO(1, this.lGw);
      if (this.wrJ != null)
      {
        paramVarArgs.iQ(2, this.wrJ.computeSize());
        this.wrJ.writeFields(paramVarArgs);
      }
      if (this.wrK != null)
      {
        paramVarArgs.iQ(3, this.wrK.computeSize());
        this.wrK.writeFields(paramVarArgs);
      }
      if (this.wrL != null)
      {
        paramVarArgs.iQ(4, this.wrL.computeSize());
        this.wrL.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(5, this.wrM);
      if (this.wrN != null)
      {
        paramVarArgs.iQ(6, this.wrN.computeSize());
        this.wrN.writeFields(paramVarArgs);
      }
      if (this.wrO != null)
      {
        paramVarArgs.iQ(7, this.wrO.computeSize());
        this.wrO.writeFields(paramVarArgs);
      }
      if (this.wrP != null)
      {
        paramVarArgs.iQ(8, this.wrP.computeSize());
        this.wrP.writeFields(paramVarArgs);
      }
      if (this.wrQ != null)
      {
        paramVarArgs.iQ(9, this.wrQ.computeSize());
        this.wrQ.writeFields(paramVarArgs);
      }
      if (this.wrR != null)
      {
        paramVarArgs.iQ(10, this.wrR.computeSize());
        this.wrR.writeFields(paramVarArgs);
      }
      if (this.wrS != null) {
        paramVarArgs.e(11, this.wrS);
      }
      if (this.wrT != null)
      {
        paramVarArgs.iQ(12, this.wrT.computeSize());
        this.wrT.writeFields(paramVarArgs);
      }
      if (this.wrU != null) {
        paramVarArgs.e(14, this.wrU);
      }
      if (this.wrV != null)
      {
        paramVarArgs.iQ(15, this.wrV.computeSize());
        this.wrV.writeFields(paramVarArgs);
      }
      if (this.wrW != null) {
        paramVarArgs.e(16, this.wrW);
      }
      paramVarArgs.aO(17, this.wrX);
      paramVarArgs.aO(18, this.wrY);
      paramVarArgs.aO(19, this.wrZ);
      if (this.wmA != null) {
        paramVarArgs.e(20, this.wmA);
      }
      paramVarArgs.aO(21, this.wsa);
      paramVarArgs.aO(22, this.wsb);
      if (this.wsc != null)
      {
        paramVarArgs.iQ(23, this.wsc.computeSize());
        this.wsc.writeFields(paramVarArgs);
      }
      if (this.wsd != null)
      {
        paramVarArgs.iQ(24, this.wsd.computeSize());
        this.wsd.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(58886);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.bl(1, this.lGw) + 0;
      paramInt = i;
      if (this.wrJ != null) {
        paramInt = i + e.a.a.a.iP(2, this.wrJ.computeSize());
      }
      i = paramInt;
      if (this.wrK != null) {
        i = paramInt + e.a.a.a.iP(3, this.wrK.computeSize());
      }
      paramInt = i;
      if (this.wrL != null) {
        paramInt = i + e.a.a.a.iP(4, this.wrL.computeSize());
      }
      i = paramInt + e.a.a.b.b.a.bl(5, this.wrM);
      paramInt = i;
      if (this.wrN != null) {
        paramInt = i + e.a.a.a.iP(6, this.wrN.computeSize());
      }
      i = paramInt;
      if (this.wrO != null) {
        i = paramInt + e.a.a.a.iP(7, this.wrO.computeSize());
      }
      paramInt = i;
      if (this.wrP != null) {
        paramInt = i + e.a.a.a.iP(8, this.wrP.computeSize());
      }
      i = paramInt;
      if (this.wrQ != null) {
        i = paramInt + e.a.a.a.iP(9, this.wrQ.computeSize());
      }
      paramInt = i;
      if (this.wrR != null) {
        paramInt = i + e.a.a.a.iP(10, this.wrR.computeSize());
      }
      i = paramInt;
      if (this.wrS != null) {
        i = paramInt + e.a.a.b.b.a.f(11, this.wrS);
      }
      paramInt = i;
      if (this.wrT != null) {
        paramInt = i + e.a.a.a.iP(12, this.wrT.computeSize());
      }
      i = paramInt;
      if (this.wrU != null) {
        i = paramInt + e.a.a.b.b.a.f(14, this.wrU);
      }
      paramInt = i;
      if (this.wrV != null) {
        paramInt = i + e.a.a.a.iP(15, this.wrV.computeSize());
      }
      i = paramInt;
      if (this.wrW != null) {
        i = paramInt + e.a.a.b.b.a.f(16, this.wrW);
      }
      i = i + e.a.a.b.b.a.bl(17, this.wrX) + e.a.a.b.b.a.bl(18, this.wrY) + e.a.a.b.b.a.bl(19, this.wrZ);
      paramInt = i;
      if (this.wmA != null) {
        paramInt = i + e.a.a.b.b.a.f(20, this.wmA);
      }
      i = paramInt + e.a.a.b.b.a.bl(21, this.wsa) + e.a.a.b.b.a.bl(22, this.wsb);
      paramInt = i;
      if (this.wsc != null) {
        paramInt = i + e.a.a.a.iP(23, this.wsc.computeSize());
      }
      i = paramInt;
      if (this.wsd != null) {
        i = paramInt + e.a.a.a.iP(24, this.wsd.computeSize());
      }
      AppMethodBeat.o(58886);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      if (this.wrJ == null)
      {
        paramVarArgs = new b("Not all required fields were included: SvrPubECDHKey");
        AppMethodBeat.o(58886);
        throw paramVarArgs;
      }
      if (this.wrK == null)
      {
        paramVarArgs = new b("Not all required fields were included: SessionKey");
        AppMethodBeat.o(58886);
        throw paramVarArgs;
      }
      if (this.wrL == null)
      {
        paramVarArgs = new b("Not all required fields were included: AutoAuthKey");
        AppMethodBeat.o(58886);
        throw paramVarArgs;
      }
      if (this.wsc == null)
      {
        paramVarArgs = new b("Not all required fields were included: ClientSessionKey");
        AppMethodBeat.o(58886);
        throw paramVarArgs;
      }
      if (this.wsd == null)
      {
        paramVarArgs = new b("Not all required fields were included: ServerSessionKey");
        AppMethodBeat.o(58886);
        throw paramVarArgs;
      }
      AppMethodBeat.o(58886);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      ft localft = (ft)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      case 13: 
      default: 
        AppMethodBeat.o(58886);
        return -1;
      case 1: 
        localft.lGw = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(58886);
        return 0;
      case 2: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new zd();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((zd)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localft.wrJ = ((zd)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(58886);
        return 0;
      case 3: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localft.wrK = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(58886);
        return 0;
      case 4: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localft.wrL = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(58886);
        return 0;
      case 5: 
        localft.wrM = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(58886);
        return 0;
      case 6: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localft.wrN = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(58886);
        return 0;
      case 7: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cvh();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cvh)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localft.wrO = ((cvh)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(58886);
        return 0;
      case 8: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new czh();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((czh)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localft.wrP = ((czh)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(58886);
        return 0;
      case 9: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localft.wrQ = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(58886);
        return 0;
      case 10: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localft.wrR = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(58886);
        return 0;
      case 11: 
        localft.wrS = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(58886);
        return 0;
      case 12: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localft.wrT = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(58886);
        return 0;
      case 14: 
        localft.wrU = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(58886);
        return 0;
      case 15: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cco();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cco)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localft.wrV = ((cco)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(58886);
        return 0;
      case 16: 
        localft.wrW = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(58886);
        return 0;
      case 17: 
        localft.wrX = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(58886);
        return 0;
      case 18: 
        localft.wrY = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(58886);
        return 0;
      case 19: 
        localft.wrZ = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(58886);
        return 0;
      case 20: 
        localft.wmA = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(58886);
        return 0;
      case 21: 
        localft.wsa = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(58886);
        return 0;
      case 22: 
        localft.wsb = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(58886);
        return 0;
      case 23: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localft.wsc = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(58886);
        return 0;
      }
      paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new SKBuiltinBuffer_t();
        localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
        localft.wsd = ((SKBuiltinBuffer_t)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(58886);
      return 0;
    }
    AppMethodBeat.o(58886);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ft
 * JD-Core Version:    0.7.0.1
 */