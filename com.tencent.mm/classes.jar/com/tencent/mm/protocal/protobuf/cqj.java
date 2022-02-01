package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cqj
  extends com.tencent.mm.bx.a
{
  public String DDP;
  public String Ejq;
  public String Ejw;
  public String Ejx;
  public String pZX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122529);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.pZX != null) {
        paramVarArgs.d(1, this.pZX);
      }
      if (this.Ejq != null) {
        paramVarArgs.d(2, this.Ejq);
      }
      if (this.DDP != null) {
        paramVarArgs.d(3, this.DDP);
      }
      if (this.Ejw != null) {
        paramVarArgs.d(4, this.Ejw);
      }
      if (this.Ejx != null) {
        paramVarArgs.d(5, this.Ejx);
      }
      AppMethodBeat.o(122529);
      return 0;
    }
    if (paramInt == 1) {
      if (this.pZX == null) {
        break label454;
      }
    }
    label454:
    for (int i = f.a.a.b.b.a.e(1, this.pZX) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Ejq != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Ejq);
      }
      i = paramInt;
      if (this.DDP != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DDP);
      }
      paramInt = i;
      if (this.Ejw != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Ejw);
      }
      i = paramInt;
      if (this.Ejx != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Ejx);
      }
      AppMethodBeat.o(122529);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(122529);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cqj localcqj = (cqj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(122529);
          return -1;
        case 1: 
          localcqj.pZX = locala.KhF.readString();
          AppMethodBeat.o(122529);
          return 0;
        case 2: 
          localcqj.Ejq = locala.KhF.readString();
          AppMethodBeat.o(122529);
          return 0;
        case 3: 
          localcqj.DDP = locala.KhF.readString();
          AppMethodBeat.o(122529);
          return 0;
        case 4: 
          localcqj.Ejw = locala.KhF.readString();
          AppMethodBeat.o(122529);
          return 0;
        }
        localcqj.Ejx = locala.KhF.readString();
        AppMethodBeat.o(122529);
        return 0;
      }
      AppMethodBeat.o(122529);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cqj
 * JD-Core Version:    0.7.0.1
 */