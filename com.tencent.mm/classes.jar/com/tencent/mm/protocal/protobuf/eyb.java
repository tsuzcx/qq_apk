package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eyb
  extends com.tencent.mm.bw.a
{
  public String KLO;
  public String Nvj;
  public String Nvk;
  public String Nvl;
  public String hid;
  public String hie;
  public String hif;
  public String hig;
  public String oTI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116822);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KLO != null) {
        paramVarArgs.e(1, this.KLO);
      }
      if (this.hie != null) {
        paramVarArgs.e(2, this.hie);
      }
      if (this.hid != null) {
        paramVarArgs.e(3, this.hid);
      }
      if (this.oTI != null) {
        paramVarArgs.e(4, this.oTI);
      }
      if (this.Nvj != null) {
        paramVarArgs.e(5, this.Nvj);
      }
      if (this.hif != null) {
        paramVarArgs.e(6, this.hif);
      }
      if (this.hig != null) {
        paramVarArgs.e(7, this.hig);
      }
      if (this.Nvk != null) {
        paramVarArgs.e(8, this.Nvk);
      }
      if (this.Nvl != null) {
        paramVarArgs.e(9, this.Nvl);
      }
      AppMethodBeat.o(116822);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KLO == null) {
        break label702;
      }
    }
    label702:
    for (int i = g.a.a.b.b.a.f(1, this.KLO) + 0;; i = 0)
    {
      paramInt = i;
      if (this.hie != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.hie);
      }
      i = paramInt;
      if (this.hid != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.hid);
      }
      paramInt = i;
      if (this.oTI != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.oTI);
      }
      i = paramInt;
      if (this.Nvj != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.Nvj);
      }
      paramInt = i;
      if (this.hif != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.hif);
      }
      i = paramInt;
      if (this.hig != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.hig);
      }
      paramInt = i;
      if (this.Nvk != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.Nvk);
      }
      i = paramInt;
      if (this.Nvl != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.Nvl);
      }
      AppMethodBeat.o(116822);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(116822);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        eyb localeyb = (eyb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(116822);
          return -1;
        case 1: 
          localeyb.KLO = locala.UbS.readString();
          AppMethodBeat.o(116822);
          return 0;
        case 2: 
          localeyb.hie = locala.UbS.readString();
          AppMethodBeat.o(116822);
          return 0;
        case 3: 
          localeyb.hid = locala.UbS.readString();
          AppMethodBeat.o(116822);
          return 0;
        case 4: 
          localeyb.oTI = locala.UbS.readString();
          AppMethodBeat.o(116822);
          return 0;
        case 5: 
          localeyb.Nvj = locala.UbS.readString();
          AppMethodBeat.o(116822);
          return 0;
        case 6: 
          localeyb.hif = locala.UbS.readString();
          AppMethodBeat.o(116822);
          return 0;
        case 7: 
          localeyb.hig = locala.UbS.readString();
          AppMethodBeat.o(116822);
          return 0;
        case 8: 
          localeyb.Nvk = locala.UbS.readString();
          AppMethodBeat.o(116822);
          return 0;
        }
        localeyb.Nvl = locala.UbS.readString();
        AppMethodBeat.o(116822);
        return 0;
      }
      AppMethodBeat.o(116822);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eyb
 * JD-Core Version:    0.7.0.1
 */