package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cum
  extends com.tencent.mm.bw.a
{
  public int HFo;
  public int HFp;
  public String gvo;
  public String gvp;
  public String gvq;
  public String gvr;
  public String nJo;
  public String oxH;
  public int zlE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123640);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.nJo != null) {
        paramVarArgs.d(1, this.nJo);
      }
      paramVarArgs.aS(2, this.HFo);
      if (this.gvo != null) {
        paramVarArgs.d(3, this.gvo);
      }
      if (this.gvp != null) {
        paramVarArgs.d(4, this.gvp);
      }
      paramVarArgs.aS(5, this.zlE);
      paramVarArgs.aS(6, this.HFp);
      if (this.gvq != null) {
        paramVarArgs.d(7, this.gvq);
      }
      if (this.gvr != null) {
        paramVarArgs.d(8, this.gvr);
      }
      if (this.oxH != null) {
        paramVarArgs.d(9, this.oxH);
      }
      AppMethodBeat.o(123640);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nJo == null) {
        break label654;
      }
    }
    label654:
    for (paramInt = f.a.a.b.b.a.e(1, this.nJo) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.HFo);
      paramInt = i;
      if (this.gvo != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.gvo);
      }
      i = paramInt;
      if (this.gvp != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.gvp);
      }
      i = i + f.a.a.b.b.a.bz(5, this.zlE) + f.a.a.b.b.a.bz(6, this.HFp);
      paramInt = i;
      if (this.gvq != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.gvq);
      }
      i = paramInt;
      if (this.gvr != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.gvr);
      }
      paramInt = i;
      if (this.oxH != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.oxH);
      }
      AppMethodBeat.o(123640);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(123640);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cum localcum = (cum)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123640);
          return -1;
        case 1: 
          localcum.nJo = locala.OmT.readString();
          AppMethodBeat.o(123640);
          return 0;
        case 2: 
          localcum.HFo = locala.OmT.zc();
          AppMethodBeat.o(123640);
          return 0;
        case 3: 
          localcum.gvo = locala.OmT.readString();
          AppMethodBeat.o(123640);
          return 0;
        case 4: 
          localcum.gvp = locala.OmT.readString();
          AppMethodBeat.o(123640);
          return 0;
        case 5: 
          localcum.zlE = locala.OmT.zc();
          AppMethodBeat.o(123640);
          return 0;
        case 6: 
          localcum.HFp = locala.OmT.zc();
          AppMethodBeat.o(123640);
          return 0;
        case 7: 
          localcum.gvq = locala.OmT.readString();
          AppMethodBeat.o(123640);
          return 0;
        case 8: 
          localcum.gvr = locala.OmT.readString();
          AppMethodBeat.o(123640);
          return 0;
        }
        localcum.oxH = locala.OmT.readString();
        AppMethodBeat.o(123640);
        return 0;
      }
      AppMethodBeat.o(123640);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cum
 * JD-Core Version:    0.7.0.1
 */