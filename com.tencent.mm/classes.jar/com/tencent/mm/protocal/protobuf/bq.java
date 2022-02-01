package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bq
  extends com.tencent.mm.bx.a
{
  public String VQT;
  public int VQU;
  public String VcU;
  public String VcV;
  public String icon;
  public String title;
  public String url;
  public String wording;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91345);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.url != null) {
        paramVarArgs.g(1, this.url);
      }
      if (this.wording != null) {
        paramVarArgs.g(2, this.wording);
      }
      if (this.icon != null) {
        paramVarArgs.g(3, this.icon);
      }
      if (this.VQT != null) {
        paramVarArgs.g(4, this.VQT);
      }
      if (this.title != null) {
        paramVarArgs.g(5, this.title);
      }
      if (this.VcU != null) {
        paramVarArgs.g(6, this.VcU);
      }
      if (this.VcV != null) {
        paramVarArgs.g(7, this.VcV);
      }
      paramVarArgs.bS(8, this.VQU);
      AppMethodBeat.o(91345);
      return 0;
    }
    if (paramInt == 1) {
      if (this.url == null) {
        break label622;
      }
    }
    label622:
    for (int i = i.a.a.b.b.a.h(1, this.url) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wording != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.wording);
      }
      i = paramInt;
      if (this.icon != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.icon);
      }
      paramInt = i;
      if (this.VQT != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.VQT);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.title);
      }
      paramInt = i;
      if (this.VcU != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.VcU);
      }
      i = paramInt;
      if (this.VcV != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.VcV);
      }
      paramInt = i.a.a.b.b.a.cJ(8, this.VQU);
      AppMethodBeat.o(91345);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91345);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        bq localbq = (bq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91345);
          return -1;
        case 1: 
          localbq.url = locala.ajGk.readString();
          AppMethodBeat.o(91345);
          return 0;
        case 2: 
          localbq.wording = locala.ajGk.readString();
          AppMethodBeat.o(91345);
          return 0;
        case 3: 
          localbq.icon = locala.ajGk.readString();
          AppMethodBeat.o(91345);
          return 0;
        case 4: 
          localbq.VQT = locala.ajGk.readString();
          AppMethodBeat.o(91345);
          return 0;
        case 5: 
          localbq.title = locala.ajGk.readString();
          AppMethodBeat.o(91345);
          return 0;
        case 6: 
          localbq.VcU = locala.ajGk.readString();
          AppMethodBeat.o(91345);
          return 0;
        case 7: 
          localbq.VcV = locala.ajGk.readString();
          AppMethodBeat.o(91345);
          return 0;
        }
        localbq.VQU = locala.ajGk.aar();
        AppMethodBeat.o(91345);
        return 0;
      }
      AppMethodBeat.o(91345);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bq
 * JD-Core Version:    0.7.0.1
 */