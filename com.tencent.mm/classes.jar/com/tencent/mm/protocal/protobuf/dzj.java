package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dzj
  extends com.tencent.mm.bx.a
{
  public float Fum;
  public String Gah;
  public String HMB;
  public String HMC;
  public String HMD;
  public int HME;
  public float HMF;
  public String HMG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147791);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HMB != null) {
        paramVarArgs.d(1, this.HMB);
      }
      if (this.Gah != null) {
        paramVarArgs.d(2, this.Gah);
      }
      if (this.HMC != null) {
        paramVarArgs.d(3, this.HMC);
      }
      if (this.HMD != null) {
        paramVarArgs.d(4, this.HMD);
      }
      paramVarArgs.aS(5, this.HME);
      paramVarArgs.z(6, this.Fum);
      paramVarArgs.z(7, this.HMF);
      if (this.HMG != null) {
        paramVarArgs.d(8, this.HMG);
      }
      AppMethodBeat.o(147791);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HMB == null) {
        break label588;
      }
    }
    label588:
    for (int i = f.a.a.b.b.a.e(1, this.HMB) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Gah != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Gah);
      }
      i = paramInt;
      if (this.HMC != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.HMC);
      }
      paramInt = i;
      if (this.HMD != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.HMD);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.HME) + f.a.a.b.b.a.alU(6) + f.a.a.b.b.a.alU(7);
      paramInt = i;
      if (this.HMG != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.HMG);
      }
      AppMethodBeat.o(147791);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(147791);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dzj localdzj = (dzj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(147791);
          return -1;
        case 1: 
          localdzj.HMB = locala.NPN.readString();
          AppMethodBeat.o(147791);
          return 0;
        case 2: 
          localdzj.Gah = locala.NPN.readString();
          AppMethodBeat.o(147791);
          return 0;
        case 3: 
          localdzj.HMC = locala.NPN.readString();
          AppMethodBeat.o(147791);
          return 0;
        case 4: 
          localdzj.HMD = locala.NPN.readString();
          AppMethodBeat.o(147791);
          return 0;
        case 5: 
          localdzj.HME = locala.NPN.zc();
          AppMethodBeat.o(147791);
          return 0;
        case 6: 
          localdzj.Fum = Float.intBitsToFloat(locala.NPN.grz());
          AppMethodBeat.o(147791);
          return 0;
        case 7: 
          localdzj.HMF = Float.intBitsToFloat(locala.NPN.grz());
          AppMethodBeat.o(147791);
          return 0;
        }
        localdzj.HMG = locala.NPN.readString();
        AppMethodBeat.o(147791);
        return 0;
      }
      AppMethodBeat.o(147791);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzj
 * JD-Core Version:    0.7.0.1
 */