package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class iv
  extends com.tencent.mm.cd.a
{
  public String DNV;
  public String IfQ;
  public int IfR;
  public int IfS;
  public String IfT;
  public String IfU;
  public String IfV;
  public long IfY;
  public LinkedList<aks> ROI;
  public String ROJ;
  public String ROK;
  public String fvP;
  
  public iv()
  {
    AppMethodBeat.i(72420);
    this.ROI = new LinkedList();
    AppMethodBeat.o(72420);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72421);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.fvP != null) {
        paramVarArgs.f(1, this.fvP);
      }
      if (this.DNV != null) {
        paramVarArgs.f(2, this.DNV);
      }
      if (this.IfQ != null) {
        paramVarArgs.f(3, this.IfQ);
      }
      paramVarArgs.aY(4, this.IfR);
      paramVarArgs.aY(5, this.IfS);
      paramVarArgs.e(6, 8, this.ROI);
      if (this.IfT != null) {
        paramVarArgs.f(7, this.IfT);
      }
      if (this.IfU != null) {
        paramVarArgs.f(8, this.IfU);
      }
      if (this.IfV != null) {
        paramVarArgs.f(9, this.IfV);
      }
      if (this.ROJ != null) {
        paramVarArgs.f(10, this.ROJ);
      }
      if (this.ROK != null) {
        paramVarArgs.f(11, this.ROK);
      }
      paramVarArgs.bm(12, this.IfY);
      AppMethodBeat.o(72421);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fvP == null) {
        break label896;
      }
    }
    label896:
    for (int i = g.a.a.b.b.a.g(1, this.fvP) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DNV != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.DNV);
      }
      i = paramInt;
      if (this.IfQ != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.IfQ);
      }
      i = i + g.a.a.b.b.a.bM(4, this.IfR) + g.a.a.b.b.a.bM(5, this.IfS) + g.a.a.a.c(6, 8, this.ROI);
      paramInt = i;
      if (this.IfT != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.IfT);
      }
      i = paramInt;
      if (this.IfU != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.IfU);
      }
      paramInt = i;
      if (this.IfV != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.IfV);
      }
      i = paramInt;
      if (this.ROJ != null) {
        i = paramInt + g.a.a.b.b.a.g(10, this.ROJ);
      }
      paramInt = i;
      if (this.ROK != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.ROK);
      }
      i = g.a.a.b.b.a.p(12, this.IfY);
      AppMethodBeat.o(72421);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ROI.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(72421);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        iv localiv = (iv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72421);
          return -1;
        case 1: 
          localiv.fvP = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72421);
          return 0;
        case 2: 
          localiv.DNV = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72421);
          return 0;
        case 3: 
          localiv.IfQ = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72421);
          return 0;
        case 4: 
          localiv.IfR = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(72421);
          return 0;
        case 5: 
          localiv.IfS = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(72421);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            aks localaks = new aks();
            if ((localObject != null) && (localObject.length > 0)) {
              localaks.parseFrom((byte[])localObject);
            }
            localiv.ROI.add(localaks);
            paramInt += 1;
          }
          AppMethodBeat.o(72421);
          return 0;
        case 7: 
          localiv.IfT = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72421);
          return 0;
        case 8: 
          localiv.IfU = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72421);
          return 0;
        case 9: 
          localiv.IfV = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72421);
          return 0;
        case 10: 
          localiv.ROJ = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72421);
          return 0;
        case 11: 
          localiv.ROK = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72421);
          return 0;
        }
        localiv.IfY = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(72421);
        return 0;
      }
      AppMethodBeat.o(72421);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.iv
 * JD-Core Version:    0.7.0.1
 */