package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fu
  extends com.tencent.mm.bx.a
{
  public int FxX;
  public int FxY;
  public int FxZ;
  public int Fya;
  public int Fyb;
  public String Fyc;
  public int Fyd;
  public int height;
  public long ood;
  public String url;
  public int width;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(103201);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.url != null) {
        paramVarArgs.d(1, this.url);
      }
      paramVarArgs.aS(2, this.FxX);
      paramVarArgs.aS(3, this.FxY);
      paramVarArgs.aY(4, this.ood);
      paramVarArgs.aS(5, this.width);
      paramVarArgs.aS(6, this.height);
      paramVarArgs.aS(10, this.FxZ);
      paramVarArgs.aS(11, this.Fya);
      paramVarArgs.aS(12, this.Fyb);
      if (this.Fyc != null) {
        paramVarArgs.d(13, this.Fyc);
      }
      paramVarArgs.aS(15, this.Fyd);
      AppMethodBeat.o(103201);
      return 0;
    }
    if (paramInt == 1) {
      if (this.url == null) {
        break label686;
      }
    }
    label686:
    for (paramInt = f.a.a.b.b.a.e(1, this.url) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.FxX) + f.a.a.b.b.a.bz(3, this.FxY) + f.a.a.b.b.a.p(4, this.ood) + f.a.a.b.b.a.bz(5, this.width) + f.a.a.b.b.a.bz(6, this.height) + f.a.a.b.b.a.bz(10, this.FxZ) + f.a.a.b.b.a.bz(11, this.Fya) + f.a.a.b.b.a.bz(12, this.Fyb);
      paramInt = i;
      if (this.Fyc != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.Fyc);
      }
      i = f.a.a.b.b.a.bz(15, this.Fyd);
      AppMethodBeat.o(103201);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(103201);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        fu localfu = (fu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 7: 
        case 8: 
        case 9: 
        case 14: 
        default: 
          AppMethodBeat.o(103201);
          return -1;
        case 1: 
          localfu.url = locala.NPN.readString();
          AppMethodBeat.o(103201);
          return 0;
        case 2: 
          localfu.FxX = locala.NPN.zc();
          AppMethodBeat.o(103201);
          return 0;
        case 3: 
          localfu.FxY = locala.NPN.zc();
          AppMethodBeat.o(103201);
          return 0;
        case 4: 
          localfu.ood = locala.NPN.zd();
          AppMethodBeat.o(103201);
          return 0;
        case 5: 
          localfu.width = locala.NPN.zc();
          AppMethodBeat.o(103201);
          return 0;
        case 6: 
          localfu.height = locala.NPN.zc();
          AppMethodBeat.o(103201);
          return 0;
        case 10: 
          localfu.FxZ = locala.NPN.zc();
          AppMethodBeat.o(103201);
          return 0;
        case 11: 
          localfu.Fya = locala.NPN.zc();
          AppMethodBeat.o(103201);
          return 0;
        case 12: 
          localfu.Fyb = locala.NPN.zc();
          AppMethodBeat.o(103201);
          return 0;
        case 13: 
          localfu.Fyc = locala.NPN.readString();
          AppMethodBeat.o(103201);
          return 0;
        }
        localfu.Fyd = locala.NPN.zc();
        AppMethodBeat.o(103201);
        return 0;
      }
      AppMethodBeat.o(103201);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fu
 * JD-Core Version:    0.7.0.1
 */