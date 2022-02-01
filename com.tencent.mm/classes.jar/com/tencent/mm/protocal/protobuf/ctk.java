package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ctk
  extends com.tencent.mm.bx.a
{
  public long Eld;
  public int actionType;
  public String doh;
  public String dub;
  public String id;
  public String lZG;
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
      if (this.doh != null) {
        paramVarArgs.d(2, this.doh);
      }
      paramVarArgs.aG(3, this.Eld);
      paramVarArgs.aR(4, this.actionType);
      if (this.url != null) {
        paramVarArgs.d(5, this.url);
      }
      if (this.title != null) {
        paramVarArgs.d(6, this.title);
      }
      if (this.lZG != null) {
        paramVarArgs.d(7, this.lZG);
      }
      if (this.dub != null) {
        paramVarArgs.d(8, this.dub);
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
      if (this.doh != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.doh);
      }
      i = i + f.a.a.b.b.a.q(3, this.Eld) + f.a.a.b.b.a.bA(4, this.actionType);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.url);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.title);
      }
      paramInt = i;
      if (this.lZG != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.lZG);
      }
      i = paramInt;
      if (this.dub != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.dub);
      }
      AppMethodBeat.o(152995);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(152995);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ctk localctk = (ctk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152995);
          return -1;
        case 1: 
          localctk.id = locala.KhF.readString();
          AppMethodBeat.o(152995);
          return 0;
        case 2: 
          localctk.doh = locala.KhF.readString();
          AppMethodBeat.o(152995);
          return 0;
        case 3: 
          localctk.Eld = locala.KhF.xT();
          AppMethodBeat.o(152995);
          return 0;
        case 4: 
          localctk.actionType = locala.KhF.xS();
          AppMethodBeat.o(152995);
          return 0;
        case 5: 
          localctk.url = locala.KhF.readString();
          AppMethodBeat.o(152995);
          return 0;
        case 6: 
          localctk.title = locala.KhF.readString();
          AppMethodBeat.o(152995);
          return 0;
        case 7: 
          localctk.lZG = locala.KhF.readString();
          AppMethodBeat.o(152995);
          return 0;
        }
        localctk.dub = locala.KhF.readString();
        AppMethodBeat.o(152995);
        return 0;
      }
      AppMethodBeat.o(152995);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ctk
 * JD-Core Version:    0.7.0.1
 */