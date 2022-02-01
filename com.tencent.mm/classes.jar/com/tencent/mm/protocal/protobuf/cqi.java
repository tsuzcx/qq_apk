package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cqi
  extends com.tencent.mm.bx.a
{
  public String GgA;
  public String Guj;
  public int HiR;
  public String SmallImgUrl;
  public String nDo;
  public String nEt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127295);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.nDo != null) {
        paramVarArgs.d(1, this.nDo);
      }
      paramVarArgs.aS(2, this.HiR);
      if (this.nEt != null) {
        paramVarArgs.d(3, this.nEt);
      }
      if (this.SmallImgUrl != null) {
        paramVarArgs.d(4, this.SmallImgUrl);
      }
      if (this.GgA != null) {
        paramVarArgs.d(5, this.GgA);
      }
      if (this.Guj != null) {
        paramVarArgs.d(6, this.Guj);
      }
      AppMethodBeat.o(127295);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nDo == null) {
        break label502;
      }
    }
    label502:
    for (paramInt = f.a.a.b.b.a.e(1, this.nDo) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.HiR);
      paramInt = i;
      if (this.nEt != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nEt);
      }
      i = paramInt;
      if (this.SmallImgUrl != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.SmallImgUrl);
      }
      paramInt = i;
      if (this.GgA != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.GgA);
      }
      i = paramInt;
      if (this.Guj != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.Guj);
      }
      AppMethodBeat.o(127295);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(127295);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cqi localcqi = (cqi)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127295);
          return -1;
        case 1: 
          localcqi.nDo = locala.NPN.readString();
          AppMethodBeat.o(127295);
          return 0;
        case 2: 
          localcqi.HiR = locala.NPN.zc();
          AppMethodBeat.o(127295);
          return 0;
        case 3: 
          localcqi.nEt = locala.NPN.readString();
          AppMethodBeat.o(127295);
          return 0;
        case 4: 
          localcqi.SmallImgUrl = locala.NPN.readString();
          AppMethodBeat.o(127295);
          return 0;
        case 5: 
          localcqi.GgA = locala.NPN.readString();
          AppMethodBeat.o(127295);
          return 0;
        }
        localcqi.Guj = locala.NPN.readString();
        AppMethodBeat.o(127295);
        return 0;
      }
      AppMethodBeat.o(127295);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cqi
 * JD-Core Version:    0.7.0.1
 */