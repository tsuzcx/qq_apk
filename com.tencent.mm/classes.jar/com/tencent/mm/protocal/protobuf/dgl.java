package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dgl
  extends cvp
{
  public String GTv;
  public SnsObject Htv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125807);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(125807);
        throw paramVarArgs;
      }
      if (this.Htv == null)
      {
        paramVarArgs = new b("Not all required fields were included: SnsObject");
        AppMethodBeat.o(125807);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Htv != null)
      {
        paramVarArgs.lC(2, this.Htv.computeSize());
        this.Htv.writeFields(paramVarArgs);
      }
      if (this.GTv != null) {
        paramVarArgs.d(3, this.GTv);
      }
      AppMethodBeat.o(125807);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label622;
      }
    }
    label622:
    for (int i = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Htv != null) {
        paramInt = i + f.a.a.a.lB(2, this.Htv.computeSize());
      }
      i = paramInt;
      if (this.GTv != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GTv);
      }
      AppMethodBeat.o(125807);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(125807);
          throw paramVarArgs;
        }
        if (this.Htv == null)
        {
          paramVarArgs = new b("Not all required fields were included: SnsObject");
          AppMethodBeat.o(125807);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125807);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dgl localdgl = (dgl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125807);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdgl.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125807);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SnsObject();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SnsObject)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdgl.Htv = ((SnsObject)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125807);
          return 0;
        }
        localdgl.GTv = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(125807);
        return 0;
      }
      AppMethodBeat.o(125807);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dgl
 * JD-Core Version:    0.7.0.1
 */