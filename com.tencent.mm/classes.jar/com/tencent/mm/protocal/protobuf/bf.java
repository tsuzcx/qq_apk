package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bf
  extends com.tencent.mm.bx.a
{
  public String Aox;
  public int Aoy;
  public String doh;
  public String dub;
  public String title;
  public String url;
  public String zHs;
  public String zHt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91345);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.url != null) {
        paramVarArgs.d(1, this.url);
      }
      if (this.doh != null) {
        paramVarArgs.d(2, this.doh);
      }
      if (this.dub != null) {
        paramVarArgs.d(3, this.dub);
      }
      if (this.Aox != null) {
        paramVarArgs.d(4, this.Aox);
      }
      if (this.title != null) {
        paramVarArgs.d(5, this.title);
      }
      if (this.zHs != null) {
        paramVarArgs.d(6, this.zHs);
      }
      if (this.zHt != null) {
        paramVarArgs.d(7, this.zHt);
      }
      paramVarArgs.aR(8, this.Aoy);
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
      if (this.doh != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.doh);
      }
      i = paramInt;
      if (this.dub != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.dub);
      }
      paramInt = i;
      if (this.Aox != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Aox);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.title);
      }
      paramInt = i;
      if (this.zHs != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.zHs);
      }
      i = paramInt;
      if (this.zHt != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.zHt);
      }
      paramInt = f.a.a.b.b.a.bA(8, this.Aoy);
      AppMethodBeat.o(91345);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(91345);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bf localbf = (bf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91345);
          return -1;
        case 1: 
          localbf.url = locala.KhF.readString();
          AppMethodBeat.o(91345);
          return 0;
        case 2: 
          localbf.doh = locala.KhF.readString();
          AppMethodBeat.o(91345);
          return 0;
        case 3: 
          localbf.dub = locala.KhF.readString();
          AppMethodBeat.o(91345);
          return 0;
        case 4: 
          localbf.Aox = locala.KhF.readString();
          AppMethodBeat.o(91345);
          return 0;
        case 5: 
          localbf.title = locala.KhF.readString();
          AppMethodBeat.o(91345);
          return 0;
        case 6: 
          localbf.zHs = locala.KhF.readString();
          AppMethodBeat.o(91345);
          return 0;
        case 7: 
          localbf.zHt = locala.KhF.readString();
          AppMethodBeat.o(91345);
          return 0;
        }
        localbf.Aoy = locala.KhF.xS();
        AppMethodBeat.o(91345);
        return 0;
      }
      AppMethodBeat.o(91345);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bf
 * JD-Core Version:    0.7.0.1
 */