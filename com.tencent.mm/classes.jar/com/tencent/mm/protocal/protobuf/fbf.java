package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fbf
  extends erp
{
  public fhj YBf;
  public String aapy;
  public int abBj;
  public fbz abBk;
  public int iaK;
  public String met;
  public LinkedList<fbh> nUC;
  
  public fbf()
  {
    AppMethodBeat.i(114070);
    this.nUC = new LinkedList();
    AppMethodBeat.o(114070);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114071);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.abBj);
      paramVarArgs.e(3, 8, this.nUC);
      if (this.met != null) {
        paramVarArgs.g(4, this.met);
      }
      if (this.aapy != null) {
        paramVarArgs.g(5, this.aapy);
      }
      if (this.abBk != null)
      {
        paramVarArgs.qD(6, this.abBk.computeSize());
        this.abBk.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(7, this.iaK);
      if (this.YBf != null)
      {
        paramVarArgs.qD(8, this.YBf.computeSize());
        this.YBf.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(114071);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label882;
      }
    }
    label882:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.abBj) + i.a.a.a.c(3, 8, this.nUC);
      paramInt = i;
      if (this.met != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.met);
      }
      i = paramInt;
      if (this.aapy != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.aapy);
      }
      paramInt = i;
      if (this.abBk != null) {
        paramInt = i + i.a.a.a.qC(6, this.abBk.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(7, this.iaK);
      paramInt = i;
      if (this.YBf != null) {
        paramInt = i + i.a.a.a.qC(8, this.YBf.computeSize());
      }
      AppMethodBeat.o(114071);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.nUC.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(114071);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        fbf localfbf = (fbf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114071);
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
            localfbf.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(114071);
          return 0;
        case 2: 
          localfbf.abBj = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(114071);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fbh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fbh)localObject2).parseFrom((byte[])localObject1);
            }
            localfbf.nUC.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(114071);
          return 0;
        case 4: 
          localfbf.met = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(114071);
          return 0;
        case 5: 
          localfbf.aapy = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(114071);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fbz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fbz)localObject2).parseFrom((byte[])localObject1);
            }
            localfbf.abBk = ((fbz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(114071);
          return 0;
        case 7: 
          localfbf.iaK = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(114071);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fhj();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fhj)localObject2).parseFrom((byte[])localObject1);
          }
          localfbf.YBf = ((fhj)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(114071);
        return 0;
      }
      AppMethodBeat.o(114071);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fbf
 * JD-Core Version:    0.7.0.1
 */