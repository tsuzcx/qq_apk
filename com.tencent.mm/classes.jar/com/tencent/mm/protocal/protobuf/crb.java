package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class crb
  extends com.tencent.mm.bw.a
{
  public String MbW;
  public String Meq;
  public String Mer;
  public String dPS;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123628);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MbW != null) {
        paramVarArgs.e(1, this.MbW);
      }
      if (this.url != null) {
        paramVarArgs.e(2, this.url);
      }
      if (this.dPS != null) {
        paramVarArgs.e(3, this.dPS);
      }
      if (this.Meq != null) {
        paramVarArgs.e(4, this.Meq);
      }
      if (this.Mer != null) {
        paramVarArgs.e(5, this.Mer);
      }
      AppMethodBeat.o(123628);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MbW == null) {
        break label454;
      }
    }
    label454:
    for (int i = g.a.a.b.b.a.f(1, this.MbW) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.url);
      }
      i = paramInt;
      if (this.dPS != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.dPS);
      }
      paramInt = i;
      if (this.Meq != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.Meq);
      }
      i = paramInt;
      if (this.Mer != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.Mer);
      }
      AppMethodBeat.o(123628);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(123628);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        crb localcrb = (crb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123628);
          return -1;
        case 1: 
          localcrb.MbW = locala.UbS.readString();
          AppMethodBeat.o(123628);
          return 0;
        case 2: 
          localcrb.url = locala.UbS.readString();
          AppMethodBeat.o(123628);
          return 0;
        case 3: 
          localcrb.dPS = locala.UbS.readString();
          AppMethodBeat.o(123628);
          return 0;
        case 4: 
          localcrb.Meq = locala.UbS.readString();
          AppMethodBeat.o(123628);
          return 0;
        }
        localcrb.Mer = locala.UbS.readString();
        AppMethodBeat.o(123628);
        return 0;
      }
      AppMethodBeat.o(123628);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.crb
 * JD-Core Version:    0.7.0.1
 */