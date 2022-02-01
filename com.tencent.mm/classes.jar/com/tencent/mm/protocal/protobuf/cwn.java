package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class cwn
  extends com.tencent.mm.bx.a
{
  public String Hom;
  public String Hon;
  public b Hoo;
  public long Hop;
  public String Hoq;
  public String Title;
  public String Username;
  public int qex;
  public String ujc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(181512);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Hon != null) {
        paramVarArgs.d(1, this.Hon);
      }
      if (this.Username != null) {
        paramVarArgs.d(2, this.Username);
      }
      if (this.ujc != null) {
        paramVarArgs.d(3, this.ujc);
      }
      paramVarArgs.aS(4, this.qex);
      if (this.Hoo != null) {
        paramVarArgs.c(5, this.Hoo);
      }
      if (this.Title != null) {
        paramVarArgs.d(6, this.Title);
      }
      if (this.Hom != null) {
        paramVarArgs.d(7, this.Hom);
      }
      paramVarArgs.aY(8, this.Hop);
      if (this.Hoq != null) {
        paramVarArgs.d(9, this.Hoq);
      }
      AppMethodBeat.o(181512);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Hon == null) {
        break label670;
      }
    }
    label670:
    for (int i = f.a.a.b.b.a.e(1, this.Hon) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Username != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Username);
      }
      i = paramInt;
      if (this.ujc != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.ujc);
      }
      i += f.a.a.b.b.a.bz(4, this.qex);
      paramInt = i;
      if (this.Hoo != null) {
        paramInt = i + f.a.a.b.b.a.b(5, this.Hoo);
      }
      i = paramInt;
      if (this.Title != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.Title);
      }
      paramInt = i;
      if (this.Hom != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.Hom);
      }
      i = paramInt + f.a.a.b.b.a.p(8, this.Hop);
      paramInt = i;
      if (this.Hoq != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.Hoq);
      }
      AppMethodBeat.o(181512);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(181512);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cwn localcwn = (cwn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(181512);
          return -1;
        case 1: 
          localcwn.Hon = locala.NPN.readString();
          AppMethodBeat.o(181512);
          return 0;
        case 2: 
          localcwn.Username = locala.NPN.readString();
          AppMethodBeat.o(181512);
          return 0;
        case 3: 
          localcwn.ujc = locala.NPN.readString();
          AppMethodBeat.o(181512);
          return 0;
        case 4: 
          localcwn.qex = locala.NPN.zc();
          AppMethodBeat.o(181512);
          return 0;
        case 5: 
          localcwn.Hoo = locala.NPN.gxI();
          AppMethodBeat.o(181512);
          return 0;
        case 6: 
          localcwn.Title = locala.NPN.readString();
          AppMethodBeat.o(181512);
          return 0;
        case 7: 
          localcwn.Hom = locala.NPN.readString();
          AppMethodBeat.o(181512);
          return 0;
        case 8: 
          localcwn.Hop = locala.NPN.zd();
          AppMethodBeat.o(181512);
          return 0;
        }
        localcwn.Hoq = locala.NPN.readString();
        AppMethodBeat.o(181512);
        return 0;
      }
      AppMethodBeat.o(181512);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cwn
 * JD-Core Version:    0.7.0.1
 */