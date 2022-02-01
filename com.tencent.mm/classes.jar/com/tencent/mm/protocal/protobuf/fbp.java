package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fbp
  extends com.tencent.mm.bw.a
{
  public String IconUrl;
  public int KSa;
  public String MEq;
  public String NxL;
  public String UserName;
  public String hik;
  public String oUJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117957);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MEq != null) {
        paramVarArgs.e(1, this.MEq);
      }
      if (this.UserName != null) {
        paramVarArgs.e(2, this.UserName);
      }
      if (this.oUJ != null) {
        paramVarArgs.e(3, this.oUJ);
      }
      if (this.hik != null) {
        paramVarArgs.e(4, this.hik);
      }
      paramVarArgs.aM(5, this.KSa);
      if (this.NxL != null) {
        paramVarArgs.e(6, this.NxL);
      }
      if (this.IconUrl != null) {
        paramVarArgs.e(7, this.IconUrl);
      }
      AppMethodBeat.o(117957);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MEq == null) {
        break label562;
      }
    }
    label562:
    for (int i = g.a.a.b.b.a.f(1, this.MEq) + 0;; i = 0)
    {
      paramInt = i;
      if (this.UserName != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.UserName);
      }
      i = paramInt;
      if (this.oUJ != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.oUJ);
      }
      paramInt = i;
      if (this.hik != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.hik);
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.KSa);
      paramInt = i;
      if (this.NxL != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.NxL);
      }
      i = paramInt;
      if (this.IconUrl != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.IconUrl);
      }
      AppMethodBeat.o(117957);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(117957);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        fbp localfbp = (fbp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117957);
          return -1;
        case 1: 
          localfbp.MEq = locala.UbS.readString();
          AppMethodBeat.o(117957);
          return 0;
        case 2: 
          localfbp.UserName = locala.UbS.readString();
          AppMethodBeat.o(117957);
          return 0;
        case 3: 
          localfbp.oUJ = locala.UbS.readString();
          AppMethodBeat.o(117957);
          return 0;
        case 4: 
          localfbp.hik = locala.UbS.readString();
          AppMethodBeat.o(117957);
          return 0;
        case 5: 
          localfbp.KSa = locala.UbS.zi();
          AppMethodBeat.o(117957);
          return 0;
        case 6: 
          localfbp.NxL = locala.UbS.readString();
          AppMethodBeat.o(117957);
          return 0;
        }
        localfbp.IconUrl = locala.UbS.readString();
        AppMethodBeat.o(117957);
        return 0;
      }
      AppMethodBeat.o(117957);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fbp
 * JD-Core Version:    0.7.0.1
 */