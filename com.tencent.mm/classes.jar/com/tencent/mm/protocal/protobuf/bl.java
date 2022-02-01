package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bl
  extends com.tencent.mm.bw.a
{
  public String Hwr;
  public String Hws;
  public String IhY;
  public int IhZ;
  public String dQx;
  public String icon;
  public String title;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91345);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.url != null) {
        paramVarArgs.e(1, this.url);
      }
      if (this.dQx != null) {
        paramVarArgs.e(2, this.dQx);
      }
      if (this.icon != null) {
        paramVarArgs.e(3, this.icon);
      }
      if (this.IhY != null) {
        paramVarArgs.e(4, this.IhY);
      }
      if (this.title != null) {
        paramVarArgs.e(5, this.title);
      }
      if (this.Hwr != null) {
        paramVarArgs.e(6, this.Hwr);
      }
      if (this.Hws != null) {
        paramVarArgs.e(7, this.Hws);
      }
      paramVarArgs.aM(8, this.IhZ);
      AppMethodBeat.o(91345);
      return 0;
    }
    if (paramInt == 1) {
      if (this.url == null) {
        break label626;
      }
    }
    label626:
    for (int i = g.a.a.b.b.a.f(1, this.url) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dQx != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.dQx);
      }
      i = paramInt;
      if (this.icon != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.icon);
      }
      paramInt = i;
      if (this.IhY != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.IhY);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.title);
      }
      paramInt = i;
      if (this.Hwr != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.Hwr);
      }
      i = paramInt;
      if (this.Hws != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.Hws);
      }
      paramInt = g.a.a.b.b.a.bu(8, this.IhZ);
      AppMethodBeat.o(91345);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91345);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        bl localbl = (bl)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91345);
          return -1;
        case 1: 
          localbl.url = locala.UbS.readString();
          AppMethodBeat.o(91345);
          return 0;
        case 2: 
          localbl.dQx = locala.UbS.readString();
          AppMethodBeat.o(91345);
          return 0;
        case 3: 
          localbl.icon = locala.UbS.readString();
          AppMethodBeat.o(91345);
          return 0;
        case 4: 
          localbl.IhY = locala.UbS.readString();
          AppMethodBeat.o(91345);
          return 0;
        case 5: 
          localbl.title = locala.UbS.readString();
          AppMethodBeat.o(91345);
          return 0;
        case 6: 
          localbl.Hwr = locala.UbS.readString();
          AppMethodBeat.o(91345);
          return 0;
        case 7: 
          localbl.Hws = locala.UbS.readString();
          AppMethodBeat.o(91345);
          return 0;
        }
        localbl.IhZ = locala.UbS.zi();
        AppMethodBeat.o(91345);
        return 0;
      }
      AppMethodBeat.o(91345);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bl
 * JD-Core Version:    0.7.0.1
 */