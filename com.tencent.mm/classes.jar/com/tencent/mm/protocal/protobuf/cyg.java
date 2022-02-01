package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cyg
  extends com.tencent.mm.bw.a
{
  public String Desc;
  public String GcE;
  public int HIx;
  public String HIy;
  public String Hek;
  public String mqC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123643);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GcE != null) {
        paramVarArgs.d(1, this.GcE);
      }
      if (this.Desc != null) {
        paramVarArgs.d(2, this.Desc);
      }
      paramVarArgs.aS(3, this.HIx);
      if (this.mqC != null) {
        paramVarArgs.d(4, this.mqC);
      }
      if (this.Hek != null) {
        paramVarArgs.d(5, this.Hek);
      }
      if (this.HIy != null) {
        paramVarArgs.d(6, this.HIy);
      }
      AppMethodBeat.o(123643);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GcE == null) {
        break label502;
      }
    }
    label502:
    for (paramInt = f.a.a.b.b.a.e(1, this.GcE) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Desc != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Desc);
      }
      i += f.a.a.b.b.a.bz(3, this.HIx);
      paramInt = i;
      if (this.mqC != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.mqC);
      }
      i = paramInt;
      if (this.Hek != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Hek);
      }
      paramInt = i;
      if (this.HIy != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.HIy);
      }
      AppMethodBeat.o(123643);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(123643);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cyg localcyg = (cyg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123643);
          return -1;
        case 1: 
          localcyg.GcE = locala.OmT.readString();
          AppMethodBeat.o(123643);
          return 0;
        case 2: 
          localcyg.Desc = locala.OmT.readString();
          AppMethodBeat.o(123643);
          return 0;
        case 3: 
          localcyg.HIx = locala.OmT.zc();
          AppMethodBeat.o(123643);
          return 0;
        case 4: 
          localcyg.mqC = locala.OmT.readString();
          AppMethodBeat.o(123643);
          return 0;
        case 5: 
          localcyg.Hek = locala.OmT.readString();
          AppMethodBeat.o(123643);
          return 0;
        }
        localcyg.HIy = locala.OmT.readString();
        AppMethodBeat.o(123643);
        return 0;
      }
      AppMethodBeat.o(123643);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cyg
 * JD-Core Version:    0.7.0.1
 */