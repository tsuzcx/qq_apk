package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dtd
  extends dyy
{
  public dsy TZl;
  public int id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32406);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TZl == null)
      {
        paramVarArgs = new b("Not all required fields were included: rcptinfolist");
        AppMethodBeat.o(32406);
        throw paramVarArgs;
      }
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32406);
        throw paramVarArgs;
      }
      paramVarArgs.aY(1, this.id);
      if (this.TZl != null)
      {
        paramVarArgs.oE(2, this.TZl.computeSize());
        this.TZl.writeFields(paramVarArgs);
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(3, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32406);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.id) + 0;
      paramInt = i;
      if (this.TZl != null) {
        paramInt = i + g.a.a.a.oD(2, this.TZl.computeSize());
      }
      i = paramInt;
      if (this.BaseResponse != null) {
        i = paramInt + g.a.a.a.oD(3, this.BaseResponse.computeSize());
      }
      AppMethodBeat.o(32406);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      if (this.TZl == null)
      {
        paramVarArgs = new b("Not all required fields were included: rcptinfolist");
        AppMethodBeat.o(32406);
        throw paramVarArgs;
      }
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32406);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32406);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      dtd localdtd = (dtd)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32406);
        return -1;
      case 1: 
        localdtd.id = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(32406);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dsy();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dsy)localObject2).parseFrom((byte[])localObject1);
          }
          localdtd.TZl = ((dsy)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(32406);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new jh();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((jh)localObject2).parseFrom((byte[])localObject1);
        }
        localdtd.BaseResponse = ((jh)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(32406);
      return 0;
    }
    AppMethodBeat.o(32406);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dtd
 * JD-Core Version:    0.7.0.1
 */