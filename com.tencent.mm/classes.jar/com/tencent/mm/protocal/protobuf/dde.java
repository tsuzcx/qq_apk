package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dde
  extends com.tencent.mm.bw.a
{
  public String HFD;
  public String HLy;
  public String Hwr;
  public String Hws;
  public String MIh;
  public String dQx;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91620);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.dQx != null) {
        paramVarArgs.e(1, this.dQx);
      }
      paramVarArgs.aM(2, this.type);
      if (this.HLy != null) {
        paramVarArgs.e(3, this.HLy);
      }
      if (this.Hwr != null) {
        paramVarArgs.e(4, this.Hwr);
      }
      if (this.Hws != null) {
        paramVarArgs.e(5, this.Hws);
      }
      if (this.MIh != null) {
        paramVarArgs.e(6, this.MIh);
      }
      if (this.HFD != null) {
        paramVarArgs.e(7, this.HFD);
      }
      AppMethodBeat.o(91620);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dQx == null) {
        break label562;
      }
    }
    label562:
    for (paramInt = g.a.a.b.b.a.f(1, this.dQx) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.type);
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
      i = paramInt;
      if (this.MIh != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.MIh);
      }
      paramInt = i;
      if (this.HFD != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.HFD);
      }
      AppMethodBeat.o(91620);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91620);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dde localdde = (dde)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91620);
          return -1;
        case 1: 
          localdde.dQx = locala.UbS.readString();
          AppMethodBeat.o(91620);
          return 0;
        case 2: 
          localdde.type = locala.UbS.zi();
          AppMethodBeat.o(91620);
          return 0;
        case 3: 
          localdde.HLy = locala.UbS.readString();
          AppMethodBeat.o(91620);
          return 0;
        case 4: 
          localdde.Hwr = locala.UbS.readString();
          AppMethodBeat.o(91620);
          return 0;
        case 5: 
          localdde.Hws = locala.UbS.readString();
          AppMethodBeat.o(91620);
          return 0;
        case 6: 
          localdde.MIh = locala.UbS.readString();
          AppMethodBeat.o(91620);
          return 0;
        }
        localdde.HFD = locala.UbS.readString();
        AppMethodBeat.o(91620);
        return 0;
      }
      AppMethodBeat.o(91620);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dde
 * JD-Core Version:    0.7.0.1
 */