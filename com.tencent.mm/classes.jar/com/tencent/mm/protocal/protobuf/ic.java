package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ic
  extends com.tencent.mm.bx.a
{
  public boolean CDF;
  public String CDG;
  public String CDu;
  public String CDw;
  public String dca;
  public String szi;
  public String vur;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(19405);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.szi != null) {
        paramVarArgs.d(1, this.szi);
      }
      if (this.vur != null) {
        paramVarArgs.d(2, this.vur);
      }
      if (this.dca != null) {
        paramVarArgs.d(3, this.dca);
      }
      paramVarArgs.bg(4, this.CDF);
      if (this.CDw != null) {
        paramVarArgs.d(5, this.CDw);
      }
      if (this.CDu != null) {
        paramVarArgs.d(6, this.CDu);
      }
      if (this.CDG != null) {
        paramVarArgs.d(7, this.CDG);
      }
      AppMethodBeat.o(19405);
      return 0;
    }
    if (paramInt == 1) {
      if (this.szi == null) {
        break label575;
      }
    }
    label575:
    for (int i = f.a.a.b.b.a.e(1, this.szi) + 0;; i = 0)
    {
      paramInt = i;
      if (this.vur != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.vur);
      }
      i = paramInt;
      if (this.dca != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.dca);
      }
      i += f.a.a.b.b.a.fY(4) + 1;
      paramInt = i;
      if (this.CDw != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.CDw);
      }
      i = paramInt;
      if (this.CDu != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.CDu);
      }
      paramInt = i;
      if (this.CDG != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.CDG);
      }
      AppMethodBeat.o(19405);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(19405);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ic localic = (ic)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(19405);
          return -1;
        case 1: 
          localic.szi = locala.KhF.readString();
          AppMethodBeat.o(19405);
          return 0;
        case 2: 
          localic.vur = locala.KhF.readString();
          AppMethodBeat.o(19405);
          return 0;
        case 3: 
          localic.dca = locala.KhF.readString();
          AppMethodBeat.o(19405);
          return 0;
        case 4: 
          localic.CDF = locala.KhF.fHu();
          AppMethodBeat.o(19405);
          return 0;
        case 5: 
          localic.CDw = locala.KhF.readString();
          AppMethodBeat.o(19405);
          return 0;
        case 6: 
          localic.CDu = locala.KhF.readString();
          AppMethodBeat.o(19405);
          return 0;
        }
        localic.CDG = locala.KhF.readString();
        AppMethodBeat.o(19405);
        return 0;
      }
      AppMethodBeat.o(19405);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ic
 * JD-Core Version:    0.7.0.1
 */