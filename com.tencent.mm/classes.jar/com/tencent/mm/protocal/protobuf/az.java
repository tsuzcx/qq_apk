package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class az
  extends com.tencent.mm.bx.a
{
  public long Cve;
  public String Cvf;
  public String Cvg;
  public String Cvh;
  public String Cvi;
  public String Cvj;
  public String evA;
  public String evz;
  public double latitude;
  public double longitude;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91341);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.evz != null) {
        paramVarArgs.d(1, this.evz);
      }
      if (this.evA != null) {
        paramVarArgs.d(2, this.evA);
      }
      paramVarArgs.e(3, this.latitude);
      paramVarArgs.e(4, this.longitude);
      paramVarArgs.aG(5, this.Cve);
      if (this.Cvf != null) {
        paramVarArgs.d(6, this.Cvf);
      }
      if (this.Cvg != null) {
        paramVarArgs.d(7, this.Cvg);
      }
      if (this.Cvh != null) {
        paramVarArgs.d(8, this.Cvh);
      }
      if (this.Cvi != null) {
        paramVarArgs.d(9, this.Cvi);
      }
      if (this.Cvj != null) {
        paramVarArgs.d(10, this.Cvj);
      }
      AppMethodBeat.o(91341);
      return 0;
    }
    if (paramInt == 1) {
      if (this.evz == null) {
        break label716;
      }
    }
    label716:
    for (paramInt = f.a.a.b.b.a.e(1, this.evz) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.evA != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.evA);
      }
      i = i + (f.a.a.b.b.a.fY(3) + 8) + (f.a.a.b.b.a.fY(4) + 8) + f.a.a.b.b.a.q(5, this.Cve);
      paramInt = i;
      if (this.Cvf != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Cvf);
      }
      i = paramInt;
      if (this.Cvg != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.Cvg);
      }
      paramInt = i;
      if (this.Cvh != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.Cvh);
      }
      i = paramInt;
      if (this.Cvi != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.Cvi);
      }
      paramInt = i;
      if (this.Cvj != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.Cvj);
      }
      AppMethodBeat.o(91341);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(91341);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        az localaz = (az)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91341);
          return -1;
        case 1: 
          localaz.evz = locala.KhF.readString();
          AppMethodBeat.o(91341);
          return 0;
        case 2: 
          localaz.evA = locala.KhF.readString();
          AppMethodBeat.o(91341);
          return 0;
        case 3: 
          localaz.latitude = Double.longBitsToDouble(locala.KhF.fHy());
          AppMethodBeat.o(91341);
          return 0;
        case 4: 
          localaz.longitude = Double.longBitsToDouble(locala.KhF.fHy());
          AppMethodBeat.o(91341);
          return 0;
        case 5: 
          localaz.Cve = locala.KhF.xT();
          AppMethodBeat.o(91341);
          return 0;
        case 6: 
          localaz.Cvf = locala.KhF.readString();
          AppMethodBeat.o(91341);
          return 0;
        case 7: 
          localaz.Cvg = locala.KhF.readString();
          AppMethodBeat.o(91341);
          return 0;
        case 8: 
          localaz.Cvh = locala.KhF.readString();
          AppMethodBeat.o(91341);
          return 0;
        case 9: 
          localaz.Cvi = locala.KhF.readString();
          AppMethodBeat.o(91341);
          return 0;
        }
        localaz.Cvj = locala.KhF.readString();
        AppMethodBeat.o(91341);
        return 0;
      }
      AppMethodBeat.o(91341);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.az
 * JD-Core Version:    0.7.0.1
 */