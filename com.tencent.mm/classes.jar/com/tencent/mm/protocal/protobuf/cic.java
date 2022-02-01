package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cic
  extends com.tencent.mm.bw.a
{
  public int FOD;
  public int Huk;
  public String dwb;
  public String iaa;
  public String mwf;
  public String mwg;
  public String mwk;
  public int position;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50096);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.d(1, this.username);
      }
      if (this.mwf != null) {
        paramVarArgs.d(2, this.mwf);
      }
      if (this.iaa != null) {
        paramVarArgs.d(3, this.iaa);
      }
      if (this.mwg != null) {
        paramVarArgs.d(4, this.mwg);
      }
      if (this.dwb != null) {
        paramVarArgs.d(5, this.dwb);
      }
      if (this.mwk != null) {
        paramVarArgs.d(6, this.mwk);
      }
      paramVarArgs.aS(7, this.position);
      paramVarArgs.aS(8, this.Huk);
      paramVarArgs.aS(9, this.FOD);
      AppMethodBeat.o(50096);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label658;
      }
    }
    label658:
    for (int i = f.a.a.b.b.a.e(1, this.username) + 0;; i = 0)
    {
      paramInt = i;
      if (this.mwf != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.mwf);
      }
      i = paramInt;
      if (this.iaa != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.iaa);
      }
      paramInt = i;
      if (this.mwg != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.mwg);
      }
      i = paramInt;
      if (this.dwb != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.dwb);
      }
      paramInt = i;
      if (this.mwk != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.mwk);
      }
      i = f.a.a.b.b.a.bz(7, this.position);
      int j = f.a.a.b.b.a.bz(8, this.Huk);
      int k = f.a.a.b.b.a.bz(9, this.FOD);
      AppMethodBeat.o(50096);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(50096);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cic localcic = (cic)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(50096);
          return -1;
        case 1: 
          localcic.username = locala.OmT.readString();
          AppMethodBeat.o(50096);
          return 0;
        case 2: 
          localcic.mwf = locala.OmT.readString();
          AppMethodBeat.o(50096);
          return 0;
        case 3: 
          localcic.iaa = locala.OmT.readString();
          AppMethodBeat.o(50096);
          return 0;
        case 4: 
          localcic.mwg = locala.OmT.readString();
          AppMethodBeat.o(50096);
          return 0;
        case 5: 
          localcic.dwb = locala.OmT.readString();
          AppMethodBeat.o(50096);
          return 0;
        case 6: 
          localcic.mwk = locala.OmT.readString();
          AppMethodBeat.o(50096);
          return 0;
        case 7: 
          localcic.position = locala.OmT.zc();
          AppMethodBeat.o(50096);
          return 0;
        case 8: 
          localcic.Huk = locala.OmT.zc();
          AppMethodBeat.o(50096);
          return 0;
        }
        localcic.FOD = locala.OmT.zc();
        AppMethodBeat.o(50096);
        return 0;
      }
      AppMethodBeat.o(50096);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cic
 * JD-Core Version:    0.7.0.1
 */