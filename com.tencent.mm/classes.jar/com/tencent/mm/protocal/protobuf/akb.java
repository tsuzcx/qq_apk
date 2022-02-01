package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class akb
  extends com.tencent.mm.bx.a
{
  public LinkedList<String> Zrh;
  public String Zri;
  public String desc;
  public String detail;
  public String title;
  public String url;
  
  public akb()
  {
    AppMethodBeat.i(113994);
    this.Zrh = new LinkedList();
    AppMethodBeat.o(113994);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113995);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.g(1, this.title);
      }
      if (this.url != null) {
        paramVarArgs.g(2, this.url);
      }
      if (this.desc != null) {
        paramVarArgs.g(3, this.desc);
      }
      paramVarArgs.e(4, 1, this.Zrh);
      if (this.detail != null) {
        paramVarArgs.g(5, this.detail);
      }
      if (this.Zri != null) {
        paramVarArgs.g(6, this.Zri);
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
    for (int i = i.a.a.b.b.a.h(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.url);
      }
      i = paramInt;
      if (this.desc != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.desc);
      }
      i += i.a.a.a.c(4, 1, this.Zrh);
      paramInt = i;
      if (this.detail != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.detail);
      }
      i = paramInt;
      if (this.Zri != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.Zri);
      }
      AppMethodBeat.o(113995);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Zrh.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(113995);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        akb localakb = (akb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(113995);
          return -1;
        case 1: 
          localakb.title = locala.ajGk.readString();
          AppMethodBeat.o(113995);
          return 0;
        case 2: 
          localakb.url = locala.ajGk.readString();
          AppMethodBeat.o(113995);
          return 0;
        case 3: 
          localakb.desc = locala.ajGk.readString();
          AppMethodBeat.o(113995);
          return 0;
        case 4: 
          localakb.Zrh.add(locala.ajGk.readString());
          AppMethodBeat.o(113995);
          return 0;
        case 5: 
          localakb.detail = locala.ajGk.readString();
          AppMethodBeat.o(113995);
          return 0;
        }
        localakb.Zri = locala.ajGk.readString();
        AppMethodBeat.o(113995);
        return 0;
      }
      AppMethodBeat.o(113995);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.akb
 * JD-Core Version:    0.7.0.1
 */