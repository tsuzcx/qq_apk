package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class cor
  extends com.tencent.mm.bw.a
{
  public String MuQ;
  public String MuR;
  public String MuS;
  public int MuT;
  public String dQx;
  public int type;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91538);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.dQx == null)
      {
        paramVarArgs = new b("Not all required fields were included: wording");
        AppMethodBeat.o(91538);
        throw paramVarArgs;
      }
      paramVarArgs.aM(1, this.type);
      if (this.dQx != null) {
        paramVarArgs.e(2, this.dQx);
      }
      if (this.url != null) {
        paramVarArgs.e(3, this.url);
      }
      if (this.MuQ != null) {
        paramVarArgs.e(4, this.MuQ);
      }
      if (this.MuR != null) {
        paramVarArgs.e(5, this.MuR);
      }
      if (this.MuS != null) {
        paramVarArgs.e(6, this.MuS);
      }
      paramVarArgs.aM(7, this.MuT);
      AppMethodBeat.o(91538);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.type) + 0;
      paramInt = i;
      if (this.dQx != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.dQx);
      }
      i = paramInt;
      if (this.url != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.url);
      }
      paramInt = i;
      if (this.MuQ != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.MuQ);
      }
      i = paramInt;
      if (this.MuR != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.MuR);
      }
      paramInt = i;
      if (this.MuS != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.MuS);
      }
      i = g.a.a.b.b.a.bu(7, this.MuT);
      AppMethodBeat.o(91538);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      if (this.dQx == null)
      {
        paramVarArgs = new b("Not all required fields were included: wording");
        AppMethodBeat.o(91538);
        throw paramVarArgs;
      }
      AppMethodBeat.o(91538);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      cor localcor = (cor)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91538);
        return -1;
      case 1: 
        localcor.type = locala.UbS.zi();
        AppMethodBeat.o(91538);
        return 0;
      case 2: 
        localcor.dQx = locala.UbS.readString();
        AppMethodBeat.o(91538);
        return 0;
      case 3: 
        localcor.url = locala.UbS.readString();
        AppMethodBeat.o(91538);
        return 0;
      case 4: 
        localcor.MuQ = locala.UbS.readString();
        AppMethodBeat.o(91538);
        return 0;
      case 5: 
        localcor.MuR = locala.UbS.readString();
        AppMethodBeat.o(91538);
        return 0;
      case 6: 
        localcor.MuS = locala.UbS.readString();
        AppMethodBeat.o(91538);
        return 0;
      }
      localcor.MuT = locala.UbS.zi();
      AppMethodBeat.o(91538);
      return 0;
    }
    AppMethodBeat.o(91538);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cor
 * JD-Core Version:    0.7.0.1
 */