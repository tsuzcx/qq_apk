package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class clh
  extends esc
{
  public LinkedList<dbl> aats;
  public dbn aatt;
  public LinkedList<Integer> aatu;
  public int status;
  
  public clh()
  {
    AppMethodBeat.i(257915);
    this.aats = new LinkedList();
    this.aatu = new LinkedList();
    AppMethodBeat.o(257915);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257924);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.aats);
      paramVarArgs.bS(3, this.status);
      if (this.aatt != null)
      {
        paramVarArgs.qD(4, this.aatt.computeSize());
        this.aatt.writeFields(paramVarArgs);
      }
      paramVarArgs.e(5, 2, this.aatu);
      AppMethodBeat.o(257924);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label639;
      }
    }
    label639:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.aats) + i.a.a.b.b.a.cJ(3, this.status);
      paramInt = i;
      if (this.aatt != null) {
        paramInt = i + i.a.a.a.qC(4, this.aatt.computeSize());
      }
      i = i.a.a.a.c(5, 2, this.aatu);
      AppMethodBeat.o(257924);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aats.clear();
        this.aatu.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257924);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        clh localclh = (clh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257924);
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
            localclh.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257924);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dbl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dbl)localObject2).parseFrom((byte[])localObject1);
            }
            localclh.aats.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257924);
          return 0;
        case 3: 
          localclh.status = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257924);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dbn();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dbn)localObject2).parseFrom((byte[])localObject1);
            }
            localclh.aatt = ((dbn)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257924);
          return 0;
        }
        localclh.aatu.add(Integer.valueOf(((i.a.a.a.a)localObject1).ajGk.aar()));
        AppMethodBeat.o(257924);
        return 0;
      }
      AppMethodBeat.o(257924);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.clh
 * JD-Core Version:    0.7.0.1
 */