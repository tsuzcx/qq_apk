package com.tencent.mm.plugin.wallet.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class j
  extends com.tencent.mm.bx.a
{
  public double VlD;
  public double VlE;
  public int VlF;
  public String VlG;
  public String VlH;
  public b VlM;
  public String VlN;
  public double VlO;
  public LinkedList<f> VlP;
  public double Vlw;
  public LinkedList<q> Vly;
  
  public j()
  {
    AppMethodBeat.i(91296);
    this.VlP = new LinkedList();
    this.Vly = new LinkedList();
    AppMethodBeat.o(91296);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91297);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.VlN != null) {
        paramVarArgs.g(1, this.VlN);
      }
      paramVarArgs.d(2, this.VlO);
      paramVarArgs.d(3, this.Vlw);
      paramVarArgs.e(4, 8, this.VlP);
      paramVarArgs.e(5, 8, this.Vly);
      paramVarArgs.d(6, this.VlD);
      paramVarArgs.d(7, this.VlE);
      paramVarArgs.bS(8, this.VlF);
      if (this.VlG != null) {
        paramVarArgs.g(9, this.VlG);
      }
      if (this.VlH != null) {
        paramVarArgs.g(10, this.VlH);
      }
      if (this.VlM != null) {
        paramVarArgs.d(11, this.VlM);
      }
      AppMethodBeat.o(91297);
      return 0;
    }
    if (paramInt == 1) {
      if (this.VlN == null) {
        break label858;
      }
    }
    label858:
    for (paramInt = i.a.a.b.b.a.h(1, this.VlN) + 0;; paramInt = 0)
    {
      int i = paramInt + (i.a.a.b.b.a.ko(2) + 8) + (i.a.a.b.b.a.ko(3) + 8) + i.a.a.a.c(4, 8, this.VlP) + i.a.a.a.c(5, 8, this.Vly) + (i.a.a.b.b.a.ko(6) + 8) + (i.a.a.b.b.a.ko(7) + 8) + i.a.a.b.b.a.cJ(8, this.VlF);
      paramInt = i;
      if (this.VlG != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.VlG);
      }
      i = paramInt;
      if (this.VlH != null) {
        i = paramInt + i.a.a.b.b.a.h(10, this.VlH);
      }
      paramInt = i;
      if (this.VlM != null) {
        paramInt = i + i.a.a.b.b.a.c(11, this.VlM);
      }
      AppMethodBeat.o(91297);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.VlP.clear();
        this.Vly.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91297);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        j localj = (j)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91297);
          return -1;
        case 1: 
          localj.VlN = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91297);
          return 0;
        case 2: 
          localj.VlO = Double.longBitsToDouble(((i.a.a.a.a)localObject1).ajGk.aay());
          AppMethodBeat.o(91297);
          return 0;
        case 3: 
          localj.Vlw = Double.longBitsToDouble(((i.a.a.a.a)localObject1).ajGk.aay());
          AppMethodBeat.o(91297);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new f();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((f)localObject2).parseFrom((byte[])localObject1);
            }
            localj.VlP.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91297);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new q();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((q)localObject2).parseFrom((byte[])localObject1);
            }
            localj.Vly.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91297);
          return 0;
        case 6: 
          localj.VlD = Double.longBitsToDouble(((i.a.a.a.a)localObject1).ajGk.aay());
          AppMethodBeat.o(91297);
          return 0;
        case 7: 
          localj.VlE = Double.longBitsToDouble(((i.a.a.a.a)localObject1).ajGk.aay());
          AppMethodBeat.o(91297);
          return 0;
        case 8: 
          localj.VlF = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91297);
          return 0;
        case 9: 
          localj.VlG = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91297);
          return 0;
        case 10: 
          localj.VlH = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91297);
          return 0;
        }
        localj.VlM = ((i.a.a.a.a)localObject1).ajGk.kFX();
        AppMethodBeat.o(91297);
        return 0;
      }
      AppMethodBeat.o(91297);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.model.j
 * JD-Core Version:    0.7.0.1
 */