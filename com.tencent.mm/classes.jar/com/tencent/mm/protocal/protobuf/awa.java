package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class awa
  extends esc
{
  public LinkedList<blk> ZGA;
  public String ZGB;
  public int ZGC;
  public bgw ZGD;
  public auy ZGE;
  public long ZGF;
  public avn ZGG;
  public bjm ZGl;
  public int ZGm;
  public btt ZGn;
  public FinderObject ZGo;
  public LinkedList<bno> ZGp;
  public bno ZGq;
  public LinkedList<bfh> ZGr;
  public int ZGs;
  public int ZGt;
  public int ZGu;
  public int ZGv;
  public fgq ZGw;
  public bfk ZGx;
  public bll ZGy;
  public int ZGz;
  public bkk live_notice_info;
  public int user_flag;
  
  public awa()
  {
    AppMethodBeat.i(257351);
    this.ZGp = new LinkedList();
    this.ZGr = new LinkedList();
    this.ZGA = new LinkedList();
    AppMethodBeat.o(257351);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257359);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.ZGl != null)
      {
        paramVarArgs.qD(2, this.ZGl.computeSize());
        this.ZGl.writeFields(paramVarArgs);
      }
      if (this.live_notice_info != null)
      {
        paramVarArgs.qD(3, this.live_notice_info.computeSize());
        this.live_notice_info.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(4, this.user_flag);
      paramVarArgs.bS(5, this.ZGm);
      if (this.ZGn != null)
      {
        paramVarArgs.qD(6, this.ZGn.computeSize());
        this.ZGn.writeFields(paramVarArgs);
      }
      if (this.ZGo != null)
      {
        paramVarArgs.qD(7, this.ZGo.computeSize());
        this.ZGo.writeFields(paramVarArgs);
      }
      paramVarArgs.e(8, 8, this.ZGp);
      if (this.ZGq != null)
      {
        paramVarArgs.qD(9, this.ZGq.computeSize());
        this.ZGq.writeFields(paramVarArgs);
      }
      paramVarArgs.e(10, 8, this.ZGr);
      paramVarArgs.bS(11, this.ZGs);
      paramVarArgs.bS(12, this.ZGt);
      paramVarArgs.bS(13, this.ZGu);
      paramVarArgs.bS(14, this.ZGv);
      if (this.ZGw != null)
      {
        paramVarArgs.qD(15, this.ZGw.computeSize());
        this.ZGw.writeFields(paramVarArgs);
      }
      if (this.ZGx != null)
      {
        paramVarArgs.qD(18, this.ZGx.computeSize());
        this.ZGx.writeFields(paramVarArgs);
      }
      if (this.ZGy != null)
      {
        paramVarArgs.qD(19, this.ZGy.computeSize());
        this.ZGy.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(20, this.ZGz);
      paramVarArgs.e(21, 8, this.ZGA);
      if (this.ZGB != null) {
        paramVarArgs.g(22, this.ZGB);
      }
      paramVarArgs.bS(23, this.ZGC);
      if (this.ZGD != null)
      {
        paramVarArgs.qD(24, this.ZGD.computeSize());
        this.ZGD.writeFields(paramVarArgs);
      }
      if (this.ZGE != null)
      {
        paramVarArgs.qD(25, this.ZGE.computeSize());
        this.ZGE.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(26, this.ZGF);
      if (this.ZGG != null)
      {
        paramVarArgs.qD(27, this.ZGG.computeSize());
        this.ZGG.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(257359);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2584;
      }
    }
    label2584:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ZGl != null) {
        paramInt = i + i.a.a.a.qC(2, this.ZGl.computeSize());
      }
      i = paramInt;
      if (this.live_notice_info != null) {
        i = paramInt + i.a.a.a.qC(3, this.live_notice_info.computeSize());
      }
      i = i + i.a.a.b.b.a.cJ(4, this.user_flag) + i.a.a.b.b.a.cJ(5, this.ZGm);
      paramInt = i;
      if (this.ZGn != null) {
        paramInt = i + i.a.a.a.qC(6, this.ZGn.computeSize());
      }
      i = paramInt;
      if (this.ZGo != null) {
        i = paramInt + i.a.a.a.qC(7, this.ZGo.computeSize());
      }
      i += i.a.a.a.c(8, 8, this.ZGp);
      paramInt = i;
      if (this.ZGq != null) {
        paramInt = i + i.a.a.a.qC(9, this.ZGq.computeSize());
      }
      i = paramInt + i.a.a.a.c(10, 8, this.ZGr) + i.a.a.b.b.a.cJ(11, this.ZGs) + i.a.a.b.b.a.cJ(12, this.ZGt) + i.a.a.b.b.a.cJ(13, this.ZGu) + i.a.a.b.b.a.cJ(14, this.ZGv);
      paramInt = i;
      if (this.ZGw != null) {
        paramInt = i + i.a.a.a.qC(15, this.ZGw.computeSize());
      }
      i = paramInt;
      if (this.ZGx != null) {
        i = paramInt + i.a.a.a.qC(18, this.ZGx.computeSize());
      }
      paramInt = i;
      if (this.ZGy != null) {
        paramInt = i + i.a.a.a.qC(19, this.ZGy.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(20, this.ZGz) + i.a.a.a.c(21, 8, this.ZGA);
      paramInt = i;
      if (this.ZGB != null) {
        paramInt = i + i.a.a.b.b.a.h(22, this.ZGB);
      }
      i = paramInt + i.a.a.b.b.a.cJ(23, this.ZGC);
      paramInt = i;
      if (this.ZGD != null) {
        paramInt = i + i.a.a.a.qC(24, this.ZGD.computeSize());
      }
      i = paramInt;
      if (this.ZGE != null) {
        i = paramInt + i.a.a.a.qC(25, this.ZGE.computeSize());
      }
      i += i.a.a.b.b.a.q(26, this.ZGF);
      paramInt = i;
      if (this.ZGG != null) {
        paramInt = i + i.a.a.a.qC(27, this.ZGG.computeSize());
      }
      AppMethodBeat.o(257359);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ZGp.clear();
        this.ZGr.clear();
        this.ZGA.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257359);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        awa localawa = (awa)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 16: 
        case 17: 
        default: 
          AppMethodBeat.o(257359);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kd)localObject2).parseFrom((byte[])localObject1);
            }
            localawa.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257359);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bjm();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bjm)localObject2).parseFrom((byte[])localObject1);
            }
            localawa.ZGl = ((bjm)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257359);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bkk();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bkk)localObject2).parseFrom((byte[])localObject1);
            }
            localawa.live_notice_info = ((bkk)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257359);
          return 0;
        case 4: 
          localawa.user_flag = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257359);
          return 0;
        case 5: 
          localawa.ZGm = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257359);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new btt();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((btt)localObject2).parseFrom((byte[])localObject1);
            }
            localawa.ZGn = ((btt)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257359);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new FinderObject();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((FinderObject)localObject2).parseFrom((byte[])localObject1);
            }
            localawa.ZGo = ((FinderObject)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257359);
          return 0;
        case 8: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bno();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bno)localObject2).parseFrom((byte[])localObject1);
            }
            localawa.ZGp.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257359);
          return 0;
        case 9: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bno();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bno)localObject2).parseFrom((byte[])localObject1);
            }
            localawa.ZGq = ((bno)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257359);
          return 0;
        case 10: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bfh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bfh)localObject2).parseFrom((byte[])localObject1);
            }
            localawa.ZGr.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257359);
          return 0;
        case 11: 
          localawa.ZGs = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257359);
          return 0;
        case 12: 
          localawa.ZGt = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257359);
          return 0;
        case 13: 
          localawa.ZGu = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257359);
          return 0;
        case 14: 
          localawa.ZGv = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257359);
          return 0;
        case 15: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fgq();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fgq)localObject2).parseFrom((byte[])localObject1);
            }
            localawa.ZGw = ((fgq)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257359);
          return 0;
        case 18: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bfk();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bfk)localObject2).parseFrom((byte[])localObject1);
            }
            localawa.ZGx = ((bfk)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257359);
          return 0;
        case 19: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bll();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bll)localObject2).parseFrom((byte[])localObject1);
            }
            localawa.ZGy = ((bll)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257359);
          return 0;
        case 20: 
          localawa.ZGz = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257359);
          return 0;
        case 21: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new blk();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((blk)localObject2).parseFrom((byte[])localObject1);
            }
            localawa.ZGA.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257359);
          return 0;
        case 22: 
          localawa.ZGB = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257359);
          return 0;
        case 23: 
          localawa.ZGC = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257359);
          return 0;
        case 24: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bgw();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bgw)localObject2).parseFrom((byte[])localObject1);
            }
            localawa.ZGD = ((bgw)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257359);
          return 0;
        case 25: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new auy();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((auy)localObject2).parseFrom((byte[])localObject1);
            }
            localawa.ZGE = ((auy)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257359);
          return 0;
        case 26: 
          localawa.ZGF = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(257359);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new avn();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((avn)localObject2).parseFrom((byte[])localObject1);
          }
          localawa.ZGG = ((avn)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(257359);
        return 0;
      }
      AppMethodBeat.o(257359);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.awa
 * JD-Core Version:    0.7.0.1
 */