package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dvp
  extends com.tencent.mm.bx.a
{
  public String DAV;
  public String DAW;
  public String EJF;
  public String dnK;
  public String url;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123707);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EJF != null) {
        paramVarArgs.d(1, this.EJF);
      }
      paramVarArgs.aR(2, this.version);
      if (this.url != null) {
        paramVarArgs.d(3, this.url);
      }
      if (this.dnK != null) {
        paramVarArgs.d(4, this.dnK);
      }
      if (this.DAV != null) {
        paramVarArgs.d(5, this.DAV);
      }
      if (this.DAW != null) {
        paramVarArgs.d(6, this.DAW);
      }
      AppMethodBeat.o(123707);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EJF == null) {
        break label502;
      }
    }
    label502:
    for (paramInt = f.a.a.b.b.a.e(1, this.EJF) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.version);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.url);
      }
      i = paramInt;
      if (this.dnK != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.dnK);
      }
      paramInt = i;
      if (this.DAV != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.DAV);
      }
      i = paramInt;
      if (this.DAW != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.DAW);
      }
      AppMethodBeat.o(123707);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(123707);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dvp localdvp = (dvp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123707);
          return -1;
        case 1: 
          localdvp.EJF = locala.KhF.readString();
          AppMethodBeat.o(123707);
          return 0;
        case 2: 
          localdvp.version = locala.KhF.xS();
          AppMethodBeat.o(123707);
          return 0;
        case 3: 
          localdvp.url = locala.KhF.readString();
          AppMethodBeat.o(123707);
          return 0;
        case 4: 
          localdvp.dnK = locala.KhF.readString();
          AppMethodBeat.o(123707);
          return 0;
        case 5: 
          localdvp.DAV = locala.KhF.readString();
          AppMethodBeat.o(123707);
          return 0;
        }
        localdvp.DAW = locala.KhF.readString();
        AppMethodBeat.o(123707);
        return 0;
      }
      AppMethodBeat.o(123707);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dvp
 * JD-Core Version:    0.7.0.1
 */