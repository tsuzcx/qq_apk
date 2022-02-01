package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class agb
  extends com.tencent.mm.bx.a
{
  public int Dim;
  public String gJA;
  public String gJB;
  public String gJC;
  public String gJv;
  public String gJx;
  public String gJy;
  public String gJz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127460);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.gJv != null) {
        paramVarArgs.d(1, this.gJv);
      }
      paramVarArgs.aR(2, this.Dim);
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
      AppMethodBeat.o(127460);
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
      int i = paramInt + f.a.a.b.b.a.bA(2, this.Dim);
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
      AppMethodBeat.o(127460);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(127460);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        agb localagb = (agb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127460);
          return -1;
        case 1: 
          localagb.gJv = locala.KhF.readString();
          AppMethodBeat.o(127460);
          return 0;
        case 2: 
          localagb.Dim = locala.KhF.xS();
          AppMethodBeat.o(127460);
          return 0;
        case 3: 
          localagb.gJy = locala.KhF.readString();
          AppMethodBeat.o(127460);
          return 0;
        case 4: 
          localagb.gJz = locala.KhF.readString();
          AppMethodBeat.o(127460);
          return 0;
        case 5: 
          localagb.gJx = locala.KhF.readString();
          AppMethodBeat.o(127460);
          return 0;
        case 6: 
          localagb.gJA = locala.KhF.readString();
          AppMethodBeat.o(127460);
          return 0;
        case 7: 
          localagb.gJB = locala.KhF.readString();
          AppMethodBeat.o(127460);
          return 0;
        }
        localagb.gJC = locala.KhF.readString();
        AppMethodBeat.o(127460);
        return 0;
      }
      AppMethodBeat.o(127460);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.agb
 * JD-Core Version:    0.7.0.1
 */