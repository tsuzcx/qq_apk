package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class qd
  extends dyl
{
  public String RYx;
  public int RYy;
  public com.tencent.mm.cd.b RYz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(208127);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RYx == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: main_brand_user_name");
        AppMethodBeat.o(208127);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.RYx != null) {
        paramVarArgs.f(2, this.RYx);
      }
      paramVarArgs.aY(3, this.RYy);
      if (this.RYz != null) {
        paramVarArgs.c(4, this.RYz);
      }
      AppMethodBeat.o(208127);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label500;
      }
    }
    label500:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.RYx != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.RYx);
      }
      i += g.a.a.b.b.a.bM(3, this.RYy);
      paramInt = i;
      if (this.RYz != null) {
        paramInt = i + g.a.a.b.b.a.b(4, this.RYz);
      }
      AppMethodBeat.o(208127);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.RYx == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: main_brand_user_name");
          AppMethodBeat.o(208127);
          throw paramVarArgs;
        }
        AppMethodBeat.o(208127);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        qd localqd = (qd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(208127);
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
            localqd.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(208127);
          return 0;
        case 2: 
          localqd.RYx = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(208127);
          return 0;
        case 3: 
          localqd.RYy = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(208127);
          return 0;
        }
        localqd.RYz = ((g.a.a.a.a)localObject).abFh.iUw();
        AppMethodBeat.o(208127);
        return 0;
      }
      AppMethodBeat.o(208127);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qd
 * JD-Core Version:    0.7.0.1
 */