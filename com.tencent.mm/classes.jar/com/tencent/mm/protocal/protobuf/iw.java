package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class iw
  extends com.tencent.mm.bw.a
{
  public String HLy;
  public String Hwr;
  public String Hws;
  public String title;
  public int uSc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91354);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.e(1, this.title);
      }
      paramVarArgs.aM(2, this.uSc);
      if (this.HLy != null) {
        paramVarArgs.e(3, this.HLy);
      }
      if (this.Hwr != null) {
        paramVarArgs.e(4, this.Hwr);
      }
      if (this.Hws != null) {
        paramVarArgs.e(5, this.Hws);
      }
      AppMethodBeat.o(91354);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label438;
      }
    }
    label438:
    for (paramInt = g.a.a.b.b.a.f(1, this.title) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.uSc);
      paramInt = i;
      if (this.HLy != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.HLy);
      }
      i = paramInt;
      if (this.Hwr != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.Hwr);
      }
      paramInt = i;
      if (this.Hws != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.Hws);
      }
      AppMethodBeat.o(91354);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91354);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        iw localiw = (iw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91354);
          return -1;
        case 1: 
          localiw.title = locala.UbS.readString();
          AppMethodBeat.o(91354);
          return 0;
        case 2: 
          localiw.uSc = locala.UbS.zi();
          AppMethodBeat.o(91354);
          return 0;
        case 3: 
          localiw.HLy = locala.UbS.readString();
          AppMethodBeat.o(91354);
          return 0;
        case 4: 
          localiw.Hwr = locala.UbS.readString();
          AppMethodBeat.o(91354);
          return 0;
        }
        localiw.Hws = locala.UbS.readString();
        AppMethodBeat.o(91354);
        return 0;
      }
      AppMethodBeat.o(91354);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.iw
 * JD-Core Version:    0.7.0.1
 */