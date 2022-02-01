package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class frf
  extends com.tencent.mm.bx.a
{
  public LinkedList<frd> YBg;
  public String abQJ;
  public String abQK;
  public dhx abQL;
  public int abQM;
  public fre abQN;
  public fre abQO;
  public int abpG;
  public String desc;
  public String title;
  
  public frf()
  {
    AppMethodBeat.i(72617);
    this.YBg = new LinkedList();
    AppMethodBeat.o(72617);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72618);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.g(1, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.g(2, this.desc);
      }
      if (this.abQJ != null) {
        paramVarArgs.g(3, this.abQJ);
      }
      if (this.abQK != null) {
        paramVarArgs.g(4, this.abQK);
      }
      if (this.abQL != null)
      {
        paramVarArgs.qD(5, this.abQL.computeSize());
        this.abQL.writeFields(paramVarArgs);
      }
      paramVarArgs.e(6, 8, this.YBg);
      paramVarArgs.bS(7, this.abpG);
      paramVarArgs.bS(8, this.abQM);
      if (this.abQN != null)
      {
        paramVarArgs.qD(9, this.abQN.computeSize());
        this.abQN.writeFields(paramVarArgs);
      }
      if (this.abQO != null)
      {
        paramVarArgs.qD(10, this.abQO.computeSize());
        this.abQO.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72618);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label1002;
      }
    }
    label1002:
    for (int i = i.a.a.b.b.a.h(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.desc);
      }
      i = paramInt;
      if (this.abQJ != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.abQJ);
      }
      paramInt = i;
      if (this.abQK != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.abQK);
      }
      i = paramInt;
      if (this.abQL != null) {
        i = paramInt + i.a.a.a.qC(5, this.abQL.computeSize());
      }
      i = i + i.a.a.a.c(6, 8, this.YBg) + i.a.a.b.b.a.cJ(7, this.abpG) + i.a.a.b.b.a.cJ(8, this.abQM);
      paramInt = i;
      if (this.abQN != null) {
        paramInt = i + i.a.a.a.qC(9, this.abQN.computeSize());
      }
      i = paramInt;
      if (this.abQO != null) {
        i = paramInt + i.a.a.a.qC(10, this.abQO.computeSize());
      }
      AppMethodBeat.o(72618);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.YBg.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(72618);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        frf localfrf = (frf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72618);
          return -1;
        case 1: 
          localfrf.title = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72618);
          return 0;
        case 2: 
          localfrf.desc = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72618);
          return 0;
        case 3: 
          localfrf.abQJ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72618);
          return 0;
        case 4: 
          localfrf.abQK = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72618);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dhx();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dhx)localObject2).parseFrom((byte[])localObject1);
            }
            localfrf.abQL = ((dhx)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72618);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new frd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((frd)localObject2).parseFrom((byte[])localObject1);
            }
            localfrf.YBg.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72618);
          return 0;
        case 7: 
          localfrf.abpG = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(72618);
          return 0;
        case 8: 
          localfrf.abQM = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(72618);
          return 0;
        case 9: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fre();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fre)localObject2).parseFrom((byte[])localObject1);
            }
            localfrf.abQN = ((fre)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72618);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fre();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fre)localObject2).parseFrom((byte[])localObject1);
          }
          localfrf.abQO = ((fre)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(72618);
        return 0;
      }
      AppMethodBeat.o(72618);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.frf
 * JD-Core Version:    0.7.0.1
 */