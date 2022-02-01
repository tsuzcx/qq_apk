package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dab
  extends com.tencent.mm.bx.a
{
  public String Ocp;
  public String YYi;
  public String aaFv;
  public long aaFw;
  public String aaFx;
  public String aaFy;
  public String aaFz;
  public int state;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72500);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YYi != null) {
        paramVarArgs.g(1, this.YYi);
      }
      paramVarArgs.bS(2, this.state);
      if (this.title != null) {
        paramVarArgs.g(3, this.title);
      }
      if (this.aaFv != null) {
        paramVarArgs.g(4, this.aaFv);
      }
      paramVarArgs.bv(5, this.aaFw);
      if (this.aaFx != null) {
        paramVarArgs.g(6, this.aaFx);
      }
      if (this.Ocp != null) {
        paramVarArgs.g(7, this.Ocp);
      }
      if (this.aaFy != null) {
        paramVarArgs.g(8, this.aaFy);
      }
      if (this.aaFz != null) {
        paramVarArgs.g(9, this.aaFz);
      }
      AppMethodBeat.o(72500);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YYi == null) {
        break label666;
      }
    }
    label666:
    for (paramInt = i.a.a.b.b.a.h(1, this.YYi) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.state);
      paramInt = i;
      if (this.title != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.title);
      }
      i = paramInt;
      if (this.aaFv != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.aaFv);
      }
      i += i.a.a.b.b.a.q(5, this.aaFw);
      paramInt = i;
      if (this.aaFx != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.aaFx);
      }
      i = paramInt;
      if (this.Ocp != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.Ocp);
      }
      paramInt = i;
      if (this.aaFy != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.aaFy);
      }
      i = paramInt;
      if (this.aaFz != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.aaFz);
      }
      AppMethodBeat.o(72500);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(72500);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        dab localdab = (dab)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72500);
          return -1;
        case 1: 
          localdab.YYi = locala.ajGk.readString();
          AppMethodBeat.o(72500);
          return 0;
        case 2: 
          localdab.state = locala.ajGk.aar();
          AppMethodBeat.o(72500);
          return 0;
        case 3: 
          localdab.title = locala.ajGk.readString();
          AppMethodBeat.o(72500);
          return 0;
        case 4: 
          localdab.aaFv = locala.ajGk.readString();
          AppMethodBeat.o(72500);
          return 0;
        case 5: 
          localdab.aaFw = locala.ajGk.aaw();
          AppMethodBeat.o(72500);
          return 0;
        case 6: 
          localdab.aaFx = locala.ajGk.readString();
          AppMethodBeat.o(72500);
          return 0;
        case 7: 
          localdab.Ocp = locala.ajGk.readString();
          AppMethodBeat.o(72500);
          return 0;
        case 8: 
          localdab.aaFy = locala.ajGk.readString();
          AppMethodBeat.o(72500);
          return 0;
        }
        localdab.aaFz = locala.ajGk.readString();
        AppMethodBeat.o(72500);
        return 0;
      }
      AppMethodBeat.o(72500);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dab
 * JD-Core Version:    0.7.0.1
 */