package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class uo
  extends com.tencent.mm.bw.a
{
  public int DhD;
  public int Gaz;
  public String gTB;
  public String text;
  public int type;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113966);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.type);
      if (this.text != null) {
        paramVarArgs.e(2, this.text);
      }
      if (this.url != null) {
        paramVarArgs.e(3, this.url);
      }
      paramVarArgs.aM(4, this.DhD);
      paramVarArgs.aM(5, this.Gaz);
      if (this.gTB != null) {
        paramVarArgs.e(6, this.gTB);
      }
      AppMethodBeat.o(113966);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.type) + 0;
      paramInt = i;
      if (this.text != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.text);
      }
      i = paramInt;
      if (this.url != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.url);
      }
      i = i + g.a.a.b.b.a.bu(4, this.DhD) + g.a.a.b.b.a.bu(5, this.Gaz);
      paramInt = i;
      if (this.gTB != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.gTB);
      }
      AppMethodBeat.o(113966);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(113966);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      uo localuo = (uo)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(113966);
        return -1;
      case 1: 
        localuo.type = locala.UbS.zi();
        AppMethodBeat.o(113966);
        return 0;
      case 2: 
        localuo.text = locala.UbS.readString();
        AppMethodBeat.o(113966);
        return 0;
      case 3: 
        localuo.url = locala.UbS.readString();
        AppMethodBeat.o(113966);
        return 0;
      case 4: 
        localuo.DhD = locala.UbS.zi();
        AppMethodBeat.o(113966);
        return 0;
      case 5: 
        localuo.Gaz = locala.UbS.zi();
        AppMethodBeat.o(113966);
        return 0;
      }
      localuo.gTB = locala.UbS.readString();
      AppMethodBeat.o(113966);
      return 0;
    }
    AppMethodBeat.o(113966);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.uo
 * JD-Core Version:    0.7.0.1
 */