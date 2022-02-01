package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class bfg
  extends com.tencent.mm.cd.a
{
  public String BHW;
  public String SPU;
  public String SPV;
  public String albumName;
  public String artist;
  public String name;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(203681);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BHW != null) {
        paramVarArgs.f(1, this.BHW);
      }
      if (this.SPU != null) {
        paramVarArgs.f(2, this.SPU);
      }
      if (this.name != null) {
        paramVarArgs.f(3, this.name);
      }
      if (this.artist != null) {
        paramVarArgs.f(4, this.artist);
      }
      if (this.albumName != null) {
        paramVarArgs.f(5, this.albumName);
      }
      if (this.SPV != null) {
        paramVarArgs.f(6, this.SPV);
      }
      AppMethodBeat.o(203681);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BHW == null) {
        break label518;
      }
    }
    label518:
    for (int i = g.a.a.b.b.a.g(1, this.BHW) + 0;; i = 0)
    {
      paramInt = i;
      if (this.SPU != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.SPU);
      }
      i = paramInt;
      if (this.name != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.name);
      }
      paramInt = i;
      if (this.artist != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.artist);
      }
      i = paramInt;
      if (this.albumName != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.albumName);
      }
      paramInt = i;
      if (this.SPV != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.SPV);
      }
      AppMethodBeat.o(203681);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(203681);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        bfg localbfg = (bfg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(203681);
          return -1;
        case 1: 
          localbfg.BHW = locala.abFh.readString();
          AppMethodBeat.o(203681);
          return 0;
        case 2: 
          localbfg.SPU = locala.abFh.readString();
          AppMethodBeat.o(203681);
          return 0;
        case 3: 
          localbfg.name = locala.abFh.readString();
          AppMethodBeat.o(203681);
          return 0;
        case 4: 
          localbfg.artist = locala.abFh.readString();
          AppMethodBeat.o(203681);
          return 0;
        case 5: 
          localbfg.albumName = locala.abFh.readString();
          AppMethodBeat.o(203681);
          return 0;
        }
        localbfg.SPV = locala.abFh.readString();
        AppMethodBeat.o(203681);
        return 0;
      }
      AppMethodBeat.o(203681);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bfg
 * JD-Core Version:    0.7.0.1
 */