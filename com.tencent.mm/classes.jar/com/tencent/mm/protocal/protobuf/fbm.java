package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fbm
  extends com.tencent.mm.cd.a
{
  public clc Sbb;
  public sb Sbe;
  public erh SpR;
  public doj TNI;
  public chz UBA;
  public dha UBB;
  public cmn UBC;
  public cmp UBD;
  public eqh UBE;
  public ado UBF;
  public sc UBG;
  public fbr UBH;
  public epw UBs;
  public eir UBt;
  public dah UBu;
  public dcd UBv;
  public us UBw;
  public aec UBx;
  public iy UBy;
  public crj UBz;
  public bh Ufu;
  public dzm Ukx;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91724);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.type);
      if (this.SpR != null)
      {
        paramVarArgs.oE(2, this.SpR.computeSize());
        this.SpR.writeFields(paramVarArgs);
      }
      if (this.Ukx != null)
      {
        paramVarArgs.oE(3, this.Ukx.computeSize());
        this.Ukx.writeFields(paramVarArgs);
      }
      if (this.UBs != null)
      {
        paramVarArgs.oE(4, this.UBs.computeSize());
        this.UBs.writeFields(paramVarArgs);
      }
      if (this.UBt != null)
      {
        paramVarArgs.oE(5, this.UBt.computeSize());
        this.UBt.writeFields(paramVarArgs);
      }
      if (this.UBu != null)
      {
        paramVarArgs.oE(6, this.UBu.computeSize());
        this.UBu.writeFields(paramVarArgs);
      }
      if (this.UBv != null)
      {
        paramVarArgs.oE(7, this.UBv.computeSize());
        this.UBv.writeFields(paramVarArgs);
      }
      if (this.UBw != null)
      {
        paramVarArgs.oE(8, this.UBw.computeSize());
        this.UBw.writeFields(paramVarArgs);
      }
      if (this.UBx != null)
      {
        paramVarArgs.oE(9, this.UBx.computeSize());
        this.UBx.writeFields(paramVarArgs);
      }
      if (this.UBy != null)
      {
        paramVarArgs.oE(10, this.UBy.computeSize());
        this.UBy.writeFields(paramVarArgs);
      }
      if (this.Sbe != null)
      {
        paramVarArgs.oE(11, this.Sbe.computeSize());
        this.Sbe.writeFields(paramVarArgs);
      }
      if (this.Sbb != null)
      {
        paramVarArgs.oE(12, this.Sbb.computeSize());
        this.Sbb.writeFields(paramVarArgs);
      }
      if (this.UBz != null)
      {
        paramVarArgs.oE(13, this.UBz.computeSize());
        this.UBz.writeFields(paramVarArgs);
      }
      if (this.UBA != null)
      {
        paramVarArgs.oE(14, this.UBA.computeSize());
        this.UBA.writeFields(paramVarArgs);
      }
      if (this.TNI != null)
      {
        paramVarArgs.oE(15, this.TNI.computeSize());
        this.TNI.writeFields(paramVarArgs);
      }
      if (this.UBB != null)
      {
        paramVarArgs.oE(16, this.UBB.computeSize());
        this.UBB.writeFields(paramVarArgs);
      }
      if (this.UBC != null)
      {
        paramVarArgs.oE(17, this.UBC.computeSize());
        this.UBC.writeFields(paramVarArgs);
      }
      if (this.UBD != null)
      {
        paramVarArgs.oE(18, this.UBD.computeSize());
        this.UBD.writeFields(paramVarArgs);
      }
      if (this.UBE != null)
      {
        paramVarArgs.oE(19, this.UBE.computeSize());
        this.UBE.writeFields(paramVarArgs);
      }
      if (this.UBF != null)
      {
        paramVarArgs.oE(20, this.UBF.computeSize());
        this.UBF.writeFields(paramVarArgs);
      }
      if (this.UBG != null)
      {
        paramVarArgs.oE(21, this.UBG.computeSize());
        this.UBG.writeFields(paramVarArgs);
      }
      if (this.Ufu != null)
      {
        paramVarArgs.oE(22, this.Ufu.computeSize());
        this.Ufu.writeFields(paramVarArgs);
      }
      if (this.UBH != null)
      {
        paramVarArgs.oE(23, this.UBH.computeSize());
        this.UBH.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91724);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.type) + 0;
      paramInt = i;
      if (this.SpR != null) {
        paramInt = i + g.a.a.a.oD(2, this.SpR.computeSize());
      }
      i = paramInt;
      if (this.Ukx != null) {
        i = paramInt + g.a.a.a.oD(3, this.Ukx.computeSize());
      }
      paramInt = i;
      if (this.UBs != null) {
        paramInt = i + g.a.a.a.oD(4, this.UBs.computeSize());
      }
      i = paramInt;
      if (this.UBt != null) {
        i = paramInt + g.a.a.a.oD(5, this.UBt.computeSize());
      }
      paramInt = i;
      if (this.UBu != null) {
        paramInt = i + g.a.a.a.oD(6, this.UBu.computeSize());
      }
      i = paramInt;
      if (this.UBv != null) {
        i = paramInt + g.a.a.a.oD(7, this.UBv.computeSize());
      }
      paramInt = i;
      if (this.UBw != null) {
        paramInt = i + g.a.a.a.oD(8, this.UBw.computeSize());
      }
      i = paramInt;
      if (this.UBx != null) {
        i = paramInt + g.a.a.a.oD(9, this.UBx.computeSize());
      }
      paramInt = i;
      if (this.UBy != null) {
        paramInt = i + g.a.a.a.oD(10, this.UBy.computeSize());
      }
      i = paramInt;
      if (this.Sbe != null) {
        i = paramInt + g.a.a.a.oD(11, this.Sbe.computeSize());
      }
      paramInt = i;
      if (this.Sbb != null) {
        paramInt = i + g.a.a.a.oD(12, this.Sbb.computeSize());
      }
      i = paramInt;
      if (this.UBz != null) {
        i = paramInt + g.a.a.a.oD(13, this.UBz.computeSize());
      }
      paramInt = i;
      if (this.UBA != null) {
        paramInt = i + g.a.a.a.oD(14, this.UBA.computeSize());
      }
      i = paramInt;
      if (this.TNI != null) {
        i = paramInt + g.a.a.a.oD(15, this.TNI.computeSize());
      }
      paramInt = i;
      if (this.UBB != null) {
        paramInt = i + g.a.a.a.oD(16, this.UBB.computeSize());
      }
      i = paramInt;
      if (this.UBC != null) {
        i = paramInt + g.a.a.a.oD(17, this.UBC.computeSize());
      }
      paramInt = i;
      if (this.UBD != null) {
        paramInt = i + g.a.a.a.oD(18, this.UBD.computeSize());
      }
      i = paramInt;
      if (this.UBE != null) {
        i = paramInt + g.a.a.a.oD(19, this.UBE.computeSize());
      }
      paramInt = i;
      if (this.UBF != null) {
        paramInt = i + g.a.a.a.oD(20, this.UBF.computeSize());
      }
      i = paramInt;
      if (this.UBG != null) {
        i = paramInt + g.a.a.a.oD(21, this.UBG.computeSize());
      }
      paramInt = i;
      if (this.Ufu != null) {
        paramInt = i + g.a.a.a.oD(22, this.Ufu.computeSize());
      }
      i = paramInt;
      if (this.UBH != null) {
        i = paramInt + g.a.a.a.oD(23, this.UBH.computeSize());
      }
      AppMethodBeat.o(91724);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(91724);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      fbm localfbm = (fbm)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91724);
        return -1;
      case 1: 
        localfbm.type = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(91724);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new erh();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((erh)localObject2).parseFrom((byte[])localObject1);
          }
          localfbm.SpR = ((erh)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91724);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dzm();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dzm)localObject2).parseFrom((byte[])localObject1);
          }
          localfbm.Ukx = ((dzm)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91724);
        return 0;
      case 4: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new epw();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((epw)localObject2).parseFrom((byte[])localObject1);
          }
          localfbm.UBs = ((epw)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91724);
        return 0;
      case 5: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eir();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eir)localObject2).parseFrom((byte[])localObject1);
          }
          localfbm.UBt = ((eir)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91724);
        return 0;
      case 6: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dah();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dah)localObject2).parseFrom((byte[])localObject1);
          }
          localfbm.UBu = ((dah)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91724);
        return 0;
      case 7: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dcd();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dcd)localObject2).parseFrom((byte[])localObject1);
          }
          localfbm.UBv = ((dcd)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91724);
        return 0;
      case 8: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new us();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((us)localObject2).parseFrom((byte[])localObject1);
          }
          localfbm.UBw = ((us)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91724);
        return 0;
      case 9: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new aec();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((aec)localObject2).parseFrom((byte[])localObject1);
          }
          localfbm.UBx = ((aec)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91724);
        return 0;
      case 10: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new iy();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((iy)localObject2).parseFrom((byte[])localObject1);
          }
          localfbm.UBy = ((iy)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91724);
        return 0;
      case 11: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new sb();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((sb)localObject2).parseFrom((byte[])localObject1);
          }
          localfbm.Sbe = ((sb)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91724);
        return 0;
      case 12: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new clc();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((clc)localObject2).parseFrom((byte[])localObject1);
          }
          localfbm.Sbb = ((clc)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91724);
        return 0;
      case 13: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new crj();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((crj)localObject2).parseFrom((byte[])localObject1);
          }
          localfbm.UBz = ((crj)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91724);
        return 0;
      case 14: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new chz();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((chz)localObject2).parseFrom((byte[])localObject1);
          }
          localfbm.UBA = ((chz)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91724);
        return 0;
      case 15: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new doj();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((doj)localObject2).parseFrom((byte[])localObject1);
          }
          localfbm.TNI = ((doj)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91724);
        return 0;
      case 16: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dha();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dha)localObject2).parseFrom((byte[])localObject1);
          }
          localfbm.UBB = ((dha)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91724);
        return 0;
      case 17: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new cmn();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((cmn)localObject2).parseFrom((byte[])localObject1);
          }
          localfbm.UBC = ((cmn)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91724);
        return 0;
      case 18: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new cmp();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((cmp)localObject2).parseFrom((byte[])localObject1);
          }
          localfbm.UBD = ((cmp)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91724);
        return 0;
      case 19: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eqh();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eqh)localObject2).parseFrom((byte[])localObject1);
          }
          localfbm.UBE = ((eqh)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91724);
        return 0;
      case 20: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ado();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ado)localObject2).parseFrom((byte[])localObject1);
          }
          localfbm.UBF = ((ado)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91724);
        return 0;
      case 21: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new sc();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((sc)localObject2).parseFrom((byte[])localObject1);
          }
          localfbm.UBG = ((sc)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91724);
        return 0;
      case 22: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bh();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bh)localObject2).parseFrom((byte[])localObject1);
          }
          localfbm.Ufu = ((bh)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91724);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new fbr();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((fbr)localObject2).parseFrom((byte[])localObject1);
        }
        localfbm.UBH = ((fbr)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(91724);
      return 0;
    }
    AppMethodBeat.o(91724);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fbm
 * JD-Core Version:    0.7.0.1
 */