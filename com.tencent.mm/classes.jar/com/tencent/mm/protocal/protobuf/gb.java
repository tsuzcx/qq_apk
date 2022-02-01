package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class gb
  extends com.tencent.mm.bx.a
{
  public int Njs;
  public String Url;
  public int YHA;
  public String YHB;
  public int YHC;
  public boolean YHD;
  public int YHE;
  public int YHF;
  public int YHG;
  public int YHH;
  public boolean YHI;
  public LinkedList<fnm> YHJ;
  public int nUA;
  public String nUB;
  
  public gb()
  {
    AppMethodBeat.i(6388);
    this.YHA = 600;
    this.nUA = -1;
    this.YHI = false;
    this.YHJ = new LinkedList();
    AppMethodBeat.o(6388);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(6389);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.Url != null) {
        paramVarArgs.g(1, this.Url);
      }
      if (this.nUB != null) {
        paramVarArgs.g(2, this.nUB);
      }
      paramVarArgs.bS(3, this.YHA);
      if (this.YHB != null) {
        paramVarArgs.g(4, this.YHB);
      }
      paramVarArgs.bS(5, this.YHC);
      paramVarArgs.di(6, this.YHD);
      paramVarArgs.bS(7, this.YHE);
      paramVarArgs.bS(8, this.YHF);
      paramVarArgs.bS(9, this.Njs);
      paramVarArgs.bS(10, this.YHG);
      paramVarArgs.bS(11, this.YHH);
      paramVarArgs.bS(12, this.nUA);
      paramVarArgs.di(13, this.YHI);
      paramVarArgs.e(14, 8, this.YHJ);
      AppMethodBeat.o(6389);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Url == null) {
        break label944;
      }
    }
    label944:
    for (paramInt = i.a.a.b.b.a.h(1, this.Url) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.nUB != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.nUB);
      }
      i += i.a.a.b.b.a.cJ(3, this.YHA);
      paramInt = i;
      if (this.YHB != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.YHB);
      }
      i = i.a.a.b.b.a.cJ(5, this.YHC);
      int j = i.a.a.b.b.a.ko(6);
      int k = i.a.a.b.b.a.cJ(7, this.YHE);
      int m = i.a.a.b.b.a.cJ(8, this.YHF);
      int n = i.a.a.b.b.a.cJ(9, this.Njs);
      int i1 = i.a.a.b.b.a.cJ(10, this.YHG);
      int i2 = i.a.a.b.b.a.cJ(11, this.YHH);
      int i3 = i.a.a.b.b.a.cJ(12, this.nUA);
      int i4 = i.a.a.b.b.a.ko(13);
      int i5 = i.a.a.a.c(14, 8, this.YHJ);
      AppMethodBeat.o(6389);
      return paramInt + i + (j + 1) + k + m + n + i1 + i2 + i3 + (i4 + 1) + i5;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.YHJ.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(6389);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        gb localgb = (gb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(6389);
          return -1;
        case 1: 
          localgb.Url = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(6389);
          return 0;
        case 2: 
          localgb.nUB = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(6389);
          return 0;
        case 3: 
          localgb.YHA = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(6389);
          return 0;
        case 4: 
          localgb.YHB = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(6389);
          return 0;
        case 5: 
          localgb.YHC = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(6389);
          return 0;
        case 6: 
          localgb.YHD = ((i.a.a.a.a)localObject).ajGk.aai();
          AppMethodBeat.o(6389);
          return 0;
        case 7: 
          localgb.YHE = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(6389);
          return 0;
        case 8: 
          localgb.YHF = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(6389);
          return 0;
        case 9: 
          localgb.Njs = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(6389);
          return 0;
        case 10: 
          localgb.YHG = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(6389);
          return 0;
        case 11: 
          localgb.YHH = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(6389);
          return 0;
        case 12: 
          localgb.nUA = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(6389);
          return 0;
        case 13: 
          localgb.YHI = ((i.a.a.a.a)localObject).ajGk.aai();
          AppMethodBeat.o(6389);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          fnm localfnm = new fnm();
          if ((localObject != null) && (localObject.length > 0)) {
            localfnm.parseFrom((byte[])localObject);
          }
          localgb.YHJ.add(localfnm);
          paramInt += 1;
        }
        AppMethodBeat.o(6389);
        return 0;
      }
      AppMethodBeat.o(6389);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gb
 * JD-Core Version:    0.7.0.1
 */