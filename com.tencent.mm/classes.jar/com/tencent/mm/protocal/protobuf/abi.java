package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class abi
  extends cvp
{
  public String FHb;
  public cpz FHh;
  public int Gbb;
  public att Gbc;
  public ng Gbd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124480);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(124480);
        throw paramVarArgs;
      }
      if (this.FHh == null)
      {
        paramVarArgs = new b("Not all required fields were included: qy_base_resp");
        AppMethodBeat.o(124480);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.FHh != null)
      {
        paramVarArgs.lC(2, this.FHh.computeSize());
        this.FHh.writeFields(paramVarArgs);
      }
      if (this.FHb != null) {
        paramVarArgs.d(3, this.FHb);
      }
      paramVarArgs.aS(4, this.Gbb);
      if (this.Gbc != null)
      {
        paramVarArgs.lC(5, this.Gbc.computeSize());
        this.Gbc.writeFields(paramVarArgs);
      }
      if (this.Gbd != null)
      {
        paramVarArgs.lC(6, this.Gbd.computeSize());
        this.Gbd.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(124480);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label974;
      }
    }
    label974:
    for (int i = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FHh != null) {
        paramInt = i + f.a.a.a.lB(2, this.FHh.computeSize());
      }
      i = paramInt;
      if (this.FHb != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FHb);
      }
      i += f.a.a.b.b.a.bz(4, this.Gbb);
      paramInt = i;
      if (this.Gbc != null) {
        paramInt = i + f.a.a.a.lB(5, this.Gbc.computeSize());
      }
      i = paramInt;
      if (this.Gbd != null) {
        i = paramInt + f.a.a.a.lB(6, this.Gbd.computeSize());
      }
      AppMethodBeat.o(124480);
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
          AppMethodBeat.o(124480);
          throw paramVarArgs;
        }
        if (this.FHh == null)
        {
          paramVarArgs = new b("Not all required fields were included: qy_base_resp");
          AppMethodBeat.o(124480);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124480);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        abi localabi = (abi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124480);
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
            localabi.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124480);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cpz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cpz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localabi.FHh = ((cpz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124480);
          return 0;
        case 3: 
          localabi.FHb = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(124480);
          return 0;
        case 4: 
          localabi.Gbb = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(124480);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new att();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((att)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localabi.Gbc = ((att)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124480);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ng();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ng)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localabi.Gbd = ((ng)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(124480);
        return 0;
      }
      AppMethodBeat.o(124480);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.abi
 * JD-Core Version:    0.7.0.1
 */