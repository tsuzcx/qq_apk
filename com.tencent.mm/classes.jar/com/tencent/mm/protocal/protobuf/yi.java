package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class yi
  extends com.tencent.mm.bv.a
{
  public String deviceBrand;
  public String deviceModel;
  public String osName;
  public String osVersion;
  public String wPv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28385);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
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
      if (this.wPv != null) {
        paramVarArgs.e(5, this.wPv);
      }
      AppMethodBeat.o(28385);
      return 0;
    }
    if (paramInt == 1) {
      if (this.deviceModel == null) {
        break label465;
      }
    }
    label465:
    for (int i = e.a.a.b.b.a.f(1, this.deviceModel) + 0;; i = 0)
    {
      paramInt = i;
      if (this.deviceBrand != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.deviceBrand);
      }
      i = paramInt;
      if (this.osName != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.osName);
      }
      paramInt = i;
      if (this.osVersion != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.osVersion);
      }
      i = paramInt;
      if (this.wPv != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.wPv);
      }
      AppMethodBeat.o(28385);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(28385);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        yi localyi = (yi)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(28385);
          return -1;
        case 1: 
          localyi.deviceModel = locala.CLY.readString();
          AppMethodBeat.o(28385);
          return 0;
        case 2: 
          localyi.deviceBrand = locala.CLY.readString();
          AppMethodBeat.o(28385);
          return 0;
        case 3: 
          localyi.osName = locala.CLY.readString();
          AppMethodBeat.o(28385);
          return 0;
        case 4: 
          localyi.osVersion = locala.CLY.readString();
          AppMethodBeat.o(28385);
          return 0;
        }
        localyi.wPv = locala.CLY.readString();
        AppMethodBeat.o(28385);
        return 0;
      }
      AppMethodBeat.o(28385);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.yi
 * JD-Core Version:    0.7.0.1
 */