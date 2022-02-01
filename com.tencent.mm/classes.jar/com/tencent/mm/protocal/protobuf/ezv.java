package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ezv
  extends dyy
{
  public LinkedList<String> UAa;
  public int vht;
  public String vhu;
  
  public ezv()
  {
    AppMethodBeat.i(82484);
    this.UAa = new LinkedList();
    AppMethodBeat.o(82484);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82485);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(82485);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.vht);
      if (this.vhu != null) {
        paramVarArgs.f(3, this.vhu);
      }
      paramVarArgs.e(4, 1, this.UAa);
      AppMethodBeat.o(82485);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label500;
      }
    }
    label500:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.vht);
      paramInt = i;
      if (this.vhu != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.vhu);
      }
      i = g.a.a.a.c(4, 1, this.UAa);
      AppMethodBeat.o(82485);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.UAa.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(82485);
          throw paramVarArgs;
        }
        AppMethodBeat.o(82485);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        ezv localezv = (ezv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(82485);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            jh localjh = new jh();
            if ((localObject != null) && (localObject.length > 0)) {
              localjh.parseFrom((byte[])localObject);
            }
            localezv.BaseResponse = localjh;
            paramInt += 1;
          }
          AppMethodBeat.o(82485);
          return 0;
        case 2: 
          localezv.vht = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(82485);
          return 0;
        case 3: 
          localezv.vhu = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(82485);
          return 0;
        }
        localezv.UAa.add(((g.a.a.a.a)localObject).abFh.readString());
        AppMethodBeat.o(82485);
        return 0;
      }
      AppMethodBeat.o(82485);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ezv
 * JD-Core Version:    0.7.0.1
 */