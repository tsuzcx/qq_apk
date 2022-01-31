package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class brg
  extends com.tencent.mm.bv.a
{
  public String SmallImgUrl;
  public String jJA;
  public String jKG;
  public String wSo;
  public String wYu;
  public int xER;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(102516);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.jJA != null) {
        paramVarArgs.e(1, this.jJA);
      }
      paramVarArgs.aO(2, this.xER);
      if (this.jKG != null) {
        paramVarArgs.e(3, this.jKG);
      }
      if (this.SmallImgUrl != null) {
        paramVarArgs.e(4, this.SmallImgUrl);
      }
      if (this.wSo != null) {
        paramVarArgs.e(5, this.wSo);
      }
      if (this.wYu != null) {
        paramVarArgs.e(6, this.wYu);
      }
      AppMethodBeat.o(102516);
      return 0;
    }
    if (paramInt == 1) {
      if (this.jJA == null) {
        break label502;
      }
    }
    label502:
    for (paramInt = e.a.a.b.b.a.f(1, this.jJA) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.xER);
      paramInt = i;
      if (this.jKG != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.jKG);
      }
      i = paramInt;
      if (this.SmallImgUrl != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.SmallImgUrl);
      }
      paramInt = i;
      if (this.wSo != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.wSo);
      }
      i = paramInt;
      if (this.wYu != null) {
        i = paramInt + e.a.a.b.b.a.f(6, this.wYu);
      }
      AppMethodBeat.o(102516);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(102516);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        brg localbrg = (brg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(102516);
          return -1;
        case 1: 
          localbrg.jJA = locala.CLY.readString();
          AppMethodBeat.o(102516);
          return 0;
        case 2: 
          localbrg.xER = locala.CLY.sl();
          AppMethodBeat.o(102516);
          return 0;
        case 3: 
          localbrg.jKG = locala.CLY.readString();
          AppMethodBeat.o(102516);
          return 0;
        case 4: 
          localbrg.SmallImgUrl = locala.CLY.readString();
          AppMethodBeat.o(102516);
          return 0;
        case 5: 
          localbrg.wSo = locala.CLY.readString();
          AppMethodBeat.o(102516);
          return 0;
        }
        localbrg.wYu = locala.CLY.readString();
        AppMethodBeat.o(102516);
        return 0;
      }
      AppMethodBeat.o(102516);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.brg
 * JD-Core Version:    0.7.0.1
 */