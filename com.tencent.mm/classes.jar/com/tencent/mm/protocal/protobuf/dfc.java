package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dfc
  extends com.tencent.mm.bw.a
{
  public long HMm;
  public int actionType;
  public String dEM;
  public String dyI;
  public String id;
  public String nhq;
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
      if (this.dyI != null) {
        paramVarArgs.d(2, this.dyI);
      }
      paramVarArgs.aZ(3, this.HMm);
      paramVarArgs.aS(4, this.actionType);
      if (this.url != null) {
        paramVarArgs.d(5, this.url);
      }
      if (this.title != null) {
        paramVarArgs.d(6, this.title);
      }
      if (this.nhq != null) {
        paramVarArgs.d(7, this.nhq);
      }
      if (this.dEM != null) {
        paramVarArgs.d(8, this.dEM);
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
      if (this.dyI != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.dyI);
      }
      i = i + f.a.a.b.b.a.p(3, this.HMm) + f.a.a.b.b.a.bz(4, this.actionType);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.url);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.title);
      }
      paramInt = i;
      if (this.nhq != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.nhq);
      }
      i = paramInt;
      if (this.dEM != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.dEM);
      }
      AppMethodBeat.o(152995);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(152995);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dfc localdfc = (dfc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152995);
          return -1;
        case 1: 
          localdfc.id = locala.OmT.readString();
          AppMethodBeat.o(152995);
          return 0;
        case 2: 
          localdfc.dyI = locala.OmT.readString();
          AppMethodBeat.o(152995);
          return 0;
        case 3: 
          localdfc.HMm = locala.OmT.zd();
          AppMethodBeat.o(152995);
          return 0;
        case 4: 
          localdfc.actionType = locala.OmT.zc();
          AppMethodBeat.o(152995);
          return 0;
        case 5: 
          localdfc.url = locala.OmT.readString();
          AppMethodBeat.o(152995);
          return 0;
        case 6: 
          localdfc.title = locala.OmT.readString();
          AppMethodBeat.o(152995);
          return 0;
        case 7: 
          localdfc.nhq = locala.OmT.readString();
          AppMethodBeat.o(152995);
          return 0;
        }
        localdfc.dEM = locala.OmT.readString();
        AppMethodBeat.o(152995);
        return 0;
      }
      AppMethodBeat.o(152995);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dfc
 * JD-Core Version:    0.7.0.1
 */