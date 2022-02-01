package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bah
  extends esc
{
  public int BeA;
  public com.tencent.mm.bx.b ZEQ;
  public int ZLf;
  public LinkedList<FinderObject> object;
  
  public bah()
  {
    AppMethodBeat.i(260040);
    this.object = new LinkedList();
    AppMethodBeat.o(260040);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260048);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(260048);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.object);
      if (this.ZEQ != null) {
        paramVarArgs.d(3, this.ZEQ);
      }
      paramVarArgs.bS(4, this.BeA);
      paramVarArgs.bS(5, this.ZLf);
      AppMethodBeat.o(260048);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label602;
      }
    }
    label602:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.object);
      paramInt = i;
      if (this.ZEQ != null) {
        paramInt = i + i.a.a.b.b.a.c(3, this.ZEQ);
      }
      i = i.a.a.b.b.a.cJ(4, this.BeA);
      int j = i.a.a.b.b.a.cJ(5, this.ZLf);
      AppMethodBeat.o(260048);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.object.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(260048);
          throw paramVarArgs;
        }
        AppMethodBeat.o(260048);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bah localbah = (bah)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(260048);
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
            localbah.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(260048);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new FinderObject();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((FinderObject)localObject2).parseFrom((byte[])localObject1);
            }
            localbah.object.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(260048);
          return 0;
        case 3: 
          localbah.ZEQ = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(260048);
          return 0;
        case 4: 
          localbah.BeA = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(260048);
          return 0;
        }
        localbah.ZLf = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(260048);
        return 0;
      }
      AppMethodBeat.o(260048);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bah
 * JD-Core Version:    0.7.0.1
 */