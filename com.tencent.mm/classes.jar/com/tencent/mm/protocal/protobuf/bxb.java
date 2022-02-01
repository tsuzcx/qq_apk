package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bxb
  extends com.tencent.mm.bw.a
{
  public String FXr;
  public int Gnw;
  public String Hkg;
  public String Hkh;
  public String type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116340);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Hkg != null) {
        paramVarArgs.d(1, this.Hkg);
      }
      if (this.FXr != null) {
        paramVarArgs.d(2, this.FXr);
      }
      if (this.type != null) {
        paramVarArgs.d(3, this.type);
      }
      paramVarArgs.aS(4, this.Gnw);
      if (this.Hkh != null) {
        paramVarArgs.d(5, this.Hkh);
      }
      AppMethodBeat.o(116340);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Hkg == null) {
        break label438;
      }
    }
    label438:
    for (int i = f.a.a.b.b.a.e(1, this.Hkg) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FXr != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FXr);
      }
      i = paramInt;
      if (this.type != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.type);
      }
      i += f.a.a.b.b.a.bz(4, this.Gnw);
      paramInt = i;
      if (this.Hkh != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Hkh);
      }
      AppMethodBeat.o(116340);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(116340);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bxb localbxb = (bxb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(116340);
          return -1;
        case 1: 
          localbxb.Hkg = locala.OmT.readString();
          AppMethodBeat.o(116340);
          return 0;
        case 2: 
          localbxb.FXr = locala.OmT.readString();
          AppMethodBeat.o(116340);
          return 0;
        case 3: 
          localbxb.type = locala.OmT.readString();
          AppMethodBeat.o(116340);
          return 0;
        case 4: 
          localbxb.Gnw = locala.OmT.zc();
          AppMethodBeat.o(116340);
          return 0;
        }
        localbxb.Hkh = locala.OmT.readString();
        AppMethodBeat.o(116340);
        return 0;
      }
      AppMethodBeat.o(116340);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bxb
 * JD-Core Version:    0.7.0.1
 */