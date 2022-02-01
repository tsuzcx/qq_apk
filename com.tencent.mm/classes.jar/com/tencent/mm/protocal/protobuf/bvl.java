package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bvl
  extends com.tencent.mm.bx.a
{
  public int DSJ;
  public String DSK;
  public String DSL;
  public String Dbg;
  public String Dbh;
  public String appId;
  public String bNK;
  public String fyo;
  public String userName;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152637);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.userName != null) {
        paramVarArgs.d(1, this.userName);
      }
      if (this.bNK != null) {
        paramVarArgs.d(2, this.bNK);
      }
      if (this.fyo != null) {
        paramVarArgs.d(3, this.fyo);
      }
      if (this.Dbg != null) {
        paramVarArgs.d(4, this.Dbg);
      }
      if (this.Dbh != null) {
        paramVarArgs.d(5, this.Dbh);
      }
      paramVarArgs.aR(6, this.DSJ);
      if (this.appId != null) {
        paramVarArgs.d(7, this.appId);
      }
      if (this.DSK != null) {
        paramVarArgs.d(8, this.DSK);
      }
      if (this.DSL != null) {
        paramVarArgs.d(9, this.DSL);
      }
      AppMethodBeat.o(152637);
      return 0;
    }
    if (paramInt == 1) {
      if (this.userName == null) {
        break label686;
      }
    }
    label686:
    for (int i = f.a.a.b.b.a.e(1, this.userName) + 0;; i = 0)
    {
      paramInt = i;
      if (this.bNK != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.bNK);
      }
      i = paramInt;
      if (this.fyo != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.fyo);
      }
      paramInt = i;
      if (this.Dbg != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Dbg);
      }
      i = paramInt;
      if (this.Dbh != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Dbh);
      }
      i += f.a.a.b.b.a.bA(6, this.DSJ);
      paramInt = i;
      if (this.appId != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.appId);
      }
      i = paramInt;
      if (this.DSK != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.DSK);
      }
      paramInt = i;
      if (this.DSL != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.DSL);
      }
      AppMethodBeat.o(152637);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(152637);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bvl localbvl = (bvl)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152637);
          return -1;
        case 1: 
          localbvl.userName = locala.KhF.readString();
          AppMethodBeat.o(152637);
          return 0;
        case 2: 
          localbvl.bNK = locala.KhF.readString();
          AppMethodBeat.o(152637);
          return 0;
        case 3: 
          localbvl.fyo = locala.KhF.readString();
          AppMethodBeat.o(152637);
          return 0;
        case 4: 
          localbvl.Dbg = locala.KhF.readString();
          AppMethodBeat.o(152637);
          return 0;
        case 5: 
          localbvl.Dbh = locala.KhF.readString();
          AppMethodBeat.o(152637);
          return 0;
        case 6: 
          localbvl.DSJ = locala.KhF.xS();
          AppMethodBeat.o(152637);
          return 0;
        case 7: 
          localbvl.appId = locala.KhF.readString();
          AppMethodBeat.o(152637);
          return 0;
        case 8: 
          localbvl.DSK = locala.KhF.readString();
          AppMethodBeat.o(152637);
          return 0;
        }
        localbvl.DSL = locala.KhF.readString();
        AppMethodBeat.o(152637);
        return 0;
      }
      AppMethodBeat.o(152637);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bvl
 * JD-Core Version:    0.7.0.1
 */