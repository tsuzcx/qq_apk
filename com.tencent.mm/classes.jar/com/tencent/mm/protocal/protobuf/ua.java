package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class ua
  extends com.tencent.mm.bx.a
{
  public String FRk;
  public String FRl;
  public long FSA;
  public String FSB;
  public String FSC;
  public String oBP;
  public String oxN;
  public String pkr;
  public String title;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113980);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      if (this.oxN != null) {
        paramVarArgs.d(2, this.oxN);
      }
      if (this.oBP != null) {
        paramVarArgs.d(3, this.oBP);
      }
      if (this.url != null) {
        paramVarArgs.d(4, this.url);
      }
      paramVarArgs.aY(5, this.FSA);
      if (this.FSB != null) {
        paramVarArgs.d(6, this.FSB);
      }
      if (this.FSC != null) {
        paramVarArgs.d(7, this.FSC);
      }
      if (this.pkr != null) {
        paramVarArgs.d(8, this.pkr);
      }
      if (this.FRk != null) {
        paramVarArgs.d(9, this.FRk);
      }
      if (this.FRl != null) {
        paramVarArgs.d(10, this.FRl);
      }
      AppMethodBeat.o(113980);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label750;
      }
    }
    label750:
    for (int i = f.a.a.b.b.a.e(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.oxN != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.oxN);
      }
      i = paramInt;
      if (this.oBP != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.oBP);
      }
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.url);
      }
      i = paramInt + f.a.a.b.b.a.p(5, this.FSA);
      paramInt = i;
      if (this.FSB != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FSB);
      }
      i = paramInt;
      if (this.FSC != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.FSC);
      }
      paramInt = i;
      if (this.pkr != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.pkr);
      }
      i = paramInt;
      if (this.FRk != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.FRk);
      }
      paramInt = i;
      if (this.FRl != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.FRl);
      }
      AppMethodBeat.o(113980);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(113980);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ua localua = (ua)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(113980);
          return -1;
        case 1: 
          localua.title = locala.NPN.readString();
          AppMethodBeat.o(113980);
          return 0;
        case 2: 
          localua.oxN = locala.NPN.readString();
          AppMethodBeat.o(113980);
          return 0;
        case 3: 
          localua.oBP = locala.NPN.readString();
          AppMethodBeat.o(113980);
          return 0;
        case 4: 
          localua.url = locala.NPN.readString();
          AppMethodBeat.o(113980);
          return 0;
        case 5: 
          localua.FSA = locala.NPN.zd();
          AppMethodBeat.o(113980);
          return 0;
        case 6: 
          localua.FSB = locala.NPN.readString();
          AppMethodBeat.o(113980);
          return 0;
        case 7: 
          localua.FSC = locala.NPN.readString();
          AppMethodBeat.o(113980);
          return 0;
        case 8: 
          localua.pkr = locala.NPN.readString();
          AppMethodBeat.o(113980);
          return 0;
        case 9: 
          localua.FRk = locala.NPN.readString();
          AppMethodBeat.o(113980);
          return 0;
        }
        localua.FRl = locala.NPN.readString();
        AppMethodBeat.o(113980);
        return 0;
      }
      AppMethodBeat.o(113980);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ua
 * JD-Core Version:    0.7.0.1
 */