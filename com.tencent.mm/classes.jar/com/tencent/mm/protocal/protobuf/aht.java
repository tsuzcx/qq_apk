package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aht
  extends com.tencent.mm.bw.a
{
  public int GxG;
  public int count;
  public String dwb;
  public String mwf;
  public String mwg;
  public String mwh;
  public String mwi;
  public int mwj;
  public String mwk;
  public int position;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50085);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.d(1, this.username);
      }
      paramVarArgs.aS(2, this.count);
      if (this.mwf != null) {
        paramVarArgs.d(3, this.mwf);
      }
      if (this.mwg != null) {
        paramVarArgs.d(4, this.mwg);
      }
      paramVarArgs.aS(5, this.GxG);
      if (this.dwb != null) {
        paramVarArgs.d(6, this.dwb);
      }
      if (this.mwh != null) {
        paramVarArgs.d(7, this.mwh);
      }
      if (this.mwi != null) {
        paramVarArgs.d(8, this.mwi);
      }
      paramVarArgs.aS(9, this.mwj);
      if (this.mwk != null) {
        paramVarArgs.d(10, this.mwk);
      }
      paramVarArgs.aS(11, this.position);
      AppMethodBeat.o(50085);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label762;
      }
    }
    label762:
    for (paramInt = f.a.a.b.b.a.e(1, this.username) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.count);
      paramInt = i;
      if (this.mwf != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.mwf);
      }
      i = paramInt;
      if (this.mwg != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.mwg);
      }
      i += f.a.a.b.b.a.bz(5, this.GxG);
      paramInt = i;
      if (this.dwb != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.dwb);
      }
      i = paramInt;
      if (this.mwh != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.mwh);
      }
      paramInt = i;
      if (this.mwi != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.mwi);
      }
      i = paramInt + f.a.a.b.b.a.bz(9, this.mwj);
      paramInt = i;
      if (this.mwk != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.mwk);
      }
      i = f.a.a.b.b.a.bz(11, this.position);
      AppMethodBeat.o(50085);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(50085);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        aht localaht = (aht)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(50085);
          return -1;
        case 1: 
          localaht.username = locala.OmT.readString();
          AppMethodBeat.o(50085);
          return 0;
        case 2: 
          localaht.count = locala.OmT.zc();
          AppMethodBeat.o(50085);
          return 0;
        case 3: 
          localaht.mwf = locala.OmT.readString();
          AppMethodBeat.o(50085);
          return 0;
        case 4: 
          localaht.mwg = locala.OmT.readString();
          AppMethodBeat.o(50085);
          return 0;
        case 5: 
          localaht.GxG = locala.OmT.zc();
          AppMethodBeat.o(50085);
          return 0;
        case 6: 
          localaht.dwb = locala.OmT.readString();
          AppMethodBeat.o(50085);
          return 0;
        case 7: 
          localaht.mwh = locala.OmT.readString();
          AppMethodBeat.o(50085);
          return 0;
        case 8: 
          localaht.mwi = locala.OmT.readString();
          AppMethodBeat.o(50085);
          return 0;
        case 9: 
          localaht.mwj = locala.OmT.zc();
          AppMethodBeat.o(50085);
          return 0;
        case 10: 
          localaht.mwk = locala.OmT.readString();
          AppMethodBeat.o(50085);
          return 0;
        }
        localaht.position = locala.OmT.zc();
        AppMethodBeat.o(50085);
        return 0;
      }
      AppMethodBeat.o(50085);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aht
 * JD-Core Version:    0.7.0.1
 */