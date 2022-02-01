package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class is
  extends com.tencent.mm.bw.a
{
  public int Brl;
  public long Brn;
  public dqi KHl;
  public dqi KHm;
  public dqi KHn;
  public String KHq;
  public String KIz;
  public int KMN;
  public int KMO;
  public int KMP;
  public LinkedList<dqi> KMQ;
  public LinkedList<dqj> KMR;
  public SKBuiltinBuffer_t KMS;
  public int KMT;
  public int KMU;
  public int KMV;
  public long KMW;
  public int KMX;
  public int oUv;
  
  public is()
  {
    AppMethodBeat.i(32137);
    this.KMQ = new LinkedList();
    this.KMR = new LinkedList();
    AppMethodBeat.o(32137);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32138);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KHl == null)
      {
        paramVarArgs = new b("Not all required fields were included: FromUserName");
        AppMethodBeat.o(32138);
        throw paramVarArgs;
      }
      if (this.KHm == null)
      {
        paramVarArgs = new b("Not all required fields were included: ToUserName");
        AppMethodBeat.o(32138);
        throw paramVarArgs;
      }
      if (this.KHn == null)
      {
        paramVarArgs = new b("Not all required fields were included: Content");
        AppMethodBeat.o(32138);
        throw paramVarArgs;
      }
      paramVarArgs.aM(1, this.oUv);
      if (this.KIz != null) {
        paramVarArgs.e(2, this.KIz);
      }
      if (this.KHl != null)
      {
        paramVarArgs.ni(3, this.KHl.computeSize());
        this.KHl.writeFields(paramVarArgs);
      }
      if (this.KHm != null)
      {
        paramVarArgs.ni(4, this.KHm.computeSize());
        this.KHm.writeFields(paramVarArgs);
      }
      if (this.KHn != null)
      {
        paramVarArgs.ni(5, this.KHn.computeSize());
        this.KHn.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(6, this.KMN);
      paramVarArgs.aM(7, this.KMO);
      if (this.KHq != null) {
        paramVarArgs.e(8, this.KHq);
      }
      paramVarArgs.aM(9, this.Brl);
      paramVarArgs.aM(10, this.KMP);
      paramVarArgs.e(11, 8, this.KMQ);
      paramVarArgs.e(12, 8, this.KMR);
      if (this.KMS != null)
      {
        paramVarArgs.ni(13, this.KMS.computeSize());
        this.KMS.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(14, this.KMT);
      paramVarArgs.aM(15, this.KMU);
      paramVarArgs.bb(16, this.Brn);
      paramVarArgs.aM(17, this.KMV);
      paramVarArgs.bb(18, this.KMW);
      paramVarArgs.aM(19, this.KMX);
      AppMethodBeat.o(32138);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.oUv) + 0;
      paramInt = i;
      if (this.KIz != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.KIz);
      }
      i = paramInt;
      if (this.KHl != null) {
        i = paramInt + g.a.a.a.nh(3, this.KHl.computeSize());
      }
      paramInt = i;
      if (this.KHm != null) {
        paramInt = i + g.a.a.a.nh(4, this.KHm.computeSize());
      }
      i = paramInt;
      if (this.KHn != null) {
        i = paramInt + g.a.a.a.nh(5, this.KHn.computeSize());
      }
      i = i + g.a.a.b.b.a.bu(6, this.KMN) + g.a.a.b.b.a.bu(7, this.KMO);
      paramInt = i;
      if (this.KHq != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.KHq);
      }
      i = paramInt + g.a.a.b.b.a.bu(9, this.Brl) + g.a.a.b.b.a.bu(10, this.KMP) + g.a.a.a.c(11, 8, this.KMQ) + g.a.a.a.c(12, 8, this.KMR);
      paramInt = i;
      if (this.KMS != null) {
        paramInt = i + g.a.a.a.nh(13, this.KMS.computeSize());
      }
      i = g.a.a.b.b.a.bu(14, this.KMT);
      int j = g.a.a.b.b.a.bu(15, this.KMU);
      int k = g.a.a.b.b.a.r(16, this.Brn);
      int m = g.a.a.b.b.a.bu(17, this.KMV);
      int n = g.a.a.b.b.a.r(18, this.KMW);
      int i1 = g.a.a.b.b.a.bu(19, this.KMX);
      AppMethodBeat.o(32138);
      return paramInt + i + j + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.KMQ.clear();
      this.KMR.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      if (this.KHl == null)
      {
        paramVarArgs = new b("Not all required fields were included: FromUserName");
        AppMethodBeat.o(32138);
        throw paramVarArgs;
      }
      if (this.KHm == null)
      {
        paramVarArgs = new b("Not all required fields were included: ToUserName");
        AppMethodBeat.o(32138);
        throw paramVarArgs;
      }
      if (this.KHn == null)
      {
        paramVarArgs = new b("Not all required fields were included: Content");
        AppMethodBeat.o(32138);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32138);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      is localis = (is)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32138);
        return -1;
      case 1: 
        localis.oUv = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(32138);
        return 0;
      case 2: 
        localis.KIz = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(32138);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dqi();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localis.KHl = ((dqi)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32138);
        return 0;
      case 4: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dqi();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localis.KHm = ((dqi)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32138);
        return 0;
      case 5: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dqi();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localis.KHn = ((dqi)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32138);
        return 0;
      case 6: 
        localis.KMN = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(32138);
        return 0;
      case 7: 
        localis.KMO = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(32138);
        return 0;
      case 8: 
        localis.KHq = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(32138);
        return 0;
      case 9: 
        localis.Brl = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(32138);
        return 0;
      case 10: 
        localis.KMP = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(32138);
        return 0;
      case 11: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dqi();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localis.KMQ.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32138);
        return 0;
      case 12: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dqj();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dqj)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localis.KMR.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32138);
        return 0;
      case 13: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localis.KMS = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32138);
        return 0;
      case 14: 
        localis.KMT = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(32138);
        return 0;
      case 15: 
        localis.KMU = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(32138);
        return 0;
      case 16: 
        localis.Brn = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(32138);
        return 0;
      case 17: 
        localis.KMV = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(32138);
        return 0;
      case 18: 
        localis.KMW = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(32138);
        return 0;
      }
      localis.KMX = ((g.a.a.a.a)localObject1).UbS.zi();
      AppMethodBeat.o(32138);
      return 0;
    }
    AppMethodBeat.o(32138);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.is
 * JD-Core Version:    0.7.0.1
 */