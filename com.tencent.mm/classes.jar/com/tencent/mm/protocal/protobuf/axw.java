package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class axw
  extends com.tencent.mm.bx.a
{
  public long ZIV;
  public String appid;
  public String ext_info;
  public String icon;
  public String link;
  public int source;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259670);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.appid != null) {
        paramVarArgs.g(1, this.appid);
      }
      if (this.icon != null) {
        paramVarArgs.g(2, this.icon);
      }
      if (this.title != null) {
        paramVarArgs.g(3, this.title);
      }
      if (this.link != null) {
        paramVarArgs.g(4, this.link);
      }
      paramVarArgs.bv(5, this.ZIV);
      if (this.ext_info != null) {
        paramVarArgs.g(6, this.ext_info);
      }
      paramVarArgs.bS(7, this.source);
      AppMethodBeat.o(259670);
      return 0;
    }
    if (paramInt == 1) {
      if (this.appid == null) {
        break label542;
      }
    }
    label542:
    for (int i = i.a.a.b.b.a.h(1, this.appid) + 0;; i = 0)
    {
      paramInt = i;
      if (this.icon != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.icon);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.title);
      }
      paramInt = i;
      if (this.link != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.link);
      }
      i = paramInt + i.a.a.b.b.a.q(5, this.ZIV);
      paramInt = i;
      if (this.ext_info != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.ext_info);
      }
      i = i.a.a.b.b.a.cJ(7, this.source);
      AppMethodBeat.o(259670);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259670);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        axw localaxw = (axw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(259670);
          return -1;
        case 1: 
          localaxw.appid = locala.ajGk.readString();
          AppMethodBeat.o(259670);
          return 0;
        case 2: 
          localaxw.icon = locala.ajGk.readString();
          AppMethodBeat.o(259670);
          return 0;
        case 3: 
          localaxw.title = locala.ajGk.readString();
          AppMethodBeat.o(259670);
          return 0;
        case 4: 
          localaxw.link = locala.ajGk.readString();
          AppMethodBeat.o(259670);
          return 0;
        case 5: 
          localaxw.ZIV = locala.ajGk.aaw();
          AppMethodBeat.o(259670);
          return 0;
        case 6: 
          localaxw.ext_info = locala.ajGk.readString();
          AppMethodBeat.o(259670);
          return 0;
        }
        localaxw.source = locala.ajGk.aar();
        AppMethodBeat.o(259670);
        return 0;
      }
      AppMethodBeat.o(259670);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.axw
 * JD-Core Version:    0.7.0.1
 */