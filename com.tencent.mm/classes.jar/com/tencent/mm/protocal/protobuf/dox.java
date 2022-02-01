package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dox
  extends com.tencent.mm.bx.a
{
  public String DYr;
  public int EFh;
  public String EFi;
  public String EFj;
  public String EFk;
  public String EFl;
  public String EFm;
  public String ProductID;
  public String Title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32504);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Title != null) {
        paramVarArgs.d(1, this.Title);
      }
      if (this.ProductID != null) {
        paramVarArgs.d(2, this.ProductID);
      }
      paramVarArgs.aR(3, this.EFh);
      if (this.EFi != null) {
        paramVarArgs.d(4, this.EFi);
      }
      if (this.DYr != null) {
        paramVarArgs.d(5, this.DYr);
      }
      if (this.EFj != null) {
        paramVarArgs.d(6, this.EFj);
      }
      if (this.EFk != null) {
        paramVarArgs.d(7, this.EFk);
      }
      if (this.EFl != null) {
        paramVarArgs.d(8, this.EFl);
      }
      if (this.EFm != null) {
        paramVarArgs.d(9, this.EFm);
      }
      AppMethodBeat.o(32504);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label701;
      }
    }
    label701:
    for (paramInt = f.a.a.b.b.a.e(1, this.Title) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ProductID != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.ProductID);
      }
      i += f.a.a.b.b.a.bA(3, this.EFh);
      paramInt = i;
      if (this.EFi != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.EFi);
      }
      i = paramInt;
      if (this.DYr != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.DYr);
      }
      paramInt = i;
      if (this.EFj != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.EFj);
      }
      i = paramInt;
      if (this.EFk != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.EFk);
      }
      paramInt = i;
      if (this.EFl != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.EFl);
      }
      i = paramInt;
      if (this.EFm != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.EFm);
      }
      AppMethodBeat.o(32504);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(32504);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dox localdox = (dox)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32504);
          return -1;
        case 1: 
          localdox.Title = locala.KhF.readString();
          AppMethodBeat.o(32504);
          return 0;
        case 2: 
          localdox.ProductID = locala.KhF.readString();
          AppMethodBeat.o(32504);
          return 0;
        case 3: 
          localdox.EFh = locala.KhF.xS();
          AppMethodBeat.o(32504);
          return 0;
        case 4: 
          localdox.EFi = locala.KhF.readString();
          AppMethodBeat.o(32504);
          return 0;
        case 5: 
          localdox.DYr = locala.KhF.readString();
          AppMethodBeat.o(32504);
          return 0;
        case 6: 
          localdox.EFj = locala.KhF.readString();
          AppMethodBeat.o(32504);
          return 0;
        case 7: 
          localdox.EFk = locala.KhF.readString();
          AppMethodBeat.o(32504);
          return 0;
        case 8: 
          localdox.EFl = locala.KhF.readString();
          AppMethodBeat.o(32504);
          return 0;
        }
        localdox.EFm = locala.KhF.readString();
        AppMethodBeat.o(32504);
        return 0;
      }
      AppMethodBeat.o(32504);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dox
 * JD-Core Version:    0.7.0.1
 */