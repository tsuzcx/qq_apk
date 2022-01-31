package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ave
  extends com.tencent.mm.bv.a
{
  public String cDz;
  public int iFL;
  public String knv;
  public String wKl;
  public long wOy;
  public String xcf;
  public int xkA;
  public long xkB;
  public long xkC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(48870);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wKl != null) {
        paramVarArgs.e(1, this.wKl);
      }
      paramVarArgs.am(2, this.wOy);
      paramVarArgs.aO(3, this.xkA);
      paramVarArgs.am(4, this.xkB);
      paramVarArgs.am(5, this.xkC);
      if (this.xcf != null) {
        paramVarArgs.e(6, this.xcf);
      }
      if (this.knv != null) {
        paramVarArgs.e(7, this.knv);
      }
      paramVarArgs.aO(8, this.iFL);
      if (this.cDz != null) {
        paramVarArgs.e(9, this.cDz);
      }
      AppMethodBeat.o(48870);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wKl == null) {
        break label618;
      }
    }
    label618:
    for (paramInt = e.a.a.b.b.a.f(1, this.wKl) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.p(2, this.wOy) + e.a.a.b.b.a.bl(3, this.xkA) + e.a.a.b.b.a.p(4, this.xkB) + e.a.a.b.b.a.p(5, this.xkC);
      paramInt = i;
      if (this.xcf != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.xcf);
      }
      i = paramInt;
      if (this.knv != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.knv);
      }
      i += e.a.a.b.b.a.bl(8, this.iFL);
      paramInt = i;
      if (this.cDz != null) {
        paramInt = i + e.a.a.b.b.a.f(9, this.cDz);
      }
      AppMethodBeat.o(48870);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(48870);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        ave localave = (ave)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(48870);
          return -1;
        case 1: 
          localave.wKl = locala.CLY.readString();
          AppMethodBeat.o(48870);
          return 0;
        case 2: 
          localave.wOy = locala.CLY.sm();
          AppMethodBeat.o(48870);
          return 0;
        case 3: 
          localave.xkA = locala.CLY.sl();
          AppMethodBeat.o(48870);
          return 0;
        case 4: 
          localave.xkB = locala.CLY.sm();
          AppMethodBeat.o(48870);
          return 0;
        case 5: 
          localave.xkC = locala.CLY.sm();
          AppMethodBeat.o(48870);
          return 0;
        case 6: 
          localave.xcf = locala.CLY.readString();
          AppMethodBeat.o(48870);
          return 0;
        case 7: 
          localave.knv = locala.CLY.readString();
          AppMethodBeat.o(48870);
          return 0;
        case 8: 
          localave.iFL = locala.CLY.sl();
          AppMethodBeat.o(48870);
          return 0;
        }
        localave.cDz = locala.CLY.readString();
        AppMethodBeat.o(48870);
        return 0;
      }
      AppMethodBeat.o(48870);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ave
 * JD-Core Version:    0.7.0.1
 */