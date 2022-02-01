package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dsu
  extends com.tencent.mm.bw.a
{
  public String Desc;
  public String MUV;
  public String ThumbUrl;
  public String Title;
  public String UserName;
  public int Version;
  public String hik;
  public String xut;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(187885);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Title != null) {
        paramVarArgs.e(1, this.Title);
      }
      if (this.Desc != null) {
        paramVarArgs.e(2, this.Desc);
      }
      if (this.ThumbUrl != null) {
        paramVarArgs.e(3, this.ThumbUrl);
      }
      if (this.hik != null) {
        paramVarArgs.e(4, this.hik);
      }
      if (this.UserName != null) {
        paramVarArgs.e(5, this.UserName);
      }
      if (this.xut != null) {
        paramVarArgs.e(6, this.xut);
      }
      if (this.MUV != null) {
        paramVarArgs.e(7, this.MUV);
      }
      paramVarArgs.aM(8, this.Version);
      AppMethodBeat.o(187885);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label626;
      }
    }
    label626:
    for (int i = g.a.a.b.b.a.f(1, this.Title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Desc != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Desc);
      }
      i = paramInt;
      if (this.ThumbUrl != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.ThumbUrl);
      }
      paramInt = i;
      if (this.hik != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.hik);
      }
      i = paramInt;
      if (this.UserName != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.UserName);
      }
      paramInt = i;
      if (this.xut != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.xut);
      }
      i = paramInt;
      if (this.MUV != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.MUV);
      }
      paramInt = g.a.a.b.b.a.bu(8, this.Version);
      AppMethodBeat.o(187885);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(187885);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dsu localdsu = (dsu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(187885);
          return -1;
        case 1: 
          localdsu.Title = locala.UbS.readString();
          AppMethodBeat.o(187885);
          return 0;
        case 2: 
          localdsu.Desc = locala.UbS.readString();
          AppMethodBeat.o(187885);
          return 0;
        case 3: 
          localdsu.ThumbUrl = locala.UbS.readString();
          AppMethodBeat.o(187885);
          return 0;
        case 4: 
          localdsu.hik = locala.UbS.readString();
          AppMethodBeat.o(187885);
          return 0;
        case 5: 
          localdsu.UserName = locala.UbS.readString();
          AppMethodBeat.o(187885);
          return 0;
        case 6: 
          localdsu.xut = locala.UbS.readString();
          AppMethodBeat.o(187885);
          return 0;
        case 7: 
          localdsu.MUV = locala.UbS.readString();
          AppMethodBeat.o(187885);
          return 0;
        }
        localdsu.Version = locala.UbS.zi();
        AppMethodBeat.o(187885);
        return 0;
      }
      AppMethodBeat.o(187885);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dsu
 * JD-Core Version:    0.7.0.1
 */