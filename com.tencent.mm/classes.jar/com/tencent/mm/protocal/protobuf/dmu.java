package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dmu
  extends com.tencent.mm.cd.a
{
  public String ODt;
  public String Ooe;
  public String Oof;
  public String Oxw;
  public String TTV;
  public int type;
  public String wording;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91620);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.wording != null) {
        paramVarArgs.f(1, this.wording);
      }
      paramVarArgs.aY(2, this.type);
      if (this.ODt != null) {
        paramVarArgs.f(3, this.ODt);
      }
      if (this.Ooe != null) {
        paramVarArgs.f(4, this.Ooe);
      }
      if (this.Oof != null) {
        paramVarArgs.f(5, this.Oof);
      }
      if (this.TTV != null) {
        paramVarArgs.f(6, this.TTV);
      }
      if (this.Oxw != null) {
        paramVarArgs.f(7, this.Oxw);
      }
      AppMethodBeat.o(91620);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wording == null) {
        break label562;
      }
    }
    label562:
    for (paramInt = g.a.a.b.b.a.g(1, this.wording) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.type);
      paramInt = i;
      if (this.ODt != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.ODt);
      }
      i = paramInt;
      if (this.Ooe != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.Ooe);
      }
      paramInt = i;
      if (this.Oof != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.Oof);
      }
      i = paramInt;
      if (this.TTV != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.TTV);
      }
      paramInt = i;
      if (this.Oxw != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.Oxw);
      }
      AppMethodBeat.o(91620);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91620);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dmu localdmu = (dmu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91620);
          return -1;
        case 1: 
          localdmu.wording = locala.abFh.readString();
          AppMethodBeat.o(91620);
          return 0;
        case 2: 
          localdmu.type = locala.abFh.AK();
          AppMethodBeat.o(91620);
          return 0;
        case 3: 
          localdmu.ODt = locala.abFh.readString();
          AppMethodBeat.o(91620);
          return 0;
        case 4: 
          localdmu.Ooe = locala.abFh.readString();
          AppMethodBeat.o(91620);
          return 0;
        case 5: 
          localdmu.Oof = locala.abFh.readString();
          AppMethodBeat.o(91620);
          return 0;
        case 6: 
          localdmu.TTV = locala.abFh.readString();
          AppMethodBeat.o(91620);
          return 0;
        }
        localdmu.Oxw = locala.abFh.readString();
        AppMethodBeat.o(91620);
        return 0;
      }
      AppMethodBeat.o(91620);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dmu
 * JD-Core Version:    0.7.0.1
 */