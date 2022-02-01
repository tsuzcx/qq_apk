package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class gif
  extends com.tencent.mm.bx.a
{
  public int AcJ;
  public int Qbt = -1;
  public String abNV;
  public String aceH;
  public String aceI;
  public String aceJ;
  public String aceK;
  public String aceL;
  public int aceM;
  public float aceN;
  public String domain;
  public int duration = -1;
  public int hIY;
  public String hqQ;
  public int idx;
  public long msgId;
  public int scene;
  public long vGG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258684);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.duration);
      paramVarArgs.bS(2, this.Qbt);
      if (this.hqQ != null) {
        paramVarArgs.g(3, this.hqQ);
      }
      if (this.aceH != null) {
        paramVarArgs.g(4, this.aceH);
      }
      paramVarArgs.bS(5, this.hIY);
      if (this.abNV != null) {
        paramVarArgs.g(6, this.abNV);
      }
      paramVarArgs.bv(7, this.msgId);
      paramVarArgs.bS(8, this.idx);
      if (this.aceI != null) {
        paramVarArgs.g(9, this.aceI);
      }
      if (this.aceJ != null) {
        paramVarArgs.g(10, this.aceJ);
      }
      if (this.aceK != null) {
        paramVarArgs.g(11, this.aceK);
      }
      if (this.aceL != null) {
        paramVarArgs.g(12, this.aceL);
      }
      paramVarArgs.bv(13, this.vGG);
      paramVarArgs.bS(14, this.scene);
      paramVarArgs.bS(15, this.AcJ);
      paramVarArgs.bS(16, this.aceM);
      if (this.domain != null) {
        paramVarArgs.g(17, this.domain);
      }
      paramVarArgs.l(18, this.aceN);
      AppMethodBeat.o(258684);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.duration) + 0 + i.a.a.b.b.a.cJ(2, this.Qbt);
      paramInt = i;
      if (this.hqQ != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.hqQ);
      }
      i = paramInt;
      if (this.aceH != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.aceH);
      }
      i += i.a.a.b.b.a.cJ(5, this.hIY);
      paramInt = i;
      if (this.abNV != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.abNV);
      }
      i = paramInt + i.a.a.b.b.a.q(7, this.msgId) + i.a.a.b.b.a.cJ(8, this.idx);
      paramInt = i;
      if (this.aceI != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.aceI);
      }
      i = paramInt;
      if (this.aceJ != null) {
        i = paramInt + i.a.a.b.b.a.h(10, this.aceJ);
      }
      paramInt = i;
      if (this.aceK != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.aceK);
      }
      i = paramInt;
      if (this.aceL != null) {
        i = paramInt + i.a.a.b.b.a.h(12, this.aceL);
      }
      i = i + i.a.a.b.b.a.q(13, this.vGG) + i.a.a.b.b.a.cJ(14, this.scene) + i.a.a.b.b.a.cJ(15, this.AcJ) + i.a.a.b.b.a.cJ(16, this.aceM);
      paramInt = i;
      if (this.domain != null) {
        paramInt = i + i.a.a.b.b.a.h(17, this.domain);
      }
      i = i.a.a.b.b.a.ko(18);
      AppMethodBeat.o(258684);
      return paramInt + (i + 4);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258684);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      gif localgif = (gif)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(258684);
        return -1;
      case 1: 
        localgif.duration = locala.ajGk.aar();
        AppMethodBeat.o(258684);
        return 0;
      case 2: 
        localgif.Qbt = locala.ajGk.aar();
        AppMethodBeat.o(258684);
        return 0;
      case 3: 
        localgif.hqQ = locala.ajGk.readString();
        AppMethodBeat.o(258684);
        return 0;
      case 4: 
        localgif.aceH = locala.ajGk.readString();
        AppMethodBeat.o(258684);
        return 0;
      case 5: 
        localgif.hIY = locala.ajGk.aar();
        AppMethodBeat.o(258684);
        return 0;
      case 6: 
        localgif.abNV = locala.ajGk.readString();
        AppMethodBeat.o(258684);
        return 0;
      case 7: 
        localgif.msgId = locala.ajGk.aaw();
        AppMethodBeat.o(258684);
        return 0;
      case 8: 
        localgif.idx = locala.ajGk.aar();
        AppMethodBeat.o(258684);
        return 0;
      case 9: 
        localgif.aceI = locala.ajGk.readString();
        AppMethodBeat.o(258684);
        return 0;
      case 10: 
        localgif.aceJ = locala.ajGk.readString();
        AppMethodBeat.o(258684);
        return 0;
      case 11: 
        localgif.aceK = locala.ajGk.readString();
        AppMethodBeat.o(258684);
        return 0;
      case 12: 
        localgif.aceL = locala.ajGk.readString();
        AppMethodBeat.o(258684);
        return 0;
      case 13: 
        localgif.vGG = locala.ajGk.aaw();
        AppMethodBeat.o(258684);
        return 0;
      case 14: 
        localgif.scene = locala.ajGk.aar();
        AppMethodBeat.o(258684);
        return 0;
      case 15: 
        localgif.AcJ = locala.ajGk.aar();
        AppMethodBeat.o(258684);
        return 0;
      case 16: 
        localgif.aceM = locala.ajGk.aar();
        AppMethodBeat.o(258684);
        return 0;
      case 17: 
        localgif.domain = locala.ajGk.readString();
        AppMethodBeat.o(258684);
        return 0;
      }
      localgif.aceN = Float.intBitsToFloat(locala.ajGk.aax());
      AppMethodBeat.o(258684);
      return 0;
    }
    AppMethodBeat.o(258684);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gif
 * JD-Core Version:    0.7.0.1
 */