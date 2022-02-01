package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class csm
  extends esc
{
  public String Krp;
  public LinkedList<String> aayA;
  public int aayB;
  public long aayC;
  public int aayD;
  public String aayE;
  public LinkedList<czi> aayx;
  public String aayy;
  public int aayz;
  public int hAV;
  public String wYI;
  
  public csm()
  {
    AppMethodBeat.i(91512);
    this.hAV = 0;
    this.wYI = "ok";
    this.aayx = new LinkedList();
    this.aayA = new LinkedList();
    AppMethodBeat.o(91512);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91513);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91513);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.hAV);
      if (this.wYI != null) {
        paramVarArgs.g(3, this.wYI);
      }
      paramVarArgs.e(4, 8, this.aayx);
      if (this.aayy != null) {
        paramVarArgs.g(5, this.aayy);
      }
      paramVarArgs.bS(6, this.aayz);
      if (this.Krp != null) {
        paramVarArgs.g(7, this.Krp);
      }
      paramVarArgs.e(8, 1, this.aayA);
      paramVarArgs.bS(9, this.aayB);
      paramVarArgs.bv(10, this.aayC);
      paramVarArgs.bS(11, this.aayD);
      if (this.aayE != null) {
        paramVarArgs.g(12, this.aayE);
      }
      AppMethodBeat.o(91513);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label978;
      }
    }
    label978:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.hAV);
      paramInt = i;
      if (this.wYI != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.wYI);
      }
      i = paramInt + i.a.a.a.c(4, 8, this.aayx);
      paramInt = i;
      if (this.aayy != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.aayy);
      }
      i = paramInt + i.a.a.b.b.a.cJ(6, this.aayz);
      paramInt = i;
      if (this.Krp != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.Krp);
      }
      i = paramInt + i.a.a.a.c(8, 1, this.aayA) + i.a.a.b.b.a.cJ(9, this.aayB) + i.a.a.b.b.a.q(10, this.aayC) + i.a.a.b.b.a.cJ(11, this.aayD);
      paramInt = i;
      if (this.aayE != null) {
        paramInt = i + i.a.a.b.b.a.h(12, this.aayE);
      }
      AppMethodBeat.o(91513);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aayx.clear();
        this.aayA.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91513);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91513);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        csm localcsm = (csm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91513);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kd)localObject2).parseFrom((byte[])localObject1);
            }
            localcsm.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91513);
          return 0;
        case 2: 
          localcsm.hAV = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91513);
          return 0;
        case 3: 
          localcsm.wYI = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91513);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new czi();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((czi)localObject2).parseFrom((byte[])localObject1);
            }
            localcsm.aayx.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91513);
          return 0;
        case 5: 
          localcsm.aayy = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91513);
          return 0;
        case 6: 
          localcsm.aayz = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91513);
          return 0;
        case 7: 
          localcsm.Krp = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91513);
          return 0;
        case 8: 
          localcsm.aayA.add(((i.a.a.a.a)localObject1).ajGk.readString());
          AppMethodBeat.o(91513);
          return 0;
        case 9: 
          localcsm.aayB = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91513);
          return 0;
        case 10: 
          localcsm.aayC = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(91513);
          return 0;
        case 11: 
          localcsm.aayD = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91513);
          return 0;
        }
        localcsm.aayE = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(91513);
        return 0;
      }
      AppMethodBeat.o(91513);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.csm
 * JD-Core Version:    0.7.0.1
 */