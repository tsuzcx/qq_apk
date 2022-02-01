package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dnv
  extends com.tencent.mm.bx.a
{
  public String HBM;
  public String HBN;
  public String appId;
  public String dJH;
  public String desc;
  public String sjU;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153000);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.d(2, this.desc);
      }
      if (this.dJH != null) {
        paramVarArgs.d(3, this.dJH);
      }
      if (this.HBM != null) {
        paramVarArgs.d(4, this.HBM);
      }
      if (this.HBN != null) {
        paramVarArgs.d(5, this.HBN);
      }
      if (this.appId != null) {
        paramVarArgs.d(6, this.appId);
      }
      if (this.sjU != null) {
        paramVarArgs.d(7, this.sjU);
      }
      AppMethodBeat.o(153000);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label578;
      }
    }
    label578:
    for (int i = f.a.a.b.b.a.e(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.desc);
      }
      i = paramInt;
      if (this.dJH != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.dJH);
      }
      paramInt = i;
      if (this.HBM != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.HBM);
      }
      i = paramInt;
      if (this.HBN != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.HBN);
      }
      paramInt = i;
      if (this.appId != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.appId);
      }
      i = paramInt;
      if (this.sjU != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.sjU);
      }
      AppMethodBeat.o(153000);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(153000);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dnv localdnv = (dnv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(153000);
          return -1;
        case 1: 
          localdnv.title = locala.NPN.readString();
          AppMethodBeat.o(153000);
          return 0;
        case 2: 
          localdnv.desc = locala.NPN.readString();
          AppMethodBeat.o(153000);
          return 0;
        case 3: 
          localdnv.dJH = locala.NPN.readString();
          AppMethodBeat.o(153000);
          return 0;
        case 4: 
          localdnv.HBM = locala.NPN.readString();
          AppMethodBeat.o(153000);
          return 0;
        case 5: 
          localdnv.HBN = locala.NPN.readString();
          AppMethodBeat.o(153000);
          return 0;
        case 6: 
          localdnv.appId = locala.NPN.readString();
          AppMethodBeat.o(153000);
          return 0;
        }
        localdnv.sjU = locala.NPN.readString();
        AppMethodBeat.o(153000);
        return 0;
      }
      AppMethodBeat.o(153000);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dnv
 * JD-Core Version:    0.7.0.1
 */