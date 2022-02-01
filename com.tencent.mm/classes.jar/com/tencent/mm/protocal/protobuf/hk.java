package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class hk
  extends com.tencent.mm.bw.a
{
  public String KEj;
  public aif KKX;
  public SKBuiltinBuffer_t KKY;
  public SKBuiltinBuffer_t KKZ;
  public int KLa;
  public SKBuiltinBuffer_t KLb;
  public ews KLc;
  public fcb KLd;
  public SKBuiltinBuffer_t KLe;
  public SKBuiltinBuffer_t KLf;
  public String KLg;
  public SKBuiltinBuffer_t KLh;
  public String KLi;
  public dyh KLj;
  public String KLk;
  public int KLl;
  public int KLm;
  public int KLn;
  public int KLo;
  public int KLp;
  public SKBuiltinBuffer_t KLq;
  public SKBuiltinBuffer_t KLr;
  public int KLs;
  public int rBx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133145);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KKX == null)
      {
        paramVarArgs = new b("Not all required fields were included: SvrPubECDHKey");
        AppMethodBeat.o(133145);
        throw paramVarArgs;
      }
      if (this.KKY == null)
      {
        paramVarArgs = new b("Not all required fields were included: SessionKey");
        AppMethodBeat.o(133145);
        throw paramVarArgs;
      }
      if (this.KKZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: AutoAuthKey");
        AppMethodBeat.o(133145);
        throw paramVarArgs;
      }
      if (this.KLq == null)
      {
        paramVarArgs = new b("Not all required fields were included: ClientSessionKey");
        AppMethodBeat.o(133145);
        throw paramVarArgs;
      }
      if (this.KLr == null)
      {
        paramVarArgs = new b("Not all required fields were included: ServerSessionKey");
        AppMethodBeat.o(133145);
        throw paramVarArgs;
      }
      paramVarArgs.aM(1, this.rBx);
      if (this.KKX != null)
      {
        paramVarArgs.ni(2, this.KKX.computeSize());
        this.KKX.writeFields(paramVarArgs);
      }
      if (this.KKY != null)
      {
        paramVarArgs.ni(3, this.KKY.computeSize());
        this.KKY.writeFields(paramVarArgs);
      }
      if (this.KKZ != null)
      {
        paramVarArgs.ni(4, this.KKZ.computeSize());
        this.KKZ.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(5, this.KLa);
      if (this.KLb != null)
      {
        paramVarArgs.ni(6, this.KLb.computeSize());
        this.KLb.writeFields(paramVarArgs);
      }
      if (this.KLc != null)
      {
        paramVarArgs.ni(7, this.KLc.computeSize());
        this.KLc.writeFields(paramVarArgs);
      }
      if (this.KLd != null)
      {
        paramVarArgs.ni(8, this.KLd.computeSize());
        this.KLd.writeFields(paramVarArgs);
      }
      if (this.KLe != null)
      {
        paramVarArgs.ni(9, this.KLe.computeSize());
        this.KLe.writeFields(paramVarArgs);
      }
      if (this.KLf != null)
      {
        paramVarArgs.ni(10, this.KLf.computeSize());
        this.KLf.writeFields(paramVarArgs);
      }
      if (this.KLg != null) {
        paramVarArgs.e(11, this.KLg);
      }
      if (this.KLh != null)
      {
        paramVarArgs.ni(12, this.KLh.computeSize());
        this.KLh.writeFields(paramVarArgs);
      }
      if (this.KLi != null) {
        paramVarArgs.e(14, this.KLi);
      }
      if (this.KLj != null)
      {
        paramVarArgs.ni(15, this.KLj.computeSize());
        this.KLj.writeFields(paramVarArgs);
      }
      if (this.KLk != null) {
        paramVarArgs.e(16, this.KLk);
      }
      paramVarArgs.aM(17, this.KLl);
      paramVarArgs.aM(18, this.KLm);
      paramVarArgs.aM(19, this.KLn);
      if (this.KEj != null) {
        paramVarArgs.e(20, this.KEj);
      }
      paramVarArgs.aM(21, this.KLo);
      paramVarArgs.aM(22, this.KLp);
      if (this.KLq != null)
      {
        paramVarArgs.ni(23, this.KLq.computeSize());
        this.KLq.writeFields(paramVarArgs);
      }
      if (this.KLr != null)
      {
        paramVarArgs.ni(24, this.KLr.computeSize());
        this.KLr.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(25, this.KLs);
      AppMethodBeat.o(133145);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.rBx) + 0;
      paramInt = i;
      if (this.KKX != null) {
        paramInt = i + g.a.a.a.nh(2, this.KKX.computeSize());
      }
      i = paramInt;
      if (this.KKY != null) {
        i = paramInt + g.a.a.a.nh(3, this.KKY.computeSize());
      }
      paramInt = i;
      if (this.KKZ != null) {
        paramInt = i + g.a.a.a.nh(4, this.KKZ.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.KLa);
      paramInt = i;
      if (this.KLb != null) {
        paramInt = i + g.a.a.a.nh(6, this.KLb.computeSize());
      }
      i = paramInt;
      if (this.KLc != null) {
        i = paramInt + g.a.a.a.nh(7, this.KLc.computeSize());
      }
      paramInt = i;
      if (this.KLd != null) {
        paramInt = i + g.a.a.a.nh(8, this.KLd.computeSize());
      }
      i = paramInt;
      if (this.KLe != null) {
        i = paramInt + g.a.a.a.nh(9, this.KLe.computeSize());
      }
      paramInt = i;
      if (this.KLf != null) {
        paramInt = i + g.a.a.a.nh(10, this.KLf.computeSize());
      }
      i = paramInt;
      if (this.KLg != null) {
        i = paramInt + g.a.a.b.b.a.f(11, this.KLg);
      }
      paramInt = i;
      if (this.KLh != null) {
        paramInt = i + g.a.a.a.nh(12, this.KLh.computeSize());
      }
      i = paramInt;
      if (this.KLi != null) {
        i = paramInt + g.a.a.b.b.a.f(14, this.KLi);
      }
      paramInt = i;
      if (this.KLj != null) {
        paramInt = i + g.a.a.a.nh(15, this.KLj.computeSize());
      }
      i = paramInt;
      if (this.KLk != null) {
        i = paramInt + g.a.a.b.b.a.f(16, this.KLk);
      }
      i = i + g.a.a.b.b.a.bu(17, this.KLl) + g.a.a.b.b.a.bu(18, this.KLm) + g.a.a.b.b.a.bu(19, this.KLn);
      paramInt = i;
      if (this.KEj != null) {
        paramInt = i + g.a.a.b.b.a.f(20, this.KEj);
      }
      i = paramInt + g.a.a.b.b.a.bu(21, this.KLo) + g.a.a.b.b.a.bu(22, this.KLp);
      paramInt = i;
      if (this.KLq != null) {
        paramInt = i + g.a.a.a.nh(23, this.KLq.computeSize());
      }
      i = paramInt;
      if (this.KLr != null) {
        i = paramInt + g.a.a.a.nh(24, this.KLr.computeSize());
      }
      paramInt = g.a.a.b.b.a.bu(25, this.KLs);
      AppMethodBeat.o(133145);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      if (this.KKX == null)
      {
        paramVarArgs = new b("Not all required fields were included: SvrPubECDHKey");
        AppMethodBeat.o(133145);
        throw paramVarArgs;
      }
      if (this.KKY == null)
      {
        paramVarArgs = new b("Not all required fields were included: SessionKey");
        AppMethodBeat.o(133145);
        throw paramVarArgs;
      }
      if (this.KKZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: AutoAuthKey");
        AppMethodBeat.o(133145);
        throw paramVarArgs;
      }
      if (this.KLq == null)
      {
        paramVarArgs = new b("Not all required fields were included: ClientSessionKey");
        AppMethodBeat.o(133145);
        throw paramVarArgs;
      }
      if (this.KLr == null)
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
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      hk localhk = (hk)paramVarArgs[1];
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
        localhk.rBx = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(133145);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aif();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aif)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localhk.KKX = ((aif)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133145);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localhk.KKY = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133145);
        return 0;
      case 4: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localhk.KKZ = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133145);
        return 0;
      case 5: 
        localhk.KLa = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(133145);
        return 0;
      case 6: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localhk.KLb = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133145);
        return 0;
      case 7: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ews();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ews)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localhk.KLc = ((ews)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133145);
        return 0;
      case 8: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new fcb();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((fcb)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localhk.KLd = ((fcb)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133145);
        return 0;
      case 9: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localhk.KLe = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133145);
        return 0;
      case 10: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localhk.KLf = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133145);
        return 0;
      case 11: 
        localhk.KLg = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(133145);
        return 0;
      case 12: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localhk.KLh = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133145);
        return 0;
      case 14: 
        localhk.KLi = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(133145);
        return 0;
      case 15: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dyh();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dyh)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localhk.KLj = ((dyh)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133145);
        return 0;
      case 16: 
        localhk.KLk = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(133145);
        return 0;
      case 17: 
        localhk.KLl = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(133145);
        return 0;
      case 18: 
        localhk.KLm = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(133145);
        return 0;
      case 19: 
        localhk.KLn = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(133145);
        return 0;
      case 20: 
        localhk.KEj = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(133145);
        return 0;
      case 21: 
        localhk.KLo = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(133145);
        return 0;
      case 22: 
        localhk.KLp = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(133145);
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
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localhk.KLq = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133145);
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
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localhk.KLr = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133145);
        return 0;
      }
      localhk.KLs = ((g.a.a.a.a)localObject1).UbS.zi();
      AppMethodBeat.o(133145);
      return 0;
    }
    AppMethodBeat.o(133145);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.hk
 * JD-Core Version:    0.7.0.1
 */