package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class coo
  extends com.tencent.mm.bw.a
{
  public int LoM;
  public dqi LpA;
  public dqi LpB;
  public dqi Lqp;
  public dqi Mjj;
  public int MmK;
  public String MmL;
  public int MuH;
  public dqi MuI;
  public dqi MuJ;
  public dqi MuK;
  public int kdY;
  public String kdZ;
  public String kea;
  public String keb;
  public int kec;
  public String keh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101823);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Lqp == null)
      {
        paramVarArgs = new b("Not all required fields were included: MemberName");
        AppMethodBeat.o(101823);
        throw paramVarArgs;
      }
      if (this.Mjj == null)
      {
        paramVarArgs = new b("Not all required fields were included: NickName");
        AppMethodBeat.o(101823);
        throw paramVarArgs;
      }
      if (this.LpA == null)
      {
        paramVarArgs = new b("Not all required fields were included: PYInitial");
        AppMethodBeat.o(101823);
        throw paramVarArgs;
      }
      if (this.LpB == null)
      {
        paramVarArgs = new b("Not all required fields were included: QuanPin");
        AppMethodBeat.o(101823);
        throw paramVarArgs;
      }
      if (this.MuI == null)
      {
        paramVarArgs = new b("Not all required fields were included: Remark");
        AppMethodBeat.o(101823);
        throw paramVarArgs;
      }
      if (this.MuJ == null)
      {
        paramVarArgs = new b("Not all required fields were included: RemarkPYInitial");
        AppMethodBeat.o(101823);
        throw paramVarArgs;
      }
      if (this.MuK == null)
      {
        paramVarArgs = new b("Not all required fields were included: RemarkQuanPin");
        AppMethodBeat.o(101823);
        throw paramVarArgs;
      }
      if (this.Lqp != null)
      {
        paramVarArgs.ni(1, this.Lqp.computeSize());
        this.Lqp.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.MuH);
      if (this.Mjj != null)
      {
        paramVarArgs.ni(3, this.Mjj.computeSize());
        this.Mjj.writeFields(paramVarArgs);
      }
      if (this.LpA != null)
      {
        paramVarArgs.ni(4, this.LpA.computeSize());
        this.LpA.writeFields(paramVarArgs);
      }
      if (this.LpB != null)
      {
        paramVarArgs.ni(5, this.LpB.computeSize());
        this.LpB.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(6, this.kdY);
      if (this.MuI != null)
      {
        paramVarArgs.ni(9, this.MuI.computeSize());
        this.MuI.writeFields(paramVarArgs);
      }
      if (this.MuJ != null)
      {
        paramVarArgs.ni(10, this.MuJ.computeSize());
        this.MuJ.writeFields(paramVarArgs);
      }
      if (this.MuK != null)
      {
        paramVarArgs.ni(11, this.MuK.computeSize());
        this.MuK.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(12, this.LoM);
      if (this.kdZ != null) {
        paramVarArgs.e(13, this.kdZ);
      }
      if (this.kea != null) {
        paramVarArgs.e(14, this.kea);
      }
      if (this.keb != null) {
        paramVarArgs.e(15, this.keb);
      }
      paramVarArgs.aM(16, this.kec);
      paramVarArgs.aM(17, this.MmK);
      if (this.MmL != null) {
        paramVarArgs.e(18, this.MmL);
      }
      if (this.keh != null) {
        paramVarArgs.e(19, this.keh);
      }
      AppMethodBeat.o(101823);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Lqp == null) {
        break label2122;
      }
    }
    label2122:
    for (paramInt = g.a.a.a.nh(1, this.Lqp.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.MuH);
      paramInt = i;
      if (this.Mjj != null) {
        paramInt = i + g.a.a.a.nh(3, this.Mjj.computeSize());
      }
      i = paramInt;
      if (this.LpA != null) {
        i = paramInt + g.a.a.a.nh(4, this.LpA.computeSize());
      }
      paramInt = i;
      if (this.LpB != null) {
        paramInt = i + g.a.a.a.nh(5, this.LpB.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(6, this.kdY);
      paramInt = i;
      if (this.MuI != null) {
        paramInt = i + g.a.a.a.nh(9, this.MuI.computeSize());
      }
      i = paramInt;
      if (this.MuJ != null) {
        i = paramInt + g.a.a.a.nh(10, this.MuJ.computeSize());
      }
      paramInt = i;
      if (this.MuK != null) {
        paramInt = i + g.a.a.a.nh(11, this.MuK.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(12, this.LoM);
      paramInt = i;
      if (this.kdZ != null) {
        paramInt = i + g.a.a.b.b.a.f(13, this.kdZ);
      }
      i = paramInt;
      if (this.kea != null) {
        i = paramInt + g.a.a.b.b.a.f(14, this.kea);
      }
      paramInt = i;
      if (this.keb != null) {
        paramInt = i + g.a.a.b.b.a.f(15, this.keb);
      }
      i = paramInt + g.a.a.b.b.a.bu(16, this.kec) + g.a.a.b.b.a.bu(17, this.MmK);
      paramInt = i;
      if (this.MmL != null) {
        paramInt = i + g.a.a.b.b.a.f(18, this.MmL);
      }
      i = paramInt;
      if (this.keh != null) {
        i = paramInt + g.a.a.b.b.a.f(19, this.keh);
      }
      AppMethodBeat.o(101823);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.Lqp == null)
        {
          paramVarArgs = new b("Not all required fields were included: MemberName");
          AppMethodBeat.o(101823);
          throw paramVarArgs;
        }
        if (this.Mjj == null)
        {
          paramVarArgs = new b("Not all required fields were included: NickName");
          AppMethodBeat.o(101823);
          throw paramVarArgs;
        }
        if (this.LpA == null)
        {
          paramVarArgs = new b("Not all required fields were included: PYInitial");
          AppMethodBeat.o(101823);
          throw paramVarArgs;
        }
        if (this.LpB == null)
        {
          paramVarArgs = new b("Not all required fields were included: QuanPin");
          AppMethodBeat.o(101823);
          throw paramVarArgs;
        }
        if (this.MuI == null)
        {
          paramVarArgs = new b("Not all required fields were included: Remark");
          AppMethodBeat.o(101823);
          throw paramVarArgs;
        }
        if (this.MuJ == null)
        {
          paramVarArgs = new b("Not all required fields were included: RemarkPYInitial");
          AppMethodBeat.o(101823);
          throw paramVarArgs;
        }
        if (this.MuK == null)
        {
          paramVarArgs = new b("Not all required fields were included: RemarkQuanPin");
          AppMethodBeat.o(101823);
          throw paramVarArgs;
        }
        AppMethodBeat.o(101823);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        coo localcoo = (coo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 7: 
        case 8: 
        default: 
          AppMethodBeat.o(101823);
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
            localcoo.Lqp = ((dqi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101823);
          return 0;
        case 2: 
          localcoo.MuH = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(101823);
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
            localcoo.Mjj = ((dqi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101823);
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
            localcoo.LpA = ((dqi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101823);
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
            localcoo.LpB = ((dqi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101823);
          return 0;
        case 6: 
          localcoo.kdY = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(101823);
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
            localcoo.MuI = ((dqi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101823);
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
            localcoo.MuJ = ((dqi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101823);
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
            localcoo.MuK = ((dqi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101823);
          return 0;
        case 12: 
          localcoo.LoM = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(101823);
          return 0;
        case 13: 
          localcoo.kdZ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(101823);
          return 0;
        case 14: 
          localcoo.kea = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(101823);
          return 0;
        case 15: 
          localcoo.keb = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(101823);
          return 0;
        case 16: 
          localcoo.kec = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(101823);
          return 0;
        case 17: 
          localcoo.MmK = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(101823);
          return 0;
        case 18: 
          localcoo.MmL = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(101823);
          return 0;
        }
        localcoo.keh = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(101823);
        return 0;
      }
      AppMethodBeat.o(101823);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.coo
 * JD-Core Version:    0.7.0.1
 */