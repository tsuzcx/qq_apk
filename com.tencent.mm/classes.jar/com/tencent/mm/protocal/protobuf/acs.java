package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class acs
  extends erp
{
  public String YFJ;
  public int YPI;
  public String YRs;
  public int Zlk;
  public String Zll;
  public LinkedList<acr> Zlm;
  public ezh Zln;
  public fas Zlo;
  public int scene;
  
  public acs()
  {
    AppMethodBeat.i(124474);
    this.Zlm = new LinkedList();
    AppMethodBeat.o(124474);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124475);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.Zlk);
      if (this.Zll != null) {
        paramVarArgs.g(3, this.Zll);
      }
      if (this.YRs != null) {
        paramVarArgs.g(4, this.YRs);
      }
      if (this.YFJ != null) {
        paramVarArgs.g(5, this.YFJ);
      }
      paramVarArgs.e(6, 8, this.Zlm);
      paramVarArgs.bS(7, this.scene);
      paramVarArgs.bS(8, this.YPI);
      if (this.Zln != null)
      {
        paramVarArgs.qD(9, this.Zln.computeSize());
        this.Zln.writeFields(paramVarArgs);
      }
      if (this.Zlo != null)
      {
        paramVarArgs.qD(10, this.Zlo.computeSize());
        this.Zlo.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(124475);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label986;
      }
    }
    label986:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.Zlk);
      paramInt = i;
      if (this.Zll != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.Zll);
      }
      i = paramInt;
      if (this.YRs != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.YRs);
      }
      paramInt = i;
      if (this.YFJ != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.YFJ);
      }
      i = paramInt + i.a.a.a.c(6, 8, this.Zlm) + i.a.a.b.b.a.cJ(7, this.scene) + i.a.a.b.b.a.cJ(8, this.YPI);
      paramInt = i;
      if (this.Zln != null) {
        paramInt = i + i.a.a.a.qC(9, this.Zln.computeSize());
      }
      i = paramInt;
      if (this.Zlo != null) {
        i = paramInt + i.a.a.a.qC(10, this.Zlo.computeSize());
      }
      AppMethodBeat.o(124475);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Zlm.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(124475);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        acs localacs = (acs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124475);
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
            localacs.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124475);
          return 0;
        case 2: 
          localacs.Zlk = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(124475);
          return 0;
        case 3: 
          localacs.Zll = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(124475);
          return 0;
        case 4: 
          localacs.YRs = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(124475);
          return 0;
        case 5: 
          localacs.YFJ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(124475);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new acr();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((acr)localObject2).parseFrom((byte[])localObject1);
            }
            localacs.Zlm.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124475);
          return 0;
        case 7: 
          localacs.scene = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(124475);
          return 0;
        case 8: 
          localacs.YPI = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(124475);
          return 0;
        case 9: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ezh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ezh)localObject2).parseFrom((byte[])localObject1);
            }
            localacs.Zln = ((ezh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124475);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fas();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fas)localObject2).parseFrom((byte[])localObject1);
          }
          localacs.Zlo = ((fas)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(124475);
        return 0;
      }
      AppMethodBeat.o(124475);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.acs
 * JD-Core Version:    0.7.0.1
 */