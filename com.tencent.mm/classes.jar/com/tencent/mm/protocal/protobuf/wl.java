package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class wl
  extends com.tencent.mm.bx.a
{
  public float TG;
  public String Zdw;
  public String Zdx;
  public String city;
  public String country;
  public String descriptor;
  public String jump_url;
  public float latitude;
  public float longitude;
  public String name;
  public String oDI;
  public String province;
  public String wsM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113969);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.name != null) {
        paramVarArgs.g(1, this.name);
      }
      if (this.descriptor != null) {
        paramVarArgs.g(2, this.descriptor);
      }
      if (this.wsM != null) {
        paramVarArgs.g(3, this.wsM);
      }
      if (this.country != null) {
        paramVarArgs.g(4, this.country);
      }
      if (this.province != null) {
        paramVarArgs.g(5, this.province);
      }
      if (this.city != null) {
        paramVarArgs.g(6, this.city);
      }
      if (this.oDI != null) {
        paramVarArgs.g(7, this.oDI);
      }
      paramVarArgs.l(8, this.TG);
      paramVarArgs.l(9, this.longitude);
      paramVarArgs.l(10, this.latitude);
      if (this.jump_url != null) {
        paramVarArgs.g(11, this.jump_url);
      }
      if (this.Zdw != null) {
        paramVarArgs.g(12, this.Zdw);
      }
      if (this.Zdx != null) {
        paramVarArgs.g(13, this.Zdx);
      }
      AppMethodBeat.o(113969);
      return 0;
    }
    if (paramInt == 1) {
      if (this.name == null) {
        break label899;
      }
    }
    label899:
    for (int i = i.a.a.b.b.a.h(1, this.name) + 0;; i = 0)
    {
      paramInt = i;
      if (this.descriptor != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.descriptor);
      }
      i = paramInt;
      if (this.wsM != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.wsM);
      }
      paramInt = i;
      if (this.country != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.country);
      }
      i = paramInt;
      if (this.province != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.province);
      }
      paramInt = i;
      if (this.city != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.city);
      }
      i = paramInt;
      if (this.oDI != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.oDI);
      }
      i = i + (i.a.a.b.b.a.ko(8) + 4) + (i.a.a.b.b.a.ko(9) + 4) + (i.a.a.b.b.a.ko(10) + 4);
      paramInt = i;
      if (this.jump_url != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.jump_url);
      }
      i = paramInt;
      if (this.Zdw != null) {
        i = paramInt + i.a.a.b.b.a.h(12, this.Zdw);
      }
      paramInt = i;
      if (this.Zdx != null) {
        paramInt = i + i.a.a.b.b.a.h(13, this.Zdx);
      }
      AppMethodBeat.o(113969);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(113969);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        wl localwl = (wl)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(113969);
          return -1;
        case 1: 
          localwl.name = locala.ajGk.readString();
          AppMethodBeat.o(113969);
          return 0;
        case 2: 
          localwl.descriptor = locala.ajGk.readString();
          AppMethodBeat.o(113969);
          return 0;
        case 3: 
          localwl.wsM = locala.ajGk.readString();
          AppMethodBeat.o(113969);
          return 0;
        case 4: 
          localwl.country = locala.ajGk.readString();
          AppMethodBeat.o(113969);
          return 0;
        case 5: 
          localwl.province = locala.ajGk.readString();
          AppMethodBeat.o(113969);
          return 0;
        case 6: 
          localwl.city = locala.ajGk.readString();
          AppMethodBeat.o(113969);
          return 0;
        case 7: 
          localwl.oDI = locala.ajGk.readString();
          AppMethodBeat.o(113969);
          return 0;
        case 8: 
          localwl.TG = Float.intBitsToFloat(locala.ajGk.aax());
          AppMethodBeat.o(113969);
          return 0;
        case 9: 
          localwl.longitude = Float.intBitsToFloat(locala.ajGk.aax());
          AppMethodBeat.o(113969);
          return 0;
        case 10: 
          localwl.latitude = Float.intBitsToFloat(locala.ajGk.aax());
          AppMethodBeat.o(113969);
          return 0;
        case 11: 
          localwl.jump_url = locala.ajGk.readString();
          AppMethodBeat.o(113969);
          return 0;
        case 12: 
          localwl.Zdw = locala.ajGk.readString();
          AppMethodBeat.o(113969);
          return 0;
        }
        localwl.Zdx = locala.ajGk.readString();
        AppMethodBeat.o(113969);
        return 0;
      }
      AppMethodBeat.o(113969);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.wl
 * JD-Core Version:    0.7.0.1
 */