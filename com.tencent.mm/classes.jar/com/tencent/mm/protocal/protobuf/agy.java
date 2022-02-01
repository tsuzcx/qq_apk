package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class agy
  extends com.tencent.mm.bw.a
{
  public LinkedList<String> LqB;
  public String LqC;
  public String desc;
  public String detail;
  public String title;
  public String url;
  
  public agy()
  {
    AppMethodBeat.i(113994);
    this.LqB = new LinkedList();
    AppMethodBeat.o(113994);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113995);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.e(1, this.title);
      }
      if (this.url != null) {
        paramVarArgs.e(2, this.url);
      }
      if (this.desc != null) {
        paramVarArgs.e(3, this.desc);
      }
      paramVarArgs.e(4, 1, this.LqB);
      if (this.detail != null) {
        paramVarArgs.e(5, this.detail);
      }
      if (this.LqC != null) {
        paramVarArgs.e(6, this.LqC);
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
    for (int i = g.a.a.b.b.a.f(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.url);
      }
      i = paramInt;
      if (this.desc != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.desc);
      }
      i += g.a.a.a.c(4, 1, this.LqB);
      paramInt = i;
      if (this.detail != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.detail);
      }
      i = paramInt;
      if (this.LqC != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.LqC);
      }
      AppMethodBeat.o(113995);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LqB.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(113995);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        agy localagy = (agy)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(113995);
          return -1;
        case 1: 
          localagy.title = locala.UbS.readString();
          AppMethodBeat.o(113995);
          return 0;
        case 2: 
          localagy.url = locala.UbS.readString();
          AppMethodBeat.o(113995);
          return 0;
        case 3: 
          localagy.desc = locala.UbS.readString();
          AppMethodBeat.o(113995);
          return 0;
        case 4: 
          localagy.LqB.add(locala.UbS.readString());
          AppMethodBeat.o(113995);
          return 0;
        case 5: 
          localagy.detail = locala.UbS.readString();
          AppMethodBeat.o(113995);
          return 0;
        }
        localagy.LqC = locala.UbS.readString();
        AppMethodBeat.o(113995);
        return 0;
      }
      AppMethodBeat.o(113995);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.agy
 * JD-Core Version:    0.7.0.1
 */