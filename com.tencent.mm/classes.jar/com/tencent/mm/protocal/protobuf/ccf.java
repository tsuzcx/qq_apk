package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ccf
  extends com.tencent.mm.bw.a
{
  public String KMl;
  public String LbJ;
  public String Md5;
  public String Mih;
  public String Name;
  public String Type;
  public String Url;
  public int oUq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32325);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Type != null) {
        paramVarArgs.e(1, this.Type);
      }
      if (this.Name != null) {
        paramVarArgs.e(2, this.Name);
      }
      paramVarArgs.aM(3, this.oUq);
      if (this.Md5 != null) {
        paramVarArgs.e(4, this.Md5);
      }
      if (this.KMl != null) {
        paramVarArgs.e(5, this.KMl);
      }
      if (this.LbJ != null) {
        paramVarArgs.e(6, this.LbJ);
      }
      if (this.Url != null) {
        paramVarArgs.e(7, this.Url);
      }
      if (this.Mih != null) {
        paramVarArgs.e(8, this.Mih);
      }
      AppMethodBeat.o(32325);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Type == null) {
        break label640;
      }
    }
    label640:
    for (paramInt = g.a.a.b.b.a.f(1, this.Type) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Name != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.Name);
      }
      i += g.a.a.b.b.a.bu(3, this.oUq);
      paramInt = i;
      if (this.Md5 != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.Md5);
      }
      i = paramInt;
      if (this.KMl != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.KMl);
      }
      paramInt = i;
      if (this.LbJ != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.LbJ);
      }
      i = paramInt;
      if (this.Url != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.Url);
      }
      paramInt = i;
      if (this.Mih != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.Mih);
      }
      AppMethodBeat.o(32325);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(32325);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ccf localccf = (ccf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32325);
          return -1;
        case 1: 
          localccf.Type = locala.UbS.readString();
          AppMethodBeat.o(32325);
          return 0;
        case 2: 
          localccf.Name = locala.UbS.readString();
          AppMethodBeat.o(32325);
          return 0;
        case 3: 
          localccf.oUq = locala.UbS.zi();
          AppMethodBeat.o(32325);
          return 0;
        case 4: 
          localccf.Md5 = locala.UbS.readString();
          AppMethodBeat.o(32325);
          return 0;
        case 5: 
          localccf.KMl = locala.UbS.readString();
          AppMethodBeat.o(32325);
          return 0;
        case 6: 
          localccf.LbJ = locala.UbS.readString();
          AppMethodBeat.o(32325);
          return 0;
        case 7: 
          localccf.Url = locala.UbS.readString();
          AppMethodBeat.o(32325);
          return 0;
        }
        localccf.Mih = locala.UbS.readString();
        AppMethodBeat.o(32325);
        return 0;
      }
      AppMethodBeat.o(32325);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ccf
 * JD-Core Version:    0.7.0.1
 */