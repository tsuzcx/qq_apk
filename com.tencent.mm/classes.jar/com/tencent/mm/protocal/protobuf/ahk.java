package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ahk
  extends com.tencent.mm.cd.a
{
  public LinkedList<String> SrZ;
  public String Ssa;
  public String desc;
  public String detail;
  public String title;
  public String url;
  
  public ahk()
  {
    AppMethodBeat.i(113994);
    this.SrZ = new LinkedList();
    AppMethodBeat.o(113994);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113995);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.f(1, this.title);
      }
      if (this.url != null) {
        paramVarArgs.f(2, this.url);
      }
      if (this.desc != null) {
        paramVarArgs.f(3, this.desc);
      }
      paramVarArgs.e(4, 1, this.SrZ);
      if (this.detail != null) {
        paramVarArgs.f(5, this.detail);
      }
      if (this.Ssa != null) {
        paramVarArgs.f(6, this.Ssa);
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
    for (int i = g.a.a.b.b.a.g(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.url);
      }
      i = paramInt;
      if (this.desc != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.desc);
      }
      i += g.a.a.a.c(4, 1, this.SrZ);
      paramInt = i;
      if (this.detail != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.detail);
      }
      i = paramInt;
      if (this.Ssa != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.Ssa);
      }
      AppMethodBeat.o(113995);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.SrZ.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(113995);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ahk localahk = (ahk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(113995);
          return -1;
        case 1: 
          localahk.title = locala.abFh.readString();
          AppMethodBeat.o(113995);
          return 0;
        case 2: 
          localahk.url = locala.abFh.readString();
          AppMethodBeat.o(113995);
          return 0;
        case 3: 
          localahk.desc = locala.abFh.readString();
          AppMethodBeat.o(113995);
          return 0;
        case 4: 
          localahk.SrZ.add(locala.abFh.readString());
          AppMethodBeat.o(113995);
          return 0;
        case 5: 
          localahk.detail = locala.abFh.readString();
          AppMethodBeat.o(113995);
          return 0;
        }
        localahk.Ssa = locala.abFh.readString();
        AppMethodBeat.o(113995);
        return 0;
      }
      AppMethodBeat.o(113995);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ahk
 * JD-Core Version:    0.7.0.1
 */