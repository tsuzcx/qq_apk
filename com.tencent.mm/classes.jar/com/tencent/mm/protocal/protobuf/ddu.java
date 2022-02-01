package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ddu
  extends com.tencent.mm.bx.a
{
  public String Hsg;
  public String Hsh;
  public String Hsi;
  public String Hsj;
  public int Hsk;
  public String Hsl;
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
      if (this.Hsg != null) {
        paramVarArgs.d(2, this.Hsg);
      }
      if (this.Hsh != null) {
        paramVarArgs.d(3, this.Hsh);
      }
      if (this.Hsi != null) {
        paramVarArgs.d(4, this.Hsi);
      }
      if (this.Hsj != null) {
        paramVarArgs.d(5, this.Hsj);
      }
      paramVarArgs.aS(6, this.Hsk);
      paramVarArgs.aS(7, this.state);
      if (this.Hsl != null) {
        paramVarArgs.d(8, this.Hsl);
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
      if (this.Hsg != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Hsg);
      }
      i = paramInt;
      if (this.Hsh != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Hsh);
      }
      paramInt = i;
      if (this.Hsi != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Hsi);
      }
      i = paramInt;
      if (this.Hsj != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Hsj);
      }
      i = i + f.a.a.b.b.a.bz(6, this.Hsk) + f.a.a.b.b.a.bz(7, this.state);
      paramInt = i;
      if (this.Hsl != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.Hsl);
      }
      AppMethodBeat.o(153299);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(153299);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ddu localddu = (ddu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(153299);
          return -1;
        case 1: 
          localddu.content = locala.NPN.readString();
          AppMethodBeat.o(153299);
          return 0;
        case 2: 
          localddu.Hsg = locala.NPN.readString();
          AppMethodBeat.o(153299);
          return 0;
        case 3: 
          localddu.Hsh = locala.NPN.readString();
          AppMethodBeat.o(153299);
          return 0;
        case 4: 
          localddu.Hsi = locala.NPN.readString();
          AppMethodBeat.o(153299);
          return 0;
        case 5: 
          localddu.Hsj = locala.NPN.readString();
          AppMethodBeat.o(153299);
          return 0;
        case 6: 
          localddu.Hsk = locala.NPN.zc();
          AppMethodBeat.o(153299);
          return 0;
        case 7: 
          localddu.state = locala.NPN.zc();
          AppMethodBeat.o(153299);
          return 0;
        }
        localddu.Hsl = locala.NPN.readString();
        AppMethodBeat.o(153299);
        return 0;
      }
      AppMethodBeat.o(153299);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ddu
 * JD-Core Version:    0.7.0.1
 */