package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class jv
  extends com.tencent.mm.bx.a
{
  public gol YJo;
  public gol YJp;
  public String YJu;
  public gol YMf;
  public gdp YMg;
  public gjp YMh;
  public int YMi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133155);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YMf != null)
      {
        paramVarArgs.qD(1, this.YMf.computeSize());
        this.YMf.writeFields(paramVarArgs);
      }
      if (this.YMg != null)
      {
        paramVarArgs.qD(2, this.YMg.computeSize());
        this.YMg.writeFields(paramVarArgs);
      }
      if (this.YMh != null)
      {
        paramVarArgs.qD(3, this.YMh.computeSize());
        this.YMh.writeFields(paramVarArgs);
      }
      if (this.YJo != null)
      {
        paramVarArgs.qD(4, this.YJo.computeSize());
        this.YJo.writeFields(paramVarArgs);
      }
      if (this.YJp != null)
      {
        paramVarArgs.qD(5, this.YJp.computeSize());
        this.YJp.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(6, this.YMi);
      if (this.YJu != null) {
        paramVarArgs.g(7, this.YJu);
      }
      AppMethodBeat.o(133155);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YMf == null) {
        break label920;
      }
    }
    label920:
    for (int i = i.a.a.a.qC(1, this.YMf.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.YMg != null) {
        paramInt = i + i.a.a.a.qC(2, this.YMg.computeSize());
      }
      i = paramInt;
      if (this.YMh != null) {
        i = paramInt + i.a.a.a.qC(3, this.YMh.computeSize());
      }
      paramInt = i;
      if (this.YJo != null) {
        paramInt = i + i.a.a.a.qC(4, this.YJo.computeSize());
      }
      i = paramInt;
      if (this.YJp != null) {
        i = paramInt + i.a.a.a.qC(5, this.YJp.computeSize());
      }
      i += i.a.a.b.b.a.cJ(6, this.YMi);
      paramInt = i;
      if (this.YJu != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.YJu);
      }
      AppMethodBeat.o(133155);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(133155);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        jv localjv = (jv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133155);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gol();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gol)localObject2).dg((byte[])localObject1);
            }
            localjv.YMf = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133155);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gdp();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gdp)localObject2).parseFrom((byte[])localObject1);
            }
            localjv.YMg = ((gdp)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133155);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gjp();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gjp)localObject2).parseFrom((byte[])localObject1);
            }
            localjv.YMh = ((gjp)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133155);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gol();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gol)localObject2).dg((byte[])localObject1);
            }
            localjv.YJo = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133155);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gol();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gol)localObject2).dg((byte[])localObject1);
            }
            localjv.YJp = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133155);
          return 0;
        case 6: 
          localjv.YMi = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(133155);
          return 0;
        }
        localjv.YJu = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(133155);
        return 0;
      }
      AppMethodBeat.o(133155);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.jv
 * JD-Core Version:    0.7.0.1
 */