package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bh
  extends com.tencent.mm.bw.a
{
  public String CRv;
  public String CRw;
  public String DyN;
  public int DyO;
  public String dEM;
  public String dyI;
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
      if (this.dyI != null) {
        paramVarArgs.d(2, this.dyI);
      }
      if (this.dEM != null) {
        paramVarArgs.d(3, this.dEM);
      }
      if (this.DyN != null) {
        paramVarArgs.d(4, this.DyN);
      }
      if (this.title != null) {
        paramVarArgs.d(5, this.title);
      }
      if (this.CRv != null) {
        paramVarArgs.d(6, this.CRv);
      }
      if (this.CRw != null) {
        paramVarArgs.d(7, this.CRw);
      }
      paramVarArgs.aS(8, this.DyO);
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
      if (this.dyI != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dyI);
      }
      i = paramInt;
      if (this.dEM != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.dEM);
      }
      paramInt = i;
      if (this.DyN != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DyN);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.title);
      }
      paramInt = i;
      if (this.CRv != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.CRv);
      }
      i = paramInt;
      if (this.CRw != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.CRw);
      }
      paramInt = f.a.a.b.b.a.bz(8, this.DyO);
      AppMethodBeat.o(91345);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
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
          localbh.url = locala.OmT.readString();
          AppMethodBeat.o(91345);
          return 0;
        case 2: 
          localbh.dyI = locala.OmT.readString();
          AppMethodBeat.o(91345);
          return 0;
        case 3: 
          localbh.dEM = locala.OmT.readString();
          AppMethodBeat.o(91345);
          return 0;
        case 4: 
          localbh.DyN = locala.OmT.readString();
          AppMethodBeat.o(91345);
          return 0;
        case 5: 
          localbh.title = locala.OmT.readString();
          AppMethodBeat.o(91345);
          return 0;
        case 6: 
          localbh.CRv = locala.OmT.readString();
          AppMethodBeat.o(91345);
          return 0;
        case 7: 
          localbh.CRw = locala.OmT.readString();
          AppMethodBeat.o(91345);
          return 0;
        }
        localbh.DyO = locala.OmT.zc();
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