package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ol
  extends com.tencent.mm.bw.a
{
  public int CreateTime;
  public int FNv;
  public String FYD;
  public int FYE;
  public int FYF;
  public int FYG;
  public String FYq;
  public int FYr;
  public String FYs;
  public String FYt;
  public String FYu;
  public String FYv;
  public String FYw;
  public String FYx;
  public int FYy;
  public int FYz;
  public long Gcl;
  public LinkedList<String> Gcm;
  public int Gcn;
  public String Gco;
  public int Gcp;
  public int Gcq;
  public String Gcr;
  public String Title;
  public int hFR;
  public String hFS;
  public String usP;
  
  public ol()
  {
    AppMethodBeat.i(188936);
    this.Gcm = new LinkedList();
    AppMethodBeat.o(188936);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(188937);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.FNv);
      if (this.Title != null) {
        paramVarArgs.d(2, this.Title);
      }
      if (this.FYq != null) {
        paramVarArgs.d(3, this.FYq);
      }
      if (this.hFS != null) {
        paramVarArgs.d(4, this.hFS);
      }
      paramVarArgs.aS(5, this.FYr);
      if (this.FYs != null) {
        paramVarArgs.d(6, this.FYs);
      }
      if (this.FYt != null) {
        paramVarArgs.d(7, this.FYt);
      }
      if (this.FYu != null) {
        paramVarArgs.d(8, this.FYu);
      }
      if (this.FYv != null) {
        paramVarArgs.d(9, this.FYv);
      }
      if (this.FYw != null) {
        paramVarArgs.d(10, this.FYw);
      }
      paramVarArgs.aS(11, this.hFR);
      if (this.FYx != null) {
        paramVarArgs.d(12, this.FYx);
      }
      paramVarArgs.aS(13, this.FYy);
      paramVarArgs.aS(14, this.FYz);
      if (this.FYD != null) {
        paramVarArgs.d(15, this.FYD);
      }
      paramVarArgs.aS(16, this.FYE);
      paramVarArgs.aS(17, this.FYF);
      paramVarArgs.aS(18, this.FYG);
      paramVarArgs.aS(19, this.CreateTime);
      paramVarArgs.aZ(20, this.Gcl);
      paramVarArgs.e(21, 1, this.Gcm);
      paramVarArgs.aS(22, this.Gcn);
      if (this.usP != null) {
        paramVarArgs.d(23, this.usP);
      }
      if (this.Gco != null) {
        paramVarArgs.d(24, this.Gco);
      }
      paramVarArgs.aS(25, this.Gcp);
      paramVarArgs.aS(26, this.Gcq);
      if (this.Gcr != null) {
        paramVarArgs.d(27, this.Gcr);
      }
      AppMethodBeat.o(188937);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.FNv) + 0;
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Title);
      }
      i = paramInt;
      if (this.FYq != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FYq);
      }
      paramInt = i;
      if (this.hFS != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.hFS);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.FYr);
      paramInt = i;
      if (this.FYs != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FYs);
      }
      i = paramInt;
      if (this.FYt != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.FYt);
      }
      paramInt = i;
      if (this.FYu != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.FYu);
      }
      i = paramInt;
      if (this.FYv != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.FYv);
      }
      paramInt = i;
      if (this.FYw != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.FYw);
      }
      i = paramInt + f.a.a.b.b.a.bz(11, this.hFR);
      paramInt = i;
      if (this.FYx != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.FYx);
      }
      i = paramInt + f.a.a.b.b.a.bz(13, this.FYy) + f.a.a.b.b.a.bz(14, this.FYz);
      paramInt = i;
      if (this.FYD != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.FYD);
      }
      i = paramInt + f.a.a.b.b.a.bz(16, this.FYE) + f.a.a.b.b.a.bz(17, this.FYF) + f.a.a.b.b.a.bz(18, this.FYG) + f.a.a.b.b.a.bz(19, this.CreateTime) + f.a.a.b.b.a.p(20, this.Gcl) + f.a.a.a.c(21, 1, this.Gcm) + f.a.a.b.b.a.bz(22, this.Gcn);
      paramInt = i;
      if (this.usP != null) {
        paramInt = i + f.a.a.b.b.a.e(23, this.usP);
      }
      i = paramInt;
      if (this.Gco != null) {
        i = paramInt + f.a.a.b.b.a.e(24, this.Gco);
      }
      i = i + f.a.a.b.b.a.bz(25, this.Gcp) + f.a.a.b.b.a.bz(26, this.Gcq);
      paramInt = i;
      if (this.Gcr != null) {
        paramInt = i + f.a.a.b.b.a.e(27, this.Gcr);
      }
      AppMethodBeat.o(188937);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Gcm.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(188937);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ol localol = (ol)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(188937);
        return -1;
      case 1: 
        localol.FNv = locala.OmT.zc();
        AppMethodBeat.o(188937);
        return 0;
      case 2: 
        localol.Title = locala.OmT.readString();
        AppMethodBeat.o(188937);
        return 0;
      case 3: 
        localol.FYq = locala.OmT.readString();
        AppMethodBeat.o(188937);
        return 0;
      case 4: 
        localol.hFS = locala.OmT.readString();
        AppMethodBeat.o(188937);
        return 0;
      case 5: 
        localol.FYr = locala.OmT.zc();
        AppMethodBeat.o(188937);
        return 0;
      case 6: 
        localol.FYs = locala.OmT.readString();
        AppMethodBeat.o(188937);
        return 0;
      case 7: 
        localol.FYt = locala.OmT.readString();
        AppMethodBeat.o(188937);
        return 0;
      case 8: 
        localol.FYu = locala.OmT.readString();
        AppMethodBeat.o(188937);
        return 0;
      case 9: 
        localol.FYv = locala.OmT.readString();
        AppMethodBeat.o(188937);
        return 0;
      case 10: 
        localol.FYw = locala.OmT.readString();
        AppMethodBeat.o(188937);
        return 0;
      case 11: 
        localol.hFR = locala.OmT.zc();
        AppMethodBeat.o(188937);
        return 0;
      case 12: 
        localol.FYx = locala.OmT.readString();
        AppMethodBeat.o(188937);
        return 0;
      case 13: 
        localol.FYy = locala.OmT.zc();
        AppMethodBeat.o(188937);
        return 0;
      case 14: 
        localol.FYz = locala.OmT.zc();
        AppMethodBeat.o(188937);
        return 0;
      case 15: 
        localol.FYD = locala.OmT.readString();
        AppMethodBeat.o(188937);
        return 0;
      case 16: 
        localol.FYE = locala.OmT.zc();
        AppMethodBeat.o(188937);
        return 0;
      case 17: 
        localol.FYF = locala.OmT.zc();
        AppMethodBeat.o(188937);
        return 0;
      case 18: 
        localol.FYG = locala.OmT.zc();
        AppMethodBeat.o(188937);
        return 0;
      case 19: 
        localol.CreateTime = locala.OmT.zc();
        AppMethodBeat.o(188937);
        return 0;
      case 20: 
        localol.Gcl = locala.OmT.zd();
        AppMethodBeat.o(188937);
        return 0;
      case 21: 
        localol.Gcm.add(locala.OmT.readString());
        AppMethodBeat.o(188937);
        return 0;
      case 22: 
        localol.Gcn = locala.OmT.zc();
        AppMethodBeat.o(188937);
        return 0;
      case 23: 
        localol.usP = locala.OmT.readString();
        AppMethodBeat.o(188937);
        return 0;
      case 24: 
        localol.Gco = locala.OmT.readString();
        AppMethodBeat.o(188937);
        return 0;
      case 25: 
        localol.Gcp = locala.OmT.zc();
        AppMethodBeat.o(188937);
        return 0;
      case 26: 
        localol.Gcq = locala.OmT.zc();
        AppMethodBeat.o(188937);
        return 0;
      }
      localol.Gcr = locala.OmT.readString();
      AppMethodBeat.o(188937);
      return 0;
    }
    AppMethodBeat.o(188937);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ol
 * JD-Core Version:    0.7.0.1
 */