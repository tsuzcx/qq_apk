package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cli
  extends com.tencent.mm.bw.a
{
  public String coverUrl;
  public String desc;
  public int duration;
  public int iAb = -1;
  public int iwd;
  public int iwe = 0;
  public int iwf;
  public int iwg;
  public String vid;
  public int videoHeight;
  public int videoWidth;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125740);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.iAb);
      paramVarArgs.aM(2, this.iwe);
      if (this.desc != null) {
        paramVarArgs.e(3, this.desc);
      }
      paramVarArgs.aM(4, this.videoWidth);
      paramVarArgs.aM(5, this.videoHeight);
      paramVarArgs.aM(6, this.iwd);
      paramVarArgs.aM(7, this.duration);
      if (this.vid != null) {
        paramVarArgs.e(8, this.vid);
      }
      paramVarArgs.aM(9, this.iwg);
      if (this.coverUrl != null) {
        paramVarArgs.e(10, this.coverUrl);
      }
      paramVarArgs.aM(11, this.iwf);
      AppMethodBeat.o(125740);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.iAb) + 0 + g.a.a.b.b.a.bu(2, this.iwe);
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.desc);
      }
      i = paramInt + g.a.a.b.b.a.bu(4, this.videoWidth) + g.a.a.b.b.a.bu(5, this.videoHeight) + g.a.a.b.b.a.bu(6, this.iwd) + g.a.a.b.b.a.bu(7, this.duration);
      paramInt = i;
      if (this.vid != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.vid);
      }
      i = paramInt + g.a.a.b.b.a.bu(9, this.iwg);
      paramInt = i;
      if (this.coverUrl != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.coverUrl);
      }
      i = g.a.a.b.b.a.bu(11, this.iwf);
      AppMethodBeat.o(125740);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(125740);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      cli localcli = (cli)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125740);
        return -1;
      case 1: 
        localcli.iAb = locala.UbS.zi();
        AppMethodBeat.o(125740);
        return 0;
      case 2: 
        localcli.iwe = locala.UbS.zi();
        AppMethodBeat.o(125740);
        return 0;
      case 3: 
        localcli.desc = locala.UbS.readString();
        AppMethodBeat.o(125740);
        return 0;
      case 4: 
        localcli.videoWidth = locala.UbS.zi();
        AppMethodBeat.o(125740);
        return 0;
      case 5: 
        localcli.videoHeight = locala.UbS.zi();
        AppMethodBeat.o(125740);
        return 0;
      case 6: 
        localcli.iwd = locala.UbS.zi();
        AppMethodBeat.o(125740);
        return 0;
      case 7: 
        localcli.duration = locala.UbS.zi();
        AppMethodBeat.o(125740);
        return 0;
      case 8: 
        localcli.vid = locala.UbS.readString();
        AppMethodBeat.o(125740);
        return 0;
      case 9: 
        localcli.iwg = locala.UbS.zi();
        AppMethodBeat.o(125740);
        return 0;
      case 10: 
        localcli.coverUrl = locala.UbS.readString();
        AppMethodBeat.o(125740);
        return 0;
      }
      localcli.iwf = locala.UbS.zi();
      AppMethodBeat.o(125740);
      return 0;
    }
    AppMethodBeat.o(125740);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cli
 * JD-Core Version:    0.7.0.1
 */