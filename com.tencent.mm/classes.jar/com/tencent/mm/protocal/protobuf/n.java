package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class n
  extends com.tencent.mm.bx.a
{
  public String YAa;
  public String YAb;
  public String YAc;
  public String YzL;
  public String YzM;
  public long ihV;
  public int role;
  public int state;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91322);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YzL != null) {
        paramVarArgs.g(1, this.YzL);
      }
      if (this.title != null) {
        paramVarArgs.g(2, this.title);
      }
      paramVarArgs.bv(3, this.ihV);
      if (this.YAa != null) {
        paramVarArgs.g(5, this.YAa);
      }
      paramVarArgs.bS(10, this.state);
      paramVarArgs.bS(11, this.role);
      if (this.YAb != null) {
        paramVarArgs.g(12, this.YAb);
      }
      if (this.YzM != null) {
        paramVarArgs.g(13, this.YzM);
      }
      if (this.YAc != null) {
        paramVarArgs.g(14, this.YAc);
      }
      AppMethodBeat.o(91322);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YzL == null) {
        break label670;
      }
    }
    label670:
    for (paramInt = i.a.a.b.b.a.h(1, this.YzL) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.title != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.title);
      }
      i += i.a.a.b.b.a.q(3, this.ihV);
      paramInt = i;
      if (this.YAa != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.YAa);
      }
      i = paramInt + i.a.a.b.b.a.cJ(10, this.state) + i.a.a.b.b.a.cJ(11, this.role);
      paramInt = i;
      if (this.YAb != null) {
        paramInt = i + i.a.a.b.b.a.h(12, this.YAb);
      }
      i = paramInt;
      if (this.YzM != null) {
        i = paramInt + i.a.a.b.b.a.h(13, this.YzM);
      }
      paramInt = i;
      if (this.YAc != null) {
        paramInt = i + i.a.a.b.b.a.h(14, this.YAc);
      }
      AppMethodBeat.o(91322);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91322);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        n localn = (n)paramVarArgs[1];
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
          localn.YzL = locala.ajGk.readString();
          AppMethodBeat.o(91322);
          return 0;
        case 2: 
          localn.title = locala.ajGk.readString();
          AppMethodBeat.o(91322);
          return 0;
        case 3: 
          localn.ihV = locala.ajGk.aaw();
          AppMethodBeat.o(91322);
          return 0;
        case 5: 
          localn.YAa = locala.ajGk.readString();
          AppMethodBeat.o(91322);
          return 0;
        case 10: 
          localn.state = locala.ajGk.aar();
          AppMethodBeat.o(91322);
          return 0;
        case 11: 
          localn.role = locala.ajGk.aar();
          AppMethodBeat.o(91322);
          return 0;
        case 12: 
          localn.YAb = locala.ajGk.readString();
          AppMethodBeat.o(91322);
          return 0;
        case 13: 
          localn.YzM = locala.ajGk.readString();
          AppMethodBeat.o(91322);
          return 0;
        }
        localn.YAc = locala.ajGk.readString();
        AppMethodBeat.o(91322);
        return 0;
      }
      AppMethodBeat.o(91322);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.n
 * JD-Core Version:    0.7.0.1
 */