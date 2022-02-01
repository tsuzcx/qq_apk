package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ewg
  extends com.tencent.mm.bw.a
{
  public String MJz;
  public int NtY;
  public String NtZ;
  public String Nua;
  public String Nub;
  public String Nuc;
  public String Nud;
  public String ProductID;
  public String Title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32504);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Title != null) {
        paramVarArgs.e(1, this.Title);
      }
      if (this.ProductID != null) {
        paramVarArgs.e(2, this.ProductID);
      }
      paramVarArgs.aM(3, this.NtY);
      if (this.NtZ != null) {
        paramVarArgs.e(4, this.NtZ);
      }
      if (this.MJz != null) {
        paramVarArgs.e(5, this.MJz);
      }
      if (this.Nua != null) {
        paramVarArgs.e(6, this.Nua);
      }
      if (this.Nub != null) {
        paramVarArgs.e(7, this.Nub);
      }
      if (this.Nuc != null) {
        paramVarArgs.e(8, this.Nuc);
      }
      if (this.Nud != null) {
        paramVarArgs.e(9, this.Nud);
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
    for (paramInt = g.a.a.b.b.a.f(1, this.Title) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ProductID != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.ProductID);
      }
      i += g.a.a.b.b.a.bu(3, this.NtY);
      paramInt = i;
      if (this.NtZ != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.NtZ);
      }
      i = paramInt;
      if (this.MJz != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.MJz);
      }
      paramInt = i;
      if (this.Nua != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.Nua);
      }
      i = paramInt;
      if (this.Nub != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.Nub);
      }
      paramInt = i;
      if (this.Nuc != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.Nuc);
      }
      i = paramInt;
      if (this.Nud != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.Nud);
      }
      AppMethodBeat.o(32504);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(32504);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ewg localewg = (ewg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32504);
          return -1;
        case 1: 
          localewg.Title = locala.UbS.readString();
          AppMethodBeat.o(32504);
          return 0;
        case 2: 
          localewg.ProductID = locala.UbS.readString();
          AppMethodBeat.o(32504);
          return 0;
        case 3: 
          localewg.NtY = locala.UbS.zi();
          AppMethodBeat.o(32504);
          return 0;
        case 4: 
          localewg.NtZ = locala.UbS.readString();
          AppMethodBeat.o(32504);
          return 0;
        case 5: 
          localewg.MJz = locala.UbS.readString();
          AppMethodBeat.o(32504);
          return 0;
        case 6: 
          localewg.Nua = locala.UbS.readString();
          AppMethodBeat.o(32504);
          return 0;
        case 7: 
          localewg.Nub = locala.UbS.readString();
          AppMethodBeat.o(32504);
          return 0;
        case 8: 
          localewg.Nuc = locala.UbS.readString();
          AppMethodBeat.o(32504);
          return 0;
        }
        localewg.Nud = locala.UbS.readString();
        AppMethodBeat.o(32504);
        return 0;
      }
      AppMethodBeat.o(32504);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ewg
 * JD-Core Version:    0.7.0.1
 */