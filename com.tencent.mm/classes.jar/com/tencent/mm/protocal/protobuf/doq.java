package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class doq
  extends com.tencent.mm.bw.a
{
  public int FQm;
  public String HGj;
  public String HVx;
  public String HkY;
  public String Hvr;
  public String Hvt;
  public int Scene;
  public int gvx;
  public String hFS;
  public String oxM;
  public int ucK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117936);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Hvr != null) {
        paramVarArgs.d(1, this.Hvr);
      }
      if (this.HVx != null) {
        paramVarArgs.d(2, this.HVx);
      }
      paramVarArgs.aS(3, this.gvx);
      if (this.Hvt != null) {
        paramVarArgs.d(4, this.Hvt);
      }
      if (this.hFS != null) {
        paramVarArgs.d(5, this.hFS);
      }
      paramVarArgs.aS(6, this.Scene);
      if (this.HkY != null) {
        paramVarArgs.d(7, this.HkY);
      }
      paramVarArgs.aS(8, this.FQm);
      if (this.oxM != null) {
        paramVarArgs.d(9, this.oxM);
      }
      if (this.HGj != null) {
        paramVarArgs.d(10, this.HGj);
      }
      paramVarArgs.aS(11, this.ucK);
      AppMethodBeat.o(117936);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Hvr == null) {
        break label762;
      }
    }
    label762:
    for (paramInt = f.a.a.b.b.a.e(1, this.Hvr) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.HVx != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.HVx);
      }
      i += f.a.a.b.b.a.bz(3, this.gvx);
      paramInt = i;
      if (this.Hvt != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Hvt);
      }
      i = paramInt;
      if (this.hFS != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.hFS);
      }
      i += f.a.a.b.b.a.bz(6, this.Scene);
      paramInt = i;
      if (this.HkY != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.HkY);
      }
      i = paramInt + f.a.a.b.b.a.bz(8, this.FQm);
      paramInt = i;
      if (this.oxM != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.oxM);
      }
      i = paramInt;
      if (this.HGj != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.HGj);
      }
      paramInt = f.a.a.b.b.a.bz(11, this.ucK);
      AppMethodBeat.o(117936);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(117936);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        doq localdoq = (doq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117936);
          return -1;
        case 1: 
          localdoq.Hvr = locala.OmT.readString();
          AppMethodBeat.o(117936);
          return 0;
        case 2: 
          localdoq.HVx = locala.OmT.readString();
          AppMethodBeat.o(117936);
          return 0;
        case 3: 
          localdoq.gvx = locala.OmT.zc();
          AppMethodBeat.o(117936);
          return 0;
        case 4: 
          localdoq.Hvt = locala.OmT.readString();
          AppMethodBeat.o(117936);
          return 0;
        case 5: 
          localdoq.hFS = locala.OmT.readString();
          AppMethodBeat.o(117936);
          return 0;
        case 6: 
          localdoq.Scene = locala.OmT.zc();
          AppMethodBeat.o(117936);
          return 0;
        case 7: 
          localdoq.HkY = locala.OmT.readString();
          AppMethodBeat.o(117936);
          return 0;
        case 8: 
          localdoq.FQm = locala.OmT.zc();
          AppMethodBeat.o(117936);
          return 0;
        case 9: 
          localdoq.oxM = locala.OmT.readString();
          AppMethodBeat.o(117936);
          return 0;
        case 10: 
          localdoq.HGj = locala.OmT.readString();
          AppMethodBeat.o(117936);
          return 0;
        }
        localdoq.ucK = locala.OmT.zc();
        AppMethodBeat.o(117936);
        return 0;
      }
      AppMethodBeat.o(117936);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.doq
 * JD-Core Version:    0.7.0.1
 */