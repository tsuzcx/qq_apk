package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class bbh
  extends com.tencent.mm.cd.a
{
  public String SNb;
  public int SNc;
  public int SNd;
  public String coverImgUrl;
  public int fod;
  public String fwt;
  public int status;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(198103);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.fod);
      paramVarArgs.aY(2, this.status);
      if (this.coverImgUrl != null) {
        paramVarArgs.f(3, this.coverImgUrl);
      }
      if (this.SNb != null) {
        paramVarArgs.f(4, this.SNb);
      }
      if (this.fwt != null) {
        paramVarArgs.f(5, this.fwt);
      }
      paramVarArgs.aY(6, this.SNc);
      paramVarArgs.aY(7, this.SNd);
      AppMethodBeat.o(198103);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.fod) + 0 + g.a.a.b.b.a.bM(2, this.status);
      paramInt = i;
      if (this.coverImgUrl != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.coverImgUrl);
      }
      i = paramInt;
      if (this.SNb != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.SNb);
      }
      paramInt = i;
      if (this.fwt != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.fwt);
      }
      i = g.a.a.b.b.a.bM(6, this.SNc);
      int j = g.a.a.b.b.a.bM(7, this.SNd);
      AppMethodBeat.o(198103);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(198103);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      bbh localbbh = (bbh)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(198103);
        return -1;
      case 1: 
        localbbh.fod = locala.abFh.AK();
        AppMethodBeat.o(198103);
        return 0;
      case 2: 
        localbbh.status = locala.abFh.AK();
        AppMethodBeat.o(198103);
        return 0;
      case 3: 
        localbbh.coverImgUrl = locala.abFh.readString();
        AppMethodBeat.o(198103);
        return 0;
      case 4: 
        localbbh.SNb = locala.abFh.readString();
        AppMethodBeat.o(198103);
        return 0;
      case 5: 
        localbbh.fwt = locala.abFh.readString();
        AppMethodBeat.o(198103);
        return 0;
      case 6: 
        localbbh.SNc = locala.abFh.AK();
        AppMethodBeat.o(198103);
        return 0;
      }
      localbbh.SNd = locala.abFh.AK();
      AppMethodBeat.o(198103);
      return 0;
    }
    AppMethodBeat.o(198103);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bbh
 * JD-Core Version:    0.7.0.1
 */