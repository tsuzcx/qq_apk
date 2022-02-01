package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ak
  extends com.tencent.mm.bw.a
{
  public String BsJ;
  public String code;
  public String fileid;
  public String key;
  public String name;
  public int size;
  public String type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(198627);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.fileid != null) {
        paramVarArgs.e(1, this.fileid);
      }
      if (this.name != null) {
        paramVarArgs.e(2, this.name);
      }
      paramVarArgs.aM(3, this.size);
      if (this.type != null) {
        paramVarArgs.e(4, this.type);
      }
      if (this.BsJ != null) {
        paramVarArgs.e(5, this.BsJ);
      }
      if (this.key != null) {
        paramVarArgs.e(6, this.key);
      }
      if (this.code != null) {
        paramVarArgs.e(7, this.code);
      }
      AppMethodBeat.o(198627);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fileid == null) {
        break label562;
      }
    }
    label562:
    for (paramInt = g.a.a.b.b.a.f(1, this.fileid) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.name != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.name);
      }
      i += g.a.a.b.b.a.bu(3, this.size);
      paramInt = i;
      if (this.type != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.type);
      }
      i = paramInt;
      if (this.BsJ != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.BsJ);
      }
      paramInt = i;
      if (this.key != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.key);
      }
      i = paramInt;
      if (this.code != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.code);
      }
      AppMethodBeat.o(198627);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(198627);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ak localak = (ak)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(198627);
          return -1;
        case 1: 
          localak.fileid = locala.UbS.readString();
          AppMethodBeat.o(198627);
          return 0;
        case 2: 
          localak.name = locala.UbS.readString();
          AppMethodBeat.o(198627);
          return 0;
        case 3: 
          localak.size = locala.UbS.zi();
          AppMethodBeat.o(198627);
          return 0;
        case 4: 
          localak.type = locala.UbS.readString();
          AppMethodBeat.o(198627);
          return 0;
        case 5: 
          localak.BsJ = locala.UbS.readString();
          AppMethodBeat.o(198627);
          return 0;
        case 6: 
          localak.key = locala.UbS.readString();
          AppMethodBeat.o(198627);
          return 0;
        }
        localak.code = locala.UbS.readString();
        AppMethodBeat.o(198627);
        return 0;
      }
      AppMethodBeat.o(198627);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.ak
 * JD-Core Version:    0.7.0.1
 */