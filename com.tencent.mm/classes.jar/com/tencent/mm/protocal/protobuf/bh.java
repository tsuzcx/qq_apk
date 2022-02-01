package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bh
  extends com.tencent.mm.bx.a
{
  public String CzQ;
  public String CzR;
  public String Dhj;
  public int Dhk;
  public String dDH;
  public String dxD;
  public String title;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91345);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.url != null) {
        paramVarArgs.d(1, this.url);
      }
      if (this.dxD != null) {
        paramVarArgs.d(2, this.dxD);
      }
      if (this.dDH != null) {
        paramVarArgs.d(3, this.dDH);
      }
      if (this.Dhj != null) {
        paramVarArgs.d(4, this.Dhj);
      }
      if (this.title != null) {
        paramVarArgs.d(5, this.title);
      }
      if (this.CzQ != null) {
        paramVarArgs.d(6, this.CzQ);
      }
      if (this.CzR != null) {
        paramVarArgs.d(7, this.CzR);
      }
      paramVarArgs.aS(8, this.Dhk);
      AppMethodBeat.o(91345);
      return 0;
    }
    if (paramInt == 1) {
      if (this.url == null) {
        break label626;
      }
    }
    label626:
    for (int i = f.a.a.b.b.a.e(1, this.url) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dxD != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dxD);
      }
      i = paramInt;
      if (this.dDH != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.dDH);
      }
      paramInt = i;
      if (this.Dhj != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Dhj);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.title);
      }
      paramInt = i;
      if (this.CzQ != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.CzQ);
      }
      i = paramInt;
      if (this.CzR != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.CzR);
      }
      paramInt = f.a.a.b.b.a.bz(8, this.Dhk);
      AppMethodBeat.o(91345);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(91345);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bh localbh = (bh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91345);
          return -1;
        case 1: 
          localbh.url = locala.NPN.readString();
          AppMethodBeat.o(91345);
          return 0;
        case 2: 
          localbh.dxD = locala.NPN.readString();
          AppMethodBeat.o(91345);
          return 0;
        case 3: 
          localbh.dDH = locala.NPN.readString();
          AppMethodBeat.o(91345);
          return 0;
        case 4: 
          localbh.Dhj = locala.NPN.readString();
          AppMethodBeat.o(91345);
          return 0;
        case 5: 
          localbh.title = locala.NPN.readString();
          AppMethodBeat.o(91345);
          return 0;
        case 6: 
          localbh.CzQ = locala.NPN.readString();
          AppMethodBeat.o(91345);
          return 0;
        case 7: 
          localbh.CzR = locala.NPN.readString();
          AppMethodBeat.o(91345);
          return 0;
        }
        localbh.Dhk = locala.NPN.zc();
        AppMethodBeat.o(91345);
        return 0;
      }
      AppMethodBeat.o(91345);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bh
 * JD-Core Version:    0.7.0.1
 */