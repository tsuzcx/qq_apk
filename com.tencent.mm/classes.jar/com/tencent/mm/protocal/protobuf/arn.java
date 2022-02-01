package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class arn
  extends com.tencent.mm.bw.a
{
  public String extraInfo;
  public String rfA;
  public String rfo;
  public String rfr;
  public int sCF;
  public int sch;
  public String sessionId;
  public long tnd;
  public String tne;
  public int tnf;
  public int tng;
  public int tnh;
  public String tni;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(189396);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.sessionId != null) {
        paramVarArgs.d(1, this.sessionId);
      }
      if (this.rfA != null) {
        paramVarArgs.d(2, this.rfA);
      }
      if (this.rfo != null) {
        paramVarArgs.d(3, this.rfo);
      }
      if (this.tne != null) {
        paramVarArgs.d(4, this.tne);
      }
      paramVarArgs.aS(5, this.sCF);
      paramVarArgs.aS(6, this.sch);
      paramVarArgs.aZ(7, this.tnd);
      paramVarArgs.aS(8, this.tnf);
      paramVarArgs.aS(9, this.tng);
      if (this.tni != null) {
        paramVarArgs.d(10, this.tni);
      }
      paramVarArgs.aS(11, this.tnh);
      if (this.extraInfo != null) {
        paramVarArgs.d(12, this.extraInfo);
      }
      if (this.rfr != null) {
        paramVarArgs.d(13, this.rfr);
      }
      AppMethodBeat.o(189396);
      return 0;
    }
    if (paramInt == 1) {
      if (this.sessionId == null) {
        break label846;
      }
    }
    label846:
    for (int i = f.a.a.b.b.a.e(1, this.sessionId) + 0;; i = 0)
    {
      paramInt = i;
      if (this.rfA != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.rfA);
      }
      i = paramInt;
      if (this.rfo != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.rfo);
      }
      paramInt = i;
      if (this.tne != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.tne);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.sCF) + f.a.a.b.b.a.bz(6, this.sch) + f.a.a.b.b.a.p(7, this.tnd) + f.a.a.b.b.a.bz(8, this.tnf) + f.a.a.b.b.a.bz(9, this.tng);
      paramInt = i;
      if (this.tni != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.tni);
      }
      i = paramInt + f.a.a.b.b.a.bz(11, this.tnh);
      paramInt = i;
      if (this.extraInfo != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.extraInfo);
      }
      i = paramInt;
      if (this.rfr != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.rfr);
      }
      AppMethodBeat.o(189396);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(189396);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        arn localarn = (arn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(189396);
          return -1;
        case 1: 
          localarn.sessionId = locala.OmT.readString();
          AppMethodBeat.o(189396);
          return 0;
        case 2: 
          localarn.rfA = locala.OmT.readString();
          AppMethodBeat.o(189396);
          return 0;
        case 3: 
          localarn.rfo = locala.OmT.readString();
          AppMethodBeat.o(189396);
          return 0;
        case 4: 
          localarn.tne = locala.OmT.readString();
          AppMethodBeat.o(189396);
          return 0;
        case 5: 
          localarn.sCF = locala.OmT.zc();
          AppMethodBeat.o(189396);
          return 0;
        case 6: 
          localarn.sch = locala.OmT.zc();
          AppMethodBeat.o(189396);
          return 0;
        case 7: 
          localarn.tnd = locala.OmT.zd();
          AppMethodBeat.o(189396);
          return 0;
        case 8: 
          localarn.tnf = locala.OmT.zc();
          AppMethodBeat.o(189396);
          return 0;
        case 9: 
          localarn.tng = locala.OmT.zc();
          AppMethodBeat.o(189396);
          return 0;
        case 10: 
          localarn.tni = locala.OmT.readString();
          AppMethodBeat.o(189396);
          return 0;
        case 11: 
          localarn.tnh = locala.OmT.zc();
          AppMethodBeat.o(189396);
          return 0;
        case 12: 
          localarn.extraInfo = locala.OmT.readString();
          AppMethodBeat.o(189396);
          return 0;
        }
        localarn.rfr = locala.OmT.readString();
        AppMethodBeat.o(189396);
        return 0;
      }
      AppMethodBeat.o(189396);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.arn
 * JD-Core Version:    0.7.0.1
 */