package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class csy
  extends com.tencent.mm.bx.a
{
  public String EkA;
  public String EkB;
  public String EkC;
  public String EkD;
  public int EkE;
  public String EkF;
  public String content;
  public int state;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153299);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.content != null) {
        paramVarArgs.d(1, this.content);
      }
      if (this.EkA != null) {
        paramVarArgs.d(2, this.EkA);
      }
      if (this.EkB != null) {
        paramVarArgs.d(3, this.EkB);
      }
      if (this.EkC != null) {
        paramVarArgs.d(4, this.EkC);
      }
      if (this.EkD != null) {
        paramVarArgs.d(5, this.EkD);
      }
      paramVarArgs.aR(6, this.EkE);
      paramVarArgs.aR(7, this.state);
      if (this.EkF != null) {
        paramVarArgs.d(8, this.EkF);
      }
      AppMethodBeat.o(153299);
      return 0;
    }
    if (paramInt == 1) {
      if (this.content == null) {
        break label606;
      }
    }
    label606:
    for (int i = f.a.a.b.b.a.e(1, this.content) + 0;; i = 0)
    {
      paramInt = i;
      if (this.EkA != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.EkA);
      }
      i = paramInt;
      if (this.EkB != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.EkB);
      }
      paramInt = i;
      if (this.EkC != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.EkC);
      }
      i = paramInt;
      if (this.EkD != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.EkD);
      }
      i = i + f.a.a.b.b.a.bA(6, this.EkE) + f.a.a.b.b.a.bA(7, this.state);
      paramInt = i;
      if (this.EkF != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.EkF);
      }
      AppMethodBeat.o(153299);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(153299);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        csy localcsy = (csy)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(153299);
          return -1;
        case 1: 
          localcsy.content = locala.KhF.readString();
          AppMethodBeat.o(153299);
          return 0;
        case 2: 
          localcsy.EkA = locala.KhF.readString();
          AppMethodBeat.o(153299);
          return 0;
        case 3: 
          localcsy.EkB = locala.KhF.readString();
          AppMethodBeat.o(153299);
          return 0;
        case 4: 
          localcsy.EkC = locala.KhF.readString();
          AppMethodBeat.o(153299);
          return 0;
        case 5: 
          localcsy.EkD = locala.KhF.readString();
          AppMethodBeat.o(153299);
          return 0;
        case 6: 
          localcsy.EkE = locala.KhF.xS();
          AppMethodBeat.o(153299);
          return 0;
        case 7: 
          localcsy.state = locala.KhF.xS();
          AppMethodBeat.o(153299);
          return 0;
        }
        localcsy.EkF = locala.KhF.readString();
        AppMethodBeat.o(153299);
        return 0;
      }
      AppMethodBeat.o(153299);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.csy
 * JD-Core Version:    0.7.0.1
 */