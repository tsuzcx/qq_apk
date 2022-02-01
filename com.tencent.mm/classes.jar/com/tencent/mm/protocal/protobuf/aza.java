package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class aza
  extends com.tencent.mm.cd.a
{
  public int SDv;
  public b SHN;
  public ayl SHb;
  public LinkedList<ayl> SHe;
  public int SKR;
  public int SKS;
  public int SKT;
  public String SKU;
  public boolean SKV;
  public String SKa;
  public FinderContact contact;
  public int ktP;
  
  public aza()
  {
    AppMethodBeat.i(205679);
    this.SHe = new LinkedList();
    AppMethodBeat.o(205679);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(205684);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.contact != null)
      {
        paramVarArgs.oE(1, this.contact.computeSize());
        this.contact.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.ktP);
      paramVarArgs.aY(3, this.SKR);
      paramVarArgs.aY(4, this.SKS);
      paramVarArgs.aY(5, this.SKT);
      if (this.SHb != null)
      {
        paramVarArgs.oE(6, this.SHb.computeSize());
        this.SHb.writeFields(paramVarArgs);
      }
      if (this.SKU != null) {
        paramVarArgs.f(9, this.SKU);
      }
      paramVarArgs.aY(10, this.SDv);
      if (this.SKa != null) {
        paramVarArgs.f(11, this.SKa);
      }
      if (this.SHN != null) {
        paramVarArgs.c(12, this.SHN);
      }
      paramVarArgs.co(13, this.SKV);
      paramVarArgs.e(14, 8, this.SHe);
      AppMethodBeat.o(205684);
      return 0;
    }
    if (paramInt == 1) {
      if (this.contact == null) {
        break label1000;
      }
    }
    label1000:
    for (paramInt = g.a.a.a.oD(1, this.contact.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.ktP) + g.a.a.b.b.a.bM(3, this.SKR) + g.a.a.b.b.a.bM(4, this.SKS) + g.a.a.b.b.a.bM(5, this.SKT);
      paramInt = i;
      if (this.SHb != null) {
        paramInt = i + g.a.a.a.oD(6, this.SHb.computeSize());
      }
      i = paramInt;
      if (this.SKU != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.SKU);
      }
      i += g.a.a.b.b.a.bM(10, this.SDv);
      paramInt = i;
      if (this.SKa != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.SKa);
      }
      i = paramInt;
      if (this.SHN != null) {
        i = paramInt + g.a.a.b.b.a.b(12, this.SHN);
      }
      paramInt = g.a.a.b.b.a.gL(13);
      int j = g.a.a.a.c(14, 8, this.SHe);
      AppMethodBeat.o(205684);
      return i + (paramInt + 1) + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.SHe.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(205684);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        aza localaza = (aza)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 7: 
        case 8: 
        default: 
          AppMethodBeat.o(205684);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new FinderContact();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((FinderContact)localObject2).parseFrom((byte[])localObject1);
            }
            localaza.contact = ((FinderContact)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(205684);
          return 0;
        case 2: 
          localaza.ktP = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(205684);
          return 0;
        case 3: 
          localaza.SKR = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(205684);
          return 0;
        case 4: 
          localaza.SKS = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(205684);
          return 0;
        case 5: 
          localaza.SKT = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(205684);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ayl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ayl)localObject2).parseFrom((byte[])localObject1);
            }
            localaza.SHb = ((ayl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(205684);
          return 0;
        case 9: 
          localaza.SKU = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(205684);
          return 0;
        case 10: 
          localaza.SDv = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(205684);
          return 0;
        case 11: 
          localaza.SKa = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(205684);
          return 0;
        case 12: 
          localaza.SHN = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(205684);
          return 0;
        case 13: 
          localaza.SKV = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(205684);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ayl();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ayl)localObject2).parseFrom((byte[])localObject1);
          }
          localaza.SHe.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(205684);
        return 0;
      }
      AppMethodBeat.o(205684);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aza
 * JD-Core Version:    0.7.0.1
 */