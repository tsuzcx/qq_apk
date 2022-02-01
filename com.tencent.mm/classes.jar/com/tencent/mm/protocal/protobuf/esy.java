package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class esy
  extends com.tencent.mm.cd.a
{
  public String BHW;
  public String CHR;
  public LinkedList<eij> Crg;
  public String Crh;
  public int KFK;
  public String PyV;
  public String PyW;
  public String PyX;
  public String PyY;
  public String PyZ;
  public LinkedList<aci> Pye;
  public String TIg;
  public String UuU;
  public long UuV;
  public String UuW;
  public String UuX;
  public int UuY;
  public String UuZ;
  public long Uva;
  public long Uvb;
  public LinkedList<eta> Uvc;
  public int Uvd;
  public long Uve;
  public est Uvf;
  public int Uvg;
  public int Uvh;
  public boolean Uvi;
  public esw Uvj;
  public int Uvk;
  public esy Uvl;
  public int Uvm;
  public esr Uvn;
  public int Uvo;
  public String fVx;
  public String fvZ;
  public long fwf;
  public boolean fxt;
  public String pqW;
  public String source;
  public int thumbHeight;
  public int thumbWidth;
  public long timestamp;
  public String title;
  public String vhY;
  public String videoUrl;
  public String zGJ;
  
  public esy()
  {
    AppMethodBeat.i(153012);
    this.Crg = new LinkedList();
    this.Uvc = new LinkedList();
    this.Pye = new LinkedList();
    AppMethodBeat.o(153012);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153013);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.f(1, this.title);
      }
      if (this.videoUrl != null) {
        paramVarArgs.f(2, this.videoUrl);
      }
      if (this.UuU != null) {
        paramVarArgs.f(3, this.UuU);
      }
      paramVarArgs.aY(4, this.KFK);
      if (this.Crh != null) {
        paramVarArgs.f(5, this.Crh);
      }
      paramVarArgs.aY(6, this.thumbWidth);
      paramVarArgs.aY(7, this.thumbHeight);
      if (this.vhY != null) {
        paramVarArgs.f(8, this.vhY);
      }
      if (this.pqW != null) {
        paramVarArgs.f(9, this.pqW);
      }
      if (this.CHR != null) {
        paramVarArgs.f(10, this.CHR);
      }
      if (this.PyV != null) {
        paramVarArgs.f(11, this.PyV);
      }
      if (this.PyW != null) {
        paramVarArgs.f(12, this.PyW);
      }
      if (this.PyX != null) {
        paramVarArgs.f(13, this.PyX);
      }
      if (this.source != null) {
        paramVarArgs.f(14, this.source);
      }
      if (this.fVx != null) {
        paramVarArgs.f(15, this.fVx);
      }
      paramVarArgs.bm(16, this.UuV);
      if (this.UuW != null) {
        paramVarArgs.f(17, this.UuW);
      }
      if (this.UuX != null) {
        paramVarArgs.f(18, this.UuX);
      }
      if (this.PyY != null) {
        paramVarArgs.f(19, this.PyY);
      }
      if (this.PyZ != null) {
        paramVarArgs.f(20, this.PyZ);
      }
      paramVarArgs.aY(21, this.UuY);
      if (this.UuZ != null) {
        paramVarArgs.f(22, this.UuZ);
      }
      if (this.TIg != null) {
        paramVarArgs.f(23, this.TIg);
      }
      paramVarArgs.e(24, 8, this.Crg);
      paramVarArgs.bm(25, this.timestamp);
      paramVarArgs.co(26, this.fxt);
      if (this.BHW != null) {
        paramVarArgs.f(27, this.BHW);
      }
      paramVarArgs.bm(28, this.Uva);
      paramVarArgs.bm(29, this.fwf);
      paramVarArgs.bm(30, this.Uvb);
      paramVarArgs.e(31, 8, this.Uvc);
      paramVarArgs.aY(32, this.Uvd);
      paramVarArgs.bm(33, this.Uve);
      if (this.Uvf != null)
      {
        paramVarArgs.oE(34, this.Uvf.computeSize());
        this.Uvf.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(35, this.Uvg);
      paramVarArgs.aY(36, this.Uvh);
      paramVarArgs.co(37, this.Uvi);
      if (this.zGJ != null) {
        paramVarArgs.f(38, this.zGJ);
      }
      if (this.Uvj != null)
      {
        paramVarArgs.oE(39, this.Uvj.computeSize());
        this.Uvj.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(40, this.Uvk);
      if (this.Uvl != null)
      {
        paramVarArgs.oE(41, this.Uvl.computeSize());
        this.Uvl.writeFields(paramVarArgs);
      }
      paramVarArgs.e(42, 8, this.Pye);
      paramVarArgs.aY(43, this.Uvm);
      if (this.Uvn != null)
      {
        paramVarArgs.oE(44, this.Uvn.computeSize());
        this.Uvn.writeFields(paramVarArgs);
      }
      if (this.fvZ != null) {
        paramVarArgs.f(45, this.fvZ);
      }
      paramVarArgs.aY(46, this.Uvo);
      AppMethodBeat.o(153013);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label3144;
      }
    }
    label3144:
    for (int i = g.a.a.b.b.a.g(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.videoUrl != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.videoUrl);
      }
      i = paramInt;
      if (this.UuU != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.UuU);
      }
      i += g.a.a.b.b.a.bM(4, this.KFK);
      paramInt = i;
      if (this.Crh != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.Crh);
      }
      i = paramInt + g.a.a.b.b.a.bM(6, this.thumbWidth) + g.a.a.b.b.a.bM(7, this.thumbHeight);
      paramInt = i;
      if (this.vhY != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.vhY);
      }
      i = paramInt;
      if (this.pqW != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.pqW);
      }
      paramInt = i;
      if (this.CHR != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.CHR);
      }
      i = paramInt;
      if (this.PyV != null) {
        i = paramInt + g.a.a.b.b.a.g(11, this.PyV);
      }
      paramInt = i;
      if (this.PyW != null) {
        paramInt = i + g.a.a.b.b.a.g(12, this.PyW);
      }
      i = paramInt;
      if (this.PyX != null) {
        i = paramInt + g.a.a.b.b.a.g(13, this.PyX);
      }
      paramInt = i;
      if (this.source != null) {
        paramInt = i + g.a.a.b.b.a.g(14, this.source);
      }
      i = paramInt;
      if (this.fVx != null) {
        i = paramInt + g.a.a.b.b.a.g(15, this.fVx);
      }
      i += g.a.a.b.b.a.p(16, this.UuV);
      paramInt = i;
      if (this.UuW != null) {
        paramInt = i + g.a.a.b.b.a.g(17, this.UuW);
      }
      i = paramInt;
      if (this.UuX != null) {
        i = paramInt + g.a.a.b.b.a.g(18, this.UuX);
      }
      paramInt = i;
      if (this.PyY != null) {
        paramInt = i + g.a.a.b.b.a.g(19, this.PyY);
      }
      i = paramInt;
      if (this.PyZ != null) {
        i = paramInt + g.a.a.b.b.a.g(20, this.PyZ);
      }
      i += g.a.a.b.b.a.bM(21, this.UuY);
      paramInt = i;
      if (this.UuZ != null) {
        paramInt = i + g.a.a.b.b.a.g(22, this.UuZ);
      }
      i = paramInt;
      if (this.TIg != null) {
        i = paramInt + g.a.a.b.b.a.g(23, this.TIg);
      }
      i = i + g.a.a.a.c(24, 8, this.Crg) + g.a.a.b.b.a.p(25, this.timestamp) + (g.a.a.b.b.a.gL(26) + 1);
      paramInt = i;
      if (this.BHW != null) {
        paramInt = i + g.a.a.b.b.a.g(27, this.BHW);
      }
      i = paramInt + g.a.a.b.b.a.p(28, this.Uva) + g.a.a.b.b.a.p(29, this.fwf) + g.a.a.b.b.a.p(30, this.Uvb) + g.a.a.a.c(31, 8, this.Uvc) + g.a.a.b.b.a.bM(32, this.Uvd) + g.a.a.b.b.a.p(33, this.Uve);
      paramInt = i;
      if (this.Uvf != null) {
        paramInt = i + g.a.a.a.oD(34, this.Uvf.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(35, this.Uvg) + g.a.a.b.b.a.bM(36, this.Uvh) + (g.a.a.b.b.a.gL(37) + 1);
      paramInt = i;
      if (this.zGJ != null) {
        paramInt = i + g.a.a.b.b.a.g(38, this.zGJ);
      }
      i = paramInt;
      if (this.Uvj != null) {
        i = paramInt + g.a.a.a.oD(39, this.Uvj.computeSize());
      }
      i += g.a.a.b.b.a.bM(40, this.Uvk);
      paramInt = i;
      if (this.Uvl != null) {
        paramInt = i + g.a.a.a.oD(41, this.Uvl.computeSize());
      }
      i = paramInt + g.a.a.a.c(42, 8, this.Pye) + g.a.a.b.b.a.bM(43, this.Uvm);
      paramInt = i;
      if (this.Uvn != null) {
        paramInt = i + g.a.a.a.oD(44, this.Uvn.computeSize());
      }
      i = paramInt;
      if (this.fvZ != null) {
        i = paramInt + g.a.a.b.b.a.g(45, this.fvZ);
      }
      paramInt = g.a.a.b.b.a.bM(46, this.Uvo);
      AppMethodBeat.o(153013);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Crg.clear();
        this.Uvc.clear();
        this.Pye.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(153013);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        esy localesy = (esy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153013);
          return -1;
        case 1: 
          localesy.title = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 2: 
          localesy.videoUrl = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 3: 
          localesy.UuU = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 4: 
          localesy.KFK = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(153013);
          return 0;
        case 5: 
          localesy.Crh = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 6: 
          localesy.thumbWidth = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(153013);
          return 0;
        case 7: 
          localesy.thumbHeight = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(153013);
          return 0;
        case 8: 
          localesy.vhY = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 9: 
          localesy.pqW = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 10: 
          localesy.CHR = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 11: 
          localesy.PyV = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 12: 
          localesy.PyW = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 13: 
          localesy.PyX = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 14: 
          localesy.source = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 15: 
          localesy.fVx = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 16: 
          localesy.UuV = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(153013);
          return 0;
        case 17: 
          localesy.UuW = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 18: 
          localesy.UuX = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 19: 
          localesy.PyY = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 20: 
          localesy.PyZ = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 21: 
          localesy.UuY = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(153013);
          return 0;
        case 22: 
          localesy.UuZ = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 23: 
          localesy.TIg = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 24: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eij();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eij)localObject2).parseFrom((byte[])localObject1);
            }
            localesy.Crg.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153013);
          return 0;
        case 25: 
          localesy.timestamp = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(153013);
          return 0;
        case 26: 
          localesy.fxt = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(153013);
          return 0;
        case 27: 
          localesy.BHW = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 28: 
          localesy.Uva = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(153013);
          return 0;
        case 29: 
          localesy.fwf = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(153013);
          return 0;
        case 30: 
          localesy.Uvb = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(153013);
          return 0;
        case 31: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eta();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eta)localObject2).parseFrom((byte[])localObject1);
            }
            localesy.Uvc.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153013);
          return 0;
        case 32: 
          localesy.Uvd = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(153013);
          return 0;
        case 33: 
          localesy.Uve = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(153013);
          return 0;
        case 34: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new est();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((est)localObject2).parseFrom((byte[])localObject1);
            }
            localesy.Uvf = ((est)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153013);
          return 0;
        case 35: 
          localesy.Uvg = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(153013);
          return 0;
        case 36: 
          localesy.Uvh = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(153013);
          return 0;
        case 37: 
          localesy.Uvi = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(153013);
          return 0;
        case 38: 
          localesy.zGJ = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 39: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new esw();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((esw)localObject2).parseFrom((byte[])localObject1);
            }
            localesy.Uvj = ((esw)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153013);
          return 0;
        case 40: 
          localesy.Uvk = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(153013);
          return 0;
        case 41: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new esy();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((esy)localObject2).parseFrom((byte[])localObject1);
            }
            localesy.Uvl = ((esy)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153013);
          return 0;
        case 42: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aci();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aci)localObject2).parseFrom((byte[])localObject1);
            }
            localesy.Pye.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153013);
          return 0;
        case 43: 
          localesy.Uvm = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(153013);
          return 0;
        case 44: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new esr();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((esr)localObject2).parseFrom((byte[])localObject1);
            }
            localesy.Uvn = ((esr)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153013);
          return 0;
        case 45: 
          localesy.fvZ = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(153013);
          return 0;
        }
        localesy.Uvo = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(153013);
        return 0;
      }
      AppMethodBeat.o(153013);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.esy
 * JD-Core Version:    0.7.0.1
 */