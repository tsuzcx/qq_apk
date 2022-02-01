package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ddk
  extends com.tencent.mm.bw.a
{
  public String MIA;
  public String MIB;
  public String MIw;
  public String MIx;
  public String MIy;
  public String MIz;
  public String desc;
  public String icon;
  public String title;
  public int type;
  public String value;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209806);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.e(1, this.title);
      }
      if (this.icon != null) {
        paramVarArgs.e(2, this.icon);
      }
      if (this.desc != null) {
        paramVarArgs.e(3, this.desc);
      }
      paramVarArgs.aM(4, this.type);
      if (this.value != null) {
        paramVarArgs.e(5, this.value);
      }
      if (this.MIw != null) {
        paramVarArgs.e(6, this.MIw);
      }
      if (this.MIx != null) {
        paramVarArgs.e(7, this.MIx);
      }
      if (this.MIy != null) {
        paramVarArgs.e(8, this.MIy);
      }
      if (this.MIz != null) {
        paramVarArgs.e(9, this.MIz);
      }
      if (this.MIA != null) {
        paramVarArgs.e(10, this.MIA);
      }
      if (this.MIB != null) {
        paramVarArgs.e(11, this.MIB);
      }
      AppMethodBeat.o(209806);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label810;
      }
    }
    label810:
    for (int i = g.a.a.b.b.a.f(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.icon != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.icon);
      }
      i = paramInt;
      if (this.desc != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.desc);
      }
      i += g.a.a.b.b.a.bu(4, this.type);
      paramInt = i;
      if (this.value != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.value);
      }
      i = paramInt;
      if (this.MIw != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.MIw);
      }
      paramInt = i;
      if (this.MIx != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.MIx);
      }
      i = paramInt;
      if (this.MIy != null) {
        i = paramInt + g.a.a.b.b.a.f(8, this.MIy);
      }
      paramInt = i;
      if (this.MIz != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.MIz);
      }
      i = paramInt;
      if (this.MIA != null) {
        i = paramInt + g.a.a.b.b.a.f(10, this.MIA);
      }
      paramInt = i;
      if (this.MIB != null) {
        paramInt = i + g.a.a.b.b.a.f(11, this.MIB);
      }
      AppMethodBeat.o(209806);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209806);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ddk localddk = (ddk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(209806);
          return -1;
        case 1: 
          localddk.title = locala.UbS.readString();
          AppMethodBeat.o(209806);
          return 0;
        case 2: 
          localddk.icon = locala.UbS.readString();
          AppMethodBeat.o(209806);
          return 0;
        case 3: 
          localddk.desc = locala.UbS.readString();
          AppMethodBeat.o(209806);
          return 0;
        case 4: 
          localddk.type = locala.UbS.zi();
          AppMethodBeat.o(209806);
          return 0;
        case 5: 
          localddk.value = locala.UbS.readString();
          AppMethodBeat.o(209806);
          return 0;
        case 6: 
          localddk.MIw = locala.UbS.readString();
          AppMethodBeat.o(209806);
          return 0;
        case 7: 
          localddk.MIx = locala.UbS.readString();
          AppMethodBeat.o(209806);
          return 0;
        case 8: 
          localddk.MIy = locala.UbS.readString();
          AppMethodBeat.o(209806);
          return 0;
        case 9: 
          localddk.MIz = locala.UbS.readString();
          AppMethodBeat.o(209806);
          return 0;
        case 10: 
          localddk.MIA = locala.UbS.readString();
          AppMethodBeat.o(209806);
          return 0;
        }
        localddk.MIB = locala.UbS.readString();
        AppMethodBeat.o(209806);
        return 0;
      }
      AppMethodBeat.o(209806);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ddk
 * JD-Core Version:    0.7.0.1
 */