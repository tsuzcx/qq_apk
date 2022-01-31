package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ccg
  extends com.tencent.mm.bv.a
{
  public String content;
  public int state;
  public String xMC;
  public String xMD;
  public String xME;
  public String xMF;
  public int xMG;
  public String xMH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114986);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.content != null) {
        paramVarArgs.e(1, this.content);
      }
      if (this.xMC != null) {
        paramVarArgs.e(2, this.xMC);
      }
      if (this.xMD != null) {
        paramVarArgs.e(3, this.xMD);
      }
      if (this.xME != null) {
        paramVarArgs.e(4, this.xME);
      }
      if (this.xMF != null) {
        paramVarArgs.e(5, this.xMF);
      }
      paramVarArgs.aO(6, this.xMG);
      paramVarArgs.aO(7, this.state);
      if (this.xMH != null) {
        paramVarArgs.e(8, this.xMH);
      }
      AppMethodBeat.o(114986);
      return 0;
    }
    if (paramInt == 1) {
      if (this.content == null) {
        break label606;
      }
    }
    label606:
    for (int i = e.a.a.b.b.a.f(1, this.content) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xMC != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.xMC);
      }
      i = paramInt;
      if (this.xMD != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.xMD);
      }
      paramInt = i;
      if (this.xME != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.xME);
      }
      i = paramInt;
      if (this.xMF != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.xMF);
      }
      i = i + e.a.a.b.b.a.bl(6, this.xMG) + e.a.a.b.b.a.bl(7, this.state);
      paramInt = i;
      if (this.xMH != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.xMH);
      }
      AppMethodBeat.o(114986);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(114986);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        ccg localccg = (ccg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(114986);
          return -1;
        case 1: 
          localccg.content = locala.CLY.readString();
          AppMethodBeat.o(114986);
          return 0;
        case 2: 
          localccg.xMC = locala.CLY.readString();
          AppMethodBeat.o(114986);
          return 0;
        case 3: 
          localccg.xMD = locala.CLY.readString();
          AppMethodBeat.o(114986);
          return 0;
        case 4: 
          localccg.xME = locala.CLY.readString();
          AppMethodBeat.o(114986);
          return 0;
        case 5: 
          localccg.xMF = locala.CLY.readString();
          AppMethodBeat.o(114986);
          return 0;
        case 6: 
          localccg.xMG = locala.CLY.sl();
          AppMethodBeat.o(114986);
          return 0;
        case 7: 
          localccg.state = locala.CLY.sl();
          AppMethodBeat.o(114986);
          return 0;
        }
        localccg.xMH = locala.CLY.readString();
        AppMethodBeat.o(114986);
        return 0;
      }
      AppMethodBeat.o(114986);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ccg
 * JD-Core Version:    0.7.0.1
 */