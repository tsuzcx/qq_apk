package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ecd
  extends com.tencent.mm.bw.a
{
  public String Desc;
  public int FNv;
  public String HyQ;
  public String IhG;
  public String ProductID;
  public String Title;
  public String urq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32508);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Title != null) {
        paramVarArgs.d(1, this.Title);
      }
      if (this.HyQ != null) {
        paramVarArgs.d(2, this.HyQ);
      }
      if (this.urq != null) {
        paramVarArgs.d(3, this.urq);
      }
      if (this.Desc != null) {
        paramVarArgs.d(4, this.Desc);
      }
      if (this.IhG != null) {
        paramVarArgs.d(5, this.IhG);
      }
      paramVarArgs.aS(6, this.FNv);
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
      if (this.HyQ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.HyQ);
      }
      i = paramInt;
      if (this.urq != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.urq);
      }
      paramInt = i;
      if (this.Desc != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Desc);
      }
      i = paramInt;
      if (this.IhG != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.IhG);
      }
      i += f.a.a.b.b.a.bz(6, this.FNv);
      paramInt = i;
      if (this.ProductID != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.ProductID);
      }
      AppMethodBeat.o(32508);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(32508);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ecd localecd = (ecd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32508);
          return -1;
        case 1: 
          localecd.Title = locala.OmT.readString();
          AppMethodBeat.o(32508);
          return 0;
        case 2: 
          localecd.HyQ = locala.OmT.readString();
          AppMethodBeat.o(32508);
          return 0;
        case 3: 
          localecd.urq = locala.OmT.readString();
          AppMethodBeat.o(32508);
          return 0;
        case 4: 
          localecd.Desc = locala.OmT.readString();
          AppMethodBeat.o(32508);
          return 0;
        case 5: 
          localecd.IhG = locala.OmT.readString();
          AppMethodBeat.o(32508);
          return 0;
        case 6: 
          localecd.FNv = locala.OmT.zc();
          AppMethodBeat.o(32508);
          return 0;
        }
        localecd.ProductID = locala.OmT.readString();
        AppMethodBeat.o(32508);
        return 0;
      }
      AppMethodBeat.o(32508);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ecd
 * JD-Core Version:    0.7.0.1
 */