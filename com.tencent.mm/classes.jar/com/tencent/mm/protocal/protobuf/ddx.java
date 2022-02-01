package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ddx
  extends com.tencent.mm.bx.a
{
  public String APF;
  public LinkedList<String> ZBf;
  public int aaJq;
  public int aaJr;
  public String md5;
  public String name;
  public String url;
  
  public ddx()
  {
    AppMethodBeat.i(82447);
    this.ZBf = new LinkedList();
    AppMethodBeat.o(82447);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82448);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.name != null) {
        paramVarArgs.g(1, this.name);
      }
      if (this.url != null) {
        paramVarArgs.g(2, this.url);
      }
      if (this.md5 != null) {
        paramVarArgs.g(3, this.md5);
      }
      paramVarArgs.e(4, 1, this.ZBf);
      paramVarArgs.bS(5, this.aaJq);
      paramVarArgs.bS(6, this.aaJr);
      if (this.APF != null) {
        paramVarArgs.g(7, this.APF);
      }
      AppMethodBeat.o(82448);
      return 0;
    }
    if (paramInt == 1) {
      if (this.name == null) {
        break label538;
      }
    }
    label538:
    for (int i = i.a.a.b.b.a.h(1, this.name) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.url);
      }
      i = paramInt;
      if (this.md5 != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.md5);
      }
      i = i + i.a.a.a.c(4, 1, this.ZBf) + i.a.a.b.b.a.cJ(5, this.aaJq) + i.a.a.b.b.a.cJ(6, this.aaJr);
      paramInt = i;
      if (this.APF != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.APF);
      }
      AppMethodBeat.o(82448);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ZBf.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(82448);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        ddx localddx = (ddx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(82448);
          return -1;
        case 1: 
          localddx.name = locala.ajGk.readString();
          AppMethodBeat.o(82448);
          return 0;
        case 2: 
          localddx.url = locala.ajGk.readString();
          AppMethodBeat.o(82448);
          return 0;
        case 3: 
          localddx.md5 = locala.ajGk.readString();
          AppMethodBeat.o(82448);
          return 0;
        case 4: 
          localddx.ZBf.add(locala.ajGk.readString());
          AppMethodBeat.o(82448);
          return 0;
        case 5: 
          localddx.aaJq = locala.ajGk.aar();
          AppMethodBeat.o(82448);
          return 0;
        case 6: 
          localddx.aaJr = locala.ajGk.aar();
          AppMethodBeat.o(82448);
          return 0;
        }
        localddx.APF = locala.ajGk.readString();
        AppMethodBeat.o(82448);
        return 0;
      }
      AppMethodBeat.o(82448);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ddx
 * JD-Core Version:    0.7.0.1
 */