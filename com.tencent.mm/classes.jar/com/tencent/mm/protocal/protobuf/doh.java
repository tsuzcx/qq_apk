package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class doh
  extends com.tencent.mm.bw.a
{
  public String DPS;
  public String Etm;
  public String FWf;
  public String iJY;
  public String ncR;
  public String ndW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117939);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ncR == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(117939);
        throw paramVarArgs;
      }
      if (this.FWf == null)
      {
        paramVarArgs = new b("Not all required fields were included: MatchWord");
        AppMethodBeat.o(117939);
        throw paramVarArgs;
      }
      if (this.ncR != null) {
        paramVarArgs.d(1, this.ncR);
      }
      if (this.FWf != null) {
        paramVarArgs.d(2, this.FWf);
      }
      if (this.ndW != null) {
        paramVarArgs.d(3, this.ndW);
      }
      if (this.Etm != null) {
        paramVarArgs.d(4, this.Etm);
      }
      if (this.iJY != null) {
        paramVarArgs.d(5, this.iJY);
      }
      if (this.DPS != null) {
        paramVarArgs.d(6, this.DPS);
      }
      AppMethodBeat.o(117939);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ncR == null) {
        break label614;
      }
    }
    label614:
    for (int i = f.a.a.b.b.a.e(1, this.ncR) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FWf != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FWf);
      }
      i = paramInt;
      if (this.ndW != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.ndW);
      }
      paramInt = i;
      if (this.Etm != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Etm);
      }
      i = paramInt;
      if (this.iJY != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.iJY);
      }
      paramInt = i;
      if (this.DPS != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.DPS);
      }
      AppMethodBeat.o(117939);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.ncR == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserName");
          AppMethodBeat.o(117939);
          throw paramVarArgs;
        }
        if (this.FWf == null)
        {
          paramVarArgs = new b("Not all required fields were included: MatchWord");
          AppMethodBeat.o(117939);
          throw paramVarArgs;
        }
        AppMethodBeat.o(117939);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        doh localdoh = (doh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117939);
          return -1;
        case 1: 
          localdoh.ncR = locala.LVo.readString();
          AppMethodBeat.o(117939);
          return 0;
        case 2: 
          localdoh.FWf = locala.LVo.readString();
          AppMethodBeat.o(117939);
          return 0;
        case 3: 
          localdoh.ndW = locala.LVo.readString();
          AppMethodBeat.o(117939);
          return 0;
        case 4: 
          localdoh.Etm = locala.LVo.readString();
          AppMethodBeat.o(117939);
          return 0;
        case 5: 
          localdoh.iJY = locala.LVo.readString();
          AppMethodBeat.o(117939);
          return 0;
        }
        localdoh.DPS = locala.LVo.readString();
        AppMethodBeat.o(117939);
        return 0;
      }
      AppMethodBeat.o(117939);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.doh
 * JD-Core Version:    0.7.0.1
 */