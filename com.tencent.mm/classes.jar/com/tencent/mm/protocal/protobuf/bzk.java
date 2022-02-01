package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bzk
  extends com.tencent.mm.bx.a
{
  public String FVo;
  public String FVp;
  public SKBuiltinBuffer_t Fvm;
  public String GDx;
  public cwt GKC;
  public int GNU;
  public String GNV;
  public String GNW;
  public String GNX;
  public int GNY;
  public dhg GOa;
  public acf GOb;
  public cwt GTS;
  public cwt GTT;
  public cwt GTU;
  public int GUi;
  public int GaH;
  public cwt GbY;
  public cwt Gbr;
  public cwt Gbs;
  public int jdc;
  public String jdd;
  public String jde;
  public String jdf;
  public int jdg;
  public String jdh;
  public int jdi;
  public int jdj;
  public String jdk;
  public String jdl;
  public String jdm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101824);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GbY == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(101824);
        throw paramVarArgs;
      }
      if (this.GKC == null)
      {
        paramVarArgs = new b("Not all required fields were included: NickName");
        AppMethodBeat.o(101824);
        throw paramVarArgs;
      }
      if (this.Gbr == null)
      {
        paramVarArgs = new b("Not all required fields were included: PYInitial");
        AppMethodBeat.o(101824);
        throw paramVarArgs;
      }
      if (this.Gbs == null)
      {
        paramVarArgs = new b("Not all required fields were included: QuanPin");
        AppMethodBeat.o(101824);
        throw paramVarArgs;
      }
      if (this.Fvm == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgBuf");
        AppMethodBeat.o(101824);
        throw paramVarArgs;
      }
      if (this.GTS == null)
      {
        paramVarArgs = new b("Not all required fields were included: Remark");
        AppMethodBeat.o(101824);
        throw paramVarArgs;
      }
      if (this.GTT == null)
      {
        paramVarArgs = new b("Not all required fields were included: RemarkPYInitial");
        AppMethodBeat.o(101824);
        throw paramVarArgs;
      }
      if (this.GTU == null)
      {
        paramVarArgs = new b("Not all required fields were included: RemarkQuanPin");
        AppMethodBeat.o(101824);
        throw paramVarArgs;
      }
      if (this.GbY != null)
      {
        paramVarArgs.lC(1, this.GbY.computeSize());
        this.GbY.writeFields(paramVarArgs);
      }
      if (this.GKC != null)
      {
        paramVarArgs.lC(2, this.GKC.computeSize());
        this.GKC.writeFields(paramVarArgs);
      }
      if (this.Gbr != null)
      {
        paramVarArgs.lC(3, this.Gbr.computeSize());
        this.Gbr.writeFields(paramVarArgs);
      }
      if (this.Gbs != null)
      {
        paramVarArgs.lC(4, this.Gbs.computeSize());
        this.Gbs.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(5, this.jdc);
      if (this.Fvm != null)
      {
        paramVarArgs.lC(6, this.Fvm.computeSize());
        this.Fvm.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(7, this.GUi);
      if (this.GTS != null)
      {
        paramVarArgs.lC(8, this.GTS.computeSize());
        this.GTS.writeFields(paramVarArgs);
      }
      if (this.GTT != null)
      {
        paramVarArgs.lC(9, this.GTT.computeSize());
        this.GTT.writeFields(paramVarArgs);
      }
      if (this.GTU != null)
      {
        paramVarArgs.lC(10, this.GTU.computeSize());
        this.GTU.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(11, this.GaH);
      if (this.jdd != null) {
        paramVarArgs.d(12, this.jdd);
      }
      if (this.jde != null) {
        paramVarArgs.d(13, this.jde);
      }
      if (this.jdf != null) {
        paramVarArgs.d(14, this.jdf);
      }
      paramVarArgs.aS(15, this.jdg);
      paramVarArgs.aS(16, this.GNU);
      if (this.GNV != null) {
        paramVarArgs.d(17, this.GNV);
      }
      if (this.GNW != null) {
        paramVarArgs.d(18, this.GNW);
      }
      if (this.GDx != null) {
        paramVarArgs.d(19, this.GDx);
      }
      if (this.GNX != null) {
        paramVarArgs.d(20, this.GNX);
      }
      paramVarArgs.aS(21, this.GNY);
      paramVarArgs.aS(22, this.jdj);
      paramVarArgs.aS(23, this.jdi);
      if (this.jdk != null) {
        paramVarArgs.d(24, this.jdk);
      }
      if (this.jdh != null) {
        paramVarArgs.d(25, this.jdh);
      }
      if (this.GOa != null)
      {
        paramVarArgs.lC(26, this.GOa.computeSize());
        this.GOa.writeFields(paramVarArgs);
      }
      if (this.jdl != null) {
        paramVarArgs.d(27, this.jdl);
      }
      if (this.FVo != null) {
        paramVarArgs.d(28, this.FVo);
      }
      if (this.FVp != null) {
        paramVarArgs.d(29, this.FVp);
      }
      if (this.jdm != null) {
        paramVarArgs.d(30, this.jdm);
      }
      if (this.GOb != null)
      {
        paramVarArgs.lC(31, this.GOb.computeSize());
        this.GOb.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(101824);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GbY == null) {
        break label3258;
      }
    }
    label3258:
    for (int i = f.a.a.a.lB(1, this.GbY.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GKC != null) {
        paramInt = i + f.a.a.a.lB(2, this.GKC.computeSize());
      }
      i = paramInt;
      if (this.Gbr != null) {
        i = paramInt + f.a.a.a.lB(3, this.Gbr.computeSize());
      }
      paramInt = i;
      if (this.Gbs != null) {
        paramInt = i + f.a.a.a.lB(4, this.Gbs.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.jdc);
      paramInt = i;
      if (this.Fvm != null) {
        paramInt = i + f.a.a.a.lB(6, this.Fvm.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(7, this.GUi);
      paramInt = i;
      if (this.GTS != null) {
        paramInt = i + f.a.a.a.lB(8, this.GTS.computeSize());
      }
      i = paramInt;
      if (this.GTT != null) {
        i = paramInt + f.a.a.a.lB(9, this.GTT.computeSize());
      }
      paramInt = i;
      if (this.GTU != null) {
        paramInt = i + f.a.a.a.lB(10, this.GTU.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(11, this.GaH);
      paramInt = i;
      if (this.jdd != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.jdd);
      }
      i = paramInt;
      if (this.jde != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.jde);
      }
      paramInt = i;
      if (this.jdf != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.jdf);
      }
      i = paramInt + f.a.a.b.b.a.bz(15, this.jdg) + f.a.a.b.b.a.bz(16, this.GNU);
      paramInt = i;
      if (this.GNV != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.GNV);
      }
      i = paramInt;
      if (this.GNW != null) {
        i = paramInt + f.a.a.b.b.a.e(18, this.GNW);
      }
      paramInt = i;
      if (this.GDx != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.GDx);
      }
      i = paramInt;
      if (this.GNX != null) {
        i = paramInt + f.a.a.b.b.a.e(20, this.GNX);
      }
      i = i + f.a.a.b.b.a.bz(21, this.GNY) + f.a.a.b.b.a.bz(22, this.jdj) + f.a.a.b.b.a.bz(23, this.jdi);
      paramInt = i;
      if (this.jdk != null) {
        paramInt = i + f.a.a.b.b.a.e(24, this.jdk);
      }
      i = paramInt;
      if (this.jdh != null) {
        i = paramInt + f.a.a.b.b.a.e(25, this.jdh);
      }
      paramInt = i;
      if (this.GOa != null) {
        paramInt = i + f.a.a.a.lB(26, this.GOa.computeSize());
      }
      i = paramInt;
      if (this.jdl != null) {
        i = paramInt + f.a.a.b.b.a.e(27, this.jdl);
      }
      paramInt = i;
      if (this.FVo != null) {
        paramInt = i + f.a.a.b.b.a.e(28, this.FVo);
      }
      i = paramInt;
      if (this.FVp != null) {
        i = paramInt + f.a.a.b.b.a.e(29, this.FVp);
      }
      paramInt = i;
      if (this.jdm != null) {
        paramInt = i + f.a.a.b.b.a.e(30, this.jdm);
      }
      i = paramInt;
      if (this.GOb != null) {
        i = paramInt + f.a.a.a.lB(31, this.GOb.computeSize());
      }
      AppMethodBeat.o(101824);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.GbY == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserName");
          AppMethodBeat.o(101824);
          throw paramVarArgs;
        }
        if (this.GKC == null)
        {
          paramVarArgs = new b("Not all required fields were included: NickName");
          AppMethodBeat.o(101824);
          throw paramVarArgs;
        }
        if (this.Gbr == null)
        {
          paramVarArgs = new b("Not all required fields were included: PYInitial");
          AppMethodBeat.o(101824);
          throw paramVarArgs;
        }
        if (this.Gbs == null)
        {
          paramVarArgs = new b("Not all required fields were included: QuanPin");
          AppMethodBeat.o(101824);
          throw paramVarArgs;
        }
        if (this.Fvm == null)
        {
          paramVarArgs = new b("Not all required fields were included: ImgBuf");
          AppMethodBeat.o(101824);
          throw paramVarArgs;
        }
        if (this.GTS == null)
        {
          paramVarArgs = new b("Not all required fields were included: Remark");
          AppMethodBeat.o(101824);
          throw paramVarArgs;
        }
        if (this.GTT == null)
        {
          paramVarArgs = new b("Not all required fields were included: RemarkPYInitial");
          AppMethodBeat.o(101824);
          throw paramVarArgs;
        }
        if (this.GTU == null)
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
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bzk localbzk = (bzk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(101824);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbzk.GbY = ((cwt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101824);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbzk.GKC = ((cwt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101824);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbzk.Gbr = ((cwt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101824);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbzk.Gbs = ((cwt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101824);
          return 0;
        case 5: 
          localbzk.jdc = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(101824);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbzk.Fvm = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101824);
          return 0;
        case 7: 
          localbzk.GUi = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(101824);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbzk.GTS = ((cwt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101824);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbzk.GTT = ((cwt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101824);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbzk.GTU = ((cwt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101824);
          return 0;
        case 11: 
          localbzk.GaH = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(101824);
          return 0;
        case 12: 
          localbzk.jdd = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(101824);
          return 0;
        case 13: 
          localbzk.jde = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(101824);
          return 0;
        case 14: 
          localbzk.jdf = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(101824);
          return 0;
        case 15: 
          localbzk.jdg = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(101824);
          return 0;
        case 16: 
          localbzk.GNU = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(101824);
          return 0;
        case 17: 
          localbzk.GNV = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(101824);
          return 0;
        case 18: 
          localbzk.GNW = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(101824);
          return 0;
        case 19: 
          localbzk.GDx = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(101824);
          return 0;
        case 20: 
          localbzk.GNX = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(101824);
          return 0;
        case 21: 
          localbzk.GNY = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(101824);
          return 0;
        case 22: 
          localbzk.jdj = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(101824);
          return 0;
        case 23: 
          localbzk.jdi = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(101824);
          return 0;
        case 24: 
          localbzk.jdk = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(101824);
          return 0;
        case 25: 
          localbzk.jdh = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(101824);
          return 0;
        case 26: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dhg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dhg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbzk.GOa = ((dhg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101824);
          return 0;
        case 27: 
          localbzk.jdl = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(101824);
          return 0;
        case 28: 
          localbzk.FVo = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(101824);
          return 0;
        case 29: 
          localbzk.FVp = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(101824);
          return 0;
        case 30: 
          localbzk.jdm = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(101824);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new acf();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((acf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbzk.GOb = ((acf)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bzk
 * JD-Core Version:    0.7.0.1
 */