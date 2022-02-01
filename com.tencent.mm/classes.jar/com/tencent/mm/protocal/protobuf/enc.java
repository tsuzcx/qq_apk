package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class enc
  extends com.tencent.mm.cd.a
{
  public String CPs;
  public String ThumbUrl;
  public long UpP;
  public int UpQ;
  public int UpR;
  public String UserName;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118434);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UserName != null) {
        paramVarArgs.f(1, this.UserName);
      }
      paramVarArgs.bm(2, this.UpP);
      paramVarArgs.aY(3, this.UpQ);
      if (this.ThumbUrl != null) {
        paramVarArgs.f(4, this.ThumbUrl);
      }
      paramVarArgs.aY(5, this.UpR);
      if (this.CPs != null) {
        paramVarArgs.f(6, this.CPs);
      }
      AppMethodBeat.o(118434);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UserName == null) {
        break label466;
      }
    }
    label466:
    for (paramInt = g.a.a.b.b.a.g(1, this.UserName) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.p(2, this.UpP) + g.a.a.b.b.a.bM(3, this.UpQ);
      paramInt = i;
      if (this.ThumbUrl != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.ThumbUrl);
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.UpR);
      paramInt = i;
      if (this.CPs != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.CPs);
      }
      AppMethodBeat.o(118434);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(118434);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        enc localenc = (enc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(118434);
          return -1;
        case 1: 
          localenc.UserName = locala.abFh.readString();
          AppMethodBeat.o(118434);
          return 0;
        case 2: 
          localenc.UpP = locala.abFh.AN();
          AppMethodBeat.o(118434);
          return 0;
        case 3: 
          localenc.UpQ = locala.abFh.AK();
          AppMethodBeat.o(118434);
          return 0;
        case 4: 
          localenc.ThumbUrl = locala.abFh.readString();
          AppMethodBeat.o(118434);
          return 0;
        case 5: 
          localenc.UpR = locala.abFh.AK();
          AppMethodBeat.o(118434);
          return 0;
        }
        localenc.CPs = locala.abFh.readString();
        AppMethodBeat.o(118434);
        return 0;
      }
      AppMethodBeat.o(118434);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.enc
 * JD-Core Version:    0.7.0.1
 */