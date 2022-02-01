package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dcm
  extends com.tencent.mm.bw.a
{
  public String FMf;
  public boolean FMg;
  public boolean FMh;
  public String appName;
  public int bRK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116816);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FMf != null) {
        paramVarArgs.d(1, this.FMf);
      }
      if (this.appName != null) {
        paramVarArgs.d(2, this.appName);
      }
      paramVarArgs.aR(3, this.bRK);
      paramVarArgs.bl(4, this.FMg);
      paramVarArgs.bl(5, this.FMh);
      AppMethodBeat.o(116816);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FMf == null) {
        break label406;
      }
    }
    label406:
    for (paramInt = f.a.a.b.b.a.e(1, this.FMf) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.appName != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.appName);
      }
      paramInt = f.a.a.b.b.a.bx(3, this.bRK);
      int j = f.a.a.b.b.a.fK(4);
      int k = f.a.a.b.b.a.fK(5);
      AppMethodBeat.o(116816);
      return i + paramInt + (j + 1) + (k + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(116816);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dcm localdcm = (dcm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(116816);
          return -1;
        case 1: 
          localdcm.FMf = locala.LVo.readString();
          AppMethodBeat.o(116816);
          return 0;
        case 2: 
          localdcm.appName = locala.LVo.readString();
          AppMethodBeat.o(116816);
          return 0;
        case 3: 
          localdcm.bRK = locala.LVo.xF();
          AppMethodBeat.o(116816);
          return 0;
        case 4: 
          localdcm.FMg = locala.LVo.fZX();
          AppMethodBeat.o(116816);
          return 0;
        }
        localdcm.FMh = locala.LVo.fZX();
        AppMethodBeat.o(116816);
        return 0;
      }
      AppMethodBeat.o(116816);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dcm
 * JD-Core Version:    0.7.0.1
 */