package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cca
  extends com.tencent.mm.bw.a
{
  public String Fqp;
  public String Fqq;
  public String Fqr;
  public String Fqs;
  public String Fqt;
  public String Fqu;
  public String Fqv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(195129);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Fqp != null) {
        paramVarArgs.d(1, this.Fqp);
      }
      if (this.Fqq != null) {
        paramVarArgs.d(2, this.Fqq);
      }
      if (this.Fqr != null) {
        paramVarArgs.d(3, this.Fqr);
      }
      if (this.Fqs != null) {
        paramVarArgs.d(4, this.Fqs);
      }
      if (this.Fqt != null) {
        paramVarArgs.d(5, this.Fqt);
      }
      if (this.Fqu != null) {
        paramVarArgs.d(6, this.Fqu);
      }
      if (this.Fqv != null) {
        paramVarArgs.d(7, this.Fqv);
      }
      AppMethodBeat.o(195129);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Fqp == null) {
        break label578;
      }
    }
    label578:
    for (int i = f.a.a.b.b.a.e(1, this.Fqp) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Fqq != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Fqq);
      }
      i = paramInt;
      if (this.Fqr != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Fqr);
      }
      paramInt = i;
      if (this.Fqs != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Fqs);
      }
      i = paramInt;
      if (this.Fqt != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Fqt);
      }
      paramInt = i;
      if (this.Fqu != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Fqu);
      }
      i = paramInt;
      if (this.Fqv != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.Fqv);
      }
      AppMethodBeat.o(195129);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(195129);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cca localcca = (cca)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(195129);
          return -1;
        case 1: 
          localcca.Fqp = locala.LVo.readString();
          AppMethodBeat.o(195129);
          return 0;
        case 2: 
          localcca.Fqq = locala.LVo.readString();
          AppMethodBeat.o(195129);
          return 0;
        case 3: 
          localcca.Fqr = locala.LVo.readString();
          AppMethodBeat.o(195129);
          return 0;
        case 4: 
          localcca.Fqs = locala.LVo.readString();
          AppMethodBeat.o(195129);
          return 0;
        case 5: 
          localcca.Fqt = locala.LVo.readString();
          AppMethodBeat.o(195129);
          return 0;
        case 6: 
          localcca.Fqu = locala.LVo.readString();
          AppMethodBeat.o(195129);
          return 0;
        }
        localcca.Fqv = locala.LVo.readString();
        AppMethodBeat.o(195129);
        return 0;
      }
      AppMethodBeat.o(195129);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cca
 * JD-Core Version:    0.7.0.1
 */