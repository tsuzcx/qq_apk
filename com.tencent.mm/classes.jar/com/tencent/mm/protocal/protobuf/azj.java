package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class azj
  extends esc
{
  public boolean ZJG;
  public String lym;
  public LinkedList<bio> nUC;
  
  public azj()
  {
    AppMethodBeat.i(259132);
    this.nUC = new LinkedList();
    AppMethodBeat.o(259132);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259135);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.nUC);
      if (this.lym != null) {
        paramVarArgs.g(3, this.lym);
      }
      paramVarArgs.di(4, this.ZJG);
      AppMethodBeat.o(259135);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label506;
      }
    }
    label506:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.nUC);
      paramInt = i;
      if (this.lym != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.lym);
      }
      i = i.a.a.b.b.a.ko(4);
      AppMethodBeat.o(259135);
      return paramInt + (i + 1);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.nUC.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259135);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        azj localazj = (azj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259135);
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
            localazj.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259135);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bio();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bio)localObject2).parseFrom((byte[])localObject1);
            }
            localazj.nUC.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259135);
          return 0;
        case 3: 
          localazj.lym = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259135);
          return 0;
        }
        localazj.ZJG = ((i.a.a.a.a)localObject1).ajGk.aai();
        AppMethodBeat.o(259135);
        return 0;
      }
      AppMethodBeat.o(259135);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.azj
 * JD-Core Version:    0.7.0.1
 */