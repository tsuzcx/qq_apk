package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ewk
  extends com.tencent.mm.bw.a
{
  public String Desc;
  public int KHa;
  public String MJz;
  public String Nuh;
  public String ProductID;
  public String Title;
  public String xJH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32508);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Title != null) {
        paramVarArgs.e(1, this.Title);
      }
      if (this.MJz != null) {
        paramVarArgs.e(2, this.MJz);
      }
      if (this.xJH != null) {
        paramVarArgs.e(3, this.xJH);
      }
      if (this.Desc != null) {
        paramVarArgs.e(4, this.Desc);
      }
      if (this.Nuh != null) {
        paramVarArgs.e(5, this.Nuh);
      }
      paramVarArgs.aM(6, this.KHa);
      if (this.ProductID != null) {
        paramVarArgs.e(7, this.ProductID);
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
    for (int i = g.a.a.b.b.a.f(1, this.Title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.MJz != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.MJz);
      }
      i = paramInt;
      if (this.xJH != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.xJH);
      }
      paramInt = i;
      if (this.Desc != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.Desc);
      }
      i = paramInt;
      if (this.Nuh != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.Nuh);
      }
      i += g.a.a.b.b.a.bu(6, this.KHa);
      paramInt = i;
      if (this.ProductID != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.ProductID);
      }
      AppMethodBeat.o(32508);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(32508);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ewk localewk = (ewk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32508);
          return -1;
        case 1: 
          localewk.Title = locala.UbS.readString();
          AppMethodBeat.o(32508);
          return 0;
        case 2: 
          localewk.MJz = locala.UbS.readString();
          AppMethodBeat.o(32508);
          return 0;
        case 3: 
          localewk.xJH = locala.UbS.readString();
          AppMethodBeat.o(32508);
          return 0;
        case 4: 
          localewk.Desc = locala.UbS.readString();
          AppMethodBeat.o(32508);
          return 0;
        case 5: 
          localewk.Nuh = locala.UbS.readString();
          AppMethodBeat.o(32508);
          return 0;
        case 6: 
          localewk.KHa = locala.UbS.zi();
          AppMethodBeat.o(32508);
          return 0;
        }
        localewk.ProductID = locala.UbS.readString();
        AppMethodBeat.o(32508);
        return 0;
      }
      AppMethodBeat.o(32508);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ewk
 * JD-Core Version:    0.7.0.1
 */