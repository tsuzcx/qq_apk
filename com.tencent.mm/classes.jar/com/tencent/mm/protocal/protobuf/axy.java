package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class axy
  extends com.tencent.mm.bw.a
{
  public String AqO;
  public String BPc;
  public String Djf;
  public String LIf;
  public String LIg;
  public String LIh;
  public String LIi;
  public String LIj;
  public long LIk;
  public String albumName;
  public int duration;
  public String extraInfo;
  public String identification;
  public String lDR;
  public String musicDataUrl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209579);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BPc != null) {
        paramVarArgs.e(1, this.BPc);
      }
      if (this.lDR != null) {
        paramVarArgs.e(2, this.lDR);
      }
      if (this.musicDataUrl != null) {
        paramVarArgs.e(3, this.musicDataUrl);
      }
      if (this.LIf != null) {
        paramVarArgs.e(4, this.LIf);
      }
      if (this.LIg != null) {
        paramVarArgs.e(5, this.LIg);
      }
      if (this.AqO != null) {
        paramVarArgs.e(6, this.AqO);
      }
      if (this.LIh != null) {
        paramVarArgs.e(7, this.LIh);
      }
      if (this.albumName != null) {
        paramVarArgs.e(8, this.albumName);
      }
      if (this.Djf != null) {
        paramVarArgs.e(9, this.Djf);
      }
      if (this.LIi != null) {
        paramVarArgs.e(10, this.LIi);
      }
      if (this.LIj != null) {
        paramVarArgs.e(11, this.LIj);
      }
      paramVarArgs.bb(12, this.LIk);
      if (this.extraInfo != null) {
        paramVarArgs.e(13, this.extraInfo);
      }
      if (this.identification != null) {
        paramVarArgs.e(14, this.identification);
      }
      paramVarArgs.aM(15, this.duration);
      AppMethodBeat.o(209579);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BPc == null) {
        break label1042;
      }
    }
    label1042:
    for (int i = g.a.a.b.b.a.f(1, this.BPc) + 0;; i = 0)
    {
      paramInt = i;
      if (this.lDR != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.lDR);
      }
      i = paramInt;
      if (this.musicDataUrl != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.musicDataUrl);
      }
      paramInt = i;
      if (this.LIf != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.LIf);
      }
      i = paramInt;
      if (this.LIg != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.LIg);
      }
      paramInt = i;
      if (this.AqO != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.AqO);
      }
      i = paramInt;
      if (this.LIh != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.LIh);
      }
      paramInt = i;
      if (this.albumName != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.albumName);
      }
      i = paramInt;
      if (this.Djf != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.Djf);
      }
      paramInt = i;
      if (this.LIi != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.LIi);
      }
      i = paramInt;
      if (this.LIj != null) {
        i = paramInt + g.a.a.b.b.a.f(11, this.LIj);
      }
      i += g.a.a.b.b.a.r(12, this.LIk);
      paramInt = i;
      if (this.extraInfo != null) {
        paramInt = i + g.a.a.b.b.a.f(13, this.extraInfo);
      }
      i = paramInt;
      if (this.identification != null) {
        i = paramInt + g.a.a.b.b.a.f(14, this.identification);
      }
      paramInt = g.a.a.b.b.a.bu(15, this.duration);
      AppMethodBeat.o(209579);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209579);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        axy localaxy = (axy)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(209579);
          return -1;
        case 1: 
          localaxy.BPc = locala.UbS.readString();
          AppMethodBeat.o(209579);
          return 0;
        case 2: 
          localaxy.lDR = locala.UbS.readString();
          AppMethodBeat.o(209579);
          return 0;
        case 3: 
          localaxy.musicDataUrl = locala.UbS.readString();
          AppMethodBeat.o(209579);
          return 0;
        case 4: 
          localaxy.LIf = locala.UbS.readString();
          AppMethodBeat.o(209579);
          return 0;
        case 5: 
          localaxy.LIg = locala.UbS.readString();
          AppMethodBeat.o(209579);
          return 0;
        case 6: 
          localaxy.AqO = locala.UbS.readString();
          AppMethodBeat.o(209579);
          return 0;
        case 7: 
          localaxy.LIh = locala.UbS.readString();
          AppMethodBeat.o(209579);
          return 0;
        case 8: 
          localaxy.albumName = locala.UbS.readString();
          AppMethodBeat.o(209579);
          return 0;
        case 9: 
          localaxy.Djf = locala.UbS.readString();
          AppMethodBeat.o(209579);
          return 0;
        case 10: 
          localaxy.LIi = locala.UbS.readString();
          AppMethodBeat.o(209579);
          return 0;
        case 11: 
          localaxy.LIj = locala.UbS.readString();
          AppMethodBeat.o(209579);
          return 0;
        case 12: 
          localaxy.LIk = locala.UbS.zl();
          AppMethodBeat.o(209579);
          return 0;
        case 13: 
          localaxy.extraInfo = locala.UbS.readString();
          AppMethodBeat.o(209579);
          return 0;
        case 14: 
          localaxy.identification = locala.UbS.readString();
          AppMethodBeat.o(209579);
          return 0;
        }
        localaxy.duration = locala.UbS.zi();
        AppMethodBeat.o(209579);
        return 0;
      }
      AppMethodBeat.o(209579);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.axy
 * JD-Core Version:    0.7.0.1
 */