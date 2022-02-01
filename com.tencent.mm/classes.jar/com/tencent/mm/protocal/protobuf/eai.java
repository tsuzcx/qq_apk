package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eai
  extends com.tencent.mm.bx.a
{
  public int HNq;
  public String HNr;
  public String HNs;
  public String HNt;
  public String HNu;
  public String HNv;
  public String Hfq;
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
      paramVarArgs.aS(3, this.HNq);
      if (this.HNr != null) {
        paramVarArgs.d(4, this.HNr);
      }
      if (this.Hfq != null) {
        paramVarArgs.d(5, this.Hfq);
      }
      if (this.HNs != null) {
        paramVarArgs.d(6, this.HNs);
      }
      if (this.HNt != null) {
        paramVarArgs.d(7, this.HNt);
      }
      if (this.HNu != null) {
        paramVarArgs.d(8, this.HNu);
      }
      if (this.HNv != null) {
        paramVarArgs.d(9, this.HNv);
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
      i += f.a.a.b.b.a.bz(3, this.HNq);
      paramInt = i;
      if (this.HNr != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.HNr);
      }
      i = paramInt;
      if (this.Hfq != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Hfq);
      }
      paramInt = i;
      if (this.HNs != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.HNs);
      }
      i = paramInt;
      if (this.HNt != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.HNt);
      }
      paramInt = i;
      if (this.HNu != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.HNu);
      }
      i = paramInt;
      if (this.HNv != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.HNv);
      }
      AppMethodBeat.o(32504);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(32504);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        eai localeai = (eai)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32504);
          return -1;
        case 1: 
          localeai.Title = locala.NPN.readString();
          AppMethodBeat.o(32504);
          return 0;
        case 2: 
          localeai.ProductID = locala.NPN.readString();
          AppMethodBeat.o(32504);
          return 0;
        case 3: 
          localeai.HNq = locala.NPN.zc();
          AppMethodBeat.o(32504);
          return 0;
        case 4: 
          localeai.HNr = locala.NPN.readString();
          AppMethodBeat.o(32504);
          return 0;
        case 5: 
          localeai.Hfq = locala.NPN.readString();
          AppMethodBeat.o(32504);
          return 0;
        case 6: 
          localeai.HNs = locala.NPN.readString();
          AppMethodBeat.o(32504);
          return 0;
        case 7: 
          localeai.HNt = locala.NPN.readString();
          AppMethodBeat.o(32504);
          return 0;
        case 8: 
          localeai.HNu = locala.NPN.readString();
          AppMethodBeat.o(32504);
          return 0;
        }
        localeai.HNv = locala.NPN.readString();
        AppMethodBeat.o(32504);
        return 0;
      }
      AppMethodBeat.o(32504);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eai
 * JD-Core Version:    0.7.0.1
 */