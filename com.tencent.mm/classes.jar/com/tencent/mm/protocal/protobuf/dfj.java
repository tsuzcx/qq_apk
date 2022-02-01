package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dfj
  extends com.tencent.mm.bx.a
{
  public String CDu;
  public String CDv;
  public String dca;
  public String gGR;
  public String szi;
  public String uns;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72615);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dca != null) {
        paramVarArgs.d(1, this.dca);
      }
      if (this.gGR != null) {
        paramVarArgs.d(2, this.gGR);
      }
      if (this.szi != null) {
        paramVarArgs.d(3, this.szi);
      }
      if (this.uns != null) {
        paramVarArgs.d(4, this.uns);
      }
      if (this.CDu != null) {
        paramVarArgs.d(5, this.CDu);
      }
      if (this.CDv != null) {
        paramVarArgs.d(6, this.CDv);
      }
      AppMethodBeat.o(72615);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dca == null) {
        break label518;
      }
    }
    label518:
    for (int i = f.a.a.b.b.a.e(1, this.dca) + 0;; i = 0)
    {
      paramInt = i;
      if (this.gGR != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.gGR);
      }
      i = paramInt;
      if (this.szi != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.szi);
      }
      paramInt = i;
      if (this.uns != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.uns);
      }
      i = paramInt;
      if (this.CDu != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.CDu);
      }
      paramInt = i;
      if (this.CDv != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.CDv);
      }
      AppMethodBeat.o(72615);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(72615);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dfj localdfj = (dfj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72615);
          return -1;
        case 1: 
          localdfj.dca = locala.KhF.readString();
          AppMethodBeat.o(72615);
          return 0;
        case 2: 
          localdfj.gGR = locala.KhF.readString();
          AppMethodBeat.o(72615);
          return 0;
        case 3: 
          localdfj.szi = locala.KhF.readString();
          AppMethodBeat.o(72615);
          return 0;
        case 4: 
          localdfj.uns = locala.KhF.readString();
          AppMethodBeat.o(72615);
          return 0;
        case 5: 
          localdfj.CDu = locala.KhF.readString();
          AppMethodBeat.o(72615);
          return 0;
        }
        localdfj.CDv = locala.KhF.readString();
        AppMethodBeat.o(72615);
        return 0;
      }
      AppMethodBeat.o(72615);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dfj
 * JD-Core Version:    0.7.0.1
 */