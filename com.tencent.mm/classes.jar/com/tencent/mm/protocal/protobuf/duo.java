package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class duo
  extends com.tencent.mm.bw.a
{
  public String Fvl;
  public int Gct;
  public String Gcu;
  public String Gcv;
  public String Gcw;
  public String Gcx;
  public String Gcy;
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
      paramVarArgs.aR(3, this.Gct);
      if (this.Gcu != null) {
        paramVarArgs.d(4, this.Gcu);
      }
      if (this.Fvl != null) {
        paramVarArgs.d(5, this.Fvl);
      }
      if (this.Gcv != null) {
        paramVarArgs.d(6, this.Gcv);
      }
      if (this.Gcw != null) {
        paramVarArgs.d(7, this.Gcw);
      }
      if (this.Gcx != null) {
        paramVarArgs.d(8, this.Gcx);
      }
      if (this.Gcy != null) {
        paramVarArgs.d(9, this.Gcy);
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
      i += f.a.a.b.b.a.bx(3, this.Gct);
      paramInt = i;
      if (this.Gcu != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Gcu);
      }
      i = paramInt;
      if (this.Fvl != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Fvl);
      }
      paramInt = i;
      if (this.Gcv != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Gcv);
      }
      i = paramInt;
      if (this.Gcw != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.Gcw);
      }
      paramInt = i;
      if (this.Gcx != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.Gcx);
      }
      i = paramInt;
      if (this.Gcy != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.Gcy);
      }
      AppMethodBeat.o(32504);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(32504);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        duo localduo = (duo)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32504);
          return -1;
        case 1: 
          localduo.Title = locala.LVo.readString();
          AppMethodBeat.o(32504);
          return 0;
        case 2: 
          localduo.ProductID = locala.LVo.readString();
          AppMethodBeat.o(32504);
          return 0;
        case 3: 
          localduo.Gct = locala.LVo.xF();
          AppMethodBeat.o(32504);
          return 0;
        case 4: 
          localduo.Gcu = locala.LVo.readString();
          AppMethodBeat.o(32504);
          return 0;
        case 5: 
          localduo.Fvl = locala.LVo.readString();
          AppMethodBeat.o(32504);
          return 0;
        case 6: 
          localduo.Gcv = locala.LVo.readString();
          AppMethodBeat.o(32504);
          return 0;
        case 7: 
          localduo.Gcw = locala.LVo.readString();
          AppMethodBeat.o(32504);
          return 0;
        case 8: 
          localduo.Gcx = locala.LVo.readString();
          AppMethodBeat.o(32504);
          return 0;
        }
        localduo.Gcy = locala.LVo.readString();
        AppMethodBeat.o(32504);
        return 0;
      }
      AppMethodBeat.o(32504);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.duo
 * JD-Core Version:    0.7.0.1
 */