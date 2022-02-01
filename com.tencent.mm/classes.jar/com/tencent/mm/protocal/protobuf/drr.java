package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class drr
  extends com.tencent.mm.bw.a
{
  public SKBuiltinBuffer_t KHp;
  public String LRO;
  public String Lir;
  public String Lis;
  public dqi LpA;
  public dqi LpB;
  public dqi Lqk;
  public int MUk;
  public dqi Mjj;
  public int MmK;
  public String MmL;
  public String MmM;
  public String MmN;
  public int MmO;
  public ebj MmQ;
  public aeq MmR;
  public int kdY;
  public String kdZ;
  public String kea;
  public String keb;
  public int kec;
  public String ked;
  public int kee;
  public int kef;
  public String keg;
  public String keh;
  public String kei;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152681);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Lqk == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(152681);
        throw paramVarArgs;
      }
      if (this.Mjj == null)
      {
        paramVarArgs = new b("Not all required fields were included: NickName");
        AppMethodBeat.o(152681);
        throw paramVarArgs;
      }
      if (this.LpA == null)
      {
        paramVarArgs = new b("Not all required fields were included: PYInitial");
        AppMethodBeat.o(152681);
        throw paramVarArgs;
      }
      if (this.LpB == null)
      {
        paramVarArgs = new b("Not all required fields were included: QuanPin");
        AppMethodBeat.o(152681);
        throw paramVarArgs;
      }
      if (this.KHp == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgBuf");
        AppMethodBeat.o(152681);
        throw paramVarArgs;
      }
      if (this.Lqk != null)
      {
        paramVarArgs.ni(1, this.Lqk.computeSize());
        this.Lqk.writeFields(paramVarArgs);
      }
      if (this.Mjj != null)
      {
        paramVarArgs.ni(2, this.Mjj.computeSize());
        this.Mjj.writeFields(paramVarArgs);
      }
      if (this.LpA != null)
      {
        paramVarArgs.ni(3, this.LpA.computeSize());
        this.LpA.writeFields(paramVarArgs);
      }
      if (this.LpB != null)
      {
        paramVarArgs.ni(4, this.LpB.computeSize());
        this.LpB.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(5, this.kdY);
      if (this.KHp != null)
      {
        paramVarArgs.ni(6, this.KHp.computeSize());
        this.KHp.writeFields(paramVarArgs);
      }
      if (this.kdZ != null) {
        paramVarArgs.e(7, this.kdZ);
      }
      if (this.kea != null) {
        paramVarArgs.e(8, this.kea);
      }
      if (this.keb != null) {
        paramVarArgs.e(9, this.keb);
      }
      paramVarArgs.aM(10, this.kec);
      paramVarArgs.aM(11, this.MmK);
      if (this.MmL != null) {
        paramVarArgs.e(12, this.MmL);
      }
      if (this.MmM != null) {
        paramVarArgs.e(13, this.MmM);
      }
      if (this.ked != null) {
        paramVarArgs.e(14, this.ked);
      }
      if (this.MmN != null) {
        paramVarArgs.e(15, this.MmN);
      }
      paramVarArgs.aM(16, this.MmO);
      paramVarArgs.aM(17, this.kef);
      paramVarArgs.aM(18, this.kee);
      if (this.keg != null) {
        paramVarArgs.e(19, this.keg);
      }
      if (this.MmQ != null)
      {
        paramVarArgs.ni(20, this.MmQ.computeSize());
        this.MmQ.writeFields(paramVarArgs);
      }
      if (this.keh != null) {
        paramVarArgs.e(21, this.keh);
      }
      if (this.kei != null) {
        paramVarArgs.e(22, this.kei);
      }
      if (this.MmR != null)
      {
        paramVarArgs.ni(23, this.MmR.computeSize());
        this.MmR.writeFields(paramVarArgs);
      }
      if (this.Lir != null) {
        paramVarArgs.e(24, this.Lir);
      }
      if (this.Lis != null) {
        paramVarArgs.e(25, this.Lis);
      }
      if (this.LRO != null) {
        paramVarArgs.e(26, this.LRO);
      }
      paramVarArgs.aM(27, this.MUk);
      AppMethodBeat.o(152681);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Lqk == null) {
        break label2602;
      }
    }
    label2602:
    for (int i = g.a.a.a.nh(1, this.Lqk.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Mjj != null) {
        paramInt = i + g.a.a.a.nh(2, this.Mjj.computeSize());
      }
      i = paramInt;
      if (this.LpA != null) {
        i = paramInt + g.a.a.a.nh(3, this.LpA.computeSize());
      }
      paramInt = i;
      if (this.LpB != null) {
        paramInt = i + g.a.a.a.nh(4, this.LpB.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.kdY);
      paramInt = i;
      if (this.KHp != null) {
        paramInt = i + g.a.a.a.nh(6, this.KHp.computeSize());
      }
      i = paramInt;
      if (this.kdZ != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.kdZ);
      }
      paramInt = i;
      if (this.kea != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.kea);
      }
      i = paramInt;
      if (this.keb != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.keb);
      }
      i = i + g.a.a.b.b.a.bu(10, this.kec) + g.a.a.b.b.a.bu(11, this.MmK);
      paramInt = i;
      if (this.MmL != null) {
        paramInt = i + g.a.a.b.b.a.f(12, this.MmL);
      }
      i = paramInt;
      if (this.MmM != null) {
        i = paramInt + g.a.a.b.b.a.f(13, this.MmM);
      }
      paramInt = i;
      if (this.ked != null) {
        paramInt = i + g.a.a.b.b.a.f(14, this.ked);
      }
      i = paramInt;
      if (this.MmN != null) {
        i = paramInt + g.a.a.b.b.a.f(15, this.MmN);
      }
      i = i + g.a.a.b.b.a.bu(16, this.MmO) + g.a.a.b.b.a.bu(17, this.kef) + g.a.a.b.b.a.bu(18, this.kee);
      paramInt = i;
      if (this.keg != null) {
        paramInt = i + g.a.a.b.b.a.f(19, this.keg);
      }
      i = paramInt;
      if (this.MmQ != null) {
        i = paramInt + g.a.a.a.nh(20, this.MmQ.computeSize());
      }
      paramInt = i;
      if (this.keh != null) {
        paramInt = i + g.a.a.b.b.a.f(21, this.keh);
      }
      i = paramInt;
      if (this.kei != null) {
        i = paramInt + g.a.a.b.b.a.f(22, this.kei);
      }
      paramInt = i;
      if (this.MmR != null) {
        paramInt = i + g.a.a.a.nh(23, this.MmR.computeSize());
      }
      i = paramInt;
      if (this.Lir != null) {
        i = paramInt + g.a.a.b.b.a.f(24, this.Lir);
      }
      paramInt = i;
      if (this.Lis != null) {
        paramInt = i + g.a.a.b.b.a.f(25, this.Lis);
      }
      i = paramInt;
      if (this.LRO != null) {
        i = paramInt + g.a.a.b.b.a.f(26, this.LRO);
      }
      paramInt = g.a.a.b.b.a.bu(27, this.MUk);
      AppMethodBeat.o(152681);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.Lqk == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserName");
          AppMethodBeat.o(152681);
          throw paramVarArgs;
        }
        if (this.Mjj == null)
        {
          paramVarArgs = new b("Not all required fields were included: NickName");
          AppMethodBeat.o(152681);
          throw paramVarArgs;
        }
        if (this.LpA == null)
        {
          paramVarArgs = new b("Not all required fields were included: PYInitial");
          AppMethodBeat.o(152681);
          throw paramVarArgs;
        }
        if (this.LpB == null)
        {
          paramVarArgs = new b("Not all required fields were included: QuanPin");
          AppMethodBeat.o(152681);
          throw paramVarArgs;
        }
        if (this.KHp == null)
        {
          paramVarArgs = new b("Not all required fields were included: ImgBuf");
          AppMethodBeat.o(152681);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152681);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        drr localdrr = (drr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152681);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdrr.Lqk = ((dqi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152681);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdrr.Mjj = ((dqi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152681);
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
            localdrr.LpA = ((dqi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152681);
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
            localdrr.LpB = ((dqi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152681);
          return 0;
        case 5: 
          localdrr.kdY = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152681);
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
            localdrr.KHp = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152681);
          return 0;
        case 7: 
          localdrr.kdZ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152681);
          return 0;
        case 8: 
          localdrr.kea = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152681);
          return 0;
        case 9: 
          localdrr.keb = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152681);
          return 0;
        case 10: 
          localdrr.kec = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152681);
          return 0;
        case 11: 
          localdrr.MmK = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152681);
          return 0;
        case 12: 
          localdrr.MmL = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152681);
          return 0;
        case 13: 
          localdrr.MmM = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152681);
          return 0;
        case 14: 
          localdrr.ked = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152681);
          return 0;
        case 15: 
          localdrr.MmN = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152681);
          return 0;
        case 16: 
          localdrr.MmO = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152681);
          return 0;
        case 17: 
          localdrr.kef = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152681);
          return 0;
        case 18: 
          localdrr.kee = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152681);
          return 0;
        case 19: 
          localdrr.keg = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152681);
          return 0;
        case 20: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ebj();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ebj)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdrr.MmQ = ((ebj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152681);
          return 0;
        case 21: 
          localdrr.keh = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152681);
          return 0;
        case 22: 
          localdrr.kei = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152681);
          return 0;
        case 23: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aeq();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aeq)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdrr.MmR = ((aeq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152681);
          return 0;
        case 24: 
          localdrr.Lir = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152681);
          return 0;
        case 25: 
          localdrr.Lis = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152681);
          return 0;
        case 26: 
          localdrr.LRO = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152681);
          return 0;
        }
        localdrr.MUk = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(152681);
        return 0;
      }
      AppMethodBeat.o(152681);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.drr
 * JD-Core Version:    0.7.0.1
 */