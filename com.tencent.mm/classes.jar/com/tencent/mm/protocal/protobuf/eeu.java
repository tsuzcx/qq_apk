package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class eeu
  extends com.tencent.mm.bx.a
{
  public String EFF;
  public String HBQ;
  public int HQc = -1;
  public String HQd;
  public String HQe;
  public String HQf;
  public String HQg;
  public String HQh;
  public int HQi;
  public float HQj;
  public String dce;
  public int dtc;
  public int duration = -1;
  public int idx;
  public long msgId;
  public long oaT;
  public int ooi;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(208999);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.duration);
      paramVarArgs.aS(2, this.HQc);
      if (this.dce != null) {
        paramVarArgs.d(3, this.dce);
      }
      if (this.HQd != null) {
        paramVarArgs.d(4, this.HQd);
      }
      paramVarArgs.aS(5, this.dtc);
      if (this.HBQ != null) {
        paramVarArgs.d(6, this.HBQ);
      }
      paramVarArgs.aY(7, this.msgId);
      paramVarArgs.aS(8, this.idx);
      if (this.HQe != null) {
        paramVarArgs.d(9, this.HQe);
      }
      if (this.HQf != null) {
        paramVarArgs.d(10, this.HQf);
      }
      if (this.HQg != null) {
        paramVarArgs.d(11, this.HQg);
      }
      if (this.HQh != null) {
        paramVarArgs.d(12, this.HQh);
      }
      paramVarArgs.aY(13, this.oaT);
      paramVarArgs.aS(14, this.scene);
      paramVarArgs.aS(15, this.ooi);
      paramVarArgs.aS(16, this.HQi);
      if (this.EFF != null) {
        paramVarArgs.d(17, this.EFF);
      }
      paramVarArgs.z(18, this.HQj);
      AppMethodBeat.o(208999);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.duration) + 0 + f.a.a.b.b.a.bz(2, this.HQc);
      paramInt = i;
      if (this.dce != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.dce);
      }
      i = paramInt;
      if (this.HQd != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.HQd);
      }
      i += f.a.a.b.b.a.bz(5, this.dtc);
      paramInt = i;
      if (this.HBQ != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.HBQ);
      }
      i = paramInt + f.a.a.b.b.a.p(7, this.msgId) + f.a.a.b.b.a.bz(8, this.idx);
      paramInt = i;
      if (this.HQe != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.HQe);
      }
      i = paramInt;
      if (this.HQf != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.HQf);
      }
      paramInt = i;
      if (this.HQg != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.HQg);
      }
      i = paramInt;
      if (this.HQh != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.HQh);
      }
      i = i + f.a.a.b.b.a.p(13, this.oaT) + f.a.a.b.b.a.bz(14, this.scene) + f.a.a.b.b.a.bz(15, this.ooi) + f.a.a.b.b.a.bz(16, this.HQi);
      paramInt = i;
      if (this.EFF != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.EFF);
      }
      i = f.a.a.b.b.a.alU(18);
      AppMethodBeat.o(208999);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(208999);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      eeu localeeu = (eeu)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(208999);
        return -1;
      case 1: 
        localeeu.duration = locala.NPN.zc();
        AppMethodBeat.o(208999);
        return 0;
      case 2: 
        localeeu.HQc = locala.NPN.zc();
        AppMethodBeat.o(208999);
        return 0;
      case 3: 
        localeeu.dce = locala.NPN.readString();
        AppMethodBeat.o(208999);
        return 0;
      case 4: 
        localeeu.HQd = locala.NPN.readString();
        AppMethodBeat.o(208999);
        return 0;
      case 5: 
        localeeu.dtc = locala.NPN.zc();
        AppMethodBeat.o(208999);
        return 0;
      case 6: 
        localeeu.HBQ = locala.NPN.readString();
        AppMethodBeat.o(208999);
        return 0;
      case 7: 
        localeeu.msgId = locala.NPN.zd();
        AppMethodBeat.o(208999);
        return 0;
      case 8: 
        localeeu.idx = locala.NPN.zc();
        AppMethodBeat.o(208999);
        return 0;
      case 9: 
        localeeu.HQe = locala.NPN.readString();
        AppMethodBeat.o(208999);
        return 0;
      case 10: 
        localeeu.HQf = locala.NPN.readString();
        AppMethodBeat.o(208999);
        return 0;
      case 11: 
        localeeu.HQg = locala.NPN.readString();
        AppMethodBeat.o(208999);
        return 0;
      case 12: 
        localeeu.HQh = locala.NPN.readString();
        AppMethodBeat.o(208999);
        return 0;
      case 13: 
        localeeu.oaT = locala.NPN.zd();
        AppMethodBeat.o(208999);
        return 0;
      case 14: 
        localeeu.scene = locala.NPN.zc();
        AppMethodBeat.o(208999);
        return 0;
      case 15: 
        localeeu.ooi = locala.NPN.zc();
        AppMethodBeat.o(208999);
        return 0;
      case 16: 
        localeeu.HQi = locala.NPN.zc();
        AppMethodBeat.o(208999);
        return 0;
      case 17: 
        localeeu.EFF = locala.NPN.readString();
        AppMethodBeat.o(208999);
        return 0;
      }
      localeeu.HQj = Float.intBitsToFloat(locala.NPN.grz());
      AppMethodBeat.o(208999);
      return 0;
    }
    AppMethodBeat.o(208999);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eeu
 * JD-Core Version:    0.7.0.1
 */