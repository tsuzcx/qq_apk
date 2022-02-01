package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dei
  extends com.tencent.mm.bx.a
{
  public long HsJ;
  public int actionType;
  public String dDH;
  public String dxD;
  public String id;
  public String nch;
  public String title;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152995);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.id != null) {
        paramVarArgs.d(1, this.id);
      }
      if (this.dxD != null) {
        paramVarArgs.d(2, this.dxD);
      }
      paramVarArgs.aY(3, this.HsJ);
      paramVarArgs.aS(4, this.actionType);
      if (this.url != null) {
        paramVarArgs.d(5, this.url);
      }
      if (this.title != null) {
        paramVarArgs.d(6, this.title);
      }
      if (this.nch != null) {
        paramVarArgs.d(7, this.nch);
      }
      if (this.dDH != null) {
        paramVarArgs.d(8, this.dDH);
      }
      AppMethodBeat.o(152995);
      return 0;
    }
    if (paramInt == 1) {
      if (this.id == null) {
        break label606;
      }
    }
    label606:
    for (paramInt = f.a.a.b.b.a.e(1, this.id) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.dxD != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.dxD);
      }
      i = i + f.a.a.b.b.a.p(3, this.HsJ) + f.a.a.b.b.a.bz(4, this.actionType);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.url);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.title);
      }
      paramInt = i;
      if (this.nch != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.nch);
      }
      i = paramInt;
      if (this.dDH != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.dDH);
      }
      AppMethodBeat.o(152995);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(152995);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dei localdei = (dei)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152995);
          return -1;
        case 1: 
          localdei.id = locala.NPN.readString();
          AppMethodBeat.o(152995);
          return 0;
        case 2: 
          localdei.dxD = locala.NPN.readString();
          AppMethodBeat.o(152995);
          return 0;
        case 3: 
          localdei.HsJ = locala.NPN.zd();
          AppMethodBeat.o(152995);
          return 0;
        case 4: 
          localdei.actionType = locala.NPN.zc();
          AppMethodBeat.o(152995);
          return 0;
        case 5: 
          localdei.url = locala.NPN.readString();
          AppMethodBeat.o(152995);
          return 0;
        case 6: 
          localdei.title = locala.NPN.readString();
          AppMethodBeat.o(152995);
          return 0;
        case 7: 
          localdei.nch = locala.NPN.readString();
          AppMethodBeat.o(152995);
          return 0;
        }
        localdei.dDH = locala.NPN.readString();
        AppMethodBeat.o(152995);
        return 0;
      }
      AppMethodBeat.o(152995);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dei
 * JD-Core Version:    0.7.0.1
 */