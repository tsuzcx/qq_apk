package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class m
  extends com.tencent.mm.bw.a
{
  public String KBG;
  public String KBH;
  public String KBI;
  public String KBs;
  public String KBt;
  public long eht;
  public int role;
  public int state;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91322);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KBs != null) {
        paramVarArgs.e(1, this.KBs);
      }
      if (this.title != null) {
        paramVarArgs.e(2, this.title);
      }
      paramVarArgs.bb(3, this.eht);
      if (this.KBG != null) {
        paramVarArgs.e(5, this.KBG);
      }
      paramVarArgs.aM(10, this.state);
      paramVarArgs.aM(11, this.role);
      if (this.KBH != null) {
        paramVarArgs.e(12, this.KBH);
      }
      if (this.KBt != null) {
        paramVarArgs.e(13, this.KBt);
      }
      if (this.KBI != null) {
        paramVarArgs.e(14, this.KBI);
      }
      AppMethodBeat.o(91322);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KBs == null) {
        break label674;
      }
    }
    label674:
    for (paramInt = g.a.a.b.b.a.f(1, this.KBs) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.title != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.title);
      }
      i += g.a.a.b.b.a.r(3, this.eht);
      paramInt = i;
      if (this.KBG != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.KBG);
      }
      i = paramInt + g.a.a.b.b.a.bu(10, this.state) + g.a.a.b.b.a.bu(11, this.role);
      paramInt = i;
      if (this.KBH != null) {
        paramInt = i + g.a.a.b.b.a.f(12, this.KBH);
      }
      i = paramInt;
      if (this.KBt != null) {
        i = paramInt + g.a.a.b.b.a.f(13, this.KBt);
      }
      paramInt = i;
      if (this.KBI != null) {
        paramInt = i + g.a.a.b.b.a.f(14, this.KBI);
      }
      AppMethodBeat.o(91322);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91322);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        m localm = (m)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 4: 
        case 6: 
        case 7: 
        case 8: 
        case 9: 
        default: 
          AppMethodBeat.o(91322);
          return -1;
        case 1: 
          localm.KBs = locala.UbS.readString();
          AppMethodBeat.o(91322);
          return 0;
        case 2: 
          localm.title = locala.UbS.readString();
          AppMethodBeat.o(91322);
          return 0;
        case 3: 
          localm.eht = locala.UbS.zl();
          AppMethodBeat.o(91322);
          return 0;
        case 5: 
          localm.KBG = locala.UbS.readString();
          AppMethodBeat.o(91322);
          return 0;
        case 10: 
          localm.state = locala.UbS.zi();
          AppMethodBeat.o(91322);
          return 0;
        case 11: 
          localm.role = locala.UbS.zi();
          AppMethodBeat.o(91322);
          return 0;
        case 12: 
          localm.KBH = locala.UbS.readString();
          AppMethodBeat.o(91322);
          return 0;
        case 13: 
          localm.KBt = locala.UbS.readString();
          AppMethodBeat.o(91322);
          return 0;
        }
        localm.KBI = locala.UbS.readString();
        AppMethodBeat.o(91322);
        return 0;
      }
      AppMethodBeat.o(91322);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.m
 * JD-Core Version:    0.7.0.1
 */