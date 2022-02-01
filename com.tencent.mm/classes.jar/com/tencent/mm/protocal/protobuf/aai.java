package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aai
  extends erp
{
  public int IJG;
  public String IMg;
  public String IMu;
  public int IcB;
  public int ZiG;
  public LinkedList<etl> ZiH;
  public String ZiI;
  public String ZiJ;
  public String muA;
  
  public aai()
  {
    AppMethodBeat.i(124468);
    this.ZiH = new LinkedList();
    AppMethodBeat.o(124468);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124469);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.IcB);
      if (this.IMg != null) {
        paramVarArgs.g(3, this.IMg);
      }
      if (this.IMu != null) {
        paramVarArgs.g(4, this.IMu);
      }
      if (this.muA != null) {
        paramVarArgs.g(5, this.muA);
      }
      paramVarArgs.bS(6, this.ZiG);
      paramVarArgs.e(7, 8, this.ZiH);
      if (this.ZiI != null) {
        paramVarArgs.g(8, this.ZiI);
      }
      if (this.ZiJ != null) {
        paramVarArgs.g(9, this.ZiJ);
      }
      paramVarArgs.bS(10, this.IJG);
      AppMethodBeat.o(124469);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label846;
      }
    }
    label846:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.IcB);
      paramInt = i;
      if (this.IMg != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.IMg);
      }
      i = paramInt;
      if (this.IMu != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.IMu);
      }
      paramInt = i;
      if (this.muA != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.muA);
      }
      i = paramInt + i.a.a.b.b.a.cJ(6, this.ZiG) + i.a.a.a.c(7, 8, this.ZiH);
      paramInt = i;
      if (this.ZiI != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.ZiI);
      }
      i = paramInt;
      if (this.ZiJ != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.ZiJ);
      }
      paramInt = i.a.a.b.b.a.cJ(10, this.IJG);
      AppMethodBeat.o(124469);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ZiH.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(124469);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        aai localaai = (aai)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124469);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kc)localObject2).parseFrom((byte[])localObject1);
            }
            localaai.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124469);
          return 0;
        case 2: 
          localaai.IcB = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(124469);
          return 0;
        case 3: 
          localaai.IMg = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(124469);
          return 0;
        case 4: 
          localaai.IMu = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(124469);
          return 0;
        case 5: 
          localaai.muA = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(124469);
          return 0;
        case 6: 
          localaai.ZiG = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(124469);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new etl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((etl)localObject2).dh((byte[])localObject1);
            }
            localaai.ZiH.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124469);
          return 0;
        case 8: 
          localaai.ZiI = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(124469);
          return 0;
        case 9: 
          localaai.ZiJ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(124469);
          return 0;
        }
        localaai.IJG = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(124469);
        return 0;
      }
      AppMethodBeat.o(124469);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aai
 * JD-Core Version:    0.7.0.1
 */