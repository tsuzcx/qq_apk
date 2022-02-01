package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fit
  extends com.tencent.mm.bx.a
{
  public int aaPu;
  public long aaTL;
  public int aaTP;
  public int abJC;
  public fir abJD;
  public String abJE;
  public boolean abJF;
  public LinkedList<String> abJG;
  public String md5;
  public String nUv;
  public int nrQ;
  
  public fit()
  {
    AppMethodBeat.i(259995);
    this.abJG = new LinkedList();
    AppMethodBeat.o(259995);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118455);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.nUv != null) {
        paramVarArgs.g(1, this.nUv);
      }
      paramVarArgs.bS(2, this.nrQ);
      paramVarArgs.bv(3, this.aaTL);
      paramVarArgs.bS(4, this.aaTP);
      if (this.md5 != null) {
        paramVarArgs.g(5, this.md5);
      }
      paramVarArgs.bS(6, this.aaPu);
      paramVarArgs.bS(7, this.abJC);
      if (this.abJD != null)
      {
        paramVarArgs.qD(8, this.abJD.computeSize());
        this.abJD.writeFields(paramVarArgs);
      }
      if (this.abJE != null) {
        paramVarArgs.g(9, this.abJE);
      }
      paramVarArgs.di(10, this.abJF);
      paramVarArgs.e(11, 1, this.abJG);
      AppMethodBeat.o(118455);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nUv == null) {
        break label796;
      }
    }
    label796:
    for (paramInt = i.a.a.b.b.a.h(1, this.nUv) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.nrQ) + i.a.a.b.b.a.q(3, this.aaTL) + i.a.a.b.b.a.cJ(4, this.aaTP);
      paramInt = i;
      if (this.md5 != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.md5);
      }
      i = paramInt + i.a.a.b.b.a.cJ(6, this.aaPu) + i.a.a.b.b.a.cJ(7, this.abJC);
      paramInt = i;
      if (this.abJD != null) {
        paramInt = i + i.a.a.a.qC(8, this.abJD.computeSize());
      }
      i = paramInt;
      if (this.abJE != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.abJE);
      }
      paramInt = i.a.a.b.b.a.ko(10);
      int j = i.a.a.a.c(11, 1, this.abJG);
      AppMethodBeat.o(118455);
      return i + (paramInt + 1) + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abJG.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(118455);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        fit localfit = (fit)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(118455);
          return -1;
        case 1: 
          localfit.nUv = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(118455);
          return 0;
        case 2: 
          localfit.nrQ = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(118455);
          return 0;
        case 3: 
          localfit.aaTL = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(118455);
          return 0;
        case 4: 
          localfit.aaTP = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(118455);
          return 0;
        case 5: 
          localfit.md5 = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(118455);
          return 0;
        case 6: 
          localfit.aaPu = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(118455);
          return 0;
        case 7: 
          localfit.abJC = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(118455);
          return 0;
        case 8: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            fir localfir = new fir();
            if ((localObject != null) && (localObject.length > 0)) {
              localfir.parseFrom((byte[])localObject);
            }
            localfit.abJD = localfir;
            paramInt += 1;
          }
          AppMethodBeat.o(118455);
          return 0;
        case 9: 
          localfit.abJE = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(118455);
          return 0;
        case 10: 
          localfit.abJF = ((i.a.a.a.a)localObject).ajGk.aai();
          AppMethodBeat.o(118455);
          return 0;
        }
        localfit.abJG.add(((i.a.a.a.a)localObject).ajGk.readString());
        AppMethodBeat.o(118455);
        return 0;
      }
      AppMethodBeat.o(118455);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fit
 * JD-Core Version:    0.7.0.1
 */