package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class uu
  extends com.tencent.mm.cd.a
{
  public float KjR;
  public String SfB;
  public String SfC;
  public String city;
  public String country;
  public String descriptor;
  public String jump_url;
  public String lLg;
  public float latitude;
  public float longitude;
  public String name;
  public String province;
  public String tol;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113969);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.name != null) {
        paramVarArgs.f(1, this.name);
      }
      if (this.descriptor != null) {
        paramVarArgs.f(2, this.descriptor);
      }
      if (this.tol != null) {
        paramVarArgs.f(3, this.tol);
      }
      if (this.country != null) {
        paramVarArgs.f(4, this.country);
      }
      if (this.province != null) {
        paramVarArgs.f(5, this.province);
      }
      if (this.city != null) {
        paramVarArgs.f(6, this.city);
      }
      if (this.lLg != null) {
        paramVarArgs.f(7, this.lLg);
      }
      paramVarArgs.i(8, this.KjR);
      paramVarArgs.i(9, this.longitude);
      paramVarArgs.i(10, this.latitude);
      if (this.jump_url != null) {
        paramVarArgs.f(11, this.jump_url);
      }
      if (this.SfB != null) {
        paramVarArgs.f(12, this.SfB);
      }
      if (this.SfC != null) {
        paramVarArgs.f(13, this.SfC);
      }
      AppMethodBeat.o(113969);
      return 0;
    }
    if (paramInt == 1) {
      if (this.name == null) {
        break label903;
      }
    }
    label903:
    for (int i = g.a.a.b.b.a.g(1, this.name) + 0;; i = 0)
    {
      paramInt = i;
      if (this.descriptor != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.descriptor);
      }
      i = paramInt;
      if (this.tol != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.tol);
      }
      paramInt = i;
      if (this.country != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.country);
      }
      i = paramInt;
      if (this.province != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.province);
      }
      paramInt = i;
      if (this.city != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.city);
      }
      i = paramInt;
      if (this.lLg != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.lLg);
      }
      i = i + (g.a.a.b.b.a.gL(8) + 4) + (g.a.a.b.b.a.gL(9) + 4) + (g.a.a.b.b.a.gL(10) + 4);
      paramInt = i;
      if (this.jump_url != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.jump_url);
      }
      i = paramInt;
      if (this.SfB != null) {
        i = paramInt + g.a.a.b.b.a.g(12, this.SfB);
      }
      paramInt = i;
      if (this.SfC != null) {
        paramInt = i + g.a.a.b.b.a.g(13, this.SfC);
      }
      AppMethodBeat.o(113969);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(113969);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        uu localuu = (uu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(113969);
          return -1;
        case 1: 
          localuu.name = locala.abFh.readString();
          AppMethodBeat.o(113969);
          return 0;
        case 2: 
          localuu.descriptor = locala.abFh.readString();
          AppMethodBeat.o(113969);
          return 0;
        case 3: 
          localuu.tol = locala.abFh.readString();
          AppMethodBeat.o(113969);
          return 0;
        case 4: 
          localuu.country = locala.abFh.readString();
          AppMethodBeat.o(113969);
          return 0;
        case 5: 
          localuu.province = locala.abFh.readString();
          AppMethodBeat.o(113969);
          return 0;
        case 6: 
          localuu.city = locala.abFh.readString();
          AppMethodBeat.o(113969);
          return 0;
        case 7: 
          localuu.lLg = locala.abFh.readString();
          AppMethodBeat.o(113969);
          return 0;
        case 8: 
          localuu.KjR = Float.intBitsToFloat(locala.abFh.AO());
          AppMethodBeat.o(113969);
          return 0;
        case 9: 
          localuu.longitude = Float.intBitsToFloat(locala.abFh.AO());
          AppMethodBeat.o(113969);
          return 0;
        case 10: 
          localuu.latitude = Float.intBitsToFloat(locala.abFh.AO());
          AppMethodBeat.o(113969);
          return 0;
        case 11: 
          localuu.jump_url = locala.abFh.readString();
          AppMethodBeat.o(113969);
          return 0;
        case 12: 
          localuu.SfB = locala.abFh.readString();
          AppMethodBeat.o(113969);
          return 0;
        }
        localuu.SfC = locala.abFh.readString();
        AppMethodBeat.o(113969);
        return 0;
      }
      AppMethodBeat.o(113969);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.uu
 * JD-Core Version:    0.7.0.1
 */