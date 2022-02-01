package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class amz
  extends dyl
{
  public String RSB;
  public String appid;
  public int source;
  public int wvP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104360);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.appid != null) {
        paramVarArgs.f(2, this.appid);
      }
      if (this.RSB != null) {
        paramVarArgs.f(3, this.RSB);
      }
      paramVarArgs.aY(4, this.source);
      paramVarArgs.aY(5, this.wvP);
      AppMethodBeat.o(104360);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label500;
      }
    }
    label500:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.appid != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.appid);
      }
      i = paramInt;
      if (this.RSB != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.RSB);
      }
      paramInt = g.a.a.b.b.a.bM(4, this.source);
      int j = g.a.a.b.b.a.bM(5, this.wvP);
      AppMethodBeat.o(104360);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(104360);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        amz localamz = (amz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104360);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            jg localjg = new jg();
            if ((localObject != null) && (localObject.length > 0)) {
              localjg.parseFrom((byte[])localObject);
            }
            localamz.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(104360);
          return 0;
        case 2: 
          localamz.appid = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(104360);
          return 0;
        case 3: 
          localamz.RSB = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(104360);
          return 0;
        case 4: 
          localamz.source = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(104360);
          return 0;
        }
        localamz.wvP = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(104360);
        return 0;
      }
      AppMethodBeat.o(104360);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.amz
 * JD-Core Version:    0.7.0.1
 */