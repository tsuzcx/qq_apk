package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cjo
  extends com.tencent.mm.bw.a
{
  public String GjV;
  public int Hwh;
  public String Hwi;
  public String Hwj;
  public String dwb;
  public String hCp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91579);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dwb != null) {
        paramVarArgs.d(1, this.dwb);
      }
      paramVarArgs.aS(2, this.Hwh);
      if (this.Hwi != null) {
        paramVarArgs.d(3, this.Hwi);
      }
      if (this.Hwj != null) {
        paramVarArgs.d(4, this.Hwj);
      }
      if (this.GjV != null) {
        paramVarArgs.d(5, this.GjV);
      }
      if (this.hCp != null) {
        paramVarArgs.d(6, this.hCp);
      }
      AppMethodBeat.o(91579);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dwb == null) {
        break label502;
      }
    }
    label502:
    for (paramInt = f.a.a.b.b.a.e(1, this.dwb) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.Hwh);
      paramInt = i;
      if (this.Hwi != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Hwi);
      }
      i = paramInt;
      if (this.Hwj != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.Hwj);
      }
      paramInt = i;
      if (this.GjV != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.GjV);
      }
      i = paramInt;
      if (this.hCp != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.hCp);
      }
      AppMethodBeat.o(91579);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(91579);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cjo localcjo = (cjo)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91579);
          return -1;
        case 1: 
          localcjo.dwb = locala.OmT.readString();
          AppMethodBeat.o(91579);
          return 0;
        case 2: 
          localcjo.Hwh = locala.OmT.zc();
          AppMethodBeat.o(91579);
          return 0;
        case 3: 
          localcjo.Hwi = locala.OmT.readString();
          AppMethodBeat.o(91579);
          return 0;
        case 4: 
          localcjo.Hwj = locala.OmT.readString();
          AppMethodBeat.o(91579);
          return 0;
        case 5: 
          localcjo.GjV = locala.OmT.readString();
          AppMethodBeat.o(91579);
          return 0;
        }
        localcjo.hCp = locala.OmT.readString();
        AppMethodBeat.o(91579);
        return 0;
      }
      AppMethodBeat.o(91579);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cjo
 * JD-Core Version:    0.7.0.1
 */