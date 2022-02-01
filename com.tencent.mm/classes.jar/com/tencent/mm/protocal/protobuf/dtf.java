package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dtf
  extends com.tencent.mm.bx.a
{
  public String EHV;
  public boolean EHW;
  public int EHX;
  public int EHY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110856);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EHV != null) {
        paramVarArgs.d(1, this.EHV);
      }
      paramVarArgs.bg(2, this.EHW);
      paramVarArgs.aR(3, this.EHX);
      paramVarArgs.aR(4, this.EHY);
      AppMethodBeat.o(110856);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EHV == null) {
        break label350;
      }
    }
    label350:
    for (paramInt = f.a.a.b.b.a.e(1, this.EHV) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.fY(2);
      int j = f.a.a.b.b.a.bA(3, this.EHX);
      int k = f.a.a.b.b.a.bA(4, this.EHY);
      AppMethodBeat.o(110856);
      return paramInt + (i + 1) + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(110856);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dtf localdtf = (dtf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(110856);
          return -1;
        case 1: 
          localdtf.EHV = locala.KhF.readString();
          AppMethodBeat.o(110856);
          return 0;
        case 2: 
          localdtf.EHW = locala.KhF.fHu();
          AppMethodBeat.o(110856);
          return 0;
        case 3: 
          localdtf.EHX = locala.KhF.xS();
          AppMethodBeat.o(110856);
          return 0;
        }
        localdtf.EHY = locala.KhF.xS();
        AppMethodBeat.o(110856);
        return 0;
      }
      AppMethodBeat.o(110856);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dtf
 * JD-Core Version:    0.7.0.1
 */