package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class drb
  extends com.tencent.mm.bw.a
{
  public String Desc;
  public String KWK;
  public int MTI;
  public String MTJ;
  public String MTK;
  public String Mjt;
  public String nBo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123643);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KWK != null) {
        paramVarArgs.e(1, this.KWK);
      }
      if (this.Desc != null) {
        paramVarArgs.e(2, this.Desc);
      }
      paramVarArgs.aM(3, this.MTI);
      if (this.nBo != null) {
        paramVarArgs.e(4, this.nBo);
      }
      if (this.Mjt != null) {
        paramVarArgs.e(5, this.Mjt);
      }
      if (this.MTJ != null) {
        paramVarArgs.e(6, this.MTJ);
      }
      if (this.MTK != null) {
        paramVarArgs.e(7, this.MTK);
      }
      AppMethodBeat.o(123643);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KWK == null) {
        break label562;
      }
    }
    label562:
    for (paramInt = g.a.a.b.b.a.f(1, this.KWK) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Desc != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.Desc);
      }
      i += g.a.a.b.b.a.bu(3, this.MTI);
      paramInt = i;
      if (this.nBo != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.nBo);
      }
      i = paramInt;
      if (this.Mjt != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.Mjt);
      }
      paramInt = i;
      if (this.MTJ != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.MTJ);
      }
      i = paramInt;
      if (this.MTK != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.MTK);
      }
      AppMethodBeat.o(123643);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(123643);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        drb localdrb = (drb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123643);
          return -1;
        case 1: 
          localdrb.KWK = locala.UbS.readString();
          AppMethodBeat.o(123643);
          return 0;
        case 2: 
          localdrb.Desc = locala.UbS.readString();
          AppMethodBeat.o(123643);
          return 0;
        case 3: 
          localdrb.MTI = locala.UbS.zi();
          AppMethodBeat.o(123643);
          return 0;
        case 4: 
          localdrb.nBo = locala.UbS.readString();
          AppMethodBeat.o(123643);
          return 0;
        case 5: 
          localdrb.Mjt = locala.UbS.readString();
          AppMethodBeat.o(123643);
          return 0;
        case 6: 
          localdrb.MTJ = locala.UbS.readString();
          AppMethodBeat.o(123643);
          return 0;
        }
        localdrb.MTK = locala.UbS.readString();
        AppMethodBeat.o(123643);
        return 0;
      }
      AppMethodBeat.o(123643);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.drb
 * JD-Core Version:    0.7.0.1
 */