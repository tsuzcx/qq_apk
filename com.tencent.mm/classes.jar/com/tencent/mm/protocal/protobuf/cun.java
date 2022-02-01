package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cun
  extends cld
{
  public LinkedList<SnsObject> CEH;
  public String Cxw;
  public int DOR;
  public String Emn;
  public int Emr;
  public int Ems;
  public cvr Emt;
  
  public cun()
  {
    AppMethodBeat.i(125776);
    this.CEH = new LinkedList();
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
      if (this.Emt == null)
      {
        paramVarArgs = new b("Not all required fields were included: ServerConfig");
        AppMethodBeat.o(125777);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Emn != null) {
        paramVarArgs.d(2, this.Emn);
      }
      paramVarArgs.aR(3, this.DOR);
      paramVarArgs.e(4, 8, this.CEH);
      paramVarArgs.aR(5, this.Emr);
      if (this.Cxw != null) {
        paramVarArgs.d(6, this.Cxw);
      }
      paramVarArgs.aR(7, this.Ems);
      if (this.Emt != null)
      {
        paramVarArgs.kX(8, this.Emt.computeSize());
        this.Emt.writeFields(paramVarArgs);
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
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Emn != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Emn);
      }
      i = i + f.a.a.b.b.a.bA(3, this.DOR) + f.a.a.a.c(4, 8, this.CEH) + f.a.a.b.b.a.bA(5, this.Emr);
      paramInt = i;
      if (this.Cxw != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Cxw);
      }
      i = paramInt + f.a.a.b.b.a.bA(7, this.Ems);
      paramInt = i;
      if (this.Emt != null) {
        paramInt = i + f.a.a.a.kW(8, this.Emt.computeSize());
      }
      AppMethodBeat.o(125777);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.CEH.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(125777);
          throw paramVarArgs;
        }
        if (this.Emt == null)
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
        cun localcun = (cun)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125777);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcun.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125777);
          return 0;
        case 2: 
          localcun.Emn = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(125777);
          return 0;
        case 3: 
          localcun.DOR = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125777);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SnsObject();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SnsObject)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcun.CEH.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125777);
          return 0;
        case 5: 
          localcun.Emr = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125777);
          return 0;
        case 6: 
          localcun.Cxw = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(125777);
          return 0;
        case 7: 
          localcun.Ems = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125777);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cvr();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cvr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcun.Emt = ((cvr)localObject1);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cun
 * JD-Core Version:    0.7.0.1
 */