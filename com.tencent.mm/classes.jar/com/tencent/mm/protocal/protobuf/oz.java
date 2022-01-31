package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class oz
  extends com.tencent.mm.bv.a
{
  public float cAH;
  public String city;
  public String country;
  public float cyV;
  public String descriptor;
  public String fBq;
  public String kmA;
  public String knV;
  public String name;
  public String province;
  public float rqZ;
  public String wFL;
  public String wFM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(89039);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.name != null) {
        paramVarArgs.e(1, this.name);
      }
      if (this.descriptor != null) {
        paramVarArgs.e(2, this.descriptor);
      }
      if (this.kmA != null) {
        paramVarArgs.e(3, this.kmA);
      }
      if (this.country != null) {
        paramVarArgs.e(4, this.country);
      }
      if (this.province != null) {
        paramVarArgs.e(5, this.province);
      }
      if (this.city != null) {
        paramVarArgs.e(6, this.city);
      }
      if (this.fBq != null) {
        paramVarArgs.e(7, this.fBq);
      }
      paramVarArgs.q(8, this.rqZ);
      paramVarArgs.q(9, this.cAH);
      paramVarArgs.q(10, this.cyV);
      if (this.knV != null) {
        paramVarArgs.e(11, this.knV);
      }
      if (this.wFL != null) {
        paramVarArgs.e(12, this.wFL);
      }
      if (this.wFM != null) {
        paramVarArgs.e(13, this.wFM);
      }
      AppMethodBeat.o(89039);
      return 0;
    }
    if (paramInt == 1) {
      if (this.name == null) {
        break label903;
      }
    }
    label903:
    for (int i = e.a.a.b.b.a.f(1, this.name) + 0;; i = 0)
    {
      paramInt = i;
      if (this.descriptor != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.descriptor);
      }
      i = paramInt;
      if (this.kmA != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.kmA);
      }
      paramInt = i;
      if (this.country != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.country);
      }
      i = paramInt;
      if (this.province != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.province);
      }
      paramInt = i;
      if (this.city != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.city);
      }
      i = paramInt;
      if (this.fBq != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.fBq);
      }
      i = i + (e.a.a.b.b.a.eW(8) + 4) + (e.a.a.b.b.a.eW(9) + 4) + (e.a.a.b.b.a.eW(10) + 4);
      paramInt = i;
      if (this.knV != null) {
        paramInt = i + e.a.a.b.b.a.f(11, this.knV);
      }
      i = paramInt;
      if (this.wFL != null) {
        i = paramInt + e.a.a.b.b.a.f(12, this.wFL);
      }
      paramInt = i;
      if (this.wFM != null) {
        paramInt = i + e.a.a.b.b.a.f(13, this.wFM);
      }
      AppMethodBeat.o(89039);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(89039);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        oz localoz = (oz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(89039);
          return -1;
        case 1: 
          localoz.name = locala.CLY.readString();
          AppMethodBeat.o(89039);
          return 0;
        case 2: 
          localoz.descriptor = locala.CLY.readString();
          AppMethodBeat.o(89039);
          return 0;
        case 3: 
          localoz.kmA = locala.CLY.readString();
          AppMethodBeat.o(89039);
          return 0;
        case 4: 
          localoz.country = locala.CLY.readString();
          AppMethodBeat.o(89039);
          return 0;
        case 5: 
          localoz.province = locala.CLY.readString();
          AppMethodBeat.o(89039);
          return 0;
        case 6: 
          localoz.city = locala.CLY.readString();
          AppMethodBeat.o(89039);
          return 0;
        case 7: 
          localoz.fBq = locala.CLY.readString();
          AppMethodBeat.o(89039);
          return 0;
        case 8: 
          localoz.rqZ = Float.intBitsToFloat(locala.CLY.emx());
          AppMethodBeat.o(89039);
          return 0;
        case 9: 
          localoz.cAH = Float.intBitsToFloat(locala.CLY.emx());
          AppMethodBeat.o(89039);
          return 0;
        case 10: 
          localoz.cyV = Float.intBitsToFloat(locala.CLY.emx());
          AppMethodBeat.o(89039);
          return 0;
        case 11: 
          localoz.knV = locala.CLY.readString();
          AppMethodBeat.o(89039);
          return 0;
        case 12: 
          localoz.wFL = locala.CLY.readString();
          AppMethodBeat.o(89039);
          return 0;
        }
        localoz.wFM = locala.CLY.readString();
        AppMethodBeat.o(89039);
        return 0;
      }
      AppMethodBeat.o(89039);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.oz
 * JD-Core Version:    0.7.0.1
 */