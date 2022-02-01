package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dpb
  extends com.tencent.mm.bx.a
{
  public int Cxm;
  public String DYr;
  public String Desc;
  public String EFq;
  public String ProductID;
  public String Title;
  public String sDZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32508);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Title != null) {
        paramVarArgs.d(1, this.Title);
      }
      if (this.DYr != null) {
        paramVarArgs.d(2, this.DYr);
      }
      if (this.sDZ != null) {
        paramVarArgs.d(3, this.sDZ);
      }
      if (this.Desc != null) {
        paramVarArgs.d(4, this.Desc);
      }
      if (this.EFq != null) {
        paramVarArgs.d(5, this.EFq);
      }
      paramVarArgs.aR(6, this.Cxm);
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
      if (this.DYr != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DYr);
      }
      i = paramInt;
      if (this.sDZ != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.sDZ);
      }
      paramInt = i;
      if (this.Desc != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Desc);
      }
      i = paramInt;
      if (this.EFq != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.EFq);
      }
      i += f.a.a.b.b.a.bA(6, this.Cxm);
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
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(32508);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dpb localdpb = (dpb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32508);
          return -1;
        case 1: 
          localdpb.Title = locala.KhF.readString();
          AppMethodBeat.o(32508);
          return 0;
        case 2: 
          localdpb.DYr = locala.KhF.readString();
          AppMethodBeat.o(32508);
          return 0;
        case 3: 
          localdpb.sDZ = locala.KhF.readString();
          AppMethodBeat.o(32508);
          return 0;
        case 4: 
          localdpb.Desc = locala.KhF.readString();
          AppMethodBeat.o(32508);
          return 0;
        case 5: 
          localdpb.EFq = locala.KhF.readString();
          AppMethodBeat.o(32508);
          return 0;
        case 6: 
          localdpb.Cxm = locala.KhF.xS();
          AppMethodBeat.o(32508);
          return 0;
        }
        localdpb.ProductID = locala.KhF.readString();
        AppMethodBeat.o(32508);
        return 0;
      }
      AppMethodBeat.o(32508);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dpb
 * JD-Core Version:    0.7.0.1
 */