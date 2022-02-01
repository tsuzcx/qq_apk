package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class edi
  extends com.tencent.mm.bw.a
{
  public String HkY;
  public String Hvr;
  public String Iio;
  public String Iip;
  public String Iiq;
  public String Iir;
  public String Iis;
  public int Scene;
  public int jeO;
  public String wTy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(121110);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Iio != null) {
        paramVarArgs.d(1, this.Iio);
      }
      if (this.Iip != null) {
        paramVarArgs.d(2, this.Iip);
      }
      if (this.HkY != null) {
        paramVarArgs.d(3, this.HkY);
      }
      if (this.Hvr != null) {
        paramVarArgs.d(4, this.Hvr);
      }
      paramVarArgs.aS(5, this.jeO);
      if (this.wTy != null) {
        paramVarArgs.d(6, this.wTy);
      }
      if (this.Iiq != null) {
        paramVarArgs.d(7, this.Iiq);
      }
      if (this.Iir != null) {
        paramVarArgs.d(8, this.Iir);
      }
      paramVarArgs.aS(9, this.Scene);
      if (this.Iis != null) {
        paramVarArgs.d(19, this.Iis);
      }
      AppMethodBeat.o(121110);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Iio == null) {
        break label770;
      }
    }
    label770:
    for (int i = f.a.a.b.b.a.e(1, this.Iio) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Iip != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Iip);
      }
      i = paramInt;
      if (this.HkY != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.HkY);
      }
      paramInt = i;
      if (this.Hvr != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Hvr);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.jeO);
      paramInt = i;
      if (this.wTy != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.wTy);
      }
      i = paramInt;
      if (this.Iiq != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.Iiq);
      }
      paramInt = i;
      if (this.Iir != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.Iir);
      }
      i = paramInt + f.a.a.b.b.a.bz(9, this.Scene);
      paramInt = i;
      if (this.Iis != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.Iis);
      }
      AppMethodBeat.o(121110);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(121110);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        edi localedi = (edi)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 10: 
        case 11: 
        case 12: 
        case 13: 
        case 14: 
        case 15: 
        case 16: 
        case 17: 
        case 18: 
        default: 
          AppMethodBeat.o(121110);
          return -1;
        case 1: 
          localedi.Iio = locala.OmT.readString();
          AppMethodBeat.o(121110);
          return 0;
        case 2: 
          localedi.Iip = locala.OmT.readString();
          AppMethodBeat.o(121110);
          return 0;
        case 3: 
          localedi.HkY = locala.OmT.readString();
          AppMethodBeat.o(121110);
          return 0;
        case 4: 
          localedi.Hvr = locala.OmT.readString();
          AppMethodBeat.o(121110);
          return 0;
        case 5: 
          localedi.jeO = locala.OmT.zc();
          AppMethodBeat.o(121110);
          return 0;
        case 6: 
          localedi.wTy = locala.OmT.readString();
          AppMethodBeat.o(121110);
          return 0;
        case 7: 
          localedi.Iiq = locala.OmT.readString();
          AppMethodBeat.o(121110);
          return 0;
        case 8: 
          localedi.Iir = locala.OmT.readString();
          AppMethodBeat.o(121110);
          return 0;
        case 9: 
          localedi.Scene = locala.OmT.zc();
          AppMethodBeat.o(121110);
          return 0;
        }
        localedi.Iis = locala.OmT.readString();
        AppMethodBeat.o(121110);
        return 0;
      }
      AppMethodBeat.o(121110);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.edi
 * JD-Core Version:    0.7.0.1
 */