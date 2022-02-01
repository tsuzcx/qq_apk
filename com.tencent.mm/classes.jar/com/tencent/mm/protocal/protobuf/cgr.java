package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cgr
  extends com.tencent.mm.bx.a
{
  public String GZZ;
  public String Haa;
  public String Hab;
  public String Hac;
  public String Had;
  public String Hae;
  public String Haf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209383);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GZZ != null) {
        paramVarArgs.d(1, this.GZZ);
      }
      if (this.Haa != null) {
        paramVarArgs.d(2, this.Haa);
      }
      if (this.Hab != null) {
        paramVarArgs.d(3, this.Hab);
      }
      if (this.Hac != null) {
        paramVarArgs.d(4, this.Hac);
      }
      if (this.Had != null) {
        paramVarArgs.d(5, this.Had);
      }
      if (this.Hae != null) {
        paramVarArgs.d(6, this.Hae);
      }
      if (this.Haf != null) {
        paramVarArgs.d(7, this.Haf);
      }
      AppMethodBeat.o(209383);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GZZ == null) {
        break label578;
      }
    }
    label578:
    for (int i = f.a.a.b.b.a.e(1, this.GZZ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Haa != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Haa);
      }
      i = paramInt;
      if (this.Hab != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Hab);
      }
      paramInt = i;
      if (this.Hac != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Hac);
      }
      i = paramInt;
      if (this.Had != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Had);
      }
      paramInt = i;
      if (this.Hae != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Hae);
      }
      i = paramInt;
      if (this.Haf != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.Haf);
      }
      AppMethodBeat.o(209383);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(209383);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cgr localcgr = (cgr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(209383);
          return -1;
        case 1: 
          localcgr.GZZ = locala.NPN.readString();
          AppMethodBeat.o(209383);
          return 0;
        case 2: 
          localcgr.Haa = locala.NPN.readString();
          AppMethodBeat.o(209383);
          return 0;
        case 3: 
          localcgr.Hab = locala.NPN.readString();
          AppMethodBeat.o(209383);
          return 0;
        case 4: 
          localcgr.Hac = locala.NPN.readString();
          AppMethodBeat.o(209383);
          return 0;
        case 5: 
          localcgr.Had = locala.NPN.readString();
          AppMethodBeat.o(209383);
          return 0;
        case 6: 
          localcgr.Hae = locala.NPN.readString();
          AppMethodBeat.o(209383);
          return 0;
        }
        localcgr.Haf = locala.NPN.readString();
        AppMethodBeat.o(209383);
        return 0;
      }
      AppMethodBeat.o(209383);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cgr
 * JD-Core Version:    0.7.0.1
 */