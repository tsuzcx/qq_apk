package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class czi
  extends com.tencent.mm.bx.a
{
  public String gJA;
  public String gJB;
  public String gJC;
  public String gJv;
  public int gJw;
  public String gJx;
  public String gJy;
  public String gJz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125846);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.gJv != null) {
        paramVarArgs.d(1, this.gJv);
      }
      paramVarArgs.aR(2, this.gJw);
      if (this.gJy != null) {
        paramVarArgs.d(3, this.gJy);
      }
      if (this.gJz != null) {
        paramVarArgs.d(4, this.gJz);
      }
      if (this.gJx != null) {
        paramVarArgs.d(5, this.gJx);
      }
      if (this.gJA != null) {
        paramVarArgs.d(6, this.gJA);
      }
      if (this.gJB != null) {
        paramVarArgs.d(7, this.gJB);
      }
      if (this.gJC != null) {
        paramVarArgs.d(8, this.gJC);
      }
      AppMethodBeat.o(125846);
      return 0;
    }
    if (paramInt == 1) {
      if (this.gJv == null) {
        break label626;
      }
    }
    label626:
    for (paramInt = f.a.a.b.b.a.e(1, this.gJv) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.gJw);
      paramInt = i;
      if (this.gJy != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.gJy);
      }
      i = paramInt;
      if (this.gJz != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.gJz);
      }
      paramInt = i;
      if (this.gJx != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.gJx);
      }
      i = paramInt;
      if (this.gJA != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.gJA);
      }
      paramInt = i;
      if (this.gJB != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.gJB);
      }
      i = paramInt;
      if (this.gJC != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.gJC);
      }
      AppMethodBeat.o(125846);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(125846);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        czi localczi = (czi)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(125846);
          return -1;
        case 1: 
          localczi.gJv = locala.KhF.readString();
          AppMethodBeat.o(125846);
          return 0;
        case 2: 
          localczi.gJw = locala.KhF.xS();
          AppMethodBeat.o(125846);
          return 0;
        case 3: 
          localczi.gJy = locala.KhF.readString();
          AppMethodBeat.o(125846);
          return 0;
        case 4: 
          localczi.gJz = locala.KhF.readString();
          AppMethodBeat.o(125846);
          return 0;
        case 5: 
          localczi.gJx = locala.KhF.readString();
          AppMethodBeat.o(125846);
          return 0;
        case 6: 
          localczi.gJA = locala.KhF.readString();
          AppMethodBeat.o(125846);
          return 0;
        case 7: 
          localczi.gJB = locala.KhF.readString();
          AppMethodBeat.o(125846);
          return 0;
        }
        localczi.gJC = locala.KhF.readString();
        AppMethodBeat.o(125846);
        return 0;
      }
      AppMethodBeat.o(125846);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.czi
 * JD-Core Version:    0.7.0.1
 */