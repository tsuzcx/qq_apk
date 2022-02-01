package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dlu
  extends com.tencent.mm.bw.a
{
  public String HTw;
  public String HTx;
  public String iDA;
  public String iDB;
  public String iDr;
  public String iDs;
  public String iDt;
  public String iDu;
  public String iDv;
  public String iDw;
  public String iDx;
  public String iDy;
  public String iDz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152710);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.iDr != null) {
        paramVarArgs.d(1, this.iDr);
      }
      if (this.iDs != null) {
        paramVarArgs.d(2, this.iDs);
      }
      if (this.iDt != null) {
        paramVarArgs.d(3, this.iDt);
      }
      if (this.iDu != null) {
        paramVarArgs.d(4, this.iDu);
      }
      if (this.iDv != null) {
        paramVarArgs.d(5, this.iDv);
      }
      if (this.iDw != null) {
        paramVarArgs.d(6, this.iDw);
      }
      if (this.iDx != null) {
        paramVarArgs.d(7, this.iDx);
      }
      if (this.iDy != null) {
        paramVarArgs.d(8, this.iDy);
      }
      if (this.iDz != null) {
        paramVarArgs.d(9, this.iDz);
      }
      if (this.iDA != null) {
        paramVarArgs.d(10, this.iDA);
      }
      if (this.iDB != null) {
        paramVarArgs.d(11, this.iDB);
      }
      if (this.HTw != null) {
        paramVarArgs.d(12, this.HTw);
      }
      if (this.HTx != null) {
        paramVarArgs.d(13, this.HTx);
      }
      AppMethodBeat.o(152710);
      return 0;
    }
    if (paramInt == 1) {
      if (this.iDr == null) {
        break label950;
      }
    }
    label950:
    for (int i = f.a.a.b.b.a.e(1, this.iDr) + 0;; i = 0)
    {
      paramInt = i;
      if (this.iDs != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.iDs);
      }
      i = paramInt;
      if (this.iDt != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.iDt);
      }
      paramInt = i;
      if (this.iDu != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.iDu);
      }
      i = paramInt;
      if (this.iDv != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.iDv);
      }
      paramInt = i;
      if (this.iDw != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.iDw);
      }
      i = paramInt;
      if (this.iDx != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.iDx);
      }
      paramInt = i;
      if (this.iDy != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.iDy);
      }
      i = paramInt;
      if (this.iDz != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.iDz);
      }
      paramInt = i;
      if (this.iDA != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.iDA);
      }
      i = paramInt;
      if (this.iDB != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.iDB);
      }
      paramInt = i;
      if (this.HTw != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.HTw);
      }
      i = paramInt;
      if (this.HTx != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.HTx);
      }
      AppMethodBeat.o(152710);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(152710);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dlu localdlu = (dlu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152710);
          return -1;
        case 1: 
          localdlu.iDr = locala.OmT.readString();
          AppMethodBeat.o(152710);
          return 0;
        case 2: 
          localdlu.iDs = locala.OmT.readString();
          AppMethodBeat.o(152710);
          return 0;
        case 3: 
          localdlu.iDt = locala.OmT.readString();
          AppMethodBeat.o(152710);
          return 0;
        case 4: 
          localdlu.iDu = locala.OmT.readString();
          AppMethodBeat.o(152710);
          return 0;
        case 5: 
          localdlu.iDv = locala.OmT.readString();
          AppMethodBeat.o(152710);
          return 0;
        case 6: 
          localdlu.iDw = locala.OmT.readString();
          AppMethodBeat.o(152710);
          return 0;
        case 7: 
          localdlu.iDx = locala.OmT.readString();
          AppMethodBeat.o(152710);
          return 0;
        case 8: 
          localdlu.iDy = locala.OmT.readString();
          AppMethodBeat.o(152710);
          return 0;
        case 9: 
          localdlu.iDz = locala.OmT.readString();
          AppMethodBeat.o(152710);
          return 0;
        case 10: 
          localdlu.iDA = locala.OmT.readString();
          AppMethodBeat.o(152710);
          return 0;
        case 11: 
          localdlu.iDB = locala.OmT.readString();
          AppMethodBeat.o(152710);
          return 0;
        case 12: 
          localdlu.HTw = locala.OmT.readString();
          AppMethodBeat.o(152710);
          return 0;
        }
        localdlu.HTx = locala.OmT.readString();
        AppMethodBeat.o(152710);
        return 0;
      }
      AppMethodBeat.o(152710);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dlu
 * JD-Core Version:    0.7.0.1
 */