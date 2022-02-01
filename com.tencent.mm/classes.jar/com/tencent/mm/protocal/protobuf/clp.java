package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class clp
  extends com.tencent.mm.bw.a
{
  public int MqO;
  public float MqS;
  public float MqT;
  public String MqU;
  public LinkedList<String> MqV;
  public String MqW;
  public LinkedList<String> MqX;
  public LinkedList<clq> MqY;
  public LinkedList<cln> MqZ;
  public int Mra;
  public int dNP;
  public int duration;
  public String iAz;
  public String jTB;
  
  public clp()
  {
    AppMethodBeat.i(169924);
    this.MqV = new LinkedList();
    this.MqX = new LinkedList();
    this.MqY = new LinkedList();
    this.MqZ = new LinkedList();
    this.Mra = 1;
    AppMethodBeat.o(169924);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169925);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MqU == null)
      {
        paramVarArgs = new b("Not all required fields were included: music_url");
        AppMethodBeat.o(169925);
        throw paramVarArgs;
      }
      paramVarArgs.aM(1, this.MqO);
      paramVarArgs.E(2, this.MqS);
      paramVarArgs.E(3, this.MqT);
      if (this.MqU != null) {
        paramVarArgs.e(4, this.MqU);
      }
      paramVarArgs.e(5, 1, this.MqV);
      if (this.MqW != null) {
        paramVarArgs.e(6, this.MqW);
      }
      paramVarArgs.e(7, 1, this.MqX);
      paramVarArgs.e(8, 8, this.MqY);
      if (this.jTB != null) {
        paramVarArgs.e(9, this.jTB);
      }
      if (this.iAz != null) {
        paramVarArgs.e(10, this.iAz);
      }
      paramVarArgs.e(11, 8, this.MqZ);
      paramVarArgs.aM(12, this.dNP);
      paramVarArgs.aM(13, this.duration);
      paramVarArgs.aM(14, this.Mra);
      AppMethodBeat.o(169925);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.MqO) + 0 + (g.a.a.b.b.a.fS(2) + 4) + (g.a.a.b.b.a.fS(3) + 4);
      paramInt = i;
      if (this.MqU != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.MqU);
      }
      i = paramInt + g.a.a.a.c(5, 1, this.MqV);
      paramInt = i;
      if (this.MqW != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.MqW);
      }
      i = paramInt + g.a.a.a.c(7, 1, this.MqX) + g.a.a.a.c(8, 8, this.MqY);
      paramInt = i;
      if (this.jTB != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.jTB);
      }
      i = paramInt;
      if (this.iAz != null) {
        i = paramInt + g.a.a.b.b.a.f(10, this.iAz);
      }
      paramInt = g.a.a.a.c(11, 8, this.MqZ);
      int j = g.a.a.b.b.a.bu(12, this.dNP);
      int k = g.a.a.b.b.a.bu(13, this.duration);
      int m = g.a.a.b.b.a.bu(14, this.Mra);
      AppMethodBeat.o(169925);
      return i + paramInt + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.MqV.clear();
      this.MqX.clear();
      this.MqY.clear();
      this.MqZ.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      if (this.MqU == null)
      {
        paramVarArgs = new b("Not all required fields were included: music_url");
        AppMethodBeat.o(169925);
        throw paramVarArgs;
      }
      AppMethodBeat.o(169925);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      clp localclp = (clp)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(169925);
        return -1;
      case 1: 
        localclp.MqO = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(169925);
        return 0;
      case 2: 
        localclp.MqS = Float.intBitsToFloat(((g.a.a.a.a)localObject1).UbS.zm());
        AppMethodBeat.o(169925);
        return 0;
      case 3: 
        localclp.MqT = Float.intBitsToFloat(((g.a.a.a.a)localObject1).UbS.zm());
        AppMethodBeat.o(169925);
        return 0;
      case 4: 
        localclp.MqU = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(169925);
        return 0;
      case 5: 
        localclp.MqV.add(((g.a.a.a.a)localObject1).UbS.readString());
        AppMethodBeat.o(169925);
        return 0;
      case 6: 
        localclp.MqW = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(169925);
        return 0;
      case 7: 
        localclp.MqX.add(((g.a.a.a.a)localObject1).UbS.readString());
        AppMethodBeat.o(169925);
        return 0;
      case 8: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new clq();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((clq)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localclp.MqY.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(169925);
        return 0;
      case 9: 
        localclp.jTB = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(169925);
        return 0;
      case 10: 
        localclp.iAz = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(169925);
        return 0;
      case 11: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cln();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cln)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localclp.MqZ.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(169925);
        return 0;
      case 12: 
        localclp.dNP = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(169925);
        return 0;
      case 13: 
        localclp.duration = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(169925);
        return 0;
      }
      localclp.Mra = ((g.a.a.a.a)localObject1).UbS.zi();
      AppMethodBeat.o(169925);
      return 0;
    }
    AppMethodBeat.o(169925);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.clp
 * JD-Core Version:    0.7.0.1
 */