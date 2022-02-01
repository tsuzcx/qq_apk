package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class duv
  extends com.tencent.mm.bx.a
{
  public String ADE;
  public String YTl;
  public String YYY;
  public int Zms;
  public int abaJ;
  public String abaK;
  public int duration;
  public int height;
  public String nUO;
  public String title;
  public String vPS;
  public String vid;
  public int width;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(176147);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.vPS != null) {
        paramVarArgs.g(1, this.vPS);
      }
      paramVarArgs.bS(2, this.duration);
      if (this.ADE != null) {
        paramVarArgs.g(3, this.ADE);
      }
      if (this.YTl != null) {
        paramVarArgs.g(4, this.YTl);
      }
      if (this.title != null) {
        paramVarArgs.g(5, this.title);
      }
      if (this.nUO != null) {
        paramVarArgs.g(6, this.nUO);
      }
      paramVarArgs.bS(7, this.abaJ);
      paramVarArgs.bS(8, this.width);
      paramVarArgs.bS(9, this.height);
      if (this.YYY != null) {
        paramVarArgs.g(10, this.YYY);
      }
      if (this.vid != null) {
        paramVarArgs.g(11, this.vid);
      }
      if (this.abaK != null) {
        paramVarArgs.g(12, this.abaK);
      }
      paramVarArgs.bS(13, this.Zms);
      AppMethodBeat.o(176147);
      return 0;
    }
    if (paramInt == 1) {
      if (this.vPS == null) {
        break label862;
      }
    }
    label862:
    for (paramInt = i.a.a.b.b.a.h(1, this.vPS) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.duration);
      paramInt = i;
      if (this.ADE != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.ADE);
      }
      i = paramInt;
      if (this.YTl != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.YTl);
      }
      paramInt = i;
      if (this.title != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.title);
      }
      i = paramInt;
      if (this.nUO != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.nUO);
      }
      i = i + i.a.a.b.b.a.cJ(7, this.abaJ) + i.a.a.b.b.a.cJ(8, this.width) + i.a.a.b.b.a.cJ(9, this.height);
      paramInt = i;
      if (this.YYY != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.YYY);
      }
      i = paramInt;
      if (this.vid != null) {
        i = paramInt + i.a.a.b.b.a.h(11, this.vid);
      }
      paramInt = i;
      if (this.abaK != null) {
        paramInt = i + i.a.a.b.b.a.h(12, this.abaK);
      }
      i = i.a.a.b.b.a.cJ(13, this.Zms);
      AppMethodBeat.o(176147);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(176147);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        duv localduv = (duv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(176147);
          return -1;
        case 1: 
          localduv.vPS = locala.ajGk.readString();
          AppMethodBeat.o(176147);
          return 0;
        case 2: 
          localduv.duration = locala.ajGk.aar();
          AppMethodBeat.o(176147);
          return 0;
        case 3: 
          localduv.ADE = locala.ajGk.readString();
          AppMethodBeat.o(176147);
          return 0;
        case 4: 
          localduv.YTl = locala.ajGk.readString();
          AppMethodBeat.o(176147);
          return 0;
        case 5: 
          localduv.title = locala.ajGk.readString();
          AppMethodBeat.o(176147);
          return 0;
        case 6: 
          localduv.nUO = locala.ajGk.readString();
          AppMethodBeat.o(176147);
          return 0;
        case 7: 
          localduv.abaJ = locala.ajGk.aar();
          AppMethodBeat.o(176147);
          return 0;
        case 8: 
          localduv.width = locala.ajGk.aar();
          AppMethodBeat.o(176147);
          return 0;
        case 9: 
          localduv.height = locala.ajGk.aar();
          AppMethodBeat.o(176147);
          return 0;
        case 10: 
          localduv.YYY = locala.ajGk.readString();
          AppMethodBeat.o(176147);
          return 0;
        case 11: 
          localduv.vid = locala.ajGk.readString();
          AppMethodBeat.o(176147);
          return 0;
        case 12: 
          localduv.abaK = locala.ajGk.readString();
          AppMethodBeat.o(176147);
          return 0;
        }
        localduv.Zms = locala.ajGk.aar();
        AppMethodBeat.o(176147);
        return 0;
      }
      AppMethodBeat.o(176147);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.duv
 * JD-Core Version:    0.7.0.1
 */