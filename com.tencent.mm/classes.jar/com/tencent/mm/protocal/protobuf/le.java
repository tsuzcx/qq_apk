package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class le
  extends com.tencent.mm.bv.a
{
  public int cancel;
  public long cpg;
  public int pos;
  public String wyW;
  public LinkedList<Integer> wyX;
  public int wyY;
  public int wyZ;
  public int wyy;
  public int wza;
  public int wzb;
  public int wzc;
  public int wzd;
  public int wze;
  public int wzf;
  public int wzg;
  public int wzh;
  public int wzi;
  public int wzj;
  public int wzk;
  public String wzl;
  public long wzm;
  public int wzn;
  public int wzo;
  public int wzp;
  public int wzq;
  public int wzr;
  public int wzs;
  public int wzt;
  
  public le()
  {
    AppMethodBeat.i(14714);
    this.wyX = new LinkedList();
    AppMethodBeat.o(14714);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(14715);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wyW != null) {
        paramVarArgs.e(1, this.wyW);
      }
      paramVarArgs.am(2, this.cpg);
      paramVarArgs.aO(3, this.pos);
      paramVarArgs.e(4, 2, this.wyX);
      paramVarArgs.aO(5, this.wyY);
      paramVarArgs.aO(6, this.wyZ);
      paramVarArgs.aO(7, this.wza);
      paramVarArgs.aO(8, this.wzb);
      paramVarArgs.aO(9, this.wzc);
      paramVarArgs.aO(10, this.wzd);
      paramVarArgs.aO(11, this.wyy);
      paramVarArgs.aO(12, this.wze);
      paramVarArgs.aO(13, this.wzf);
      paramVarArgs.aO(14, this.cancel);
      paramVarArgs.aO(15, this.wzg);
      paramVarArgs.aO(16, this.wzh);
      paramVarArgs.aO(17, this.wzi);
      paramVarArgs.aO(18, this.wzj);
      paramVarArgs.aO(19, this.wzk);
      if (this.wzl != null) {
        paramVarArgs.e(20, this.wzl);
      }
      paramVarArgs.am(21, this.wzm);
      paramVarArgs.aO(22, this.wzn);
      paramVarArgs.aO(23, this.wzo);
      paramVarArgs.aO(24, this.wzp);
      paramVarArgs.aO(25, this.wzq);
      paramVarArgs.aO(26, this.wzr);
      paramVarArgs.aO(27, this.wzs);
      paramVarArgs.aO(28, this.wzt);
      AppMethodBeat.o(14715);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wyW == null) {
        break label1495;
      }
    }
    label1495:
    for (paramInt = e.a.a.b.b.a.f(1, this.wyW) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.p(2, this.cpg) + e.a.a.b.b.a.bl(3, this.pos) + e.a.a.a.c(4, 2, this.wyX) + e.a.a.b.b.a.bl(5, this.wyY) + e.a.a.b.b.a.bl(6, this.wyZ) + e.a.a.b.b.a.bl(7, this.wza) + e.a.a.b.b.a.bl(8, this.wzb) + e.a.a.b.b.a.bl(9, this.wzc) + e.a.a.b.b.a.bl(10, this.wzd) + e.a.a.b.b.a.bl(11, this.wyy) + e.a.a.b.b.a.bl(12, this.wze) + e.a.a.b.b.a.bl(13, this.wzf) + e.a.a.b.b.a.bl(14, this.cancel) + e.a.a.b.b.a.bl(15, this.wzg) + e.a.a.b.b.a.bl(16, this.wzh) + e.a.a.b.b.a.bl(17, this.wzi) + e.a.a.b.b.a.bl(18, this.wzj) + e.a.a.b.b.a.bl(19, this.wzk);
      paramInt = i;
      if (this.wzl != null) {
        paramInt = i + e.a.a.b.b.a.f(20, this.wzl);
      }
      i = e.a.a.b.b.a.p(21, this.wzm);
      int j = e.a.a.b.b.a.bl(22, this.wzn);
      int k = e.a.a.b.b.a.bl(23, this.wzo);
      int m = e.a.a.b.b.a.bl(24, this.wzp);
      int n = e.a.a.b.b.a.bl(25, this.wzq);
      int i1 = e.a.a.b.b.a.bl(26, this.wzr);
      int i2 = e.a.a.b.b.a.bl(27, this.wzs);
      int i3 = e.a.a.b.b.a.bl(28, this.wzt);
      AppMethodBeat.o(14715);
      return paramInt + i + j + k + m + n + i1 + i2 + i3;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wyX.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(14715);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        le localle = (le)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(14715);
          return -1;
        case 1: 
          localle.wyW = locala.CLY.readString();
          AppMethodBeat.o(14715);
          return 0;
        case 2: 
          localle.cpg = locala.CLY.sm();
          AppMethodBeat.o(14715);
          return 0;
        case 3: 
          localle.pos = locala.CLY.sl();
          AppMethodBeat.o(14715);
          return 0;
        case 4: 
          localle.wyX.add(Integer.valueOf(locala.CLY.sl()));
          AppMethodBeat.o(14715);
          return 0;
        case 5: 
          localle.wyY = locala.CLY.sl();
          AppMethodBeat.o(14715);
          return 0;
        case 6: 
          localle.wyZ = locala.CLY.sl();
          AppMethodBeat.o(14715);
          return 0;
        case 7: 
          localle.wza = locala.CLY.sl();
          AppMethodBeat.o(14715);
          return 0;
        case 8: 
          localle.wzb = locala.CLY.sl();
          AppMethodBeat.o(14715);
          return 0;
        case 9: 
          localle.wzc = locala.CLY.sl();
          AppMethodBeat.o(14715);
          return 0;
        case 10: 
          localle.wzd = locala.CLY.sl();
          AppMethodBeat.o(14715);
          return 0;
        case 11: 
          localle.wyy = locala.CLY.sl();
          AppMethodBeat.o(14715);
          return 0;
        case 12: 
          localle.wze = locala.CLY.sl();
          AppMethodBeat.o(14715);
          return 0;
        case 13: 
          localle.wzf = locala.CLY.sl();
          AppMethodBeat.o(14715);
          return 0;
        case 14: 
          localle.cancel = locala.CLY.sl();
          AppMethodBeat.o(14715);
          return 0;
        case 15: 
          localle.wzg = locala.CLY.sl();
          AppMethodBeat.o(14715);
          return 0;
        case 16: 
          localle.wzh = locala.CLY.sl();
          AppMethodBeat.o(14715);
          return 0;
        case 17: 
          localle.wzi = locala.CLY.sl();
          AppMethodBeat.o(14715);
          return 0;
        case 18: 
          localle.wzj = locala.CLY.sl();
          AppMethodBeat.o(14715);
          return 0;
        case 19: 
          localle.wzk = locala.CLY.sl();
          AppMethodBeat.o(14715);
          return 0;
        case 20: 
          localle.wzl = locala.CLY.readString();
          AppMethodBeat.o(14715);
          return 0;
        case 21: 
          localle.wzm = locala.CLY.sm();
          AppMethodBeat.o(14715);
          return 0;
        case 22: 
          localle.wzn = locala.CLY.sl();
          AppMethodBeat.o(14715);
          return 0;
        case 23: 
          localle.wzo = locala.CLY.sl();
          AppMethodBeat.o(14715);
          return 0;
        case 24: 
          localle.wzp = locala.CLY.sl();
          AppMethodBeat.o(14715);
          return 0;
        case 25: 
          localle.wzq = locala.CLY.sl();
          AppMethodBeat.o(14715);
          return 0;
        case 26: 
          localle.wzr = locala.CLY.sl();
          AppMethodBeat.o(14715);
          return 0;
        case 27: 
          localle.wzs = locala.CLY.sl();
          AppMethodBeat.o(14715);
          return 0;
        }
        localle.wzt = locala.CLY.sl();
        AppMethodBeat.o(14715);
        return 0;
      }
      AppMethodBeat.o(14715);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.le
 * JD-Core Version:    0.7.0.1
 */