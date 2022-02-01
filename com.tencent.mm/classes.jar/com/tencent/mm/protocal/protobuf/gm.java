package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class gm
  extends com.tencent.mm.bx.a
{
  public acp CBa;
  public SKBuiltinBuffer_t CBb;
  public SKBuiltinBuffer_t CBc;
  public int CBd;
  public SKBuiltinBuffer_t CBe;
  public dpi CBf;
  public dtx CBg;
  public SKBuiltinBuffer_t CBh;
  public SKBuiltinBuffer_t CBi;
  public String CBj;
  public SKBuiltinBuffer_t CBk;
  public String CBl;
  public ctj CBm;
  public String CBn;
  public int CBo;
  public int CBp;
  public int CBq;
  public int CBr;
  public int CBs;
  public SKBuiltinBuffer_t CBt;
  public SKBuiltinBuffer_t CBu;
  public int CBv;
  public String CuP;
  public int oXh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133145);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CBa == null)
      {
        paramVarArgs = new b("Not all required fields were included: SvrPubECDHKey");
        AppMethodBeat.o(133145);
        throw paramVarArgs;
      }
      if (this.CBb == null)
      {
        paramVarArgs = new b("Not all required fields were included: SessionKey");
        AppMethodBeat.o(133145);
        throw paramVarArgs;
      }
      if (this.CBc == null)
      {
        paramVarArgs = new b("Not all required fields were included: AutoAuthKey");
        AppMethodBeat.o(133145);
        throw paramVarArgs;
      }
      if (this.CBt == null)
      {
        paramVarArgs = new b("Not all required fields were included: ClientSessionKey");
        AppMethodBeat.o(133145);
        throw paramVarArgs;
      }
      if (this.CBu == null)
      {
        paramVarArgs = new b("Not all required fields were included: ServerSessionKey");
        AppMethodBeat.o(133145);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.oXh);
      if (this.CBa != null)
      {
        paramVarArgs.kX(2, this.CBa.computeSize());
        this.CBa.writeFields(paramVarArgs);
      }
      if (this.CBb != null)
      {
        paramVarArgs.kX(3, this.CBb.computeSize());
        this.CBb.writeFields(paramVarArgs);
      }
      if (this.CBc != null)
      {
        paramVarArgs.kX(4, this.CBc.computeSize());
        this.CBc.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(5, this.CBd);
      if (this.CBe != null)
      {
        paramVarArgs.kX(6, this.CBe.computeSize());
        this.CBe.writeFields(paramVarArgs);
      }
      if (this.CBf != null)
      {
        paramVarArgs.kX(7, this.CBf.computeSize());
        this.CBf.writeFields(paramVarArgs);
      }
      if (this.CBg != null)
      {
        paramVarArgs.kX(8, this.CBg.computeSize());
        this.CBg.writeFields(paramVarArgs);
      }
      if (this.CBh != null)
      {
        paramVarArgs.kX(9, this.CBh.computeSize());
        this.CBh.writeFields(paramVarArgs);
      }
      if (this.CBi != null)
      {
        paramVarArgs.kX(10, this.CBi.computeSize());
        this.CBi.writeFields(paramVarArgs);
      }
      if (this.CBj != null) {
        paramVarArgs.d(11, this.CBj);
      }
      if (this.CBk != null)
      {
        paramVarArgs.kX(12, this.CBk.computeSize());
        this.CBk.writeFields(paramVarArgs);
      }
      if (this.CBl != null) {
        paramVarArgs.d(14, this.CBl);
      }
      if (this.CBm != null)
      {
        paramVarArgs.kX(15, this.CBm.computeSize());
        this.CBm.writeFields(paramVarArgs);
      }
      if (this.CBn != null) {
        paramVarArgs.d(16, this.CBn);
      }
      paramVarArgs.aR(17, this.CBo);
      paramVarArgs.aR(18, this.CBp);
      paramVarArgs.aR(19, this.CBq);
      if (this.CuP != null) {
        paramVarArgs.d(20, this.CuP);
      }
      paramVarArgs.aR(21, this.CBr);
      paramVarArgs.aR(22, this.CBs);
      if (this.CBt != null)
      {
        paramVarArgs.kX(23, this.CBt.computeSize());
        this.CBt.writeFields(paramVarArgs);
      }
      if (this.CBu != null)
      {
        paramVarArgs.kX(24, this.CBu.computeSize());
        this.CBu.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(25, this.CBv);
      AppMethodBeat.o(133145);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.oXh) + 0;
      paramInt = i;
      if (this.CBa != null) {
        paramInt = i + f.a.a.a.kW(2, this.CBa.computeSize());
      }
      i = paramInt;
      if (this.CBb != null) {
        i = paramInt + f.a.a.a.kW(3, this.CBb.computeSize());
      }
      paramInt = i;
      if (this.CBc != null) {
        paramInt = i + f.a.a.a.kW(4, this.CBc.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bA(5, this.CBd);
      paramInt = i;
      if (this.CBe != null) {
        paramInt = i + f.a.a.a.kW(6, this.CBe.computeSize());
      }
      i = paramInt;
      if (this.CBf != null) {
        i = paramInt + f.a.a.a.kW(7, this.CBf.computeSize());
      }
      paramInt = i;
      if (this.CBg != null) {
        paramInt = i + f.a.a.a.kW(8, this.CBg.computeSize());
      }
      i = paramInt;
      if (this.CBh != null) {
        i = paramInt + f.a.a.a.kW(9, this.CBh.computeSize());
      }
      paramInt = i;
      if (this.CBi != null) {
        paramInt = i + f.a.a.a.kW(10, this.CBi.computeSize());
      }
      i = paramInt;
      if (this.CBj != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.CBj);
      }
      paramInt = i;
      if (this.CBk != null) {
        paramInt = i + f.a.a.a.kW(12, this.CBk.computeSize());
      }
      i = paramInt;
      if (this.CBl != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.CBl);
      }
      paramInt = i;
      if (this.CBm != null) {
        paramInt = i + f.a.a.a.kW(15, this.CBm.computeSize());
      }
      i = paramInt;
      if (this.CBn != null) {
        i = paramInt + f.a.a.b.b.a.e(16, this.CBn);
      }
      i = i + f.a.a.b.b.a.bA(17, this.CBo) + f.a.a.b.b.a.bA(18, this.CBp) + f.a.a.b.b.a.bA(19, this.CBq);
      paramInt = i;
      if (this.CuP != null) {
        paramInt = i + f.a.a.b.b.a.e(20, this.CuP);
      }
      i = paramInt + f.a.a.b.b.a.bA(21, this.CBr) + f.a.a.b.b.a.bA(22, this.CBs);
      paramInt = i;
      if (this.CBt != null) {
        paramInt = i + f.a.a.a.kW(23, this.CBt.computeSize());
      }
      i = paramInt;
      if (this.CBu != null) {
        i = paramInt + f.a.a.a.kW(24, this.CBu.computeSize());
      }
      paramInt = f.a.a.b.b.a.bA(25, this.CBv);
      AppMethodBeat.o(133145);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      if (this.CBa == null)
      {
        paramVarArgs = new b("Not all required fields were included: SvrPubECDHKey");
        AppMethodBeat.o(133145);
        throw paramVarArgs;
      }
      if (this.CBb == null)
      {
        paramVarArgs = new b("Not all required fields were included: SessionKey");
        AppMethodBeat.o(133145);
        throw paramVarArgs;
      }
      if (this.CBc == null)
      {
        paramVarArgs = new b("Not all required fields were included: AutoAuthKey");
        AppMethodBeat.o(133145);
        throw paramVarArgs;
      }
      if (this.CBt == null)
      {
        paramVarArgs = new b("Not all required fields were included: ClientSessionKey");
        AppMethodBeat.o(133145);
        throw paramVarArgs;
      }
      if (this.CBu == null)
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
      gm localgm = (gm)paramVarArgs[1];
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
        localgm.oXh = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(133145);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new acp();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((acp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localgm.CBa = ((acp)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133145);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localgm.CBb = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133145);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localgm.CBc = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133145);
        return 0;
      case 5: 
        localgm.CBd = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(133145);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localgm.CBe = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133145);
        return 0;
      case 7: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dpi();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dpi)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localgm.CBf = ((dpi)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133145);
        return 0;
      case 8: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dtx();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dtx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localgm.CBg = ((dtx)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133145);
        return 0;
      case 9: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localgm.CBh = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133145);
        return 0;
      case 10: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localgm.CBi = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133145);
        return 0;
      case 11: 
        localgm.CBj = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(133145);
        return 0;
      case 12: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localgm.CBk = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133145);
        return 0;
      case 14: 
        localgm.CBl = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(133145);
        return 0;
      case 15: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ctj();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ctj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localgm.CBm = ((ctj)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133145);
        return 0;
      case 16: 
        localgm.CBn = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(133145);
        return 0;
      case 17: 
        localgm.CBo = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(133145);
        return 0;
      case 18: 
        localgm.CBp = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(133145);
        return 0;
      case 19: 
        localgm.CBq = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(133145);
        return 0;
      case 20: 
        localgm.CuP = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(133145);
        return 0;
      case 21: 
        localgm.CBr = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(133145);
        return 0;
      case 22: 
        localgm.CBs = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(133145);
        return 0;
      case 23: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localgm.CBt = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133145);
        return 0;
      case 24: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localgm.CBu = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133145);
        return 0;
      }
      localgm.CBv = ((f.a.a.a.a)localObject1).KhF.xS();
      AppMethodBeat.o(133145);
      return 0;
    }
    AppMethodBeat.o(133145);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gm
 * JD-Core Version:    0.7.0.1
 */