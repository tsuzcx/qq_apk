package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class bdp
  extends com.tencent.mm.cd.a
{
  public bds GaB;
  public bdr Gbq;
  public LinkedList<bdt> SOB;
  public bfk SOC;
  public bdq SOD;
  public LinkedList<bdt> SOE;
  public int SOF;
  public int SOG;
  
  public bdp()
  {
    AppMethodBeat.i(200034);
    this.SOB = new LinkedList();
    this.SOE = new LinkedList();
    AppMethodBeat.o(200034);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(200049);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.SOB);
      if (this.GaB != null)
      {
        paramVarArgs.oE(2, this.GaB.computeSize());
        this.GaB.writeFields(paramVarArgs);
      }
      if (this.Gbq != null)
      {
        paramVarArgs.oE(3, this.Gbq.computeSize());
        this.Gbq.writeFields(paramVarArgs);
      }
      if (this.SOC != null)
      {
        paramVarArgs.oE(4, this.SOC.computeSize());
        this.SOC.writeFields(paramVarArgs);
      }
      if (this.SOD != null)
      {
        paramVarArgs.oE(5, this.SOD.computeSize());
        this.SOD.writeFields(paramVarArgs);
      }
      paramVarArgs.e(6, 8, this.SOE);
      paramVarArgs.aY(7, this.SOF);
      paramVarArgs.aY(8, this.SOG);
      AppMethodBeat.o(200049);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.a.c(1, 8, this.SOB) + 0;
      paramInt = i;
      if (this.GaB != null) {
        paramInt = i + g.a.a.a.oD(2, this.GaB.computeSize());
      }
      i = paramInt;
      if (this.Gbq != null) {
        i = paramInt + g.a.a.a.oD(3, this.Gbq.computeSize());
      }
      paramInt = i;
      if (this.SOC != null) {
        paramInt = i + g.a.a.a.oD(4, this.SOC.computeSize());
      }
      i = paramInt;
      if (this.SOD != null) {
        i = paramInt + g.a.a.a.oD(5, this.SOD.computeSize());
      }
      paramInt = g.a.a.a.c(6, 8, this.SOE);
      int j = g.a.a.b.b.a.bM(7, this.SOF);
      int k = g.a.a.b.b.a.bM(8, this.SOG);
      AppMethodBeat.o(200049);
      return i + paramInt + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.SOB.clear();
      this.SOE.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(200049);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      bdp localbdp = (bdp)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(200049);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bdt();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bdt)localObject2).parseFrom((byte[])localObject1);
          }
          localbdp.SOB.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(200049);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bds();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bds)localObject2).parseFrom((byte[])localObject1);
          }
          localbdp.GaB = ((bds)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(200049);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bdr();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bdr)localObject2).parseFrom((byte[])localObject1);
          }
          localbdp.Gbq = ((bdr)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(200049);
        return 0;
      case 4: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bfk();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bfk)localObject2).parseFrom((byte[])localObject1);
          }
          localbdp.SOC = ((bfk)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(200049);
        return 0;
      case 5: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bdq();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bdq)localObject2).parseFrom((byte[])localObject1);
          }
          localbdp.SOD = ((bdq)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(200049);
        return 0;
      case 6: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bdt();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bdt)localObject2).parseFrom((byte[])localObject1);
          }
          localbdp.SOE.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(200049);
        return 0;
      case 7: 
        localbdp.SOF = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(200049);
        return 0;
      }
      localbdp.SOG = ((g.a.a.a.a)localObject1).abFh.AK();
      AppMethodBeat.o(200049);
      return 0;
    }
    AppMethodBeat.o(200049);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bdp
 * JD-Core Version:    0.7.0.1
 */