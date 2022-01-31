package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ye
  extends com.tencent.mm.bv.a
{
  public String desc;
  public String detail;
  public String title;
  public String url;
  public LinkedList<String> wPk;
  public String wPl;
  
  public ye()
  {
    AppMethodBeat.i(89061);
    this.wPk = new LinkedList();
    AppMethodBeat.o(89061);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(89062);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.e(1, this.title);
      }
      if (this.url != null) {
        paramVarArgs.e(2, this.url);
      }
      if (this.desc != null) {
        paramVarArgs.e(3, this.desc);
      }
      paramVarArgs.e(4, 1, this.wPk);
      if (this.detail != null) {
        paramVarArgs.e(5, this.detail);
      }
      if (this.wPl != null) {
        paramVarArgs.e(6, this.wPl);
      }
      AppMethodBeat.o(89062);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label514;
      }
    }
    label514:
    for (int i = e.a.a.b.b.a.f(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.url);
      }
      i = paramInt;
      if (this.desc != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.desc);
      }
      i += e.a.a.a.c(4, 1, this.wPk);
      paramInt = i;
      if (this.detail != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.detail);
      }
      i = paramInt;
      if (this.wPl != null) {
        i = paramInt + e.a.a.b.b.a.f(6, this.wPl);
      }
      AppMethodBeat.o(89062);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wPk.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(89062);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        ye localye = (ye)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(89062);
          return -1;
        case 1: 
          localye.title = locala.CLY.readString();
          AppMethodBeat.o(89062);
          return 0;
        case 2: 
          localye.url = locala.CLY.readString();
          AppMethodBeat.o(89062);
          return 0;
        case 3: 
          localye.desc = locala.CLY.readString();
          AppMethodBeat.o(89062);
          return 0;
        case 4: 
          localye.wPk.add(locala.CLY.readString());
          AppMethodBeat.o(89062);
          return 0;
        case 5: 
          localye.detail = locala.CLY.readString();
          AppMethodBeat.o(89062);
          return 0;
        }
        localye.wPl = locala.CLY.readString();
        AppMethodBeat.o(89062);
        return 0;
      }
      AppMethodBeat.o(89062);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ye
 * JD-Core Version:    0.7.0.1
 */