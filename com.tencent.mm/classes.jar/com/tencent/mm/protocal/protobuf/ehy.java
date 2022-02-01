package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class ehy
  extends com.tencent.mm.bx.a
{
  public int FFN;
  public String Fvh;
  public String HSp;
  public float HSq;
  public float HSr;
  public int HSs;
  public String HSt;
  public b HpP;
  public String IconUrl;
  public String iht;
  public String nDo;
  public String nEt;
  public String ujc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117960);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HSp != null) {
        paramVarArgs.d(1, this.HSp);
      }
      if (this.nEt != null) {
        paramVarArgs.d(2, this.nEt);
      }
      if (this.IconUrl != null) {
        paramVarArgs.d(3, this.IconUrl);
      }
      if (this.nDo != null) {
        paramVarArgs.d(4, this.nDo);
      }
      paramVarArgs.aS(5, this.FFN);
      if (this.Fvh != null) {
        paramVarArgs.d(6, this.Fvh);
      }
      if (this.ujc != null) {
        paramVarArgs.d(7, this.ujc);
      }
      paramVarArgs.z(8, this.HSq);
      paramVarArgs.z(9, this.HSr);
      paramVarArgs.aS(10, this.HSs);
      if (this.iht != null) {
        paramVarArgs.d(11, this.iht);
      }
      if (this.HSt != null) {
        paramVarArgs.d(12, this.HSt);
      }
      if (this.HpP != null) {
        paramVarArgs.c(13, this.HpP);
      }
      AppMethodBeat.o(117960);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HSp == null) {
        break label880;
      }
    }
    label880:
    for (int i = f.a.a.b.b.a.e(1, this.HSp) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nEt != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.nEt);
      }
      i = paramInt;
      if (this.IconUrl != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.IconUrl);
      }
      paramInt = i;
      if (this.nDo != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.nDo);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.FFN);
      paramInt = i;
      if (this.Fvh != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Fvh);
      }
      i = paramInt;
      if (this.ujc != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.ujc);
      }
      i = i + f.a.a.b.b.a.alU(8) + f.a.a.b.b.a.alU(9) + f.a.a.b.b.a.bz(10, this.HSs);
      paramInt = i;
      if (this.iht != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.iht);
      }
      i = paramInt;
      if (this.HSt != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.HSt);
      }
      paramInt = i;
      if (this.HpP != null) {
        paramInt = i + f.a.a.b.b.a.b(13, this.HpP);
      }
      AppMethodBeat.o(117960);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(117960);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ehy localehy = (ehy)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117960);
          return -1;
        case 1: 
          localehy.HSp = locala.NPN.readString();
          AppMethodBeat.o(117960);
          return 0;
        case 2: 
          localehy.nEt = locala.NPN.readString();
          AppMethodBeat.o(117960);
          return 0;
        case 3: 
          localehy.IconUrl = locala.NPN.readString();
          AppMethodBeat.o(117960);
          return 0;
        case 4: 
          localehy.nDo = locala.NPN.readString();
          AppMethodBeat.o(117960);
          return 0;
        case 5: 
          localehy.FFN = locala.NPN.zc();
          AppMethodBeat.o(117960);
          return 0;
        case 6: 
          localehy.Fvh = locala.NPN.readString();
          AppMethodBeat.o(117960);
          return 0;
        case 7: 
          localehy.ujc = locala.NPN.readString();
          AppMethodBeat.o(117960);
          return 0;
        case 8: 
          localehy.HSq = Float.intBitsToFloat(locala.NPN.grz());
          AppMethodBeat.o(117960);
          return 0;
        case 9: 
          localehy.HSr = Float.intBitsToFloat(locala.NPN.grz());
          AppMethodBeat.o(117960);
          return 0;
        case 10: 
          localehy.HSs = locala.NPN.zc();
          AppMethodBeat.o(117960);
          return 0;
        case 11: 
          localehy.iht = locala.NPN.readString();
          AppMethodBeat.o(117960);
          return 0;
        case 12: 
          localehy.HSt = locala.NPN.readString();
          AppMethodBeat.o(117960);
          return 0;
        }
        localehy.HpP = locala.NPN.gxI();
        AppMethodBeat.o(117960);
        return 0;
      }
      AppMethodBeat.o(117960);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ehy
 * JD-Core Version:    0.7.0.1
 */