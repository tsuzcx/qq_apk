package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class axf
  extends com.tencent.mm.bw.a
{
  public String LHG;
  public String LHH;
  public String coverUrl;
  public String desc;
  public String feedId;
  public String hFO;
  public String hJs;
  public String headUrl;
  public float height;
  public int liveStatus;
  public String nickName;
  public String objectNonceId;
  public String username;
  public float width;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(196088);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.hJs != null) {
        paramVarArgs.e(1, this.hJs);
      }
      if (this.username != null) {
        paramVarArgs.e(2, this.username);
      }
      if (this.feedId != null) {
        paramVarArgs.e(3, this.feedId);
      }
      if (this.nickName != null) {
        paramVarArgs.e(4, this.nickName);
      }
      if (this.desc != null) {
        paramVarArgs.e(5, this.desc);
      }
      if (this.coverUrl != null) {
        paramVarArgs.e(6, this.coverUrl);
      }
      paramVarArgs.E(7, this.width);
      paramVarArgs.E(8, this.height);
      if (this.LHG != null) {
        paramVarArgs.e(9, this.LHG);
      }
      if (this.hFO != null) {
        paramVarArgs.e(10, this.hFO);
      }
      if (this.LHH != null) {
        paramVarArgs.e(11, this.LHH);
      }
      if (this.headUrl != null) {
        paramVarArgs.e(12, this.headUrl);
      }
      if (this.objectNonceId != null) {
        paramVarArgs.e(13, this.objectNonceId);
      }
      paramVarArgs.aM(14, this.liveStatus);
      AppMethodBeat.o(196088);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hJs == null) {
        break label964;
      }
    }
    label964:
    for (int i = g.a.a.b.b.a.f(1, this.hJs) + 0;; i = 0)
    {
      paramInt = i;
      if (this.username != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.username);
      }
      i = paramInt;
      if (this.feedId != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.feedId);
      }
      paramInt = i;
      if (this.nickName != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.nickName);
      }
      i = paramInt;
      if (this.desc != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.desc);
      }
      paramInt = i;
      if (this.coverUrl != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.coverUrl);
      }
      i = paramInt + (g.a.a.b.b.a.fS(7) + 4) + (g.a.a.b.b.a.fS(8) + 4);
      paramInt = i;
      if (this.LHG != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.LHG);
      }
      i = paramInt;
      if (this.hFO != null) {
        i = paramInt + g.a.a.b.b.a.f(10, this.hFO);
      }
      paramInt = i;
      if (this.LHH != null) {
        paramInt = i + g.a.a.b.b.a.f(11, this.LHH);
      }
      i = paramInt;
      if (this.headUrl != null) {
        i = paramInt + g.a.a.b.b.a.f(12, this.headUrl);
      }
      paramInt = i;
      if (this.objectNonceId != null) {
        paramInt = i + g.a.a.b.b.a.f(13, this.objectNonceId);
      }
      i = g.a.a.b.b.a.bu(14, this.liveStatus);
      AppMethodBeat.o(196088);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(196088);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        axf localaxf = (axf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(196088);
          return -1;
        case 1: 
          localaxf.hJs = locala.UbS.readString();
          AppMethodBeat.o(196088);
          return 0;
        case 2: 
          localaxf.username = locala.UbS.readString();
          AppMethodBeat.o(196088);
          return 0;
        case 3: 
          localaxf.feedId = locala.UbS.readString();
          AppMethodBeat.o(196088);
          return 0;
        case 4: 
          localaxf.nickName = locala.UbS.readString();
          AppMethodBeat.o(196088);
          return 0;
        case 5: 
          localaxf.desc = locala.UbS.readString();
          AppMethodBeat.o(196088);
          return 0;
        case 6: 
          localaxf.coverUrl = locala.UbS.readString();
          AppMethodBeat.o(196088);
          return 0;
        case 7: 
          localaxf.width = Float.intBitsToFloat(locala.UbS.zm());
          AppMethodBeat.o(196088);
          return 0;
        case 8: 
          localaxf.height = Float.intBitsToFloat(locala.UbS.zm());
          AppMethodBeat.o(196088);
          return 0;
        case 9: 
          localaxf.LHG = locala.UbS.readString();
          AppMethodBeat.o(196088);
          return 0;
        case 10: 
          localaxf.hFO = locala.UbS.readString();
          AppMethodBeat.o(196088);
          return 0;
        case 11: 
          localaxf.LHH = locala.UbS.readString();
          AppMethodBeat.o(196088);
          return 0;
        case 12: 
          localaxf.headUrl = locala.UbS.readString();
          AppMethodBeat.o(196088);
          return 0;
        case 13: 
          localaxf.objectNonceId = locala.UbS.readString();
          AppMethodBeat.o(196088);
          return 0;
        }
        localaxf.liveStatus = locala.UbS.zi();
        AppMethodBeat.o(196088);
        return 0;
      }
      AppMethodBeat.o(196088);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.axf
 * JD-Core Version:    0.7.0.1
 */