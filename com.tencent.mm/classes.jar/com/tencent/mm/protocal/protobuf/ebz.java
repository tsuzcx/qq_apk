package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ebz
  extends com.tencent.mm.bw.a
{
  public String HyQ;
  public String IhA;
  public String IhB;
  public String IhC;
  public int Ihx;
  public String Ihy;
  public String Ihz;
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
      paramVarArgs.aS(3, this.Ihx);
      if (this.Ihy != null) {
        paramVarArgs.d(4, this.Ihy);
      }
      if (this.HyQ != null) {
        paramVarArgs.d(5, this.HyQ);
      }
      if (this.Ihz != null) {
        paramVarArgs.d(6, this.Ihz);
      }
      if (this.IhA != null) {
        paramVarArgs.d(7, this.IhA);
      }
      if (this.IhB != null) {
        paramVarArgs.d(8, this.IhB);
      }
      if (this.IhC != null) {
        paramVarArgs.d(9, this.IhC);
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
      i += f.a.a.b.b.a.bz(3, this.Ihx);
      paramInt = i;
      if (this.Ihy != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Ihy);
      }
      i = paramInt;
      if (this.HyQ != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.HyQ);
      }
      paramInt = i;
      if (this.Ihz != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Ihz);
      }
      i = paramInt;
      if (this.IhA != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.IhA);
      }
      paramInt = i;
      if (this.IhB != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.IhB);
      }
      i = paramInt;
      if (this.IhC != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.IhC);
      }
      AppMethodBeat.o(32504);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(32504);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ebz localebz = (ebz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32504);
          return -1;
        case 1: 
          localebz.Title = locala.OmT.readString();
          AppMethodBeat.o(32504);
          return 0;
        case 2: 
          localebz.ProductID = locala.OmT.readString();
          AppMethodBeat.o(32504);
          return 0;
        case 3: 
          localebz.Ihx = locala.OmT.zc();
          AppMethodBeat.o(32504);
          return 0;
        case 4: 
          localebz.Ihy = locala.OmT.readString();
          AppMethodBeat.o(32504);
          return 0;
        case 5: 
          localebz.HyQ = locala.OmT.readString();
          AppMethodBeat.o(32504);
          return 0;
        case 6: 
          localebz.Ihz = locala.OmT.readString();
          AppMethodBeat.o(32504);
          return 0;
        case 7: 
          localebz.IhA = locala.OmT.readString();
          AppMethodBeat.o(32504);
          return 0;
        case 8: 
          localebz.IhB = locala.OmT.readString();
          AppMethodBeat.o(32504);
          return 0;
        }
        localebz.IhC = locala.OmT.readString();
        AppMethodBeat.o(32504);
        return 0;
      }
      AppMethodBeat.o(32504);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ebz
 * JD-Core Version:    0.7.0.1
 */