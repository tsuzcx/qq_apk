package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cqm
  extends com.tencent.mm.bw.a
{
  public int KDZ;
  public int KEc;
  public dqi Lqk;
  public long LuA;
  public String LuB;
  public dqi Mjj;
  public int MmK;
  public String MmL;
  public String MmM;
  public String MmN;
  public int MmO;
  public ahm MvH;
  public int MvW;
  public int Mvj;
  public int Mwc;
  public com.tencent.mm.bw.b Mwd;
  public int Mwf;
  public dqi Mwg;
  public dqi Mwh;
  public int Mwi;
  public int Mwj;
  public int Mwk;
  public int Mwl;
  public int Mwm;
  public bzs Mwn;
  public int Mwo;
  public String Mwp;
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
  public int oTW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43112);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Lqk == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: UserName");
        AppMethodBeat.o(43112);
        throw paramVarArgs;
      }
      if (this.Mjj == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: NickName");
        AppMethodBeat.o(43112);
        throw paramVarArgs;
      }
      if (this.Mwg == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: BindEmail");
        AppMethodBeat.o(43112);
        throw paramVarArgs;
      }
      if (this.Mwh == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: BindMobile");
        AppMethodBeat.o(43112);
        throw paramVarArgs;
      }
      paramVarArgs.aM(1, this.Mwf);
      if (this.Lqk != null)
      {
        paramVarArgs.ni(2, this.Lqk.computeSize());
        this.Lqk.writeFields(paramVarArgs);
      }
      if (this.Mjj != null)
      {
        paramVarArgs.ni(3, this.Mjj.computeSize());
        this.Mjj.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(4, this.KDZ);
      if (this.Mwg != null)
      {
        paramVarArgs.ni(5, this.Mwg.computeSize());
        this.Mwg.writeFields(paramVarArgs);
      }
      if (this.Mwh != null)
      {
        paramVarArgs.ni(6, this.Mwh.computeSize());
        this.Mwh.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(7, this.oTW);
      paramVarArgs.aM(8, this.Mwc);
      if (this.Mwd != null) {
        paramVarArgs.c(9, this.Mwd);
      }
      paramVarArgs.aM(10, this.kdY);
      if (this.kdZ != null) {
        paramVarArgs.e(11, this.kdZ);
      }
      if (this.kea != null) {
        paramVarArgs.e(12, this.kea);
      }
      if (this.keb != null) {
        paramVarArgs.e(13, this.keb);
      }
      paramVarArgs.aM(14, this.kec);
      if (this.MvH != null)
      {
        paramVarArgs.ni(15, this.MvH.computeSize());
        this.MvH.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(16, this.KEc);
      paramVarArgs.aM(17, this.MmK);
      if (this.MmL != null) {
        paramVarArgs.e(18, this.MmL);
      }
      paramVarArgs.aM(19, this.Mwi);
      paramVarArgs.aM(20, this.Mwj);
      paramVarArgs.aM(21, this.Mvj);
      paramVarArgs.aM(22, this.Mwk);
      paramVarArgs.aM(23, this.Mwl);
      if (this.MmM != null) {
        paramVarArgs.e(24, this.MmM);
      }
      paramVarArgs.aM(25, this.Mwm);
      if (this.Mwn != null)
      {
        paramVarArgs.ni(26, this.Mwn.computeSize());
        this.Mwn.writeFields(paramVarArgs);
      }
      if (this.ked != null) {
        paramVarArgs.e(27, this.ked);
      }
      if (this.MmN != null) {
        paramVarArgs.e(28, this.MmN);
      }
      paramVarArgs.aM(29, this.MmO);
      paramVarArgs.aM(30, this.Mwo);
      paramVarArgs.bb(31, this.LuA);
      if (this.LuB != null) {
        paramVarArgs.e(32, this.LuB);
      }
      paramVarArgs.aM(33, this.kef);
      paramVarArgs.aM(34, this.kee);
      if (this.keg != null) {
        paramVarArgs.e(35, this.keg);
      }
      paramVarArgs.aM(36, this.MvW);
      if (this.Mwp != null) {
        paramVarArgs.e(37, this.Mwp);
      }
      if (this.keh != null) {
        paramVarArgs.e(38, this.keh);
      }
      AppMethodBeat.o(43112);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.Mwf) + 0;
      paramInt = i;
      if (this.Lqk != null) {
        paramInt = i + g.a.a.a.nh(2, this.Lqk.computeSize());
      }
      i = paramInt;
      if (this.Mjj != null) {
        i = paramInt + g.a.a.a.nh(3, this.Mjj.computeSize());
      }
      i += g.a.a.b.b.a.bu(4, this.KDZ);
      paramInt = i;
      if (this.Mwg != null) {
        paramInt = i + g.a.a.a.nh(5, this.Mwg.computeSize());
      }
      i = paramInt;
      if (this.Mwh != null) {
        i = paramInt + g.a.a.a.nh(6, this.Mwh.computeSize());
      }
      i = i + g.a.a.b.b.a.bu(7, this.oTW) + g.a.a.b.b.a.bu(8, this.Mwc);
      paramInt = i;
      if (this.Mwd != null) {
        paramInt = i + g.a.a.b.b.a.b(9, this.Mwd);
      }
      i = paramInt + g.a.a.b.b.a.bu(10, this.kdY);
      paramInt = i;
      if (this.kdZ != null) {
        paramInt = i + g.a.a.b.b.a.f(11, this.kdZ);
      }
      i = paramInt;
      if (this.kea != null) {
        i = paramInt + g.a.a.b.b.a.f(12, this.kea);
      }
      paramInt = i;
      if (this.keb != null) {
        paramInt = i + g.a.a.b.b.a.f(13, this.keb);
      }
      i = paramInt + g.a.a.b.b.a.bu(14, this.kec);
      paramInt = i;
      if (this.MvH != null) {
        paramInt = i + g.a.a.a.nh(15, this.MvH.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(16, this.KEc) + g.a.a.b.b.a.bu(17, this.MmK);
      paramInt = i;
      if (this.MmL != null) {
        paramInt = i + g.a.a.b.b.a.f(18, this.MmL);
      }
      i = paramInt + g.a.a.b.b.a.bu(19, this.Mwi) + g.a.a.b.b.a.bu(20, this.Mwj) + g.a.a.b.b.a.bu(21, this.Mvj) + g.a.a.b.b.a.bu(22, this.Mwk) + g.a.a.b.b.a.bu(23, this.Mwl);
      paramInt = i;
      if (this.MmM != null) {
        paramInt = i + g.a.a.b.b.a.f(24, this.MmM);
      }
      i = paramInt + g.a.a.b.b.a.bu(25, this.Mwm);
      paramInt = i;
      if (this.Mwn != null) {
        paramInt = i + g.a.a.a.nh(26, this.Mwn.computeSize());
      }
      i = paramInt;
      if (this.ked != null) {
        i = paramInt + g.a.a.b.b.a.f(27, this.ked);
      }
      paramInt = i;
      if (this.MmN != null) {
        paramInt = i + g.a.a.b.b.a.f(28, this.MmN);
      }
      i = paramInt + g.a.a.b.b.a.bu(29, this.MmO) + g.a.a.b.b.a.bu(30, this.Mwo) + g.a.a.b.b.a.r(31, this.LuA);
      paramInt = i;
      if (this.LuB != null) {
        paramInt = i + g.a.a.b.b.a.f(32, this.LuB);
      }
      i = paramInt + g.a.a.b.b.a.bu(33, this.kef) + g.a.a.b.b.a.bu(34, this.kee);
      paramInt = i;
      if (this.keg != null) {
        paramInt = i + g.a.a.b.b.a.f(35, this.keg);
      }
      i = paramInt + g.a.a.b.b.a.bu(36, this.MvW);
      paramInt = i;
      if (this.Mwp != null) {
        paramInt = i + g.a.a.b.b.a.f(37, this.Mwp);
      }
      i = paramInt;
      if (this.keh != null) {
        i = paramInt + g.a.a.b.b.a.f(38, this.keh);
      }
      AppMethodBeat.o(43112);
      return i;
    }
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
        paramVarArgs = new g.a.a.b("Not all required fields were included: UserName");
        AppMethodBeat.o(43112);
        throw paramVarArgs;
      }
      if (this.Mjj == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: NickName");
        AppMethodBeat.o(43112);
        throw paramVarArgs;
      }
      if (this.Mwg == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: BindEmail");
        AppMethodBeat.o(43112);
        throw paramVarArgs;
      }
      if (this.Mwh == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: BindMobile");
        AppMethodBeat.o(43112);
        throw paramVarArgs;
      }
      AppMethodBeat.o(43112);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      cqm localcqm = (cqm)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(43112);
        return -1;
      case 1: 
        localcqm.Mwf = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(43112);
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
          localcqm.Lqk = ((dqi)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(43112);
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
          localcqm.Mjj = ((dqi)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(43112);
        return 0;
      case 4: 
        localcqm.KDZ = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(43112);
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
          localcqm.Mwg = ((dqi)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(43112);
        return 0;
      case 6: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dqi();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localcqm.Mwh = ((dqi)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(43112);
        return 0;
      case 7: 
        localcqm.oTW = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(43112);
        return 0;
      case 8: 
        localcqm.Mwc = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(43112);
        return 0;
      case 9: 
        localcqm.Mwd = ((g.a.a.a.a)localObject1).UbS.hPo();
        AppMethodBeat.o(43112);
        return 0;
      case 10: 
        localcqm.kdY = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(43112);
        return 0;
      case 11: 
        localcqm.kdZ = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(43112);
        return 0;
      case 12: 
        localcqm.kea = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(43112);
        return 0;
      case 13: 
        localcqm.keb = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(43112);
        return 0;
      case 14: 
        localcqm.kec = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(43112);
        return 0;
      case 15: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ahm();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ahm)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localcqm.MvH = ((ahm)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(43112);
        return 0;
      case 16: 
        localcqm.KEc = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(43112);
        return 0;
      case 17: 
        localcqm.MmK = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(43112);
        return 0;
      case 18: 
        localcqm.MmL = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(43112);
        return 0;
      case 19: 
        localcqm.Mwi = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(43112);
        return 0;
      case 20: 
        localcqm.Mwj = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(43112);
        return 0;
      case 21: 
        localcqm.Mvj = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(43112);
        return 0;
      case 22: 
        localcqm.Mwk = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(43112);
        return 0;
      case 23: 
        localcqm.Mwl = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(43112);
        return 0;
      case 24: 
        localcqm.MmM = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(43112);
        return 0;
      case 25: 
        localcqm.Mwm = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(43112);
        return 0;
      case 26: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bzs();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bzs)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localcqm.Mwn = ((bzs)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(43112);
        return 0;
      case 27: 
        localcqm.ked = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(43112);
        return 0;
      case 28: 
        localcqm.MmN = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(43112);
        return 0;
      case 29: 
        localcqm.MmO = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(43112);
        return 0;
      case 30: 
        localcqm.Mwo = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(43112);
        return 0;
      case 31: 
        localcqm.LuA = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(43112);
        return 0;
      case 32: 
        localcqm.LuB = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(43112);
        return 0;
      case 33: 
        localcqm.kef = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(43112);
        return 0;
      case 34: 
        localcqm.kee = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(43112);
        return 0;
      case 35: 
        localcqm.keg = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(43112);
        return 0;
      case 36: 
        localcqm.MvW = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(43112);
        return 0;
      case 37: 
        localcqm.Mwp = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(43112);
        return 0;
      }
      localcqm.keh = ((g.a.a.a.a)localObject1).UbS.readString();
      AppMethodBeat.o(43112);
      return 0;
    }
    AppMethodBeat.o(43112);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cqm
 * JD-Core Version:    0.7.0.1
 */