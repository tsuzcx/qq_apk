package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eal
  extends com.tencent.mm.bx.a
{
  public String YBH;
  public String abfC;
  public String abfD;
  public String abfE;
  public int abfF;
  public LinkedList<vs> abfG;
  public String abfH;
  public String abfI;
  
  public eal()
  {
    AppMethodBeat.i(114047);
    this.abfG = new LinkedList();
    AppMethodBeat.o(114047);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114048);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YBH != null) {
        paramVarArgs.g(1, this.YBH);
      }
      if (this.abfC != null) {
        paramVarArgs.g(2, this.abfC);
      }
      if (this.abfD != null) {
        paramVarArgs.g(3, this.abfD);
      }
      if (this.abfE != null) {
        paramVarArgs.g(4, this.abfE);
      }
      paramVarArgs.bS(5, this.abfF);
      paramVarArgs.e(6, 8, this.abfG);
      if (this.abfH != null) {
        paramVarArgs.g(7, this.abfH);
      }
      if (this.abfI != null) {
        paramVarArgs.g(8, this.abfI);
      }
      AppMethodBeat.o(114048);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YBH == null) {
        break label680;
      }
    }
    label680:
    for (int i = i.a.a.b.b.a.h(1, this.YBH) + 0;; i = 0)
    {
      paramInt = i;
      if (this.abfC != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.abfC);
      }
      i = paramInt;
      if (this.abfD != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.abfD);
      }
      paramInt = i;
      if (this.abfE != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.abfE);
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.abfF) + i.a.a.a.c(6, 8, this.abfG);
      paramInt = i;
      if (this.abfH != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.abfH);
      }
      i = paramInt;
      if (this.abfI != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.abfI);
      }
      AppMethodBeat.o(114048);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abfG.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(114048);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        eal localeal = (eal)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114048);
          return -1;
        case 1: 
          localeal.YBH = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(114048);
          return 0;
        case 2: 
          localeal.abfC = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(114048);
          return 0;
        case 3: 
          localeal.abfD = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(114048);
          return 0;
        case 4: 
          localeal.abfE = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(114048);
          return 0;
        case 5: 
          localeal.abfF = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(114048);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            vs localvs = new vs();
            if ((localObject != null) && (localObject.length > 0)) {
              localvs.parseFrom((byte[])localObject);
            }
            localeal.abfG.add(localvs);
            paramInt += 1;
          }
          AppMethodBeat.o(114048);
          return 0;
        case 7: 
          localeal.abfH = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(114048);
          return 0;
        }
        localeal.abfI = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(114048);
        return 0;
      }
      AppMethodBeat.o(114048);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eal
 * JD-Core Version:    0.7.0.1
 */