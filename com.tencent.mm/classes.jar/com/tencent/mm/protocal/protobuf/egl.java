package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class egl
  extends com.tencent.mm.bw.a
{
  public String EYb;
  public String HVD;
  public int Ikj = -1;
  public String Ikk;
  public String Ikl;
  public String Ikm;
  public String Ikn;
  public String Iko;
  public int Ikp;
  public float Ikq;
  public String ddg;
  public int dui;
  public int duration = -1;
  public int idx;
  public long msgId;
  public long ogK;
  public int otZ;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(199205);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.duration);
      paramVarArgs.aS(2, this.Ikj);
      if (this.ddg != null) {
        paramVarArgs.d(3, this.ddg);
      }
      if (this.Ikk != null) {
        paramVarArgs.d(4, this.Ikk);
      }
      paramVarArgs.aS(5, this.dui);
      if (this.HVD != null) {
        paramVarArgs.d(6, this.HVD);
      }
      paramVarArgs.aZ(7, this.msgId);
      paramVarArgs.aS(8, this.idx);
      if (this.Ikl != null) {
        paramVarArgs.d(9, this.Ikl);
      }
      if (this.Ikm != null) {
        paramVarArgs.d(10, this.Ikm);
      }
      if (this.Ikn != null) {
        paramVarArgs.d(11, this.Ikn);
      }
      if (this.Iko != null) {
        paramVarArgs.d(12, this.Iko);
      }
      paramVarArgs.aZ(13, this.ogK);
      paramVarArgs.aS(14, this.scene);
      paramVarArgs.aS(15, this.otZ);
      paramVarArgs.aS(16, this.Ikp);
      if (this.EYb != null) {
        paramVarArgs.d(17, this.EYb);
      }
      paramVarArgs.y(18, this.Ikq);
      AppMethodBeat.o(199205);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.duration) + 0 + f.a.a.b.b.a.bz(2, this.Ikj);
      paramInt = i;
      if (this.ddg != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.ddg);
      }
      i = paramInt;
      if (this.Ikk != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.Ikk);
      }
      i += f.a.a.b.b.a.bz(5, this.dui);
      paramInt = i;
      if (this.HVD != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.HVD);
      }
      i = paramInt + f.a.a.b.b.a.p(7, this.msgId) + f.a.a.b.b.a.bz(8, this.idx);
      paramInt = i;
      if (this.Ikl != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.Ikl);
      }
      i = paramInt;
      if (this.Ikm != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.Ikm);
      }
      paramInt = i;
      if (this.Ikn != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.Ikn);
      }
      i = paramInt;
      if (this.Iko != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.Iko);
      }
      i = i + f.a.a.b.b.a.p(13, this.ogK) + f.a.a.b.b.a.bz(14, this.scene) + f.a.a.b.b.a.bz(15, this.otZ) + f.a.a.b.b.a.bz(16, this.Ikp);
      paramInt = i;
      if (this.EYb != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.EYb);
      }
      i = f.a.a.b.b.a.amE(18);
      AppMethodBeat.o(199205);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(199205);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      egl localegl = (egl)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(199205);
        return -1;
      case 1: 
        localegl.duration = locala.OmT.zc();
        AppMethodBeat.o(199205);
        return 0;
      case 2: 
        localegl.Ikj = locala.OmT.zc();
        AppMethodBeat.o(199205);
        return 0;
      case 3: 
        localegl.ddg = locala.OmT.readString();
        AppMethodBeat.o(199205);
        return 0;
      case 4: 
        localegl.Ikk = locala.OmT.readString();
        AppMethodBeat.o(199205);
        return 0;
      case 5: 
        localegl.dui = locala.OmT.zc();
        AppMethodBeat.o(199205);
        return 0;
      case 6: 
        localegl.HVD = locala.OmT.readString();
        AppMethodBeat.o(199205);
        return 0;
      case 7: 
        localegl.msgId = locala.OmT.zd();
        AppMethodBeat.o(199205);
        return 0;
      case 8: 
        localegl.idx = locala.OmT.zc();
        AppMethodBeat.o(199205);
        return 0;
      case 9: 
        localegl.Ikl = locala.OmT.readString();
        AppMethodBeat.o(199205);
        return 0;
      case 10: 
        localegl.Ikm = locala.OmT.readString();
        AppMethodBeat.o(199205);
        return 0;
      case 11: 
        localegl.Ikn = locala.OmT.readString();
        AppMethodBeat.o(199205);
        return 0;
      case 12: 
        localegl.Iko = locala.OmT.readString();
        AppMethodBeat.o(199205);
        return 0;
      case 13: 
        localegl.ogK = locala.OmT.zd();
        AppMethodBeat.o(199205);
        return 0;
      case 14: 
        localegl.scene = locala.OmT.zc();
        AppMethodBeat.o(199205);
        return 0;
      case 15: 
        localegl.otZ = locala.OmT.zc();
        AppMethodBeat.o(199205);
        return 0;
      case 16: 
        localegl.Ikp = locala.OmT.zc();
        AppMethodBeat.o(199205);
        return 0;
      case 17: 
        localegl.EYb = locala.OmT.readString();
        AppMethodBeat.o(199205);
        return 0;
      }
      localegl.Ikq = Float.intBitsToFloat(locala.OmT.gwb());
      AppMethodBeat.o(199205);
      return 0;
    }
    AppMethodBeat.o(199205);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.egl
 * JD-Core Version:    0.7.0.1
 */