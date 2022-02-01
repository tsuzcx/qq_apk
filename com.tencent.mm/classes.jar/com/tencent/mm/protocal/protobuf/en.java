package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class en
  extends com.tencent.mm.bx.a
{
  public String Fwk;
  public String Fwl;
  public int Fwm;
  public String Id;
  public String Version;
  public String uiR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125709);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Id != null) {
        paramVarArgs.d(1, this.Id);
      }
      if (this.Version != null) {
        paramVarArgs.d(2, this.Version);
      }
      if (this.uiR != null) {
        paramVarArgs.d(3, this.uiR);
      }
      if (this.Fwk != null) {
        paramVarArgs.d(4, this.Fwk);
      }
      if (this.Fwl != null) {
        paramVarArgs.d(5, this.Fwl);
      }
      paramVarArgs.aS(6, this.Fwm);
      AppMethodBeat.o(125709);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Id == null) {
        break label502;
      }
    }
    label502:
    for (int i = f.a.a.b.b.a.e(1, this.Id) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Version != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Version);
      }
      i = paramInt;
      if (this.uiR != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.uiR);
      }
      paramInt = i;
      if (this.Fwk != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Fwk);
      }
      i = paramInt;
      if (this.Fwl != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Fwl);
      }
      paramInt = f.a.a.b.b.a.bz(6, this.Fwm);
      AppMethodBeat.o(125709);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(125709);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        en localen = (en)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(125709);
          return -1;
        case 1: 
          localen.Id = locala.NPN.readString();
          AppMethodBeat.o(125709);
          return 0;
        case 2: 
          localen.Version = locala.NPN.readString();
          AppMethodBeat.o(125709);
          return 0;
        case 3: 
          localen.uiR = locala.NPN.readString();
          AppMethodBeat.o(125709);
          return 0;
        case 4: 
          localen.Fwk = locala.NPN.readString();
          AppMethodBeat.o(125709);
          return 0;
        case 5: 
          localen.Fwl = locala.NPN.readString();
          AppMethodBeat.o(125709);
          return 0;
        }
        localen.Fwm = locala.NPN.zc();
        AppMethodBeat.o(125709);
        return 0;
      }
      AppMethodBeat.o(125709);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.en
 * JD-Core Version:    0.7.0.1
 */