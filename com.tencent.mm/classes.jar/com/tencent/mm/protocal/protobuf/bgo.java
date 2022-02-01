package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bgo
  extends com.tencent.mm.bw.a
{
  public int KSa;
  public int LQr;
  public String LQs;
  public String LQt;
  public String jfi;
  public com.tencent.mm.bw.b oTm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50086);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.jfi == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: AppId");
        AppMethodBeat.o(50086);
        throw paramVarArgs;
      }
      if (this.oTm == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: Data");
        AppMethodBeat.o(50086);
        throw paramVarArgs;
      }
      if (this.LQt == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: EventInfo");
        AppMethodBeat.o(50086);
        throw paramVarArgs;
      }
      if (this.jfi != null) {
        paramVarArgs.e(1, this.jfi);
      }
      paramVarArgs.aM(2, this.KSa);
      paramVarArgs.aM(3, this.LQr);
      if (this.oTm != null) {
        paramVarArgs.c(4, this.oTm);
      }
      if (this.LQs != null) {
        paramVarArgs.e(5, this.LQs);
      }
      if (this.LQt != null) {
        paramVarArgs.e(6, this.LQt);
      }
      AppMethodBeat.o(50086);
      return 0;
    }
    if (paramInt == 1) {
      if (this.jfi == null) {
        break label626;
      }
    }
    label626:
    for (paramInt = g.a.a.b.b.a.f(1, this.jfi) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.KSa) + g.a.a.b.b.a.bu(3, this.LQr);
      paramInt = i;
      if (this.oTm != null) {
        paramInt = i + g.a.a.b.b.a.b(4, this.oTm);
      }
      i = paramInt;
      if (this.LQs != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.LQs);
      }
      paramInt = i;
      if (this.LQt != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.LQt);
      }
      AppMethodBeat.o(50086);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.jfi == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: AppId");
          AppMethodBeat.o(50086);
          throw paramVarArgs;
        }
        if (this.oTm == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: Data");
          AppMethodBeat.o(50086);
          throw paramVarArgs;
        }
        if (this.LQt == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: EventInfo");
          AppMethodBeat.o(50086);
          throw paramVarArgs;
        }
        AppMethodBeat.o(50086);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        bgo localbgo = (bgo)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(50086);
          return -1;
        case 1: 
          localbgo.jfi = locala.UbS.readString();
          AppMethodBeat.o(50086);
          return 0;
        case 2: 
          localbgo.KSa = locala.UbS.zi();
          AppMethodBeat.o(50086);
          return 0;
        case 3: 
          localbgo.LQr = locala.UbS.zi();
          AppMethodBeat.o(50086);
          return 0;
        case 4: 
          localbgo.oTm = locala.UbS.hPo();
          AppMethodBeat.o(50086);
          return 0;
        case 5: 
          localbgo.LQs = locala.UbS.readString();
          AppMethodBeat.o(50086);
          return 0;
        }
        localbgo.LQt = locala.UbS.readString();
        AppMethodBeat.o(50086);
        return 0;
      }
      AppMethodBeat.o(50086);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bgo
 * JD-Core Version:    0.7.0.1
 */