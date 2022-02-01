package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dso
  extends com.tencent.mm.bw.a
{
  public String Lir;
  public String Lis;
  public dqi Lqk;
  public aer MUR;
  public dqi Mjj;
  public int MmK;
  public String MmL;
  public String MmM;
  public String MmN;
  public int MmO;
  public int kdY;
  public String kdZ;
  public String kea;
  public String keb;
  public int kec;
  public String ked;
  public String keh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117918);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Lqk == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(117918);
        throw paramVarArgs;
      }
      if (this.Mjj == null)
      {
        paramVarArgs = new b("Not all required fields were included: NickName");
        AppMethodBeat.o(117918);
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
      paramVarArgs.aM(3, this.kdY);
      if (this.kdZ != null) {
        paramVarArgs.e(4, this.kdZ);
      }
      if (this.kea != null) {
        paramVarArgs.e(5, this.kea);
      }
      if (this.keb != null) {
        paramVarArgs.e(6, this.keb);
      }
      paramVarArgs.aM(7, this.kec);
      paramVarArgs.aM(8, this.MmK);
      if (this.MmL != null) {
        paramVarArgs.e(9, this.MmL);
      }
      if (this.MmM != null) {
        paramVarArgs.e(10, this.MmM);
      }
      if (this.ked != null) {
        paramVarArgs.e(11, this.ked);
      }
      if (this.MmN != null) {
        paramVarArgs.e(12, this.MmN);
      }
      paramVarArgs.aM(13, this.MmO);
      if (this.keh != null) {
        paramVarArgs.e(14, this.keh);
      }
      if (this.MUR != null)
      {
        paramVarArgs.ni(15, this.MUR.computeSize());
        this.MUR.writeFields(paramVarArgs);
      }
      if (this.Lir != null) {
        paramVarArgs.e(16, this.Lir);
      }
      if (this.Lis != null) {
        paramVarArgs.e(17, this.Lis);
      }
      AppMethodBeat.o(117918);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Lqk == null) {
        break label1514;
      }
    }
    label1514:
    for (paramInt = g.a.a.a.nh(1, this.Lqk.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Mjj != null) {
        i = paramInt + g.a.a.a.nh(2, this.Mjj.computeSize());
      }
      i += g.a.a.b.b.a.bu(3, this.kdY);
      paramInt = i;
      if (this.kdZ != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.kdZ);
      }
      i = paramInt;
      if (this.kea != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.kea);
      }
      paramInt = i;
      if (this.keb != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.keb);
      }
      i = paramInt + g.a.a.b.b.a.bu(7, this.kec) + g.a.a.b.b.a.bu(8, this.MmK);
      paramInt = i;
      if (this.MmL != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.MmL);
      }
      i = paramInt;
      if (this.MmM != null) {
        i = paramInt + g.a.a.b.b.a.f(10, this.MmM);
      }
      paramInt = i;
      if (this.ked != null) {
        paramInt = i + g.a.a.b.b.a.f(11, this.ked);
      }
      i = paramInt;
      if (this.MmN != null) {
        i = paramInt + g.a.a.b.b.a.f(12, this.MmN);
      }
      i += g.a.a.b.b.a.bu(13, this.MmO);
      paramInt = i;
      if (this.keh != null) {
        paramInt = i + g.a.a.b.b.a.f(14, this.keh);
      }
      i = paramInt;
      if (this.MUR != null) {
        i = paramInt + g.a.a.a.nh(15, this.MUR.computeSize());
      }
      paramInt = i;
      if (this.Lir != null) {
        paramInt = i + g.a.a.b.b.a.f(16, this.Lir);
      }
      i = paramInt;
      if (this.Lis != null) {
        i = paramInt + g.a.a.b.b.a.f(17, this.Lis);
      }
      AppMethodBeat.o(117918);
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
          AppMethodBeat.o(117918);
          throw paramVarArgs;
        }
        if (this.Mjj == null)
        {
          paramVarArgs = new b("Not all required fields were included: NickName");
          AppMethodBeat.o(117918);
          throw paramVarArgs;
        }
        AppMethodBeat.o(117918);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dso localdso = (dso)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117918);
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
            localdso.Lqk = ((dqi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117918);
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
            localdso.Mjj = ((dqi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117918);
          return 0;
        case 3: 
          localdso.kdY = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(117918);
          return 0;
        case 4: 
          localdso.kdZ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(117918);
          return 0;
        case 5: 
          localdso.kea = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(117918);
          return 0;
        case 6: 
          localdso.keb = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(117918);
          return 0;
        case 7: 
          localdso.kec = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(117918);
          return 0;
        case 8: 
          localdso.MmK = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(117918);
          return 0;
        case 9: 
          localdso.MmL = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(117918);
          return 0;
        case 10: 
          localdso.MmM = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(117918);
          return 0;
        case 11: 
          localdso.ked = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(117918);
          return 0;
        case 12: 
          localdso.MmN = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(117918);
          return 0;
        case 13: 
          localdso.MmO = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(117918);
          return 0;
        case 14: 
          localdso.keh = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(117918);
          return 0;
        case 15: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aer();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aer)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdso.MUR = ((aer)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117918);
          return 0;
        case 16: 
          localdso.Lir = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(117918);
          return 0;
        }
        localdso.Lis = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(117918);
        return 0;
      }
      AppMethodBeat.o(117918);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dso
 * JD-Core Version:    0.7.0.1
 */