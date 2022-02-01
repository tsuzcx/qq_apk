package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dwg
  extends com.tencent.mm.bw.a
{
  public String HdK;
  public String Hel;
  public String Ibz;
  public String cVJ;
  public String dwb;
  public String oOW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123678);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dwb != null) {
        paramVarArgs.d(1, this.dwb);
      }
      if (this.cVJ != null) {
        paramVarArgs.d(2, this.cVJ);
      }
      if (this.Hel != null) {
        paramVarArgs.d(3, this.Hel);
      }
      if (this.Ibz != null) {
        paramVarArgs.d(4, this.Ibz);
      }
      if (this.oOW != null) {
        paramVarArgs.d(5, this.oOW);
      }
      if (this.HdK != null) {
        paramVarArgs.d(6, this.HdK);
      }
      AppMethodBeat.o(123678);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dwb == null) {
        break label518;
      }
    }
    label518:
    for (int i = f.a.a.b.b.a.e(1, this.dwb) + 0;; i = 0)
    {
      paramInt = i;
      if (this.cVJ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.cVJ);
      }
      i = paramInt;
      if (this.Hel != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Hel);
      }
      paramInt = i;
      if (this.Ibz != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Ibz);
      }
      i = paramInt;
      if (this.oOW != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.oOW);
      }
      paramInt = i;
      if (this.HdK != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.HdK);
      }
      AppMethodBeat.o(123678);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(123678);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dwg localdwg = (dwg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123678);
          return -1;
        case 1: 
          localdwg.dwb = locala.OmT.readString();
          AppMethodBeat.o(123678);
          return 0;
        case 2: 
          localdwg.cVJ = locala.OmT.readString();
          AppMethodBeat.o(123678);
          return 0;
        case 3: 
          localdwg.Hel = locala.OmT.readString();
          AppMethodBeat.o(123678);
          return 0;
        case 4: 
          localdwg.Ibz = locala.OmT.readString();
          AppMethodBeat.o(123678);
          return 0;
        case 5: 
          localdwg.oOW = locala.OmT.readString();
          AppMethodBeat.o(123678);
          return 0;
        }
        localdwg.HdK = locala.OmT.readString();
        AppMethodBeat.o(123678);
        return 0;
      }
      AppMethodBeat.o(123678);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dwg
 * JD-Core Version:    0.7.0.1
 */