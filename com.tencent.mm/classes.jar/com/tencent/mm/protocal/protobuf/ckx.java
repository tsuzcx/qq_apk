package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ckx
  extends com.tencent.mm.bv.a
{
  public long cnw;
  public boolean coy;
  public int fgQ;
  public int fgR;
  public String lHq;
  public String lHr;
  public String puE;
  public String rrm;
  public String source;
  public long timestamp;
  public String title;
  public String uJn;
  public String uJo;
  public String uJp;
  public String uJq;
  public String uJr;
  public String uKI;
  public int vYf;
  public String videoUrl;
  public LinkedList<ccp> wVo;
  public String xUY;
  public int xUZ;
  public String xVa;
  public long xVb;
  public String xVc;
  public String xVd;
  public int xVe;
  public String xVf;
  public String xVg;
  public long xVh;
  public long xVi;
  public LinkedList<ckz> xVj;
  public LinkedList<adl> xVk;
  public int xVl;
  public long xVm;
  public int xVn;
  public int xVo;
  public boolean xVp;
  public String xVq;
  public int xVr;
  public int xVs;
  
  public ckx()
  {
    AppMethodBeat.i(55710);
    this.wVo = new LinkedList();
    this.xVj = new LinkedList();
    this.xVk = new LinkedList();
    AppMethodBeat.o(55710);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(55711);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.e(1, this.title);
      }
      if (this.videoUrl != null) {
        paramVarArgs.e(2, this.videoUrl);
      }
      if (this.xUY != null) {
        paramVarArgs.e(3, this.xUY);
      }
      paramVarArgs.aO(4, this.xUZ);
      if (this.xVa != null) {
        paramVarArgs.e(5, this.xVa);
      }
      paramVarArgs.aO(6, this.fgR);
      paramVarArgs.aO(7, this.fgQ);
      if (this.lHq != null) {
        paramVarArgs.e(8, this.lHq);
      }
      if (this.lHr != null) {
        paramVarArgs.e(9, this.lHr);
      }
      if (this.rrm != null) {
        paramVarArgs.e(10, this.rrm);
      }
      if (this.uJn != null) {
        paramVarArgs.e(11, this.uJn);
      }
      if (this.uJo != null) {
        paramVarArgs.e(12, this.uJo);
      }
      if (this.uJp != null) {
        paramVarArgs.e(13, this.uJp);
      }
      if (this.source != null) {
        paramVarArgs.e(14, this.source);
      }
      if (this.puE != null) {
        paramVarArgs.e(15, this.puE);
      }
      paramVarArgs.am(16, this.xVb);
      if (this.xVc != null) {
        paramVarArgs.e(17, this.xVc);
      }
      if (this.xVd != null) {
        paramVarArgs.e(18, this.xVd);
      }
      if (this.uJq != null) {
        paramVarArgs.e(19, this.uJq);
      }
      if (this.uJr != null) {
        paramVarArgs.e(20, this.uJr);
      }
      paramVarArgs.aO(21, this.xVe);
      if (this.xVf != null) {
        paramVarArgs.e(22, this.xVf);
      }
      if (this.xVg != null) {
        paramVarArgs.e(23, this.xVg);
      }
      paramVarArgs.e(24, 8, this.wVo);
      paramVarArgs.am(25, this.timestamp);
      paramVarArgs.aS(26, this.coy);
      if (this.uKI != null) {
        paramVarArgs.e(27, this.uKI);
      }
      paramVarArgs.am(28, this.xVh);
      paramVarArgs.am(29, this.cnw);
      paramVarArgs.am(30, this.xVi);
      paramVarArgs.e(31, 8, this.xVj);
      paramVarArgs.e(32, 8, this.xVk);
      paramVarArgs.aO(33, this.xVl);
      paramVarArgs.am(34, this.xVm);
      paramVarArgs.aO(35, this.xVn);
      paramVarArgs.aO(36, this.vYf);
      paramVarArgs.aO(37, this.xVo);
      paramVarArgs.aS(38, this.xVp);
      if (this.xVq != null) {
        paramVarArgs.e(39, this.xVq);
      }
      paramVarArgs.aO(40, this.xVr);
      paramVarArgs.aO(41, this.xVs);
      AppMethodBeat.o(55711);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label2610;
      }
    }
    label2610:
    for (int i = e.a.a.b.b.a.f(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.videoUrl != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.videoUrl);
      }
      i = paramInt;
      if (this.xUY != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.xUY);
      }
      i += e.a.a.b.b.a.bl(4, this.xUZ);
      paramInt = i;
      if (this.xVa != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.xVa);
      }
      i = paramInt + e.a.a.b.b.a.bl(6, this.fgR) + e.a.a.b.b.a.bl(7, this.fgQ);
      paramInt = i;
      if (this.lHq != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.lHq);
      }
      i = paramInt;
      if (this.lHr != null) {
        i = paramInt + e.a.a.b.b.a.f(9, this.lHr);
      }
      paramInt = i;
      if (this.rrm != null) {
        paramInt = i + e.a.a.b.b.a.f(10, this.rrm);
      }
      i = paramInt;
      if (this.uJn != null) {
        i = paramInt + e.a.a.b.b.a.f(11, this.uJn);
      }
      paramInt = i;
      if (this.uJo != null) {
        paramInt = i + e.a.a.b.b.a.f(12, this.uJo);
      }
      i = paramInt;
      if (this.uJp != null) {
        i = paramInt + e.a.a.b.b.a.f(13, this.uJp);
      }
      paramInt = i;
      if (this.source != null) {
        paramInt = i + e.a.a.b.b.a.f(14, this.source);
      }
      i = paramInt;
      if (this.puE != null) {
        i = paramInt + e.a.a.b.b.a.f(15, this.puE);
      }
      i += e.a.a.b.b.a.p(16, this.xVb);
      paramInt = i;
      if (this.xVc != null) {
        paramInt = i + e.a.a.b.b.a.f(17, this.xVc);
      }
      i = paramInt;
      if (this.xVd != null) {
        i = paramInt + e.a.a.b.b.a.f(18, this.xVd);
      }
      paramInt = i;
      if (this.uJq != null) {
        paramInt = i + e.a.a.b.b.a.f(19, this.uJq);
      }
      i = paramInt;
      if (this.uJr != null) {
        i = paramInt + e.a.a.b.b.a.f(20, this.uJr);
      }
      i += e.a.a.b.b.a.bl(21, this.xVe);
      paramInt = i;
      if (this.xVf != null) {
        paramInt = i + e.a.a.b.b.a.f(22, this.xVf);
      }
      i = paramInt;
      if (this.xVg != null) {
        i = paramInt + e.a.a.b.b.a.f(23, this.xVg);
      }
      i = i + e.a.a.a.c(24, 8, this.wVo) + e.a.a.b.b.a.p(25, this.timestamp) + (e.a.a.b.b.a.eW(26) + 1);
      paramInt = i;
      if (this.uKI != null) {
        paramInt = i + e.a.a.b.b.a.f(27, this.uKI);
      }
      i = paramInt + e.a.a.b.b.a.p(28, this.xVh) + e.a.a.b.b.a.p(29, this.cnw) + e.a.a.b.b.a.p(30, this.xVi) + e.a.a.a.c(31, 8, this.xVj) + e.a.a.a.c(32, 8, this.xVk) + e.a.a.b.b.a.bl(33, this.xVl) + e.a.a.b.b.a.p(34, this.xVm) + e.a.a.b.b.a.bl(35, this.xVn) + e.a.a.b.b.a.bl(36, this.vYf) + e.a.a.b.b.a.bl(37, this.xVo) + (e.a.a.b.b.a.eW(38) + 1);
      paramInt = i;
      if (this.xVq != null) {
        paramInt = i + e.a.a.b.b.a.f(39, this.xVq);
      }
      i = e.a.a.b.b.a.bl(40, this.xVr);
      int j = e.a.a.b.b.a.bl(41, this.xVs);
      AppMethodBeat.o(55711);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wVo.clear();
        this.xVj.clear();
        this.xVk.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(55711);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        ckx localckx = (ckx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(55711);
          return -1;
        case 1: 
          localckx.title = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(55711);
          return 0;
        case 2: 
          localckx.videoUrl = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(55711);
          return 0;
        case 3: 
          localckx.xUY = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(55711);
          return 0;
        case 4: 
          localckx.xUZ = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(55711);
          return 0;
        case 5: 
          localckx.xVa = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(55711);
          return 0;
        case 6: 
          localckx.fgR = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(55711);
          return 0;
        case 7: 
          localckx.fgQ = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(55711);
          return 0;
        case 8: 
          localckx.lHq = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(55711);
          return 0;
        case 9: 
          localckx.lHr = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(55711);
          return 0;
        case 10: 
          localckx.rrm = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(55711);
          return 0;
        case 11: 
          localckx.uJn = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(55711);
          return 0;
        case 12: 
          localckx.uJo = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(55711);
          return 0;
        case 13: 
          localckx.uJp = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(55711);
          return 0;
        case 14: 
          localckx.source = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(55711);
          return 0;
        case 15: 
          localckx.puE = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(55711);
          return 0;
        case 16: 
          localckx.xVb = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(55711);
          return 0;
        case 17: 
          localckx.xVc = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(55711);
          return 0;
        case 18: 
          localckx.xVd = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(55711);
          return 0;
        case 19: 
          localckx.uJq = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(55711);
          return 0;
        case 20: 
          localckx.uJr = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(55711);
          return 0;
        case 21: 
          localckx.xVe = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(55711);
          return 0;
        case 22: 
          localckx.xVf = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(55711);
          return 0;
        case 23: 
          localckx.xVg = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(55711);
          return 0;
        case 24: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ccp();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ccp)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localckx.wVo.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(55711);
          return 0;
        case 25: 
          localckx.timestamp = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(55711);
          return 0;
        case 26: 
          localckx.coy = ((e.a.a.a.a)localObject1).CLY.emu();
          AppMethodBeat.o(55711);
          return 0;
        case 27: 
          localckx.uKI = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(55711);
          return 0;
        case 28: 
          localckx.xVh = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(55711);
          return 0;
        case 29: 
          localckx.cnw = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(55711);
          return 0;
        case 30: 
          localckx.xVi = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(55711);
          return 0;
        case 31: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ckz();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ckz)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localckx.xVj.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(55711);
          return 0;
        case 32: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new adl();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((adl)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localckx.xVk.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(55711);
          return 0;
        case 33: 
          localckx.xVl = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(55711);
          return 0;
        case 34: 
          localckx.xVm = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(55711);
          return 0;
        case 35: 
          localckx.xVn = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(55711);
          return 0;
        case 36: 
          localckx.vYf = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(55711);
          return 0;
        case 37: 
          localckx.xVo = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(55711);
          return 0;
        case 38: 
          localckx.xVp = ((e.a.a.a.a)localObject1).CLY.emu();
          AppMethodBeat.o(55711);
          return 0;
        case 39: 
          localckx.xVq = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(55711);
          return 0;
        case 40: 
          localckx.xVr = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(55711);
          return 0;
        }
        localckx.xVs = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(55711);
        return 0;
      }
      AppMethodBeat.o(55711);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ckx
 * JD-Core Version:    0.7.0.1
 */