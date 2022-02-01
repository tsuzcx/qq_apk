package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class doo
  extends com.tencent.mm.bw.a
{
  public int FQm;
  public String GKx;
  public String HGj;
  public String HVv;
  public String HVw;
  public String HkY;
  public String Hvr;
  public String Hvt;
  public int Scene;
  public String Title;
  public String hFS;
  public String oxM;
  public int ucK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117934);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Hvt != null) {
        paramVarArgs.d(1, this.Hvt);
      }
      if (this.Hvr != null) {
        paramVarArgs.d(2, this.Hvr);
      }
      if (this.hFS != null) {
        paramVarArgs.d(3, this.hFS);
      }
      if (this.HVv != null) {
        paramVarArgs.d(4, this.HVv);
      }
      if (this.HVw != null) {
        paramVarArgs.d(5, this.HVw);
      }
      if (this.GKx != null) {
        paramVarArgs.d(6, this.GKx);
      }
      if (this.Title != null) {
        paramVarArgs.d(7, this.Title);
      }
      if (this.HkY != null) {
        paramVarArgs.d(8, this.HkY);
      }
      paramVarArgs.aS(9, this.Scene);
      paramVarArgs.aS(10, this.FQm);
      if (this.HGj != null) {
        paramVarArgs.d(11, this.HGj);
      }
      if (this.oxM != null) {
        paramVarArgs.d(12, this.oxM);
      }
      paramVarArgs.aS(13, this.ucK);
      AppMethodBeat.o(117934);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Hvt == null) {
        break label902;
      }
    }
    label902:
    for (int i = f.a.a.b.b.a.e(1, this.Hvt) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Hvr != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Hvr);
      }
      i = paramInt;
      if (this.hFS != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.hFS);
      }
      paramInt = i;
      if (this.HVv != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.HVv);
      }
      i = paramInt;
      if (this.HVw != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.HVw);
      }
      paramInt = i;
      if (this.GKx != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.GKx);
      }
      i = paramInt;
      if (this.Title != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.Title);
      }
      paramInt = i;
      if (this.HkY != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.HkY);
      }
      i = paramInt + f.a.a.b.b.a.bz(9, this.Scene) + f.a.a.b.b.a.bz(10, this.FQm);
      paramInt = i;
      if (this.HGj != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.HGj);
      }
      i = paramInt;
      if (this.oxM != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.oxM);
      }
      paramInt = f.a.a.b.b.a.bz(13, this.ucK);
      AppMethodBeat.o(117934);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(117934);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        doo localdoo = (doo)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117934);
          return -1;
        case 1: 
          localdoo.Hvt = locala.OmT.readString();
          AppMethodBeat.o(117934);
          return 0;
        case 2: 
          localdoo.Hvr = locala.OmT.readString();
          AppMethodBeat.o(117934);
          return 0;
        case 3: 
          localdoo.hFS = locala.OmT.readString();
          AppMethodBeat.o(117934);
          return 0;
        case 4: 
          localdoo.HVv = locala.OmT.readString();
          AppMethodBeat.o(117934);
          return 0;
        case 5: 
          localdoo.HVw = locala.OmT.readString();
          AppMethodBeat.o(117934);
          return 0;
        case 6: 
          localdoo.GKx = locala.OmT.readString();
          AppMethodBeat.o(117934);
          return 0;
        case 7: 
          localdoo.Title = locala.OmT.readString();
          AppMethodBeat.o(117934);
          return 0;
        case 8: 
          localdoo.HkY = locala.OmT.readString();
          AppMethodBeat.o(117934);
          return 0;
        case 9: 
          localdoo.Scene = locala.OmT.zc();
          AppMethodBeat.o(117934);
          return 0;
        case 10: 
          localdoo.FQm = locala.OmT.zc();
          AppMethodBeat.o(117934);
          return 0;
        case 11: 
          localdoo.HGj = locala.OmT.readString();
          AppMethodBeat.o(117934);
          return 0;
        case 12: 
          localdoo.oxM = locala.OmT.readString();
          AppMethodBeat.o(117934);
          return 0;
        }
        localdoo.ucK = locala.OmT.zc();
        AppMethodBeat.o(117934);
        return 0;
      }
      AppMethodBeat.o(117934);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.doo
 * JD-Core Version:    0.7.0.1
 */