package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dfm
  extends cvp
{
  public LinkedList<SnsObject> FCD;
  public String Fvh;
  public int GUQ;
  public String HtU;
  public int HtY;
  public int HtZ;
  public dgq Hua;
  
  public dfm()
  {
    AppMethodBeat.i(125776);
    this.FCD = new LinkedList();
    AppMethodBeat.o(125776);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125777);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(125777);
        throw paramVarArgs;
      }
      if (this.Hua == null)
      {
        paramVarArgs = new b("Not all required fields were included: ServerConfig");
        AppMethodBeat.o(125777);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.HtU != null) {
        paramVarArgs.d(2, this.HtU);
      }
      paramVarArgs.aS(3, this.GUQ);
      paramVarArgs.e(4, 8, this.FCD);
      paramVarArgs.aS(5, this.HtY);
      if (this.Fvh != null) {
        paramVarArgs.d(6, this.Fvh);
      }
      paramVarArgs.aS(7, this.HtZ);
      if (this.Hua != null)
      {
        paramVarArgs.lC(8, this.Hua.computeSize());
        this.Hua.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125777);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label954;
      }
    }
    label954:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.HtU != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.HtU);
      }
      i = i + f.a.a.b.b.a.bz(3, this.GUQ) + f.a.a.a.c(4, 8, this.FCD) + f.a.a.b.b.a.bz(5, this.HtY);
      paramInt = i;
      if (this.Fvh != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Fvh);
      }
      i = paramInt + f.a.a.b.b.a.bz(7, this.HtZ);
      paramInt = i;
      if (this.Hua != null) {
        paramInt = i + f.a.a.a.lB(8, this.Hua.computeSize());
      }
      AppMethodBeat.o(125777);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FCD.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(125777);
          throw paramVarArgs;
        }
        if (this.Hua == null)
        {
          paramVarArgs = new b("Not all required fields were included: ServerConfig");
          AppMethodBeat.o(125777);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125777);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dfm localdfm = (dfm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125777);
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
            localdfm.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125777);
          return 0;
        case 2: 
          localdfm.HtU = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125777);
          return 0;
        case 3: 
          localdfm.GUQ = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125777);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SnsObject();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SnsObject)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdfm.FCD.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125777);
          return 0;
        case 5: 
          localdfm.HtY = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125777);
          return 0;
        case 6: 
          localdfm.Fvh = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125777);
          return 0;
        case 7: 
          localdfm.HtZ = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125777);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dgq();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dgq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdfm.Hua = ((dgq)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125777);
        return 0;
      }
      AppMethodBeat.o(125777);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dfm
 * JD-Core Version:    0.7.0.1
 */