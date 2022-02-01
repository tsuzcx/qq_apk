package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ahc
  extends com.tencent.mm.bw.a
{
  public String LqM;
  public String deviceBrand;
  public String deviceModel;
  public String osName;
  public String osVersion;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32189);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.deviceModel != null) {
        paramVarArgs.e(1, this.deviceModel);
      }
      if (this.deviceBrand != null) {
        paramVarArgs.e(2, this.deviceBrand);
      }
      if (this.osName != null) {
        paramVarArgs.e(3, this.osName);
      }
      if (this.osVersion != null) {
        paramVarArgs.e(4, this.osVersion);
      }
      if (this.LqM != null) {
        paramVarArgs.e(5, this.LqM);
      }
      AppMethodBeat.o(32189);
      return 0;
    }
    if (paramInt == 1) {
      if (this.deviceModel == null) {
        break label465;
      }
    }
    label465:
    for (int i = g.a.a.b.b.a.f(1, this.deviceModel) + 0;; i = 0)
    {
      paramInt = i;
      if (this.deviceBrand != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.deviceBrand);
      }
      i = paramInt;
      if (this.osName != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.osName);
      }
      paramInt = i;
      if (this.osVersion != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.osVersion);
      }
      i = paramInt;
      if (this.LqM != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.LqM);
      }
      AppMethodBeat.o(32189);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(32189);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ahc localahc = (ahc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32189);
          return -1;
        case 1: 
          localahc.deviceModel = locala.UbS.readString();
          AppMethodBeat.o(32189);
          return 0;
        case 2: 
          localahc.deviceBrand = locala.UbS.readString();
          AppMethodBeat.o(32189);
          return 0;
        case 3: 
          localahc.osName = locala.UbS.readString();
          AppMethodBeat.o(32189);
          return 0;
        case 4: 
          localahc.osVersion = locala.UbS.readString();
          AppMethodBeat.o(32189);
          return 0;
        }
        localahc.LqM = locala.UbS.readString();
        AppMethodBeat.o(32189);
        return 0;
      }
      AppMethodBeat.o(32189);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ahc
 * JD-Core Version:    0.7.0.1
 */