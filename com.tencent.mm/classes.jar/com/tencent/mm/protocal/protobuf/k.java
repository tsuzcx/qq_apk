package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class k
  extends com.tencent.mm.bw.a
{
  public String FIe;
  public String FIf;
  public String FIs;
  public String FIt;
  public String FIu;
  public long dPq;
  public int role;
  public int state;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91322);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FIe != null) {
        paramVarArgs.d(1, this.FIe);
      }
      if (this.title != null) {
        paramVarArgs.d(2, this.title);
      }
      paramVarArgs.aZ(3, this.dPq);
      if (this.FIs != null) {
        paramVarArgs.d(5, this.FIs);
      }
      paramVarArgs.aS(10, this.state);
      paramVarArgs.aS(11, this.role);
      if (this.FIt != null) {
        paramVarArgs.d(12, this.FIt);
      }
      if (this.FIf != null) {
        paramVarArgs.d(13, this.FIf);
      }
      if (this.FIu != null) {
        paramVarArgs.d(14, this.FIu);
      }
      AppMethodBeat.o(91322);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FIe == null) {
        break label674;
      }
    }
    label674:
    for (paramInt = f.a.a.b.b.a.e(1, this.FIe) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.title != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.title);
      }
      i += f.a.a.b.b.a.p(3, this.dPq);
      paramInt = i;
      if (this.FIs != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.FIs);
      }
      i = paramInt + f.a.a.b.b.a.bz(10, this.state) + f.a.a.b.b.a.bz(11, this.role);
      paramInt = i;
      if (this.FIt != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.FIt);
      }
      i = paramInt;
      if (this.FIf != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.FIf);
      }
      paramInt = i;
      if (this.FIu != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.FIu);
      }
      AppMethodBeat.o(91322);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(91322);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        k localk = (k)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 4: 
        case 6: 
        case 7: 
        case 8: 
        case 9: 
        default: 
          AppMethodBeat.o(91322);
          return -1;
        case 1: 
          localk.FIe = locala.OmT.readString();
          AppMethodBeat.o(91322);
          return 0;
        case 2: 
          localk.title = locala.OmT.readString();
          AppMethodBeat.o(91322);
          return 0;
        case 3: 
          localk.dPq = locala.OmT.zd();
          AppMethodBeat.o(91322);
          return 0;
        case 5: 
          localk.FIs = locala.OmT.readString();
          AppMethodBeat.o(91322);
          return 0;
        case 10: 
          localk.state = locala.OmT.zc();
          AppMethodBeat.o(91322);
          return 0;
        case 11: 
          localk.role = locala.OmT.zc();
          AppMethodBeat.o(91322);
          return 0;
        case 12: 
          localk.FIt = locala.OmT.readString();
          AppMethodBeat.o(91322);
          return 0;
        case 13: 
          localk.FIf = locala.OmT.readString();
          AppMethodBeat.o(91322);
          return 0;
        }
        localk.FIu = locala.OmT.readString();
        AppMethodBeat.o(91322);
        return 0;
      }
      AppMethodBeat.o(91322);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.k
 * JD-Core Version:    0.7.0.1
 */