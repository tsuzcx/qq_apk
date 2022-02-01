package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class goi
  extends esc
{
  public int aarw;
  public LinkedList<cix> aarx;
  public LinkedList<ciy> aklg;
  public ann aklh;
  
  public goi()
  {
    AppMethodBeat.i(104803);
    this.aklg = new LinkedList();
    this.aarx = new LinkedList();
    AppMethodBeat.o(104803);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104804);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(104804);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.aklg);
      paramVarArgs.bS(3, this.aarw);
      paramVarArgs.e(4, 8, this.aarx);
      if (this.aklh != null)
      {
        paramVarArgs.qD(5, this.aklh.computeSize());
        this.aklh.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(104804);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label742;
      }
    }
    label742:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.aklg) + i.a.a.b.b.a.cJ(3, this.aarw) + i.a.a.a.c(4, 8, this.aarx);
      paramInt = i;
      if (this.aklh != null) {
        paramInt = i + i.a.a.a.qC(5, this.aklh.computeSize());
      }
      AppMethodBeat.o(104804);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aklg.clear();
        this.aarx.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(104804);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104804);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        goi localgoi = (goi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104804);
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
            localgoi.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104804);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ciy();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ciy)localObject2).parseFrom((byte[])localObject1);
            }
            localgoi.aklg.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104804);
          return 0;
        case 3: 
          localgoi.aarw = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(104804);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cix();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cix)localObject2).parseFrom((byte[])localObject1);
            }
            localgoi.aarx.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104804);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ann();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ann)localObject2).parseFrom((byte[])localObject1);
          }
          localgoi.aklh = ((ann)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(104804);
        return 0;
      }
      AppMethodBeat.o(104804);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.goi
 * JD-Core Version:    0.7.0.1
 */