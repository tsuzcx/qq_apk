package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class cpl
  extends com.tencent.mm.bw.a
{
  public int DeleteFlag;
  public int ExtFlag;
  public String KHk;
  public SKBuiltinBuffer_t KHp;
  public String LRy;
  public xg LUi;
  public String LiD;
  public String LiF;
  public String Lir;
  public String Lis;
  public int LoG;
  public int LoH;
  public int LoM;
  public int LoN;
  public LinkedList<dpt> LoO;
  public int LoQ;
  public int LoR;
  public dqi LpA;
  public dqi LpB;
  public dqi Lqk;
  public int Lql;
  public String Lqm;
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
  public String MvA;
  public int MvB;
  public int Mvd;
  public dqi Mvh;
  public int Mvi;
  public int Mvj;
  public String Mvk;
  public String Mvl;
  public String Mvm;
  public String Mvn;
  public String Mvo;
  public String Mvp;
  public String Mvq;
  public String Mvr;
  public dq Mvs;
  public int Mvt;
  public int Mvu;
  public int Mvv;
  public String Mvw;
  public dbl Mvx;
  public int Mvy;
  public int Mvz;
  public String fuW;
  public long fvd;
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
  public String xNU;
  public int xub;
  
  public cpl()
  {
    AppMethodBeat.i(43106);
    this.LoO = new LinkedList();
    AppMethodBeat.o(43106);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43107);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Lqk == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(43107);
        throw paramVarArgs;
      }
      if (this.Mjj == null)
      {
        paramVarArgs = new b("Not all required fields were included: NickName");
        AppMethodBeat.o(43107);
        throw paramVarArgs;
      }
      if (this.LpA == null)
      {
        paramVarArgs = new b("Not all required fields were included: PYInitial");
        AppMethodBeat.o(43107);
        throw paramVarArgs;
      }
      if (this.LpB == null)
      {
        paramVarArgs = new b("Not all required fields were included: QuanPin");
        AppMethodBeat.o(43107);
        throw paramVarArgs;
      }
      if (this.KHp == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgBuf");
        AppMethodBeat.o(43107);
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
      paramVarArgs.aM(7, this.LoG);
      paramVarArgs.aM(8, this.LoH);
      paramVarArgs.aM(9, this.Mvd);
      if (this.MuI != null)
      {
        paramVarArgs.ni(10, this.MuI.computeSize());
        this.MuI.writeFields(paramVarArgs);
      }
      if (this.MuJ != null)
      {
        paramVarArgs.ni(11, this.MuJ.computeSize());
        this.MuJ.writeFields(paramVarArgs);
      }
      if (this.MuK != null)
      {
        paramVarArgs.ni(12, this.MuK.computeSize());
        this.MuK.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(13, this.LoM);
      paramVarArgs.aM(14, this.LoN);
      paramVarArgs.e(15, 8, this.LoO);
      if (this.Mvh != null)
      {
        paramVarArgs.ni(16, this.Mvh.computeSize());
        this.Mvh.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(17, this.LoQ);
      paramVarArgs.aM(18, this.LoR);
      if (this.kdZ != null) {
        paramVarArgs.e(19, this.kdZ);
      }
      if (this.kea != null) {
        paramVarArgs.e(20, this.kea);
      }
      if (this.keb != null) {
        paramVarArgs.e(21, this.keb);
      }
      paramVarArgs.aM(22, this.kec);
      paramVarArgs.aM(23, this.Mvi);
      paramVarArgs.aM(24, this.MmK);
      if (this.MmL != null) {
        paramVarArgs.e(25, this.MmL);
      }
      paramVarArgs.aM(26, this.Mvj);
      paramVarArgs.aM(27, this.xub);
      if (this.MmM != null) {
        paramVarArgs.e(28, this.MmM);
      }
      if (this.MbK != null) {
        paramVarArgs.e(29, this.MbK);
      }
      if (this.ked != null) {
        paramVarArgs.e(30, this.ked);
      }
      if (this.Mvk != null) {
        paramVarArgs.e(31, this.Mvk);
      }
      if (this.MmN != null) {
        paramVarArgs.e(32, this.MmN);
      }
      paramVarArgs.aM(33, this.MmO);
      paramVarArgs.aM(34, this.kef);
      paramVarArgs.aM(35, this.kee);
      if (this.keg != null) {
        paramVarArgs.e(36, this.keg);
      }
      if (this.MmQ != null)
      {
        paramVarArgs.ni(37, this.MmQ.computeSize());
        this.MmQ.writeFields(paramVarArgs);
      }
      if (this.keh != null) {
        paramVarArgs.e(38, this.keh);
      }
      if (this.Lir != null) {
        paramVarArgs.e(39, this.Lir);
      }
      if (this.Lis != null) {
        paramVarArgs.e(40, this.Lis);
      }
      if (this.kei != null) {
        paramVarArgs.e(41, this.kei);
      }
      if (this.MmR != null)
      {
        paramVarArgs.ni(42, this.MmR.computeSize());
        this.MmR.writeFields(paramVarArgs);
      }
      if (this.Mvl != null) {
        paramVarArgs.e(43, this.Mvl);
      }
      if (this.Mvm != null) {
        paramVarArgs.e(44, this.Mvm);
      }
      if (this.Mvn != null) {
        paramVarArgs.e(45, this.Mvn);
      }
      if (this.Mvo != null) {
        paramVarArgs.e(46, this.Mvo);
      }
      if (this.Mvp != null) {
        paramVarArgs.e(47, this.Mvp);
      }
      if (this.Mvq != null) {
        paramVarArgs.e(48, this.Mvq);
      }
      if (this.Mvr != null) {
        paramVarArgs.e(49, this.Mvr);
      }
      if (this.Mvs != null)
      {
        paramVarArgs.ni(50, this.Mvs.computeSize());
        this.Mvs.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(53, this.Mvt);
      if (this.xNU != null) {
        paramVarArgs.e(54, this.xNU);
      }
      paramVarArgs.aM(55, this.Mvu);
      paramVarArgs.aM(56, this.Mvv);
      if (this.LUi != null)
      {
        paramVarArgs.ni(57, this.LUi.computeSize());
        this.LUi.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(58, this.DeleteFlag);
      if (this.KHk != null) {
        paramVarArgs.e(59, this.KHk);
      }
      if (this.Mvw != null) {
        paramVarArgs.e(60, this.Mvw);
      }
      if (this.Lqm != null) {
        paramVarArgs.e(61, this.Lqm);
      }
      if (this.Mvx != null)
      {
        paramVarArgs.ni(62, this.Mvx.computeSize());
        this.Mvx.writeFields(paramVarArgs);
      }
      if (this.fuW != null) {
        paramVarArgs.e(63, this.fuW);
      }
      paramVarArgs.aM(64, this.Mvy);
      paramVarArgs.aM(65, this.Lql);
      paramVarArgs.aM(66, this.Mvz);
      paramVarArgs.aM(67, this.ExtFlag);
      if (this.MvA != null) {
        paramVarArgs.e(68, this.MvA);
      }
      paramVarArgs.bb(70, this.fvd);
      if (this.LRy != null) {
        paramVarArgs.e(71, this.LRy);
      }
      if (this.LiD != null) {
        paramVarArgs.e(77, this.LiD);
      }
      if (this.LiF != null) {
        paramVarArgs.e(79, this.LiF);
      }
      paramVarArgs.aM(80, this.MvB);
      AppMethodBeat.o(43107);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Lqk == null) {
        break label5778;
      }
    }
    label5778:
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
      i = paramInt + g.a.a.b.b.a.bu(7, this.LoG) + g.a.a.b.b.a.bu(8, this.LoH) + g.a.a.b.b.a.bu(9, this.Mvd);
      paramInt = i;
      if (this.MuI != null) {
        paramInt = i + g.a.a.a.nh(10, this.MuI.computeSize());
      }
      i = paramInt;
      if (this.MuJ != null) {
        i = paramInt + g.a.a.a.nh(11, this.MuJ.computeSize());
      }
      paramInt = i;
      if (this.MuK != null) {
        paramInt = i + g.a.a.a.nh(12, this.MuK.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(13, this.LoM) + g.a.a.b.b.a.bu(14, this.LoN) + g.a.a.a.c(15, 8, this.LoO);
      paramInt = i;
      if (this.Mvh != null) {
        paramInt = i + g.a.a.a.nh(16, this.Mvh.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(17, this.LoQ) + g.a.a.b.b.a.bu(18, this.LoR);
      paramInt = i;
      if (this.kdZ != null) {
        paramInt = i + g.a.a.b.b.a.f(19, this.kdZ);
      }
      i = paramInt;
      if (this.kea != null) {
        i = paramInt + g.a.a.b.b.a.f(20, this.kea);
      }
      paramInt = i;
      if (this.keb != null) {
        paramInt = i + g.a.a.b.b.a.f(21, this.keb);
      }
      i = paramInt + g.a.a.b.b.a.bu(22, this.kec) + g.a.a.b.b.a.bu(23, this.Mvi) + g.a.a.b.b.a.bu(24, this.MmK);
      paramInt = i;
      if (this.MmL != null) {
        paramInt = i + g.a.a.b.b.a.f(25, this.MmL);
      }
      i = paramInt + g.a.a.b.b.a.bu(26, this.Mvj) + g.a.a.b.b.a.bu(27, this.xub);
      paramInt = i;
      if (this.MmM != null) {
        paramInt = i + g.a.a.b.b.a.f(28, this.MmM);
      }
      i = paramInt;
      if (this.MbK != null) {
        i = paramInt + g.a.a.b.b.a.f(29, this.MbK);
      }
      paramInt = i;
      if (this.ked != null) {
        paramInt = i + g.a.a.b.b.a.f(30, this.ked);
      }
      i = paramInt;
      if (this.Mvk != null) {
        i = paramInt + g.a.a.b.b.a.f(31, this.Mvk);
      }
      paramInt = i;
      if (this.MmN != null) {
        paramInt = i + g.a.a.b.b.a.f(32, this.MmN);
      }
      i = paramInt + g.a.a.b.b.a.bu(33, this.MmO) + g.a.a.b.b.a.bu(34, this.kef) + g.a.a.b.b.a.bu(35, this.kee);
      paramInt = i;
      if (this.keg != null) {
        paramInt = i + g.a.a.b.b.a.f(36, this.keg);
      }
      i = paramInt;
      if (this.MmQ != null) {
        i = paramInt + g.a.a.a.nh(37, this.MmQ.computeSize());
      }
      paramInt = i;
      if (this.keh != null) {
        paramInt = i + g.a.a.b.b.a.f(38, this.keh);
      }
      i = paramInt;
      if (this.Lir != null) {
        i = paramInt + g.a.a.b.b.a.f(39, this.Lir);
      }
      paramInt = i;
      if (this.Lis != null) {
        paramInt = i + g.a.a.b.b.a.f(40, this.Lis);
      }
      i = paramInt;
      if (this.kei != null) {
        i = paramInt + g.a.a.b.b.a.f(41, this.kei);
      }
      paramInt = i;
      if (this.MmR != null) {
        paramInt = i + g.a.a.a.nh(42, this.MmR.computeSize());
      }
      i = paramInt;
      if (this.Mvl != null) {
        i = paramInt + g.a.a.b.b.a.f(43, this.Mvl);
      }
      paramInt = i;
      if (this.Mvm != null) {
        paramInt = i + g.a.a.b.b.a.f(44, this.Mvm);
      }
      i = paramInt;
      if (this.Mvn != null) {
        i = paramInt + g.a.a.b.b.a.f(45, this.Mvn);
      }
      paramInt = i;
      if (this.Mvo != null) {
        paramInt = i + g.a.a.b.b.a.f(46, this.Mvo);
      }
      i = paramInt;
      if (this.Mvp != null) {
        i = paramInt + g.a.a.b.b.a.f(47, this.Mvp);
      }
      paramInt = i;
      if (this.Mvq != null) {
        paramInt = i + g.a.a.b.b.a.f(48, this.Mvq);
      }
      i = paramInt;
      if (this.Mvr != null) {
        i = paramInt + g.a.a.b.b.a.f(49, this.Mvr);
      }
      paramInt = i;
      if (this.Mvs != null) {
        paramInt = i + g.a.a.a.nh(50, this.Mvs.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(53, this.Mvt);
      paramInt = i;
      if (this.xNU != null) {
        paramInt = i + g.a.a.b.b.a.f(54, this.xNU);
      }
      i = paramInt + g.a.a.b.b.a.bu(55, this.Mvu) + g.a.a.b.b.a.bu(56, this.Mvv);
      paramInt = i;
      if (this.LUi != null) {
        paramInt = i + g.a.a.a.nh(57, this.LUi.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(58, this.DeleteFlag);
      paramInt = i;
      if (this.KHk != null) {
        paramInt = i + g.a.a.b.b.a.f(59, this.KHk);
      }
      i = paramInt;
      if (this.Mvw != null) {
        i = paramInt + g.a.a.b.b.a.f(60, this.Mvw);
      }
      paramInt = i;
      if (this.Lqm != null) {
        paramInt = i + g.a.a.b.b.a.f(61, this.Lqm);
      }
      i = paramInt;
      if (this.Mvx != null) {
        i = paramInt + g.a.a.a.nh(62, this.Mvx.computeSize());
      }
      paramInt = i;
      if (this.fuW != null) {
        paramInt = i + g.a.a.b.b.a.f(63, this.fuW);
      }
      i = paramInt + g.a.a.b.b.a.bu(64, this.Mvy) + g.a.a.b.b.a.bu(65, this.Lql) + g.a.a.b.b.a.bu(66, this.Mvz) + g.a.a.b.b.a.bu(67, this.ExtFlag);
      paramInt = i;
      if (this.MvA != null) {
        paramInt = i + g.a.a.b.b.a.f(68, this.MvA);
      }
      i = paramInt + g.a.a.b.b.a.r(70, this.fvd);
      paramInt = i;
      if (this.LRy != null) {
        paramInt = i + g.a.a.b.b.a.f(71, this.LRy);
      }
      i = paramInt;
      if (this.LiD != null) {
        i = paramInt + g.a.a.b.b.a.f(77, this.LiD);
      }
      paramInt = i;
      if (this.LiF != null) {
        paramInt = i + g.a.a.b.b.a.f(79, this.LiF);
      }
      i = g.a.a.b.b.a.bu(80, this.MvB);
      AppMethodBeat.o(43107);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LoO.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.Lqk == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserName");
          AppMethodBeat.o(43107);
          throw paramVarArgs;
        }
        if (this.Mjj == null)
        {
          paramVarArgs = new b("Not all required fields were included: NickName");
          AppMethodBeat.o(43107);
          throw paramVarArgs;
        }
        if (this.LpA == null)
        {
          paramVarArgs = new b("Not all required fields were included: PYInitial");
          AppMethodBeat.o(43107);
          throw paramVarArgs;
        }
        if (this.LpB == null)
        {
          paramVarArgs = new b("Not all required fields were included: QuanPin");
          AppMethodBeat.o(43107);
          throw paramVarArgs;
        }
        if (this.KHp == null)
        {
          paramVarArgs = new b("Not all required fields were included: ImgBuf");
          AppMethodBeat.o(43107);
          throw paramVarArgs;
        }
        AppMethodBeat.o(43107);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cpl localcpl = (cpl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 51: 
        case 52: 
        case 69: 
        case 72: 
        case 73: 
        case 74: 
        case 75: 
        case 76: 
        case 78: 
        default: 
          AppMethodBeat.o(43107);
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
            localcpl.Lqk = ((dqi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
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
            localcpl.Mjj = ((dqi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
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
            localcpl.LpA = ((dqi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
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
            localcpl.LpB = ((dqi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
          return 0;
        case 5: 
          localcpl.kdY = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(43107);
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
            localcpl.KHp = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
          return 0;
        case 7: 
          localcpl.LoG = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(43107);
          return 0;
        case 8: 
          localcpl.LoH = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(43107);
          return 0;
        case 9: 
          localcpl.Mvd = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(43107);
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
            localcpl.MuI = ((dqi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
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
            localcpl.MuJ = ((dqi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
          return 0;
        case 12: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcpl.MuK = ((dqi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
          return 0;
        case 13: 
          localcpl.LoM = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(43107);
          return 0;
        case 14: 
          localcpl.LoN = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(43107);
          return 0;
        case 15: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dpt();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dpt)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcpl.LoO.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
          return 0;
        case 16: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcpl.Mvh = ((dqi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
          return 0;
        case 17: 
          localcpl.LoQ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(43107);
          return 0;
        case 18: 
          localcpl.LoR = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(43107);
          return 0;
        case 19: 
          localcpl.kdZ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 20: 
          localcpl.kea = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 21: 
          localcpl.keb = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 22: 
          localcpl.kec = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(43107);
          return 0;
        case 23: 
          localcpl.Mvi = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(43107);
          return 0;
        case 24: 
          localcpl.MmK = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(43107);
          return 0;
        case 25: 
          localcpl.MmL = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 26: 
          localcpl.Mvj = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(43107);
          return 0;
        case 27: 
          localcpl.xub = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(43107);
          return 0;
        case 28: 
          localcpl.MmM = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 29: 
          localcpl.MbK = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 30: 
          localcpl.ked = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 31: 
          localcpl.Mvk = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 32: 
          localcpl.MmN = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 33: 
          localcpl.MmO = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(43107);
          return 0;
        case 34: 
          localcpl.kef = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(43107);
          return 0;
        case 35: 
          localcpl.kee = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(43107);
          return 0;
        case 36: 
          localcpl.keg = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 37: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ebj();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ebj)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcpl.MmQ = ((ebj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
          return 0;
        case 38: 
          localcpl.keh = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 39: 
          localcpl.Lir = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 40: 
          localcpl.Lis = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 41: 
          localcpl.kei = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 42: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aeq();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aeq)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcpl.MmR = ((aeq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
          return 0;
        case 43: 
          localcpl.Mvl = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 44: 
          localcpl.Mvm = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 45: 
          localcpl.Mvn = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 46: 
          localcpl.Mvo = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 47: 
          localcpl.Mvp = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 48: 
          localcpl.Mvq = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 49: 
          localcpl.Mvr = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 50: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dq();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dq)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcpl.Mvs = ((dq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
          return 0;
        case 53: 
          localcpl.Mvt = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(43107);
          return 0;
        case 54: 
          localcpl.xNU = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 55: 
          localcpl.Mvu = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(43107);
          return 0;
        case 56: 
          localcpl.Mvv = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(43107);
          return 0;
        case 57: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new xg();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((xg)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcpl.LUi = ((xg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
          return 0;
        case 58: 
          localcpl.DeleteFlag = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(43107);
          return 0;
        case 59: 
          localcpl.KHk = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 60: 
          localcpl.Mvw = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 61: 
          localcpl.Lqm = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 62: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dbl();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dbl)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcpl.Mvx = ((dbl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
          return 0;
        case 63: 
          localcpl.fuW = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 64: 
          localcpl.Mvy = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(43107);
          return 0;
        case 65: 
          localcpl.Lql = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(43107);
          return 0;
        case 66: 
          localcpl.Mvz = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(43107);
          return 0;
        case 67: 
          localcpl.ExtFlag = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(43107);
          return 0;
        case 68: 
          localcpl.MvA = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 70: 
          localcpl.fvd = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(43107);
          return 0;
        case 71: 
          localcpl.LRy = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 77: 
          localcpl.LiD = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 79: 
          localcpl.LiF = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(43107);
          return 0;
        }
        localcpl.MvB = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(43107);
        return 0;
      }
      AppMethodBeat.o(43107);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cpl
 * JD-Core Version:    0.7.0.1
 */