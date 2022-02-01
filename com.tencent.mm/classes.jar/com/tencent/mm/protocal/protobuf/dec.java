package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dec
  extends com.tencent.mm.bw.a
{
  public String FJN;
  public String FJO;
  public int FJP;
  public String FQf;
  public String dJb;
  public String dJc;
  public String oEo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114073);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dJb != null) {
        paramVarArgs.d(1, this.dJb);
      }
      if (this.oEo != null) {
        paramVarArgs.d(2, this.oEo);
      }
      if (this.dJc != null) {
        paramVarArgs.d(3, this.dJc);
      }
      if (this.FJN != null) {
        paramVarArgs.d(4, this.FJN);
      }
      if (this.FJO != null) {
        paramVarArgs.d(5, this.FJO);
      }
      paramVarArgs.aS(6, this.FJP);
      if (this.FQf != null) {
        paramVarArgs.d(7, this.FQf);
      }
      AppMethodBeat.o(114073);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dJb == null) {
        break label562;
      }
    }
    label562:
    for (int i = f.a.a.b.b.a.e(1, this.dJb) + 0;; i = 0)
    {
      paramInt = i;
      if (this.oEo != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.oEo);
      }
      i = paramInt;
      if (this.dJc != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.dJc);
      }
      paramInt = i;
      if (this.FJN != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FJN);
      }
      i = paramInt;
      if (this.FJO != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.FJO);
      }
      i += f.a.a.b.b.a.bz(6, this.FJP);
      paramInt = i;
      if (this.FQf != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.FQf);
      }
      AppMethodBeat.o(114073);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(114073);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dec localdec = (dec)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(114073);
          return -1;
        case 1: 
          localdec.dJb = locala.OmT.readString();
          AppMethodBeat.o(114073);
          return 0;
        case 2: 
          localdec.oEo = locala.OmT.readString();
          AppMethodBeat.o(114073);
          return 0;
        case 3: 
          localdec.dJc = locala.OmT.readString();
          AppMethodBeat.o(114073);
          return 0;
        case 4: 
          localdec.FJN = locala.OmT.readString();
          AppMethodBeat.o(114073);
          return 0;
        case 5: 
          localdec.FJO = locala.OmT.readString();
          AppMethodBeat.o(114073);
          return 0;
        case 6: 
          localdec.FJP = locala.OmT.zc();
          AppMethodBeat.o(114073);
          return 0;
        }
        localdec.FQf = locala.OmT.readString();
        AppMethodBeat.o(114073);
        return 0;
      }
      AppMethodBeat.o(114073);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dec
 * JD-Core Version:    0.7.0.1
 */