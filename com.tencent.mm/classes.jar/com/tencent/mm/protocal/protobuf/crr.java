package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class crr
  extends com.tencent.mm.bx.a
{
  public String GMM;
  public int Hka;
  public String Hkb;
  public String Hkc;
  public String Hkd;
  public String Hke;
  public bmk Hkf;
  public String Hkg;
  public String Hkh;
  public String mrh;
  public String mri;
  public String mrj;
  public String mrk;
  public int mrl;
  public String mrm;
  public String pky;
  public double score;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50101);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.mrl);
      paramVarArgs.aS(2, this.Hka);
      if (this.GMM != null) {
        paramVarArgs.d(3, this.GMM);
      }
      if (this.mrj != null) {
        paramVarArgs.d(4, this.mrj);
      }
      if (this.mrk != null) {
        paramVarArgs.d(5, this.mrk);
      }
      if (this.Hkb != null) {
        paramVarArgs.d(6, this.Hkb);
      }
      if (this.pky != null) {
        paramVarArgs.d(7, this.pky);
      }
      if (this.Hkc != null) {
        paramVarArgs.d(8, this.Hkc);
      }
      if (this.Hkd != null) {
        paramVarArgs.d(9, this.Hkd);
      }
      paramVarArgs.e(10, this.score);
      if (this.Hke != null) {
        paramVarArgs.d(11, this.Hke);
      }
      if (this.mrh != null) {
        paramVarArgs.d(12, this.mrh);
      }
      if (this.Hkf != null)
      {
        paramVarArgs.lC(14, this.Hkf.computeSize());
        this.Hkf.writeFields(paramVarArgs);
      }
      if (this.mri != null) {
        paramVarArgs.d(15, this.mri);
      }
      if (this.Hkg != null) {
        paramVarArgs.d(16, this.Hkg);
      }
      if (this.Hkh != null) {
        paramVarArgs.d(17, this.Hkh);
      }
      if (this.mrm != null) {
        paramVarArgs.d(18, this.mrm);
      }
      AppMethodBeat.o(50101);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.mrl) + 0 + f.a.a.b.b.a.bz(2, this.Hka);
      paramInt = i;
      if (this.GMM != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.GMM);
      }
      i = paramInt;
      if (this.mrj != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.mrj);
      }
      paramInt = i;
      if (this.mrk != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.mrk);
      }
      i = paramInt;
      if (this.Hkb != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.Hkb);
      }
      paramInt = i;
      if (this.pky != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.pky);
      }
      i = paramInt;
      if (this.Hkc != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.Hkc);
      }
      paramInt = i;
      if (this.Hkd != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.Hkd);
      }
      i = paramInt + f.a.a.b.b.a.alT(10);
      paramInt = i;
      if (this.Hke != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.Hke);
      }
      i = paramInt;
      if (this.mrh != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.mrh);
      }
      paramInt = i;
      if (this.Hkf != null) {
        paramInt = i + f.a.a.a.lB(14, this.Hkf.computeSize());
      }
      i = paramInt;
      if (this.mri != null) {
        i = paramInt + f.a.a.b.b.a.e(15, this.mri);
      }
      paramInt = i;
      if (this.Hkg != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.Hkg);
      }
      i = paramInt;
      if (this.Hkh != null) {
        i = paramInt + f.a.a.b.b.a.e(17, this.Hkh);
      }
      paramInt = i;
      if (this.mrm != null) {
        paramInt = i + f.a.a.b.b.a.e(18, this.mrm);
      }
      AppMethodBeat.o(50101);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(50101);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      crr localcrr = (crr)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      case 13: 
      default: 
        AppMethodBeat.o(50101);
        return -1;
      case 1: 
        localcrr.mrl = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(50101);
        return 0;
      case 2: 
        localcrr.Hka = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(50101);
        return 0;
      case 3: 
        localcrr.GMM = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(50101);
        return 0;
      case 4: 
        localcrr.mrj = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(50101);
        return 0;
      case 5: 
        localcrr.mrk = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(50101);
        return 0;
      case 6: 
        localcrr.Hkb = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(50101);
        return 0;
      case 7: 
        localcrr.pky = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(50101);
        return 0;
      case 8: 
        localcrr.Hkc = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(50101);
        return 0;
      case 9: 
        localcrr.Hkd = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(50101);
        return 0;
      case 10: 
        localcrr.score = Double.longBitsToDouble(((f.a.a.a.a)localObject1).NPN.grA());
        AppMethodBeat.o(50101);
        return 0;
      case 11: 
        localcrr.Hke = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(50101);
        return 0;
      case 12: 
        localcrr.mrh = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(50101);
        return 0;
      case 14: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bmk();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bmk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcrr.Hkf = ((bmk)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(50101);
        return 0;
      case 15: 
        localcrr.mri = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(50101);
        return 0;
      case 16: 
        localcrr.Hkg = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(50101);
        return 0;
      case 17: 
        localcrr.Hkh = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(50101);
        return 0;
      }
      localcrr.mrm = ((f.a.a.a.a)localObject1).NPN.readString();
      AppMethodBeat.o(50101);
      return 0;
    }
    AppMethodBeat.o(50101);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.crr
 * JD-Core Version:    0.7.0.1
 */