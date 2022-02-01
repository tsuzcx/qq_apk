package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aub
  extends esc
{
  public LinkedList<avi> ZEA;
  public int ZEB;
  public LinkedList<bqy> ZEz;
  
  public aub()
  {
    AppMethodBeat.i(258023);
    this.ZEz = new LinkedList();
    this.ZEA = new LinkedList();
    AppMethodBeat.o(258023);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258026);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.ZEz);
      paramVarArgs.e(3, 8, this.ZEA);
      paramVarArgs.bS(4, this.ZEB);
      AppMethodBeat.o(258026);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label568;
      }
    }
    label568:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.a.c(2, 8, this.ZEz);
      int j = i.a.a.a.c(3, 8, this.ZEA);
      int k = i.a.a.b.b.a.cJ(4, this.ZEB);
      AppMethodBeat.o(258026);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ZEz.clear();
        this.ZEA.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258026);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        aub localaub = (aub)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258026);
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
            localaub.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258026);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bqy();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bqy)localObject2).parseFrom((byte[])localObject1);
            }
            localaub.ZEz.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258026);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new avi();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((avi)localObject2).parseFrom((byte[])localObject1);
            }
            localaub.ZEA.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258026);
          return 0;
        }
        localaub.ZEB = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(258026);
        return 0;
      }
      AppMethodBeat.o(258026);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aub
 * JD-Core Version:    0.7.0.1
 */