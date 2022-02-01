package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ddn
  extends com.tencent.mm.bx.a
{
  public String Fvh;
  public String MD5;
  public String Title;
  public String URL;
  public String ujl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32451);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.URL != null) {
        paramVarArgs.d(1, this.URL);
      }
      if (this.Title != null) {
        paramVarArgs.d(2, this.Title);
      }
      if (this.Fvh != null) {
        paramVarArgs.d(3, this.Fvh);
      }
      if (this.ujl != null) {
        paramVarArgs.d(4, this.ujl);
      }
      if (this.MD5 != null) {
        paramVarArgs.d(5, this.MD5);
      }
      AppMethodBeat.o(32451);
      return 0;
    }
    if (paramInt == 1) {
      if (this.URL == null) {
        break label465;
      }
    }
    label465:
    for (int i = f.a.a.b.b.a.e(1, this.URL) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Title);
      }
      i = paramInt;
      if (this.Fvh != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Fvh);
      }
      paramInt = i;
      if (this.ujl != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.ujl);
      }
      i = paramInt;
      if (this.MD5 != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.MD5);
      }
      AppMethodBeat.o(32451);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(32451);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ddn localddn = (ddn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32451);
          return -1;
        case 1: 
          localddn.URL = locala.NPN.readString();
          AppMethodBeat.o(32451);
          return 0;
        case 2: 
          localddn.Title = locala.NPN.readString();
          AppMethodBeat.o(32451);
          return 0;
        case 3: 
          localddn.Fvh = locala.NPN.readString();
          AppMethodBeat.o(32451);
          return 0;
        case 4: 
          localddn.ujl = locala.NPN.readString();
          AppMethodBeat.o(32451);
          return 0;
        }
        localddn.MD5 = locala.NPN.readString();
        AppMethodBeat.o(32451);
        return 0;
      }
      AppMethodBeat.o(32451);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ddn
 * JD-Core Version:    0.7.0.1
 */