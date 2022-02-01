package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class abm
  extends com.tencent.mm.bx.a
{
  public LinkedList<String> DbO;
  public String DbP;
  public String desc;
  public String detail;
  public String title;
  public String url;
  
  public abm()
  {
    AppMethodBeat.i(113994);
    this.DbO = new LinkedList();
    AppMethodBeat.o(113994);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113995);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      if (this.url != null) {
        paramVarArgs.d(2, this.url);
      }
      if (this.desc != null) {
        paramVarArgs.d(3, this.desc);
      }
      paramVarArgs.e(4, 1, this.DbO);
      if (this.detail != null) {
        paramVarArgs.d(5, this.detail);
      }
      if (this.DbP != null) {
        paramVarArgs.d(6, this.DbP);
      }
      AppMethodBeat.o(113995);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label514;
      }
    }
    label514:
    for (int i = f.a.a.b.b.a.e(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.url);
      }
      i = paramInt;
      if (this.desc != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.desc);
      }
      i += f.a.a.a.c(4, 1, this.DbO);
      paramInt = i;
      if (this.detail != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.detail);
      }
      i = paramInt;
      if (this.DbP != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.DbP);
      }
      AppMethodBeat.o(113995);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DbO.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(113995);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        abm localabm = (abm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(113995);
          return -1;
        case 1: 
          localabm.title = locala.KhF.readString();
          AppMethodBeat.o(113995);
          return 0;
        case 2: 
          localabm.url = locala.KhF.readString();
          AppMethodBeat.o(113995);
          return 0;
        case 3: 
          localabm.desc = locala.KhF.readString();
          AppMethodBeat.o(113995);
          return 0;
        case 4: 
          localabm.DbO.add(locala.KhF.readString());
          AppMethodBeat.o(113995);
          return 0;
        case 5: 
          localabm.detail = locala.KhF.readString();
          AppMethodBeat.o(113995);
          return 0;
        }
        localabm.DbP = locala.KhF.readString();
        AppMethodBeat.o(113995);
        return 0;
      }
      AppMethodBeat.o(113995);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.abm
 * JD-Core Version:    0.7.0.1
 */