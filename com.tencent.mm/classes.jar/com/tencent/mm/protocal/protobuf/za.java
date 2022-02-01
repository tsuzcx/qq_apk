package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class za
  extends com.tencent.mm.bw.a
{
  public int GqY;
  public int GqZ;
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
    AppMethodBeat.i(50083);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.d(1, this.username);
      }
      if (this.mwf != null) {
        paramVarArgs.d(2, this.mwf);
      }
      paramVarArgs.aS(3, this.GqY);
      paramVarArgs.aS(4, this.GqZ);
      if (this.mwg != null) {
        paramVarArgs.d(5, this.mwg);
      }
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
      AppMethodBeat.o(50083);
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
      int i = paramInt;
      if (this.mwf != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.mwf);
      }
      i = i + f.a.a.b.b.a.bz(3, this.GqY) + f.a.a.b.b.a.bz(4, this.GqZ);
      paramInt = i;
      if (this.mwg != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.mwg);
      }
      i = paramInt;
      if (this.dwb != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.dwb);
      }
      paramInt = i;
      if (this.mwh != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.mwh);
      }
      i = paramInt;
      if (this.mwi != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.mwi);
      }
      i += f.a.a.b.b.a.bz(9, this.mwj);
      paramInt = i;
      if (this.mwk != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.mwk);
      }
      i = f.a.a.b.b.a.bz(11, this.position);
      AppMethodBeat.o(50083);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(50083);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        za localza = (za)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(50083);
          return -1;
        case 1: 
          localza.username = locala.OmT.readString();
          AppMethodBeat.o(50083);
          return 0;
        case 2: 
          localza.mwf = locala.OmT.readString();
          AppMethodBeat.o(50083);
          return 0;
        case 3: 
          localza.GqY = locala.OmT.zc();
          AppMethodBeat.o(50083);
          return 0;
        case 4: 
          localza.GqZ = locala.OmT.zc();
          AppMethodBeat.o(50083);
          return 0;
        case 5: 
          localza.mwg = locala.OmT.readString();
          AppMethodBeat.o(50083);
          return 0;
        case 6: 
          localza.dwb = locala.OmT.readString();
          AppMethodBeat.o(50083);
          return 0;
        case 7: 
          localza.mwh = locala.OmT.readString();
          AppMethodBeat.o(50083);
          return 0;
        case 8: 
          localza.mwi = locala.OmT.readString();
          AppMethodBeat.o(50083);
          return 0;
        case 9: 
          localza.mwj = locala.OmT.zc();
          AppMethodBeat.o(50083);
          return 0;
        case 10: 
          localza.mwk = locala.OmT.readString();
          AppMethodBeat.o(50083);
          return 0;
        }
        localza.position = locala.OmT.zc();
        AppMethodBeat.o(50083);
        return 0;
      }
      AppMethodBeat.o(50083);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.za
 * JD-Core Version:    0.7.0.1
 */