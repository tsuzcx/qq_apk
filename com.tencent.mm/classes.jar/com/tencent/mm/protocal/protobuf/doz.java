package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class doz
  extends com.tencent.mm.bx.a
{
  public String DYr;
  public String EFn;
  public String EFo;
  public String sah;
  public String sdQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32506);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DYr != null) {
        paramVarArgs.d(1, this.DYr);
      }
      if (this.EFn != null) {
        paramVarArgs.d(2, this.EFn);
      }
      if (this.sdQ != null) {
        paramVarArgs.d(3, this.sdQ);
      }
      if (this.sah != null) {
        paramVarArgs.d(4, this.sah);
      }
      if (this.EFo != null) {
        paramVarArgs.d(5, this.EFo);
      }
      AppMethodBeat.o(32506);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DYr == null) {
        break label465;
      }
    }
    label465:
    for (int i = f.a.a.b.b.a.e(1, this.DYr) + 0;; i = 0)
    {
      paramInt = i;
      if (this.EFn != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.EFn);
      }
      i = paramInt;
      if (this.sdQ != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.sdQ);
      }
      paramInt = i;
      if (this.sah != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.sah);
      }
      i = paramInt;
      if (this.EFo != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.EFo);
      }
      AppMethodBeat.o(32506);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(32506);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        doz localdoz = (doz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32506);
          return -1;
        case 1: 
          localdoz.DYr = locala.KhF.readString();
          AppMethodBeat.o(32506);
          return 0;
        case 2: 
          localdoz.EFn = locala.KhF.readString();
          AppMethodBeat.o(32506);
          return 0;
        case 3: 
          localdoz.sdQ = locala.KhF.readString();
          AppMethodBeat.o(32506);
          return 0;
        case 4: 
          localdoz.sah = locala.KhF.readString();
          AppMethodBeat.o(32506);
          return 0;
        }
        localdoz.EFo = locala.KhF.readString();
        AppMethodBeat.o(32506);
        return 0;
      }
      AppMethodBeat.o(32506);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.doz
 * JD-Core Version:    0.7.0.1
 */