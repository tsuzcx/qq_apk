package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cxs
  extends com.tencent.mm.bw.a
{
  public String MCA;
  public String MCB;
  public String MCC;
  public String MCD;
  public String MCx;
  public String MCy;
  public String MCz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209773);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MCx != null) {
        paramVarArgs.e(1, this.MCx);
      }
      if (this.MCy != null) {
        paramVarArgs.e(2, this.MCy);
      }
      if (this.MCz != null) {
        paramVarArgs.e(3, this.MCz);
      }
      if (this.MCA != null) {
        paramVarArgs.e(4, this.MCA);
      }
      if (this.MCB != null) {
        paramVarArgs.e(5, this.MCB);
      }
      if (this.MCC != null) {
        paramVarArgs.e(6, this.MCC);
      }
      if (this.MCD != null) {
        paramVarArgs.e(7, this.MCD);
      }
      AppMethodBeat.o(209773);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MCx == null) {
        break label578;
      }
    }
    label578:
    for (int i = g.a.a.b.b.a.f(1, this.MCx) + 0;; i = 0)
    {
      paramInt = i;
      if (this.MCy != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.MCy);
      }
      i = paramInt;
      if (this.MCz != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.MCz);
      }
      paramInt = i;
      if (this.MCA != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.MCA);
      }
      i = paramInt;
      if (this.MCB != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.MCB);
      }
      paramInt = i;
      if (this.MCC != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.MCC);
      }
      i = paramInt;
      if (this.MCD != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.MCD);
      }
      AppMethodBeat.o(209773);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209773);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cxs localcxs = (cxs)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(209773);
          return -1;
        case 1: 
          localcxs.MCx = locala.UbS.readString();
          AppMethodBeat.o(209773);
          return 0;
        case 2: 
          localcxs.MCy = locala.UbS.readString();
          AppMethodBeat.o(209773);
          return 0;
        case 3: 
          localcxs.MCz = locala.UbS.readString();
          AppMethodBeat.o(209773);
          return 0;
        case 4: 
          localcxs.MCA = locala.UbS.readString();
          AppMethodBeat.o(209773);
          return 0;
        case 5: 
          localcxs.MCB = locala.UbS.readString();
          AppMethodBeat.o(209773);
          return 0;
        case 6: 
          localcxs.MCC = locala.UbS.readString();
          AppMethodBeat.o(209773);
          return 0;
        }
        localcxs.MCD = locala.UbS.readString();
        AppMethodBeat.o(209773);
        return 0;
      }
      AppMethodBeat.o(209773);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cxs
 * JD-Core Version:    0.7.0.1
 */