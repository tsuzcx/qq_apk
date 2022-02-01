package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dus
  extends com.tencent.mm.bw.a
{
  public int DPI;
  public String Desc;
  public String Fvl;
  public String GcC;
  public String ProductID;
  public String Title;
  public String tLG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32508);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Title != null) {
        paramVarArgs.d(1, this.Title);
      }
      if (this.Fvl != null) {
        paramVarArgs.d(2, this.Fvl);
      }
      if (this.tLG != null) {
        paramVarArgs.d(3, this.tLG);
      }
      if (this.Desc != null) {
        paramVarArgs.d(4, this.Desc);
      }
      if (this.GcC != null) {
        paramVarArgs.d(5, this.GcC);
      }
      paramVarArgs.aR(6, this.DPI);
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
      if (this.Fvl != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Fvl);
      }
      i = paramInt;
      if (this.tLG != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.tLG);
      }
      paramInt = i;
      if (this.Desc != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Desc);
      }
      i = paramInt;
      if (this.GcC != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.GcC);
      }
      i += f.a.a.b.b.a.bx(6, this.DPI);
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
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(32508);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dus localdus = (dus)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32508);
          return -1;
        case 1: 
          localdus.Title = locala.LVo.readString();
          AppMethodBeat.o(32508);
          return 0;
        case 2: 
          localdus.Fvl = locala.LVo.readString();
          AppMethodBeat.o(32508);
          return 0;
        case 3: 
          localdus.tLG = locala.LVo.readString();
          AppMethodBeat.o(32508);
          return 0;
        case 4: 
          localdus.Desc = locala.LVo.readString();
          AppMethodBeat.o(32508);
          return 0;
        case 5: 
          localdus.GcC = locala.LVo.readString();
          AppMethodBeat.o(32508);
          return 0;
        case 6: 
          localdus.DPI = locala.LVo.xF();
          AppMethodBeat.o(32508);
          return 0;
        }
        localdus.ProductID = locala.LVo.readString();
        AppMethodBeat.o(32508);
        return 0;
      }
      AppMethodBeat.o(32508);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dus
 * JD-Core Version:    0.7.0.1
 */