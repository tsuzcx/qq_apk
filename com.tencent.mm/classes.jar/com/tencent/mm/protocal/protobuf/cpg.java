package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class cpg
  extends com.tencent.mm.bw.a
{
  public SKBuiltinBuffer_t KHp;
  public String Lir;
  public String Lis;
  public int LoM;
  public dqi LpA;
  public dqi LpB;
  public dqi Lqk;
  public String MbK;
  public dqi Mjj;
  public int MmK;
  public String MmL;
  public String MmM;
  public String MmN;
  public int MmO;
  public ebj MmQ;
  public aeq MmR;
  public dqi MuI;
  public dqi MuJ;
  public dqi MuK;
  public int Mvd;
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
    AppMethodBeat.i(101824);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Lqk == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(101824);
        throw paramVarArgs;
      }
      if (this.Mjj == null)
      {
        paramVarArgs = new b("Not all required fields were included: NickName");
        AppMethodBeat.o(101824);
        throw paramVarArgs;
      }
      if (this.LpA == null)
      {
        paramVarArgs = new b("Not all required fields were included: PYInitial");
        AppMethodBeat.o(101824);
        throw paramVarArgs;
      }
      if (this.LpB == null)
      {
        paramVarArgs = new b("Not all required fields were included: QuanPin");
        AppMethodBeat.o(101824);
        throw paramVarArgs;
      }
      if (this.KHp == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgBuf");
        AppMethodBeat.o(101824);
        throw paramVarArgs;
      }
      if (this.MuI == null)
      {
        paramVarArgs = new b("Not all required fields were included: Remark");
        AppMethodBeat.o(101824);
        throw paramVarArgs;
      }
      if (this.MuJ == null)
      {
        paramVarArgs = new b("Not all required fields were included: RemarkPYInitial");
        AppMethodBeat.o(101824);
        throw paramVarArgs;
      }
      if (this.MuK == null)
      {
        paramVarArgs = new b("Not all required fields were included: RemarkQuanPin");
        AppMethodBeat.o(101824);
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
      paramVarArgs.aM(7, this.Mvd);
      if (this.MuI != null)
      {
        paramVarArgs.ni(8, this.MuI.computeSize());
        this.MuI.writeFields(paramVarArgs);
      }
      if (this.MuJ != null)
      {
        paramVarArgs.ni(9, this.MuJ.computeSize());
        this.MuJ.writeFields(paramVarArgs);
      }
      if (this.MuK != null)
      {
        paramVarArgs.ni(10, this.MuK.computeSize());
        this.MuK.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(11, this.LoM);
      if (this.kdZ != null) {
        paramVarArgs.e(12, this.kdZ);
      }
      if (this.kea != null) {
        paramVarArgs.e(13, this.kea);
      }
      if (this.keb != null) {
        paramVarArgs.e(14, this.keb);
      }
      paramVarArgs.aM(15, this.kec);
      paramVarArgs.aM(16, this.MmK);
      if (this.MmL != null) {
        paramVarArgs.e(17, this.MmL);
      }
      if (this.MmM != null) {
        paramVarArgs.e(18, this.MmM);
      }
      if (this.MbK != null) {
        paramVarArgs.e(19, this.MbK);
      }
      if (this.MmN != null) {
        paramVarArgs.e(20, this.MmN);
      }
      paramVarArgs.aM(21, this.MmO);
      paramVarArgs.aM(22, this.kef);
      paramVarArgs.aM(23, this.kee);
      if (this.keg != null) {
        paramVarArgs.e(24, this.keg);
      }
      if (this.ked != null) {
        paramVarArgs.e(25, this.ked);
      }
      if (this.MmQ != null)
      {
        paramVarArgs.ni(26, this.MmQ.computeSize());
        this.MmQ.writeFields(paramVarArgs);
      }
      if (this.keh != null) {
        paramVarArgs.e(27, this.keh);
      }
      if (this.Lir != null) {
        paramVarArgs.e(28, this.Lir);
      }
      if (this.Lis != null) {
        paramVarArgs.e(29, this.Lis);
      }
      if (this.kei != null) {
        paramVarArgs.e(30, this.kei);
      }
      if (this.MmR != null)
      {
        paramVarArgs.ni(31, this.MmR.computeSize());
        this.MmR.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(101824);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Lqk == null) {
        break label3258;
      }
    }
    label3258:
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
      i = paramInt + g.a.a.b.b.a.bu(7, this.Mvd);
      paramInt = i;
      if (this.MuI != null) {
        paramInt = i + g.a.a.a.nh(8, this.MuI.computeSize());
      }
      i = paramInt;
      if (this.MuJ != null) {
        i = paramInt + g.a.a.a.nh(9, this.MuJ.computeSize());
      }
      paramInt = i;
      if (this.MuK != null) {
        paramInt = i + g.a.a.a.nh(10, this.MuK.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(11, this.LoM);
      paramInt = i;
      if (this.kdZ != null) {
        paramInt = i + g.a.a.b.b.a.f(12, this.kdZ);
      }
      i = paramInt;
      if (this.kea != null) {
        i = paramInt + g.a.a.b.b.a.f(13, this.kea);
      }
      paramInt = i;
      if (this.keb != null) {
        paramInt = i + g.a.a.b.b.a.f(14, this.keb);
      }
      i = paramInt + g.a.a.b.b.a.bu(15, this.kec) + g.a.a.b.b.a.bu(16, this.MmK);
      paramInt = i;
      if (this.MmL != null) {
        paramInt = i + g.a.a.b.b.a.f(17, this.MmL);
      }
      i = paramInt;
      if (this.MmM != null) {
        i = paramInt + g.a.a.b.b.a.f(18, this.MmM);
      }
      paramInt = i;
      if (this.MbK != null) {
        paramInt = i + g.a.a.b.b.a.f(19, this.MbK);
      }
      i = paramInt;
      if (this.MmN != null) {
        i = paramInt + g.a.a.b.b.a.f(20, this.MmN);
      }
      i = i + g.a.a.b.b.a.bu(21, this.MmO) + g.a.a.b.b.a.bu(22, this.kef) + g.a.a.b.b.a.bu(23, this.kee);
      paramInt = i;
      if (this.keg != null) {
        paramInt = i + g.a.a.b.b.a.f(24, this.keg);
      }
      i = paramInt;
      if (this.ked != null) {
        i = paramInt + g.a.a.b.b.a.f(25, this.ked);
      }
      paramInt = i;
      if (this.MmQ != null) {
        paramInt = i + g.a.a.a.nh(26, this.MmQ.computeSize());
      }
      i = paramInt;
      if (this.keh != null) {
        i = paramInt + g.a.a.b.b.a.f(27, this.keh);
      }
      paramInt = i;
      if (this.Lir != null) {
        paramInt = i + g.a.a.b.b.a.f(28, this.Lir);
      }
      i = paramInt;
      if (this.Lis != null) {
        i = paramInt + g.a.a.b.b.a.f(29, this.Lis);
      }
      paramInt = i;
      if (this.kei != null) {
        paramInt = i + g.a.a.b.b.a.f(30, this.kei);
      }
      i = paramInt;
      if (this.MmR != null) {
        i = paramInt + g.a.a.a.nh(31, this.MmR.computeSize());
      }
      AppMethodBeat.o(101824);
      return i;
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
          AppMethodBeat.o(101824);
          throw paramVarArgs;
        }
        if (this.Mjj == null)
        {
          paramVarArgs = new b("Not all required fields were included: NickName");
          AppMethodBeat.o(101824);
          throw paramVarArgs;
        }
        if (this.LpA == null)
        {
          paramVarArgs = new b("Not all required fields were included: PYInitial");
          AppMethodBeat.o(101824);
          throw paramVarArgs;
        }
        if (this.LpB == null)
        {
          paramVarArgs = new b("Not all required fields were included: QuanPin");
          AppMethodBeat.o(101824);
          throw paramVarArgs;
        }
        if (this.KHp == null)
        {
          paramVarArgs = new b("Not all required fields were included: ImgBuf");
          AppMethodBeat.o(101824);
          throw paramVarArgs;
        }
        if (this.MuI == null)
        {
          paramVarArgs = new b("Not all required fields were included: Remark");
          AppMethodBeat.o(101824);
          throw paramVarArgs;
        }
        if (this.MuJ == null)
        {
          paramVarArgs = new b("Not all required fields were included: RemarkPYInitial");
          AppMethodBeat.o(101824);
          throw paramVarArgs;
        }
        if (this.MuK == null)
        {
          paramVarArgs = new b("Not all required fields were included: RemarkQuanPin");
          AppMethodBeat.o(101824);
          throw paramVarArgs;
        }
        AppMethodBeat.o(101824);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cpg localcpg = (cpg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(101824);
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
            localcpg.Lqk = ((dqi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101824);
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
            localcpg.Mjj = ((dqi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101824);
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
            localcpg.LpA = ((dqi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101824);
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
            localcpg.LpB = ((dqi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101824);
          return 0;
        case 5: 
          localcpg.kdY = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(101824);
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
            localcpg.KHp = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101824);
          return 0;
        case 7: 
          localcpg.Mvd = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(101824);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcpg.MuI = ((dqi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101824);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcpg.MuJ = ((dqi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101824);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcpg.MuK = ((dqi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101824);
          return 0;
        case 11: 
          localcpg.LoM = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(101824);
          return 0;
        case 12: 
          localcpg.kdZ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(101824);
          return 0;
        case 13: 
          localcpg.kea = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(101824);
          return 0;
        case 14: 
          localcpg.keb = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(101824);
          return 0;
        case 15: 
          localcpg.kec = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(101824);
          return 0;
        case 16: 
          localcpg.MmK = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(101824);
          return 0;
        case 17: 
          localcpg.MmL = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(101824);
          return 0;
        case 18: 
          localcpg.MmM = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(101824);
          return 0;
        case 19: 
          localcpg.MbK = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(101824);
          return 0;
        case 20: 
          localcpg.MmN = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(101824);
          return 0;
        case 21: 
          localcpg.MmO = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(101824);
          return 0;
        case 22: 
          localcpg.kef = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(101824);
          return 0;
        case 23: 
          localcpg.kee = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(101824);
          return 0;
        case 24: 
          localcpg.keg = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(101824);
          return 0;
        case 25: 
          localcpg.ked = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(101824);
          return 0;
        case 26: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ebj();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ebj)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcpg.MmQ = ((ebj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101824);
          return 0;
        case 27: 
          localcpg.keh = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(101824);
          return 0;
        case 28: 
          localcpg.Lir = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(101824);
          return 0;
        case 29: 
          localcpg.Lis = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(101824);
          return 0;
        case 30: 
          localcpg.kei = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(101824);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aeq();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aeq)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localcpg.MmR = ((aeq)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(101824);
        return 0;
      }
      AppMethodBeat.o(101824);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cpg
 * JD-Core Version:    0.7.0.1
 */