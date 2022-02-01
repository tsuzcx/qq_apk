package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cda
  extends com.tencent.mm.bw.a
{
  public String GjV;
  public String GvO;
  public int Hpy;
  public int Hpz;
  public String dEM;
  public String desc;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91555);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.d(2, this.desc);
      }
      if (this.GvO != null) {
        paramVarArgs.d(3, this.GvO);
      }
      paramVarArgs.aS(4, this.Hpy);
      paramVarArgs.aS(5, this.Hpz);
      if (this.GjV != null) {
        paramVarArgs.d(6, this.GjV);
      }
      if (this.dEM != null) {
        paramVarArgs.d(7, this.dEM);
      }
      AppMethodBeat.o(91555);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label546;
      }
    }
    label546:
    for (int i = f.a.a.b.b.a.e(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.desc);
      }
      i = paramInt;
      if (this.GvO != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GvO);
      }
      i = i + f.a.a.b.b.a.bz(4, this.Hpy) + f.a.a.b.b.a.bz(5, this.Hpz);
      paramInt = i;
      if (this.GjV != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.GjV);
      }
      i = paramInt;
      if (this.dEM != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.dEM);
      }
      AppMethodBeat.o(91555);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(91555);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cda localcda = (cda)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91555);
          return -1;
        case 1: 
          localcda.title = locala.OmT.readString();
          AppMethodBeat.o(91555);
          return 0;
        case 2: 
          localcda.desc = locala.OmT.readString();
          AppMethodBeat.o(91555);
          return 0;
        case 3: 
          localcda.GvO = locala.OmT.readString();
          AppMethodBeat.o(91555);
          return 0;
        case 4: 
          localcda.Hpy = locala.OmT.zc();
          AppMethodBeat.o(91555);
          return 0;
        case 5: 
          localcda.Hpz = locala.OmT.zc();
          AppMethodBeat.o(91555);
          return 0;
        case 6: 
          localcda.GjV = locala.OmT.readString();
          AppMethodBeat.o(91555);
          return 0;
        }
        localcda.dEM = locala.OmT.readString();
        AppMethodBeat.o(91555);
        return 0;
      }
      AppMethodBeat.o(91555);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cda
 * JD-Core Version:    0.7.0.1
 */