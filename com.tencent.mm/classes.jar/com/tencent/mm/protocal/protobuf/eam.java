package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eam
  extends com.tencent.mm.bx.a
{
  public String Desc;
  public int FuX;
  public String HNz;
  public String Hfq;
  public String ProductID;
  public String Title;
  public String uOt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32508);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Title != null) {
        paramVarArgs.d(1, this.Title);
      }
      if (this.Hfq != null) {
        paramVarArgs.d(2, this.Hfq);
      }
      if (this.uOt != null) {
        paramVarArgs.d(3, this.uOt);
      }
      if (this.Desc != null) {
        paramVarArgs.d(4, this.Desc);
      }
      if (this.HNz != null) {
        paramVarArgs.d(5, this.HNz);
      }
      paramVarArgs.aS(6, this.FuX);
      if (this.ProductID != null) {
        paramVarArgs.d(7, this.ProductID);
      }
      AppMethodBeat.o(32508);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label575;
      }
    }
    label575:
    for (int i = f.a.a.b.b.a.e(1, this.Title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Hfq != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Hfq);
      }
      i = paramInt;
      if (this.uOt != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.uOt);
      }
      paramInt = i;
      if (this.Desc != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Desc);
      }
      i = paramInt;
      if (this.HNz != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.HNz);
      }
      i += f.a.a.b.b.a.bz(6, this.FuX);
      paramInt = i;
      if (this.ProductID != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.ProductID);
      }
      AppMethodBeat.o(32508);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(32508);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        eam localeam = (eam)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32508);
          return -1;
        case 1: 
          localeam.Title = locala.NPN.readString();
          AppMethodBeat.o(32508);
          return 0;
        case 2: 
          localeam.Hfq = locala.NPN.readString();
          AppMethodBeat.o(32508);
          return 0;
        case 3: 
          localeam.uOt = locala.NPN.readString();
          AppMethodBeat.o(32508);
          return 0;
        case 4: 
          localeam.Desc = locala.NPN.readString();
          AppMethodBeat.o(32508);
          return 0;
        case 5: 
          localeam.HNz = locala.NPN.readString();
          AppMethodBeat.o(32508);
          return 0;
        case 6: 
          localeam.FuX = locala.NPN.zc();
          AppMethodBeat.o(32508);
          return 0;
        }
        localeam.ProductID = locala.NPN.readString();
        AppMethodBeat.o(32508);
        return 0;
      }
      AppMethodBeat.o(32508);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eam
 * JD-Core Version:    0.7.0.1
 */