package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cfo
  extends com.tencent.mm.bw.a
{
  public String Guf;
  public String Gug;
  public int Hsr;
  public String Hss;
  public String Hst;
  public String appId;
  public String bVF;
  public String fXp;
  public String userName;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152637);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.userName != null) {
        paramVarArgs.d(1, this.userName);
      }
      if (this.bVF != null) {
        paramVarArgs.d(2, this.bVF);
      }
      if (this.fXp != null) {
        paramVarArgs.d(3, this.fXp);
      }
      if (this.Guf != null) {
        paramVarArgs.d(4, this.Guf);
      }
      if (this.Gug != null) {
        paramVarArgs.d(5, this.Gug);
      }
      paramVarArgs.aS(6, this.Hsr);
      if (this.appId != null) {
        paramVarArgs.d(7, this.appId);
      }
      if (this.Hss != null) {
        paramVarArgs.d(8, this.Hss);
      }
      if (this.Hst != null) {
        paramVarArgs.d(9, this.Hst);
      }
      AppMethodBeat.o(152637);
      return 0;
    }
    if (paramInt == 1) {
      if (this.userName == null) {
        break label686;
      }
    }
    label686:
    for (int i = f.a.a.b.b.a.e(1, this.userName) + 0;; i = 0)
    {
      paramInt = i;
      if (this.bVF != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.bVF);
      }
      i = paramInt;
      if (this.fXp != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.fXp);
      }
      paramInt = i;
      if (this.Guf != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Guf);
      }
      i = paramInt;
      if (this.Gug != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Gug);
      }
      i += f.a.a.b.b.a.bz(6, this.Hsr);
      paramInt = i;
      if (this.appId != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.appId);
      }
      i = paramInt;
      if (this.Hss != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.Hss);
      }
      paramInt = i;
      if (this.Hst != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.Hst);
      }
      AppMethodBeat.o(152637);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(152637);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cfo localcfo = (cfo)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152637);
          return -1;
        case 1: 
          localcfo.userName = locala.OmT.readString();
          AppMethodBeat.o(152637);
          return 0;
        case 2: 
          localcfo.bVF = locala.OmT.readString();
          AppMethodBeat.o(152637);
          return 0;
        case 3: 
          localcfo.fXp = locala.OmT.readString();
          AppMethodBeat.o(152637);
          return 0;
        case 4: 
          localcfo.Guf = locala.OmT.readString();
          AppMethodBeat.o(152637);
          return 0;
        case 5: 
          localcfo.Gug = locala.OmT.readString();
          AppMethodBeat.o(152637);
          return 0;
        case 6: 
          localcfo.Hsr = locala.OmT.zc();
          AppMethodBeat.o(152637);
          return 0;
        case 7: 
          localcfo.appId = locala.OmT.readString();
          AppMethodBeat.o(152637);
          return 0;
        case 8: 
          localcfo.Hss = locala.OmT.readString();
          AppMethodBeat.o(152637);
          return 0;
        }
        localcfo.Hst = locala.OmT.readString();
        AppMethodBeat.o(152637);
        return 0;
      }
      AppMethodBeat.o(152637);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cfo
 * JD-Core Version:    0.7.0.1
 */